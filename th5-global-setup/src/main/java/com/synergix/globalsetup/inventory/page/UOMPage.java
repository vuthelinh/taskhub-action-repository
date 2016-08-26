package com.synergix.globalsetup.inventory.page;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;
import com.synergix.utilities.ConnectDatabase;

public class UOMPage extends TH5PageObject {

	public UOMPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddNewBtn() {
		findBtn("New").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeUOMCode(String uOMCode) {
		enterInputFieldCodeWithLabel("UOM Code", uOMCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void clickOnUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

	public void checkType(String listType) {
		if (listType.contains("Inventory")) {
			String xpath = "//table[contains(@id, 'panUomDetail')]/tbody//td[preceding-sibling::td[text()='Type']]/input[1]";
			if (!$(xpath).isSelected()) {
				clickOnElement(xpath);
				waitForAllJSCompletes();
			}
		}
		if (listType.contains("Service")) {
			String xpath = "//table[contains(@id, 'panUomDetail')]/tbody//td[preceding-sibling::td[text()='Type']]/input[2]";
			if (!$(xpath).isSelected()) {
				clickOnElement(xpath);
				waitForAllJSCompletes();
			}
		}
	}

	public String check_database_exist(String uOMCode) {
		String sql_query = "SELECT * FROM MT_UOM WHERE UOM_CODE = '"+uOMCode+"'";
		ResultSet rs = null;
		ConnectDatabase.connect();
		rs = ConnectDatabase.executeQuery(sql_query);

		String result = "";
		try {
			while (rs.next()) {
				result= rs.getString("UOM_CODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabase.close();
		return result;
	}
}
