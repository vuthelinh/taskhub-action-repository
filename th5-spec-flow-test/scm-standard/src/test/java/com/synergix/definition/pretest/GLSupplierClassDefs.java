package com.synergix.definition.pretest;

import java.util.List;
import com.synergix.globalsetup.party.supplier.steps.SupplierClassSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLSupplierClassDefs {
	@Steps
	SupplierClassSteps onSupplierClassSteps;

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

	}

	@Given("^user maintains supplier class as \"([^\"]*)\"$")
	public void user_maintains_supplier_class_as(String dataKey, List<List<String>> dataTable) {
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
				if(!onSupplierClassSteps.searchSupplierClassCode(supplierClassCode)){
					onSupplierClassSteps.addSupplierClass();
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

				if (company.toLowerCase().trim().equals("all")) {
					onSupplierClassSteps.checkAllCompany();
				} else
					onSupplierClassSteps.checkCompany(company);
			}
			onSupplierClassSteps.clickOnUpdateButton();
		}

	}
	
	@When("^user delete supplier class$")
	public void user_delete_supplier_class(List<List<String>> dataTable) {
		String dataTableKey = "DelSupClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colSupplierClassCode = "Supplier Class Code";
		for (int rowSupClass : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupClass, colSupplierClassCode);
			if (!supplierClassCode.isEmpty()) {
				onSupplierClassSteps.chooseDelSupClass(supplierClassCode);
			}
		}

	}
}
