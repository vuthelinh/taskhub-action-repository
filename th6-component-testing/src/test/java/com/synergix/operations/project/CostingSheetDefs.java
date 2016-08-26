package com.synergix.operations.project;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.operations.project.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * 
 * @author Zoe
 *
 */
public class CostingSheetDefs {

	@Steps
	ProjectEstimationSteps prOrderSteps;

	@When("^I create phase for \"([^\"]*)\"$")
	public void i_create_phase_for(String dataKey, List<List<String>> phaseList) throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");

			if (!sPhaseNo.isEmpty()) {
				prOrderSteps.click_btn_add_main_phase();
			}
			if (!sQty.isEmpty()) {
				prOrderSteps.enter_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.enter_unit_price(sPhaseNo, sUnitPrice);
			}
		}
	}

	@When("^I create costing sheet by phase for \"([^\"]*)\"$")
	public void i_create_costing_sheet_by_phase_for(String dataKey, List<List<String>> phaseList) throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sNo = SessionData.getDataTbVal("phaseTbl", row, "No");
			String sType = SessionData.getDataTbVal("phaseTbl", row, "Type");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitCost = SessionData.getDataTbVal("phaseTbl", row, "Unit Cost");
			String sMarkup = SessionData.getDataTbVal("phaseTbl", row, "Markup");
			prOrderSteps.click_btn_costing_sheet();
			if (!sPhaseNo.isEmpty()) {
				prOrderSteps.click_on_phase_no_in_costing_sheet(sPhaseNo);
			}
			if (!sNo.isEmpty()) {
				prOrderSteps.click_btn_add_drawing_object();

			}
			if (!sType.isEmpty()) {
				prOrderSteps.select_in_drawing_object_type(sNo, sType);
			}
			if (!sQty.isEmpty()) {
				prOrderSteps.enter_drawing_object_qty(sNo, sQty);
			}
			if (!sUnitCost.isEmpty()) {
				prOrderSteps.enter_drawing_object_unit_cost(sNo, sUnitCost);
			}
			if (!sMarkup.isEmpty()) {
				prOrderSteps.enter_drawing_object_markup_percent(sNo, sMarkup);
			}
			prOrderSteps.click_btn_back_to_phase_details();
		}

	}

	@When("^I should see details \"([^\"]*)\" as$")
	public void i_should_see_details_as(String dataKey, List<List<String>> phaseList) throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sPhaseValue = SessionData.getDataTbVal("phaseTbl", row, "Phase Value");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");
			String sBudgetProfit = SessionData.getDataTbVal("phaseTbl", row, "Budget Profit");
			String sMargin = SessionData.getDataTbVal("phaseTbl", row, "Margin");

			if (!sQty.isEmpty()) {
				prOrderSteps.verify_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.verify_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sPhaseValue.isEmpty()) {
				prOrderSteps.verify_phase_value(sPhaseNo, sPhaseValue);
			}
			if (!sBudgetCost.isEmpty()) {
				prOrderSteps.verify_budget_cost(sPhaseNo, sBudgetCost);
			}
			if (!sBudgetProfit.isEmpty()) {
				prOrderSteps.verify_budget_cost(sPhaseNo, sBudgetCost);
			}
			if (!sMargin.isEmpty()) {
				prOrderSteps.verify_margin_percent(sPhaseNo, sMargin);
			}
		}
	}

	@When("^I make a change at \"([^\"]*)\" in the costing sheet of a phase$")
	public void i_make_a_change_at_in_the_costing_sheet_of_a_phase(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sPlace = SessionData.getDataTbVal("phaseTbl", row, "Place");
			String sNo = SessionData.getDataTbVal("phaseTbl", row, "No");
			String sNewValue = SessionData.getDataTbVal("phaseTbl", row, "New Value");
			prOrderSteps.click_btn_costing_sheet();
			prOrderSteps.click_on_phase_no_in_costing_sheet(sPhaseNo);
			switch (sPlace) {
			case "Qty":
				prOrderSteps.enter_drawing_object_qty(sNo, sNewValue);
				break;
			case "Unit Cost":
				prOrderSteps.enter_drawing_object_unit_cost(sNo, sNewValue);
				break;
			case "Markup":
				prOrderSteps.enter_drawing_object_markup_percent(sNo, sNewValue);
				break;
			default:
				break;
			}

			prOrderSteps.click_btn_back_to_phase_details();
		}

	}

	@Then("^I should see details of that phase when changing that \"([^\"]*)\" as$")
	public void i_should_see_details_of_that_phase_when_changing_that_as(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			
			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sPhaseValue = SessionData.getDataTbVal("phaseTbl", row, "Phase Value");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");
			String sBudgetProfit = SessionData.getDataTbVal("phaseTbl", row, "Budget Profit");
			String sMargin = SessionData.getDataTbVal("phaseTbl", row, "Margin");
			
			if (!sQty.isEmpty()) {
				prOrderSteps.verify_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.verify_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sPhaseValue.isEmpty()) {
				prOrderSteps.verify_phase_value(sPhaseNo, sPhaseValue);
			}
			if (!sBudgetCost.isEmpty()) {
				prOrderSteps.verify_budget_cost(sPhaseNo, sBudgetCost);
			}
			if (!sBudgetProfit.isEmpty()) {
				prOrderSteps.verify_budget_profit(sPhaseNo, sBudgetProfit);
			}
			if (!sMargin.isEmpty()) {
				prOrderSteps.verify_margin_percent(sPhaseNo, sMargin);
			}
		}

	}

	@Then("^the summary values when changing that \"([^\"]*)\" should be$")
	public void the_summary_values_when_changing_that_should_be(String dataKey, List<List<String>> phaseList)
			throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sSummaryValues = SessionData.getDataTbVal("phaseTbl", row, "Summary Values");
			String sNature = SessionData.getDataTbVal("phaseTbl", row, "Nature");
			String sHome = SessionData.getDataTbVal("phaseTbl", row, "Home");
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

}
