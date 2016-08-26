package com.synergix.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import net.serenitybdd.core.Serenity;

/**
 * Table data, Excel data utility for data table of cucumber feature file and
 * CRUD from Excel File(.xls only) for using in everywhere of FW. WARNING: for
 * more performance and easy to maintain data, please follow the rule: 1. All
 * column data must have unique name 2. Header Data ranger in each sheet must be
 * defined(not empty) 3. Key File Name must be unique.
 * 
 * @author Vincent
 * @version: 20160824
 */
public class SessionData {

	// Name key contains excel file in session variable
	private static final String EXCEL_FILE_LIST = "#ExcelFiles#";
	// Name key contains table data in session variable
	private static final String TABLE_DATA_LIST = "#TableDatas#";
	// Name key contains soft assert in session variable
	private static final String SOFT_ASSERTION_LIST = "#SoftAssertions#";
	private static final String SOFT_ASSERTION_RESULT = "#SoftAssertions#Result#";

	// Region#Data Table Comparison
	/**
	 * Comparing two Data Table directly (without mapping column name). All data
	 * in target Data Table will be compared with source Data Table.This
	 * function compare by column order and ignore column name.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _sourceDataTbKey
	 * @param _targetDataTbKey
	 * @return
	 */
	public static int compareDataTb(String _assertionKey, String _sourceDataTbKey, String _targetDataTbKey) {
		return compareDataTb(_assertionKey, _sourceDataTbKey, _targetDataTbKey, false);
	}

	/**
	 * Comparing two Data Table directly (with auto mapping column name). All
	 * data in target Data Table will be compared with source Data Table. This
	 * function compare only column name that exited in both Data Table.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _sourceDataTbKey
	 * @param _targetDataTbKey
	 * @return
	 */
	public static int compareDataTbAutoMapping(String _assertionKey, String _sourceDataTbKey, String _targetDataTbKey) {
		return compareDataTb(_assertionKey, _sourceDataTbKey, _targetDataTbKey, true);
	}

	/**
	 * Comparing two Data Table by list of column name. All data in target Data
	 * Table will be compared with source Data Table.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _sourceDataTbKey
	 * @param _targetDataTbKey
	 * @param _columnNames
	 * @return
	 */
	public static int compareDataTb(String _assertionKey, String _sourceDataTbKey, String _targetDataTbKey,
			String... _columnNames) {
		return compareDataTb(_assertionKey, _sourceDataTbKey, _targetDataTbKey, true, _columnNames);
	}

	/**
	 * Comparing two Data Table with full option. All data in target Data Table
	 * will be compared with source Data Table.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _sourceDataTbKey
	 * @param _targetDataTbKey
	 * @param isMatchColumnName
	 * @param _columnNames
	 * @return
	 */
	public static int compareDataTb(String _assertionKey, String _sourceDataTbKey, String _targetDataTbKey,
			boolean isMatchColumnName, String... _columnNames) {
		int iCountDif = 0;
		int possibleTargetDataTbSize = 0; // store number of column in Target
											// Data Table can perform comparison
		LinkedHashMap<Integer, List<String>> sourceData = getDataTbRows(_sourceDataTbKey);
		LinkedHashMap<Integer, List<String>> tartgetData = getDataTbRows(_targetDataTbKey);

		// Check data in Data Table
		if (tartgetData.size() <= 1) {
			addSoftAssertion(_assertionKey, "WARNING",
					"Data Table [" + _targetDataTbKey + "][" + tartgetData + "] is empty. Nothing to compare.", true,
					false);
			return 0;
		}
		if (sourceData.size() <= 1) {
			addSoftAssertion(_assertionKey, "WARNING",
					"Data Table [" + _sourceDataTbKey + "][" + sourceData + "] is empty. Nothing to compare.", true,
					false);
			return 0;
		}

		// Validate column name in source and target Data Table
		List<String> compareColumnNames = new ArrayList<String>();
		for (String c : _columnNames) {
			boolean bColumnExistedInSource = false;
			boolean bColumnExistedInTarget = false;
			for (String s : sourceData.get(0)) {
				if (c.equalsIgnoreCase(s)) {
					bColumnExistedInSource = true;
				}
			}
			for (String t : tartgetData.get(0)) {
				if (c.equalsIgnoreCase(t)) {
					bColumnExistedInTarget = true;
				}
			}
			if (bColumnExistedInSource && bColumnExistedInTarget) {
				addSoftAssertion(_assertionKey, "VALIDATE", "Column [" + c + "] exists in both Data Table", "EXIST",
						"NOT EXIST", "FAILURE");
			}
			if (!(bColumnExistedInSource && bColumnExistedInTarget)) {
				addSoftAssertion(_assertionKey, "VALIDATE",
						"Column [" + c + "] not existed in both Data Table. This column does not compare.", "EXIST",
						"NOT EXIST", "FAILURE");
			} else if (!bColumnExistedInSource) {
				addSoftAssertion(
						_assertionKey, "VALIDATE", "Column [" + c + "] does not exist in Data Table ["
								+ _sourceDataTbKey + "]. This column does not compare.",
						"EXIST", "NOT EXIST", "FAILURE");
			} else if (!bColumnExistedInTarget) {
				addSoftAssertion(_assertionKey, "VALIDATE", "Column [" + c + "] does not exist in Data Table ["
						+ tartgetData + "]. This column does not compare.", "EXIST", "NOT EXIST", "FAILURE");
			}
			compareColumnNames.add(c);
		}
		// Validate column to compare in case don not figure Column name
		if (compareColumnNames.size() == 0) {
			if (isMatchColumnName) {
				for (String t : tartgetData.get(0)) {
					boolean existed = false;
					for (String s : sourceData.get(0)) {
						if (t.equalsIgnoreCase(s)) {
							compareColumnNames.add(t);
							existed = true;
							break;
						}
					}
					if (!existed) {
						System.out.println("***** ASSERT FAILURE ***** Column [" + t
								+ "] does not exist in Data Table [" + _sourceDataTbKey + "]");
						addSoftAssertion(
								_assertionKey, "VALIDATE", "Column [" + t + "] does not exist in Data Table ["
										+ _sourceDataTbKey + "]. This column does not compare.",
								"EXIST", "NOT EXIST", "FAILURE");
					}
				}
			} else {
				for (int i = 0; i < tartgetData.get(0).size(); i++) {
					try {
						sourceData.get(0).get(i);
					} catch (Exception e) {
						System.out.println(
								"***** ASSERT FAILURE ***** Column Index [" + i + "] does not exist in Data Table ["
										+ _sourceDataTbKey + "]. Column Name is [" + tartgetData.get(0).get(i) + "]");
						addSoftAssertion(_assertionKey, "VALIDATE",
								"Column Index [" + i + "] does not exist in Data Table [" + _sourceDataTbKey
										+ "]. Column Name is [" + tartgetData.get(0).get(i)
										+ "]. This column does not compare.",
								"EXIST", "NOT EXIST", "FAILURE");
						if (possibleTargetDataTbSize == 0) {// get the max
															// existed ranger of
															// column
							possibleTargetDataTbSize = i;
						}
					}
				}
				if (possibleTargetDataTbSize == 0) {
					possibleTargetDataTbSize = tartgetData.get(0).size();
				}
			}
		}
		// loop row in target Data Table
		for (int key : tartgetData.keySet()) {
			if (key == 0) {// Do not compare header
				continue;
			}
			if (compareColumnNames.size() == 0) {// compare all data
				// loop each value in row in tartgetData
				for (int i = 0; i < tartgetData.get(key).size(); i++) {
					if (i >= possibleTargetDataTbSize) {
						break; // Not compare if out of column index in Source
								// Data Table
					}
					// Get the data in the same position in source file
					String target = tartgetData.get(key).get(i);
					String source = "-Not Found-";
					try {
						if (isMatchColumnName) {
							String colName = tartgetData.get(0).get(i);
							int indexColSource = sourceData.get(0).indexOf(colName);
							source = sourceData.get(key).get(indexColSource);
						} else {
							source = sourceData.get(key).get(i);
						}
					} catch (Exception e) {
						// do nothing
					}
					// Add result to soft assertion
					if (!target.equals(source)) {
						iCountDif += 1;
						System.out.println("***** ASSERT FAILURE ***** Target Data Table [" + _targetDataTbKey
								+ "] - Row [" + key + "] - Column [" + i + "]");
					}
					addSoftAssertion(_assertionKey, "[" + key + "][" + i + "]", "Row Index [" + key
							+ "] - Column Index [" + i + "] - Column Name [" + tartgetData.get(0).get(i) + "]", target,
							source);
				}
			} else {// compare specific Column Name only
				// loop each value in row in tartgetData
				for (int i = 0; i < tartgetData.get(key).size(); i++) {
					// ignore other column
					String currentColumn = tartgetData.get(0).get(i);
					if (!compareColumnNames.contains(currentColumn)) {
						continue;
					}
					int colIndexSource = sourceData.get(0).indexOf(currentColumn);
					// Get the data in the same position in source file
					String target = tartgetData.get(key).get(i);
					String source = "";
					source = sourceData.get(key).get(colIndexSource);
					// Add result to soft assertion
					if (!target.equals(source)) {
						iCountDif += 1;
						System.out.println("***** ASSERT FAILURE ***** Target Data Table [" + _targetDataTbKey
								+ "] - Row [" + key + "] - Column [" + i + "]");
					}
					addSoftAssertion(_assertionKey, "[" + key + "][" + i + "]",
							"Row Index [" + key + "] - Column Index [" + i + "] - Column Name [" + currentColumn + "]",
							target, source);
				}
			}
		}
		return iCountDif;
	}

