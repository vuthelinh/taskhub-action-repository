package com.synergix.processing.accountsreceivable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountsreceivable.steps.ARCreditNoteSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class ARCreditNoteDefs {
	@Steps
	ARCreditNoteSteps onARCreditNoteSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssCrnInv = "ARCrnInv";

	@When("^user create AR credit note as \"([^\"]*)\"$")
	public void user_create_AR_credit_note_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARCreditNote";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colCrnNo = "Crn No.";
		String colCustomer = "Customer";
		String colBillingParty = "Billing Party";
		String colCreditNoteDate = "Credit Note Date";
		String colRefNo = "Ref No.";
		String colCustomerPONo = "Customer PO No.";
		String colCurrency = "Currency";
		String colDefaultSalesTax = "Default Sales Tax";
		String colPaymentOption = "Payment Option";
		String colBillingContact = "Billing Contact";
		String colDefaultDisc = "Default Disc %";
		String colLocation = "Location";
		String colSalesPerson = "Sales Person";
		String colBillingAddress = "Billing Address";
		String colCreditNoteCategory = "Credit Note Category";
		String colCreditNoteJustification = "Credit Note Justification";
		String colRemarksToCustomer = "Remarks To Customer";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowARCreditNote : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String crnNo = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCrnNo);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCustomer);
			String billingParty = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colBillingParty);
			String creditNoteDate = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCreditNoteDate);
			String refNo = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colRefNo);
			String customerPONo = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCustomerPONo);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCurrency);
			String defaultSalesTax = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colDefaultSalesTax);
			String paymentOption = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colPaymentOption);
			String billingContact = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colBillingContact);
			String defaultDisc = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colDefaultDisc);
			String location = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colLocation);
			String salesPerson = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSalesPerson);
			String billingAddress = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colBillingAddress);
			String creditNoteCategory = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCreditNoteCategory);
			String creditNoteJustification = SessionData.getDataTbVal(
					dataTableKey, rowARCreditNote, colCreditNoteJustification);
			String remarksToCustomer = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colRemarksToCustomer);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment4);

			onARCreditNoteSteps.switchToDrafTab();

			if (!customer.isEmpty()) {
				onARCreditNoteSteps.clickOnNewBtn();
				onARCreditNoteSteps.typeCustomer(customer);

				onARCreditNoteSteps.switchToBillingTab();

				if (creditNoteDate.isEmpty()) {
					creditNoteDate = onARCreditNoteSteps.getToday();
					onARCreditNoteSteps.typeCreditNoteDate(creditNoteDate);
				}
				if (!refNo.isEmpty()) {
					onARCreditNoteSteps.typeRefNo(refNo);
				}
				if (!customerPONo.isEmpty()) {
					onARCreditNoteSteps.typeCustomerPONo(customerPONo);
				}
				if (!currency.isEmpty()) {
					onARCreditNoteSteps.typeCurrency(currency);
				}
				if (!defaultSalesTax.isEmpty()) {
					onARCreditNoteSteps.typeDefaultSalesTax(defaultSalesTax);
				}
				if (!paymentOption.isEmpty()) {
					onARCreditNoteSteps.choosePaymentOption(paymentOption);
				}
				if (!billingContact.isEmpty()) {
					onARCreditNoteSteps.typeBillingContact(billingContact);
				}
				if (!defaultDisc.isEmpty()) {
					onARCreditNoteSteps.typeDefaultDisc(defaultDisc);
				}
				if (!location.isEmpty()) {
					onARCreditNoteSteps.typeLocation(location);
				}
				if (!salesPerson.isEmpty()) {
					onARCreditNoteSteps.typeSalesPerson(salesPerson);
				}
				if (!billingAddress.isEmpty()) {
					onARCreditNoteSteps.typeBillingAddress(billingAddress);
				}
				if (!creditNoteCategory.isEmpty()) {
					onARCreditNoteSteps
							.typeCreditNoteCategory(creditNoteCategory);
				}
				if (!creditNoteJustification.isEmpty()) {
					onARCreditNoteSteps
							.typeCreditNoteJustification(creditNoteJustification);
				}
				if (!remarksToCustomer.isEmpty()) {
					onARCreditNoteSteps
							.typeRemarksToCustomer(remarksToCustomer);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARCreditNoteSteps.setSegment(listSegment);

				isContinue = true;
				isUpdate = false;
				onARCreditNoteSteps.getInvoiceNo(ssCrnInv);
			}
		}
	}

	@When("^user update AR credit note as \"([^\"]*)\"$")
	public void user_update_AR_credit_note_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "ARCreditNote";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colCrnNo = "Crn No.";
		String colCustomer = "Customer";
		String colBillingParty = "Billing Party";
		String colCreditNoteDate = "Credit Note Date";
		String colRefNo = "Ref No.";
		String colCustomerPONo = "Customer PO No.";
		String colCurrency = "Currency";
		String colDefaultSalesTax = "Default Sales Tax";
		String colPaymentOption = "Payment Option";
		String colBillingContact = "Billing Contact";
		String colDefaultDisc = "Default Disc %";
		String colLocation = "Location";
		String colSalesPerson = "Sales Person";
		String colBillingAddress = "Billing Address";
		String colCreditNoteCategory = "Credit Note Category";
		String colCreditNoteJustification = "Credit Note Justification";
		String colRemarksToCustomer = "Remarks To Customer";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowARCreditNote : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String crnNo = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCrnNo);
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCustomer);
			String billingParty = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colBillingParty);
			String creditNoteDate = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCreditNoteDate);
			String refNo = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colRefNo);
			String customerPONo = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCustomerPONo);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCurrency);
			String defaultSalesTax = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colDefaultSalesTax);
			String paymentOption = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colPaymentOption);
			String billingContact = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colBillingContact);
			String defaultDisc = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colDefaultDisc);
			String location = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colLocation);
			String salesPerson = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSalesPerson);
			String billingAddress = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colBillingAddress);
			String creditNoteCategory = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colCreditNoteCategory);
			String creditNoteJustification = SessionData.getDataTbVal(
					dataTableKey, rowARCreditNote, colCreditNoteJustification);
			String remarksToCustomer = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colRemarksToCustomer);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowARCreditNote, colSegment4);

			onARCreditNoteSteps.switchToDrafTab();
			if (onARCreditNoteSteps.searchDrafARCrnNo(crnNo)) {

				onARCreditNoteSteps.deleteAllBillingDetail();

				if (!customer.isEmpty()) {
					onARCreditNoteSteps.typeCustomer(customer);
				}

				onARCreditNoteSteps.switchToBillingTab();

				if (!creditNoteDate.isEmpty()) {
					onARCreditNoteSteps.typeCreditNoteDate(creditNoteDate);
				}
				if (!refNo.isEmpty()) {
					onARCreditNoteSteps.typeRefNo(refNo);
				}
				if (!customerPONo.isEmpty()) {
					onARCreditNoteSteps.typeCustomerPONo(customerPONo);
				}
				if (!currency.isEmpty()) {
					onARCreditNoteSteps.typeCurrency(currency);
				}
				if (!defaultSalesTax.isEmpty()) {
					onARCreditNoteSteps.typeDefaultSalesTax(defaultSalesTax);
				}
				if (!paymentOption.isEmpty()) {
					onARCreditNoteSteps.choosePaymentOption(paymentOption);
				}
				if (!billingContact.isEmpty()) {
					onARCreditNoteSteps.typeBillingContact(billingContact);
				}
				if (!defaultDisc.isEmpty()) {
					onARCreditNoteSteps.typeDefaultDisc(defaultDisc);
				}
				if (!location.isEmpty()) {
					onARCreditNoteSteps.typeLocation(location);
				}
				if (!salesPerson.isEmpty()) {
					onARCreditNoteSteps.typeSalesPerson(salesPerson);
				}
				if (!billingAddress.isEmpty()) {
					onARCreditNoteSteps.typeBillingAddress(billingAddress);
				}
				if (!creditNoteCategory.isEmpty()) {
					onARCreditNoteSteps
							.typeCreditNoteCategory(creditNoteCategory);
				}
				if (!creditNoteJustification.isEmpty()) {
					onARCreditNoteSteps
							.typeCreditNoteJustification(creditNoteJustification);
				}
				if (!remarksToCustomer.isEmpty()) {
					onARCreditNoteSteps
							.typeRemarksToCustomer(remarksToCustomer);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARCreditNoteSteps.setSegment(listSegment);

				isContinue = true;
				isUpdate = true;
				onARCreditNoteSteps.getInvoiceNo(ssCrnInv);
			}
		}
	}

	@When("^AR credit note is added billing detail as \"([^\"]*)\"$")
	public void AR_credit_note_is_added_billing_detail_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARCreditNoteBilling";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colType = "Type";
			String colItemCode = "Item Code";
			String colRemarksDescription = "Remarks Description";
			String colQtyUOM = "Qty UOM";
			String colPackSizeNoOfPacks = "Pack Size No. Of Packs";
			String colPriceType = "Price Type";
			String colUnitPrice = "Unit Price";
			String colDiscount = "Discount %";
			String colAmount = "Amount";
			String colSalesTax = "Sales Tax";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colDelete = "Delete";

			int rowIndex = onARCreditNoteSteps.countRowBillingTb();

			for (int rowARCreditNoteBilling : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String type = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colType);
				String itemCode = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colItemCode);
				String remarksDescription = SessionData.getDataTbVal(
						dataTableKey, rowARCreditNoteBilling,
						colRemarksDescription);
				String qtyUOM = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colQtyUOM);
				String packSizeNoOfPacks = SessionData.getDataTbVal(
						dataTableKey, rowARCreditNoteBilling,
						colPackSizeNoOfPacks);
				String priceType = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colPriceType);
				String unitPrice = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colUnitPrice);
				String discount = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colDiscount);
				String amount = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colAmount);
				String salesTax = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colSalesTax);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colSegment4);
				String delete = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteBilling, colDelete);

				onARCreditNoteSteps.clickOnAddBtn();
				rowIndex = rowIndex + 1;
				if (!type.isEmpty()) {
					onARCreditNoteSteps.chooseType(type, rowIndex);
				}
				if (!itemCode.isEmpty()) {
					onARCreditNoteSteps.typeItemCode(itemCode, rowIndex);
				}
				if (!remarksDescription.isEmpty()) {
					onARCreditNoteSteps.typeRemarksDescription(
							remarksDescription, rowIndex);
				}
				if (!qtyUOM.isEmpty()) {
					onARCreditNoteSteps.typeQtyUOM(qtyUOM, rowIndex);
				}
				if (!packSizeNoOfPacks.isEmpty()) {
					onARCreditNoteSteps.typePackSizeNoOfPacks(
							packSizeNoOfPacks, rowIndex);
				}
				if (!priceType.isEmpty()) {
					onARCreditNoteSteps.typePriceType(priceType, rowIndex);
				}
				if (!unitPrice.isEmpty()) {
					onARCreditNoteSteps.typeUnitPrice(unitPrice, rowIndex);
				}
				if (!discount.isEmpty()) {
					onARCreditNoteSteps.typeDiscount(discount, rowIndex);
				}
				if (!amount.isEmpty()) {
					onARCreditNoteSteps.chooseAmount(amount, rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onARCreditNoteSteps.typeSalesTax(salesTax, rowIndex);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onARCreditNoteSteps.setSegment(listSegment, rowIndex);

				if (!delete.isEmpty()) {
					onARCreditNoteSteps.chooseDelete(rowIndex);
					rowIndex = rowIndex - 1;
				}
			}
		}
	}

	@When("^AR credit note is applied as \"([^\"]*)\"$")
	public void AR_credit_note_is_applied_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARCreditNoteApplied";
			SessionData.addDataTable(dataTableKey, dataTable, false);

			String colKEY = "KEY";
			String colInvNo = "Inv No.";
			String colSrcInvNo = "Src Inv No";
			String colInvoiceDate = "Invoice Date";
			String colDueDate = "Due Date";
			String colInvCcy = "Inv Ccy";
			String colRefNo = "Ref No.";
			String coldCrnAmtHomeAmt = "d Crn Amt Home Amt";
			String coldInvAmtHomeAmt = "d Inv Amt Home Amt";
			String colApplyFull = "Apply Full";

			for (int rowARCreditNoteApplied : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String kEY = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colKEY);
				String invNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colInvNo);
				String srcInvNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colSrcInvNo);
				String invoiceDate = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colInvoiceDate);
				String dueDate = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colDueDate);
				String invCcy = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colInvCcy);
				String refNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colRefNo);
				String dCrnAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, coldCrnAmtHomeAmt);
				String dInvAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, coldInvAmtHomeAmt);
				String applyFull = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteApplied, colApplyFull);

				onARCreditNoteSteps.switchToApplicationTab();

				if (onARCreditNoteSteps.searchInvNoApplied(invNo)) {
					int rowIndex = 1;
					if (!dCrnAmtHomeAmt.isEmpty()) {
						onARCreditNoteSteps.typedCrnAmtHomeAmt(dCrnAmtHomeAmt,
								rowIndex);
					}
					if (!applyFull.isEmpty()) {
						onARCreditNoteSteps.typeApplyFull(rowIndex);
					}
				}
			}
		}
	}

	@When("^AR credit note is applied at outstanding tab as \"([^\"]*)\"$")
	public void AR_credit_note_is_applied_at_outstanding_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "ARCreditNoteAppliedOst";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colInvNo = "Inv No.";
			String colApplicationDate = "Application Date";

			onARCreditNoteSteps.switchToOutstandingTab();
			for (int rowARCreditNoteAppliedOst : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String invNo = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteAppliedOst, colInvNo);
				String applicationDate = SessionData.getDataTbVal(dataTableKey,
						rowARCreditNoteAppliedOst, colApplicationDate);

				if (invNo.isEmpty())
					invNo = onARCreditNoteSteps.getDataWithSession(ssCrnInv);
				if (onARCreditNoteSteps.searchOstCrnNo(invNo)) {
					if (applicationDate.isEmpty())
						applicationDate = onARCreditNoteSteps.getToday();
					onARCreditNoteSteps.typeApplicationDate(applicationDate);
				}
			}
		}
	}

	@When("^AR credit note is submitted$")
	public void AR_credit_note_is_submitted() {
		if (isContinue) {
			onARCreditNoteSteps.clickOnSubmitBtn();
		}
	}

	@When("^AR credit note is previewed with report name \"([^\"]*)\"$")
	public void AR_credit_note_is_previewed_with_report_name(String reportName) {
		if (isContinue) {
			onARCreditNoteSteps.clickPreview(reportName);
		}
	}

	@When("^AR credit note is preview at history tab with report name \"([^\"]*)\"$")
	public void AR_credit_note_is_previewed_at_history_tab_with_report_name(
			String reportName) {
		if (isContinue) {
			String invNo = onARCreditNoteSteps.getDataWithSession(ssCrnInv);
			onARCreditNoteSteps.clickPreviewHST(invNo, reportName);
		}
	}
}
