package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplParticularsTabPage;

public class EmplParticularsTabSteps extends ScenarioSteps {

	EmplParticularsTabPage onParticularsTabPage;

	// PARTICULARS TAB

	@Step
	public void typeDateofBirth(String dateofBirth) {
		onParticularsTabPage.typeDateofBirth(dateofBirth);
	}

	@Step
	public void salutation(String salutation) {
		if (!salutation.isEmpty())
			onParticularsTabPage.salutation(salutation);
	}

	@Step
	public void gender(String gender) {
		if (!gender.isEmpty())
			onParticularsTabPage.gender(gender);
	}

	@Step
	public void marital_status(String marital_status) {
		if (!marital_status.isEmpty())
			onParticularsTabPage.marital_status(marital_status);
	}

	@Step
	public void race(String race) {
		if (!race.isEmpty())
			onParticularsTabPage.race(race);
	}

	@Step
	public void nationality(String nationality) {
		if (!nationality.isEmpty())
			onParticularsTabPage.nationality(nationality);
	}

	@Step
	public void religion(String religion) {
		if (!religion.isEmpty())
			onParticularsTabPage.religion(religion);
	}

	@Step
	public void date_to_become_pr(String date_to_become_pr) {
		if (!date_to_become_pr.isEmpty())
			onParticularsTabPage.date_to_become_pr(date_to_become_pr);
	}

	@Step
	public void home_address(String home_address) {
		if (!home_address.isEmpty())
			onParticularsTabPage.home_address(home_address);
	}

	@Step
	public void postal_code(String postal_code) {
		if (!postal_code.isEmpty())
			onParticularsTabPage.postal_code(postal_code);
	}

	@Step
	public void country_code(String country_code) {
		if (!country_code.isEmpty())
			onParticularsTabPage.country_code(country_code);
	}

	@Step
	public void overseas_address(String overseas_address) {
		if (!overseas_address.isEmpty())
			onParticularsTabPage.overseas_address(overseas_address);
	}

	@Step
	public void overseas_postal_code(String overseas_postal_code) {
		if (!overseas_postal_code.isEmpty())
			onParticularsTabPage.overseas_postal_code(overseas_postal_code);
	}

	@Step
	public void overseas_country_code(String overseas_country_code) {
		if (!overseas_country_code.isEmpty())
			onParticularsTabPage.overseas_country_code(overseas_country_code);
	}

	@Step
	public void smart_card_no(String smart_card_no) {
		if (!smart_card_no.isEmpty())
			onParticularsTabPage.smart_card_no(smart_card_no);
	}

	/* Identification / Documents */

	@Step
	public void type_of_identification(String typeIden) {
		if (!typeIden.isEmpty())
			onParticularsTabPage.type_of_identification(typeIden);
	}

	@Step
	public void no(String no) {
		if (!no.isEmpty())
			onParticularsTabPage.no(no);
	}

	@Step
	public void application_date(String application_date) {
		if (!application_date.isEmpty())
			onParticularsTabPage.application_date(application_date);
	}

	@Step
	public void issue_date(String issue_date) {
		if (!issue_date.isEmpty())
			onParticularsTabPage.issue_date(issue_date);
	}

	@Step
	public void expiry_date(String expiry_date) {
		if (!expiry_date.isEmpty())
			onParticularsTabPage.expiry_date(expiry_date);
	}

	@Step
	public void card_return_date(String card_return_date) {
		if (!card_return_date.isEmpty())
			onParticularsTabPage.card_return_date(card_return_date);
	}

	@Step
	public void is_default(String is_default) {
		onParticularsTabPage.is_default(is_default);
	}

	@Step
	public void del(String del) {
		if (!del.isEmpty())
			onParticularsTabPage.del(del);
	}

	@Step
	public void add_identification() {
		onParticularsTabPage.addIdentification();
	}

}
