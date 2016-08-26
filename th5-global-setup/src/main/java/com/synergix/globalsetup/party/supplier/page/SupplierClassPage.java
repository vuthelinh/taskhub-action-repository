package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SupplierClassPage extends TH5PageObject {

	public final String SUPPLIER_CLASS_CODE = "Supplier Class Code";

	public SupplierClassPage(WebDriver driver) {
		super(driver);
	}

	public void typeSupplierClassCode(String supplierClassCode) {
		enterInputFieldCodeWithLabel(SUPPLIER_CLASS_CODE, supplierClassCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typePayableGLAN(String payableGLAN) {
		enterInputFieldCodeWithLabel("Payable GLAN", payableGLAN);
	}

	public void typeRealizedGLAN(String realizedGLAN) {
		enterInputFieldCodeWithLabel("Realized GLAN", realizedGLAN);
	}

	public void typeUnrealizedGLAN(String unrealizedGLAN) {
		enterInputFieldCodeWithLabel("Unrealized GLAN", unrealizedGLAN);
	}

	public void typeGoodsReceiptClearingGLAN(String goodsReceiptClearingGLAN) {
		enterInputFieldCodeWithLabel("Goods Receipt Clearing GLAN", goodsReceiptClearingGLAN);
	}

	public void typePurchaseVarianceGLAN(String purchaseVarianceGLAN) {
		enterInputFieldCodeWithLabel("Purchase Variance GLAN", purchaseVarianceGLAN);
	}

	public void typeAdditionalCost(String additionalCost) {
		enterInputFieldCodeWithLabel("Additional Cost", additionalCost);
	}

	public void typeAdditionalCostVariance(String additionalCostVariance) {
		enterInputFieldCodeWithLabel("Additional Cost Variance", additionalCostVariance);
	}

	public void typeAdditionalCostExchange(String additionalCostExchange) {
		enterInputFieldCodeWithLabel("Additional Cost Exchange", additionalCostExchange);
	}

	public void typePurchaseReturnVariance(String purchaseReturnVariance) {
		enterInputFieldCodeWithLabel("Purchase Return Variance", purchaseReturnVariance);
	}

	public void typePurchaseVarianceExchDiff(String purchaseVarianceExchDiff) {
		enterInputFieldCodeWithLabel("Purchase Variance Exch Diff", purchaseVarianceExchDiff);
	}

	public void typeSalesTaxExchDifference(String salesTaxExchDifference) {
		enterInputFieldCodeWithLabel("Sales Tax Exch Difference", salesTaxExchDifference);
	}

	public void typeRetentionGLAN(String retentionGLAN) {
		enterInputFieldCodeWithLabel("Retention GLAN", retentionGLAN);
	}

	public void typeOtherIncomeGLAN(String otherIncomeGLAN) {
		enterInputFieldCodeWithLabel("Other Income GLAN", otherIncomeGLAN);
	}

	public void clickOnNewButton() {
		findBtn("New").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void clickOnUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

}
