package com.synergix.mastersetup.finance.fixedasset;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.fixedasset.steps.LocationStep;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLFALocationDefs {

	@Steps
	LocationStep onLocationSteps;

	String keyFileName = "Location";
	String filePath = System.getProperty("user.dir") + CONST.FIN_FIXED_ASSET + "Location.xls";
	String locationSheet = "Location";
	String companySheet = "Company";

	@When("^user creates fixed asset location as \"([^\"]*)\"$")
	public void user_creates_fixed_asset_location_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "FALocation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYFA = "KEY FA";
		String colFixedAssetLocationCode = "Fixed Asset Location Code";
		String colFixedAssetLocationName = "Fixed Asset Location Name";
		String colCompany = "Company";

		onLocationSteps.switchToIFrame();

		for (int rowFALocation : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYFA, dataKey).keySet()) {
			String fixedAssetLocationCode = SessionData.getDataTbVal(dataTableKey, rowFALocation,
					colFixedAssetLocationCode);
			String fixedAssetLocationName = SessionData.getDataTbVal(dataTableKey, rowFALocation,
					colFixedAssetLocationName);
			String company = SessionData.getDataTbVal(dataTableKey, rowFALocation, colCompany);

			if (!fixedAssetLocationCode.isEmpty()) {
				onLocationSteps.clickOnNewBtn();
				onLocationSteps.typeFixedAssetLocationCode(fixedAssetLocationCode);

				if (!fixedAssetLocationName.isEmpty()) {
					onLocationSteps.typeFixedAssetLocationName(fixedAssetLocationName);
				}

				if (company.trim().toLowerCase().equals("all")) {
					onLocationSteps.checkAllCompany();
				} else
					onLocationSteps.checkCompany(company);

				onLocationSteps.clickOnUpdateBtn();
			}
		}
		onLocationSteps.switchOutDefaultIFrame();
	}

	@When("^user delete fixed asset location$")
	public void user_delete_fixed_asset_location(List<List<String>> dataTable) {

		String colFixedAssetLocationCode = "Fixed Asset Location Code";
		String dataTableKey = "DelFALocation";
		SessionData.addDataTable(dataTableKey, dataTable);

		onLocationSteps.switchToIFrame();

		for (int rowFALocation : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String fixedAssetLocationCode = SessionData.getDataTbVal(dataTableKey, rowFALocation,
					colFixedAssetLocationCode);
			if (!fixedAssetLocationCode.isEmpty()) {
				onLocationSteps.clickOnNewBtn();
				onLocationSteps.chooseDelFALocation(fixedAssetLocationCode);
			}
		}
		onLocationSteps.switchOutDefaultIFrame();
	}

	@Given("^user creates new fixed asset location$")
	public void user_create_new_fixed_asset_location() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hLocationColName = SessionData.getExcelColNameBySheetName(keyFileName, locationSheet);
		int colKey = hLocationColName.get("Key");
		int colFixedAssetLocationCode = hLocationColName.get("Fixed Asset Location Code");
		int colFixedAssetLocationName = hLocationColName.get("Fixed Asset Location Name");

		String key = "";
		String fixedAssetLocationCode = "";
		String fixedAssetLocationName = "";

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colKeyLocation = hCompanyColName.get("Key");
		int colCompany = hCompanyColName.get("Company");
		String keyLocation = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getLocation = SessionData.getExcelSheetDataNoHeader(keyFileName,
				locationSheet);

		onLocationSteps.switchToIFrame();

		for (Integer rowLocation : getLocation.keySet()) {
			key = getLocation.get(rowLocation).get(colKey);
			fixedAssetLocationCode = getLocation.get(rowLocation).get(colFixedAssetLocationCode);
			fixedAssetLocationName = getLocation.get(rowLocation).get(colFixedAssetLocationName);

			onLocationSteps.clickOnNewBtn();
			if (!fixedAssetLocationCode.isEmpty()) {
				onLocationSteps.typeFixedAssetLocationCode(fixedAssetLocationCode);
			}
			if (!fixedAssetLocationName.isEmpty()) {
				onLocationSteps.typeFixedAssetLocationName(fixedAssetLocationName);
			}

			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					companySheet);
			for (Integer rowCompany : getCompany.keySet()) {
				keyLocation = getCompany.get(rowCompany).get(colKeyLocation);
				if (keyLocation.equals(key)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onLocationSteps.checkAllCompany();
						break;
					} else
						onLocationSteps.checkCompany(company);

				}
			}
			onLocationSteps.clickOnUpdateBtn();
		}
		onLocationSteps.switchOutDefaultIFrame();
	}
}
