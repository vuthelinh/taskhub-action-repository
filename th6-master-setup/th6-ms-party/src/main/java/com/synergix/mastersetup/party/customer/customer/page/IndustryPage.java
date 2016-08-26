package com.synergix.mastersetup.party.customer.customer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;
import com.synergix.mastersetup.party.customer.customer.page.IndustryPage;

import net.thucydides.core.annotations.Step;

public class IndustryPage extends TH5PageObject {
	public IndustryPage(WebDriver driver) {
		super(driver);
	}

	private String xPathBtnNew = "//input[@value='New']";
	private String xPathBtnClose = "//input[@value='Close']";
	private String xPathBtnDelete = "//input[@value='Delete']";
	private String xPathBtnSearch = "//input[@value='Search']";
	private String xPathBtnUpdate = "//input[@value='Update']";
	private String xPathLinkIndustryCodeSearch = "//tbody[@id='searchResult_Form:searchResult_Table:tb']//td[1]/a[contains(@id,'searchResult_Form')]/span";
	private String xPathTxtIndustryCode = "//*[text()='Industry Code']/parent::td/following-sibling::td/input";
	private String xPathTxtDescription = "//*[text()='Description']/following-sibling::td/input";
	private String xPathBtnStatusPopup = "//*[@id='statusPopupPanel_OkButton']";

	public void click_btn_search() {
		waitElementToBeClickable(xPathBtnSearch).waitUntilClickable().click();

	}

	public void click_btn_new() {
		waitElementToBeClickable(xPathBtnNew).waitUntilClickable().click();

	}

	public void click_btn_Delete() {
		waitElementToBeClickable(xPathBtnDelete).waitUntilClickable().click();

	}

	public void click_btn_update() {
		waitElementToBeClickable(xPathBtnUpdate).waitUntilClickable().click();

	}

	public boolean search_result(String brandCodeSearch) {
		return search("Industry Code", brandCodeSearch);

	}

	public void click_on_brand_code_link() {
		String xPath = ".//*[@id='searchResult_Form:searchResults']/div/span[text()='No Records Found!']";
		if (isElementExist(xPath)) {
			$("//img[@src='/TH5Web/img/close-icon.gif']").waitUntilClickable().click();
		} else {
			waitElementToBePresent(xPathLinkIndustryCodeSearch).waitUntilClickable().click();
		}

	}

	public void enter_industry_code(String code) {
		waitTypeAndEnterThenUpdateValueOrError(xPathTxtIndustryCode, code);

	}

	public void enter_description(String description) {
		waitTypeAndEnter(xPathTxtDescription, description);

	}

	public void click_btn_status_popup() {
		if (isElementVisible(xPathBtnStatusPopup, 1)) {
			waitElementToBePresent(xPathBtnStatusPopup).waitUntilClickable().click();
		}
	}

}
