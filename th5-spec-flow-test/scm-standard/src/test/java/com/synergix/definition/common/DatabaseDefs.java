package com.synergix.definition.common;

import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;

import com.synergix.common.CONST;
import com.synergix.common.steps.DBSteps;
import com.synergix.utilities.ConnectDatabase;
import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class DatabaseDefs {
	@Steps
	DBSteps DBStep;

	@Then("^user compares pulled out Excel file with Reference Excel file as \"([^\"]*)\"$")
	public void user_compares_pulled_out_Excel_file_with_Reference_Excel_file_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		// Constant
		String DB_PULL_OUT_FILE_NAME = "DB_PULL_OUT_FILE_NAME_";
		String DB_PULL_OUT_LIST_SHEET_NAME = "DB_PULL_OUT_LIST_SHEET_NAME_OF_";

		SessionData.addDataTable("ASSERT_PULL_OUT_EXCEL_WITH_REF_FILE", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("ASSERT_PULL_OUT_EXCEL_WITH_REF_FILE", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("ASSERT_PULL_OUT_EXCEL_WITH_REF_FILE", row, "KEY");
			String sOutputFileName = SessionData.getDataTbVal("ASSERT_PULL_OUT_EXCEL_WITH_REF_FILE", row,
					"Output File Name");
			String sReferenceFileName = SessionData.getDataTbVal("ASSERT_PULL_OUT_EXCEL_WITH_REF_FILE", row,
					"Reference File Name");
			String sChecksumDifference = SessionData.getDataTbVal("ASSERT_PULL_OUT_EXCEL_WITH_REF_FILE", row,
					"Checksum Difference");
			if (!sKey.isEmpty()) {
			}
			if (!sOutputFileName.isEmpty()) {
			}
			if (!sReferenceFileName.isEmpty()) {
			}
			// Set ref file name
			String excelPath = System.getProperty("user.dir") + CONST.PAYROLL;
			sReferenceFileName = excelPath + sReferenceFileName + ".xls";
			// Check create file name
			String sCreateFileName = Serenity.sessionVariableCalled(DB_PULL_OUT_FILE_NAME + sOutputFileName);
			if (sCreateFileName == null) {
				fail("***** FAIL ***** Output file name not found : [" + sOutputFileName + "]\n\r");
			}
			// compare 2 file
			int iTotalDifference = 0;
			iTotalDifference = compareExcelFileThenMark(sCreateFileName, sReferenceFileName);
			if (iTotalDifference != 0) {
				if (!sChecksumDifference.isEmpty()) {
					int iChecksumDifference = 0;
					try {
						iChecksumDifference = Integer.parseInt(sChecksumDifference);
					} catch (Exception e) {
						System.out.println("***** ERROR ***** Checksum value is not interger" + "\n\r");
					}
					if (iChecksumDifference == iTotalDifference) {
						System.out.println("***** WARNING ***** Output file [" + sCreateFileName
								+ "] is different with reference file [" + sReferenceFileName + "]\n\r");
					} else {
						fail("***** FAIL ***** Output file [" + sCreateFileName + "] is different with reference file ["
								+ sReferenceFileName + "]\n\r");
					}
				}
			} else {
				fail("***** FAIL ***** Output file [" + sCreateFileName + "] is different with reference file ["
						+ sReferenceFileName + "]\n\r");
			}
		}
	}

	public int compareExcelFileThenMark(String sourceFile, String targetFile) {
		int iCountFailed = 0;
		SessionData.addExcelData("SOURCE_EXCEL_FILE", sourceFile);
		SessionData.addExcelData("TARTGET_EXCEL_FILE", targetFile);
		HashMap<String, LinkedHashMap<Integer, List<String>>> sourceData = SessionData
				.getExcelData("SOURCE_EXCEL_FILE");
		HashMap<String, LinkedHashMap<Integer, List<String>>> tartgetData = SessionData
				.getExcelData("TARTGET_EXCEL_FILE");
		// Get all sheet name in target file
		List<String> targetSheetsName = new ArrayList<String>();
		for (String key : tartgetData.keySet()) {
			targetSheetsName.add(key);
		}
		// Check sheet name in source file then add to all sheet name can
		// compare
		List<String> compareSheetsName = new ArrayList<String>();
		for (String key : sourceData.keySet()) {
			if (targetSheetsName.indexOf(key) != -1) {
				compareSheetsName.add(key);
			} else {
				System.out.println("***** ASSERT FAIL ***** Sheet " + key + " not exist in target file.");
			}
		}

		// Assert each line in each sheet
		for (String sheet : compareSheetsName) {
			System.out.println("***** INFO ***** Assert sheet " + sheet);
			LinkedHashMap<Integer, List<String>> sourceSheetData = sourceData.get(sheet);
			LinkedHashMap<Integer, List<String>> targetSheetData = tartgetData.get(sheet);
			// loop row in target file
			for (int key : targetSheetData.keySet()) {
				// loop each cell in row in target file
				// Assert source file
				for (int i = 0; i < targetSheetData.get(key).size(); i++) {
					// Get the data in the same position in source file
					String target = targetSheetData.get(key).get(i);
					String source = "";
					try {
						source = sourceSheetData.get(key).get(i);
					} catch (Exception e) {
						// do nothing
					}
					// If assert fail, mark color and comment
					if (!target.equals(source)) {
						iCountFailed += 1;
						System.out.println(
								"***** ASSERT FAIL ***** SourceFile:" + sourceFile + "Sheet:" + key + "Cell:" + i);
						ExcelUtils.setCellColor(sourceFile, sheet, key, i, HSSFColor.LIGHT_ORANGE.index);
						ExcelUtils.setCellComment(sourceFile, sheet, key, i, "AUTO", "Expected value: " + target);
					}
				}
			}

		}
		System.out.println("***** ASSERT FAIL ***** Total different:" + iCountFailed);
		return iCountFailed;
	}

	@Given("^user changes database connection as \"([^\"]*)\"$")
	public void user_changes_database_connection_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("DB_CONFIG", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("DB_CONFIG", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("DB_CONFIG", row, "KEY");
			String sJdbc_Driver = SessionData.getDataTbVal("DB_CONFIG", row, "JDBC_DRIVER");
			String sIp_Server = SessionData.getDataTbVal("DB_CONFIG", row, "IP_SERVER");
			String sServer_Port = SessionData.getDataTbVal("DB_CONFIG", row, "SERVER_PORT");
			String sDb_Name = SessionData.getDataTbVal("DB_CONFIG", row, "DB_NAME");
			String sUser_Name = SessionData.getDataTbVal("DB_CONFIG", row, "USER_NAME");
			String sPass_Word = SessionData.getDataTbVal("DB_CONFIG", row, "PASS_WORD");
			if (!(sKey.isEmpty() && sJdbc_Driver.isEmpty() && sIp_Server.isEmpty() && sServer_Port.isEmpty()
					&& sDb_Name.isEmpty() && sUser_Name.isEmpty() && sPass_Word.isEmpty())) {
				ConnectDatabase.CHANGE_DB_CONFIG = true;
				ConnectDatabase.JDBC_DRIVER = sJdbc_Driver;
				ConnectDatabase.IP_SERVER = sIp_Server;
				ConnectDatabase.SERVER_PORT = sServer_Port;
				ConnectDatabase.DB_NAME = sDb_Name;
				ConnectDatabase.USER_NAME = sUser_Name;
				ConnectDatabase.PASS_WORD = sPass_Word;
			}
		}
	}

	@Given("^user resets database connection to default$")
	public void user_reset_database_connection_to_default() throws Throwable {
		ConnectDatabase.CHANGE_DB_CONFIG = false;
	}

	@Then("^user checks number of records in database$")
	public void user_checks_number_of_records_in_database(List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SQL_COUNT_STATEMENT", dataTable, false);
		ConnectDatabase.connect();
		for (int row : SessionData.getDataTbRowsNoHeader("SQL_COUNT_STATEMENT").keySet()) {
			String sSqlCountStatement = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "SQL Count Statement");
			String sResults = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "Results");
			String sReplacement1DataKey = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row,
					"Replacement 1 Data Key");
			String sIndex1 = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "Index 1");
			String sReplacement2DataKey = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row,
					"Replacement 2 Data Key");
			String sIndex2 = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "Index 2");
			int ret = 0;
			if (!sSqlCountStatement.isEmpty() && !sResults.isEmpty()) {
				if (!sReplacement1DataKey.isEmpty()) {
					String temp = "";
					try {
						if (Serenity.sessionVariableCalled(sReplacement1DataKey) instanceof List<?>) {
							if (!sIndex1.isEmpty()) {
								temp = SessionData.getListStringByIndex(sReplacement1DataKey,
										Integer.parseInt(sIndex1));
							} else {
								temp = SessionData.getListStringLastValue(sReplacement1DataKey);
							}
						} else {
							temp = Serenity.sessionVariableCalled(sReplacement1DataKey).toString();
						}
					} catch (Exception e) {
						fail("***** Error ***** Please recheck input data or session data : " + sReplacement1DataKey);
					}
					sSqlCountStatement = sSqlCountStatement.replace("@@#1#@@", temp);
				}

				if (!sReplacement2DataKey.isEmpty()) {
					String temp = "";
					try {
						if (Serenity.sessionVariableCalled(sReplacement2DataKey) instanceof List<?>) {
							if (!sIndex2.isEmpty()) {
								temp = SessionData.getListStringByIndex(sReplacement2DataKey,
										Integer.parseInt(sIndex2));
							} else {
								temp = SessionData.getListStringLastValue(sReplacement2DataKey);
							}
						} else {
							temp = Serenity.sessionVariableCalled(sReplacement2DataKey).toString();
						}
					} catch (Exception e) {
						fail("***** Error ***** Please recheck input data or session data : " + sReplacement2DataKey);
					}
					sSqlCountStatement = sSqlCountStatement.replace("@@#2#@@", temp);
				}
				ResultSet rs = null;
				rs = ConnectDatabase.executeQuery(sSqlCountStatement);
				System.out.println("***** INFO ***** SQL Statement : " + sSqlCountStatement);
				try {
					if (rs.next()) {
						ret = rs.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (!Integer.toString(ret).equals(sResults)) {
					ConnectDatabase.close();
					fail("***** FAIL ***** SQL Statement : " + sSqlCountStatement + "\n\r" + "Actual: " + ret
							+ " . Expected : " + sResults);
					return;
				}
			} else {
				continue;
			}
		}
		ConnectDatabase.close();
	}

	@Then("^user checks number of records in database as \"([^\"]*)\"$")
	public void user_checks_number_of_records_in_database_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("SQL_COUNT_STATEMENT", dataTable, false);
		ConnectDatabase.connect();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SQL_COUNT_STATEMENT", "KEY", dataKey).keySet()) {
			String sSqlCountStatement = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "SQL Count Statement");
			String sResults = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "Results");
			String sReplacement1DataKey = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row,
					"Replacement 1 Data Key");
			String sIndex1 = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "Index 1");
			String sReplacement2DataKey = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row,
					"Replacement 2 Data Key");
			String sIndex2 = SessionData.getDataTbVal("SQL_COUNT_STATEMENT", row, "Index 2");
			int ret = 0;
			if (!sSqlCountStatement.isEmpty() && !sResults.isEmpty()) {
				if (!sReplacement1DataKey.isEmpty()) {
					String temp = "";
					try {
						if (Serenity.sessionVariableCalled(sReplacement1DataKey) instanceof List<?>) {
							if (!sIndex1.isEmpty()) {
								temp = SessionData.getListStringByIndex(sReplacement1DataKey,
										Integer.parseInt(sIndex1));
							} else {
								temp = SessionData.getListStringLastValue(sReplacement1DataKey);
							}
						} else {
							temp = Serenity.sessionVariableCalled(sReplacement1DataKey).toString();
						}
					} catch (Exception e) {
						fail("***** Error ***** Please recheck input data or session data : " + sReplacement1DataKey);
					}
					sSqlCountStatement = sSqlCountStatement.replace("@@#1#@@", temp);
				}

				if (!sReplacement2DataKey.isEmpty()) {
					String temp = "";
					try {
						if (Serenity.sessionVariableCalled(sReplacement2DataKey) instanceof List<?>) {
							if (!sIndex2.isEmpty()) {
								temp = SessionData.getListStringByIndex(sReplacement2DataKey,
										Integer.parseInt(sIndex2));
							} else {
								temp = SessionData.getListStringLastValue(sReplacement2DataKey);
							}
						} else {
							temp = Serenity.sessionVariableCalled(sReplacement2DataKey).toString();
						}
					} catch (Exception e) {
						fail("***** Error ***** Please recheck input data or session data : " + sReplacement2DataKey);
					}
					sSqlCountStatement = sSqlCountStatement.replace("@@#2#@@", temp);
				}
				ResultSet rs = null;
				rs = ConnectDatabase.executeQuery(sSqlCountStatement);
				System.out.println("***** INFO ***** SQL Statement : " + sSqlCountStatement);
				try {
					if (rs.next()) {
						ret = rs.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (!Integer.toString(ret).equals(sResults)) {
					ConnectDatabase.close();
					fail("***** FAIL *****  SQL Statement : " + sSqlCountStatement + "\n\r" + "Actual: " + ret
							+ " . Expected : " + sResults);
					return;
				}
			} else {
				continue;
			}
		}
		ConnectDatabase.close();
	}

	@Then("^user gets \"([^\"]*)\" before values and sets expected values will be changed in database as \"([^\"]*)\"$")
	public void user_gets_before_values_and_sets_expected_values_will_change_in_database_as(String verifyNo,
			String dataKey, List<List<String>> dataTable) throws Throwable {
		String VERIFY_VALUE_CHANGE_IN_DB = "VERIFY_VALUE_CHANGE_IN_DB_" + verifyNo;
		SessionData.addDataTable(VERIFY_VALUE_CHANGE_IN_DB, dataTable, false);
		ConnectDatabase.connect();
		for (int row : SessionData.getDataTbRowsByValEqualInCol(VERIFY_VALUE_CHANGE_IN_DB, "KEY", dataKey).keySet()) {
			String sVerifyKey = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row, "VERIFY KEY");
			String sExpectedCondition = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row, "Expected Condition");
			String sExpectedValue1 = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row, "Expected Value 1");
			String sExpectedValue2 = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row, "Expected Value 2");
			String sSqlSelectStatement = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row,
					"SQL Select Statement");
			String sReplacement1DataKey = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row,
					"Replacement 1 Data Key");
			String sIndex1 = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row, "Index 1");
			String sReplacement2DataKey = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row,
					"Replacement 2 Data Key");
			String sIndex2 = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, row, "Index 2");
			if (!sVerifyKey.isEmpty() && !sSqlSelectStatement.isEmpty() && !sExpectedCondition.isEmpty()) {
				try {
					List<List<String>> lVerifyData = new ArrayList<List<String>>();
					// Execute query
					if (!sReplacement1DataKey.isEmpty()) {
						String temp = "";
						try {
							if (Serenity.sessionVariableCalled(sReplacement1DataKey) instanceof List<?>) {
								if (!sIndex1.isEmpty()) {
									temp = SessionData.getListStringByIndex(sReplacement1DataKey,
											Integer.parseInt(sIndex1));
								} else {
									temp = SessionData.getListStringLastValue(sReplacement1DataKey);
								}
							} else {
								temp = Serenity.sessionVariableCalled(sReplacement1DataKey).toString();
							}
						} catch (Exception e) {
							fail("***** Error ***** Please recheck input data or session data : "
									+ sReplacement1DataKey);
						}
						sSqlSelectStatement = sSqlSelectStatement.replace("@@#1#@@", temp);
					}

					if (!sReplacement2DataKey.isEmpty()) {
						String temp = "";
						try {
							if (Serenity.sessionVariableCalled(sReplacement2DataKey) instanceof List<?>) {
								if (!sIndex2.isEmpty()) {
									temp = SessionData.getListStringByIndex(sReplacement2DataKey,
											Integer.parseInt(sIndex2));
								} else {
									temp = SessionData.getListStringLastValue(sReplacement2DataKey);
								}
							} else {
								temp = Serenity.sessionVariableCalled(sReplacement2DataKey).toString();
							}
						} catch (Exception e) {
							fail("***** Error ***** Please recheck input data or session data : "
									+ sReplacement2DataKey);
						}
						sSqlSelectStatement = sSqlSelectStatement.replace("@@#2#@@", temp);
					}
					ResultSet rs = null;
					rs = ConnectDatabase.executeQuery(sSqlSelectStatement);
					System.out.println("***** INFO ***** SQL Statement : " + sSqlSelectStatement);

					// Get list of column names result
					ResultSetMetaData metaData = rs.getMetaData();
					int count = metaData.getColumnCount(); // number of column
					List<String> columnName = new ArrayList<String>();
					for (int i = 1; i <= count; i++) {
						columnName.add("BEFORE_" + metaData.getColumnLabel(i));
					}
					for (int i = 1; i <= count; i++) {
						columnName.add("AFTER_" + metaData.getColumnLabel(i));
					}
					lVerifyData.add(columnName);
					// Add before result value
					while (rs.next()) {
						List<String> resultRow = new ArrayList<String>();
						for (int i = 1; i <= count; i++) {
							resultRow.add(rs.getString(i));
						}
						lVerifyData.add(resultRow);
					}
					// Create data table for each verify key
					SessionData.addDataTable(VERIFY_VALUE_CHANGE_IN_DB + sVerifyKey, lVerifyData, false);
				} catch (Exception e) {
					e.printStackTrace();
					fail("***** FAIL *****  SQL Statement : " + sSqlSelectStatement + "\n\r" + "Error: "
							+ e.toString());
					ConnectDatabase.close();
				}
			} else {
				continue;
			}
		}
		ConnectDatabase.close();
	}

	@Then("^user verifies \"([^\"]*)\" change of value in database as \"([^\"]*)\"$")
	public void user_verifies_change_of_value_in_database_as(String verifyNo, String dataKey,
			List<List<String>> dataTable) throws Throwable {
		boolean fail = false;
		String VERIFY_VALUE_CHANGE_IN_DB = "VERIFY_VALUE_CHANGE_IN_DB_" + verifyNo;
		String RESULT_VERIFY_VALUE_CHANGE_IN_DB = "RESULT_VERIFY_VALUE_CHANGE_IN_DB_" + verifyNo;
		String DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB = "";
		SessionData.addDataTable(RESULT_VERIFY_VALUE_CHANGE_IN_DB, dataTable, false);
		ConnectDatabase.connect();
		for (int row : SessionData.getDataTbRowsByValEqualInCol(RESULT_VERIFY_VALUE_CHANGE_IN_DB, "KEY", dataKey)
				.keySet()) {

			String sVerifyKey = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row, "VERIFY KEY");
			String sExpectedCondition = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row,
					"Expected Condition");
			String sExpectedValue1 = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row,
					"Expected Value 1");
			String sExpectedValue2 = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row,
					"Expected Value 2");
			String sSqlSelectStatement = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row,
					"SQL Select Statement");
			String sReplacement1DataKey = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row,
					"Replacement 1 Data Key");
			String sIndex1 = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row, "Index 1");
			String sReplacement2DataKey = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row,
					"Replacement 2 Data Key");
			String sIndex2 = SessionData.getDataTbVal(RESULT_VERIFY_VALUE_CHANGE_IN_DB, row, "Index 2");
			// Reload data in before table
			boolean matchKey = false;
			for (int beforeTbRow : SessionData.getDataTbRowsByValEqualInCol(VERIFY_VALUE_CHANGE_IN_DB, "KEY", dataKey)
					.keySet()) {
				String sBeforeVerifyKey = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
						"VERIFY KEY");
				if (sBeforeVerifyKey.equals(sVerifyKey)) {
					if (sExpectedCondition.isEmpty()) {
						sExpectedCondition = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
								"Expected Condition");
					}
					if (sExpectedValue1.isEmpty()) {
						sExpectedValue1 = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
								"Expected Value 1");
					}
					if (sExpectedValue2.isEmpty()) {
						sExpectedValue2 = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
								"Expected Value 2");
					}
					if (sSqlSelectStatement.isEmpty()) {
						sSqlSelectStatement = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
								"SQL Select Statement");
					}
					if (sReplacement1DataKey.isEmpty()) {
						sReplacement1DataKey = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
								"Replacement 1 Data Key");
					}
					if (sReplacement2DataKey.isEmpty()) {
						sReplacement2DataKey = SessionData.getDataTbVal(VERIFY_VALUE_CHANGE_IN_DB, beforeTbRow,
								"Replacement 2 Data Key");
					}
					matchKey = true;
					break;
				} else {
					continue;
				}
			}
			if (!matchKey) {
				fail = true;
				System.out.println("***** FAIL ***** Verify value change in DB. Verify Key not match : " + sVerifyKey);
			}

			int numberOfColumn = 0;
			if (!sVerifyKey.isEmpty() && !sSqlSelectStatement.isEmpty() && !sExpectedCondition.isEmpty()) {
				try {
					List<List<String>> lVerifyData = new ArrayList<List<String>>();
					// Execute query
					if (!sReplacement1DataKey.isEmpty()) {
						String temp = "";
						try {
							if (Serenity.sessionVariableCalled(sReplacement1DataKey) instanceof List<?>) {
								if (!sIndex1.isEmpty()) {
									temp = SessionData.getListStringByIndex(sReplacement1DataKey,
											Integer.parseInt(sIndex1));
								} else {
									temp = SessionData.getListStringLastValue(sReplacement1DataKey);
								}
							} else {
								temp = Serenity.sessionVariableCalled(sReplacement1DataKey).toString();
							}
						} catch (Exception e) {
							fail("***** Error ***** Please recheck input data or session data : "
									+ sReplacement1DataKey);
						}
						sSqlSelectStatement = sSqlSelectStatement.replace("@@#1#@@", temp);
					}

					if (!sReplacement2DataKey.isEmpty()) {
						String temp = "";
						try {
							if (Serenity.sessionVariableCalled(sReplacement2DataKey) instanceof List<?>) {
								if (!sIndex2.isEmpty()) {
									temp = SessionData.getListStringByIndex(sReplacement2DataKey,
											Integer.parseInt(sIndex2));
								} else {
									temp = SessionData.getListStringLastValue(sReplacement2DataKey);
								}
							} else {
								temp = Serenity.sessionVariableCalled(sReplacement2DataKey).toString();
							}
						} catch (Exception e) {
							fail("***** Error ***** Please recheck input data or session data : "
									+ sReplacement2DataKey);
						}
						sSqlSelectStatement = sSqlSelectStatement.replace("@@#2#@@", temp);
					}
					ResultSet rs = null;
					rs = ConnectDatabase.executeQuery(sSqlSelectStatement);
					System.out.println("***** INFO ***** SQL Statement : " + sSqlSelectStatement);

					// Get list of column names result
					ResultSetMetaData metaData = rs.getMetaData();
					numberOfColumn = metaData.getColumnCount(); // number of
																// column
					List<String> columnName = new ArrayList<String>();
					for (int i = 1; i <= numberOfColumn; i++) {
						columnName.add("BEFORE_" + metaData.getColumnLabel(i));
					}
					for (int i = 1; i <= numberOfColumn; i++) {
						columnName.add("AFTER_" + metaData.getColumnLabel(i));
					}
					lVerifyData.add(columnName);
					// Add before result value
					// Get before data
					LinkedHashMap<Integer, List<String>> beforeData = new LinkedHashMap<Integer, List<String>>();
					beforeData = SessionData.getDataTbRowsNoHeader(VERIFY_VALUE_CHANGE_IN_DB + sVerifyKey);
					int y = 1; // count for before result
					while (rs.next()) {
						for (int i = 1; i <= numberOfColumn; i++) {
							beforeData.get(y).add(rs.getString(i));
						}
						lVerifyData.add(beforeData.get(y));
						y++;
					}
					// Create data table for each verify key
					DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB = RESULT_VERIFY_VALUE_CHANGE_IN_DB + sVerifyKey;
					SessionData.addDataTable(RESULT_VERIFY_VALUE_CHANGE_IN_DB + sVerifyKey, lVerifyData, false);
				} catch (Exception e) {
					e.printStackTrace();
					fail("***** FAIL *****  SQL Statement : " + sSqlSelectStatement + "\n\r" + "Error: "
							+ e.toString());
					ConnectDatabase.close();
				}

				// Verify data change
				// Loop all result data
				for (int dataRow : SessionData.getDataTbRowsNoHeader(DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB)
						.keySet()) {
					for (int i = 0; i < numberOfColumn; i++) {
						String beforeColName = SessionData.getDataTbVal(DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB, 0, i);
						String beforeValue = SessionData.getDataTbVal(DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB, dataRow,
								i);
						String afterColName = SessionData.getDataTbVal(DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB, 0,
								i + numberOfColumn);
						String afterValue = SessionData.getDataTbVal(DETAIL_RESULT_VERIFY_VALUE_CHANGE_IN_DB, dataRow,
								i + numberOfColumn);
						System.out.println("***** INFO ***** [" + beforeColName + "] : " + beforeValue + " ["
								+ afterColName + "] : " + afterValue);
						if (sExpectedCondition.equalsIgnoreCase("Not Change")) {
							if (!beforeValue.equals(afterValue)) {
								fail = true;
								System.out.println("***** FAIL ***** Value in DB changed.");
							}
						} else if (sExpectedCondition.equalsIgnoreCase("Increase By")) {
							try {
								if (Float.parseFloat(beforeValue) + Float.parseFloat(sExpectedValue1) != Float
										.parseFloat(afterValue)) {
									fail = true;
									System.out.println("***** FAIL ***** Expected: Increase By " + sExpectedValue1);
								}
							} catch (Exception e) {
								fail = true;
								System.out.println(
										"***** FAIL ***** Please recheck test data. Error: " + "\n\r" + e.getMessage());
							}
						} else if (sExpectedCondition.equalsIgnoreCase("Reduce By")) {
							try {
								if (Float.parseFloat(beforeValue) != Float.parseFloat(afterValue)
										+ Float.parseFloat(sExpectedValue1)) {
									fail = true;
									System.out.println("***** FAIL ***** Expected: Reduce By " + sExpectedValue1);
								}
							} catch (Exception e) {
								fail = true;
								System.out.println(
										"***** FAIL ***** Please recheck test data. Error: " + "\n\r" + e.getMessage());
							}
						} else if (sExpectedCondition.equalsIgnoreCase("Replace By")) {

							if (!beforeValue.equals(sExpectedValue1)) {
								fail = true;
								System.out.println("***** FAIL ***** Expected: Replace By " + sExpectedValue1);
							}

						} else {
							fail = true;
							System.out.println(
									"***** FAIL ***** Verify value change in DB not handle for this expected keyword yet: "
											+ sExpectedCondition);
						}
					}
				}
			} else {
				continue;
			}
		}
		if (fail) {
			fail("***** FAIL ***** Failed to verify change of value in database. VERIFY NO: " + verifyNo);
		}
		ConnectDatabase.close();
	}

	@Then("^user gets draft Voucher No between current period start and current period end date from Database$")
	public void user_gets_draft_Voucher_No_between_current_period_start_and_current_period_end_date_from_Database()
			throws Throwable {
		List<List<String>> dataTable = new ArrayList<List<String>>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		ConnectDatabase.connect();
		String sSqlStatement = "select X.INVENTORY_VOUCHER_NO,X.TRANSACTION_DATE from " + "IC_VCH_NEW_HDR AS X "
				+ "INNER JOIN " + "( select B.PERIOD_START_DATE,B.PERIOD_CLOSING_DATE " + "from IC_SYSTEM_SETUP AS A "
				+ "INNER JOIN MT_FINANCIAL_PERIOD AS B " + "ON A.POINTER_KEY = 0 "
				+ "AND A.CURRENT_YEAR = B.FINANCIAL_YEAR " + "AND A.CURRENT_PERIOD = B.FINANCIAL_PERIOD ) AS Y " + "ON "
				+ "X.TRANSACTION_DATE BETWEEN Y.PERIOD_START_DATE AND Y.PERIOD_CLOSING_DATE "
				+ "ORDER BY X.TRANSACTION_DATE";

		ResultSet rs = null;
		List<String> header = new ArrayList<String>();
		List<String> contents = new ArrayList<String>();
		rs = ConnectDatabase.executeQuery(sSqlStatement);
		System.out.println("***** INFO ***** SQL Statement : " + sSqlStatement);
		try {
			header.add("Inventory Voucher No");
			header.add("Transaction Date");
			dataTable.add(header);
			while (rs.next()) {
				contents.add(rs.getString("INVENTORY_VOUCHER_NO"));
				contents.add(df.format(rs.getDate("TRANSACTION_DATE")));
				dataTable.add(contents);
			}
			ConnectDatabase.close();
		} catch (SQLException e) {
			e.printStackTrace();
			fail("***** FAIL *****  SQL Statement : " + sSqlStatement + "\n\r" + "Error: " + e.toString());
			ConnectDatabase.close();
		}
		SessionData.addDataTable("INVENTORY_VOUCHER_BETWEEN_CURRENT_PERIOD", dataTable, false);

	}
}
