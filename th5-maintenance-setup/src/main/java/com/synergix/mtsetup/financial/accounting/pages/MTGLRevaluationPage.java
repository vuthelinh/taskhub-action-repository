package com.synergix.mtsetup.financial.accounting.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class MTGLRevaluationPage extends TH5PageObject {

	public MTGLRevaluationPage(WebDriver driver) {
		super(driver);
	}

	public void typeGLAccountCode(String gLAccountCode) {
		enterInputFieldCodeWithLabel("GL Account Code", gLAccountCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeUnrealisedGainLossGLAN(String unrealisedGainLossGLAN) {
		enterInputFieldCodeWithLabel("Unrealised Gain/Loss GLAN", unrealisedGainLossGLAN);
	}

}
