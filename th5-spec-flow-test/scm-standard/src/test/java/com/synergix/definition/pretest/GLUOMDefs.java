package com.synergix.definition.pretest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.inventory.steps.UOMSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLUOMDefs {
	@Steps
	UOMSteps onUOMSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_INVENTORY + "UnitOfMeasurement.xls";

	@When("^user create unit of measurement as \"([^\"]*)\"$")
	public void user_create_unit_of_measurement_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "UOM";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYUOM = "KEY UOM";
		String colUOMCode = "UOM Code";
		String colDescription = "Description";
		String colType = "Type";
		String colCompany = "Company";

		for (int rowUOM : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYUOM, dataKey).keySet()) {
			String uOMCode = SessionData.getDataTbVal(dataTableKey, rowUOM, colUOMCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowUOM, colDescription);
			String type = SessionData.getDataTbVal(dataTableKey, rowUOM, colType);
			String company = SessionData.getDataTbVal(dataTableKey, rowUOM, colCompany);

			if (!uOMCode.isEmpty()) {

				onUOMSteps.addUOM();
				onUOMSteps.typeUOMCode(uOMCode);

				if (!description.isEmpty()) {
					onUOMSteps.typeDescription(description);
				}
				if (!type.isEmpty()) {
					onUOMSteps.checkType(type);
				}
				onUOMSteps.moveToCompanyTab();
				if (company.toLowerCase().equals("all")) {
					onUOMSteps.checkAllCompany();
				} else
					onUOMSteps.checkCompany(company);
				
				onUOMSteps.update();
			}
		}
	}
	
	@When("^user maintains unit of measurement as \"([^\"]*)\"$")
	public void user_maintains_unit_of_measurement_as(String dataKey, List<List<String>> dataTable){
		String dataTableKey = "UOM";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYUOM = "KEY UOM";
		String colUOMCode = "UOM Code";
		String colDescription = "Description";
		String colType = "Type";
		String colCompany = "Company";

		for (int rowUOM : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYUOM, dataKey).keySet()) {
			String uOMCode = SessionData.getDataTbVal(dataTableKey, rowUOM, colUOMCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowUOM, colDescription);
			String type = SessionData.getDataTbVal(dataTableKey, rowUOM, colType);
			String company = SessionData.getDataTbVal(dataTableKey, rowUOM, colCompany);

			if (!uOMCode.isEmpty()) {
				if(!onUOMSteps.search_UOM(uOMCode)){
					onUOMSteps.addUOM();
					onUOMSteps.typeUOMCode(uOMCode);
				}				

				if (!description.isEmpty()) {
					onUOMSteps.typeDescription(description);
				}
				if (!type.isEmpty()) {
					onUOMSteps.checkType(type);
				}
				onUOMSteps.moveToCompanyTab();
				if (company.toLowerCase().equals("all")) {
					onUOMSteps.checkAllCompany();
				} else
					onUOMSteps.checkCompany(company);
				
				onUOMSteps.update();
			}
		}
	}

	@When("^user delete unit of measurement$")
	public void user_delete_unit_of_measurement(List<List<String>> dataTable) {
		String dataTableKey = "DelUOM";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colUOMCode = "UOM Code";
		for(int rowUOM : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String uOMCode = SessionData.getDataTbVal(dataTableKey, rowUOM, colUOMCode);

			if(!uOMCode.isEmpty()){
				onUOMSteps.chooseDelUOM(uOMCode);
			}
		}
	}

	@When("^user create new unit of measurement$")
	public void user_create_new_unit_of_measurement() {
		SessionData.addExcelData("UnitOfMeasurement", filePath);

		HashMap<String, Integer> sUOMColName = SessionData.getExcelColNameBySheetName("UnitOfMeasurement",
				"Unit of Measurement");
		int colUOMCode = sUOMColName.get("UOM Code");
		int colDescription = sUOMColName.get("Description");

		HashMap<String, Integer> sTypeColName = SessionData.getExcelColNameBySheetName("UnitOfMeasurement", "Type");
		int colUOMType = sTypeColName.get("UOM");
		int colType = sTypeColName.get("Type");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName("UnitOfMeasurement", "Company");
		int colUOMCompany = hCompanyColName.get("UOM");
		int colCompany = hCompanyColName.get("Company");

		String uOMCode = "";
		String description = "";
		String uOMType = "";
		String type = "";
		String uOMCompany = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader("UnitOfMeasurement",
				"Unit of Measurement");
		LinkedHashMap<Integer, List<String>> getType = SessionData.getExcelSheetDataNoHeader("UnitOfMeasurement",
				"Type");
		LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader("UnitOfMeasurement",
				"Company");

		for (Integer row : getDataset.keySet()) {
			uOMCode = getDataset.get(row).get(colUOMCode);
			description = getDataset.get(row).get(colDescription);

			onUOMSteps.addUOM();
			if (!uOMCode.isEmpty()) {
				onUOMSteps.typeUOMCode(uOMCode);
			}
			if (!description.isEmpty()) {
				onUOMSteps.typeDescription(description);
			}

			for (Integer rowType : getType.keySet()) {
				uOMType = getType.get(rowType).get(colUOMType);
				if (uOMType.trim().equals(uOMCode)) {
					type = getType.get(rowType).get(colType);
					onUOMSteps.checkType(type);
				}
			}

			onUOMSteps.moveToCompanyTab();
			for (Integer rowCompany : getCompany.keySet()) {
				uOMCompany = getCompany.get(rowCompany).get(colUOMCompany);
				if (uOMCompany.trim().equals(uOMCode)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onUOMSteps.checkAllCompany();
						break;
					} else
						onUOMSteps.checkCompany(company);
				}
			}

			onUOMSteps.update();
		}
	}

}
