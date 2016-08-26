package com.synergix.mtsetup.financial.accounting.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class MTFinancialYearPeriodPage extends TH5PageObject {

	public MTFinancialYearPeriodPage(WebDriver driver) {
		super(driver);
	}

	public void typeFinancialYear(String financialYear) {
		enterInputFieldWithLabel("Financial Year", financialYear);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeBeginDate(String beginDate) {
		enterInputFieldWithLabel("Begin Date", beginDate);
	}

	public void typeEndDate(String endDate) {
		enterInputFieldWithLabel("End Date", endDate);
	}

	public void typeNoOfPeriod(String noOfPeriod) {
		enterInputFieldWithLabel("No. Of Period", noOfPeriod);
	}

	public void setCurrentYearPeriod(String beginDate) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();

		int currentMonth = Integer.parseInt(dateFormat.format(cal.getTime()).split("/")[1]);
		String currentYear = dateFormat.format(cal.getTime()).split("/")[2];
		int beginMonth = Integer.parseInt(beginDate.split("/")[1]);
		String currentPeriod;

		if (currentMonth < beginMonth) {
			currentPeriod = (currentMonth + 12 - beginMonth + 1) + "";
		} else {
			currentPeriod = (currentMonth - beginMonth + 1) + "";
		}

		for (int i = 1; i <= 5; i++) {
			typeYearPeriod(i, 1, currentYear);
			typeYearPeriod(i, 2, currentPeriod);
			waitABit(500);
			clickSaveBtn(i);
		}
	}

	public void typeYearPeriod(int row, int col, String value) {
		String xPath = "//tbody[contains(@id, 'periodTable')]/tr[" + row + "]/td[2]/input[" + col + "]";
		$(xPath).waitUntilPresent().typeAndEnter(value);
		waitForAllJSCompletes();
	}

	public void clickSaveBtn(int row) {
		String xPath = "//tbody[contains(@id, 'periodTable')]/tr[" + row + "]/td[3]/input";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

}
