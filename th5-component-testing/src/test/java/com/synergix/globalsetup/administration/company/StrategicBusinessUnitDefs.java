package com.synergix.globalsetup.administration.company;

import java.util.LinkedHashMap;
import java.util.List;
import com.synergix.globalsetup.administration.company.steps.StrategicBusinessUnitSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StrategicBusinessUnitDefs {
	@Steps
	StrategicBusinessUnitSteps strategicBusinessUnitSteps;

	@Given("^user create SBU as \"([^\"]*)\"$")
	public void user_create_SBU_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("sbuDataTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("sbuDataTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSbuCode = SessionData.getDataTbVal("sbuDataTable", row, "SBU Code");
			String sDescription = SessionData.getDataTbVal("sbuDataTable", row, "Description");
			String sDetailedDescription = SessionData.getDataTbVal("sbuDataTable", row, "Detailed Description");
			String sCtiCode = SessionData.getDataTbVal("sbuDataTable", row, "CTI Code");
			String sGlobalStatus = SessionData.getDataTbVal("sbuDataTable", row, "Global Status");
			String sCompany = SessionData.getDataTbVal("sbuDataTable", row, "Company");

			if (!sSbuCode.isEmpty()) {
				strategicBusinessUnitSteps.click_btn_new();
				strategicBusinessUnitSteps.enter_sbu_code(sSbuCode);
			}
			if (!sDescription.isEmpty()) {
				strategicBusinessUnitSteps.enter_description(sDescription);
			}
			if (!sDetailedDescription.isEmpty()) {
				strategicBusinessUnitSteps.enter_detailed_description(sDetailedDescription);
			}
			if (!sCtiCode.isEmpty()) {
				strategicBusinessUnitSteps.enter_cti_code(sCtiCode);
			}
			if (!sGlobalStatus.isEmpty()) {
				strategicBusinessUnitSteps.select_global_status(sGlobalStatus);
			}
			if (!sCompany.isEmpty()) {
				strategicBusinessUnitSteps.choose_company(sCompany);
			}
		}
	}

	@Given("^user enters purchaser in charge as \"([^\"]*)\"$")
	public void user_enters_purchaser_in_charge_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("purchaserDataTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("purchaserDataTable", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPurchaserInCharge = SessionData.getDataTbVal("purchaserDataTable", row, "Purchaser in Charge");
			strategicBusinessUnitSteps.switch_tab_purchaser_in_charge();
			if (!sPurchaserInCharge.isEmpty()) {
				strategicBusinessUnitSteps.enter_purchaser_in_charge(sPurchaserInCharge);
			}
		}

	}

	@Given("^user enters inventory class as \"([^\"]*)\"$")
	public void user_enters_inventory_class(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("inventoryTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("inventoryTable", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sInventoryClass = SessionData.getDataTbVal("inventoryTable", row, "Inventory Class");
			String sDel = SessionData.getDataTbVal("inventoryTable", row, "Del");
			strategicBusinessUnitSteps.switch_tab_accessible_inventory();
			if (!sInventoryClass.isEmpty()) {
				strategicBusinessUnitSteps.click_btn_add_in_tab();
				int lastRowIndex = strategicBusinessUnitSteps.get_inventory_class_table_count_data_row();
				strategicBusinessUnitSteps.enter_inventory_class(sInventoryClass, lastRowIndex);

				if (!sDel.isEmpty()) {
					strategicBusinessUnitSteps.check_del(lastRowIndex);
				}
			}
		}
		strategicBusinessUnitSteps.update();
	}

	@When("^user search for the SBU as \"([^\"]*)\"$")
	public void user_search_for_the_SBU_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("searchSBUTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("searchSBUTable", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sSbuCode = SessionData.getDataTbVal("searchSBUTable", row, "SBU Code");

			if (!sSbuCode.isEmpty()) {
				strategicBusinessUnitSteps.search_sbu(sSbuCode);
			}
		}
	}

	@Then("^user should see the SBU as \"([^\"]*)\"$")
	public void user_should_see_the_SBU_as(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("sbuDataTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSbuCode = SessionData.getDataTbVal("sbuDataTable", row, "SBU Code");
			String sDescription = SessionData.getDataTbVal("sbuDataTable", row, "Description");
			String sDetailedDescription = SessionData.getDataTbVal("sbuDataTable", row, "Detailed Description");
			String sCtiCode = SessionData.getDataTbVal("sbuDataTable", row, "CTI Code");
			String sGlobalStatus = SessionData.getDataTbVal("sbuDataTable", row, "Global Status");

			if (!sSbuCode.isEmpty()) {
				strategicBusinessUnitSteps.verify_sbu_code(sSbuCode);
			}
			if (!sDescription.isEmpty()) {
				strategicBusinessUnitSteps.verify_sbu_description(sDescription);
			}
			if (!sDetailedDescription.isEmpty()) {
				strategicBusinessUnitSteps.verify_detailed_description(sDetailedDescription);
			}
			if (!sCtiCode.isEmpty()) {
				strategicBusinessUnitSteps.verify_cti_code(sCtiCode);
			}
			if (!sGlobalStatus.isEmpty()) {
				strategicBusinessUnitSteps.verify_global_status(sGlobalStatus);
			}
		}

		// Verify info in tab Purchaser in Charge
		testData = SessionData.getDataTbRowsByValEqualInCol("purchaserDataTable", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPurchaserInCharge = SessionData.getDataTbVal("purchaserDataTable", row, "Purchaser in Charge");
			strategicBusinessUnitSteps.switch_tab_purchaser_in_charge();
			if (!sPurchaserInCharge.isEmpty()) {
				strategicBusinessUnitSteps.verify_purchaser_in_charge(sPurchaserInCharge);
			}
		}

		// Verify info in tab Accessible Inventory
		testData = SessionData.getDataTbRowsByValEqualInCol("inventoryTable", "KEY", dataKey);
		int count = 1;
		for (int row : testData.keySet()) {
			String sInventoryClass = SessionData.getDataTbVal("inventoryTable", row, "Inventory Class");
			String sInventoryDescription = SessionData.getDataTbVal("inventoryTable", row, "Description");
			strategicBusinessUnitSteps.switch_tab_accessible_inventory();
			if (!sInventoryClass.isEmpty()) {
				strategicBusinessUnitSteps.verify_inventory_class(count, sInventoryClass);
				if (!sInventoryDescription.isEmpty()) {
					strategicBusinessUnitSteps.verify_inventory_description(count, sInventoryDescription);
				}
			}
		}

	}

	@When("^user deletes the SBU as \"([^\"]*)\"$")
	public void user_deletes_the_SBU_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("delSBUTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("delSBUTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSbuCode = SessionData.getDataTbVal("delSBUTable", row, "SBU Code");

			if (!sSbuCode.isEmpty()) {
				strategicBusinessUnitSteps.delete_sbu();

			}
		}
	}

	@Then("^user should not see the SBU with \"([^\"]*)\"$")
	public void user_should_not_see_the_SBU_with(String dataKey, List<List<String>> dataTable) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("delSBUTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSbuCode = SessionData.getDataTbVal("delSBUTable", row, "SBU Code");
			if (!sSbuCode.isEmpty()) {
				strategicBusinessUnitSteps.verify_sbu_code_not_found(sSbuCode);
			}
		}
	}
}