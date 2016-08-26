package com.synergix.processing.bankbook;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.synergix.common.actions.DatasetBase;
import com.synergix.processing.bankbook.steps.BKTransactionVchSteps;
import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BKTransactionVchDefs extends DatasetBase {
	@Steps
	BKTransactionVchSteps onBKTransactionVchSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String parentPath = "E:\\Testing\\New\\";

	String ssBKTransVch = "BKTransVch";

	String ssSQL1 = "BKResultSQL1";
	String ssSQL2 = "BKResultSQL2";
	String ssSQL3 = "BKResultSQL3";
	String ssSQL4 = "BKResultSQL4";
	String ssSQL5 = "BKResultSQL5";
	String ssSQL6 = "BKResultSQL6";
	String ssSQL7 = "BKResultSQL7";
	String ssSQL8 = "BKResultSQL8";
	String ssSQL9 = "BKResultSQL9";
	String ssSQL10 = "BKResultSQL10";
	String ssSQL11 = "BKResultSQL11";

	// DONE
	@When("^user create BK transaction voucher as \"([^\"]*)\"$")
	public void user_create_BK_transaction_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "BKTransactionVch";
		SessionData.addDataTable(dataTableKey, dataTable, false);

		String colKEYBK = "KEY BK";
		String colBankVoucherDescription = "Bank Voucher Description";
		String colReceivedFrom = "Received From/Payee Name";
		String colTransactionType = "Transaction Type";

		for (int rowBKTransactionVch : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
				.keySet()) {
			String bankVoucherDescription = SessionData.getDataTbVal(
					dataTableKey, rowBKTransactionVch,
					colBankVoucherDescription);
			String receivedFrom = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVch, colReceivedFrom);
			String transactionType = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVch, colTransactionType);

			if (!bankVoucherDescription.isEmpty()) {
				onBKTransactionVchSteps.clickOnNewBtn();
				onBKTransactionVchSteps
						.typeBankVoucherDescription(bankVoucherDescription);

				if (!transactionType.isEmpty()) {
					onBKTransactionVchSteps
							.chooseTransactionType(transactionType);
				}
				if (!receivedFrom.isEmpty()) {
					onBKTransactionVchSteps.typeReceivedFrom(receivedFrom,
							transactionType);
				}
				isContinue = true;
				isUpdate = false;

				onBKTransactionVchSteps.getVoucherNo(ssBKTransVch);
			}
		}
	}

	// DONE
	@When("^user update BK transaction voucher as \"([^\"]*)\"$")
	public void user_update_BK_transaction_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "BKTransactionVchUpdate";
		SessionData.addDataTable(dataTableKey, dataTable, false);

		String colKEYBK = "KEY BK";
		String colBankVoucherNo = "Bank Voucher No";
		String colBankVoucherDescription = "Bank Voucher Description";
		String colReceivedFrom = "Received From/Payee Name";
		String colTransactionType = "Transaction Type";

		for (int rowBKTransactionVch : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
				.keySet()) {
			String bankVoucherNo = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVch, colBankVoucherNo);
			String bankVoucherDescription = SessionData.getDataTbVal(
					dataTableKey, rowBKTransactionVch,
					colBankVoucherDescription);
			String receivedFrom = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVch, colReceivedFrom);
			String transactionType = SessionData.getDataTbVal(dataTableKey,
					rowBKTransactionVch, colTransactionType);

			if (!bankVoucherNo.isEmpty()) {
				if (onBKTransactionVchSteps.searchBankVchNo(bankVoucherNo)) {
					if (!bankVoucherDescription.isEmpty()) {
						onBKTransactionVchSteps
								.typeBankVoucherDescription(bankVoucherDescription);
					}
					if (!transactionType.isEmpty()) {
						onBKTransactionVchSteps
								.chooseTransactionType(transactionType);
					}
					if (!receivedFrom.isEmpty()) {
						onBKTransactionVchSteps.typeReceivedFrom(receivedFrom,
								transactionType);
					}
					isContinue = true;
					isUpdate = true;

					onBKTransactionVchSteps.getVoucherNo(ssBKTransVch);
				}
			}
		}
	}

	// DONE
	@When("^BK transaction voucher is deposit as \"([^\"]*)\"$")
	public void BK_transaction_voucher_is_deposit_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKTransactionVchDeposit";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colModeofDeposit = "Mode of Deposit";
			String colBankVchDate = "Bank Vch Date";
			String colDepositSlipDate = "Deposit Slip Date";
			String colBankPartyCode = "Bank Party Code";
			String colBankAccountNo = "Bank Account No";
			String colCurrency = "Currency";
			String colCrossRate = "Cross Rate";
			String colSBUCode = "SBU Code";
			String colValueDate = "Value Date";
			String colChequeNo = "Cheque No.";
			String colDepositSlipNo = "Deposit Slip No";
			String colDepositBankExchRate = "Deposit Bank Exch Rate";
			String colExchRate = "Exch Rate";
			String colDefaultSalesTax = "Default Sales Tax";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKTransactionVchDeposit : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK,
							dataKey).keySet()) {
				String modeofDeposit = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colModeofDeposit);
				String bankVchDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colBankVchDate);
				String depositSlipDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colDepositSlipDate);
				String bankPartyCode = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colBankPartyCode);
				String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colBankAccountNo);
				String currency = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colCurrency);
				String crossRate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colCrossRate);
				String sBUCode = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colSBUCode);
				String valueDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colValueDate);
				String chequeNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colChequeNo);
				String depositSlipNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colDepositSlipNo);
				String depositBankExchRate = SessionData.getDataTbVal(
						dataTableKey, rowBKTransactionVchDeposit,
						colDepositBankExchRate);
				String exchRate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colExchRate);
				String defaultSalesTax = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colDefaultSalesTax);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDeposit, colSegment4);

				if (!modeofDeposit.isEmpty()) {
					onBKTransactionVchSteps.chooseModeofDeposit(modeofDeposit);
				}
				if (!bankVchDate.isEmpty()) {
					onBKTransactionVchSteps.typeBankVchDate(bankVchDate);
				}
				if (!depositSlipDate.isEmpty()) {
					onBKTransactionVchSteps
							.typeDepositSlipDate(depositSlipDate);
				}
				if (!bankPartyCode.isEmpty()) {
					onBKTransactionVchSteps
							.searchBankPartyCode("Deposit Bank A/C No",
									bankPartyCode, bankAccountNo);
				}
				if (!currency.isEmpty()) {
					onBKTransactionVchSteps.typeCurrency(currency);
				}
				if (!crossRate.isEmpty()) {
					onBKTransactionVchSteps.typeCrossRate(crossRate);
				}
				if (!sBUCode.isEmpty()) {
					onBKTransactionVchSteps.typeSBUCode(sBUCode);
				}
				if (!valueDate.isEmpty()) {
					onBKTransactionVchSteps.typeValueDate(valueDate);
				}
				if (!chequeNo.isEmpty()) {
					onBKTransactionVchSteps.typeChequeNo(chequeNo);
				}
				if (!depositSlipNo.isEmpty()) {
					onBKTransactionVchSteps.typeDepositSlipNo(depositSlipNo);
				}
				if (!depositBankExchRate.isEmpty()) {
					onBKTransactionVchSteps
							.typeDepositBankExchRate(depositBankExchRate);
				}
				if (!exchRate.isEmpty()) {
					onBKTransactionVchSteps.typeExchRate(exchRate);
				}
				if (!defaultSalesTax.isEmpty()) {
					onBKTransactionVchSteps
							.typeDefaultSalesTax(defaultSalesTax);
				}
				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));

				onBKTransactionVchSteps.setSegment(listSegment);
			}
		}
	}

	// DONE
	@When("^BK deposit transaction voucher is add detail as \"([^\"]*)\"$")
	public void BK_deposit_transaction_voucher_is_add_detail_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {

			String transactionType = "Deposit";

			String dataTableKey = "BKTransactionVchDDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colLineItems = "Line No.";
			String colCreditDebit = "Credit/Debit";
			String colReceivedFrom = "Received From";
			String colAmount = "Amount";
			String colSalesTax = "Sales Tax";
			String colDocumentNo = "Document No";
			String colDocDate = "Doc Date";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKTransactionVchDDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK,
							dataKey).keySet()) {
				String lineItems = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colLineItems);
				String creditDebit = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colCreditDebit);
				String receivedFrom = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colReceivedFrom);
				String amount = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colAmount);
				String salesTax = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colSalesTax);
				String documentNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colDocumentNo);
				String docDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colDocDate);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchDDetail, colSegment4);

				onBKTransactionVchSteps.clickOnAddBtn();
				int rowIndex = onBKTransactionVchSteps
						.countRowDetailsTb(transactionType);

				if (!creditDebit.isEmpty()) {
					onBKTransactionVchSteps.chooseCreditDebit(transactionType,
							creditDebit, rowIndex);
				}
				if (!receivedFrom.isEmpty()) {
					onBKTransactionVchSteps.typeReceivedFrom(transactionType,
							receivedFrom, rowIndex);
				}
				if (!amount.isEmpty()) {
					onBKTransactionVchSteps.typeAmount(transactionType, amount,
							rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onBKTransactionVchSteps.typeSalesTax(transactionType,
							salesTax, rowIndex);
				}
				if (!documentNo.isEmpty()) {
					onBKTransactionVchSteps.typeDocumentNo(transactionType,
							documentNo, rowIndex);
				}
				if (!docDate.isEmpty()) {
					onBKTransactionVchSteps.typeDocDate(transactionType,
							docDate, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));

				onBKTransactionVchSteps.setSegment(transactionType,
						listSegment, rowIndex);
			}
		}
	}


	@When("^BK transaction voucher is fund transfer as \"([^\"]*)\"$")
	public void BK_transaction_voucher_is_fund_transfer_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKTransFund";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colModeofTransfer = "Mode of Transfer";
			String colBankVchDate = "Bank Vch Date";
			String colTransferAdviceDate = "Transfer Advice Date";
			String colRemittanceBankACName = "Remittance Bank A/C Name";
			String colRemittanceBankACNo = "Remittance Bank A/C No";
			String colDestinationBankACName = "Destination Bank A/C Name";
			String colDestinationBankACNo = "Destination Bank A/C No";
			String colTransferAmount = "Transfer Amount";
			String colCrossRate = "Cross Rate";
			String colValueDate = "Value Date";
			String colTransferAdviceNo = "Transfer Advice No";
			String colRemittanceBankExchRate = "Remittance Bank Exch Rate";
			String colDestinationBankExchRate = "Destination Bank Exch Rate";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKTransFund : SessionData.getDataTbRowsByValEqualInCol(
					dataTableKey, colKEYBK, dataKey).keySet()) {
				String modeofTransfer = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colModeofTransfer);
				String bankVchDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colBankVchDate);
				String transferAdviceDate = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund, colTransferAdviceDate);
				String remittanceBankACName = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund, colRemittanceBankACName);
				String remittanceBankACNo = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund, colRemittanceBankACNo);
				String destinationBankACName = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund, colDestinationBankACName);
				String destinationBankACNo = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund, colDestinationBankACNo);
				String transferAmount = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colTransferAmount);
				String crossRate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colCrossRate);
				String valueDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colValueDate);
				String transferAdviceNo = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund, colTransferAdviceNo);
				String remittanceBankExchRate = SessionData
						.getDataTbVal(dataTableKey, rowBKTransFund,
								colRemittanceBankExchRate);
				String destinationBankExchRate = SessionData.getDataTbVal(
						dataTableKey, rowBKTransFund,
						colDestinationBankExchRate);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransFund, colSegment4);

				if (!modeofTransfer.isEmpty()) {
					onBKTransactionVchSteps.typeModeofTransfer(modeofTransfer);
				}
				if (!bankVchDate.isEmpty()) {
					onBKTransactionVchSteps.typeBankVchDate(bankVchDate);
				}
				if (!transferAdviceDate.isEmpty()) {
					onBKTransactionVchSteps
							.typeTransferAdviceDate(transferAdviceDate);
				}
				if (!remittanceBankACName.isEmpty()) {
					onBKTransactionVchSteps.searchRemittanBank(
							remittanceBankACName, remittanceBankACNo);
				}
				if (!destinationBankACName.isEmpty()) {
					onBKTransactionVchSteps.searcDestinationBank(
							destinationBankACName, destinationBankACNo);
				}
				if (!transferAmount.isEmpty()) {
					onBKTransactionVchSteps.typeTransferAmount(transferAmount);
				}
				if (!crossRate.isEmpty()) {
					onBKTransactionVchSteps.typeCrossRate(crossRate);
				}
				if (!valueDate.isEmpty()) {
					onBKTransactionVchSteps.typeValueDate(valueDate);
				}
				if (!transferAdviceNo.isEmpty()) {
					onBKTransactionVchSteps
							.typeTransferAdviceNo(transferAdviceNo);
				}
				if (!remittanceBankExchRate.isEmpty()) {
					onBKTransactionVchSteps
							.typeRemittanceBankExchRate(remittanceBankExchRate);
				}
				if (!destinationBankExchRate.isEmpty()) {
					onBKTransactionVchSteps
							.typeDestinationBankExchRate(destinationBankExchRate);
				}
				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onBKTransactionVchSteps.setSegment(listSegment);
			}
		}
	}
	// DONE
	@When("^BK transaction voucher is withdrawal as \"([^\"]*)\"$")
	public void BK_transaction_voucher_is_withdrawal_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKTransactionVchWithdrawal";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colModeofWithdrawal = "Mode of Withdrawal";
			String colBankVchDate = "Bank Vch Date";
			String colWithdrawalSlipDate = "Withdrawal Slip Date";
			String colBankPartyCode = "Bank Party Code";
			String colBankAccountNo = "Bank Account No";
			String colCurrency = "Currency";
			String colSBUCode = "SBU Code";
			String colValueDate = "Value Date";
			String colChequeNo = "Cheque No.";
			String colWithdrawalSlipNo = "Withdrawal Slip No";
			String colWithdrawalBankExchRate = "Withdrawal Bank Exch Rate";
			String colExchRate = "Exch Rate";
			String colDefaultSalesTax = "Default Sales Tax";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKTransactionVchWithdrawal : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK,
							dataKey).keySet()) {

				String modeofWithdrawal = SessionData.getDataTbVal(
						dataTableKey, rowBKTransactionVchWithdrawal,
						colModeofWithdrawal);
				String bankVchDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colBankVchDate);
				String withdrawalSlipDate = SessionData.getDataTbVal(
						dataTableKey, rowBKTransactionVchWithdrawal,
						colWithdrawalSlipDate);
				String bankPartyCode = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colBankPartyCode);
				String bankAccountNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colBankAccountNo);
				String currency = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colCurrency);
				String sBUCode = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colSBUCode);
				String valueDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colValueDate);
				String chequeNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colChequeNo);
				String withdrawalSlipNo = SessionData.getDataTbVal(
						dataTableKey, rowBKTransactionVchWithdrawal,
						colWithdrawalSlipNo);
				String withdrawalBankExchRate = SessionData.getDataTbVal(
						dataTableKey, rowBKTransactionVchWithdrawal,
						colWithdrawalBankExchRate);
				String exchRate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colExchRate);
				String defaultSalesTax = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colDefaultSalesTax);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWithdrawal, colSegment4);

				if (!modeofWithdrawal.isEmpty()) {
					onBKTransactionVchSteps
							.chooseModeofWithdrawal(modeofWithdrawal);
				}
				if (!bankVchDate.isEmpty()) {
					onBKTransactionVchSteps.typeBankVchDate(bankVchDate);
				}
				if (!withdrawalSlipDate.isEmpty()) {
					onBKTransactionVchSteps
							.typeWithdrawalSlipDate(withdrawalSlipDate);
				}
				if (!bankPartyCode.isEmpty()) {
					onBKTransactionVchSteps.searchBankPartyCode(
							"Withdrawal Bank A/C No", bankPartyCode,
							bankAccountNo);
				}
				if (!currency.isEmpty()) {
					onBKTransactionVchSteps.typeCurrency(currency);
				}
				if (!sBUCode.isEmpty()) {
					onBKTransactionVchSteps.typeSBUCode(sBUCode);
				}
				if (!valueDate.isEmpty()) {
					onBKTransactionVchSteps.typeValueDate(valueDate);
				}
				if (!chequeNo.isEmpty()) {
					onBKTransactionVchSteps.typeChequeNo(chequeNo);
				}
				if (!withdrawalSlipNo.isEmpty()) {
					onBKTransactionVchSteps
							.typeWithdrawalSlipNo(withdrawalSlipNo);
				}
				if (!withdrawalBankExchRate.isEmpty()) {
					onBKTransactionVchSteps
							.typeWithdrawalBankExchRate(withdrawalBankExchRate);
				}
				if (!exchRate.isEmpty()) {
					onBKTransactionVchSteps.typeExchRate(exchRate);
				}
				if (!defaultSalesTax.isEmpty()) {
					onBKTransactionVchSteps
							.typeDefaultSalesTax(defaultSalesTax);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));

				onBKTransactionVchSteps.setSegment(listSegment);
			}
		}
	}

	// DONE
	@When("^BK withdrawal transaction voucher is add detail as \"([^\"]*)\"$")
	public void BK_withdrawal_transaction_voucher_is_add_detail_as(
			String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKTransactionVchWDetails";
			SessionData.addDataTable(dataTableKey, dataTable);

			String transactionType = "Withdrawal";

			String colKEYBK = "KEY BK";
			String colCreditDebit = "Credit/Debit";
			String colPaidto = "Paid to";
			String colAmount = "Amount";
			String colSalesTax = "Sales Tax";
			String colDocumentNo = "Document No";
			String colDocDate = "Doc Date";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colExpectedMessage = " Expected Message ";

			for (int rowBKTransactionVchWDetails : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK,
							dataKey).keySet()) {
				String creditDebit = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colCreditDebit);
				String paidTo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colPaidto);

				String amount = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colAmount);
				String salesTax = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colSalesTax);
				String documentNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colDocumentNo);
				String docDate = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colDocDate);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colSegment4);
				String expectedMessage = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchWDetails, colExpectedMessage);

				onBKTransactionVchSteps.clickOnAddBtn();
				int rowIndex = onBKTransactionVchSteps
						.countRowDetailsTb(transactionType);

				if (!creditDebit.isEmpty()) {
					onBKTransactionVchSteps.chooseCreditDebit(transactionType,
							creditDebit, rowIndex);
				}
				if (!paidTo.isEmpty()) {
					onBKTransactionVchSteps.typePaidTo(transactionType, paidTo,
							rowIndex);
				}
				if (!amount.isEmpty()) {
					onBKTransactionVchSteps.typeAmount(transactionType, amount,
							rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onBKTransactionVchSteps.typeSalesTax(transactionType,
							salesTax, rowIndex);
				}
				if (!documentNo.isEmpty()) {
					onBKTransactionVchSteps.typeDocumentNo(transactionType,
							documentNo, rowIndex);
				}
				if (!docDate.isEmpty()) {
					onBKTransactionVchSteps.typeDocDate(transactionType,
							docDate, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onBKTransactionVchSteps.setSegment(transactionType,
						listSegment, rowIndex);
			}
		}
	}

	@When("^BK transaction voucher is add allocation as \"([^\"]*)\"$")
	public void BK_transaction_voucher_is_add_allocation_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKTransactionVchAlloc";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colLiNo = "Li No.";
			String colType = "Type";
			String colOACode = "OA Code";
			String colVoucherNo = "Voucher No.";
			String colPhaseSequenceNo = "Phase Sequence No.";
			String colLINo = "LI No.";
			String colAllocationAmt = "Allocation Amt";
			String colDelete = "Delete";
			String colSel = "Sel";
			String colExpectedMessage = "Expected Message";
			for (int rowBKTransactionVchAlloc : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK,
							dataKey).keySet()) {
				String liNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colLiNo);
				String type = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colType);
				String oACode = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colOACode);
				String voucherNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colVoucherNo);
				String phaseSequenceNo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colPhaseSequenceNo);
				String lINo = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colLINo);
				String allocationAmt = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colAllocationAmt);
				String delete = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colDelete);
				String sel = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colSel);
				String expectedMessage = SessionData.getDataTbVal(dataTableKey,
						rowBKTransactionVchAlloc, colExpectedMessage);

				if (!liNo.isEmpty()) {
					onBKTransactionVchSteps.chooseLiNo(liNo);
				}

				onBKTransactionVchSteps.clickOnAddAllocateBtn();

				int rowIndex = onBKTransactionVchSteps.countRowAllocationTb();

				if (!type.isEmpty()) {
					onBKTransactionVchSteps.chooseType(type, rowIndex);
				}
				if (!oACode.isEmpty()) {
					onBKTransactionVchSteps.chooseOACode(oACode, rowIndex);
				}
				if (!voucherNo.isEmpty()) {
					onBKTransactionVchSteps.chooseVoucherNo(voucherNo,
							phaseSequenceNo, lINo, rowIndex);
				}
				if (!allocationAmt.isEmpty()) {
					onBKTransactionVchSteps.typeAllocationAmt(allocationAmt,
							rowIndex);
				}
				if (!delete.isEmpty()) {
					onBKTransactionVchSteps.chooseDelete(delete, rowIndex);
				}
				if (!sel.isEmpty()) {
					onBKTransactionVchSteps.chooseSel(sel, rowIndex);
				}

				onBKTransactionVchSteps.clickOnCloseAllocationDetail();
			}
		}
	}

	@When("^BK transaction preview report \"([^\"]*)\"$")
	public void BK_transaction_is_previewed(String reportName) {
		if (isContinue) {
			onBKTransactionVchSteps.clickOnPreviewBtn(reportName);
		}
	}

	@When("^BK transaction is submitted$")
	public void BK_transaction_is_submitted() {
		if (isContinue) {
			onBKTransactionVchSteps.clickOnSubmitBtn();
		}
	}

	@When("^BK transaction preview at history tab with report name \"([^\"]*)\"$")
	public void BK_transaction_preview_at_history_tab_with_report_name(
			String reportName) {
		if (isContinue) {
			onBKTransactionVchSteps.switchToIFrame();
			String bankVchNo = onBKTransactionVchSteps
					.getDataWithSession(ssBKTransVch);
			onBKTransactionVchSteps.clickOnPreviewHSTBtn(bankVchNo, reportName);
			onBKTransactionVchSteps.switchOutDefaultIFrame();
		}
	}

	
	@When("^BK transaction get data before submit as \"([^\"]*)\"$")
	public void BK_transaction_get_data_before_submit(String dataKey) {
		String sql1 = "select BANK_VOUCHER_NO, BANK_VOUCHER_DESC, VOUCHER_DATE, VALUE_DATE, PAYEE_RECIPIENT_NAME, TRANSACTION_TYPE, MODE_OF_PAYMENT, SLIP_DATE, SLIP_NO, SBU_CODE, DEFAULT_SALES_TAX_CODE, BANK_CODE, BANK_ACCOUNT_NO, BANK_CURRENCY_CODE, DEST_BANK_CODE, DEST_BANK_ACCOUNT_NO, DEST_BANK_CURRENCY_CODE, CURRENCY_CODE, EXCH_RATE, CROSS_RATE, REMIT_BANK_EXCH_RATE, DEST_BANK_EXCH_RATE, TOTAL_TRANSACTION_AMT, TOTAL_TRANSACTION_HOME_AMT, CONVERTED_TOTAL_TRANS_AMT, TOTAL_SALES_TAX_AMT, TOTAL_SALES_TAX_HOME_AMT, CONVERTED_TTL_SALES_TAX_AMT, TOTAL_AFTER_TAX_AMT, TOTAL_AFTER_TAX_HOME_AMT, CONVERTED_TTL_AFTER_TAX_AMT, TOTAL_CHARGE_HOME_AMT, CONVERTED_TOTAL_CHARGE_AMT, TOTAL_DEST_CHARGE_HOME_AMT, CONVERTED_TOTAL_DEST_CHG_AMT, YEAR_POSTED_TO, PERIOD_POSTED_TO, SEGMENT_1_CODE, SEGMENT_2_CODE, SEGMENT_3_CODE, SEGMENT_4_CODE from BK_TRANSACTION_NEW_HDR where BANK_VOUCHER_NO='?'";
		String sql2 = "select BANK_VOUCHER_NO, LINE_ITEM_NO, SERVICE_CODE, BANK_CODE, BANK_ACCOUNT_NO, CURRENCY_CODE, EXCH_RATE, CROSS_RATE, CHARGE_AMT, CHARGE_HOME_AMT, CONVERTED_CHARGE_AMT from BK_TRANSACTION_NEW_BK_CHG where BANK_VOUCHER_NO='?'";
		String sql3 = "select BANK_VOUCHER_NO, LINE_ITEM_NO, DR_CR_TYPE, type, TRANSACTION_FOR, TRANSACTION_AMT, TRANSACTION_HOME_AMT, CONVERTED_TRANSACTION_AMT , CHEQUE_NO, DOCUMENT_NO, DOCUMENT_DATE, SALES_TAX_CODE, SEGMENT_1_CODE, SEGMENT_2_CODE, SEGMENT_3_CODE, SEGMENT_4_CODE from BK_TRANSACTION_NEW_DET where BANK_VOUCHER_NO='?'";
		String sql4 = "select BANK_VOUCHER_NO, LINE_ITEM_NO, ALLOCATION_NO, ALLOCATION_TYPE, ALLOC_AMT, ALLOC_HOME_AMT from BK_TRANSACTION_NEW_DET_ALLOC where BANK_VOUCHER_NO='?'";
		String sql5 = "select BANK_VOUCHER_NO, SALES_TAX_CODE, SALES_TAX_PERCENT, TOTAL_TAXABLE_AMT, SALES_TAX_AMT, SALES_TAX_HOME_AMT, CONVERTED_SALES_TAX_AMT, SALES_TAX_ADJ_AMT from BK_TRANSACTION_NEW_TAX where BANK_VOUCHER_NO='?'";

		if (isContinue) {
			String vchNo = onBKTransactionVchSteps
					.getDataWithSession(ssBKTransVch);
			// String vchNo="TR00075BKT";

			sql1 = sql1.replace("?", vchNo);
			sql2 = sql2.replace("?", vchNo);
			sql3 = sql3.replace("?", vchNo);
			sql4 = sql4.replace("?", vchNo);
			sql5 = sql5.replace("?", vchNo);

			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL01 - "+sql1, sql1);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL02 - "+sql2, sql2);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL03 - "+sql3, sql3);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL04 - "+sql4, sql4);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL05 - "+sql5, sql5);
		}
	}

	@When("^BK transaction get data after submit as \"([^\"]*)\"$")
	public void BK_transaction_get_data_after_submit(String dataKey) {
		String sql1 = "select BANK_VOUCHER_NO, BANK_VOUCHER_DESC, VOUCHER_DATE, PAYEE_RECIPIENT_NAME, TRANSACTION_TYPE, MODE_OF_PAYMENT, VALUE_DATE, SLIP_DATE, SLIP_NO, SBU_CODE, DEFAULT_SALES_TAX_CODE, BANK_CODE, BANK_ACCOUNT_NO, BANK_CURRENCY_CODE, CURRENCY_CODE, EXCH_RATE, REMIT_BANK_EXCH_RATE, DEST_BANK_EXCH_RATE, CROSS_RATE, TOTAL_TRANSACTION_AMT, TOTAL_TRANSACTION_HOME_AMT, CONVERTED_TOTAL_TRANS_AMT, TOTAL_SALES_TAX_AMT, TOTAL_SALES_TAX_HOME_AMT, CONVERTED_TTL_SALES_TAX_AMT, TOTAL_AFTER_TAX_AMT, TOTAL_AFTER_TAX_HOME_AMT, CONVERTED_TTL_AFTER_TAX_AMT, TOTAL_CHARGE_HOME_AMT, CONVERTED_TOTAL_CHARGE_AMT, TOTAL_DEST_CHARGE_HOME_AMT, CONVERTED_TOTAL_DEST_CHG_AMT, YEAR_POSTED_TO, PERIOD_POSTED_TO, SEGMENT_1_CODE, SEGMENT_2_CODE, SEGMENT_3_CODE,SEGMENT_4_CODE from BK_TRANSACTION_HST_HDR where BANK_VOUCHER_NO='?'";

		String sql2 = "select BANK_VOUCHER_NO, LINE_ITEM_NO, DR_CR_TYPE, type, TRANSACTION_FOR, TRANSACTION_AMT, TRANSACTION_HOME_AMT, CONVERTED_TRANSACTION_AMT, SALES_TAX_CODE, CHEQUE_NO, DOCUMENT_NO, SEGMENT_1_CODE, SEGMENT_2_CODE, SEGMENT_3_CODE, SEGMENT_4_CODE from BK_TRANSACTION_HST_DET where BANK_VOUCHER_NO='?'";
		String sql3 = "select BANK_VOUCHER_NO, LINE_ITEM_NO, ALLOCATION_NO, ALLOCATION_TYPE, ALLOC_AMT, ALLOC_HOME_AMT from BK_TRANSACTION_HST_DET_ALLOC where BANK_VOUCHER_NO='?'";
		String sql4 = "select BANK_VOUCHER_NO, LINE_ITEM_NO, SERVICE_CODE, BANK_CODE, BANK_ACCOUNT_NO, CURRENCY_CODE, EXCH_RATE, CROSS_RATE, CHARGE_AMT, CHARGE_HOME_AMT, CONVERTED_CHARGE_AMT from BK_TRANSACTION_HST_BK_CHG where BANK_VOUCHER_NO='?'";
		String sql5 = "select BANK_VOUCHER_NO, SALES_TAX_CODE, SALES_TAX_PERCENT, TOTAL_TAXABLE_AMT, SALES_TAX_AMT, SALES_TAX_HOME_AMT, CONVERTED_SALES_TAX_AMT, SALES_TAX_ADJ_AMT from BK_TRANSACTION_HST_TAX where BANK_VOUCHER_NO='?'";

		// GL Ledger
		String sql6 = "select MODULE_CODE, TRANSACTION_TYPE_CODE, SOURCE_VOUCHER_NO, CURRENCY_CODE, EXCH_RATE, GL_ACC_CODE, GL_ENTRY_TYPE, LINE_ITEM_NO, HOME_CREDIT, HOME_DEBIT, NATURE_CREDIT, NATURE_DEBIT from GL_LEDGER_SUMMARY where SOURCE_VOUCHER_NO = '?'";
		String sql7 = "select MODULE_CODE, TRANSACTION_TYPE_CODE, SOURCE_VOUCHER_NO, GL_ENTRY_TYPE, LINE_ITEM_NO from GL_LEDGER_DETAIL where MODULE_CODE='BK' and SOURCE_VOUCHER_NO='?'";

		// BK_BOOK
		String sql8 = "select SOURCE_VOUCHER_NO, SOURCE_VOUCHER_TYPE, TRANSACTION_MODE, BANK_CODE, BANK_ACCOUNT_NO, BANK_CURRENCY_CODE, TOTAL_BANK_VOUCHER_DT, TOTAL_BANK_VOUCHER_WD from BK_BOOK_TRN_OST_HDR  where SOURCE_VOUCHER_NO='?'";
		String sql9 = "select SOURCE_VOUCHER_NO, SOURCE_VOUCHER_TYPE, BANK_CODE, BANK_ACCOUNT_NO, LINE_ITEM_NO, LINE_ITEM_TYPE, BANK_VOUCHER_DEPOSIT, BANK_VOUCHER_WITHDRAWAL from BK_BOOK_TRN_OST_DET where SOURCE_VOUCHER_NO='?'";

		// Project Allocation
		String sql10 = "select COST_ALLOCATION_NO, COST_ALLOCATION_DATE, TYPE, PROJECT_NO, CURRENCY_CODE, EXCH_RATE, SOURCE_TYPE, SOURCE_VOUCHER_NO, SOURCE_COMPANY_CODE from PJ_COST_ALC_HST_HDR where SOURCE_VOUCHER_NO='?'";
		String sql11 = "select COST_ALLOCATION_NO, LINE_ITEM_NO, DT_TYPE, TYPE, SERVICE_CODE, ADD_TOTAL_AMT, ADD_TOTAL_HOME_AMT, RED_TOTAL_AMT, RED_TOTAL_HOME_AMT from PJ_COST_ALC_HST_DET where COST_ALLOCATION_NO in (select COST_ALLOCATION_NO from PJ_COST_ALC_HST_DET_ALLOC  where SOURCE_VOUCHER_NO in ('PJ00015669','PJ00015670', 'PJ00015572','PJ00015673','PJ00015674','PJ00015675', 'PJ00015676'))";
		String sql12 = "select COST_ALLOCATION_NO, LINE_ITEM_NO, ALLOCATION_NO, ALLOCATION_TYPE, SOURCE_VOUCHER_NO, SOURCE_PHASE_NO, SOURCE_LINE_ITEM_NO, ALLOC_QTY, ALLOC_UNIT_COST, ADD_ALLOC_AMT, ADD_ALLOC_HOME_AMT, RED_ALLOC_AMT, RED_ALLOC_HOME_AMT from PJ_COST_ALC_HST_DET_ALLOC where SOURCE_VOUCHER_NO in ('PJ00015669','PJ00015670', 'PJ00015572','PJ00015673','PJ00015674','PJ00015675', 'PJ00015676')";

		// Project Estimation Actual Cost
		String sql13 = "select PROJECT_NO, PHASE_NO, COST_ITEM_NO, SERVICE_CODE, TOTAL_QTY_SHIPPED, NETT_QTY_SHIPPED, TOTAL_SHIPPED_COST, TOTAL_SHIPPED_COST_HOME, TOTAL_ACTUAL_COST, TOTAL_ACTUAL_COST_HOME, TOL_TOTAL_USED_HOME from PJ_EST_OST_CST_ITM where PROJECT_NO in ('PJ00015669','PJ00015670', 'PJ00015572','PJ00015673','PJ00015674','PJ00015675', 'PJ00015676') ";

		if (isContinue) {
			String vchNo = onBKTransactionVchSteps
					.getDataWithSession(ssBKTransVch);

			sql1 = sql1.replace("?", vchNo);
			sql2 = sql2.replace("?", vchNo);
			sql3 = sql3.replace("?", vchNo);
			sql4 = sql4.replace("?", vchNo);
			sql5 = sql5.replace("?", vchNo);
			sql6 = sql6.replace("?", vchNo);
			sql7 = sql7.replace("?", vchNo);
			sql8 = sql8.replace("?", vchNo);
			sql9 = sql9.replace("?", vchNo);
			sql10 = sql10.replace("?", vchNo);
			sql11 = sql11.replace("?", vchNo);
			sql12 = sql12.replace("?", vchNo);
			sql13 = sql13.replace("?", vchNo);

			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL06 - "+sql1, sql1);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL07 - "+sql1, sql2);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL08 - "+sql3, sql3);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL09 - "+sql4, sql4);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL10 - "+sql5, sql5);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL11 - "+sql6, sql6);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL12 - "+sql7, sql7);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL13 - "+sql8, sql8);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL14 - "+sql9, sql9);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL15 - "+sql10, sql10);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL16 - "+sql11, sql11);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL17 - "+sql12, sql12);
			writeDataToExcel(parentPath + "MODI-Deluge.xls", "Scenario"
					+ dataKey + ".xls", "SQL18 - "+sql13, sql13);
		}
	}

	@When("^verify expected result of BK transaction deposit as \"([^\"]*)\"$")
	public void verify_expected_result_of_BK_transaction_deposit(String dataKey) {
		String sql1 = "select PROJECT_NO, PHASE_NO, COST_ITEM_NO, SERVICE_CODE, TOTAL_QTY_SHIPPED, NETT_QTY_SHIPPED, TOTAL_SHIPPED_COST, TOTAL_SHIPPED_COST_HOME, TOTAL_ACTUAL_COST, TOTAL_ACTUAL_COST_HOME, TOL_TOTAL_USED_HOME from PJ_EST_OST_CST_ITM where PROJECT_NO in ('PJ00015669', 'PJ00015667', 'PJE0022336') ";

		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 1, sql1);
		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 2, sql1);
		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 3, sql1);
		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 4, sql1);
	}

	@When("^verify expected result of BK transaction withdrawal as \"([^\"]*)\"$")
	public void verify_expected_result_of_BK_transaction_withdrawal(
			String dataKey) {
		String sql1 = "select PROJECT_NO, PHASE_NO, COST_ITEM_NO, SERVICE_CODE, TOTAL_QTY_SHIPPED, NETT_QTY_SHIPPED, TOTAL_SHIPPED_COST, TOTAL_SHIPPED_COST_HOME, TOTAL_ACTUAL_COST, TOTAL_ACTUAL_COST_HOME, TOL_TOTAL_USED_HOME from PJ_EST_OST_CST_ITM where PROJECT_NO in ('PJ00015669', 'PJ00015667', 'PJE0022336') ";

		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 5, sql1);
		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 6, sql1);
		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 7, sql1);
		writeDataToExcel(parentPath + "NT.xls", "Scenario" + dataKey,
				"Result" + 8, sql1);
	}

	public void writeDataToExcel(String filePath, String sheetName,
			String tableName, String sql) {
		ResultSet rs;
		rs = getResultStatement(sql);
		ExcelUtils.writeToExcel(filePath, sheetName, tableName, rs);
	}
}
