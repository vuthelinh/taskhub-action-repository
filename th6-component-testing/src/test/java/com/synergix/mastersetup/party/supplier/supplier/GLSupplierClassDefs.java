package com.synergix.mastersetup.party.supplier.supplier;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.party.supplier.steps.SupplierClassSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLSupplierClassDefs {
	@Steps
	SupplierClassSteps onSupplierClassSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_PARTY + "SupplierClass.xls";
	String keyFileName = "SupplierClass";
	String DATASET_SHEET = "Supplier Class";
	String COMPANY_SHEET = "Company";

	boolean isContinue = false;

	@When("^user create supplier class as \"([^\"]*)\"$")
	public void user_create_supplier_class_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "SupClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSUPCLASS = "KEY SUP CLASS";
		String colSupplierClassCode = "Supplier Class Code";
		String colDescription = "Description";
		String colPayableGLAN = "Payable GLAN";
		String colRealizedGLAN = "Realized GLAN";
		String colUnrealizedGLAN = "Unrealized GLAN";
		String colGoodsReceiptClearingGLAN = "Goods Receipt Clearing GLAN";
		String colPurchaseVarianceGLAN = "Purchase Variance GLAN";
		String colAdditionalCost = "Additional Cost";
		String colAdditionalCostVariance = "Additional Cost Variance";
		String colAdditionalCostExchange = "Additional Cost Exchange";
		String colPurchaseReturnVariance = "Purchase Return Variance";
		String colPurchaseVarianceExchDiff = "Purchase Variance Exch Diff";
		String colSalesTaxExchDifference = "Sales Tax Exch Difference";
		String colRetentionGLAN = "Retention GLAN";
		String colOtherIncomeGLAN = "Other Income GLAN";
		String colCompany = "Company";

		onSupplierClassSteps.switchToIFrame();

		for (int rowSupClass : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSUPCLASS, dataKey)
				.keySet()) {
			String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupClass, colSupplierClassCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowSupClass, colDescription);
			String payableGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass, colPayableGLAN);
			String realizedGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass, colRealizedGLAN);
			String unrealizedGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass, colUnrealizedGLAN);
			String goodsReceiptClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colGoodsReceiptClearingGLAN);
			String purchaseVarianceGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass, colPurchaseVarianceGLAN);
			String additionalCost = SessionData.getDataTbVal(dataTableKey, rowSupClass, colAdditionalCost);
			String additionalCostVariance = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colAdditionalCostVariance);
			String additionalCostExchange = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colAdditionalCostExchange);
			String purchaseReturnVariance = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colPurchaseReturnVariance);
			String purchaseVarianceExchDiff = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colPurchaseVarianceExchDiff);
			String salesTaxExchDifference = SessionData.getDataTbVal(dataTableKey, rowSupClass,
					colSalesTaxExchDifference);
			String retentionGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass, colRetentionGLAN);
			String otherIncomeGLAN = SessionData.getDataTbVal(dataTableKey, rowSupClass, colOtherIncomeGLAN);
			String company = SessionData.getDataTbVal(dataTableKey, rowSupClass, colCompany);

			if (!supplierClassCode.isEmpty()) {
				onSupplierClassSteps.addSupplierClass();

				onSupplierClassSteps.typeSupplierClassCode(supplierClassCode);

				if (!description.isEmpty()) {
					onSupplierClassSteps.typeDescription(description);
				}
				if (!payableGLAN.isEmpty()) {
					onSupplierClassSteps.typePayableGLAN(payableGLAN);
				}
				if (!realizedGLAN.isEmpty()) {
					onSupplierClassSteps.typeRealizedGLAN(realizedGLAN);
				}
				if (!unrealizedGLAN.isEmpty()) {
					onSupplierClassSteps.typeUnrealizedGLAN(unrealizedGLAN);
				}
				if (!goodsReceiptClearingGLAN.isEmpty()) {
					onSupplierClassSteps.typeGoodsReceiptClearingGLAN(goodsReceiptClearingGLAN);
				}
				if (!purchaseVarianceGLAN.isEmpty()) {
					onSupplierClassSteps.typePurchaseVarianceGLAN(purchaseVarianceGLAN);
				}
				if (!additionalCost.isEmpty()) {
					onSupplierClassSteps.typeAdditionalCost(additionalCost);
				}
				if (!additionalCostVariance.isEmpty()) {
					onSupplierClassSteps.typeAdditionalCostVariance(additionalCostVariance);
				}
				if (!additionalCostExchange.isEmpty()) {
					onSupplierClassSteps.typeAdditionalCostExchange(additionalCostExchange);
				}
				if (!purchaseReturnVariance.isEmpty()) {
					onSupplierClassSteps.typePurchaseReturnVariance(purchaseReturnVariance);
				}
				if (!purchaseVarianceExchDiff.isEmpty()) {
					onSupplierClassSteps.typePurchaseVarianceExchDiff(purchaseVarianceExchDiff);
				}
				if (!salesTaxExchDifference.isEmpty()) {
					onSupplierClassSteps.typeSalesTaxExchDifference(salesTaxExchDifference);
				}
				if (!retentionGLAN.isEmpty()) {
					onSupplierClassSteps.typeRetentionGLAN(retentionGLAN);
				}
				if (!otherIncomeGLAN.isEmpty()) {
					onSupplierClassSteps.typeOtherIncomeGLAN(otherIncomeGLAN);
				}

				onSupplierClassSteps.moveToCompanyTab();

				if (company.toLowerCase().trim().equals("all")) {
					onSupplierClassSteps.checkAllCompany();
				} else
					onSupplierClassSteps.checkCompany(company);
			}
			onSupplierClassSteps.clickOnUpdateButton();
		}
		onSupplierClassSteps.switchOutDefaultIFrame();
	}

	@When("^user delete supplier class$")
	public void user_delete_supplier_class(List<List<String>> dataTable) {
		String dataTableKey = "DelSupClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colSupplierClassCode = "Supplier Class Code";

		onSupplierClassSteps.switchToIFrame();

		for (int rowSupClass : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupClass, colSupplierClassCode);
			if (!supplierClassCode.isEmpty()) {
				onSupplierClassSteps.chooseDelSupClass(supplierClassCode);
			}
		}
		onSupplierClassSteps.switchOutDefaultIFrame();
	}

	@When("^user create new supplier class$")
	public void user_create_new_supplier_class() {
		SessionData.addExcelData(keyFileName, filePath);

		HashMap<String, Integer> hClassColName = SessionData.getExcelColNameBySheetName(keyFileName, DATASET_SHEET);

		int colSupplierClassCode = hClassColName.get("Supplier Class Code");
		int colDescription = hClassColName.get("Description");
		int colPayableGLAN = hClassColName.get("Payable GLAN");
		int colRealizedGLAN = hClassColName.get("Realized GLAN");
		int colUnrealizedGLAN = hClassColName.get("Unrealized GLAN");
		int colGoodsReceiptClearingGLAN = hClassColName.get("Goods Receipt Clearing GLAN");
		int colPurchaseVarianceGLAN = hClassColName.get("Purchase Variance GLAN");
		int colAdditionalCost = hClassColName.get("Additional Cost");
		int colAdditionalCostVariance = hClassColName.get("Additional Cost Variance");
		int colAdditionalCostExchange = hClassColName.get("Additional Cost Exchange");
		int colPurchaseReturnVariance = hClassColName.get("Purchase Return Variance");
		int colPurchaseVarianceExchDiff = hClassColName.get("Purchase Variance Exch Diff");
		int colSalesTaxExchDifference = hClassColName.get("Sales Tax Exch Difference");
		int colRetentionGLAN = hClassColName.get("Retention GLAN");
		int colOtherIncomeGLAN = hClassColName.get("Other Income GLAN");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, COMPANY_SHEET);
		int colsupplierClass = hCompanyColName.get("Supplier Class");
		int colCompany = hCompanyColName.get("Company");

		String supplierClassCode = "";
		String description = "";
		String payableGLAN = "";
		String realizedGLAN = "";
		String unrealizedGLAN = "";
		String goodsReceiptClearingGLAN = "";
		String purchaseVarianceGLAN = "";
		String additionalCost = "";
		String additionalCostVariance = "";
		String additionalCostExchange = "";
		String purchaseReturnVariance = "";
		String purchaseVarianceExchDiff = "";
		String salesTaxExchDifference = "";
		String retentionGLAN = "";
		String otherIncomeGLAN = "";

		String supplierClass = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				DATASET_SHEET);

		onSupplierClassSteps.switchToIFrame();

		for (Integer row : getDataset.keySet()) {
			supplierClassCode = getDataset.get(row).get(colSupplierClassCode);
			description = getDataset.get(row).get(colDescription);
			payableGLAN = getDataset.get(row).get(colPayableGLAN);
			realizedGLAN = getDataset.get(row).get(colRealizedGLAN);
			unrealizedGLAN = getDataset.get(row).get(colUnrealizedGLAN);
			goodsReceiptClearingGLAN = getDataset.get(row).get(colGoodsReceiptClearingGLAN);
			purchaseVarianceGLAN = getDataset.get(row).get(colPurchaseVarianceGLAN);
			additionalCost = getDataset.get(row).get(colAdditionalCost);
			additionalCostVariance = getDataset.get(row).get(colAdditionalCostVariance);
			additionalCostExchange = getDataset.get(row).get(colAdditionalCostExchange);
			purchaseReturnVariance = getDataset.get(row).get(colPurchaseReturnVariance);
			purchaseVarianceExchDiff = getDataset.get(row).get(colPurchaseVarianceExchDiff);
			salesTaxExchDifference = getDataset.get(row).get(colSalesTaxExchDifference);
			retentionGLAN = getDataset.get(row).get(colRetentionGLAN);
			otherIncomeGLAN = getDataset.get(row).get(colOtherIncomeGLAN);

			onSupplierClassSteps.addSupplierClass();

			if (!supplierClassCode.isEmpty()) {
				onSupplierClassSteps.typeSupplierClassCode(supplierClassCode);
			}
			if (!description.isEmpty()) {
				onSupplierClassSteps.typeDescription(description);
			}
			if (!payableGLAN.isEmpty()) {
				onSupplierClassSteps.typePayableGLAN(payableGLAN);
			}
			if (!realizedGLAN.isEmpty()) {
				onSupplierClassSteps.typeRealizedGLAN(realizedGLAN);
			}
			if (!unrealizedGLAN.isEmpty()) {
				onSupplierClassSteps.typeUnrealizedGLAN(unrealizedGLAN);
			}
			if (!goodsReceiptClearingGLAN.isEmpty()) {
				onSupplierClassSteps.typeGoodsReceiptClearingGLAN(goodsReceiptClearingGLAN);
			}
			if (!purchaseVarianceGLAN.isEmpty()) {
				onSupplierClassSteps.typePurchaseVarianceGLAN(purchaseVarianceGLAN);
			}
			if (!additionalCost.isEmpty()) {
				onSupplierClassSteps.typeAdditionalCost(additionalCost);
			}
			if (!additionalCostVariance.isEmpty()) {
				onSupplierClassSteps.typeAdditionalCostVariance(additionalCostVariance);
			}
			if (!additionalCostExchange.isEmpty()) {
				onSupplierClassSteps.typeAdditionalCostExchange(additionalCostExchange);
			}
			if (!purchaseReturnVariance.isEmpty()) {
				onSupplierClassSteps.typePurchaseReturnVariance(purchaseReturnVariance);
			}
			if (!purchaseVarianceExchDiff.isEmpty()) {
				onSupplierClassSteps.typePurchaseVarianceExchDiff(purchaseVarianceExchDiff);
			}
			if (!salesTaxExchDifference.isEmpty()) {
				onSupplierClassSteps.typeSalesTaxExchDifference(salesTaxExchDifference);
			}
			if (!retentionGLAN.isEmpty()) {
				onSupplierClassSteps.typeRetentionGLAN(retentionGLAN);
			}
			if (!otherIncomeGLAN.isEmpty()) {
				onSupplierClassSteps.typeOtherIncomeGLAN(otherIncomeGLAN);
			}

			onSupplierClassSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					COMPANY_SHEET);
			for (Integer rowCompany : getCompany.keySet()) {
				supplierClass = getCompany.get(rowCompany).get(colsupplierClass);
				if (supplierClass.equals(supplierClassCode)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.toLowerCase().trim().equals("all")) {
						onSupplierClassSteps.checkAllCompany();
						break;
					} else
						onSupplierClassSteps.checkCompany(company);
				}
			}
			onSupplierClassSteps.clickOnUpdateButton();
		}
		onSupplierClassSteps.switchOutDefaultIFrame();
	}
}
