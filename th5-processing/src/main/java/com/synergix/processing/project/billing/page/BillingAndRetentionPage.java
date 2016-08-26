package com.synergix.processing.project.billing.page;

import com.synergix.common.TH5PageObject;
import com.synergix.utilities.SessionData;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BillingAndRetentionPage extends TH5PageObject {

	public BillingAndRetentionPage(WebDriver driver) {
		super(driver);
	}

	public void search_invoice_on_invoice_tab(String projectNo) {
		filterDataByHeader(xPathTbHeaderCell("//*[@id='ostProjectInvoicesTab']", "Project No."), projectNo);
		waitForAllJSCompletes();
		$("//*[@id='ostProjectInvoicesTab']//td/a[1]").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void search_invoice_on_processing_tab(String projectNo) {
		filterDataByHeader(xPathTbHeaderCell("//*[contains(@id,'progressiveBillingSummaryTable')]", "Project No."), projectNo);
		waitForAllJSCompletes();
	}

	public void clickBillFirstResultInSummary(){
		$("(//tbody[preceding-sibling::thead]//tr)[1]/td/input").waitUntilClickable().click();
		waitForAllJSCompletes();
		clickBtnYesOnConfirmSubmit2();
	}

	private static final String xPathPanelInvoice = "(//*[contains(@id,'invoiceOstFormButtons')]//ancestor-or-self::form)[1]";

	public void click_submit_invoice_tab_btn() {
		String invoice_no = getTextWithLabel("Invoice No.", 1); // get from xpath
		Serenity.setSessionVariable("INVOICE NO").to(invoice_no);
		clickBtn(xPathPanelInvoice, "Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	private static final String xPathPanelBilling = "(//*[contains(@id,'submitBtn')]//ancestor-or-self::form)[1]";

	public void click_submit_billing_tab_btn() {
		clickBtn(xPathPanelBilling, "Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	private String xPathPanelConfirmSubmit = "//div[" + sSpecialTextPredicates("Submit Confirmation") + " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void clickBtnNoOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	private String xPathBillButtonOrLink = "//tr[1]/td[12]/a | //tr[1]/td[12]/input";
	private String xPathPanelConfirmSubmit2 = "//div[" + sSpecialTextPredicates("Confirmed") + " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void click_bill_button_or_link() {
		waitElementToBePresentThenScrollIntoView(xPathBillButtonOrLink).shouldBeVisible();
		$("//tr[1]/td[12]/a | //tr[1]/td[12]/input").waitUntilClickable().click();
		clickBtnYesOnConfirmSubmit2();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	public void clickBtnYesOnConfirmSubmit2() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit2).shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit2, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit2);
	}

	private String xPathRetentionPercent = "(//td//descendant-or-self::*[contains(text(),'This Retention (')]/input[@type='text'])";

	public void enter_retention_percent(String value) {
		$(xPathRetentionPercent).clear();
		waitForAllJSCompletes();
		$(xPathRetentionPercent).typeAndEnter(value);
		waitForAllJSCompletes();
	}

	private String xPathAmountToBillPercent = "(//td//descendant-or-self::*[text()='Amount to Bill (']/input[@type='text'])";

	public void enter_amount_to_bill_percent(String value) {
		$(xPathAmountToBillPercent).clear();
		$(xPathAmountToBillPercent).typeAndEnter(value);
		waitForAllJSCompletes();
	}

	public void search_invoice_on_retention_tab(String projectNo) {
		filterDataByHeader(xPathTbHeaderCell("//*[contains(@id,'pjRetentionBillingSummary')]", "Project No."), projectNo);
		waitForAllJSCompletes();
	}

	String xPathBillButtonOrLinkOnRetentionTab = "//tr[1]/td[11]/a | //tr[1]/td[11]/input";

	public void click_bill_button_or_link_on_retention_tab() {
		waitElementToBePresentThenScrollIntoView(xPathBillButtonOrLinkOnRetentionTab).shouldBeVisible();
		$("//tr[1]/td[11]/a | //tr[1]/td[11]/input").waitUntilClickable().click();
	}

	private static final String xPathPanelRetention = "(//*[contains(@id,'retentionBillingDetailForm')]//ancestor-or-self::form)[1]";

	public void click_summit_on_retention_tab() {
		clickBtn(xPathPanelRetention, "Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}


	public void enterInvoiceDate(String invoiceDate) {
		clickOnElement(xPathInputFieldWithLabel("Invoice Date", 1));
		waitForAllJSCompletes();
		calendarSetDate(invoiceDate);
		waitForAllJSCompletes();
		enterInputFieldCodeWithLabel("Invoice Date", invoiceDate);
	}

	public void enterSalesTax(String salesTax) {
		enterInputFieldCodeWithLabel("Sales Tax", salesTax);
	}

	public void enterExchRate(String exchRate) {
		enterInputFieldWithLabel("Exch Rate", exchRate);
	}

	public void enterAmountToBillAmount(String amtToBill) {
		String xpath = "(//td[preceding-sibling::td[descendant-or-self::*[" + sSpecialTextPredicates("Amount'to'Bill")
				+ "]]]//input[@type='text'])[1]";
		waitTypeAndEnterThenUpdateValue(xpath, amtToBill);
	}

	public String getInvoiceNo() {
		return getTextValueWithLabel("Invoice No.");
	}

	public void saveInvoiceNo() {
		String dataKey = "Invoice";
		SessionData.addToListString(dataKey, getInvoiceNo());
	}

	public void clickSubmitBtn() {
		clickBtn("Submit");
	}

	public void enterProgressivePercent(String progressivePercent) {
		String xpath = "(//td//descendant-or-self::*[" + sSpecialTextPredicates("Amount'to'Bill")
				+ "]/input[@type='text'])[1]";
		waitTypeAndEnterThenUpdateValue(xpath, progressivePercent);
	}

	public void enterCumulativeBilledAmount(String cumulativeBilledAmount) {
		enterInputFieldWithLabel("Total This Cumulative Billed Amount", cumulativeBilledAmount);
	}

	public void enterRetentionAmount(String retentionAmount) {
		String xpath = "(//td[preceding-sibling::td[descendant-or-self::*[" + sSpecialTextPredicates("This'Retention'(")
				+ "]]]//input[@type='text'])[1]";
		waitTypeAndEnterThenUpdateValue(xpath, retentionAmount);
	}

	public void enterThisCumulativeRetentionBalance(String thisCumulativeRetentionBalance) {
		enterInputFieldCodeWithLabel("This Cumulative Retention Balance", thisCumulativeRetentionBalance);
	}

	public void enterLessDiscount(String lessDiscount) {
		enterInputFieldCodeWithLabel("Less Discount", lessDiscount);
	}

	public String getProjectAmount() {
		return getTextValueWithLabel("Project Amount");
	}

	public String getBilledAmount() {
		return getTextValueWithLabel("Total billed amount (before retention)");
	}
	public String getProgressivePercent() {
		String xpath = "(//td//descendant-or-self::*[" + sSpecialTextPredicates("Amount'to'Bill")
				+ "]/input[@type='text'])[1]";
		return $(xpath).getTextValue();
	}
	public String getAmountToBill() {
		String xpath = "(//td[preceding-sibling::td[descendant-or-self::*[" + sSpecialTextPredicates("Amount'to'Bill")
				+ "]]]//input[@type='text'])[1]";
		return $(xpath).getTextValue();
	}
	public String getCumulativeBilledAmount() {
		return getTextValueWithLabel("Total This Cumulative Billed Amount");
	}
	public String getRetentionCurrentCumulativeReleased() {
		return getTextValueWithLabel("Current Cumulative Released");
	}
	public String getRetentionCurrentCumulativeBalance() {
		return getTextValueWithLabel("Current Cumulative Balance");
	}
	public String getRetentionPercent() {
		String xpath = "(//td//descendant-or-self::*[" + sSpecialTextPredicates("This'Retention")
				+ "]/input[@type='text'])[1]";
		return $(xpath).getTextValue();
	}
	public String getRetentionAmount() {
		String xpath = "(//td[preceding-sibling::td[descendant-or-self::*[" + sSpecialTextPredicates("This'Retention'(")
				+ "]]]//input[@type='text'])[1]";
		return $(xpath).getTextValue();
	}
	public String getThisCumulativeRetentionBalance() {
		return getTextValueWithLabel("This Cumulative Retention Balance");
	}
	public String getDownpaymentRecoverd() {
		return getTextValueWithLabel("Less This Downpayment Recovered");
	}
	public String getPreviousBilledAmount() {
		return getTextValueWithLabel("Less Previous Billed Amount (after Retention)");
	}
	public String getDiscount() {
		return getTextValueWithLabel("Less Discount");
	}
	public String getInvoiceAmount() {
		return getTextValueWithLabel("Nett Invoice Amt / Home");
	}
	public String getSalesTax() {
		return getTextValueWithLabel("Add Sales Tax Home Amount");
	}
	public String getAffterTax() {
		return getTextValueWithLabel("After Tax Invoice Amt / Home");
	}
	public String getExchRate() {
		return getTextValueWithLabel("Exchange Rate");
	}
	public String getInvoiceHome() {
		return waitElementToBePresent(xPathTextWithLabel("Nett Invoice Amt / Home", 3)).getTextValue();
	}
	public String getSalesTaxHome() {
		return waitElementToBePresent(xPathTextWithLabel("Add Sales Tax Home Amount", 3)).getTextValue();
	}
	public String getAfterTaxHome() {
		return waitElementToBePresent(xPathTextWithLabel("After Tax Invoice Amt / Home", 3)).getTextValue();
	}


}
