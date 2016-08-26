package com.synergix.mastersetup.finance.accounting.accounting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.mtsetup.financial.accounting.steps.MTPeriodEndClosingSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTPeriodEndClosingDefs {

	@Steps
	MTPeriodEndClosingSteps onMTPeriodEndClosingSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_MT_FINANCIAL_ACCOUNTTING + "MTPeriodEndClosing.xls";
	String keyFileName = "MTPeriodEndClosing";
	String datasetSheet = "Dataset";

	@When("^user submit period end closing$")
	public void user_close_period(List<List<String>> dataTable) {
		String dataTableKey = "PeriodEndClosing";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colModuleCode = "Module Code";

		onMTPeriodEndClosingSteps.switchToIFrame();

		for (int rowPeriodEndClosing : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String moduleCode = SessionData.getDataTbVal(dataTableKey, rowPeriodEndClosing, colModuleCode);
			if (!moduleCode.isEmpty()) {
				onMTPeriodEndClosingSteps.chooseModuleCode(moduleCode);
			}
		}
		onMTPeriodEndClosingSteps.clickOnSubmitBtn();
		onMTPeriodEndClosingSteps.switchOutDefaultIFrame();
	}

	@When("^user close period$")
	public void user_close_period() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hDatasetColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colModuleCode = hDatasetColName.get("Module Code");
		String moduleCode = "";
		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);

		onMTPeriodEndClosingSteps.switchToIFrame();

		for (Integer rowDataset : getDataset.keySet()) {
			moduleCode = getDataset.get(rowDataset).get(colModuleCode);
			if (!moduleCode.isEmpty()) {
				onMTPeriodEndClosingSteps.chooseModuleCode(moduleCode);
			}
		}
		onMTPeriodEndClosingSteps.clickOnSubmitBtn();
		onMTPeriodEndClosingSteps.switchOutDefaultIFrame();
	}
}
