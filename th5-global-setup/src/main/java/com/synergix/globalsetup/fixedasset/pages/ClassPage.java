package com.synergix.globalsetup.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ClassPage extends TH5PageObject {

	public ClassPage(WebDriver driver) {
		super(driver);
	}

	public void typeFixedAssetClassCode(String fixedAssetClassCode) {
		enterInputFieldCodeWithLabel("Fixed Asset Class Code", fixedAssetClassCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeFixedAssetGLAN(String fixedAssetGLAN) {
		enterInputFieldCodeWithLabel("Fixed Asset GLAN", fixedAssetGLAN);
	}

	public void typeDepreciationGLAN(String depreciationGLAN) {
		enterInputFieldCodeWithLabel("Depreciation GLAN", depreciationGLAN);
	}

	public void typeCumulativeDepreciationGLAN(String cumulativeDepreciationGLAN) {
		enterInputFieldCodeWithLabel("Cumulative Depreciation GLAN", cumulativeDepreciationGLAN);
	}

	public void typeGainLossDisposalGLAN(String gainLossDisposalGLAN) {
		enterInputFieldCodeWithLabel("Gain Loss Disposal GLAN", gainLossDisposalGLAN);
	}

	public void typeDisposalClearingGLAN(String disposalClearingGLAN) {
		enterInputFieldCodeWithLabel("Disposal Clearing GLAN", disposalClearingGLAN);
	}

	public void typeFixedAssetClearingGLAN(String fixedAssetClearingGLAN) {
		enterInputFieldCodeWithLabel("Fixed Asset Clearing GLAN", fixedAssetClearingGLAN);
	}

	public void typeProjectUtilizationGlan(String projectUtilizationGlan) {
		enterInputFieldCodeWithLabel("Project Utilization Glan", projectUtilizationGlan);
	}

	public void onClickUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}
}
