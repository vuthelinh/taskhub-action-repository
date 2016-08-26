package com.synergix.mastersetup.finance.currency.currency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.financial.accounting.steps.CurrencySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLCurrencyDefs {
	@Steps
	CurrencySteps onGlobalCurrencySteps;

	String dataFilePath = System.getProperty("user.dir") + CONST.FIN_FINANCIAL + "Currency.xls";

	@When("^user delete currency$")
	public void user_delete_currency(List<List<String>> dataTable) {
		String dataTableKey = "DelCurrency";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colCurrency = "Currency";

		onGlobalCurrencySteps.switchToIFrame();

		for (int rowCurrency : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String currency = SessionData.getDataTbVal(dataTableKey, rowCurrency, colCurrency);
			if (!currency.isEmpty()) {
				onGlobalCurrencySteps.chooseDelCurrency(currency);
			}
		}
		onGlobalCurrencySteps.switchOutDefaultIFrame();
	}

	@When("^user create currency as \"([^\"]*)\"$")
	public void user_create_currency_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Currency";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYCURRENCY = "KEY CURRENCY";
		String colCurrency = "Currency";
		String colDescription = "Description";
		String colCurrencySymbol = "Currency Symbol";
		String colDollarinword = "Dollar in word";
		String colCentinword = "Cent in word";
		String colMinimumBankRate = "Minimum Bank Rate";
		String colMaximumBankRate = "Maximum Bank Rate";
		String colMaximumSpread = "Maximum Spread%";
		String colSpreadBase = "Spread % Base";
		String colCreditLimitExchangeRate = "Credit Limit Exchange Rate";
		String colCompany = "Company";

		onGlobalCurrencySteps.switchToIFrame();

		for (int rowCurrency : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCURRENCY, dataKey)
				.keySet()) {
			String currency = SessionData.getDataTbVal(dataTableKey, rowCurrency, colCurrency);
			String description = SessionData.getDataTbVal(dataTableKey, rowCurrency, colDescription);
			String currencySymbol = SessionData.getDataTbVal(dataTableKey, rowCurrency, colCurrencySymbol);
			String dollarinword = SessionData.getDataTbVal(dataTableKey, rowCurrency, colDollarinword);
			String centinword = SessionData.getDataTbVal(dataTableKey, rowCurrency, colCentinword);
			String minimumBankRate = SessionData.getDataTbVal(dataTableKey, rowCurrency, colMinimumBankRate);
			String maximumBankRate = SessionData.getDataTbVal(dataTableKey, rowCurrency, colMaximumBankRate);
			String maximumSpread = SessionData.getDataTbVal(dataTableKey, rowCurrency, colMaximumSpread);
			String spreadBase = SessionData.getDataTbVal(dataTableKey, rowCurrency, colSpreadBase);
			String creditLimitExchangeRate = SessionData.getDataTbVal(dataTableKey, rowCurrency,
					colCreditLimitExchangeRate);
			String company = SessionData.getDataTbVal(dataTableKey, rowCurrency, colCompany);

			if (!currency.isEmpty()) {
				onGlobalCurrencySteps.addNewCurency();

				onGlobalCurrencySteps.typeCurrency(currency);

				if (!description.isEmpty()) {
					onGlobalCurrencySteps.typeDescription(description);
				}
				if (!currencySymbol.isEmpty()) {
					onGlobalCurrencySteps.typeCurrencySymbol(currencySymbol);
				}
				if (!dollarinword.isEmpty()) {
					onGlobalCurrencySteps.typeDollarinword(dollarinword);
				}
				if (!centinword.isEmpty()) {
					onGlobalCurrencySteps.typeCentinword(centinword);
				}

				onGlobalCurrencySteps.moveToExchangeRateTab();

				if (!minimumBankRate.isEmpty()) {
					onGlobalCurrencySteps.typeMinimumBankRate(minimumBankRate);
				}
				if (!maximumBankRate.isEmpty()) {
					onGlobalCurrencySteps.typeMaximumBankRate(maximumBankRate);
				}
				if (!maximumSpread.isEmpty()) {
					onGlobalCurrencySteps.typeMaximumSpread(maximumSpread);
				}
				if (!spreadBase.isEmpty()) {
					onGlobalCurrencySteps.typeSpreadBase(spreadBase);
				}
				if (!creditLimitExchangeRate.isEmpty()) {
					onGlobalCurrencySteps.typeCreditLimitExchangeRate(creditLimitExchangeRate);
				}

				onGlobalCurrencySteps.moveToCompanyTab();

				if (company.trim().toLowerCase().equals("all")) {
					onGlobalCurrencySteps.checkAllCompany();

				} else
					onGlobalCurrencySteps.checkCompany(company);

				onGlobalCurrencySteps.clickOnUpdateButton();
			}
		}
		onGlobalCurrencySteps.switchOutDefaultIFrame();
	}

	@When("^user create Global Currency$")
	public void user_create_Global_Currency() {
		SessionData.addExcelData("Currency", dataFilePath);

		HashMap<String, Integer> hCurrencyColName = SessionData.getExcelColNameBySheetName("Currency", "Global Currency");
		int colCurrency = hCurrencyColName.get("Currency");
		int colDescription = hCurrencyColName.get("Description");
		int colCurrencySymbol = hCurrencyColName.get("Currency Symbol");
		int colDollarinword = hCurrencyColName.get("Dollar in word");
		int colCentinword = hCurrencyColName.get("Cent in word");
		int colMinimumBankRate = hCurrencyColName.get("Minimum Bank Rate");
		int colMaximumBankRate = hCurrencyColName.get("Maximum Bank Rate");
		int colMaximumSpread = hCurrencyColName.get("Maximum Spread%");
		int colSpreadBase = hCurrencyColName.get("Spread % Base");
		int colCreditLimitExchangeRate = hCurrencyColName.get("Credit Limit Exchange Rate");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName("Currency", "Company");
		int colKeyCurrency = hCompanyColName.get("Currency");
		int colCompany = hCompanyColName.get("Company");

		String currency = "";
		String description = "";
		String currencySymbol = "";
		String dollarinword = "";
		String centinword = "";
		String minimumBankRate = "";
		String maximumBankRate = "";
		String maximumSpread = "";
		String spreadBase = "";
		String creditLimitExchangeRate = "";

		String keyCurrency = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader("Currency",
				"Global Currency");

		onGlobalCurrencySteps.switchToIFrame();

		for (Integer row : getDataset.keySet()) {
			currency = getDataset.get(row).get(colCurrency);
			description = getDataset.get(row).get(colDescription);
			currencySymbol = getDataset.get(row).get(colCurrencySymbol);
			dollarinword = getDataset.get(row).get(colDollarinword);
			centinword = getDataset.get(row).get(colCentinword);
			minimumBankRate = getDataset.get(row).get(colMinimumBankRate);
			maximumBankRate = getDataset.get(row).get(colMaximumBankRate);
			maximumSpread = getDataset.get(row).get(colMaximumSpread);
			spreadBase = getDataset.get(row).get(colSpreadBase);
			creditLimitExchangeRate = getDataset.get(row).get(colCreditLimitExchangeRate);

			onGlobalCurrencySteps.addNewCurency();
			if (!currency.isEmpty()) {
				onGlobalCurrencySteps.typeCurrency(currency);
			}
			if (!description.isEmpty()) {
				onGlobalCurrencySteps.typeDescription(description);
			}
			if (!currencySymbol.isEmpty()) {
				onGlobalCurrencySteps.typeCurrencySymbol(currencySymbol);
			}
			if (!dollarinword.isEmpty()) {
				onGlobalCurrencySteps.typeDollarinword(dollarinword);
			}
			if (!centinword.isEmpty()) {
				onGlobalCurrencySteps.typeCentinword(centinword);
			}

			onGlobalCurrencySteps.moveToExchangeRateTab();

			if (!minimumBankRate.isEmpty()) {
				onGlobalCurrencySteps.typeMinimumBankRate(minimumBankRate);
			}
			if (!maximumBankRate.isEmpty()) {
				onGlobalCurrencySteps.typeMaximumBankRate(maximumBankRate);
			}
			if (!maximumSpread.isEmpty()) {
				onGlobalCurrencySteps.typeMaximumSpread(maximumSpread);
			}
			if (!spreadBase.isEmpty()) {
				onGlobalCurrencySteps.typeSpreadBase(spreadBase);
			}
			if (!creditLimitExchangeRate.isEmpty()) {
				onGlobalCurrencySteps.typeCreditLimitExchangeRate(creditLimitExchangeRate);
			}

			onGlobalCurrencySteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetData("Currency", "Company");
			for (Integer rowComp : getCompany.keySet()) {
				keyCurrency = getCompany.get(rowComp).get(colKeyCurrency);
				if (keyCurrency.equals(currency)) {
					company = getCompany.get(rowComp).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onGlobalCurrencySteps.checkAllCompany();
						break;
					} else
						onGlobalCurrencySteps.checkCompany(company);
				}
			}
			onGlobalCurrencySteps.clickOnUpdateButton();
		}
		onGlobalCurrencySteps.switchOutDefaultIFrame();
	}
}
