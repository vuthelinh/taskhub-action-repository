package com.synergix.globalsetup.fixedasset;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.fixedasset.steps.CategorySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLFACategoryDefs {

	@Steps
	CategorySteps onCategorySteps;

	String keyFileName = "Category";
	String filePath = System.getProperty("user.dir") + CONST.FIN_FIXED_ASSET + "Category.xls";
	String categorySheet = "Category";
	String companySheet = "Company";

	@When("^user creates fixed asset category as \"([^\"]*)\"$")
	public void user_creates_fixed_asset_category_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "FACategory";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYFA = "KEY FA";
		String colFixedAssetCategoryCode = "Fixed Asset Category Code";
		String colDescription = "Description";
		String colCompany = "Company";

		for (int rowSupClass : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYFA, dataKey).keySet()) {
			String fixedAssetCategoryCode = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colFixedAssetCategoryCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowSupClass, colDescription);
			String company = SessionData.getDataTbVal(dataTableKey, rowSupClass, colCompany);

			if (!fixedAssetCategoryCode.isEmpty()) {
				onCategorySteps.clickOnNewBtn();
				onCategorySteps.typeFixedAssetCategoryCode(fixedAssetCategoryCode);

				if (!description.isEmpty()) {
					onCategorySteps.typeDescription(description);
				}

				if (company.trim().toLowerCase().equals("all")) {
					onCategorySteps.checkAllCompany();
				} else
					onCategorySteps.checkCompany(company);

				onCategorySteps.clickOnUpdateBtn();
			}
		}
	}

	@When("^user delete fixed asset category$")
	public void user_delete_fixed_asset_category(List<List<String>> dataTable) {
		String dataTableKey = "DelFACategory";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colFixedAssetCategoryCode = "Fixed Asset Category Code";

		for (int rowSupClass : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {

			String fixedAssetCategoryCode = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colFixedAssetCategoryCode);

			if (!fixedAssetCategoryCode.isEmpty()) {
				onCategorySteps.clickOnNewBtn();
				onCategorySteps.chooseDelCategory(fixedAssetCategoryCode);
			}
		}
	}
	
	@Given("^user creates new fixed asset category$")
	public void user_create_new_fixed_asset_category() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hCategoryColName = SessionData.getExcelColNameBySheetName(keyFileName, categorySheet);

		int colKey = hCategoryColName.get("Key");
		String key = "";

		int colFixedAssetCategoryCode = hCategoryColName.get("Fixed Asset Category Code");
		String fixedAssetCategoryCode = "";

		int colDescription = hCategoryColName.get("Description");
		String description = "";

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colKeyCategory = hCompanyColName.get("Key");
		String keyCategory = "";
		int colCompany = hCompanyColName.get("Company");
		String company = "";

		LinkedHashMap<Integer, List<String>> getCategory = SessionData.getExcelSheetDataNoHeader(keyFileName,
				categorySheet);
		for (Integer rowCategory : getCategory.keySet()) {
			key = getCategory.get(rowCategory).get(colKey);
			fixedAssetCategoryCode = getCategory.get(rowCategory).get(colFixedAssetCategoryCode);
			description = getCategory.get(rowCategory).get(colDescription);

			onCategorySteps.clickOnNewBtn();
			if (!fixedAssetCategoryCode.isEmpty()) {
				onCategorySteps.typeFixedAssetCategoryCode(fixedAssetCategoryCode);
			}
			if (!description.isEmpty()) {
				onCategorySteps.typeDescription(description);
			}

			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					companySheet);
			for (Integer rowCompany : getCompany.keySet()) {
				keyCategory = getCompany.get(rowCompany).get(colKeyCategory);

				if (keyCategory.equals(key)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onCategorySteps.checkAllCompany();
						break;
					} else
						onCategorySteps.checkCompany(company);
				}
			}
			onCategorySteps.clickOnUpdateBtn();
		}

	}
}
