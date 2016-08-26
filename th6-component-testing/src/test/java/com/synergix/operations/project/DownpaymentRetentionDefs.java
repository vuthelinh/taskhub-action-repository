package com.synergix.operations.project;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.operations.project.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DownpaymentRetentionDefs {
	@Steps
	ProjectEstimationSteps prOrderSteps;

	@Given("^I create phase as \"([^\"]*)\"$")
	public void i_create_phase_as(String dataKey, List<List<String>> phaseList) throws Throwable {

		prOrderSteps.click_btn_add_main_phase();
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sPhaseNo = SessionData.getDataTbVal("phaseTbl", row, "Phase No.");
			String sQty = SessionData.getDataTbVal("phaseTbl", row, "Qty");
			String sUnitPrice = SessionData.getDataTbVal("phaseTbl", row, "Unit Price");

			if (!sQty.isEmpty()) {
				prOrderSteps.enter_qty(sPhaseNo, sQty);
			}
			if (!sUnitPrice.isEmpty()) {
				prOrderSteps.enter_unit_price(sPhaseNo, sUnitPrice);
			}

		}
	}

	@Given("^the total amount of money the customer has to pay for \"([^\"]*)\" is$")
	public void the_total_amount_of_money_the_customer_has_to_pay_for_is(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {

			String sProjectSum = SessionData.getDataTbVal("phaseTbl", row, "Project Sum");

			if (!sProjectSum.isEmpty()) {
				prOrderSteps.verify_home_project_sum(sProjectSum);
			}
		}

	}

	@When("^with \"([^\"]*)\" the downpayment type entered is$")
	public void with_the_downpayment_type_entered_is(String dataKey, List<List<String>> phaseList) throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("phaseTbl", row, "KEY");
			String sDownpaymentAmount = SessionData.getDataTbVal("phaseTbl", row, "Downpayment Amount");
			String sDownpaymentPercent = SessionData.getDataTbVal("phaseTbl", row, "Downpayment Percent");
			if (!sKey.isEmpty()) {
			}
			if (!sDownpaymentAmount.isEmpty()) {
				prOrderSteps.enter_downpayment_amt(sDownpaymentAmount);
			}
			if (!sDownpaymentPercent.isEmpty()) {
				prOrderSteps.enter_downpayment_percent(sDownpaymentPercent);
			}
		}

	}

	@Then("^I should see the other downpayment  for \"([^\"]*)\" as$")
	public void i_should_see_the_other_downpayment_for_as(String dataKey, List<List<String>> phaseList)
			throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("phaseTbl", row, "KEY");
			String sDownpaymentAmount = SessionData.getDataTbVal("phaseTbl", row, "Downpayment Amount");
			String sDownpaymentPercent = SessionData.getDataTbVal("phaseTbl", row, "Downpayment Percent");
			if (!sKey.isEmpty()) {
			}
			if (!sDownpaymentAmount.isEmpty()) {
				
				prOrderSteps.verify_downpayment_amt(sDownpaymentAmount);
				
			}
			if (!sDownpaymentPercent.isEmpty()) {
				prOrderSteps.verify_downpayment_percent(sDownpaymentPercent);
			}
		}
	}

	@When("^with \"([^\"]*)\" the progressive retention entered is$")
	public void with_the_progressive_retention_entered_is(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKEY = SessionData.getDataTbVal("phaseTbl", row, "KEY");
			String sProgressiveRetention = SessionData.getDataTbVal("phaseTbl", row, "Progressive Retention");
			if (!sKEY.isEmpty()) {
			}
			if (!sProgressiveRetention.isEmpty()) {
				
				prOrderSteps.enter_progressive_retention(sProgressiveRetention);
				
				
			}
		}

	}

	@When("^with \"([^\"]*)\" the max retention type entered is$")
	public void with_the_max_retention_type_entered_is(String dataKey, List<List<String>> phaseList) throws Throwable {

		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("phaseTbl", row, "KEY");
			String sMaxRetentionAmount = SessionData.getDataTbVal("phaseTbl", row, "Max Retention Amount");
			String sMaxRetentionPercent = SessionData.getDataTbVal("phaseTbl", row, "Max Retention Percent");
			if (!sKey.isEmpty()) {
			}
			if (!sMaxRetentionAmount.isEmpty()) {
				prOrderSteps.enter_max_retention_amt(sMaxRetentionAmount);
				
			}
			if (!sMaxRetentionPercent.isEmpty()) {
				prOrderSteps.enter_max_retention_percent(sMaxRetentionPercent);
			}
		}
	}

	@Then("^I should see the other max retention type for \"([^\"]*)\" as$")
	public void i_should_see_the_other_max_retention_type_for_as(String dataKey, List<List<String>> phaseList)
			throws Throwable {
		SessionData.addDataTable("phaseTbl", phaseList, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("phaseTbl", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("phaseTbl", row, "KEY");
			String sRetentionAmount = SessionData.getDataTbVal("phaseTbl", row, "Retention Amount");
			String sRetentionPercent = SessionData.getDataTbVal("phaseTbl", row, "Retention Percent");
			if (!sKey.isEmpty()) {
			}
			if (!sRetentionAmount.isEmpty()) {
				prOrderSteps.verify_retention_amt(sRetentionAmount);
				
			}
			if (!sRetentionPercent.isEmpty()) {
				prOrderSteps.verify_max_retention_percent(sRetentionPercent);
			}
		}

	}

}
