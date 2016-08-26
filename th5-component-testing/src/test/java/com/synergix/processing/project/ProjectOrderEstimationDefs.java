package com.synergix.processing.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import com.synergix.processing.project.quotationorder.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class ProjectOrderEstimationDefs {
	@Steps
	ProjectEstimationSteps projectEstimationSteps;
	private List<String> listProjectNo = new ArrayList<String>();
	private boolean isNewProject;
	private String ssProjectNo = "ProjectNo";

	@When("^user create project estimation as \"([^\"]*)\"$")
	public void the_user_create_project_estimation_as(String keyPrj,
			List<List<String>> dataset) {
		String dataTableKey = "WTS_ProjectEstimation";
		SessionData.addDataTable(dataTableKey, dataset, false);

		isNewProject = false;
		String colCustomer = "Customer";

		for (int rowWTS_ProjectEstimation : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "PE KEY", keyPrj)
				.keySet()) {
			String customer = SessionData.getDataTbVal(dataTableKey,
					rowWTS_ProjectEstimation, colCustomer);
			// projectEstimationSteps.searchProjectNo("PJE0000066");
			projectEstimationSteps.createNewVoucherPE();
			isNewProject = true;
			if (!customer.isEmpty()) {
				projectEstimationSteps.customer_code(colCustomer, customer);
			}
		}
	}

	@When("^user update project estimation as \"([^\"]*)\"$")
	public void the_user_update_project_estimation_as(String keyPrj,
			List<List<String>> dataset) {

		String dataTableKey = "WTS_ProjectEstimation";
		SessionData.addDataTable(dataTableKey, dataset, false);

		isNewProject = false;
		String colProjectNo = "Project No.";

		for (int rowWTS_ProjectEstimation : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, "PE KEY", keyPrj)
				.keySet()) {
			String projectNo = SessionData.getDataTbVal(dataTableKey,
					rowWTS_ProjectEstimation, colProjectNo);
			isNewProject = true;
			if (!projectNo.isEmpty()) {
				projectEstimationSteps.searchProjectNo(projectNo);
			}
		}
	}

	@When("^project estimation is created with header tab as \"([^\"]*)\"$")
	public void project_estimation_is_created_with_header_tab_as(String keyPrj,
			List<List<String>> dataTable) {
		if (isNewProject) {
			String dataTableKey = "WTS_ProjectEstimation_Header";
			SessionData.addDataTable(dataTableKey, dataTable, false);

			String colCurrency = "Currency";
			String colSalesTax = "Sales Tax";
			String colEstimateDate = "Estimate Date";
			String colStartDate = "Start Date";
			String colEndDate = "End Date";
			String colProjectClass = "Project Class";
			String colPaymentTermTenor = "Payment Term Tenor";

			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";

			for (int rowWTS_ProjectEstimation_Header : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, "PE KEY",
							keyPrj).keySet()) {

				projectEstimationSteps.go_to_tab("Header");

				String currency = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colCurrency);
				String salesTax = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSalesTax);
				String estimateDate = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colEstimateDate);
				String startDate = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colStartDate);
				String endDate = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colEndDate);
				String projectClass = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colProjectClass);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowWTS_ProjectEstimation_Header, colSegment4);

				String paymentTermTenor = SessionData.getDataTbVal(
						dataTableKey, rowWTS_ProjectEstimation_Header,
						colPaymentTermTenor);

				if (!currency.isEmpty()) {
					projectEstimationSteps.currency(colCurrency, currency);
				}
				if (!salesTax.isEmpty()) {
					projectEstimationSteps.sales_tax(colSalesTax, salesTax);
				}
				if (!estimateDate.isEmpty()) {
					projectEstimationSteps.estimate_date(colEstimateDate,
							estimateDate);
				}
				if (!startDate.isEmpty()) {
					projectEstimationSteps.start_date(colStartDate, startDate);
				}
				if (!endDate.isEmpty()) {
					projectEstimationSteps.end_date(colEndDate, endDate);
				}
				if (!projectClass.isEmpty()) {
					projectEstimationSteps.project_class(colProjectClass,
							projectClass);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				projectEstimationSteps.setSegment(listSegment);

				if (!paymentTermTenor.isEmpty()) {
					projectEstimationSteps.go_to_tab("Payment Info");
					projectEstimationSteps.payment_term_tenor_date(
							colPaymentTermTenor, paymentTermTenor);
				}
			}
		}
	}

	@When("^project estimation is created with detail tab with phase as \"([^\"]*)\"$")
	public void project_estimation_is_created_with_detail_tab_with_phase_as(
			String keyPrj, List<List<String>> dataset) {
		if (isNewProject) {
			projectEstimationSteps.go_to_tab("Detail");
			projectEstimationSteps.setPhaseInfor(keyPrj, dataset);
		}
	}

	@When("^project estimation is created with detail tab with item as \"([^\"]*)\"$")
	public void project_estimation_is_created_with_detail_tab_with_item_as(
			String keyPrj, List<List<String>> dataset) {
		if (isNewProject) {
			projectEstimationSteps.setItemInfor(keyPrj, dataset);
		}
	}

	@When("^project estimation is submitted$")
	public void project_estimation_is_submitted() {
		if (isNewProject) {

			String projectNo = projectEstimationSteps.getProjectNo();

			try {
				listProjectNo = Serenity.sessionVariableCalled(ssProjectNo);
				if (listProjectNo == null) {
					listProjectNo = new ArrayList<String>();
				}
			} catch (Exception e) {
				System.out
						.println("***** WARNING ***** : ProjectNo Variable Not created yet ");
			}

			listProjectNo.add(projectNo);
			Serenity.setSessionVariable(ssProjectNo).to(listProjectNo);

			projectEstimationSteps.click_summit();
		}
	}
}
