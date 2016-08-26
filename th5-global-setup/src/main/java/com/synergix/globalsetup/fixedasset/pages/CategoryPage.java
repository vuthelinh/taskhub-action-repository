package com.synergix.globalsetup.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CategoryPage extends TH5PageObject {

	public CategoryPage(WebDriver driver) {
		super(driver);
	}

	public void typeFixedAssetCategoryCode(String fixedAssetCategoryCode) {
		enterInputFieldCodeWithLabel("Fixed Asset Category Code", fixedAssetCategoryCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void clickOnUpdateBtn() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

}
