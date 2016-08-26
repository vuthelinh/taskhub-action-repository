package com.synergix.maintenancesetup.financial.accounting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.mtsetup.financial.accounting.steps.MTFinancialYearPeriodSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTFinancialYearPeriodDefs {

	@Steps
	MTFinancialYearPeriodSteps onMTFinancialYearPeriodSteps;

	@Steps
	MenuNavigationSteps onMenuNavigationSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_MT_FINANCIAL_ACCOUNTTING + "MTFinancialYearPeriod.xls";
	String keyFileName = "MTFinancialYearPeriod";
	String financialYearPeriodSheet = "FinancialYearPeriod";

	@Given("^user set financial year period as \"([^\"]*)\"$")
	public void user_set_financial_year_period_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "FinancialPeriod";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colFinancialYear = "Financial Year";
		String colDescription = "Description";
		String colBeginDate = "Begin Date";
		String colEndDate = "End Date";
		String colNoOfPeriod = "No Of Period";

		for (int rowFinancialPeriod : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String financialYear = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colFinancialYear);
			String description = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colDescription);
			String beginDate = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colBeginDate);
			String endDate = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colEndDate);
			String noOfPeriod = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colNoOfPeriod);

			onMTFinancialYearPeriodSteps.clickOnNewBtn();

			if (!financialYear.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeFinancialYear(financialYear);

				if (!description.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeDescription(description);
				}
				if (!beginDate.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeBeginDate(beginDate);
				}
				if (!endDate.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeEndDate(endDate);
				}
				if (!noOfPeriod.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeNoOfPeriod(noOfPeriod);
				}

				onMTFinancialYearPeriodSteps.clickOnAutoGeneratePeriodBtn();
			}
		}
	}

	@Given("^user update financial year period as \"([^\"]*)\"$")
	public void user_update_financial_year_period_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "FinancialPeriod";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colFinancialYear = "Financial Year";
		String colDescription = "Description";
		String colBeginDate = "Begin Date";
		String colEndDate = "End Date";
		String colNoOfPeriod = "No Of Period";

		for (int rowFinancialPeriod : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String financialYear = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colFinancialYear);
			String description = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colDescription);
			String beginDate = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colBeginDate);
			String endDate = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colEndDate);
			String noOfPeriod = SessionData.getDataTbVal(dataTableKey, rowFinancialPeriod, colNoOfPeriod);

			onMTFinancialYearPeriodSteps.chooseDelFinancialYear(financialYear);

			onMTFinancialYearPeriodSteps.clickOnNewBtn();

			if (!financialYear.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeFinancialYear(financialYear);

				if (!description.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeDescription(description);
				}
				if (!beginDate.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeBeginDate(beginDate);
				}
				if (!endDate.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeEndDate(endDate);
				}
				if (!noOfPeriod.isEmpty()) {
					onMTFinancialYearPeriodSteps.typeNoOfPeriod(noOfPeriod);
				}

				onMTFinancialYearPeriodSteps.clickOnAutoGeneratePeriodBtn();
			}
		}
	}

	@When("^user create new financial year/period$")
	public void user_create_new_financial_year_period() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hFinancialYearPeriodColName = SessionData.getExcelColNameBySheetName(keyFileName,
				financialYearPeriodSheet);

		int colFinancialYear = hFinancialYearPeriodColName.get("Financial Year");
		int colDescription = hFinancialYearPeriodColName.get("Description");
		int colBeginDate = hFinancialYearPeriodColName.get("Begin Date");
		int colEndDate = hFinancialYearPeriodColName.get("End Date");
		int colNoOfPeriod = hFinancialYearPeriodColName.get("No Of Period");

		String financialYear = "";
		String description = "";
		String beginDate = "";
		String endDate = "";
		String noOfPeriod = "";

		LinkedHashMap<Integer, List<String>> getFinancialYearPeriod = SessionData.getExcelSheetDataNoHeader(keyFileName,
				financialYearPeriodSheet);
		for (Integer rowFinancialYearPeriod : getFinancialYearPeriod.keySet()) {
			financialYear = getFinancialYearPeriod.get(rowFinancialYearPeriod).get(colFinancialYear);
			description = getFinancialYearPeriod.get(rowFinancialYearPeriod).get(colDescription);
			beginDate = getFinancialYearPeriod.get(rowFinancialYearPeriod).get(colBeginDate);
			endDate = getFinancialYearPeriod.get(rowFinancialYearPeriod).get(colEndDate);
			noOfPeriod = getFinancialYearPeriod.get(rowFinancialYearPeriod).get(colNoOfPeriod);

			onMTFinancialYearPeriodSteps.clickOnNewBtn();
			if (!financialYear.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeFinancialYear(financialYear);
			}
			if (!description.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeDescription(description);
			}
			if (!beginDate.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeBeginDate(beginDate);
			}
			if (!endDate.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeEndDate(endDate);
			}
			if (!noOfPeriod.isEmpty()) {
				onMTFinancialYearPeriodSteps.typeNoOfPeriod(noOfPeriod);
			}

			onMTFinancialYearPeriodSteps.clickOnAutoGeneratePeriodBtn();
		}
		onMenuNavigationSteps.user_navigates_to_screen("Opening Balance>Financial Period Opening");
		onMTFinancialYearPeriodSteps.setCurrentYearPeriod(beginDate);

	}
}
