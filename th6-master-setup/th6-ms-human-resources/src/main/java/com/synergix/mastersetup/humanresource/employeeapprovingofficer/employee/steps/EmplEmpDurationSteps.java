package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplEmpDurationPage;

public class EmplEmpDurationSteps extends ScenarioSteps {

	EmplEmpDurationPage onEmpDurationPage;

	@Step
	public void type(String type) {
		if (!type.isEmpty())
			onEmpDurationPage.type(type);
	}

	@Step
	public void join_date(String join_date) {
		if (!join_date.isEmpty())
			onEmpDurationPage.join_date(join_date);
	}

	@Step
	public void contract_start_date(String contract_start_date) {
		if (!contract_start_date.isEmpty())
			onEmpDurationPage.contract_start_date(contract_start_date);
	}

	@Step
	public void confirmation_date(String confirmation_date) {
		if (!confirmation_date.isEmpty())
			onEmpDurationPage.confirmation_date(confirmation_date);
	}

	@Step
	public void contract_end_date(String contract_end_date) {
		if (!contract_end_date.isEmpty())
			onEmpDurationPage.contract_end_date(contract_end_date);
	}

	@Step
	public void cessation_date(String cessation_date) {
		if (!cessation_date.isEmpty())
			onEmpDurationPage.cessation_date(cessation_date);
	}

	@Step
	public void reason_for_cessation(String reason_for_cessation) {
		if (!reason_for_cessation.isEmpty())
			onEmpDurationPage.reason_for_cessation(reason_for_cessation);
	}

	@Step
	public void sabbatical_leave_end_date(String sabbatical_leave_end_date) {
		if (!sabbatical_leave_end_date.isEmpty())
			onEmpDurationPage
					.sabbatical_leave_end_date(sabbatical_leave_end_date);
	}

	@Step
	public void include_in_year_of_service(String include_in_year_of_service) {
		if (!include_in_year_of_service.isEmpty())
			onEmpDurationPage
					.include_in_year_of_service(include_in_year_of_service);
	}

	@Step
	public void company_code(String company_code) {
		onEmpDurationPage.company_code(company_code);
	}

	@Step
	public void company_name(String company_name) {
		// onEmpDurationPage.company_name();
	}

	@Step
	public void employer_cpf_submission_no(String employer_cpf_submission_no) {
		if (!employer_cpf_submission_no.isEmpty())
			onEmpDurationPage
					.employer_cpf_submission_no(employer_cpf_submission_no);
	}

	@Step
	public void employment_status(String employment_status) {
		if (!employment_status.isEmpty())
			onEmpDurationPage.employment_status(employment_status);
	}

	@Step
	public void del(String del) {
		if (!del.isEmpty())
			onEmpDurationPage.del(del);
	}

	@Step
	public void add_employee_duration() {
		onEmpDurationPage.addEmployDuration();
	}

}
