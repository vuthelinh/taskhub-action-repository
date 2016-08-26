package com.synergix.definition.pretest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.party.supplier.steps.SupAddressTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupBankDetailTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupCompanyTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupContactTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupCurrencyTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupLocalInfoTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupPaymentTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupSBUTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupSalePersonTabSteps;
import com.synergix.globalsetup.party.supplier.steps.SupplierSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLSupplierDefs {
	@Steps
	SupplierSteps onSupplierSteps;
	@Steps
	SupAddressTabSteps onSupAddressTabSteps;
	@Steps
	SupContactTabSteps onSupContactTabSteps;
	@Steps
	SupBankDetailTabSteps onSupBankDetailTabSteps;
	@Steps
	SupCompanyTabSteps onSupCompanyTabSteps;
	@Steps
	SupCurrencyTabSteps onSupCurrencyTabSteps;
	@Steps
	SupLocalInfoTabSteps onSupLocalInfoTabSteps;
	@Steps
	SupPaymentTabSteps onSupPaymentTabSteps;
	@Steps
	SupSalePersonTabSteps onSupSalePersonTabSteps;
	@Steps
	SupSBUTabSteps onSupSBUTabSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_PARTY + "Supplier.xls";
	String keyFileName = "Supplier";
	String datasetSheet = "Supplier";
	String companySheet = "Company";

	String currencySheet = "Currency";

	String paymentSheet = "Payment";
	String paymentOptionSheet = "Payment Option";
	String paymentTermSheet = "Payment Term";
	String paymentMethodSheet = "Payment Method";

	String addressSheet = "Address";
	String addressContactTypeSheet = "AddressContactType";
	String addressTypeSheet = "AddressType";

	String contactSheet = "Contact";
	String contactIncTypeSheet = "ContactIncType";
	String contactTypeSheet = "ContactType";

	String bankDetailSheet = "BankDetail";
	String sBUSheet = "SBU";

	String shipmentModeTermSheet = "ShipmentModeTerm";
	String countryPortSheet = "CountryPort";

	String detailPortSheet = "DetailPort";

	String defaultSettingSheet = "DefaultSetting";

	boolean isContinue = false;
	boolean isUpdate = false;

	@When("^user create supplier as \"([^\"]*)\"$")
	public void user_create_supplier_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Supplier";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSUPPIER = "KEY SUPPLIER";
		String colisContra = "isContra";
		String colPrefixAutoGenCode = "Prefix Auto Gen Code";
		String colSupplier = "Supplier";
		String colSupplierName = "Supplier Name";
		String colSupplierClassCode = "Supplier Class Code";
		String colPartyGroupCode = "Party Group Code";
		String colMainHomePage = "Main Home Page";
		String colGSTRegistrationNo = "GST Registration No";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colSubconWIPGlan = "Subcon WIP Glan";
		String colSalesTaxCode = "Sales Tax Code";
		String colDefaultTenorTermCode = "Default Tenor Term Code";
		String colDefaultTenor = "Default Tenor";
		String colIPTRelated = "IPT Related";
		String colStatus = "Status";
		String colUniqueEntityNo = "Unique Entity No";
		String colMainSupplierCode = "Main Supplier Code";
		String colSupplierShortName = "Supplier Short Name";
		String colSupplierCategoryCode = "Supplier Category Code";
		String colSupplierRankCode = "Supplier Rank Code";
		String colPurchasingZone = "Purchasing Zone";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colDefaultDiscountPercent = "Default Discount Percent";
		String colCombineShmtoInvoices = "Combine Shm to Invoices";
		String colRemarks = "Remarks";
		String colCompany = "Company";

		for (int rowSupplier : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
				.keySet()) {
			String isContra = SessionData.getDataTbVal(dataTableKey, rowSupplier, colisContra);
			String prefixAutoGenCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPrefixAutoGenCode);
			String supplier = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplier);
			String supplierName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierName);
			String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierClassCode);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPartyGroupCode);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowSupplier, colMainHomePage);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowSupplier, colGSTRegistrationNo);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowSupplier,
					colCountryOfIncorporation);
			String subconWIPGlan = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSubconWIPGlan);
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSalesTaxCode);
			String defaultTenorTermCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colDefaultTenorTermCode);
			String defaultTenor = SessionData.getDataTbVal(dataTableKey, rowSupplier, colDefaultTenor);
			String iPTRelated = SessionData.getDataTbVal(dataTableKey, rowSupplier, colIPTRelated);
			String status = SessionData.getDataTbVal(dataTableKey, rowSupplier, colStatus);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowSupplier, colUniqueEntityNo);
			String mainSupplierCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colMainSupplierCode);
			String supplierShortName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierShortName);
			String supplierCategoryCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierCategoryCode);
			String supplierRankCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierRankCode);
			String purchasingZone = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPurchasingZone);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPartyContraGLAN);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowSupplier,
					colContraRealizedExchGLAN);
			String defaultDiscountPercent = SessionData.getDataTbVal(dataTableKey, rowSupplier,
					colDefaultDiscountPercent);
			String combineShmtoInvoices = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCombineShmtoInvoices);
			String remarks = SessionData.getDataTbVal(dataTableKey, rowSupplier, colRemarks);
			String company = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCompany);

			onSupplierSteps.addSupplier();

			if (isContra.trim().toLowerCase().equals("y")) {
				if (onSupplierSteps.searchParty(supplier)) {
					isContinue = true;
					if (!supplierName.isEmpty()) {
						onSupplierSteps.typeSupplierName(supplierName);
					}
					if (!supplierClassCode.isEmpty()) {
						onSupplierSteps.typeSupplierClassCode(supplierClassCode);
					}
					if (!partyGroupCode.isEmpty()) {
						onSupplierSteps.typePartyGroupCode(partyGroupCode);
					}
					if (!mainHomePage.isEmpty()) {
						onSupplierSteps.typeMainHomePage(mainHomePage);
					}
					if (!gSTRegistrationNo.isEmpty()) {
						onSupplierSteps.typeGSTRegistrationNo(gSTRegistrationNo);
					}
					if (!countryOfIncorporation.isEmpty()) {
						onSupplierSteps.typeCountryOfIncorporation(countryOfIncorporation);
					}
					if (!subconWIPGlan.isEmpty()) {
						onSupplierSteps.typeSubconWIPGlan(subconWIPGlan);
					}
					if (!salesTaxCode.isEmpty()) {
						onSupplierSteps.typeSalesTaxCode(salesTaxCode);
					}
					if (!defaultTenorTermCode.isEmpty()) {
						onSupplierSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
					}
					if (!defaultTenor.isEmpty()) {
						onSupplierSteps.typeDefaultTenor(defaultTenor);
					}
					if (!iPTRelated.isEmpty()) {
						onSupplierSteps.chooseIPTRelated(iPTRelated);
					}
					if (!status.isEmpty()) {
						onSupplierSteps.chooseStatus(status);
					}
					if (!uniqueEntityNo.isEmpty()) {
						onSupplierSteps.typeUniqueEntityNo(uniqueEntityNo);
					}
					if (!mainSupplierCode.isEmpty()) {
						onSupplierSteps.typeMainSupplierCode(mainSupplierCode);
					}
					if (!supplierShortName.isEmpty()) {
						onSupplierSteps.typeSupplierShortName(supplierShortName);
					}
					if (!supplierCategoryCode.isEmpty()) {
						onSupplierSteps.typeSupplierCategoryCode(supplierCategoryCode);
					}
					if (!supplierRankCode.isEmpty()) {
						onSupplierSteps.typeSupplierRankCode(supplierRankCode);
					}
					if (!purchasingZone.isEmpty()) {
						onSupplierSteps.typePurchasingZone(purchasingZone);
					}
					if (!partyContraGLAN.isEmpty()) {
						onSupplierSteps.typePartyContraGLAN(partyContraGLAN);
					}
					if (!contraRealizedExchGLAN.isEmpty()) {
						onSupplierSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
					}
					if (!defaultDiscountPercent.isEmpty()) {
						onSupplierSteps.typeDefaultDiscountPercent(defaultDiscountPercent);
					}
					if (!combineShmtoInvoices.isEmpty()) {
						onSupplierSteps.chooseCombineShmtoInvoices(combineShmtoInvoices);
					}
					if (!remarks.isEmpty()) {
						onSupplierSteps.typeRemarks(remarks);
					}
					if (!company.isEmpty()) {
						onSupplierSteps.moveToCompanyTab();
						if (company.toLowerCase().equals("all")) {
							onSupCompanyTabSteps.chooseAllCompany();
						} else
							onSupCompanyTabSteps.chooseCompany(company);
					}
				}

			} else {
				if (!prefixAutoGenCode.isEmpty()) {
					supplier = onSupplierSteps.autoGenCode(prefixAutoGenCode);
				}

				if (!supplier.isEmpty()) {
					onSupplierSteps.typeSupplier(supplier);
					String mess = onSupplierSteps.verifyMessagePopup();
					if (mess != null) {
						isContinue = false;
						System.out.println("[*** NANCY ***] Error Message:===" + mess + "===");
					} else {
						isContinue = true;

						if (!supplierName.isEmpty()) {
							onSupplierSteps.typeSupplierName(supplierName);
						}
						if (!supplierClassCode.isEmpty()) {
							onSupplierSteps.typeSupplierClassCode(supplierClassCode);
						}
						if (!partyGroupCode.isEmpty()) {
							onSupplierSteps.typePartyGroupCode(partyGroupCode);
						}
						if (!mainHomePage.isEmpty()) {
							onSupplierSteps.typeMainHomePage(mainHomePage);
						}
						if (!gSTRegistrationNo.isEmpty()) {
							onSupplierSteps.typeGSTRegistrationNo(gSTRegistrationNo);
						}
						if (!countryOfIncorporation.isEmpty()) {
							onSupplierSteps.typeCountryOfIncorporation(countryOfIncorporation);
						}
						if (!subconWIPGlan.isEmpty()) {
							onSupplierSteps.typeSubconWIPGlan(subconWIPGlan);
						}
						if (!salesTaxCode.isEmpty()) {
							onSupplierSteps.typeSalesTaxCode(salesTaxCode);
						}
						if (!defaultTenorTermCode.isEmpty()) {
							onSupplierSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
						}
						if (!defaultTenor.isEmpty()) {
							onSupplierSteps.typeDefaultTenor(defaultTenor);
						}
						if (!iPTRelated.isEmpty()) {
							onSupplierSteps.chooseIPTRelated(iPTRelated);
						}
						if (!status.isEmpty()) {
							onSupplierSteps.chooseStatus(status);
						}
						if (!uniqueEntityNo.isEmpty()) {
							onSupplierSteps.typeUniqueEntityNo(uniqueEntityNo);
						}
						if (!mainSupplierCode.isEmpty()) {
							onSupplierSteps.typeMainSupplierCode(mainSupplierCode);
						}
						if (!supplierShortName.isEmpty()) {
							onSupplierSteps.typeSupplierShortName(supplierShortName);
						}
						if (!supplierCategoryCode.isEmpty()) {
							onSupplierSteps.typeSupplierCategoryCode(supplierCategoryCode);
						}
						if (!supplierRankCode.isEmpty()) {
							onSupplierSteps.typeSupplierRankCode(supplierRankCode);
						}
						if (!purchasingZone.isEmpty()) {
							onSupplierSteps.typePurchasingZone(purchasingZone);
						}
						if (!partyContraGLAN.isEmpty()) {
							onSupplierSteps.typePartyContraGLAN(partyContraGLAN);
						}
						if (!contraRealizedExchGLAN.isEmpty()) {
							onSupplierSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
						}
						if (!defaultDiscountPercent.isEmpty()) {
							onSupplierSteps.typeDefaultDiscountPercent(defaultDiscountPercent);
						}
						if (!combineShmtoInvoices.isEmpty()) {
							onSupplierSteps.chooseCombineShmtoInvoices(combineShmtoInvoices);
						}
						if (!remarks.isEmpty()) {
							onSupplierSteps.typeRemarks(remarks);
						}
						if (!company.isEmpty()) {
							onSupplierSteps.moveToCompanyTab();
							if (company.toLowerCase().equals("all")) {
								onSupCompanyTabSteps.chooseAllCompany();
							} else
								onSupCompanyTabSteps.chooseCompany(company);
						}
					}
				}
			}
		}
	}
	

