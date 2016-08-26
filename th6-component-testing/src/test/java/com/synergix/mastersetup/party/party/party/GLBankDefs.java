package com.synergix.mastersetup.party.party.party;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.party.steps.PartySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLBankDefs {
	@Steps
	PartySteps onBankSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_PARTY + "Bank.xls";
	String keyFileName = "Bank";
	String datasetSheet = "Bank";
	String relationServiceGroupSheet = "Relation Service Group";
	String ownBankDetailSheet = "Own Bank Detail";
	String companySheet = "Company";

	boolean isContinue = false;
	boolean isUpdate = false;

	@When("^user create bank as \"([^\"]*)\"$")
	public void user_create_bank_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Bank";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYBANK = "KEY BANK";
		String colPrefix = "Prefix";
		String colPartyCode = "Party Code";
		String colPartyName = "Party Name";
		String colPartyShortName = "Party Short Name";
		String colPartyGroupCode = "Party Group Code";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colMainHomePage = "Main Home Page";
		String colTaxAgent = "Tax Agent";
		String colGSTRegistrationNo = "GST Registration No";
		String colUniqueEntityNo = "Unique Entity No";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colCompany = "Company";

		onBankSteps.switchToIFrame();

		for (int rowBank : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBANK, dataKey).keySet()) {
			String prefix = SessionData.getDataTbVal(dataTableKey, rowBank, colPrefix);
			String partyCode = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyCode);
			String partyName = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyName);
			String partyShortName = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyShortName);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyGroupCode);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowBank, colCountryOfIncorporation);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowBank, colMainHomePage);
			String taxAgent = SessionData.getDataTbVal(dataTableKey, rowBank, colTaxAgent);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowBank, colGSTRegistrationNo);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowBank, colUniqueEntityNo);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyContraGLAN);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowBank, colContraRealizedExchGLAN);
			String company = SessionData.getDataTbVal(dataTableKey, rowBank, colCompany);

			onBankSteps.addBank();
			if (!prefix.isEmpty()) {
				partyCode = onBankSteps.autoGenCode(prefix);
			}

			if (!partyCode.isEmpty()) {
				onBankSteps.typePartyCode(partyCode);

				isContinue = true;
				if (!partyName.isEmpty()) {
					onBankSteps.typePartyName(partyName);
				}
				if (!partyShortName.isEmpty()) {
					onBankSteps.typePartyShortName(partyShortName);
				}
				if (!partyGroupCode.isEmpty()) {
					onBankSteps.typePartyGroupCode(partyGroupCode);
				}
				if (!countryOfIncorporation.isEmpty()) {
					onBankSteps.typeCountryOfIncorporation(countryOfIncorporation);
				}
				if (!mainHomePage.isEmpty()) {
					onBankSteps.typeMainHomePage(mainHomePage);
				}
				if (!taxAgent.isEmpty()) {
					onBankSteps.chooseTaxAgent(taxAgent);
				}
				if (!gSTRegistrationNo.isEmpty()) {
					onBankSteps.typeGSTRegistrationNo(gSTRegistrationNo);
				}
				if (!uniqueEntityNo.isEmpty()) {
					onBankSteps.typeUniqueEntityNo(uniqueEntityNo);
				}
				if (!partyContraGLAN.isEmpty()) {
					onBankSteps.typePartyContraGLAN(partyContraGLAN);
				}
				if (!contraRealizedExchGLAN.isEmpty()) {
					onBankSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
				}
				if (!company.isEmpty()) {
					onBankSteps.moveToCompanyTab();
					if (company.toLowerCase().equals("all"))
						onBankSteps.chooseAllCompany();
					else
						onBankSteps.chooseCompany(company);
				}
			}
		}
		onBankSteps.switchOutDefaultIFrame();
	}

	@When("^user update bank as \"([^\"]*)\"$")
	public void user_update_bank_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Bank";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYBANK = "KEY BANK";
		String colPartyCode = "Party Code";
		String colPartyName = "Party Name";
		String colPartyShortName = "Party Short Name";
		String colPartyGroupCode = "Party Group Code";
		String colCountryOfIncorporation = "Country Of Incorporation";
		String colMainHomePage = "Main Home Page";
		String colTaxAgent = "Tax Agent";
		String colGSTRegistrationNo = "GST Registration No";
		String colUniqueEntityNo = "Unique Entity No";
		String colPartyContraGLAN = "Party Contra GLAN";
		String colContraRealizedExchGLAN = "Contra Realized Exch GLAN";
		String colCompany = "Company";

		onBankSteps.switchToIFrame();

		for (int rowBank : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBANK, dataKey).keySet()) {
			String partyCode = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyCode);
			String partyName = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyName);
			String partyShortName = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyShortName);
			String partyGroupCode = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyGroupCode);
			String countryOfIncorporation = SessionData.getDataTbVal(dataTableKey, rowBank, colCountryOfIncorporation);
			String mainHomePage = SessionData.getDataTbVal(dataTableKey, rowBank, colMainHomePage);
			String taxAgent = SessionData.getDataTbVal(dataTableKey, rowBank, colTaxAgent);
			String gSTRegistrationNo = SessionData.getDataTbVal(dataTableKey, rowBank, colGSTRegistrationNo);
			String uniqueEntityNo = SessionData.getDataTbVal(dataTableKey, rowBank, colUniqueEntityNo);
			String partyContraGLAN = SessionData.getDataTbVal(dataTableKey, rowBank, colPartyContraGLAN);
			String contraRealizedExchGLAN = SessionData.getDataTbVal(dataTableKey, rowBank, colContraRealizedExchGLAN);
			String company = SessionData.getDataTbVal(dataTableKey, rowBank, colCompany);

			if (!partyCode.isEmpty()) {
				onBankSteps.searchBank(partyCode);
				isContinue = true;
				isUpdate = true;

				if (!partyName.isEmpty()) {
					onBankSteps.typePartyName(partyName);
				}
				if (!partyShortName.isEmpty()) {
					onBankSteps.typePartyShortName(partyShortName);
				}
				if (!partyGroupCode.isEmpty()) {
					onBankSteps.typePartyGroupCode(partyGroupCode);
				}
				if (!countryOfIncorporation.isEmpty()) {
					onBankSteps.typeCountryOfIncorporation(countryOfIncorporation);
				}
				if (!mainHomePage.isEmpty()) {
					onBankSteps.typeMainHomePage(mainHomePage);
				}
				if (!taxAgent.isEmpty()) {
					onBankSteps.chooseTaxAgent(taxAgent);
				}
				if (!gSTRegistrationNo.isEmpty()) {
					onBankSteps.typeGSTRegistrationNo(gSTRegistrationNo);
				}
				if (!uniqueEntityNo.isEmpty()) {
					onBankSteps.typeUniqueEntityNo(uniqueEntityNo);
				}
				if (!partyContraGLAN.isEmpty()) {
					onBankSteps.typePartyContraGLAN(partyContraGLAN);
				}
				if (!contraRealizedExchGLAN.isEmpty()) {
					onBankSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
				}
				if (!company.isEmpty()) {
					onBankSteps.moveToCompanyTab();
					if (company.toLowerCase().equals("all"))
						onBankSteps.chooseAllCompany();
					else
						onBankSteps.chooseCompany(company);
				}
			}
		}
		onBankSteps.switchOutDefaultIFrame();
	}

	@When("bank is added relation service group as \"([^\"]*)\"$")
	public void bank_is_added_relation_service_group_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYBANK = "KEY BANK";
			String colPartyRelation = "Party Relation";
			String colServiceType = "Service Type";
			String colAllowed = "Allowed";

			String dataTableKey = "BankRelation";
			SessionData.addDataTable(dataTableKey, dataTable);

			onBankSteps.switchToIFrame();

			for (int rowBankRelation : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBANK, dataKey)
					.keySet()) {
				String partyRelation = SessionData.getDataTbVal(dataTableKey, rowBankRelation, colPartyRelation);
				String serviceType = SessionData.getDataTbVal(dataTableKey, rowBankRelation, colServiceType);
				String allowed = SessionData.getDataTbVal(dataTableKey, rowBankRelation, colAllowed);

				onBankSteps.moveToRelationServiceGroupTab();
				if (allowed.toLowerCase().equals("y")) {
					if (!partyRelation.isEmpty() && !serviceType.isEmpty()) {
						onBankSteps.chooseRelationService(partyRelation, serviceType);
					}
				}
			}
			onBankSteps.switchOutDefaultIFrame();
		}
	}

	@When("bank is added local info own bank detail as \"([^\"]*)\"$")
	public void bank_is_added_local_info_own_bank_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "OwnBankDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBANK = "KEY BANK";
			String colAccountNo = "Account No";
			String colBranchCode = "Branch Code";
			String colCurrencyCode = "Currency Code";
			String colBankGLAN = "Bank GLAN";
			String colLastChequeNo = "Last Cheque No";
			String colCombineBCinPayment = "Combine BC in Payment";
			String colCombineBCinReceipt = "Combine BC in Receipt";
			String colDel = "Del";

			onBankSteps.moveToLocalInfoTab();
			onBankSteps.moveToOwnBankDetailTab();

			onBankSteps.switchToIFrame();

			for (int rowOwnBankDetail : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBANK, dataKey)
					.keySet()) {
				String accountNo = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail, colAccountNo);
				String branchCode = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail, colBranchCode);
				String currencyCode = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail, colCurrencyCode);
				String bankGLAN = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail, colBankGLAN);
				String lastChequeNo = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail, colLastChequeNo);
				String combineBCinPayment = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail,
						colCombineBCinPayment);
				String combineBCinReceipt = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail,
						colCombineBCinReceipt);
				String del = SessionData.getDataTbVal(dataTableKey, rowOwnBankDetail, colDel);

				if (isUpdate) {
					if (onBankSteps.isOwnBankDetailExit(accountNo))
						onBankSteps.chooseDelOwnBankDetail(accountNo);
				}

				if (!accountNo.isEmpty()) {
					onBankSteps.addBankDetail();

					int rowIndex = onBankSteps.countRowTb();

					onBankSteps.typeAccountNo(accountNo, rowIndex);

					if (!branchCode.isEmpty()) {
						onBankSteps.typeBranchCode(branchCode, rowIndex);
					}
					if (!currencyCode.isEmpty()) {
						onBankSteps.typeCurrencyCode(currencyCode, rowIndex);
					}
					if (!bankGLAN.isEmpty()) {
						onBankSteps.typeBankGLAN(bankGLAN, rowIndex);
					}
					if (!lastChequeNo.isEmpty()) {
						onBankSteps.typeLastChequeNo(lastChequeNo, rowIndex);
					}
					if (!combineBCinPayment.isEmpty()) {
						onBankSteps.chooseCombineBCinPayment(rowIndex);
					}
					if (!combineBCinReceipt.isEmpty()) {
						onBankSteps.chooseCombineBCinReceipt(rowIndex);
					}
					if (del.toLowerCase().equals("y")) {
						onBankSteps.chooseDelOwnBankDetail(accountNo);
					}
				}
			}
			onBankSteps.switchOutDefaultIFrame();
		}
	}

	@When("bank is updated$")
	public void bank_is_updated() {
		if (isContinue) {
			onBankSteps.switchToIFrame();
			onBankSteps.clickOnUpdateButton();
			onBankSteps.switchOutDefaultIFrame();
		}
	}

	@Given("^user create new Bank$")
	public void user_create_new_Bank() {

		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hBankColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);
		int colPartyCode = hBankColName.get("Party Code");
		int colPartyName = hBankColName.get("Party Name");
		int colPartyShortName = hBankColName.get("Party Short Name");
		int colPartyGroupCode = hBankColName.get("Party Group Code");
		int colCountryOfIncorporation = hBankColName.get("Country Of Incorporation");
		int colMainHomePage = hBankColName.get("Main Home Page");
		int colTaxAgent = hBankColName.get("Tax Agent");
		int colGSTRegistrationNo = hBankColName.get("GST Registration No");
		int colUniqueEntityNo = hBankColName.get("Unique Entity No");
		int colPartyContraGLAN = hBankColName.get("Party Contra GLAN");
		int colContraRealizedExchGLAN = hBankColName.get("Contra Realized Exch GLAN");

		HashMap<String, Integer> hRelationServiceGroupColName = SessionData.getExcelColNameBySheetName(keyFileName,
				relationServiceGroupSheet);
		int colPartyRelation = hRelationServiceGroupColName.get("Party Relation");
		int colServiceType = hRelationServiceGroupColName.get("Service Type");

		HashMap<String, Integer> hOwnBankDetail = SessionData.getExcelColNameBySheetName(keyFileName, ownBankDetailSheet);
		int colAccountNo = hOwnBankDetail.get("Account No");
		int colBranchCode = hOwnBankDetail.get("Branch Code");
		int colCurrencyCode = hOwnBankDetail.get("Currency Code");
		int colBankGLAN = hOwnBankDetail.get("Bank GLAN");
		int colLastChequeNo = hOwnBankDetail.get("Last Cheque No");
		int colCombineBCinPayment = hOwnBankDetail.get("Combine BC in Payment");
		int colCombineBCinReceipt = hOwnBankDetail.get("Combine BC in Receipt");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colBankCompany = hCompanyColName.get("Bank");
		int colCompany = hCompanyColName.get("Company");

		String partyCode = "";
		String partyName = "";
		String partyShortName = "";
		String partyGroupCode = "";
		String countryOfIncorporation = "";
		String mainHomePage = "";
		String taxAgent = "";
		String gSTRegistrationNo = "";
		String uniqueEntityNo = "";
		String partyContraGLAN = "";
		String contraRealizedExchGLAN = "";

		String partyRelation = "";
		String serviceType = "";

		String accountNo = "";
		String branchCode = "";
		String currencyCode = "";
		String bankGLAN = "";
		String lastChequeNo = "";
		String combineBCinPayment = "";
		String combineBCinReceipt = "";

		String bankCompany = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);

		onBankSteps.switchToIFrame();

		for (Integer row : getDataset.keySet()) {
			partyCode = getDataset.get(row).get(colPartyCode);
			partyName = getDataset.get(row).get(colPartyName);
			partyShortName = getDataset.get(row).get(colPartyShortName);
			partyGroupCode = getDataset.get(row).get(colPartyGroupCode);
			countryOfIncorporation = getDataset.get(row).get(colCountryOfIncorporation);
			mainHomePage = getDataset.get(row).get(colMainHomePage);
			taxAgent = getDataset.get(row).get(colTaxAgent);
			gSTRegistrationNo = getDataset.get(row).get(colGSTRegistrationNo);
			uniqueEntityNo = getDataset.get(row).get(colUniqueEntityNo);
			partyContraGLAN = getDataset.get(row).get(colPartyContraGLAN);
			contraRealizedExchGLAN = getDataset.get(row).get(colContraRealizedExchGLAN);

			onBankSteps.addBank();
			if (!partyCode.isEmpty()) {
				onBankSteps.typePartyCode(partyCode);
				// onBankSteps.updateBank(partyCode);
			}
			if (!partyName.isEmpty()) {
				onBankSteps.typePartyName(partyName);
			}
			if (!partyShortName.isEmpty()) {
				onBankSteps.typePartyShortName(partyShortName);
			}
			if (!partyGroupCode.isEmpty()) {
				onBankSteps.typePartyGroupCode(partyGroupCode);
			}
			if (!countryOfIncorporation.isEmpty()) {
				onBankSteps.typeCountryOfIncorporation(countryOfIncorporation);
			}
			if (!mainHomePage.isEmpty()) {
				onBankSteps.typeMainHomePage(mainHomePage);
			}
			if (!taxAgent.isEmpty()) {
				onBankSteps.chooseTaxAgent(taxAgent);
			}
			if (!gSTRegistrationNo.isEmpty()) {
				onBankSteps.typeGSTRegistrationNo(gSTRegistrationNo);
			}
			if (!uniqueEntityNo.isEmpty()) {
				onBankSteps.typeUniqueEntityNo(uniqueEntityNo);
			}
			if (!partyContraGLAN.isEmpty()) {
				onBankSteps.typePartyContraGLAN(partyContraGLAN);
			}
			if (!contraRealizedExchGLAN.isEmpty()) {
				onBankSteps.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
			}

			onBankSteps.moveToRelationServiceGroupTab();
			LinkedHashMap<Integer, List<String>> getRelationServiceGroup = SessionData
					.getExcelSheetDataNoHeader(keyFileName, relationServiceGroupSheet);
			for (Integer rowRelationServiceGroup : getRelationServiceGroup.keySet()) {
				partyRelation = getRelationServiceGroup.get(rowRelationServiceGroup).get(colPartyRelation);
				serviceType = getRelationServiceGroup.get(rowRelationServiceGroup).get(colServiceType);

				if (!partyRelation.isEmpty() && !serviceType.isEmpty()) {
					onBankSteps.chooseRelationService(partyRelation, serviceType);
				}
			}

			onBankSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetData(keyFileName, companySheet);
			for (Integer rowComp : getCompany.keySet()) {
				bankCompany = getCompany.get(rowComp).get(colBankCompany);
				if (bankCompany.equals(partyCode)) {
					company = getCompany.get(rowComp).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onBankSteps.checkAllCompany();
						break;
					} else
						onBankSteps.checkCompany(company);
				}
			}

			onBankSteps.clickOnUpdateButton();

			onBankSteps.moveToLocalInfoTab();
			onBankSteps.moveToOwnBankDetailTab();

			int rowIndex = 1;

			LinkedHashMap<Integer, List<String>> getOwnBankDetail = SessionData.getExcelSheetDataNoHeader(keyFileName,
					ownBankDetailSheet);
			for (Integer rowOwnBankDetail : getOwnBankDetail.keySet()) {
				accountNo = getOwnBankDetail.get(rowOwnBankDetail).get(colAccountNo);
				branchCode = getOwnBankDetail.get(rowOwnBankDetail).get(colBranchCode);
				currencyCode = getOwnBankDetail.get(rowOwnBankDetail).get(colCurrencyCode);
				bankGLAN = getOwnBankDetail.get(rowOwnBankDetail).get(colBankGLAN);
				lastChequeNo = getOwnBankDetail.get(rowOwnBankDetail).get(colLastChequeNo);
				combineBCinPayment = getOwnBankDetail.get(rowOwnBankDetail).get(colCombineBCinPayment);
				combineBCinReceipt = getOwnBankDetail.get(rowOwnBankDetail).get(colCombineBCinReceipt);

				onBankSteps.addBankDetail();

				if (!accountNo.isEmpty()) {
					onBankSteps.typeAccountNo(accountNo, rowIndex);
				}
				if (!branchCode.isEmpty()) {
					onBankSteps.typeBranchCode(branchCode, rowIndex);
				}
				if (!currencyCode.isEmpty()) {
					onBankSteps.typeCurrencyCode(currencyCode, rowIndex);
				}
				if (!bankGLAN.isEmpty()) {
					onBankSteps.typeBankGLAN(bankGLAN, rowIndex);
				}
				if (!lastChequeNo.isEmpty()) {
					onBankSteps.typeLastChequeNo(lastChequeNo, rowIndex);
				}
				if (!combineBCinPayment.isEmpty()) {
					onBankSteps.chooseCombineBCinPayment(rowIndex);
				}
				if (!combineBCinReceipt.isEmpty()) {
					onBankSteps.chooseCombineBCinReceipt(rowIndex);
				}

				rowIndex++;
			}
			onBankSteps.clickOnUpdateButton();
		}
		onBankSteps.switchOutDefaultIFrame();
	}
}
