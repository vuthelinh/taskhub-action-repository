package com.synergix.mastersetup.humanresource.employeeapprovingofficer;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.common.steps.HomeSteps;
import com.synergix.common.steps.LoginSteps;
import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplCompanyTabSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplGenerateAccSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.employee.steps.EmplParticularsTabSteps;
import com.synergix.mastersetup.humanresource.employeeapprovingofficer.steps.EmployeeSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class GenerateAccountDefs {

	@Steps
	MenuNavigationSteps onMenuNavigationSteps;

	@Steps
	LoginSteps onLoginSteps;

	@Steps
	MenuNavigationSteps onMenuNavigation;

	@Steps
	HomeSteps onHomeStep;

	@Steps
	EmployeeSteps onEmployeeSteps;

	@Steps
	EmplGenerateAccSteps onEmplGenerateAccSteps;

	@Steps
	EmplParticularsTabSteps onEmplParticularsTabSteps;

	@Steps
	EmplCompanyTabSteps onEmplCompanyTabSteps;

	@When("^user create new account as \"([^\"]*)\"$")
	public void user_create_new_account_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "createAcc";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colEmployeeCode = "Employee Code";
		String colEmployeeName = "Employee Name (NRIC/FIN/Bank account)";
		String colDateofBirth = "Date of Birth";
		String colCompany = "Company";
		String colNewUserName = "User Name";
		String colNewPassword = "Password";

		for (int rowcreateAcc : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colEmployeeCode);
			String employeeName = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colEmployeeName);
			String dateofBirth = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colDateofBirth);
			String company = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colCompany);
			String newUserName = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colNewUserName);
			String newPassword = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colNewPassword);

			dateofBirth = "01/01/1990";
			onEmployeeSteps.clickOnNewBtn();

			onEmployeeSteps.typeEmployeeCode(employeeCode);
			onEmployeeSteps.typeEmployeeName(employeeName);

			onEmployeeSteps.moveToParticularsTab();
			if (!dateofBirth.isEmpty()) {
				onEmplParticularsTabSteps.typeDateofBirth(dateofBirth);
			}

			onEmplCompanyTabSteps.moveToCompanyTab();
			if (company.toLowerCase().equals("all")) {
				onEmplCompanyTabSteps.chooseAllCompany();
			} else if (!company.isEmpty()) {
				onEmplCompanyTabSteps.chooseCompany(company);
			}

			onEmployeeSteps.generate_account();
			String pass = onEmployeeSteps.getPassword();

			onMenuNavigationSteps.clickOnHomeIcon();
			onHomeStep.logOut();

			onLoginSteps.goTo();
			onLoginSteps.login(employeeCode, pass, 2);
			onEmplGenerateAccSteps.current_password(pass);
			onEmplGenerateAccSteps.new_user_name(newUserName.toUpperCase());
			onEmplGenerateAccSteps.new_password(newPassword);
			onEmplGenerateAccSteps.confirm_new_password(newPassword);
			onEmplGenerateAccSteps.submit();
		}
	}

	@When("^user generate password for account as \"([^\"]*)\"$")
	public void user_generate_password_for_account_as(String dataKey,
			List<List<String>> dataTable) {

		String dataTableKey = "generateAccount";

		String colKEY = "KEY";
		String colEmployeeCode = "Employee Code";
		String colNewUserName = "User Name";
		String colNewPassword = "Password";

		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowcreateAcc : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String employeeCode = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colEmployeeCode);
			String newUserName = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colNewUserName);
			String newPassword = SessionData.getDataTbVal(dataTableKey,
					rowcreateAcc, colNewPassword);

			if (onEmployeeSteps.searchEmployeeByEmployeeCode(employeeCode)) {
				onEmployeeSteps.clickOnRsetPasswordBtn();
				String pass = onEmployeeSteps.getPassword();

				onMenuNavigationSteps.clickOnHomeIcon();
				onHomeStep.logOut();

				onLoginSteps.goTo();
				onLoginSteps.login(employeeCode, pass, 2);
				onEmplGenerateAccSteps.current_password(pass);
				onEmplGenerateAccSteps.new_user_name(newUserName);
				onEmplGenerateAccSteps.new_password(newPassword);
				onEmplGenerateAccSteps.confirm_new_password(newPassword);
				onEmplGenerateAccSteps.submit();
			}
		}
	}
}
