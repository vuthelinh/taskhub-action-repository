package com.synergix.mastersetup.party.customer.customer;

import java.util.List;

import com.synergix.globalsetup.party.customer.steps.CustomerClassSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLCustomerClassDefs {

	@Steps
	CustomerClassSteps onCustomerClassSteps;

	@When("^user create customer class as \"([^\"]*)\"$")
	public void user_create_customer_class_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "CusClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYCUSCLASS = "KEY CUS CLASS";
		String colCustomerClassCode = "Customer Class Code";
		String colDescription = "Description";
		String colReceivableGLAN = "Receivable GLAN";
		String colRealizedGLAN = "Realized GLAN";
		String colUnrealizedGLAN = "Unrealized GLAN";
		String colCorporateClearingGLAN = "Corporate Clearing GLAN";
		String colAmtRefundabletoCustomer = "Amt Refundable to Customer";
		String colReceivableMedisaveGLAN = "Receivable Medisave GLAN";
		String colMedisaveClearingGLAN = "Medisave Clearing GLAN";
		String colAmtBillabletoCustomer = "Amt Billable to Customer";
		String colRecognizedAccruedCost = "Recognized Accrued Cost";
		String colRecognizedAccruedRevenue = "Recognized Accrued Revenue";
		String colRentalRevenueGLAN = "Rental Revenue GLAN";
		String colSalesGLAN = "Sales GLAN";
		String colCostsofSalesGLAN = "Costs of Sales GLAN";
		String colSalesReturnGLAN = "Sales Return GLAN";
		String colCostsofSalesReturnGLAN = "Costs of Sales Return GLAN";
		String colCostsofSalesRetClearingGLAN = "Costs of Sales Ret Clearing GLAN";
		String colDeliveryClearingGLAN = "Delivery Clearing GLAN";
		String colInventoryWithCustomerGLAN = "Inventory With Customer GLAN";
		String colCostofServicingGLAN = "Cost of Servicing GLAN";
		String colUnearnedRevenueGLAN = "Unearned Revenue GLAN";
		String colWorkinProgressGLAN = "Work in Progress GLAN";
		String colRetentionGLAN = "Retention GLAN";
		String colProjectRevenueGLAN = "Project Revenue GLAN";
		String colProjectCostGLAN = "Project Cost GLAN";
		String colRecognitionExchGainLossGLAN = "Recognition Exch Gain Loss GLAN";
		String colCostAccrualGLAN = "Cost Accrual GLAN";
		String colRevenueAccrualGLAN = "Revenue Accrual GLAN";
		String colAccruedIncomeGLAN = "Accrued Income GLAN";
		String colAttributableProfit = "Attributable Profit";
		String colClaimDebtor = "Claim Debtor";
		String colCertificationDebtor = "Certification Debtor";
		String colOtherPayable = "Other Payable";
		String colRetentionClearing = "Retention Clearing";
		String colMaterialonSite = "Material on Site";
		String colRetentionMaterialonSite = "Retention Material on Site";
		String colDownpaymentUnearnedGLAN = "Downpayment Unearned GLAN";
		String colDownpaymentExchGainLossGLAN = "Downpayment Exch Gain Loss GLAN";
		String colCompany = "Company";

		onCustomerClassSteps.switchToIFrame();

		for (int rowCusClass : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYCUSCLASS, dataKey)
				.keySet()) {
			String customerClassCode = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCustomerClassCode);
			String description = SessionData.getDataTbVal(dataTableKey, rowCusClass, colDescription);
			String receivableGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colReceivableGLAN);
			String realizedGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colRealizedGLAN);
			String unrealizedGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colUnrealizedGLAN);
			String corporateClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colCorporateClearingGLAN);
			String amtRefundabletoCustomer = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colAmtRefundabletoCustomer);
			String receivableMedisaveGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colReceivableMedisaveGLAN);
			String medisaveClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colMedisaveClearingGLAN);
			String amtBillabletoCustomer = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colAmtBillabletoCustomer);
			String recognizedAccruedCost = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colRecognizedAccruedCost);
			String recognizedAccruedRevenue = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colRecognizedAccruedRevenue);
			String rentalRevenueGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colRentalRevenueGLAN);
			String salesGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colSalesGLAN);
			String costsofSalesGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCostsofSalesGLAN);
			String salesReturnGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colSalesReturnGLAN);
			String costsofSalesReturnGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colCostsofSalesReturnGLAN);
			String costsofSalesRetClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colCostsofSalesRetClearingGLAN);
			String deliveryClearingGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colDeliveryClearingGLAN);
			String inventoryWithCustomerGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colInventoryWithCustomerGLAN);
			String costofServicingGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCostofServicingGLAN);
			String unearnedRevenueGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colUnearnedRevenueGLAN);
			String workinProgressGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colWorkinProgressGLAN);
			String retentionGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colRetentionGLAN);
			String projectRevenueGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colProjectRevenueGLAN);
			String projectCostGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colProjectCostGLAN);
			String recognitionExchGainLossGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colRecognitionExchGainLossGLAN);
			String costAccrualGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCostAccrualGLAN);
			String revenueAccrualGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colRevenueAccrualGLAN);
			String accruedIncomeGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass, colAccruedIncomeGLAN);
			String attributableProfit = SessionData.getDataTbVal(dataTableKey, rowCusClass, colAttributableProfit);
			String claimDebtor = SessionData.getDataTbVal(dataTableKey, rowCusClass, colClaimDebtor);
			String certificationDebtor = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCertificationDebtor);
			String otherPayable = SessionData.getDataTbVal(dataTableKey, rowCusClass, colOtherPayable);
			String retentionClearing = SessionData.getDataTbVal(dataTableKey, rowCusClass, colRetentionClearing);
			String materialonSite = SessionData.getDataTbVal(dataTableKey, rowCusClass, colMaterialonSite);
			String retentionMaterialonSite = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colRetentionMaterialonSite);
			String downpaymentUnearnedGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colDownpaymentUnearnedGLAN);
			String downpaymentExchGainLossGLAN = SessionData.getDataTbVal(dataTableKey, rowCusClass,
					colDownpaymentExchGainLossGLAN);
			String company = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCompany);

			onCustomerClassSteps.clickOnNewBtn();
			if (!customerClassCode.isEmpty()) {

				onCustomerClassSteps.typeCustomerClassCode(customerClassCode);

				if (!description.isEmpty()) {
					onCustomerClassSteps.typeDescription(description);
				}
				if (!receivableGLAN.isEmpty()) {
					onCustomerClassSteps.typeReceivableGLAN(receivableGLAN);
				}
				if (!realizedGLAN.isEmpty()) {
					onCustomerClassSteps.typeRealizedGLAN(realizedGLAN);
				}
				if (!unrealizedGLAN.isEmpty()) {
					onCustomerClassSteps.typeUnrealizedGLAN(unrealizedGLAN);
				}
				if (!corporateClearingGLAN.isEmpty()) {
					onCustomerClassSteps.typeCorporateClearingGLAN(corporateClearingGLAN);
				}
				if (!amtRefundabletoCustomer.isEmpty()) {
					onCustomerClassSteps.typeAmtRefundabletoCustomer(amtRefundabletoCustomer);
				}
				if (!receivableMedisaveGLAN.isEmpty()) {
					onCustomerClassSteps.typeReceivableMedisaveGLAN(receivableMedisaveGLAN);
				}
				if (!medisaveClearingGLAN.isEmpty()) {
					onCustomerClassSteps.typeMedisaveClearingGLAN(medisaveClearingGLAN);
				}
				if (!amtBillabletoCustomer.isEmpty()) {
					onCustomerClassSteps.typeAmtBillabletoCustomer(amtBillabletoCustomer);
				}
				if (!recognizedAccruedCost.isEmpty()) {
					onCustomerClassSteps.typeRecognizedAccruedCost(recognizedAccruedCost);
				}
				if (!recognizedAccruedRevenue.isEmpty()) {
					onCustomerClassSteps.typeRecognizedAccruedRevenue(recognizedAccruedRevenue);
				}
				if (!rentalRevenueGLAN.isEmpty()) {
					onCustomerClassSteps.typeRentalRevenueGLAN(rentalRevenueGLAN);
				}
				if (!salesGLAN.isEmpty()) {
					onCustomerClassSteps.typeSalesGLAN(salesGLAN);
				}
				if (!costsofSalesGLAN.isEmpty()) {
					onCustomerClassSteps.typeCostsofSalesGLAN(costsofSalesGLAN);
				}
				if (!salesReturnGLAN.isEmpty()) {
					onCustomerClassSteps.typeSalesReturnGLAN(salesReturnGLAN);
				}
				if (!costsofSalesReturnGLAN.isEmpty()) {
					onCustomerClassSteps.typeCostsofSalesReturnGLAN(costsofSalesReturnGLAN);
				}
				if (!costsofSalesRetClearingGLAN.isEmpty()) {
					onCustomerClassSteps.typeCostsofSalesRetClearingGLAN(costsofSalesRetClearingGLAN);
				}
				if (!deliveryClearingGLAN.isEmpty()) {
					onCustomerClassSteps.typeDeliveryClearingGLAN(deliveryClearingGLAN);
				}
				if (!inventoryWithCustomerGLAN.isEmpty()) {
					onCustomerClassSteps.typeInventoryWithCustomerGLAN(inventoryWithCustomerGLAN);
				}
				if (!costofServicingGLAN.isEmpty()) {
					onCustomerClassSteps.typeCostofServicingGLAN(costofServicingGLAN);
				}
				if (!unearnedRevenueGLAN.isEmpty()) {
					onCustomerClassSteps.typeUnearnedRevenueGLAN(unearnedRevenueGLAN);
				}
				if (!workinProgressGLAN.isEmpty()) {
					onCustomerClassSteps.typeWorkinProgressGLAN(workinProgressGLAN);
				}
				if (!retentionGLAN.isEmpty()) {
					onCustomerClassSteps.typeRetentionGLAN(retentionGLAN);
				}
				if (!projectRevenueGLAN.isEmpty()) {
					onCustomerClassSteps.typeProjectRevenueGLAN(projectRevenueGLAN);
				}
				if (!projectCostGLAN.isEmpty()) {
					onCustomerClassSteps.typeProjectCostGLAN(projectCostGLAN);
				}
				if (!recognitionExchGainLossGLAN.isEmpty()) {
					onCustomerClassSteps.typeRecognitionExchGainLossGLAN(recognitionExchGainLossGLAN);
				}
				if (!costAccrualGLAN.isEmpty()) {
					onCustomerClassSteps.typeCostAccrualGLAN(costAccrualGLAN);
				}
				if (!revenueAccrualGLAN.isEmpty()) {
					onCustomerClassSteps.typeRevenueAccrualGLAN(revenueAccrualGLAN);
				}
				if (!accruedIncomeGLAN.isEmpty()) {
					onCustomerClassSteps.typeAccruedIncomeGLAN(accruedIncomeGLAN);
				}
				if (!attributableProfit.isEmpty()) {
					onCustomerClassSteps.typeAttributableProfit(attributableProfit);
				}
				if (!claimDebtor.isEmpty()) {
					onCustomerClassSteps.typeClaimDebtor(claimDebtor);
				}
				if (!certificationDebtor.isEmpty()) {
					onCustomerClassSteps.typeCertificationDebtor(certificationDebtor);
				}
				if (!otherPayable.isEmpty()) {
					onCustomerClassSteps.typeOtherPayable(otherPayable);
				}
				if (!retentionClearing.isEmpty()) {
					onCustomerClassSteps.typeRetentionClearing(retentionClearing);
				}
				if (!materialonSite.isEmpty()) {
					onCustomerClassSteps.typeMaterialonSite(materialonSite);
				}
				if (!retentionMaterialonSite.isEmpty()) {
					onCustomerClassSteps.typeRetentionMaterialonSite(retentionMaterialonSite);
				}
				if (!downpaymentUnearnedGLAN.isEmpty()) {
					onCustomerClassSteps.typeDownpaymentUnearnedGLAN(downpaymentUnearnedGLAN);
				}
				if (!downpaymentExchGainLossGLAN.isEmpty()) {
					onCustomerClassSteps.typeDownpaymentExchGainLossGLAN(downpaymentExchGainLossGLAN);
				}

				if (company.trim().toLowerCase().equals("all")) {
					onCustomerClassSteps.chooseAllCompany();
				} else
					onCustomerClassSteps.chooseCompany(company);
			}
			onCustomerClassSteps.clickOnUpdateButton();
		}
		onCustomerClassSteps.switchOutDefaultIFrame();
	}

	@When("^user delete customer class$")
	public void user_delete_customer_class(List<List<String>> dataTable) {
		String dataTableKey = "DelCusClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colCustomerClassCode = "Customer Class Code";

		onCustomerClassSteps.switchToIFrame();

		for (int rowCusClass : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String customerClassCode = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCustomerClassCode);
			if (!customerClassCode.isEmpty()) {
				onCustomerClassSteps.chooseDelCusClass(customerClassCode);
			}
		}
		onCustomerClassSteps.switchOutDefaultIFrame();
	}

}
