package com.synergix.report.pages;

import static org.junit.Assert.fail;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @version 20160406
 */
public class CommonReportPage extends TH5PageObject {
	public CommonReportPage(WebDriver driver) {
		super(driver);
	}

	// Report Parameter
	/**
	 * @Description Set parameter for Report Parameter. Supported parameter
	 * type: Radio,Input,Select,Search,Checkbox
	 * @author Vincent
	 * @param _parameterName
	 * @param _parameterNameIndex
	 * @param _parameterType
	 * @param _parameterValue
	 */
	private String xPathPanelReportParameters = "//*[text()='Report Parameters']//ancestor::fieldset[1]";

	public void set_report_parameter(String _parameterName, int _parameterNameIndex, String _parameterType,
	                                 String _parameterValue1, String _parameterValue2) {
		switch (_parameterType) {
			case "Radio":
				selectRadioButton(xPathRadioBtnWithGroupLabel(xPathPanelReportParameters, _parameterName,
						_parameterNameIndex, _parameterValue1));
				break;
			case "Input":
				if (!_parameterValue1.isEmpty()) {
					enterInputFieldWithLabel(xPathPanelReportParameters, _parameterName, _parameterValue1,
							_parameterNameIndex);
				}
				if (!_parameterValue2.isEmpty()) {
					enterInputFieldWithLabel(xPathPanelReportParameters, _parameterName, _parameterValue2,
							_parameterNameIndex + 1);
				}
				break;
			case "Select":
				waitForAllJSCompletes();
				selectDdlWithLabelByText(xPathPanelReportParameters, _parameterName, _parameterNameIndex, _parameterValue1);
				break;
			case "Search":
				try {
					String[] asConfigValue = _parameterValue1.split(">");
					clickSearchIconWithLabel(xPathPanelReportParameters, _parameterName, _parameterNameIndex);
					if (!search(asConfigValue[0], asConfigValue[1])) {
						fail(asConfigValue[0] + " not found: " + asConfigValue[1]);
					}
				} catch (Exception e) {
					fail("Incorrect format of parameter value: " + _parameterValue1);
				}
				break;
			case "Checkbox":
				setChkbox(xPathChkboxWithGroupLabel(xPathPanelReportParameters, _parameterName, ""), _parameterValue1);
				break;
			case "Multi Checkbox":
				setChkbox(xPathChkboxWithGroupLabel(_parameterName, _parameterValue1), "Yes");
				break;
			default:
				fail("Incorrect parameter type or not support this parameter type yet: " + _parameterType);
				break;
		}
	}

	// Report Templates
	private String xPathPanelReportTemplate = "//*[text()='Report Templates']//ancestor::fieldset[1]";

	public void click_btn_load_template() {
		clickBtn(xPathPanelReportTemplate, "Load Template");
	}

	public void click_btn_save_as_new_template() {
		clickBtn(xPathPanelReportTemplate, "Save As New Template");
	}

	public void click_btn_save_back_to_loaded_template() {
		clickBtn(xPathPanelReportTemplate, "Save Back To Loaded Template");
	}

	private String xPathPanelNewTemplate = "//*[contains(text(),'New Template')]//ancestor::table[1]";

	public void click_btn_new_temp_submit() {
		clickBtn(xPathPanelNewTemplate, "Submit");
	}

	public void click_btn_new_temp_cancel() {
		clickBtn(xPathPanelNewTemplate, "Cancel");
	}

	public void enter_new_temp_name(String _templateName) {
		enterInputFieldWithLabel(xPathPanelNewTemplate, "Template Name", _templateName);
	}

	public void enter_new_temp_desc(String _templateDesc) {
		enterInputFieldWithLabel(xPathPanelNewTemplate, "Template Desc", _templateDesc);
	}

	// Template List
	private String xPathPanelTemplateList = "//*[contains(text(),'Template List')]//ancestor::table[1]";

	public void click_btn_tepm_list_done() {
		clickBtn(xPathPanelTemplateList, "Done");
	}

