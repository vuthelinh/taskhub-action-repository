package com.synergix.globalsetup.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class LocationPage extends TH5PageObject {

	public LocationPage(WebDriver driver) {
		super(driver);
	}

	public void typeFixedAssetLocationCode(String fixedAssetLocationCode) {
		enterInputFieldCodeWithLabel("Fixed Asset Location Code", fixedAssetLocationCode);
	}

	public void typeFixedAssetLocationName(String fixedAssetLocationName) {
		enterInputFieldWithLabel("Fixed Asset Location Name", fixedAssetLocationName);
	}

	public void clickOnUpdateBtn() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

}
