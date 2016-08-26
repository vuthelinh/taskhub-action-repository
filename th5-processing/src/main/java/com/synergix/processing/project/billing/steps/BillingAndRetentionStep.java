package com.synergix.processing.project.billing.steps;

import com.synergix.processing.project.billing.page.BillingAndRetentionPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class BillingAndRetentionStep extends ScenarioSteps {

	BillingAndRetentionPage onBillingAndRetentionPage;

	@Step
	public void go_to_tab(String _tabName) {
		onBillingAndRetentionPage.switch_to_tab(_tabName);
	}

	@Step
	public void go_to_progressive_tab() {
		onBillingAndRetentionPage.switch_to_tab("Progressive Billing");
	}

	@Step
	public void go_to_retention_tab() {
		onBillingAndRetentionPage.switch_to_tab("Retention Billing");
	}

	@Step
	public void go_to_invoice_tab() {
		onBillingAndRetentionPage.switch_to_tab("Invoice");
	}

	@Step
	public void search_invoice_on_invoice_tab(String projectNo) {
		onBillingAndRetentionPage.search_invoice_on_invoice_tab(projectNo);
	}

	@Step
	public void submit_invoice() {
		onBillingAndRetentionPage.click_submit_invoice_tab_btn();
	}

	@Step
	public void search_invoice_on_processing_tab(String projectNo) {
		onBillingAndRetentionPage.search_invoice_on_processing_tab(projectNo);
	}

	@Step
	public void search_invoice_on_retention_tab(String projectNo) {
		onBillingAndRetentionPage.search_invoice_on_retention_tab(projectNo);
	}

	@Step
	public void click_bill_first_result(){
		onBillingAndRetentionPage.clickBillFirstResultInSummary();
	}

	@Step
	public void enter_invoice_date(String invoiceDate) {
		onBillingAndRetentionPage.enterInvoiceDate(invoiceDate);
	}

	@Step
	public void amount_to_bill_percent(String labelName, String value) {
		onBillingAndRetentionPage.enter_amount_to_bill_percent(value);
	}

	@Step
	public void enter_amount_to_bill_amount(String amtToBill) {
		onBillingAndRetentionPage.enterAmountToBillAmount(amtToBill);
	}

	@Step
	public void cumulative_billed_amount(String labelName, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(labelName, value);
	}

	@Step
	public void retention_percent(String labelName, String value) {
		onBillingAndRetentionPage.enter_retention_percent(value);
	}

	@Step
	public void retention_amount(String labelName, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(labelName, value);
	}

	@Step
	public void cumulative_retention_balance(String labelName, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(labelName, value);
	}

	@Step
	public void payment_option(String lableText, String value) {
		onBillingAndRetentionPage.selectDdlWithLabelByText(lableText, value);
	}

	@Step
	public void payment_term(String lableText, String value) {
		onBillingAndRetentionPage.selectDdlWithLabelByText(lableText, value);
	}

	@Step
	public void payment_term_tenor_date(String lableText, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void payment_term_tenor_term(String lableText, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(lableText, value, 2);
	}

	@Step
	public void payment_method(String lableText, String value) {
		onBillingAndRetentionPage.selectDdlWithLabelByText(lableText, value);
	}

	@Step
	public void billing_address(String lableText, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void billing_contact(String lableText, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void internal_remarks_code(String lableText, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void external_remarks_code(String lableText, String value) {
		onBillingAndRetentionPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void internal_remarks(String lableText, String value) {
		onBillingAndRetentionPage.enterTextAreaWithLabel(lableText, value);
	}

	@Step
	public void external_remarks(String lableText, String value) {
		onBillingAndRetentionPage.enterTextAreaWithLabel(lableText, value);
	}

	@Step
	public void click_summit() {
		onBillingAndRetentionPage.clickSubmitBtn();
	}

	@Step
	public void click_bill_or_link() {
		onBillingAndRetentionPage.click_bill_button_or_link();
	}

	@Step
	public void check_bill_all() {
		onBillingAndRetentionPage.setHeaderCheckbox(onBillingAndRetentionPage.xPathTbHeaderChkbox(), "true"); // only have 1 check box cell on table
	}

	@Step
	public void click_bill_button_or_link_on_retention_tab() {
		onBillingAndRetentionPage.click_bill_button_or_link_on_retention_tab();
	}

	@Step
	public void click_summit_on_retention_tab() {
		onBillingAndRetentionPage.click_summit_on_retention_tab();
	}

	@Step
	public void switch_to_iframe() {
		onBillingAndRetentionPage.switchToIFrame("th5frame");
	}

	@Step
	public void enter_sales_tax(String salesTax) {
		onBillingAndRetentionPage.enterSalesTax(salesTax);
	}

	@Step
	public void enter_exch_rate(String exchRate) {
		onBillingAndRetentionPage.enterExchRate(exchRate);
	}

	@Step
	public void save_invoice_no() {
		onBillingAndRetentionPage.saveInvoiceNo();
	}

	@Step
	public void submit_voucher() {
		onBillingAndRetentionPage.clickSubmitBtn();
		onBillingAndRetentionPage.clickBtnYesOnConfirmSubmit();
	}

	@Step
	public void enter_progressive_percent(String progressivePercent) {
		onBillingAndRetentionPage.enterProgressivePercent(progressivePercent);
	}

	@Step
	public void enter_cumulative_billed_amount(String cumulativeBilledAmount) {
		onBillingAndRetentionPage.enterCumulativeBilledAmount(cumulativeBilledAmount);
	}

	@Step
	public void enter_retention_percent(String retentionPercent) {
		onBillingAndRetentionPage.enter_retention_percent(retentionPercent);
	}

	@Step
	public void enter_retention_amount(String cumulativeRetention) {
		onBillingAndRetentionPage.enterRetentionAmount(cumulativeRetention);
	}

	@Step
	public void enter_this_cumulative_retention_balance(String thisCumulativeRetentionBalance) {
		onBillingAndRetentionPage.enterThisCumulativeRetentionBalance(thisCumulativeRetentionBalance);
	}

	@Step
	public void enter_less_discount(String lessDiscount) {
		onBillingAndRetentionPage.enterLessDiscount(lessDiscount);
	}

	@Step
	public void verify_project_amount(String projectAmount) {
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getProjectAmount().replaceAll(",", "")))
				.isEqualTo(Float.parseFloat(projectAmount));
	}

	@Step
	public void verify_billed_amount(String billedAmount){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getBilledAmount().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(billedAmount));
	}
	@Step
	public void verify_progressive_percent(String progressivePercent){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getProgressivePercent().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(progressivePercent));
	}
	@Step
	public void verify_amount_to_bill(String amountToBill){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getAmountToBill().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(amountToBill));
	}
	@Step
	public void verify_cumulative_billed_amount(String cumulativeBilledAmount){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getCumulativeBilledAmount().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(cumulativeBilledAmount));
	}
	@Step
	public void verify_retention_current_cumulative_released(String retentionCurrentCumulativeReleased){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getRetentionCurrentCumulativeReleased().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(retentionCurrentCumulativeReleased));
	}
	@Step
	public void verify_retention_current_cumulative_balance(String retentionCurrentCumulativeBalance){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getRetentionCurrentCumulativeBalance().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(retentionCurrentCumulativeBalance));
	}
	@Step
	public void verify_retention_percent(String retentionPercent){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getRetentionPercent().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(retentionPercent));
	}
	@Step
	public void verify_retention_amount(String cumulativeRetention){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getRetentionAmount().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(cumulativeRetention));
	}
	@Step
	public void verify_this_cumulative_retention_balance(String thisCumulativeRetentionBalance){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getThisCumulativeRetentionBalance().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(thisCumulativeRetentionBalance));
	}
	@Step
	public void verify_downpayment_recoverd(String downpaymentRecoverd){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getDownpaymentRecoverd().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(downpaymentRecoverd));
	}
	@Step
	public void verify_previous_billed_amount(String previousBilledAmount){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getPreviousBilledAmount().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(previousBilledAmount));
	}
	@Step
	public void verify_discount(String discount){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getDiscount().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(discount));
	}
	@Step
	public void verify_invoice_amount(String invoiceAmount){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getInvoiceAmount().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(invoiceAmount));
	}
	@Step
	public void verify_sales_tax(String salesTax){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getSalesTax().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(salesTax));
	}
	@Step
	public void verify_affter_tax(String affterTax){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getAffterTax().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(affterTax));
	}
	@Step
	public void verify_exch_rate(String exchRate){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getExchRate().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(exchRate));
	}
	@Step
	public void verify_invoice_home(String invoiceHome){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getInvoiceHome().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(invoiceHome));
	}
	@Step
	public void verify_sales_tax_home(String salesTaxHome){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getSalesTaxHome().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(salesTaxHome));
	}
	@Step
	public void verify_after_tax_home(String afterTaxHome){
		assertThat(Float.parseFloat(onBillingAndRetentionPage.getAfterTaxHome().replaceAll(",","")))
				.isEqualTo(Float.parseFloat(afterTaxHome));
	}

	@Step
	public void submit_bill() {
		onBillingAndRetentionPage.clickSubmitBtn();
		onBillingAndRetentionPage.clickBtnYesOnConfirmSubmit();
	}
}
