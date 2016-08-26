package com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synergix.common.TH6PageObject;

import net.serenitybdd.core.annotations.findby.By;

public class EmplParticularsTabPage extends TH6PageObject {

	public EmplParticularsTabPage(WebDriver driver) {
		super(driver);
	}
	

	public void select_item_by_text(String label, String value) {
		waitForAjaxLoadCompleted();
		$("//*[text()='" + label + "']/following-sibling::div//label[text()='Please Select']").waitUntilClickable().click();
		$("//*[text()='" + label + "']/following::div//li[text()='" + value + "']").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	// PARTICULARS TAB
	public void typeDateofBirth(String dateofBirth) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Date of Birth", 1), dateofBirth);
	}

	public void salutation(String salutation) {
		withAction().moveToElement($("(//button[@type='button'])[3]")).doubleClick().build().perform();
		withAction().moveToElement($("//li[@data-item-label='" + salutation + "']")).click().build().perform();
	}

	public void gender(String gender) {
		select_item_by_text("Gender", gender);
	}

	public void marital_status(String marital_status) {
		select_item_by_text("Marital Status", marital_status);
	}

	public void race(String race) {
		select_item_by_text("Race", race);
	}

	public void nationality(String nationality) {
		if (!nationality.isEmpty())
			if (nationality.equals("Singaporean")) {
				select_item_by_text("Nationality", nationality);
				$("//div[2]/div/button/span[text()='Submit']").waitUntilVisible().click();
				waitForAllJSCompletes();
			} else {
				select_item_by_text("Nationality", nationality);
			}
	}

	public void religion(String religion) {
		select_item_by_text("Religion", religion);
	}

	public void date_to_become_pr(String date_to_become_pr) {
		waitTypeAndEnterThenUpdateDate(xPathInputFieldWithLabel("Date to Become PR", 1), date_to_become_pr);
	}

	public void smart_card_no(String smart_card_no) {
		enterTextAreaWithLabel("Smart Card No.", smart_card_no);
	}

	public void home_address(String home_address) {
		enterTextAreaWithLabel("Home Address", home_address);
	}

	public void postal_code(String postal_code) {
		enterInputFieldWithLabel("Postal Code", postal_code);
	}

	public void country_code(String country_code) {
		enterInputFieldWithLabel("Country Code", country_code);
	}

	public void overseas_address(String overseas_address) {
		enterTextAreaWithLabel("Overseas Address", overseas_address);
	}

	public void overseas_postal_code(String overseas_postal_code) {
		enterInputFieldWithLabel("ZIP/Postal Code", overseas_postal_code);
	}

	public void overseas_country_code(String overseas_country_code) {
		waitTypeAndTabThenUpdateValue("//tr[7]/td[3]/div[2]/span/span/input", overseas_country_code);
		waitForAllJSCompletes();
	}

	/* Identification / Documents */

	public void type_of_identification(String type) {
		$("(//*[text()='Type']/following::div//label[text()='FIN'])[last()]").waitUntilClickable().click();
		$("(//*[text()='Type']/following::div//li[text()='"+type+"'])[last()]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	private String xpathTableDetails = "//div[contains(@id,'accordionPanel:particularsTab:idenDocform:idDocumentTabl')]//div[@class='ui-datatable-tablewrapper']/table/tbody/tr/";

	public void no(String no) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails+"td[2]/input)[last()]",no);
		waitForAllJSCompletes();
	}

	public void application_date(String application_date) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails+"td[3]/span/input)[last()]",application_date);
		waitForAjaxLoadCompleted();
	}

	public void issue_date(String issue_date) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails+"td[4]/span/input)[last()]",issue_date);
		waitForAjaxLoadCompleted();
	}

	public void expiry_date(String expiry_date) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails+"td[5]/span/input)[last()]",expiry_date);
		waitForAjaxLoadCompleted();
	}

	public void card_return_date(String card_return_date) {
		waitTypeAndEnterThenUpdateDate("("+xpathTableDetails+"td[6]/span/input)[last()]",card_return_date);
		waitForAjaxLoadCompleted();
	}

	public void is_default(String is_default) {
		if (is_default.equalsIgnoreCase("Yes"))
			checkChkbox("("+xpathTableDetails+"td[7]/div/div[2])[last()]");
			waitForAjaxLoadCompleted();
	}

	public void del(String del) {
		if (del.equalsIgnoreCase("Yes"))
			checkChkbox("("+xpathTableDetails+"td[8]/div/div[2])[last()]");
			waitForAjaxLoadCompleted();
	}

	public void addIdentification() {
		$("(//button[contains(@id,'accordionPanel:particularsTab:idenDocform:idDocumentTabl')])[1]").click();
		waitForAllJSCompletes();
	}
	
	public void waitForAjaxLoadCompleted(){
		waitABit(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), 30); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxSpinner"))); 
	}
}
