package com.synergix.definition.pretest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.party.customer.steps.CusAddressTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusBankDetailTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusCompanyTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusContactTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusCurrencyTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusLocalInfoTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusPaymentTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusSBUTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusSalePersonTabSteps;
import com.synergix.globalsetup.party.customer.steps.CustomerSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLCustomerDefs {
	@Steps
	CustomerSteps onCustomerSteps;
	@Steps
	CusAddressTabSteps onCusAddressTabSteps;
	@Steps
	CusContactTabSteps onCusContactTabSteps;
	@Steps
	CusBankDetailTabSteps onCusBankDetailTabSteps;
	@Steps
	CusCompanyTabSteps onCusCompanyTabSteps;
	@Steps
	CusSBUTabSteps onCusSBUTabSteps;
	@Steps
	CusCurrencyTabSteps onCusCurrencyTabSteps;
	@Steps
	CusLocalInfoTabSteps onCusLocalInfoTabSteps;
	@Steps
	CusPaymentTabSteps onCusPaymentTabSteps;
	@Steps
	CusSalePersonTabSteps onCusSalePersonTabSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_PARTY + "Customer.xls";
	String keyFileName = "Customer";
	String datasetSheet = "Customer";

	String addressSheet = "Address";
	String addressIncTypeSheet = "AddressIncType";
	String addressContactTypeSheet = "AddressContactType";

	String contactSheet = "Contact";
	String contactIncTypeSheet = "ContactIncType";
	String contactTypeSheet = "ContactType";

	String currencySheet = "Currency";

	String paymentSheet = "Payment";
	String paymentOptionSheet = "Payment Option";
	String paymentTermSheet = "Payment Term";
	String paymentMethodSheet = "Payment Method";

	String bankDetailSheet = "BankDetail";

	String sBUSheet = "SBU";
	String salesPersonSheet = "SalesPerson";

	String companySheet = "Company";

	String localPricingSheet = "LocalPricing";
	String pricingListSheet = "PricingList";
	String localCreditLimitTermSheet = "LocalCreditLimitTerm";

	String localShipmentTermSheet = "LocalShipmentTerm";
	String localShipmentPortSheet = "LocalShipmentPort";
	String localDetailPortSheet = "LocalDetailPort";

	String localCustomerInventorySheet = "LocalCustomerInventory";

	boolean isContinue = false;
	boolean isUpdate = false;

	@When("^user create customer as \"([^\"]*)\"$")
	public void user_create_customer_as(String dataKey, List<List<String>> dataTable) {
		String colKeyCustomer = "KEY CUSTOMER";
		String colCustomerCode = "Customer Code";
		String colAutoGenCode = "Prefix Auto Gen Code";
		String colUniqueEntityNo = "Unique Entity No";
		String colCustomerName = "Customer Name";
		String colCustomerClassCode = "Customer Class Code";
		String colPartyGroupCode = "Party Group Code";
		String colIndustryCode = "Industry Code";
		String colAcquiredBy = "Acquired By";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colSalesTaxCode = "Sales Tax Code";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colStatementDeliveryOption = "Statement Delivery Option";
		String colDefaultTenor = "Default Tenor";
		String colDiscount = "Discount";
		String colDueARInvoiceCorrespondenceLanguage = "Due AR Invoice Correspondence Language";
		String colCustomerRemarks = "Customer Remarks";
		String colStatus = "Status";
		String colMainCustomerCode = "Main Customer Code";
		String colCustomerShortName = "Customer Short Name";
		String colCustomerCategoryCode = "Customer Category Code";
		String colCustomerGroupCode = "Customer Group Code";
		String colCustomerType = "Customer Type";
		String colMainHomePage = "Main Home Page";
		String colGSTRegistrationNo = "GST Registration No";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colDefaultValidity = "Default Validity";
		String colDefaultTenorTermCode = "Default Tenor Term Code";
		String colPriceMarkupPercent = "Price Markup Percent";
		String colCombineShmtoInvoices = "Combine Shm to Invoices";
		String colIPTRelated = "IPT Related";
		String colShippingMarksCode = "Shipping Marks Code";
		String colCompany = "Company";

		String dataTableKey = "Customer";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKeyCustomer, dataKey)
				.keySet()) {
			String autoGenCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colAutoGenCode);
			String customerCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerCode);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowCustomer, colUniqueEntityNo);
			String customerName = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerName);
			String customerClassCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerClassCode);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPartyGroupCode);
			String industryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colIndustryCode);
			String acquiredBy = SessionData.getDataTbVal(dataTableKey, rowCustomer, colAcquiredBy);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colCountryOfIncorporation);
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colSalesTaxCode);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colContraRealizedExchGLAN);
			String statementDeliveryOption = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colStatementDeliveryOption);
			String defaultTenor = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultTenor);
			String discount = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDiscount);
			String dueARInvoiceCorrespondenceLanguage = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colDueARInvoiceCorrespondenceLanguage);
			String customerRemarks = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerRemarks);
			String status = SessionData.getDataTbVal(dataTableKey, rowCustomer, colStatus);
			String mainCustomerCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colMainCustomerCode);
			String customerShortName = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerShortName);
			String customerCategoryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerCategoryCode);
			String customerGroupCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerGroupCode);
			String customerType = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerType);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowCustomer, colMainHomePage);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowCustomer, colGSTRegistrationNo);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPartyContraGLAN);
			String defaultValidity = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultValidity);
			String defaultTenorTermCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultTenorTermCode);
			String priceMarkupPercent = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPriceMarkupPercent);
			String combineShmtoInvoices = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCombineShmtoInvoices);
			String iPTRelated = SessionData.getDataTbVal(dataTableKey, rowCustomer, colIPTRelated);
			String shippingMarksCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colShippingMarksCode);
			String company = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCompany);

			onCustomerSteps.clickOnNewBtn();

			if (!autoGenCode.isEmpty()) {
				customerCode = onCustomerSteps.autoGenCode(autoGenCode);
			}

			if (!customerCode.isEmpty()) {
				onCustomerSteps.typeCustomerCode(customerCode);
				String mess = onCustomerSteps.verifyMessagePopup();
				if (mess != null) {
					isContinue = false;
					System.out.println("[*** NANCY ***] Error Message:===" + mess + "===");
				} else {
					isContinue = true;
					if (!uniqueEntityNo.isEmpty()) {
						onCustomerSteps.typeUniqueEntityNo(uniqueEntityNo);
					}
					if (!customerName.isEmpty()) {
						onCustomerSteps.typeCustomerName(customerName);
					}
					if (!customerClassCode.isEmpty()) {
						onCustomerSteps.typeCustomerClassCode(customerClassCode);
					}
					if (!partyGroupCode.isEmpty()) {
						onCustomerSteps.typePartyGroupCode(partyGroupCode);
					}
					if (!industryCode.isEmpty()) {
						onCustomerSteps.typeIndustryCode(industryCode);
					}
					if (!acquiredBy.isEmpty()) {
						onCustomerSteps.typeAcquiredBy(acquiredBy);
					}
					if (!countryOfIncorporation.isEmpty()) {
						onCustomerSteps.typeCountryOfIncorporation(countryOfIncorporation);
					}
					if (!salesTaxCode.isEmpty()) {
						onCustomerSteps.typeSalesTaxCode(salesTaxCode);
					}
					if (!contraRealizedExchGLAN.isEmpty()) {
						onCustomerSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
					}
					if (!statementDeliveryOption.isEmpty()) {
						onCustomerSteps.selectStatementDeliveryOption(statementDeliveryOption);
					}
					if (!defaultTenor.isEmpty()) {
						onCustomerSteps.typeDefaultTenor(defaultTenor);
					}
					if (!discount.isEmpty()) {
						onCustomerSteps.typeDiscount(discount);
					}
					if (!dueARInvoiceCorrespondenceLanguage.isEmpty()) {
						onCustomerSteps.selectDueARInvoiceCorrespondenceLanguage(dueARInvoiceCorrespondenceLanguage);
					}
					if (!customerRemarks.isEmpty()) {
						onCustomerSteps.typeCustomerRemarks(customerRemarks);
					}
					if (!status.isEmpty()) {
						onCustomerSteps.selectStatus(status);
					}
					if (!mainCustomerCode.isEmpty()) {
						onCustomerSteps.typeMainCustomerCode(mainCustomerCode);
					}
					if (!customerShortName.isEmpty()) {
						onCustomerSteps.typeCustomerShortName(customerShortName);
					}
					if (!customerCategoryCode.isEmpty()) {
						onCustomerSteps.typeCustomerCategoryCode(customerCategoryCode);
					}
					if (!customerGroupCode.isEmpty()) {
						onCustomerSteps.typeCustomerGroupCode(customerGroupCode);
					}
					if (!customerType.isEmpty()) {
						onCustomerSteps.selectCustomerType(customerType);
					}
					if (!mainHomePage.isEmpty()) {
						onCustomerSteps.typeMainHomePage(mainHomePage);
					}
					if (!gSTRegistrationNo.isEmpty()) {
						onCustomerSteps.typeGSTRegistrationNo(gSTRegistrationNo);
					}
					if (!partyContraGLAN.isEmpty()) {
						onCustomerSteps.typePartyContraGLAN(partyContraGLAN);
					}
					if (!defaultValidity.isEmpty()) {
						onCustomerSteps.typeDefaultValidity(defaultValidity);
					}
					if (!defaultTenorTermCode.isEmpty()) {
						onCustomerSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
					}
					if (!priceMarkupPercent.isEmpty()) {
						onCustomerSteps.typePriceMarkupPercent(priceMarkupPercent);
					}
					if (!combineShmtoInvoices.isEmpty()) {
						onCustomerSteps.selectCombineShmtoInvoices(combineShmtoInvoices);
					}
					if (!iPTRelated.isEmpty()) {
						onCustomerSteps.selectIPTRelated(iPTRelated);
					}
					if (!shippingMarksCode.isEmpty()) {
						onCustomerSteps.typeShippingMarksCode(shippingMarksCode);
					}
					if (!company.isEmpty()) {
						onCustomerSteps.moveToCompanyTab();
						if (company.toLowerCase().equals("all")) {
							onCusCompanyTabSteps.chooseAllCompany();
						} else
							onCusCompanyTabSteps.chooseCompany(company);
					}
				}
			}
		}
	}
	
	@When("^user maintains customer as \"([^\"]*)\"$")
	public void user_maintains_customer_as(String dataKey, List<List<String>> dataTable) {
		String colKeyCustomer = "KEY CUSTOMER";
		String colCustomerCode = "Customer Code";
		String colAutoGenCode = "Prefix Auto Gen Code";
		String colUniqueEntityNo = "Unique Entity No";
		String colCustomerName = "Customer Name";
		String colCustomerClassCode = "Customer Class Code";
		String colPartyGroupCode = "Party Group Code";
		String colIndustryCode = "Industry Code";
		String colAcquiredBy = "Acquired By";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colSalesTaxCode = "Sales Tax Code";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colStatementDeliveryOption = "Statement Delivery Option";
		String colDefaultTenor = "Default Tenor";
		String colDiscount = "Discount";
		String colDueARInvoiceCorrespondenceLanguage = "Due AR Invoice Correspondence Language";
		String colCustomerRemarks = "Customer Remarks";
		String colStatus = "Status";
		String colMainCustomerCode = "Main Customer Code";
		String colCustomerShortName = "Customer Short Name";
		String colCustomerCategoryCode = "Customer Category Code";
		String colCustomerGroupCode = "Customer Group Code";
		String colCustomerType = "Customer Type";
		String colMainHomePage = "Main Home Page";
		String colGSTRegistrationNo = "GST Registration No";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colDefaultValidity = "Default Validity";
		String colDefaultTenorTermCode = "Default Tenor Term Code";
		String colPriceMarkupPercent = "Price Markup Percent";
		String colCombineShmtoInvoices = "Combine Shm to Invoices";
		String colIPTRelated = "IPT Related";
		String colShippingMarksCode = "Shipping Marks Code";
		String colCompany = "Company";

		String dataTableKey = "Customer";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKeyCustomer, dataKey)
				.keySet()) {
			String autoGenCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colAutoGenCode);
			String customerCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerCode);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowCustomer, colUniqueEntityNo);
			String customerName = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerName);
			String customerClassCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerClassCode);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPartyGroupCode);
			String industryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colIndustryCode);
			String acquiredBy = SessionData.getDataTbVal(dataTableKey, rowCustomer, colAcquiredBy);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colCountryOfIncorporation);
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colSalesTaxCode);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colContraRealizedExchGLAN);
			String statementDeliveryOption = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colStatementDeliveryOption);
			String defaultTenor = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultTenor);
			String discount = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDiscount);
			String dueARInvoiceCorrespondenceLanguage = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colDueARInvoiceCorrespondenceLanguage);
			String customerRemarks = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerRemarks);
			String status = SessionData.getDataTbVal(dataTableKey, rowCustomer, colStatus);
			String mainCustomerCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colMainCustomerCode);
			String customerShortName = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerShortName);
			String customerCategoryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerCategoryCode);
			String customerGroupCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerGroupCode);
			String customerType = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerType);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowCustomer, colMainHomePage);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowCustomer, colGSTRegistrationNo);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPartyContraGLAN);
			String defaultValidity = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultValidity);
			String defaultTenorTermCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultTenorTermCode);
			String priceMarkupPercent = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPriceMarkupPercent);
			String combineShmtoInvoices = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCombineShmtoInvoices);
			String iPTRelated = SessionData.getDataTbVal(dataTableKey, rowCustomer, colIPTRelated);
			String shippingMarksCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colShippingMarksCode);
			String company = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCompany);
			
			isUpdate = true;
			boolean customerExist = true;
			if (!onCustomerSteps.searchCustomer(customerCode)){
				onCustomerSteps.clickOnNewBtn();
				onCustomerSteps.typeCustomerCode(customerCode);
				customerExist = false;
			}
			

			if (!autoGenCode.isEmpty()) {
				customerCode = onCustomerSteps.autoGenCode(autoGenCode);
			}

			if (!customerCode.isEmpty()) {
				
				String mess = onCustomerSteps.verifyMessagePopup();
				if (mess != null) {
					isContinue = false;
					System.out.println("[*** NANCY ***] Error Message:===" + mess + "===");
				} else {
					isContinue = true;
					if (!uniqueEntityNo.isEmpty()) {
						onCustomerSteps.typeUniqueEntityNo(uniqueEntityNo);
					}
					if (!customerName.isEmpty()) {
						onCustomerSteps.typeCustomerName(customerName);
					}
					if (!customerExist){
						if (!customerClassCode.isEmpty()) {
							onCustomerSteps.typeCustomerClassCode(customerClassCode);
						}
					}
					
					if (!partyGroupCode.isEmpty()) {
						onCustomerSteps.typePartyGroupCode(partyGroupCode);
					}
					if (!industryCode.isEmpty()) {
						onCustomerSteps.typeIndustryCode(industryCode);
					}
					if (!acquiredBy.isEmpty()) {
						onCustomerSteps.typeAcquiredBy(acquiredBy);
					}
					if (!countryOfIncorporation.isEmpty()) {
						onCustomerSteps.typeCountryOfIncorporation(countryOfIncorporation);
					}
					if (!salesTaxCode.isEmpty()) {
						onCustomerSteps.typeSalesTaxCode(salesTaxCode);
					}
					if (!contraRealizedExchGLAN.isEmpty()) {
						onCustomerSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
					}
					if (!statementDeliveryOption.isEmpty()) {
						onCustomerSteps.selectStatementDeliveryOption(statementDeliveryOption);
					}
					if (!defaultTenor.isEmpty()) {
						onCustomerSteps.typeDefaultTenor(defaultTenor);
					}
					if (!discount.isEmpty()) {
						onCustomerSteps.typeDiscount(discount);
					}
					if (!dueARInvoiceCorrespondenceLanguage.isEmpty()) {
						onCustomerSteps.selectDueARInvoiceCorrespondenceLanguage(dueARInvoiceCorrespondenceLanguage);
					}
					if (!customerRemarks.isEmpty()) {
						onCustomerSteps.typeCustomerRemarks(customerRemarks);
					}
					if (!status.isEmpty()) {
						onCustomerSteps.selectStatus(status);
					}
					if (!mainCustomerCode.isEmpty()) {
						onCustomerSteps.typeMainCustomerCode(mainCustomerCode);
					}
					if (!customerShortName.isEmpty()) {
						onCustomerSteps.typeCustomerShortName(customerShortName);
					}
					if (!customerCategoryCode.isEmpty()) {
						onCustomerSteps.typeCustomerCategoryCode(customerCategoryCode);
					}
					if (!customerGroupCode.isEmpty()) {
						onCustomerSteps.typeCustomerGroupCode(customerGroupCode);
					}
					if (!customerType.isEmpty()) {
						onCustomerSteps.selectCustomerType(customerType);
					}
					if (!mainHomePage.isEmpty()) {
						onCustomerSteps.typeMainHomePage(mainHomePage);
					}
					if (!gSTRegistrationNo.isEmpty()) {
						onCustomerSteps.typeGSTRegistrationNo(gSTRegistrationNo);
					}
					if (!partyContraGLAN.isEmpty()) {
						onCustomerSteps.typePartyContraGLAN(partyContraGLAN);
					}
					if (!defaultValidity.isEmpty()) {
						onCustomerSteps.typeDefaultValidity(defaultValidity);
					}
					if (!defaultTenorTermCode.isEmpty()) {
						onCustomerSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
					}
					if (!priceMarkupPercent.isEmpty()) {
						onCustomerSteps.typePriceMarkupPercent(priceMarkupPercent);
					}
					if (!combineShmtoInvoices.isEmpty()) {
						onCustomerSteps.selectCombineShmtoInvoices(combineShmtoInvoices);
					}
					if (!iPTRelated.isEmpty()) {
						onCustomerSteps.selectIPTRelated(iPTRelated);
					}
					if (!shippingMarksCode.isEmpty()) {
						onCustomerSteps.typeShippingMarksCode(shippingMarksCode);
					}
					if (!company.isEmpty()) {
						onCustomerSteps.moveToCompanyTab();
						if (company.toLowerCase().equals("all")) {
							onCusCompanyTabSteps.chooseAllCompany();
						} else
							onCusCompanyTabSteps.chooseCompany(company);
					}
				}
			}
		}

	}


	@When("^user update customer as \"([^\"]*)\"$")
	public void user_update_customer_as(String dataKey, List<List<String>> dataTable) {
		String colKeyCustomer = "KEY CUSTOMER";
		String colCustomerCode = "Customer Code";
		String colUniqueEntityNo = "Unique Entity No";
		String colCustomerName = "Customer Name";
		String colCustomerClassCode = "Customer Class Code";
		String colPartyGroupCode = "Party Group Code";
		String colIndustryCode = "Industry Code";
		String colAcquiredBy = "Acquired By";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colSalesTaxCode = "Sales Tax Code";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colStatementDeliveryOption = "Statement Delivery Option";
		String colDefaultTenor = "Default Tenor";
		String colDiscount = "Discount";
		String colDueARInvoiceCorrespondenceLanguage = "Due AR Invoice Correspondence Language";
		String colCustomerRemarks = "Customer Remarks";
		String colStatus = "Status";
		String colMainCustomerCode = "Main Customer Code";
		String colCustomerShortName = "Customer Short Name";
		String colCustomerCategoryCode = "Customer Category Code";
		String colCustomerGroupCode = "Customer Group Code";
		String colCustomerType = "Customer Type";
		String colMainHomePage = "Main Home Page";
		String colGSTRegistrationNo = "GST Registration No";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colDefaultValidity = "Default Validity";
		String colDefaultTenorTermCode = "Default Tenor Term Code";
		String colPriceMarkupPercent = "Price Markup Percent";
		String colCombineShmtoInvoices = "Combine Shm to Invoices";
		String colIPTRelated = "IPT Related";
		String colShippingMarksCode = "Shipping Marks Code";
		String colCompany = "Company";

		String dataTableKey = "Customer";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKeyCustomer, dataKey)
				.keySet()) {
			String customerCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerCode);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowCustomer, colUniqueEntityNo);
			String customerName = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerName);
			String customerClassCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerClassCode);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPartyGroupCode);
			String industryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colIndustryCode);
			String acquiredBy = SessionData.getDataTbVal(dataTableKey, rowCustomer, colAcquiredBy);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colCountryOfIncorporation);
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colSalesTaxCode);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colContraRealizedExchGLAN);
			String statementDeliveryOption = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colStatementDeliveryOption);
			String defaultTenor = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultTenor);
			String discount = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDiscount);
			String dueARInvoiceCorrespondenceLanguage = SessionData.getDataTbVal(dataTableKey, rowCustomer,
					colDueARInvoiceCorrespondenceLanguage);
			String customerRemarks = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerRemarks);
			String status = SessionData.getDataTbVal(dataTableKey, rowCustomer, colStatus);
			String mainCustomerCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colMainCustomerCode);
			String customerShortName = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerShortName);
			String customerCategoryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerCategoryCode);
			String customerGroupCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerGroupCode);
			String customerType = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCustomerType);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowCustomer, colMainHomePage);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowCustomer, colGSTRegistrationNo);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPartyContraGLAN);
			String defaultValidity = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultValidity);
			String defaultTenorTermCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colDefaultTenorTermCode);
			String priceMarkupPercent = SessionData.getDataTbVal(dataTableKey, rowCustomer, colPriceMarkupPercent);
			String combineShmtoInvoices = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCombineShmtoInvoices);
			String iPTRelated = SessionData.getDataTbVal(dataTableKey, rowCustomer, colIPTRelated);
			String shippingMarksCode = SessionData.getDataTbVal(dataTableKey, rowCustomer, colShippingMarksCode);
			String company = SessionData.getDataTbVal(dataTableKey, rowCustomer, colCompany);

			if (onCustomerSteps.searchCustomer(customerCode)) {
				isContinue = true;
				isUpdate = true;
				if (!uniqueEntityNo.isEmpty()) {
					onCustomerSteps.typeUniqueEntityNo(uniqueEntityNo);
				}
				if (!customerName.isEmpty()) {
					onCustomerSteps.typeCustomerName(customerName);
				}
				if (!customerClassCode.isEmpty()) {
					onCustomerSteps.typeCustomerClassCode(customerClassCode);
				}
				if (!partyGroupCode.isEmpty()) {
					onCustomerSteps.typePartyGroupCode(partyGroupCode);
				}
				if (!industryCode.isEmpty()) {
					onCustomerSteps.typeIndustryCode(industryCode);
				}
				if (!acquiredBy.isEmpty()) {
					onCustomerSteps.typeAcquiredBy(acquiredBy);
				}
				if (!countryOfIncorporation.isEmpty()) {
					onCustomerSteps.typeCountryOfIncorporation(countryOfIncorporation);
				}
				if (!salesTaxCode.isEmpty()) {
					onCustomerSteps.typeSalesTaxCode(salesTaxCode);
				}
				if (!contraRealizedExchGLAN.isEmpty()) {
					onCustomerSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
				}
				if (!statementDeliveryOption.isEmpty()) {
					onCustomerSteps.selectStatementDeliveryOption(statementDeliveryOption);
				}
				if (!defaultTenor.isEmpty()) {
					onCustomerSteps.typeDefaultTenor(defaultTenor);
				}
				if (!discount.isEmpty()) {
					onCustomerSteps.typeDiscount(discount);
				}
				if (!dueARInvoiceCorrespondenceLanguage.isEmpty()) {
					onCustomerSteps.selectDueARInvoiceCorrespondenceLanguage(dueARInvoiceCorrespondenceLanguage);
				}
				if (!customerRemarks.isEmpty()) {
					onCustomerSteps.typeCustomerRemarks(customerRemarks);
				}
				if (!status.isEmpty()) {
					onCustomerSteps.selectStatus(status);
				}
				if (!mainCustomerCode.isEmpty()) {
					onCustomerSteps.typeMainCustomerCode(mainCustomerCode);
				}
				if (!customerShortName.isEmpty()) {
					onCustomerSteps.typeCustomerShortName(customerShortName);
				}
				if (!customerCategoryCode.isEmpty()) {
					onCustomerSteps.typeCustomerCategoryCode(customerCategoryCode);
				}
				if (!customerGroupCode.isEmpty()) {
					onCustomerSteps.typeCustomerGroupCode(customerGroupCode);
				}
				if (!customerType.isEmpty()) {
					onCustomerSteps.selectCustomerType(customerType);
				}
				if (!mainHomePage.isEmpty()) {
					onCustomerSteps.typeMainHomePage(mainHomePage);
				}
				if (!gSTRegistrationNo.isEmpty()) {
					onCustomerSteps.typeGSTRegistrationNo(gSTRegistrationNo);
				}
				if (!partyContraGLAN.isEmpty()) {
					onCustomerSteps.typePartyContraGLAN(partyContraGLAN);
				}
				if (!defaultValidity.isEmpty()) {
					onCustomerSteps.typeDefaultValidity(defaultValidity);
				}
				if (!defaultTenorTermCode.isEmpty()) {
					onCustomerSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
				}
				if (!priceMarkupPercent.isEmpty()) {
					onCustomerSteps.typePriceMarkupPercent(priceMarkupPercent);
				}
				if (!combineShmtoInvoices.isEmpty()) {
					onCustomerSteps.selectCombineShmtoInvoices(combineShmtoInvoices);
				}
				if (!iPTRelated.isEmpty()) {
					onCustomerSteps.selectIPTRelated(iPTRelated);
				}
				if (!shippingMarksCode.isEmpty()) {
					onCustomerSteps.typeShippingMarksCode(shippingMarksCode);
				}
				if (!company.isEmpty()) {
					onCustomerSteps.moveToCompanyTab();
					if (company.toLowerCase().equals("all")) {
						onCusCompanyTabSteps.chooseAllCompany();
					} else
						onCusCompanyTabSteps.chooseCompany(company);
				}
			}
		}
	}

	@When("^customer is added address as \"([^\"]*)\"$")
	public void customer_is_added_address_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "Customer_Address";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKeyCustomer = "KEY CUSTOMER";
			String colAddressCode = "Address Code";
			String colDescription = "Description";
			String colAddress = "Address";
			String colCountryCode = "Country Code";
			String colStateProvince = "State Province";
			String colCityTown = "City Town";
			String colPostalCode = "Postal Code";
			String colBlockEstateName = "Block Estate Name";
			String colStreetName = "Street Name";
			String colBuildingBlockHouseNo = "Building Block House No";
			String colBuildingType = "Building Type";
			String colUnitNo = "Unit No";
			String colIncType = "Inc Type";
			String colDefaultAddress = "Default";
			String colLRA = "LRA";
			String colDel = "Del";

			onCustomerSteps.moveToAddressTab();
			for (int rowCustomer_Address : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKeyCustomer, dataKey).keySet()) {
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colAddressCode);
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colDescription);
				String address = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colAddress);
				String countryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colCountryCode);
				String stateProvince = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colStateProvince);
				String cityTown = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colCityTown);
				String postalCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colPostalCode);
				String blockEstateName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address,
						colBlockEstateName);
				String streetName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colStreetName);
				String buildingBlockHouseNo = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address,
						colBuildingBlockHouseNo);
				String buildingType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colBuildingType);
				String unitNo = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colUnitNo);
				String listIncType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colIncType);
				String listDefaultIncType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address,
						colDefaultAddress);
				String lRA = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colLRA);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colDel);

				if (!addressCode.isEmpty()) {
					if (isUpdate) {
						if (!onCusAddressTabSteps.isAddressCodeExit(addressCode)) {
							//onCusAddressTabSteps.chooseDelAddress(addressCode);
							onCusAddressTabSteps.clickOnAddAddress();
							onCusAddressTabSteps.typeAddressCode(addressCode);
						}
						else {
							onCusAddressTabSteps.chooseAddressCode(addressCode);
						}
					}
									

					if (!description.isEmpty()) {
						onCusAddressTabSteps.typeDescription(description);
					}
					if (!address.isEmpty()) {
						onCusAddressTabSteps.typeAddress(address);
					}
					if (!countryCode.isEmpty()) {
						onCusAddressTabSteps.typeCountryCode(countryCode);
					}
					if (!stateProvince.isEmpty()) {
						onCusAddressTabSteps.typeStateProvince(stateProvince);
					}
					if (!cityTown.isEmpty()) {
						onCusAddressTabSteps.typeCityTown(cityTown);
					}
					if (!postalCode.isEmpty()) {
						onCusAddressTabSteps.typePostalCode(postalCode);
					}
					if (!blockEstateName.isEmpty()) {
						onCusAddressTabSteps.typeBlockEstateName(blockEstateName);
					}
					if (!streetName.isEmpty()) {
						onCusAddressTabSteps.typeStreetName(streetName);
					}
					if (!buildingBlockHouseNo.isEmpty()) {
						onCusAddressTabSteps.typeBuildingBlockHouseNo(buildingBlockHouseNo);
					}
					if (!buildingType.isEmpty()) {
						onCusAddressTabSteps.chooseBuildingType(buildingType);
					}
					if (!unitNo.isEmpty()) {
						onCusAddressTabSteps.typeUnitNo(unitNo);
					}
					if (!listIncType.isEmpty()) {
						onCusAddressTabSteps.waitABit(500);
						if (listIncType.contains(",")) {
							String[] sIncType = listIncType.split(",");
							for (String incType : sIncType) {
								if (!incType.trim().isEmpty()) {
									onCusAddressTabSteps.chooseIncType(incType.trim());
								}
							}
						} else {
							onCusAddressTabSteps.chooseIncType(listIncType);
						}
					}
					if (!listDefaultIncType.isEmpty()) {
						onCusAddressTabSteps.waitABit(500);
						if (listDefaultIncType.contains(",")) {
							String[] sDefault = listDefaultIncType.split(",");
							for (String defaultAdd : sDefault) {
								if (!defaultAdd.trim().isEmpty()) {
									onCusAddressTabSteps.chooseDefaultIncType(defaultAdd.trim());
								}
							}
						} else
							onCusAddressTabSteps.chooseDefaultIncType(listDefaultIncType);
					}

					if (lRA.toLowerCase().equals("y")) {
						onCusAddressTabSteps.chooseLRA(addressCode);
					}
					if (del.toLowerCase().equals("y")) {
						onCusAddressTabSteps.chooseDelAddress(addressCode);
					}
				}
			}
		}
	}

	@When("^customer is added address contact type as \"([^\"]*)\"$")
	public void customer_is_added_address_contact_type_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colAddressCode = "Address Code";
			String colContactType = "Contact Type";
			String colContactInformation = "Contact Information";
			String colDefaultAddContactType = "Default";
			String colDel = "Del";

			String dataTableKey = "Customer_AddressContact";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_AddressContact : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact, colAddressCode);
				String contactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact, colContactType);
				String contactInformation = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact,
						colContactInformation);
				String defaultAddContactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact,
						colDefaultAddContactType);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact, colDel);

				if (onCusAddressTabSteps.chooseAddressCode(addressCode)) {
					onCusAddressTabSteps.clickOnAddAddrContactType();
					int rowIndex = onCusAddressTabSteps.countRowAddrContactType();

					if (!contactType.isEmpty()) {
						onCusAddressTabSteps.chooseContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onCusAddressTabSteps.typeContactInformation(contactInformation, rowIndex);
					}
					if (defaultAddContactType.toLowerCase().equals("y")) {
						onCusAddressTabSteps.chooseAddrContactTypeDefault(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onCusAddressTabSteps.chooseDelAddContactType(rowIndex);
					}
				}
			}
		}
	}

	@When("^customer is added contact as \"([^\"]*)\"$")
	public void customer_is_added_contact_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colPartyContactCode = "Party Contact Code";
			String colSalutation = "Salutation";
			String colFirstName = "First Name";
			String colMiddleName = "Middle Name";
			String colLastName = "Last Name";
			String colName = "Name";
			String colAddressCode = "Address Code";
			String colDesignation = "Designation";
			String colDesignationGroup = "Designation Group";
			String colDepartment = "Department";
			String colIncType = "Inc Type";
			String colDefaultContact = "Default";
			String colDel = "Del";

			String dataTableKey = "Customer_Contact";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCusContactTabSteps.moveToContactTab();

			for (int rowCustomer_Contact : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact,
						colPartyContactCode);
				String salutation = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colSalutation);
				String firstName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colFirstName);
				String middleName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colMiddleName);
				String lastName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colLastName);
				String name = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colName);
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colAddressCode);
				String designation = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colDesignation);
				String designationGroup = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact,
						colDesignationGroup);
				String department = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colDepartment);
				String listIncType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colIncType);
				String listDefaultContact = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact,
						colDefaultContact);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colDel);

				if (!partyContactCode.isEmpty()) {
					if (isUpdate) {
						if (onCusContactTabSteps.isContactExit(partyContactCode)) {
							onCusContactTabSteps.chooseDelContact(partyContactCode);
						}
					}
					onCusContactTabSteps.clickOnAddContact();
					onCusContactTabSteps.typePartyContactCode(partyContactCode);

					if (!salutation.isEmpty()) {
						onCusContactTabSteps.chooseSalutation(salutation);
					}
					if (!firstName.isEmpty()) {
						onCusContactTabSteps.typeFirstName(firstName);
					}
					if (!middleName.isEmpty()) {
						onCusContactTabSteps.typeMiddleName(middleName);
					}
					if (!lastName.isEmpty()) {
						onCusContactTabSteps.typeLastName(lastName);
					}
					if (!name.isEmpty()) {
						onCusContactTabSteps.typeName(name);
					}
					if (!addressCode.isEmpty()) {
						onCusContactTabSteps.chooseAddressCode(addressCode);
					}
					if (!designation.isEmpty()) {
						onCusContactTabSteps.typeDesignation(designation);
					}
					if (!designationGroup.isEmpty()) {
						onCusContactTabSteps.typeDesignationGroup(designationGroup);
					}
					if (!department.isEmpty()) {
						onCusContactTabSteps.typeDepartment(department);
					}
					if (!listIncType.isEmpty()) {
						if (listIncType.contains(",")) {
							String[] sIncType = listIncType.split(",");
							for (String incType : sIncType) {
								if (!incType.trim().isEmpty()) {
									onCusContactTabSteps.chooseIncType(incType.trim());
								}
							}
						} else
							onCusContactTabSteps.chooseIncType(listIncType);
					}
					if (!listDefaultContact.isEmpty()) {
						if (listDefaultContact.contains(",")) {
							String[] sDefault = listDefaultContact.split(",");
							for (String defaultAdd : sDefault) {
								if (!defaultAdd.trim().isEmpty()) {
									onCusContactTabSteps.chooseDefaultIncType(defaultAdd.trim());
								}
							}
						} else
							onCusContactTabSteps.chooseDefaultIncType(listDefaultContact);
					}

					if (del.toLowerCase().equals("y")) {
						onCusContactTabSteps.chooseDelContact(partyContactCode);
					}
				}
			}
		}
	}

	@When("^customer is added contact type as \"([^\"]*)\"$")
	public void customer_is_added_contact_type_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colPartyContactCode = "Party Contact Code";
			String colContactType = "Contact Type";
			String colContactInformation = "Contact Information";
			String colDefaultContactType = "Default";
			String colDelContactType = "Del";

			String dataTableKey = "Customer_ContactType";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_ContactType : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
						colPartyContactCode);
				String contactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType, colContactType);
				String contactInformation = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
						colContactInformation);
				String defaultContactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
						colDefaultContactType);
				String delContactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
						colDelContactType);

				if (onCusContactTabSteps.chooseContact(partyContactCode)) {
					onCusContactTabSteps.clickOnAddContactTypeBtn();
					int rowIndex = onCusContactTabSteps.countRowContactContactTypeTb();
					if (!contactType.isEmpty()) {
						onCusContactTabSteps.chooseContactTypeContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onCusContactTabSteps.typeContactTypeContactInformation(contactInformation, rowIndex);
					}
					if (defaultContactType.toLowerCase().equals("y")) {
						onCusContactTabSteps.chooseContactTypeTypeDefault(rowIndex);
					}
					if (delContactType.toLowerCase().equals("y")) {
						onCusContactTabSteps.chooseContactTypeDel(rowIndex);
					}
				}
			}
		}
	}

	@When("^customer is added bank detail as \"([^\"]*)\"$")
	public void customer_is_added_bank_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colBank = "Bank";
			String colDescription = "Description";
			String colAccountNo = "Account No";
			String colCurrency = "Currency";
			String colDefaultBank = "Default";
			String colDel = "Del";

			String dataTableKey = "Customer_Bank";
			SessionData.addDataTable(dataTableKey, dataTable);
			onCustomerSteps.moveToBankDetailTab();
			for (int rowCustomer_Bank : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey)
					.keySet()) {
				String bank = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colBank);
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colDescription);
				String accountNo = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colAccountNo);
				String currency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colCurrency);
				String defaultBank = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colDefaultBank);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colDel);

				if (!bank.isEmpty()) {
					if (isUpdate) {
						if (onCusBankDetailTabSteps.isBankExit(bank)) {
							onCusBankDetailTabSteps.chooseBankDel(onCusBankDetailTabSteps.getRowIndexBank(bank));
						}
					}
					onCusBankDetailTabSteps.clickOnAddBank();
					int rowIndex = onCusBankDetailTabSteps.countRowBank();
					onCusBankDetailTabSteps.typeBank(bank, rowIndex);

					if (!description.isEmpty()) {
						onCusBankDetailTabSteps.typeDescription(description, rowIndex);
					}
					if (!accountNo.isEmpty()) {
						onCusBankDetailTabSteps.typeAccountNo(accountNo, rowIndex);
					}
					if (!currency.isEmpty()) {
						onCusBankDetailTabSteps.typeCurrency(currency, rowIndex);
					}
					if (!defaultBank.isEmpty()) {
						onCusBankDetailTabSteps.chooseBankDefault(rowIndex);
					}
					if (!del.isEmpty()) {
						onCusBankDetailTabSteps.chooseBankDel(rowIndex);
					}
				}
			}
		}
	}

	@When("^customer is added SBU as \"([^\"]*)\"$")
	public void customer_is_added_SBU_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colSBU = "SBU";
			String colDescription = "Description";
			String colDel = "Del";

			String dataTableKey = "Customer_SBU";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToSBUTab();
			for (int rowCustomer_SBU : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey)
					.keySet()) {
				String sBU = SessionData.getDataTbVal(dataTableKey, rowCustomer_SBU, colSBU);
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_SBU, colDescription);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_SBU, colDel);

				if (!sBU.isEmpty()) {
					if (isUpdate) {
						if (onCusSBUTabSteps.isSBUExit(sBU)) {
							onCusSBUTabSteps.chooseDelSBU(onCusSBUTabSteps.getRowIndexSBU(sBU));
						}
					}
					onCusSBUTabSteps.clickAddSBU();
					int rowIndex = onCusSBUTabSteps.countRowSBU();

					onCusSBUTabSteps.typeSBU(sBU, rowIndex);

					if (!description.isEmpty()) {
						onCusSBUTabSteps.typeDescription(description, rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onCusSBUTabSteps.chooseDelSBU(rowIndex);
					}
				}
			}
		}
	}

	@When("^customer is added sale person as \"([^\"]*)\"$")
	public void customer_is_added_sale_person_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colSalesPerson = "Sales Person";
			String colName = "Name";
			String colSalePersonDefault = "Default";
			String colDSales = "D Sales";
			String colDel = "Del";

			String dataTableKey = "Customer_SalePerson";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToSalesPersonTab();

			for (int rowCustomer_SalePerson : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String salesPerson = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colSalesPerson);
				String name = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colName);
				String salePersonDefault = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson,
						colSalePersonDefault);
				String dSales = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colDSales);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colDel);

				if (!salesPerson.isEmpty()) {
					if (isUpdate) {
						if (onCusSalePersonTabSteps.isSalePersonExit(salesPerson)) {
							onCusSalePersonTabSteps
									.chooseSalesPersonDel(onCusSalePersonTabSteps.getRowIndexSalesPerson(salesPerson));
						}
					}
					onCusSalePersonTabSteps.clickOnAddSalesPeron();
					int rowIndex = onCusSalePersonTabSteps.countRowSalesPerson();

					onCusSalePersonTabSteps.typeSalesPerson(salesPerson, rowIndex);

					if (!name.isEmpty()) {
						onCusSalePersonTabSteps.typeName(name, rowIndex);
					}
					if (!salePersonDefault.isEmpty()) {
						onCusSalePersonTabSteps.chooseSalesPersonDefault(rowIndex);
					}
					if (!dSales.isEmpty()) {
						onCusSalePersonTabSteps.chooseDSales(rowIndex);
					}
					if (!del.isEmpty()) {
						onCusSalePersonTabSteps.chooseSalesPersonDel(rowIndex);
					}
				}
			}
		}
	}

	@When("^customer is added currency as \"([^\"]*)\"$")
	public void customer_is_added_currency_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colCurrency = "Currency";
			String colDel = "Del";

			String dataTableKey = "Customer_Currency";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToCurrencyTab();

			for (int rowCustomer_Currency : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String currency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Currency, colCurrency);
				String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Currency, colDel);
				if (!currency.isEmpty()) {
					if (isUpdate) {
						if (onCusCurrencyTabSteps.isCurrencyExit(currency)) {
							onCusCurrencyTabSteps.chooseDelCurrency(currency);
						}
					}
					onCusCurrencyTabSteps.clickAddCurrency();
					onCusCurrencyTabSteps.typeCurrency(currency);

					if (del.toLowerCase().equals("y")) {
						onCusCurrencyTabSteps.chooseDelCurrency(currency);
					}
				}
			}
		}
	}

	@When("^customer is added payment as \"([^\"]*)\"$")
	public void customer_is_added_payment_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colOperationalCurrency = "Operational Currency";
			String colNextCreditReviewDate = "Next Credit Review Date";

			String dataTableKey = "Customer_Payment";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToPaymentTab();
			for (int rowCustomer_Payment : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String operationalCurrency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Payment,
						colOperationalCurrency);
				String nextCreditReviewDate = SessionData.getDataTbVal(dataTableKey, rowCustomer_Payment,
						colNextCreditReviewDate);

				if (!operationalCurrency.isEmpty()) {
					onCusPaymentTabSteps.selectOperationalCurrency(operationalCurrency);
				}
				if (!nextCreditReviewDate.isEmpty()) {
					onCusPaymentTabSteps.typeReviewDate(nextCreditReviewDate);
					//nextCreditReviewDate = onCusPaymentTabSteps.getToday();
				}
				
			}
		}
	}

	@When("^customer is added payment option as \"([^\"]*)\"$")
	public void customer_is_added_payment_option_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String tableName = "Payment Option";
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colDescription = "Description";
			String colIsActive = "Is Active";
			String colDefaultOption = "Default";

			String dataTableKey = "Customer_PaymentOption";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_PaymentTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDescription);
				String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colIsActive);
				String defaultOption = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm,
						colDefaultOption);

				if (defaultOption.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.clickDescription(tableName, description);
					onCusPaymentTabSteps.selectDefault(tableName, description);
				} else if (isActive.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.clickDescription(tableName, description);
					onCusPaymentTabSteps.chooseIsActive(tableName, description);
				}
			}
		}
	}

	@When("^customer is added payment term as \"([^\"]*)\"$")
	public void customer_is_added_payment_term_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String tableNameOption = "Payment Option";
			String tableName = "Payment Term";

			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colDescription = "Description";
			String colIsActive = "Is Active";
			String colDefaultTerm = "Default";
			String colOPTION = "OPTION";

			String dataTableKey = "Customer_PaymentTerm";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_PaymentTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDescription);
				String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colIsActive);
				String defaultTerm = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDefaultTerm);
				String oPTION = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colOPTION);

				if (!oPTION.isEmpty()) {
					onCusPaymentTabSteps.clickDescription(tableNameOption, oPTION);
					if (defaultTerm.trim().toLowerCase().equals("y")) {
						onCusPaymentTabSteps.clickDescription(tableName, description);
						onCusPaymentTabSteps.selectDefault(tableName, description);
					} else if (isActive.trim().toLowerCase().equals("y")) {
						onCusPaymentTabSteps.clickDescription(tableName, description);
						onCusPaymentTabSteps.chooseIsActive(tableName, description);
					}
				}
			}
		}
	}

	@When("^customer is added payment menthod as \"([^\"]*)\"$")
	public void customer_is_added_payment_menthod_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String tableNameOption = "Payment Option";
			String tableNameTerm = "Payment Term";
			String tableName = "Payment Method";

			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colDescription = "Description";
			String colIsActive = "Is Active";
			String colDefaultMenthod = "Default";
			String colOPTION = "OPTION";
			String colTERM = "TERM";

			String dataTableKey = "Customer_PaymentMenthod";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_PaymentMenthod : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colDescription);
				String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colIsActive);
				String defaultMethod = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod,
						colDefaultMenthod);
				String oPTION = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colOPTION);
				String tERM = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colTERM);
				if (!oPTION.isEmpty()) {
					onCusPaymentTabSteps.clickDescription(tableNameOption, oPTION);
					if (!tERM.isEmpty()) {
						onCusPaymentTabSteps.clickDescription(tableNameTerm, tERM);
						if (defaultMethod.trim().toLowerCase().equals("y")) {
							onCusPaymentTabSteps.selectDefault(tableName, description);
						} else if (isActive.trim().toLowerCase().equals("y")) {
							onCusPaymentTabSteps.chooseIsActive(tableName, description);
						}
					}
				}
			}
		}
	}

	@When("^customer is added local pricing as \"([^\"]*)\"$")
	public void customer_is_added_local_pricing_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colCurrencyCode = "Currency Code";
			String colInventoryPriceListCode = "Inventory Price List Code";
			String colServicePriceListCode = "Service Price List Code";

			String dataTableKey = "Cus_LocalPricing";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToLocalInfoTab();
			onCustomerSteps.moveToPricingTab();

			for (int rowCus_LocalPricing : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String currencyCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing, colCurrencyCode);
				String inventoryPriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
						colInventoryPriceListCode);
				String servicePriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
						colServicePriceListCode);

				if (!currencyCode.isEmpty()) {
					int rowIndex = onCusLocalInfoTabSteps.getRowIndexPricing(currencyCode);
					if (rowIndex > 0) {
						if (!inventoryPriceListCode.isEmpty()) {
							onCusLocalInfoTabSteps.typeInventoryPriceListCode(inventoryPriceListCode, rowIndex);
						}
						if (!servicePriceListCode.isEmpty()) {
							onCusLocalInfoTabSteps.typeServicePriceListCode(servicePriceListCode, rowIndex);
						}
					}
				}
			}
		}
	}

	@When("^customer is added local pricing list as \"([^\"]*)\"$")
	public void customer_is_added_local_pricing_list_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colCurrencyCode = "Currency Code";
			String colWorkingAreaCode = "Working Area Code";
			String colInventoryPriceListCode = "Inventory Price List Code";
			String colServicePriceListCode = "Service Price List Code";
			String colDel = "Del";

			String dataTableKey = "Cus_LocalPricingList";
			SessionData.addDataTable(dataTableKey, dataTable);

			for (int rowCus_LocalPricing : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String currencyCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing, colCurrencyCode);
				String workingAreaCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
						colWorkingAreaCode);
				String inventoryPriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
						colInventoryPriceListCode);
				String servicePriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
						colServicePriceListCode);
				String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing, colDel);

				int rowIndex = onCusLocalInfoTabSteps.getRowIndexPricing(currencyCode);

				onCusLocalInfoTabSteps.clickOnPriceListIcon(rowIndex);
				onCusLocalInfoTabSteps.clickOnAddListPricing();

				int listRowIndex = onCusLocalInfoTabSteps.countRowListPricing();

				if (!workingAreaCode.isEmpty()) {
					onCusLocalInfoTabSteps.typeListWorkingAreaCode(workingAreaCode, listRowIndex);
				}
				if (!inventoryPriceListCode.isEmpty()) {
					onCusLocalInfoTabSteps.typeListInventoryPriceListCode(inventoryPriceListCode, listRowIndex);
				}
				if (!servicePriceListCode.isEmpty()) {
					onCusLocalInfoTabSteps.typeListServicePriceListCode(servicePriceListCode, listRowIndex);
				}
				if (!del.isEmpty()) {
					onCusLocalInfoTabSteps.chooseDeleteListPricing(listRowIndex);
				}
				onCusLocalInfoTabSteps.clickOnDoneListPricing();
			}
		}
	}

	@When("^customer is added local credit limit term as \"([^\"]*)\"$")
	public void customer_is_added_local_credit_limit_term_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colOperationalCurrency = "Operational Currency";
			String colCreditLimitAmt = "Credit Limit Amt";
			String colGracePeriod = "Grace Period";

			String dataTableKey = "Cus_LocalCreditTerm";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToLocalInfoTab();
			onCustomerSteps.moveToCreditLimitTab();

			for (int rowCus_LocalCreditTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String operationalCurrency = SessionData.getDataTbVal(dataTableKey, rowCus_LocalCreditTerm,
						colOperationalCurrency);
				String creditLimitAmt = SessionData.getDataTbVal(dataTableKey, rowCus_LocalCreditTerm,
						colCreditLimitAmt);
				String gracePeriod = SessionData.getDataTbVal(dataTableKey, rowCus_LocalCreditTerm, colGracePeriod);

				String currency = onCusLocalInfoTabSteps.getOperationCurrency();
				if (operationalCurrency.toUpperCase().equals(currency)) {
					if (!creditLimitAmt.isEmpty()) {
						onCusLocalInfoTabSteps.typeCreditLimitAmt(creditLimitAmt);
					}
					if (!gracePeriod.isEmpty()) {
						onCusLocalInfoTabSteps.typeGracePeriod(gracePeriod);
					}
				}
			}
		}
	}

	@When("^customer is added local shipment term as \"([^\"]*)\"$")
	public void customer_is_added_local_shipment_term_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colInc = "Inc";
			String colShippingTerm = "Shipping Term";
			String colAir = "Air";
			String colSea = "Sea";
			String colRoad = "Road";
			String colRail = "Rail";
			String colDefaultShipment = "Default";

			String dataTableKey = "Cus_LocalShipmentTerm";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToLocalInfoTab();
			onCustomerSteps.moveToShipmentInfo();
			onCustomerSteps.moveToShipmentTermTab();

			for (int rowCus_LocalShipmentTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String inc = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colInc);
				String shippingTerm = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colShippingTerm);
				String air = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colAir);
				String sea = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colSea);
				String road = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colRoad);
				String rail = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colRail);
				String defaultShipment = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm,
						colDefaultShipment);

				if (!shippingTerm.isEmpty()) {
					int rowIndex = onCusLocalInfoTabSteps.getRowIndexShipTerm(shippingTerm);
					if (rowIndex > 0) {
						boolean flagDefault = false;
						if (inc.toLowerCase().equals("y")) {
							onCusLocalInfoTabSteps.chooseInc(rowIndex);
							flagDefault = true;
						} else {
							if (air.toLowerCase().equals("y")) {
								flagDefault = true;
								onCusLocalInfoTabSteps.chooseAir(rowIndex);
							}
							if (road.toLowerCase().equals("y")) {
								flagDefault = true;
								onCusLocalInfoTabSteps.chooseRoad(rowIndex);
							}
							if (rail.toLowerCase().equals("y")) {
								flagDefault = true;
								onCusLocalInfoTabSteps.chooseRail(rowIndex);
							}
							if (sea.toLowerCase().equals("y")) {
								flagDefault = true;
								onCusLocalInfoTabSteps.chooseSea(rowIndex);
							}
						}
						if (defaultShipment.toLowerCase().equals("y") && flagDefault) {
							onCusLocalInfoTabSteps.chooseShipmentDefault(rowIndex);
						}
					}
				}
			}
		}
	}

	@When("^customer is added local shipment port as \"([^\"]*)\"$")
	public void customer_is_added_local_shipment_port_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colCountry = "Country";
			String colLoading = "Loading";
			String colDischarge = "Discharge";
			String colFinalDest = "Final Dest";
			String colDel = "Del";

			String dataTableKey = "Cus_LocalShipmentPort";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToLocalInfoTab();
			onCustomerSteps.moveToShipmentInfo();
			onCustomerSteps.moveToShipmentPort();

			for (int rowCus_LocalShipmentPort : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String country = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colCountry);
				String loading = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colLoading);
				String discharge = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colDischarge);
				String finalDest = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colFinalDest);
				String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colDel);

				if (!country.isEmpty()) {
					if (isUpdate) {
						if (onCusLocalInfoTabSteps.isCountryExit(country))
							onCusLocalInfoTabSteps.chooseDelCountry(country);
					}
					onCusLocalInfoTabSteps.clickOnAddCountry();
					int rowIndex = onCusLocalInfoTabSteps.countRowCountry();
					onCusLocalInfoTabSteps.typeCountry(country, rowIndex);

					rowIndex = onCusLocalInfoTabSteps.getRowIndexCountry(country);

					if (rowIndex > 0) {
						onCusLocalInfoTabSteps.clickToOpenPort(rowIndex);

						if (loading.toLowerCase().equals("y")) {
							onCusLocalInfoTabSteps.chooseLoading(rowIndex);
						}
						if (discharge.toLowerCase().equals("y")) {
							onCusLocalInfoTabSteps.chooseDischarge(rowIndex);
						}
						if (finalDest.toLowerCase().equals("y")) {
							onCusLocalInfoTabSteps.chooseFinalDest(rowIndex);
						}
						if (del.toLowerCase().equals("y")) {
							onCusLocalInfoTabSteps.chooseDelCountry(rowIndex);
						}
					}
				}

			}
		}
	}

	@When("^customer is added local detail port as \"([^\"]*)\"$")
	public void customer_is_added_local_detail_port_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colCountry = "Country";
			String colLoading = "Loading";
			String colDischarge = "Discharge";
			String colFinalDest = "Final Dest";
			String colPort = "Port";

			String dataTableKey = "Cus_LocalShipmentPortDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			for (int rowCus_LocalShipmentPortDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String country = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colCountry);
				String loading = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colLoading);
				String discharge = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colDischarge);
				String finalDest = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colFinalDest);
				String port = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colPort);

				if (onCusLocalInfoTabSteps.chooseContry(country)) {
					if (!port.isEmpty()) {
						int rowIndex = onCusLocalInfoTabSteps.getRowIndexPort(port);
						if (rowIndex > 0) {
							if (loading.equals("y")) {
								onCusLocalInfoTabSteps.choosePortLoading(rowIndex);
							}
							if (discharge.equals("y")) {
								onCusLocalInfoTabSteps.choosePortDischange(rowIndex);
							}
							if (finalDest.equals("y")) {
								onCusLocalInfoTabSteps.choosePortFinalDest(rowIndex);
							}
						}
					}
				}
			}
		}
	}

	@When("^customer is added local customer inverntory as \"([^\"]*)\"$")
	public void customer_is_added_local_customer_inverntory_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYCUSTOMER = "KEY CUSTOMER";
			String colInventoryBrand = "Inventory Brand";
			String colDiscountCode = "Discount Code";
			String colDiscount = "Discount";
			String colDel = "Del";

			String dataTableKey = "Cus_LocalInventory";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.moveToLocalInfoTab();
			onCustomerSteps.moveToCustomerInventory();

			for (int rowCus_LocalInventory : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
				String inventoryBrand = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory,
						colInventoryBrand);
				String discountCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory, colDiscountCode);
				String discount = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory, colDiscount);
				String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory, colDel);

				onCusLocalInfoTabSteps.clickOnAddInventoryBrand();
				int rowIndex = onCusLocalInfoTabSteps.countRowInventoryBrand();

				if (!inventoryBrand.isEmpty()) {
					onCusLocalInfoTabSteps.typeInventoryBrand(inventoryBrand, rowIndex);
				}
				if (!discountCode.isEmpty()) {
					onCusLocalInfoTabSteps.typeDiscountCode(discountCode, rowIndex);
				}
				if (!discount.isEmpty()) {
					onCusLocalInfoTabSteps.typeDiscount(discount, rowIndex);
				}
				if (!del.isEmpty()) {
					onCusLocalInfoTabSteps.chooseDelInventoryBrand(rowIndex);
				}
			}
		}
	}

	@When("^customer is updated$")
	public void customer_is_updated() {
		if (isContinue) {
			onCustomerSteps.clickOnUpdateButton();
		}
	}

