package com.synergix.globalsetup.party.customer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.party.customer.steps.CustomerClassSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLCustomerClassDefs {
	@Steps
	CustomerClassSteps onCustomerClassSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_PARTY + "CustomerClass.xls";
	String nameFile = "CustomerClass";
	String datasetSheet = "Customer Class";
	String companySheet = "Company";

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
		String colRevenueAccrualGLAN="Revenue Accrual GLAN";
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
			String revenueAccrualGLAN=SessionData.getDataTbVal(dataTableKey, rowCusClass, colRevenueAccrualGLAN);
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
				if(!revenueAccrualGLAN.isEmpty()){
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
	}

	@When("^user delete customer class$")
	public void user_delete_customer_class(List<List<String>> dataTable) {
		String dataTableKey = "DelCusClass";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colCustomerClassCode = "Customer Class Code";
		for (int rowCusClass : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String customerClassCode = SessionData.getDataTbVal(dataTableKey, rowCusClass, colCustomerClassCode);
			if (!customerClassCode.isEmpty()) {
				onCustomerClassSteps.chooseDelCusClass(customerClassCode);
			}
		}
	}

	@Given("^user create new customer class$")
	public void user_create_new_customer_class() {

		SessionData.addExcelData(nameFile, filePath);

		HashMap<String, Integer> hClassColName = SessionData.getExcelColNameBySheetName(nameFile, datasetSheet);

		int colCustomerClassCode = hClassColName.get("Customer Class Code");
		int colDescription = hClassColName.get("Description");
		int colReceivableGLAN = hClassColName.get("Receivable GLAN");
		int colRealizedGLAN = hClassColName.get("Realized GLAN");
		int colUnrealizedGLAN = hClassColName.get("Unrealized GLAN");
		int colCorporateClearingGLAN = hClassColName.get("Corporate Clearing GLAN");
		int colAmtRefundabletoCustomer = hClassColName.get("Amt Refundable to Customer");
		int colReceivableMedisaveGLAN = hClassColName.get("Receivable Medisave GLAN");
		int colMedisaveClearingGLAN = hClassColName.get("Medisave Clearing GLAN");
		int colAmtBillabletoCustomer = hClassColName.get("Amt Billable to Customer");
		int colRecognizedAccruedCost = hClassColName.get("Recognized Accrued Cost");
		int colRecognizedAccruedRevenue = hClassColName.get("Recognized Accrued Revenue");
		int colRentalRevenueGLAN = hClassColName.get("Rental Revenue GLAN");
		int colSalesGLAN = hClassColName.get("Sales GLAN");
		int colCostsofSalesGLAN = hClassColName.get("Costs of Sales GLAN");
		int colSalesReturnGLAN = hClassColName.get("Sales Return GLAN");
		int colCostsofSalesReturnGLAN = hClassColName.get("Costs of Sales Return GLAN");
		int colCostsofSalesRetClearingGLAN = hClassColName.get("Costs of Sales Ret Clearing GLAN");
		int colDeliveryClearingGLAN = hClassColName.get("Delivery Clearing GLAN");
		int colInventoryWithCustomerGLAN = hClassColName.get("Inventory With Customer GLAN");
		int colCostofServicingGLAN = hClassColName.get("Cost of Servicing GLAN");
		int colUnearnedRevenueGLAN = hClassColName.get("Unearned Revenue GLAN");
		int colWorkinProgressGLAN = hClassColName.get("Work in Progress GLAN");
		int colRetentionGLAN = hClassColName.get("Retention GLAN");
		int colProjectRevenueGLAN = hClassColName.get("Project Revenue GLAN");
		int colProjectCostGLAN = hClassColName.get("Project Cost GLAN");
		int colRecognitionExchGainLossGLAN = hClassColName.get("Recognition Exch Gain Loss GLAN");
		int colCostAccrualGLAN = hClassColName.get("Cost Accrual GLAN");
		int colAccruedIncomeGLAN = hClassColName.get("Accrued Income GLAN");
		int colAttributableProfit = hClassColName.get("Attributable Profit");
		int colClaimDebtor = hClassColName.get("Claim Debtor");
		int colCertificationDebtor = hClassColName.get("Certification Debtor");
		int colOtherPayable = hClassColName.get("Other Payable");
		int colRetentionClearing = hClassColName.get("Retention Clearing");
		int colMaterialonSite = hClassColName.get("Material on Site");
		int colRetentionMaterialonSite = hClassColName.get("Retention Material on Site");
		int colDownpaymentUnearnedGLAN = hClassColName.get("Downpayment Unearned GLAN");
		int colDownpaymentExchGainLossGLAN = hClassColName.get("Downpayment Exch Gain Loss GLAN");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(nameFile, companySheet);
		int colCustomerClassCompany = hCompanyColName.get("Customer Class");
		int colCompany = hCompanyColName.get("Company");

		String customerClassCode = "";
		String description = "";
		String receivableGLAN = "";
		String realizedGLAN = "";
		String unrealizedGLAN = "";
		String corporateClearingGLAN = "";
		String amtRefundabletoCustomer = "";
		String receivableMedisaveGLAN = "";
		String medisaveClearingGLAN = "";
		String amtBillabletoCustomer = "";
		String recognizedAccruedCost = "";
		String recognizedAccruedRevenue = "";
		String rentalRevenueGLAN = "";
		String salesGLAN = "";
		String costsofSalesGLAN = "";
		String salesReturnGLAN = "";
		String costsofSalesReturnGLAN = "";
		String costsofSalesRetClearingGLAN = "";
		String deliveryClearingGLAN = "";
		String inventoryWithCustomerGLAN = "";
		String costofServicingGLAN = "";
		String unearnedRevenueGLAN = "";
		String workinProgressGLAN = "";
		String retentionGLAN = "";
		String projectRevenueGLAN = "";
		String projectCostGLAN = "";
		String recognitionExchGainLossGLAN = "";
		String costAccrualGLAN = "";
		String accruedIncomeGLAN = "";
		String attributableProfit = "";
		String claimDebtor = "";
		String certificationDebtor = "";
		String otherPayable = "";
		String retentionClearing = "";
		String materialonSite = "";
		String retentionMaterialonSite = "";
		String downpaymentUnearnedGLAN = "";
		String downpaymentExchGainLossGLAN = "";

		String customerClassCompany = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(nameFile, datasetSheet);

		for (Integer row : getDataset.keySet()) {
			customerClassCode = getDataset.get(row).get(colCustomerClassCode);
			description = getDataset.get(row).get(colDescription);
			receivableGLAN = getDataset.get(row).get(colReceivableGLAN);
			realizedGLAN = getDataset.get(row).get(colRealizedGLAN);
			unrealizedGLAN = getDataset.get(row).get(colUnrealizedGLAN);
			corporateClearingGLAN = getDataset.get(row).get(colCorporateClearingGLAN);
			amtRefundabletoCustomer = getDataset.get(row).get(colAmtRefundabletoCustomer);
			receivableMedisaveGLAN = getDataset.get(row).get(colReceivableMedisaveGLAN);
			medisaveClearingGLAN = getDataset.get(row).get(colMedisaveClearingGLAN);
			amtBillabletoCustomer = getDataset.get(row).get(colAmtBillabletoCustomer);
			recognizedAccruedCost = getDataset.get(row).get(colRecognizedAccruedCost);
			recognizedAccruedRevenue = getDataset.get(row).get(colRecognizedAccruedRevenue);
			rentalRevenueGLAN = getDataset.get(row).get(colRentalRevenueGLAN);
			salesGLAN = getDataset.get(row).get(colSalesGLAN);
			costsofSalesGLAN = getDataset.get(row).get(colCostsofSalesGLAN);
			salesReturnGLAN = getDataset.get(row).get(colSalesReturnGLAN);
			costsofSalesReturnGLAN = getDataset.get(row).get(colCostsofSalesReturnGLAN);
			costsofSalesRetClearingGLAN = getDataset.get(row).get(colCostsofSalesRetClearingGLAN);
			deliveryClearingGLAN = getDataset.get(row).get(colDeliveryClearingGLAN);
			inventoryWithCustomerGLAN = getDataset.get(row).get(colInventoryWithCustomerGLAN);
			costofServicingGLAN = getDataset.get(row).get(colCostofServicingGLAN);
			unearnedRevenueGLAN = getDataset.get(row).get(colUnearnedRevenueGLAN);
			workinProgressGLAN = getDataset.get(row).get(colWorkinProgressGLAN);
			retentionGLAN = getDataset.get(row).get(colRetentionGLAN);
			projectRevenueGLAN = getDataset.get(row).get(colProjectRevenueGLAN);
			projectCostGLAN = getDataset.get(row).get(colProjectCostGLAN);
			recognitionExchGainLossGLAN = getDataset.get(row).get(colRecognitionExchGainLossGLAN);
			costAccrualGLAN = getDataset.get(row).get(colCostAccrualGLAN);
			accruedIncomeGLAN = getDataset.get(row).get(colAccruedIncomeGLAN);
			attributableProfit = getDataset.get(row).get(colAttributableProfit);
			claimDebtor = getDataset.get(row).get(colClaimDebtor);
			certificationDebtor = getDataset.get(row).get(colCertificationDebtor);
			otherPayable = getDataset.get(row).get(colOtherPayable);
			retentionClearing = getDataset.get(row).get(colRetentionClearing);
			materialonSite = getDataset.get(row).get(colMaterialonSite);
			retentionMaterialonSite = getDataset.get(row).get(colRetentionMaterialonSite);
			downpaymentUnearnedGLAN = getDataset.get(row).get(colDownpaymentUnearnedGLAN);
			downpaymentExchGainLossGLAN = getDataset.get(row).get(colDownpaymentExchGainLossGLAN);

			onCustomerClassSteps.clickOnNewBtn();
			if (!customerClassCode.isEmpty()) {
				onCustomerClassSteps.typeCustomerClassCode(customerClassCode);
			}
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

			onCustomerClassSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetData(nameFile, companySheet);
			for (Integer rowComp : getCompany.keySet()) {
				customerClassCompany = getCompany.get(rowComp).get(colCustomerClassCompany);
				if (customerClassCompany.equals(customerClassCode)) {
					company = getCompany.get(rowComp).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onCustomerClassSteps.chooseAllCompany();
						break;
					} else
						onCustomerClassSteps.chooseCompany(company);
				}
			}
			onCustomerClassSteps.clickOnUpdateButton();
		}

	}

}
