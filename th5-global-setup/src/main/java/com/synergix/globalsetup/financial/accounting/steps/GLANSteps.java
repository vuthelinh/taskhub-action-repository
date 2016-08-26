package com.synergix.globalsetup.financial.accounting.steps;

import com.synergix.globalsetup.financial.accounting.pages.GLANPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class GLANSteps extends ScenarioSteps {

	GLANPage onGLANPage;

	public void switchToIFrame() {
		onGLANPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onGLANPage.switchOutDefaultIFrame();
	}

	@Step
	public void typeGLAccountCode(String gLAccountCode) {
		onGLANPage.typeGLAccountCode(gLAccountCode);
	}

	@Step
	public void typeDescription(String description) {
		onGLANPage.typeDescription(description);
	}

	@Step
	public void typeAccountType(String accountType) {
		onGLANPage.typeAccountType(accountType);
	}

	@Step
	public void typeStatus(String status) {
		onGLANPage.typeStatus(status);
	}

	@Step
	public void typeForSubLedgerAccount(String forSubLedgerAccount) {
		onGLANPage.typeForSubLedgerAccount(forSubLedgerAccount);
	}

	@Step
	public void addNewGLAN() {
		onGLANPage.clickOnNewButton();
	}

	
	@Step
	/**
	 * Click on update button
	 */
	public void update() {
		onGLANPage.clickOnUpdateButton();
	}

	@Step
	public void checkAllCompany() {
		onGLANPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onGLANPage.chooseCompany(company);
	}

	@Step
	public void moveToCompanyTab() {
		onGLANPage.switch_to_tab("Company");
	}

	/**
	 * Edited by Steve
	 * @param gLAccountCode
	 * @return
	 */
	public boolean searchGLAN(String gLAccountCode) {
		onGLANPage.clickBtn("Search");
		onGLANPage.waitForAllJSCompletes();
		return onGLANPage.search("GL Account Code", gLAccountCode);
		
	}

	public void chooseDelCOA(String gLAccountCode) {
		onGLANPage.deleteValueBySearchBtn("Search", "GL Account Code", gLAccountCode);
	}
	
	/** Check GLAN Account is existed in DB
	 * @param gLAccountCode
	 * @return gLAccountCode
	 */
	@Step
	public String isExisted(String gLAccountCode){
		return onGLANPage.check_database_exist(gLAccountCode);
	}
}
