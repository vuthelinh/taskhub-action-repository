package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupSalePersonTabPage extends TH5PageObject {

	public SupSalePersonTabPage(WebDriver driver) {
		super(driver);
	}

	private String xAdd = "//input[@value='Add'][@type='button'][parent::form]";

	private String xPathTbCurrency = "//table[contains(@id,'tblCurrency')]";
	private String xPathTbSearchResult = "//table[contains(@id, 'searchResult_Form:searchResult_Table')]";

	private String xModelPanel = "//table[contains(@id, 'ModalPanel')]";
	private String xParentContactType = "//table[contains(@id, 'ContactDetails')]";
	private String xAddContactType = "//span/input[@value='Add'][@type='button']";
	private String xDelContactType = "//span/input[@value='Delete'][@type='button']";

	private String xParentContactContactType = "//table[contains(@id, 'ContactContDetails')]";

	private String xParentBankDetail = "//table[contains(@id, 'PartyBank')][child::thead]";

	private String xParentSBU = "//table[contains(@id, 'PartySbu')][child::thead]";

	private String xParentShipMode = "//td[contains(@id, 'ShipmentMode')][child::table[@class]]";
	private String xParentCountry = "//table[contains(@id, 'tblCountry')]";
	private String xAddCountry = "//table[contains(@id, 'shipmentInfoPanel')]//input[@value='Add'][@type='button']";
	private String xDeleteCountry = "//table[contains(@id, 'shipmentInfoPanel')]//input[@value='Delete'][@type='button']";

	private String xParentPort = "//table[contains(@id, 'tblPort')]";

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		String xPath = _parentXpath + "//tbody[preceding::thead]/tr[@class][" + _rowIndex + "]/td[" + _headerIndex
				+ "]";
		return xPath;
	}

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
		enterInputFieldCodeWithLabel("Supplier", supplier);
	}

	public void typeSupplierName(String supplierName) {
		enterInputFieldWithLabel("Supplier Name", supplierName);
	}

	public void typeSupplierClassCode(String supplierClassCode) {
		enterInputFieldCodeWithLabel("Supplier Class Code", supplierClassCode);
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

	public void searchParty(String supplier) {
		findBtn("Party").waitUntilClickable().click();
		String xPathLable = "(//table[@id='searchModalPanelContentTable']//*[text()='Party Code']//ancestor::td)[last()]/following-sibling::td//input[@type='text']";
		String xPathSearch = "(//table[@id='searchModalPanelContentTable']//*[text()='Party Code']//ancestor::td)[last()]/following-sibling::td//input[@type='button']";
		$(xPathLable).typeAndTab(supplier);
		$(xPathSearch).waitUntilClickable().click();
		waitForAllJSCompletes();
		String xPathFirstRow = "(//tbody[@id='searchResult_Form:searchResult_Table:tb']//a/span)[1]";
		$(xPathFirstRow).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	/**
	 * Region Address Tab
	 */

	public void clickOnAddAddressBtn() {
		$(xAdd).waitUntilClickable().click();
		if ($(xModelPanel).isPresent()) {
			$(xPathTbDataCellByPosition(xModelPanel, 1, 1) + "/a[@href]").waitUntilClickable().click();
		}
		waitForAllJSCompletes();
	}

	public void clickOnAddContactTypeBtn() {
		$(xAddContactType).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowContactTypeTb() {
		return countRowTb(xParentContactType);
	}

	public void typeAddressCode(String addressCode) {
		enterInputFieldCodeWithLabel("Address Code", addressCode);
	}

	public void typeAddressDescription(String addressDescription) {
		enterInputFieldWithLabel("Description", addressDescription);
	}

	public void typeAddress(String address) {
		enterTextAreaWithLabel("Address", address);
	}

	public void typeCountryCode(String countryCode) {
		enterInputFieldCodeWithLabel("Country Code", countryCode);
	}

	public void typeStateProvince(String stateProvince) {
		enterInputFieldWithLabel("State/Province", stateProvince);
	}

	public void typeCityTown(String cityTown) {
		enterInputFieldWithLabel("City/Town", cityTown);
	}

	public void typePostalCode(String postalCode) {
		enterInputFieldWithLabel("Postal Code", postalCode);
	}

	public void chooseIncType(String incType) {
		String xPathIncType = "//tr[child::*[text()='" + incType + "']]/td[1]/input";
		if (!$(xPathIncType).isSelected())
			$(xPathIncType).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseTypeDefault(String incType) {
		String xPathDefault = "//tr[child::*[text()='" + incType + "']]/td[3]/input";
		if (!$(xPathDefault).isSelected())
			$(xPathDefault).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseContactType(String contactType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Contact Type");
		selectDdlByText(xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex) + "/select", contactType);
	}

	public void typeContactInformation(String contactInformation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Contact Information");
		waitTypeAndEnterThenUpdateCodeValue(
				xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex) + "/input", contactInformation);
	}

	public void chooseContactTypeDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Default");
		$(xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactType, "Del");
		$(xPathTbDataCellByPosition(xParentContactType, rowIndex, colIndex) + "/input").waitUntilClickable().click();
		waitForAllJSCompletes();
		$(xDelContactType).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	/**
	 * Region Contact Tab
	 */

	public int countRowContactContactTypeTb() {
		return countRowTb(xParentContactContactType);
	}

	public void clickOnAddContact() {
		$(xAdd).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typePartyContactCode(String partyContactCode) {
		enterInputFieldCodeWithLabel("Party Contact Code", partyContactCode);
	}

	public void chooseSalutation(String salutation) {
		selectDdlWithLabelByText("Salutation", salutation);
	}

	public void typeFirstName(String firstName) {
		enterInputFieldWithLabel("First Name", firstName);
	}

	public void typeMiddleName(String middleName) {
		enterInputFieldWithLabel("Middle Name", middleName);
	}

	public void typeLastName(String lastName) {
		enterInputFieldWithLabel("Last Name", lastName);
	}

	public void typeName(String name) {
		enterInputFieldWithLabel("Name", name);
	}

	public void chooseAddressCode(String addressCode) {
		selectDdlWithLabelByText("Address Code", addressCode);
	}

	public void typeDesignation(String designation) {
		enterInputFieldWithLabel("Designation", designation);
	}

	public void typeDesignationGroup(String designationGroup) {
		enterInputFieldCodeWithLabel("Designation Group", designationGroup);
	}

	public void typeDepartment(String department) {
		enterInputFieldWithLabel("Department", department);
	}

	public void chooseContactTypeContactType(String contactTypeContactType, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Contact Type");
		selectDdlByText(xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex) + "/select",
				contactTypeContactType);
	}

	public void typeContactTypeContactInformation(String contactTypeContactInformation, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Contact Information");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex) + "/input",
				contactTypeContactInformation);
	}

	public void chooseContactTypeTypeDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Default");
		$(xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseContactTypeDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentContactContactType, "Del");
		$(xPathTbDataCellByPosition(xParentContactContactType, rowIndex, colIndex) + "/input").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
		$(xDelContactType).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	/**
	 * Region Bank Detail Tab
	 */

	public void clickOnAddBankDetail() {
		$(xAdd).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowBankDetal() {
		return countRowTb(xParentBankDetail);
	}

	public void typeBank(String bank, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Bank");
		String xPath = xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input";
		$(xPath).waitUntilPresent().typeAndEnter(bank);
		waitForAllJSCompletes();
	}

	public void typeDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Description");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				description);
	}

	public void typeAccountNo(String accountNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Account No.");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				accountNo);
	}

	public void typeBankCurrency(String currency, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Currency");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input",
				currency);
	}

	public void chooseBankDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Default");
		$(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void chooseBankDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentBankDetail, "Del");
		$(xPathTbDataCellByPosition(xParentBankDetail, rowIndex, colIndex) + "/input").waitUntilClickable().click();
		waitForAllJSCompletes();
		$(xDelContactType).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	/**
	 * Region SBU Tab
	 */

	public int countRowSBU() {
		return countRowTb(xParentSBU);
	}

	public void clickOnAddSBU() {
		$(xAdd).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeSBU(String sBU, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "SBU");
		waitTypeAndEnterThenUpdateCodeValue(xPathTbDataCellByPosition(xParentSBU, rowIndex, colIndex) + "/input", sBU);
	}

	public void typeSBUDescription(String description, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "description");
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xParentSBU, rowIndex, colIndex) + "/input",
				description);
	}

	public void typeDel(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentSBU, "Del");
		String xPath = xPathTbDataCellByPosition(xParentSBU, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected())
			$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();

		clickBtn("Delete", 2);
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	/**
	 * Region Local Info Tab
	 */
	// Shipment Term

	public void chooseInc(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Inc");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void typeShippingTerm(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Shipping Term");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseAir(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Air");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseSea(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Sea");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseRoad(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Road");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseRail(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Rail");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseShipmentDefault(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Default");
		String xPath = xPathTbDataCellByPosition(xParentShipMode, rowIndex, colIndex)
				+ "//input[following-sibling::label[text()='Yes']]";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	// Country Port Tab

	public void clickOnAddCountry() {
		$(xAddCountry).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickToOpenPort(int rowIndex) {
		String xPath = "//table[contains(@id, 'tblCountry')]//tbody[preceding::thead]/tr[@class][" + rowIndex
				+ "]/td[1]/a[@href]";
		$(xPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public int countRowCountry() {
		return countRowTb(xParentCountry);
	}

	public int getRowIndexCountry(String country) {
		String xPath = xParentCountry + "//tbody[preceding::thead]/tr[@class][descendant::input[@value ='"
				+ country.toUpperCase() + "']]/preceding-sibling::tr";
		return findAll(By.xpath(xPath)).size() + 1;
	}

	public int getRowIndexShipTerm(String shippingTerm) {
		int colIndex = getTbColHeaderIndex(xParentShipMode, "Shipment Term");
		String xPath = xParentShipMode + "//tbody[preceding::thead]/tr[@class][descendant::td[" + colIndex
				+ "][text()='" + shippingTerm + "']]/preceding-sibling::tr";
		return findAll(By.xpath(xPath)).size() + 1;
	}

	public int getRowIndexPort(String port) {
		return searchInTbMultiPage(xParentPort, "Port", 1, port, true);
	}

	public void typeCountry(String country, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Country");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input", country);
		waitForAllJSCompletes();
	}

	public void chooseLoading(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Loading");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDischarge(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Discharge");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseFinalDest(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Final Dest");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseDelCountry(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentCountry, "Del");
		String xPath = xPathTbDataCellByPosition(xParentCountry, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
		$(xDeleteCountry).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	// Port Tab

	public boolean findPort(String port) {

		String xPathPort = xParentPort
				+ "//tbody[preceding::thead]/tr[@class][descendant::td[1][text()='PORT 1-Port 1']]";
		return false;
	}

	public void choosePortLoading(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Loading");
		String xPath = xPathTbDataCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void choosePortDischange(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Discharge");
		String xPath = xPathTbDataCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void choosePortFinalDest(int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentPort, "Final Dest");
		String xPath = xPathTbDataCellByPosition(xParentPort, rowIndex, colIndex) + "/input";
		if (!$(xPath).isSelected()) {
			$(xPath).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	/**
	 * REGION DEFAULT TAB
	 */

	public void chooseDeductChargeFlag(String deductChargeFlag) {
		selectRadioButton("Deduct Charge Flag (COS)", deductChargeFlag);
	}

	public void chooseDeliveryToFornonCC(String deliveryToFornonCC) {
		selectRadioButton("Delivery To For non-CC (COS)", deliveryToFornonCC);
	}

	public void chooseDeliveryMode(String deliveryMode) {
		selectRadioButton("Delivery Mode", deliveryMode);
	}
}
