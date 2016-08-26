package com.synergix.mtsetup.financial.accounting.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class MTBKRecurringTemplatePage extends TH5PageObject {

	public MTBKRecurringTemplatePage(WebDriver driver) {
		super(driver);
	}

	private String xSearchForm = "//div[@id='searchModalPanelCDiv']";

	public int getRowTb(String xParentTb) {
		String xRow = xParentTb + "/tbody/tr";
		if (isElementExist(xRow)) {
			return findAll(xRow).size();
		}
		return 0;
	}

	public void typeBankTemplateCode(String bankTemplateCode) {
		enterInputFieldCodeWithLabel("Bank Template Code", bankTemplateCode);
	}

	public void typeTemplateDescription(String templateDescription) {
		enterInputFieldWithLabel("Template Description", templateDescription);
	}

	public void typeBankVoucherDescription(String bankVoucherDescription) {
		enterInputFieldWithLabel("Bank Voucher Description", bankVoucherDescription);
	}

	public void chooseRecurringFrequency(String recurringFrequency) {
		selectRadioButton("Recurring Frequency", "Recurring Frequency");
	}

	public void chooseRecurringDay(String recurringDay) {
		selectDdlWithLabelByText("Recurring Day", recurringDay);
	}

	public void typeRecurrenceStartDate(String recurrenceStartDate) {
		enterInputFieldWithLabel("Recurrence Start Date", recurrenceStartDate);
	}

	public void typeRecurrenceEndDate(String recurrenceEndDate) {
		enterInputFieldWithLabel("Recurrence End Date", recurrenceEndDate);
	}

	public void typeLastRecurredDate(String lastRecurredDate) {
		enterInputFieldWithLabel("Last Recurred Date", lastRecurredDate);
	}

	public void chooseTransactionType(String transactionType) {
		String xTransactionType = xPathRadioBtnWithGroupLabel("Transaction Type", transactionType);
		if (findAll(xTransactionType + "[@disabled]").size() == 0)
			selectRadioButton("Transaction Type", transactionType);
	}

	// ############ DEPOSIT #############
	public void chooseModeofDeposit(String modeofDeposit) {
		selectDdlWithLabelByText("Mode of Deposit", modeofDeposit);
	}

	public void typeDepositbankkAcNo(String depositbankkAcNo) {
		clickSearchIconWithLabel("Deposit Bank A/C No");
		getResultSearch("Bank Party Code", depositbankkAcNo);
		waitForAllJSCompletes();
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeDepositSlipNo(String depositSlipNo) {
		enterInputFieldWithLabel("Deposit Slip No", depositSlipNo);
	}

	public void typeSegment1(String segment1) {
		enterInputFieldWithLabel("Segment 1", segment1);
	}

	public void typeSegment2(String segment2) {
		enterInputFieldWithLabel("Segment 2", segment2);
	}

	public void typeSegment3(String segment3) {
		enterInputFieldWithLabel("Segment 3", segment3);
	}

	public void typeSegment4(String segment4) {
		enterInputFieldWithLabel("Segment 4", segment4);
	}

	// Deposit Detail

	public void typeReceivedFrom(String xParentTb, String receivedFrom, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Received From");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex) + "/input", receivedFrom);
	}

	public void typeChequeNo(String xParentTb, String chequeNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Cheque No.");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex) + "/input", chequeNo);
	}

	public void typeAmount(String xParentTb, String amount, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Amount");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex) + "/input", amount);
	}

	public void typeSalesTax(String xParentTb, String salesTax, int rowIndex) {

	}

	public void typeDocumentNo(String xParentTb, String documentNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Document No");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex) + "/input", documentNo);
	}

	public void typeDocDate(String xParentTb, String docDate, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Doc Date");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex) + "//input", docDate);
	}

	public void chooseDelDepositDetail(String xParentTb, int rowIndex) {
		String xDelDetail = xParentTb + "/tbody/tr[" + rowIndex
				+ "]/td[descendant-or-self::*[text()='delete' and @href]]//*[@href]";
		clickOnElement(xDelDetail);
		chooseYesOnUpdateConfirmation();
	}

	// ############ FUND TRANSFER #############
	public void typeRemittanceBankAcNo(String remittanceBankAcNo) {
		clickSearchIconWithLabel("Remittance Bank A/C No");
		if (remittanceBankAcNo.contains(">")) {
			String bankCode = remittanceBankAcNo.split(">")[0].trim();
			String bankNo = remittanceBankAcNo.split(">")[1].trim();

			enterInputFieldWithLabel("Bank Party Code", bankCode);
			waitForAllJSCompletes();
			String xRowSelect = xSearchForm
					+ "//table[child::thead]/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
					+ bankCode.toUpperCase() + "']] and child::td[3 and descendant-or-self::*[text()='"
					+ bankNo.toUpperCase() + "']]]/td[1]//*[@href]";
			if (isElementExist(xRowSelect))
				clickOnElement(xRowSelect);
		} else
			getResultSearch("Bank Party Code", remittanceBankAcNo);
	}

	public void typeDestinationBankAcNo(String destinationBankAcNo) {
		clickSearchIconWithLabel("Destination Bank A/C No");
		if (destinationBankAcNo.contains(">")) {
			String bankCode = destinationBankAcNo.split(">")[0].trim();
			String bankNo = destinationBankAcNo.split(">")[1].trim();

			enterInputFieldWithLabel("Bank Party Code", bankCode);
			waitForAllJSCompletes();
			String xRowSelect = xSearchForm
					+ "//table[child::thead]/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
					+ bankCode.toUpperCase() + "']] and child::td[3 and descendant-or-self::*[text()='"
					+ bankNo.toUpperCase() + "']]]/td[1]//*[@href]";
			if (isElementExist(xRowSelect))
				clickOnElement(xRowSelect);
		} else
			getResultSearch("Bank Party Code", destinationBankAcNo);
	}

	public void typeTransferAmount(String transferAmount) {
		enterInputFieldWithLabel("Transfer Amount", transferAmount);
	}

	// ############# WITHDRAWAL ####################

	public void chooseModeofWithdrawal(String modeofWithdrawal) {
		selectDdlWithLabelByText("Mode of Withdrawal", modeofWithdrawal);
	}

	public void typeWithdrawalBankACNo(String withdrawalBankACNo) {
		clickSearchIconWithLabel("Withdrawal Bank A/C No");
		if (withdrawalBankACNo.contains(">")) {
			String bankCode = withdrawalBankACNo.split(">")[0].trim();
			String bankNo = withdrawalBankACNo.split(">")[1].trim();

			enterInputFieldWithLabel("Bank Party Code", bankCode);
			waitForAllJSCompletes();
			String xRowSelect = xSearchForm
					+ "//table[child::thead]/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
					+ bankCode.toUpperCase() + "']] and child::td[3 and descendant-or-self::*[text()='"
					+ bankNo.toUpperCase() + "']]]/td[1]//*[@href]";
			if (isElementExist(xRowSelect))
				clickOnElement(xRowSelect);
		} else
			getResultSearch("Bank Party Code", withdrawalBankACNo);
	}

	public void typeWithdrawalSlipNo(String withdrawalSlipNo) {
		enterInputFieldWithLabel("Withdrawal Slip No", withdrawalSlipNo);
	}

	public void typePaidto(String xParentTb, String paidto, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xParentTb, "Paid to");
		waitTypeAndEnter(xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex) + "/input", paidto);

	}

}