	public int select_temp_by_template_name(String _tempName) {
		int rowIndex = searchInTbMultiPage(xPathPanelTemplateList, "Template Name", 1, _tempName, true);
		clickOnElement(xPathTbDataCellByPosition(xPathPanelTemplateList, rowIndex, 1) + "//a");
		return rowIndex;
	}

	public int select_temp_by_template_desc(String _tempDesc) {
		int rowIndex = searchInTbMultiPage(xPathPanelTemplateList, "Template Desc", 1, _tempDesc, true);
		clickOnElement(xPathTbDataCellByPosition(xPathPanelTemplateList, rowIndex, 2) + "//a");
		return rowIndex;
	}

	// Report Export
	private String xPathPanelReportExport = "//*[text()='Report Export']//ancestor::fieldset[1]";
	private String xPathPanelAdvanceOption = "//*[contains(text(),'Advance Options')]//ancestor::table[1]";

	public void click_btn_generate_report() {
		clickBtn(xPathPanelReportExport, "Generate Report");
	}

	public void select_format_report_export(String _format) {
		selectDdlWithLabelByText(xPathPanelReportExport, "Format", _format);
	}

	public void click_btn_advance_options() {
		clickBtn(xPathPanelReportExport, "Advance Options");
	}

	public void click_btn_done_advance_options() {
		clickBtn(xPathPanelAdvanceOption, "Done");
	}

	public void set_ignore_pagination(String _value) {
		setChkbox(xPathChkboxWithGroupLabel(xPathPanelAdvanceOption, "Ignore Pagination", ""), _value);
	}

	public void enter_maximum_result_size(String _maximumResultSize) {
		enterInputFieldWithLabel(xPathPanelAdvanceOption, "Maximum Result Size", _maximumResultSize);
	}

	public boolean switch_to_pdf_preview_report_window(int _timeoutInSeconds) {
		int polling = 0;
		_timeoutInSeconds = _timeoutInSeconds * 1000; // Convert from second to
		// millisecond
		boolean ret = false;
		do {
			waitABit(500);
			polling += 500;
			for (String sHandle : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(sHandle);
				if (getDriver().getTitle().contains("jasperReport.seam")) {
					ret = true;
					waitABit(1000);
					break;
				}
			}
		} while (polling < _timeoutInSeconds && ret == false);
		return ret;
	}

	public boolean verify_pdf_preview_report_content(String _givenContent) {
		String[] tokens = _givenContent.split(" ");
		int numText = tokens.length;
		String xPathSearchPattern = "";
		if (numText > 1) {
			xPathSearchPattern = "contains(*,'" + tokens[0] + "')";
			for (int i = 1; i < numText; i++) {
				xPathSearchPattern += " and contains(*,'" + tokens[i] + "')";
			}
			xPathSearchPattern = "//body[" + xPathSearchPattern + "]";
		} else {
			xPathSearchPattern = "//body[contains(*,'" + _givenContent + "')]";
		}
		if (isElementVisibleNoA4J(xPathSearchPattern, 5)) {
			return true;
		}
		return false;
	}

	// Report Filters
	private String xPathPanelReportFilters = "//*[text()='Report Filters']//ancestor::fieldset[1]";

	public void select_field_report_filters(String _selectField) {
		selectDdlWithLabelByText(xPathPanelReportFilters, "Select Field", _selectField);
	}

	public void click_btn_add_report_filters() {
		clickBtn(xPathPanelReportFilters, "Add");
	}