@When("^customer maintains address as \"([^\"]*)\"$")
public void customer_maintains_address_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String dataTableKey = "Customer_Address";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKeyCustomer = "KEY CUSTOMER";
		String colAddressCode = "Address Code";
		String colDescription = "Description";
		String colAddress = "Address";
		String colCountryCode = "Country Code";
		String colStateProvince = "State Province";
		String colCityTown = "City Town";
		String colPostalCode = "Postal Code";
		String colBlockEstateName = "Block Estate Name";
		String colStreetName = "Street Name";
		String colBuildingBlockHouseNo = "Building Block House No";
		String colBuildingType = "Building Type";
		String colUnitNo = "Unit No";
		String colIncType = "Inc Type";
		String colDefaultAddress = "Default";
		String colLRA = "LRA";
		String colDel = "Del";

		onCustomerSteps.moveToAddressTab();
		for (int rowCustomer_Address : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKeyCustomer, dataKey).keySet()) {
			String addressCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colAddressCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colDescription);
			String address = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colAddress);
			String countryCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colCountryCode);
			String stateProvince = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colStateProvince);
			String cityTown = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colCityTown);
			String postalCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colPostalCode);
			String blockEstateName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address,
					colBlockEstateName);
			String streetName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colStreetName);
			String buildingBlockHouseNo = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address,
					colBuildingBlockHouseNo);
			String buildingType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colBuildingType);
			String unitNo = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colUnitNo);
			String listIncType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colIncType);
			String listDefaultIncType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address,
					colDefaultAddress);
			String lRA = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colLRA);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Address, colDel);

			if (!addressCode.isEmpty()) {
				if (isUpdate) {
					if (!onCusAddressTabSteps.isAddressCodeExit(addressCode)) {
						onCusAddressTabSteps.clickOnAddAddress();
						onCusAddressTabSteps.typeAddressCode(addressCode);
					}
					else {
						onCusAddressTabSteps.chooseAddressCode(addressCode);
					}
				}
								

				if (!description.isEmpty()) {
					onCusAddressTabSteps.typeDescription(description);
				}
				if (!address.isEmpty()) {
					onCusAddressTabSteps.typeAddress(address);
				}
				if (!countryCode.isEmpty()) {
					onCusAddressTabSteps.typeCountryCode(countryCode);
				}
				if (!stateProvince.isEmpty()) {
					onCusAddressTabSteps.typeStateProvince(stateProvince);
				}
				if (!cityTown.isEmpty()) {
					onCusAddressTabSteps.typeCityTown(cityTown);
				}
				if (!postalCode.isEmpty()) {
					onCusAddressTabSteps.typePostalCode(postalCode);
				}
				if (!blockEstateName.isEmpty()) {
					onCusAddressTabSteps.typeBlockEstateName(blockEstateName);
				}
				if (!streetName.isEmpty()) {
					onCusAddressTabSteps.typeStreetName(streetName);
				}
				if (!buildingBlockHouseNo.isEmpty()) {
					onCusAddressTabSteps.typeBuildingBlockHouseNo(buildingBlockHouseNo);
				}
				if (!buildingType.isEmpty()) {
					onCusAddressTabSteps.chooseBuildingType(buildingType);
				}
				if (!unitNo.isEmpty()) {
					onCusAddressTabSteps.typeUnitNo(unitNo);
				}
				if (!listIncType.isEmpty()) {
					onCusAddressTabSteps.waitABit(500);
					if (listIncType.contains(",")) {
						String[] sIncType = listIncType.split(",");
						for (String incType : sIncType) {
							if (!incType.trim().isEmpty()) {
								onCusAddressTabSteps.chooseIncType(incType.trim());
							}
						}
					} else {
						onCusAddressTabSteps.chooseIncType(listIncType);
					}
				}
				if (!listDefaultIncType.isEmpty()) {
					onCusAddressTabSteps.waitABit(500);
					if (listDefaultIncType.contains(",")) {
						String[] sDefault = listDefaultIncType.split(",");
						for (String defaultAdd : sDefault) {
							if (!defaultAdd.trim().isEmpty()) {
								onCusAddressTabSteps.chooseDefaultIncType(defaultAdd.trim());
							}
						}
					} else
						onCusAddressTabSteps.chooseDefaultIncType(listDefaultIncType);
				}

				if (lRA.toLowerCase().equals("y")) {
					onCusAddressTabSteps.chooseLRA(addressCode);
				}
				if (del.toLowerCase().equals("y")) {
					onCusAddressTabSteps.chooseDelAddress(addressCode);
				}
			}
		}
	}
}

