package com.synergix.processing.bankbook.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class BKGenerateRecurringBankVchPage extends TH5PageObject {

	public BKGenerateRecurringBankVchPage(WebDriver driver) {
		super(driver);
	}

	public void typeGenerationDateFrom(String generationDateFrom) {
		enterInputFieldWithLabel("Generation Date From", generationDateFrom);
	}

	public void typeGenerationDateTo(String generationDateTo) {
		enterInputFieldWithLabel("Generation Date To", generationDateTo);
	}

	public void typeRecurringTemplateNoFrom(String recurringTemplateNoFrom) {
		enterInputFieldCodeWithLabel("Recurring Template No From",
				recurringTemplateNoFrom);
	}

	public void typeRecurringTemplateNoTo(String recurringTemplateNoTo) {
		enterInputFieldCodeWithLabel("Recurring Template No To",
				recurringTemplateNoTo);
	}

	String xGenerateVchInfo = "//div[child::div[text()='Generated Bank Book Voucher']]";

	public int getAmtVch() {
		try {
			String xAmt = xGenerateVchInfo
					+ "//td[preceding-sibling::td[text()='Number of Generated Bank Vouchers:']]";
			String sAmt = $(xAmt).getText().trim();
			int amtVch = Integer.parseInt(sAmt);
			return amtVch;
		} catch (Exception ex) {
			return 0;
		}
	}

	public String getFirstVch() {
		try {
			String xFirstVch = xGenerateVchInfo
					+ "//td[preceding-sibling::td[text()='First Bank Voucher No:']]";
			String firstVch = $(xFirstVch).getText().trim();
			return firstVch;
		} catch (Exception ex) {
			return "";
		}
	}
}
