package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CustomerClassPage extends TH5PageObject {

	public CustomerClassPage(WebDriver driver) {
		super(driver);
	}

	public void typeCustomerClassCode(String customerClassCode) {
		enterInputFieldCodeWithLabel("Customer Class Code", customerClassCode);
	}

	public void typeDescription(String description) {
		enterInputFieldWithLabel("Description", description);
	}

	public void typeReceivableGLAN(String receivableGLAN) {
		enterInputFieldCodeWithLabel("Receivable GLAN", receivableGLAN);
	}

	public void typeRealizedGLAN(String realizedGLAN) {
		enterInputFieldCodeWithLabel("Realized GLAN", realizedGLAN);
	}

	public void typeUnrealizedGLAN(String unrealizedGLAN) {
		enterInputFieldCodeWithLabel("Unrealized GLAN", unrealizedGLAN);
	}

	public void typeCorporateClearingGLAN(String corporateClearingGLAN) {
		enterInputFieldCodeWithLabel("Corporate Clearing GLAN", corporateClearingGLAN);
	}

	public void typeAmtRefundabletoCustomer(String amtRefundabletoCustomer) {
		enterInputFieldCodeWithLabel("Amt Refundable to Customer", amtRefundabletoCustomer);
	}

	public void typeReceivableMedisaveGLAN(String receivableMedisaveGLAN) {
		enterInputFieldCodeWithLabel("Receivable Medisave GLAN", receivableMedisaveGLAN);
	}

	public void typeMedisaveClearingGLAN(String medisaveClearingGLAN) {
		enterInputFieldCodeWithLabel("Medisave Clearing GLAN", medisaveClearingGLAN);
	}

	public void typeAmtBillabletoCustomer(String amtBillabletoCustomer) {
		enterInputFieldCodeWithLabel("Amt Billable to Customer", amtBillabletoCustomer);
	}

	public void typeRecognizedAccruedCost(String recognizedAccruedCost) {
		enterInputFieldCodeWithLabel("Recognized Accrued Cost", recognizedAccruedCost);
	}

	public void typeRecognizedAccruedRevenue(String recognizedAccruedRevenue) {
		enterInputFieldCodeWithLabel("Recognized Accrued Revenue", recognizedAccruedRevenue);
	}

	public void typeRentalRevenueGLAN(String rentalRevenueGLAN) {
		enterInputFieldCodeWithLabel("Rental Revenue GLAN", rentalRevenueGLAN);
	}

	public void typeSalesGLAN(String salesGLAN) {
		enterInputFieldCodeWithLabel("Sales GLAN", salesGLAN);
	}

	public void typeCostsofSalesGLAN(String costsofSalesGLAN) {
		enterInputFieldCodeWithLabel("Costs of Sales GLAN", costsofSalesGLAN);
	}

	public void typeSalesReturnGLAN(String salesReturnGLAN) {
		enterInputFieldCodeWithLabel("Sales Return GLAN", salesReturnGLAN);
	}

	public void typeCostsofSalesReturnGLAN(String costsofSalesReturnGLAN) {
		enterInputFieldCodeWithLabel("Costs of Sales Return GLAN", costsofSalesReturnGLAN);
	}

	public void typeCostsofSalesRetClearingGLAN(String costsofSalesRetClearingGLAN) {
		enterInputFieldCodeWithLabel("Costs of Sales Ret Clearing GLAN", costsofSalesRetClearingGLAN);
	}

	public void typeDeliveryClearingGLAN(String deliveryClearingGLAN) {
		enterInputFieldCodeWithLabel("Delivery Clearing GLAN", deliveryClearingGLAN);
	}

	public void typeInventoryWithCustomerGLAN(String inventoryWithCustomerGLAN) {
		enterInputFieldCodeWithLabel("Inventory With Customer GLAN", inventoryWithCustomerGLAN);
	}

	public void typeCostofServicingGLAN(String costofServicingGLAN) {
		enterInputFieldCodeWithLabel("Cost of Servicing GLAN", costofServicingGLAN);
	}

	public void typeUnearnedRevenueGLAN(String unearnedRevenueGLAN) {
		enterInputFieldCodeWithLabel("Unearned Revenue GLAN", unearnedRevenueGLAN);
	}

	public void typeWorkinProgressGLAN(String workinProgressGLAN) {
		enterInputFieldCodeWithLabel("Work in Progress GLAN", workinProgressGLAN);
	}

	public void typeRetentionGLAN(String retentionGLAN) {
		enterInputFieldCodeWithLabel("Retention GLAN", retentionGLAN);
	}

	public void typeProjectRevenueGLAN(String projectRevenueGLAN) {
		enterInputFieldCodeWithLabel("Project Revenue GLAN", projectRevenueGLAN);
	}

	public void typeProjectCostGLAN(String projectCostGLAN) {
		enterInputFieldCodeWithLabel("Project Cost GLAN", projectCostGLAN);
	}

	public void typeRecognitionExchGainLossGLAN(String recognitionExchGainLossGLAN) {
		enterInputFieldCodeWithLabel("Recognition Exch Gain/Loss GLAN (TH2)", recognitionExchGainLossGLAN);
	}

	public void typeCostAccrualGLAN(String costAccrualGLAN) {
		enterInputFieldCodeWithLabel("Cost Accrual GLAN", costAccrualGLAN);
	}

	public void typeAccruedIncomeGLAN(String accruedIncomeGLAN) {
		enterInputFieldCodeWithLabel("Accrued Income GLAN", accruedIncomeGLAN);
	}

	public void typeAttributableProfit(String attributableProfit) {
		enterInputFieldCodeWithLabel("Attributable Profit", attributableProfit);
	}

	public void typeClaimDebtor(String claimDebtor) {
		enterInputFieldCodeWithLabel("Claim Debtor", claimDebtor);
	}

	public void typeCertificationDebtor(String certificationDebtor) {
		enterInputFieldCodeWithLabel("Certification Debtor", certificationDebtor);
	}

	public void typeOtherPayable(String otherPayable) {
		enterInputFieldCodeWithLabel("Other Payable", otherPayable);
	}

	public void typeRetentionClearing(String retentionClearing) {
		enterInputFieldCodeWithLabel("Retention Clearing", retentionClearing);
	}

	public void typeMaterialonSite(String materialonSite) {
		enterInputFieldCodeWithLabel("Material on Site", materialonSite);
	}

	public void typeRetentionMaterialonSite(String retentionMaterialonSite) {
		enterInputFieldCodeWithLabel("Retention Material on Site", retentionMaterialonSite);
	}

	public void typeDownpaymentUnearnedGLAN(String downpaymentUnearnedGLAN) {
		enterInputFieldCodeWithLabel("Downpayment Unearned GLAN", downpaymentUnearnedGLAN);
	}

	public void typeDownpaymentExchGainLossGLAN(String downpaymentExchGainLossGLAN) {
		enterInputFieldCodeWithLabel("Downpayment Exch Gain/Loss GLAN", downpaymentExchGainLossGLAN);
	}

	public void onClickNewButton() {
		findBtn("New").waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void onClickUpdateButton() {
		findBtn("Update").waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

	public void typeRevenueAccrualGLAN(String revenueAccrualGLAN) {
		enterInputFieldCodeWithLabel("Revenue Accrual GLAN", revenueAccrualGLAN);
	}

	public void typeContractUnearnedRevenueGLAN(String contractUnearnedRevenueGLAN) {
		enterInputFieldCodeWithLabel("Contract Unearned Revenue GLAN", contractUnearnedRevenueGLAN);
	}

	public void typeContractRevenueGLAN(String contractRevenueGLAN) {
		enterInputFieldCodeWithLabel("Contract Revenue GLAN", contractRevenueGLAN);
	}

}
