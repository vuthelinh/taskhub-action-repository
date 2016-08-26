package com.synergix.operations.project;

import com.synergix.common.steps.LoginSteps;
import com.synergix.mtsetup.financial.currency.steps.ExchangeRateSteps;
import com.synergix.globalsetup.financial.accounting.steps.CurrencySteps;
import com.synergix.globalsetup.financial.accounting.steps.GLANSteps;
import com.synergix.globalsetup.financial.accounting.steps.SalesTaxSteps;
import com.synergix.globalsetup.inventory.classification.steps.InventoryClassSteps;
import com.synergix.globalsetup.party.customer.steps.CusAddressTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusBankDetailTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusCompanyTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusContactTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusCurrencyTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusLocalInfoTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusPaymentTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusSBUTabSteps;
import com.synergix.globalsetup.party.customer.steps.CusSalePersonTabSteps;
import com.synergix.globalsetup.party.customer.steps.CustomerClassSteps;
import com.synergix.globalsetup.party.customer.steps.CustomerSteps;
import com.synergix.globalsetup.project.steps.ProjectCategorySteps;
import com.synergix.globalsetup.project.steps.ProjectClassSteps;
import com.synergix.operations.project.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.LinkedHashMap;
import java.util.List;

public class DataForProjectEstimationDefs {

	@Steps
	LoginSteps loginSteps;

	@Steps
	ProjectEstimationSteps projectEstimationSteps;

	@Steps
	GLANSteps glanSteps;

	@Steps
	CustomerClassSteps customerClassSteps;

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