@When("^customer maintains address contact type as \"([^\"]*)\"$")
public void customer_maintains_address_contact_type_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colAddressCode = "Address Code";
		String colContactType = "Contact Type";
		String colContactInformation = "Contact Information";
		String colDefaultAddContactType = "Default";
		String colDel = "Del";

		String dataTableKey = "Customer_AddressContact";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer_AddressContact : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String addressCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact, colAddressCode);
			String contactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact, colContactType);
			String contactInformation = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact,
					colContactInformation);
			String defaultAddContactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact,
					colDefaultAddContactType);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_AddressContact, colDel);

			if (onCusAddressTabSteps.chooseAddressCode(addressCode)) {
				
				if (!onCusAddressTabSteps.is_added_contact(contactType, contactInformation)){
					onCusAddressTabSteps.clickOnAddAddrContactType();
					int rowIndex = onCusAddressTabSteps.countRowAddrContactType();
					if (!contactType.isEmpty()) {
						onCusAddressTabSteps.chooseContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onCusAddressTabSteps.typeContactInformation(contactInformation, rowIndex);
					}
					if (defaultAddContactType.toLowerCase().equals("y")) {
						onCusAddressTabSteps.chooseAddrContactTypeDefault(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onCusAddressTabSteps.chooseDelAddContactType(rowIndex);
					}					
				}
							
			}
		}
	}
}

