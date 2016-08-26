package com.synergix.mtsetup.financial.accounting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class MTPeriodEndClosingPage extends TH5PageObject {

	public MTPeriodEndClosingPage(WebDriver driver) {
		super(driver);
	}

	public void chooseModuleCode(String moduleCode) {
		String parentXpath = "//tbody[contains(@id, 'periodEndCloseTable')]";
		String countRowXpath = "//tbody[contains(@id, 'periodEndCloseTable')]//td[2][text()='" + moduleCode
				+ "']/parent::tr/preceding-sibling::tr";

		int rowIndex = findAll(By.xpath(countRowXpath)).size() + 1;
		String xPathCell = "//tbody[contains(@id, 'periodEndCloseTable')]/tr[" + rowIndex + "]/td[1]";
		$(xPathCell).waitUntilClickable().click();
		waitForAllJSCompletes();
	}
}