	public int get_row_index_by_column_name_report_filters(String _value) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelReportFilters, _value, 1, 1));
	}

	public void select_filter_type_report_filter(int _rowIndex, String _filterType) {
		String xpath = "((" + xPathPanelReportFilters + "//tbody[preceding::thead])[" + "contains(@id,'tblColumnFilter')"
				+ "]/tr/td[contains(@class,'cell')][2])[" + _rowIndex + "]" + "//select";

		selectDdlByText(xpath, _filterType);
	}

	public void enter_filterdata_value1(int _rowIndex, String _value1) {
		String xpath = "((" + xPathPanelReportFilters + "//tbody[preceding::thead])[" + "contains(@id,'tblColumnFilter')"
				+ "]/tr/td[contains(@class,'cell')][3])[" + _rowIndex + "]" + "//input[@type='text'][1]";

		waitTypeAndEnterThenUpdateValue(xpath, _value1);
	}

	public void enter_filterdata_value2(int _rowIndex, String _value2) {
		waitTypeAndEnterThenUpdateValue("(" + xPathTbDataCellByPositionAndBodyPredicate(xPathPanelReportFilters,
				"contains(@id,'tblColumnFilter')", _rowIndex, 3) + "//input[@type='text'])[2]", _value2);
	}

	// Report Sorters
	private String xPathPanelReportSorters = "//*[text()='Report Sorters']//ancestor::fieldset[1]";

	public void select_field_report_sorters(String _selectField) {
		waitForAllJSCompletes();
		selectDdlWithLabelByText(xPathPanelReportSorters, "Select Field", _selectField);
		waitForAllJSCompletes();
	}

	public void click_btn_add_report_sorters() {
		clickBtn(xPathPanelReportSorters, "Add");
	}

	public int get_row_index_by_column_name_report_sorters(String _value) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelReportSorters, _value, 1, 1));
	}

	public void select_sorter_type_report_sorter(int _rowIndex, String _sorterType) {
		waitForAllJSCompletes();
		selectDdlByText(xPathTbDataCellByPositionAndBodyPredicate(xPathPanelReportSorters,
				"contains(@id,'tblColumnSort')", _rowIndex, 2) + "//select", _sorterType);
		waitForAllJSCompletes();
	}

	// Report Sorters
	private String xPathPanelReportGroups = "//*[text()='Report Groups']//ancestor::fieldset[1]";

	public void select_field_report_groups(String _selectField) {
		waitForAllJSCompletes();
		selectDdlWithLabelByText(xPathPanelReportGroups, "Select Field", _selectField);
		waitForAllJSCompletes();
	}

	public void click_btn_add_report_groups() {
		clickBtn(xPathPanelReportGroups, "Add");
		waitForAllJSCompletes();
	}

	public int get_row_index_by_column_name_report_groups(String _value) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelReportGroups, _value, 1, 1));
	}

	// Report Column
	public void set_report_column(String _columnName, String _value) {
		String parentXpath = "//table[contains(@id,'tblPrintColumns')]";
		int headerIndex = getTbColHeaderIndex(parentXpath, _columnName);
		setChkbox(xPathTbDataCellByPosition(parentXpath, 1, headerIndex) + "//input[@type='checkbox']", _value);
	}

	public String getNatureGlEntry(String account, String kind) {
		int colIndex = 0;
		switch (kind) {
			case "Debit":
				colIndex = 6;
				break;
			case "Credit":
				colIndex = 7;
				break;
		}
		String xpath = "(//table/tbody/tr[td[4][.='" + account.toString() + "']]/td[" + colIndex +"])[1]";
		return $(xpath).getText();
	}

	public String getNatureGlEntry(String kind) {
		int colIndex = 0;
		switch (kind) {
			case "Debit":
				colIndex = 3;
				break;
			case "Credit":
				colIndex = 4;
				break;
		}
		String xpath = "//table/tbody/tr[td[2]/p/span[contains(text(),'Total')]]/td[" + colIndex+ "]";
		return $(xpath).getText();
	}

	public String getHomeGlEntry(String account, String kind) {
		int colIndex = 0;
		switch (kind) {
			case "Debit":
				colIndex = 6;
				break;
			case "Credit":
				colIndex = 7;
				break;
		}
		String xpath = "(//table/tbody/tr[td[4][.='" + account.toString() + "']]/following-sibling::tr[1]/td[" + colIndex +"])[1]";
		return $(xpath).getText();
	}

	public String getHomeGlEntry(String kind) {
		int colIndex = 0;
		switch (kind) {
			case "Debit":
				colIndex = 1;
				break;
			case "Credit":
				colIndex = 2;
				break;
		}
		String xpath = "(//table/tbody/tr[td[2]/p/span[contains(text(),'Total')]]/following-sibling::tr[1]//tbody/tr/td/p/span)["+ colIndex+"]";
		return $(xpath).getText();
	}
}