@When("^customer maintains contact as \"([^\"]*)\"$")
public void customer_maintains_contact_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colPartyContactCode = "Party Contact Code";
		String colSalutation = "Salutation";
		String colFirstName = "First Name";
		String colMiddleName = "Middle Name";
		String colLastName = "Last Name";
		String colName = "Name";
		String colAddressCode = "Address Code";
		String colDesignation = "Designation";
		String colDesignationGroup = "Designation Group";
		String colDepartment = "Department";
		String colIncType = "Inc Type";
		String colDefaultContact = "Default";
		String colDel = "Del";

		String dataTableKey = "Customer_Contact";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCusContactTabSteps.moveToContactTab();

		for (int rowCustomer_Contact : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact,
					colPartyContactCode);
			String salutation = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colSalutation);
			String firstName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colFirstName);
			String middleName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colMiddleName);
			String lastName = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colLastName);
			String name = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colName);
			String addressCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colAddressCode);
			String designation = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colDesignation);
			String designationGroup = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact,
					colDesignationGroup);
			String department = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colDepartment);
			String listIncType = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colIncType);
			String listDefaultContact = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact,
					colDefaultContact);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Contact, colDel);

			if (!partyContactCode.isEmpty()) {
				if (isUpdate) {
					if (!onCusContactTabSteps.isContactExit(partyContactCode)) {
						//onCusContactTabSteps.chooseDelContact(partyContactCode);
						onCusContactTabSteps.clickOnAddContact();
						onCusContactTabSteps.typePartyContactCode(partyContactCode);
					}
					else{
						onCusContactTabSteps.chooseContact(partyContactCode);
					}
				}
				

				if (!salutation.isEmpty()) {
					onCusContactTabSteps.chooseSalutation(salutation);
				}
				if (!firstName.isEmpty()) {
					onCusContactTabSteps.typeFirstName(firstName);
				}
				if (!middleName.isEmpty()) {
					onCusContactTabSteps.typeMiddleName(middleName);
				}
				if (!lastName.isEmpty()) {
					onCusContactTabSteps.typeLastName(lastName);
				}
				if (!name.isEmpty()) {
					onCusContactTabSteps.typeName(name);
				}
				if (!addressCode.isEmpty()) {
					onCusContactTabSteps.chooseAddressCode(addressCode);
				}
				if (!designation.isEmpty()) {
					onCusContactTabSteps.typeDesignation(designation);
				}
				if (!designationGroup.isEmpty()) {
					onCusContactTabSteps.typeDesignationGroup(designationGroup);
				}
				if (!department.isEmpty()) {
					onCusContactTabSteps.typeDepartment(department);
				}
				if (!listIncType.isEmpty()) {
					if (listIncType.contains(",")) {
						String[] sIncType = listIncType.split(",");
						for (String incType : sIncType) {
							if (!incType.trim().isEmpty()) {
								onCusContactTabSteps.chooseIncType(incType.trim());
							}
						}
					} else
						onCusContactTabSteps.chooseIncType(listIncType);
				}
				if (!listDefaultContact.isEmpty()) {
					if (listDefaultContact.contains(",")) {
						String[] sDefault = listDefaultContact.split(",");
						for (String defaultAdd : sDefault) {
							if (!defaultAdd.trim().isEmpty()) {
								onCusContactTabSteps.chooseDefaultIncType(defaultAdd.trim());
							}
						}
					} else
						onCusContactTabSteps.chooseDefaultIncType(listDefaultContact);
				}

				if (del.toLowerCase().equals("y")) {
					onCusContactTabSteps.chooseDelContact(partyContactCode);
				}
			}
		}
	}
    
}

