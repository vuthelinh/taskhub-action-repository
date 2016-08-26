package com.synergix.globalsetup.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.service.steps.ServiceSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLServiceDefs {
	@Steps
	ServiceSteps onServiceSteps;

	String fileName = System.getProperty("user.dir") + CONST.FIN_SERVICE + "Service.xls";

	String keyFileName = "Service";
	String datasetSheet = "Service";
	String serviceRelationSheet = "Service Relation";
	String supplierSheet = "Supplier";
	String payrollSheet = "Payroll";
	String medicalSpecificSheet = "Medical Specific";
	String manufacturingSheet = "Manufacturing";
	String companySheet = "Company";
	String localInfoSheet = "Local Info";

	boolean isContinue = false;

	@When("^user create service as \"([^\"]*)\"$")
	public void user_create_service_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Service";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSERVICE = "KEY SERVICE";
		String colServiceCode = "Service Code";
		String colServiceDescription = "Service Description";
		String colServiceCategory = "Service Category";
		String colUOM = "UOM";
		String colTrackQtyinProject = "Track Qty in Project";
		String colBudgetCategoryCode = "Budget Category Code";
		String colServiceType = "Service Type";
		String colRevenueStatus = "Revenue Status";
		String colRevenueGLAN = "Revenue GLAN";
		String colUnearnedRevenueGLAN = "Unearned Revenue GLAN";
		String colSalesAccrualGLAN = "Sales Accrual GLAN";
		String colReportGrouping = "Report Grouping";
		String colDefaultSalesTax = "Default Sales Tax";
		String colIntercompanySalesTax = "Intercompany Sales Tax";
		String colExpenseStatus = "Expense Status";
		String colExpenseGLAN = "Expense GLAN";
		String colAccruedCostGLAN = "Accrued Cost GLAN";
		String colOverheadGLAN = "Overhead GLAN";
		String colCompany = "Company";

		for (int rowService : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSERVICE, dataKey).keySet()) {
			String serviceCode = SessionData.getDataTbVal(dataTableKey, rowService, colServiceCode);
			String serviceDescription = SessionData.getDataTbVal(dataTableKey, rowService, colServiceDescription);
			String serviceCategory = SessionData.getDataTbVal(dataTableKey, rowService, colServiceCategory);
			String uOM = SessionData.getDataTbVal(dataTableKey, rowService, colUOM);
			String trackQtyinProject = SessionData.getDataTbVal(dataTableKey, rowService, colTrackQtyinProject);
			String budgetCategoryCode = SessionData.getDataTbVal(dataTableKey, rowService, colBudgetCategoryCode);
			String serviceType = SessionData.getDataTbVal(dataTableKey, rowService, colServiceType);
			String revenueStatus = SessionData.getDataTbVal(dataTableKey, rowService, colRevenueStatus);
			String revenueGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colRevenueGLAN);
			String unearnedRevenueGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colUnearnedRevenueGLAN);
			String salesAccrualGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colSalesAccrualGLAN);
			String reportGrouping = SessionData.getDataTbVal(dataTableKey, rowService, colReportGrouping);
			String defaultSalesTax = SessionData.getDataTbVal(dataTableKey, rowService, colDefaultSalesTax);
			String intercompanySalesTax = SessionData.getDataTbVal(dataTableKey, rowService, colIntercompanySalesTax);
			String expenseStatus = SessionData.getDataTbVal(dataTableKey, rowService, colExpenseStatus);
			String expenseGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colExpenseGLAN);
			String accruedCostGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colAccruedCostGLAN);
			String overheadGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colOverheadGLAN);
			String company = SessionData.getDataTbVal(dataTableKey, rowService, colCompany);

			if (!serviceCode.isEmpty()) {
				onServiceSteps.clickOnNewBtn();
				onServiceSteps.typeServiceCode(serviceCode);

				isContinue = true;

				if (!serviceDescription.isEmpty()) {
					onServiceSteps.typeServiceDescription(serviceDescription);
				}

				onServiceSteps.moveToHeaderTab();
				if (!serviceCategory.isEmpty()) {
					onServiceSteps.typeServiceCategory(serviceCategory);
				}
				if (!uOM.isEmpty()) {
					onServiceSteps.typeUOM(uOM);
				}
				if (!trackQtyinProject.isEmpty()) {
					onServiceSteps.chooseTrackQtyinProject(trackQtyinProject);
				}
				if (!budgetCategoryCode.isEmpty()) {
					onServiceSteps.typeBudgetCategoryCode(budgetCategoryCode);
				}
				if (!serviceType.isEmpty()) {
					onServiceSteps.chooseServiceType(serviceType);
				}
				if (!revenueStatus.isEmpty()) {
					onServiceSteps.chooseRevenueStatus(revenueStatus);
				}
				if (!revenueGLAN.isEmpty()) {
					onServiceSteps.typeRevenueGLAN(revenueGLAN);
				}
				if (!unearnedRevenueGLAN.isEmpty()) {
					onServiceSteps.typeUnearnedRevenueGLAN(unearnedRevenueGLAN);
				}
				if (!salesAccrualGLAN.isEmpty()) {
					onServiceSteps.typeSalesAccrualGLAN(salesAccrualGLAN);
				}
				if (!reportGrouping.isEmpty()) {
					onServiceSteps.typeReportGrouping(reportGrouping);
				}
				if (!defaultSalesTax.isEmpty()) {
					onServiceSteps.chooseDefaultSalesTax(defaultSalesTax);
				}
				if (!intercompanySalesTax.isEmpty()) {
					onServiceSteps.typeIntercompanySalesTax(intercompanySalesTax);
				}
				if (!expenseStatus.isEmpty()) {
					onServiceSteps.chooseExpenseStatus(expenseStatus);
				}
				if (!expenseGLAN.isEmpty()) {
					onServiceSteps.typeExpenseGLAN(expenseGLAN);
				}
				if (!accruedCostGLAN.isEmpty()) {
					onServiceSteps.typeAccruedCostGLAN(accruedCostGLAN);
				}
				if (!overheadGLAN.isEmpty()) {
					onServiceSteps.typeOverheadGLAN(overheadGLAN);
				}

				onServiceSteps.moveToCompanyTab();
				if (company.toLowerCase().trim().equals("all")) {
					onServiceSteps.chooseAllCompany();

				} else
					onServiceSteps.chooseCompany(company);
			}
		}
	}

	@When("^user udpate service as \"([^\"]*)\"$")
	public void user_update_service_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "Service";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSERVICE = "KEY SERVICE";
		String colServiceCode = "Service Code";
		String colServiceDescription = "Service Description";
		String colServiceCategory = "Service Category";
		String colUOM = "UOM";
		String colTrackQtyinProject = "Track Qty in Project";
		String colBudgetCategoryCode = "Budget Category Code";
		String colServiceType = "Service Type";
		String colRevenueStatus = "Revenue Status";
		String colRevenueGLAN = "Revenue GLAN";
		String colUnearnedRevenueGLAN = "Unearned Revenue GLAN";
		String colSalesAccrualGLAN = "Sales Accrual GLAN";
		String colReportGrouping = "Report Grouping";
		String colDefaultSalesTax = "Default Sales Tax";
		String colIntercompanySalesTax = "Intercompany Sales Tax";
		String colExpenseStatus = "Expense Status";
		String colExpenseGLAN = "Expense GLAN";
		String colAccruedCostGLAN = "Accrued Cost GLAN";
		String colOverheadGLAN = "Overhead GLAN";
		String colCompany = "Company";

		for (int rowService : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSERVICE, dataKey).keySet()) {
			String serviceCode = SessionData.getDataTbVal(dataTableKey, rowService, colServiceCode);
			String serviceDescription = SessionData.getDataTbVal(dataTableKey, rowService, colServiceDescription);
			String serviceCategory = SessionData.getDataTbVal(dataTableKey, rowService, colServiceCategory);
			String uOM = SessionData.getDataTbVal(dataTableKey, rowService, colUOM);
			String trackQtyinProject = SessionData.getDataTbVal(dataTableKey, rowService, colTrackQtyinProject);
			String budgetCategoryCode = SessionData.getDataTbVal(dataTableKey, rowService, colBudgetCategoryCode);
			String serviceType = SessionData.getDataTbVal(dataTableKey, rowService, colServiceType);
			String revenueStatus = SessionData.getDataTbVal(dataTableKey, rowService, colRevenueStatus);
			String revenueGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colRevenueGLAN);
			String unearnedRevenueGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colUnearnedRevenueGLAN);
			String salesAccrualGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colSalesAccrualGLAN);
			String reportGrouping = SessionData.getDataTbVal(dataTableKey, rowService, colReportGrouping);
			String defaultSalesTax = SessionData.getDataTbVal(dataTableKey, rowService, colDefaultSalesTax);
			String intercompanySalesTax = SessionData.getDataTbVal(dataTableKey, rowService, colIntercompanySalesTax);
			String expenseStatus = SessionData.getDataTbVal(dataTableKey, rowService, colExpenseStatus);
			String expenseGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colExpenseGLAN);
			String accruedCostGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colAccruedCostGLAN);
			String overheadGLAN = SessionData.getDataTbVal(dataTableKey, rowService, colOverheadGLAN);
			String company = SessionData.getDataTbVal(dataTableKey, rowService, colCompany);

			if (!serviceCode.isEmpty()) {
				if (onServiceSteps.searchServiceCode(serviceCode)) {

					isContinue = true;

					if (!serviceDescription.isEmpty()) {
						onServiceSteps.typeServiceDescription(serviceDescription);
					}

					onServiceSteps.moveToHeaderTab();
					if (!serviceCategory.isEmpty()) {
						onServiceSteps.typeServiceCategory(serviceCategory);
					}
					if (!uOM.isEmpty()) {
						onServiceSteps.typeUOM(uOM);
					}
					if (!trackQtyinProject.isEmpty()) {
						onServiceSteps.chooseTrackQtyinProject(trackQtyinProject);
					}
					if (!budgetCategoryCode.isEmpty()) {
						onServiceSteps.typeBudgetCategoryCode(budgetCategoryCode);
					}
					if (!serviceType.isEmpty()) {
						onServiceSteps.chooseServiceType(serviceType);
					}
					if (!revenueStatus.isEmpty()) {
						onServiceSteps.chooseRevenueStatus(revenueStatus);
					}
					if (!revenueGLAN.isEmpty()) {
						onServiceSteps.typeRevenueGLAN(revenueGLAN);
					}
					if (!unearnedRevenueGLAN.isEmpty()) {
						onServiceSteps.typeUnearnedRevenueGLAN(unearnedRevenueGLAN);
					}
					if (!salesAccrualGLAN.isEmpty()) {
						onServiceSteps.typeSalesAccrualGLAN(salesAccrualGLAN);
					}
					if (!reportGrouping.isEmpty()) {
						onServiceSteps.typeReportGrouping(reportGrouping);
					}
					if (!defaultSalesTax.isEmpty()) {
						onServiceSteps.chooseDefaultSalesTax(defaultSalesTax);
					}
					if (!intercompanySalesTax.isEmpty()) {
						onServiceSteps.typeIntercompanySalesTax(intercompanySalesTax);
					}
					if (!expenseStatus.isEmpty()) {
						onServiceSteps.chooseExpenseStatus(expenseStatus);
					}
					if (!expenseGLAN.isEmpty()) {
						onServiceSteps.typeExpenseGLAN(expenseGLAN);
					}
					if (!accruedCostGLAN.isEmpty()) {
						onServiceSteps.typeAccruedCostGLAN(accruedCostGLAN);
					}
					if (!overheadGLAN.isEmpty()) {
						onServiceSteps.typeOverheadGLAN(overheadGLAN);
					}

					onServiceSteps.moveToCompanyTab();
					if (company.toLowerCase().trim().equals("all")) {
						onServiceSteps.chooseAllCompany();

					} else
						onServiceSteps.chooseCompany(company);
				}
			}
		}
	}

	@When("^service is added service relation as \"([^\"]*)\"$")
	public void service_is_added_service_relation_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String colKEYSERVICE = "KEY SERVICE";
			String colPartyTypeGroup = "Party Type Group";
			String colPartyType = "Party Type";
			String colRevenue = "Revenue";
			String colExpense = "Expense";

			String dataTableKey = "ServiceRelation";
			SessionData.addDataTable(dataTableKey, dataTable);

			onServiceSteps.moveToServiceRelationTab();
			for (int rowServiceRelation : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSERVICE, dataKey)
					.keySet()) {
				String partyTypeGroup = SessionData.getDataTbVal(dataTableKey, rowServiceRelation, colPartyTypeGroup);
				String partyType = SessionData.getDataTbVal(dataTableKey, rowServiceRelation, colPartyType);
				String revenue = SessionData.getDataTbVal(dataTableKey, rowServiceRelation, colRevenue);
				String expense = SessionData.getDataTbVal(dataTableKey, rowServiceRelation, colExpense);

				if (!partyTypeGroup.isEmpty() && !partyType.isEmpty()) {
					onServiceSteps.typeRelation(partyTypeGroup, partyType);

					if (revenue.toLowerCase().equals("y")) {
						onServiceSteps.chooseRevenue();
					}
					if (expense.toLowerCase().equals("y")) {
						onServiceSteps.chooseExpense();
					}
				}
			}
		}
	}

	@When("^service is updated$")
	public void service_is_updated() {
		if (isContinue)
			onServiceSteps.clickOnUpdateBtn();
	}

	@When("^user delete service$")
	public void user_delete_service(List<List<String>> dataTable) {
		String dataTableKey = "DelService";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colServiceCode = "Service Code";
		for (int rowService : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String serviceCode = SessionData.getDataTbVal(dataTableKey, rowService, colServiceCode);

			if (!serviceCode.isEmpty()) {
				onServiceSteps.chooseDelService(serviceCode);
			}
		}

	}

	@When("^user create new service$")
	public void user_create_new_service() {
		SessionData.addExcelData(keyFileName, fileName);

		HashMap<String, Integer> hServiceColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);

		int colServiceCode = hServiceColName.get("Service Code");
		int colServiceDescription = hServiceColName.get("Service Description");
		int colServiceCategory = hServiceColName.get("Service Category");
		int colUOM = hServiceColName.get("UOM");
		int colTrackQtyinProject = hServiceColName.get("Track Qty in Project");
		int colBudgetCategoryCode = hServiceColName.get("Budget Category Code");
		int colServiceType = hServiceColName.get("Service Type");
		int colRevenueStatus = hServiceColName.get("Revenue Status");
		int colRevenueGLAN = hServiceColName.get("Revenue GLAN");
		int colUnearnedRevenueGLAN = hServiceColName.get("Unearned Revenue GLAN");
		int colSalesAccrualGLAN = hServiceColName.get("Sales Accrual GLAN");
		int colReportGrouping = hServiceColName.get("Report Grouping");
		int colDefaultSalesTax = hServiceColName.get("Default Sales Tax");
		int colIntercompanySalesTax = hServiceColName.get("Intercompany Sales Tax");
		int colExpenseStatus = hServiceColName.get("Expense Status");
		int colExpenseGLAN = hServiceColName.get("Expense GLAN");
		int colAccruedCostGLAN = hServiceColName.get("Accrued Cost GLAN");
		int colOverheadGLAN = hServiceColName.get("Overhead GLAN");

		HashMap<String, Integer> hServiceRelationColName = SessionData.getExcelColNameBySheetName(keyFileName,
				serviceRelationSheet);
		int colPartyTypeGroup = hServiceRelationColName.get("Party Type Group");
		int colPartyType = hServiceRelationColName.get("Party Type");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName(keyFileName, companySheet);
		int colServiceCompany = hCompanyColName.get("Service");
		int colCompany = hCompanyColName.get("Company");

		String serviceCode = "";
		String serviceDescription = "";
		String serviceCategory = "";
		String uOM = "";
		String trackQtyinProject = "";
		String budgetCategoryCode = "";
		String serviceType = "";
		String revenueStatus = "";
		String revenueGLAN = "";
		String unearnedRevenueGLAN = "";
		String salesAccrualGLAN = "";
		String reportGrouping = "";
		String defaultSalesTax = "";
		String intercompSalesTax = "";
		String expenseStatus = "";
		String expenseGLAN = "";
		String accruedCostGLAN = "";
		String overheadGLAN = "";

		String partyTypeGroup = "";
		String partyType = "";

		String serviceCompany = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);
		for (Integer row : getDataset.keySet()) {
			serviceCode = getDataset.get(row).get(colServiceCode);
			serviceDescription = getDataset.get(row).get(colServiceDescription);
			serviceCategory = getDataset.get(row).get(colServiceCategory);
			uOM = getDataset.get(row).get(colUOM);
			trackQtyinProject = getDataset.get(row).get(colTrackQtyinProject);
			budgetCategoryCode = getDataset.get(row).get(colBudgetCategoryCode);
			serviceType = getDataset.get(row).get(colServiceType);
			revenueStatus = getDataset.get(row).get(colRevenueStatus);
			revenueGLAN = getDataset.get(row).get(colRevenueGLAN);
			unearnedRevenueGLAN = getDataset.get(row).get(colUnearnedRevenueGLAN);
			salesAccrualGLAN = getDataset.get(row).get(colSalesAccrualGLAN);
			reportGrouping = getDataset.get(row).get(colReportGrouping);
			defaultSalesTax = getDataset.get(row).get(colDefaultSalesTax);
			intercompSalesTax = getDataset.get(row).get(colIntercompanySalesTax);
			expenseStatus = getDataset.get(row).get(colExpenseStatus);
			expenseGLAN = getDataset.get(row).get(colExpenseGLAN);
			accruedCostGLAN = getDataset.get(row).get(colAccruedCostGLAN);
			overheadGLAN = getDataset.get(row).get(colOverheadGLAN);

			onServiceSteps.clickOnNewBtn();
			if (!serviceCode.isEmpty()) {
				onServiceSteps.typeServiceCode(serviceCode);
			}
			if (!serviceDescription.isEmpty()) {
				onServiceSteps.typeServiceDescription(serviceDescription);
			}

			onServiceSteps.moveToHeaderTab();
			if (!serviceCategory.isEmpty()) {
				onServiceSteps.typeServiceCategory(serviceCategory);
			}
			if (!uOM.isEmpty()) {
				onServiceSteps.typeUOM(uOM);
			}
			if (!trackQtyinProject.isEmpty()) {
				onServiceSteps.chooseTrackQtyinProject(trackQtyinProject);
			}
			if (!budgetCategoryCode.isEmpty()) {
				onServiceSteps.typeBudgetCategoryCode(budgetCategoryCode);
			}
			if (!serviceType.isEmpty()) {
				onServiceSteps.chooseServiceType(serviceType);
			}
			if (!revenueStatus.isEmpty()) {
				onServiceSteps.chooseRevenueStatus(revenueStatus);
			}
			if (!revenueGLAN.isEmpty()) {
				onServiceSteps.typeRevenueGLAN(revenueGLAN);
			}
			if (!unearnedRevenueGLAN.isEmpty()) {
				onServiceSteps.typeUnearnedRevenueGLAN(unearnedRevenueGLAN);
			}
			if (!salesAccrualGLAN.isEmpty()) {
				onServiceSteps.typeSalesAccrualGLAN(salesAccrualGLAN);
			}
			if (!reportGrouping.isEmpty()) {
				onServiceSteps.typeReportGrouping(reportGrouping);
			}
			if (!defaultSalesTax.isEmpty()) {
				onServiceSteps.chooseDefaultSalesTax(defaultSalesTax);
			}
			if (!intercompSalesTax.isEmpty()) {
				onServiceSteps.typeIntercompanySalesTax(intercompSalesTax);
			}
			if (!expenseStatus.isEmpty()) {
				onServiceSteps.chooseExpenseStatus(expenseStatus);
			}
			if (!expenseGLAN.isEmpty()) {
				onServiceSteps.typeExpenseGLAN(expenseGLAN);
			}
			if (!accruedCostGLAN.isEmpty()) {
				onServiceSteps.typeAccruedCostGLAN(accruedCostGLAN);
			}
			if (!overheadGLAN.isEmpty()) {
				onServiceSteps.typeOverheadGLAN(overheadGLAN);
			}

			onServiceSteps.moveToServiceRelationTab();
			LinkedHashMap<Integer, List<String>> getServiceRelation = SessionData.getExcelSheetDataNoHeader(keyFileName,
					serviceRelationSheet);
			for (Integer rowRelation : getServiceRelation.keySet()) {
				partyTypeGroup = getServiceRelation.get(rowRelation).get(colPartyTypeGroup);
				partyType = getServiceRelation.get(rowRelation).get(colPartyType);
				if (!partyTypeGroup.isEmpty() && !partyType.isEmpty()) {
					onServiceSteps.typeRelation(partyTypeGroup, partyType);
				}
			}

			onServiceSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetDataNoHeader(keyFileName,
					companySheet);
			for (Integer rowCompany : getCompany.keySet()) {
				serviceCompany = getCompany.get(rowCompany).get(colServiceCompany);
				if (serviceCompany.equals(serviceCode)) {
					company = getCompany.get(rowCompany).get(colCompany);
					if (company.toLowerCase().trim().equals("all")) {
						onServiceSteps.chooseAllCompany();
						break;
					} else
						onServiceSteps.chooseCompany(company);
				}
			}
			onServiceSteps.clickOnUpdateBtn();
		}
	}
}
