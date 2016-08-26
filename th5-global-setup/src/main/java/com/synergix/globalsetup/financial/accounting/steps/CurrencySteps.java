package com.synergix.globalsetup.financial.accounting.steps;

import com.synergix.globalsetup.financial.accounting.pages.CurrencyPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
/**
 * 
 * @author Steve
 *
 */

public class CurrencySteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	private static final String CURRENCY_DESCRIPTION = "Currency Description";

	CurrencyPage onCurrencyPage;
	CurrencyPage onGlobalCurrencyPage;

	@Step
	public void deleteCurrencyBySearchBtn(String labelName, String valueDelete) {
		onCurrencyPage.deleteCurrencyBySearchBtn(labelName, valueDelete);
	}

	@Step
	public void enter_currency(String currency) {
		onCurrencyPage.waitForAllJSCompletes();
		onCurrencyPage.click_add_new_button_on_functional_panel();
		onCurrencyPage.enter_currency(currency);

	}

	public void switchToIFrame(){
		onGlobalCurrencyPage.switchToIFrame();
	}
	public void switchOutDefaultIFrame() {
		onGlobalCurrencyPage.switchOutDefaultIFrame();
	}

	@Step
	public String get_text_currency() {
		return onCurrencyPage.get_text_currency();
	}

	@Step
	public boolean is_enabled_currency() {
		return onCurrencyPage.is_enabled_currency();
	}

	@Step
	public boolean is_readonly_currency() {
		return onCurrencyPage.is_readonly_currency();
	}

	@Step
	public void enter_description(String description) {
		onCurrencyPage.enter_description(description);

	}

	@Step
	public void addNewCurency() {
		onGlobalCurrencyPage.clickOnNewButton();
	}

	@Step
	public String get_text_description() {
		return onCurrencyPage.get_text_description();
	}

	@Step
	public boolean is_enabled_description() {
		return onCurrencyPage.is_enabled_description();
	}

	@Step
	public boolean is_readonly_description() {
		return onCurrencyPage.is_readonly_description();
	}

	@Step
	public void enter_currency_symbol(String currencySymbol) {
		onCurrencyPage.enter_currency_symbol(currencySymbol);

	}

	@Step
	public void clickOnUpdateButton() {
		onGlobalCurrencyPage.click_update_button_on_functional_panel();
	}

	@Step
	public String get_text_currency_symbol() {
		return onCurrencyPage.get_text_currency_symbol();
	}

	@Step
	public void enter_dollar_in_word(String dollarInWord) {
		onCurrencyPage.enter_dollar_in_word(dollarInWord);

	}

	// Label
	@Step
	public void typeCurrency(String currency) {
		onGlobalCurrencyPage.typeCurrency(currency);
	}

	@Step
	public String get_text_dollar_in_word() {
		return onCurrencyPage.get_text_dollar_in_word();
	}

	@Step
	public boolean is_enabled_dollar_in_word() {
		return onCurrencyPage.is_enabled_dollar_in_word();
	}

	@Step
	public boolean is_readonly_dollar_in_word() {
		return onCurrencyPage.is_readonly_dollar_in_word();
	}

	@Step
	public void enter_cent_in_word(String centInWord) {
		onCurrencyPage.enter_cent_in_word(centInWord);

	}

	@Step
	public void typeDescription(String description) {
		onGlobalCurrencyPage.typeDescription(description);
	}

	@Step
	public String get_text_cent_in_word() {
		return onCurrencyPage.get_text_cent_in_word();

	}

	@Step
	public void typeCurrencySymbol(String currencySymbol) {
		onGlobalCurrencyPage.typeCurrencySymbol(currencySymbol);
	}

	@Step
	public boolean is_enabled_cent_in_word() {
		return onCurrencyPage.is_enabled_cent_in_word();

	}

	@Step
	public void typeDollarinword(String dollarinword) {
		onGlobalCurrencyPage.typeDollarinword(dollarinword);
	}

	@Step
	public boolean is_readonly_cent_in_word() {
		return onCurrencyPage.is_readonly_cent_in_word();
	}

	@Step
	public void switch_tab_company() {
		onCurrencyPage.switch_to_tab_company();
	}

	@Step
	public boolean is_tab_active_company() {
		return onCurrencyPage.is_tab_active_company();
	}

	@Step
	public void check_company_name(String companyName) {
		onCurrencyPage.chooseCompany(companyName);
		;
	}

	@Step
	public void check_all_company() {
		onCurrencyPage.chooseAllCompany();
	}

	@Step
	public void uncheck_company_name(String companyName) {
		onCurrencyPage.uncheck_company_name(companyName);
	}

	@Step
	public boolean is_checked_company_name(String companyName) {
		return onCurrencyPage.is_checked_company_name(companyName);
	}

	@Step
	public boolean is_unchecked_company_name(String companyName) {
		return onCurrencyPage.is_unchecked_company_name(companyName);
	}

	// Tab exchange rate
	@Step
	public void select_spread_base(String spreadBase) {
		onCurrencyPage.select_spread_base(spreadBase);

	}

	@Step
	public void typeCentinword(String centinword) {
		onGlobalCurrencyPage.typeCentinword(centinword);
	}

	@Step
	public void switch_tab_exchange_rate() {
		onCurrencyPage.switch_tab_exchange_rate();
	}

	@Step
	public boolean is_tab_active_exchange_rate() {
		return onCurrencyPage.is_tab_active_exchange_rate();
	}

	@Step
	public boolean search_by_currency_code_found(String currencyCode) {
		onCurrencyPage.click_search_button_on_functional_panel();
		return onCurrencyPage.search("Currency Code", currencyCode);

	}

	@Step
	public void typeMinimumBankRate(String minimumBankRate) {
		onGlobalCurrencyPage.typeMinimumBankRate(minimumBankRate);
	}

	@Step
	public boolean search_by_currency_code_not_found(String currencyCode) {
		onCurrencyPage.click_search_button_on_functional_panel();
		return !onCurrencyPage.search("Currency Code", currencyCode);

	}

	@Step
	public boolean search_by_currency_description_found(String currencyDescription) {
		onCurrencyPage.click_search_button_on_functional_panel();
		return onCurrencyPage.search(CURRENCY_DESCRIPTION, currencyDescription);

	}

	@Step
	public void typeMaximumBankRate(String maximumBankRate) {
		onGlobalCurrencyPage.typeMaximumBankRate(maximumBankRate);
	}

	@Step
	public void typeMaximumSpread(String maximumSpread) {
		onGlobalCurrencyPage.typeMaximumSpread(maximumSpread);
	}

	@Step
	public boolean verify_currency_description_not_found(String currencyDescription) {
		onCurrencyPage.click_search_button_on_functional_panel();
		return !onCurrencyPage.search(CURRENCY_DESCRIPTION, currencyDescription);

	}

	@Step
	public void click_btn_delete_currency() {
		onCurrencyPage.click_delete_button_on_functional_panel();
	}

	@Step
	public void typeSpreadBase(String spreadBase) {
		onGlobalCurrencyPage.typeSpreadBase(spreadBase);
	}

	@Step
	public void typeCreditLimitExchangeRate(String creditLimitExchangeRate) {
		onGlobalCurrencyPage.typeCreditLimitExchangeRate(creditLimitExchangeRate);
	}

	// check Company
	@Step
	public void checkAllCompany() {
		onGlobalCurrencyPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onGlobalCurrencyPage.chooseCompany(company);
	}
	
	@Step
	public void switch_to_tab_local_info(){
		onGlobalCurrencyPage.switch_to_tab_local_info();
	}

	// Move tab
	@Step
	public void moveToExchangeRateTab() {
		onGlobalCurrencyPage.switch_to_tab("Exchange Rate");
	}

	@Step
	public void moveToCompanyTab() {
		onGlobalCurrencyPage.switch_to_tab("Company");
	}

	@Step
	public void chooseDelCurrency(String currency) {
		onGlobalCurrencyPage.deleteValueBySearchBtn("Search", "Currency Code", currency);
	}

	@Step
	public void enter_minimum_bank_rate(String minimumBankRate) {
		onCurrencyPage.enter_minimum_bank_rate(minimumBankRate);
	}

	@Step
	public String get_text_minimum_bank_rate() {
		return onCurrencyPage.get_text_minimum_bank_rate();
	}

	@Step
	public void enter_maximum_bank_rate(String maximumBankRate) {
		onCurrencyPage.enter_maximum_bank_rate(maximumBankRate);
	}

	@Step
	public String get_text_maximum_bank_rate() {
		return onCurrencyPage.get_text_maximum_bank_rate();
	}

	@Step
	public void enter_maximum_spread(String maximumSpread) {
		onCurrencyPage.enter_maximum_spread(maximumSpread);
	}

	@Step
	public String get_text_maximum_spread() {
		return onCurrencyPage.get_text_maximum_spread();
	}

	@Step
	public boolean is_selected_spread_base(String spreadBase) {
		return onCurrencyPage.is_selected_spread_base(spreadBase);
	}

	@Step
	public void enter_credit_limit_exchange_rate(String creditLimitExchangeRate) {
		onCurrencyPage.enter_credit_limit_exchange_rate(creditLimitExchangeRate);
	}

	@Step
	public String get_text_credit_limit_exchange_rate() {
		return onCurrencyPage.get_text_credit_limit_exchange_rate();
	}

	@Step
	public void verify_currency(String currency) {
		onCurrencyPage.waitForAllJSCompletes();
		assertThat(onCurrencyPage.get_text_currency(), equalTo(currency));
	}

	@Step
	public void verify_description(String description) {
		assertThat(onCurrencyPage.get_text_description(), equalTo(description));
	}

	@Step
	public void verify_currency_symbol(String currencySymbol) {
		assertThat(onCurrencyPage.get_text_currency_symbol(), equalTo(currencySymbol));
	}

	@Step
	public void verify_dollar_in_word(String dollarInWord) {
		assertThat(onCurrencyPage.get_text_dollar_in_word(), equalTo(dollarInWord));
	}

	@Step
	public void verify_cent_in_word(String centInWord) {
		assertThat(onCurrencyPage.get_text_cent_in_word(), equalTo(centInWord));
	}

	@Step
	public void verify_minimum_bank_rate(String minimumBankRate) {
		assertThat(onCurrencyPage.get_text_minimum_bank_rate(), equalTo(minimumBankRate));
	}

	@Step
	public void verify_maximum_bank_rate(String maximumBankRate) {
		assertThat(onCurrencyPage.get_text_maximum_bank_rate(), equalTo(maximumBankRate));
	}

	@Step
	public void verify_maximum_spread(String maximumSpread) {
		assertThat(onCurrencyPage.get_text_maximum_spread(), equalTo(maximumSpread));
	}

	@Step
	public void verify_spread_base(String spreadBase) {
		assertThat(onCurrencyPage.is_selected_spread_base(spreadBase), equalTo(true));
	}

	@Step
	public void verify_credit_limit_exchange_rate(String creditLimitExchangeRate) {
		assertThat(onCurrencyPage.get_text_credit_limit_exchange_rate(), equalTo(creditLimitExchangeRate));
	}

	@Step
	public void verify_company(String company) {
		onCurrencyPage.switch_to_tab_company();
		if (company.equals("All")) {
			assertThat(onCurrencyPage.is_checked_all_company(), equalTo(true));
		} else {
			assertThat(onCurrencyPage.is_checked_company_name(company), equalTo(true));
		}
	}
}
