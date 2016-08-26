package com.synergix.processing.project.quotationorder.pages;

import com.synergix.common.TH5PageObject;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectRecognitionPage extends TH5PageObject {
	public ProjectRecognitionPage(WebDriver driver) {
		super(driver);
	}

	public void search_project_on_recognition_summary_tab(String projectNo) {
		filterDataByHeader(xPathTbHeaderCell("//*[contains(@id,'pjRecogSumTable')]", "Project No."), projectNo);
		waitForAllJSCompletes();
		$("//tr[1]/td[8]/a | //tr[1]/td[8]/input").waitUntilClickable().click();
		waitForAllJSCompletes();	
	}

	private static final String xPathPanelProjectRecognition = "(//*[contains(@id,'mainPanel')]//ancestor-or-self::form)[1]";

	public void submit_voucher() {
		clickBtn(xPathPanelProjectRecognition,"Submit");
		clickBtnYesOnConfirmSubmit2();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}
		
	public void clickBtnYesOnConfirmSubmit2() {
		String xPathPanelConfirmSubmit = "//div[text()='Submit Confirmation' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}
}
