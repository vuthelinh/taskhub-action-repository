package com.synergix.operations.project;

import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.operations.project.steps.ProjectEstimationSteps;
import com.synergix.processing.project.billing.steps.BillingAndRetentionStep;
import com.synergix.report.steps.CommonReportSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by Ian on 8/22/2016.
 */
public class BillingByProjectDefs {
	@Steps
	MenuNavigationSteps menuNavigation;

	@Steps
	ProjectEstimationSteps projectEstimation;

	@Given("^There is a bill-by-project project has retention and downpayment$")
	public void there_is_a_bill_by_project_project_has_retention_and_downpayment() throws Throwable {
		menuNavigation.user_navigates_to_screen("Operations>Project>Project Order");

		projectEstimation.click_add_new_button_on_functional_panel();

		projectEstimation.enter_project_name("Bill-by-project project for testing");
		projectEstimation.enter_customer("ANTEO1");
		projectEstimation.pick_project_duration_and_dlp_from("15/08/2016");
		projectEstimation.pick_project_duration_and_dlp_to("31/08/2016");

		projectEstimation.enter_project_class("PJCLASS1");
		projectEstimation.enter_project_category("STPJCAT");
		projectEstimation.enter_sbu("KD1");

		projectEstimation.enter_currency("USD");
		projectEstimation.enter_exchange_rate("1.3");
		projectEstimation.enter_sales_tax("GST7");

		projectEstimation.add_a_phase("1");
		projectEstimation.enter_qty("1", "1");
		projectEstimation.enter_unit_price("1", "2500.55");

		projectEstimation.enter_downpayment_percent("15");
		projectEstimation.enter_progressive_retention("13");

		projectEstimation.select_in_billing_type("Bill By Project");

		projectEstimation.save_project_order_voucher();
		projectEstimation.submit_the_project_order();
	}

	@Steps
	BillingAndRetentionStep billingAndRetention;

	@When("^I create bill for the downpayent$")
	public void i_create_bill_for_the_downpayent(List<List<String>> dataTable) throws Throwable {
		menuNavigation.clickOnHomeIcon();
		menuNavigation.user_navigates_to_screen("Operations>Project>Billing by Project/Phase & Retention Billing");
		billingAndRetention.switch_to_iframe();

		String projectOrderVoucher = SessionData.getListStringLastValue("Project Order Voucher");

		billingAndRetention.go_to_tab("Invoice");
		billingAndRetention.search_invoice_on_invoice_tab(projectOrderVoucher);

		String dataTableKey = "DownpaymentInvoice";
		SessionData.addDataTable(dataTableKey, dataTable, false);

		String colBillKey = "BILL KEY";
		String colInvoiceDate = "Invoice Date";
		String colSalesTax = "Sales Tax";
		String colExchRate = "Exch Rate";
		String colAmountToBill = "Amount To Bill";

		for (int rowDownpaymentInvoice : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String _billKey = SessionData.getDataTbVal(dataTableKey, rowDownpaymentInvoice, colBillKey);
			String invoiceDate = SessionData.getDataTbVal(dataTableKey, rowDownpaymentInvoice, colInvoiceDate);
			String salesTax = SessionData.getDataTbVal(dataTableKey, rowDownpaymentInvoice, colSalesTax);
			String exchRate = SessionData.getDataTbVal(dataTableKey, rowDownpaymentInvoice, colExchRate);
			String amountToBill = SessionData.getDataTbVal(dataTableKey, rowDownpaymentInvoice, colAmountToBill);

			if (!invoiceDate.isEmpty()) {
				billingAndRetention.enter_invoice_date(invoiceDate);
			}

			if (!salesTax.isEmpty()) {
				billingAndRetention.enter_sales_tax(salesTax);
			}

			if (!exchRate.isEmpty()) {
				billingAndRetention.enter_exch_rate(exchRate);
			}

			if (!amountToBill.isEmpty()) {
				billingAndRetention.enter_amount_to_bill_amount(amountToBill);
			}
		}
	}

	@When("^I submit the invoice$")
	public void i_submit_the_invoice() throws Throwable {
		billingAndRetention.save_invoice_no();
		billingAndRetention.submit_voucher();

		menuNavigation.switchToParentFrame();
	}

	@Steps
	CommonReportSteps sourceJournal;

	@Then("^Source Journal Report should include$")
	public void source_Journal_Report_should_include(List<List<String>> dataTable) throws Throwable {
				String dataTableKey = "GlEntries";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colVoucherKey = "Voucher Key";
		String colKind = "Kind";
		String colAccount = "Account";
		String colNature = "Nature";
		String colHome = "Home";

		for (int rowGlEntries : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String voucherKey = SessionData.getDataTbVal(dataTableKey, rowGlEntries, colVoucherKey);
			String kind = SessionData.getDataTbVal(dataTableKey, rowGlEntries, colKind);
			String account = SessionData.getDataTbVal(dataTableKey, rowGlEntries, colAccount);
			String nature = SessionData.getDataTbVal(dataTableKey, rowGlEntries, colNature);
			String home = SessionData.getDataTbVal(dataTableKey, rowGlEntries, colHome);

			if (!voucherKey.isEmpty()) {
				menuNavigation.switchToParentFrame();
				menuNavigation.clickOnHomeIcon();
				menuNavigation.user_navigates_to_screen("Operations>General Ledger>Source Journal");
				menuNavigation.switchToTH5iframe();

				sourceJournal.select_format_report_export("Html");
				sourceJournal.set_report_parameter("Module Code", 1, "Input", "PJ", "");

				int filterRowIndex = sourceJournal.get_row_index_by_column_name_report_filters("Source Voucher No.");
				sourceJournal.select_filter_type_report_filter(filterRowIndex, "Equal");

				String voucherNo = SessionData.getListStringByIndex("Invoice", Integer.parseInt(voucherKey));
				sourceJournal.enter_filterdata_value1(filterRowIndex, voucherNo);
				sourceJournal.click_btn_generate_html_report();
			}
			if(account == "Total") {
				if (!nature.isEmpty()) {
					sourceJournal.verify_gl_entry_total_nature(kind, nature);
				}
				if (!home.isEmpty()) {
					sourceJournal.verify_gl_entry_total_home(kind, home);
				}
			} else {
				if (!nature.isEmpty()) {
					sourceJournal.verify_gl_entry_nature(account, kind, nature);
				}
				if (!home.isEmpty()) {
					sourceJournal.verify_gl_entry_home(account, kind, home);
				}
			}
		}
	}

	@When("^I create bill for the Project Order$")
	public void i_create_bill_for_the_Project_Order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I bill the project order$")
	public void i_bill_the_project_order(List<List<String>> dataTable) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

	@Then("^Billing should be as following$")
	public void billing_should_be_as_following(List<List<String>> dataTable) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}

	@When("^I submit the bill$")
	public void i_submit_the_bill() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
