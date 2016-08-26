package com.synergix.mastersetup.finance.fixedasset;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.fixedasset.steps.ClassSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLFAClassDefs {

	@Steps
	ClassSteps onClassSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_FIXED_ASSET + "Class.xls";
	String keyFileName = "Class";
	String classSheet = "Class";
	String companySheet = "Company";

	@When("^user creates fixed asset class as \"([^\"]*)\"$")
	public void user_creates_fixed_asset_class_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "FAClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYFA = "KEY FA";
		String colFixedAssetClassCode = "Fixed Asset Class Code";
		String colDescription = "Description";
		String colFixedAssetGLAN = "Fixed Asset GLAN";
		String colDepreciationGLAN = "Depreciation GLAN";
		String colCumulativeDepreciationGLAN = "Cumulative Depreciation GLAN";
		String colGainLossDisposalGLAN = "Gain Loss Disposal GLAN";
		String colDisposalClearingGLAN = "Disposal Clearing GLAN";
		String colFixedAssetClearingGLAN = "Fixed Asset Clearing GLAN";
		String colProjectUtilizationGlan = "Project Utilization Glan";
		String colCompany = "Company";

		onClassSteps.switchToIFrame();

		for (int rowFAClass : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYFA, dataKey).keySet()) {
			String fixedAssetClassCode = SessionData.getDataTbVal(dataTableKey, rowFAClass, colFixedAssetClassCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowFAClass, colDescription);
			String fixedAssetGLAN = SessionData.getDataTbVal(dataTableKey, rowFAClass, colFixedAssetGLAN);
			String depreciationGLAN = SessionData.getDataTbVal(dataTableKey, rowFAClass, colDepreciationGLAN);
			String cumulativeDepreciationGLAN = SessionData.getDataTbVal(dataTableKey, rowFAClass,
					colCumulativeDepreciationGLAN);
			String gainLossDisposalGLAN = SessionData.getDataTbVal(dataTableKey, rowFAClass, colGainLossDisposalGLAN);
			String disposalClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowFAClass, colDisposalClearingGLAN);
			String fixedAssetClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowFAClass,
					colFixedAssetClearingGLAN);
			String projectUtilizationGlan = SessionData.getDataTbVal(dataTableKey, rowFAClass,
					colProjectUtilizationGlan);
			String company = SessionData.getDataTbVal(dataTableKey, rowFAClass, colCompany);

			if (!fixedAssetClassCode.isEmpty()) {
				onClassSteps.clickOnNewBtn();
				onClassSteps.typeFixedAssetClassCode(fixedAssetClassCode);

				if (!description.isEmpty()) {
					onClassSteps.typeDescription(description);
				}
				if (!fixedAssetGLAN.isEmpty()) {
					onClassSteps.typeFixedAssetGLAN(fixedAssetGLAN);
				}
				if (!depreciationGLAN.isEmpty()) {
					onClassSteps.typeDepreciationGLAN(depreciationGLAN);
				}
				if (!cumulativeDepreciationGLAN.isEmpty()) {
					onClassSteps.typeCumulativeDepreciationGLAN(cumulativeDepreciationGLAN);
				}
				if (!gainLossDisposalGLAN.isEmpty()) {
					onClassSteps.typeGainLossDisposalGLAN(gainLossDisposalGLAN);
				}
				if (!disposalClearingGLAN.isEmpty()) {
					onClassSteps.typeDisposalClearingGLAN(disposalClearingGLAN);
				}
				if (!fixedAssetClearingGLAN.isEmpty()) {
					onClassSteps.typeFixedAssetClearingGLAN(fixedAssetClearingGLAN);
				}
				if (!projectUtilizationGlan.isEmpty()) {
					onClassSteps.typeProjectUtilizationGlan(projectUtilizationGlan);
				}
				if (company.trim().toLowerCase().equals("all")) {
					onClassSteps.checkAllCompany();
					break;
				} else
					onClassSteps.checkCompany(company);

				onClassSteps.clickOnUpdateButton();
			}
		}
		onClassSteps.switchOutDefaultIFrame();
	}

	@When("^user delete fixed asset class$")
	public void user_delete_fixed_asset_class(List<List<String>> dataTable) {
		String dataTableKey = "DelFAClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colFixedAssetClassCode = "Fixed Asset Class Code";

		onClassSteps.switchToIFrame();

		for (int rowFAClass : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String fixedAssetClassCode = SessionData.getDataTbVal(dataTableKey, rowFAClass, colFixedAssetClassCode);
			if (!fixedAssetClassCode.isEmpty()) {
				onClassSteps.clickOnNewBtn();
				onClassSteps.chooseDelFAClass(fixedAssetClassCode);
			}
		}
		onClassSteps.switchOutDefaultIFrame();
	}

	@Given("^user creates new fixed asset class$")
	public void user_create_new_fixed_asset_class() {

		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hClassColName = SessionData.getExcelColNameBySheetName(keyFileName, classSheet);
		int colKey = hClassColName.get("Key");
		int colFixedAssetClassCode = hClassColName.get("Fixed Asset Class Code");
		int colDescription = hClassColName.get("Description");
		int colFixedAssetGLAN = hClassColName.get("Fixed Asset GLAN");
		int colDepreciationGLAN = hClassColName.get("Depreciation GLAN");
		int colCumulativeDepreciationGLAN = hClassColName.get("Cumulative Depreciation GLAN");
		int colGainLossDisposalGLAN = hClassColName.get("Gain Loss Disposal GLAN");
		int colDisposalClearingGLAN = hClassColName.get("Disposal Clearing GLAN");
		int colFixedAssetClearingGLAN = hClassColName.get("Fixed Asset Clearing GLAN");
		int colProjectUtilizationGlan = hClassColName.get("Project Utilization Glan");

		String key = "";
		String fixedAssetClassCode = "";
		String description = "";
		String fixedAssetGLAN = "";
		String depreciationGLAN = "";
		String cumulativeDepreciationGLAN = "";
		String gainLossDisposalGLAN = "";
		String disposalClearingGLAN = "";
		String fixedAssetClearingGLAN = "";
		String projectUtilizationGlan = "";

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colKeyClass = hCompanyColName.get("Key");
		int colCompany = hCompanyColName.get("Company");

		String keyClass = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getClass = SessionData.getExcelSheetDataNoHeader(keyFileName, classSheet);

		onClassSteps.switchToIFrame();

		for (Integer rowClass : getClass.keySet()) {
			key = getClass.get(rowClass).get(colKey);
			fixedAssetClassCode = getClass.get(rowClass).get(colFixedAssetClassCode);
			description = getClass.get(rowClass).get(colDescription);
			fixedAssetGLAN = getClass.get(rowClass).get(colFixedAssetGLAN);
			depreciationGLAN = getClass.get(rowClass).get(colDepreciationGLAN);
			cumulativeDepreciationGLAN = getClass.get(rowClass).get(colCumulativeDepreciationGLAN);
			gainLossDisposalGLAN = getClass.get(rowClass).get(colGainLossDisposalGLAN);
			disposalClearingGLAN = getClass.get(rowClass).get(colDisposalClearingGLAN);
			fixedAssetClearingGLAN = getClass.get(rowClass).get(colFixedAssetClearingGLAN);
			projectUtilizationGlan = getClass.get(rowClass).get(colProjectUtilizationGlan);

			onClassSteps.clickOnNewBtn();
			if (!fixedAssetClassCode.isEmpty()) {
				onClassSteps.typeFixedAssetClassCode(fixedAssetClassCode);
			}
			if (!description.isEmpty()) {
				onClassSteps.typeDescription(description);
			}
			if (!fixedAssetGLAN.isEmpty()) {
				onClassSteps.typeFixedAssetGLAN(fixedAssetGLAN);
			}
			if (!depreciationGLAN.isEmpty()) {
				onClassSteps.typeDepreciationGLAN(depreciationGLAN);
			}
			if (!cumulativeDepreciationGLAN.isEmpty()) {
				onClassSteps.typeCumulativeDepreciationGLAN(cumulativeDepreciationGLAN);
			}
			if (!gainLossDisposalGLAN.isEmpty()) {
				onClassSteps.typeGainLossDisposalGLAN(gainLossDisposalGLAN);
			}
			if (!disposalClearingGLAN.isEmpty()) {
				onClassSteps.typeDisposalClearingGLAN(disposalClearingGLAN);
			}
			if (!fixedAssetClearingGLAN.isEmpty()) {
				onClassSteps.typeFixedAssetClearingGLAN(fixedAssetClearingGLAN);
			}
			if (!projectUtilizationGlan.isEmpty()) {
				onClassSteps.typeProjectUtilizationGlan(projectUtilizationGlan);
			}

			onClassSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					companySheet);
			for (Integer rowCompany : getCompany.keySet()) {
				keyClass = getCompany.get(rowCompany).get(colKeyClass);

				if (keyClass.equals(key)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onClassSteps.checkAllCompany();
						break;
					} else
						onClassSteps.checkCompany(company);
				}

			}
			onClassSteps.clickOnUpdateButton();
		}
		onClassSteps.switchOutDefaultIFrame();
	}
}
