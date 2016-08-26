package com.synergix.globalsetup.financial.accounting.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.synergix.common.TH5PageObject;

/**
 * 
 * @author Steve
 *
 */
public class CurrencyPage extends TH5PageObject {

	private static final String LOCAL_INFO_TAB_lABEL = "Local Info";
	private static final String TAG = "Tag";
	private static final String CURRENCY_CODE = "Currency Code";
	public static final String SEARCH = "Search";
	private static final String CREDIT_LIMIT_EXCHANGE_RATE = "Credit Limit Exchange Rate";
	private static final String SPREAD_BASE = "Spread % Base";
	private static final String MAXIMUM_SPREAD = "Maximum Spread%";
	private static final String MAXIMUM_BANK_RATE = "Maximum Bank Rate";
	private static final String MINIMUM_BANK_RATE = "Minimum Bank Rate";
	private static final String EXCHANGE_RATE = "Exchange Rate";
	private static final String COMPANY = "Company";
	private static final String CENT_IN_WORD = "Cent in word";
	private static final String DOLLAR_IN_WORD = "Dollar in word";
	private static final String CURRENCY_SYMBOL = "Currency Symbol";
	private static final String DESCRIPTION = "Description";
	private static final String CURRENCY = "Currency";

	public CurrencyPage(WebDriver driver) {
		super(driver);
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public String getTextValueWithLabelInCurrencyPage(String _labelName) {
		String inputField = xPathInputFieldWithLabel(_labelName);
		return $(inputField).getValue();
	}

	public void enter_currency(String currency) {
		enterInputFieldCodeWithLabel(CURRENCY, currency);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public String get_text_currency() {
		return getTextValueWithLabelInCurrencyPage(CURRENCY);

	}

	public void typeCurrencySymbol(String currencySymbol) {
		enterInputFieldWithLabel("Currency Symbol", currencySymbol);
	}

	/**
	 * @Description Return true if the field currency is enabled
	 * @author Steve
	 * @param
	 * 
	 */
	public boolean is_enabled_currency() {
		String currencyFieldXpath = xPathInputFieldWithLabel(CURRENCY);
		return $(currencyFieldXpath).isEnabled();

	}

	public void typeDollarinword(String dollarinword) {
		enterInputFieldWithLabel("Dollar in word", dollarinword);
	}

	/**
	 * @Description Return true if the field currency is readonly
	 * @author Steve
	 * @param
	 * 
	 */
	public boolean is_readonly_currency() {
		String currencyFieldXpath = xPathInputFieldWithLabel(CURRENCY);
		return !$(currencyFieldXpath).isEnabled();

	}

	public void typeCentinword(String centinword) {
		enterInputFieldWithLabel("Cent in word", centinword);
	}

	/**
	 * @Description Enter currency description
	 * @author Steve
	 * @param description
	 * 
	 */
	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);

	}
	
	public void switch_to_tab_local_info(){
		switch_to_tab(LOCAL_INFO_TAB_lABEL);
	}

	public void typeMinimumBankRate(String minimumBankRate) {
		enterInputFieldWithLabel("Minimum Bank Rate", minimumBankRate);
	}

	/**
	 * @Description Enter a currency code when creating a currency
	 * @author Steve
	 * @param
	 * 
	 */
	public String get_text_description() {
		return getTextValueWithLabelInCurrencyPage(DESCRIPTION);

	}

	public void typeMaximumBankRate(String maximumBankRate) {
		enterInputFieldWithLabel("Maximum Bank Rate", maximumBankRate);
	}

	public boolean is_enabled_description() {
		String descriptionFieldXpath = xPathInputFieldWithLabel(DESCRIPTION);
		return $(descriptionFieldXpath).isEnabled();

	}

	public void typeMaximumSpread(String maximumSpread) {
		enterInputFieldWithLabel("Maximum Spread%", maximumSpread);
	}

	public boolean is_readonly_description() {
		String descriptionFieldXpath = xPathInputFieldWithLabel(DESCRIPTION);
		return !$(descriptionFieldXpath).isEnabled();

	}

	public void typeSpreadBase(String spreadBase) {
		selectRadioButton("Spread % Base", spreadBase);
	}

	/**
	 * @Description Enter currency symbol
	 * @author Steve
	 * @param currencySymbol
	 * 
	 */
	public void enter_currency_symbol(String currencySymbol) {
		enterInputFieldWithLabel(CURRENCY_SYMBOL, currencySymbol);

	}

	public void typeCreditLimitExchangeRate(String creditLimitExchangeRate) {
		enterInputFieldWithLabel("Credit Limit Exchange Rate", creditLimitExchangeRate);
	}

	public String get_text_currency_symbol() {
		return getTextValueWithLabelInCurrencyPage(CURRENCY_SYMBOL);

	}

	public void clickOnNewButton() {
		findBtn("New").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
	}

	public void enter_dollar_in_word(String dollarInWord) {
		enterInputFieldWithLabel(DOLLAR_IN_WORD, dollarInWord);
	}

	public String get_text_dollar_in_word() {
		return getTextValueWithLabelInCurrencyPage(DOLLAR_IN_WORD);
	}

	public boolean is_enabled_dollar_in_word() {
		String dollarInWordFieldXpath = xPathInputFieldWithLabel(DOLLAR_IN_WORD);
		return $(dollarInWordFieldXpath).isEnabled();
	}

