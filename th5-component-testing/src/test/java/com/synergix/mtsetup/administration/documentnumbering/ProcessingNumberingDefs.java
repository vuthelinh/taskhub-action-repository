package com.synergix.mtsetup.administration.documentnumbering;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.mtsetup.administration.documentnumbering.steps.ProcessingNumberingSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ProcessingNumberingDefs {

	@Steps
	ProcessingNumberingSteps PNSteps;

	@Then("^user selects Transaction in Processing Numbering as \"([^\"]*)\"$")
	public void user_selects_Transaction_in_Processing_Numbering_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("PROCESSING_NUMBERING_TRANSACTION", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PROCESSING_NUMBERING_TRANSACTION", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("PROCESSING_NUMBERING_TRANSACTION", row, "KEY");
			String sModuleCode = SessionData.getDataTbVal("PROCESSING_NUMBERING_TRANSACTION", row, "Module Code");
			String sModuleDesc = SessionData.getDataTbVal("PROCESSING_NUMBERING_TRANSACTION", row, "Module Desc");
			String sTransactionTypeCode = SessionData.getDataTbVal("PROCESSING_NUMBERING_TRANSACTION", row,
					"Transaction Type Code");
			String sTransactionTypeDesc = SessionData.getDataTbVal("PROCESSING_NUMBERING_TRANSACTION", row,
					"Transaction Type Desc");
			String sAutoNumber = SessionData.getDataTbVal("PROCESSING_NUMBERING_TRANSACTION", row, "Auto Number");
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			if (!sModuleCode.isEmpty()) {
				PNSteps.enter_module_code(sModuleCode);
			}
			if (!sModuleDesc.isEmpty()) {
				PNSteps.enter_module_desc(sModuleDesc);
			}
			if (!sTransactionTypeCode.isEmpty()) {
				PNSteps.enter_transaction_type_code(sTransactionTypeCode);
			}
			if (!sTransactionTypeDesc.isEmpty()) {
				PNSteps.enter_transaction_type_desc(sTransactionTypeDesc);
			}
			if (!sAutoNumber.isEmpty()) {
				PNSteps.set_first_result_auto_number(sAutoNumber);
			}
			PNSteps.select_first_result_module();
		}
	}

	@Then("^user maintains Numbering Scheme Code as \"([^\"]*)\"$")
	public void user_maintains_Numbering_Scheme_Code_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", dataTable);
		for (int row : SessionData
				.getDataTbRowsByValEqualInCol("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row, "KEY");
			String sNumberingSchemeCode = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Numbering Scheme Code");
			String sDescription = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Description");
			String sAutoNumber = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Auto Number");
			String sIsManualNumbering = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Is manual Numbering");
			String sLastNumber = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Last Number");
			String sPrefix = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row, "Prefix");
			String sSuffix = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row, "Suffix");
			String sFillCharacter = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Fill Character");
			String sMaximumLengthOfCode = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Maximum Length of Code");
			String sLengthOfCode = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Length of Code");
			String sAllowUserToOverwrite = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row,
					"Allow User to Overwrite");
			String sDeviceId = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_SCHEME_CODE", row, "Device ID");
			int rowAddedIndex = 0;
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			if (!sAutoNumber.isEmpty()) {
				PNSteps.set_ns_auto_number(sAutoNumber);
			}
			if (!sNumberingSchemeCode.isEmpty()) {
				PNSteps.click_btn_ns_add();
				String ret = PNSteps.enter_ns_numbering_scheme_code(sNumberingSchemeCode);
				if (ret == null || ret.contains("Duplicate scheme numbering key")) {
					rowAddedIndex = PNSteps.search_ns_numbering_scheme_code(sNumberingSchemeCode);
					assertThat(rowAddedIndex != 0).isTrue();
				} else {
					fail("***** Error ***** : Unhandle error: " + ret);
				}
			}
			if (!sDescription.isEmpty()) {
				PNSteps.enter_ns_description(rowAddedIndex, sDescription);
			}

			if (!sIsManualNumbering.isEmpty()) {
				PNSteps.set_ns_is_manual_numbering(rowAddedIndex, sIsManualNumbering);
			}
			//PNSteps.select_numbering_scheme_code(rowAddedIndex, sNumberingSchemeCode);
			PNSteps.select_numbering_scheme_code(sNumberingSchemeCode);
			PNSteps.switch_to_tab_numbering_scheme_maintenance();
			if (!sLengthOfCode.isEmpty()) {
				PNSteps.enter_ns_length_of_code(sLengthOfCode);
			}
			if (!sMaximumLengthOfCode.isEmpty()) {
				PNSteps.enter_ns_maximum_length_of_code(sMaximumLengthOfCode);
			}
			if (!sLastNumber.isEmpty()) {
				PNSteps.enter_ns_last_number(sLastNumber);
			}
			if (!sPrefix.isEmpty()) {
				PNSteps.enter_ns_prefix(sPrefix);
			}
			if (!sSuffix.isEmpty()) {
				PNSteps.enter_ns_suffix(sSuffix);
			}
			if (!sFillCharacter.isEmpty()) {
				PNSteps.enter_ns_fill_character(sFillCharacter);
			}
			if (!sAllowUserToOverwrite.isEmpty()) {
				PNSteps.set_ns_allow_user_to_overwrite(sAllowUserToOverwrite);
			}
			if (!sDeviceId.isEmpty()) {
				PNSteps.enter_ns_device_id(sDeviceId);
			}
		}
	}

	@Then("^user tags user to Numbering Scheme as \"([^\"]*)\"$")
	public void user_tags_user_to_Numbering_Scheme_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PROCESSING_NUMBERING_NUMBERING_USER", dataTable);
		PNSteps.switch_to_tab_tag_users_to_numbering_scheme();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PROCESSING_NUMBERING_NUMBERING_USER", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row, "KEY");
			String sUserIdFrom = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row, "User ID From");
			String sUserIdTo = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row, "User ID To");
			String sUserId = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row, "User ID");
			String sUserNameFrom = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row,
					"User Name From");
			String sUserNameTo = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row, "User Name To");
			String sUserName = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row, "User Name");
			String sEmployeeCode = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row,
					"Employee Code");
			String sEmployeeName = SessionData.getDataTbVal("PROCESSING_NUMBERING_NUMBERING_USER", row,
					"Employee Name");
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			// Case use user id
			if (!sUserIdFrom.isEmpty()) {
				PNSteps.enter_tag_user_user_id_from(sUserIdFrom);
				if (!sUserIdTo.isEmpty()) {
					PNSteps.enter_tag_user_user_id_to(sUserIdTo);
					PNSteps.click_btn_tag_user_insert();
				}
			} else {
				if (!sUserId.isEmpty()) {
					PNSteps.click_btn_tag_user_add();
					String ret = PNSteps.enter_tag_user_user_id(sUserId);
					if (ret == null || ret.contains("User already tagged")) {
						assertThat(PNSteps.search_tag_user_by_user_id(sUserId) != 0).isTrue();
					} else {
						fail("***** Error ***** : Unhandle error: " + ret);
					}
					// verify if need
					if (!sEmployeeCode.isEmpty()) {
						PNSteps.verify_tag_user_employee_code(sUserId, sEmployeeCode);
					}
					if (!sEmployeeName.isEmpty()) {
						PNSteps.verify_tag_user_employee_name(sUserId, sEmployeeName);
					}
				}
			}
			// Case use user name
			if (!sUserNameFrom.isEmpty()) {
				PNSteps.enter_tag_user_user_name_from(sUserNameFrom);
				if (!sUserNameTo.isEmpty()) {
					PNSteps.enter_tag_user_user_name_to(sUserNameTo);
					PNSteps.click_btn_tag_user_insert();
				}
			} else {
				if (!sUserName.isEmpty()) {
					PNSteps.click_btn_tag_user_add();
					String ret = PNSteps.enter_tag_user_user_name(sUserName);
					if (ret == null || ret.contains("User already tagged")) {
						if (!sUserId.isEmpty()) {
							assertThat(PNSteps.search_tag_user_by_user_id(sUserId) != 0).isTrue();
						}
					} else {
						fail("***** Error ***** : Unhandle error: " + ret);
					}
					// verify if need
					if (!sEmployeeCode.isEmpty() && !sUserId.isEmpty()) {
						PNSteps.verify_tag_user_employee_code(sUserId, sEmployeeCode);
					}
					if (!sEmployeeName.isEmpty() && !sUserId.isEmpty()) {
						PNSteps.verify_tag_user_employee_name(sUserId, sEmployeeName);
					}
				}
			}
		}
		PNSteps.click_btn_ns_close();
	}

	@Then("^user creates new Processing Numbering$")
	public void user_creates_new_Processing_Numbering() throws Throwable {
		String fixedData = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\dataset\\scm\\maintain_master_data\\ProcessingNumbering.xls";
		System.out.println(fixedData);
		creates_new_Processing_Numbering(fixedData);
	}

	@Then("^user creates new Processing Numbering as data in \"([^\"]*)\" file\\.$")
	public void user_create_new_Processing_Numbering_as_data_in_file(String _dataFilePath) throws Throwable {
		creates_new_Processing_Numbering(_dataFilePath);
	}

	public void creates_new_Processing_Numbering(String _dataFilePath) throws Throwable {
		// Add data to process
		
		SessionData.addExcelData("Processing Numbering", _dataFilePath);
		// Get col definition
		HashMap<String, Integer> hPNColNames = SessionData.getExcelColNameBySheetName("Processing Numbering",
				"Processing Numbering");
		// int colPNTestkey = hPNColNames.get("TestKey");
		int colPNModuleCode = hPNColNames.get("Module Code");
		int colPNModuleDesc = hPNColNames.get("Module Desc");
		int colPNTransactionTypeCode = hPNColNames.get("Transaction Type Code");
		int colPNTransactionTypeDesc = hPNColNames.get("Transaction Type Desc");
		int colPNAutoNumber = hPNColNames.get("Auto Number");
		int colPNNumberingSchemeCodeTestkey = hPNColNames.get("Numbering Scheme Code TestKey");

		// Declare store data variable
		// String sPNTestkey = "";
		String sPNModuleCode = "";
		String sPNModuleDesc = "";
		String sPNTransactionTypeCode = "";
		String sPNTransactionTypeDesc = "";
		String sPNAutoNumber = "";
		String sPNNumberingSchemeCodeTestkey = "";

		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> PNData = SessionData.getExcelDataRowsContainVal("Processing Numbering",
				"Processing Numbering", "TestKey", "KEY");

		// Execute all test data
		for (Integer keyPN : PNData.keySet()) {
			// Parse data
			// sPNTestkey = PNData.get(keyPN).get(colPNTestkey);
			sPNModuleCode = PNData.get(keyPN).get(colPNModuleCode);
			sPNModuleDesc = PNData.get(keyPN).get(colPNModuleDesc);
			sPNTransactionTypeCode = PNData.get(keyPN).get(colPNTransactionTypeCode);
			sPNTransactionTypeDesc = PNData.get(keyPN).get(colPNTransactionTypeDesc);
			sPNAutoNumber = PNData.get(keyPN).get(colPNAutoNumber);
			sPNNumberingSchemeCodeTestkey = PNData.get(keyPN).get(colPNNumberingSchemeCodeTestkey);
			// Do test
			// if (!sPNTestkey.isEmpty()) {
			// }
			if (!sPNModuleCode.isEmpty()) {
				PNSteps.enter_module_code(sPNModuleCode);
			}
			if (!sPNModuleDesc.isEmpty()) {
				PNSteps.enter_module_desc(sPNModuleDesc);
			}
			if (!sPNTransactionTypeCode.isEmpty()) {
				PNSteps.enter_transaction_type_code(sPNTransactionTypeCode);
			}
			if (!sPNTransactionTypeDesc.isEmpty()) {
				PNSteps.enter_transaction_type_desc(sPNTransactionTypeDesc);
			}
			if (!sPNAutoNumber.isEmpty()) {
				PNSteps.set_first_result_auto_number(sPNAutoNumber);
			}
			if (!sPNNumberingSchemeCodeTestkey.isEmpty()) {
				PNSteps.select_first_result_module();
				add_new_numbering_scheme_code(sPNNumberingSchemeCodeTestkey);
			}
			PNSteps.click_btn_ns_close();
		}
	}

	public void add_new_numbering_scheme_code(String sPNNumberingSchemeCodeTestkey) {
		// Get col definition
		HashMap<String, Integer> hNSColNames = SessionData.getExcelColNameBySheetName("Processing Numbering",
				"Numbering Scheme Maintenance");
		// int colNSTestkey = hNSColNames.get("TestKey");
		int colNSAutoNumber = hNSColNames.get("Auto Number");
		int colNSNumberingSchemeCode = hNSColNames.get("Numbering Scheme Code");
		int colNSDescription = hNSColNames.get("Description");
		int colNSIsManualNumbering = hNSColNames.get("Is manual Numbering");
		int colNSLastNumber = hNSColNames.get("Last Number");
		int colNSPrefix = hNSColNames.get("Prefix");
		int colNSSuffix = hNSColNames.get("Suffix");
		int colNSFillCharacter = hNSColNames.get("Fill Character");
		int colNSMaximumLengthOfCode = hNSColNames.get("Maximum Length of Code");
		int colNSLengthOfCode = hNSColNames.get("Length of Code");
		int colNSAllowUserToOverwrite = hNSColNames.get("Allow User to Overwrite");
		int colNSDeviceId = hNSColNames.get("Device ID");
		int colNSTagUsersToNumberingSchemeTestkey = hNSColNames.get("Tag Users To Numbering Scheme TestKey");
		// Declare variable to store data
		// String sNSTestkey = "";
		String sNSAutoNumber = "";
		String sNSNumberingSchemeCode = "";
		String sNSDescription = "";
		String sNSIsManualNumbering = "";
		String sNSLastNumber = "";
		String sNSPrefix = "";
		String sNSSuffix = "";
		String sNSFillCharacter = "";
		String sNSMaximumLengthOfCode = "";
		String sNSLengthOfCode = "";
		String sNSAllowUserToOverwrite = "";
		String sNSDeviceId = "";
		String sNSTagUsersToNumberingSchemeTestkey = "";
		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> NSData = SessionData.getExcelDataRowsEqualVal("Processing Numbering",
				"Numbering Scheme Maintenance", "TestKey", sPNNumberingSchemeCodeTestkey);
		if (NSData.size() == 0) {
			// fail.datanotfound
		}

		// Execute all test data
		for (Integer keyNS : NSData.keySet()) {
			// Parse data
			// sNSTestkey = NSData.get(keyNS).get(colNSTestkey);
			sNSAutoNumber = NSData.get(keyNS).get(colNSAutoNumber);
			sNSNumberingSchemeCode = NSData.get(keyNS).get(colNSNumberingSchemeCode);
			sNSDescription = NSData.get(keyNS).get(colNSDescription);
			sNSIsManualNumbering = NSData.get(keyNS).get(colNSIsManualNumbering);
			sNSLastNumber = NSData.get(keyNS).get(colNSLastNumber);
			sNSPrefix = NSData.get(keyNS).get(colNSPrefix);
			sNSSuffix = NSData.get(keyNS).get(colNSSuffix);
			sNSFillCharacter = NSData.get(keyNS).get(colNSFillCharacter);
			sNSMaximumLengthOfCode = NSData.get(keyNS).get(colNSMaximumLengthOfCode);
			sNSLengthOfCode = NSData.get(keyNS).get(colNSLengthOfCode);
			sNSAllowUserToOverwrite = NSData.get(keyNS).get(colNSAllowUserToOverwrite);
			sNSDeviceId = NSData.get(keyNS).get(colNSDeviceId);
			sNSTagUsersToNumberingSchemeTestkey = NSData.get(keyNS).get(colNSTagUsersToNumberingSchemeTestkey);

			// Do test
			// if (!sNSTestkey.isEmpty()) {
			// }
			int rowAddedIndex = 0;
			if (!sNSAutoNumber.isEmpty()) {
				PNSteps.set_ns_auto_number(sNSAutoNumber);
			}
			if (!sNSNumberingSchemeCode.isEmpty()) {
				PNSteps.click_btn_ns_add();
				rowAddedIndex = PNSteps.enter_ns_new_numbering_scheme_code(sNSNumberingSchemeCode);
				assertThat(rowAddedIndex != 0).isTrue();
			}

			if (rowAddedIndex != 0) {
				if (!sNSDescription.isEmpty()) {
					PNSteps.enter_ns_description(rowAddedIndex, sNSDescription);
				}
				if (!sNSIsManualNumbering.isEmpty()) {
					PNSteps.set_ns_is_manual_numbering(rowAddedIndex, sNSIsManualNumbering);
				}
				//PNSteps.select_numbering_scheme_code(rowAddedIndex, sNSNumberingSchemeCode);
				PNSteps.select_numbering_scheme_code(sNSNumberingSchemeCode);
				PNSteps.switch_to_tab_numbering_scheme_maintenance();
				if (!sNSLengthOfCode.isEmpty()) {
					PNSteps.enter_ns_length_of_code(sNSLengthOfCode);
				}
				if (!sNSMaximumLengthOfCode.isEmpty()) {
					PNSteps.enter_ns_maximum_length_of_code(sNSMaximumLengthOfCode);
				}
				if (!sNSLastNumber.isEmpty()) {
					PNSteps.enter_ns_last_number(sNSLastNumber);
				}
				if (!sNSPrefix.isEmpty()) {
					PNSteps.enter_ns_prefix(sNSPrefix);
				}
				if (!sNSSuffix.isEmpty()) {
					PNSteps.enter_ns_suffix(sNSSuffix);
				}
				if (!sNSFillCharacter.isEmpty()) {
					PNSteps.enter_ns_fill_character(sNSFillCharacter);
				}

				if (!sNSAllowUserToOverwrite.isEmpty()) {
					PNSteps.set_ns_allow_user_to_overwrite(sNSAllowUserToOverwrite);
				}
				if (!sNSDeviceId.isEmpty()) {
					PNSteps.enter_ns_device_id(sNSDeviceId);
				}
				if (!sNSTagUsersToNumberingSchemeTestkey.isEmpty()) {
					tag_new_user_to_numbering_scheme(sNSTagUsersToNumberingSchemeTestkey);
				}
			}
		}
	}

	public void tag_new_user_to_numbering_scheme(String sNSTagUsersToNumberingSchemeTestkey) {
		// Get col definition
		HashMap<String, Integer> hTUColNames = SessionData.getExcelColNameBySheetName("Processing Numbering",
				"Tag Users To Numbering Scheme");
		int colTUTestkey = hTUColNames.get("TestKey");
		int colTUUserIdFrom = hTUColNames.get("User ID From");
		int colTUUserIdTo = hTUColNames.get("User ID To");
		int colTUUserId = hTUColNames.get("User ID");
		int colTUUserNameFrom = hTUColNames.get("User Name From");
		int colTUUserNameTo = hTUColNames.get("User Name To");
		int colTUUserName = hTUColNames.get("User Name");
		int colTUEmployeeCode = hTUColNames.get("Employee Code");
		int colTUEmployeeName = hTUColNames.get("Employee Name");

		// Declare variable to store data
		String sTUTestkey = "";
		String sTUUserIdFrom = "";
		String sTUUserIdTo = "";
		String sTUUserId = "";
		String sTUUserNameFrom = "";
		String sTUUserNameTo = "";
		String sTUUserName = "";
		String sTUEmployeeCode = "";
		String sTUEmployeeName = "";

		// Get Data row mark with test key
		LinkedHashMap<Integer, List<String>> TUData = SessionData.getExcelDataRowsEqualVal("Processing Numbering",
				"Tag Users To Numbering Scheme", "TestKey", sNSTagUsersToNumberingSchemeTestkey);
		if (TUData.size() == 0) {
			// fail.datanotfound
		}
		PNSteps.switch_to_tab_tag_users_to_numbering_scheme();
		// Execute all test data
		for (Integer keyTU : TUData.keySet()) {
			// Parse data
			sTUTestkey = TUData.get(keyTU).get(colTUTestkey);
			sTUUserIdFrom = TUData.get(keyTU).get(colTUUserIdFrom);
			sTUUserIdTo = TUData.get(keyTU).get(colTUUserIdTo);
			sTUUserId = TUData.get(keyTU).get(colTUUserId);
			sTUUserNameFrom = TUData.get(keyTU).get(colTUUserNameFrom);
			sTUUserNameTo = TUData.get(keyTU).get(colTUUserNameTo);
			sTUUserName = TUData.get(keyTU).get(colTUUserName);
			sTUEmployeeCode = TUData.get(keyTU).get(colTUEmployeeCode);
			sTUEmployeeName = TUData.get(keyTU).get(colTUEmployeeName);

			// Do test
			if (!sTUTestkey.isEmpty()) {
			}
			// Case use user id
			if (!sTUUserIdFrom.isEmpty()) {
				PNSteps.enter_tag_user_user_id_from(sTUUserIdFrom);
				if (!sTUUserIdTo.isEmpty()) {
					PNSteps.enter_tag_user_user_id_to(sTUUserIdTo);
					PNSteps.click_btn_tag_user_insert();
				}
			} else {
				if (!sTUUserId.isEmpty()) {
					PNSteps.click_btn_tag_user_add();
					PNSteps.enter_tag_user_new_user_id(sTUUserId);
					// verify if need
					if (!sTUEmployeeCode.isEmpty()) {
						PNSteps.verify_tag_user_employee_code(sTUUserId, sTUEmployeeCode);
					}
					if (!sTUEmployeeName.isEmpty()) {
						PNSteps.verify_tag_user_employee_name(sTUUserId, sTUEmployeeName);
					}
				}
			}
			// Case use user name
			if (!sTUUserNameFrom.isEmpty()) {
				PNSteps.enter_tag_user_user_name_from(sTUUserNameFrom);
				if (!sTUUserNameTo.isEmpty()) {
					PNSteps.enter_tag_user_user_name_to(sTUUserNameTo);
					PNSteps.click_btn_tag_user_insert();
				}
			} else {
				if (!sTUUserName.isEmpty()) {
					PNSteps.click_btn_tag_user_add();
					PNSteps.enter_tag_user_new_user_name(sTUUserName);
					// verify if need
					if (!sTUEmployeeCode.isEmpty() && !sTUUserId.isEmpty()) {
						PNSteps.verify_tag_user_employee_code(sTUUserId, sTUEmployeeCode);
					}
					if (!sTUEmployeeName.isEmpty() && !sTUUserId.isEmpty()) {
						PNSteps.verify_tag_user_employee_name(sTUUserId, sTUEmployeeName);
					}
				}
			}
		}
	}
}
