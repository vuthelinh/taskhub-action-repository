package com.synergix.definition.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.mtsetup.administration.employee.steps.ApprovingOfficerSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ApprovingOfficerDefs {

	@Steps
	ApprovingOfficerSteps approvingOfficerSteps;

	@Then("^user selects Transaction in Approving Officer as \"([^\"]*)\"$")
	public void user_selects_Transaction_in_Approving_Officer_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("APPROVING_OFFICER_TRANS", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("APPROVING_OFFICER_TRANS", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("APPROVING_OFFICER_TRANS", row, "KEY");
			String sModuleCodeDesc = SessionData.getDataTbVal("APPROVING_OFFICER_TRANS", row, "Module Code Desc");
			String sTransactionTypeDesc = SessionData.getDataTbVal("APPROVING_OFFICER_TRANS", row,
					"Transaction Type Desc");
			String sApprovingMethod = SessionData.getDataTbVal("APPROVING_OFFICER_TRANS", row, "Approving Method");
			String sRejectRemarksMandatory = SessionData.getDataTbVal("APPROVING_OFFICER_TRANS", row,
					"Reject Remarks Mandatory");
			if (!sKey.isEmpty()) {
			}
			if (!sModuleCodeDesc.isEmpty()) {
				approvingOfficerSteps.filter_module_code_desc(sModuleCodeDesc);
			}
			if (!sTransactionTypeDesc.isEmpty()) {
				approvingOfficerSteps.filter_transaction_type_desc(sTransactionTypeDesc);
			}
			int rowIndex = 1;
			if (!sApprovingMethod.isEmpty()) {
				// Special case
				if (sTransactionTypeDesc.toLowerCase().equals("sales order")) {
					rowIndex = 2;
				}
				approvingOfficerSteps.select_approving_method(rowIndex, sApprovingMethod);
			}
			if (!sRejectRemarksMandatory.isEmpty()) {
				approvingOfficerSteps.select_reject_remarks_mandatory(rowIndex, sRejectRemarksMandatory);
			}
		}
	}

	@Then("^user adds Approving Officer as \"([^\"]*)\"$")
	public void user_adds_Approving_Officer_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("APPROVING_OFFICER", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("APPROVING_OFFICER", "KEY", dataKey).keySet()) {
			// String sKey = SessionData.getDataTbVal("APPROVING_OFFICER", row,
			// "KEY");
			String sApprovingMethod = SessionData.getDataTbVal("APPROVING_OFFICER", row, "Approving Method");
			String sApprovalHomeAmountLimitPerVoucher = SessionData.getDataTbVal("APPROVING_OFFICER", row,
					"Approval Home Amount Limit (Per Voucher)");
			String sApprovingOfficer = SessionData.getDataTbVal("APPROVING_OFFICER", row, "Approving Officer");
			String sEmployeeCode = SessionData.getDataTbVal("APPROVING_OFFICER", row, "Employee Code");
			String sOfficerForSingleSupplier = SessionData.getDataTbVal("APPROVING_OFFICER", row,
					"Officer For Single Supplier");

			switch (sApprovingMethod) {
			case "By Amount (1 Level by Value)":
				if (!sEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					assertTrue("Add approving officer",
							approvingOfficerSteps.add_approving_officer_by_employee_code(sEmployeeCode));
				}
				if (!sApprovalHomeAmountLimitPerVoucher.isEmpty()) {
					approvingOfficerSteps.enter_approval_home_amount_limit_per_voucher(sApprovingOfficer,
							sApprovalHomeAmountLimitPerVoucher, sOfficerForSingleSupplier);
				}
				break;
			case "By Approving Officer (1 Level by Value)":
				if (!sEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					assertTrue("Add approving officer",
							approvingOfficerSteps.add_approving_officer_by_employee_code(sEmployeeCode));
				}
				if (!sApprovingOfficer.isEmpty()) {
					approvingOfficerSteps.verify_adding_approving_officer(sApprovingOfficer);
				}
				break;
			case "Is SBU (1 Level by SBU by Value)":
				// TODO
				break;
			case "Is SBU & Multiple Level (All levels By SBU)":
				// TODO
				break;
			case "Is Hierarchical (Multiple Levels by Value)":
				// TODO
				break;
			case "Is SBU and Hierarchical (Multiple Levels by SBU by Value)":
				// TODO
				break;
			case "Is Layer (All Levels by different criteria at each level, e.g. Specific, Specific with Condition)":
				// TODO
				break;
			case "By Amount and System Role":
				// TODO
				break;
			case "By Amount, Item Type and Officer System Role":
				// TODO
				break;
			case "Is Combination (All Levels by SBU by Margin)":
				// TODO
				break;
			case "By Margin (1 Level by Value by Margin)":
				// TODO
				break;
			default:
				System.out.println("Approving Method is not define: " + sApprovingMethod);
				break;
			}
		}
	}

	@Then("^user creates new Approving Officer$")
	public void user_creates_new_Approving_Officer() throws Throwable {
		String fixedData = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\dataset\\scm\\maintain_master_data\\ApprovingOfficer.xls";
		System.out.println(fixedData);
		creates_new_Approving_Officer(fixedData);
	}

	@Then("^user creates new Approving Officer as data in \"([^\"]*)\" file\\.$")
	public void user_create_new_Approving_Officer_as_data_in_file(String _dataFilePath) throws Throwable {
		creates_new_Approving_Officer(_dataFilePath);
	}

	public void creates_new_Approving_Officer(String _dataFilePath) throws Throwable {
		SessionData.addExcelData("Approving Officer", _dataFilePath);
		HashMap<String, Integer> hAOColNames = SessionData.getExcelColNameBySheetName("Approving Officer",
				"Approving Officer");
		int colAOModuleCodeDesc = hAOColNames.get("Module Code Desc");
		int colAOTransactionTypeDesc = hAOColNames.get("Transaction Type Desc");
		int colAOApprovingMethod = hAOColNames.get("Approving Method");
		int colAORejectRemarksMandatory = hAOColNames.get("Reject Remarks Mandatory");
		int colAOSbuCode = hAOColNames.get("SBU Code");
		int colAOSbuDesc = hAOColNames.get("SBU Desc");
		int colAOEmployeeCode = hAOColNames.get("Employee Code");
		// int colAOEmployeeName = hAOColNames.get("Employee Name");
		int colAOApprovalHomeAmountLimitPerVoucher = hAOColNames.get("Approval Home Amount Limit (Per Voucher)");
		int colAOApprovingOfficer = hAOColNames.get("Approving Officer");
		int colAOMultipleLevelTestKey = hAOColNames.get("Multiple Level TestKey");
		int colAOLayerTestKey = hAOColNames.get("Layer TestKey");

		// Store data variable
		String sAOModuleCodeDesc = "";
		String sAOTransactionTypeDesc = "";
		String sAOApprovingMethod = "";
		String sAORejectRemarksMandatory = "";
		String sAOSbuCode = "";
		String sAOSbuDesc = "";
		String sAOEmployeeCode = "";
		// String sAOEmployeeName = "";
		String sAOApprovalHomeAmountLimitPerVoucher = "";
		String sAOApprovingOfficer = "";
		String sAOMultipleLevelTestKey = "";
		String sAOLayerTestKey = "";

		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> AOData = SessionData.getExcelDataRowsContainVal("Approving Officer",
				"Approving Officer", "TestKey", "KEY");
		// Execute all test data
		for (Integer keyAO : AOData.keySet()) {
			// Parse data
			sAOModuleCodeDesc = AOData.get(keyAO).get(colAOModuleCodeDesc);
			sAOTransactionTypeDesc = AOData.get(keyAO).get(colAOTransactionTypeDesc);
			sAOApprovingMethod = AOData.get(keyAO).get(colAOApprovingMethod);
			sAORejectRemarksMandatory = AOData.get(keyAO).get(colAORejectRemarksMandatory);
			sAOSbuCode = AOData.get(keyAO).get(colAOSbuCode);
			sAOSbuDesc = AOData.get(keyAO).get(colAOSbuDesc);
			sAOEmployeeCode = AOData.get(keyAO).get(colAOEmployeeCode);
			// sAOEmployeeName = AOData.get(keyAO).get(colAOEmployeeName);
			sAOApprovalHomeAmountLimitPerVoucher = AOData.get(keyAO).get(colAOApprovalHomeAmountLimitPerVoucher);
			sAOApprovingOfficer = AOData.get(keyAO).get(colAOApprovingOfficer);
			sAOMultipleLevelTestKey = AOData.get(keyAO).get(colAOMultipleLevelTestKey);
			sAOLayerTestKey = AOData.get(keyAO).get(colAOLayerTestKey);
			// Do test
			if (!sAOModuleCodeDesc.isEmpty()) {
				approvingOfficerSteps.filter_module_code_desc(sAOModuleCodeDesc);
			}
			if (!sAOTransactionTypeDesc.isEmpty()) {
				approvingOfficerSteps.filter_transaction_type_desc(sAOTransactionTypeDesc);
			}
			if (!sAOApprovingMethod.isEmpty()) {
				approvingOfficerSteps.select_approving_method(1, sAOApprovingMethod);
			}
			if (!sAORejectRemarksMandatory.isEmpty()) {
				approvingOfficerSteps.select_reject_remarks_mandatory(1, sAORejectRemarksMandatory);
			}
			if (!sAOModuleCodeDesc.isEmpty() || !sAOTransactionTypeDesc.isEmpty()) {
				approvingOfficerSteps.select_first_transaction();
			}
			if (sAOApprovingOfficer.isEmpty()) {
				sAOApprovingOfficer = sAOEmployeeCode;
			}
			switch (sAOApprovingMethod) {
			case "By Amount (1 Level by Value)":
				if (!sAOEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					approvingOfficerSteps.add_approving_officer_by_employee_code(sAOEmployeeCode);
				}
				if (!sAOApprovalHomeAmountLimitPerVoucher.isEmpty()) {
					approvingOfficerSteps.enter_approval_home_amount_limit_per_voucher(sAOApprovingOfficer,
							sAOApprovalHomeAmountLimitPerVoucher);
				}
				break;
			case "By Approving Officer (1 Level by Value)":
				if (!sAOEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					approvingOfficerSteps.add_approving_officer_by_employee_code(sAOEmployeeCode);
				}
				if (!sAOApprovingOfficer.isEmpty()) {
					approvingOfficerSteps.verify_adding_approving_officer(sAOApprovingOfficer);
				}
				break;
			case "Is SBU (1 Level by SBU by Value)":
				if (!sAOSbuCode.isEmpty()) {
					approvingOfficerSteps.filter_sbu_code(sAOSbuCode);
				}
				if (!sAOSbuDesc.isEmpty()) {
					approvingOfficerSteps.filter_sbu_desc(sAOSbuDesc);
				}
				if (!sAOSbuCode.isEmpty() || !sAOSbuDesc.isEmpty()) {
					approvingOfficerSteps.select_first_sbu();
				}
				if (!sAOEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					approvingOfficerSteps.add_approving_officer_by_employee_code(sAOEmployeeCode);
				}
				if (!sAOApprovingOfficer.isEmpty()) {
					approvingOfficerSteps.verify_adding_approving_officer_in_AOSbu(sAOApprovingOfficer);
				}
				break;
			case "Is SBU & Multiple Level (All levels By SBU)":
				if (!sAOSbuCode.isEmpty()) {
					approvingOfficerSteps.click_btn_multi_by_sbu_add();
					approvingOfficerSteps.enter_new_sbu_code(sAOSbuCode);
					approvingOfficerSteps.select_sbu_by_sbu_code(sAOSbuCode);
				}
				if (!sAOMultipleLevelTestKey.isEmpty()) {
					add_new_multiple_level(sAOMultipleLevelTestKey);
				}
				break;
			case "Is Hierarchical (Multiple Levels by Value)":
				if (!sAOEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					approvingOfficerSteps.add_approving_officer_by_employee_code(sAOEmployeeCode);
				}
				break;
			case "Is SBU and Hierarchical (Multiple Levels by SBU by Value)":
				if (!sAOSbuCode.isEmpty()) {
					approvingOfficerSteps.filter_sbu_code(sAOSbuCode);
				}
				if (!sAOSbuDesc.isEmpty()) {
					approvingOfficerSteps.filter_sbu_desc(sAOSbuDesc);
				}
				if (!sAOSbuCode.isEmpty() || !sAOSbuDesc.isEmpty()) {
					approvingOfficerSteps.select_first_sbu();
				}
				if (!sAOEmployeeCode.isEmpty()) {
					approvingOfficerSteps.click_btn_add();
					approvingOfficerSteps.add_approving_officer_by_employee_code(sAOEmployeeCode);
				}
				if (!sAOApprovingOfficer.isEmpty() && !sAOApprovalHomeAmountLimitPerVoucher.isEmpty()) {
					approvingOfficerSteps.enter_approval_home_amount_limit_per_voucher_sbu(sAOApprovingOfficer,
							sAOApprovalHomeAmountLimitPerVoucher);
				}
				break;
			case "Is Layer (All Levels by different criteria at each level, e.g. Specific, Specific with Condition)":
				if (!sAOLayerTestKey.isEmpty()) {
					add_new_layer_detail(sAOLayerTestKey);
				}
				break;
			case "By Amount and System Role":
				// TODO
				break;
			case "By Amount, Item Type and Officer System Role":
				// TODO
				break;
			case "Is Combination (All Levels by SBU by Margin)":
				// TODO
				break;
			case "By Margin (1 Level by Value by Margin)":
				// TODO
				break;
			default:
				System.out.println("Approving Method is not define: " + sAOApprovingMethod);
				break;
			}
		}
	}

	public void add_new_multiple_level(String sAOMultipleLevelTestKey) {
		// Multiple Level (All levels By SBU)
		HashMap<String, Integer> hMLColNames = SessionData.getExcelColNameBySheetName("Approving Officer", "Multiple Level");
		// TODO
		int colMLLevel = hMLColNames.get("Level");
		int colMLApprovingOfficer = hMLColNames.get("Approving Officer");
		// int colMLEmployeeName = hMLColNames.get("Employee Name");
		// Customer Information
		String sMLLevel = "";
		String sMLApprovingOfficer = "";
		// String sMLEmployeeName = "";

		LinkedHashMap<Integer, List<String>> MLData = SessionData.getExcelDataRowsEqualVal("Approving Officer",
				"Multiple Level", "TestKey", sAOMultipleLevelTestKey);
		if (MLData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer keyML : MLData.keySet()) {
			// Parse data
			sMLLevel = MLData.get(keyML).get(colMLLevel);
			sMLApprovingOfficer = MLData.get(keyML).get(colMLApprovingOfficer);
			// sMLEmployeeName = MLData.get(keyML).get(colMLEmployeeName);
			// Do test
			approvingOfficerSteps.click_btn_add_ao_in_multiple_level();
			approvingOfficerSteps.enter_mutiple_ao_level(sMLLevel);
			approvingOfficerSteps.enter_mutiple_ao_approving_officer(sMLApprovingOfficer);
		}
	}

	public void add_new_layer_detail(String sAOLayerTestKey) {
		HashMap<String, Integer> hLayerColNames = SessionData.getExcelColNameBySheetName("Approving Officer", "Layer");
		int colLayerLayer = hLayerColNames.get("Layer");
		int colLayerType = hLayerColNames.get("Type");
		int colLayerParameterDefinitionTestKey = hLayerColNames.get("Parameter Definition TestKey");

		// Store data variable
		String sLayerLayer = "";
		String sLayerType = "";
		String sLayerParameterDefinitionTestKey = "";
		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> LayerData = SessionData.getExcelDataRowsEqualVal("Approving Officer",
				"Layer", "TestKey", sAOLayerTestKey);
		if (LayerData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer keyLayer : LayerData.keySet()) {
			// Parse data
			sLayerLayer = LayerData.get(keyLayer).get(colLayerLayer);
			sLayerType = LayerData.get(keyLayer).get(colLayerType);
			sLayerParameterDefinitionTestKey = LayerData.get(keyLayer).get(colLayerParameterDefinitionTestKey);
			if (!sLayerLayer.isEmpty()) {
				approvingOfficerSteps.click_btn_add_layer();
				int layerRowIndex = approvingOfficerSteps.get_layer_row(sLayerLayer);
				if (!sLayerType.isEmpty()) {
					approvingOfficerSteps.select_layer_type(layerRowIndex, sLayerType);
				}
				approvingOfficerSteps.select_layer_detail(layerRowIndex);
			} else {
				continue;
			}

			if (!sLayerParameterDefinitionTestKey.isEmpty()) {
				add_new_parameter_definition(sLayerParameterDefinitionTestKey);
			}
		}
	}

	public void add_new_parameter_definition(String sLayerParameterDefinitionTestKey) {
		HashMap<String, Integer> hPDColNames = SessionData.getExcelColNameBySheetName("Approving Officer",
				"Parameter Definition");
		int colPDProjectCategory = hPDColNames.get("Project Category");
		int colPDProjectCategoryDescription = hPDColNames.get("Project Category Description");
		int colPDSbu = hPDColNames.get("SBU");
		int colPDSbuDesc = hPDColNames.get("SBU Desc");
		int colPDProjectType = hPDColNames.get("Project Type");
		int colPDProjectTypeDesc = hPDColNames.get("Project Type Desc");
		int colPDApprovingLevelsTestkey = hPDColNames.get("Approving Levels TestKey");
		// Store data variable
		String sPDProjectCategory = "";
		String sPDProjectCategoryDescription = "";
		String sPDSbu = "";
		String sPDSbuDesc = "";
		String sPDProjectType = "";
		String sPDProjectTypeDesc = "";
		String sPDApprovingLevelsTestkey = "";
		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> PDData = SessionData.getExcelDataRowsEqualVal("Approving Officer",
				"Parameter Definition", "TestKey", sLayerParameterDefinitionTestKey);
		if (PDData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer keyPD : PDData.keySet()) {
			// Parse data
			sPDProjectCategory = PDData.get(keyPD).get(colPDProjectCategory);
			sPDProjectCategoryDescription = PDData.get(keyPD).get(colPDProjectCategoryDescription);
			sPDSbu = PDData.get(keyPD).get(colPDSbu);
			sPDSbuDesc = PDData.get(keyPD).get(colPDSbuDesc);
			sPDProjectType = PDData.get(keyPD).get(colPDProjectType);
			sPDProjectTypeDesc = PDData.get(keyPD).get(colPDProjectTypeDesc);
			sPDApprovingLevelsTestkey = PDData.get(keyPD).get(colPDApprovingLevelsTestkey);
			// Do test
			if (!sPDProjectCategory.isEmpty()) {
				approvingOfficerSteps.click_btn_add_parameter_definition();
				approvingOfficerSteps.enter_new_param_defi_project_catagory(sPDProjectCategory);
			} else {
				continue;
			}
			if (!sPDProjectCategoryDescription.isEmpty()) {
				// TODOLATER: for verify only
			}
			if (!sPDSbu.isEmpty()) {
				approvingOfficerSteps.enter_new_param_defi_sbu(sPDSbu);
			}
			if (!sPDSbuDesc.isEmpty()) {
				// TODOLATER: for verify only
			}
			if (!sPDProjectType.isEmpty()) {
				approvingOfficerSteps.enter_new_param_defi_project_type(sPDProjectType);
			}
			if (!sPDProjectTypeDesc.isEmpty()) {
				// TODOLATER: for verify only
			}
			if (!sPDApprovingLevelsTestkey.isEmpty()) {
				approvingOfficerSteps.select_param_defi(sPDProjectCategory, sPDSbu, sPDProjectType);
				add_approving_level(sPDApprovingLevelsTestkey);
			}
		}
	}

	public void add_approving_level(String sPDApprovingLevelsTestkey) {
		HashMap<String, Integer> hALColNames = SessionData.getExcelColNameBySheetName("Approving Officer",
				"Approving Levels");
		int colALLevel = hALColNames.get("Level");
		int colALApprovalHomeAmtLimit = hALColNames.get("Approval Home Amt Limit (per Voucher)");
		int colALApprovingOfficerTestKey = hALColNames.get("Approving Officer TestKey");
		// Store data variable
		String sALLevel = "";
		String sALApprovalHomeAmtLimit = "";
		String sALApprovingOfficerTestKey = "";

		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> ALData = SessionData.getExcelDataRowsEqualVal("Approving Officer",
				"Approving Levels", "TestKey", sPDApprovingLevelsTestkey);
		if (ALData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer keyAL : ALData.keySet()) {
			// Parse data
			sALLevel = ALData.get(keyAL).get(colALLevel);
			sALApprovalHomeAmtLimit = ALData.get(keyAL).get(colALApprovalHomeAmtLimit);
			sALApprovingOfficerTestKey = ALData.get(keyAL).get(colALApprovingOfficerTestKey);

			// Do test
			if (!sALLevel.isEmpty()) {
				approvingOfficerSteps.click_btn_al_add();
				int currentRowIndex = approvingOfficerSteps.get_al_row_by_level(sALLevel);
				if (!sALApprovalHomeAmtLimit.isEmpty()) {
					approvingOfficerSteps.enter_al_approval_home_amt_limit(currentRowIndex, sALApprovalHomeAmtLimit);
				}
				if (!sALApprovingOfficerTestKey.isEmpty()) {
					approvingOfficerSteps.select_approving_levels_by_level(currentRowIndex);
					add_al_approving_officer(sALApprovingOfficerTestKey);
				}
			} else {
				continue;
			}

		}
	}

	public void add_al_approving_officer(String sALApprovingOfficerTestKey) {
		HashMap<String, Integer> hALAOColNames = SessionData.getExcelColNameBySheetName("Approving Officer",
				"AL Approving Officer");
		int colALAOEmployeeCode = hALAOColNames.get("Employee Code");
		int colALAOEmployeeName = hALAOColNames.get("Employee Name");
		// Store data variable
		String sALAOEmployeeCode = "";
		String sALAOEmployeeName = "";

		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> ALAOData = SessionData.getExcelDataRowsEqualVal("Approving Officer",
				"AL Approving Officer", "TestKey", sALApprovingOfficerTestKey);
		if (ALAOData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer keyALAO : ALAOData.keySet()) {
			// Parse data
			sALAOEmployeeCode = ALAOData.get(keyALAO).get(colALAOEmployeeCode);
			sALAOEmployeeName = ALAOData.get(keyALAO).get(colALAOEmployeeName);

			// Do test
			if (!sALAOEmployeeCode.isEmpty()) {
				approvingOfficerSteps.click_btn_al_ao_add();
				approvingOfficerSteps.enter_al_ao_new_employee_code(sALAOEmployeeCode);
			} else {
				continue;
			}
			if (!sALAOEmployeeName.isEmpty()) {
				// TODOLATER forverify only
			}

		}
	}
}
