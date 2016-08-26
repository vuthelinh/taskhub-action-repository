package com.synergix.globalsetup.party.customer.page;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;
import com.synergix.utilities.DateTimeUtil;

public class CustomerPage extends TH5PageObject {

	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public String xAddBtnSpan = "//input[@value='Add'][@type='button'][parent::span]";
	public String xDeleteBtnSpan = "//input[@value='Delete'][@type='button'][parent::span]";

	public String xCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding-sibling::thead])[1]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	public String verifyMessagePopup() {
		return getErrorMessagesThenClickOK();
	}

	public int countRowTb(String xParent) {
		String xPath = xParent + "/tbody/tr[@class]";
		return findAll(By.xpath(xPath)).size();
	}

	public void onClickUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

	public void typeCustomerCode(String customerCode) {
		enterInputFieldWithLabelNoVerify("Customer Code", customerCode);
	}

	public void typeUniqueEntityNo(String uniqueEntityNo) {
		enterInputFieldWithLabel("Unique Entity No", uniqueEntityNo);
	}

	public void typeCustomerName(String customerName) {
		enterInputFieldWithLabelNoVerify("Customer Name", customerName);
	}

	public void typeCustomerClassCode(String customerClassCode) {
		String xCustomerClassCode = xPathInputFieldWithLabel("Customer Class Code");
		if (!isElementExist(xCustomerClassCode + "[@readonly]"))
			enterInputFieldCodeWithLabel("Customer Class Code", customerClassCode);
	}

	public void typePartyGroupCode(String partyGroupCode) {
		enterInputFieldCodeWithLabel("Party Group Code", partyGroupCode);
	}

	public void typeIndustryCode(String industryCode) {
		enterInputFieldCodeWithLabel("Industry Code", industryCode);
	}

	public void typeAcquiredBy(String acquiredBy) {
		enterInputFieldCodeWithLabel("Acquired By", acquiredBy);
	}

	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		enterInputFieldCodeWithLabel("Country Of Incorporation", countryOfIncorporation);
	}

	public void typeSalesTaxCode(String salesTaxCode) {
		enterInputFieldCodeWithLabel("Sales Tax Code", salesTaxCode);
	}

	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		enterInputFieldWithLabelNoVerify("Contra Realized Exch GLAN", contraRealizedExchGLAN);
		waitABit(500);
		if (yesBtn.isPresent()) {
			chooseYesOnUpdateConfirmation();
			waitABit(500);
		}
	}

	public void selectStatementDeliveryOption(String statementDeliveryOption) {
		selectDdlWithLabelByText("Statement Delivery Option", statementDeliveryOption);
	}

	public void typeDefaultTenor(String defaultTenor) {
		enterInputFieldCodeWithLabel("Default Tenor", defaultTenor);
	}

	public void typeDiscount(String discount) {
		enterInputFieldCodeWithLabel("Discount(%)", discount);
	}

	public void selectDueARInvoiceCorrespondenceLanguage(String dueARInvoiceCorrespondenceLanguage) {
		String xLabelLanguage = "//tbody/tr[descendant::*[text()='Correspondence Language']]/td[descendant-or-self::*[text()='English']]";

		if (dueARInvoiceCorrespondenceLanguage.contains("English")) {
			String xOption = xLabelLanguage + "/input[1]";
			if (!isElementExist(xOption + "[@checked]")) {
				clickOnElement(xOption);				
			}
		}
		if (dueARInvoiceCorrespondenceLanguage.contains("Chinese")) {
			String xOption = xLabelLanguage + "/input[2]";
			if (!isElementExist(xOption + "[@checked]")) {
				clickOnElement(xOption);
			}
		}

		// if (dueARInvoiceCorrespondenceLanguage.contains(",")) {
		// String[] language = dueARInvoiceCorrespondenceLanguage.split(",");
		// for (String lang : language) {
		// if (lang.trim().equals("English")) {
		// String xOption = xLabelLanguage+"/input[1]";
		// if (!isElementExist(xOption + "[@checked]")) {
		// clickOnElement(xOption);
		// }
		// } else if (lang.trim().equals("Chinese")) {
		// String xOption = xLabelLanguage+"/input[2]";
		// if (!isElementExist(xOption + "[@checked]")) {
		// clickOnElement(xOption);
		// }
		// }
		// }
		// } else {
		// if (dueARInvoiceCorrespondenceLanguage.trim().equals("English")) {
		// String xOption = xLabelLanguage+"/input[1]";
		// if (!isElementExist(xOption + "[@checked]")) {
		// clickOnElement(xOption);
		// }
		//
		// } else if
		// (dueARInvoiceCorrespondenceLanguage.trim().equals("Chinese")) {
		// String xOption = xLabelLanguage+"/input[2]";
		// if (!isElementExist(xOption + "[@checked]")) {
		// clickOnElement(xOption);
		// }
		// }
		// }
	}

	public void typeCustomerRemarks(String customerRemarks) {
		enterTextAreaWithLabel("Customer Remarks", customerRemarks);
	}

	public void selectStatus(String status) {
		selectRadioButton("Status", status);
	}

	public void typeMainCustomerCode(String mainCustomerCode) {
		enterInputFieldCodeWithLabel("Main Customer Code", mainCustomerCode);
	}

	public void typeCustomerShortName(String customerShortName) {
		enterInputFieldWithLabel("Customer Short Name", customerShortName);
	}

	public void typeCustomerCategoryCode(String customerCategoryCode) {
		enterInputFieldCodeWithLabel("Customer Category Code", customerCategoryCode);
	}

	public void typeCustomerGroupCode(String customerGroupCode) {
		enterInputFieldCodeWithLabel("Customer Group Code", customerGroupCode);
	}

	public void selectCustomerType(String customerType) {
		selectDdlWithLabelByText("Customer Type", customerType);
	}

	public void typeMainHomePage(String mainHomePage) {
		enterInputFieldWithLabel("Main Home Page", mainHomePage);
	}

	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		enterInputFieldWithLabel("GST Registration No", gSTRegistrationNo);
	}

	public void typePartyContraGLAN(String partyContraGLAN) {
		enterInputFieldWithLabelNoVerify("Party Contra GLAN", partyContraGLAN);
		waitABit(500);
		if (yesBtn.isPresent()) {
			chooseYesOnUpdateConfirmation();
			waitABit(500);
		}
	}

	public void typeDefaultValidity(String defaultValidity) {
		enterInputFieldCodeWithLabel("Default Validity", defaultValidity);
	}

	public void typeDefaultTenorTermCode(String defaultTenorTermCode) {
		enterInputFieldCodeWithLabel("Default Tenor Term Code", defaultTenorTermCode);
	}

	public void typePriceMarkupPercent(String priceMarkupPercent) {
		enterInputFieldWithLabel("Price Markup Percent", priceMarkupPercent);
	}

	public void selectCombineShmtoInvoices(String combineShmtoInvoices) {
		selectRadioButton("Combine Shm to Invoices", combineShmtoInvoices);
	}

	public void selectIPTRelated(String iPTRelated) {
		selectRadioButton("IPT Related", iPTRelated);
	}

	public void typeShippingMarksCode(String shippingMarksCode) {
		enterInputFieldCodeWithLabel("Shipping Marks Code", shippingMarksCode);
	}

	public boolean searchCustomer(String customerCode) {
		if (!customerCode.isEmpty()) {
			clickBtn("Search");
			String xSearchForm = "//table[@id='searchModalPanelContentTable']";

			enterInputFieldWithLabel(xSearchForm, "Customer Code", customerCode);
			clickBtn(xSearchForm, "Search");
			String xRowSelected = xSearchForm
					+ "//table[@id='searchResult_Form:searchResult_Table']//*[@href and descendant::*[text()='"
					+ customerCode.toUpperCase() + "'] and parent::td[1]]";
			if (isElementExist(xRowSelected)) {
				clickOnElement(xRowSelected);
				waitForAllJSCompletes();
				return true;
			}
		}
		return false;
	}

	public String autoGenCode(String autoGenCode) {
		String result=autoGenCode;		
		String a=new SimpleDateFormat("dd/MM/yy HH:mm").format(new Date());
		result+=a.replace("/", "").replace(":","").replace(" " ,"").trim();
		return result;
	}
}
