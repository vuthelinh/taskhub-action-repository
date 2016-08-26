package com.synergix.processing.fixedasset.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class FAGenerateDepreciationVchPage extends TH5PageObject {

	public FAGenerateDepreciationVchPage(WebDriver driver) {
		super(driver);
	}

	public void typeFixedAssetClassFrom(String fixedAssetClassFrom) {
		enterInputFieldCodeWithLabel("Fixed Asset Class From",
				fixedAssetClassFrom);
	}

	public void typeFixedAssetClassTo(String fixedAssetClassTo) {
		enterInputFieldCodeWithLabel("Fixed Asset Class To", fixedAssetClassTo);
	}

}