@When("^customer maintains contact type as \"([^\"]*)\"$")
public void customer_maintains_contact_type_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colPartyContactCode = "Party Contact Code";
		String colContactType = "Contact Type";
		String colContactInformation = "Contact Information";
		String colDefaultContactType = "Default";
		String colDelContactType = "Del";

		String dataTableKey = "Customer_ContactType";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer_ContactType : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
					colPartyContactCode);
			String contactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType, colContactType);
			String contactInformation = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
					colContactInformation);
			String defaultContactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
					colDefaultContactType);
			String delContactType = SessionData.getDataTbVal(dataTableKey, rowCustomer_ContactType,
					colDelContactType);

			if (onCusContactTabSteps.chooseContact(partyContactCode)) {
				int rowIndex = onCusContactTabSteps.countRowContactContactTypeTb();
				if (!onCusContactTabSteps.is_added_contact(contactType, contactInformation)){
					onCusContactTabSteps.clickOnAddContactTypeBtn();
					if (!contactType.isEmpty()) {
						onCusContactTabSteps.chooseContactTypeContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onCusContactTabSteps.typeContactTypeContactInformation(contactInformation, rowIndex);
					}
				}
				
				if (defaultContactType.toLowerCase().equals("y")) {
					onCusContactTabSteps.chooseContactTypeTypeDefault(rowIndex);
				}
				if (delContactType.toLowerCase().equals("y")) {
					onCusContactTabSteps.chooseContactTypeDel(rowIndex);
				}
			}
		}
	}
    
}

