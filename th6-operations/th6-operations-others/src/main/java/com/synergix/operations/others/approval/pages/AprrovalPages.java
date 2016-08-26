package com.synergix.operations.others.approval.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class AprrovalPages extends TH5PageObject {

	public AprrovalPages(WebDriver driver) {
		super(driver);
	}

	public void clickInQueue(String radioValue, String transactionTypeDesc,
			String projectNo) {
		String xPathApproval = "//tr[count(//td[2][text()='"
				+ transactionTypeDesc
				+ "']/parent::tr/preceding-sibling::tr)+1]/td[3]/a";
		waitElementToBePresent(xPathApproval).click();

		switch_to_tab("In Queue");
		waitForAllJSCompletes();

		String xpathTable = "//input[@value='Submit']/following::table[1]";
		String xPathHeaderCell = "((" + xpathTable + "//tr)[1])/th[1]";
		filterDataByHeader(xPathHeaderCell, projectNo);

		String xRowSelected = xpathTable
				+ "/tbody//tr[child::td[1 and descendant::*[text()='"
				+ projectNo + "']]]//td[child::*[text()='" + radioValue
				+ "']]/input[@type='radio']";
		if (isElementExist(xRowSelected)) {
			clickOnElement(xRowSelected);
			clickBtn("Submit");
			chooseYesOnUpdateConfirmation();
		}
	}

	private static final String xPathPanelApproval = "(//table[contains(@class, 'rich-tabpanel-content')]//ancestor-or-self::form)[1]";

	public void click_btn_submit() {
		clickBtn(xPathPanelApproval, "Submit");
		clickBtnYesOnConfirmSubmit();
		String mes = getInfoPanelMessagesThenClickOK();
	}

	private String xPathPanelConfirmSubmit = "//div[text()='Submit Confirmation' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit)
				.shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

}
