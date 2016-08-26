package com.synergix.mastersetup.party.customer.customer;

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

		onCustomerSteps.switchToIFrame();

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
		onCustomerSteps.switchOutDefaultIFrame();
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

		onCustomerSteps.switchToIFrame();

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
		onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
						if (onCusAddressTabSteps.isAddressCodeExit(addressCode)) {
							onCusAddressTabSteps.chooseDelAddress(addressCode);
						}
					}
					onCusAddressTabSteps.clickOnAddAddress();
					onCusAddressTabSteps.typeAddressCode(addressCode);

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
				if (nextCreditReviewDate.isEmpty()) {
					nextCreditReviewDate = onCusPaymentTabSteps.getToday();
				}
				onCusPaymentTabSteps.typeReviewDate(nextCreditReviewDate);
			}
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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
			String colDefaultMenthod = "Default Menthod";
			String colOPTION = "OPTION";
			String colTERM = "TERM";

			String dataTableKey = "Customer_PaymentMenthod";
			SessionData.addDataTable(dataTableKey, dataTable);

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
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

			onCustomerSteps.switchToIFrame();

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
			onCustomerSteps.switchOutDefaultIFrame();
		}
	}

	@When("^customer is updated$")
	public void customer_is_updated() {
		if (isContinue) {
			onCustomerSteps.switchToIFrame();
			onCustomerSteps.clickOnUpdateButton();
			onCustomerSteps.switchOutDefaultIFrame();
		}
	}

	@Given("^user create new customer$")
	public void user_create_new_customer() {

		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hCustomerColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colKey = hCustomerColName.get("Key");
		int colCustomerCode = hCustomerColName.get("Customer Code");
		int colUniqueEntityNo = hCustomerColName.get("Unique Entity No");
		int colCustomerName = hCustomerColName.get("Customer Name");
		int colCustomerClassCode = hCustomerColName.get("Customer Class Code");
		int colPartyGroupCode = hCustomerColName.get("Party Group Code");
		int colIndustryCode = hCustomerColName.get("Industry Code");
		int colAcquiredBy = hCustomerColName.get("Acquired By");
		int colCountryOfIncorporation = hCustomerColName.get("Country Of Incorporation");
		int colSalesTaxCode = hCustomerColName.get("Sales Tax Code");
		int colContraRealizedExchGLAN = hCustomerColName.get("Contra Realized Exch GLAN");
		int colStatementDeliveryOption = hCustomerColName.get("Statement Delivery Option");
		int colDefaultTenor = hCustomerColName.get("Default Tenor");
		int colDiscount = hCustomerColName.get("Discount");
		int colDueARInvoiceCorrespondenceLanguage = hCustomerColName.get("Due AR Invoice Correspondence Language");
		int colCustomerRemarks = hCustomerColName.get("Customer Remarks");
		int colStatus = hCustomerColName.get("Status");
		int colMainCustomerCode = hCustomerColName.get("Main Customer Code");
		int colCustomerShortName = hCustomerColName.get("Customer Short Name");
		int colCustomerCategoryCode = hCustomerColName.get("Customer Category Code");
		int colCustomerGroupCode = hCustomerColName.get("Customer Group Code");
		int colCustomerType = hCustomerColName.get("Customer Type");
		int colMainHomePage = hCustomerColName.get("Main Home Page");
		int colGSTRegistrationNo = hCustomerColName.get("GST Registration No");
		int colPartyContraGLAN = hCustomerColName.get("Party Contra GLAN");
		int colDefaultValidity = hCustomerColName.get("Default Validity");
		int colDefaultTenorTermCode = hCustomerColName.get("Default Tenor Term Code");
		int colPriceMarkupPercent = hCustomerColName.get("Price Markup Percent");
		int colCombineShmtoInvoices = hCustomerColName.get("Combine Shm to Invoices");
		int colIPTRelated = hCustomerColName.get("IPT Related");
		int colShippingMarksCode = hCustomerColName.get("Shipping Marks Code");

		String key = "";
		String customerCode = "";
		String uniqueEntityNo = "";
		String customerName = "";
		String customerClassCode = "";
		String partyGroupCode = "";
		String industryCode = "";
		String acquiredBy = "";
		String countryOfIncorporation = "";
		String salesTaxCode = "";
		String contraRealizedExchGLAN = "";
		String statementDeliveryOption = "";
		String defaultTenor = "";
		String discount = "";
		String dueARInvoiceCorrespondenceLanguage = "";
		String customerRemarks = "";
		String mainCustomerCode = "";
		String customerShortName = "";
		String customerCategoryCode = "";
		String customerGroupCode = "";
		String customerType = "";
		String mainHomePage = "";
		String gSTRegistrationNo = "";
		String partyContraGLAN = "";
		String defaultValidity = "";
		String defaultTenorTermCode = "";
		String priceMarkupPercent = "";
		String combineShmtoInvoices = "";
		String iPTRelated = "";
		String shippingMarksCode = "";
		String status = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);

		onCustomerSteps.switchToIFrame();

		for (Integer row : getDataset.keySet()) {
			key = getDataset.get(row).get(colKey);
			customerCode = getDataset.get(row).get(colCustomerCode);
			uniqueEntityNo = getDataset.get(row).get(colUniqueEntityNo);
			customerName = getDataset.get(row).get(colCustomerName);
			customerClassCode = getDataset.get(row).get(colCustomerClassCode);
			partyGroupCode = getDataset.get(row).get(colPartyGroupCode);
			industryCode = getDataset.get(row).get(colIndustryCode);
			acquiredBy = getDataset.get(row).get(colAcquiredBy);
			countryOfIncorporation = getDataset.get(row).get(colCountryOfIncorporation);
			salesTaxCode = getDataset.get(row).get(colSalesTaxCode);
			contraRealizedExchGLAN = getDataset.get(row).get(colContraRealizedExchGLAN);
			statementDeliveryOption = getDataset.get(row).get(colStatementDeliveryOption);
			defaultTenor = getDataset.get(row).get(colDefaultTenor);
			discount = getDataset.get(row).get(colDiscount);
			dueARInvoiceCorrespondenceLanguage = getDataset.get(row).get(colDueARInvoiceCorrespondenceLanguage);
			customerRemarks = getDataset.get(row).get(colCustomerRemarks);
			mainCustomerCode = getDataset.get(row).get(colMainCustomerCode);
			customerShortName = getDataset.get(row).get(colCustomerShortName);
			customerCategoryCode = getDataset.get(row).get(colCustomerCategoryCode);
			customerGroupCode = getDataset.get(row).get(colCustomerGroupCode);
			customerType = getDataset.get(row).get(colCustomerType);
			mainHomePage = getDataset.get(row).get(colMainHomePage);
			gSTRegistrationNo = getDataset.get(row).get(colGSTRegistrationNo);
			partyContraGLAN = getDataset.get(row).get(colPartyContraGLAN);
			defaultValidity = getDataset.get(row).get(colDefaultValidity);
			defaultTenorTermCode = getDataset.get(row).get(colDefaultTenorTermCode);
			priceMarkupPercent = getDataset.get(row).get(colPriceMarkupPercent);
			combineShmtoInvoices = getDataset.get(row).get(colCombineShmtoInvoices);
			iPTRelated = getDataset.get(row).get(colIPTRelated);
			shippingMarksCode = getDataset.get(row).get(colShippingMarksCode);
			status = getDataset.get(row).get(colStatus);

			// onCustomerSteps.searchCustomer("NCUS01");
			onCustomerSteps.clickOnNewBtn();
			if (!customerCode.isEmpty()) {
				onCustomerSteps.typeCustomerCode(customerCode);
			}

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

			// moveToAddressTab(key);
			// moveToContactTab(key);
			// moveToBankDetailsTab(key);
			// moveToSBUTab(key);
			// moveToSalesPersonTab(key);
			moveToCurrencyTab(key);
			moveToPaymentTab(key);
			moveToCompanyTab(key);
			onCustomerSteps.clickOnUpdateButton();
			// moveToLocalInfoTab(key);
		}
		onCustomerSteps.switchOutDefaultIFrame();
	}

	public void moveToAddressTab(String cusKey) {
		if (isContinue) {
			onCustomerSteps.moveToAddressTab();

			HashMap<String, Integer> hAddressColName = SessionData.getExcelColNameBySheetName(keyFileName, addressSheet);
			int colCustomerKey = hAddressColName.get("Customer Key");
			int colKey = hAddressColName.get("Key");
			int colAddressCode = hAddressColName.get("Address Code");
			int colDescription = hAddressColName.get("Description");
			int colAddress = hAddressColName.get("Address");
			int colCountryCode = hAddressColName.get("Country Code");
			int colStateProvince = hAddressColName.get("State Province");
			int colCityTown = hAddressColName.get("City Town");
			int colPostalCode = hAddressColName.get("Postal Code");
			int colBlockEstateName = hAddressColName.get("Block Estate Name");
			int colStreetName = hAddressColName.get("Street Name");
			int colBuildingBlockHouseNo = hAddressColName.get("Building Block House No");
			int colBuildingType = hAddressColName.get("Building Type");
			int colUnitNo = hAddressColName.get("Unit No");

			String customerKey = "";
			String key = "";
			String addressCode = "";
			String description = "";
			String address = "";
			String countryCode = "";
			String stateProvince = "";
			String cityTown = "";
			String postalCode = "";
			String blockEstateName = "";
			String streetName = "";
			String buildingBlockHouseNo = "";
			String buildingType = "";
			String unitNo = "";

			LinkedHashMap<Integer, List<String>> getAddress = SessionData.getExcelSheetDataNoHeader(keyFileName,
					addressSheet);
			for (Integer rowAddress : getAddress.keySet()) {
				customerKey = getAddress.get(rowAddress).get(colCustomerKey);
				key = getAddress.get(rowAddress).get(colKey);
				addressCode = getAddress.get(rowAddress).get(colAddressCode);
				description = getAddress.get(rowAddress).get(colDescription);
				address = getAddress.get(rowAddress).get(colAddress);
				countryCode = getAddress.get(rowAddress).get(colCountryCode);
				stateProvince = getAddress.get(rowAddress).get(colStateProvince);
				cityTown = getAddress.get(rowAddress).get(colCityTown);
				postalCode = getAddress.get(rowAddress).get(colPostalCode);
				blockEstateName = getAddress.get(rowAddress).get(colBlockEstateName);
				streetName = getAddress.get(rowAddress).get(colStreetName);
				buildingBlockHouseNo = getAddress.get(rowAddress).get(colBuildingBlockHouseNo);
				buildingType = getAddress.get(rowAddress).get(colBuildingType);
				unitNo = getAddress.get(rowAddress).get(colUnitNo);

				onCusAddressTabSteps.clickOnAddAddress();

				if (!addressCode.isEmpty()) {
					onCusAddressTabSteps.typeAddressCode(addressCode);
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

				chooseIncType(key);
				addAddressContacType(key);
			}
		}
	}

	public void chooseIncType(String addressKey) {
		HashMap<String, Integer> hAddressIncTypeColName = SessionData.getExcelColNameBySheetName(keyFileName,
				addressIncTypeSheet);

		int colKey = hAddressIncTypeColName.get("Address Key");
		String key = "";
		int colIncType = hAddressIncTypeColName.get("Inc Type");
		String incType = "";
		int colAddrDefault = hAddressIncTypeColName.get("Default");
		String addrDefault = "";

		LinkedHashMap<Integer, List<String>> getAddressIncType = SessionData.getExcelSheetDataNoHeader(keyFileName,
				addressIncTypeSheet);
		for (Integer rowAddressIncType : getAddressIncType.keySet()) {
			key = getAddressIncType.get(rowAddressIncType).get(colKey);
			incType = getAddressIncType.get(rowAddressIncType).get(colIncType);
			addrDefault = getAddressIncType.get(rowAddressIncType).get(colAddrDefault);

			if (!incType.isEmpty()) {
				onCusAddressTabSteps.chooseIncType(incType);
			}
			if (addrDefault.toLowerCase().equals("y")) {
				onCusAddressTabSteps.chooseDefaultIncType(incType);
			}
		}
	}

	public void addAddressContacType(String addressKey) {
		HashMap<String, Integer> hAddressContactTypeColName = SessionData.getExcelColNameBySheetName(keyFileName,
				addressContactTypeSheet);

		int colKey = hAddressContactTypeColName.get("Address Key");
		int colContactType = hAddressContactTypeColName.get("Contact Type");
		int colContactInformation = hAddressContactTypeColName.get("Contact Information");
		int colAddrContactTypeDefault = hAddressContactTypeColName.get("Default");
		int colDel = hAddressContactTypeColName.get("Del");

		String key = "";
		String contactType = "";
		String contactInformation = "";
		String addrContactTypeDefault = "";
		String del = "";
		LinkedHashMap<Integer, List<String>> getAddressContactType = SessionData.getExcelSheetDataNoHeader(keyFileName,
				addressContactTypeSheet);
		for (Integer rowAddressContactType : getAddressContactType.keySet()) {
			key = getAddressContactType.get(rowAddressContactType).get(colKey);
			contactType = getAddressContactType.get(rowAddressContactType).get(colContactType);
			contactInformation = getAddressContactType.get(rowAddressContactType).get(colContactInformation);
			addrContactTypeDefault = getAddressContactType.get(rowAddressContactType).get(colAddrContactTypeDefault);
			del = getAddressContactType.get(rowAddressContactType).get(colDel);

			if (addressKey.equals(key)) {
				onCusAddressTabSteps.clickOnAddAddrContactType();
				int rowIndex = onCusAddressTabSteps.countRowAddrContactType();

				if (!contactType.isEmpty()) {
					onCusAddressTabSteps.chooseContactType(contactType, rowIndex);
				}
				if (!contactInformation.isEmpty()) {
					onCusAddressTabSteps.typeContactInformation(contactInformation, rowIndex);
				}
				if (!addrContactTypeDefault.isEmpty()) {
					onCusAddressTabSteps.chooseAddrContactTypeDefault(rowIndex);
				}
				if (del.toLowerCase().equals("y")) {
					onCusAddressTabSteps.chooseDelAddContactType(rowIndex);
				}
			}
		}
	}

	public void moveToContactTab(String cusKey) {
		onCustomerSteps.moveToContactTab();
		HashMap<String, Integer> hContactColName = SessionData.getExcelColNameBySheetName(keyFileName, contactSheet);

		int colContactKey = hContactColName.get("Key");
		int colPartyContactCode = hContactColName.get("Party Contact Code");
		int colSalutation = hContactColName.get("Salutation");
		int colFirstName = hContactColName.get("First Name");
		int colMiddleName = hContactColName.get("Middle Name");
		int colLastName = hContactColName.get("Last Name");
		int colName = hContactColName.get("Name");
		int colAddressCode = hContactColName.get("Address Code");
		int colDesignation = hContactColName.get("Designation");
		int colDesignationGroup = hContactColName.get("Designation Group");
		int colDepartment = hContactColName.get("Department");

		String contactKey = "";
		String partyContactCode = "";
		String salutation = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String name = "";
		String addressCode = "";
		String designation = "";
		String designationGroup = "";
		String department = "";

		HashMap<String, Integer> hContactIncTypeColName = SessionData.getExcelColNameBySheetName(keyFileName,
				contactIncTypeSheet);
		int colIncTypeKey = hContactIncTypeColName.get("Key");
		int colIncType = hContactIncTypeColName.get("Inc Type");
		int colIncDefault = hContactIncTypeColName.get("Default");

		String incTypeKey = "";
		String incType = "";
		String incDefault = "";

		HashMap<String, Integer> hContactTypeColName = SessionData.getExcelColNameBySheetName(keyFileName, contactTypeSheet);
		int colcontactTypeTypeKey = hContactTypeColName.get("Key");
		int colContactTypeContactType = hContactTypeColName.get("Contact Type");
		int colContactTypeContactInformation = hContactTypeColName.get("Contact Information");
		int colContactTypeTypeDefault = hContactTypeColName.get("Default");
		int colContactTypeDel = hContactTypeColName.get("Del");
		String contactTypeTypeKey = "";
		String contactTypeContactType = "";
		String contactTypeContactInformation = "";
		String contactTypeTypeDefault = "";
		String contactTypeDel = "";

		LinkedHashMap<Integer, List<String>> getContact = SessionData.getExcelSheetDataNoHeader(keyFileName,
				contactSheet);
		for (Integer rowContact : getContact.keySet()) {
			contactKey = getContact.get(rowContact).get(colContactKey);
			partyContactCode = getContact.get(rowContact).get(colPartyContactCode);
			salutation = getContact.get(rowContact).get(colSalutation);
			firstName = getContact.get(rowContact).get(colFirstName);
			middleName = getContact.get(rowContact).get(colMiddleName);
			lastName = getContact.get(rowContact).get(colLastName);
			name = getContact.get(rowContact).get(colName);
			addressCode = getContact.get(rowContact).get(colAddressCode);
			designation = getContact.get(rowContact).get(colDesignation);
			designationGroup = getContact.get(rowContact).get(colDesignationGroup);
			department = getContact.get(rowContact).get(colDepartment);

			onCusContactTabSteps.clickOnAddContact();
			// if(contactKey.equals(supKey))
			if (!partyContactCode.isEmpty()) {
				onCusContactTabSteps.typePartyContactCode(partyContactCode);
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

			LinkedHashMap<Integer, List<String>> getContactIncType = SessionData.getExcelSheetDataNoHeader(keyFileName,
					contactIncTypeSheet);
			for (Integer rowContactIncType : getContactIncType.keySet()) {
				incTypeKey = getContactIncType.get(rowContactIncType).get(colIncTypeKey);
				incType = getContactIncType.get(rowContactIncType).get(colIncType);
				incDefault = getContactIncType.get(rowContactIncType).get(colIncDefault);

				if (incTypeKey.equals(contactKey)) {
					if (!incType.isEmpty()) {
						onCusContactTabSteps.chooseIncType(incType);
					}
					if (incDefault.toLowerCase().equals("y")) {
						onCusContactTabSteps.chooseDefaultIncType(incType);
					}
				}
			}

			LinkedHashMap<Integer, List<String>> getContactType = SessionData.getExcelSheetDataNoHeader(keyFileName,
					contactTypeSheet);
			for (Integer rowContactType : getContactType.keySet()) {
				contactTypeTypeKey = getContactType.get(rowContactType).get(colcontactTypeTypeKey);
				contactTypeContactType = getContactType.get(rowContactType).get(colContactTypeContactType);
				contactTypeContactInformation = getContactType.get(rowContactType)
						.get(colContactTypeContactInformation);
				contactTypeTypeDefault = getContactType.get(rowContactType).get(colContactTypeTypeDefault);
				contactTypeDel = getContactType.get(rowContactType).get(colContactTypeDel);

				if (contactTypeTypeKey.equals(contactKey)) {
					onCusContactTabSteps.clickOnAddContactTypeBtn();
					int rowIndex = onCusContactTabSteps.countRowContactContactTypeTb();

					if (!contactTypeContactType.isEmpty()) {
						onCusContactTabSteps.chooseContactTypeContactType(contactTypeContactType, rowIndex);
					}
					if (!contactTypeContactInformation.isEmpty()) {
						onCusContactTabSteps.typeContactTypeContactInformation(contactTypeContactInformation, rowIndex);
					}
					if (contactTypeTypeDefault.toLowerCase().equals("y")) {
						onCusContactTabSteps.chooseContactTypeTypeDefault(rowIndex);
					}
					if (contactTypeDel.toLowerCase().equals("y")) {
						onCusContactTabSteps.chooseContactTypeDel(rowIndex);
					}
				}
			}
		}
	}

	public void moveToCurrencyTab(String cusKey) {

		onCustomerSteps.moveToCurrencyTab();

		String key = "";
		String currency = "";
		HashMap<String, Integer> hCurrencyColName = SessionData.getExcelColNameBySheetName(keyFileName, currencySheet);
		int colCurrency = hCurrencyColName.get("Currency");
		int colKey = hCurrencyColName.get("Customer Key");

		LinkedHashMap<Integer, List<String>> getCurrency = SessionData.getExcelSheetDataNoHeader(keyFileName,
				currencySheet);
		for (Integer rowCurrency : getCurrency.keySet()) {
			currency = getCurrency.get(rowCurrency).get(colCurrency);
			if (!currency.isEmpty()) {
				onCusCurrencyTabSteps.clickAddCurrency();
				onCusCurrencyTabSteps.typeCurrency(currency);
			}
		}
	}

	public void moveToBankDetailsTab(String cusKey) {
		onCustomerSteps.moveToBankDetailTab();

		HashMap<String, Integer> hBankDetailColName = SessionData.getExcelColNameBySheetName(keyFileName, bankDetailSheet);
		int colKey = hBankDetailColName.get("Customer Key");
		int colBank = hBankDetailColName.get("Bank");
		int colDescription = hBankDetailColName.get("Description");
		int colAccountNo = hBankDetailColName.get("Account No");
		int colCurrency = hBankDetailColName.get("Currency");
		int colBankDefault = hBankDetailColName.get("Default");
		int colDel = hBankDetailColName.get("Del");

		String key = "";
		String bank = "";
		String description = "";
		String accountNo = "";
		String currency = "";
		String bankDefault = "";
		String del = "";
		int rowIndex;
		LinkedHashMap<Integer, List<String>> getBankDetail = SessionData.getExcelSheetDataNoHeader(keyFileName,
				bankDetailSheet);
		for (Integer rowBankDetail : getBankDetail.keySet()) {
			key = getBankDetail.get(rowBankDetail).get(colKey);
			bank = getBankDetail.get(rowBankDetail).get(colBank);
			description = getBankDetail.get(rowBankDetail).get(colDescription);
			accountNo = getBankDetail.get(rowBankDetail).get(colAccountNo);
			currency = getBankDetail.get(rowBankDetail).get(colCurrency);
			bankDefault = getBankDetail.get(rowBankDetail).get(colBankDefault);
			del = getBankDetail.get(rowBankDetail).get(colDel);

			onCusBankDetailTabSteps.clickOnAddBank();
			rowIndex = onCusBankDetailTabSteps.countRowBank();

			if (!bank.isEmpty()) {
				onCusBankDetailTabSteps.typeBank(bank, rowIndex);
			}
			if (!description.isEmpty()) {
				onCusBankDetailTabSteps.typeDescription(description, rowIndex);
			}
			if (!accountNo.isEmpty()) {
				onCusBankDetailTabSteps.typeAccountNo(accountNo, rowIndex);
			}
			if (!currency.isEmpty()) {
				onCusBankDetailTabSteps.typeCurrency(currency, rowIndex);
			}
			if (bankDefault.equals("y")) {
				onCusBankDetailTabSteps.chooseBankDefault(rowIndex);
			}
			if (del.equals("y")) {
				onCusBankDetailTabSteps.chooseBankDel(rowIndex);
			}
		}
	}

	public void moveToSBUTab(String cuskey) {

		onCustomerSteps.moveToSBUTab();

		HashMap<String, Integer> hSBUColName = SessionData.getExcelColNameBySheetName(keyFileName, sBUSheet);
		int colSBUKey = hSBUColName.get("Customer Key");
		int colSBU = hSBUColName.get("SBU");
		int colDescription = hSBUColName.get("Description");
		int colDel = hSBUColName.get("Del");

		String sBUKey = "";
		String sBU = "";
		String description = "";
		String del = "";

		LinkedHashMap<Integer, List<String>> getSBU = SessionData.getExcelSheetDataNoHeader(keyFileName, sBUSheet);
		for (Integer rowSBU : getSBU.keySet()) {

			sBUKey = getSBU.get(rowSBU).get(colSBUKey);
			sBU = getSBU.get(rowSBU).get(colSBU);
			description = getSBU.get(rowSBU).get(colDescription);
			del = getSBU.get(rowSBU).get(colDel);

			onCusSBUTabSteps.clickAddSBU();
			int rowIndex = onCusSBUTabSteps.countRowSBU();
			// if(sBUKey.equals(supKey))

			if (!sBU.isEmpty()) {
				onCusSBUTabSteps.typeSBU(sBU, rowIndex);
			}
			if (!description.isEmpty()) {
				onCusSBUTabSteps.typeDescription(description, rowIndex);
			}
			if (del.toLowerCase().equals("y")) {
				onCusSBUTabSteps.chooseDelSBU(rowIndex);
			}
		}

	}

	public void moveToSalesPersonTab(String cusKey) {

		onCustomerSteps.moveToSalesPersonTab();

		HashMap<String, Integer> hSalesPersonColName = SessionData.getExcelColNameBySheetName(keyFileName, salesPersonSheet);
		int colKey = hSalesPersonColName.get("Customer Key");
		int colSalesPerson = hSalesPersonColName.get("Sales Person");
		int colName = hSalesPersonColName.get("Name");
		int colSalesPersonDefault = hSalesPersonColName.get("Default");
		int colDSales = hSalesPersonColName.get("D Sales");
		int colDel = hSalesPersonColName.get("Del");

		String key = "";
		String salesPerson = "";
		String name = "";
		String salesPersonDefault = "";
		String dSales = "";
		String del = "";

		int rowIndex;
		LinkedHashMap<Integer, List<String>> getSalesPerson = SessionData.getExcelSheetDataNoHeader(keyFileName,
				salesPersonSheet);
		for (Integer rowSalesPerson : getSalesPerson.keySet()) {
			key = getSalesPerson.get(rowSalesPerson).get(colKey);
			salesPerson = getSalesPerson.get(rowSalesPerson).get(colSalesPerson);
			name = getSalesPerson.get(rowSalesPerson).get(colName);
			salesPersonDefault = getSalesPerson.get(rowSalesPerson).get(colSalesPersonDefault);
			dSales = getSalesPerson.get(rowSalesPerson).get(colDSales);
			del = getSalesPerson.get(rowSalesPerson).get(colDel);

			onCusSalePersonTabSteps.clickOnAddSalesPeron();
			rowIndex = onCusSalePersonTabSteps.countRowSalesPerson();
			// if (!key.isEmpty())

			if (!salesPerson.isEmpty()) {
				onCusSalePersonTabSteps.typeSalesPerson(salesPerson, rowIndex);
				rowIndex = onCusSalePersonTabSteps.getRowIndexSalesPerson(salesPerson);
				if (rowIndex > 0) {
					if (!name.isEmpty()) {
						onCusSalePersonTabSteps.typeName(name, rowIndex);
					}
					if (!salesPersonDefault.isEmpty()) {
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

	public void moveToPaymentTab(String cusKey) {
		onCustomerSteps.moveToPaymentTab();

		HashMap<String, Integer> hPaymentColName = SessionData.getExcelColNameBySheetName(keyFileName, paymentSheet);
		int colKey = hPaymentColName.get("Customer Key");
		int colOperationalCurrency = hPaymentColName.get("Operational Currency");
		int colReviewDate = hPaymentColName.get("Next Credit Review Date");

		String key = "";
		String operationalCurrency = "";
		String reviewDate = "";

		LinkedHashMap<Integer, List<String>> getPayment = SessionData.getExcelSheetDataNoHeader(keyFileName,
				paymentSheet);
		for (Integer rowPayment : getPayment.keySet()) {
			operationalCurrency = getPayment.get(rowPayment).get(colOperationalCurrency);
			reviewDate = getPayment.get(rowPayment).get(colReviewDate);

			if (!operationalCurrency.isEmpty()) {
				onCusPaymentTabSteps.selectOperationalCurrency(operationalCurrency);
			}
			if (!reviewDate.isEmpty()) {
				onCusPaymentTabSteps.typeReviewDate(reviewDate);
			}
		}
		selectPaymentOption();
	}

	public void moveToCompanyTab(String cusKey) {
		onCustomerSteps.moveToCompanyTab();

		String key = "";
		String company = "";

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colKey = hCompanyColName.get("Customer Key");
		int colCompany = hCompanyColName.get("Company");

		LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetData(keyFileName, companySheet);
		for (Integer rowComp : getCompany.keySet()) {
			key = getCompany.get(rowComp).get(colKey);
			if (key.equals(cusKey)) {
				company = getCompany.get(rowComp).get(colCompany);
				if (company.trim().toLowerCase().equals("all")) {
					onCustomerSteps.checkAllCompany();
				} else
					onCustomerSteps.checkCompany(company);
			}
		}
	}

	public void selectPaymentOption() {
		HashMap<String, Integer> hPaymentOptionColName = SessionData.getExcelColNameBySheetName(keyFileName,
				paymentOptionSheet);
		int colKeyOption = hPaymentOptionColName.get("Key Option");
		int colDescOption = hPaymentOptionColName.get("Description");
		int colIsActiveOption = hPaymentOptionColName.get("Is Active");
		int colDefaultOption = hPaymentOptionColName.get("Default");

		String keyOption = "";
		String descOption = "";
		String isActiveOption = "";
		String defaultOption = "";

		LinkedHashMap<Integer, List<String>> getPaymentOption = SessionData.getExcelSheetDataNoHeader(keyFileName,
				paymentOptionSheet);
		for (Integer rowPaymentOption : getPaymentOption.keySet()) {
			keyOption = getPaymentOption.get(rowPaymentOption).get(colKeyOption);
			descOption = getPaymentOption.get(rowPaymentOption).get(colDescOption);
			isActiveOption = getPaymentOption.get(rowPaymentOption).get(colIsActiveOption);
			defaultOption = getPaymentOption.get(rowPaymentOption).get(colDefaultOption);

			if (defaultOption.trim().toLowerCase().equals("y")) {
				onCusPaymentTabSteps.selectDefault("Payment Option", descOption);
				onCusPaymentTabSteps.clickDescription("Payment Option", descOption);
				selectPaymentTerm(keyOption);
			} else if (isActiveOption.trim().toLowerCase().equals("y")) {
				onCusPaymentTabSteps.clickDescription("Payment Option", descOption);
				onCusPaymentTabSteps.chooseIsActive("Payment Option", descOption);
				selectPaymentTerm(keyOption);
			}
		}
	}

	public void selectPaymentTerm(String keyOption) {
		String tableName = "Payment Term";
		HashMap<String, Integer> hPaymentTermColName = SessionData.getExcelColNameBySheetName(keyFileName, paymentTermSheet);
		int colKeyOpetionTerm = hPaymentTermColName.get("Key Option");
		int colKeyTerm = hPaymentTermColName.get("Key Term");
		int colDescTerm = hPaymentTermColName.get("Description");
		int colIsActiveTerm = hPaymentTermColName.get("Is Active");
		int colDefaultTerm = hPaymentTermColName.get("Default");

		String keyOptionTerm = "";
		String keyTerm = "";
		String descTerm = "";
		String isActiveTerm = "";
		String defaultTerm = "";

		LinkedHashMap<Integer, List<String>> getPaymentTerm = SessionData.getExcelSheetDataNoHeader(keyFileName,
				paymentTermSheet);
		for (Integer rowPaymentTerm : getPaymentTerm.keySet()) {
			keyOptionTerm = getPaymentTerm.get(rowPaymentTerm).get(colKeyOpetionTerm);
			keyTerm = getPaymentTerm.get(rowPaymentTerm).get(colKeyTerm);
			descTerm = getPaymentTerm.get(rowPaymentTerm).get(colDescTerm);
			isActiveTerm = getPaymentTerm.get(rowPaymentTerm).get(colIsActiveTerm);
			defaultTerm = getPaymentTerm.get(rowPaymentTerm).get(colDefaultTerm);
			if (keyOption.equals(keyOptionTerm)) {
				if (defaultTerm.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.selectDefault(tableName, descTerm);
					onCusPaymentTabSteps.clickDescription(tableName, descTerm);
					selectPaymentMethod(keyOption);
				} else if (isActiveTerm.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.clickDescription(tableName, descTerm);
					onCusPaymentTabSteps.chooseIsActive(tableName, descTerm);
					selectPaymentMethod(keyTerm);
				}
			}
		}

	}

	public void selectPaymentMethod(String keyTerm) {
		String tableName = "Payment Method";
		HashMap<String, Integer> hPaymentMethodColName = SessionData.getExcelColNameBySheetName(keyFileName,
				paymentMethodSheet);
		int colKeyTermMethod = hPaymentMethodColName.get("Key Term");
		int colDescMethod = hPaymentMethodColName.get("Description");
		int colIsActiveMethod = hPaymentMethodColName.get("Is Active");
		int colDefaultMethod = hPaymentMethodColName.get("Default");

		String keyTermMethod = "";
		String descMethod = "";
		String isActiveMethod = "";
		String defaultMethod = "";

		LinkedHashMap<Integer, List<String>> getPaymentMethod = SessionData.getExcelSheetDataNoHeader(keyFileName,
				paymentMethodSheet);
		for (Integer rowMethod : getPaymentMethod.keySet()) {
			keyTermMethod = getPaymentMethod.get(rowMethod).get(colKeyTermMethod);
			descMethod = getPaymentMethod.get(rowMethod).get(colDescMethod);
			isActiveMethod = getPaymentMethod.get(rowMethod).get(colIsActiveMethod);
			defaultMethod = getPaymentMethod.get(rowMethod).get(colDefaultMethod);

			if (keyTerm.equals(keyTermMethod)) {
				if (defaultMethod.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.selectDefault(tableName, descMethod);
				} else if (isActiveMethod.trim().toLowerCase().equals("y")) {
					onCusPaymentTabSteps.chooseIsActive(tableName, descMethod);
				}
			}
		}
	}

	public void moveToLocalInfoTab(String cusKey) {
		onCustomerSteps.moveToLocalInfoTab();
		moveToPricingTab(cusKey);
		// moveToCreditLimitTab(cusKey);
		moveToShipmentInfoTab(cusKey);
		moveToCustomerInventory(cusKey);
	}

	public void moveToPricingTab(String cusKey) {

		onCustomerSteps.moveToPricingTab();

		HashMap<String, Integer> hLocalPricingColName = SessionData.getExcelColNameBySheetName(keyFileName,
				localPricingSheet);

		int colCustomerKey = hLocalPricingColName.get("Customer Key");
		int colKey = hLocalPricingColName.get("Key");
		int colCurrencyCode = hLocalPricingColName.get("Currency Code");
		int colInventoryPriceListCode = hLocalPricingColName.get("Inventory Price List Code");
		int colServicePriceListCode = hLocalPricingColName.get("Service Price List Code");

		String customerKey = "";
		String key = "";
		String currencyCode = "";
		String inventoryPriceListCode = "";
		String servicePriceListCode = "";

		int rowIndex;
		LinkedHashMap<Integer, List<String>> getLocalPricing = SessionData.getExcelSheetDataNoHeader(keyFileName,
				localPricingSheet);
		for (Integer rowLocalPricing : getLocalPricing.keySet()) {
			customerKey = getLocalPricing.get(rowLocalPricing).get(colCustomerKey);
			key = getLocalPricing.get(rowLocalPricing).get(colKey);
			currencyCode = getLocalPricing.get(rowLocalPricing).get(colCurrencyCode);
			inventoryPriceListCode = getLocalPricing.get(rowLocalPricing).get(colInventoryPriceListCode);
			servicePriceListCode = getLocalPricing.get(rowLocalPricing).get(colServicePriceListCode);
			// if(cusKey.equals(customerKey))

			if (!currencyCode.isEmpty()) {
				rowIndex = onCusLocalInfoTabSteps.getRowIndexPricing(currencyCode);

				if (rowIndex > 0) {
					if (!inventoryPriceListCode.isEmpty()) {
						onCusLocalInfoTabSteps.typeInventoryPriceListCode(inventoryPriceListCode, rowIndex);
					}

					if (!servicePriceListCode.isEmpty()) {
						onCusLocalInfoTabSteps.typeServicePriceListCode(servicePriceListCode, rowIndex);
					}

					onCusLocalInfoTabSteps.clickOnPriceListIcon(rowIndex);

					HashMap<String, Integer> hPricingListColName = SessionData.getExcelColNameBySheetName(keyFileName,
							pricingListSheet);
					int colPricingKey = hPricingListColName.get("Pricing Key");
					int colListWorkingAreaCode = hPricingListColName.get("Working Area Code");
					int colListInventoryPriceListCode = hPricingListColName.get("Inventory Price List Code");
					int colListServicePriceListCode = hPricingListColName.get("Service Price List Code");
					int colDelete = hPricingListColName.get("Delete");

					String pricingKey = "";
					String listWorkingAreaCode = "";
					String listInventoryPriceListCode = "";
					String listServicePriceListCode = "";
					String delete = "";

					int listRowIndex;
					LinkedHashMap<Integer, List<String>> getPricingList = SessionData
							.getExcelSheetDataNoHeader(keyFileName, pricingListSheet);
					for (Integer rowPricingList : getPricingList.keySet()) {
						pricingKey = getPricingList.get(rowPricingList).get(colPricingKey);
						listWorkingAreaCode = getPricingList.get(rowPricingList).get(colListWorkingAreaCode);
						listInventoryPriceListCode = getPricingList.get(rowPricingList)
								.get(colListInventoryPriceListCode);
						listServicePriceListCode = getPricingList.get(rowPricingList).get(colListServicePriceListCode);
						delete = getPricingList.get(rowPricingList).get(colDelete);

						if (pricingKey.equals(key)) {
							onCusLocalInfoTabSteps.clickOnAddListPricing();
							listRowIndex = onCusLocalInfoTabSteps.countRowListPricing();
							if (!listWorkingAreaCode.isEmpty()) {
								onCusLocalInfoTabSteps.typeListWorkingAreaCode(listWorkingAreaCode, listRowIndex);
							}
							if (!listInventoryPriceListCode.isEmpty()) {
								onCusLocalInfoTabSteps.typeListInventoryPriceListCode(listInventoryPriceListCode,
										listRowIndex);
							}
							if (!listServicePriceListCode.isEmpty()) {
								onCusLocalInfoTabSteps.typeListServicePriceListCode(listServicePriceListCode,
										listRowIndex);
							}
							if (!delete.isEmpty()) {
								onCusLocalInfoTabSteps.chooseDeleteListPricing(listRowIndex);
							}
						}
					}
					onCusLocalInfoTabSteps.clickOnDoneListPricing();
				}
			}
		}
	}

	public void moveToCreditLimitTab(String cusKey) {
		onCustomerSteps.moveToCreditLimitTab();

		HashMap<String, Integer> hLocalCreditLimitTermColName = SessionData.getExcelColNameBySheetName(keyFileName,
				localCreditLimitTermSheet);
		int colCustomerKey = hLocalCreditLimitTermColName.get("Customer Key");
		int colOperationalCurrency = hLocalCreditLimitTermColName.get("Operational Currency");
		int colCreditLimitAmt = hLocalCreditLimitTermColName.get("Credit Limit Amt");
		int colGracePeriod = hLocalCreditLimitTermColName.get("Grace Period");

		String customerKey = "";
		String operationalCurrency = "";
		String creditLimitAmt = "";
		String gracePeriod = "";

		LinkedHashMap<Integer, List<String>> getLocalCreditLimitTerm = SessionData
				.getExcelSheetDataNoHeader(keyFileName, localCreditLimitTermSheet);
		for (Integer rowLocalCreditLimitTerm : getLocalCreditLimitTerm.keySet()) {
			customerKey = getLocalCreditLimitTerm.get(rowLocalCreditLimitTerm).get(colCustomerKey);
			operationalCurrency = getLocalCreditLimitTerm.get(rowLocalCreditLimitTerm).get(colOperationalCurrency);
			creditLimitAmt = getLocalCreditLimitTerm.get(rowLocalCreditLimitTerm).get(colCreditLimitAmt);
			gracePeriod = getLocalCreditLimitTerm.get(rowLocalCreditLimitTerm).get(colGracePeriod);

			// if(customerKey.equals(cusKey))
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

	public void moveToShipmentInfoTab(String cusKey) {
		onCustomerSteps.moveToShipmentInfo();
		moveToShipmentTermTab(cusKey);
		moveToShipmentPortTab(cusKey);
	}

	public void moveToShipmentTermTab(String cusKey) {

		onCustomerSteps.moveToShipmentTermTab();

		HashMap<String, Integer> hShipmentModeTermColName = SessionData.getExcelColNameBySheetName(keyFileName,
				localShipmentTermSheet);
		int colKey = hShipmentModeTermColName.get("Customer Key");
		int colInc = hShipmentModeTermColName.get("Inc");
		int colShippingTerm = hShipmentModeTermColName.get("Shipping Term");
		int colAir = hShipmentModeTermColName.get("Air");
		int colRoad = hShipmentModeTermColName.get("Road");
		int colRail = hShipmentModeTermColName.get("Rail");
		int colShipmentDefault = hShipmentModeTermColName.get("Default");
		int colSea = hShipmentModeTermColName.get("Sea");

		String key = "";
		String inc = "";
		String shippingTerm = "";
		String air = "";
		String road = "";
		String rail = "";
		String shipmentDefault = "";
		String sea = "";

		int rowIndex;
		LinkedHashMap<Integer, List<String>> getShipmentModeTerm = SessionData.getExcelSheetDataNoHeader(keyFileName,
				localShipmentTermSheet);
		for (Integer rowShipmentModeTerm : getShipmentModeTerm.keySet()) {

			key = getShipmentModeTerm.get(rowShipmentModeTerm).get(colKey);
			inc = getShipmentModeTerm.get(rowShipmentModeTerm).get(colInc);
			shippingTerm = getShipmentModeTerm.get(rowShipmentModeTerm).get(colShippingTerm);
			air = getShipmentModeTerm.get(rowShipmentModeTerm).get(colAir);
			road = getShipmentModeTerm.get(rowShipmentModeTerm).get(colRoad);
			rail = getShipmentModeTerm.get(rowShipmentModeTerm).get(colRail);
			shipmentDefault = getShipmentModeTerm.get(rowShipmentModeTerm).get(colShipmentDefault);
			sea = getShipmentModeTerm.get(rowShipmentModeTerm).get(colSea);
			// if (!key.isEmpty())

			if (!shippingTerm.isEmpty()) {
				if (!shippingTerm.isEmpty()) {
					rowIndex = onCusLocalInfoTabSteps.getRowIndexShipTerm(shippingTerm);
					if (rowIndex > 0) {
						if (!inc.isEmpty()) {
							onCusLocalInfoTabSteps.chooseInc(rowIndex);
						}
						if (!air.isEmpty()) {
							onCusLocalInfoTabSteps.chooseAir(rowIndex);
						}
						if (!road.isEmpty()) {
							onCusLocalInfoTabSteps.chooseRoad(rowIndex);
						}
						if (!rail.isEmpty()) {
							onCusLocalInfoTabSteps.chooseRail(rowIndex);
						}
						if (!shipmentDefault.isEmpty()) {
							onCusLocalInfoTabSteps.chooseShipmentDefault(rowIndex);
						}

						if (!sea.isEmpty()) {
							onCusLocalInfoTabSteps.chooseSea(rowIndex);
						}
					}
				}
			}
		}
	}

	public void moveToShipmentPortTab(String cusKey) {
		onCustomerSteps.moveToShipmentPort();

		HashMap<String, Integer> hCountryPortColName = SessionData.getExcelColNameBySheetName(keyFileName,
				localShipmentPortSheet);
		int colKey = hCountryPortColName.get("Customer Key");
		int colCountryKey = hCountryPortColName.get("Key");
		int colCountry = hCountryPortColName.get("Country");
		int colLoading = hCountryPortColName.get("Loading");
		int colDischarge = hCountryPortColName.get("Discharge");
		int colFinalDest = hCountryPortColName.get("Final Dest");
		int colDel = hCountryPortColName.get("Del");

		String key = "";
		String countryKey = "";
		String country = "";
		String loading = "";
		String discharge = "";
		String finalDest = "";
		String del = "";

		int rowIndex;
		LinkedHashMap<Integer, List<String>> getCountryPort = SessionData.getExcelSheetDataNoHeader(keyFileName,
				localShipmentPortSheet);
		for (Integer rowCountryPort : getCountryPort.keySet()) {
			key = getCountryPort.get(rowCountryPort).get(colKey);
			countryKey = getCountryPort.get(rowCountryPort).get(colCountryKey);
			country = getCountryPort.get(rowCountryPort).get(colCountry);
			loading = getCountryPort.get(rowCountryPort).get(colLoading);
			discharge = getCountryPort.get(rowCountryPort).get(colDischarge);
			finalDest = getCountryPort.get(rowCountryPort).get(colFinalDest);
			del = getCountryPort.get(rowCountryPort).get(colDel);

			onCusLocalInfoTabSteps.clickOnAddCountry();
			rowIndex = onCusLocalInfoTabSteps.countRowCountry();
			// if(!key.isEmpty())
			if (!country.isEmpty()) {
				onCusLocalInfoTabSteps.typeCountry(country, rowIndex);
			}

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

				choosePort(countryKey);

				if (del.toLowerCase().equals("y")) {
					onCusLocalInfoTabSteps.chooseDelCountry(rowIndex);
				}
			}
		}

	}

	public void choosePort(String countryKey) {
		HashMap<String, Integer> hDetailPortColName = SessionData.getExcelColNameBySheetName(keyFileName,
				localDetailPortSheet);
		int colKey = hDetailPortColName.get("Country Key");
		int colPort = hDetailPortColName.get("Port");
		int colLoading = hDetailPortColName.get("Loading");
		int colDischange = hDetailPortColName.get("Dischange");
		int colFinalDest = hDetailPortColName.get("Final Dest");

		String key = "";
		String port = "";
		String loading = "";
		String dischange = "";
		String finalDest = "";

		int rowIndex;
		LinkedHashMap<Integer, List<String>> getDetailPort = SessionData.getExcelSheetDataNoHeader(keyFileName,
				localDetailPortSheet);
		for (Integer rowDetailPort : getDetailPort.keySet()) {
			key = getDetailPort.get(rowDetailPort).get(colKey);
			port = getDetailPort.get(rowDetailPort).get(colPort);
			loading = getDetailPort.get(rowDetailPort).get(colLoading);
			dischange = getDetailPort.get(rowDetailPort).get(colDischange);
			finalDest = getDetailPort.get(rowDetailPort).get(colFinalDest);

			if (countryKey.equals(key)) {
				if (!port.isEmpty()) {
					rowIndex = onCusLocalInfoTabSteps.getRowIndexPort(port);
					if (rowIndex > 0) {
						if (loading.equals("y")) {
							onCusLocalInfoTabSteps.choosePortLoading(rowIndex);
						}
						if (dischange.equals("y")) {
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

	public void moveToCustomerInventory(String cusKey) {
		onCustomerSteps.moveToCustomerInventory();
		HashMap<String, Integer> hLocalCustomerInventoryColName = SessionData.getExcelColNameBySheetName(keyFileName,
				localCustomerInventorySheet);
		int colCustomerKey = hLocalCustomerInventoryColName.get("Customer Key");
		int colInventoryBrand = hLocalCustomerInventoryColName.get("Inventory Brand");
		int colDiscountCode = hLocalCustomerInventoryColName.get("Discount Code");
		int colDiscount = hLocalCustomerInventoryColName.get("Discount");
		int colDel = hLocalCustomerInventoryColName.get("Del");

		String customerKey = "";
		String inventoryBrand = "";
		String discountCode = "";
		String discount = "";
		String del = "";

		int rowIndex;
		LinkedHashMap<Integer, List<String>> getLocalCustomerInventory = SessionData
				.getExcelSheetDataNoHeader(keyFileName, localCustomerInventorySheet);
		for (Integer rowLocalCustomerInventory : getLocalCustomerInventory.keySet()) {
			customerKey = getLocalCustomerInventory.get(rowLocalCustomerInventory).get(colCustomerKey);
			inventoryBrand = getLocalCustomerInventory.get(rowLocalCustomerInventory).get(colInventoryBrand);
			discountCode = getLocalCustomerInventory.get(rowLocalCustomerInventory).get(colDiscountCode);
			discount = getLocalCustomerInventory.get(rowLocalCustomerInventory).get(colDiscount);
			del = getLocalCustomerInventory.get(rowLocalCustomerInventory).get(colDel);

			// if(cusKey.equals(customerKey))
			onCusLocalInfoTabSteps.clickOnAddInventoryBrand();
			rowIndex = onCusLocalInfoTabSteps.countRowInventoryBrand();

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