	// EndRegion#Data Table Comparison
	// Region#Soft Assert
	/**
	 * Get Soft Assertion Overall Result. If one soft assertion return failure,
	 * the result is false.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @return
	 */
	public static boolean getSoftAssertionOverallResult(String _assertionKey) {
		return Serenity.sessionVariableCalled(SOFT_ASSERTION_RESULT + _assertionKey);
	}

	/**
	 * Get Soft Assertion Overall Result. If one soft assertion return failure,
	 * the result is false.
	 * 
	 * @author Vincent
	 * @return
	 */
	public static boolean getSoftAssertionOverallResult() {
		return getSoftAssertionOverallResult("");
	}

	/**
	 * Add new Soft Assertion into Soft Assertion List.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _assertion
	 * @param _description
	 * @param _expected
	 * @param _actual
	 * @param _result
	 */
	public static void addSoftAssertion(String _assertionKey, String _assertion, String _description, String _expected,
			String _actual, String _result) {
		List<String> assertion = Arrays.asList(_assertion, _description, _expected, _actual, _result);
		addRowToTbDataReport(SOFT_ASSERTION_LIST + _assertionKey, assertion);
	}

	/**
	 * Add new Soft Assertion into Soft Assertion List.
	 * 
	 * @author Vincent
	 * @param _assertion
	 * @param _description
	 * @param _expected
	 * @param _actual
	 */
	public static void addSoftAssertion(String _assertion, String _description, String _expected, String _actual) {
		addSoftAssertion("", _assertion, _description, _expected, _actual);
	}

	/**
	 * Add new Soft Assertion into Soft Assertion List.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _assertion:
	 *            Case or Name of assertion
	 * @param _description
	 * @param _expected
	 * @param _actual
	 */
	public static void addSoftAssertion(String _assertionKey, String _assertion, String _description, String _expected,
			String _actual) {
		// Compare expected and actual
		String result = "PASSED";
		if (!_expected.equals(_actual)) {
			result = "FAILURE";
		}
		addSoftAssertion(_assertionKey, _assertion, _description, _expected, _actual, result);
	}

	/**
	 * Add new Soft Assertion into Soft Assertion List.
	 * 
	 * @author Vincent
	 * @param _assertion
	 * @param _description
	 * @param _expected
	 * @param _actual
	 */
	public static void addSoftAssertion(String _assertion, String _description, boolean _expected, boolean _actual) {
		addSoftAssertion("", _assertion, _description, _expected, _actual);
	}

	/**
	 * Add new Soft Assertion into Soft Assertion List.
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @param _assertion
	 * @param _description
	 * @param _expected
	 * @param _actual
	 */
	public static void addSoftAssertion(String _assertionKey, String _assertion, String _description, boolean _expected,
			boolean _actual) {
		// Compare expected and actual
		String result = "PASSED";
		if (_expected != _actual) {
			result = "FAILURE";
		}
		addSoftAssertion(_assertionKey, _assertion, _description, new Boolean(_expected).toString(),
				new Boolean(_actual).toString(), result);
	}

	/**
	 * Clear Soft Assertion data
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 */
	public static void clearSoftAssertion(String _assertionKey) {
		clearTbDataReport(SOFT_ASSERTION_LIST + _assertionKey);
		if (Serenity.sessionVariableCalled(SOFT_ASSERTION_RESULT + _assertionKey) != null) {
			Serenity.setSessionVariable(SOFT_ASSERTION_RESULT + _assertionKey).to(null);
		}
	}

	/**
	 * Clear Soft Assertion data
	 * 
	 * @author Vincent
	 */
	public static void clearSoftAssertion() {
		clearSoftAssertion("");
	}

	/**
	 * Generating Soft Assertion
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @return
	 */
	public static String generateSoftAssertion(String _assertionKey) {
		List<List<String>> tbReport = Serenity.sessionVariableCalled(SOFT_ASSERTION_LIST + _assertionKey);
		List<List<String>> tbReport1 = new ArrayList<List<String>>();
		// Count number of FAILURE and PASSED and create report
		int iAssert = 0;
		int iFailure = 0;
		int iPassed = 0;
		// Add Report Header
		List<String> header = Arrays.asList("Assertion", "Description", "Expected", "Actual", "Result");
		tbReport1.add(header);
		// Count result and print out report detail
		for (List<String> temp : tbReport) {
			iAssert += 1;
			String result = temp.get(4);
			if (result.equalsIgnoreCase("FAILURE")) {
				iFailure += 1;
			} else if (result.equalsIgnoreCase("PASSED")) {
				iPassed += 1;
			}
			tbReport1.add(new ArrayList<String>(temp));
		}
		// Set overall result for this Soft Assertion
		if (iFailure != 0) {
			Serenity.setSessionVariable(SOFT_ASSERTION_RESULT + _assertionKey).to(false);
		} else {
			Serenity.setSessionVariable(SOFT_ASSERTION_RESULT + _assertionKey).to(true);
		}
		// Add Report Result
		String result = "[" + _assertionKey + "]" + System.getProperty("line.separator") + "- Total Assertion: ["
				+ iAssert + "] - Total Passed: [" + iPassed + "] - Total Failure: [" + iFailure + "]"
				+ System.getProperty("line.separator");
		return result + generateTbDataReport(tbReport1) + System.getProperty("line.separator") + result;
	}

	/**
	 * Generating Soft Assertion and display failure assertion only
	 * 
	 * @author Vincent
	 * @param _assertionKey
	 * @return
	 */
	public static String generateSoftAssertionFailureOnly(String _assertionKey) {
		List<List<String>> tbReport = Serenity.sessionVariableCalled(SOFT_ASSERTION_LIST + _assertionKey);
		List<List<String>> tbReport1 = new ArrayList<List<String>>();
		// Count number of FAILURE and PASSED and create report
		int iAssert = 0;
		int iFailure = 0;
		int iPassed = 0;
		// Add Report Header
		List<String> header = Arrays.asList("Assertion", "Description", "Expected", "Actual", "Result");
		tbReport1.add(header);
		// Count result and print out report detail
		for (List<String> temp : tbReport) {
			iAssert += 1;
			String result = temp.get(4);
			if (result.equals("FAILURE")) {
				iFailure += 1;
				tbReport1.add(new ArrayList<String>(temp));
			} else if (result.equalsIgnoreCase("PASSED")) {
				iPassed += 1;
			}
		}
		// Set overall result for this Soft Assertion
		if (iFailure != 0) {
			Serenity.setSessionVariable(SOFT_ASSERTION_RESULT + _assertionKey).to(false);
		} else {
			Serenity.setSessionVariable(SOFT_ASSERTION_RESULT + _assertionKey).to(true);
		}
		// Add Report Result
		String result = "[" + _assertionKey + "]" + System.getProperty("line.separator") + "- Total Assertion: ["
				+ iAssert + "] - Total Passed: [" + iPassed + "] - Total Failure: [" + iFailure + "]"
				+ System.getProperty("line.separator");
		return result + generateTbDataReport(tbReport1) + System.getProperty("line.separator") + result;
	}

