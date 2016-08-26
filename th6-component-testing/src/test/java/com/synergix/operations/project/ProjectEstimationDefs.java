package com.synergix.operations.project;

import com.synergix.definition.common.CommonDefs;
import com.synergix.operations.project.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;
import com.synergix.common.steps.LoginSteps;
import com.synergix.common.steps.MenuNavigationSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.LinkedHashMap;
import java.util.List;

public class ProjectEstimationDefs {

	private static final String QTY_PLACE = "Qty";

	private static final String DEFAULT_SALES_TAX = "STV01";

	private static final String DEFAULT_CUSTOMER_NAME = "Steve Job";

	@Steps
	CommonDefs commonDefs;

	@Steps
	LoginSteps loginSteps;

	@Steps
	ProjectEstimationSteps projectEstimationSteps;

	@Given("^I am in project estimation page$")
	public void i_am_in_project_estimation_page() {
		projectEstimationSteps.click_add_new_button_on_functional_panel();
	}

	@When("^a phase of the project has details with known unit price and discount percent as the following with \"([^\"]*)\":$")
	public void a_phase_of_the_project_has_details_with_known_unit_price_and_discount_percent_as_the_following_with(
			String dataKey, List<List<String>> detailsOfAPhase) {
		SessionData.addDataTable("detailsOfAPhase", detailsOfAPhase, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("detailsOfAPhase", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("detailsOfAPhase", row, "KEY");
			String sQty = SessionData.getDataTbVal("detailsOfAPhase", row, QTY_PLACE);
			String sUnitPrice = SessionData.getDataTbVal("detailsOfAPhase", row, "Unit Price");
			String sDiscPercent = SessionData.getDataTbVal("detailsOfAPhase", row, "Disc %");
			String sBudgetCost = SessionData.getDataTbVal("detailsOfAPhase", row, "Budget Cost");
			if (!sKey.isEmpty()) {
				projectEstimationSteps.click_btn_add_main_phase();
			}
			if (!sQty.isEmpty()) {
				projectEstimationSteps.enter_qty("1", sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				projectEstimationSteps.enter_unit_price("1", sUnitPrice);
			}
			if (!sDiscPercent.isEmpty()) {
				projectEstimationSteps.enter_disc_percent("1", sDiscPercent);
			}
			if (!sBudgetCost.isEmpty()) {
				projectEstimationSteps.enter_budget_cost("1", sBudgetCost);
			}
		}
	}

	@Then("^I should see phase details including discount amount and profit margin as the following with \"([^\"]*)\":$")
	public void i_should_see_phase_details_including_discount_amount_and_profit_margin_as_the_following_with(
			String dataKey, List<List<String>> detailsOfAPhase) {
		SessionData.addDataTable("resultDetailsOfAPhase", detailsOfAPhase, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("resultDetailsOfAPhase", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sDiscAmt = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Disc Amt");
			String sPhaseValue = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Phase Value");
			String sBudgetProfit = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Budget Profit");
			String sMarginPercent = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Margin %");

			if (!sDiscAmt.isEmpty()) {
				projectEstimationSteps.verify_disc_amt("1", sDiscAmt);
			}
			if (!sPhaseValue.isEmpty()) {
				projectEstimationSteps.verify_phase_value("1", sPhaseValue);
			}
			if (!sBudgetProfit.isEmpty()) {
				projectEstimationSteps.verify_budget_profit("1", sBudgetProfit);
			}
			if (!sMarginPercent.isEmpty()) {
				projectEstimationSteps.verify_margin_percent("1", sMarginPercent);
			}
		}
	}

	@When("^a phase of the project has details with known unit price and discount amount as the following with \"([^\"]*)\":$")
	public void a_phase_of_the_project_has_details_with_known_unit_price_and_discount_amount_as_the_following_with(
			String dataKey, List<List<String>> detailsOfAPhase) {
		SessionData.addDataTable("detailsOfAPhase", detailsOfAPhase, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("detailsOfAPhase", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("detailsOfAPhase", row, "KEY");
			String sQty = SessionData.getDataTbVal("detailsOfAPhase", row, QTY_PLACE);
			String sUnitPrice = SessionData.getDataTbVal("detailsOfAPhase", row, "Unit Price");
			String sDiscAmt = SessionData.getDataTbVal("detailsOfAPhase", row, "Disc Amt");
			String sBudgetCost = SessionData.getDataTbVal("detailsOfAPhase", row, "Budget Cost");
			if (!sKey.isEmpty()) {
				projectEstimationSteps.click_btn_add_main_phase();
			}
			if (!sQty.isEmpty()) {
				projectEstimationSteps.enter_qty("1", sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				projectEstimationSteps.enter_unit_price("1", sUnitPrice);
			}
			if (!sDiscAmt.isEmpty()) {
				projectEstimationSteps.enter_disc_amt("1", sDiscAmt);
			}
			if (!sBudgetCost.isEmpty()) {
				projectEstimationSteps.enter_budget_cost("1", sBudgetCost);
			}
		}
	}

	@Then("^I should see phase details including discount percent and profit margin as the following with \"([^\"]*)\":$")
	public void i_should_see_phase_details_including_discount_percent_and_profit_margin_as_the_following_with(
			String dataKey, List<List<String>> detailsOfAPhase) {
		SessionData.addDataTable("resultDetailsOfAPhase", detailsOfAPhase, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("resultDetailsOfAPhase", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sDiscPercent = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Disc %");
			String sPhaseValue = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Phase Value");
			String sBudgetProfit = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Budget Profit");
			String sMarginPercent = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Margin %");

			if (!sDiscPercent.isEmpty()) {
				projectEstimationSteps.verify_disc_percent("1", sDiscPercent);
			}
			if (!sPhaseValue.isEmpty()) {
				projectEstimationSteps.verify_phase_value("1", sPhaseValue);
			}
			if (!sBudgetProfit.isEmpty()) {
				projectEstimationSteps.verify_budget_profit("1", sBudgetProfit);
			}
			if (!sMarginPercent.isEmpty()) {
				projectEstimationSteps.verify_margin_percent("1", sMarginPercent);
			}
		}
	}

	@When("^I enter the details of phases as \"([^\"]*)\"$")
	public void i_enter_the_details_of_phases_as(String dataKey, List<List<String>> detailsOfAPhase) {
		SessionData.addDataTable("detailsOfAPhase", detailsOfAPhase, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("detailsOfAPhase", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("detailsOfAPhase", row, "Phase No.");
			if (!sPhaseNo.isEmpty()) {
				projectEstimationSteps.add_a_phase(sPhaseNo);
			}
		}
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("detailsOfAPhase", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("detailsOfAPhase", row, QTY_PLACE);
			String sUnitPrice = SessionData.getDataTbVal("detailsOfAPhase", row, "Unit Price");
			String sDiscPercent = SessionData.getDataTbVal("detailsOfAPhase", row, "Disc %");
			String sDiscAmt = SessionData.getDataTbVal("detailsOfAPhase", row, "Disc Amt");
			String sBudgetCost = SessionData.getDataTbVal("detailsOfAPhase", row, "Budget Cost");

			if (!sQty.isEmpty()) {
				projectEstimationSteps.enter_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				projectEstimationSteps.enter_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sDiscPercent.isEmpty()) {
				projectEstimationSteps.enter_disc_percent(sPhaseNo, sDiscPercent);
			}
			if (!sDiscAmt.isEmpty()){
				projectEstimationSteps.enter_disc_amt(sPhaseNo, sDiscAmt);
			}
			if (!sBudgetCost.isEmpty()) {
				projectEstimationSteps.enter_budget_cost(sPhaseNo, sBudgetCost);
			}
		}

	}

	@Then("^I should see values of parent phases as with \"([^\"]*)\":$")
	public void i_should_see_values_of_parent_phases_as_with(String dataKey, List<List<String>> detailsOfAPhase) {
		SessionData.addDataTable("resultDetailsOfAPhase", detailsOfAPhase, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("resultDetailsOfAPhase", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Phase No.");
			String sPhaseValue = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Phase Value");
			String sBudgetCost = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Budget Cost");
			String sBudgetProfit = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Budget Profit");
			String sMarginPercent = SessionData.getDataTbVal("resultDetailsOfAPhase", row, "Margin %");

			if (!sPhaseValue.isEmpty()) {
				projectEstimationSteps.verify_phase_value(sPhaseNo, sPhaseValue);
			}
			if (!sBudgetCost.isEmpty()) {
				projectEstimationSteps.verify_budget_cost(sPhaseNo, sBudgetCost);
			}
			if (!sBudgetProfit.isEmpty()) {
				projectEstimationSteps.verify_budget_profit(sPhaseNo, sBudgetProfit);
			}
			if (!sMarginPercent.isEmpty()) {
				projectEstimationSteps.verify_margin_percent(sPhaseNo, sMarginPercent);
			}
		}
	}

	@Given("^the project estimation has the awarded date as below with \"([^\"]*)\"$")
	public void the_project_estimation_has_the_awarded_date_as_below_with(String dataKey,
			List<List<String>> dataTable) {
		SessionData.addDataTable("awardedDateTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("awardedDateTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("awardedDateTable", row, "KEY");
			String sAwardedDate = SessionData.getDataTbVal("awardedDateTable", row, "Awarded Date");
			if (!sKey.isEmpty()) {
			}
			if (!sAwardedDate.isEmpty()) {
				projectEstimationSteps.enter_awarded_date(sAwardedDate);
			}
		}
	}

	@Given("^I have a customer using currency with \"([^\"]*)\"$")
	public void i_have_a_customer_using_currency_with(String dataKey, List<List<String>> dataTable) {
		projectEstimationSteps.enter_customer(DEFAULT_CUSTOMER_NAME);
		SessionData.addDataTable("currencyTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("currencyTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sCurrency = SessionData.getDataTbVal("currencyTable", row, "Currency");
			if (!sCurrency.isEmpty()) {
				projectEstimationSteps.enter_currency(sCurrency);
			}
		}
	}

	@Given("^the sales tax for this customer is with \"([^\"]*)\"$")
	public void the_sales_tax_for_this_customer_is_with(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("salesTaxTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("salesTaxTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSalesTax = SessionData.getDataTbVal("salesTaxTable", row, "Sales Tax");
			if (!sSalesTax.isEmpty()) {
				projectEstimationSteps.enter_sales_tax(DEFAULT_SALES_TAX);
			}
		}
	}

	@When("^parent phases have the values as \"([^\"]*)\"$")
	public void parent_phases_have_the_values_as(String dataKey, List<List<String>> dataTable) {
		String[] qty = { "3.00", "3.00" };
		String[] unitPrice = { "455.26", "316.74" };
		int count = 0;
		SessionData.addDataTable("phaseDetailsTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseDetailsTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("phaseDetailsTable", row, "Phase No.");
			String sBudgetCost = SessionData.getDataTbVal("phaseDetailsTable", row, "Budget Cost");

			if (!sPhaseNo.isEmpty()) {
				projectEstimationSteps.add_a_phase(sPhaseNo);
				projectEstimationSteps.enter_qty(sPhaseNo, qty[count]);
				projectEstimationSteps.enter_unit_price(sPhaseNo, unitPrice[count]);

				if (!sBudgetCost.isEmpty()) {
					projectEstimationSteps.enter_budget_cost(sPhaseNo, sBudgetCost);
				}
			}
			count++;
		}
	}

	@Then("^I should see total values as \"([^\"]*)\"$")
	public void i_should_see_total_values_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("summaryTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("summaryTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSummaryValues = SessionData.getDataTbVal("summaryTable", row, "Summary Values");
			String sNature = SessionData.getDataTbVal("summaryTable", row, "Nature");
			String sHome = SessionData.getDataTbVal("summaryTable", row, "Home");

			if (!sSummaryValues.isEmpty()) {
				if (sSummaryValues.equals("Project Sum")) {
					projectEstimationSteps.verify_nature_project_sum(sNature);
					projectEstimationSteps.verify_home_project_sum(sHome);
				}
				if (sSummaryValues.equals("Project Budget Cost")) {
					projectEstimationSteps.verify_nature_project_budget_cost(sNature);
					projectEstimationSteps.verify_home_project_budget_cost(sHome);
				}
				if (sSummaryValues.equals("Project Budget Profit Amount")) {
					projectEstimationSteps.verify_nature_project_budget_profit(sNature);
					projectEstimationSteps.verify_home_project_budget_profit(sHome);
				}
				if (sSummaryValues.equals("Project Budget Profit Percent")) {
					projectEstimationSteps.verify_project_budget_percent(sNature);
					projectEstimationSteps.verify_project_budget_percent(sHome);
				}
				if (sSummaryValues.equals("Sales Tax")) {
					projectEstimationSteps.verify_nature_sales_tax(sNature);
					projectEstimationSteps.verify_home_sales_tax(sHome);
				}
				if (sSummaryValues.equals("Project Value incl. Tax")) {
					projectEstimationSteps.verify_nature_project_value_incl_tax(sNature);
					projectEstimationSteps.verify_home_project_value_incl_tax(sHome);
				}
			}

		}
	}

	@Given("^I create a project estimation with information as \"([^\"]*)\"$")
	public void i_create_a_project_estimation_with_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("beforeHeaderTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("beforeHeaderTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sProjectName = SessionData.getDataTbVal("beforeHeaderTable", row, "Project name");
			String sCustomer = SessionData.getDataTbVal("beforeHeaderTable", row, "Customer");
			String sProjectDurationDlpFrom = SessionData.getDataTbVal("beforeHeaderTable", row,
					"Project Duration & DLP From");
			String sProjectDurationDlpTo = SessionData.getDataTbVal("beforeHeaderTable", row,
					"Project Duration & DLP To");
			String sWithDlp = SessionData.getDataTbVal("beforeHeaderTable", row, "With DLP");

			if (!sProjectName.isEmpty()) {
				projectEstimationSteps.enter_project_name(sProjectName);
			}
			if (!sCustomer.isEmpty()) {
				projectEstimationSteps.enter_customer(sCustomer);
			}
			if (!sProjectDurationDlpFrom.isEmpty()) {
				projectEstimationSteps.pick_project_duration_and_dlp_from(sProjectDurationDlpFrom);
			}
			if (!sProjectDurationDlpTo.isEmpty()) {
				projectEstimationSteps.pick_project_duration_and_dlp_to(sProjectDurationDlpTo);
			}
			if (!sWithDlp.isEmpty()) {
				projectEstimationSteps.enter_dlp(sWithDlp);
			}
		}
	}

	@Given("^I enter the header tab as \"([^\"]*)\"$")
	public void i_enter_the_header_tab_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("headerTabTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("headerTabTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sCustomerJobNo = SessionData.getDataTbVal("headerTabTable", row, "Customer Job No.");
			String sAwardedDate = SessionData.getDataTbVal("headerTabTable", row, "Awarded Date");
			String sReferenceNo = SessionData.getDataTbVal("headerTabTable", row, "Reference No.");
			String sContactPerson = SessionData.getDataTbVal("headerTabTable", row, "Contact Person");
			String sContactAddress = SessionData.getDataTbVal("headerTabTable", row, "Contact Address");
			String sProjectClass = SessionData.getDataTbVal("headerTabTable", row, "Project Class");
			String sProjectCategory = SessionData.getDataTbVal("headerTabTable", row, "Project Category");
			String sSbu = SessionData.getDataTbVal("headerTabTable", row, "SBU");
			String sDownpaymentAmount = SessionData.getDataTbVal("headerTabTable", row, "Downpayment Amount");
			String sDownpaymentPercent = SessionData.getDataTbVal("headerTabTable", row, "Downpayment Percent");
			String sProgressiveRetention = SessionData.getDataTbVal("headerTabTable", row, "Progressive Retention");
			String sMaxRetentionAmount = SessionData.getDataTbVal("headerTabTable", row, "Max Retention Amount");
			String sMaxRetentionPercent = SessionData.getDataTbVal("headerTabTable", row, "Max Retention Percent");
			String sRetentionDueDateDays = SessionData.getDataTbVal("headerTabTable", row, "Retention Due Date Days");
			String sDueOn = SessionData.getDataTbVal("headerTabTable", row, "Retention Due Date Due on");
			String sInventoryLoadingLocation = SessionData.getDataTbVal("headerTabTable", row,
					"Inventory Loading Location");
			String sTolerableVariance = SessionData.getDataTbVal("headerTabTable", row, "Tolerable Variance %");
			if (!sCustomerJobNo.isEmpty()) {
				projectEstimationSteps.enter_customer_job_no(sCustomerJobNo);
			}
			if (!sAwardedDate.isEmpty()) {
				projectEstimationSteps.enter_awarded_date(sAwardedDate);
			}
			if (!sReferenceNo.isEmpty()) {
				projectEstimationSteps.enter_reference_no(sReferenceNo);
			}
			if (!sContactPerson.isEmpty()) {
				projectEstimationSteps.enter_contact_person(sContactPerson);
			}
			if (!sContactAddress.isEmpty()) {
				projectEstimationSteps.enter_contact_address(sContactAddress);
			}
			if (!sProjectClass.isEmpty()) {
				projectEstimationSteps.enter_project_class(sProjectClass);
			}
			if (!sProjectCategory.isEmpty()) {
				projectEstimationSteps.enter_project_category(sProjectCategory);
			}
			if (!sSbu.isEmpty()) {
				projectEstimationSteps.enter_sbu(sSbu);
			}
			if (!sDownpaymentAmount.isEmpty()) {
				projectEstimationSteps.enter_downpayment_amt(sDownpaymentAmount);
			}
			if (!sDownpaymentPercent.isEmpty()) {
				projectEstimationSteps.enter_downpayment_percent(sDownpaymentPercent);
			}
			if (!sProgressiveRetention.isEmpty()) {
				projectEstimationSteps.enter_progressive_retention(sProgressiveRetention);
			}
			if (!sMaxRetentionAmount.isEmpty()) {
				projectEstimationSteps.enter_max_retention_amt(sMaxRetentionAmount);
			}
			if (!sMaxRetentionPercent.isEmpty()) {
				projectEstimationSteps.enter_max_retention_percent(sMaxRetentionPercent);
			}
			if (!sRetentionDueDateDays.isEmpty()) {
				projectEstimationSteps.enter_retention_due_date_days(sRetentionDueDateDays);
			}
			if (!sDueOn.isEmpty()) {
				projectEstimationSteps.enter_retention_due_date_due_on(sDueOn);
			}
			if (!sInventoryLoadingLocation.isEmpty()) {
				projectEstimationSteps.enter_inventory_loading_location(sInventoryLoadingLocation);
			}
			if (!sTolerableVariance.isEmpty()) {
				projectEstimationSteps.enter_tolerable_variance(sTolerableVariance);
			}
		}
	}

	@Given("^I enter employees as \"([^\"]*)\"$")
	public void i_enter_employees_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("employeeTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("employeeTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sEmployeeCode = SessionData.getDataTbVal("employeeTable", row, "Employee Code");
			String sRoleInProject = SessionData.getDataTbVal("employeeTable", row, "Role In Project");
			String sMainRole = SessionData.getDataTbVal("employeeTable", row, "Main Role");
			projectEstimationSteps.click_btn_add_employees();
			if (!sEmployeeCode.isEmpty()) {
				projectEstimationSteps.enter_employee(sEmployeeCode);
			}
			if (!sRoleInProject.isEmpty()) {
				projectEstimationSteps.check_role_in_project_with_employee_name(sEmployeeCode, sRoleInProject);
			}
			if (!sMainRole.isEmpty()) {
				projectEstimationSteps.make_key_person(sEmployeeCode, sMainRole);
				;
			}
		}
	}

	@Given("^I enter payment information as \"([^\"]*)\"$")
	public void I_enter_payment_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("paymentTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("paymentTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sBillingType = SessionData.getDataTbVal("paymentTable", row, "Billing Type");
			String sCutOffDate = SessionData.getDataTbVal("paymentTable", row, "Cut-off Date");
			String sBillingParty = SessionData.getDataTbVal("paymentTable", row, "Billing Party");
			String sBillingContact = SessionData.getDataTbVal("paymentTable", row, "Billing Contact");
			String sBillingAddress = SessionData.getDataTbVal("paymentTable", row, "Billing Address");
			String sPaymentOption = SessionData.getDataTbVal("paymentTable", row, "Payment Option");
			String sPaymentTerm = SessionData.getDataTbVal("paymentTable", row, "Payment Term");
			String sPaymentMethod = SessionData.getDataTbVal("paymentTable", row, "Payment Method");
			String sPaymentTenor = SessionData.getDataTbVal("paymentTable", row, "Payment Tenor");
			String sTenorTerm = SessionData.getDataTbVal("paymentTable", row, "Tenor Term");

			if (!sBillingType.isEmpty()) {
				projectEstimationSteps.select_in_billing_type(sBillingType);
			}
			if (!sCutOffDate.isEmpty()) {
				projectEstimationSteps.enter_cutoff_date(sCutOffDate);
			}
			if (!sBillingParty.isEmpty()) {
				projectEstimationSteps.enter_billing_party(sBillingParty);
			}
			if (!sBillingContact.isEmpty()) {
				projectEstimationSteps.enter_billing_contact(sBillingContact);
			}
			if (!sBillingAddress.isEmpty()) {
				projectEstimationSteps.enter_billing_address(sBillingAddress);
			}
			if (!sPaymentOption.isEmpty()) {
				projectEstimationSteps.select_in_payment_option(sPaymentOption);
			}
			if (!sPaymentTerm.isEmpty()) {
				projectEstimationSteps.select_in_payment_term(sPaymentTerm);
			}
			if (!sPaymentMethod.isEmpty()) {
				projectEstimationSteps.select_in_payment_method(sPaymentMethod);
			}
			if (!sPaymentTenor.isEmpty()) {
				projectEstimationSteps.enter_payment_tenor(sPaymentTenor);
			}
			if (!sTenorTerm.isEmpty()) {
				projectEstimationSteps.enter_tenor_term(sTenorTerm);
			}
		}
	}

	@Given("^I enter bonds information as \"([^\"]*)\"$")
	public void i_enter_bonds_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("bondsTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("bondsTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sBondRefNo = SessionData.getDataTbVal("bondsTable", row, "Bond Ref. No.");
			String sStartDate = SessionData.getDataTbVal("bondsTable", row, "Start Date");
			String sEndDate = SessionData.getDataTbVal("bondsTable", row, "End Date");
			String sIssuingParty = SessionData.getDataTbVal("bondsTable", row, "Issuing Party");
			String sDlp = SessionData.getDataTbVal("bondsTable", row, "DLP");
			String sActualExpiryDate = SessionData.getDataTbVal("bondsTable", row, "Actual Expiry Date");
			String sRemarks = SessionData.getDataTbVal("bondsTable", row, "Remarks");
			projectEstimationSteps.click_btn_add_bonds();
			if (!sBondRefNo.isEmpty()) {
				projectEstimationSteps.enter_bond_ref_no(sBondRefNo);
			}
			if (!sStartDate.isEmpty()) {
				projectEstimationSteps.pick_start_date_with_bond_ref_no(sStartDate, sBondRefNo);
				;
			}
			if (!sEndDate.isEmpty()) {
				projectEstimationSteps.pick_end_date_with_bond_ref_no(sEndDate, sBondRefNo);
			}
			if (!sIssuingParty.isEmpty()) {
				projectEstimationSteps.enter_issuing_party_with_bond_ref_no(sIssuingParty, sBondRefNo);
			}
			if (!sDlp.isEmpty()) {
				projectEstimationSteps.enter_bond_dlp_with_bond_ref_no(sDlp, sBondRefNo);
			}
			if (!sActualExpiryDate.isEmpty()) {
				projectEstimationSteps.pick_actual_expiry_date_with_bond_ref_no(sActualExpiryDate, sBondRefNo);
			}
			if (!sRemarks.isEmpty()) {
				projectEstimationSteps.enter_remarks_with_bond_ref_no(sRemarks, sBondRefNo);
			}
		}
	}

	@Given("^I enter insurance information as \"([^\"]*)\"$")
	public void i_enter_insurance_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("policyTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("policyTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPolicyNo = SessionData.getDataTbVal("policyTable", row, "Policy No.");
			String sPolicyType = SessionData.getDataTbVal("policyTable", row, "Policy Type");
			String sStartDate = SessionData.getDataTbVal("policyTable", row, "Start Date");
			String sEndDate = SessionData.getDataTbVal("policyTable", row, "End Date");
			String sInsuranceCompany = SessionData.getDataTbVal("policyTable", row, "Insurance Company");
			String sInsured = SessionData.getDataTbVal("policyTable", row, "Insured");
			String sRemarks = SessionData.getDataTbVal("policyTable", row, "Remarks");
			projectEstimationSteps.click_btn_add_policies();
			if (!sPolicyNo.isEmpty()) {
				projectEstimationSteps.enter_policy_no(sPolicyNo);
			}
			if (!sPolicyType.isEmpty()) {
				projectEstimationSteps.enter_policy_type(sPolicyType);
			}
			if (!sStartDate.isEmpty()) {
				projectEstimationSteps.pick_policy_start_date(sStartDate);
				;
			}
			if (!sEndDate.isEmpty()) {
				projectEstimationSteps.pick_policy_end_date(sEndDate);
			}
			if (!sInsuranceCompany.isEmpty()) {
				projectEstimationSteps.enter_insurance_company(sInsuranceCompany);
			}
			if (!sInsured.isEmpty()) {
				projectEstimationSteps.check_insured_with_policy_no(sInsured, sPolicyNo);
			}
			if (!sRemarks.isEmpty()) {
				projectEstimationSteps.enter_policy_remarks(sRemarks);
			}
		}
	}

	@Given("^I enter remarks as \"([^\"]*)\"$")
	public void i_enter_remarks_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("remarksTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("remarksTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSubjectDetail = SessionData.getDataTbVal("remarksTable", row, "Subject Detail");
			String sTermsCondition = SessionData.getDataTbVal("remarksTable", row, "Terms & Condition");
			String sInternalRemarks = SessionData.getDataTbVal("remarksTable", row, "Internal Remarks");
			String sExternalRemarks = SessionData.getDataTbVal("remarksTable", row, "External Remarks");
			String sLiquidatedDamageRemarks = SessionData.getDataTbVal("remarksTable", row,
					"Liquidated Damage Remarks");
			if (!sSubjectDetail.isEmpty()) {
				projectEstimationSteps.enter_subject_detail(sSubjectDetail);
			}
			if (!sTermsCondition.isEmpty()) {
				projectEstimationSteps.enter_terms_and_condition(sTermsCondition);
			}
			if (!sInternalRemarks.isEmpty()) {
				projectEstimationSteps.enter_internal_remarks(sInternalRemarks);
			}
			if (!sExternalRemarks.isEmpty()) {
				projectEstimationSteps.enter_external_remarks(sExternalRemarks);
			}
			if (!sLiquidatedDamageRemarks.isEmpty()) {
				projectEstimationSteps.enter_liquidated_damage_remarks(sLiquidatedDamageRemarks);
			}
		}
	}

