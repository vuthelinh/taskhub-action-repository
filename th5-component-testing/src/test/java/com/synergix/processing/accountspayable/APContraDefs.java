package com.synergix.processing.accountspayable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APContraSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APContraDefs {
	@Steps
	APContraSteps onAPContraSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssContraVch = "ContraVchNo";

	@When("^user create AP contra as \"([^\"]*)\"$")
	public void user_create_AP_contra_as(String dataKey,
			List<List<String>> dataTable) {

		String dataTableKey = "APContra";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colContraVoucherNo = "Contra Voucher No.";
		String colParty = "Party";

		

		for (int rowBKTransactionVchWDetails : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String contraVoucherNo = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVchWDetails, colContraVoucherNo);
			String party = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVchWDetails, colParty);

			onAPContraSteps.clickOnNewBtn();
			if (!party.isEmpty()) {
				onAPContraSteps.typeParty(party);
			}
			isContinue = true;
			isUpdate = false;
		}
		
	}

	@When("^user update AP contra as \"([^\"]*)\"$")
	public void user_update_AP_contra_as(String dataKey,
			List<List<String>> dataTable) {

		String dataTableKey = "APContraUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colContraVoucherNo = "Contra Voucher No.";
		String colParty = "Party";

		

		for (int rowBKTransactionVchWDetails : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String contraVoucherNo = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVchWDetails, colContraVoucherNo);
			String party = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVchWDetails, colParty);

			if (onAPContraSteps.searchDrafVoucherNo(contraVoucherNo)) {
				if (!party.isEmpty()) {
					onAPContraSteps.typeParty(party);
				}
				isContinue = true;
				isUpdate = true;
			}
		}
		
	}

	@When("^AP contra is added info at header tab as \"([^\"]*)\"$")
	public void AP_contra_is_added_info_at_header_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APContraHeader";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colContraVoucherDate = "Contra Voucher Date";
			String colCurrency = "Currency";
			String colExchRateBuyRate = "Exch Rate - Buy Rate";
			String colExchRateSellRate = "Exch Rate - Sell Rate";
			String colRemarksCode = "Remarks Code";
			String colRemarks = "Remarks";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			

			for (int rowAPContraHeader : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String contraVoucherDate = SessionData.getDataTbVal(
						dataTableKey, rowAPContraHeader, colContraVoucherDate);
				String currency = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colCurrency);
				String exchRateBuyRate = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colExchRateBuyRate);
				String exchRateSellRate = SessionData.getDataTbVal(
						dataTableKey, rowAPContraHeader, colExchRateSellRate);
				String remarksCode = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colRemarksCode);
				String remarks = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colRemarks);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowAPContraHeader, colSegment4);

				onAPContraSteps.moveToHeaderTab();

				if (contraVoucherDate.isEmpty()) {
					contraVoucherDate = onAPContraSteps.getToday();
				}
				onAPContraSteps.chooseContraVoucherDate(contraVoucherDate);

				if (!currency.isEmpty()) {
					onAPContraSteps.typeCurrency(currency);
				}
				if (!exchRateBuyRate.isEmpty()) {
					onAPContraSteps.typeExchRateBuyRate(exchRateBuyRate);
				}
				if (!exchRateSellRate.isEmpty()) {
					onAPContraSteps.typeExchRateSellRate(exchRateSellRate);
				}
				if (!remarksCode.isEmpty()) {
					onAPContraSteps.typeRemarksCode(remarksCode);
				}
				if (!remarks.isEmpty()) {
					onAPContraSteps.typeRemarks(remarks);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPContraSteps.setSegment(listSegment);
			}
			
		}
	}

	@When("^AP contra is added info at AR invoice tab as \"([^\"]*)\"$")
	public void AP_contra_is_added_info_at_AR_invoice_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APContraAR";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colInvoiceNo = "Invoice No.";
			String colInvoiceDate = "Invoice Date";
			String colDueDate = "Due Date";
			String colInvCcyRefNo = "Inv Ccy Ref No.";
			String coldInvAmtHomeAmt = "d Inv Amt Home Amt";
			String colApplyFull = "Apply Full";

			
			onAPContraSteps.moveToARInvoiceTab();

			for (int rowAPContraAR : SessionData.getDataTbRowsByValEqualInCol(
					dataTableKey, colKEY, dataKey).keySet()) {
				String invoiceNo = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAR, colInvoiceNo);
				String invoiceDate = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAR, colInvoiceDate);
				String dueDate = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAR, colDueDate);
				String invCcyRefNo = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAR, colInvCcyRefNo);
				String dInvAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAR, coldInvAmtHomeAmt);
				String applyFull = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAR, colApplyFull);

				int rowIndex = onAPContraSteps.typeARInvoiceNo(invoiceNo);
				System.out.println("***[NANCY]*** ROW AR INDEX: " + rowIndex);

				if (rowIndex > 0) {
					if (!dInvAmtHomeAmt.isEmpty()) {
						onAPContraSteps.typeARdInvAmtHomeAmt(dInvAmtHomeAmt,
								rowIndex);
					}
					if (applyFull.toLowerCase().equals("y")) {
						onAPContraSteps.chooseARApplyFull(applyFull, rowIndex);
					}
				} else {
					if (!invoiceDate.isEmpty()) {
						onAPContraSteps.typeInvoiceDate(invoiceDate);
					}
					if (!dueDate.isEmpty()) {
						onAPContraSteps.typeDueDate(dueDate);
					}
					if (!invCcyRefNo.isEmpty()) {
						onAPContraSteps.typeARInvCcyRefNo(invCcyRefNo);
					}
				}
			}
			
		}
	}

	@When("^AP contra is added info at AP invoice tab as \"([^\"]*)\"$")
	public void AP_contra_is_added_info_at_AP_invoice_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APContraAP";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colInvNo = "Inv No.";
			String colSupInvNo = "Sup Inv No";
			String colAgeDate = "Age Date";
			String colInvCcyRefNo = "Inv Ccy Ref No";
			String coldInvAmtHomeAmt = "d Inv Amt Home Amt";
			String colApplyFull = "Apply Full";

			
			onAPContraSteps.moveToAPInvoiceTab();

			for (int rowAPContraAP : SessionData.getDataTbRowsByValEqualInCol(
					dataTableKey, colKEY, dataKey).keySet()) {
				String invNo = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAP, colInvNo);
				String supInvNo = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAP, colSupInvNo);
				String ageDate = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAP, colAgeDate);
				String invCcyRefNo = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAP, colInvCcyRefNo);
				String dInvAmtHomeAmt = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAP, coldInvAmtHomeAmt);
				String applyFull = SessionData.getDataTbVal(dataTableKey,
						rowAPContraAP, colApplyFull);

				int rowIndex = onAPContraSteps.typeAPInvNo(invNo);
				if (rowIndex > 0) {

					if (!dInvAmtHomeAmt.isEmpty()) {
						onAPContraSteps.typeAPdInvAmtHomeAmt(dInvAmtHomeAmt,
								rowIndex);
					}
					if (applyFull.toLowerCase().equals("y")) {
						onAPContraSteps.chooseAPApplyFull(applyFull, rowIndex);
					}
				}
				if (!ageDate.isEmpty()) {
					onAPContraSteps.typeAgeDate(ageDate);
				}
				if (!invCcyRefNo.isEmpty()) {
					onAPContraSteps.typeAPInvCcyRefNo(invCcyRefNo);
				}
			}
			
		}
	}

	@When("^AP contra is submitted$")
	public void AP_contra_is_submitted() {
		if (isContinue) {
			
			onAPContraSteps.getVchNo(ssContraVch);
			onAPContraSteps.clickOnSubmitBtn();
			
		}
	}

	@When("^AP contra is previewed with report name as \"([^\"]*)\"$")
	public void AP_contra_is_previewed_with_report_name_as(String reportName) {
		if (isContinue) {
			
			onAPContraSteps.clickPreviewBtn(reportName);
			
		}
	}

	@When("^AP contra is previewed history with report name as \"([^\"]*)\"$")
	public void AP_contra_is_previewed_History_with_report_name_as(
			String reportName) {
		isContinue = true;
		if (isContinue) {
			
			onAPContraSteps.moveToHSTTab();

			String voucherNo = onAPContraSteps.getDataWithSession(ssContraVch);

			onAPContraSteps.clickPreviewHSTBtn(voucherNo, reportName);
			
		}
	}
}
