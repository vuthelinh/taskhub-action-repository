package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CusPaymentTabPage extends TH5PageObject {

	public CusPaymentTabPage(WebDriver driver) {
		super(driver);
	}

	private String xPathTbSearchResult = "//table[contains(@id, 'searchResult_Form:searchResult_Table')]";

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	public void selectOperationalCurrency(String operationalCurrency) {
		// $(xPathSearchIcon).click();
		clickSearchIconWithLabel("Operational Currency");
		enterInputFieldWithLabel("Currency Code", operationalCurrency);
		$(xPathTbDataCellByPosition(xPathTbSearchResult, 1, 1) + "/a[@href]").click();
		waitForAllJSCompletes();
	}

	public void typeReviewDate(String reviewDate) {
		enterInputFieldWithLabel("Next Credit Review Date", reviewDate);
	}

	public void clickDescription(String tableName, String description) {
		String xRowSelect = "//table[contains(@id, '" + tableName
				+ "')][child::thead]//td[1 and descendant-or-self::*[text()='" + description + "']]//*[@href]";
		clickOnElement(xRowSelect);
		waitForAllJSCompletes();
	}

	public void chooseIsActive(String tableName, String description) {
		String xRowSelect = "//table[contains(@id, '" + tableName
				+ "')][child::thead]//tr[child::td[1 and descendant-or-self::*[text()='" + description
				+ "']]]//*[@type='checkbox']";
		try {
			if (findAll(xRowSelect + "[@checked]").size() == 0) {
				clickOnElement(xRowSelect);
			}
		} catch (Exception e) {
			System.out.println("[*** NANCY ***] Exception: " + e);
		}
	}

	public void selectDefault(String tableName, String description) {
		String xRowSelect = "//table[contains(@id, '" + tableName
				+ "')][child::thead]//tr[child::td[1 and descendant-or-self::*[text()='" + description
				+ "']]]//*[@type='radio' and @value='true']";
		clickOnElement(xRowSelect);
		waitForAllJSCompletes();

	}
}