	@Given("^I add attachment information as \"([^\"]*)\"$")
	public void i_add_attachment_information_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("filesTable", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("filesTable", "KEY", dataKey);
		int rowIndex = 1;
		for (int row : testData.keySet()) {
			String sFilePath = SessionData.getDataTbVal("filesTable", row, "File Path");
			String sFileDescription = SessionData.getDataTbVal("filesTable", row, "File Description");
			if (!sFilePath.isEmpty()) {
				projectEstimationSteps.add_a_file(sFilePath);
			}
			if (!sFileDescription.isEmpty()) {
				projectEstimationSteps.enter_file_description(sFileDescription, rowIndex);
				rowIndex++;
			}
		}
		projectEstimationSteps.click_btn_submit();
	}

	@Given("^I create costing sheet by phase as \"([^\"]*)\"$")
	public void i_create_costing_sheet_by_phase_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("inputcostingsheetTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("inputcostingsheetTable", "KEY", dataKey);
		projectEstimationSteps.click_btn_costing_sheet();
		String previousPhaseNo = "";
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("inputcostingsheetTable", row, "Phase No.");
			String sNo = SessionData.getDataTbVal("inputcostingsheetTable", row, "No");
			String sType = SessionData.getDataTbVal("inputcostingsheetTable", row, "Type");
			String sItemCostDescription = SessionData.getDataTbVal("inputcostingsheetTable", row,
					"Item Cost Description");
			String sQty = SessionData.getDataTbVal("inputcostingsheetTable", row, QTY_PLACE);
			String sUnitCost = SessionData.getDataTbVal("inputcostingsheetTable", row, "Unit Cost");
			String sMarkup = SessionData.getDataTbVal("inputcostingsheetTable", row, "Markup %");

			if (!sPhaseNo.isEmpty()) {
				projectEstimationSteps.click_on_phase_no_in_costing_sheet(sPhaseNo);
				if (!sPhaseNo.equals(previousPhaseNo)) {
					projectEstimationSteps.click_btn_add_drawing_object();
				}
			}
			if (!sType.isEmpty()) {
				projectEstimationSteps.select_in_drawing_object_type(sNo, sType);
			}
			if (!sItemCostDescription.isEmpty()) {
				projectEstimationSteps.enter_item_code_by_description(sNo, sItemCostDescription);
			}
			if (!sQty.isEmpty()) {
				projectEstimationSteps.enter_drawing_object_qty(sNo, sQty);
			}
			if (!sUnitCost.isEmpty()) {
				projectEstimationSteps.enter_drawing_object_unit_cost(sNo, sUnitCost);
			}
			if (!sMarkup.isEmpty()) {
				projectEstimationSteps.enter_drawing_object_markup_percent(sNo, sMarkup);
			}
		}
		projectEstimationSteps.click_btn_back_to_phase_details();
	}

	@Given("^the details of phases have information as \"([^\"]*)\"$")
	public void the_details_of_phases_have_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("phaseDetailsTable", dataTable, false);
	}

	@Given("^the costing sheet by phase has information as \"([^\"]*)\"$")
	public void the_costing_sheet_by_phase_has_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("costingsheetTable", dataTable, false);
	}

	@Given("^the summary has information as \"([^\"]*)\"$")
	public void the_summary_has_information_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("summaryTable", dataTable, false);
	}

	@When("^user goes back to summary$")
	public void user_goes_back_to_summary() {
		projectEstimationSteps.click_btn_back_to_summary();
	}

	@When("^I change the a value as \"([^\"]*)\" in a phase$")
	public void i_change_the_a_value_as_in_a_phase(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("changeValueTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("changeValueTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPlace = SessionData.getDataTbVal("changeValueTable", row, "Place");
			String sPhaseNo = SessionData.getDataTbVal("changeValueTable", row, "Phase No.");
			String sNewValue = SessionData.getDataTbVal("changeValueTable", row, "New Value");
			switch (sPlace) {
			case QTY_PLACE:
				projectEstimationSteps.enter_qty(sPhaseNo, sNewValue);
				break;
			case "Unit Price":
				projectEstimationSteps.enter_unit_price(sPhaseNo, sNewValue);
				break;
			case "Disc%":
				projectEstimationSteps.enter_disc_percent(sPhaseNo, sNewValue);
				break;
			case "Disc Amt":
				projectEstimationSteps.enter_disc_amt(sPhaseNo, sNewValue);
				break;
			case "Budget Cost":
				projectEstimationSteps.enter_budget_cost(sPhaseNo, sNewValue);
				break;
			case "Margin %":
				projectEstimationSteps.enter_margin_percent(sPhaseNo, sNewValue);
				break;
			case "Delete a phase":
				projectEstimationSteps.click_btn_delete_phase(sPhaseNo);
				break;
			case "Add a phase":
				projectEstimationSteps.add_a_phase(sPhaseNo);
				projectEstimationSteps.enter_new_value_for_phase(sPhaseNo, sNewValue);
				break;
			default:
				System.out.println("Cannot recognize the place");
				break;
			}
		}
	}

	@Then("^I should see details of that phase after changing as \"([^\"]*)\"$")
	public void i_should_see_details_of_that_phase_after_changing_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("phaseDetails", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseDetails", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("phaseDetails", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseDetails", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseDetails", row, "Unit Price");
			String sDisc = SessionData.getDataTbVal("phaseDetails", row, "Disc%");
			String sDiscAmt = SessionData.getDataTbVal("phaseDetails", row, "Disc Amt");
			String sPhaseValue = SessionData.getDataTbVal("phaseDetails", row, "Phase Value");
			String sBudgetCost = SessionData.getDataTbVal("phaseDetails", row, "Budget Cost");
			String sBudgetProfit = SessionData.getDataTbVal("phaseDetails", row, "Budget Profit");
			String sMargin = SessionData.getDataTbVal("phaseDetails", row, "Margin %");
			if (!sQty.isEmpty()) {
				projectEstimationSteps.verify_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				projectEstimationSteps.verify_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sDisc.isEmpty()) {
				projectEstimationSteps.verify_disc_percent(sPhaseNo, sDisc);
			}
			if (!sDiscAmt.isEmpty()) {
				projectEstimationSteps.verify_disc_amt(sPhaseNo, sDiscAmt);
			}
			if (!sPhaseValue.isEmpty()) {
				projectEstimationSteps.verify_phase_value(sPhaseNo, sPhaseValue);
			}
			if (!sBudgetCost.isEmpty()) {
				projectEstimationSteps.verify_budget_cost(sPhaseNo, sBudgetCost);
			}
			if (!sBudgetProfit.isEmpty()) {
				projectEstimationSteps.verify_budget_profit(sPhaseNo, sBudgetProfit);
			}
			if (!sMargin.isEmpty()) {
				projectEstimationSteps.verify_margin_percent(sPhaseNo, sMargin);
			}
		}
	}

	@Then("^the summary values after changing should be as \"([^\"]*)\"$")
	public void the_summary_values_after_changing_should_be_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("summaryTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("summaryTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSummaryValues = SessionData.getDataTbVal("summaryTable", row, "Summary Values");
			String sNature = SessionData.getDataTbVal("summaryTable", row, "Nature");
			String sHome = SessionData.getDataTbVal("summaryTable", row, "Home");

			if (!sSummaryValues.isEmpty()) {
				if (sSummaryValues.equals("Project Sum")) {
					projectEstimationSteps.verify_nature_project_sum(sNature);
					projectEstimationSteps.verify_home_project_sum(sHome);
				}
				if (sSummaryValues.equals("Project Budget Cost")) {
					projectEstimationSteps.verify_nature_project_budget_cost(sNature);
					projectEstimationSteps.verify_home_project_budget_cost(sHome);
				}
				if (sSummaryValues.equals("Project Budget Profit Amount")) {
					projectEstimationSteps.verify_nature_project_budget_profit(sNature);
					projectEstimationSteps.verify_home_project_budget_profit(sHome);
				}
				if (sSummaryValues.equals("Project Budget Profit Percent")) {
					projectEstimationSteps.verify_project_budget_percent(sNature);
					projectEstimationSteps.verify_project_budget_percent(sHome);
				}
				if (sSummaryValues.equals("Sales Tax")) {
					projectEstimationSteps.verify_nature_sales_tax(sNature);
					projectEstimationSteps.verify_home_sales_tax(sHome);
				}
				if (sSummaryValues.equals("Project Value incl. Tax")) {
					projectEstimationSteps.verify_nature_project_value_incl_tax(sNature);
					projectEstimationSteps.verify_home_project_value_incl_tax(sHome);
				}
			}
		}
	}

	@Then("^the downpayment and retention after changing should be as \"([^\"]*)\"$")
	public void the_downpayment_and_retention_after_changing_should_be_as(String dataKey,
			List<List<String>> dataTable) {
		SessionData.addDataTable("headerTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("headerTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sDownpaymentAmount = SessionData.getDataTbVal("headerTable", row, "Downpayment Amount");
			String sDownpaymentPercent = SessionData.getDataTbVal("headerTable", row, "Downpayment Percent");
			String sProgressiveRetention = SessionData.getDataTbVal("headerTable", row, "Progressive Retention");
			String sMaxRetentionAmount = SessionData.getDataTbVal("headerTable", row, "Max Retention Amount");
			String sMaxRetentionPercent = SessionData.getDataTbVal("headerTable", row, "Max Retention Percent");

			if (!sDownpaymentAmount.isEmpty()) {
				projectEstimationSteps.verify_downpayment_amt(sDownpaymentAmount);
			}
			if (!sDownpaymentPercent.isEmpty()) {
				projectEstimationSteps.verify_downpayment_percent(sDownpaymentPercent);
			}
			if (!sProgressiveRetention.isEmpty()) {
				projectEstimationSteps.verify_progressive_retention(sProgressiveRetention);
			}
			if (!sMaxRetentionAmount.isEmpty()) {
				projectEstimationSteps.verify_max_retention_amt(sMaxRetentionAmount);
			}
			if (!sMaxRetentionPercent.isEmpty()) {
				projectEstimationSteps.verify_max_retention_percent(sMaxRetentionPercent);
			}
		}
	}
}