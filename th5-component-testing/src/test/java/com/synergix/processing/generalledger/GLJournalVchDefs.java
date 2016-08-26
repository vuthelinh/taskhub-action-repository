package com.synergix.processing.generalledger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.generalledger.steps.GLJournalVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class GLJournalVchDefs {
	@Steps
	GLJournalVchSteps onGLJournalVchSteps;

	String ssGLJV = "ssGLJournalVch";

	@When("^user create GL journal voucher as \"([^\"]*)\"$")
	public void user_create_GL_journal_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "GLJournalVch";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colType = "Type";
		String colVoucherNo = "Voucher No";
		String colDescription = "Description";
		String colVoucherDate = "Voucher Date";
		String colCurrency = "Currency";
		String colDocumentType = "Document Type";
		String colExchangeRateType = "Exchange Rate Type";
		String colExchangeRate = "Exchange Rate";
		String colDocumentNo = "Document No";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowGLJournalVch : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String type = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colType);
			String voucherNo = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colVoucherNo);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colDescription);
			String voucherDate = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colVoucherDate);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colCurrency);
			String documentType = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colDocumentType);
			String exchangeRateType = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colExchangeRateType);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colExchangeRate);
			String documentNo = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colDocumentNo);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment4);

			onGLJournalVchSteps.clickOnNewBtn();

			if (!type.isEmpty()) {
				onGLJournalVchSteps.chooseType(type);
			}

			if (!description.isEmpty()) {
				onGLJournalVchSteps.typeDescription(description);
			}
			if (!voucherDate.isEmpty())
				voucherDate = onGLJournalVchSteps.getToday();
			onGLJournalVchSteps.typeVoucherDate(voucherDate);

			if (!currency.isEmpty()) {
				onGLJournalVchSteps.typeCurrency(currency);
			}
			if (!documentType.isEmpty()) {
				onGLJournalVchSteps.typeDocumentType(documentType);
			}
			if (!exchangeRateType.isEmpty()) {
				onGLJournalVchSteps.chooseExchangeRateType(exchangeRateType);
			}
			if (!exchangeRate.isEmpty()) {
				onGLJournalVchSteps.typeExchangeRate(exchangeRate);
			}
			if (!documentNo.isEmpty()) {
				onGLJournalVchSteps.typeDocumentNo(documentNo);
			}

			List<String> listSegment = new ArrayList<String>();
			listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
					segment4));
			onGLJournalVchSteps.setSegment(listSegment);

			onGLJournalVchSteps.getVchNoToSession(ssGLJV);
		}
	}

	@When("^user update GL journal voucher as \"([^\"]*)\"$")
	public void user_update_GL_journal_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "GLJournalVch";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colType = "Type";
		String colVoucherNo = "Voucher No.";
		String colDescription = "Description";
		String colVoucherDate = "Voucher Date";
		String colCurrency = "Currency";
		String colDocumentType = "Document Type";
		String colExchangeRateType = "Exchange Rate Type";
		String colExchangeRate = "Exchange Rate";
		String colDocumentNo = "Document No";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowGLJournalVch : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String type = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colType);
			String voucherNo = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colVoucherNo);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colDescription);
			String voucherDate = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colVoucherDate);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colCurrency);
			String documentType = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colDocumentType);
			String exchangeRateType = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colExchangeRateType);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colExchangeRate);
			String documentNo = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colDocumentNo);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVch, colSegment4);

			if (onGLJournalVchSteps.searchVchNo(voucherNo)) {
				if (!type.isEmpty()) {
					onGLJournalVchSteps.chooseType(type);
				}
				if (!description.isEmpty()) {
					onGLJournalVchSteps.typeDescription(description);
				}
				if (!voucherDate.isEmpty()) {
					onGLJournalVchSteps.typeVoucherDate(voucherDate);
				}
				if (!currency.isEmpty()) {
					onGLJournalVchSteps.typeCurrency(currency);
				}
				if (!documentType.isEmpty()) {
					onGLJournalVchSteps.typeDocumentType(documentType);
				}
				if (!exchangeRateType.isEmpty()) {
					onGLJournalVchSteps
							.chooseExchangeRateType(exchangeRateType);
				}
				if (!exchangeRate.isEmpty()) {
					onGLJournalVchSteps.typeExchangeRate(exchangeRate);
				}
				if (!documentNo.isEmpty()) {
					onGLJournalVchSteps.typeDocumentNo(documentNo);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onGLJournalVchSteps.setSegment(listSegment);

				onGLJournalVchSteps.chooseDeleteAll();
				onGLJournalVchSteps.getVchNoToSession(ssGLJV);
			}
		}
	}

	@When("^GL journal voucher is added details as \"([^\"]*)\"$")
	public void GL_journal_voucher_is_added_details_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "GLJournalVchDet";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colGLAccountNo = "GL Account No.";
		String colRemark = "Remark";
		String colNatureDebit = "Nature Debit";
		String colHomeDebit = "Home Debit";
		String colNatureCredit = "Nature Credit";
		String colHomeCredit = "Home Credit";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";
		String colDelete = "Delete";

		int rowIndex = 0;

		for (int rowGLJournalVchDet : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String gLAccountNo = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colGLAccountNo);
			String remark = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colRemark);
			String natureDebit = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colNatureDebit);
			String homeDebit = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colHomeDebit);
			String natureCredit = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colNatureCredit);
			String homeCredit = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colHomeCredit);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colSegment4);
			String delete = SessionData.getDataTbVal(dataTableKey,
					rowGLJournalVchDet, colDelete);

			onGLJournalVchSteps.clickOnAddBtn();
			rowIndex += 1;

			if (!gLAccountNo.isEmpty()) {
				onGLJournalVchSteps.typeGLAccountNo(gLAccountNo, rowIndex);
			}
			if (!remark.isEmpty()) {
				onGLJournalVchSteps.typeRemark(remark, rowIndex);
			}
			if (!natureDebit.isEmpty()) {
				onGLJournalVchSteps.typeNatureDebit(natureDebit, rowIndex);
			}
			if (!homeDebit.isEmpty()) {
				onGLJournalVchSteps.typeHomeDebit(homeDebit, rowIndex);
			}
			if (!natureCredit.isEmpty()) {
				onGLJournalVchSteps.typeNatureCredit(natureCredit, rowIndex);
			}
			if (!homeCredit.isEmpty()) {
				onGLJournalVchSteps.typeHomeCredit(homeCredit, rowIndex);
			}
			if (!delete.isEmpty()) {
				onGLJournalVchSteps.chooseDelete(delete, rowIndex);
				rowIndex -= 1;
			}

			List<String> listSegment = new ArrayList<String>();
			listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
					segment4));
			onGLJournalVchSteps.setSegment(listSegment, rowIndex);
		}
	}

	@When("^GL journal voucher is submitted$")
	public void GL_journal_voucher_is_submitted() {
		onGLJournalVchSteps.clickOnSubmitBtn();
	}

	@When("^GL journal voucher is previewed with report name \"([^\"]*)\"$")
	public void GL_journal_voucher_is_previewed_with_report_name(
			String reportName) {
		onGLJournalVchSteps.clickOnPreview(reportName);
	}

	@When("^GL journal voucher is previewed at history tab with report name \"([^\"]*)\"$")
	public void GL_journal_voucher_is_previewed_at_hostiry_tab_with_report_name(
			String reportName) {
		String vchNo = onGLJournalVchSteps.getDataWithSession(ssGLJV);
		onGLJournalVchSteps.clickPreviewHST(vchNo, reportName);
	}
}
