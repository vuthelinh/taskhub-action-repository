package com.synergix.report.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.synergix.report.pages.CommonReportPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160406
 */
public class CommonReportSteps extends ScenarioSteps {

	CommonReportPage commonReportPage;

	// Report Templates
	@Step
	public void click_btn_load_template() {
		commonReportPage.click_btn_load_template();
	}

	@Step
	public void click_btn_save_as_new_template() {
		commonReportPage.click_btn_save_as_new_template();
	}

	@Step
	public void click_btn_save_back_to_loaded_template() {
		commonReportPage.click_btn_save_back_to_loaded_template();
	}

	@Step
	public void click_btn_new_temp_submit() {
		commonReportPage.click_btn_new_temp_submit();
	}

	@Step
	public void click_btn_new_temp_cancel() {
		commonReportPage.click_btn_new_temp_cancel();
	}

	@Step
	public void enter_new_temp_name(String _templateName) {
		commonReportPage.enter_new_temp_name(_templateName);
	}

	@Step
	public void enter_new_temp_desc(String _templateDesc) {
		commonReportPage.enter_new_temp_desc(_templateDesc);
	}

	// Template List
	@Step
	public void click_btn_tepm_list_done() {
		commonReportPage.click_btn_tepm_list_done();
	}

	@Step
	public int select_temp_by_template_name(String _tempName) {
		return commonReportPage.select_temp_by_template_name(_tempName);
	}

	@Step
	public int select_temp_by_template_desc(String _tempDesc) {
		return commonReportPage.select_temp_by_template_desc(_tempDesc);
	}

	// Report Export
	@Step
	public void click_btn_generate_report() {
		commonReportPage.click_btn_generate_report();
		assertThat(commonReportPage.getErrorMessagesThenClickOK() == null).isTrue();
	}

	@Step
	public void select_format_report_export(String _format) {
		commonReportPage.select_format_report_export(_format);
	}

	@Step
	public void click_btn_advance_options() {
		commonReportPage.click_btn_advance_options();
	}

	@Step
	public void click_btn_done_advance_options() {
		commonReportPage.click_btn_done_advance_options();
	}

	@Step
	public void set_ignore_pagination(String _value) {
		commonReportPage.set_ignore_pagination(_value);
	}

	@Step
	public void enter_maximum_result_size(String _maximumResultSize) {
		commonReportPage.enter_maximum_result_size(_maximumResultSize);
	}

	@Step
	public String getCurrentWindowHandle() {
		return commonReportPage.getCurrentWindowHandle();
	}

	@Step
	public boolean switchToWindowHandle(String _handle) {
		return commonReportPage.switchToWindowHandle(_handle);
	}

	@Step
	public boolean switch_to_pdf_preview_report_window() {
		return commonReportPage.switch_to_pdf_preview_report_window(10);
	}

	@Step
	public boolean verify_pdf_preview_report_content(String _givenContent) {
		return commonReportPage.verify_pdf_preview_report_content(_givenContent);
	}

	// Report Parameter
	@Step
	public void set_report_parameter(String _parameterName, int _parameterNameIndex, String _parameterType,
			String _parameterValue1, String _parameterValue2) {
		commonReportPage.set_report_parameter(_parameterName, _parameterNameIndex, _parameterType, _parameterValue1,
				_parameterValue2);
	}

	// Report Filters
	@Step
	public void select_field_report_filters(String _selectField) {
		commonReportPage.select_field_report_filters(_selectField);
	}

	@Step
	public void click_btn_add_report_filters() {
		commonReportPage.click_btn_add_report_filters();
	}

	@Step
	public int get_row_index_by_column_name_report_filters(String _value) {
		return commonReportPage.get_row_index_by_column_name_report_filters(_value);
	}

	@Step
	public void select_filter_type_report_filter(int _rowIndex, String _filterType) {
		commonReportPage.select_filter_type_report_filter(_rowIndex, _filterType);
	}

	@Step
	public void enter_filterdata_value1(int _rowIndex, String _value1) {
		commonReportPage.enter_filterdata_value1(_rowIndex, _value1);
	}

	@Step
	public void enter_filterdata_value2(int _rowIndex, String _value2) {
		commonReportPage.enter_filterdata_value2(_rowIndex, _value2);
	}

	// Report Sorters
	@Step
	public void select_field_report_sorters(String _selectField) {
		commonReportPage.select_field_report_sorters(_selectField);
	}

	@Step
	public void click_btn_add_report_sorters() {
		commonReportPage.click_btn_add_report_sorters();
	}

	@Step
	public int get_row_index_by_column_name_report_sorters(String _value) {
		return commonReportPage.get_row_index_by_column_name_report_sorters(_value);
	}

	@Step
	public void select_sorter_type_report_sorter(int _rowIndex, String _sorterType) {
		commonReportPage.select_sorter_type_report_sorter(_rowIndex, _sorterType);
	}

	// Report Groups
	@Step
	public void select_field_report_groups(String _selectField) {
		commonReportPage.select_field_report_groups(_selectField);
	}

	@Step
	public void click_btn_add_report_groups() {
		commonReportPage.click_btn_add_report_groups();
	}

	@Step
	public int get_row_index_by_column_name_report_groups(String _value) {
		return commonReportPage.get_row_index_by_column_name_report_groups(_value);
	}

	// Report Column
	@Step
	public void set_report_column(String columnName, String value) {
		commonReportPage.set_report_column(columnName, value);
	}

	@Step
	public void verify_gl_entry_nature(String account, String kind, String nature) {
		assertThat(Float.parseFloat(commonReportPage.getNatureGlEntry(account, kind).replaceAll(",", "")))
				.isEqualTo(Float.parseFloat(nature));
	}

	@Step
	public void verify_gl_entry_home(String account, String kind, String home) {
		assertThat(Float.parseFloat(commonReportPage.getHomeGlEntry(account, kind).replaceAll(",", "")))
				.isEqualTo(Float.parseFloat(home));
	}

	@Step
	public void verify_gl_entry_total_nature(String kind, String nature) {
		assertThat(Float.parseFloat(commonReportPage.getNatureGlEntry(kind).replaceAll(",", "")))
				.isEqualTo(Float.parseFloat(nature));
	}

	@Step
	public void verify_gl_entry_total_home(String kind, String home) {
		assertThat(Float.parseFloat(commonReportPage.getHomeGlEntry(kind).replaceAll(",", "")))
				.isEqualTo(Float.parseFloat(home));
	}

	@Step
	public void click_btn_generate_html_report() {
		commonReportPage.click_btn_generate_report();
	}
}