package com.synergix.globalsetup.party.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class PartyPage extends TH5PageObject {

	public PartyPage(WebDriver driver) {
		super(driver);
	}

	private String xOwnBankTb = "//table[@id='partyForm:intAcctTable'][child::thead]";

	public void onClickNewButton() {
		findBtn("New").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void onClickUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

	public void typePartyCode(String partyCode) {
		enterInputFieldWithLabelNoVerify("Party Code", partyCode);
	}

	public void typePartyName(String partyName) {
		enterInputFieldWithLabelNoVerify("Party Name", partyName);
	}

	public void typePartyShortName(String partyShortName) {
		enterInputFieldWithLabel("Party Short Name", partyShortName);
	}

	public void typePartyGroupCode(String partyGroupCode) {
		enterInputFieldCodeWithLabel("Party Group Code", partyGroupCode);
	}

	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		enterInputFieldCodeWithLabel("Country Of Incorporation", countryOfIncorporation);
	}

	public void typeMainHomePage(String mainHomePage) {
		enterInputFieldWithLabel("Main Home Page", mainHomePage);
	}

	public void chooseTaxAgent(String taxAgent) {
		selectRadioButton("Tax Agent", taxAgent);
	}

	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		enterInputFieldWithLabel("GST Registration No", gSTRegistrationNo);
	}

	public void typeUniqueEntityNo(String uniqueEntityNo) {
		enterInputFieldWithLabel("Unique Entity No", uniqueEntityNo);
	}

	public void typePartyContraGLAN(String partyContraGLAN) {
		enterInputFieldCodeWithLabel("Party Contra GLAN", partyContraGLAN);
	}

	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		enterInputFieldCodeWithLabel("Contra Realized Exch GLAN", contraRealizedExchGLAN);
	}

	private String xpathPartyRelation = "//*[text()='Party Relation']/parent::div/following-sibling::div/input";
	private String xpathPartyType = "//*[text()='Service Type']/parent::div/following-sibling::div/input";

	public void chooseRelationService(String partyRelation, String serviceType) {
		$(xpathPartyRelation).typeAndEnter(partyRelation);
		waitForAllJSCompletes();
		$(xpathPartyType).typeAndEnter(serviceType);
		waitForAllJSCompletes();
		waitABit(1000);

		String xPathFirstRow = "//thead/following-sibling::tbody/tr[1]/td[3]//*[text()='Yes']/preceding-sibling::input[@type='radio']";
		$(xPathFirstRow).click();
		waitForAllJSCompletes();
	}

	public void clickOnAddBtn() {
		clickBtn("Add", 2);
		waitForAllJSCompletes();
	}

	private String parentXpath = "//table[@id='partyForm:intAcctTable']";

	public void typeAccountNo(String accountNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Account No.");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "/input",
				accountNo.toUpperCase());
	}

	public void typeBranchCode(String branchCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Branch Code");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "/input",
				branchCode.toUpperCase());
	}

	public void typeCurrencyCode(String currencyCode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Currency Code");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "/input",
				currencyCode.toUpperCase());
	}

	public void typeBankGLAN(String bankGLAN, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Bank GLAN");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "/input",
				bankGLAN.toUpperCase());
	}

	public void typeLastChequeNo(String lastChequeNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parentXpath, "Last Cheque No");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(parentXpath, rowIndex, colIndex) + "/input",
				lastChequeNo);
	}

	public void chooseCombineBCinPayment(int rowIndex) {
		int colNumber = getTbColHeaderIndexByText("Combine BC in Payment");
		selectRadioButton(xPathTbDataCellByPosition(parentXpath, rowIndex, colNumber) + "/input");
	}

	public void chooseCombineBCinReceipt(int rowIndex) {
		int colNumber = getTbColHeaderIndexByText("Combine BC in Receipt");
		selectRadioButton(xPathTbDataCellByPosition(parentXpath, rowIndex, colNumber) + "/input");
	}

	public void searchBank(String partyCode) {
		clickBtn("Search");
		getResultSearch("Party Code", partyCode);
	}

	public boolean isOwnBankDetailExit(String accountNo) {
		String xRowSelect = xOwnBankTb + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='54321' or @value='"
				+ accountNo.toUpperCase() + "']]]";
		if (isElementExist(xRowSelect))
			return true;
		return false;
	}

	public void chooseDelOwnBankDetail(String accountNo) {
		String xRowSelect = xOwnBankTb + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='54321' or @value='"
				+ accountNo.toUpperCase() + "']]]/td[8]//input";
		if (isElementExist(xRowSelect)) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			clickBtn("Delete", 3);
			waitForAllJSCompletes();
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}

	public int countRowTb() {
		String xRow = xOwnBankTb + "/tbody/tr";
		return findAll(xRow).size();
	}
}
