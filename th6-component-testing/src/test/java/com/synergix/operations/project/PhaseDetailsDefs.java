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
public class PhaseDetailsDefs {
	@Steps
	ProjectEstimationSteps prOrderSteps;

	@When("^user creates phase with Qty, Unit Price and Budget Cost as \"([^\"]*)\"$")
	public void user_creates_phase_with_Qty_Unit_Price_and_Budget_Cost(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		prOrderSteps.click_add_new_button_on_functional_panel();
		prOrderSteps.click_btn_add_main_phase();
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");

			if (!sQty.isEmpty()) {
				prOrderSteps.enter_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.enter_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sBudgetCost.isEmpty()) {
				prOrderSteps.enter_budget_cost(sPhaseNo, sBudgetCost);
			}
		}
	}

	@Then("^user should see result for \"([^\"]*)\" as the following:$")
	public void user_should_see_result_as_the_following(String dataKey, List<List<String>> phaseList) throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");
			String sBudgetProfit = SessionData.getDataTbVal("phaseTbl", row, "Budget Profit");
			String sMargin = SessionData.getDataTbVal("phaseTbl", row, "Margin");

			if (!sQty.isEmpty()) {
				prOrderSteps.verify_qty(sPhaseNo, sQty);

			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.verify_unit_price(sPhaseNo, sUnitPrice);
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

	@When("^user creates phase with Qty, Budget Cost, Margin as \"([^\"]*)\"$")
	public void user_creates_phase_with_Qty_Budget_Cost_Margin(String dataKey, List<List<String>> phaseList)
			throws Throwable {

		prOrderSteps.click_add_new_button_on_functional_panel();
		prOrderSteps.click_btn_add_main_phase();

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");
			String sMargin = SessionData.getDataTbVal("phaseTbl", row, "Margin");

			if (!sPhaseNo.isEmpty()) {
				prOrderSteps.add_a_phase(sPhaseNo);

			}
			if (!sQty.isEmpty()) {
				prOrderSteps.enter_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.enter_unit_price(sPhaseNo, sUnitPrice);
			}
			if (!sBudgetCost.isEmpty()) {
				prOrderSteps.enter_budget_cost(sPhaseNo, sBudgetCost);
			}
			if (!sMargin.isEmpty()) {
				prOrderSteps.enter_margin_percent(sPhaseNo, sMargin);
			}
		}

	}

	@Then("^user should see the following result for \"([^\"]*)\":$")
	public void user_should_see_the_following_result_for_phase_details(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");
			String sBudgetProfit = SessionData.getDataTbVal("phaseTbl", row, "Budget Profit");
			String sMargin = SessionData.getDataTbVal("phaseTbl", row, "Margin");
			if (!sPhaseNo.isEmpty()) {
			}
			if (!sQty.isEmpty()) {
				prOrderSteps.verify_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.verify_unit_price(sPhaseNo, sUnitPrice);
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

	@When("^user creates the following details for each phase as \"([^\"]*)\"$")
	public void user_creates_the_following_details_for_each_phase(String dataKey, List<List<String>> phaseList)
			throws Throwable {

		prOrderSteps.click_add_new_button_on_functional_panel();
		prOrderSteps.click_btn_add_main_phase();
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sDiscPercent = SessionData.getDataTbVal("phaseTbl", row, "Disc Percent");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");

			if (!sPhaseNo.isEmpty()) {
				prOrderSteps.add_a_phase(sPhaseNo);
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

	@When("^user creates costing sheet by phase as the following for  \"([^\"]*)\":$")
	public void user_creates_costing_sheet_by_phase_as_the_following(String dataKey, List<List<String>> phaseList)
			throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("phaseTbl", row, "KEY");
			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sNo = SessionData.getDataTbVal("phaseTbl", row, "No");

			String sType = SessionData.getDataTbVal("phaseTbl", row, "Type");

			
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitCost = SessionData.getDataTbVal("phaseTbl", row, "Unit Cost");
			String sMarkup = SessionData.getDataTbVal("phaseTbl", row, "Markup");
			if (!sKey.isEmpty()) {
				prOrderSteps.click_btn_costing_sheet();
			}
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

	@Then("^user should see the result of Phase Details  \"([^\"]*)\" as the following:$")
	public void user_should_see_the_result_of_Phase_Details_as_the_following(String dataKey,
			List<List<String>> phaseList) throws Throwable {

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

			prOrderSteps.verify_qty(sPhaseNo, sQty);
			prOrderSteps.verify_unit_price(sPhaseNo, sUnitPrice);
			prOrderSteps.verify_phase_value(sPhaseNo, sPhaseValue);
			prOrderSteps.verify_budget_cost(sPhaseNo, sBudgetCost);
			prOrderSteps.verify_budget_profit(sPhaseNo, sBudgetProfit);
			prOrderSteps.verify_margin_percent(sPhaseNo, sMargin);
		}

	}

	@When("^user creates the following details as \"([^\"]*)\":$")
	public void user_creates_the_following_details(String dataKey, List<List<String>> phaseList) throws Throwable {
		prOrderSteps.click_add_new_button_on_functional_panel();
		prOrderSteps.click_btn_add_main_phase();
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");
			String sDiscPercent = SessionData.getDataTbVal("phaseTbl", row, "Disc Percent");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");

			if (!sPhaseNo.isEmpty()) {
				prOrderSteps.add_a_phase(sPhaseNo);
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

	@When("^user creates costing sheet by phase as \"([^\"]*)\":$")
	public void user_creates_costing_sheet_by_phase(String dataKey, List<List<String>> phaseList) throws Throwable {

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
		prOrderSteps.click_btn_costing_sheet();

	}


	@When("^sum of Budget Cost as \"([^\"]*)\":$")
	public void sum_of_Budget_Cost(String dataKey, List<List<String>> phaseList) throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");

			prOrderSteps.click_on_phase_no_in_costing_sheet(sPhaseNo);
			if (!sBudgetCost.isEmpty()) {
				prOrderSteps.verify_budget_cost_in_costing_sheet(sPhaseNo, sBudgetCost);
			}
		}
	}

	@When("^user delete one item on costing sheet as \"([^\"]*)\":$")
	public void user_delete_one_item_on_costing_sheet(String dataKey, List<List<String>> phaseList) throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sNo = SessionData.getDataTbVal("phaseTbl", row, "No");

			if (!sNo.isEmpty()) {
				prOrderSteps.check_drawing_object(sNo);
				prOrderSteps.click_btn_delete_drawing_object();
			}
		}

	}

	@Then("^user should see the budget cost result as \"([^\"]*)\":$")
	public void user_should_see_the_budget_cost_result(String dataKey, List<List<String>> phaseList) throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sBudgetCost = SessionData.getDataTbVal("phaseTbl", row, "Budget Cost");

			prOrderSteps.verify_budget_cost_in_costing_sheet(sPhaseNo, sBudgetCost);
		}

	}

	@Then("^user should see the phase details as \"([^\"]*)\":$")
	public void user_should_see_the_phase_details(String dataKey, List<List<String>> phaseList) throws Throwable {
		prOrderSteps.click_btn_back_to_phase_details();
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
}
