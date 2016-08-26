package com.synergix.processing.payroll.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160727
 */
public class PayrollAddPaymentByRecipientPage extends TH5PageObject {
	public PayrollAddPaymentByRecipientPage(WebDriver driver) {
		super(driver);
	}

	// BEGIN Common
	private String xPathPanelConfirmSubmit = "//div[text() = 'Confirmation' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_btn_confirm_submit_yes() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void click_btn_confirm_submit_no() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	// END Common

	// private static final String sPageHeader = "Additional Payment";
	// BEGIN Summary
	private String xPathPanelAddPaymentByRecipientSummary = "(//table[@id='mainPanel']//td[not(contains(@style,'display: none'))]//table[@id='byRecipientTab'])[1]";

	public void switch_tab_by_recipient() {
		switch_to_tab("By Recipient");
	}

	public boolean is_tab_active_by_recipient() {
		return isTabActive(xPathPanelAddPaymentByRecipientSummary, "By Recipient");
	}

	public void switch_tab_draft() {
		switch_to_tab(xPathPanelAddPaymentByRecipientSummary, "Draft");
	}

	public boolean is_tab_active_draft() {
		return isTabActive(xPathPanelAddPaymentByRecipientSummary, "Draft");
	}

	public void switch_tab_outstanding() {
		switch_to_tab(xPathPanelAddPaymentByRecipientSummary, "Outstanding");
	}

	public boolean is_tab_active_outstanding() {
		return isTabActive(xPathPanelAddPaymentByRecipientSummary, "Draft");
	}

	public void switch_tab_history() {
		switch_to_tab(xPathPanelAddPaymentByRecipientSummary, "History");
	}

	public boolean is_tab_active_history() {
		return isTabActive(xPathPanelAddPaymentByRecipientSummary, "History");
	}

	public void switch_tab_pending_approval() {
		switch_to_tab(xPathPanelAddPaymentByRecipientSummary, "Pending Approval");
	}

	public boolean is_tab_active_pending_approval() {
		return isTabActive(xPathPanelAddPaymentByRecipientSummary, "Pending Approval");
	}

	public void filter_by_voucher_no(String voucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher No."), voucherNo);
	}

