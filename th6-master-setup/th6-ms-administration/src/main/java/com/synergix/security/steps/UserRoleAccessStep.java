package com.synergix.security.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.security.pages.UserRoleAccessPage;

public class UserRoleAccessStep extends ScenarioSteps {

	UserRoleAccessPage onUserRoleAccessPage;

	public void switchToIFrame() {
		onUserRoleAccessPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onUserRoleAccessPage.switchOutDefaultIFrame();
	}

	@Step
	public boolean searchUserName(String userName) {
		return onUserRoleAccessPage.searchUserName(userName);
	}

	@Step
	public void clickOnAddBtn() {
		onUserRoleAccessPage.clickBtn("Add");
		onUserRoleAccessPage.waitForAllJSCompletes();
	}

	@Step
	public void addRoleCode(String roleCode) {
		onUserRoleAccessPage.typeRoleCode(roleCode);
	}

	@Step
	public void clickOnCloseBtn() {
		onUserRoleAccessPage.clickBtn("Close");
		onUserRoleAccessPage.waitForAllJSCompletes();
	}

}
