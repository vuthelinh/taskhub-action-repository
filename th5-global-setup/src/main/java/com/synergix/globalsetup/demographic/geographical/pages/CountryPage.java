package com.synergix.globalsetup.demographic.geographical.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author jacob.vu
 *
 */
public class CountryPage extends TH5PageObject {

	public static final String COUNTRY_CODE_SEARCH = "Country Code";
	
	private static final String COUNTRY_CODE = "Country Code:";

	private static final String COUNTRY_DESCRIPTION = "Country Description:";
	
	public static final String NATIONALITY_DESCRIPTION = "Nationality Description:";

	private static final String NATIONALITY_CODE = "Employment Income File Country/Nationality Code:";

	public CountryPage(WebDriver driver) {
		super(driver);
	}

	public void enter_country_code(String countryCode) {
		enterInputFieldCodeWithLabel(COUNTRY_CODE, countryCode);
	}

	public String get_text_country_code() {
		return getTextValueWithLabel(COUNTRY_CODE);
	}

	public void enter_country_description(String countryDescription) {
		enterInputFieldWithLabel(COUNTRY_DESCRIPTION, countryDescription);
	}

	public String get_text_country_description() {
		return getTextValueWithLabel(COUNTRY_DESCRIPTION);
	}

	public void enter_nationality_description(String nationalityDescription) {
		enterInputFieldWithLabel(NATIONALITY_DESCRIPTION, nationalityDescription);
	}

	public void enter_nationality_code(String nationalityCode) {
		enterInputFieldWithLabel(NATIONALITY_CODE, nationalityCode);
	}

	public String get_text_nationality_description() {
		return getTextValueWithLabel(NATIONALITY_DESCRIPTION);
	}

	public String get_text_nationality_code() {
		return getTextValueWithLabel(NATIONALITY_CODE);
	}

	public boolean search_country(String countryCode) {
		return search(COUNTRY_CODE_SEARCH, countryCode);
	}

}
