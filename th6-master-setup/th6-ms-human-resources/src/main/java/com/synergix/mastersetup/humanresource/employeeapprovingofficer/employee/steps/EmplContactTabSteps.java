package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplContactPage;

public class EmplContactTabSteps extends ScenarioSteps {

	EmplContactPage onContactPage;

	@Step
	public void company_email(String company_email) {
		if (!company_email.isEmpty())
			onContactPage.company_email(company_email);
	}

	@Step
	public void personal_email(String personal_email) {
		if (!personal_email.isEmpty())
			onContactPage.personal_email(personal_email);
	}

	@Step
	public void other_email(String other_email) {
		if (!other_email.isEmpty())
			onContactPage.other_email(other_email);
	}

	@Step
	public void office_phone_no(String office_phone_no) {
		if (!office_phone_no.isEmpty())
			onContactPage.office_phone_no(office_phone_no);
	}

	@Step
	public void extension_no(String extension_no) {
		if (!extension_no.isEmpty())
			onContactPage.extension_no(extension_no);
	}

	@Step
	public void home_phone_no(String home_phone_no) {
		if (!home_phone_no.isEmpty())
			onContactPage.home_phone_no(home_phone_no);
	}

	@Step
	public void mobile_phone_no(String mobile_phone_no) {
		if (!mobile_phone_no.isEmpty())
			onContactPage.mobile_phone_no(mobile_phone_no);
	}

	@Step
	public void secondary_mobile_phone_no(String secondary_mobile_phone_no) {
		if (!secondary_mobile_phone_no.isEmpty())
			onContactPage.secondary_mobile_phone_no(secondary_mobile_phone_no);
	}

	@Step
	public void other_phone_no(String other_phone_no) {
		if (!other_phone_no.isEmpty())
			onContactPage.other_phone_no(other_phone_no);
	}
}