	public boolean is_readonly_dollar_in_word() {
		String dollarInWordFieldXpath = xPathInputFieldWithLabel(DOLLAR_IN_WORD);
		return !$(dollarInWordFieldXpath).isEnabled();
	}

	public void enter_cent_in_word(String centInWord) {
		enterInputFieldWithLabel(CENT_IN_WORD, centInWord);
	}

	public String get_text_cent_in_word() {
		return getTextValueWithLabelInCurrencyPage(CENT_IN_WORD);
	}

	public boolean is_enabled_cent_in_word() {
		String centInWordFieldXpath = xPathInputFieldWithLabel(CENT_IN_WORD);
		return $(centInWordFieldXpath).isEnabled();
	}

	public boolean is_readonly_cent_in_word() {
		String centInWordFieldXpath = xPathInputFieldWithLabel(CENT_IN_WORD);
		return !$(centInWordFieldXpath).isEnabled();
	}

	/**
	 * @Description Uncheck a company name
	 * @author Steve
	 * @param companyName
	 * 
	 */
	public void uncheck_company_name(String companyName) {
		if (is_checked_company_name(companyName)) {
			String companyNameXpath = getXpathCheckboxByText(companyName);
			$(companyNameXpath).click();
		}
	}

	/**
	 * @Description Return true if a company with name companyName is chosen
	 * @author Steve
	 * @param companyName
	 * 
	 */
	public boolean is_checked_company_name(String companyName) {
		String companyNameXpath = getXpathCheckboxByText(companyName);
		return $(companyNameXpath).isSelected();
	}

	public boolean is_checked_all_company() {
		String tag = getXpathCheckboxByText(TAG);
		return $(tag).isSelected();
	}

	/**
	 * @Description Return true if a company with name companyName is not chosen
	 * @author Steve
	 * @param companyName
	 * 
	 */
	public boolean is_unchecked_company_name(String companyName) {
		String companyNameXpath = getXpathCheckboxByText(companyName);
		return !$(companyNameXpath).isSelected();
	}

	/**
	 * @Description Switch to tab exchange rate
	 * @author Steve
	 * @param exchangeRate
	 * 
	 */
	public void switch_tab_exchange_rate() {
		switch_to_tab(EXCHANGE_RATE);
	}

	public boolean is_tab_active_exchange_rate() {
		try {
			findActiveTabWithTabName(EXCHANGE_RATE);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void enter_minimum_bank_rate(String minimumBankRate) {
		enterInputFieldWithLabel(MINIMUM_BANK_RATE, minimumBankRate);
	}

	public String get_text_minimum_bank_rate() {
		return getTextValueWithLabelInCurrencyPage(MINIMUM_BANK_RATE);
	}

	public void enter_maximum_bank_rate(String maximumBankRate) {
		enterInputFieldWithLabel(MAXIMUM_BANK_RATE, maximumBankRate);
	}

	public String get_text_maximum_bank_rate() {
		return getTextValueWithLabelInCurrencyPage(MAXIMUM_BANK_RATE);
	}

	public void enter_maximum_spread(String maximumSpread) {
		enterInputFieldWithLabel(MAXIMUM_SPREAD, maximumSpread);
	}

	public String get_text_maximum_spread() {
		return getTextValueWithLabelInCurrencyPage(MAXIMUM_SPREAD);
	}

	public void select_spread_base(String spreadBase) {
		checkRadio(SPREAD_BASE, spreadBase);
	}

	public boolean is_selected_spread_base(String spreadBase) {
		String spreadBaseXpath = xPathRadioBtnWithLabel(spreadBase);
		return $(spreadBaseXpath).isSelected();
	}

	public void enter_credit_limit_exchange_rate(String creditLimitExchangeRate) {
		enterInputFieldWithLabel(CREDIT_LIMIT_EXCHANGE_RATE, creditLimitExchangeRate);
	}

	public String get_text_credit_limit_exchange_rate() {
		return getTextValueWithLabelInCurrencyPage(CREDIT_LIMIT_EXCHANGE_RATE);
	}

	public boolean is_tab_active_company() {
		try {
			findActiveTabWithTabName(COMPANY);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void deleteCurrencyBySearchBtn(String labelName, String valueDelete) {
		clickBtn(SEARCH);
		if (getResultSearch(labelName, valueDelete)) {
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			chooseOKOnInfoPanel();
		} else {
			String xCloseIcon = "//table[@id='searchModalPanelContentTable']" + "/preceding-sibling::div//a[@href]";
			waitForAllJSCompletes();
			$(xCloseIcon).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
		
		//deleteValueBySearchBtn("Search", labelName, valueDelete);

	}

	@Override
	public boolean getResultSearch(String labelName, String valueSearch) {
		String xModelPanel = "//table[@id='searchModalPanelContentTable']";

		String xPathFirstRow = "//tbody[@id='searchResult_Form:searchResult_Table:tb']//*[text()='"
				+ valueSearch.toUpperCase() + "']";
		waitTypeAndEnter(xPathInputFieldWithLabel(xModelPanel, labelName), valueSearch);
		// searchInTbMultiPage(_parentXpath, _headerText, _colResOrder, _value,
		// _searchFromFirstPage)

		if (findAll(xPathFirstRow).size() > 0) {
			if ($(xPathFirstRow).getText().toLowerCase().equals(valueSearch.toLowerCase())) {
				$(xPathFirstRow).waitUntilClickable().click();
				waitForAllJSCompletes();
				return true;
			}
		}
		return false;
	}
}
