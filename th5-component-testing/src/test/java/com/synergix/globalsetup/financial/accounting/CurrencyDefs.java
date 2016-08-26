package com.synergix.globalsetup.financial.accounting;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.definition.common.CommonDefs;
import com.synergix.globalsetup.financial.accounting.steps.CurrencySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CurrencyDefs {

	@Steps
	CurrencySteps currencySteps;

	@Steps
	CommonDefs commonDefs;

	@Given("^I am in currency page$")
	public void i_am_in_currency_page() throws Throwable {
		commonDefs.loginTaskhub();
		commonDefs.user_navigates_to_screen("Global Setup>Financial>Accounting>Currency");
	}

	@When("^I create a currency as the following with \"([^\"]*)\":$")
	public void i_create_a_currency_as_the_following_with(String dataKey, List<List<String>> currencyTable) {
		SessionData.addDataTable("currencyTable", currencyTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("currencyTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sCurrency = SessionData.getDataTbVal("currencyTable", row, "Currency");
			String sDescription = SessionData.getDataTbVal("currencyTable", row, "Description");
			String sCurrencySymbol = SessionData.getDataTbVal("currencyTable", row, "Currency Symbol");
			String sDollarInWord = SessionData.getDataTbVal("currencyTable", row, "Dollar in word");
			String sCentInWord = SessionData.getDataTbVal("currencyTable", row, "Cent in word");
			String sCompany = SessionData.getDataTbVal("currencyTable", row, "Company");

			if (!sCurrency.isEmpty()) {
				currencySteps.enter_currency(sCurrency);
			}
			if (!sDescription.isEmpty()) {
				currencySteps.enter_description(sDescription);
			}
			if (!sCurrencySymbol.isEmpty()) {
				currencySteps.enter_currency_symbol(sCurrencySymbol);
			}
			if (!sDollarInWord.isEmpty()) {
				currencySteps.enter_dollar_in_word(sDollarInWord);
			}
			if (!sCentInWord.isEmpty()) {
				currencySteps.enter_cent_in_word(sCentInWord);
			}
			currencySteps.switch_tab_company();
			if (!sCompany.isEmpty()) {
				if (sCompany.equals("All")) {
					currencySteps.check_all_company();
				} else {
					currencySteps.check_company_name(sCompany);
				}
			}
		}
	}

	@When("^with exchange rate details with \"([^\"]*)\"$")
	public void with_exchange_rate_details_with(String dataKey, List<List<String>> exchangeRateTable) {
		SessionData.addDataTable("exchangeRateTable", exchangeRateTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("exchangeRateTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sMinimumBankRate = SessionData.getDataTbVal("exchangeRateTable", row, "Minimum Bank Rate");
			String sMaximumBankRate = SessionData.getDataTbVal("exchangeRateTable", row, "Maximum Bank Rate");
			String sMaximumSpread = SessionData.getDataTbVal("exchangeRateTable", row, "Maximum Spread%");
			String sSpreadBase = SessionData.getDataTbVal("exchangeRateTable", row, "Spread % Base");
			String sCreditLimitExchangeRate = SessionData.getDataTbVal("exchangeRateTable", row,
					"Credit Limit Exchange Rate");
			currencySteps.switch_tab_exchange_rate();
			if (!sMinimumBankRate.isEmpty()) {
				currencySteps.enter_minimum_bank_rate(sMinimumBankRate);
			}
			if (!sMaximumBankRate.isEmpty()) {
				currencySteps.enter_maximum_bank_rate(sMaximumBankRate);
			}
			if (!sMaximumSpread.isEmpty()) {
				currencySteps.enter_maximum_spread(sMaximumSpread);
			}
			if (!sSpreadBase.isEmpty()) {
				currencySteps.select_spread_base(sSpreadBase);
			}
			if (!sCreditLimitExchangeRate.isEmpty()) {
				currencySteps.enter_credit_limit_exchange_rate(sCreditLimitExchangeRate);
			}
		}
	}

	@When("^I search for the currency with \"([^\"]*)\"$")
	public void i_search_for_the_currency_with(String dataKey) throws Throwable {
	}

	@Then("^I should see the currency with \"([^\"]*)\"$")
	public void i_should_see_the_currency_with(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("currencyTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sCurrency = SessionData.getDataTbVal("currencyTable", row, "Currency");
			String sDescription = SessionData.getDataTbVal("currencyTable", row, "Description");
			String sCurrencySymbol = SessionData.getDataTbVal("currencyTable", row, "Currency Symbol");
			String sDollarInWord = SessionData.getDataTbVal("currencyTable", row, "Dollar in word");
			String sCentInWord = SessionData.getDataTbVal("currencyTable", row, "Cent in word");
			if (!sDescription.isEmpty()) {
				currencySteps.search_by_currency_description_found(sDescription);
				currencySteps.verify_description(sDescription);
			}
			if (!sCurrency.isEmpty()) {
				currencySteps.verify_currency(sCurrency);
			}
			if (!sCurrencySymbol.isEmpty()) {
				currencySteps.verify_currency_symbol(sCurrencySymbol);
			}
			if (!sDollarInWord.isEmpty()) {
				currencySteps.verify_dollar_in_word(sDollarInWord);
			}
			if (!sCentInWord.isEmpty()) {
				currencySteps.verify_cent_in_word(sCentInWord);
			}
		}

		testData = SessionData.getDataTbRowsByValEqualInCol("exchangeRateTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sMinimumBankRate = SessionData.getDataTbVal("exchangeRateTable", row, "Minimum Bank Rate");
			String sMaximumBankRate = SessionData.getDataTbVal("exchangeRateTable", row, "Maximum Bank Rate");
			String sMaximumSpread = SessionData.getDataTbVal("exchangeRateTable", row, "Maximum Spread%");
			String sSpreadBase = SessionData.getDataTbVal("exchangeRateTable", row, "Spread % Base");
			String sCreditLimitExchangeRate = SessionData.getDataTbVal("exchangeRateTable", row,
					"Credit Limit Exchange Rate");
			currencySteps.switch_tab_exchange_rate();
			if (!sMinimumBankRate.isEmpty()) {
				currencySteps.verify_minimum_bank_rate(sMinimumBankRate);
			}
			if (!sMaximumBankRate.isEmpty()) {
				currencySteps.verify_maximum_bank_rate(sMaximumBankRate);
			}
			if (!sMaximumSpread.isEmpty()) {
				currencySteps.verify_maximum_spread(sMaximumSpread);
			}
			if (!sSpreadBase.isEmpty()) {
				currencySteps.verify_spread_base(sSpreadBase);
			}
			if (!sCreditLimitExchangeRate.isEmpty()) {
				currencySteps.verify_credit_limit_exchange_rate(sCreditLimitExchangeRate);
			}
		}
		currencySteps.clickOnUpdateButton();
	}

	@When("^I delete the currency  with \"([^\"]*)\"$")
	public void i_delete_the_currency_with(String dataKey) {
		currencySteps.click_btn_delete_currency();
	}

	@Then("^I should not see the currency with \"([^\"]*)\"$")
	public void i_should_not_see_the_currency_with(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("currencyTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sCurrencyDescription = SessionData.getDataTbVal("currencyTable", row, "Description");
			System.out.println("Currency desc =" + sCurrencyDescription);
			if (!sCurrencyDescription.isEmpty()) {
				currencySteps.verify_currency_description_not_found(sCurrencyDescription);
			}
		}
	}
}