@When("^customer maintains bank detail as \"([^\"]*)\"$")
public void customer_maintains_bank_detail_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colBank = "Bank";
		String colDescription = "Description";
		String colAccountNo = "Account No";
		String colCurrency = "Currency";
		String colDefaultBank = "Default";
		String colDel = "Del";

		String dataTableKey = "Customer_Bank";
		SessionData.addDataTable(dataTableKey, dataTable);
		onCustomerSteps.moveToBankDetailTab();
		for (int rowCustomer_Bank : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey)
				.keySet()) {
			String bank = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colBank);
			String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colDescription);
			String accountNo = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colAccountNo);
			String currency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colCurrency);
			String defaultBank = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colDefaultBank);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Bank, colDel);

			if (!bank.isEmpty()) {
				if (isUpdate) {
					if (onCusBankDetailTabSteps.isBankExit(bank)) {
						onCusBankDetailTabSteps.chooseBankDel(onCusBankDetailTabSteps.getRowIndexBank(bank));
					}
				}
				onCusBankDetailTabSteps.clickOnAddBank();
				int rowIndex = onCusBankDetailTabSteps.countRowBank();
				onCusBankDetailTabSteps.typeBank(bank, rowIndex);

				if (!description.isEmpty()) {
					onCusBankDetailTabSteps.typeDescription(description, rowIndex);
				}
				if (!accountNo.isEmpty()) {
					onCusBankDetailTabSteps.typeAccountNo(accountNo, rowIndex);
				}
				if (!currency.isEmpty()) {
					onCusBankDetailTabSteps.typeCurrency(currency, rowIndex);
				}
				if (!defaultBank.isEmpty()) {
					onCusBankDetailTabSteps.chooseBankDefault(rowIndex);
				}
				if (!del.isEmpty()) {
					onCusBankDetailTabSteps.chooseBankDel(rowIndex);
				}
			}
		}
	}
    
}

