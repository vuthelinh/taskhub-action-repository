package com.synergix.globalsetup.demographic;

import java.util.List;

import com.synergix.common.LogWork;
import com.synergix.globalsetup.demographic.geographical.steps.CountrySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author jacob.vu
 *
 */
public class CountryDefs {

	@Steps
	CountrySteps countryStep;

	@When("^user create new country$")
	public void user_create_new_country(List<List<String>> CountryTable) {

		SessionData.addDataTable("CountryTable", CountryTable,false);

		for (int row : SessionData.getDataTbRowsNoHeader("CountryTable").keySet()) {
			String sCountryCode 			= SessionData.getDataTbVal("CountryTable", row, "Country Code");
			String sCountryDescription 		= SessionData.getDataTbVal("CountryTable", row, "Country Description");
			String sNationalityDescription 	= SessionData.getDataTbVal("CountryTable", row, "Nationality Description");
			String sNationalityCode 		= SessionData.getDataTbVal("CountryTable", row, "Nationality Code");

			if (!sCountryCode.isEmpty()) {
				countryStep.enter_country_code(sCountryCode);
			}
			if (!sCountryDescription.isEmpty()) {
				countryStep.enter_country_description(sCountryDescription);
			}
			if (!sNationalityDescription.isEmpty()) {
				countryStep.enter_nationality_description(sNationalityDescription);
			}
			if (!sNationalityCode.isEmpty()) {
				countryStep.enter_nationality_code(sNationalityCode);
			}
						
			countryStep.update_country_to_main_db();
			
			countryStep.search_code(sCountryCode);
			countryStep.verify_country_code(sCountryCode);
			countryStep.verify_country_description(sCountryDescription);
			countryStep.verify_nationality_code(sNationalityCode);
			countryStep.verify_nationality_description(sNationalityDescription);
		}
	}

	@When("^user delete a country then the country not found in the list$")
	public void user_delete_a_country(List<List<String>> countryDel) {
		SessionData.addDataTable("countryDel", countryDel,false);

		for (int row : SessionData.getDataTbRowsNoHeader("countryDel").keySet()) {
			String sCountryCode = SessionData.getDataTbVal("countryDel", row, "Country Code");
		
			countryStep.remove_country(sCountryCode);
			countryStep.verify_country_not_found(sCountryCode);
		}
	}

}
