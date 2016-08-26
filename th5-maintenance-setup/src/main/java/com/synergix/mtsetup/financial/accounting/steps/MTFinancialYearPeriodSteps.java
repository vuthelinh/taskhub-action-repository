package com.synergix.mtsetup.financial.accounting.steps;

import com.synergix.mtsetup.financial.accounting.pages.MTFinancialYearPeriodPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MTFinancialYearPeriodSteps extends ScenarioSteps {

	MTFinancialYearPeriodPage onMTFinancialYearPeriodPage;

	public void switchToIFrame() {
		onMTFinancialYearPeriodPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onMTFinancialYearPeriodPage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnNewBtn() {
		onMTFinancialYearPeriodPage.clickBtn("New");
		onMTFinancialYearPeriodPage.waitForAllJSCompletes();
	}

	@Step
	public void clickOnAutoGeneratePeriodBtn() {
		onMTFinancialYearPeriodPage.clickBtn("Auto Generate Period");
		onMTFinancialYearPeriodPage.waitForAllJSCompletes();
	}

	@Step
	public void typeFinancialYear(String financialYear) {
		onMTFinancialYearPeriodPage.typeFinancialYear(financialYear);
	}

	@Step
	public void typeDescription(String description) {
		onMTFinancialYearPeriodPage.typeDescription(description);
	}

	@Step
	public void typeBeginDate(String beginDate) {
		onMTFinancialYearPeriodPage.typeBeginDate(beginDate);
	}

	@Step
	public void typeEndDate(String endDate) {
		onMTFinancialYearPeriodPage.typeEndDate(endDate);
	}

	@Step
	public void typeNoOfPeriod(String noOfPeriod) {
		onMTFinancialYearPeriodPage.typeNoOfPeriod(noOfPeriod);
	}

	@Step
	public void setCurrentYearPeriod(String beginDate) {
		onMTFinancialYearPeriodPage.setCurrentYearPeriod(beginDate);
	}

	@Step
	public void chooseDelFinancialYear(String financialYear) {
		onMTFinancialYearPeriodPage.deleteValueBySearchBtn("Search", "Financial Year", financialYear);
	}
}
