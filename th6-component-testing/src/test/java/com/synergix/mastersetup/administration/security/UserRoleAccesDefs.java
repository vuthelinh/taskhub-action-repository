package com.synergix.mastersetup.administration.security;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.security.steps.UserRoleAccessStep;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class UserRoleAccesDefs {
	@Steps
	UserRoleAccessStep onUserRoleAccessStep;

	@When("^user set role for user$")
	public void user_set_role_for_user(List<List<String>> dataTable) {
		String dataTableKey = "roleAccess";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colUserName = "User Name";

		onUserRoleAccessStep.switchToIFrame();
		for (int rowroleAccess : SessionData
				.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String userName = SessionData.getDataTbVal(dataTableKey,
					rowroleAccess, colUserName);

			String roleCode = "ADMIN>SYNSUPPORT";
			if (onUserRoleAccessStep.searchUserName(userName)) {
				onUserRoleAccessStep.addRoleCode(roleCode);
				onUserRoleAccessStep.clickOnCloseBtn();
			}
		}
		onUserRoleAccessStep.switchOutDefaultIFrame();
	}
}
