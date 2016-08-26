package com.synergix.globalsetup.financial.accounting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.common.LogWork;
import com.synergix.globalsetup.financial.accounting.steps.GLANSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLChartOfAccountDefs {

	@Steps
	GLANSteps onGLANSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_FINANCIAL + "ChartOfAcc.xls";
	String keyFileName = "ChartOfAcc";
	String datasetSheet = "Account";
	String companySheet = "Company";

	@When("^user create chart of account daily with company \"([^\"]*)\"$")
	public void user_create_chart_of_account_daily_with_company(String company, List<List<String>> dataTable) {
		String dataTableKey = "ChartOfAccount";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colGLAccountCode = "GL Account Code";
		String colDescription = "Description";
		String colAccountType = "Account Type";
		String colStatus = "Status";
		String colForSubLedgerAccount = "For Sub Ledger Account";
		String colCompany = "Company";

		if (!company.isEmpty()) {
			for (int rowChartOfAccount : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
				String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colGLAccountCode);
				String description = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colDescription);
				String accountType = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colAccountType);
				String status = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colStatus);
				String forSubLedgerAccount = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount,
						colForSubLedgerAccount);
				String company2 = company;

				onGLANSteps.addNewGLAN();
				if (!gLAccountCode.isEmpty()) {
					onGLANSteps.typeGLAccountCode("N" + gLAccountCode);

					if (!description.isEmpty()) {
						onGLANSteps.typeDescription("NOT USE- " + description);
					}
					if (!accountType.isEmpty()) {
						onGLANSteps.typeAccountType(accountType);
					}
					if (!status.isEmpty()) {
						onGLANSteps.typeStatus(status);
					}
					if (!forSubLedgerAccount.isEmpty()) {
						onGLANSteps.typeForSubLedgerAccount(forSubLedgerAccount);
					}

					onGLANSteps.moveToCompanyTab();
					if (company2.trim().toLowerCase().equals("all")) {
						onGLANSteps.checkAllCompany();
					} else {
						onGLANSteps.checkCompany(company);
					}
					onGLANSteps.update();
				}
			}
		} else {
			for (int rowChartOfAccount : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
				String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colGLAccountCode);
				String description = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colDescription);
				String accountType = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colAccountType);
				String status = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colStatus);
				String forSubLedgerAccount = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount,
						colForSubLedgerAccount);
				String company2 = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colCompany);

				onGLANSteps.addNewGLAN();
				if (!gLAccountCode.isEmpty()) {
					onGLANSteps.typeGLAccountCode("N" + gLAccountCode);

					if (!description.isEmpty()) {
						onGLANSteps.typeDescription(description);
					}
					if (!accountType.isEmpty()) {
						onGLANSteps.typeAccountType(accountType);
					}
					if (!status.isEmpty()) {
						onGLANSteps.typeStatus(status);
					}
					if (!forSubLedgerAccount.isEmpty()) {
						onGLANSteps.typeForSubLedgerAccount(forSubLedgerAccount);
					}

					onGLANSteps.moveToCompanyTab();
					if (company2.trim().toLowerCase().equals("all")) {
						onGLANSteps.checkAllCompany();
					} else {
						onGLANSteps.checkCompany(company);
					}

					onGLANSteps.update();
				}
			}
		}
	}

	@When("^user create chart of account with company \"([^\"]*)\"$")
	public void user_create_chart_of_account_with_company(String company, List<List<String>> dataTable) {

		String dataTableKey = "ChartOfAccount";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colGLAccountCode = "GL Account Code";
		String colDescription = "Description";
		String colAccountType = "Account Type";
		String colStatus = "Status";
		String colForSubLedgerAccount = "For Sub Ledger Account";
		String colCompany = "Company";

		if (!company.isEmpty()) {
			for (int rowChartOfAccount : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
				String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colGLAccountCode);

				if (!onGLANSteps.isExisted(gLAccountCode).isEmpty()) {

					String description = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colDescription);
					String accountType = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colAccountType);
					String status = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colStatus);
					String forSubLedgerAccount = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount,
							colForSubLedgerAccount);
					String company2 = company;

					onGLANSteps.addNewGLAN();
					if (!gLAccountCode.isEmpty()) {
						onGLANSteps.typeGLAccountCode(gLAccountCode);

						if (!description.isEmpty()) {
							onGLANSteps.typeDescription(description);
						}
						if (!accountType.isEmpty()) {
							onGLANSteps.typeAccountType(accountType);
						}

						onGLANSteps.typeDescription(description);
						if (!status.isEmpty()) {
							onGLANSteps.typeStatus(status);
						}
						if (!forSubLedgerAccount.isEmpty()) {
							onGLANSteps.typeForSubLedgerAccount(forSubLedgerAccount);
						}

						onGLANSteps.moveToCompanyTab();
						if (company2.trim().toLowerCase().equals("all")) {
							onGLANSteps.checkAllCompany();
						} else {
							onGLANSteps.checkCompany(company);
						}
						onGLANSteps.update();
					}
				}
			}
		} else {
			for (int rowChartOfAccount : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
				String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colGLAccountCode);

				if (onGLANSteps.isExisted(gLAccountCode).isEmpty()) {
					String description = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colDescription);
					String accountType = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colAccountType);
					String status = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colStatus);
					String forSubLedgerAccount = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount,
							colForSubLedgerAccount);
					String company2 = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colCompany);

					onGLANSteps.addNewGLAN();
					if (!gLAccountCode.isEmpty()) {
						onGLANSteps.typeGLAccountCode(gLAccountCode);

						if (!description.isEmpty()) {
							onGLANSteps.typeDescription(description);
						}
						if (!accountType.isEmpty()) {
							onGLANSteps.typeAccountType(accountType);
						}
						if (!status.isEmpty()) {
							onGLANSteps.typeStatus(status);
						}
						if (!forSubLedgerAccount.isEmpty()) {
							onGLANSteps.typeForSubLedgerAccount(forSubLedgerAccount);
						}

						onGLANSteps.moveToCompanyTab();
						if (company2.trim().toLowerCase().equals("all")) {
							onGLANSteps.checkAllCompany();
						} else {
							onGLANSteps.checkCompany(company);
						}
						onGLANSteps.update();
					}
				}
			}
		}
	}

	@When("^user delete chart of account daily$")
	public void user_delete_chart_of_account_daily(List<List<String>> dataTable) {
		String dataTableKey = "Del_ChartOfAccount";

		String colGLAccountCode = "GL Account Code";

		SessionData.addDataTable(dataTableKey, dataTable);

		for (int rowChartOfAccount : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colGLAccountCode);

			if (!gLAccountCode.isEmpty()) {
				onGLANSteps.chooseDelCOA("N" + gLAccountCode);
			}
		}
	}

	@When("^user delete chart of account$")
	public void user_delete_chart_of_account(List<List<String>> dataTable) {
		String dataTableKey = "Del_ChartOfAccount";

		String colGLAccountCode = "GL Account Code";

		SessionData.addDataTable(dataTableKey, dataTable);

		for (int rowChartOfAccount : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowChartOfAccount, colGLAccountCode);

			if (!gLAccountCode.isEmpty()) {
				onGLANSteps.chooseDelCOA(gLAccountCode);
			}
		}
	}

	@Given("^user create new GLAN$")
	public void user_create_new_GLAN() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hGLANColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colGLAccountCode = hGLANColName.get("GL Account Code");
		int colOperationCurrency = hGLANColName.get("Description");
		int colAccountType = hGLANColName.get("Account Type");
		int colStatus = hGLANColName.get("Status");
		int colForSubLedgerAccount = hGLANColName.get("For Sub Ledger Account");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colGLANCompany = hCompanyColName.get("GL Account Code");
		int colCompany = hCompanyColName.get("Company");

		String gLAccountCode = "";
		String operationCurrency = "";
		String accountType = "";
		String status = "";
		String forSubLedgerAccount = "";

		String GLANCompany = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);
		for (Integer row : getDataset.keySet()) {
			gLAccountCode = getDataset.get(row).get(colGLAccountCode);
			operationCurrency = getDataset.get(row).get(colOperationCurrency);
			accountType = getDataset.get(row).get(colAccountType);
			status = getDataset.get(row).get(colStatus);
			forSubLedgerAccount = getDataset.get(row).get(colForSubLedgerAccount);

			onGLANSteps.addNewGLAN();
			if (!gLAccountCode.isEmpty()) {
				onGLANSteps.typeGLAccountCode(gLAccountCode);
			}
			if (!operationCurrency.isEmpty()) {
				onGLANSteps.typeDescription(operationCurrency);
			}
			if (!accountType.isEmpty()) {
				onGLANSteps.typeAccountType(accountType);
			}
			if (!status.isEmpty()) {
				onGLANSteps.typeStatus(status);
			}
			if (!forSubLedgerAccount.isEmpty()) {
				onGLANSteps.typeForSubLedgerAccount(forSubLedgerAccount);
			}

			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					companySheet);
			onGLANSteps.moveToCompanyTab();
			for (Integer rowCompany : getCompany.keySet()) {
				GLANCompany = getCompany.get(rowCompany).get(colGLANCompany);

				if (GLANCompany.equals(gLAccountCode)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onGLANSteps.checkAllCompany();
					} else {
						onGLANSteps.checkCompany(company);
					}
				}
			}
			onGLANSteps.update();
		}
	}

	@When("^user update company GLAN$")
	public void user_update_GLAN() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hGLANColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colGLAccountCode = hGLANColName.get("GL Account Code");

		String gLAccountCode = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);
		for (Integer row : getDataset.keySet()) {
			gLAccountCode = getDataset.get(row).get(colGLAccountCode);

			if (!gLAccountCode.isEmpty()) {
				onGLANSteps.searchGLAN(gLAccountCode);
				onGLANSteps.update();
			}
		}
	}

	@When("^user create chart of account as \"([^\"]*)\"$")
	public void user_create_chart_of_account_as_key(String dataKey, List<List<String>> dataTable) {

		String dataTableKey = "glaccount";
		SessionData.addDataTable(dataTableKey, dataTable, false);

		for (int row : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, "KEY", dataKey).keySet()) {

			String colGLAccountCode = "GL Account Code";
			String colDescription = "Description";
			String colAccountType = "Account Type";
			String colStatus = "Status";
			String colForSubLedgerAccount = "For Sub Ledger Account";

			String gLAccountCode = SessionData.getDataTbVal(dataTableKey, row, colGLAccountCode);
			if (onGLANSteps.isExisted(gLAccountCode).isEmpty()) {
				String description = SessionData.getDataTbVal(dataTableKey, row, colDescription);
				String accountType = SessionData.getDataTbVal(dataTableKey, row, colAccountType);
				String status = SessionData.getDataTbVal(dataTableKey, row, colStatus);
				String forSubLedgerAccount = SessionData.getDataTbVal(dataTableKey, row, colForSubLedgerAccount);

				onGLANSteps.addNewGLAN();

				onGLANSteps.typeGLAccountCode(gLAccountCode);

				onGLANSteps.typeDescription(description);
				onGLANSteps.typeAccountType(accountType);
				onGLANSteps.typeStatus(status);
				onGLANSteps.typeForSubLedgerAccount(forSubLedgerAccount);
				onGLANSteps.update();
			}
		}
	}
}
