package com.synergix.definition.pretest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.globalsetup.logistics.steps.ShipmentTermSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ShipmentTermDefs {

	@Steps
	ShipmentTermSteps shipmentTermSteps;

	@Then("^user maintains Shipment Term$")
	public void user_maintains_Shipment_Term(List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("MT_LG_SHIPMENT_TERM", dataTable);
		String sTemp1 = "";
		String sTemp2 = "";
		boolean isTagCompanyTab = false;
		for (int row : SessionData.getDataTbRowsNoHeader("MT_LG_SHIPMENT_TERM").keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row, "Shipment Mode");
			String sNextShipmentMode = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row + 1, "Shipment Mode");
			String sHoldingBayPeriod = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row, "Holding Bay Period");
			String sShipmentTermCode = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row, "Shipment Term Code");
			String sNextShipmentTermCode = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row + 1,
					"Shipment Term Code");
			String sDescription = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row, "Description");
			String sCompanyName = SessionData.getDataTbVal("MT_LG_SHIPMENT_TERM", row, "Company Name");
			int rowIndex = 0;
			if (sShipmentTermCode.isEmpty() || sShipmentMode.isEmpty()) {
				continue;
			}
			if (!sShipmentMode.equals(sTemp1) || !sShipmentMode.equals(sNextShipmentMode)) {
				shipmentTermSteps.select_shipment_mode(sShipmentMode);
			}
			if (!sHoldingBayPeriod.isEmpty()) {
				shipmentTermSteps.enter_holding_bay_period(sHoldingBayPeriod);
			}
			if (!sShipmentTermCode.isEmpty()) {
				if ((!sShipmentMode.equals(sTemp1)) || (!sShipmentTermCode.equals(sTemp2))) {
					shipmentTermSteps.switch_to_tab_shipment_term();
					isTagCompanyTab = false;
					shipmentTermSteps.click_btn_add();
					String ret = shipmentTermSteps.enter_new_shipment_term_code(sShipmentTermCode);
					if (ret.isEmpty() || ret.contains("Duplicate Shipment Term Code")) {
						rowIndex = shipmentTermSteps.get_row_index_by_shipment_term_code(sShipmentTermCode);
						assertThat(rowIndex != 0).isTrue();
					} else {
						fail("***** Error ***** : Unhandle error: " + ret);
					}
				}
				sTemp2 = sShipmentTermCode;
			}
			sTemp1 = sShipmentMode;

			if (!sDescription.isEmpty()) {
				if (isTagCompanyTab) {
					shipmentTermSteps.switch_to_tab_shipment_term();
					isTagCompanyTab = false;
				}
				rowIndex = shipmentTermSteps.get_row_index_by_shipment_term_code(sShipmentTermCode);
				assertThat(rowIndex != 0).isTrue();
				if (isTagCompanyTab) {
					shipmentTermSteps.switch_to_tab_shipment_term();
					isTagCompanyTab = false;
				}
				shipmentTermSteps.enter_description(rowIndex, sDescription);
			}
			if (!sCompanyName.isEmpty()) {
				if (!isTagCompanyTab) {
					shipmentTermSteps.switch_to_tab_company();
					isTagCompanyTab = true;
				}
				shipmentTermSteps.tag_company(sCompanyName);
			}
			if (!sShipmentTermCode.equals(sNextShipmentTermCode) || !sShipmentMode.equals(sNextShipmentMode)) {
				shipmentTermSteps.click_btn_update();
			}
		}
	}

	@Then("^user creates new Shipment Term$")
	public void user_creates_new_Global_Inventory_Class() throws Throwable {
		String fixedData = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\dataset\\scm\\maintain_master_data\\ShipmentTerm.xls";
		System.out.println(fixedData);
		creates_new_Shipment_Term(fixedData);
	}

	@Then("^user creates new Shipment Term as data in \"([^\"]*)\" file\\.$")
	public void user_create_new_Shipment_Term_as_data_in_file(String _dataFilePath) throws Throwable {
		creates_new_Shipment_Term(_dataFilePath);
	}

	public void creates_new_Shipment_Term(String _dataFilePath) throws Throwable {
		SessionData.addExcelData("Shipment Term", _dataFilePath);
		HashMap<String, Integer> hShipmentTermColNames = SessionData.getExcelColNameBySheetName("Shipment Term",
				"Shipment Term");
		int colTestKey_ShipmentTerm = hShipmentTermColNames.get("TestKey");
		int colShipmentMode = hShipmentTermColNames.get("Shipment Mode");
		int colHoldingBayPeriod = hShipmentTermColNames.get("Holding Bay Period");
		int colShipmentTermCode = hShipmentTermColNames.get("Shipment Term Code");
		int colDescription = hShipmentTermColNames.get("Description");
		int colCompanyKey = hShipmentTermColNames.get("Tag Company TestKey");

		HashMap<String, Integer> hCompanyColNames = SessionData.getExcelColNameBySheetName("Shipment Term", "Company Name");
		// int colTestKey_Company = hCompanyColNames.get("TestKey");
		int colCompany = hCompanyColNames.get("Company Name");

		// Store data variable
		String sTestKey_ShipmentTerm = "";
		String sShipmentMode = "";
		String sHoldingBayPeriod = "";
		String sShipmentTermCode = "";
		String sDescription = "";
		String sCompanyKey = "";
		// String sTestKey_Company = "";
		// String sCompany = "";

		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> TestData = SessionData.getExcelDataRowsContainVal("Shipment Term",
				"Shipment Term", "TestKey", "KEY");

		// Execute all test data
		for (Integer testkey : TestData.keySet()) {
			// Parse data
			sTestKey_ShipmentTerm = TestData.get(testkey).get(colTestKey_ShipmentTerm);
			sShipmentMode = TestData.get(testkey).get(colShipmentMode);
			sHoldingBayPeriod = TestData.get(testkey).get(colHoldingBayPeriod);
			sShipmentTermCode = TestData.get(testkey).get(colShipmentTermCode);
			sDescription = TestData.get(testkey).get(colDescription);
			sCompanyKey = TestData.get(testkey).get(colCompanyKey);
			// Do test
			shipmentTermSteps.switch_to_tab_shipment_term();
			if (sTestKey_ShipmentTerm.contains("KEY")) {
				shipmentTermSteps.select_shipment_mode(sShipmentMode);
				shipmentTermSteps.enter_holding_bay_period(sHoldingBayPeriod);
				int rowIndex = 0;
				shipmentTermSteps.switch_to_tab_shipment_term();
				shipmentTermSteps.click_btn_add();
				shipmentTermSteps.enter_new_shipment_term_code(sShipmentTermCode);
				rowIndex = shipmentTermSteps.get_row_index_by_shipment_term_code(sShipmentTermCode);
				if (!sDescription.isEmpty()) {
					shipmentTermSteps.enter_description(rowIndex, sDescription);
				}
				if (!sCompanyKey.equals("")) { // Tag company
					LinkedHashMap<Integer, List<String>> CompanyData = SessionData
							.getExcelDataRowsEqualVal("Shipment Term", "Company Name", "TestKey", sCompanyKey);
					if (CompanyData.size() == 0) {
						// fail.datanotfound
					}
					shipmentTermSteps.switch_to_tab_company();
					for (Integer key : CompanyData.keySet()) { // Tag company
						shipmentTermSteps.tag_company(CompanyData.get(key).get(colCompany));
					}
					shipmentTermSteps.click_btn_update();
				}
			}
		}
	}
}
