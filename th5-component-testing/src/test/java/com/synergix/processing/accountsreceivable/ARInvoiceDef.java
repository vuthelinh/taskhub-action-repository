package com.synergix.processing.accountsreceivable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountsreceivable.steps.ARInvoiceSTeps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class ARInvoiceDef {
	@Steps
	ARInvoiceSTeps onARInvoiceStep;

	private boolean isContinue = false;
	private boolean isUpdate = false;

	String ssARInv = "ssARInv";

	@When("^user create ar invoice as \"([^\"]*)\"$")
	public void user_create_ar_invoice_as(String datakey,
			List<List<String>> dataTable) throws Throwable {

		String dataTableKey = "ARInvoice";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKey = "KEY";
		String colCustomer = "Customer";
		String colInvoiceDate = "Invoice Date";
		String colDueDate = "DueDate";
		String colRefNo = "Ref No";
		String colCurrency = "Currency";
		String colDefaultSalesTax = "Default Sales Tax";
		String colSalesPerson = "Sales Person ";
		String colDefaultDisc = "Default Disc %";
		String colCustomerPONo = "Customer PO No";
		String colLocation = "Location";
		String colCreatedBy = "Creat By";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onARInvoiceStep.switchToDrafTab();

		for (int row : SessionData.getDataTbRowsByValEqualInCol(dataTableKey,
				colKey, datakey).keySet()) {

			String customer = SessionData.getDataTbVal(dataTableKey, row,
					colCustomer);
			String invoiceDate = SessionData.getDataTbVal(dataTableKey, row,
					colInvoiceDate);
			String dueDate = SessionData.getDataTbVal(dataTableKey, row,
					colDueDate);
			String refNo = SessionData
					.getDataTbVal(dataTableKey, row, colRefNo);
			String currency = SessionData.getDataTbVal(dataTableKey, row,
					colCurrency);
			String defaultSalesTax = SessionData.getDataTbVal(dataTableKey,
					row, colDefaultSalesTax);
			String salesPerson = SessionData.getDataTbVal(dataTableKey, row,
					colSalesPerson);
			String defaultDisc = SessionData.getDataTbVal(dataTableKey, row,
					colDefaultDisc);
			String customerPONo = SessionData.getDataTbVal(dataTableKey, row,
					colCustomerPONo);
			String location = SessionData.getDataTbVal(dataTableKey, row,
					colLocation);
			String creatby = SessionData.getDataTbVal(dataTableKey, row,
					colCreatedBy);
			String segment1 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment4);

			onARInvoiceStep.clickOnNewBtn();

			if (!customer.isEmpty()) {
				onARInvoiceStep.type_Customer(customer);
			}
			if (invoiceDate.isEmpty())
				invoiceDate = onARInvoiceStep.getToday();
			onARInvoiceStep.type_InvoiceDate(invoiceDate);

			if (!refNo.isEmpty()) {
				onARInvoiceStep.type_RefNo(refNo);
			}
			if (!currency.isEmpty()) {
				onARInvoiceStep.type_Currency(currency);
			}
			if (!defaultSalesTax.isEmpty()) {
				onARInvoiceStep.type_defaultSalesTax(defaultSalesTax);
			}

			if (!salesPerson.isEmpty()) {
				onARInvoiceStep.type_salesPerson(salesPerson);
			}

			if (!customerPONo.isEmpty()) {
				onARInvoiceStep.type_customerPONo(customerPONo);
			}
			if (!defaultDisc.isEmpty()) {
				onARInvoiceStep.type_defaultDisc(defaultDisc);
			}

			if (!location.isEmpty()) {
				onARInvoiceStep.type_location(location);
			}

			List<String> listSegment = new ArrayList<>();
			listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
					segment4));
			onARInvoiceStep.setSegment(listSegment);
			isContinue = true;
			isUpdate = false;
		}
	}

	@When("^user update ar invoice as \"([^\"]*)\"$")
	public void user_update_ar_invoice_as(String datakey,
			List<List<String>> dataTable) {

		String dataTableKey = "ARInvoiceUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colKey = "KEY";
		String colInvNo = "Inv No";
		String colCustomer = "Customer";
		String colInvoiceDate = "Invoice Date";
		String colDueDate = "DueDate";
		String colRefNo = "Ref No";
		String colCurrency = "Currency";
		String colDefaultSalesTax = "Default Sales Tax";
		String colSalesPerson = "Sales Person";
		String colDefaultDisc = "Default Disc %";
		String colCustomerPONo = "Customer PO No";
		String colLocation = "Location";
		String colCreatedBy = "Creat By";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onARInvoiceStep.switchToDrafTab();

		for (int row : SessionData.getDataTbRowsByValEqualInCol(dataTableKey,
				colKey, datakey).keySet()) {
			String invNo = SessionData
					.getDataTbVal(dataTableKey, row, colInvNo);
			String customer = SessionData.getDataTbVal(dataTableKey, row,
					colCustomer);
			String invoiceDate = SessionData.getDataTbVal(dataTableKey, row,
					colInvoiceDate);
			String dueDate = SessionData.getDataTbVal(dataTableKey, row,
					colDueDate);
			String refNo = SessionData
					.getDataTbVal(dataTableKey, row, colRefNo);
			String currency = SessionData.getDataTbVal(dataTableKey, row,
					colCurrency);
			String defaultSalesTax = SessionData.getDataTbVal(dataTableKey,
					row, colDefaultSalesTax);

			String salesPerson = SessionData.getDataTbVal(dataTableKey, row,
					colSalesPerson);
			String defaultDisc = SessionData.getDataTbVal(dataTableKey, row,
					colDefaultDisc);
			String customerPONo = SessionData.getDataTbVal(dataTableKey, row,
					colCustomerPONo);
			String location = SessionData.getDataTbVal(dataTableKey, row,
					colLocation);
			String creatby = SessionData.getDataTbVal(dataTableKey, row,
					colCreatedBy);
			String segment1 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, row,
					colSegment4);

			if (!invNo.isEmpty()) {
				onARInvoiceStep.search(invNo);
				onARInvoiceStep.selectInv(invNo);

				if (!customer.isEmpty()) {
					onARInvoiceStep.type_Customer(customer);
				}
				if (!invoiceDate.isEmpty()) {
					onARInvoiceStep.type_InvoiceDate(invoiceDate);
				}
				if (!refNo.isEmpty()) {
					onARInvoiceStep.type_RefNo(refNo);
				}
				if (!currency.isEmpty()) {
					onARInvoiceStep.type_Currency(currency);
				}
				if (!defaultSalesTax.isEmpty()) {
					onARInvoiceStep.type_defaultSalesTax(defaultSalesTax);
				}

				if (!salesPerson.isEmpty()) {
					onARInvoiceStep.type_salesPerson(salesPerson);
				}

				if (!customerPONo.isEmpty()) {
					onARInvoiceStep.type_customerPONo(customerPONo);
				}
				if (!defaultDisc.isEmpty()) {
					onARInvoiceStep.type_defaultDisc(defaultDisc);
				}

				if (!location.isEmpty()) {
					onARInvoiceStep.type_location(location);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARInvoiceStep.setSegment(listSegment);

				isContinue = true;
				isUpdate = true;
			}
		}
	}

	@When("^user add billing AR invoice as \"([^\"]*)\"$")
	public void user_add_billing_ar_invoice(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARInvoiceRPT";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKey = "KEY";
			String colType = "Type";
			String colItemCode = "Item Code/Remarks Description";
			String colQtyUOM = "Qty UOM";
			String colNoOfPacksPackSize = "No Of Packs Pack Size";
			String colUnitPricePriceType = "Unit Price Price Type";
			String colDisc = "Disc %";
			String colAmount = "Amount";
			String colTotalAmt = "Total Amt";
			String colSalesTax = "Sales Tax";
			String colSerialNo = "Serial No";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colDelete = "Delete";
			String colCkeckDel = "Check Del";

			int rowIndex = onARInvoiceStep.countRowTb();

			for (int row1 : SessionData.getDataTbRowsByValEqualInCol(
					dataTableKey, colKey, dataKey).keySet()) {

				String type = SessionData.getDataTbVal(dataTableKey, row1,
						colType);
				String itemCode = SessionData.getDataTbVal(dataTableKey, row1,
						colItemCode);
				String QtyUOM = SessionData.getDataTbVal(dataTableKey, row1,
						colQtyUOM);
				String NoOfPacksPackSize = SessionData.getDataTbVal(
						dataTableKey, row1, colNoOfPacksPackSize);
				String unitPricePriceType = SessionData.getDataTbVal(
						dataTableKey, row1, colUnitPricePriceType);
				String disc = SessionData.getDataTbVal(dataTableKey, row1,
						colDisc);
				String amount = SessionData.getDataTbVal(dataTableKey, row1,
						colAmount);
				String totalAmt = SessionData.getDataTbVal(dataTableKey, row1,
						colTotalAmt);
				String salesTax = SessionData.getDataTbVal(dataTableKey, row1,
						colSalesTax);
				String serialNo = SessionData.getDataTbVal(dataTableKey, row1,
						colSerialNo);
				String segment1 = SessionData.getDataTbVal(dataTableKey, row1,
						colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, row1,
						colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, row1,
						colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, row1,
						colSegment4);

				String delete = SessionData.getDataTbVal(dataTableKey, row1,
						colDelete);
				String checkDel = SessionData.getDataTbVal(dataTableKey, row1,
						colCkeckDel);

				onARInvoiceStep.addLI();
				rowIndex += 1;

				if (!type.isEmpty()) {
					onARInvoiceStep.select_Type(type, rowIndex);
				}
				if (!itemCode.isEmpty()) {
					onARInvoiceStep.type_ItemCode(itemCode, rowIndex);
				}
				if (!QtyUOM.isEmpty()) {
					onARInvoiceStep.type_QtyUOM(QtyUOM, rowIndex);
				}
				if (!NoOfPacksPackSize.isEmpty()) {
					onARInvoiceStep.select_NoOfPacksPackSize(NoOfPacksPackSize,
							rowIndex);
				}
				if (!unitPricePriceType.isEmpty()) {
					onARInvoiceStep.type_unitPricePriceType(unitPricePriceType,
							rowIndex);
				}
				if (!disc.isEmpty()) {
					onARInvoiceStep.type_disc(disc, rowIndex);
				}
				if (!amount.isEmpty()) {
					onARInvoiceStep.type_amount(amount, rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onARInvoiceStep.type_salesTax(salesTax, rowIndex);
				}
				if (!serialNo.isEmpty()) {
					onARInvoiceStep.type_serialNo(serialNo, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARInvoiceStep.setSegment(listSegment, rowIndex);

				if (!delete.isEmpty()) {
					onARInvoiceStep.clickOnDeletetext(rowIndex);
					rowIndex = rowIndex - 1;
				}
				if (!checkDel.isEmpty()) {
					onARInvoiceStep.check_Delete(rowIndex);
					rowIndex = rowIndex - 1;
				}
			}
		}
	}

	@When("^user creat payment information ar invoice as \"([^\"]*)\"$")
	public void user_creat_payment_information_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			SessionData.addDataTable("ARINVOICE1", dataTable);
			for (int row : SessionData.getDataTbRowsByValEqualInCol(
					"ARINVOICE1", "KEY", dataKey).keySet()) {
				String sPaymentOption = SessionData.getDataTbVal("ARINVOICE1",
						row, "Payment Option");
				String sPaymentTerm = SessionData.getDataTbVal("ARINVOICE1",
						row, "Payment Term");
				String sPaymentTermTenor = SessionData.getDataTbVal(
						"ARINVOICE1", row, "Payment Term Tenor");
				String sPaymentTermTenorCode = SessionData.getDataTbVal(
						"ARINVOICE1", row, "Payment Term Tenor Code");
				String sPaymentMethod = SessionData.getDataTbVal("ARINVOICE1",
						row, "Payment Method");
				String sBillingParty = SessionData.getDataTbVal("ARINVOICE1",
						row, "Billing Party");
				String sBillingAddress = SessionData.getDataTbVal("ARINVOICE1",
						row, "Billing Address");
				String sBillingContact = SessionData.getDataTbVal("ARINVOICE1",
						row, "Billing Contact");

				onARInvoiceStep.intoPaymentInformation();

				if (!sPaymentOption.isEmpty()) {
					onARInvoiceStep.select_in_payment_option(sPaymentOption);
				}
				if (!sPaymentTerm.isEmpty()) {
					onARInvoiceStep.select_in_payment_term(sPaymentTerm);
				}
				if (!sPaymentTermTenor.isEmpty()) {
					onARInvoiceStep.enter_payment_term_tenor(sPaymentTermTenor);
				}
				if (!sPaymentTermTenorCode.isEmpty()) {
					onARInvoiceStep
							.enter_payment_term_tenor_code(sPaymentTermTenorCode);
				}
				if (!sPaymentMethod.isEmpty()) {
					onARInvoiceStep.select_in_payment_method(sPaymentMethod);
				}
				if (!sBillingParty.isEmpty()) {
					onARInvoiceStep.enter_billingParty(sBillingParty);
				}
				if (!sBillingAddress.isEmpty()) {
					onARInvoiceStep.enter_billing_address(sBillingAddress);
				}
				if (!sBillingContact.isEmpty()) {
					onARInvoiceStep.enter_billing_contact(sBillingContact);
				}
			}
		}
	}

	@When("^user submit ar invoice$")
	public void user_submit_ar_invoice() {
		if (isContinue) {
			onARInvoiceStep.getInvoiceNo(ssARInv);
			onARInvoiceStep.clickSubmitbtn();
		}
	}

	@When("^ar invoice is previewed with report name as \"([^\"]*)\"$")
	public void ar_invoice_is_previewed_with_report_name_as(String reportName) {
		onARInvoiceStep.clickOnPreviewBtn(reportName);
	}

	@When("^ar invoice is previewed at history tab with report name as \"([^\"]*)\"$")
	public void ar_invoice_is_previewed_at_history_tab_with_report_name_as(
			String reportName) {
		String invNo = onARInvoiceStep.getDataWithSession(ssARInv);
		onARInvoiceStep.clickOnPreviewBtn(invNo, reportName);
	}
}
