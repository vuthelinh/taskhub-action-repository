package com.synergix.openingbalance.finance.finance.finance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.steps.AccountsReceivableSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OBAccountsReceivableDefs {

	@Steps
	AccountsReceivableSteps onAccountsReceivableSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_OPENING_BALANCE + "AccountsReceivable.xls";
	String keyFileName = "AccountsReceivable";
	String invoiceSheet = "Invoice";
	String creditNoteSheet = "Credit Note";

	@When("user create invoice ar as \"([^\"]*)\"")
	public void user_create_invoice_ar_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "OBARInv";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYOBARINV = "KEY OBARINV";
		String colCustomerCode = "Customer Code";
		String colInvoiceDate = "Invoice Date";
		String colDueDate = "Due Date";
		String colSalesPerson = "Sales Person";
		String colReferenceNo = "Reference No";
		String colCurrency = "Currency";
		String colExchangeRate = "Exchange Rate";
		String colTotalAfterTaxAmt = "Total After Tax Amt";
		String colTotalAfterTaxHomeAmt = "Total After Tax Home Amt";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onAccountsReceivableSteps.switchToIFrame();

		onAccountsReceivableSteps.moveToInvoiceTab();

		for (int rowOBARInv : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBARINV, dataKey).keySet()) {
			String customerCode = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colCustomerCode);
			String invoiceDate = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colInvoiceDate);
			String dueDate = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colDueDate);
			String salesPerson = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colSalesPerson);
			String referenceNo = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colReferenceNo);
			String currency = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colExchangeRate);
			String totalAfterTaxAmt = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colTotalAfterTaxAmt);
			String totalAfterTaxHomeAmt = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colTotalAfterTaxHomeAmt);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBARInv, colSegment4);

			if (!customerCode.isEmpty()) {
				onAccountsReceivableSteps.addNewInvoice();

				onAccountsReceivableSteps.typeCustomerCode(customerCode);

				if (!invoiceDate.isEmpty()) {
					onAccountsReceivableSteps.typeInvoiceDate(invoiceDate);
				}
				if (!dueDate.isEmpty()) {
					onAccountsReceivableSteps.typeDueDate(dueDate);
				}
				if (!salesPerson.isEmpty()) {
					onAccountsReceivableSteps.typeSalesPerson(salesPerson);
				}
				if (!referenceNo.isEmpty()) {
					onAccountsReceivableSteps.typeReferenceNo(referenceNo);
				}
				if (!currency.isEmpty()) {
					onAccountsReceivableSteps.typeCurrency(currency);
				}
				if (!exchangeRate.isEmpty()) {
					onAccountsReceivableSteps.typeExchangeRate(exchangeRate);
				}
				if (!totalAfterTaxAmt.isEmpty()) {
					onAccountsReceivableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
				}
				if (!totalAfterTaxHomeAmt.isEmpty()) {
					onAccountsReceivableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onAccountsReceivableSteps.setSegment(listSegment);

				onAccountsReceivableSteps.clickOnSubmitButton();
			}
		}
		onAccountsReceivableSteps.switchOutDefaultIFrame();
	}

	@When("user create credit note ar as \"([^\"]*)\"")
	public void user_create_credit_note_ar_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "OBARCrn";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYOBARCRN = "KEY OBARCRN";
		String colCustomerCode = "Customer Code";
		String colCreditNoteDate = "Credit Note Date";
		String colSalesPerson = "Sales Person";
		String colReferenceNo = "Reference No";
		String colCreditNoteCategory = "Credit Note Category";
		String colCreditNoteJustification = "Credit Note Justification";
		String colCurrency = "Currency";
		String colExchangeRate = "Exchange Rate";
		String colTotalAfterTaxAmt = "Total After Tax Amt";
		String colTotalAfterTaxHomeAmt = "Total After Tax Home Amt";
		String colRemarksToCustomer = "Remarks To Customer";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onAccountsReceivableSteps.switchToIFrame();

		onAccountsReceivableSteps.moveToCreditNoteTab();

		for (int rowOBARCrn : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBARCRN, dataKey).keySet()) {
			String customerCode = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colCustomerCode);
			String creditNoteDate = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colCreditNoteDate);
			String salesPerson = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colSalesPerson);
			String referenceNo = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colReferenceNo);
			String creditNoteCategory = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colCreditNoteCategory);
			String creditNoteJustification = SessionData.getDataTbVal(dataTableKey, rowOBARCrn,
					colCreditNoteJustification);
			String currency = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colExchangeRate);
			String totalAfterTaxAmt = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colTotalAfterTaxAmt);
			String totalAfterTaxHomeAmt = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colTotalAfterTaxHomeAmt);
			String remarksToCustomer = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colRemarksToCustomer);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBARCrn, colSegment4);

			if (!customerCode.isEmpty()) {
				onAccountsReceivableSteps.addNewCreditNote();

				onAccountsReceivableSteps.typeCustomerCode(customerCode);

				if (!creditNoteDate.isEmpty()) {
					onAccountsReceivableSteps.typeCreditNoteDate(creditNoteDate);
				}
				if (!salesPerson.isEmpty()) {
					onAccountsReceivableSteps.typeSalesPerson(salesPerson);
				}
				if (!referenceNo.isEmpty()) {
					onAccountsReceivableSteps.typeReferenceNo(referenceNo);
				}
				if (!creditNoteCategory.isEmpty()) {
					onAccountsReceivableSteps.typeCreditNoteCategory(creditNoteCategory);
				}
				if (!creditNoteJustification.isEmpty()) {
					onAccountsReceivableSteps.typeCreditNoteJustification(creditNoteJustification);
				}
				if (!currency.isEmpty()) {
					onAccountsReceivableSteps.typeCurrency(currency);
				}
				if (!exchangeRate.isEmpty()) {
					onAccountsReceivableSteps.typeExchangeRate(exchangeRate);
				}
				if (!totalAfterTaxAmt.isEmpty()) {
					onAccountsReceivableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
				}
				if (!totalAfterTaxHomeAmt.isEmpty()) {
					onAccountsReceivableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
				}
				if (!remarksToCustomer.isEmpty()) {
					onAccountsReceivableSteps.typeRemarksToCustomer(remarksToCustomer);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onAccountsReceivableSteps.setSegment(listSegment);

				onAccountsReceivableSteps.clickOnSubmitButton();
			}
		}
		onAccountsReceivableSteps.switchOutDefaultIFrame();
	}

	@When("^user create new credit note accounts receivable$")
	public void user_create_new_credit_note_accounts_receivable() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hCreditNoteColName = SessionData.getExcelColNameBySheetName(keyFileName, creditNoteSheet);

		int colCustomerCode = hCreditNoteColName.get("Customer Code");
		int colCreditNoteDate = hCreditNoteColName.get("Credit Note Date");
		int colSalesPerson = hCreditNoteColName.get("Sales Person");
		int colReferenceNo = hCreditNoteColName.get("Reference No");
		int colCreditNoteCategory = hCreditNoteColName.get("Credit Note Category");
		int colCreditNoteJustification = hCreditNoteColName.get("Credit Note Justification");
		int colCurrency = hCreditNoteColName.get("Currency");
		int colExchangeRate = hCreditNoteColName.get("Exchange Rate");
		int colTotalAfterTaxAmt = hCreditNoteColName.get("Total After Tax Amt");
		int colTotalAfterTaxHomeAmt = hCreditNoteColName.get("Total After Tax Home Amt");
		int colRemarksToCustomer = hCreditNoteColName.get("Remarks To Customer");
		int colSegment1 = hCreditNoteColName.get("Segment 1");
		int colSegment2 = hCreditNoteColName.get("Segment 2");
		int colSegment3 = hCreditNoteColName.get("Segment 3");
		int colSegment4 = hCreditNoteColName.get("Segment 4");

		String customerCode = "";
		String creditNoteDate = "";
		String salesPerson = "";
		String referenceNo = "";
		String creditNoteCategory = "";
		String creditNoteJustification = "";
		String currency = "";
		String exchangeRate = "";
		String totalAfterTaxAmt = "";
		String totalAfterTaxHomeAmt = "";
		String remarksToCustomer = "";
		String segment1 = "";
		String segment2 = "";
		String segment3 = "";
		String segment4 = "";

		boolean isSegment = onAccountsReceivableSteps.isSegment();
		LinkedHashMap<Integer, List<String>> getCreditNote = SessionData.getExcelSheetDataNoHeader(keyFileName,
				creditNoteSheet);

		onAccountsReceivableSteps.switchToIFrame();

		onAccountsReceivableSteps.moveToCreditNoteTab();
		for (Integer rowCreditNote : getCreditNote.keySet()) {
			customerCode = getCreditNote.get(rowCreditNote).get(colCustomerCode);
			creditNoteDate = getCreditNote.get(rowCreditNote).get(colCreditNoteDate);
			salesPerson = getCreditNote.get(rowCreditNote).get(colSalesPerson);
			referenceNo = getCreditNote.get(rowCreditNote).get(colReferenceNo);
			creditNoteCategory = getCreditNote.get(rowCreditNote).get(colCreditNoteCategory);
			creditNoteJustification = getCreditNote.get(rowCreditNote).get(colCreditNoteJustification);
			currency = getCreditNote.get(rowCreditNote).get(colCurrency);
			exchangeRate = getCreditNote.get(rowCreditNote).get(colExchangeRate);
			totalAfterTaxAmt = getCreditNote.get(rowCreditNote).get(colTotalAfterTaxAmt);
			totalAfterTaxHomeAmt = getCreditNote.get(rowCreditNote).get(colTotalAfterTaxHomeAmt);
			remarksToCustomer = getCreditNote.get(rowCreditNote).get(colRemarksToCustomer);
			segment1 = getCreditNote.get(rowCreditNote).get(colSegment1);
			segment2 = getCreditNote.get(rowCreditNote).get(colSegment2);
			segment3 = getCreditNote.get(rowCreditNote).get(colSegment3);
			segment4 = getCreditNote.get(rowCreditNote).get(colSegment4);
			onAccountsReceivableSteps.addNewCreditNote();
			if (!customerCode.isEmpty()) {
				onAccountsReceivableSteps.typeCustomerCode(customerCode);
			}
			if (!creditNoteDate.isEmpty()) {
				onAccountsReceivableSteps.typeCreditNoteDate(creditNoteDate);
			}
			if (!salesPerson.isEmpty()) {
				onAccountsReceivableSteps.typeSalesPerson(salesPerson);
			}
			if (!referenceNo.isEmpty()) {
				onAccountsReceivableSteps.typeReferenceNo(referenceNo);
			}
			if (!creditNoteCategory.isEmpty()) {
				onAccountsReceivableSteps.typeCreditNoteCategory(creditNoteCategory);
			}
			if (!creditNoteJustification.isEmpty()) {
				onAccountsReceivableSteps.typeCreditNoteJustification(creditNoteJustification);
			}
			if (!currency.isEmpty()) {
				onAccountsReceivableSteps.typeCurrency(currency);
			}
			if (!exchangeRate.isEmpty()) {
				onAccountsReceivableSteps.typeExchangeRate(exchangeRate);
			}
			if (!totalAfterTaxAmt.isEmpty()) {
				onAccountsReceivableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
			}
			if (!totalAfterTaxHomeAmt.isEmpty()) {
				onAccountsReceivableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
			}
			if (!remarksToCustomer.isEmpty()) {
				onAccountsReceivableSteps.typeRemarksToCustomer(remarksToCustomer);
			}
			if (isSegment) {
				if (!segment1.isEmpty()) {
					onAccountsReceivableSteps.typeSegment1(segment1);
				}
				if (!segment2.isEmpty()) {
					onAccountsReceivableSteps.typeSegment2(segment2);
				}
				if (!segment3.isEmpty()) {
					onAccountsReceivableSteps.typeSegment3(segment3);
				}
				if (!segment4.isEmpty()) {
					onAccountsReceivableSteps.typeSegment4(segment4);
				}
			}

			onAccountsReceivableSteps.clickOnSubmitButton();
		}
		onAccountsReceivableSteps.switchOutDefaultIFrame();
	}

	@When("^user create new invoice accounts receivable$")
	public void user_create_new_invoice_accounts_receivable() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hInvoiceColName = SessionData.getExcelColNameBySheetName(keyFileName, invoiceSheet);

		int colCustomerCode = hInvoiceColName.get("Customer Code");
		int colInvoiceDate = hInvoiceColName.get("Invoice Date");
		int colDueDate = hInvoiceColName.get("Due Date");
		int colSalesPerson = hInvoiceColName.get("Sales Person");
		int colReferenceNo = hInvoiceColName.get("Reference No");
		int colCurrency = hInvoiceColName.get("Currency");
		int colExchangeRate = hInvoiceColName.get("Exchange Rate");
		int colTotalAfterTaxAmt = hInvoiceColName.get("Total After Tax Amt");
		int colTotalAfterTaxHomeAmt = hInvoiceColName.get("Total After Tax Home Amt");
		int colSegment1 = hInvoiceColName.get("Segment 1");
		int colSegment2 = hInvoiceColName.get("Segment 2");
		int colSegment3 = hInvoiceColName.get("Segment 3");
		int colSegment4 = hInvoiceColName.get("Segment 4");

		String customerCode = "";
		String invoiceDate = "";
		String dueDate = "";
		String salesPerson = "";
		String referenceNo = "";
		String currency = "";
		String exchangeRate = "";
		String totalAfterTaxAmt = "";
		String totalAfterTaxHomeAmt = "";
		String segment1 = "";
		String segment2 = "";
		String segment3 = "";
		String segment4 = "";

		boolean isSegment = onAccountsReceivableSteps.isSegment();

		LinkedHashMap<Integer, List<String>> getInvoice = SessionData.getExcelSheetDataNoHeader(keyFileName,
				invoiceSheet);

		onAccountsReceivableSteps.switchToIFrame();

		onAccountsReceivableSteps.moveToInvoiceTab();
		for (Integer rowInvoice : getInvoice.keySet()) {
			customerCode = getInvoice.get(rowInvoice).get(colCustomerCode);
			invoiceDate = getInvoice.get(rowInvoice).get(colInvoiceDate);
			dueDate = getInvoice.get(rowInvoice).get(colDueDate);
			salesPerson = getInvoice.get(rowInvoice).get(colSalesPerson);
			referenceNo = getInvoice.get(rowInvoice).get(colReferenceNo);
			currency = getInvoice.get(rowInvoice).get(colCurrency);
			exchangeRate = getInvoice.get(rowInvoice).get(colExchangeRate);
			totalAfterTaxAmt = getInvoice.get(rowInvoice).get(colTotalAfterTaxAmt);
			totalAfterTaxHomeAmt = getInvoice.get(rowInvoice).get(colTotalAfterTaxHomeAmt);
			segment1 = getInvoice.get(rowInvoice).get(colSegment1);
			segment2 = getInvoice.get(rowInvoice).get(colSegment2);
			segment3 = getInvoice.get(rowInvoice).get(colSegment3);
			segment4 = getInvoice.get(rowInvoice).get(colSegment4);

			onAccountsReceivableSteps.addNewInvoice();
			if (!customerCode.isEmpty()) {
				onAccountsReceivableSteps.typeCustomerCode(customerCode);
			}
			if (!invoiceDate.isEmpty()) {
				onAccountsReceivableSteps.typeInvoiceDate(invoiceDate);
			}
			if (!dueDate.isEmpty()) {
				onAccountsReceivableSteps.typeDueDate(dueDate);
			}
			if (!salesPerson.isEmpty()) {
				onAccountsReceivableSteps.typeSalesPerson(salesPerson);
			}
			if (!referenceNo.isEmpty()) {
				onAccountsReceivableSteps.typeReferenceNo(referenceNo);
			}
			if (!currency.isEmpty()) {
				onAccountsReceivableSteps.typeCurrency(currency);
			}
			if (!exchangeRate.isEmpty()) {
				onAccountsReceivableSteps.typeExchangeRate(exchangeRate);
			}
			if (!totalAfterTaxAmt.isEmpty()) {
				onAccountsReceivableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
			}
			if (!totalAfterTaxHomeAmt.isEmpty()) {
				onAccountsReceivableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
			}

			if (isSegment) {
				if (!segment1.isEmpty()) {
					onAccountsReceivableSteps.typeSegment1(segment1);
				}
				if (!segment2.isEmpty()) {
					onAccountsReceivableSteps.typeSegment2(segment2);
				}
				if (!segment3.isEmpty()) {
					onAccountsReceivableSteps.typeSegment3(segment3);
				}
				if (!segment4.isEmpty()) {
					onAccountsReceivableSteps.typeSegment4(segment4);
				}
			}
			onAccountsReceivableSteps.clickOnSubmitButton();
		}
		onAccountsReceivableSteps.switchOutDefaultIFrame();
	}
}
