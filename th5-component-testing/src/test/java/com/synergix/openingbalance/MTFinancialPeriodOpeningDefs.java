package com.synergix.openingbalance;

import java.util.List;

import com.synergix.common.CONST;
import com.synergix.steps.FinancialPeriodOpeningSteps;
import com.synergix.utilities.MSExcelReader;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTFinancialPeriodOpeningDefs {

	@Steps
	FinancialPeriodOpeningSteps onFinancialPeriodOpeningSteps;

	static MSExcelReader FinancialPeriodOpeningExcel = new MSExcelReader(
			System.getProperty("user.dir") + CONST.FIN_OPENING_BALANCE + "FinancialPeriodOpening.xls");

	@When("^user set financial period opening with feature file$")
	public void user_set_financial_period_opening_with_feature_file(List<List<String>> dataTable) {
		String dataTableKey = "PeriodOpening";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colModuleCode = "Module Code";
		String colFinancialYear = "Financial Year";
		String colPeriod = "Period";

		for (int rowPeriodOpening : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String moduleCode = SessionData.getDataTbVal(dataTableKey, rowPeriodOpening, colModuleCode);
			String financialYear = SessionData.getDataTbVal(dataTableKey, rowPeriodOpening, colFinancialYear);
			String period = SessionData.getDataTbVal(dataTableKey, rowPeriodOpening, colPeriod);

			onFinancialPeriodOpeningSteps.typeYearAndPeriod(moduleCode, financialYear, period);
		}

	}

	@Given("^user set financial period opening$")
	public void user_set_financial_period_opening() {

		int totals = FinancialPeriodOpeningExcel.getRows(FinancialPeriodOpeningFile.DATASET_SHEET);
		for (int i = 1; i < totals; i++) {
			String module = FinancialPeriodOpeningInfor.getModule(i + 1);
			String year = FinancialPeriodOpeningInfor.getYear(i + 1);
			String period = FinancialPeriodOpeningInfor.getPeriod(i + 1);

			onFinancialPeriodOpeningSteps.typeYearAndPeriod(module, year, period);
		}
	}

	public class FinancialPeriodOpeningFile {
		public static final String DATASET_SHEET = "Financial Period Opening";
	}

	public static class FinancialPeriodOpeningInfor {

		public static String getModule(int rowIndex) {
			return FinancialPeriodOpeningExcel.getCellValue(FinancialPeriodOpeningFile.DATASET_SHEET, rowIndex, 1);
		}

		public static String getYear(int rowIndex) {
			return FinancialPeriodOpeningExcel.getCellValue(FinancialPeriodOpeningFile.DATASET_SHEET, rowIndex, 2);
		}

		public static String getPeriod(int rowIndex) {
			return FinancialPeriodOpeningExcel.getCellValue(FinancialPeriodOpeningFile.DATASET_SHEET, rowIndex, 3);
		}
	}
}
