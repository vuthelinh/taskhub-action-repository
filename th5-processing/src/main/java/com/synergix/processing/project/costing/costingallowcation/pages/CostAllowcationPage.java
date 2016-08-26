package com.synergix.processing.project.costing.costingallowcation.pages;

import com.synergix.common.TH5PageObject;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CostAllowcationPage extends TH5PageObject {
	public CostAllowcationPage(WebDriver driver){
		super(driver);
	}
	
	public String xpathTableDetails = "(//table[contains(@id,'costAlcFormDetail:tblCostAlcDetail')])";
	
	public String xpathCostAllocate = "(//table[contains(@id,'popupModalPanelContentTable')])";
	public String xpathCostAllocateTable = "(//table[contains(@id,'costAlcFormAllocDetail:tblBillDocAllocDetail')])";
	
	public void setDataCellTable( String xpathTable,String headerName, int currentRow, String type,int order, String value){
		int headerIndex = getTbColHeaderIndex(xpathTable, headerName, 1); // select header
		switch(type){
			case "textarea":
				waitTypeAndTab((xPathTbDataCellByPositionAndBodyIndex(xpathTable,1, currentRow, headerIndex) + "//textarea["+order+"]"),value);
				break;
			case "checkbox":
				setChkbox((xPathTbDataCellByPositionAndBodyIndex(xpathTable,1, currentRow, headerIndex) + "//input[contains(@type,'"+type+"')]["+order+"]"),value);
				break;
			case "radio":
				selectRadioButton((xPathTbDataCellByPositionAndBodyIndex(xpathTable,1, currentRow, headerIndex)+ "//input[contains(@type,'"+type+"')]["+order+"]"), value);
				break;
			case "select":
				selectDdlByText((xPathTbDataCellByPositionAndBodyIndex(xpathTable,1, currentRow, headerIndex) + "//select["+order+"]"), value);
				break;
			case "span":
				waitElementToBePresent(xPathTbDataCellByPositionAndBodyIndex("(" + xpathTable,1, currentRow, headerIndex) + "//span)["+order+"]").click();
				break;
			default:
				waitTypeAndTab((xPathTbDataCellByPositionAndBodyIndex(xpathTable,1, currentRow, headerIndex) + "//input[contains(@type,'"+type+"')]["+order+"]"),value);
				break;
		}
	}
	
	private static final String xPathPanelCostAllocation = "(//*[contains(@id,'mainPanel')]//ancestor-or-self::form)[1]";
	
	public void submit_voucher() {
		clickBtn(xPathPanelCostAllocation,"Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
		String xPathPanelConfirmSubmit = "//div[text()='Submit Confirmation' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
	}
	
	public void clickBtnYesOnConfirmSubmit() {
		String xPathPanelConfirmSubmit = "//div["+ sSpecialTextPredicates("You're about to submit this cost allocation .")+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}
	
	public void clickBtnYesOnConfirmSubmit2() {
		String xPathPanelConfirmSubmit = "//div[text()='Submit Confirmation' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}
}
