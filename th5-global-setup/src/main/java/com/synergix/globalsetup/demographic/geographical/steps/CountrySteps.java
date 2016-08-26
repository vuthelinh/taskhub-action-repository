package com.synergix.globalsetup.demographic.geographical.steps;

import com.synergix.common.LogWork;
import com.synergix.globalsetup.demographic.geographical.pages.CountryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author jacob.vu
 *
 */
public class CountrySteps extends ScenarioSteps {

	//private static final long serialVersionUID = 1L;
	CountryPage countryPage;

	@Step
	public void search_code(String countryCode) {
		countryPage.click_search_button_on_functional_panel();
		countryPage.search(CountryPage.COUNTRY_CODE_SEARCH, countryCode);
	}

	@Step
	public void remove_country(String countryCode) {
		search_code(countryCode);
		countryPage.click_delete_button_on_functional_panel();
	}

	@Step
	public void enter_country_code(String countryCode) {
		countryPage.click_add_new_button_on_functional_panel();
		countryPage.enter_country_code(countryCode);
	}

	@Step
	public void enter_country_description(String countryDescription) {
		countryPage.enter_country_description(countryDescription);
	}

	@Step
	public void enter_nationality_description(String nationalityDescription) {
		countryPage.enter_nationality_description(nationalityDescription);
	}

	@Step
	public void enter_nationality_code(String nationalityCode) {
		countryPage.enter_nationality_code(nationalityCode);
	}

	@Step
	public void verify_country_code(String countryCode) {
		assertThat(countryPage.get_text_country_code(), equalTo(countryCode));
	}

	@Step
	public void verify_nationality_description(String nationalityDescription) {
		assertThat(countryPage.get_text_nationality_description(), equalTo(nationalityDescription));
	}

	@Step
	public void verify_country_description(String countryDescription) {
		assertThat(countryPage.get_text_country_description(), equalTo(countryDescription));
	}

	@Step
	public void verify_nationality_code(String nationalityCode) {
		assertThat(countryPage.get_text_nationality_code(), equalTo(nationalityCode));
	}

	@Step
	public void verify_country_not_found(String countryCode) {

		countryPage.click_add_new_button_on_functional_panel();
		countryPage.click_search_button_on_functional_panel();
		boolean found = countryPage.search_country(countryCode);
		assertThat(found, equalTo(false));
	}

	@Step
	public void update_country_to_main_db() {
		countryPage.click_update_button_on_functional_panel();
	}

}