@Given("^user maintains supplier as \"([^\"]*)\"$")
public void user_maintains_supplier_as(String dataKey, List<List<String>> dataTable) {
	isUpdate = true;
	String dataTableKey = "MaintainSupplier";
	SessionData.addDataTable(dataTableKey, dataTable);

	String colKEYSUPPIER = "KEY SUPPLIER";
	String colisContra = "isContra";
	String colPrefixAutoGenCode = "Prefix Auto Gen Code";
	String colSupplier = "Supplier";
	String colSupplierName = "Supplier Name";
	String colSupplierClassCode = "Supplier Class Code";
	String colPartyGroupCode = "Party Group Code";
	String colMainHomePage = "Main Home Page";
	String colGSTRegistrationNo = "GST Registration No";
	String colCountryOfIncorporation = "Country Of Incorporation";
	String colSubconWIPGlan = "Subcon WIP Glan";
	String colSalesTaxCode = "Sales Tax Code";
	String colDefaultTenorTermCode = "Default Tenor Term Code";
	String colDefaultTenor = "Default Tenor";
	String colIPTRelated = "IPT Related";
	String colStatus = "Status";
	String colUniqueEntityNo = "Unique Entity No";
	String colMainSupplierCode = "Main Supplier Code";
	String colSupplierShortName = "Supplier Short Name";
	String colSupplierCategoryCode = "Supplier Category Code";
	String colSupplierRankCode = "Supplier Rank Code";
	String colPurchasingZone = "Purchasing Zone";
	String colPartyContraGLAN = "Party Contra GLAN";
	String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
	String colDefaultDiscountPercent = "Default Discount Percent";
	String colCombineShmtoInvoices = "Combine Shm to Invoices";
	String colRemarks = "Remarks";
	String colCompany = "Company";

	for (int rowSupplier : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
			.keySet()) {
		String isContra = SessionData.getDataTbVal(dataTableKey, rowSupplier, colisContra);
		String prefixAutoGenCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPrefixAutoGenCode);
		String supplier = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplier);
		String supplierName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierName);
		String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierClassCode);
		String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPartyGroupCode);
		String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowSupplier, colMainHomePage);
		String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowSupplier, colGSTRegistrationNo);
		String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowSupplier,
				colCountryOfIncorporation);
		String subconWIPGlan = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSubconWIPGlan);
		String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSalesTaxCode);
		String defaultTenorTermCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colDefaultTenorTermCode);
		String defaultTenor = SessionData.getDataTbVal(dataTableKey, rowSupplier, colDefaultTenor);
		String iPTRelated = SessionData.getDataTbVal(dataTableKey, rowSupplier, colIPTRelated);
		String status = SessionData.getDataTbVal(dataTableKey, rowSupplier, colStatus);
		String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowSupplier, colUniqueEntityNo);
		String mainSupplierCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colMainSupplierCode);
		String supplierShortName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierShortName);
		String supplierCategoryCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierCategoryCode);
		String supplierRankCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierRankCode);
		String purchasingZone = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPurchasingZone);
		String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPartyContraGLAN);
		String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowSupplier,
				colContraRealizedExchGLAN);
		String defaultDiscountPercent = SessionData.getDataTbVal(dataTableKey, rowSupplier,
				colDefaultDiscountPercent);
		String combineShmtoInvoices = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCombineShmtoInvoices);
		String remarks = SessionData.getDataTbVal(dataTableKey, rowSupplier, colRemarks);
		String company = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCompany);
		boolean supplierExist = true;
		
		if (!onSupplierSteps.searchSupplier(supplier)){
			onSupplierSteps.addSupplier();
			supplierExist = false;
		}		

		if (isContra.trim().toLowerCase().equals("y")) {
			if (onSupplierSteps.searchParty(supplier)) {
				isContinue = true;
				if (!supplierName.isEmpty()) {
					onSupplierSteps.typeSupplierName(supplierName);
				}
				
				if (!supplierClassCode.isEmpty()) {
					onSupplierSteps.typeSupplierClassCode(supplierClassCode);
				}
				if (!partyGroupCode.isEmpty()) {
					onSupplierSteps.typePartyGroupCode(partyGroupCode);
				}
				if (!mainHomePage.isEmpty()) {
					onSupplierSteps.typeMainHomePage(mainHomePage);
				}
				if (!gSTRegistrationNo.isEmpty()) {
					onSupplierSteps.typeGSTRegistrationNo(gSTRegistrationNo);
				}
				if (!countryOfIncorporation.isEmpty()) {
					onSupplierSteps.typeCountryOfIncorporation(countryOfIncorporation);
				}
				if (!subconWIPGlan.isEmpty()) {
					onSupplierSteps.typeSubconWIPGlan(subconWIPGlan);
				}
				if (!salesTaxCode.isEmpty()) {
					onSupplierSteps.typeSalesTaxCode(salesTaxCode);
				}
				if (!defaultTenorTermCode.isEmpty()) {
					onSupplierSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
				}
				if (!defaultTenor.isEmpty()) {
					onSupplierSteps.typeDefaultTenor(defaultTenor);
				}
				if (!iPTRelated.isEmpty()) {
					onSupplierSteps.chooseIPTRelated(iPTRelated);
				}
				if (!status.isEmpty()) {
					onSupplierSteps.chooseStatus(status);
				}
				if (!uniqueEntityNo.isEmpty()) {
					onSupplierSteps.typeUniqueEntityNo(uniqueEntityNo);
				}
				if (!mainSupplierCode.isEmpty()) {
					onSupplierSteps.typeMainSupplierCode(mainSupplierCode);
				}
				if (!supplierShortName.isEmpty()) {
					onSupplierSteps.typeSupplierShortName(supplierShortName);
				}
				if (!supplierCategoryCode.isEmpty()) {
					onSupplierSteps.typeSupplierCategoryCode(supplierCategoryCode);
				}
				if (!supplierRankCode.isEmpty()) {
					onSupplierSteps.typeSupplierRankCode(supplierRankCode);
				}
				if (!purchasingZone.isEmpty()) {
					onSupplierSteps.typePurchasingZone(purchasingZone);
				}
				if (!partyContraGLAN.isEmpty()) {
					onSupplierSteps.typePartyContraGLAN(partyContraGLAN);
				}
				if (!contraRealizedExchGLAN.isEmpty()) {
					onSupplierSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
				}
				if (!defaultDiscountPercent.isEmpty()) {
					onSupplierSteps.typeDefaultDiscountPercent(defaultDiscountPercent);
				}
				if (!combineShmtoInvoices.isEmpty()) {
					onSupplierSteps.chooseCombineShmtoInvoices(combineShmtoInvoices);
				}
				if (!remarks.isEmpty()) {
					onSupplierSteps.typeRemarks(remarks);
				}
				if (!company.isEmpty()) {
					onSupplierSteps.moveToCompanyTab();
					if (company.toLowerCase().equals("all")) {
						onSupCompanyTabSteps.chooseAllCompany();
					} else
						onSupCompanyTabSteps.chooseCompany(company);
				}
			}

		} else {
			if (!prefixAutoGenCode.isEmpty()) {
				supplier = onSupplierSteps.autoGenCode(prefixAutoGenCode);
			}

			if (!supplier.isEmpty()) {
				if (!supplierExist){
					onSupplierSteps.typeSupplier(supplier);
				}
				
				String mess = onSupplierSteps.verifyMessagePopup();
				if (mess != null) {
					isContinue = false;
					System.out.println("[*** NANCY ***] Error Message:===" + mess + "===");
				} else {
					isContinue = true;

					if (!supplierName.isEmpty()) {
						onSupplierSteps.typeSupplierName(supplierName);
					}
					if (!supplierExist){
						if (!supplierClassCode.isEmpty()) {
							onSupplierSteps.typeSupplierClassCode(supplierClassCode);
						}
					}
					
					if (!partyGroupCode.isEmpty()) {
						onSupplierSteps.typePartyGroupCode(partyGroupCode);
					}
					if (!mainHomePage.isEmpty()) {
						onSupplierSteps.typeMainHomePage(mainHomePage);
					}
					if (!gSTRegistrationNo.isEmpty()) {
						onSupplierSteps.typeGSTRegistrationNo(gSTRegistrationNo);
					}
					if (!countryOfIncorporation.isEmpty()) {
						onSupplierSteps.typeCountryOfIncorporation(countryOfIncorporation);
					}
					if (!subconWIPGlan.isEmpty()) {
						onSupplierSteps.typeSubconWIPGlan(subconWIPGlan);
					}
					if (!salesTaxCode.isEmpty()) {
						onSupplierSteps.typeSalesTaxCode(salesTaxCode);
					}
					if (!defaultTenorTermCode.isEmpty()) {
						onSupplierSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
					}
					if (!defaultTenor.isEmpty()) {
						onSupplierSteps.typeDefaultTenor(defaultTenor);
					}
					if (!iPTRelated.isEmpty()) {
						onSupplierSteps.chooseIPTRelated(iPTRelated);
					}
					if (!status.isEmpty()) {
						onSupplierSteps.chooseStatus(status);
					}
					if (!uniqueEntityNo.isEmpty()) {
						onSupplierSteps.typeUniqueEntityNo(uniqueEntityNo);
					}
					if (!mainSupplierCode.isEmpty()) {
						onSupplierSteps.typeMainSupplierCode(mainSupplierCode);
					}
					if (!supplierShortName.isEmpty()) {
						onSupplierSteps.typeSupplierShortName(supplierShortName);
					}
					if (!supplierCategoryCode.isEmpty()) {
						onSupplierSteps.typeSupplierCategoryCode(supplierCategoryCode);
					}
					if (!supplierRankCode.isEmpty()) {
						onSupplierSteps.typeSupplierRankCode(supplierRankCode);
					}
					if (!purchasingZone.isEmpty()) {
						onSupplierSteps.typePurchasingZone(purchasingZone);
					}
					if (!partyContraGLAN.isEmpty()) {
						onSupplierSteps.typePartyContraGLAN(partyContraGLAN);
					}
					if (!contraRealizedExchGLAN.isEmpty()) {
						onSupplierSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
					}
					if (!defaultDiscountPercent.isEmpty()) {
						onSupplierSteps.typeDefaultDiscountPercent(defaultDiscountPercent);
					}
					if (!combineShmtoInvoices.isEmpty()) {
						onSupplierSteps.chooseCombineShmtoInvoices(combineShmtoInvoices);
					}
					if (!remarks.isEmpty()) {
						onSupplierSteps.typeRemarks(remarks);
					}
					if (!company.isEmpty()) {
						onSupplierSteps.moveToCompanyTab();
						if (company.toLowerCase().equals("all")) {
							onSupCompanyTabSteps.chooseAllCompany();
						} else
							onSupCompanyTabSteps.chooseCompany(company);
					}
				}
			}
		}
	}
}

	@When("^user update supplier as \"([^\"]*)\"$")
	public void user_update_supplier_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Supplier";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSUPPIER = "KEY SUPPLIER";
		String colisContra = "isContra";
		String colPrefixAutoGenCode = "Prefix Auto Gen Code";
		String colSupplier = "Supplier";
		String colSupplierName = "Supplier Name";
		String colSupplierClassCode = "Supplier Class Code";
		String colPartyGroupCode = "Party Group Code";
		String colMainHomePage = "Main Home Page";
		String colGSTRegistrationNo = "GST Registration No";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colSubconWIPGlan = "Subcon WIP Glan";
		String colSalesTaxCode = "Sales Tax Code";
		String colDefaultTenorTermCode = "Default Tenor Term Code";
		String colDefaultTenor = "Default Tenor";
		String colIPTRelated = "IPT Related";
		String colStatus = "Status";
		String colUniqueEntityNo = "Unique Entity No";
		String colMainSupplierCode = "Main Supplier Code";
		String colSupplierShortName = "Supplier Short Name";
		String colSupplierCategoryCode = "Supplier Category Code";
		String colSupplierRankCode = "Supplier Rank Code";
		String colPurchasingZone = "Purchasing Zone";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colDefaultDiscountPercent = "Default Discount Percent";
		String colCombineShmtoInvoices = "Combine Shm to Invoices";
		String colRemarks = "Remarks";
		String colCompany = "Company";

		for (int rowSupplier : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
				.keySet()) {
			String isContra = SessionData.getDataTbVal(dataTableKey, rowSupplier, colisContra);
			String prefixAutoGenCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPrefixAutoGenCode);
			String supplier = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplier);
			String supplierName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierName);
			String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierClassCode);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPartyGroupCode);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowSupplier, colMainHomePage);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowSupplier, colGSTRegistrationNo);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowSupplier,
					colCountryOfIncorporation);
			String subconWIPGlan = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSubconWIPGlan);
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSalesTaxCode);
			String defaultTenorTermCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colDefaultTenorTermCode);
			String defaultTenor = SessionData.getDataTbVal(dataTableKey, rowSupplier, colDefaultTenor);
			String iPTRelated = SessionData.getDataTbVal(dataTableKey, rowSupplier, colIPTRelated);
			String status = SessionData.getDataTbVal(dataTableKey, rowSupplier, colStatus);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowSupplier, colUniqueEntityNo);
			String mainSupplierCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colMainSupplierCode);
			String supplierShortName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierShortName);
			String supplierCategoryCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierCategoryCode);
			String supplierRankCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierRankCode);
			String purchasingZone = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPurchasingZone);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowSupplier, colPartyContraGLAN);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowSupplier,
					colContraRealizedExchGLAN);
			String defaultDiscountPercent = SessionData.getDataTbVal(dataTableKey, rowSupplier,
					colDefaultDiscountPercent);
			String combineShmtoInvoices = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCombineShmtoInvoices);
			String remarks = SessionData.getDataTbVal(dataTableKey, rowSupplier, colRemarks);
			String company = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCompany);
			isContinue = true;
			if (!onSupplierSteps.searchSupplier(supplier)) {
				isContinue = true;
				isUpdate = true;
				if (!supplierName.isEmpty()) {
					onSupplierSteps.typeSupplierName(supplierName);
				}
				if (!supplierClassCode.isEmpty()) {
					onSupplierSteps.typeSupplierClassCode(supplierClassCode);
				}
				if (!partyGroupCode.isEmpty()) {
					onSupplierSteps.typePartyGroupCode(partyGroupCode);
				}
				if (!mainHomePage.isEmpty()) {
					onSupplierSteps.typeMainHomePage(mainHomePage);
				}
				if (!gSTRegistrationNo.isEmpty()) {
					onSupplierSteps.typeGSTRegistrationNo(gSTRegistrationNo);
				}
				if (!countryOfIncorporation.isEmpty()) {
					onSupplierSteps.typeCountryOfIncorporation(countryOfIncorporation);
				}
				if (!subconWIPGlan.isEmpty()) {
					onSupplierSteps.typeSubconWIPGlan(subconWIPGlan);
				}
				if (!salesTaxCode.isEmpty()) {
					onSupplierSteps.typeSalesTaxCode(salesTaxCode);
				}
				if (!defaultTenorTermCode.isEmpty()) {
					onSupplierSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
				}
				if (!defaultTenor.isEmpty()) {
					onSupplierSteps.typeDefaultTenor(defaultTenor);
				}
				if (!iPTRelated.isEmpty()) {
					onSupplierSteps.chooseIPTRelated(iPTRelated);
				}
				if (!status.isEmpty()) {
					onSupplierSteps.chooseStatus(status);
				}
				if (!uniqueEntityNo.isEmpty()) {
					onSupplierSteps.typeUniqueEntityNo(uniqueEntityNo);
				}
				if (!mainSupplierCode.isEmpty()) {
					onSupplierSteps.typeMainSupplierCode(mainSupplierCode);
				}
				if (!supplierShortName.isEmpty()) {
					onSupplierSteps.typeSupplierShortName(supplierShortName);
				}
				if (!supplierCategoryCode.isEmpty()) {
					onSupplierSteps.typeSupplierCategoryCode(supplierCategoryCode);
				}
				if (!supplierRankCode.isEmpty()) {
					onSupplierSteps.typeSupplierRankCode(supplierRankCode);
				}
				if (!purchasingZone.isEmpty()) {
					onSupplierSteps.typePurchasingZone(purchasingZone);
				}
				if (!partyContraGLAN.isEmpty()) {
					onSupplierSteps.typePartyContraGLAN(partyContraGLAN);
				}
				if (!contraRealizedExchGLAN.isEmpty()) {
					onSupplierSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
				}
				if (!defaultDiscountPercent.isEmpty()) {
					onSupplierSteps.typeDefaultDiscountPercent(defaultDiscountPercent);
				}
				if (!combineShmtoInvoices.isEmpty()) {
					onSupplierSteps.chooseCombineShmtoInvoices(combineShmtoInvoices);
				}
				if (!remarks.isEmpty()) {
					onSupplierSteps.typeRemarks(remarks);
				}
				if (!company.isEmpty()) {
					onSupplierSteps.moveToCompanyTab();
					if (company.toLowerCase().trim().equals("all")) {
						onSupCompanyTabSteps.chooseAllCompany();
					} else
						onSupCompanyTabSteps.chooseCompany(company);
				}
			}
		}
	}

	@When("^supplier is added address as \"([^\"]*)\"$")
	public void supplier_is_added_address_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYSUPPIER = "KEY SUPPLIER";
			String colAddressCode = "Address Code";
			String colDescription = "Description";
			String colAddress = "Address";
			String colCountryCode = "Country Code";
			String colStateProvince = "State Province";
			String colCityTown = "City Town";
			String colPostalCode = "Postal Code";
			String colIncType = "Inc Type";
			String colDefault = "Default";
			String colLRA = "LRA";
			String colDel = "Del";

			String dataTableKey = "SupAddress";
			SessionData.addDataTable(dataTableKey, dataTable);

			onSupplierSteps.moveToAddressTab();

			for (int rowSupAddress : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
					.keySet()) {
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colAddressCode);
				String description = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDescription);
				String address = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colAddress);
				String countryCode = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colCountryCode);
				String stateProvince = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colStateProvince);
				String cityTown = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colCityTown);
				String postalCode = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colPostalCode);
				String listIncType = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colIncType);
				String listDefaultIncType = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDefault);
				String lRA = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colLRA);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDel);

				if (!addressCode.isEmpty()) {
					if (isUpdate) {
						if (onSupAddressTabSteps.isAddressCodeExit(addressCode)) {
							onSupAddressTabSteps.chooseDelAddress(addressCode);
						}
					}
					onSupAddressTabSteps.clickOnAddAddressBtn();
					onSupAddressTabSteps.typeAddressCode(addressCode);

					if (!description.isEmpty()) {
						onSupAddressTabSteps.typeAddressDescription(description);
					}
					if (!address.isEmpty()) {
						onSupAddressTabSteps.typeAddress(address);
					}
					if (!countryCode.isEmpty()) {
						onSupAddressTabSteps.typeCountryCode(countryCode);
					}
					if (!stateProvince.isEmpty()) {
						onSupAddressTabSteps.typeStateProvince(stateProvince);
					}
					if (!cityTown.isEmpty()) {
						onSupAddressTabSteps.typeCityTown(cityTown);
					}
					if (!postalCode.isEmpty()) {
						onSupAddressTabSteps.typePostalCode(postalCode);
					}

					if (!listIncType.isEmpty()) {
						if (listIncType.contains(",")) {
							String[] sIncType = listIncType.split(",");
							for (String incType : sIncType) {
								if (!incType.trim().isEmpty()) {
									onSupAddressTabSteps.waitABit(120);
									onSupAddressTabSteps.chooseIncType(incType.trim());
								}
							}
						} else {
							onSupAddressTabSteps.waitABit(120);
							onSupAddressTabSteps.chooseIncType(listIncType);
						}
					}
					if (!listDefaultIncType.isEmpty()) {
						onSupAddressTabSteps.waitABit(120);
						if (listDefaultIncType.contains(",")) {
							String[] sDefault = listDefaultIncType.split(",");
							for (String defaultAdd : sDefault) {
								if (!defaultAdd.trim().isEmpty()) {
									onSupAddressTabSteps.chooseTypeDefault(defaultAdd.trim());
								}
							}
						} else
							onSupAddressTabSteps.chooseTypeDefault(listDefaultIncType);
					}

					if (lRA.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseLRA(addressCode);
					}
					if (del.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseDelAddress(addressCode);
					}
				}
			}
		}
	}

	@When("^supplier is added address contact type as \"([^\"]*)\"$")
	public void supplier_is_added_address_contact_type_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupAddressContact";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPIER = "KEY SUPPLIER";
			String colAddressCode = "Address Code";
			String colContactType = "Contact Type";
			String colContactInformation = "Contact Information";
			String colDefault = "Default";
			String colDel = "Del";

			onSupplierSteps.moveToAddressTab();
			for (int rowSupAddress : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
					.keySet()) {
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colAddressCode);
				String contactType = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colContactType);
				String contactInformation = SessionData.getDataTbVal(dataTableKey, rowSupAddress,
						colContactInformation);
				String defaultAddress = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDefault);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDel);

				if (onSupAddressTabSteps.chooseAddressCode(addressCode)) {
					onSupAddressTabSteps.clickOnAddContactTypeBtn();
					int rowIndex = onSupAddressTabSteps.countRowContactTypeTb();

					if (!contactType.isEmpty()) {
						onSupAddressTabSteps.chooseContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onSupAddressTabSteps.typeContactInformation(contactInformation, rowIndex);
					}
					if (defaultAddress.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseContactTypeDefault(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseDel(rowIndex);
					}
				}
			}
		}
	}

	@When("^supplier maintains added address contact type as \"([^\"]*)\"$")
	public void supplier_maintains_added_address_contact_type_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupAddressContact";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPIER = "KEY SUPPLIER";
			String colAddressCode = "Address Code";
			String colContactType = "Contact Type";
			String colContactInformation = "Contact Information";
			String colDefault = "Default";
			String colDel = "Del";

			onSupplierSteps.moveToAddressTab();
			for (int rowSupAddress : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
					.keySet()) {
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colAddressCode);
				String contactType = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colContactType);
				String contactInformation = SessionData.getDataTbVal(dataTableKey, rowSupAddress,
						colContactInformation);
				String defaultAddress = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDefault);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupAddress, colDel);

				if (onSupAddressTabSteps.chooseAddressCode(addressCode)) {
					
					if(!onSupAddressTabSteps.is_added_contact(contactType, contactInformation)){
						onSupAddressTabSteps.clickOnAddContactTypeBtn();
						int rowIndex = onSupAddressTabSteps.countRowContactTypeTb();
						if (!contactType.isEmpty()) {
							onSupAddressTabSteps.chooseContactType(contactType, rowIndex);
						}
						if (!contactInformation.isEmpty()) {
							onSupAddressTabSteps.typeContactInformation(contactInformation, rowIndex);
						}						
						if (defaultAddress.toLowerCase().equals("y")) {
							onSupAddressTabSteps.chooseContactTypeDefault(rowIndex);
						}
						if (del.toLowerCase().equals("y")) {
							onSupAddressTabSteps.chooseDel(rowIndex);
						}
					}					
					
				}
			}
		}
	}
	
	@When("^supplier is added contact as \"([^\"]*)\"$")
	public void supplier_is_added_contact_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupContact";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPIER = "KEY SUPPLIER";
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
			String colDefault = "Default";
			String colDel = "Del";

			onSupplierSteps.moveToContactTab();

			for (int rowSupContact : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
					.keySet()) {
				String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowSupContact, colPartyContactCode);
				String salutation = SessionData.getDataTbVal(dataTableKey, rowSupContact, colSalutation);
				String firstName = SessionData.getDataTbVal(dataTableKey, rowSupContact, colFirstName);
				String middleName = SessionData.getDataTbVal(dataTableKey, rowSupContact, colMiddleName);
				String lastName = SessionData.getDataTbVal(dataTableKey, rowSupContact, colLastName);
				String name = SessionData.getDataTbVal(dataTableKey, rowSupContact, colName);
				String addressCode = SessionData.getDataTbVal(dataTableKey, rowSupContact, colAddressCode);
				String designation = SessionData.getDataTbVal(dataTableKey, rowSupContact, colDesignation);
				String designationGroup = SessionData.getDataTbVal(dataTableKey, rowSupContact, colDesignationGroup);
				String department = SessionData.getDataTbVal(dataTableKey, rowSupContact, colDepartment);
				String listIncType = SessionData.getDataTbVal(dataTableKey, rowSupContact, colIncType);
				String listDefaultContact = SessionData.getDataTbVal(dataTableKey, rowSupContact, colDefault);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupContact, colDel);

				if (!partyContactCode.isEmpty()) {
					if (isUpdate) {
						if (!onSupContactTabSteps.isContactExit(partyContactCode)) {
							onSupContactTabSteps.clickOnAddContact();
							onSupContactTabSteps.typePartyContactCode(partyContactCode);
						}
						else{
							onSupContactTabSteps.chooseContact(partyContactCode);
						}
					}					

					if (!salutation.isEmpty()) {
						onSupContactTabSteps.chooseSalutation(salutation);
					}
					if (!firstName.isEmpty()) {
						onSupContactTabSteps.typeFirstName(firstName);
					}
					if (!middleName.isEmpty()) {
						onSupContactTabSteps.typeMiddleName(middleName);
					}
					if (!lastName.isEmpty()) {
						onSupContactTabSteps.typeLastName(lastName);
					}
					if (!name.isEmpty()) {
						onSupContactTabSteps.typeName(name);
					}
					if (!addressCode.isEmpty()) {
						onSupContactTabSteps.chooseAddressCode(addressCode);
					}
					if (!designation.isEmpty()) {
						onSupContactTabSteps.typeDesignation(designation);
					}
					if (!designationGroup.isEmpty()) {
						onSupContactTabSteps.typeDesignationGroup(designationGroup);
					}
					if (!department.isEmpty()) {
						onSupContactTabSteps.typeDepartment(department);
					}

					if (!listIncType.isEmpty()) {
						if (listIncType.contains(",")) {
							String[] sIncType = listIncType.split(",");
							for (String incType : sIncType) {
								if (!incType.trim().isEmpty()) {
									onSupContactTabSteps.chooseIncType(incType.trim());
								}
							}
						} else
							onSupContactTabSteps.chooseIncType(listIncType);
					}
					if (!listDefaultContact.isEmpty()) {
						if (listDefaultContact.contains(",")) {
							String[] sDefault = listDefaultContact.split(",");
							for (String defaultAdd : sDefault) {
								if (!defaultAdd.trim().isEmpty()) {
									onSupContactTabSteps.chooseIncDefault(defaultAdd.trim());
								}
							}
						} else {
							onSupContactTabSteps.waitABit(120);
							onSupContactTabSteps.chooseIncDefault(listDefaultContact);
						}

					}

					if (del.toLowerCase().equals("y")) {
						onSupContactTabSteps.chooseDelContact(partyContactCode);
					}
				}
			}
		}
	}

	@When("^supplier is added contact type as \"([^\"]*)\"$")
	public void supplier_is_added_contact_type_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupContactType";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPIER = "KEY SUPPLIER";
			String colPartyContactCode = "Party Contact Code";
			String colContactType = "Contact Type";
			String colContactInformation = "Contact Information";
			String colDefault = "Default";
			String colDel = "Del";

			onSupplierSteps.moveToContactTab();

			for (int rowSupContactType : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
					.keySet()) {
				String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowSupContactType,
						colPartyContactCode);
				String contactType = SessionData.getDataTbVal(dataTableKey, rowSupContactType, colContactType);
				String contactInformation = SessionData.getDataTbVal(dataTableKey, rowSupContactType,
						colContactInformation);
				String defaultContactType = SessionData.getDataTbVal(dataTableKey, rowSupContactType, colDefault);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupContactType, colDel);

				if (onSupContactTabSteps.chooseContact(partyContactCode)) {
					onSupContactTabSteps.clickOnAddContactTypeBtn();
					int rowIndex = onSupContactTabSteps.countRowContactContactTypeTb();

					if (!contactType.isEmpty()) {
						onSupContactTabSteps.chooseContactTypeContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onSupContactTabSteps.typeContactTypeContactInformation(contactInformation, rowIndex);
					}
					if (defaultContactType.toLowerCase().equals("y")) {
						onSupContactTabSteps.chooseContactTypeTypeDefault(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onSupContactTabSteps.chooseDelContactType(rowIndex);
					}

				}
			}
		}
	}
	
	@When("^supplier maintains added contact type as \"([^\"]*)\"$")
	public void supplier_maintains_added_contact_type_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupContactType";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPIER = "KEY SUPPLIER";
			String colPartyContactCode = "Party Contact Code";
			String colContactType = "Contact Type";
			String colContactInformation = "Contact Information";
			String colDefault = "Default";
			String colDel = "Del";

			onSupplierSteps.moveToContactTab();

			for (int rowSupContactType : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPIER, dataKey)
					.keySet()) {
				String partyContactCode = SessionData.getDataTbVal(dataTableKey, rowSupContactType,
						colPartyContactCode);
				String contactType = SessionData.getDataTbVal(dataTableKey, rowSupContactType, colContactType);
				String contactInformation = SessionData.getDataTbVal(dataTableKey, rowSupContactType,
						colContactInformation);
				String defaultContactType = SessionData.getDataTbVal(dataTableKey, rowSupContactType, colDefault);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupContactType, colDel);

				if (onSupContactTabSteps.chooseContact(partyContactCode)) {
					if (!onSupContactTabSteps.is_added_contact(contactType, contactInformation)){
						onSupContactTabSteps.clickOnAddContactTypeBtn();
						int rowIndex = onSupContactTabSteps.countRowContactContactTypeTb();

						if (!contactType.isEmpty()) {
							onSupContactTabSteps.chooseContactTypeContactType(contactType, rowIndex);
						}
						if (!contactInformation.isEmpty()) {
							onSupContactTabSteps.typeContactTypeContactInformation(contactInformation, rowIndex);
						}
						if (defaultContactType.toLowerCase().equals("y")) {
							onSupContactTabSteps.chooseContactTypeTypeDefault(rowIndex);
						}
						if (del.toLowerCase().equals("y")) {
							onSupContactTabSteps.chooseDelContactType(rowIndex);
						}
					}
				}
			}
		}
	}


	@When("^supplier is added bank detail as \"([^\"]*)\"$")
	public void supplier_is_added_bank_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupBank";
			SessionData.addDataTable(dataTableKey, dataTable);
			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colBank = "Bank";
			String colDescription = "Description";
			String colAccountNo = "Account No";
			String colCurrency = "Currency";
			String colDefault = "Default";
			String colDel = "Del";

			onSupplierSteps.moveToBankDetailTab();

			for (int rowSupBank : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey)
					.keySet()) {
				String bank = SessionData.getDataTbVal(dataTableKey, rowSupBank, colBank);
				String description = SessionData.getDataTbVal(dataTableKey, rowSupBank, colDescription);
				String accountNo = SessionData.getDataTbVal(dataTableKey, rowSupBank, colAccountNo);
				String currency = SessionData.getDataTbVal(dataTableKey, rowSupBank, colCurrency);
				String defaultBank = SessionData.getDataTbVal(dataTableKey, rowSupBank, colDefault);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupBank, colDel);

				if (!bank.isEmpty()) {
					if (isUpdate) {
						if (onSupBankDetailTabSteps.isBankExit(bank))
							onSupBankDetailTabSteps.chooseBankDel(onSupBankDetailTabSteps.getRowIndex(bank));
					}
					onSupBankDetailTabSteps.clickOnAddBankDetail();
					int rowIndex = onSupBankDetailTabSteps.countRowBankDetail();

					onSupBankDetailTabSteps.typeBank(bank, rowIndex);

					if (!description.isEmpty()) {
						onSupBankDetailTabSteps.typeDescription(description, rowIndex);
					}
					if (!accountNo.isEmpty()) {
						onSupBankDetailTabSteps.typeAccountNo(accountNo, rowIndex);
					}
					if (!currency.isEmpty()) {
						onSupBankDetailTabSteps.typeBankCurrency(currency, rowIndex);
					}
					if (defaultBank.toLowerCase().equals("y")) {
						onSupBankDetailTabSteps.chooseBankDefault(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onSupBankDetailTabSteps.chooseBankDel(rowIndex);
					}
				}
			}
		}
	}

	@When("^supplier is added SBU as \"([^\"]*)\"$")
	public void supplier_is_added_SBU_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupSBU";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colSBU = "SBU";
			String colDescription = "Description";
			String colDel = "Del";

			onSupplierSteps.moveToSBUTab();

			for (int rowSupSBU : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey)
					.keySet()) {
				String sBU = SessionData.getDataTbVal(dataTableKey, rowSupSBU, colSBU);
				String description = SessionData.getDataTbVal(dataTableKey, rowSupSBU, colDescription);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupSBU, colDel);

				if (!sBU.isEmpty()) {
					if (isUpdate) {
						if (onSupSBUTabSteps.isSBUExit(sBU)) {
							onSupSBUTabSteps.chooseDelSBU(sBU);
						}
					}
					onSupSBUTabSteps.clickAddSBU();
					int rowIndex = onSupSBUTabSteps.countRowSBU();

					onSupSBUTabSteps.typeSBU(sBU, rowIndex);

					if (!description.isEmpty()) {
						onSupSBUTabSteps.typeDescription(description, rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onSupSBUTabSteps.chooseDelSBU(rowIndex);
					}
				}
			}
		}
	}

	@When("^supplier is added currency as \"([^\"]*)\"$")
	public void supplier_is_added_currency_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupCur";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colCurrency = "Currency";
			String colDel = "Del";

			onSupplierSteps.moveToCurrencyTab();

			for (int rowSupCur : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey)
					.keySet()) {
				String currency = SessionData.getDataTbVal(dataTableKey, rowSupCur, colCurrency);
				String del = SessionData.getDataTbVal(dataTableKey, rowSupCur, colDel);

				if (!currency.isEmpty()) {
					if (isUpdate) {
						if (onSupCurrencyTabSteps.isCurrencyExit(currency)) {
							onSupCurrencyTabSteps.chooseDel(currency);
						}
					}
					onSupCurrencyTabSteps.clickAddCurrency();
					onSupCurrencyTabSteps.typeCurrency(currency);

					if (del.toLowerCase().equals("y")) {
						onSupCurrencyTabSteps.chooseDel(currency);
					}
				}
			}
		}
	}

	@When("^supplier is added payment as \"([^\"]*)\"$")
	public void supplier_is_added_payment_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colOperationalCurrency = "Operational Currency";
			String colOverallCreditLimit = "Overall Credit Limit";

			String dataTableKey = "Sup_Payment";
			SessionData.addDataTable(dataTableKey, dataTable);

			onSupplierSteps.moveToPaymentTab();

			for (int rowCustomer_Payment : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String operationalCurrency = SessionData.getDataTbVal(dataTableKey, rowCustomer_Payment,
						colOperationalCurrency);
				String overallCreditLimit = SessionData.getDataTbVal(dataTableKey, rowCustomer_Payment,
						colOverallCreditLimit);

				if (!operationalCurrency.isEmpty()) {
					onSupPaymentTabSteps.selectOperationalCurrency(operationalCurrency);
				}
				if (!overallCreditLimit.isEmpty()) {
					onSupPaymentTabSteps.typeOverallCreditLimit(overallCreditLimit);
				}
			}
		}
	}

	@When("^supplier is added payment option as \"([^\"]*)\"$")
	public void supplier_is_added_payment_option_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String tableName = "Payment Option";
			String colKEYSUPPLIER = "KEY SUPPLIER";

			String colDescription = "Description";
			String colIsActive = "Is Active";
			String colDefaultOption = "Default";

			String dataTableKey = "Sup_PaymentOption";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_PaymentTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDescription);
				String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colIsActive);
				String defaultOption = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm,
						colDefaultOption);

				if (defaultOption.trim().toLowerCase().equals("y")) {
					onSupPaymentTabSteps.clickDescription(tableName, description);
					onSupPaymentTabSteps.selectDefault(tableName, description);
				} else if (isActive.trim().toLowerCase().equals("y")) {
					onSupPaymentTabSteps.clickDescription(tableName, description);
					onSupPaymentTabSteps.chooseIsActive(tableName, description);
				}
			}
		}
	}

	@When("^supplier is added payment term as \"([^\"]*)\"$")
	public void supplier_is_added_payment_term_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String tableNameOption = "Payment Option";
			String tableName = "Payment Term";

			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colDescription = "Description";
			String colIsActive = "Is Active";
			String colDefaultTerm = "Default";
			String colOPTION = "OPTION";

			String dataTableKey = "Customer_PaymentTerm";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_PaymentTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDescription);
				String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colIsActive);
				String defaultTerm = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colDefaultTerm);
				String oPTION = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentTerm, colOPTION);

				if (!oPTION.isEmpty()) {
					onSupPaymentTabSteps.clickDescription(tableNameOption, oPTION);
					if (defaultTerm.trim().toLowerCase().equals("y")) {
						onSupPaymentTabSteps.clickDescription(tableName, description);
						onSupPaymentTabSteps.selectDefault(tableName, description);
					} else if (isActive.trim().toLowerCase().equals("y")) {
						onSupPaymentTabSteps.clickDescription(tableName, description);
						onSupPaymentTabSteps.chooseIsActive(tableName, description);
					}
				}
			}
		}
	}

	@When("^supplier is added payment menthod as \"([^\"]*)\"$")
	public void supplier_is_added_payment_menthod_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String tableNameOption = "Payment Option";
			String tableNameTerm = "Payment Term";
			String tableName = "Payment Method";

			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colDescription = "Description";
			String colIsActive = "Is Active";
			String colDefaultMenthod = "Default";
			String colOPTION = "OPTION";
			String colTERM = "TERM";

			String dataTableKey = "Customer_PaymentMenthod";
			SessionData.addDataTable(dataTableKey, dataTable);
			for (int rowCustomer_PaymentMenthod : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String description = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colDescription);
				String isActive = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colIsActive);
				String defaultMethod = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod,
						colDefaultMenthod);
				String oPTION = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colOPTION);
				String tERM = SessionData.getDataTbVal(dataTableKey, rowCustomer_PaymentMenthod, colTERM);
				if (!oPTION.isEmpty()) {
					onSupPaymentTabSteps.clickDescription(tableNameOption, oPTION);
					if (!tERM.isEmpty()) {
						onSupPaymentTabSteps.clickDescription(tableNameTerm, tERM);
						if (defaultMethod.trim().toLowerCase().equals("y")) {
							onSupPaymentTabSteps.selectDefault(tableName, description);
						} else if (isActive.trim().toLowerCase().equals("y")) {
							onSupPaymentTabSteps.chooseIsActive(tableName, description);
						}
					}
				}
			}
		}
	}

	@When("^supplier is added local shipment term as \"([^\"]*)\"$")
	public void supplier_is_added_local_shipment_term_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colInc = "Inc";
			String colShippingTerm = "Shipping Term";
			String colAir = "Air";
			String colSea = "Sea";
			String colRoad = "Road";
			String colRail = "Rail";
			String colDefaultShipment = "Default";

			String dataTableKey = "Cus_LocalShipmentTerm";
			SessionData.addDataTable(dataTableKey, dataTable);

			onSupplierSteps.moveToLocalInfoTab();
			onSupplierSteps.moveToShipmentInfoTab();
			onSupplierSteps.moveToShipmentModeTermTab();

			for (int rowCus_LocalShipmentTerm : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String inc = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colInc);
				String shippingTerm = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colShippingTerm);
				String air = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colAir);
				String sea = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colSea);
				String road = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colRoad);
				String rail = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm, colRail);
				String defaultShipment = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentTerm,
						colDefaultShipment);

				if (!shippingTerm.isEmpty()) {
					int rowIndex = onSupLocalInfoTabSteps.getRowIndexShipTerm(shippingTerm);
					if (rowIndex > 0) {
						boolean flagDefault = false;
						if (inc.toLowerCase().equals("y")) {
							onSupLocalInfoTabSteps.chooseInc(rowIndex);
							flagDefault = true;
						} else {
							if (air.toLowerCase().equals("y")) {
								flagDefault = true;
								onSupLocalInfoTabSteps.chooseAir(rowIndex);
							}
							if (road.toLowerCase().equals("y")) {
								flagDefault = true;
								onSupLocalInfoTabSteps.chooseRoad(rowIndex);
							}
							if (rail.toLowerCase().equals("y")) {
								flagDefault = true;
								onSupLocalInfoTabSteps.chooseRail(rowIndex);
							}
							if (sea.toLowerCase().equals("y")) {
								flagDefault = true;
								onSupLocalInfoTabSteps.chooseSea(rowIndex);
							}
						}
						if (defaultShipment.toLowerCase().equals("y") && flagDefault) {
							onSupLocalInfoTabSteps.chooseShipmentDefault(rowIndex);
						}
					}
				}
			}
		}
	}

	@When("^supplier is added local shipment country as \"([^\"]*)\"$")
	public void supplier_is_added_local_shipment_country_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colCountry = "Country";
			String colLoading = "Loading";
			String colDischarge = "Discharge";
			String colFinalDest = "Final Dest";
			String colDel = "Del";

			String dataTableKey = "Cus_LocalShipmentPort";
			SessionData.addDataTable(dataTableKey, dataTable);

			onSupplierSteps.moveToLocalInfoTab();
			onSupplierSteps.moveToShipmentInfoTab();
			onSupplierSteps.moveToCountryPortTab();

			for (int rowCus_LocalShipmentPort : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String country = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colCountry);
				String loading = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colLoading);
				String discharge = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colDischarge);
				String finalDest = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colFinalDest);
				String del = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPort, colDel);

				if (!country.isEmpty()) {
					if (isUpdate) {
						if (onSupLocalInfoTabSteps.isCountryExit(country))
							onSupLocalInfoTabSteps.chooseDelCountry(country);
					}
					onSupLocalInfoTabSteps.clickOnAddCountry();
					int rowIndex = onSupLocalInfoTabSteps.countRowCountry();

					onSupLocalInfoTabSteps.typeCountry(country, rowIndex);

					rowIndex = onSupLocalInfoTabSteps.getRowIndexCountry(country);

					if (rowIndex > 0) {
						onSupLocalInfoTabSteps.clickToOpenPort(rowIndex);

						if (loading.toLowerCase().equals("y")) {
							onSupLocalInfoTabSteps.chooseLoading(rowIndex);
						}
						if (discharge.toLowerCase().equals("y")) {
							onSupLocalInfoTabSteps.chooseDischarge(rowIndex);
						}
						if (finalDest.toLowerCase().equals("y")) {
							onSupLocalInfoTabSteps.chooseFinalDest(rowIndex);
						}
						if (del.toLowerCase().equals("y")) {
							onSupLocalInfoTabSteps.chooseDelCountry(rowIndex);
						}
					}
				}
			}
		}
	}

	@When("^supplier is added local shipment port as \"([^\"]*)\"$")
	public void supplier_is_added_local_shipment_port_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colCountry = "Country";
			String colLoading = "Loading";
			String colDischarge = "Discharge";
			String colFinalDest = "Final Dest";
			String colPort = "Port";

			String dataTableKey = "Cus_LocalShipmentPortDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			onSupplierSteps.moveToLocalInfoTab();
			onSupplierSteps.moveToShipmentInfoTab();
			onSupplierSteps.moveToCountryPortTab();

			for (int rowCus_LocalShipmentPortDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String country = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colCountry);
				String loading = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colLoading);
				String discharge = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colDischarge);
				String finalDest = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colFinalDest);
				String port = SessionData.getDataTbVal(dataTableKey, rowCus_LocalShipmentPortDetail, colPort);

				if (onSupLocalInfoTabSteps.chooseContry(country)) {
					if (!port.isEmpty()) {
						int rowIndex = onSupLocalInfoTabSteps.getRowIndexPort(port);
						if (rowIndex > 0) {
							if (loading.equals("y")) {
								onSupLocalInfoTabSteps.choosePortLoading(rowIndex);
							}
							if (discharge.equals("y")) {
								onSupLocalInfoTabSteps.choosePortDischange(rowIndex);
							}
							if (finalDest.equals("y")) {
								onSupLocalInfoTabSteps.choosePortFinalDest(rowIndex);
							}
						}
					}
				}
			}
		}
	}

	@When("^supplier is added local default setting as \"([^\"]*)\"$")
	public void supplier_is_added_local_default_setting_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SupDefaultSetting";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSUPPLIER = "KEY SUPPLIER";
			String colDeductChargeFlag = "Deduct Charge Flag";
			String colDeliveryToFornonCC = "Delivery To For nonCC";
			String colDeliveryMode = "Delivery Mode";

			onSupplierSteps.moveToLocalInfoTab();
			onSupplierSteps.moveToDefaultSettingTab();

			for (int rowSupDefaultSetting : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPPLIER, dataKey).keySet()) {
				String deductChargeFlag = SessionData.getDataTbVal(dataTableKey, rowSupDefaultSetting,
						colDeductChargeFlag);
				String deliveryToFornonCC = SessionData.getDataTbVal(dataTableKey, rowSupDefaultSetting,
						colDeliveryToFornonCC);
				String deliveryMode = SessionData.getDataTbVal(dataTableKey, rowSupDefaultSetting, colDeliveryMode);

				if (!deductChargeFlag.isEmpty()) {
					onSupLocalInfoTabSteps.chooseDeductChargeFlag(deductChargeFlag);
				}
				if (!deliveryToFornonCC.isEmpty()) {
					onSupLocalInfoTabSteps.chooseDeliveryToFornonCC(deliveryToFornonCC);
				}
				if (!deliveryMode.isEmpty()) {
					onSupLocalInfoTabSteps.chooseDeliveryMode(deliveryMode);
				}
			}
		}
	}

	@When("^supplier is updated$")
	public void supplier_is_updated() {
		if (isContinue)
			onSupplierSteps.clickOnUpdateButton();
	}

	@Given("^user create new Supplier$")
	public void user_create_new_Supplier() {

		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hSupplierColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colKey = hSupplierColName.get("Key");
		int colIsContra = hSupplierColName.get("isContra");
		int colSupplier = hSupplierColName.get("Supplier");
		int colSupplierName = hSupplierColName.get("Supplier Name");
		int colSupplierClassCode = hSupplierColName.get("Supplier Class Code");
		int colPartyGroupCode = hSupplierColName.get("Party Group Code");
		int colMainHomePage = hSupplierColName.get("Main Home Page");
		int colGSTRegistrationNo = hSupplierColName.get("GST Registration No");
		int colCountryOfIncorporation = hSupplierColName.get("Country Of Incorporation");
		int colSubconWIPGlan = hSupplierColName.get("Subcon WIP Glan");
		int colSalesTaxCode = hSupplierColName.get("Sales Tax Code");
		int colDefaultTenorTermCode = hSupplierColName.get("Default Tenor Term Code");
		int colDefaultTenor = hSupplierColName.get("Default Tenor");
		int colIPTRelated = hSupplierColName.get("IPT Related");
		int colStatus = hSupplierColName.get("Status");
		int colUniqueEntityNo = hSupplierColName.get("Unique Entity No");
		int colMainSupplierCode = hSupplierColName.get("Main Supplier Code");
		int colSupplierShortName = hSupplierColName.get("Supplier Short Name");
		int colSupplierCategoryCode = hSupplierColName.get("Supplier Category Code");
		int colSupplierRankCode = hSupplierColName.get("Supplier Rank Code");
		int colPurchasingZone = hSupplierColName.get("Purchasing Zone");
		int colPartyContraGLAN = hSupplierColName.get("Party Contra GLAN");
		int colContraRealizedExchGLAN = hSupplierColName.get("Contra Realized Exch GLAN");
		int colDefaultDiscountPercent = hSupplierColName.get("Default Discount Percent");
		int colCombineShmtoInvoices = hSupplierColName.get("Combine Shm to Invoices");
		int colRemarks = hSupplierColName.get("Remarks");

		String key = "";
		String isContra = "";
		String supplier = "";
		String supplierName = "";
		String supplierClassCode = "";
		String partyGroupCode = "";
		String mainHomePage = "";
		String gSTRegistrationNo = "";
		String countryOfIncorporation = "";
		String subconWIPGlan = "";
		String salesTaxCode = "";
		String defaultTenorTermCode = "";
		String defaultTenor = "";
		String iPTRelated = "";
		String status = "";
		String uniqueEntityNo = "";
		String mainSupplierCode = "";
		String supplierShortName = "";
		String supplierCategoryCode = "";
		String supplierRankCode = "";
		String purchasingZone = "";
		String partyContraGLAN = "";
		String contraRealizedExchGLAN = "";
		String defaultDiscountPercent = "";
		String combineShmtoInvoices = "";
		String remarks = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);

		for (Integer row : getDataset.keySet()) {
			key = getDataset.get(row).get(colKey);
			isContra = getDataset.get(row).get(colIsContra);
			supplier = getDataset.get(row).get(colSupplier);
			supplierName = getDataset.get(row).get(colSupplierName);
			supplierClassCode = getDataset.get(row).get(colSupplierClassCode);
			partyGroupCode = getDataset.get(row).get(colPartyGroupCode);
			mainHomePage = getDataset.get(row).get(colMainHomePage);
			gSTRegistrationNo = getDataset.get(row).get(colGSTRegistrationNo);
			countryOfIncorporation = getDataset.get(row).get(colCountryOfIncorporation);
			subconWIPGlan = getDataset.get(row).get(colSubconWIPGlan);
			salesTaxCode = getDataset.get(row).get(colSalesTaxCode);
			defaultTenorTermCode = getDataset.get(row).get(colDefaultTenorTermCode);
			defaultTenor = getDataset.get(row).get(colDefaultTenor);
			iPTRelated = getDataset.get(row).get(colIPTRelated);
			status = getDataset.get(row).get(colStatus);
			uniqueEntityNo = getDataset.get(row).get(colUniqueEntityNo);
			mainSupplierCode = getDataset.get(row).get(colMainSupplierCode);
			supplierShortName = getDataset.get(row).get(colSupplierShortName);
			supplierCategoryCode = getDataset.get(row).get(colSupplierCategoryCode);
			supplierRankCode = getDataset.get(row).get(colSupplierRankCode);
			purchasingZone = getDataset.get(row).get(colPurchasingZone);
			partyContraGLAN = getDataset.get(row).get(colPartyContraGLAN);
			contraRealizedExchGLAN = getDataset.get(row).get(colContraRealizedExchGLAN);
			defaultDiscountPercent = getDataset.get(row).get(colDefaultDiscountPercent);
			combineShmtoInvoices = getDataset.get(row).get(colCombineShmtoInvoices);
			remarks = getDataset.get(row).get(colRemarks);

			onSupplierSteps.addSupplier();

			if (isContra.trim().toLowerCase().equals("y")) {
				onSupplierSteps.searchParty(supplier);
			} else {
				if (!supplier.isEmpty()) {
					onSupplierSteps.typeSupplier(supplier);
				}
				if (!supplierName.isEmpty()) {
					onSupplierSteps.typeSupplierName(supplierName);
				}
			}

			if (!supplierClassCode.isEmpty()) {
				onSupplierSteps.typeSupplierClassCode(supplierClassCode);
			}
			if (!partyGroupCode.isEmpty()) {
				onSupplierSteps.typePartyGroupCode(partyGroupCode);
			}
			if (!mainHomePage.isEmpty()) {
				onSupplierSteps.typeMainHomePage(mainHomePage);
			}
			if (!gSTRegistrationNo.isEmpty()) {
				onSupplierSteps.typeGSTRegistrationNo(gSTRegistrationNo);
			}
			if (!countryOfIncorporation.isEmpty()) {
				onSupplierSteps.typeCountryOfIncorporation(countryOfIncorporation);
			}
			if (!subconWIPGlan.isEmpty()) {
				onSupplierSteps.typeSubconWIPGlan(subconWIPGlan);
			}
			if (!salesTaxCode.isEmpty()) {
				onSupplierSteps.typeSalesTaxCode(salesTaxCode);
			}
			if (!defaultTenorTermCode.isEmpty()) {
				onSupplierSteps.typeDefaultTenorTermCode(defaultTenorTermCode);
			}
			if (!defaultTenor.isEmpty()) {
				onSupplierSteps.typeDefaultTenor(defaultTenor);
			}
			if (!iPTRelated.isEmpty()) {
				onSupplierSteps.chooseIPTRelated(iPTRelated);
			}
			if (!status.isEmpty()) {
				onSupplierSteps.chooseStatus(status);
			}
			if (!uniqueEntityNo.isEmpty()) {
				onSupplierSteps.typeUniqueEntityNo(uniqueEntityNo);
			}
			if (!mainSupplierCode.isEmpty()) {
				onSupplierSteps.typeMainSupplierCode(mainSupplierCode);
			}
			if (!supplierShortName.isEmpty()) {
				onSupplierSteps.typeSupplierShortName(supplierShortName);
			}
			if (!supplierCategoryCode.isEmpty()) {
				onSupplierSteps.typeSupplierCategoryCode(supplierCategoryCode);
			}
			if (!supplierRankCode.isEmpty()) {
				onSupplierSteps.typeSupplierRankCode(supplierRankCode);
			}
			if (!purchasingZone.isEmpty()) {
				onSupplierSteps.typePurchasingZone(purchasingZone);
			}
			if (!partyContraGLAN.isEmpty()) {
				onSupplierSteps.typePartyContraGLAN(partyContraGLAN);
			}
			if (!contraRealizedExchGLAN.isEmpty()) {
				onSupplierSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
			}
			if (!defaultDiscountPercent.isEmpty()) {
				onSupplierSteps.typeDefaultDiscountPercent(defaultDiscountPercent);
			}
			if (!combineShmtoInvoices.isEmpty()) {
				onSupplierSteps.chooseCombineShmtoInvoices(combineShmtoInvoices);
			}
			if (!remarks.isEmpty()) {
				onSupplierSteps.typeRemarks(remarks);
			}

			// moveToAddressTab(key);
			// moveToContactTab(key);
			// moveToBankDetailTab(key);
			// moveToSBUTab(key);
			moveToCurrencyTab();
			moveToPaymentTab();
			moveToCompanyTab(key);

			onSupplierSteps.clickOnUpdateButton();
			// moveToLocalInfoTab(key);

		}
	}

	public void moveToAddressTab(String supKey) {
		onSupplierSteps.moveToAddressTab();
		HashMap<String, Integer> hAddressColName = SessionData.getExcelColNameBySheetName(keyFileName, addressSheet);

		int colAddressCode = hAddressColName.get("Address Code");
		int colAddressKey = hAddressColName.get("Key");
		int colAddressDescription = hAddressColName.get("Description");
		int colAddress = hAddressColName.get("Address");
		int colCountryCode = hAddressColName.get("Country Code");
		int colStateProvince = hAddressColName.get("State Province");
		int colCityTown = hAddressColName.get("City Town");
		int colPostalCode = hAddressColName.get("Postal Code");

		String addressCode = "";
		String addressKey = "";
		String addressDescription = "";
		String address = "";
		String countryCode = "";
		String stateProvince = "";
		String cityTown = "";
		String postalCode = "";

		HashMap<String, Integer> hAddressTypeColName = SessionData.getExcelColNameBySheetName(keyFileName, addressTypeSheet);
		int colTypeKey = hAddressTypeColName.get("Key");
		int colIncType = hAddressTypeColName.get("Inc Type");
		int colTypeDefault = hAddressTypeColName.get("Default");

		String typeKey = "";
		String incType = "";
		String typeDefault = "";

		HashMap<String, Integer> hAddressContactTypeColName = SessionData.getExcelColNameBySheetName(keyFileName,
				addressContactTypeSheet);
		int colContactTypeKey = hAddressContactTypeColName.get("Key");
		int colContactType = hAddressContactTypeColName.get("Contact Type");
		int colContactInformation = hAddressContactTypeColName.get("Contact Information");
		int colContactTypeDefault = hAddressContactTypeColName.get("Default");
		int colDel = hAddressContactTypeColName.get("Del");

		String contactTypeKey = "";
		String contactType = "";
		String contactInformation = "";
		String contactTypeDefault = "";
		String del = "";

		LinkedHashMap<Integer, List<String>> getAddress = SessionData.getExcelSheetDataNoHeader(keyFileName,
				addressSheet);
		for (Integer rowAddress : getAddress.keySet()) {
			addressCode = getAddress.get(rowAddress).get(colAddressCode);
			addressKey = getAddress.get(rowAddress).get(colAddressKey);
			addressDescription = getAddress.get(rowAddress).get(colAddressDescription);
			address = getAddress.get(rowAddress).get(colAddress);
			countryCode = getAddress.get(rowAddress).get(colCountryCode);
			stateProvince = getAddress.get(rowAddress).get(colStateProvince);
			cityTown = getAddress.get(rowAddress).get(colCityTown);
			postalCode = getAddress.get(rowAddress).get(colPostalCode);

			onSupAddressTabSteps.clickOnAddAddressBtn();
			// if(addressKey.equals(supKey))
			if (!addressCode.isEmpty()) {
				onSupAddressTabSteps.typeAddressCode(addressCode);
			}
			if (!addressDescription.isEmpty()) {
				onSupAddressTabSteps.typeAddressDescription(addressDescription);
			}
			if (!address.isEmpty()) {
				onSupAddressTabSteps.typeAddress(address);
			}
			if (!countryCode.isEmpty()) {
				onSupAddressTabSteps.typeCountryCode(countryCode);
			}
			if (!stateProvince.isEmpty()) {
				onSupAddressTabSteps.typeStateProvince(stateProvince);
			}
			if (!cityTown.isEmpty()) {
				onSupAddressTabSteps.typeCityTown(cityTown);
			}
			if (!postalCode.isEmpty()) {
				onSupAddressTabSteps.typePostalCode(postalCode);
			}

			LinkedHashMap<Integer, List<String>> getAddressType = SessionData.getExcelSheetDataNoHeader(keyFileName,
					addressTypeSheet);
			for (Integer rowAddressType : getAddressType.keySet()) {
				typeKey = getAddressType.get(rowAddressType).get(colTypeKey);
				incType = getAddressType.get(rowAddressType).get(colIncType);
				typeDefault = getAddressType.get(rowAddressType).get(colTypeDefault);

				if (typeKey.equals(addressKey)) {
					if (!incType.isEmpty()) {
						onSupAddressTabSteps.chooseIncType(incType);
					}
					if (typeDefault.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseTypeDefault(incType);
					}
				}
			}

			LinkedHashMap<Integer, List<String>> getAddressContactType = SessionData
					.getExcelSheetDataNoHeader(keyFileName, addressContactTypeSheet);
			for (Integer rowAddressContactType : getAddressContactType.keySet()) {
				contactTypeKey = getAddressContactType.get(rowAddressContactType).get(colContactTypeKey);
				contactType = getAddressContactType.get(rowAddressContactType).get(colContactType);
				contactInformation = getAddressContactType.get(rowAddressContactType).get(colContactInformation);
				contactTypeDefault = getAddressContactType.get(rowAddressContactType).get(colContactTypeDefault);
				del = getAddressContactType.get(rowAddressContactType).get(colDel);

				if (contactTypeKey.equals(addressKey)) {
					onSupAddressTabSteps.clickOnAddContactTypeBtn();
					int rowIndex = onSupAddressTabSteps.countRowContactTypeTb();

					if (!contactType.isEmpty()) {
						onSupAddressTabSteps.chooseContactType(contactType, rowIndex);
					}
					if (!contactInformation.isEmpty()) {
						onSupAddressTabSteps.typeContactInformation(contactInformation, rowIndex);
					}
					if (contactTypeDefault.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseContactTypeDefault(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onSupAddressTabSteps.chooseDel(rowIndex);
					}
				}
			}
		}
	}

	public void moveToContactTab(String supKey) {
		onSupplierSteps.moveToContactTab();
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

			onSupContactTabSteps.clickOnAddContact();
			// if(contactKey.equals(supKey))
			if (!partyContactCode.isEmpty()) {
				onSupContactTabSteps.typePartyContactCode(partyContactCode);
			}
			if (!salutation.isEmpty()) {
				onSupContactTabSteps.chooseSalutation(salutation);
			}
			if (!firstName.isEmpty()) {
				onSupContactTabSteps.typeFirstName(firstName);
			}
			if (!middleName.isEmpty()) {
				onSupContactTabSteps.typeMiddleName(middleName);
			}
			if (!lastName.isEmpty()) {
				onSupContactTabSteps.typeLastName(lastName);
			}
			if (!name.isEmpty()) {
				onSupContactTabSteps.typeName(name);
			}
			if (!addressCode.isEmpty()) {
				onSupContactTabSteps.chooseAddressCode(addressCode);
			}
			if (!designation.isEmpty()) {
				onSupContactTabSteps.typeDesignation(designation);
			}
			if (!designationGroup.isEmpty()) {
				onSupContactTabSteps.typeDesignationGroup(designationGroup);
			}
			if (!department.isEmpty()) {
				onSupContactTabSteps.typeDepartment(department);
			}

			LinkedHashMap<Integer, List<String>> getContactIncType = SessionData.getExcelSheetDataNoHeader(keyFileName,
					contactIncTypeSheet);
			for (Integer rowContactIncType : getContactIncType.keySet()) {
				incTypeKey = getContactIncType.get(rowContactIncType).get(colIncTypeKey);
				incType = getContactIncType.get(rowContactIncType).get(colIncType);
				incDefault = getContactIncType.get(rowContactIncType).get(colIncDefault);

				if (incTypeKey.equals(contactKey)) {
					if (!incType.isEmpty()) {
						onSupContactTabSteps.chooseIncType(incType);
					}
					if (incDefault.toLowerCase().equals("y")) {
						onSupContactTabSteps.chooseIncDefault(incType);
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
					onSupContactTabSteps.clickOnAddContactTypeBtn();
					int rowIndex = onSupContactTabSteps.countRowContactContactTypeTb();

					if (!contactTypeContactType.isEmpty()) {
						onSupContactTabSteps.chooseContactTypeContactType(contactTypeContactType, rowIndex);
					}
					if (!contactTypeContactInformation.isEmpty()) {
						onSupContactTabSteps.typeContactTypeContactInformation(contactTypeContactInformation, rowIndex);
					}
					if (contactTypeTypeDefault.toLowerCase().equals("y")) {
						onSupContactTabSteps.chooseContactTypeTypeDefault(rowIndex);
					}
					if (contactTypeDel.toLowerCase().equals("y")) {
						onSupContactTabSteps.chooseDelContactType(rowIndex);
					}
				}
			}
		}
	}

	public void moveToBankDetailTab(String supKey) {
		onSupplierSteps.moveToBankDetailTab();

		HashMap<String, Integer> hBankDetailColName = SessionData.getExcelColNameBySheetName(keyFileName, bankDetailSheet);
		int colKey = hBankDetailColName.get("Key");
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

			onSupBankDetailTabSteps.clickOnAddBankDetail();
			int rowIndex = onSupBankDetailTabSteps.countRowBankDetail();
			// if(key.equals(supKey))

			if (!bank.isEmpty()) {
				onSupBankDetailTabSteps.typeBank(bank, rowIndex);
			}
			if (!description.isEmpty()) {
				onSupBankDetailTabSteps.typeDescription(description, rowIndex);
			}
			if (!accountNo.isEmpty()) {
				onSupBankDetailTabSteps.typeAccountNo(accountNo, rowIndex);
			}
			if (!currency.isEmpty()) {
				onSupBankDetailTabSteps.typeBankCurrency(currency, rowIndex);
			}
			if (bankDefault.toLowerCase().equals("y")) {
				onSupBankDetailTabSteps.chooseBankDefault(rowIndex);
			}
			if (del.toLowerCase().equals("y")) {
				onSupBankDetailTabSteps.chooseBankDel(rowIndex);
			}
		}
	}

	public void moveToSBUTab(String supKey) {
		onSupplierSteps.moveToSBUTab();

		HashMap<String, Integer> hSBUColName = SessionData.getExcelColNameBySheetName(keyFileName, sBUSheet);

		int colSBUKey = hSBUColName.get("Key");
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

			onSupSBUTabSteps.clickAddSBU();
			int rowIndex = onSupSBUTabSteps.countRowSBU();
			// if(sBUKey.equals(supKey))

			if (!sBU.isEmpty()) {
				onSupSBUTabSteps.typeSBU(sBU, rowIndex);
			}
			if (!description.isEmpty()) {
				onSupSBUTabSteps.typeDescription(description, rowIndex);
			}
			if (del.toLowerCase().equals("y")) {
				onSupSBUTabSteps.chooseDelSBU(rowIndex);
			}
		}

	}

	public void moveToCurrencyTab() {

		HashMap<String, Integer> hCurrencyColName = SessionData.getExcelColNameBySheetName(keyFileName, currencySheet);
		int colCurrency = hCurrencyColName.get("Currency");
		String currency = "";

		onSupplierSteps.moveToCurrencyTab();
		LinkedHashMap<Integer, List<String>> getCurrency = SessionData.getExcelSheetDataNoHeader(keyFileName,
				currencySheet);
		for (Integer rowCurrency : getCurrency.keySet()) {
			currency = getCurrency.get(rowCurrency).get(colCurrency);
			if (!currency.isEmpty()) {
				onSupCurrencyTabSteps.clickAddCurrency();
				onSupCurrencyTabSteps.typeCurrency(currency);
			}
		}
	}

	public void moveToPaymentTab() {
		HashMap<String, Integer> hPaymentColName = SessionData.getExcelColNameBySheetName(keyFileName, paymentSheet);
		int colOperationalCurrency = hPaymentColName.get("Operational Currency");
		int colOverallCreditLimit = hPaymentColName.get("Overall Credit Limit");

		String operationalCurrency = "";
		String overallCreditLimit = "";

		onSupplierSteps.moveToPaymentTab();
		LinkedHashMap<Integer, List<String>> getPayment = SessionData.getExcelSheetDataNoHeader(keyFileName,
				paymentSheet);
		for (Integer rowPayment : getPayment.keySet()) {
			operationalCurrency = getPayment.get(rowPayment).get(colOperationalCurrency);
			overallCreditLimit = getPayment.get(rowPayment).get(colOverallCreditLimit);

			if (!operationalCurrency.isEmpty()) {
				onSupPaymentTabSteps.selectOperationalCurrency(operationalCurrency);
			}
			if (!overallCreditLimit.isEmpty()) {
				onSupPaymentTabSteps.typeOverallCreditLimit(overallCreditLimit);
			}
		}
		selectPaymentOption();
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
				onSupPaymentTabSteps.selectDefault("Payment Option", descOption);
				onSupPaymentTabSteps.clickDescription("Payment Option", descOption);
				selectPaymentTerm(keyOption);
			} else if (isActiveOption.trim().toLowerCase().equals("y")) {
				onSupPaymentTabSteps.clickDescription("Payment Option", descOption);
				onSupPaymentTabSteps.chooseIsActive("Payment Option", descOption);
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
					onSupPaymentTabSteps.selectDefault(tableName, descTerm);
					onSupPaymentTabSteps.clickDescription(tableName, descTerm);
					selectPaymentMethod(keyOption);
				} else if (isActiveTerm.trim().toLowerCase().equals("y")) {
					onSupPaymentTabSteps.clickDescription(tableName, descTerm);
					onSupPaymentTabSteps.chooseIsActive(tableName, descTerm);
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
					onSupPaymentTabSteps.selectDefault(tableName, descMethod);
				} else if (isActiveMethod.trim().toLowerCase().equals("y")) {
					onSupPaymentTabSteps.chooseIsActive(tableName, descMethod);
				}
			}
		}
	}

	public void moveToCompanyTab(String supKey) {
		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colKey = hCompanyColName.get("Key");
		int colCompany = hCompanyColName.get("Company");

		String companyKey = "";
		String company = "";

		onSupplierSteps.moveToCompanyTab();
		LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetData(keyFileName, companySheet);
		for (Integer rowComp : getCompany.keySet()) {
			companyKey = getCompany.get(rowComp).get(colKey);
			if (companyKey.equals(supKey)) {
				company = getCompany.get(rowComp).get(colCompany);
				if (company.trim().toLowerCase().equals("all")) {
					onSupCompanyTabSteps.chooseAllCompany();
				} else
					onSupCompanyTabSteps.chooseCompany(company);
			}
		}
	}

	public void moveToLocalInfoTab(String supKey) {

		onSupplierSteps.moveToLocalInfoTab();
		moveToShipmentModeTab(supKey);
		moveToCountryPortTab(supKey);
		moveToDefaultSettingTab(supKey);
	}

	public void moveToShipmentModeTab(String supKey) {

		onSupplierSteps.moveToShipmentInfoTab();
		onSupplierSteps.moveToShipmentModeTermTab();
		HashMap<String, Integer> hShipmentModeTermColName = SessionData.getExcelColNameBySheetName(keyFileName,
				shipmentModeTermSheet);
		int colKey = hShipmentModeTermColName.get("Sup Key");
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
				shipmentModeTermSheet);
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
					rowIndex = onSupLocalInfoTabSteps.getRowIndexShipTerm(shippingTerm);

					if (!inc.isEmpty()) {
						onSupLocalInfoTabSteps.chooseInc(rowIndex);
					}
					if (!air.isEmpty()) {
						onSupLocalInfoTabSteps.chooseAir(rowIndex);
					}
					if (!road.isEmpty()) {
						onSupLocalInfoTabSteps.chooseRoad(rowIndex);
					}
					if (!rail.isEmpty()) {
						onSupLocalInfoTabSteps.chooseRail(rowIndex);
					}
					if (!shipmentDefault.isEmpty()) {
						onSupLocalInfoTabSteps.chooseShipmentDefault(rowIndex);
					}

					if (!sea.isEmpty()) {
						onSupLocalInfoTabSteps.chooseSea(rowIndex);
					}
				}
			}
		}
	}

	public void moveToCountryPortTab(String supKey) {
		onSupplierSteps.moveToShipmentInfoTab();
		onSupplierSteps.moveToCountryPortTab();

		HashMap<String, Integer> hCountryPortColName = SessionData.getExcelColNameBySheetName(keyFileName, countryPortSheet);
		int colKey = hCountryPortColName.get("Sup Key");
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
				countryPortSheet);
		for (Integer rowCountryPort : getCountryPort.keySet()) {
			key = getCountryPort.get(rowCountryPort).get(colKey);
			countryKey = getCountryPort.get(rowCountryPort).get(colCountryKey);
			country = getCountryPort.get(rowCountryPort).get(colCountry);
			loading = getCountryPort.get(rowCountryPort).get(colLoading);
			discharge = getCountryPort.get(rowCountryPort).get(colDischarge);
			finalDest = getCountryPort.get(rowCountryPort).get(colFinalDest);
			del = getCountryPort.get(rowCountryPort).get(colDel);

			onSupLocalInfoTabSteps.clickOnAddCountry();
			rowIndex = onSupLocalInfoTabSteps.countRowCountry();
			// if(!key.isEmpty())
			if (!country.isEmpty()) {
				onSupLocalInfoTabSteps.typeCountry(country, rowIndex);
			}

			rowIndex = onSupLocalInfoTabSteps.getRowIndexCountry(country);
			onSupLocalInfoTabSteps.clickToOpenPort(rowIndex);

			if (loading.toLowerCase().equals("y")) {
				onSupLocalInfoTabSteps.chooseLoading(rowIndex);
			}
			if (discharge.toLowerCase().equals("y")) {
				onSupLocalInfoTabSteps.chooseDischarge(rowIndex);
			}
			if (finalDest.toLowerCase().equals("y")) {
				onSupLocalInfoTabSteps.chooseFinalDest(rowIndex);
			}

			choosePort(countryKey);

			if (del.toLowerCase().equals("y")) {
				onSupLocalInfoTabSteps.chooseDelCountry(rowIndex);
			}
		}
	}

	public void choosePort(String countryKey) {
		HashMap<String, Integer> hDetailPortColName = SessionData.getExcelColNameBySheetName(keyFileName, detailPortSheet);
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
				detailPortSheet);
		for (Integer rowDetailPort : getDetailPort.keySet()) {
			key = getDetailPort.get(rowDetailPort).get(colKey);
			port = getDetailPort.get(rowDetailPort).get(colPort);
			loading = getDetailPort.get(rowDetailPort).get(colLoading);
			dischange = getDetailPort.get(rowDetailPort).get(colDischange);
			finalDest = getDetailPort.get(rowDetailPort).get(colFinalDest);

			if (countryKey.equals(key)) {
				if (!port.isEmpty()) {
					rowIndex = onSupLocalInfoTabSteps.getRowIndexPort(port);

					if (loading.equals("y")) {
						onSupLocalInfoTabSteps.choosePortLoading(rowIndex);
					}
					if (dischange.equals("y")) {
						onSupLocalInfoTabSteps.choosePortDischange(rowIndex);
					}
					if (finalDest.equals("y")) {
						onSupLocalInfoTabSteps.choosePortFinalDest(rowIndex);
					}
				}
			}
		}
	}

	public void moveToDefaultSettingTab(String supKey) {
		onSupplierSteps.moveToDefaultSettingTab();
		HashMap<String, Integer> hDefaultSettingColName = SessionData.getExcelColNameBySheetName(keyFileName,
				defaultSettingSheet);

		int colKey = hDefaultSettingColName.get("Key");
		int colDeductChargeFlag = hDefaultSettingColName.get("Deduct Charge Flag");
		int colDeliveryToFornonCC = hDefaultSettingColName.get("Delivery To For nonCC");
		int colDeliveryMode = hDefaultSettingColName.get("Delivery Mode");

		String key = "";
		String deductChargeFlag = "";
		String deliveryToFornonCC = "";
		String deliveryMode = "";

		LinkedHashMap<Integer, List<String>> getDefaultSetting = SessionData.getExcelSheetDataNoHeader(keyFileName,
				defaultSettingSheet);
		for (Integer rowDefaultSetting : getDefaultSetting.keySet()) {
			key = getDefaultSetting.get(rowDefaultSetting).get(colKey);
			deductChargeFlag = getDefaultSetting.get(rowDefaultSetting).get(colDeductChargeFlag);
			deliveryToFornonCC = getDefaultSetting.get(rowDefaultSetting).get(colDeliveryToFornonCC);
			deliveryMode = getDefaultSetting.get(rowDefaultSetting).get(colDeliveryMode);

			// if(!key.isEmpty())

			if (!deductChargeFlag.isEmpty()) {
				onSupLocalInfoTabSteps.chooseDeductChargeFlag(deductChargeFlag);
			}
			if (!deliveryToFornonCC.isEmpty()) {
				onSupLocalInfoTabSteps.chooseDeliveryToFornonCC(deliveryToFornonCC);
			}
			if (!deliveryMode.isEmpty()) {
				onSupLocalInfoTabSteps.chooseDeliveryMode(deliveryMode);
			}
		}
	}
}