	@And("^I create Customer Class \"([^\"]*)\"$")
	public void i_create_Customer_Class(String dataKey, List<List<String>> dataTable) {
		String keyDataTable = "customerClassTable";
		SessionData.addDataTable(keyDataTable, dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol(keyDataTable, "KEY", dataKey);
		customerClassSteps.switchToIFrame();
		for (int row : testData.keySet()) {
			String sCustomerClassCode = SessionData.getDataTbVal(keyDataTable, row, "Customer Class Code");
			String sReceivableGlan = SessionData.getDataTbVal(keyDataTable, row, "Receivable GLAN");
			if (!customerClassSteps.searchCustomerClassCode(sCustomerClassCode)){
				if (!sCustomerClassCode.isEmpty()) {
					customerClassSteps.clickOnNewBtn();
					customerClassSteps.typeCustomerClassCode(sCustomerClassCode);
				}
				if (!sReceivableGlan.isEmpty()) {
					customerClassSteps.typeReceivableGLAN(sReceivableGlan);
				}
			}
		}
		customerClassSteps.clickOnUpdateButton();
		customerClassSteps.switchOutDefaultIFrame();
	}

	@Steps
	CurrencySteps currencySteps;

	@When("^I create currencies \"([^\"]*)\"$")
	public void i_create_currencies(String dataKey, List<List<String>> dataTable) {
		String keyDataTable = "currencyTable";
		SessionData.addDataTable(keyDataTable, dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol(keyDataTable, "KEY", dataKey);
		currencySteps.switchToIFrame();
		for (int row : testData.keySet()) {

			String sCurrency = SessionData.getDataTbVal(keyDataTable, row, "Currency");
			String sDescription = SessionData.getDataTbVal(keyDataTable, row, "Description");
			String sMinimumBankRate = SessionData.getDataTbVal(keyDataTable, row, "Minimum Bank Rate");
			String sMaximumBankRate = SessionData.getDataTbVal(keyDataTable, row, "Maximum Bank Rate");
			String sMaximumSpreadPercent = SessionData.getDataTbVal(keyDataTable, row, "Maximum Spread %");
			String sSpreadPercentBase = SessionData.getDataTbVal(keyDataTable, row, "Spread % Base");
			String sCreditLimitExchangeRate = SessionData.getDataTbVal(keyDataTable, row, "Credit Limit Exchange Rate");
			if (!sCurrency.isEmpty()) {
				currencySteps.addNewCurency();
				currencySteps.typeCurrency(sCurrency);
			}
			if (!sDescription.isEmpty()) {
				currencySteps.typeDescription(sDescription);
			}
			currencySteps.clickOnUpdateButton();
			currencySteps.switch_to_tab_local_info();
			if (!sMaximumBankRate.isEmpty()) {
				currencySteps.typeMaximumBankRate(sMaximumBankRate);
			}
			if (!sMinimumBankRate.isEmpty()) {
				currencySteps.typeMinimumBankRate(sMinimumBankRate);
			}
			if (!sMaximumSpreadPercent.isEmpty()) {
				currencySteps.typeMaximumSpread(sMaximumSpreadPercent);
			}
			if (!sSpreadPercentBase.isEmpty()) {
				currencySteps.typeSpreadBase(sSpreadPercentBase);
			}
			if (!sCreditLimitExchangeRate.isEmpty()) {
				currencySteps.typeCreditLimitExchangeRate(sCreditLimitExchangeRate);

			}
		}
		currencySteps.clickOnUpdateButton();
		currencySteps.switchOutDefaultIFrame();
	}

	@Steps
	ExchangeRateSteps exchangeRateSteps;

	@When("^I enter exchange rates \"([^\"]*)\"$")
	public void i_enter_exchange_rates(String dataKey, List<List<String>> dataTable) {
		String keyDataTable = "exchangeRateTable";
		SessionData.addDataTable(keyDataTable, dataTable, false);
		LinkedHashMap<Integer, List<String>> currencyData = new LinkedHashMap<>();
		LinkedHashMap<Integer, List<String>> exchangeRateData = new LinkedHashMap<>();
		currencyData = SessionData.getDataTbRowsByValEqualInCol("currencyTable", "KEY", dataKey);
		exchangeRateData = SessionData.getDataTbRowsByValEqualInCol(keyDataTable, "KEY", dataKey);
		exchangeRateSteps.switchToIFrame();
		for (int row1 : currencyData.keySet()) {
			String sCurrency = SessionData.getDataTbVal("currencyTable", row1, "Currency");
			if (!sCurrency.isEmpty()) {
				exchangeRateSteps.typeCurrency(sCurrency);
			}
			exchangeRateSteps.deleteOldRow();
			int count = 1;
			for (int row : exchangeRateData.keySet()) {
				String sEffectiveDateFrom = SessionData.getDataTbVal(keyDataTable, row, "Effective Date From");
				String sEffectiveDateTo = SessionData.getDataTbVal(keyDataTable, row, "Effective Date To");
				String sUpwardsVarianceAllowed = SessionData.getDataTbVal(keyDataTable, row,
						"% Upwards Variance Allowed");
				String sDownwardsVarianceAllowed = SessionData.getDataTbVal(keyDataTable, row,
						"% Downwards Variance Allowed");
				String sBankSellRate = SessionData.getDataTbVal(keyDataTable, row, "Bank's Sell Rate");
				String sBankBuyRate = SessionData.getDataTbVal(keyDataTable, row, "Bank's Buy Rate");

				if (!sEffectiveDateFrom.isEmpty()) {
					exchangeRateSteps.clickAddBtn();
					exchangeRateSteps.typeEffectiveDateFrom(sEffectiveDateFrom, count);
				}
				if (!sEffectiveDateTo.isEmpty()) {
					exchangeRateSteps.typeEffectiveDateTo(sEffectiveDateTo, count);
				}
				if (!sUpwardsVarianceAllowed.isEmpty()) {
					exchangeRateSteps.typeUpwardsVarianceAllowed(sUpwardsVarianceAllowed, count);
				}
				if (!sDownwardsVarianceAllowed.isEmpty()) {
					exchangeRateSteps.typeDownwardsVarianceAllowed(sDownwardsVarianceAllowed, count);
				}
				if (!sBankSellRate.isEmpty()) {
					exchangeRateSteps.typeBankSellRate(sBankSellRate, count);
				}
				if (!sBankBuyRate.isEmpty()) {
					exchangeRateSteps.typeBankBuyRate(sBankBuyRate, count);
				}
			}
			count++;
		}
		currencySteps.switchOutDefaultIFrame();

	}

	@Steps
	SalesTaxSteps salesTaxSteps;

	@When("^I create sales tax with \"([^\"]*)\"$")
	public void i_create_sales_tax_with(String dataKey, List<List<String>> dataTable) {
		salesTaxSteps.switchToIFrame();
		String keyDataTable = "salesTaxTable";
		SessionData.addDataTable(keyDataTable, dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol(keyDataTable, "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSalesTaxCode = SessionData.getDataTbVal(keyDataTable, row, "Sales Tax Code");
			String sSalesTax = SessionData.getDataTbVal(keyDataTable, row, "Sales Tax %");
			String sInputTaxGlan = SessionData.getDataTbVal(keyDataTable, row, "Input Tax GLAN");
			String sOutputTaxGlan = SessionData.getDataTbVal(keyDataTable, row, "Output Tax GLAN");
			if (!sSalesTaxCode.isEmpty()) {
				salesTaxSteps.addNewSalesTax();
				salesTaxSteps.typeSalesTaxCode(sSalesTaxCode);
			}
			if (!sSalesTax.isEmpty()) {
				salesTaxSteps.typeSalesTax(sSalesTax);
			}
			if (!sInputTaxGlan.isEmpty()) {
				salesTaxSteps.typeInputTaxGLAN(sInputTaxGlan);
			}
			if (!sOutputTaxGlan.isEmpty()) {
				salesTaxSteps.typeOutputTaxGLAN(sOutputTaxGlan);
			}
		}
		salesTaxSteps.clickOnUpdateButton();
		salesTaxSteps.switchOutDefaultIFrame();
	}

	@When("^I creates chart of account as \"([^\"]*)\"$")
	public void i_creates_chart_of_account_as_key(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "glaccount";
		SessionData.addDataTable(dataTableKey, dataTable, false);
		glanSteps.switchToIFrame();
		for (int row : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, "KEY", dataKey).keySet()) {

			String colGLAccountCode = "GL Account Code";
			String colDescription = "Description";
			String colAccountType = "Account Type";
			String colStatus = "Status";
			String colForSubLedgerAccount = "For Sub Ledger Account";

			String gLAccountCode = SessionData.getDataTbVal(dataTableKey, row, colGLAccountCode);
			String description = SessionData.getDataTbVal(dataTableKey, row, colDescription);
			glanSteps.addNewGLAN();
			glanSteps.typeGLAccountCode(gLAccountCode);
			glanSteps.typeDescription(description);
			glanSteps.update();
		}
		glanSteps.switchOutDefaultIFrame();
	}

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

	@When("^I create customer as$")
	public void i_create_customer_as(String dataKey, List<List<String>> dataTable) {
		String colKeyCustomer = "KEY";
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
	}

	@When("^the customer is added address$")
	public void the_customer_is_added_address_as(String dataKey, List<List<String>> dataTable) {
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
		}
	}

	@When("^the customer is added address contact type as \"([^\"]*)\"$")
	public void the_customer_is_added_address_contact_type_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added contact as \"([^\"]*)\"$")
	public void the_customer_is_added_contact_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added contact type as \"([^\"]*)\"$")
	public void the_customer_is_added_contact_type_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added SBU as \"([^\"]*)\"$")
	public void the_customer_is_added_SBU_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added currency as \"([^\"]*)\"$")
	public void the_customer_is_added_currency_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added payment as \"([^\"]*)\"$")
	public void the_customer_is_added_payment_as(String dataKey, List<List<String>> dataTable) {
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
				if (nextCreditReviewDate.isEmpty()) {
					nextCreditReviewDate = onCusPaymentTabSteps.getToday();
				}
				onCusPaymentTabSteps.typeReviewDate(nextCreditReviewDate);
			}
		}
	}

	@When("^the customer is added payment option as \"([^\"]*)\"$")
	public void the_customer_is_added_payment_option_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added payment term as \"([^\"]*)\"$")
	public void the_customer_is_added_payment_term_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is added payment menthod as \"([^\"]*)\"$")
	public void the_customer_is_added_payment_menthod_as(String dataKey, List<List<String>> dataTable) {
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

	@When("^the customer is updated$")
	public void the_customer_is_updated() {
		if (isContinue) {
			onCustomerSteps.clickOnUpdateButton();
		}

		onCustomerSteps.switchOutDefaultIFrame();
	}

	@Steps
	ProjectClassSteps projectClassSteps;

	@When("^I create a project class as \"([^\"]*)\"$")
	public void i_create_a_project_class_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("projectClassTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("projectClassTable", "KEY", dataKey);
		projectClassSteps.switch_to_iframe();
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("projectClassTable", row, "KEY");
			String sProjectClassCode = SessionData.getDataTbVal("projectClassTable", row, "Project Class Code");
			String sProjectClassDescription = SessionData.getDataTbVal("projectClassTable", row,
					"Project Class Description");
			String sUnearnedRevenue = SessionData.getDataTbVal("projectClassTable", row, "Unearned Revenue");
			String sWorkInProgress = SessionData.getDataTbVal("projectClassTable", row, "Work In Progress");
			String sRetention = SessionData.getDataTbVal("projectClassTable", row, "Retention");
			String sProjectRevenue = SessionData.getDataTbVal("projectClassTable", row, "Project Revenue");
			String sProjectCost = SessionData.getDataTbVal("projectClassTable", row, "Project Cost");
			String sRecognitionExchGainLoss = SessionData.getDataTbVal("projectClassTable", row,
					"Recognition Exch Gain/Loss (TH2)");
			String sCostAccrual = SessionData.getDataTbVal("projectClassTable", row, "Cost Accrual");
			String sRevenueAccrual = SessionData.getDataTbVal("projectClassTable", row, "Revenue Accrual");
			String sDownpaymentUnearned = SessionData.getDataTbVal("projectClassTable", row, "Downpayment Unearned");
			String sAttributableProfit = SessionData.getDataTbVal("projectClassTable", row, "Attributable Profit");
			String sClaimDebtor = SessionData.getDataTbVal("projectClassTable", row, "Claim Debtor");
			String sCertificationDebtor = SessionData.getDataTbVal("projectClassTable", row, "Certification Debtor");
			String sOtherPayable = SessionData.getDataTbVal("projectClassTable", row, "Other Payable");
			String sRetentionClearing = SessionData.getDataTbVal("projectClassTable", row, "Retention Clearing");
			String sSubconClaimPayable = SessionData.getDataTbVal("projectClassTable", row, "Subcon Claim Payable");
			String sSubconCertificationPayable = SessionData.getDataTbVal("projectClassTable", row,
					"Subcon Certification Payable");
			String sMaterialOnSite = SessionData.getDataTbVal("projectClassTable", row, "Material on Site");
			String sRetentionMaterialOnSite = SessionData.getDataTbVal("projectClassTable", row,
					"Retention Material on Site");
			String sLiquidatedDamage = SessionData.getDataTbVal("projectClassTable", row, "Liquidated Damage");
			String sSubconAdvancePayment = SessionData.getDataTbVal("projectClassTable", row, "Subcon Advance Payment");
			if (!sKey.isEmpty()) {
				projectClassSteps.click_add_new_button_on_functional_panel();
			}
			if (!sProjectClassCode.isEmpty()) {
				projectClassSteps.enter_project_class_code(sProjectClassCode);
			}
			if (!sProjectClassDescription.isEmpty()) {
				projectClassSteps.enter_project_class_description(sProjectClassDescription);
			}
			if (!sUnearnedRevenue.isEmpty()) {
				projectClassSteps.enter_unearned_revenue(sUnearnedRevenue);
			}
			if (!sWorkInProgress.isEmpty()) {
				projectClassSteps.enter_work_in_progress(sWorkInProgress);
			}
			if (!sRetention.isEmpty()) {
				projectClassSteps.enter_retention(sRetention);
			}
			if (!sProjectRevenue.isEmpty()) {
				projectClassSteps.enter_project_revenue(sProjectRevenue);
			}
			if (!sProjectCost.isEmpty()) {
				projectClassSteps.enter_project_cost(sProjectCost);
			}
			if (!sRecognitionExchGainLoss.isEmpty()) {
				projectClassSteps.enter_recognition_exch_gain_or_loss_th2(sRecognitionExchGainLoss);
			}
			if (!sCostAccrual.isEmpty()) {
				projectClassSteps.enter_cost_accrual(sCostAccrual);
			}
			if (!sRevenueAccrual.isEmpty()) {
				projectClassSteps.enter_revenue_accrual(sRevenueAccrual);
			}
			if (!sDownpaymentUnearned.isEmpty()) {
				projectClassSteps.enter_downpayment_unearned(sDownpaymentUnearned);
			}
			if (!sAttributableProfit.isEmpty()) {
				projectClassSteps.enter_attributable_profit(sAttributableProfit);
			}
			if (!sClaimDebtor.isEmpty()) {
				projectClassSteps.enter_claim_debtor(sClaimDebtor);
			}
			if (!sCertificationDebtor.isEmpty()) {
				projectClassSteps.enter_certification_debtor(sCertificationDebtor);
			}
			if (!sOtherPayable.isEmpty()) {
				projectClassSteps.enter_other_payable(sOtherPayable);
			}
			if (!sRetentionClearing.isEmpty()) {
				projectClassSteps.enter_retention_clearing(sRetentionClearing);
			}
			if (!sSubconClaimPayable.isEmpty()) {
				projectClassSteps.enter_subcon_claim_payable(sSubconClaimPayable);
			}
			if (!sSubconCertificationPayable.isEmpty()) {
				projectClassSteps.enter_subcon_certification_payable(sSubconCertificationPayable);
			}
			if (!sMaterialOnSite.isEmpty()) {
				projectClassSteps.enter_material_on_site(sMaterialOnSite);
			}
			if (!sRetentionMaterialOnSite.isEmpty()) {
				projectClassSteps.enter_retention_material_on_site(sRetentionMaterialOnSite);
			}
			if (!sLiquidatedDamage.isEmpty()) {
				projectClassSteps.enter_liquidated_damage(sLiquidatedDamage);
			}
			if (!sSubconAdvancePayment.isEmpty()) {
				projectClassSteps.enter_subcon_advance_payment(sSubconAdvancePayment);
			}
		}
		projectClassSteps.update();
		projectClassSteps.switch_out_default_iframe();
	}

	@Steps
	ProjectCategorySteps projectCategorySteps;

	@Given("^user creates project category as \"([^\"]*)\"$")
	public void user_creates_project_category_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("projectCategoryTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("projectCategoryTable", "KEY", dataKey);
		projectCategorySteps.switch_to_iframe();
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("projectCategoryTable", row, "KEY");
			String sProjectCategoryCode = SessionData.getDataTbVal("projectCategoryTable", row,
					"Project Category Code");
			String sDescription = SessionData.getDataTbVal("projectCategoryTable", row, "Description");
			String sCompany = SessionData.getDataTbVal("projectCategoryTable", row, "Company");
			String sStatus = SessionData.getDataTbVal("projectCategoryTable", row, "Status");
			if (!sKey.isEmpty()) {
				projectCategorySteps.click_add_new_button_on_functional_panel();
			}
			if (!sProjectCategoryCode.isEmpty()) {
				projectCategorySteps.enter_project_category_code(sProjectCategoryCode);
			}
			if (!sDescription.isEmpty()) {
				projectCategorySteps.enter_description(sDescription);
			}
			if (!sCompany.isEmpty()) {
				projectCategorySteps.choose_company(sCompany);
				projectCategorySteps.click_update();
			}
			if (!sStatus.isEmpty()) {
				projectCategorySteps.switch_to_tab_local_info();
				projectCategorySteps.select_status(sStatus);
			}
		}
		projectCategorySteps.click_update();
		projectCategorySteps.switch_out_default_iframe();
	}

	@Steps
	InventoryClassSteps classSteps;

	private static final String CLASS_TABLE = "CLASS TABLE";

	@When("^I create a new inventory class as \"([^\"]*)\"$")
	public void i_create_a_new_class_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable(CLASS_TABLE, dataTable);
		classSteps.switchToIFrame();
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CLASS_TABLE, "KEY", dataKey).keySet()) {

			String sInventoryClassCode = SessionData.getDataTbVal(CLASS_TABLE, row, "Inventory Class Code");

			String sDescription = SessionData.getDataTbVal(CLASS_TABLE, row, "Description");
			String sCostingMethod = SessionData.getDataTbVal(CLASS_TABLE, row, "Costing Method");
			String sInventoryGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Inventory GLAN");
			String sSalesGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Sales GLAN");
			String sCostsOfSalesGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Costs of Sales GLAN");
			String sSalesReturnGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Sales Return GLAN");
			String sCostsOfSalesReturnGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Costs of Sales Return GLAN");
			String sCostsSalesClearingGlan = SessionData.getDataTbVal(CLASS_TABLE, row,
					"Costs of Sales Ret Clearing GLAN");
			String sReplacementHoldingGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Replacement Holding GLAN");
			String sIssueVarianceGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Issue Variance GLAN");
			String sProductionVarianceGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Production Variance GLAN");
			String sInventoryExpenseGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Inventory Expense GLAN");
			String sPhysicalAdditionGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Physical Addition GLAN");
			String sPhysicalReductionGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Physical Reduction GLAN");
			String sDeliveryClearingGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Delivery Clearing GLAN");
			String sWorkInProgressGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Work in Progress GLAN");
			String sCalibrationGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Calibration GLAN");
			String sScrapExpenseGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Scrap Expense GLAN");
			String sReworkExpenseGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Rework Expense GLAN");
			String sCostOfServicingGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Cost of Servicing GLAN");
			String segment1 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg1");
			String segment2 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg2");
			String segment3 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg3");
			String segment4 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg4");

			classSteps.click_btn_new();

			classSteps.enter_inventory_class_code(sInventoryClassCode);
			classSteps.create_new_inventory_class(sDescription, sCostingMethod, sInventoryGlan, sSalesGlan,
					sCostsOfSalesGlan, sSalesReturnGlan, sCostsOfSalesReturnGlan, sCostsSalesClearingGlan,
					sReplacementHoldingGlan, sIssueVarianceGlan, sProductionVarianceGlan, sInventoryExpenseGlan,
					sPhysicalAdditionGlan, sPhysicalReductionGlan, sDeliveryClearingGlan, sWorkInProgressGlan,
					sCalibrationGlan, sScrapExpenseGlan, sReworkExpenseGlan, sCostOfServicingGlan);

			classSteps.click_btn_update();
		}
		classSteps.switchOutDefaultIFrame();
	}
}