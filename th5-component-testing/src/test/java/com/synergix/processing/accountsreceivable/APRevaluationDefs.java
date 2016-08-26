package com.synergix.processing.accountsreceivable;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APRevaluationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APRevaluationDefs {
	@Steps
	APRevaluationSteps onAPRevaluationSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	@When("^user create AP revaluation as \"([^\"]*)\"$")
	public void user_create_AP_revaluation_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APRevaluation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colRevaluationVoucherNo = "Revaluation Voucher No.";
		String colRevaluationVoucherDate = "Revaluation Voucher Date";
		String colDescription = "Description";

		for (int rowAPRevaluation : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String revaluationVoucherNo = SessionData.getDataTbVal(
					dataTableKey, rowAPRevaluation, colRevaluationVoucherNo);
			String revaluationVoucherDate = SessionData.getDataTbVal(
					dataTableKey, rowAPRevaluation, colRevaluationVoucherDate);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowAPRevaluation, colDescription);

			onAPRevaluationSteps.clickOnNewBtn();
			if (revaluationVoucherDate.isEmpty()) {
				revaluationVoucherDate = onAPRevaluationSteps.getToday();
			}
			onAPRevaluationSteps
					.typeRevaluationVoucherDate(revaluationVoucherDate);

			if (!description.isEmpty()) {
				onAPRevaluationSteps.typeDescription(description);
			}
			isContinue = true;
			isUpdate = false;
		}
	}

	@When("^user update AP revaluation as \"([^\"]*)\"$")
	public void user_update_AP_revaluation_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APRevaluationUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colRevaluationVoucherNo = "Revaluation Voucher No.";
		String colRevaluationVoucherDate = "Revaluation Voucher Date";
		String colDescription = "Description";

		for (int rowAPRevaluation : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String revaluationVoucherNo = SessionData.getDataTbVal(
					dataTableKey, rowAPRevaluation, colRevaluationVoucherNo);
			String revaluationVoucherDate = SessionData.getDataTbVal(
					dataTableKey, rowAPRevaluation, colRevaluationVoucherDate);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowAPRevaluation, colDescription);

			if (onAPRevaluationSteps.searchDrafVoucherNo(revaluationVoucherNo)) {
				if (!revaluationVoucherDate.isEmpty()) {
					onAPRevaluationSteps
							.typeRevaluationVoucherDate(revaluationVoucherDate);
				}
				if (!description.isEmpty()) {
					onAPRevaluationSteps.typeDescription(description);
				}
				isContinue = true;
				isUpdate = true;
			}
		}
	}

	@When("^AP revalueation is added currency as \"([^\"]*)\"$")
	public void AP_revalueation_is_added_currency_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {

			int rowIndex = onAPRevaluationSteps.getRowCcyTb();
			if (rowIndex > 0 && !isUpdate) {
				onAPRevaluationSteps.chooseDelAllCurrency();
				rowIndex = 0;
			}
			String dataTableKey = "APRevaluationCcy";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEY = "KEY";
			String colCurrency = "Currency";
			String colExchRate = "Exch Rate";
			String colDel = "Del";

			for (int rowAPRevaluationCcy : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
					.keySet()) {
				String currency = SessionData.getDataTbVal(dataTableKey,
						rowAPRevaluationCcy, colCurrency);
				String exchRate = SessionData.getDataTbVal(dataTableKey,
						rowAPRevaluationCcy, colExchRate);
				String del = SessionData.getDataTbVal(dataTableKey,
						rowAPRevaluationCcy, colDel);

				if (!currency.isEmpty()) {
					onAPRevaluationSteps.clickOnAddBtn();
					rowIndex += 1;

					onAPRevaluationSteps.typeCurrency(currency, rowIndex);

					if (!exchRate.isEmpty()) {
						onAPRevaluationSteps.typeExchRate(exchRate, rowIndex);
					}
					if (del.toLowerCase().equals("y")
							|| del.toLowerCase().equals("yes")) {
						onAPRevaluationSteps.chooseDel(del, rowIndex);
					}
				}
			}
		}
	}

	@When("^AP revaluation is submitted$")
	public void AP_revaluation_is_submitted() {
		if (isContinue) {
			onAPRevaluationSteps.clickOnUpdateBtn();
		}
	}
}
