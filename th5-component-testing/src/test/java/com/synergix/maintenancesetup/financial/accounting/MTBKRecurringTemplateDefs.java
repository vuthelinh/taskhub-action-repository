package com.synergix.maintenancesetup.financial.accounting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.synergix.mtsetup.financial.accounting.steps.MTBKRecurringTemplateSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTBKRecurringTemplateDefs {

	@Steps
	MTBKRecurringTemplateSteps onMTBKRecurringTemplateSteps;

	boolean isContinue = false;

	@When("^user create BK recurring template as \"([^\"]*)\"$")
	public void user_create_BK_recurring_template_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "MTBKRecurringTemplate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYBK = "KEY BK";
		String colBankTemplateCode = "Bank Template Code";
		String colTemplateDescription = "Template Description";
		String colBankVoucherDescription = "Bank Voucher Description";
		String colRecurringFrequency = "Recurring Frequency";
		String colRecurringDay = "Recurring Day";
		String colRecurrenceStartDate = "Recurrence Start Date";
		String colRecurrenceEndDate = "Recurrence End Date";
		String colLastRecurredDate = "Last Recurred Date";
		String colTransactionType = "Transaction Type";

		isContinue = false;
		for (int rowMTBKRecurringTemplate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
				.keySet()) {
			String bankTemplateCode = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colBankTemplateCode);
			String templateDescription = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colTemplateDescription);
			String bankVoucherDescription = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colBankVoucherDescription);
			String recurringFrequency = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colRecurringFrequency);
			String recurringDay = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate, colRecurringDay);
			String recurrenceStartDate = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colRecurrenceStartDate);
			String recurrenceEndDate = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colRecurrenceEndDate);
			String lastRecurredDate = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colLastRecurredDate);
			String transactionType = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colTransactionType);

			onMTBKRecurringTemplateSteps.clickOnNewBtn();

			if (!bankTemplateCode.isEmpty()) {
				onMTBKRecurringTemplateSteps.typeBankTemplateCode(bankTemplateCode);

				isContinue = true;

				if (!templateDescription.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeTemplateDescription(templateDescription);
				}
				if (!bankVoucherDescription.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeBankVoucherDescription(bankVoucherDescription);
				}
				if (!recurringFrequency.isEmpty()) {
					onMTBKRecurringTemplateSteps.chooseRecurringFrequency(recurringFrequency);
				}
				if (!recurringDay.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeRecurringDay(recurringDay);
				}
				if (recurrenceStartDate.isEmpty()) {
					recurrenceStartDate = onMTBKRecurringTemplateSteps.getToday();
				}
				onMTBKRecurringTemplateSteps.typeRecurrenceStartDate(recurrenceStartDate);

				if (!recurrenceEndDate.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeRecurrenceEndDate(recurrenceEndDate);
				}
				if (!lastRecurredDate.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeLastRecurredDate(lastRecurredDate);
				}
				if (!transactionType.isEmpty()) {
					onMTBKRecurringTemplateSteps.chooseTransactionType(transactionType);
				}
			}
		}
	}

	@When("^user update BK recurring template as \"([^\"]*)\"$")
	public void user_update_BK_recurring_template_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "MTBKRecurringTemplate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYBK = "KEY BK";
		String colBankTemplateCode = "Bank Template Code";
		String colTemplateDescription = "Template Description";
		String colBankVoucherDescription = "Bank Voucher Description";
		String colRecurringFrequency = "Recurring Frequency";
		String colRecurringDay = "Recurring Day";
		String colRecurrenceStartDate = "Recurrence Start Date";
		String colRecurrenceEndDate = "Recurrence End Date";
		String colLastRecurredDate = "Last Recurred Date";
		String colTransactionType = "Transaction Type";

		isContinue = false;
		for (int rowMTBKRecurringTemplate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
				.keySet()) {
			String bankTemplateCode = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colBankTemplateCode);
			String templateDescription = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colTemplateDescription);
			String bankVoucherDescription = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colBankVoucherDescription);
			String recurringFrequency = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colRecurringFrequency);
			String recurringDay = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate, colRecurringDay);
			String recurrenceStartDate = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colRecurrenceStartDate);
			String recurrenceEndDate = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colRecurrenceEndDate);
			String lastRecurredDate = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colLastRecurredDate);
			String transactionType = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colTransactionType);

			onMTBKRecurringTemplateSteps.clickOnNewBtn();

			if (!bankTemplateCode.isEmpty()) {
				if (onMTBKRecurringTemplateSteps.searchBankTemplateCode(bankTemplateCode)) {

					isContinue = true;

					if (!templateDescription.isEmpty()) {
						onMTBKRecurringTemplateSteps.typeTemplateDescription(templateDescription);
					}
					if (!bankVoucherDescription.isEmpty()) {
						onMTBKRecurringTemplateSteps.typeBankVoucherDescription(bankVoucherDescription);
					}
					if (!recurringFrequency.isEmpty()) {
						onMTBKRecurringTemplateSteps.chooseRecurringFrequency(recurringFrequency);
					}
					if (!recurringDay.isEmpty()) {
						onMTBKRecurringTemplateSteps.typeRecurringDay(recurringDay);
					}
					if (recurrenceStartDate.isEmpty()) {
						recurrenceStartDate = onMTBKRecurringTemplateSteps.getToday();
					}
					onMTBKRecurringTemplateSteps.typeRecurrenceStartDate(recurrenceStartDate);

					if (!recurrenceEndDate.isEmpty()) {
						onMTBKRecurringTemplateSteps.typeRecurrenceEndDate(recurrenceEndDate);
					}
					if (!lastRecurredDate.isEmpty()) {
						onMTBKRecurringTemplateSteps.typeLastRecurredDate(lastRecurredDate);
					}
					if (!transactionType.isEmpty()) {
						onMTBKRecurringTemplateSteps.chooseTransactionType(transactionType);
					}
				}
			}
		}
	}

	@When("^user delete BK recurring template$")
	public void user_delete_BK_recurring_template() {
		if (isContinue) {
			onMTBKRecurringTemplateSteps.clickOnDelBKBtn();
			isContinue = false;
		}
	}

	@When("^user delete BK recurring template as \"([^\"]*)\"$")
	public void user_delete_BK_recurring_template_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "DelMTBKRecurringTemplate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYBK = "KEY BK";
		String colBankTemplateCode = "Bank Template Code";

		isContinue = false;
		for (int rowMTBKRecurringTemplate : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
				.keySet()) {
			String bankTemplateCode = SessionData.getDataTbVal(dataTableKey, rowMTBKRecurringTemplate,
					colBankTemplateCode);

			if (!bankTemplateCode.isEmpty()) {
				onMTBKRecurringTemplateSteps.clickOnNewBtn();
				onMTBKRecurringTemplateSteps.deleteValueBySearchBtn(bankTemplateCode);
			}
		}
	}

	@When("^BK recurring template is deposit as \"([^\"]*)\"$")
	public void BK_recurring_template_is_deposit_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKDeposit";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colModeofDeposit = "Mode of Deposit";
			String colDepositbankkAcNo = "Deposit bankk A/c No";
			String colCurrency = "Currency";
			String colDepositSlipNo = "Deposit Slip No";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKDeposit : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
					.keySet()) {
				String modeofDeposit = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colModeofDeposit);
				String depositbankkAcNo = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colDepositbankkAcNo);
				String currency = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colCurrency);
				String depositSlipNo = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colDepositSlipNo);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowBKDeposit, colSegment4);

				if (!modeofDeposit.isEmpty()) {
					onMTBKRecurringTemplateSteps.chooseModeofDeposit(modeofDeposit);
				}
				if (!depositbankkAcNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeDepositbankkAcNo(depositbankkAcNo);
				}
				if (!currency.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeCurrency(currency);
				}
				if (!depositSlipNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.chooseDepositSlipNo(depositSlipNo);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

				onMTBKRecurringTemplateSteps.setSegment(listSegment);
			}
		}
	}

	@When("^BK deposit is added detail as \"([^\"]*)\"$")
	public void BK_deposit_is_added_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKDepositDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colReceivedFrom = "Received From";
			String colChequeNo = "Cheque No.";
			String colAmount = "Amount";
			String colSalesTax = "Sales Tax";
			String colDocumentNo = "Document No";
			String colDocDate = "Doc Date";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colDel = "Del";

			String xDepositDetailTb = "//table[contains(@id, 'lineItemsTable') and child::thead]";

			for (int rowBKDepositDetail : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
					.keySet()) {
				String receivedFrom = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colReceivedFrom);
				String chequeNo = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colChequeNo);
				String amount = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colAmount);
				String salesTax = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colSalesTax);
				String documentNo = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colDocumentNo);
				String docDate = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colDocDate);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colSegment4);
				String del = SessionData.getDataTbVal(dataTableKey, rowBKDepositDetail, colDel);

				onMTBKRecurringTemplateSteps.clickOnAddBtn();
				int rowIndex = onMTBKRecurringTemplateSteps.getRowTb(xDepositDetailTb);

				if (!receivedFrom.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeReceivedFrom(xDepositDetailTb, receivedFrom, rowIndex);
				}
				if (!chequeNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeChequeNo(xDepositDetailTb, chequeNo, rowIndex);
				}
				if (!amount.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeAmount(xDepositDetailTb, amount, rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeSalesTax(xDepositDetailTb, salesTax, rowIndex);
				}
				if (!documentNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeDocumentNo(xDepositDetailTb, documentNo, rowIndex);
				}
				if (!docDate.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeDocDate(xDepositDetailTb, docDate, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onMTBKRecurringTemplateSteps.setSegment(xDepositDetailTb, listSegment, rowIndex);

				if (del.toLowerCase().equals("y")) {
					onMTBKRecurringTemplateSteps.chooseDelDetail(xDepositDetailTb, rowIndex);
				}
			}
		}
	}

	@When("^BK recurring template is fund transfer as \"([^\"]*)\"$")
	public void BK_recurring_template_is_fund_transfer_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKFundTransfer";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colRemittanceBankAcNo = "Remittance Bank A/c No (Code > No.)";
			String colDestinationBankAcNo = "Destination Bank A/c No (Code > No.)";
			String colTransferAmount = "Transfer Amount";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKFundTransfer : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
					.keySet()) {
				String remittanceBankAcNo = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer,
						colRemittanceBankAcNo);
				String destinationBankAcNo = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer,
						colDestinationBankAcNo);
				String transferAmount = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer, colTransferAmount);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowBKFundTransfer, colSegment4);

				if (!remittanceBankAcNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeRemittanceBankAcNo(remittanceBankAcNo);
				}
				if (!destinationBankAcNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeDestinationBankAcNo(destinationBankAcNo);
				}
				if (!transferAmount.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeTransferAmount(transferAmount);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onMTBKRecurringTemplateSteps.setSegment(listSegment);

			}

		}
	}

	@When("^BK recurring template is withdrawal as \"([^\"]*)\"$")
	public void BK_recurring_template_is_withdrawal_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKWithdrawal";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colModeofWithdrawal = "Mode of Withdrawal";
			String colWithdrawalBankACNo = "Withdrawal Bank A/C No";
			String colCurrency = "Currency";
			String colWithdrawalSlipNo = "Withdrawal Slip No";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowBKWithdrawal : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
					.keySet()) {
				String modeofWithdrawal = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colModeofWithdrawal);
				String withdrawalBankACNo = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal,
						colWithdrawalBankACNo);
				String currency = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colCurrency);
				String withdrawalSlipNo = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colWithdrawalSlipNo);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawal, colSegment4);

				if (!modeofWithdrawal.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeModeofWithdrawal(modeofWithdrawal);
				}
				if (!withdrawalBankACNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeWithdrawalBankACNo(withdrawalBankACNo);
				}
				if (!currency.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeCurrency(currency);
				}
				if (!withdrawalSlipNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeWithdrawalSlipNo(withdrawalSlipNo);
				}
				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

				onMTBKRecurringTemplateSteps.setSegment(listSegment);
			}
		}
	}

	@When("^BK withdrawal is added detail as \"([^\"]*)\"$")
	public void BK_withdrawal_is_added_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "BKWithdrawalDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYBK = "KEY BK";
			String colPaidto = "Paid to";
			String colChequeNo = "Cheque No.";
			String colAmount = "Amount";
			String colSalesTax = "Sales Tax";
			String colDocumentNo = "Document No";
			String colDocDate = "Doc Date";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colDel = "Del";

			String xWithDrawalDetailTb = "//table[contains(@id, 'withdrawLineItemsTable') and child::thead]";

			for (int rowBKWithdrawalDetail : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYBK, dataKey)
					.keySet()) {
				String paidto = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colPaidto);
				String chequeNo = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colChequeNo);
				String amount = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colAmount);
				String salesTax = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colSalesTax);
				String documentNo = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colDocumentNo);
				String docDate = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colDocDate);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colSegment4);
				String del = SessionData.getDataTbVal(dataTableKey, rowBKWithdrawalDetail, colDel);

				onMTBKRecurringTemplateSteps.clickOnAddBtn();
				int rowIndex = onMTBKRecurringTemplateSteps.getRowTb(xWithDrawalDetailTb);

				if (!paidto.isEmpty()) {
					onMTBKRecurringTemplateSteps.typePaidto(xWithDrawalDetailTb, paidto, rowIndex);
				}
				if (!chequeNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeChequeNo(xWithDrawalDetailTb, chequeNo, rowIndex);
				}
				if (!amount.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeAmount(xWithDrawalDetailTb, amount, rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeSalesTax(xWithDrawalDetailTb, salesTax, rowIndex);
				}
				if (!documentNo.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeDocumentNo(xWithDrawalDetailTb, documentNo, rowIndex);
				}
				if (!docDate.isEmpty()) {
					onMTBKRecurringTemplateSteps.typeDocDate(xWithDrawalDetailTb, docDate, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onMTBKRecurringTemplateSteps.setSegment(xWithDrawalDetailTb, listSegment, rowIndex);

				if (del.toLowerCase().equals("y")) {
					onMTBKRecurringTemplateSteps.chooseDelDetail(xWithDrawalDetailTb, rowIndex);
				}
			}

		}
	}
}
