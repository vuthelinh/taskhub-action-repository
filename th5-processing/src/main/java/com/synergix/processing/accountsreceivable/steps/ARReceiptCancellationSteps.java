package com.synergix.processing.accountsreceivable.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.processing.accountsreceivable.pages.ARReceiptCancellationPage;

public class ARReceiptCancellationSteps extends ScenarioSteps {
	ARReceiptCancellationPage onARReceiptCancellationPage;

	String xDrafTb = "//table[contains(@id, 'arRccNewHdrTable') and child::thead]";

	@Step
	public void switchOutDefaultIFrame() {
		onARReceiptCancellationPage.switchOutDefaultIFrame();
	}

	@Step
	public void switchToIFrame() {
		onARReceiptCancellationPage.switchToIFrame();
	}

	@Step
	public boolean searchDrafRcpCancelNo(String crnNo) {
		return onARReceiptCancellationPage.searchByFilter(xDrafTb,
				"Receipt Cancellation No", crnNo);
	}

	@Step
	public void clickOnNewBtn() {
		onARReceiptCancellationPage.clickBtn("New");
		onARReceiptCancellationPage.waitForAllJSCompletes();
	}

	@Step
	public void switchToDrafTab() {
		onARReceiptCancellationPage.switch_to_tab("Draf");
		onARReceiptCancellationPage.waitForAllJSCompletes();
	}

	@Step
	public void typeReceiptCancellationDate(String receiptCancellationDate) {
		onARReceiptCancellationPage
				.typeReceiptCancellationDate(receiptCancellationDate);
	}

	@Step
	public void typeCustomer(String customer) {
		onARReceiptCancellationPage.typeCustomer(customer);
	}

	@Step
	public void typeChequeNo(String chequeNo) {
		onARReceiptCancellationPage.typeChequeNo(chequeNo);
	}

	@Step
	public void typeReceiptNo(String receiptNo) {
		onARReceiptCancellationPage.typeReceiptNo(receiptNo);
	}

	@Step
	public void chooseCancellationType(String cancellationType) {
		onARReceiptCancellationPage.chooseCancellationType(cancellationType);
	}

	@Step
	public void typeNewCustomer(String newCustomer) {
		onARReceiptCancellationPage.typeNewCustomer(newCustomer);
	}

	@Step
	public void chooseInvNo(String invNo) {
		onARReceiptCancellationPage.chooseInvNo(invNo);
	}

	@Step
	public String getToday() {
		return onARReceiptCancellationPage.getToday();
	}

	@Step
	public void getInvoiceNo(String ssARRcpCancel) {
		onARReceiptCancellationPage.getInvoiceNo(ssARRcpCancel);
	}

	@Step
	public void clickOnSubmitBtn() {
		onARReceiptCancellationPage.clickBtn("Submit");
		onARReceiptCancellationPage.chooseYesOnUpdateConfirmation();
		onARReceiptCancellationPage.chooseOkOnInforPanel();
		onARReceiptCancellationPage.waitForAllJSCompletes();
	}

	@Step
	public void clickPreview(String reportName) {
		onARReceiptCancellationPage.clickPreviewBtn(reportName);
	}

	@Step
	public String getDataWithSession(String ssCrnInv) {
		return onARReceiptCancellationPage.getDataWithSession(ssCrnInv, 0);
	}

	@Step
	public void clickPreviewHST(String invNo, String reportName) {
		onARReceiptCancellationPage.clickOnPreviewHST(invNo, reportName);
	}

}
