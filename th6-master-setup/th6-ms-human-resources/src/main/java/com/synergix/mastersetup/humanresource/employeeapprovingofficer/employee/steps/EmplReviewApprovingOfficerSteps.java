package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages.EmplReviewApprovingOfficerPage;

public class EmplReviewApprovingOfficerSteps extends ScenarioSteps {

	EmplReviewApprovingOfficerPage onReviewApprovingOfficerPage;

	@Step
	public void exclude_from_year_end_review(String exclude_from_year_end_review) {
		if (exclude_from_year_end_review.equalsIgnoreCase("Yes"))
			onReviewApprovingOfficerPage.exclude_from_year_end_review();
	}

	@Step
	public void exclude_from_confirmation_review(
			String exclude_from_confirmation_review) {
		if (exclude_from_confirmation_review.equalsIgnoreCase("Yes"))
			onReviewApprovingOfficerPage.exclude_from_confirmation_review();
	}

	@Step
	public void exclude_from_internship_review(
			String exclude_from_internship_review) {
		if (exclude_from_internship_review.equalsIgnoreCase("Yes"))
			onReviewApprovingOfficerPage.exclude_from_internship_review();
	}

	@Step
	public void director(String director) {
		if (!director.isEmpty())
			onReviewApprovingOfficerPage.director(director);
	}

	@Step
	public void associate_director(String associate_director) {
		if (!associate_director.isEmpty())
			onReviewApprovingOfficerPage.associate_director(associate_director);
	}

	@Step
	public void team_leader(String team_leader) {
		if (!team_leader.isEmpty())
			onReviewApprovingOfficerPage.team_leader(team_leader);
	}

	@Step
	public void click_add_other_team_leaders() {
		onReviewApprovingOfficerPage.clickAddOtherTeamLeaders();
	}

	@Step
	public void effective_date_from_to(String from, String to) {
		if (!from.isEmpty())
			onReviewApprovingOfficerPage.EffectiveDataFromTo(from, to);
	}

	@Step
	public void add_teamleader(String teamLeaders) {
		onReviewApprovingOfficerPage.AddTeamLeaders(teamLeaders);
	}

	@Step
	public void click_add_internship_monitoring_committee() {
		onReviewApprovingOfficerPage.clickAddInternshipMonitoringCommittee();
	}

	@Step
	public void committee_member(String members) {
		onReviewApprovingOfficerPage.committeeMember(members);
	}

}
