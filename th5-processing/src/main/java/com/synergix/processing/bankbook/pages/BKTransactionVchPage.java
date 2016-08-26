package com.synergix.processing.bankbook.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class BKTransactionVchPage extends TH5PageObject {

	public BKTransactionVchPage(WebDriver driver) {
		super(driver);
	}

	private String xParentSearchDiv = "//div[@id='searchModalPanelContentDiv']";
	private String xDraftTb = "//table[contains(@id, 'bkTransNewHdrsTable')]";
	private String xHistoryTb = "//table[@id= 'bkTransHstHdrsForm:bkTransHstHdrsTable']";


	
	public boolean searchBankVchNo(String bankVoucherNo) {
		String xDraftTb = "//table[contains(@id, 'bkTransNewHdrsTable')]";

		String xFilterTxt = xDraftTb
				+ "/thead//span[descendant::*[text()='Bank Voucher No.']]/input[@type='text']";
		waitTypeAndEnter(xFilterTxt, bankVoucherNo);
		waitForAllJSCompletes();

		String xRowSelect = xDraftTb
				+ "/tbody//td[2 and descendant-or-self::*[@href and text()='"
				+ bankVoucherNo + "']]";
		try {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		} catch (Exception ex) {
			System.out
					.println("***[NANCY - ERROR MESSAGE]*** Can not search Bank Voucher No "
							+ bankVoucherNo);
			return false;
		}
	}

	public void typeBankVoucherDescription(String bankVoucherDescription) {
		enterInputFieldWithLabel("Bank Voucher Description",
				bankVoucherDescription);
	}

	public void typeReceivedFrom(String receivedFrom, String transactionType) {
		if (transactionType.equals("Deposit"))
			enterInputFieldWithLabel("Received From", receivedFrom);
		else if (transactionType.equals("Withdrawal"))
			enterInputFieldWithLabel("Payee Name", receivedFrom);
	}

	public void chooseTransactionType(String transactionType) {
		try {
			selectRadioButton("Transaction Type", transactionType);
			waitForAllJSCompletes();
			chooseYesOnUpdateConfirmation();
		} catch (Exception ex) {
		}
	}

	// ==================================================
	// ================= DEPOSIT ========================

	public void chooseModeofDeposit(String modeofDeposit) {
		selectDdlWithLabelByText("Mode of Deposit", modeofDeposit);
		waitForAllJSCompletes();
	}

	public void typeBankVchDate(String bankVchDate) {
		enterInputFieldWithLabel("Bank Vch Date", bankVchDate);
	}

	public void typeDepositSlipDate(String depositSlipDate) {
		enterInputFieldWithLabel("Deposit Slip Date", depositSlipDate);
	}

	public void searchBankPartyCode(String labelSearch, String bankPartyCode,
			String bankAccountNo) {
		clickSearchIconWithLabel(labelSearch);
		waitForAllJSCompletes();
		enterInputFieldWithLabel("Bank Party Code", bankPartyCode);

		String xSearchResultTb = "//table[@id='searchResult_Form:searchResult_Table']";
		int colIndexBankCode = getTbColHeaderIndex(xSearchResultTb,
				"Bank Party Code");
		int colIndexBankNo = getTbColHeaderIndex(xSearchResultTb,
				"Bank Party Code");

		String xAccountNo = "";
		if (!bankAccountNo.isEmpty()) {
			xAccountNo = " and descendant::td[" + colIndexBankNo
					+ " and descendant-or-self::*[text()='" + bankAccountNo
					+ "']]";
		}
		String xRowSelect = "(" + xSearchResultTb + "/tbody/tr[descendant::td["
				+ colIndexBankCode + " and descendant-or-self::*[text()='"
				+ bankPartyCode.toUpperCase() + "']] " + xAccountNo + "]/td["
				+ colIndexBankCode + "]//*[@href])[1]";

		clickOnElement(xRowSelect);
		waitForAllJSCompletes();
	}

	public void typeCurrency(String currency) {
		enterInputFieldCodeWithLabel("Currency", currency);
	}

	public void typeCrossRate(String crossRate) {
		enterInputFieldWithLabel("Cross Rate", crossRate);
	}

	public void typeSBUCode(String sBUCode) {
		enterInputFieldCodeWithLabel("SBU Code", sBUCode);
	}

	public void typeValueDate(String valueDate) {
		enterInputFieldWithLabel("Value Date", valueDate);
	}

	public void typeDepositSlipNo(String depositSlipNo) {
		enterInputFieldWithLabel("Deposit Slip No", depositSlipNo);
	}

	public void typeDepositBankExchRate(String depositBankExchRate) {
		enterInputFieldWithLabel("Deposit Bank Exch Rate", depositBankExchRate);
	}

	public void typeExchRate(String exchRate) {
		enterInputFieldWithLabel("Exch Rate", exchRate);
	}

	public void typeDefaultSalesTax(String defaultSalesTax) {
		enterInputFieldCodeWithLabel("Default Sales Tax", defaultSalesTax);
	}

	// Detail
	private String xDepositTb = "//table[contains(@id, 'draftDepositLineItemsTable') and child::thead]";
	private String xWithdrawalTb = "//table[contains(@id, 'draftWdlLineItemsTable') and child::thead]";
	private String xDetailTb = "//table[contains(@id, 'LineItemsTable') and child::thead]";
	private String xPopUp = "//div[@id='popupModalPanelContentDiv']";
	private String xAllocationDetailTb = xPopUp
			+ "//tbody//table[contains(@id, 'allocsTable')]";

	public void typeReceivedFrom(String transactionType, String receivedFrom,
			int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Received From");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input", receivedFrom);

	}	

	// ================================================
	// =============== FUND TRANSFER =====================

	public void typeModeofTransfer(String modeofTransfer) {
		selectDdlWithLabelByText("Mode of Transfer", modeofTransfer);
	}

	public void typeTransferAdviceDate(String transferAdviceDate) {
		enterInputFieldWithLabel("Transfer Advice Date", transferAdviceDate);
	}

	public void typeTransferAmount(String transferAmount) {
		enterInputFieldWithLabelNoVerify("Transfer Amount", transferAmount);
	}

	public void typeTransferAdviceNo(String transferAdviceNo) {
		enterInputFieldWithLabel("Transfer Advice No", transferAdviceNo);
	}

	public void typeRemittanceBankExchRate(String remittanceBankExchRate) {
		enterInputFieldWithLabelNoVerify("Remittance Bank Exch Rate",
				remittanceBankExchRate);
	}

	public void typeDestinationBankExchRate(String destinationBankExchRate) {
		enterInputFieldWithLabelNoVerify("Destination Bank Exch Rate",
				destinationBankExchRate);
	}

	// ================================================
	// =============== WITHDRAWAL =====================

	public void chooseModeofWithdrawal(String modeofWithdrawal) {
		selectDdlWithLabelByText("Mode of Withdrawal", modeofWithdrawal);
		waitForAllJSCompletes();
	}

	public void typeWithdrawalSlipDate(String withdrawalSlipDate) {
		enterInputFieldWithLabel("Withdrawal Slip Date", withdrawalSlipDate);
	}

	public void typeChequeNo(String chequeNo) {
		enterInputFieldWithLabel("Cheque No.", chequeNo);
	}

	public void typeWithdrawalSlipNo(String withdrawalSlipNo) {
		enterInputFieldWithLabel("Withdrawal Slip No", withdrawalSlipNo);
	}

	public void typeWithdrawalBankExchRate(String withdrawalBankExchRate) {
		enterInputFieldWithLabel("Withdrawal Bank Exch Rate",
				withdrawalBankExchRate);
	}

	// Detail

	public void chooseCreditDebit(String transactionType, String creditDebit,
			int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Credit/Debit");
		selectDdlByText(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//select", creditDebit);
		waitForAllJSCompletes();
	}

	public void typePaidTo(String transactionType, String paidTo, int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Paid to");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input", paidTo);
	}

	public void typeAmount(String transactionType, String amount, int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Amount");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input", amount);
	}

	public void typeSalesTax(String transactionType, String salesTax,
			int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Sales Tax");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input", salesTax.toUpperCase());

	}

	public void typeDocumentNo(String transactionType, String documentNo,
			int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Document No");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input", documentNo);
	}

	public void typeDocDate(String transactionType, String docDate, int rowIndex) {
		String xParentTb = xDetailTb;
		int colIndex = getTbColHeaderIndex(xParentTb, "Doc Date");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xParentTb, rowIndex, colIndex)
						+ "//input[@type='text']", docDate);
	}

	// ===============================================
	// ============ ALLOCATION PROJECT ===============

	public void chooseType(String type, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb, "Type");
		selectDdlByText(
				xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
						colIndex) + "//select", type);
	}

	public void chooseOACode(String oACode, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb, "OA Code");
		clickOnElement(xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
				colIndex) + "//a[href]");

		String xSearchTb = "//table[@id='searchModalPanelContentTable']";
		enterInputFieldWithLabel(xSearchTb, "Operational Asset Code", oACode);
		clickBtn(xSearchTb, "Search", 1);
		waitForAllJSCompletes();

		String xRowSelect = xSearchTb
				+ "//table[child::thead]/tbody//td[1 and descendant-or-self::*[text()='"
				+ oACode.toUpperCase() + "']]//*[@href]";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
		} else
			close_from();
	}

	public void chooseVoucherNo(String voucherNo, String phaseSequenceNo,
			String lINo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb, "Voucher No.");
		String xIconSearch = xPathTbDataCellByPosition(xAllocationDetailTb,
				rowIndex, colIndex) + "//img";
		clickOnElement(xIconSearch);
		waitForAllJSCompletes();

		enterInputFieldWithLabel("Project No.", voucherNo);
		clickBtn("Search");

		String xParentSearchTb = xParentSearchDiv + "//table[child::thead]";
		int colProjectNo = getTbColHeaderIndex(xParentSearchTb, "Project No.");

		String subDetail = "child::td[" + colProjectNo
				+ " and descendant::*[text()='" + voucherNo.toUpperCase()
				+ "']]";
		if (!phaseSequenceNo.isEmpty()) {
			int colPharseSeqNo = getTbColHeaderIndex(xParentSearchTb,
					"Phase Seq No.");
			subDetail += " and child::td[" + colPharseSeqNo
					+ " and descendant::*[text()='"
					+ phaseSequenceNo.toUpperCase() + "']]";
		}
		if (!lINo.isEmpty()) {
			int colLINo = getTbColHeaderIndex(xParentSearchTb, "Seq No");
			subDetail += " and child::td[" + colLINo
					+ " and descendant::*[text()='" + lINo.toUpperCase()
					+ "']]";
		}

		String xRowSelect = xParentSearchDiv
				+ "//table[child::thead]/tbody/tr[" + subDetail + "]";

		try {
			clickOnElement(xRowSelect + "/td[1]//a[@href]");
		} catch (Exception ex) {
		}
	}

	public void typePhaseSequenceNo(String phaseSequenceNo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb,
				"Phase Sequence No.");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
						colIndex) + "//input[@type='text']", phaseSequenceNo);
	}

	public void typeLINo(String lINo, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb, "LI No.");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
						colIndex) + "//input[@type='text']", lINo);
	}

	public void typeAllocationAmt(String allocationAmt, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb,
				"Allocation Amt");
		waitTypeAndEnter(
				xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
						colIndex) + "//input[@type='text']", allocationAmt);
	}

	public void chooseDelete(String delete, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb, "Delete");
		clickOnElement(xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
				colIndex) + "//*[@href]");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseSel(String sel, int rowIndex) {
		int colIndex = getTbColHeaderIndex(xAllocationDetailTb, "Sel");
		clickOnElement(xPathTbDataCellByPosition(xAllocationDetailTb, rowIndex,
				colIndex) + "//input[@type='checkbox']");
		waitForAllJSCompletes();
		clickBtn(xPopUp, "Delete");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseLiNo(String liNo) {
		int colIndex = getTbColHeaderIndex(xDetailTb, "Allocation");
		String xRowSelect = xDetailTb + "/tbody/tr[child::td[1 and text()='"
				+ liNo.trim() + "']]/td[" + colIndex + "]//*[@href]";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
		}
	}

	public int countRowAllocationTb() {
		return findAll(xAllocationDetailTb + "/tbody/tr[@class]").size();
	}

	public void getVoucherNo(String ssBKTrans) {
		String vchNo = getTextValueWithLabel("Bank Voucher No.", 2);
		setDataToNewSession(vchNo, ssBKTrans);
	}

	public void clickOnLastUpdateDatAtDratTab() {
		String xPath = xPathTbHeaderCell(xDraftTb, "Last Updated Date")
				+ "//a[@href]";
		clickOnElement(xPath);
		waitForAllJSCompletes();
		clickOnElement(xPath);
		waitForAllJSCompletes();
	}

	public void chooseVchNoAtDraftTab(String firstVch, int amtVch) {
		String xRowSelect = xDraftTb
				+ "/tbody/tr[child::td[2 and descendant::*[text()='"
				+ firstVch.toUpperCase() + "']]]";
		clickOnElement(xRowSelect + "/td[1]//input[@type='checkbox']");
		waitForAllJSCompletes();
		for (int i = 1; i < amtVch; i++) {
			clickOnElement(xRowSelect + "/preceding-sibling::tr[@class][" + i
					+ "]/td[1]//input[@type='checkbox']");
			waitForAllJSCompletes();
		}
		waitForAllJSCompletes();
	}

	public void chooseVchNoAtDraftTab(String firstVch) {
		chooseVchNoAtDraftTab(firstVch, 1);
	}
}
