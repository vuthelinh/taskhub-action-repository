package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class EmplReviewApprovingOfficerPage extends TH6PageObject {

	public EmplReviewApprovingOfficerPage(WebDriver driver) {
		super(driver);
	}

	public void exclude_from_year_end_review() {
		check("Exclude from Year End Review");
	}

	private void check(String labelCheck) {
		$("//form[contains(@id,':accordionPanel:reviewOfficerInchargeTab')]//*[text()='" + labelCheck
				+ "']/following-sibling::div//div[2]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void exclude_from_confirmation_review() {
		check("Exclude from Confirmation Review");
	}

	public void exclude_from_internship_review() {
		check("Exclude from Internship Review");
	}

	public void director(String director) {
		inputValue("Director", director);
	}

	public void associate_director(String associate_director) {
		inputValue("Associate Director", associate_director);
	}

	public void team_leader(String team_leader) {
		inputValue("Team Leader", team_leader);
	}

	private void inputValue(String namePopup, String value) {
		click_on_button(namePopup);
		String[] data = value.split(",");
		fill_effective_date(namePopup, data[0]);
		search_by_input_directly(namePopup, data[1]);
		click_sumbit(namePopup);
		close_popup(namePopup);
	}

	private void click_on_button(String labelText) {
		$("//form[contains(@id,'accordionPanel:reviewOfficerInchargeTab')]//*[text()='" + labelText
				+ "']/following-sibling::div/table//button[contains(@id,'accordionPanel:reviewOfficerInchargeTab')]")
						.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	private void fill_effective_date(String namePopup, String value) {
		waitTypeAndEnterThenUpdateDate(
				"//*[text()='" + namePopup
						+ "']/parent::div/following-sibling::div//td[text()='Effective Date']/following-sibling::td//input",
				value);
		waitForAllJSCompletes();
	}

	private void search_by_input_directly(String namePopup, String value) {
		// open popUp
		$("//*[text()='" + namePopup + "']/parent::div/following-sibling::div//td[text()='" + namePopup
				+ "']/following-sibling::td//button").waitUntilClickable().click();
		waitForAllJSCompletes();
		// type
		$("//*[@id='searchParameterPanel']//*[text()='Employee Code']/parent::div/parent::td/following-sibling::td//input")
				.typeAndEnter(value);
		waitForAllJSCompletes();
		// click search
		$("//*[@id='searchParameterPanel']//*[text()='Employee Code']/parent::div/parent::td/following-sibling::td//button")
				.waitUntilClickable().click();
		waitForAllJSCompletes();
		// click on the result
		$("//*[@id='searchResultsForm:searchResultTable_data']//*[text()='" + value + "']").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	private void click_sumbit(String namePopup) {
		$("//*[text()='" + namePopup + "']/parent::div/following-sibling::div//td[2]/button").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	private void close_popup(String namePopup) {
		$("//span[text()='" + namePopup + "']/following-sibling::a[@aria-label='Close']").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	// 1. Click Add Other Team Leader
	public void clickAddOtherTeamLeaders() {
		click_on_add_button("Other Team Leaders");
	}

	public void clickAddInternshipMonitoringCommittee() {
		click_on_add_button("Internship Monitoring Committee");
	}

	private void click_on_add_button(String lableText) {
		$("//*[text()='" + lableText
				+ "']/parent::div/following-sibling::div//form[contains(@id,'accordionPanel:reviewOfficerInchargeTab')]//button")
						.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	// 2 Click on eye
	public void clickOnLastEye() {
		$("(//tbody[contains(@id,'accordionPanel:reviewOfficerInchargeTab') and contains(@id,'tblPeriod_data')]/tr/td/button)[last()]")
				.waitUntilClickable().click();
	}

	// 3. Input effective date from
	public void EffectiveDataFrom(String from) {
		waitTypeAndEnterThenUpdateDate(
				"(//*[text()='Effective Date From']/ancestor::thead[contains(@id,'accordionPanel:reviewOfficerInchargeTab')]/following-sibling::tbody/tr/td[2]//input)[last()]",
				from);
		waitForAllJSCompletes();
	}

	// 4. Input effective date from
	public void EffectiveDataTo(String to) {
		waitTypeAndEnterThenUpdateDate(
				"(//*[text()='Effective Date To']/ancestor::thead[contains(@id,'accordionPanel:reviewOfficerInchargeTab')]/following-sibling::tbody/tr/td[3]//input)[last()]",
				to);
		waitForAllJSCompletes();
	}

	public void EffectiveDataFromTo(String from, String to) {
		clickAddOtherTeamLeaders();
		EffectiveDataFrom(from);
		EffectiveDataTo(to);
		clickOnLastEye();
	}

	public void AddTeamLeaders(String teamLeaders) {

		String[] data = teamLeaders.split(", ");
		for (int i = 0; i < data.length; i++) {
			$("//*[text()='Team Leader']/ancestor::div[contains(@id,'accordionPanel:reviewOfficerInchargeTab')]/div//button[contains(@id,'teamLeaderTbl')]")
					.waitUntilClickable().click();
			waitForAllJSCompletes();
			waitTypeAndEnter(
					"//tbody[contains(@id,'accordionPanel:reviewOfficerInchargeTab') and contains(@id,'teamLeaderTbl')]/tr[last()]/td//input",
					data[i]);
			waitForAllJSCompletes();
		}
	}

	public void committeeMember(String members) {
		String[] data = members.split(", ");
		for (int i = 0; i < data.length; i++) {
			
			clickAddInternshipMonitoringCommittee();
			waitTypeAndEnter(
					"//*[text()='Committee Members']/ancestor::thead/following-sibling::tbody/tr[last()]//input",
					data[i]);
			waitForAllJSCompletes();
		}
	}

}