	/**
	 * Generating Soft Assertion
	 * 
	 * @author Vincent
	 * @return
	 */
	public static String generateSoftAssertion() {
		return generateSoftAssertion("");
	}

	/**
	 * Generating Soft Assertion
	 * 
	 * @author Vincent
	 * @return
	 */
	public static String generateSoftAssertionFailureOnly() {
		return generateSoftAssertionFailureOnly("");
	}
	// EndRegion#Soft Assert

	// Region#Data Table
	/**
	 * Update value in Data Table by index of Row and Column. Note: index starts
	 * from 0
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _colIndex
	 * @param _rowIndex
	 * @param _value
	 */
	public static void updateDataTbVal(String _keyDataTableName, int _colIndex, int _rowIndex, String _value) {
		// Get session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// Check Data Table exist or not in Session Data
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			System.out.println("***** ERROR ***** Data Table does not exist. Update value is impossible. ["
					+ _keyDataTableName + "]");
			throw new IllegalArgumentException(
					"Data Table does not exist. Update value is impossible. [" + _keyDataTableName + "]");
		} else {// Update value
			HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
			hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
			LinkedHashMap<Integer, List<String>> mAddDataTable = hSessionDataTable.get(_keyDataTableName);
			String colName = "";
			String originalVal = "";
			try {
				colName = mAddDataTable.get(0).get(_colIndex);
				originalVal = mAddDataTable.get(_rowIndex).get(_colIndex);
				mAddDataTable.get(_rowIndex).set(_colIndex, _value);
				System.out.println("***** INFO ***** Update [" + originalVal + "] by [" + _value + "] in Data Table ["
						+ _keyDataTableName + "] column [" + colName + "] row [" + _rowIndex + "]");
			} catch (Exception e) {
				System.out.println("***** ERROR ***** Update [" + _value + "] in Data Table [" + _keyDataTableName
						+ "] unsuccessful!. Can not find data at column [" + _colIndex + "] and row [" + _rowIndex
						+ "]");
				throw new IllegalArgumentException("Update [" + _value + "] in Data Table [" + _keyDataTableName
						+ "] unsuccessful!. Can not find data at column [" + _colIndex + "] and row [" + _rowIndex
						+ "]");
			}
		}
	}

	/**
	 * Update value in Data Table by Row index and Column name. Note: index
	 * starts from 0
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _colName
	 * @param _rowIndex
	 * @param _value
	 */
	public static void updateDataTbVal(String _keyDataTableName, String _colName, int _rowIndex, String _value) {
		// Get session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// Check Data Table exist or not in Session Data
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			System.out.println("***** ERROR ***** Data Table does not exist. Update value is impossible. ["
					+ _keyDataTableName + "]");
			throw new IllegalArgumentException(
					"Data Table does not exist. Update value is impossible. [" + _keyDataTableName + "]");
		} else {// Update value
			HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
			hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
			LinkedHashMap<Integer, List<String>> mAddDataTable = hSessionDataTable.get(_keyDataTableName);
			int colIndex = 0;
			String originalVal = "";
			try {
				colIndex = mAddDataTable.get(0).indexOf(_colName);
				originalVal = mAddDataTable.get(_rowIndex).get(colIndex);
				mAddDataTable.get(_rowIndex).set(colIndex, _value);
				System.out.println("***** INFO ***** Update [" + originalVal + "] by [" + _value + "] in Data Table ["
						+ _keyDataTableName + "] column [" + _colName + "] row [" + _rowIndex + "]");
			} catch (Exception e) {
				System.out.println("***** ERROR ***** Update [" + _value + "] in Data Table [" + _keyDataTableName
						+ "] unsuccessful!. Can not find data at column [" + _colName + "] and row [" + _rowIndex
						+ "]");
				throw new IllegalArgumentException("Update [" + _value + "] in Data Table [" + _keyDataTableName
						+ "] unsuccessful!. Can not find data at column [" + _colName + "] and row [" + _rowIndex
						+ "]");
			}
		}
	}

	/**
	 * Add new Row data before the last existed row into Data Table in Session
	 * Data variable.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _newRowData
	 */
	public static void addDataTbNewRow(String _keyDataTableName, List<String> _newRowData) {
		addDataTbNewRow(_keyDataTableName, _newRowData, -1);
	}

	/**
	 * Add new Row data into Data Table in Session Data variable. Note: if index
	 * of new Row out of number existed row or negative value, new Row will be
	 * added before the last existed Row.It is not permitted to add new row to
	 * Data Table Header(index = 0)
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _newRowData
	 * @param _index
	 */

	public static void addDataTbNewRow(String _keyDataTableName, List<String> _newRowData, int _index) {
		// Get session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// If session data not exist then initialize
		if (hSession_DataTable == null) {
			HashMap<String, LinkedHashMap<Integer, List<String>>> hDataTable = new HashMap<>();
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hDataTable);
			hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		}
		// Check Data Table exist or not in Session Data
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			System.out.println("***** ERROR ***** Data Table does not exist. Adding more row is impossible. ["
					+ _keyDataTableName + "]");
		} else {// Adding new row
			HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
			hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
			LinkedHashMap<Integer, List<String>> mAddDataTable = hSessionDataTable.get(_keyDataTableName);
			int numCol = mAddDataTable.get(0).size();
			// Validate input
			if (_index == 0) {
				System.out.println("***** ERROR ***** It is not permitted to add new row to Data Table Header");
				throw new IllegalArgumentException(
						"It is not permitted to add new row to header of Data Table. Data Table [" + _keyDataTableName
								+ "]");
			}
			System.out.println("***** INFO ***** Adding new row into Data Table [" + _keyDataTableName + "]");
			if (_newRowData.size() != numCol) {
				System.out.println(
						"***** WARNING ***** New row data does not map with Data Table [" + _keyDataTableName + "]");
				System.out.println("***** WARNING ***** Data Table Header size is [" + numCol + "]");
				System.out.println("***** WARNING ***** New row data size is [" + _newRowData.size() + "]");
			}
			// Create new instant for data to insert
			LinkedHashMap<Integer, List<String>> newAddDataTable = new LinkedHashMap<>();
			// Insert new row
			// If index > the last row or negative, add before the last row
			int lastRowIndex = 0;
			for (int key : mAddDataTable.keySet()) {
				if (key < _index) {
					newAddDataTable.put(key, mAddDataTable.get(key));
				}
				if (key == _index) {
					newAddDataTable.put(key, _newRowData);
				}
				if (key >= _index) {
					newAddDataTable.put(key + 1, mAddDataTable.get(key));
				}
				lastRowIndex = key;
			}
			if (_index > lastRowIndex || _index < 0) {
				newAddDataTable.put(lastRowIndex + 1, _newRowData);
			}
			hSession_DataTable.put(_keyDataTableName, newAddDataTable);
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hSession_DataTable);
		}
	}

	/**
	 * Remove existed Row data of Data Table in Session Data variable. Negative
	 * value will remove the last row. Note: if index of Row out of number
	 * existed row will raise Exception.Index starts from 0 (0 is header row and
	 * can not be removed).
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _index
	 */
	public static void removeDataTbRow(String _keyDataTableName, int _index) {
		// Get session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// If session data not exist then initialize
		if (hSession_DataTable == null) {
			HashMap<String, LinkedHashMap<Integer, List<String>>> hDataTable = new HashMap<>();
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hDataTable);
			hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		}
		// Check Data Table exist or not in Session Data
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			System.out.println("***** ERROR ***** Data Table does not exist. Remove existed row is impossible. ["
					+ _keyDataTableName + "]");
		} else {// Adding new row
			HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
			hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
			LinkedHashMap<Integer, List<String>> mAddDataTable = hSessionDataTable.get(_keyDataTableName);
			// Validate input
			if (_index == 0) {
				System.out.println("***** ERROR ***** It is not permitted to remove Data Table Header");
				throw new IllegalArgumentException(
						"It is not permitted to remove header of Data Table. Data Table [" + _keyDataTableName + "]");
			}
			System.out
					.println("***** INFO ***** Remove row [" + _index + "] of Data Table [" + _keyDataTableName + "]");
			// Create new instant for data to remove
			LinkedHashMap<Integer, List<String>> newAddDataTable = new LinkedHashMap<>();
			// Remove row
			// If index is negative value, remove row before the last row
			int lastRowIndex = 0;
			for (int key : mAddDataTable.keySet()) {
				if (key < _index) {
					newAddDataTable.put(key, mAddDataTable.get(key));
				}
				if (key == _index) {
					// remove this row
				}
				if (key > _index) {
					newAddDataTable.put(key - 1, mAddDataTable.get(key));
				}
				lastRowIndex = key;
			}
			if (_index < 0) {
				newAddDataTable.remove(lastRowIndex);
			}
			// If index > index of last existed row,raise error
			if (_index > lastRowIndex) {
				System.out.println("***** ERROR ***** Row [" + _index
						+ "] does not exist. Remove existed row is impossible. Data Table [" + _keyDataTableName + "]");
				throw new IllegalArgumentException("Row [" + _index
						+ "] does not exist. Remove existed row is impossible. Data Table [" + _keyDataTableName + "]");
			}
			hSession_DataTable.put(_keyDataTableName, newAddDataTable);
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hSession_DataTable);
		}
	}

	/**
	 * Add new Column into Data Table in Session Data variable. Note: if index
	 * of new Column out of Column ranger or negative value, new Column will be
	 * added before the last existed Column.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _fileName
	 * @param _sheetname
	 * @param bOnceTime
	 */
	public static void addDataTbNewColumn(String _keyDataTableName, String _newColName, int _index) {
		// Get session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// If session data not exist then initialize
		if (hSession_DataTable == null) {
			HashMap<String, LinkedHashMap<Integer, List<String>>> hDataTable = new HashMap<>();
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hDataTable);
			hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		}
		// Check Data Table exist or not in Session Data
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			System.out.println("***** ERROR ***** Data Table does not exist. Adding more column is impossible. ["
					+ _keyDataTableName + "]");
			throw new IllegalArgumentException(
					"Data Table does not exist. Adding more column is impossible. [" + _keyDataTableName + "]");
		} else {// Adding more column
			HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
			hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
			LinkedHashMap<Integer, List<String>> mAddDataTable = hSessionDataTable.get(_keyDataTableName);
			int numCol = mAddDataTable.get(0).size();

			if (_index == 0) {
				System.out.println("***** INFO ***** Adding the first column [" + _newColName + "] into Data Table ["
						+ _keyDataTableName + "]");
			} else if (_index <= numCol) {
				String afterColName = getDataTbColName(_keyDataTableName, _index - 1);
				System.out.println("***** INFO ***** Adding column [" + _newColName + "] after column [" + afterColName
						+ "] into Data Table [" + _keyDataTableName + "]");
			} else if (_index > numCol || _index < 0) {// add to the last
				String afterColName = getDataTbColName(_keyDataTableName, _index);
				System.out.println("***** INFO ***** Adding column [" + _newColName + "] before column [" + afterColName
						+ "] into Data Table [" + _keyDataTableName + "]");
				_index = numCol;
			}
			for (int row : mAddDataTable.keySet()) {
				// Add new header
				if (row == 0) {
					mAddDataTable.get(row).add(_index, _newColName);
				} else {// add blank value to other row
					mAddDataTable.get(row).add(_index, "");
				}
			}
		}
	}

	/**
	 * Add new Column into Data Table in Session Data variable. New Column will
	 * be added before the last existed Column.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _newColName
	 */
	public static void addDataTbNewColumn(String _keyDataTableName, String _newColName) {
		addDataTbNewColumn(_keyDataTableName, _newColName, -1);
	}

	/**
	 * Load data from data table in feature file to raw data
	 * 
	 * @author Vincent
	 * @param _dataTable
	 * @return
	 */
	private static LinkedHashMap<Integer, List<String>> loadDataTable(List<List<String>> _dataTable) {
		// Used the LinkedHashMap to maintain the order
		LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
		// Add
		for (int i = 0; i < _dataTable.size(); i++) {
			hashMap.put(i, _dataTable.get(i));
		}
		return hashMap;
	}

	/**
	 * Store data table (data in specific sheet of Excel file) to Session Data
	 * variable.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _fileName
	 * @param _sheetname
	 * @param bOnceTime
	 */
	public static void addDataTable(String _keyDataTableName, String _fileName, String _sheetName, boolean bOnceTime) {
		// Get session data
		File file = new File(_fileName);
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// If session data not exist then initialize
		if (hSession_DataTable == null) {
			HashMap<String, LinkedHashMap<Integer, List<String>>> hDataTable = new HashMap<>();
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hDataTable);
			hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		}
		// Check Data Table exist or not in Session Data
		boolean bExist = true;
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			bExist = false;
		}

		// Load data from excel sheet to data table
		if (((bExist) && (!bOnceTime)) || (!bExist)) {
			// Add data for session data
			LinkedHashMap<Integer, List<String>> mAddDataTable = new LinkedHashMap<>();
			System.out.println("***** INFO ***** Loading data from Data Table into [" + _keyDataTableName + "]");
			mAddDataTable = loadExcelLinesByHeaderRanger(file, _sheetName);
			hSession_DataTable.put(_keyDataTableName, mAddDataTable);
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hSession_DataTable);
		}
	}

	/**
	 * Store data table (data in specific sheet of Excel file) to Session Data
	 * variable.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _fileName
	 * @param _sheetname
	 */
	public static void addDataTable(String _keyDataTableName, String _fileName, String _sheetName) {
		addDataTable(_keyDataTableName, _fileName, _sheetName, true);
	}

	/**
	 * Store data table (description in feature file) to Session Data variable.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _dataTable
	 */
	public static void addDataTable(String _keyDataTableName, List<List<String>> _dataTable, boolean bOnceTime) {
		// Get session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSession_DataTable = new HashMap<>();
		hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		// If session data not exist then initialize
		if (hSession_DataTable == null) {
			HashMap<String, LinkedHashMap<Integer, List<String>>> hDataTable = new HashMap<>();
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hDataTable);
			hSession_DataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		}
		// Check Data Table exist or not in Session Data
		boolean bExist = true;
		if (hSession_DataTable.get(_keyDataTableName) == null) {
			bExist = false;
		}

		if (((bExist) && (!bOnceTime)) || (!bExist)) {
			// Add data for session data
			LinkedHashMap<Integer, List<String>> mAddDataTable = new LinkedHashMap<>();
			System.out.println("***** INFO ***** Loading data from Data Table into [" + _keyDataTableName + "]");
			mAddDataTable = loadDataTable(_dataTable);
			hSession_DataTable.put(_keyDataTableName, mAddDataTable);
			Serenity.setSessionVariable(TABLE_DATA_LIST).to(hSession_DataTable);
		}
	}

	/**
	 * Store data table one times (description in feature file) to Session Data
	 * variable.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 * @param _dataTable
	 */
	public static void addDataTable(String _keyDataTableName, List<List<String>> _dataTable) {
		addDataTable(_keyDataTableName, _dataTable, true);
	}

	/**
	 * Remove data table (description in feature file) from Session Data
	 * variable.
	 * 
	 * @author Vincent
	 * @param _keyDataTableName
	 */
	public static void removeDataTable(String _keyDataTableName) {
		// Remove data data table
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
		hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		hSessionDataTable.remove(_keyDataTableName);
		Serenity.setSessionVariable(TABLE_DATA_LIST).to(hSessionDataTable);
		System.out.println("***** INFO ***** Remove Data Table [" + _keyDataTableName + "] from Session Data");
	}

	/**
	 * Get data table rows (data table description in feature file) from Session
	 * Data variable by added Data Table Key.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getDataTbRows(String _dataTableKey) {
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = new HashMap<>();
		hSessionDataTable = Serenity.sessionVariableCalled(TABLE_DATA_LIST);
		return hSessionDataTable.get(_dataTableKey);
	}

	/**
	 * Get data table rows (data table description in feature file) without
	 * header (without first row) from Session Data variable by added Data Table
	 * Key.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getDataTbRowsNoHeader(String _dataTableKey) {
		HashMap<String, LinkedHashMap<Integer, List<String>>> hSessionDataTable = Serenity
				.sessionVariableCalled(TABLE_DATA_LIST);
		LinkedHashMap<Integer, List<String>> ret = new LinkedHashMap<Integer, List<String>>(
				hSessionDataTable.get(_dataTableKey));
		ret.remove(0);
		return ret;
	}

	/**
	 * Get data table row (data table description in feature file) from Session
	 * Data variable by Row Index.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _row
	 * @return List<String>
	 */
	public static List<String> getDataTbRowByRowIndex(String _dataTableKey, int _row) {
		return getDataTbRows(_dataTableKey).get(_row);
	}

	/**
	 * Get index of data table column (data table description in feature file)
	 * from Session Data variable by Column Name.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _colName
	 * @return
	 */
	public static int getDataTbColIndex(String _dataTableKey, String _colName) {
		int colIndex = getDataTbRows(_dataTableKey).get(0).indexOf(_colName);
		if (colIndex == -1) {
			System.out
					.println("***ERROR*** Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "].");
			throw new IllegalArgumentException(
					"Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "]. Re check data !");
		}
		return colIndex;
	}

	/**
	 * Get name of data table column (data table description in feature file)
	 * from Session Data variable by Column index. Return null if not found.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _colIndex
	 * @return
	 */
	public static String getDataTbColName(String _dataTableKey, int _colIndex) {
		String colName = null;
		try {
			colName = getDataTbRows(_dataTableKey).get(0).get(_colIndex);
		} catch (Exception e) {
			System.out.println(
					"***ERROR*** Column Index [" + _colIndex + "] not found in Data Table [" + _dataTableKey + "].");
			throw new IllegalArgumentException("Column Index [" + _colIndex + "] not found in Data Table ["
					+ _dataTableKey + "]. Re check data !");
		}
		return colName;
	}

	/**
	 * Get data rows (data table description in feature file) from Session Data
	 * variable by given Value equals in specific Column Name.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _colName
	 * @param _givenVal
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getDataTbRowsByValEqualInCol(String _dataTableKey,
			String _colName, String _givenVal) {
		LinkedHashMap<Integer, List<String>> lhTempSessionDataTable = getDataTbRows(_dataTableKey);
		LinkedHashMap<Integer, List<String>> lhOuput = new LinkedHashMap<>();
		int colIndex = lhTempSessionDataTable.get(0).indexOf(_colName);
		if (colIndex == -1) {
			System.out
					.println("***ERROR*** Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "].");
			throw new IllegalArgumentException(
					"Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "]. Re check data !");
		} else {
			// Loop through data in data table and add match data row
			for (int key : lhTempSessionDataTable.keySet()) {
				List<String> lTemp = lhTempSessionDataTable.get(key);
				if (!(lTemp.size() == 0)) {
					if (lTemp.get(colIndex).equals(_givenVal)) {
						lhOuput.put(key, lTemp);
					}
				} else {
					System.out.println(
							"***ERROR*** Data Row not found in Data Table [" + _dataTableKey + "].[" + key + "].");
					throw new IllegalArgumentException(
							"Data Row not found in Data Table [" + _dataTableKey + "].[" + key + "]. Re check data !");
				}
			}
		}
		return lhOuput;
	}

	/**
	 * Get data rows (data table description in feature file) from Session Data
	 * variable by given Value is contained in specific Column Name.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _colName
	 * @param _givenVal
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getDataTbRowsByValContainsInCol(String _dataTableKey,
			String _colName, String _givenVal) {
		LinkedHashMap<Integer, List<String>> lhTempSessionDataTable = getDataTbRows(_dataTableKey);
		LinkedHashMap<Integer, List<String>> lhOuput = new LinkedHashMap<>();
		int colIndex = lhTempSessionDataTable.get(0).indexOf(_colName);
		if (colIndex == -1) {
			System.out
					.println("***ERROR*** Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "].");
			throw new IllegalArgumentException(
					"Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "]. Re check data !");
		} else {
			// Loop through data in data table and add match data row
			for (int key : lhTempSessionDataTable.keySet()) {
				List<String> lTemp = lhTempSessionDataTable.get(key);
				if (!(lTemp.size() == 0)) {
					if (lTemp.get(colIndex).contains(_givenVal)) {
						lhOuput.put(key, lTemp);
					}
				} else {
					System.out.println("***ERROR*** There are unexpected errors in Data Table [" + _dataTableKey + "].["
							+ key + "].");
				}
			}
		}
		return lhOuput;
	}

	/**
	 * Get cell data value (data table description in feature file) from Session
	 * Data variable by index of Row and Column Name.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _rowIndex
	 * @param _colName
	 * @return
	 */
	public static String getDataTbVal(String _dataTableKey, int _rowIndex, String _colName) {
		String ret = "";
		LinkedHashMap<Integer, List<String>> lhTempSessionDataTable = getDataTbRows(_dataTableKey);
		int colIndex = lhTempSessionDataTable.get(0).indexOf(_colName);
		if (colIndex == -1) {
			System.out.println(
					"***WARNING*** Column [" + _colName + "] not found in Data Table [" + _dataTableKey + "].");
			return ret;
		} else {
			try {
				ret = lhTempSessionDataTable.get(_rowIndex).get(colIndex);
			} catch (Exception e) {
				ret = "";
				System.out.println(
						"***WARNING*** Row [" + _rowIndex + "] not found in Data Table [" + _dataTableKey + "].");
			}

		}
		return ret;
	}

	/**
	 * Get cell data value (data table description in feature file) from Session
	 * Data variable by index of Row and Column.Noted: index start from 0.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _rowIndex
	 * @param _colIndex
	 * @return
	 */
	public static String getDataTbVal(String _dataTableKey, int _rowIndex, int _colIndex) {
		String ret = "";
		LinkedHashMap<Integer, List<String>> lhTempSessionDataTable = getDataTbRows(_dataTableKey);
		try {
			ret = lhTempSessionDataTable.get(_rowIndex).get(_colIndex);
		} catch (Exception e) {
			ret = "";
			System.out
					.println("***WARNING*** Row [" + _rowIndex + "] not found in Data Table [" + _dataTableKey + "].");
		}
		return ret;
	}

	/**
	 * Get list of Cell value in specific Column Name (data table description in
	 * feature file) from Session Data variable by reference Value of reference
	 * ColumnName.
	 * 
	 * @author Vincent
	 * @param _dataTableKey
	 * @param _refColName
	 * @param _refValue
	 * @param _givenColName
	 * @return
	 */
	public static List<String> getDataTbValsByRefVal(String _dataTableKey, String _refColName, String _refValue,
			String _givenColName) {
		// Get column index
		LinkedHashMap<Integer, List<String>> lhData = getDataTbRows(_dataTableKey);
		int colRefIndex = lhData.get(0).indexOf(_refColName);
		if (colRefIndex == -1) {
			System.out.println(
					"***WARNING*** Column [" + _refColName + "] not found in Data Table [" + _dataTableKey + "].");
			return null;
		}
		int colIndex = lhData.get(0).indexOf(_givenColName);
		if (colIndex == -1) {
			System.out.println(
					"***WARNING*** Column [" + _givenColName + "] not found in Data Table [" + _dataTableKey + "].");
			return null;
		}
		List<String> lResulValue = new ArrayList<String>();
		for (Integer key : lhData.keySet()) {
			if (lhData.get(key).size() == 0) {
				System.out.println("***Warning*** No data in row [" + key + "] of [" + _dataTableKey + "].");
			} else {
				try {
					if (lhData.get(key).get(colRefIndex).equals(_refValue)) {
						lResulValue.add(lhData.get(key).get(colIndex));
					}
				} catch (Exception e) {
					System.out.println(
							"***ERROR*** Incorret data format with row  [" + key + "] of [" + _dataTableKey + "].");
					throw e;
				}
			}
		}
		return lResulValue;
	}

	// #EndRegion#Data Table
	// #Region# Session Data Variable : List<String>
	/**
	 * Add new string for List<String> via Session Data
	 * 
	 * @author Vincent
	 * @param dataKey
	 * @param value
	 */
	public static void addToListString(String dataKey, String value) {
		try {
			List<String> getlString = Serenity.sessionVariableCalled(dataKey);
			getlString.add(value);
			Serenity.setSessionVariable(dataKey).to(getlString);
		} catch (NullPointerException e) {
			System.out.println("***** WARNING ***** : Session Data does not exist: " + dataKey);
			List<String> getlString = new ArrayList<String>();
			getlString.add(value);
			Serenity.setSessionVariable(dataKey).to(getlString);
		}
	}

	/**
	 * Clear all string for List<String> via Session Data
	 * 
	 * @author Vincent
	 * @param dataKey
	 */
	public static void clearListString(String dataKey) {
		try {
			List<String> getlString = Serenity.sessionVariableCalled(dataKey);
			getlString.clear();
			Serenity.setSessionVariable(dataKey).to(getlString);
		} catch (NullPointerException e) {
			System.out.println("***** WARNING ***** : Session Data List String does not exist: " + dataKey);
		}
	}

	/**
	 * Get the last added string for List<String> via Session Data
	 * 
	 * @author Vincent
	 * @param dataKey
	 */
	public static String getListStringLastValue(String dataKey) {
		try {
			List<String> getlString = Serenity.sessionVariableCalled(dataKey);
			return getlString.get(getlString.size() - 1);
		} catch (NullPointerException e) {
			System.out.println("***** WARNING ***** : Session Data List String does not exist: " + dataKey);
			return null;
		}
	}

	/**
	 * Get the last added string for List<String> via Session Data
	 * 
	 * @author Vincent
	 * @param dataKey
	 */
	public static int getListStringValueIndex(String dataKey, String value) {
		try {
			List<String> getlString = Serenity.sessionVariableCalled(dataKey);
			return getlString.indexOf(value);
		} catch (NullPointerException e) {
			System.out.println("***** WARNING ***** : Session Data List String does not exist: " + dataKey);
			return -1;
		}
	}

	/**
	 * Get value string for List<String> via Session Data. Negative number for
	 * get from the last.
	 * 
	 * @author Vincent
	 * @param dataKey
	 * @param index
	 */
	public static String getListStringByIndex(String dataKey, int index) {
		try {
			List<String> getlString = Serenity.sessionVariableCalled(dataKey);
			if (index >= 0) {
				return getlString.get(index - 1);
			} else {
				System.out.println("***** INFO ***** : Session Data [" + dataKey + "] "
						+ System.getProperty("line.separator") + getlString);
				return getlString.get((getlString.size() - 1) + index);
			}
		} catch (NullPointerException e) {
			System.out.println("***** WARNING ***** : Session Data List String does not exist: " + dataKey);
			return null;
		}
	}

	// #EndRegion# Session Data Variable : List<String>
	// #Region# Report
	/**
	 * Generate Data Table Report as String
	 * 
	 * @author Vincent
	 * @param reportKey
	 * @return String
	 */
	public static String generateTbDataReport(String reportKey) {
		List<List<String>> tbReport = Serenity.sessionVariableCalled(reportKey);
		List<List<String>> tbReport1 = new ArrayList<List<String>>();
		for (List<String> temp : tbReport) {
			tbReport1.add(new ArrayList<String>(temp));
		}
		return generateTbDataReport(tbReport1);
	}

	/**
	 * Clear data in Data Table Report
	 * 
	 * @author Vincent
	 * @param reportKey
	 * @return String
	 */
	public static void clearTbDataReport(String reportKey) {
		try {
			List<List<String>> tbReport = Serenity.sessionVariableCalled(reportKey);
			tbReport.clear();
			Serenity.setSessionVariable(reportKey).to(tbReport);
		} catch (NullPointerException e) {
			System.out.println("***** WARNING ***** : Data Table Report does not exist: " + reportKey);
		}
	}

	/**
	 * Add data row to Data Table Report
	 * 
	 * @author Vincent
	 * @param reportKey
	 * @param rowData
	 */
	public static void addRowToTbDataReport(String reportKey, List<String> rowData) {
		List<List<String>> tbReport = new ArrayList<List<String>>();
		try {
			tbReport = Serenity.sessionVariableCalled(reportKey);
			tbReport.add(rowData);
			Serenity.setSessionVariable(reportKey).to(tbReport);
		} catch (NullPointerException e) {
			Serenity.setSessionVariable(reportKey).to(tbReport);
			tbReport = new ArrayList<List<String>>();
			tbReport.add(rowData);
			Serenity.setSessionVariable(reportKey).to(tbReport);
		}
	}

	/**
	 * Generate table data view
	 * 
	 * @author Vincent
	 * @param rawData
	 * @return
	 */
	public static String generateTbDataReport(List<List<String>> rawData) {
		// Get max length of each column
		List<Integer> columnLength = new ArrayList<Integer>();
		for (List<String> row : rawData) {
			// Set max length for each column
			for (int i = 0; i < row.size(); i++) {
				int length = 0;
				if (row.get(i) != null) {
					length = row.get(i).length();
				} else {
					length = 4;
				}

				if (columnLength.size() < i + 1) {// New column
					columnLength.add(length);
				} else {// existed column
					if (columnLength.get(i) < length) {
						columnLength.set(i, length);
					}
				}
			}
		}
		// Set table data as String
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("line.separator"));
		for (List<String> row : rawData) {
			String rowContent = "";
			// Set max length for each column
			for (int i = 0; i < row.size(); i++) {
				String cell = row.get(i);
				if (cell == null) {
					cell = "null";
				}
				int length = columnLength.get(i);
				if (i == 0) {
					row.set(i, "|" + padRight(cell, length) + " | ");
				} else {
					row.set(i, padRight(cell, length) + " | ");
				}
				rowContent += row.get(i);
			}
			sb.append(rowContent);
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

	/**
	 * @author Vincent
	 * @param s
	 * @param n
	 * @return
	 */
	private static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

	public static boolean isSameDecimalValue(String _actual, String _expected) {
		System.out.println("Actual: " + _actual + " Expected: " + _expected);
		int maxlength = 0;
		if (!_actual.contains(".")) {
			_actual += ".";
		}
		if (!_expected.contains(".")) {
			_expected += ".";
		}
		if (_actual.length() >= _expected.length()) {
			maxlength = _actual.length();
		} else {
			maxlength = _expected.length();
		}
		_actual = padRight(_actual, maxlength).replace(' ', '0');
		_expected = padRight(_expected, maxlength).replace(' ', '0');
		if (_actual.equals(_expected)) {
			return true;
		} else {
			return false;
		}
	}
	// #EndRegion# Report

	// #Region#ReadExcelData
	/**
	 * Get cell data value (data in Excel file) from Session Data variable by
	 * key of Excel file, Sheet Name, Column Name and index of row .
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnName
	 * @param _rowIndex
	 * @return
	 */
	public static String getExcelDataVal(String _keyFileName, String _sheetName, String _columnName, int _rowIndex) {
		String ret = "";
		int colIndex = getExcelColNameIndex(_keyFileName, _sheetName, _columnName);
		ret = getExcelSheetData(_keyFileName, _sheetName).get(_rowIndex).get(colIndex);
		return ret;
	}

	/**
	 * Get cell data value (data in Excel file) from Session Data variable by
	 * key of Excel file, Sheet Name, Column Index and index of row. Note,
	 * Column index start from 0
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnIndex
	 * @param _rowIndex
	 * @return
	 */
	public static String getExcelDataVal(String _keyFileName, String _sheetName, int _columnIndex, int _rowIndex) {
		String ret = "";
		ret = getExcelSheetData(_keyFileName, _sheetName).get(_rowIndex).get(_columnIndex);
		return ret;
	}

	/**
	 * Store excel data file (.xls) to session data variable.
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _fileName
	 */
	public static void addExcelData(String _keyFileName, String _fileName) {
		// Get session data
		File file = new File(_fileName);
		Map<String, HashMap<String, LinkedHashMap<Integer, List<String>>>> mSession_ExcelFile = new HashMap<>();
		mSession_ExcelFile = Serenity.sessionVariableCalled(EXCEL_FILE_LIST);
		// If session data not exist then initialize
		if (mSession_ExcelFile == null) {
			Map<String, HashMap<String, LinkedHashMap<Integer, List<String>>>> mExcelFile = new HashMap<>();
			Serenity.setSessionVariable(EXCEL_FILE_LIST).to(mExcelFile);
			mSession_ExcelFile = Serenity.sessionVariableCalled(EXCEL_FILE_LIST);
		}

		// Add data for session data
		HashMap<String, LinkedHashMap<Integer, List<String>>> mAddExcelFile = new HashMap<>();
		System.out.println("***** INFO ***** Loading data from [" + file + "] into [" + _keyFileName + "]");
		mAddExcelFile = loadExcelLinesByHeaderRanger(file);
		mSession_ExcelFile.put(_keyFileName, mAddExcelFile);
		Serenity.setSessionVariable(EXCEL_FILE_LIST).to(mSession_ExcelFile);
		// System.out.println("Import Data: " + mAddExcelFile);

		// Add column index to map
		HashMap<String, LinkedHashMap<String, Integer>> mSheet_ColumnName_ColumnIndex = new HashMap<>();
		// Create session variable store with format "#Excel Files#Key File
		// Name#"
		// Iterator iteSheet = mAddExcelFile.entrySet().iterator();
		Iterator<HashMap.Entry<String, LinkedHashMap<Integer, List<String>>>> iterator = mAddExcelFile.entrySet()
				.iterator();
		while (iterator.hasNext()) { // loop all sheet
			HashMap.Entry<String, LinkedHashMap<Integer, List<String>>> pair = (HashMap.Entry<String, LinkedHashMap<Integer, List<String>>>) iterator
					.next();
			// Get header row
			LinkedHashMap<Integer, List<String>> dataSheet = (LinkedHashMap<Integer, List<String>>) pair.getValue();
			List<String> lColumnHeader = (List<String>) dataSheet.get(0);
			if (lColumnHeader != null) {
				int i = 0;
				LinkedHashMap<String, Integer> mColumnName_Index = new LinkedHashMap<String, Integer>();
				for (String temp : lColumnHeader) {
					mColumnName_Index.put(temp, i);
					i++;
				}
				mSheet_ColumnName_ColumnIndex.put(pair.getKey().toString(), mColumnName_Index);
			}
		}
		Serenity.setSessionVariable(EXCEL_FILE_LIST + _keyFileName + "#").to(mSheet_ColumnName_ColumnIndex);
	}

	/**
	 * Remove (delete) all data of Excel Data in Session Data by Data Key Name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 */
	public static void removeExcelData(String _keyFileName) {
		// Remove data
		Map<String, HashMap<String, LinkedHashMap<Integer, List<String>>>> mSession_ExcelFile = new HashMap<>();
		mSession_ExcelFile = Serenity.sessionVariableCalled(EXCEL_FILE_LIST);
		mSession_ExcelFile.remove(_keyFileName);
		Serenity.setSessionVariable(EXCEL_FILE_LIST).to(mSession_ExcelFile);
		// Remove release data
		Serenity.setSessionVariable(EXCEL_FILE_LIST + _keyFileName + "#").to(null);
	}

	/**
	 * Get all data in Excel Data in Session Data by Excel File Name key
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @return
	 */
	public static HashMap<String, LinkedHashMap<Integer, List<String>>> getExcelData(String _keyFileName) {
		// Get session data
		Map<String, HashMap<String, LinkedHashMap<Integer, List<String>>>> mSessionExcelFile = new HashMap<>();
		mSessionExcelFile = Serenity.sessionVariableCalled(EXCEL_FILE_LIST);
		return mSessionExcelFile.get(_keyFileName);
	}

	/**
	 * Get data in Excel Data Sheet in Session Data by Excel File Name key and
	 * Sheet name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getExcelSheetData(String _keyFileName, String _sheetName) {
		// Get session data
		Map<String, HashMap<String, LinkedHashMap<Integer, List<String>>>> mSessionExcelFile = new HashMap<>();
		mSessionExcelFile = Serenity.sessionVariableCalled(EXCEL_FILE_LIST);
		return mSessionExcelFile.get(_keyFileName).get(_sheetName);
	}

	/**
	 * Get data without column header in Excel Data Sheet in Session Data by
	 * Excel File Name key and Sheet name.
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getExcelSheetDataNoHeader(String _keyFileName,
			String _sheetName) {
		// Get session data
		LinkedHashMap<Integer, List<String>> temp = new LinkedHashMap<Integer, List<String>>(
				getExcelSheetData(_keyFileName, _sheetName));
		temp.remove(0);
		return temp;
	}

	/**
	 * Get index of Column name in Excel Data by Excel File Name key , Sheet
	 * name and Column name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnName
	 * @return
	 */
	public static int getExcelColNameIndex(String _keyFileName, String _sheetName, String _columnName) {
		// Get session data
		Map<String, HashMap<String, Integer>> mSheet_ColumnName_ColumnIndex = new HashMap<>();
		// Generate session variable key
		mSheet_ColumnName_ColumnIndex = Serenity.sessionVariableCalled(getExcelSessionKeyColName(_keyFileName));
		return mSheet_ColumnName_ColumnIndex.get(_sheetName).get(_columnName);
	}

	/**
	 * Get all Column name in Excel Data by Excel File Name key and Sheet Name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @return
	 */

	public static HashMap<String, Integer> getExcelColNameBySheetName(String _keyFileName, String _sheetName) {
		// Get session data
		Map<String, HashMap<String, Integer>> mSheet_ColumnName_ColumnIndex = new HashMap<>();
		// Generate session variable key
		mSheet_ColumnName_ColumnIndex = Serenity.sessionVariableCalled(getExcelSessionKeyColName(_keyFileName));
		return mSheet_ColumnName_ColumnIndex.get(_sheetName);
	}

	/**
	 * Get list of all rows in Excel Data which Cell value contain given value
	 * by Excel File Name key , Sheet name and Column name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnName
	 * @param _givenValue
	 * @return
	 */
	public static List<Integer> getExcelRowNumsContainVal(String _keyFileName, String _sheetName, String _columnName,
			String _givenValue) {
		// Get column index
		List<Integer> lResultRowNums = new ArrayList<Integer>();
		int columnIndex = getExcelColNameIndex(_keyFileName, _sheetName, _columnName);
		// Get data sheet
		LinkedHashMap<Integer, List<String>> lhSheet_data = getExcelSheetData(_keyFileName, _sheetName);
		// Get data row list
		for (Integer key : lhSheet_data.keySet()) {
			if (lhSheet_data.get(key).size() == 0) {
				System.out.println("Warning : No data in row " + key + "of" + _keyFileName + "#" + _sheetName);
			} else {
				try {
					if (lhSheet_data.get(key).get(columnIndex).contains(_givenValue)) {
						lResultRowNums.add(key);
					}
				} catch (Exception e) {
					System.out.println(
							"Error : Incorret data format with row  " + key + "of" + _keyFileName + "#" + _sheetName);
					throw e;
				}
			}
		}
		return lResultRowNums;
	}

	/**
	 * Get list of all rows in Excel Data which Cell value contain given value
	 * by Excel File Name key , Sheet name and Column name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnName
	 * @param _givenValue
	 * @return
	 */
	public static List<Integer> getExcelRowNumsEqualVal(String _keyFileName, String _sheetName, String _columnName,
			String _givenValue) {
		// Get column index
		List<Integer> lResultRowNums = new ArrayList<Integer>();
		int columnIndex = getExcelColNameIndex(_keyFileName, _sheetName, _columnName);
		// Get data sheet
		LinkedHashMap<Integer, List<String>> lhSheet_data = getExcelSheetData(_keyFileName, _sheetName);
		// Get data row list
		for (Integer key : lhSheet_data.keySet()) {
			if (lhSheet_data.get(key).size() == 0) {
				System.out.println("Warning : No data in row " + key + "of" + _keyFileName + "#" + _sheetName);
			} else {
				try {
					if (lhSheet_data.get(key).get(columnIndex).equals(_givenValue)) {
						lResultRowNums.add(key);
					}
				} catch (Exception e) {
					System.out.println(
							"Error : Incorret data format with row  " + key + "of" + _keyFileName + "#" + _sheetName);
					throw e;
				}
			}
		}
		return lResultRowNums;
	}

	/**
	 * Get data rows in Excel Data which Cell value contain given value by Excel
	 * File Name key , Sheet name and Column name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnName
	 * @param _givenValue
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getExcelDataRowsContainVal(String _keyFileName,
			String _sheetName, String _columnName, String _givenValue) {
		// Get column index
		LinkedHashMap<Integer, List<String>> lResultRowNums = new LinkedHashMap<Integer, List<String>>();
		int columnIndex = getExcelColNameIndex(_keyFileName, _sheetName, _columnName);
		// Get data sheet
		LinkedHashMap<Integer, List<String>> lhSheet_data = getExcelSheetData(_keyFileName, _sheetName);
		// Get data row list
		for (Integer key : lhSheet_data.keySet()) {
			if (lhSheet_data.get(key).size() == 0) {
				System.out.println("Warning : No data in row " + key + "of" + _keyFileName + "#" + _sheetName);
			} else {
				try {
					if (lhSheet_data.get(key).get(columnIndex).contains(_givenValue)) {
						lResultRowNums.put(key, lhSheet_data.get(key));
					}
				} catch (Exception e) {
					System.out.println(
							"Error : Incorret data format with row  " + key + "of" + _keyFileName + "#" + _sheetName);
					throw e;
				}
			}
		}
		return lResultRowNums;
	}

	/**
	 * Get data rows in Excel Data which Cell value equal given value by Excel
	 * File Name key , Sheet name and Column name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _columnName
	 * @param _givenValue
	 * @return
	 */
	public static LinkedHashMap<Integer, List<String>> getExcelDataRowsEqualVal(String _keyFileName, String _sheetName,
			String _columnName, String _givenValue) {
		// Get column index
		LinkedHashMap<Integer, List<String>> lResultRowNums = new LinkedHashMap<Integer, List<String>>();
		int columnIndex = getExcelColNameIndex(_keyFileName, _sheetName, _columnName);
		// Get data sheet
		LinkedHashMap<Integer, List<String>> lhSheet_data = getExcelSheetData(_keyFileName, _sheetName);
		// Get data row list
		for (Integer key : lhSheet_data.keySet()) {
			if (lhSheet_data.get(key).size() == 0) {
				System.out.println("Warning : No data in row " + key + "of" + _keyFileName + "#" + _sheetName);
			} else {
				try {
					if (lhSheet_data.get(key).get(columnIndex).equals(_givenValue)) {
						lResultRowNums.put(key, lhSheet_data.get(key));
					}
				} catch (Exception e) {
					System.out.println(
							"Error : Incorret data format with row  " + key + "of" + _keyFileName + "#" + _sheetName);
					throw e;
				}
			}
		}
		return lResultRowNums;
	}

	/**
	 * Get list of Cell value in Excel Data by reference value of reference
	 * Column name
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @param _sheetName
	 * @param _refColName
	 * @param _refValue
	 * @param _givenColName
	 * @return
	 */
	public static List<String> getExcelValsByRefVal(String _keyFileName, String _sheetName, String _refColName,
			String _refValue, String _givenColName) {
		// Get column index
		int refColIndex = getExcelColNameIndex(_keyFileName, _sheetName, _refColName);
		int givenColIndex = getExcelColNameIndex(_keyFileName, _sheetName, _givenColName);
		List<String> lResulValue = new ArrayList<String>();
		// Get data sheet
		LinkedHashMap<Integer, List<String>> lhSheet_data = getExcelSheetData(_keyFileName, _sheetName);
		// Get data row list
		for (Integer key : lhSheet_data.keySet()) {
			if (lhSheet_data.get(key).size() == 0) {
				System.out.println("Warning : No data in row " + key + "of" + _keyFileName + "#" + _sheetName);
			} else {
				try {
					if (lhSheet_data.get(key).get(refColIndex).equals(_refValue)) {
						lResulValue.add(lhSheet_data.get(key).get(givenColIndex));
					}
				} catch (Exception e) {
					System.out.println(
							"Error : Incorret data format with row  " + key + "of" + _keyFileName + "#" + _sheetName);
					throw e;
				}
			}
		}
		return lResulValue;
	}

	/**
	 * Get Key name of Column in Excel Data
	 * 
	 * @author Vincent
	 * @param _keyFileName
	 * @return
	 */
	private static String getExcelSessionKeyColName(String _keyFileName) {
		return EXCEL_FILE_LIST + _keyFileName + "#";
	}

	/**
	 * Load all data from Excel file to raw data
	 * 
	 * @author Vincent
	 * @param _fileName
	 * @return
	 */

	private static HashMap<String, LinkedHashMap<Integer, List<String>>> loadExcelLinesByHeaderRanger(File _fileName) {
		// Used the LinkedHashMap and LikedList to maintain the order
		HashMap<String, LinkedHashMap<Integer, List<String>>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List<String>>>();
		LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
		String _sheetName = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(_fileName);
			// Create an excel workbook from the file system
			HSSFWorkbook workBook = new HSSFWorkbook(fis);
			// Get the first sheet on the workbook.
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				HSSFSheet sheet = workBook.getSheetAt(i);
				// XSSFSheet sheet = workBook.getSheetAt(0);
				_sheetName = workBook.getSheetName(i);
				int countCellInRowHeader = 0;
				Iterator<Row> rows = sheet.rowIterator();
				while (rows.hasNext()) {
					HSSFRow row = (HSSFRow) rows.next();
					HSSFCell cell;
					List<String> data = new LinkedList<String>();
					if (countCellInRowHeader == 0) { // Get the header size
						Iterator<Cell> cells = row.cellIterator();
						while (cells.hasNext()) {
							HSSFCell cellCol = (HSSFCell) cells.next();
							cellCol.setCellType(Cell.CELL_TYPE_STRING);
							data.add(cellCol.toString());
						}
						countCellInRowHeader = data.size();
						System.out.println("HEADER COLUMN NAME of SHEET : [" + sheet.getSheetName() + "]");
						System.out.println(data);
						hashMap.put(row.getRowNum(), data);
					} else {
						for (int j = 0; j < countCellInRowHeader; j++) {
							cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							data.add(cell.toString());
						}
						hashMap.put(row.getRowNum(), data);
					}
				}
				outerMap.put(_sheetName, hashMap);
				hashMap = new LinkedHashMap<Integer, List<String>>();
				workBook.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return outerMap;
	}

	/**
	 * Load all data in specific Sheet of Excel File to raw data.
	 * 
	 * @author Vincent
	 * @param _fileName
	 * @param _sheetName
	 * @return
	 */
	private static LinkedHashMap<Integer, List<String>> loadExcelLinesByHeaderRanger(File _fileName,
			String _sheetName) {
		// Used the LinkedHashMap to maintain the order of data
		LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(_fileName);
			// Create an excel workbook from the file system
			HSSFWorkbook workBook = new HSSFWorkbook(fis);
			// Get sheet on the workbook.
			HSSFSheet sheet = workBook.getSheet(_sheetName);
			// XSSFSheet sheet = workBook.getSheetAt(0);
			int countCellInRowHeader = 0;
			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				HSSFCell cell;
				List<String> data = new LinkedList<String>();
				if (countCellInRowHeader == 0) { // Get the header size
					Iterator<Cell> cells = row.cellIterator();
					while (cells.hasNext()) {
						HSSFCell cellCol = (HSSFCell) cells.next();
						cellCol.setCellType(Cell.CELL_TYPE_STRING);
						data.add(cellCol.toString());
					}
					countCellInRowHeader = data.size();
					System.out.println("HEADER COLUMN NAME of SHEET : [" + sheet.getSheetName() + "]");
					System.out.println(data);
				} else {
					for (int j = 0; j < countCellInRowHeader; j++) {
						cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						data.add(cell.toString());
					}
				}
				hashMap.put(row.getRowNum(), data);
			}
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return hashMap;
	}
	// #EndRegion#ReadExcelData
}
