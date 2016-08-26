package com.synergix.globalsetup.financial.accounting.pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.synergix.common.LogWork;
import com.synergix.common.TH5PageObject;
import com.synergix.utilities.ConnectDatabase;

public class GLANPage extends TH5PageObject {

	public GLANPage(WebDriver driver) {
		super(driver);
	}

	public void typeGLAccountCode(String gLAccountCode) {
		enterInputFieldCodeWithLabel("GL Account Code", gLAccountCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeAccountType(String accountType) {
		selectRadioButton("Account Type", accountType);
	}

	public void typeStatus(String status) {
		selectRadioButton("Status", status);
	}

	public void typeForSubLedgerAccount(String forSubLedgerAccount) {
		selectRadioButton("For Sub Ledger Account", forSubLedgerAccount);
	}

	public void clickOnNewButton() {
		clickBtn("New");
		waitForAllJSCompletes();
	}

	public void clickOnUpdateButton() {
		clickBtn("Update");
		waitForAllJSCompletes();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}	
	
	public String check_database_exist(String objectCode) {
		String sql_query = "SELECT * FROM MT_CHART_OF_ACC_GLBL WHERE GL_ACC_CODE = '"+objectCode+"'";
		ResultSet rs = null;
		ConnectDatabase.connect();
		rs = ConnectDatabase.executeQuery(sql_query);

		String employeeRole = "";
		try {
			while (rs.next()) {
				employeeRole= rs.getString("GL_ACC_CODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabase.close();
		return employeeRole;
	}
}
