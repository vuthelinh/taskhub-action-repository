package com.synergix.mastersetup.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.synergix.common.TH6PageObject;

import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by Ian on 8/4/2016.
 */
public class PolicyTypePage extends TH6PageObject {

	
	public static final String INPUT_DESCRIPTION = "/td[3]/input";
	public static final String BUTTON_UPDATE = "//button[.='Update']";

	public PolicyTypePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(@id,'syn:summary') and span[contains(@class,' fa-plus')]]")
	private WebElementFacade newButton;

	// TODO create click add new button on common
	public void clickAddNewButtonOnFunctionalPanel() {
		newButton.waitUntilPresent().click();
	}

	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[2]/input[@aria-readonly='false' and @aria-readonly='false']")
	private WebElementFacade newPolicyTypeCodeInput;

	public void enterPolicyTypeCodeAndEnter(String policyTypeCode) {
		newPolicyTypeCodeInput.typeAndEnter(policyTypeCode);
	}

	private String xpathRowPolicyType(String policyTypeCode) {
		return "//table[@role='grid']/tbody/tr[td[input[@value='" + policyTypeCode + "']]]";
	}

	public void enterPolicyTypeDescriptionForPolicyType(String policyTypeCode, String description) {
		waitTypeAndEnter(xpathRowPolicyType(policyTypeCode) + INPUT_DESCRIPTION, description);
	}

	public void clickUpdateForPolicyType(String policyTypeCode) {
		clickOnElement(xpathRowPolicyType(policyTypeCode) + BUTTON_UPDATE);
	}

	private String xPathBtnYesConfirmUpdate = "//div[contains(@id,'globalConfirmation')]//button[.='Yes']";

	public void clickBtnYesOnConfirmUpdate() {
		waitFor(xPathBtnYesConfirmUpdate);
		clickOnElement(xPathBtnYesConfirmUpdate);
		waitForAllJSCompletes();
	}

	/**
	 * Created by Zoe on 8/9/2016.
	 */


	public String get_text_policy_type_code(String policyTypeCode) {
		 String xPathEnter="//table[@role='grid']/tbody/tr/td[2]/input[@aria-readonly='false']";
		
		return $(xPathEnter).getValue();
	}


	public String get_text_description(String description) {
		
		String xPathDes="//input[@id='syn:summaryTblForm:entityTbl:0:description']";
		return $(xPathDes).getTextValue();
	}

	public void select_status(String status) {
		String xPathRadioBtn = "//*[contains(@class,'syn-radio-button')]";
		selectRadioButton(xPathRadioBtn);
	}

	public void click_btn_update() {
		String xPathUpdateBtn = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']";
		waitElementToBePresent(xPathUpdateBtn).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void click_btn_delete() { 
		String xPathBtnDel = "//span[@class='synfaces-float-right']/button[contains(@id,'syn:summary')]";
		waitElementToBePresent(xPathBtnDel).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void click_add_new() {
		String xPathAdd = "//span[@class='synfaces-float-left']";

		waitElementToBePresent(xPathAdd).waitUntilClickable().click();

		waitForAllJSCompletes();
	}

	public void enter_code(String policyTypeCode) {
		 String xPathEnter="//table[@role='grid']/thead/tr/th[2]/input[@aria-readonly='false']";
		waitTypeAndEnter(xPathEnter, policyTypeCode);
	}

	public void choose_policy_type(){
		String xPathChkBox="//div[@class='ui-chkbox ui-widget']";
		
		 if (waitElementToBePresent(xPathChkBox).getAttribute("checked") == null)
	        {
	            highlightElement(xPathChkBox + "//ancestor-or-self::td[1]");
	            clickOnElement(xPathChkBox);
	           
	        }
	        else
	        {
	            highlightElement(xPathChkBox + "//ancestor-or-self::td[1]");
	        }
		
	}

	public String get_result_code() {
		return $("//*[contains(@class,'ui-widget-content ui-datatable-empty-message')]").waitUntilPresent().getText();
	}
}
