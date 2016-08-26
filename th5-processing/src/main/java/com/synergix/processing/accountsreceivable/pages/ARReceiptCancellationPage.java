package com.synergix.processing.accountsreceivable.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class ARReceiptCancellationPage extends TH5PageObject {
	public ARReceiptCancellationPage(WebDriver driver) {
		super(driver);
	}

	String xDrafTb = "//table[contains(@id, 'arRecNewHdrTable') and child::thead]";
	String xHistoryTb = "//table[contains(@id, 'arRccHstHdrTable') and child::thead]";

	public int countRowTb(String xParentTb) {
		return findAll(xParentTb + "/tbody/tr[@class]").size();
	}

	public void typeReceiptCancellationDate(String receiptCancellationDate) {
		enterInputFieldWithLabel("Receipt Cancellation Date",
				receiptCancellationDate);
	}

	public void typeCustomer(String customer) {
		enterInputFieldCodeWithLabel("Customer", customer);
	}

	public void typeChequeNo(String chequeNo) {
		enterInputFieldWithLabel("Cheque No.", chequeNo);
	}

	public void typeReceiptNo(String receiptNo) {
		if (receiptNo.isEmpty()) {
			clickSearchIconWithLabel("Receipt No");
			clickBtn("Search");
			waitForAllJSCompletes();
			clickOnElement("//table[@id='searchResult_Form:searchResult_Table']/tbody/tr[1]/td[1]//a[@href]");
			waitForAllJSCompletes();
		} else
			enterInputFieldCodeWithLabel("Receipt No", receiptNo);
	}

	public void chooseCancellationType(String cancellationType) {
		selectRadioButton("Cancellation Type", cancellationType);
		waitForAllJSCompletes();
	}

	public void typeNewCustomer(String newCustomer) {
		enterInputFieldCodeWithLabel("New Customer", newCustomer);
	}

	private String xApplicationsTb = "//div[@id='draftApplicationPanel']//table[child::thead]";

	public void chooseInvNo(String invNo) {
		String xRowSelect = "";
		if (invNo.isEmpty()) {
			xRowSelect = xApplicationsTb
					+ "/tbody/tr[1]/td[1]//input[@type='checkbox']";
		} else {
			int colIndex = getTbColHeaderIndex(xApplicationsTb,
					"Inv No. Src Inv No");

			xRowSelect = xApplicationsTb + "/tbody/tr[descendant::td["
					+ colIndex + " and descendant-or-self::*[text()='"
					+ invNo.toUpperCase()
					+ "']]]/td[1]//input[@type='checkbox']";
		}
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
		}
	}

	public void getInvoiceNo(String ssARRcpCancel) {
		String invNo = getTextValueWithLabel("Receipt Cancellation No", 2);
		setDataToNewSession(invNo, ssARRcpCancel);
	}

	public void clickOnPreviewHST(String invNo, String reportName) {
		clickPreviewHST(xHistoryTb, "Receipt Cancellation No", invNo,
				reportName);
	}
}
