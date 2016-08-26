package com.synergix.globalsetup.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FixedAssetPage extends TH5PageObject {

	public FixedAssetPage(WebDriver driver) {
		super(driver);
	}

	public void typeFixedAssetCode(String fixedAssetCode) {
		enterInputFieldCodeWithLabel("Fixed Asset Code", fixedAssetCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeDetailedSpecification(String detailedSpecification) {
		enterTextAreaWithLabel("Detailed Specification", detailedSpecification);
	}

	public void typeFixedAssetClass(String fixedAssetClass) {
		enterInputFieldCodeWithLabel("Fixed Asset Class", fixedAssetClass);
	}

	public void typeFixedAssetCategory(String fixedAssetCategory) {
		enterInputFieldCodeWithLabel("Fixed Asset Category", fixedAssetCategory);
	}

	public void chooseDepreciationMethod(String depreciationMethod) {
		selectRadioButton("Depreciation Method", depreciationMethod);
	}

	public void chooseRateOnDecliningBalance(String rateOnDecliningBalance) {
		selectRadioButton("Rate On Declining Balance", rateOnDecliningBalance);
	}

	public void typePercentageofStraightLineRate(String percentageofStraightLineRate) {
		String xPath = "//td[following-sibling::td[text()='%']]/input[@type='text']";
		waitTypeAndEnter(xPath, percentageofStraightLineRate);
	}

	public void typeUsefulLifeYear(String usefulLifeYear) {
		enterInputFieldWithLabel("Useful Life Year", usefulLifeYear);
	}

	public void typeUsefulLifePeriod(String usefulLifePeriod) {
		enterInputFieldWithLabel("Useful Life Period", usefulLifePeriod);
	}

	public void typeTotalUsefulLife(String totalUsefulLife) {
		enterInputFieldWithLabel("Total Useful Life", totalUsefulLife);
	}

	public void chooseGlobalStatus(String globalStatus) {
		selectRadioButton("Global Status", globalStatus);
	}

	public void typeUOM(String uOM) {
		enterInputFieldCodeWithLabel("UOM", uOM);
	}

	public void typeVolume(String volume) {
		enterInputFieldWithLabel("Volume", volume);
	}

	public void typeGrossWeight(String grossWeight) {
		enterInputFieldWithLabel("Gross Weight", grossWeight);
	}

	public void typeLocation(String location) {
		enterInputFieldCodeWithLabel("Location", location);
	}

	public void chooseLocalInfoStatus(String localInfoStatus) {
		selectRadioButton("Local Info Status", localInfoStatus);
	}

	public void clickOnUpdateBtn() {
		clickBtn("Update");
		chooseYesOnUpdateConfirmation();
		chooseOKOnInfoPanel();
		waitForAllJSCompletes();
	}
}
