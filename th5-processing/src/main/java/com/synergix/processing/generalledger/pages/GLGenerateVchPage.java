package com.synergix.processing.generalledger.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class GLGenerateVchPage extends TH5PageObject {

	public GLGenerateVchPage(WebDriver driver) {
		super(driver);
	}

	public void typeGenerationDateFrom(String generationDateFrom) {
		enterInputFieldWithLabel("Generation Date From", generationDateFrom);
	}

	public void typeGenerationDateTo(String generationDateTo) {
		enterInputFieldWithLabel("Generation Date To", generationDateTo);
	}

	public void typeRecurringVchCodeFrom(String recurringVchCodeFrom) {
		enterInputFieldCodeWithLabel("Recurring Vch Code From",
				recurringVchCodeFrom);
	}

	public void typeRecurringVchCodeTo(String recurringVchCodeTo) {
		enterInputFieldCodeWithLabel("Recurring Vch Code To",
				recurringVchCodeTo);
	}

	public void clickAndSubmitVchNo() {
		String xVchNo = "//table[contains(@id, 'generatedJV') and child::thead]/tbody//a[@href]";
		clickOnElement(xVchNo);
		waitForAllJSCompletes();
		clickBtn("Submit");
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}
}
