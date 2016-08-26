package com.synergix.processing.accountspayable.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class APRevaluationPage extends TH5PageObject {
	public APRevaluationPage(WebDriver driver) {
		super(driver);
	}

	private String xCurrencyTb = "//table[contains(@id, 'apRevalDetailCurr:apRevalCurrTable')]";

	public void typeRevaluationVoucherNo(String revaluationVoucherNo) {
		enterInputFieldCodeWithLabel("Revaluation Voucher No.",
				revaluationVoucherNo);
	}

	public void typeRevaluationVoucherDate(String revaluationVoucherDate) {
		enterInputFieldWithLabel("Revaluation Voucher Date",
				revaluationVoucherDate);
	}

	public void typeDescription(String description) {
		enterTextAreaWithLabel("Description", description);
	}

	public void typeCurrency(String currency, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xCurrencyTb, "Currency");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xCurrencyTb, rowIndex, colIndex)
						+ "//input", currency);
	}

	public void typeExchRate(String exchRate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xCurrencyTb, "Exch Rate");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xCurrencyTb, rowIndex, colIndex)
						+ "//input", exchRate);
	}

	public void chooseDel(String del, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xCurrencyTb, "Del");
		clickOnElement(xPathTbDataCellByPosition(xCurrencyTb, rowIndex,
				colIndex) + "//input[@type='checkbox']");
		waitForAllJSCompletes();
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public int getRowCcyTb() {
		return findAll(xCurrencyTb + "/tbody/tr[@class]").size();
	}

	public void chooseDelAllCurrency() {
		String xDelAll = xCurrencyTb
				+ "/thead//th[descendant::*[text()='Del']]//input";
		if (!$(xDelAll).isSelected()) {
			clickOnElement(xDelAll);
			waitForAllJSCompletes();
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public boolean searchDrafVoucherNo(String revaluationVoucherNo) {
		String xDraftTb = "//table[contains(@id, 'apRevalSum') and child::thead]";
		waitTypeAndEnter(xPathTbHeaderCell(xDraftTb, "Revaluation Voucher No.")
				+ "//input", revaluationVoucherNo);

		String xRowSelect = xDraftTb
				+ "/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
				+ revaluationVoucherNo.toUpperCase() + "']]]//a[@href]";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

}