@When("^customer maintains SBU as \"([^\"]*)\"$")
public void customer_maintains_SBU_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colSBU = "SBU";
		String colDescription = "Description";
		String colDel = "Del";

		String dataTableKey = "Customer_SBU";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToSBUTab();
		for (int rowCustomer_SBU : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey)
				.keySet()) {
			String sBU = SessionData.getDataTbVal(dataTableKey, rowCustomer_SBU, colSBU);
			String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_SBU, colDescription);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_SBU, colDel);

			if (!sBU.isEmpty()) {
				if (isUpdate) {
					if (onCusSBUTabSteps.isSBUExit(sBU)) {
						onCusSBUTabSteps.chooseDelSBU(onCusSBUTabSteps.getRowIndexSBU(sBU));
					}
				}
				onCusSBUTabSteps.clickAddSBU();
				int rowIndex = onCusSBUTabSteps.countRowSBU();

				onCusSBUTabSteps.typeSBU(sBU, rowIndex);

				if (!description.isEmpty()) {
					onCusSBUTabSteps.typeDescription(description, rowIndex);
				}
				if (del.toLowerCase().equals("y")) {
					onCusSBUTabSteps.chooseDelSBU(rowIndex);
				}
			}
		}
	}
    
}

@When("^customer maintains sale person as \"([^\"]*)\"$")
public void customer_maintains_sale_person_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colSalesPerson = "Sales Person";
		String colName = "Name";
		String colSalePersonDefault = "Default";
		String colDSales = "D Sales";
		String colDel = "Del";

		String dataTableKey = "Customer_SalePerson";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToSalesPersonTab();

		for (int rowCustomer_SalePerson : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String salesPerson = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colSalesPerson);
			String name = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colName);
			String salePersonDefault = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson,
					colSalePersonDefault);
			String dSales = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colDSales);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_SalePerson, colDel);

			if (!salesPerson.isEmpty()) {
				if (isUpdate) {
					if (onCusSalePersonTabSteps.isSalePersonExit(salesPerson)) {
						onCusSalePersonTabSteps
								.chooseSalesPersonDel(onCusSalePersonTabSteps.getRowIndexSalesPerson(salesPerson));
					}
				}
				onCusSalePersonTabSteps.clickOnAddSalesPeron();
				int rowIndex = onCusSalePersonTabSteps.countRowSalesPerson();

				onCusSalePersonTabSteps.typeSalesPerson(salesPerson, rowIndex);

				if (!name.isEmpty()) {
					onCusSalePersonTabSteps.typeName(name, rowIndex);
				}
				if (!salePersonDefault.isEmpty()) {
					onCusSalePersonTabSteps.chooseSalesPersonDefault(rowIndex);
				}
				if (!dSales.isEmpty()) {
					onCusSalePersonTabSteps.chooseDSales(rowIndex);
				}
				if (!del.isEmpty()) {
					onCusSalePersonTabSteps.chooseSalesPersonDel(rowIndex);
				}
			}
		}
	}
    
}

@When("^customer maintains currency as \"([^\"]*)\"$")
public void customer_maintains_currency_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colCurrency = "Currency";
		String colDel = "Del";

		String dataTableKey = "Customer_Currency";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToCurrencyTab();

		for (int rowCustomer_Currency : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String currency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Currency, colCurrency);
			String del = SessionData.getDataTbVal(dataTableKey, rowCustomer_Currency, colDel);
			if (!currency.isEmpty()) {
				if (isUpdate) {
					if (onCusCurrencyTabSteps.isCurrencyExit(currency)) {
						onCusCurrencyTabSteps.chooseDelCurrency(currency);
					}
				}
				onCusCurrencyTabSteps.clickAddCurrency();
				onCusCurrencyTabSteps.typeCurrency(currency);

				if (del.toLowerCase().equals("y")) {
					onCusCurrencyTabSteps.chooseDelCurrency(currency);
				}
			}
		}
	}
    
}

@When("^customer maintains payment as \"([^\"]*)\"$")
public void customer_maintains_payment_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colOperationalCurrency = "Operational Currency";
		String colNextCreditReviewDate = "Next Credit Review Date";

		String dataTableKey = "Customer_Payment";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToPaymentTab();
		for (int rowCustomer_Payment : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String operationalCurrency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Payment,
					colOperationalCurrency);
			String nextCreditReviewDate = SessionData.getDataTbVal(dataTableKey, rowCustomer_Payment,
					colNextCreditReviewDate);

			if (!operationalCurrency.isEmpty()) {
				onCusPaymentTabSteps.selectOperationalCurrency(operationalCurrency);
			}
			if (!nextCreditReviewDate.isEmpty()) {
				onCusPaymentTabSteps.typeReviewDate(nextCreditReviewDate);
				//nextCreditReviewDate = onCusPaymentTabSteps.getToday();
			}
			
		}
	}
    
}

@When("^customer maintains payment option as \"([^\"]*)\"$")
public void customer_maintains_payment_option_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String tableName = "Payment Option";
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colDescription = "Description";
		String colIsActive = "Is Active";
		String colDefaultOption = "Default";

		String dataTableKey = "Customer_PaymentOption";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer_PaymentTerm : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDescription);
			String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colIsActive);
			String defaultOption = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm,
					colDefaultOption);

			if (defaultOption.trim().toLowerCase().equals("y")) {
				onCusPaymentTabSteps.clickDescription(tableName, description);
				onCusPaymentTabSteps.selectDefault(tableName, description);
			} else if (isActive.trim().toLowerCase().equals("y")) {
				onCusPaymentTabSteps.clickDescription(tableName, description);
				onCusPaymentTabSteps.chooseIsActive(tableName, description);
			}
		}
	}
    
}

@When("^customer maintains payment term as \"([^\"]*)\"$")
public void customer_maintains_payment_term_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String tableNameOption = "Payment Option";
		String tableName = "Payment Term";

		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colDescription = "Description";
		String colIsActive = "Is Active";
		String colDefaultTerm = "Default";
		String colOPTION = "OPTION";

		String dataTableKey = "Customer_PaymentTerm";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer_PaymentTerm : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDescription);
			String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colIsActive);
			String defaultTerm = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDefaultTerm);
			String oPTION = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colOPTION);

			if (!oPTION.isEmpty()) {
				onCusPaymentTabSteps.clickDescription(tableNameOption, oPTION);
				if (defaultTerm.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.clickDescription(tableName, description);
					onCusPaymentTabSteps.selectDefault(tableName, description);
				} else if (isActive.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.clickDescription(tableName, description);
					onCusPaymentTabSteps.chooseIsActive(tableName, description);
				}
			}
		}
	}
    
}

@When("^customer maintains payment menthod as \"([^\"]*)\"$")
public void customer_maintains_payment_menthod_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String tableNameOption = "Payment Option";
		String tableNameTerm = "Payment Term";
		String tableName = "Payment Method";

		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colDescription = "Description";
		String colIsActive = "Is Active";
		String colDefaultMenthod = "Default";
		String colOPTION = "OPTION";
		String colTERM = "TERM";

		String dataTableKey = "Customer_PaymentMenthod";
		SessionData.addDataTable(dataTableKey, dataTable);
		for (int rowCustomer_PaymentMenthod : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colDescription);
			String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colIsActive);
			String defaultMethod = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod,
					colDefaultMenthod);
			String oPTION = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colOPTION);
			String tERM = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colTERM);
			if (!oPTION.isEmpty()) {
				onCusPaymentTabSteps.clickDescription(tableNameOption, oPTION);
				if (!tERM.isEmpty()) {
					onCusPaymentTabSteps.clickDescription(tableNameTerm, tERM);
					if (defaultMethod.trim().toLowerCase().equals("y")) {
						onCusPaymentTabSteps.selectDefault(tableName, description);
					} else if (isActive.trim().toLowerCase().equals("y")) {
						onCusPaymentTabSteps.chooseIsActive(tableName, description);
					}
				}
			}
		}
	}
    
}

