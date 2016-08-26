package com.synergix.maintenancesetup.financial.accounting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.mtsetup.financial.accounting.steps.MTGLRevaluationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTGLRevaluationDefs {

	@Steps
	MTGLRevaluationSteps onMTGLRevaluationSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_MT_FINANCIAL_ACCOUNTTING + "MTGLRevaluation.xls";
	String keyFileName = "MTGLRevaluation";
	String datasetSheet = "Dataset";

	@When("^user create GL revaluation$")
	public void user_create_GL_revaluation(List<List<String>> dataTable) {
		String dataTableKey = "MTGLRevaluation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colGLAccountCode = "GL Account Code";
		String colDescription = "Description";
		String colUnrealisedGainLossGLAN = "Unrealised Gain Loss GLAN";

		for (int rowMTGLRevaluation : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowMTGLRevaluation, colGLAccountCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowMTGLRevaluation, colDescription);
			String unrealisedGainLossGLAN = SessionData.getDataTbVal(dataTableKey, rowMTGLRevaluation,
					colUnrealisedGainLossGLAN);

			onMTGLRevaluationSteps.clickOnNewBtn();
			if (!gLAccountCode.isEmpty()) {
				onMTGLRevaluationSteps.typeGLAccountCode(gLAccountCode);
			}
			if (!description.isEmpty()) {
				onMTGLRevaluationSteps.typeDescription(description);
			}
			if (!unrealisedGainLossGLAN.isEmpty()) {
				onMTGLRevaluationSteps.typeUnrealisedGainLossGLAN(unrealisedGainLossGLAN);
			}
		}
	}

	@When("^user delete GL revaluation$")
	public void user_delete_GL_revaluation(List<List<String>> dataTable) {
		String dataTableKey = "DelMTGLRevaluation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colGLAccountCode = "GL Account Code";

		for (int rowMTGLRevaluation : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowMTGLRevaluation, colGLAccountCode);

			if (!gLAccountCode.isEmpty()) {
				onMTGLRevaluationSteps.deleteValueBySearchBtn(gLAccountCode);
			}

		}
	}

	@When("^user set GL revaluation$")
	public void user_set_GL_revaluation() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hDatasetColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colGLAccountCode = hDatasetColName.get("GL Account Code");
		int colDescription = hDatasetColName.get("Description");
		int colUnrealisedGainLossGLAN = hDatasetColName.get("Unrealised Gain Loss GLAN");

		String gLAccountCode = "";
		String description = "";
		String unrealisedGainLossGLAN = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);
		for (Integer rowDataset : getDataset.keySet()) {
			gLAccountCode = getDataset.get(rowDataset).get(colGLAccountCode);
			description = getDataset.get(rowDataset).get(colDescription);
			unrealisedGainLossGLAN = getDataset.get(rowDataset).get(colUnrealisedGainLossGLAN);

			onMTGLRevaluationSteps.clickOnNewBtn();
			if (!gLAccountCode.isEmpty()) {
				onMTGLRevaluationSteps.typeGLAccountCode(gLAccountCode);
			}
			if (!description.isEmpty()) {
				onMTGLRevaluationSteps.typeDescription(description);
			}
			if (!unrealisedGainLossGLAN.isEmpty()) {
				onMTGLRevaluationSteps.typeUnrealisedGainLossGLAN(unrealisedGainLossGLAN);
			}
		}
		onMTGLRevaluationSteps.clickOnCloseBtn();
	}
}
