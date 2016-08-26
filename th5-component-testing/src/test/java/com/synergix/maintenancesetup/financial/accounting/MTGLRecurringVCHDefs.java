package com.synergix.maintenancesetup.financial.accounting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.mtsetup.financial.accounting.steps.MTGLRecurringVCHSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTGLRecurringVCHDefs {

	@Steps
	MTGLRecurringVCHSteps onMTGLRecurringVCHSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_MT_FINANCIAL_ACCOUNTTING + "MTGLRecurringVCH.xls";
	String keyFileName = "MTGLRecurringVCH";
	String datasetSheet = "Dataset";
	String detailSheet = "Detail";

	boolean isContinue = false;

	@When("^user create MT GL Recurring VCH as \"([^\"]*)\"$")
	public void user_create_MT_GL_Recurring_VCH_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "MTGLRecurringVCH";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRECURRING = "KEY RECURRING";
		String colRecurringVoucherCode = "Recurring Voucher Code";
		String colDescription = "Description";
		String colCurrency = "Currency";
		String colExchangeRateType = "Exchange Rate Type";
		String colSourceDocumentType = "Source Document Type";
		String colSourceDocumentNo = "Source Document No";
		String colRecurringDay = "Recurring Day";
		String colRecurringFrequency = "Recurring Frequency";
		String colRecurrenceStartDate = "Recurrence Start Date";
		String colRecurrenceEndDate = "Recurrence End Date";
		String colNextRecurrenceDate = "Next Recurrence Date";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowMTGLRecurringVCH : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRECURRING, dataKey)
				.keySet()) {
			String recurringVoucherCode = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurringVoucherCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colDescription);
			String currency = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colCurrency);
			String exchangeRateType = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colExchangeRateType);
			String sourceDocumentType = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colSourceDocumentType);
			String sourceDocumentNo = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSourceDocumentNo);
			String recurringDay = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colRecurringDay);
			String recurringFrequency = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurringFrequency);
			String recurrenceStartDate = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurrenceStartDate);
			String recurrenceEndDate = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurrenceEndDate);
			String nextRecurrenceDate = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colNextRecurrenceDate);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment4);

			onMTGLRecurringVCHSteps.clickOnNewBtn();

			if (!recurringVoucherCode.isEmpty()) {
				onMTGLRecurringVCHSteps.typeRecurringVoucherCode(recurringVoucherCode);

				isContinue = true;

				if (!description.isEmpty()) {
					onMTGLRecurringVCHSteps.typeDescription(description);
				}
				if (!currency.isEmpty()) {
					onMTGLRecurringVCHSteps.typeCurrency(currency);
				}
				if (!exchangeRateType.isEmpty()) {
					onMTGLRecurringVCHSteps.chooseExchangeRateType(exchangeRateType);
				}
				if (!sourceDocumentType.isEmpty()) {
					onMTGLRecurringVCHSteps.typeSourceDocumentType(sourceDocumentType);
				}
				if (!sourceDocumentNo.isEmpty()) {
					onMTGLRecurringVCHSteps.typeSourceDocumentNo(sourceDocumentNo);
				}
				if (!recurringDay.isEmpty()) {
					onMTGLRecurringVCHSteps.chooseRecurringDay(recurringDay);
				}
				if (!recurringFrequency.isEmpty()) {
					onMTGLRecurringVCHSteps.chooseRecurringFrequency(recurringFrequency);
				}
				if (!recurrenceStartDate.isEmpty()) {
					onMTGLRecurringVCHSteps.typeRecurrenceStartDate(recurrenceStartDate);
				}
				if (!recurrenceEndDate.isEmpty()) {
					onMTGLRecurringVCHSteps.typeRecurrenceEndDate(recurrenceEndDate);
				}
				if (!nextRecurrenceDate.isEmpty()) {
					onMTGLRecurringVCHSteps.typeNextRecurrenceDate(nextRecurrenceDate);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

				onMTGLRecurringVCHSteps.setSegment(listSegment);
			}
		}
	}

	@When("^user delete MT GL Recurring VCH as \"([^\"]*)\"$")
	public void user_delete_MT_GL_Recurring_VCH_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "DelMTGLRecurringVCH";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRECURRING = "KEY RECURRING";
		String colRecurringVoucherCode = "Recurring Voucher Code";

		for (int rowMTGLRecurringVCH : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRECURRING, dataKey)
				.keySet()) {
			String recurringVoucherCode = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurringVoucherCode);

			onMTGLRecurringVCHSteps.clickOnNewBtn();

			if (!recurringVoucherCode.isEmpty()) {
				onMTGLRecurringVCHSteps.deleteValueBySearchBtn(recurringVoucherCode);
				isContinue = false;

			}
		}
	}

	@When("^user update MT GL Recurring VCH as \"([^\"]*)\"$")
	public void user_update_MT_GL_Recurring_VCH_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "MTGLRecurringVCH";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYRECURRING = "KEY RECURRING";
		String colRecurringVoucherCode = "Recurring Voucher Code";
		String colDescription = "Description";
		String colCurrency = "Currency";
		String colExchangeRateType = "Exchange Rate Type";
		String colSourceDocumentType = "Source Document Type";
		String colSourceDocumentNo = "Source Document No";
		String colRecurringDay = "Recurring Day";
		String colRecurringFrequency = "Recurring Frequency";
		String colRecurrenceStartDate = "Recurrence Start Date";
		String colRecurrenceEndDate = "Recurrence End Date";
		String colNextRecurrenceDate = "Next Recurrence Date";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowMTGLRecurringVCH : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRECURRING, dataKey)
				.keySet()) {
			String recurringVoucherCode = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurringVoucherCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colDescription);
			String currency = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colCurrency);
			String exchangeRateType = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colExchangeRateType);
			String sourceDocumentType = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colSourceDocumentType);
			String sourceDocumentNo = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSourceDocumentNo);
			String recurringDay = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colRecurringDay);
			String recurringFrequency = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurringFrequency);
			String recurrenceStartDate = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurrenceStartDate);
			String recurrenceEndDate = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colRecurrenceEndDate);
			String nextRecurrenceDate = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH,
					colNextRecurrenceDate);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH, colSegment4);

			onMTGLRecurringVCHSteps.clickOnNewBtn();

			if (!recurringVoucherCode.isEmpty()) {
				if (onMTGLRecurringVCHSteps.searchVCH(recurringVoucherCode)) {

					isContinue = true;

					if (!description.isEmpty()) {
						onMTGLRecurringVCHSteps.typeDescription(description);
					}
					if (!currency.isEmpty()) {
						onMTGLRecurringVCHSteps.typeCurrency(currency);
					}
					if (!exchangeRateType.isEmpty()) {
						onMTGLRecurringVCHSteps.chooseExchangeRateType(exchangeRateType);
					}
					if (!sourceDocumentType.isEmpty()) {
						onMTGLRecurringVCHSteps.typeSourceDocumentType(sourceDocumentType);
					}
					if (!sourceDocumentNo.isEmpty()) {
						onMTGLRecurringVCHSteps.typeSourceDocumentNo(sourceDocumentNo);
					}
					if (!recurringDay.isEmpty()) {
						onMTGLRecurringVCHSteps.chooseRecurringDay(recurringDay);
					}
					if (!recurringFrequency.isEmpty()) {
						onMTGLRecurringVCHSteps.chooseRecurringFrequency(recurringFrequency);
					}
					if (!recurrenceStartDate.isEmpty()) {
						onMTGLRecurringVCHSteps.typeRecurrenceStartDate(recurrenceStartDate);
					}
					if (!recurrenceEndDate.isEmpty()) {
						onMTGLRecurringVCHSteps.typeRecurrenceEndDate(recurrenceEndDate);
					}
					if (!nextRecurrenceDate.isEmpty()) {
						onMTGLRecurringVCHSteps.typeNextRecurrenceDate(nextRecurrenceDate);
					}

					List<String> listSegment = new ArrayList<>();
					listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

					onMTGLRecurringVCHSteps.setSegment(listSegment);
				}
			}
		}
	}

	@When("^MT GL recurring vch is add detail as \"([^\"]*)\"$")
	public void MT_GL_recurring_vch_is_add_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "MTGLRecurringVCH_Detail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYRECURRING = "KEY RECURRING";
			String colGLAccountCode = "GL Account Code";
			String colDescription = "Description";
			String colNatureDebit = "Nature Debit";
			String colNaturalCredit = "Natural Credit";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			int rowIndex = onMTGLRecurringVCHSteps.getRowDetailTb();

			for (int rowMTGLRecurringVCH_Detail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYRECURRING, dataKey).keySet()) {
				String gLAccountCode = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail,
						colGLAccountCode);
				String description = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail, colDescription);
				String natureDebit = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail, colNatureDebit);
				String naturalCredit = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail,
						colNaturalCredit);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowMTGLRecurringVCH_Detail, colSegment4);

				onMTGLRecurringVCHSteps.clickOnAddBtn();
				rowIndex++;

				if (!gLAccountCode.isEmpty()) {
					onMTGLRecurringVCHSteps.typeGLAccountCode(gLAccountCode, rowIndex);
				}
				if (!description.isEmpty()) {
					onMTGLRecurringVCHSteps.typeDetailDescription(description, rowIndex);
				}
				if (!natureDebit.isEmpty()) {
					onMTGLRecurringVCHSteps.typeNatureDebit(natureDebit, rowIndex);
				}
				if (!naturalCredit.isEmpty()) {
					onMTGLRecurringVCHSteps.typeNaturalCredit(naturalCredit, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));

				onMTGLRecurringVCHSteps.setSegment(listSegment, rowIndex);

			}
		}
	}

	@When("^user close MT GL Recurring VCH$")
	public void user_close_MT_GL_Recurring() {
		if (isContinue) {
			onMTGLRecurringVCHSteps.clickOnCloseBtn();
		}
	}

	@When("^user create MT GL Recurring VCH$")
	public void user_create_MT_GL_Recurring_VCH() {
		boolean isSegment = onMTGLRecurringVCHSteps.isSegment();

		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hDatasetColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colRecurringVoucherCode = hDatasetColName.get("Recurring Voucher Code");
		int colDescription = hDatasetColName.get("Description");
		int colCurrency = hDatasetColName.get("Currency");
		int colExchangeRateType = hDatasetColName.get("Exchange Rate Type");
		int colSourceDocumentType = hDatasetColName.get("Source Document Type");
		int colSourceDocumentNo = hDatasetColName.get("Source Document No");
		int colRecurringDay = hDatasetColName.get("Recurring Day");
		int colRecurringFrequency = hDatasetColName.get("Recurring Frequency");
		int colRecurrenceStartDate = hDatasetColName.get("Recurrence Start Date");
		int colRecurrenceEndDate = hDatasetColName.get("Recurrence End Date");
		int colNextRecurrenceDate = hDatasetColName.get("Next Recurrence Date");
		int colSegment1 = hDatasetColName.get("Segment 1");
		int colSegment2 = hDatasetColName.get("Segment 2");
		int colSegment3 = hDatasetColName.get("Segment 3");
		int colSegment4 = hDatasetColName.get("Segment 4");

		HashMap<String, Integer> hDetailColName = SessionData.getExcelColNameBySheetName(keyFileName, detailSheet);
		int colGLAccountCode = hDetailColName.get("GL Account Code");
		int colDetailDescription = hDetailColName.get("Description");
		int colNatureDebit = hDetailColName.get("Nature Debit");
		int colNaturalCredit = hDetailColName.get("Natural Credit");
		int colDetailSegment1 = hDetailColName.get("Segment 1");
		int colDetailSegment2 = hDetailColName.get("Segment 2");
		int colDetailSegment3 = hDetailColName.get("Segment 3");
		int colDetailSegment4 = hDetailColName.get("Segment 4");

		String recurringVoucherCode = "";
		String description = "";
		String currency = "";
		String exchangeRateType = "";
		String sourceDocumentType = "";
		String sourceDocumentNo = "";
		String recurringDay = "";
		String recurringFrequency = "";
		String recurrenceStartDate = "";
		String recurrenceEndDate = "";
		String nextRecurrenceDate = "";
		String segment1 = "";
		String segment2 = "";
		String segment3 = "";
		String segment4 = "";

		String gLAccountCode = "";
		String detailDescription = "";
		String natureDebit = "";
		String naturalCredit = "";
		String detailSegment1 = "";
		String detailSegment2 = "";
		String detailSegment3 = "";
		String detailSegment4 = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);
		for (Integer rowDataset : getDataset.keySet()) {
			recurringVoucherCode = getDataset.get(rowDataset).get(colRecurringVoucherCode);
			description = getDataset.get(rowDataset).get(colDescription);
			currency = getDataset.get(rowDataset).get(colCurrency);
			exchangeRateType = getDataset.get(rowDataset).get(colExchangeRateType);
			sourceDocumentType = getDataset.get(rowDataset).get(colSourceDocumentType);
			sourceDocumentNo = getDataset.get(rowDataset).get(colSourceDocumentNo);
			recurringDay = getDataset.get(rowDataset).get(colRecurringDay);
			recurringFrequency = getDataset.get(rowDataset).get(colRecurringFrequency);
			recurrenceStartDate = getDataset.get(rowDataset).get(colRecurrenceStartDate);
			recurrenceEndDate = getDataset.get(rowDataset).get(colRecurrenceEndDate);
			nextRecurrenceDate = getDataset.get(rowDataset).get(colNextRecurrenceDate);
			segment1 = getDataset.get(rowDataset).get(colSegment1);
			segment2 = getDataset.get(rowDataset).get(colSegment2);
			segment3 = getDataset.get(rowDataset).get(colSegment3);
			segment4 = getDataset.get(rowDataset).get(colSegment4);

			onMTGLRecurringVCHSteps.clickOnNewBtn();

			if (!recurringVoucherCode.isEmpty()) {
				onMTGLRecurringVCHSteps.typeRecurringVoucherCode(recurringVoucherCode);
			}
			if (!description.isEmpty()) {
				onMTGLRecurringVCHSteps.typeDescription(description);
			}
			if (!currency.isEmpty()) {
				onMTGLRecurringVCHSteps.typeCurrency(currency);
			}
			if (!exchangeRateType.isEmpty()) {
				onMTGLRecurringVCHSteps.chooseExchangeRateType(exchangeRateType);
			}
			if (!sourceDocumentType.isEmpty()) {
				onMTGLRecurringVCHSteps.typeSourceDocumentType(sourceDocumentType);
			}
			if (!sourceDocumentNo.isEmpty()) {
				onMTGLRecurringVCHSteps.typeSourceDocumentNo(sourceDocumentNo);
			}
			if (!recurringDay.isEmpty()) {
				onMTGLRecurringVCHSteps.chooseRecurringDay(recurringDay);
			}
			if (!recurringFrequency.isEmpty()) {
				onMTGLRecurringVCHSteps.chooseRecurringFrequency(recurringFrequency);
			}
			if (!recurrenceStartDate.isEmpty()) {
				onMTGLRecurringVCHSteps.typeRecurrenceStartDate(recurrenceStartDate);
			}
			if (!recurrenceEndDate.isEmpty()) {
				onMTGLRecurringVCHSteps.typeRecurrenceEndDate(recurrenceEndDate);
			}
			if (!nextRecurrenceDate.isEmpty()) {
				onMTGLRecurringVCHSteps.typeNextRecurrenceDate(nextRecurrenceDate);
			}

			if (isSegment) {
				if (!segment1.isEmpty()) {
					onMTGLRecurringVCHSteps.typeSegment1(segment1);
				}
				if (!segment2.isEmpty()) {
					onMTGLRecurringVCHSteps.typeSegment2(segment2);
				}
				if (!segment3.isEmpty()) {
					onMTGLRecurringVCHSteps.typeSegment3(segment3);
				}
				if (!segment4.isEmpty()) {
					onMTGLRecurringVCHSteps.typeSegment4(segment4);
				}
			}

			int rowIndex = 1;
			LinkedHashMap<Integer, List<String>> getDetail = SessionData.getExcelSheetDataNoHeader(keyFileName,
					detailSheet);
			for (Integer rowDetail : getDetail.keySet()) {
				gLAccountCode = getDetail.get(rowDetail).get(colGLAccountCode);
				detailDescription = getDetail.get(rowDetail).get(colDetailDescription);
				natureDebit = getDetail.get(rowDetail).get(colNatureDebit);
				naturalCredit = getDetail.get(rowDetail).get(colNaturalCredit);
				detailSegment1 = getDetail.get(rowDetail).get(colDetailSegment1);
				detailSegment2 = getDetail.get(rowDetail).get(colDetailSegment2);
				detailSegment3 = getDetail.get(rowDetail).get(colDetailSegment3);
				detailSegment4 = getDetail.get(rowDetail).get(colDetailSegment4);

				onMTGLRecurringVCHSteps.clickOnAddBtn();

				if (!gLAccountCode.isEmpty()) {
					onMTGLRecurringVCHSteps.typeGLAccountCode(gLAccountCode, rowIndex);
				}
				if (!detailDescription.isEmpty()) {
					onMTGLRecurringVCHSteps.typeDetailDescription(detailDescription, rowIndex);
				}
				if (!natureDebit.isEmpty()) {
					onMTGLRecurringVCHSteps.typeNatureDebit(natureDebit, rowIndex);
				}
				if (isSegment) {
					onMTGLRecurringVCHSteps.clickOnInfoSgmts(rowIndex);
					if (!naturalCredit.isEmpty()) {
						onMTGLRecurringVCHSteps.typeNaturalCredit(naturalCredit, rowIndex);
					}
					if (!detailSegment1.isEmpty()) {
						onMTGLRecurringVCHSteps.typeDetailSegment1(detailSegment1);
					}
					if (!detailSegment2.isEmpty()) {
						onMTGLRecurringVCHSteps.typeDetailSegment2(detailSegment2);
					}
					if (!detailSegment3.isEmpty()) {
						onMTGLRecurringVCHSteps.typeDetailSegment3(detailSegment3);
					}
					if (!detailSegment4.isEmpty()) {
						onMTGLRecurringVCHSteps.typeDetailSegment4(detailSegment4);
					}

					onMTGLRecurringVCHSteps.clickOnDone();
				}
				rowIndex++;
			}
		}
		onMTGLRecurringVCHSteps.clickOnCloseBtn();
	}
}