@When("^customer maintains local pricing as \"([^\"]*)\"$")
public void customer_maintains_local_pricing_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colCurrencyCode = "Currency Code";
		String colInventoryPriceListCode = "Inventory Price List Code";
		String colServicePriceListCode = "Service Price List Code";

		String dataTableKey = "Cus_LocalPricing";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToLocalInfoTab();
		onCustomerSteps.moveToPricingTab();

		for (int rowCus_LocalPricing : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String currencyCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing, colCurrencyCode);
			String inventoryPriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
					colInventoryPriceListCode);
			String servicePriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
					colServicePriceListCode);

			if (!currencyCode.isEmpty()) {
				int rowIndex = onCusLocalInfoTabSteps.getRowIndexPricing(currencyCode);
				if (rowIndex > 0) {
					if (!inventoryPriceListCode.isEmpty()) {
						onCusLocalInfoTabSteps.typeInventoryPriceListCode(inventoryPriceListCode, rowIndex);
					}
					if (!servicePriceListCode.isEmpty()) {
						onCusLocalInfoTabSteps.typeServicePriceListCode(servicePriceListCode, rowIndex);
					}
				}
			}
		}
	}
    
}

@When("^customer maintains local pricing list as \"([^\"]*)\"$")
public void customer_maintains_local_pricing_list_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colCurrencyCode = "Currency Code";
		String colWorkingAreaCode = "Working Area Code";
		String colInventoryPriceListCode = "Inventory Price List Code";
		String colServicePriceListCode = "Service Price List Code";
		String colDel = "Del";

		String dataTableKey = "Cus_LocalPricingList";
		SessionData.addDataTable(dataTableKey, dataTable);

		for (int rowCus_LocalPricing : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String currencyCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing, colCurrencyCode);
			String workingAreaCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
					colWorkingAreaCode);
			String inventoryPriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
					colInventoryPriceListCode);
			String servicePriceListCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing,
					colServicePriceListCode);
			String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalPricing, colDel);

			int rowIndex = onCusLocalInfoTabSteps.getRowIndexPricing(currencyCode);

			onCusLocalInfoTabSteps.clickOnPriceListIcon(rowIndex);
			onCusLocalInfoTabSteps.clickOnAddListPricing();

			int listRowIndex = onCusLocalInfoTabSteps.countRowListPricing();

			if (!workingAreaCode.isEmpty()) {
				onCusLocalInfoTabSteps.typeListWorkingAreaCode(workingAreaCode, listRowIndex);
			}
			if (!inventoryPriceListCode.isEmpty()) {
				onCusLocalInfoTabSteps.typeListInventoryPriceListCode(inventoryPriceListCode, listRowIndex);
			}
			if (!servicePriceListCode.isEmpty()) {
				onCusLocalInfoTabSteps.typeListServicePriceListCode(servicePriceListCode, listRowIndex);
			}
			if (!del.isEmpty()) {
				onCusLocalInfoTabSteps.chooseDeleteListPricing(listRowIndex);
			}
			onCusLocalInfoTabSteps.clickOnDoneListPricing();
		}
	}
    
}

@When("^customer maintains local credit limit term as \"([^\"]*)\"$")
public void customer_maintains_local_credit_limit_term_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colOperationalCurrency = "Operational Currency";
		String colCreditLimitAmt = "Credit Limit Amt";
		String colGracePeriod = "Grace Period";

		String dataTableKey = "Cus_LocalCreditTerm";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToLocalInfoTab();
		onCustomerSteps.moveToCreditLimitTab();

		for (int rowCus_LocalCreditTerm : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String operationalCurrency = SessionData.getDataTbVal(dataTableKey, rowCus_LocalCreditTerm,
					colOperationalCurrency);
			String creditLimitAmt = SessionData.getDataTbVal(dataTableKey, rowCus_LocalCreditTerm,
					colCreditLimitAmt);
			String gracePeriod = SessionData.getDataTbVal(dataTableKey, rowCus_LocalCreditTerm, colGracePeriod);

			String currency = onCusLocalInfoTabSteps.getOperationCurrency();
			if (operationalCurrency.toUpperCase().equals(currency)) {
				if (!creditLimitAmt.isEmpty()) {
					onCusLocalInfoTabSteps.typeCreditLimitAmt(creditLimitAmt);
				}
				if (!gracePeriod.isEmpty()) {
					onCusLocalInfoTabSteps.typeGracePeriod(gracePeriod);
				}
			}
		}
	}
    
}

@When("^customer maintains local shipment term as \"([^\"]*)\"$")
public void customer_maintains_local_shipment_term_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colInc = "Inc";
		String colShippingTerm = "Shipping Term";
		String colAir = "Air";
		String colSea = "Sea";
		String colRoad = "Road";
		String colRail = "Rail";
		String colDefaultShipment = "Default";

		String dataTableKey = "Cus_LocalShipmentTerm";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToLocalInfoTab();
		onCustomerSteps.moveToShipmentInfo();
		onCustomerSteps.moveToShipmentTermTab();

		for (int rowCus_LocalShipmentTerm : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String inc = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colInc);
			String shippingTerm = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colShippingTerm);
			String air = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colAir);
			String sea = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colSea);
			String road = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colRoad);
			String rail = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colRail);
			String defaultShipment = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm,
					colDefaultShipment);

			if (!shippingTerm.isEmpty()) {
				int rowIndex = onCusLocalInfoTabSteps.getRowIndexShipTerm(shippingTerm);
				if (rowIndex > 0) {
					boolean flagDefault = false;
					if (inc.toLowerCase().equals("y")) {
						onCusLocalInfoTabSteps.chooseInc(rowIndex);
						flagDefault = true;
					} else {
						if (air.toLowerCase().equals("y")) {
							flagDefault = true;
							onCusLocalInfoTabSteps.chooseAir(rowIndex);
						}
						if (road.toLowerCase().equals("y")) {
							flagDefault = true;
							onCusLocalInfoTabSteps.chooseRoad(rowIndex);
						}
						if (rail.toLowerCase().equals("y")) {
							flagDefault = true;
							onCusLocalInfoTabSteps.chooseRail(rowIndex);
						}
						if (sea.toLowerCase().equals("y")) {
							flagDefault = true;
							onCusLocalInfoTabSteps.chooseSea(rowIndex);
						}
					}
					if (defaultShipment.toLowerCase().equals("y") && flagDefault) {
						onCusLocalInfoTabSteps.chooseShipmentDefault(rowIndex);
					}
				}
			}
		}
	}
}

@When("^customer maintains local shipment port as \"([^\"]*)\"$")
public void customer_maintains_local_shipment_port_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colCountry = "Country";
		String colLoading = "Loading";
		String colDischarge = "Discharge";
		String colFinalDest = "Final Dest";
		String colDel = "Del";

		String dataTableKey = "Cus_LocalShipmentPort";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToLocalInfoTab();
		onCustomerSteps.moveToShipmentInfo();
		onCustomerSteps.moveToShipmentPort();

		for (int rowCus_LocalShipmentPort : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String country = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colCountry);
			String loading = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colLoading);
			String discharge = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colDischarge);
			String finalDest = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colFinalDest);
			String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colDel);

			if (!country.isEmpty()) {
				if (isUpdate) {
					if (onCusLocalInfoTabSteps.isCountryExit(country))
						onCusLocalInfoTabSteps.chooseDelCountry(country);
				}
				onCusLocalInfoTabSteps.clickOnAddCountry();
				int rowIndex = onCusLocalInfoTabSteps.countRowCountry();
				onCusLocalInfoTabSteps.typeCountry(country, rowIndex);

				rowIndex = onCusLocalInfoTabSteps.getRowIndexCountry(country);

				if (rowIndex > 0) {
					onCusLocalInfoTabSteps.clickToOpenPort(rowIndex);

					if (loading.toLowerCase().equals("y")) {
						onCusLocalInfoTabSteps.chooseLoading(rowIndex);
					}
					if (discharge.toLowerCase().equals("y")) {
						onCusLocalInfoTabSteps.chooseDischarge(rowIndex);
					}
					if (finalDest.toLowerCase().equals("y")) {
						onCusLocalInfoTabSteps.chooseFinalDest(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onCusLocalInfoTabSteps.chooseDelCountry(rowIndex);
					}
				}
			}

		}
	}
    
}

@When("^customer maintains local detail port as \"([^\"]*)\"$")
public void customer_maintains_local_detail_port_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colCountry = "Country";
		String colLoading = "Loading";
		String colDischarge = "Discharge";
		String colFinalDest = "Final Dest";
		String colPort = "Port";

		String dataTableKey = "Cus_LocalShipmentPortDetail";
		SessionData.addDataTable(dataTableKey, dataTable);

		for (int rowCus_LocalShipmentPortDetail : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String country = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colCountry);
			String loading = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colLoading);
			String discharge = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colDischarge);
			String finalDest = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colFinalDest);
			String port = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colPort);

			if (onCusLocalInfoTabSteps.chooseContry(country)) {
				if (!port.isEmpty()) {
					int rowIndex = onCusLocalInfoTabSteps.getRowIndexPort(port);
					if (rowIndex > 0) {
						if (loading.equals("y")) {
							onCusLocalInfoTabSteps.choosePortLoading(rowIndex);
						}
						if (discharge.equals("y")) {
							onCusLocalInfoTabSteps.choosePortDischange(rowIndex);
						}
						if (finalDest.equals("y")) {
							onCusLocalInfoTabSteps.choosePortFinalDest(rowIndex);
						}
					}
				}
			}
		}
	}
    
}

@When("^customer maintains local customer inverntory as \"([^\"]*)\"$")
public void customer_maintains_local_customer_inverntory_as(String dataKey, List<List<String>> dataTable) {
	if (isContinue) {
		String colKEYCUSTOMER = "KEY CUSTOMER";
		String colInventoryBrand = "Inventory Brand";
		String colDiscountCode = "Discount Code";
		String colDiscount = "Discount";
		String colDel = "Del";

		String dataTableKey = "Cus_LocalInventory";
		SessionData.addDataTable(dataTableKey, dataTable);

		onCustomerSteps.moveToLocalInfoTab();
		onCustomerSteps.moveToCustomerInventory();

		for (int rowCus_LocalInventory : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSTOMER, dataKey).keySet()) {
			String inventoryBrand = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory,
					colInventoryBrand);
			String discountCode = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory, colDiscountCode);
			String discount = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory, colDiscount);
			String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalInventory, colDel);

			onCusLocalInfoTabSteps.clickOnAddInventoryBrand();
			int rowIndex = onCusLocalInfoTabSteps.countRowInventoryBrand();

			if (!inventoryBrand.isEmpty()) {
				onCusLocalInfoTabSteps.typeInventoryBrand(inventoryBrand, rowIndex);
			}
			if (!discountCode.isEmpty()) {
				onCusLocalInfoTabSteps.typeDiscountCode(discountCode, rowIndex);
			}
			if (!discount.isEmpty()) {
				onCusLocalInfoTabSteps.typeDiscount(discount, rowIndex);
			}
			if (!del.isEmpty()) {
				onCusLocalInfoTabSteps.chooseDelInventoryBrand(rowIndex);
			}
		}
	}   
}

	
}
