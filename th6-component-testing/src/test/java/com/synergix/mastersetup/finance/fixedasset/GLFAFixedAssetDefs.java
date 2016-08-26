package com.synergix.mastersetup.finance.fixedasset;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.fixedasset.steps.FixedAssetSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLFAFixedAssetDefs {

	@Steps
	FixedAssetSteps onFixedAssetSteps;
	String filePath = System.getProperty("user.dir") + CONST.FIN_FIXED_ASSET + "FixedAsset.xls";
	String keyFileName = "FixedAsset";
	String fixedAssetSheet = "FixedAsset";
	String companySheet = "Company";

	@When("^user creates global fixed asset as \"([^\"]*)\"$")
	public void user_creates_global_fixed_asset_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "FA";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYFA = "KEY FA";
		String colFixedAssetCode = "Fixed Asset Code";
		String colDescription = "Description";
		String colDetailedSpecification = "Detailed Specification";
		String colFixedAssetClass = "Fixed Asset Class";
		String colFixedAssetCategory = "Fixed Asset Category";
		String colDepreciationMethod = "Depreciation Method";
		String colRateOnDecliningBalance = "Rate On Declining Balance";
		String colPercentageofStraightLineRate = "Percentage of Straight Line Rate";
		String colUsefulLifeYear = "Useful Life Year";
		String colUsefulLifePeriod = "Useful Life Period";
		String colTotalUsefulLife = "Total Useful Life";
		String colGlobalStatus = "Global Status";
		String colUOM = "UOM";
		String colVolume = "Volume";
		String colGrossWeight = "Gross Weight";
		String colLocation = "Location";
		String colLocalInfoStatus = "Local Info Status";
		String colCompany = "Company";

		onFixedAssetSteps.switchToIFrame();

		for (int rowFA : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYFA, dataKey).keySet()) {
			String fixedAssetCode = SessionData.getDataTbVal(dataTableKey, rowFA, colFixedAssetCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowFA, colDescription);
			String detailedSpecification = SessionData.getDataTbVal(dataTableKey, rowFA, colDetailedSpecification);
			String fixedAssetClass = SessionData.getDataTbVal(dataTableKey, rowFA, colFixedAssetClass);
			String fixedAssetCategory = SessionData.getDataTbVal(dataTableKey, rowFA, colFixedAssetCategory);
			String depreciationMethod = SessionData.getDataTbVal(dataTableKey, rowFA, colDepreciationMethod);
			String rateOnDecliningBalance = SessionData.getDataTbVal(dataTableKey, rowFA, colRateOnDecliningBalance);
			String percentageofStraightLineRate = SessionData.getDataTbVal(dataTableKey, rowFA,
					colPercentageofStraightLineRate);
			String usefulLifeYear = SessionData.getDataTbVal(dataTableKey, rowFA, colUsefulLifeYear);
			String usefulLifePeriod = SessionData.getDataTbVal(dataTableKey, rowFA, colUsefulLifePeriod);
			String totalUsefulLife = SessionData.getDataTbVal(dataTableKey, rowFA, colTotalUsefulLife);
			String globalStatus = SessionData.getDataTbVal(dataTableKey, rowFA, colGlobalStatus);
			String uOM = SessionData.getDataTbVal(dataTableKey, rowFA, colUOM);
			String volume = SessionData.getDataTbVal(dataTableKey, rowFA, colVolume);
			String grossWeight = SessionData.getDataTbVal(dataTableKey, rowFA, colGrossWeight);
			String location = SessionData.getDataTbVal(dataTableKey, rowFA, colLocation);
			String localInfoStatus = SessionData.getDataTbVal(dataTableKey, rowFA, colLocalInfoStatus);
			String company = SessionData.getDataTbVal(dataTableKey, rowFA, colCompany);

			if (!fixedAssetCode.isEmpty()) {
				onFixedAssetSteps.clickOnNewBtn();

				onFixedAssetSteps.typeFixedAssetCode(fixedAssetCode);

				if (!description.isEmpty()) {
					onFixedAssetSteps.typeDescription(description);
				}
				if (!detailedSpecification.isEmpty()) {
					onFixedAssetSteps.typeDetailedSpecification(detailedSpecification);
				}
				if (!fixedAssetClass.isEmpty()) {
					onFixedAssetSteps.typeFixedAssetClass(fixedAssetClass);
				}
				if (!fixedAssetCategory.isEmpty()) {
					onFixedAssetSteps.typeFixedAssetCategory(fixedAssetCategory);
				}
				if (!depreciationMethod.isEmpty()) {
					onFixedAssetSteps.chooseDepreciationMethod(depreciationMethod);
				}
				if (!rateOnDecliningBalance.isEmpty()) {
					onFixedAssetSteps.chooseRateOnDecliningBalance(rateOnDecliningBalance);
				}
				if (!percentageofStraightLineRate.isEmpty()) {
					onFixedAssetSteps.typePercentageofStraightLineRate(percentageofStraightLineRate);
				}
				if (!usefulLifeYear.isEmpty()) {
					onFixedAssetSteps.typeUsefulLifeYear(usefulLifeYear);
				}
				if (!usefulLifePeriod.isEmpty()) {
					onFixedAssetSteps.typeUsefulLifePeriod(usefulLifePeriod);
				}
				if (!totalUsefulLife.isEmpty()) {
					onFixedAssetSteps.typeTotalUsefulLife(totalUsefulLife);
				}
				if (!globalStatus.isEmpty()) {
					onFixedAssetSteps.chooseGlobalStatus(globalStatus);
				}
				if (!uOM.isEmpty()) {
					onFixedAssetSteps.typeUOM(uOM);
				}
				if (!volume.isEmpty()) {
					onFixedAssetSteps.typeVolume(volume);
				}
				if (!grossWeight.isEmpty()) {
					onFixedAssetSteps.typeGrossWeight(grossWeight);
				}
				if (!location.isEmpty()) {
					onFixedAssetSteps.typeLocation(location);
				}

				onFixedAssetSteps.moveToLocalInfoTab();
				if (!localInfoStatus.isEmpty()) {
					onFixedAssetSteps.chooseLocalInfoStatus(localInfoStatus);
				}

				if (company.toLowerCase().equals("all"))
					onFixedAssetSteps.checkAllCompany();
				else
					onFixedAssetSteps.checkCompany(company);

				onFixedAssetSteps.clickOnUpdateBtn();
			}
		}
		onFixedAssetSteps.switchOutDefaultIFrame();
	}

	@When("^user delete global fixed asset$")
	public void user_delete_global_fixed_asset(List<List<String>> dataTable) {
		String dataTableKey = "FA";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colFixedAssetCode = "Fixed Asset Code";

		onFixedAssetSteps.switchToIFrame();

		for (int rowFA : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String fixedAssetCode = SessionData.getDataTbVal(dataTableKey, rowFA, colFixedAssetCode);
			if (!fixedAssetCode.isEmpty()) {
				onFixedAssetSteps.clickOnNewBtn();
				onFixedAssetSteps.chooseDelFA(fixedAssetCode);
			}
		}
		onFixedAssetSteps.switchToIFrame();
	}

	@Given("^user creates new global fixed asset$")
	public void user_create_new_fixed_asset() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hFixedAssetColName = SessionData.getExcelColNameBySheetName(keyFileName, fixedAssetSheet);
		int colKey = hFixedAssetColName.get("Key");
		int colFixedAssetCode = hFixedAssetColName.get("Fixed Asset Code");
		int colDescription = hFixedAssetColName.get("Description");
		int colDetailedSpecification = hFixedAssetColName.get("Detailed Specification");
		int colFixedAssetClass = hFixedAssetColName.get("Fixed Asset Class");
		int colFixedAssetCategory = hFixedAssetColName.get("Fixed Asset Category");
		int colDepreciationMethod = hFixedAssetColName.get("Depreciation Method");
		int colRateOnDecliningBalance = hFixedAssetColName.get("Rate On Declining Balance");
		int colPercentageofStraightLineRate = hFixedAssetColName.get("Percentage of Straight Line Rate");
		int colUsefulLifeYear = hFixedAssetColName.get("Useful Life Year");
		int colUsefulLifePeriod = hFixedAssetColName.get("Useful Life Period");
		int colTotalUsefulLife = hFixedAssetColName.get("Total Useful Life");
		int colGlobalStatus = hFixedAssetColName.get("Global Status");
		int colUOM = hFixedAssetColName.get("UOM");
		int colVolume = hFixedAssetColName.get("Volume");
		int colGrossWeight = hFixedAssetColName.get("Gross Weight");
		int colLocation = hFixedAssetColName.get("Location");
		int colLocalInfoStatus = hFixedAssetColName.get("Local Info Status");

		String key = "";
		String fixedAssetCode = "";
		String description = "";
		String detailedSpecification = "";
		String fixedAssetClass = "";
		String fixedAssetCategory = "";
		String depreciationMethod = "";
		String rateOnDecliningBalance = "";
		String percentageofStraightLineRate = "";
		String usefulLifeYear = "";
		String usefulLifePeriod = "";
		String totalUsefulLife = "";
		String globalStatus = "";
		String uOM = "";
		String volume = "";
		String grossWeight = "";
		String location = "";
		String localInfoStatus = "";

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colKeyFA = hCompanyColName.get("Key");
		int colCompany = hCompanyColName.get("Company");

		String keyFA = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getFixedAsset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				fixedAssetSheet);

		onFixedAssetSteps.switchToIFrame();

		for (Integer rowFixedAsset : getFixedAsset.keySet()) {
			key = getFixedAsset.get(rowFixedAsset).get(colKey);
			fixedAssetCode = getFixedAsset.get(rowFixedAsset).get(colFixedAssetCode);
			description = getFixedAsset.get(rowFixedAsset).get(colDescription);
			detailedSpecification = getFixedAsset.get(rowFixedAsset).get(colDetailedSpecification);
			fixedAssetClass = getFixedAsset.get(rowFixedAsset).get(colFixedAssetClass);
			fixedAssetCategory = getFixedAsset.get(rowFixedAsset).get(colFixedAssetCategory);
			depreciationMethod = getFixedAsset.get(rowFixedAsset).get(colDepreciationMethod);
			rateOnDecliningBalance = getFixedAsset.get(rowFixedAsset).get(colRateOnDecliningBalance);
			percentageofStraightLineRate = getFixedAsset.get(rowFixedAsset).get(colPercentageofStraightLineRate);
			usefulLifeYear = getFixedAsset.get(rowFixedAsset).get(colUsefulLifeYear);
			usefulLifePeriod = getFixedAsset.get(rowFixedAsset).get(colUsefulLifePeriod);
			totalUsefulLife = getFixedAsset.get(rowFixedAsset).get(colTotalUsefulLife);
			globalStatus = getFixedAsset.get(rowFixedAsset).get(colGlobalStatus);
			uOM = getFixedAsset.get(rowFixedAsset).get(colUOM);
			volume = getFixedAsset.get(rowFixedAsset).get(colVolume);
			grossWeight = getFixedAsset.get(rowFixedAsset).get(colGrossWeight);
			location = getFixedAsset.get(rowFixedAsset).get(colLocation);
			localInfoStatus = getFixedAsset.get(rowFixedAsset).get(colLocalInfoStatus);

			onFixedAssetSteps.clickOnNewBtn();

			if (!fixedAssetCode.isEmpty()) {
				onFixedAssetSteps.typeFixedAssetCode(fixedAssetCode);
			}
			if (!description.isEmpty()) {
				onFixedAssetSteps.typeDescription(description);
			}
			if (!detailedSpecification.isEmpty()) {
				onFixedAssetSteps.typeDetailedSpecification(detailedSpecification);
			}
			if (!fixedAssetClass.isEmpty()) {
				onFixedAssetSteps.typeFixedAssetClass(fixedAssetClass);
			}
			if (!fixedAssetCategory.isEmpty()) {
				onFixedAssetSteps.typeFixedAssetCategory(fixedAssetCategory);
			}
			if (!depreciationMethod.isEmpty()) {
				onFixedAssetSteps.chooseDepreciationMethod(depreciationMethod);
			}
			if (!rateOnDecliningBalance.isEmpty()) {
				onFixedAssetSteps.chooseRateOnDecliningBalance(rateOnDecliningBalance);
			}
			if (!percentageofStraightLineRate.isEmpty()) {
				onFixedAssetSteps.typePercentageofStraightLineRate(percentageofStraightLineRate);
			}
			if (!usefulLifeYear.isEmpty()) {
				onFixedAssetSteps.typeUsefulLifeYear(usefulLifeYear);
			}
			if (!usefulLifePeriod.isEmpty()) {
				onFixedAssetSteps.typeUsefulLifePeriod(usefulLifePeriod);
			}
			if (!totalUsefulLife.isEmpty()) {
				onFixedAssetSteps.typeTotalUsefulLife(totalUsefulLife);
			}
			if (!globalStatus.isEmpty()) {
				onFixedAssetSteps.chooseGlobalStatus(globalStatus);
			}
			if (!uOM.isEmpty()) {
				onFixedAssetSteps.typeUOM(uOM);
			}
			if (!volume.isEmpty()) {
				onFixedAssetSteps.typeVolume(volume);
			}
			if (!grossWeight.isEmpty()) {
				onFixedAssetSteps.typeGrossWeight(grossWeight);
			}
			if (!location.isEmpty()) {
				onFixedAssetSteps.typeLocation(location);
			}

			onFixedAssetSteps.moveToLocalInfoTab();
			if (!localInfoStatus.isEmpty()) {
				onFixedAssetSteps.chooseLocalInfoStatus(localInfoStatus);
			}

			onFixedAssetSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					companySheet);
			for (Integer rowCompany : getCompany.keySet()) {
				keyFA = getCompany.get(rowCompany).get(colKeyFA);

				if (keyFA.equals(key)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.toLowerCase().equals("all"))
						onFixedAssetSteps.checkAllCompany();
					else
						onFixedAssetSteps.checkCompany(company);
				}
			}

			onFixedAssetSteps.clickOnUpdateBtn();
		}
		onFixedAssetSteps.switchOutDefaultIFrame();
	}
}
