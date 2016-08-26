package com.synergix.processing.bankbook;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.bankbook.steps.BKRevaluationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class BKRevaluationDefs {
	@Steps
	BKRevaluationSteps onBKRevaluationSteps;

	@When("^user create BK revaluation as \"([^\"]*)\"$")
	public void user_create_BK_revaluation_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "BKRevaluation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colRevaluationVoucherDate = "Revaluation Voucher Date";
		String colCurrency = "Currency";
		String colExchangeRate = "Exchange Rate";
		String colDescription = "Description";

		for (int rowBKRevaluation : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String revaluationVoucherDate = SessionData.getDataTbVal(
					dataTableKey, rowBKRevaluation, colRevaluationVoucherDate);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowBKRevaluation, colCurrency);
			String exchangeRate = SessionData.getDataTbVal(dataTableKey,
					rowBKRevaluation, colExchangeRate);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowBKRevaluation, colDescription);

			onBKRevaluationSteps.clickOnNewBtn();

			if (!revaluationVoucherDate.isEmpty()) {
				onBKRevaluationSteps
						.typeRevaluationVoucherDate(revaluationVoucherDate);
			}
			if (!currency.isEmpty()) {
				onBKRevaluationSteps.typeCurrency(currency);
			}
			if (!exchangeRate.isEmpty()) {
				onBKRevaluationSteps.typeExchangeRate(exchangeRate);
			}
			if (!description.isEmpty()) {
				onBKRevaluationSteps.typeDescription(description);
			}
		}
	}

	@When("^BK revaluation is add detail as \"([^\"]*)\"$")
	public void BK_revaluation_is_add_detail_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "BKRevaluationDet";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colGLAccountCode = "GL Account Code";

		for (int rowBKRevaluationDet : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String gLAccountCode = SessionData.getDataTbVal(dataTableKey,
					rowBKRevaluationDet, colGLAccountCode);

			onBKRevaluationSteps.clickOnAddBtn();
			if (!gLAccountCode.isEmpty()) {
				onBKRevaluationSteps.searchGLAccount(gLAccountCode);
			}
		}
	}

	@When("^BK revaluation is submitted$")
	public void BK_revaluation_is_submitted() {
		onBKRevaluationSteps.clickOnSubmitBtn();
	}
}
