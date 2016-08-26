package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplFamilyMemberTabPage;

public class EmplFamilyMemberSteps extends ScenarioSteps {

	EmplFamilyMemberTabPage onFamilyMemberPage;

	@Step
	public void name(String name) {
		if (!name.isEmpty())
			onFamilyMemberPage.name(name);
	}

	@Step
	public void relationship(String relationship) {
		if (!relationship.isEmpty())
			onFamilyMemberPage.relationship(relationship);
	}

	@Step
	public void date_of_birth(String date_of_birth) {
		if (!date_of_birth.isEmpty())
			onFamilyMemberPage.date_of_birth(date_of_birth);
	}

	@Step
	public void nationality(String nationality) {
		if (!nationality.isEmpty())
			onFamilyMemberPage.nationality(nationality);
	}

	@Step
	public void race(String race) {
		if (!race.isEmpty())
			onFamilyMemberPage.race(race);
	}

	@Step
	public void identification_no(String identification_no) {
		if (!identification_no.isEmpty())
			onFamilyMemberPage.identification_no(identification_no);
	}

	@Step
	public void home_phone_no(String home_phone_no) {
		if (!home_phone_no.isEmpty())
			onFamilyMemberPage.home_phone_no(home_phone_no);
	}

	@Step
	public void mobile_no(String mobile_no) {
		if (!mobile_no.isEmpty())
			onFamilyMemberPage.mobile_no(mobile_no);
	}

	@Step
	public void next_of_kin(String next_of_kin) {
		if (!next_of_kin.isEmpty())
			onFamilyMemberPage.next_of_kin(next_of_kin);
	}

	@Step
	public void co_worker(String co_worker) {
		onFamilyMemberPage.co_worker(co_worker);
	}

	@Step
	public void dependent_pass(String dependent_pass) {
		onFamilyMemberPage.dependent_pass(dependent_pass);
	}

	@Step
	public void application_date(String application_date) {
		onFamilyMemberPage.application_date(application_date);
	}

	@Step
	public void issue_date(String issue_date) {
		onFamilyMemberPage.issue_date(issue_date);
	}

	@Step
	public void expiry_date(String expiry_date) {
		onFamilyMemberPage.expiry_date(expiry_date);
	}

	@Step
	public void card_return_date(String card_return_date) {
		onFamilyMemberPage.card_return_date(card_return_date);
	}

	@Step
	public void add_family_member() {
		onFamilyMemberPage.add_family_member();
	}

}
