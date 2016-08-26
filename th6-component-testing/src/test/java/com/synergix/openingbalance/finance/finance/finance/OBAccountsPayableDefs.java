package com.synergix.openingbalance.finance.finance.finance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.steps.AccountsPayableSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OBAccountsPayableDefs {

	@Steps
	AccountsPayableSteps onAccountsPayableSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_OPENING_BALANCE + "AccountsPayable.xls";
	String keyFileName = "AccountsPayable";
	String invoiceSheet = "Invoice";
	String creditNoteSheet = "Credit Note";

	@When("^user create invoice ap as \"([^\"]*)\"$")
	public void user_create_invoice_ap_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "OBAPInvoice";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYOBAPINV = "KEY OBAPINV";
		String colSupplierCode = "Supplier Code";
		String colSupplierInvoiceNo = "Supplier Invoice No";
		String colSupplierInvoiceDate = "Supplier Invoice Date";
		String colPostingDate = "Posting Date";
		String colDueDate = "Due Date";
		String colReferenceNo = "Reference No";
		String colCurrency = "Currency";
		String colExchangeRate = "Exchange Rate";
		String colTotalAfterTaxAmt = "Total After Tax Amt";
		String colTotalAfterTaxHomeAmt = "Total After Tax Home Amt";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onAccountsPayableSteps.switchToIFrame();

		onAccountsPayableSteps.moveToInvoiceTab();

		for (int rowOBAPInvoice : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBAPINV, dataKey)
				.keySet()) {
			String supplierCode = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSupplierCode);
			String supplierInvoiceNo = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSupplierInvoiceNo);
			String supplierInvoiceDate = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSupplierInvoiceDate);
			String postingDate = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colPostingDate);
			String dueDate = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colDueDate);
			String referenceNo = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colReferenceNo);
			String currency = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colExchangeRate);
			String totalAfterTaxAmt = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colTotalAfterTaxAmt);
			String totalAfterTaxHomeAmt = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice,
					colTotalAfterTaxHomeAmt);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBAPInvoice, colSegment4);

			List<String> listSegment = new ArrayList<>();
			listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

			if (!supplierCode.isEmpty()) {
				onAccountsPayableSteps.addNewInvoice();

				onAccountsPayableSteps.typeSupplierCode(supplierCode);

				if (!supplierInvoiceNo.isEmpty()) {
					onAccountsPayableSteps.typeSupplierInvoiceNo(supplierInvoiceNo);
				}
				if (!supplierInvoiceDate.isEmpty()) {
					onAccountsPayableSteps.typeSupplierInvoiceDate(supplierInvoiceDate);
				}
				if (postingDate.isEmpty())
					postingDate = onAccountsPayableSteps.getToday();
				onAccountsPayableSteps.typePostingDate(postingDate);

				if (!dueDate.isEmpty()) {
					onAccountsPayableSteps.typeDueDate(dueDate);
				}
				if (!referenceNo.isEmpty()) {
					onAccountsPayableSteps.typeReferenceNo(referenceNo);
				}
				if (!currency.isEmpty()) {
					onAccountsPayableSteps.typeCurrency(currency);
				}
				if (!exchangeRate.isEmpty()) {
					onAccountsPayableSteps.typeExchangeRate(exchangeRate);
				}
				if (!totalAfterTaxAmt.isEmpty()) {
					onAccountsPayableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
				}
				if (!totalAfterTaxHomeAmt.isEmpty()) {
					onAccountsPayableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
				}

				onAccountsPayableSteps.setSegment(listSegment);
				onAccountsPayableSteps.clickOnSubmit();
			}
		}
		onAccountsPayableSteps.switchOutDefaultIFrame();
	}

	@When("^user create credit note ap as \"([^\"]*)\"$")
	public void user_create_credit_note_ap_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "OBAPCrn";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYOBAPCRN = "KEY OBAPCRN";
		String colSupplierCode = "Supplier Code";
		String colSupplierCreditNoteNo = "Supplier Credit Note No";
		String colSupplierCreditNoteDate = "Supplier Credit Note Date";
		String colPostingDate = "Posting Date";
		String colReferenceNo = "Reference No";
		String colCreditNoteCategory = "Credit Note Category";
		String colCreditNoteJustification = "Credit Note Justification";
		String colCurrency = "Currency";
		String colExchangeRate = "Exchange Rate";
		String colTotalAfterTaxAmt = "Total After Tax Amt";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";
		String colTotalAfterTaxHomeAmt = "Total After Tax Home Amt";

		onAccountsPayableSteps.switchToIFrame();

		onAccountsPayableSteps.moveToCreditNoteTab();

		for (int rowOBAPCrn : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBAPCRN, dataKey).keySet()) {
			String supplierCode = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colSupplierCode);
			String supplierCreditNoteNo = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colSupplierCreditNoteNo);
			String supplierCreditNoteDate = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn,
					colSupplierCreditNoteDate);
			String postingDate = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colPostingDate);
			String referenceNo = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colReferenceNo);
			String creditNoteCategory = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colCreditNoteCategory);
			String creditNoteJustification = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn,
					colCreditNoteJustification);
			String currency = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colExchangeRate);
			String totalAfterTaxAmt = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colTotalAfterTaxAmt);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colSegment4);
			String totalAfterTaxHomeAmt = SessionData.getDataTbVal(dataTableKey, rowOBAPCrn, colTotalAfterTaxHomeAmt);

			if (!supplierCode.isEmpty()) {

				onAccountsPayableSteps.addNewCreditNote();

				onAccountsPayableSteps.typeSupplierCode(supplierCode);

				if (!supplierCreditNoteNo.isEmpty()) {
					onAccountsPayableSteps.typeSupplierCreditNoteNo(supplierCreditNoteNo);
				}
				if (!supplierCreditNoteDate.isEmpty()) {
					onAccountsPayableSteps.typeSupplierCreditNoteDate(supplierCreditNoteDate);
				}
				if (postingDate.isEmpty())
					postingDate = onAccountsPayableSteps.getToday();

				onAccountsPayableSteps.typePostingDate(postingDate);

				if (!referenceNo.isEmpty()) {
					onAccountsPayableSteps.typeReferenceNo(referenceNo);
				}
				if (!creditNoteCategory.isEmpty()) {
					onAccountsPayableSteps.typeCreditNoteCategory(creditNoteCategory);
				}
				if (!creditNoteJustification.isEmpty()) {
					onAccountsPayableSteps.typeCreditNoteJustification(creditNoteJustification);
				}
				if (!currency.isEmpty()) {
					onAccountsPayableSteps.typeCurrency(currency);
				}
				if (!exchangeRate.isEmpty()) {
					onAccountsPayableSteps.typeExchangeRate(exchangeRate);
				}
				if (!totalAfterTaxAmt.isEmpty()) {
					onAccountsPayableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
				}
				if (!totalAfterTaxHomeAmt.isEmpty()) {
					onAccountsPayableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onAccountsPayableSteps.setSegment(listSegment);

				onAccountsPayableSteps.clickOnSubmit();
			}
		}
		onAccountsPayableSteps.switchOutDefaultIFrame();
	}

	@When("^user create new invoice accounts payable$")
	public void user_create_new_invoice_accounts_payable() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hInvoiceColName = SessionData.getExcelColNameBySheetName(keyFileName, invoiceSheet);

		int colSupplierCode = hInvoiceColName.get("Supplier Code");
		int colSupplierInvoiceNo = hInvoiceColName.get("Supplier Invoice No");
		int colSupplierInvoiceDate = hInvoiceColName.get("Supplier Invoice Date");
		int colPostingDate = hInvoiceColName.get("Posting Date");
		int colDueDate = hInvoiceColName.get("Due Date");
		int colReferenceNo = hInvoiceColName.get("Reference No");
		int colCurrency = hInvoiceColName.get("Currency");
		int colExchangeRate = hInvoiceColName.get("Exchange Rate");
		int colTotalAfterTaxAmt = hInvoiceColName.get("Total After Tax Amt");
		int colTotalAfterTaxHomeAmt = hInvoiceColName.get("Total After Tax Home Amt");
		int colSegment1 = hInvoiceColName.get("Segment 1");
		int colSegment2 = hInvoiceColName.get("Segment 2");
		int colSegment3 = hInvoiceColName.get("Segment 3");
		int colSegment4 = hInvoiceColName.get("Segment 4");

		String supplierCode = "";
		String supplierInvoiceNo = "";
		String supplierInvoiceDate = "";
		String postingDate = "";
		String dueDate = "";
		String referenceNo = "";
		String currency = "";
		String exchangeRate = "";
		String totalAfterTaxAmt = "";
		String totalAfterTaxHomeAmt = "";
		String segment1 = "";
		String segment2 = "";
		String segment3 = "";
		String segment4 = "";

		LinkedHashMap<Integer, List<String>> getInvoice = SessionData.getExcelSheetDataNoHeader(keyFileName,
				invoiceSheet);

		onAccountsPayableSteps.switchToIFrame();

		onAccountsPayableSteps.moveToInvoiceTab();
		for (Integer rowInvoice : getInvoice.keySet()) {
			supplierCode = getInvoice.get(rowInvoice).get(colSupplierCode);
			supplierInvoiceNo = getInvoice.get(rowInvoice).get(colSupplierInvoiceNo);
			supplierInvoiceDate = getInvoice.get(rowInvoice).get(colSupplierInvoiceDate);
			postingDate = getInvoice.get(rowInvoice).get(colPostingDate);
			dueDate = getInvoice.get(rowInvoice).get(colDueDate);
			referenceNo = getInvoice.get(rowInvoice).get(colReferenceNo);
			currency = getInvoice.get(rowInvoice).get(colCurrency);
			exchangeRate = getInvoice.get(rowInvoice).get(colExchangeRate);
			totalAfterTaxAmt = getInvoice.get(rowInvoice).get(colTotalAfterTaxAmt);
			totalAfterTaxHomeAmt = getInvoice.get(rowInvoice).get(colTotalAfterTaxHomeAmt);
			segment1 = getInvoice.get(rowInvoice).get(colSegment1);
			segment2 = getInvoice.get(rowInvoice).get(colSegment2);
			segment3 = getInvoice.get(rowInvoice).get(colSegment3);
			segment4 = getInvoice.get(rowInvoice).get(colSegment4);

			onAccountsPayableSteps.addNewInvoice();
			if (!supplierCode.isEmpty()) {
				onAccountsPayableSteps.typeSupplierCode(supplierCode);
			}
			if (!supplierInvoiceNo.isEmpty()) {
				onAccountsPayableSteps.typeSupplierInvoiceNo(supplierInvoiceNo);
			}
			if (!supplierInvoiceDate.isEmpty()) {
				onAccountsPayableSteps.typeSupplierInvoiceDate(supplierInvoiceDate);
			}
			if (postingDate.isEmpty())
				postingDate = onAccountsPayableSteps.getToday();
			onAccountsPayableSteps.typePostingDate(postingDate);

			if (!dueDate.isEmpty()) {
				onAccountsPayableSteps.typeDueDate(dueDate);
			}
			if (!referenceNo.isEmpty()) {
				onAccountsPayableSteps.typeReferenceNo(referenceNo);
			}
			if (!currency.isEmpty()) {
				onAccountsPayableSteps.typeCurrency(currency);
			}
			if (!exchangeRate.isEmpty()) {
				onAccountsPayableSteps.typeExchangeRate(exchangeRate);
			}
			if (!totalAfterTaxAmt.isEmpty()) {
				onAccountsPayableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
			}
			if (!totalAfterTaxHomeAmt.isEmpty()) {
				onAccountsPayableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
			}

			List<String> listSegment = new ArrayList<>();
			listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

			onAccountsPayableSteps.setSegment(listSegment);
			onAccountsPayableSteps.clickOnSubmit();
		}
		onAccountsPayableSteps.switchOutDefaultIFrame();
	}

	@When("^user create new credit note accounts payable$")
	public void user_create_new_credit_note_accounts_payable() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hCreditNoteColName = SessionData.getExcelColNameBySheetName(keyFileName, creditNoteSheet);

		int colSupplierCode = hCreditNoteColName.get("Supplier Code");
		int colSupplierCreditNoteNo = hCreditNoteColName.get("Supplier Credit Note No");
		int colSupplierCreditNoteDate = hCreditNoteColName.get("Supplier Credit Note Date");
		int colPostingDate = hCreditNoteColName.get("Posting Date");
		int colReferenceNo = hCreditNoteColName.get("Reference No");
		int colCreditNoteCategory = hCreditNoteColName.get("Credit Note Category");
		int colCreditNoteJustification = hCreditNoteColName.get("Credit Note Justification");
		int colCurrency = hCreditNoteColName.get("Currency");
		int colExchangeRate = hCreditNoteColName.get("Exchange Rate");
		int colTotalAfterTaxAmt = hCreditNoteColName.get("Total After Tax Amt");
		int colTotalAfterTaxHomeAmt = hCreditNoteColName.get("Total After Tax Home Amt");
		int colSegment1 = hCreditNoteColName.get("Segment 1");
		int colSegment2 = hCreditNoteColName.get("Segment 2");
		int colSegment3 = hCreditNoteColName.get("Segment 3");
		int colSegment4 = hCreditNoteColName.get("Segment 4");

		String supplierCode = "";
		String supplierCreditNoteNo = "";
		String supplierCreditNoteDate = "";
		String postingDate = "";
		String referenceNo = "";
		String creditNoteCategory = "";
		String creditNoteJustification = "";
		String currency = "";
		String exchangeRate = "";
		String totalAfterTaxAmt = "";
		String totalAfterTaxHomeAmt = "";
		String segment1 = "";
		String segment2 = "";
		String segment3 = "";
		String segment4 = "";

		boolean isSegment = onAccountsPayableSteps.checkSegment();

		LinkedHashMap<Integer, List<String>> getCreditNote = SessionData.getExcelSheetDataNoHeader(keyFileName,
				creditNoteSheet);

		onAccountsPayableSteps.switchToIFrame();

		onAccountsPayableSteps.moveToCreditNoteTab();
		for (Integer rowCreditNote : getCreditNote.keySet()) {
			supplierCode = getCreditNote.get(rowCreditNote).get(colSupplierCode);
			supplierCreditNoteNo = getCreditNote.get(rowCreditNote).get(colSupplierCreditNoteNo);
			supplierCreditNoteDate = getCreditNote.get(rowCreditNote).get(colSupplierCreditNoteDate);
			postingDate = getCreditNote.get(rowCreditNote).get(colPostingDate);
			referenceNo = getCreditNote.get(rowCreditNote).get(colReferenceNo);
			creditNoteCategory = getCreditNote.get(rowCreditNote).get(colCreditNoteCategory);
			creditNoteJustification = getCreditNote.get(rowCreditNote).get(colCreditNoteJustification);
			currency = getCreditNote.get(rowCreditNote).get(colCurrency);
			exchangeRate = getCreditNote.get(rowCreditNote).get(colExchangeRate);
			totalAfterTaxAmt = getCreditNote.get(rowCreditNote).get(colTotalAfterTaxAmt);
			totalAfterTaxHomeAmt = getCreditNote.get(rowCreditNote).get(colTotalAfterTaxHomeAmt);
			segment1 = getCreditNote.get(rowCreditNote).get(colSegment1);
			segment2 = getCreditNote.get(rowCreditNote).get(colSegment2);
			segment3 = getCreditNote.get(rowCreditNote).get(colSegment3);
			segment4 = getCreditNote.get(rowCreditNote).get(colSegment4);

			onAccountsPayableSteps.addNewCreditNote();

			if (!supplierCode.isEmpty()) {
				onAccountsPayableSteps.typeSupplierCode(supplierCode);
			}
			if (!supplierCreditNoteNo.isEmpty()) {
				onAccountsPayableSteps.typeSupplierCreditNoteNo(supplierCreditNoteNo);
			}
			if (!supplierCreditNoteDate.isEmpty()) {
				onAccountsPayableSteps.typeSupplierCreditNoteDate(supplierCreditNoteDate);
			}
			if (postingDate.isEmpty())
				postingDate = onAccountsPayableSteps.getToday();
			onAccountsPayableSteps.typePostingDate(postingDate);

			if (!referenceNo.isEmpty()) {
				onAccountsPayableSteps.typeReferenceNo(referenceNo);
			}
			if (!creditNoteCategory.isEmpty()) {
				onAccountsPayableSteps.typeCreditNoteCategory(creditNoteCategory);
			}
			if (!creditNoteJustification.isEmpty()) {
				onAccountsPayableSteps.typeCreditNoteJustification(creditNoteJustification);
			}
			if (!currency.isEmpty()) {
				onAccountsPayableSteps.typeCurrency(currency);
			}
			if (!exchangeRate.isEmpty()) {
				onAccountsPayableSteps.typeExchangeRate(exchangeRate);
			}
			if (!totalAfterTaxAmt.isEmpty()) {
				onAccountsPayableSteps.typeTotalAfterTaxAmt(totalAfterTaxAmt);
			}
			if (!totalAfterTaxHomeAmt.isEmpty()) {
				onAccountsPayableSteps.typeTotalAfterTaxHomeAmt(totalAfterTaxHomeAmt);
			}

			if (isSegment) {
				if (!segment1.isEmpty()) {
					onAccountsPayableSteps.typeSegment1(segment1);
				}
				if (!segment2.isEmpty()) {
					onAccountsPayableSteps.typeSegment2(segment2);
				}
				if (!segment3.isEmpty()) {
					onAccountsPayableSteps.typeSegment3(segment3);
				}
				if (!segment4.isEmpty()) {
					onAccountsPayableSteps.typeSegment4(segment4);
				}
			}
			onAccountsPayableSteps.clickOnSubmit();
		}
		onAccountsPayableSteps.switchOutDefaultIFrame();
	}
}