	public void clear_filter_by_voucher_no(String voucherNo) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher No."), "");
	}

	public void sort_filter_by_voucher_no() {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher No.", 1) + "//span[last()]");
	}

	public void filter_by_payroll_date(String payrollDateFrom, String payrollDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Payroll Date From To"),
				payrollDateFrom, payrollDateTo);
	}

	public void clear_filter_by_payroll_date() {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Payroll Date From To"), "",
				"");
	}

	public void sort_filter_by_payroll_date() {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Payroll Date From To", 1)
				+ "//span[last()]");
	}

	public void filter_by_voucher_date(String voucherDateFrom, String voucherDateTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher Date From To"),
				voucherDateFrom, voucherDateTo);
	}

	public void clear_filter_by_voucher_date() {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher Date From To"), "",
				"");
	}

	public void sort_filter_by_voucher_date() {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher Date From To", 1)
				+ "//span[last()]");
	}

	public void filter_by_voucher_desc(String voucherDesc) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher Desc"), voucherDesc);
	}

	public void clear_filter_by_voucher_desc() {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher Desc"), "");
	}

	public void sort_filter_by_voucher_desc() {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Voucher Desc", 1) + "//span[last()]");
	}

	public void filter_by_recipient(String recipient) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient"), recipient);

	}

	public void clear_filter_by_recipient(String recipient) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient"), "");
	}

	public void sort_filter_by_recipient(String recipient) {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient", 1) + "//span[last()]");
	}

	public void filter_by_recipient_name(String recipientName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient Name"), recipientName);
	}

	public void clear_filter_by_recipient_name() {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient Name"), "");
	}

	public void sort_filter_by_recipient_name() {
		clickOnElement(
				xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient Name", 1) + "//span[last()]");
	}

	public void filter_by_recipient_short_name(String recipientShortName) {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient Short Name"),
				recipientShortName);
	}

	public void clear_filter_by_recipient_short_name() {
		filterDataByHeader(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient Short Name"), "");
	}

	public void sort_filter_by_recipient_short_name() {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Recipient Short Name", 1)
				+ "//span[last()]");
	}

	public void filter_by_created_by(String createdByFrom, String createdByTo) {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Created Datetime From To"),
				createdByFrom, createdByTo);
	}

	public void clear_filter_by_created_by() {
		filterDataByHeaderDate(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Created Datetime From To"),
				"", "");
	}

	public void sort_filter_by_created_by() {
		clickOnElement(xPathTbHeaderCell(xPathPanelAddPaymentByRecipientSummary, "Created Datetime From To", 1)
				+ "//span[last()]");
	}

	public void open_first_voucher_no() {
		int headerIndex = getTbColHeaderIndex(xPathPanelAddPaymentByRecipientSummary, "Voucher No.");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelAddPaymentByRecipientSummary, 1, headerIndex) + "//a");
	}

	// END Summary

	// BEGIN Draft
	public void switch_tab_draft_by_recipient(String byRecipient) {
		switch_to_tab("By Recipient");
	}

	public boolean is_tab_active_draft_by_recipient(String byRecipient) {
		return isTabActive("By Recipient");
	}

	public void switch_tab_draft_remark() {
		switch_to_tab("Remarks");
	}

	public boolean is_tab_active_draft_remark(String remark) {
		return isTabActive("Remarks");
	}

	public void switch_tab_draft_attachments(String attachments) {
		switch_to_tab("Attachments");
	}

	public boolean is_tab_active_draft_attachments(String attachments) {
		return isTabActive("Attachments");
	}

	public void click_btn_new() {
		clickBtn(xPathPanelAddPaymentByRecipientSummary, "New");
	}

	public boolean is_btn_clickable_new() {
		return isElementClickable(xPathBtn("New"), 1);
	}

	public void click_btn_abort() {
		clickBtn("Abort");
	}

	public boolean is_btn_clickable_abort() {
		return isElementClickable(xPathBtn("Abort"), 1);
	}

	public void click_btn_submit() {
		clickBtn("Submit");
	}

	public boolean is_btn_clickable_submit() {
		return isElementClickable(xPathBtn("Submit"), 1);
	}

	public void click_btn_back_to_summary() {
		clickBtn("Back To Summary");
	}

	public boolean is_btn_clickable_back_to_summary(String backToSummary) {
		return isElementClickable(xPathBtn("Back To Summary"), 1);
	}

	// public void enter_voucher_no(String voucherNo){}
	public String get_text_voucher_no() {
		return getTextWithLabel("Voucher No.");
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public String get_text_description() {
		return getTextValueWithLabel("Description");
	}

	// public String is_enabled_description(String description){
	// }
	// public String is_readonly_description(String description){
	// }
	public void select_voucher_type(String voucherType) {
		selectRadioButton("Voucher Type", voucherType);
	}

	// public boolean is_selected_voucher_type(String voucherType){
	//
	// }
	// public boolean is_enabled_voucher_type(String voucherType){
	//
	// }
	public void enter_voucher_date(String voucherDate) {
		enterInputFieldWithLabel("Voucher Date", voucherDate);
	}

	public String get_text_voucher_date() {
		return getTextValueWithLabel("Voucher Date");
	}
	// public String is_enabled_voucher_date(String voucherDate){
	//
	// }
	// public String is_readonly_voucher_date(String voucherDate){
	//
	// }

	// BEGIN By Recipient

	public void enter_recipient(String recipient) {
		enterInputFieldWithLabel("Recipient", recipient, 1);
	}

	public String get_text_recipient() {
		return getTextValueWithLabel("Recipient", 1);
	}

	public String get_text_recipient_name() {
		return getTextValueWithLabel("Recipient", 2);
	}

	// public String is_enabled_recipient(String recipient){}
	// public String is_readonly_recipient(String recipient){}
	public void enter_payroll_date(String payrollDate) {
		if (payrollDate.equals("@CurrentDate@")) {
			calendarSetTodayWithLabel("Payroll Date");
		} else {
			enterInputFieldWithLabel("Payroll Date", payrollDate);
		}
	}

	public String get_text_payroll_date(String payrollDate) {
		return getTextWithLabel("Payroll Date");
	}

	// public String is_enabled_payroll_date(String payrollDate){}
	// public String is_readonly_payroll_date(String payrollDate){}
	private String xPathPanelWageServices = "(//div[@id='wservicePanel_body'])[1]";

	public void click_btn_ws_add() {
		clickBtn(xPathPanelWageServices, "Add");
	}

	public boolean is_btn_clickable_ws_add() {
		return isElementClickable(xPathBtn(xPathPanelWageServices, "Add"), 1);
	}

	public void click_btn_ws_delete(String delete) {
		clickBtn(xPathPanelWageServices, "Delete");
	}

	public boolean is_btn_clickable_ws_delete(String delete) {
		return isElementClickable(xPathBtn(xPathPanelWageServices, "Delete"), 1);
	}

	public int get_ws_row_by_no(String no) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathPanelWageServices, no, 1, "No.", 1));
	}

	public void enter_ws_wage_service(int rowIndex, String wageService) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Wage Service Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input[@type='text']",
				wageService);
	}

	public String get_text_ws_wage_service(int rowIndex, String wageService) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Wage Service Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input").getText();
	}
	// public String is_enabled_ws_wage_service(int rowIndex, String
	// wageService){}
	// public String is_readonly_ws_wage_service(int rowIndex, String
	// wageService){}

	public String get_text_ws_description(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Wage Service Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//tr/td[3]").getText();
	}

	public void enter_ws_wage_service_remark(int rowIndex, String remark) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Wage Service Description");
		enterRemarkByClickIcon(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex)
				+ "//img[contains(@src,'remarks.gif')]", remark);
	}

	// public String is_enabled_ws_description(int rowIndex, String
	// description){}
	// public String is_readonly_ws_description(int rowIndex, String
	// description){}
	public void enter_ws_voucher_date(int rowIndex, String voucherDate) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Voucher Date");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", voucherDate);
	}

	public String get_text_ws_voucher_date(int rowIndex, String voucherDate) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Wage Service Description");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	// public String is_enabled_ws_voucher_date(int rowIndex, String
	// voucherDate) {
	// }
	//
	// public String is_readonly_ws_voucher_date(int rowIndex, String
	// voucherDate) {
	// }

	public void select_in_ws_currency(int rowIndex, String currency) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Currency");
		selectDdlByText(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//select",
				currency);
	}

	// public List<String> get_all_option_ws_currency(int rowIndex, String
	// currency) {
	// }

	public void enter_ws_exchange_rate(int rowIndex, String exchangeRate) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Exchange Rate");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", exchangeRate);
	}

	public String get_text_ws_exchange_rate(int rowIndex, String exchangeRate) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Exchange Rate");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	// public String is_enabled_ws_exchange_rate(int rowIndex, String
	// exchangeRate) {
	//
	// }
	//
	// public String is_readonly_ws_exchange_rate(int rowIndex, String
	// exchangeRate) {
	// }
	public void enter_ws_qty(int rowIndex, String qty) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Qty");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", qty);
	}

	public String get_text_ws_qty(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Qty");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	public void enter_ws_unit_price(int rowIndex, String unitPrice) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Unit Price");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", unitPrice);
	}

	public String get_text_ws_unit_price(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Unit Price");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	// public String is_enabled_ws_unit_price(int rowIndex, String unitPrice) {
	//
	// }
	//
	// public String is_readonly_ws_unit_price(int rowIndex, String unitPrice) {
	// }

	public void check_ws_incl_tax(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Incl. Tax");
		setChkbox(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", "yes");
	}

	public void uncheck_ws_incl_tax(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Incl. Tax");
		setChkbox(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", "no");
	}

	public void set_ws_incl_tax(int rowIndex, String inclTax) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Incl.");
		setChkbox(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", inclTax);
	}

	public boolean is_checked_ws_incl_tax(int rowIndex, String inclTax) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Incl.");
		if (waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input")
				.getAttribute("checked") == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean is_unchecked_ws_incl_tax(int rowIndex, String inclTax) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Incl.");
		if (waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input")
				.getAttribute("checked") == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean is_enabled_ws_incl_tax(int rowIndex, String inclTax) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Incl.");
		if (waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input")
				.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public void enter_ws_sales_tax(int rowIndex, String salesTax) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Sales Tax");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input", salesTax);

	}

	public String get_text_ws_sales_tax(int rowIndex, String salesTax) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Sales Tax");
		return waitElementToBeVisible(
				xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex) + "//input[1]").getTextValue();
	}

	// public String is_enabled_ws_sales_tax(int rowIndex, String salesTax){
	// }
	// public String is_readonly_ws_sales_tax(int rowIndex, String salesTax){
	// }

	public String get_text_ws_nature_amt_before_tax(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Nature Amt Before Tax");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex))
				.getText();
	}

	public String get_text_ws_nature_amt_after_tax(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Nature Amt After Tax");
		return waitElementToBeVisible(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex))
				.getText();
	}

	private String xPathPanelCommission = "(//div[contains(text(),'Commission')]//ancestor::table[contains(@id,'popup')])[1]";

	public void enter_ws_commission(int rowIndex, String startDate, String endDate, String monthlyCommission) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Commission");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex)
				+ "//span[@class='text-icon']");
		waitElementToBePresent(xPathPanelCommission).shouldBeVisible();
		enterInputFieldWithLabel(xPathPanelCommission, "Start Date:", startDate);
		enterInputFieldWithLabel(xPathPanelCommission, "End Date:", startDate);
		selectRadioButton(xPathPanelCommission, "Monthly Commission:", monthlyCommission);
		clickBtn(xPathPanelCommission, "Done");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelCommission);
	}

	private String xPathPanelAllocDetails = "(//div[contains(text(),'Allocation Details')]//ancestor::table[contains(@id,'popup')])[1]";

	public void open_ws_allocation_detail(int rowIndex) {
		int headerIndex = getTbColHeaderIndex(xPathPanelWageServices, "Allocation");
		clickOnElement(xPathTbDataCellByPosition(xPathPanelWageServices, rowIndex, headerIndex)
				+ "//span[@class='text-icon']");
	}

	public void close_ws_allocation_detail() {
		clickBtn(xPathPanelAllocDetails, "Done");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelAllocDetails);
	}

	public void enter_alloc_detail_voucher_no(String voucherNo) {
		waitTypeAndEnterThenUpdateValue(xPathPanelAllocDetails + "//input[contains(@id,'txtAllocVoucherNo')]",
				voucherNo);
	}

	public void enter_alloc_detail_phase_sequence_no(String phaseSequenceNo) {
		waitTypeAndEnterThenUpdateValue(xPathPanelAllocDetails + "//input[contains(@id,'txtAllocPhaseNo')]",
				phaseSequenceNo);
	}

	public void enter_alloc_detail_li_no(String liNo) {
		waitTypeAndEnterThenUpdateValue(xPathPanelAllocDetails + "//input[contains(@id,'txtAllocLineNo')]", liNo);
	}

	public String get_alloc_detail_line_no() {
		return getTextWithLabel(xPathPanelAllocDetails, "Line No.");
	}

	public String get_alloc_detail_wage_service_code() {
		return getTextWithLabel(xPathPanelAllocDetails, "Wage Service Code");
	}

	public String get_alloc_detail_wage_service_description() {
		return getTextWithLabel(xPathPanelAllocDetails, "Wage Service Description");
	}

	public String get_alloc_detail_alloc_line_no() {
		return waitElementToBePresent(xPathPanelAllocDetails + "//input[contains(@id,'txtAllocLineNo')]")
				.getTextValue();
	}

	public String enter_ws_allocation(int rowIndex, String voucherNo, String phaseSequenceNo, String liNo) {
		String sAllocLineNo = "";
		open_ws_allocation_detail(rowIndex);
		enter_alloc_detail_voucher_no(voucherNo);
		enter_alloc_detail_phase_sequence_no(phaseSequenceNo);
		if (!liNo.toLowerCase().equals("@default@") && !liNo.isEmpty()) {
			enter_alloc_detail_li_no(liNo);
		}
		sAllocLineNo = get_alloc_detail_alloc_line_no();
		close_ws_allocation_detail();
		return sAllocLineNo;
	}

	// END By Recipient
	// BEGIN Remarks
	public void enter_internal_remarks_code(String internalRemarksCode) {
		enterInputFieldWithLabel("Internal Remarks Code", internalRemarksCode);
	}

	public void enter_external_remarks_code(String externalRemarksCode) {
		enterInputFieldWithLabel("External Remarks Code", externalRemarksCode);
	}

	public void enter_internal_remarks(String internalRemarks) {
		enterTextAreaWithLabel("Internal Remarks", internalRemarks);
	}

	public void enter_external_remarks(String externalRemarks) {
		enterTextAreaWithLabel("External Remarks", externalRemarks);
	}

	// END Remarks

	// END Draft
}
