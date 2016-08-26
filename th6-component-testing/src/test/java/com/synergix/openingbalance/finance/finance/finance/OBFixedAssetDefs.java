package com.synergix.openingbalance.finance.finance.finance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.steps.FixedAssetSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OBFixedAssetDefs {

	@Steps
	FixedAssetSteps onFixedAssetSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_OPENING_BALANCE + "FixedAsset.xls";
	String keyFileName = "FixedAsset";
	String fixedAssetSheet = "FixedAsset";
	String detailSheet = "Detail";
	String remarksSheet = "Remarks";

	boolean isContinue = false;

	@When("^user create fixed asset for opening balance as \"([^\"]*)\"$")
	public void user_create_fixed_asset_for_opening_balance_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "OBFA";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYOBFA = "KEY OBFA";
		String colVoucherNo = "Voucher No";
		String colFixedAssetCode = "Fixed Asset Code";
		String colTransactionDate = "Transaction Date";
		String colSupplier = "Supplier";
		String colSupplierInvoiceNo = "Supplier Invoice No";
		String colSupplierInvoiceDate = "Supplier Invoice Date";
		String colSubject = "Subject";
		String colDescription = "Description";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onFixedAssetSteps.switchToIFrame();

		for (int rowOBFA : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBFA, dataKey).keySet()) {
			String voucherNo = SessionData.getDataTbVal(dataTableKey, rowOBFA, colVoucherNo);
			String fixedAssetCode = SessionData.getDataTbVal(dataTableKey, rowOBFA, colFixedAssetCode);
			String transactionDate = SessionData.getDataTbVal(dataTableKey, rowOBFA, colTransactionDate);
			String supplier = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSupplier);
			String supplierInvoiceNo = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSupplierInvoiceNo);
			String supplierInvoiceDate = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSupplierInvoiceDate);
			String subject = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSubject);
			String description = SessionData.getDataTbVal(dataTableKey, rowOBFA, colDescription);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment4);

			if (!fixedAssetCode.isEmpty()) {

				onFixedAssetSteps.addNewFixedAsset();

				onFixedAssetSteps.typeFixedAssetCode(fixedAssetCode);

				isContinue = true;
				onFixedAssetSteps.moveToHeaderTab();

				if (transactionDate.isEmpty()) {
					transactionDate = onFixedAssetSteps.getDateToday();
				}
				onFixedAssetSteps.typeTransactionDate(transactionDate);
				if (!supplier.isEmpty()) {
					onFixedAssetSteps.typeSupplier(supplier);
				}
				if (!supplierInvoiceNo.isEmpty()) {
					onFixedAssetSteps.typeSupplierInvoiceNo(supplierInvoiceNo);
				}
				if (!supplierInvoiceDate.isEmpty()) {
					onFixedAssetSteps.typeSupplierInvoiceDate(supplierInvoiceDate);
				}
				if (!subject.isEmpty()) {
					onFixedAssetSteps.typeSubject(subject);
				}
				if (!description.isEmpty()) {
					onFixedAssetSteps.typeDescription(description);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onFixedAssetSteps.setSegment(listSegment);
			}
		}
		onFixedAssetSteps.switchOutDefaultIFrame();
	}

	@When("^user update fixed asset for opening balance as \"([^\"]*)\"$")
	public void user_update_fixed_asset_for_opening_balance_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "OBFAUpdate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYOBFA = "KEY OBFA";
		String colVoucherNo = "Voucher No.";
		String colFixedAssetCode = "Fixed Asset Code";
		String colTransactionDate = "Transaction Date";
		String colSupplier = "Supplier";
		String colSupplierInvoiceNo = "Supplier Invoice No";
		String colSupplierInvoiceDate = "Supplier Invoice Date";
		String colSubject = "Subject";
		String colDescription = "Description";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		onFixedAssetSteps.switchToIFrame();

		for (int rowOBFA : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBFA, dataKey).keySet()) {
			String voucherNo = SessionData.getDataTbVal(dataTableKey, rowOBFA, colVoucherNo);
			String fixedAssetCode = SessionData.getDataTbVal(dataTableKey, rowOBFA, colFixedAssetCode);
			String transactionDate = SessionData.getDataTbVal(dataTableKey, rowOBFA, colTransactionDate);
			String supplier = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSupplier);
			String supplierInvoiceNo = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSupplierInvoiceNo);
			String supplierInvoiceDate = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSupplierInvoiceDate);
			String subject = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSubject);
			String description = SessionData.getDataTbVal(dataTableKey, rowOBFA, colDescription);
			String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBFA, colSegment4);

			if (!fixedAssetCode.isEmpty()) {
				onFixedAssetSteps.update(voucherNo);

				onFixedAssetSteps.typeFixedAssetCode(fixedAssetCode);

				isContinue = true;
				onFixedAssetSteps.moveToHeaderTab();

				if (transactionDate.isEmpty()) {
					transactionDate = onFixedAssetSteps.getDateToday();
				}
				onFixedAssetSteps.typeTransactionDate(transactionDate);
				if (!supplier.isEmpty()) {
					onFixedAssetSteps.typeSupplier(supplier);
				}
				if (!supplierInvoiceNo.isEmpty()) {
					onFixedAssetSteps.typeSupplierInvoiceNo(supplierInvoiceNo);
				}
				if (!supplierInvoiceDate.isEmpty()) {
					onFixedAssetSteps.typeSupplierInvoiceDate(supplierInvoiceDate);
				}
				if (!subject.isEmpty()) {
					onFixedAssetSteps.typeSubject(subject);
				}
				if (!description.isEmpty()) {
					onFixedAssetSteps.typeDescription(description);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onFixedAssetSteps.setSegment(listSegment);
			}
		}
		onFixedAssetSteps.switchOutDefaultIFrame();
	}

	@When("^fixed asset for opening balance is added detail as \"([^\"]*)\"$")
	public void fixed_asset_for_opening_balance_is_added_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "OBFADetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYOBFA = "KEY OBFA";
			String colSerialNo = "Serial No";
			String colLocation = "Location";
			String colAssetCost = "Asset Cost";
			String colResidualValue = "Residual Value";
			String colLastDepreciationDate = "Last Depreciation Date";
			String colNoofDepreciation = "No of Depreciation";
			String colRemainingUsefulLife = "Remaining Useful Life";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			onFixedAssetSteps.switchToIFrame();

			for (int rowOBFADetail : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYOBFA, dataKey)
					.keySet()) {
				String serialNo = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colSerialNo);
				String location = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colLocation);
				String assetCost = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colAssetCost);
				String residualValue = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colResidualValue);
				String lastDepreciationDate = SessionData.getDataTbVal(dataTableKey, rowOBFADetail,
						colLastDepreciationDate);
				String noofDepreciation = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colNoofDepreciation);
				String remainingUsefulLife = SessionData.getDataTbVal(dataTableKey, rowOBFADetail,
						colRemainingUsefulLife);
				String segment1 = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey, rowOBFADetail, colSegment4);

				onFixedAssetSteps.moveToDetailTab();

				onFixedAssetSteps.addDetail();
				int rowIndex = onFixedAssetSteps.countRowTb();
				if (!serialNo.isEmpty()) {
					onFixedAssetSteps.typeSerialNo(serialNo, rowIndex);
				}
				if (!location.isEmpty()) {
					onFixedAssetSteps.typeLocation(location, rowIndex);
				}
				if (!assetCost.isEmpty()) {
					onFixedAssetSteps.typeAssetCost(assetCost, rowIndex);
				}
				if (!residualValue.isEmpty()) {
					onFixedAssetSteps.typeResidualValue(residualValue, rowIndex);
				}
				onFixedAssetSteps.clickInfoCumulativeDepnAmt(rowIndex);

				onFixedAssetSteps.typeLastDepreciationDate(lastDepreciationDate);

				if (!noofDepreciation.isEmpty()) {
					onFixedAssetSteps.typeNoofDepreciation(noofDepreciation);
				}
				if (!remainingUsefulLife.isEmpty()) {
					onFixedAssetSteps.typeRemainingUsefulLife(remainingUsefulLife);
				}

				onFixedAssetSteps.clickOnOKBtn();

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				onFixedAssetSteps.setSegment(listSegment, rowIndex);

				rowIndex++;
			}
			onFixedAssetSteps.switchOutDefaultIFrame();
		}
	}

	@When("fixed asset for opening balance is updated")
	public void fixed_asset_for_opening_balance_is_updated() {
		if (isContinue) {
			onFixedAssetSteps.switchToIFrame();
			onFixedAssetSteps.clickOnSubmit();
			onFixedAssetSteps.switchOutDefaultIFrame();
		}
	}

	@When("^user create new fixed asset for opening balance$")
	public void user_create_new_fixed_asset_for_opening_balance() {

		boolean isSegment = onFixedAssetSteps.isSegment();

		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hFixedAssetColName = SessionData.getExcelColNameBySheetName(keyFileName, fixedAssetSheet);
		int colkeyFA = hFixedAssetColName.get("Key");
		int colFixedAssetCode = hFixedAssetColName.get("Fixed Asset Code");
		int colTransactionDate = hFixedAssetColName.get("Transaction Date");
		int colSupplier = hFixedAssetColName.get("Supplier");
		int colSupplierInvoiceNo = hFixedAssetColName.get("Supplier Invoice No");
		int colSupplierInvoiceDate = hFixedAssetColName.get("Supplier Invoice Date");
		int colSubject = hFixedAssetColName.get("Subject");
		int colDescription = hFixedAssetColName.get("Description");
		int colSegment1 = hFixedAssetColName.get("Segment 1");
		int colSegment2 = hFixedAssetColName.get("Segment 2");
		int colSegment3 = hFixedAssetColName.get("Segment 3");
		int colSegment4 = hFixedAssetColName.get("Segment 4");

		HashMap<String, Integer> hRemarksColName = SessionData.getExcelColNameBySheetName(keyFileName, remarksSheet);
		int colInternalRemarksCode = hRemarksColName.get("Internal Remarks Code");
		int colExternalRemarksCode = hRemarksColName.get("External Remarks Code");
		int colInternalRemarks = hRemarksColName.get("Internal Remarks");
		int colExternalRemarks = hRemarksColName.get("External Remarks");

		HashMap<String, Integer> hDetailColName = SessionData.getExcelColNameBySheetName(keyFileName, detailSheet);
		int colkeyDetail = hDetailColName.get("Key");
		int colSerialNo = hDetailColName.get("Serial No");
		int colLocation = hDetailColName.get("Location");
		int colAssetCost = hDetailColName.get("Asset Cost");
		int colResidualValue = hDetailColName.get("Residual Value");
		int colLastDepreciationDate = hDetailColName.get("Last Depreciation Date");
		int colNoofDepreciation = hDetailColName.get("No of Depreciation");
		int colRemainingUsefulLife = hDetailColName.get("Remaining Useful Life");
		int colDetailSegment1 = hDetailColName.get("Segment 1");
		int colDetailSegment2 = hDetailColName.get("Segment 2");
		int colDetailSegment3 = hDetailColName.get("Segment 3");
		int colDetailSegment4 = hDetailColName.get("Segment 4");

		String keyFA = "";
		String fixedAssetCode = "";
		String transactionDate = "";
		String supplier = "";
		String supplierInvoiceNo = "";
		String supplierInvoiceDate = "";
		String subject = "";
		String description = "";
		String segment1 = "";
		String segment2 = "";
		String segment3 = "";
		String segment4 = "";

		String internalRemarksCode = "";
		String externalRemarksCode = "";
		String internalRemarks = "";
		String externalRemarks = "";

		String keyDetail = "";
		String serialNo = "";
		String location = "";
		String assetCost = "";
		String residualValue = "";
		String lastDepreciationDate = "";
		String noofDepreciation = "";
		String remainingUsefulLife = "";
		String detailSegment1 = "";
		String detailSegment2 = "";
		String detailSegment3 = "";
		String detailSegment4 = "";

		LinkedHashMap<Integer, List<String>> getFixedAsset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				fixedAssetSheet);

		onFixedAssetSteps.switchToIFrame();

		for (Integer rowFixedAsset : getFixedAsset.keySet()) {
			keyFA = getFixedAsset.get(rowFixedAsset).get(colkeyFA);
			fixedAssetCode = getFixedAsset.get(rowFixedAsset).get(colFixedAssetCode);
			transactionDate = getFixedAsset.get(rowFixedAsset).get(colTransactionDate);
			supplier = getFixedAsset.get(rowFixedAsset).get(colSupplier);
			supplierInvoiceNo = getFixedAsset.get(rowFixedAsset).get(colSupplierInvoiceNo);
			supplierInvoiceDate = getFixedAsset.get(rowFixedAsset).get(colSupplierInvoiceDate);
			subject = getFixedAsset.get(rowFixedAsset).get(colSubject);
			description = getFixedAsset.get(rowFixedAsset).get(colDescription);
			segment1 = getFixedAsset.get(rowFixedAsset).get(colSegment1);
			segment2 = getFixedAsset.get(rowFixedAsset).get(colSegment2);
			segment3 = getFixedAsset.get(rowFixedAsset).get(colSegment3);
			segment4 = getFixedAsset.get(rowFixedAsset).get(colSegment4);

			onFixedAssetSteps.addNewFixedAsset();

			if (!fixedAssetCode.isEmpty()) {
				onFixedAssetSteps.typeFixedAssetCode(fixedAssetCode);
			}
			// onFixedAssetSteps.update("FA000001OB");

			onFixedAssetSteps.moveToHeaderTab();
			if (!transactionDate.isEmpty()) {
				onFixedAssetSteps.typeTransactionDate(transactionDate);
			}
			if (!supplier.isEmpty()) {
				onFixedAssetSteps.typeSupplier(supplier);
			}
			if (!supplierInvoiceNo.isEmpty()) {
				onFixedAssetSteps.typeSupplierInvoiceNo(supplierInvoiceNo);
			}
			if (!supplierInvoiceDate.isEmpty()) {
				onFixedAssetSteps.typeSupplierInvoiceDate(supplierInvoiceDate);
			}
			if (!subject.isEmpty()) {
				onFixedAssetSteps.typeSubject(subject);
			}
			if (!description.isEmpty()) {
				onFixedAssetSteps.typeDescription(description);
			}
			if (isSegment) {
				if (!segment1.isEmpty()) {
					onFixedAssetSteps.typeSegment1(segment1);
				}
				if (!segment2.isEmpty()) {
					onFixedAssetSteps.typeSegment2(segment2);
				}
				if (!segment3.isEmpty()) {
					onFixedAssetSteps.typeSegment3(segment3);
				}
				if (!segment4.isEmpty()) {
					onFixedAssetSteps.typeSegment4(segment4);
				}
			}

			onFixedAssetSteps.moveToRemarksTab();
			LinkedHashMap<Integer, List<String>> getRemarks = SessionData.getExcelSheetDataNoHeader(keyFileName,
					remarksSheet);

			for (Integer rowRemarks : getRemarks.keySet()) {
				internalRemarksCode = getRemarks.get(rowRemarks).get(colInternalRemarksCode);
				externalRemarksCode = getRemarks.get(rowRemarks).get(colExternalRemarksCode);
				internalRemarks = getRemarks.get(rowRemarks).get(colInternalRemarks);
				externalRemarks = getRemarks.get(rowRemarks).get(colExternalRemarks);

				if (!internalRemarksCode.isEmpty()) {
					onFixedAssetSteps.typeInternalRemarksCode(internalRemarksCode);
				}
				if (!externalRemarksCode.isEmpty()) {
					onFixedAssetSteps.typeExternalRemarksCode(externalRemarksCode);
				}
				if (!internalRemarks.isEmpty()) {
					onFixedAssetSteps.typeInternalRemarks(internalRemarks);
				}
				if (!externalRemarks.isEmpty()) {
					onFixedAssetSteps.typeExternalRemarks(externalRemarks);
				}
			}

			onFixedAssetSteps.moveToDetailTab();
			LinkedHashMap<Integer, List<String>> getDetail = SessionData.getExcelSheetDataNoHeader(keyFileName,
					detailSheet);
			int rowIndex = 1;
			for (Integer rowDetail : getDetail.keySet()) {
				keyDetail = getDetail.get(rowDetail).get(colkeyDetail);
				serialNo = getDetail.get(rowDetail).get(colSerialNo);
				location = getDetail.get(rowDetail).get(colLocation);
				assetCost = getDetail.get(rowDetail).get(colAssetCost);
				residualValue = getDetail.get(rowDetail).get(colResidualValue);
				lastDepreciationDate = getDetail.get(rowDetail).get(colLastDepreciationDate);
				noofDepreciation = getDetail.get(rowDetail).get(colNoofDepreciation);
				remainingUsefulLife = getDetail.get(rowDetail).get(colRemainingUsefulLife);
				detailSegment1 = getDetail.get(rowDetail).get(colDetailSegment1);
				detailSegment2 = getDetail.get(rowDetail).get(colDetailSegment2);
				detailSegment3 = getDetail.get(rowDetail).get(colDetailSegment3);
				detailSegment4 = getDetail.get(rowDetail).get(colDetailSegment4);

				if (keyDetail.equals(keyFA)) {
					onFixedAssetSteps.addDetail();
					if (!serialNo.isEmpty()) {
						onFixedAssetSteps.typeSerialNo(serialNo, rowIndex);
					}
					if (!location.isEmpty()) {
						onFixedAssetSteps.typeLocation(location, rowIndex);
					}
					if (!assetCost.isEmpty()) {
						onFixedAssetSteps.typeAssetCost(assetCost, rowIndex);
					}
					if (!residualValue.isEmpty()) {
						onFixedAssetSteps.typeResidualValue(residualValue, rowIndex);
					}
					onFixedAssetSteps.clickInfoCumulativeDepnAmt(rowIndex);

					onFixedAssetSteps.typeLastDepreciationDate(lastDepreciationDate);

					if (!noofDepreciation.isEmpty()) {
						onFixedAssetSteps.typeNoofDepreciation(noofDepreciation);
					}
					if (!remainingUsefulLife.isEmpty()) {
						onFixedAssetSteps.typeRemainingUsefulLife(remainingUsefulLife);
					}

					onFixedAssetSteps.clickOnOKBtn();
					if (isSegment) {
						onFixedAssetSteps.clickInfoSegmt(rowIndex);
						if (!detailSegment1.isEmpty()) {
							onFixedAssetSteps.typeDetailSegment1(detailSegment1);
						}
						if (!detailSegment2.isEmpty()) {
							onFixedAssetSteps.typeDetailSegment2(detailSegment2);
						}
						if (!detailSegment3.isEmpty()) {
							onFixedAssetSteps.typeDetailSegment3(detailSegment3);
						}
						if (!detailSegment4.isEmpty()) {
							onFixedAssetSteps.typeDetailSegment4(detailSegment4);
						}
						onFixedAssetSteps.clickOnDoneBtn();
					}
					rowIndex++;
				}
			}

			onFixedAssetSteps.clickOnSubmit();
		}
		onFixedAssetSteps.switchOutDefaultIFrame();
	}
}
