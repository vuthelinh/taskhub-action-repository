package com.synergix.maintenancesetup.financial.currency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.mtsetup.financial.currency.steps.ExchangeRateSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTExchangeRateDefs {

	@Steps
	ExchangeRateSteps onExchangeRateSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_MT_FINANCIAL_CURRENCY + "ExchangeRate.xls";
	String keyFileName = "ExchangeRate";
	String exchangeRateSheet = "ExchangeRate";
	String addDetailSheet = "AddDetail";

	boolean isUpdate = false;

	// Delete all old data and add new data
	@When("^user set exchange rate as \"([^\"]*)\"$")
	public void user_set_exchange_rate_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "ExchangeRate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRATE = "KEY RATE";
		String colCurrency = "Currency";

		for (int rowExchangeRate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRATE, dataKey)
				.keySet()) {
			String currency = SessionData.getDataTbVal(dataTableKey, rowExchangeRate, colCurrency);
			if (!currency.isEmpty()) {
				onExchangeRateSteps.typeCurrency(currency);
				isUpdate = false;
			}
		}
	}

	// Keep old data and add new data, Finding solution
	@When("^user update exchange rate as \"([^\"]*)\"$")
	public void user_update_exchange_rate_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "ExchangeRate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRATE = "KEY RATE";
		String colCurrency = "Currency";

		for (int rowExchangeRate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRATE, dataKey)
				.keySet()) {
			String currency = SessionData.getDataTbVal(dataTableKey, rowExchangeRate, colCurrency);
			if (!currency.isEmpty()) {
				onExchangeRateSteps.typeCurrency(currency);
				isUpdate = true;
			}
		}
	}

	@When("^exchange rate is added date as \"([^\"]*)\"$")
	public void exchange_rate_is_added_date_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "DelExchangeRate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRATE = "KEY RATE";
		String colEffectiveDateFrom = "Effective Date From";
		String colEffectiveDateTo = "Effective Date To";
		String colUpwardsVarianceAllowed = "Upwards Variance Allowed";
		String colDownwardsVarianceAllowed = "Downwards Variance Allowed";
		String colBankSellRate = "Bank Sell Rate";
		String colBankBuyRate = "Bank Buy Rate";
		String colRevaluationRate = "Revaluation Rate";

		if (isUpdate) {
			// Finding solution =)))
		} else {
			if (onExchangeRateSteps.isExitData()) {
				onExchangeRateSteps.deleteOldRow();
			}

			for (int rowDelExchangeRate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRATE, dataKey)
					.keySet()) {

				String effectiveDateFrom = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate,
						colEffectiveDateFrom);
				String effectiveDateTo = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate, colEffectiveDateTo);
				String upwardsVarianceAllowed = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate,
						colUpwardsVarianceAllowed);
				String downwardsVarianceAllowed = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate,
						colDownwardsVarianceAllowed);
				String bankSellRate = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate, colBankSellRate);
				String bankBuyRate = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate, colBankBuyRate);
				String revaluationRate = SessionData.getDataTbVal(dataTableKey, rowDelExchangeRate, colRevaluationRate);

				onExchangeRateSteps.clickAddBtn();

				if (!effectiveDateFrom.isEmpty()) {
					onExchangeRateSteps.typeEffectiveDateFrom(effectiveDateFrom, 1);
				}
				if (!effectiveDateTo.isEmpty()) {
					onExchangeRateSteps.typeEffectiveDateTo(effectiveDateTo, 1);
				}
				if (!upwardsVarianceAllowed.isEmpty()) {
					onExchangeRateSteps.typeUpwardsVarianceAllowed(upwardsVarianceAllowed, 1);
				}
				if (!downwardsVarianceAllowed.isEmpty()) {
					onExchangeRateSteps.typeDownwardsVarianceAllowed(downwardsVarianceAllowed, 1);
				}
				if (!bankSellRate.isEmpty()) {
					onExchangeRateSteps.typeBankSellRate(bankSellRate, 1);
				}
				if (!bankBuyRate.isEmpty()) {
					onExchangeRateSteps.typeBankBuyRate(bankBuyRate, 1);
				}
				if (!revaluationRate.isEmpty()) {
					onExchangeRateSteps.typeRevaluationRate(revaluationRate, 1);
				}
			}
		}
	}

	@When("^user delete exchange rate as \"([^\"]*)\"$")
	public void user_delete_exchange_rate_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "DelExchangeRate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRATE = "KEY RATE";
		String colCurrency = "Currency";

		for (int rowExchangeRate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRATE, dataKey)
				.keySet()) {
			String currency = SessionData.getDataTbVal(dataTableKey, rowExchangeRate, colCurrency);
			if (!currency.isEmpty()) {
				onExchangeRateSteps.typeCurrency(currency);

				if (onExchangeRateSteps.isExitData()) {
					onExchangeRateSteps.deleteOldRow();
				}
			}
		}
	}

	@When("^user set exchange rate$")
	public void user_set_exchange_rate() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hExchangeRateColName = SessionData.getExcelColNameBySheetName(keyFileName,
				exchangeRateSheet);
		int colCurrency = hExchangeRateColName.get("Currency");
		int colSheet = hExchangeRateColName.get("Sheet");

		HashMap<String, Integer> hAddDetailColName = SessionData.getExcelColNameBySheetName(keyFileName, addDetailSheet);

		int colEffectiveDateFrom = hAddDetailColName.get("Effective Date From");
		int colEffectiveDateTo = hAddDetailColName.get("Effective Date To");
		int colUpwardsVarianceAllowed = hAddDetailColName.get("Upwards Variance Allowed");
		int colDownwardsVarianceAllowed = hAddDetailColName.get("Downwards Variance Allowed");
		int colBankSellRate = hAddDetailColName.get("Bank Sell Rate");
		int colBankBuyRate = hAddDetailColName.get("Bank Buy Rate");
		int colRevaluationRate = hAddDetailColName.get("Revaluation Rate");
		int colKey = hAddDetailColName.get("Key");

		String currency = "";
		String sheet = "";

		String effectiveDateFrom = "";
		String effectiveDateTo = "";
		String upwardsVarianceAllowed = "";
		String downwardsVarianceAllowed = "";
		String bankSellRate = "";
		String bankBuyRate = "";
		String revaluationRate = "";
		String key = "";

		LinkedHashMap<Integer, List<String>> getExchangeRate = SessionData.getExcelSheetDataNoHeader(keyFileName,
				exchangeRateSheet);
		for (Integer rowExchangeRate : getExchangeRate.keySet()) {
			currency = getExchangeRate.get(rowExchangeRate).get(colCurrency);
			sheet = getExchangeRate.get(rowExchangeRate).get(colSheet);

			if (!currency.isEmpty()) {
				onExchangeRateSteps.typeCurrency(currency);
			}

			boolean isDeleteOldRow = true;
			LinkedHashMap<Integer, List<String>> getAddDetail = SessionData.getExcelSheetDataNoHeader(keyFileName,
					addDetailSheet);
			for (Integer rowAddDetail : getAddDetail.keySet()) {
				key = getAddDetail.get(rowAddDetail).get(colKey);
				if (key.equals(sheet)) {
					effectiveDateFrom = getAddDetail.get(rowAddDetail).get(colEffectiveDateFrom);
					effectiveDateTo = getAddDetail.get(rowAddDetail).get(colEffectiveDateTo);
					upwardsVarianceAllowed = getAddDetail.get(rowAddDetail).get(colUpwardsVarianceAllowed);
					downwardsVarianceAllowed = getAddDetail.get(rowAddDetail).get(colDownwardsVarianceAllowed);
					bankSellRate = getAddDetail.get(rowAddDetail).get(colBankSellRate);
					bankBuyRate = getAddDetail.get(rowAddDetail).get(colBankBuyRate);
					revaluationRate = getAddDetail.get(rowAddDetail).get(colRevaluationRate);

					if (isDeleteOldRow) {
						// onExchangeRateSteps.deleteOldRow();
						isDeleteOldRow = false;
					}

					onExchangeRateSteps.clickAddBtn();
					if (!effectiveDateFrom.isEmpty()) {
						onExchangeRateSteps.typeEffectiveDateFrom(effectiveDateFrom, 1);
					}
					if (!effectiveDateTo.isEmpty()) {
						onExchangeRateSteps.typeEffectiveDateTo(effectiveDateTo, 1);
					}
					if (!upwardsVarianceAllowed.isEmpty()) {
						onExchangeRateSteps.typeUpwardsVarianceAllowed(upwardsVarianceAllowed, 1);
					}
					if (!downwardsVarianceAllowed.isEmpty()) {
						onExchangeRateSteps.typeDownwardsVarianceAllowed(downwardsVarianceAllowed, 1);
					}
					if (!bankSellRate.isEmpty()) {
						onExchangeRateSteps.typeBankSellRate(bankSellRate, 1);
					}
					if (!bankBuyRate.isEmpty()) {
						onExchangeRateSteps.typeBankBuyRate(bankBuyRate, 1);
					}
					if (!revaluationRate.isEmpty()) {
						onExchangeRateSteps.typeRevaluationRate(revaluationRate, 1);
					}
				}
			}

		}

	}
}
