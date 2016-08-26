package com.synergix.operations.project;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.operations.project.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CurrencyExchRateSalesTaxDefs {

	@Steps
	ProjectEstimationSteps prOrderSteps;

	@When("^I create phase details for \"([^\"]*)\"$")
	public void i_create_phase_details_for(String dataKey, List<List<String>> phaseList) throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList,false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sDiscPercent = SessionData.getDataTbVal("phaseTbl", row, "Disc %");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");

			if (!sPhaseNo.isEmpty()) {
				prOrderSteps.click_btn_add_main_phase();
			}
			if (!sQty.isEmpty()) {
				prOrderSteps.enter_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.enter_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sDiscPercent.isEmpty()) {
				prOrderSteps.enter_disc_percent(sPhaseNo, sDiscPercent);
			}
			if (!sBudgetCost.isEmpty()) {
				prOrderSteps.enter_budget_cost(sPhaseNo, sBudgetCost);
			}
		}

	}

	@When("^the summary values of \"([^\"]*)\" should be$")
	public void the_summary_values_of_should_be(String dataKey, List<List<String>> phaseList) throws Throwable {

		SessionData.addDataTable("summaryTable", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("summaryTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSummaryValues = SessionData.getDataTbVal("summaryTable", row, "Summary Values");
			String sNature = SessionData.getDataTbVal("summaryTable", row, "Nature");
			String sHome = SessionData.getDataTbVal("summaryTable", row, "Home");

			if (!sSummaryValues.isEmpty()) {
				if (sSummaryValues.equals("Project Sum")) {
					prOrderSteps.verify_nature_project_sum(sNature);
					prOrderSteps.verify_home_project_sum(sHome);
				}
				if (sSummaryValues.equals("Project Budget Cost")) {
					prOrderSteps.verify_nature_project_budget_cost(sNature);
					prOrderSteps.verify_home_project_budget_cost(sHome);
				}
				if (sSummaryValues.equals("Project Budget Profit Amount")) {
					prOrderSteps.verify_nature_project_budget_profit(sNature);
					prOrderSteps.verify_home_project_budget_profit(sHome);
				}
				if (sSummaryValues.equals("Project Budget Profit Percent")) {
					prOrderSteps.verify_project_budget_percent(sNature);
					prOrderSteps.verify_project_budget_percent(sHome);
				}
				if (sSummaryValues.equals("Sales Tax")) {
					prOrderSteps.verify_nature_sales_tax(sNature);
					prOrderSteps.verify_home_sales_tax(sHome);
				}
				if (sSummaryValues.equals("Project Value incl. Tax")) {
					prOrderSteps.verify_nature_project_value_incl_tax(sNature);
					prOrderSteps.verify_home_project_value_incl_tax(sHome);
				}
			}
		}

	}

	@When("^I change values at the \"([^\"]*)\"$")
	public void i_change_values_at_the(String dataKey, List<List<String>> phaseList) throws Throwable {

		SessionData.addDataTable("phaseTbl",phaseList,false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			
			String sPlace = SessionData.getDataTbVal("phaseTbl", row, "Place");
			String sNewValue = SessionData.getDataTbVal("phaseTbl", row, "New Value");
			
			switch (sPlace) {
			case "Currency":
				prOrderSteps.enter_currency(sNewValue);
				break;
			case "Exchange Rate":
				prOrderSteps.enter_exchange_rate(sNewValue);
				break;
			case "Sales Tax":
				prOrderSteps.enter_sales_tax(sNewValue);
				break;
			default:
				break;
			}
		}
	}

}
