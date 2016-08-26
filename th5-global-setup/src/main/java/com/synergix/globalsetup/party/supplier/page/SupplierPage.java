package com.synergix.globalsetup.party.supplier.page;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupplierPage extends TH5PageObject {

	public SupplierPage(WebDriver driver) {
		super(driver);
	}

	private String xParentSearchTb = "//div[@id='searchModalPanelCDiv']";
	private String xPathTbCurrency = "//table[contains(@id,'tblCurrency')]";
	private String xPathTbSearchResult = "//table[contains(@id, 'searchResult_Form:searchResult_Table')]";

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		String xPath = _parentXpath + "//tbody[preceding::thead]/tr[@class][" + _rowIndex + "]/td[" + _headerIndex
				+ "]";
		return xPath;
	}

	public void onClickNewButton() {
		clickBtn("New");
		waitForAllJSCompletes();
	}

	public void onClickUpdateButton() {
		try {
			findBtn("Update").waitUntilClickable().click();
			chooseYesOnUpdateConfirmation();
			chooseOKOnInfoPanel();
		} catch (Exception ex) {
		}
		waitForAllJSCompletes();
	}

	public void updateCustomer(String customerCode) {
		findBtn("Search").waitUntilClickable().click();
		String xPathLable = "(//table[@id='searchModalPanelContentTable']//*[text()='Customer Code']//ancestor::td)[last()]/following-sibling::td//input[@type='text']";
		String xPathsearch = "(//table[@id='searchModalPanelContentTable']//*[text()='Customer Code']//ancestor::td)[last()]/following-sibling::td//input[@type='button']";
		$(xPathLable).typeAndTab(customerCode);
		$(xPathsearch).waitUntilClickable().click();
		String xPathFirstRow = "(//tbody[@id='searchResult_Form:searchResult_Table:tb']//a/span)[1]";
		$(xPathFirstRow).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnAddCurrencyBtn() {
		clickBtn("Add");
		waitABit(1000);
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	public void typeSupplier(String supplier) {
		enterInputFieldWithLabelNoVerify("Supplier", supplier);
	}

	public void typeSupplierName(String supplierName) {
		enterInputFieldWithLabelNoVerify("Supplier Name", supplierName);
	}

	public void typeSupplierClassCode(String supplierClassCode) {
		try {
			enterInputFieldCodeWithLabel("Supplier Class Code", supplierClassCode);
		} catch (Exception ex) {
		}
	}

	public void typePartyGroupCode(String partyGroupCode) {
		enterInputFieldCodeWithLabel("Party Group Code", partyGroupCode);
	}

	public void typeMainHomePage(String mainHomePage) {
		enterInputFieldWithLabel("Main Home Page", mainHomePage);
	}

	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		enterInputFieldWithLabel("GST Registration No", gSTRegistrationNo);
	}

	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		enterInputFieldCodeWithLabel("Country Of Incorporation", countryOfIncorporation);
	}

	public void typeSubconWIPGlan(String subconWIPGlan) {
		enterInputFieldCodeWithLabel("Subcon WIP Glan", subconWIPGlan);
	}

	public void typeSalesTaxCode(String salesTaxCode) {
		enterInputFieldCodeWithLabel("Sales Tax Code", salesTaxCode);
	}

	public void typeDefaultTenorTermCode(String defaultTenorTermCode) {
		enterInputFieldCodeWithLabel("Default Tenor Term Code", defaultTenorTermCode);
	}

	public void typeDefaultTenor(String defaultTenor) {
		enterInputFieldWithLabel("Default Tenor", defaultTenor);
	}

	public void chooseIPTRelated(String iPTRelated) {
		selectRadioButton("IPT Related", iPTRelated);
	}

	public void chooseStatus(String status) {
		selectRadioButton("Status", status);
	}

	public void typeUniqueEntityNo(String uniqueEntityNo) {
		enterInputFieldWithLabel("Unique Entity No", uniqueEntityNo);
	}

	public void typeMainSupplierCode(String mainSupplierCode) {
		enterInputFieldCodeWithLabel("Main Supplier Code", mainSupplierCode);
	}

	public void typeSupplierShortName(String supplierShortName) {
		enterInputFieldWithLabel("Supplier Short Name", supplierShortName);
	}

	public void typeSupplierCategoryCode(String supplierCategoryCode) {
		enterInputFieldCodeWithLabel("Supplier Category Code", supplierCategoryCode);
	}

	public void typeSupplierRankCode(String supplierRankCode) {
		enterInputFieldCodeWithLabel("Supplier Rank Code", supplierRankCode);
	}

	public void typePurchasingZone(String purchasingZone) {
		enterInputFieldCodeWithLabel("Purchasing Zone", purchasingZone);
	}

	public void typePartyContraGLAN(String partyContraGLAN) {
		enterInputFieldWithLabelNoVerify("Party Contra GLAN", partyContraGLAN);
		waitForAllJSCompletes();
		waitABit(500);
		if (yesBtn.isCurrentlyVisible()) {
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
			waitABit(500);
		}
	}

	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		enterInputFieldWithLabelNoVerify("Contra Realized Exch GLAN", contraRealizedExchGLAN);
		waitForAllJSCompletes();
		waitABit(500);
		if (yesBtn.isCurrentlyVisible()) {
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
			waitABit(500);
		}
	}

	public void typeDefaultDiscountPercent(String defaultDiscountPercent) {
		enterInputFieldWithLabel("Default Discount Percent", defaultDiscountPercent);
	}

	public void chooseCombineShmtoInvoices(String combineShmtoInvoices) {
		selectRadioButton("Combine Shm to Invoices", combineShmtoInvoices);
	}

	public void typeRemarks(String remarks) {
		enterTextAreaWithLabel("Remarks", remarks);
	}

	public void typeCurrency(String currency) {
		waitElementToBePresent(xPathTbGetLastDataCellByHeaderIndex(xPathTbCurrency, 1) + "/input");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbCurrency, 1) + "/input", currency);
	}

	public void selectOperationalCurrency(String operationalCurrency) {
		clickSearchIconWithLabel("Operational Currency");
		enterInputFieldWithLabel("Currency Code", operationalCurrency);
		$(xPathTbDataCellByPosition(xPathTbSearchResult, 1, 1) + "/a[@href]").click();
		waitForAllJSCompletes();
	}

	public void typeOverallCreditLimit(String overallCreditLimit) {
		enterInputFieldWithLabel("Overall Credit Limit", overallCreditLimit);
	}

	public void clickDescription(String tableName, String description) {
		int rowIndex = findAll(By.xpath("(//table[contains(@id, '" + tableName + "')]//*[text()='" + description
				+ "']/ancestor::tr)[last()]/preceding-sibling::tr")).size() + 1;
		String xPath = "(//table[contains(@id, '" + tableName + "')]//tbody/tr/td[contains(@class, 'cell')][1])["
				+ rowIndex + "]/a[@href]";
		$(xPath).click();
		waitForAllJSCompletes();
	}

	public void chooseIsActive(String tableName, String description) {
		int rowIndex = findAll(By.xpath("(//table[contains(@id, '" + tableName + "')]//*[text()='" + description
				+ "']/ancestor::tr)[last()]/preceding-sibling::tr")).size() + 1;
		String xPath = "(//table[contains(@id, '" + tableName + "')]//tbody/tr/td[contains(@class, 'cell')][2])["
				+ rowIndex + "]/input[@type='checkbox']";

		if (!$(xPath).isSelected()) {
			$(xPath).click();
			waitForAllJSCompletes();
		}
	}

	public void selectDefault(String tableName, String description) {
		int rowIndex = findAll(By.xpath("(//table[contains(@id, '" + tableName + "')]//*[text()='" + description
				+ "']/ancestor::tr)[last()]/preceding-sibling::tr")).size() + 1;
		String xPath = "(//table[contains(@id, '" + tableName + "')]//tbody/tr/td[contains(@class, 'cell')][3])["
				+ rowIndex + "]//*[text()='Yes']";
		$(xPath).click();
		waitForAllJSCompletes();
	}

	public void updateSupplier(String supplier) {
		findBtn("Search").waitUntilClickable().click();
		String xPathLable = "(//table[@id='searchModalPanelContentTable']//*[text()='Supplier Code']//ancestor::td)[last()]/following-sibling::td//input[@type='text']";
		String xPathSearch = "(//table[@id='searchModalPanelContentTable']//*[text()='Supplier Code']//ancestor::td)[last()]/following-sibling::td//input[@type='button']";
		$(xPathLable).typeAndTab(supplier);
		$(xPathSearch).waitUntilClickable().click();
		String xPathFirstRow = "(//tbody[@id='searchResult_Form:searchResult_Table:tb']//a/span)[1]";
		$(xPathFirstRow).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public boolean searchParty(String supplier) {
		clickBtn("//div[contains(@id, 'panSupplierDetail')]", "Party");
		enterInputFieldCodeWithLabel(xParentSearchTb, "Party Code", supplier);
		waitForAllJSCompletes();
		String xRowSelected = xParentSearchTb + xPathTbSearchResult
				+ "/tbody/tr[child::td[1 and descendant-or-self::*[text()='" + supplier.toUpperCase()
				+ "']]]/td[1]/*[@href]";
		try {
			clickOnElement(xRowSelected);
			waitForAllJSCompletes();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean searchSupplier(String supplier) {
		clickBtn("//div[contains(@id, 'panSupplierDetail')]", "Search");
		enterInputFieldCodeWithLabel(xParentSearchTb, "Supplier Code", supplier);
		waitForAllJSCompletes();
		String xRowSelected = xParentSearchTb + xPathTbSearchResult
				+ "/tbody/tr[child::td[1 and descendant-or-self::*[text()='" + supplier.toUpperCase()
				+ "']]]/td[1]/*[@href]";
		try {
			clickOnElement(xRowSelected);
			waitForAllJSCompletes();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String autoGenCode(String prefixAutoGenCode) {
		String result = prefixAutoGenCode;
		String a = new SimpleDateFormat("dd/MM/yy HH:mm").format(new Date());
		result += a.replace("/", "").replace(":", "").replace(" ", "").trim();
		return result;
	}

	public String verifyMessagePopup() {
		return getErrorMessagesThenClickOK();
	}
}
