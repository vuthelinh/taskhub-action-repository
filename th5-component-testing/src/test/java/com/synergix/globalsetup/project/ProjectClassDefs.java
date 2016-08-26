package com.synergix.globalsetup.project;

import java.util.LinkedHashMap;
import java.util.List;
import com.synergix.globalsetup.project.steps.ProjectClassSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProjectClassDefs {
	@Steps
	ProjectClassSteps projectClassSteps;

	@When("^user creates a project class as \"([^\"]*)\"$")
	public void user_creates_a_project_class_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("projectClassTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("projectClassTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("projectClassTable", row, "KEY");
			String sProjectClassCode = SessionData.getDataTbVal("projectClassTable", row, "Project Class Code");
			String sProjectClassDescription = SessionData.getDataTbVal("projectClassTable", row,
					"Project Class Description");
			String sUnearnedRevenue = SessionData.getDataTbVal("projectClassTable", row, "Unearned Revenue");
			String sWorkInProgress = SessionData.getDataTbVal("projectClassTable", row, "Work In Progress");
			String sRetention = SessionData.getDataTbVal("projectClassTable", row, "Retention");
			String sProjectRevenue = SessionData.getDataTbVal("projectClassTable", row, "Project Revenue");
			String sProjectCost = SessionData.getDataTbVal("projectClassTable", row, "Project Cost");
			String sRecognitionExchGainLoss = SessionData.getDataTbVal("projectClassTable", row,
					"Recognition Exch Gain/Loss (TH2)");
			String sCostAccrual = SessionData.getDataTbVal("projectClassTable", row, "Cost Accrual");
			String sRevenueAccrual = SessionData.getDataTbVal("projectClassTable", row, "Revenue Accrual");
			String sDownpaymentUnearned = SessionData.getDataTbVal("projectClassTable", row, "Downpayment Unearned");
			String sAttributableProfit = SessionData.getDataTbVal("projectClassTable", row, "Attributable Profit");
			String sClaimDebtor = SessionData.getDataTbVal("projectClassTable", row, "Claim Debtor");
			String sCertificationDebtor = SessionData.getDataTbVal("projectClassTable", row, "Certification Debtor");
			String sOtherPayable = SessionData.getDataTbVal("projectClassTable", row, "Other Payable");
			String sRetentionClearing = SessionData.getDataTbVal("projectClassTable", row, "Retention Clearing");
			String sSubconClaimPayable = SessionData.getDataTbVal("projectClassTable", row, "Subcon Claim Payable");
			String sSubconCertificationPayable = SessionData.getDataTbVal("projectClassTable", row,
					"Subcon Certification Payable");
			String sMaterialOnSite = SessionData.getDataTbVal("projectClassTable", row, "Material on Site");
			String sRetentionMaterialOnSite = SessionData.getDataTbVal("projectClassTable", row,
					"Retention Material on Site");
			String sLiquidatedDamage = SessionData.getDataTbVal("projectClassTable", row, "Liquidated Damage");
			String sSubconAdvancePayment = SessionData.getDataTbVal("projectClassTable", row, "Subcon Advance Payment");
			if (!sKey.isEmpty()) {
				projectClassSteps.click_add_new_button_on_functional_panel();
			}
			if (!sProjectClassCode.isEmpty()) {
				projectClassSteps.enter_project_class_code(sProjectClassCode);
			}
			if (!sProjectClassDescription.isEmpty()) {
				projectClassSteps.enter_project_class_description(sProjectClassDescription);
			}
			if (!sUnearnedRevenue.isEmpty()) {
				projectClassSteps.enter_unearned_revenue(sUnearnedRevenue);
			}
			if (!sWorkInProgress.isEmpty()) {
				projectClassSteps.enter_work_in_progress(sWorkInProgress);
			}
			if (!sRetention.isEmpty()) {
				projectClassSteps.enter_retention(sRetention);
			}
			if (!sProjectRevenue.isEmpty()) {
				projectClassSteps.enter_project_revenue(sProjectRevenue);
			}
			if (!sProjectCost.isEmpty()) {
				projectClassSteps.enter_project_cost(sProjectCost);
			}
			if (!sRecognitionExchGainLoss.isEmpty()) {
				projectClassSteps.enter_recognition_exch_gain_or_loss_th2(sRecognitionExchGainLoss);
			}
			if (!sCostAccrual.isEmpty()) {
				projectClassSteps.enter_cost_accrual(sCostAccrual);
			}
			if (!sRevenueAccrual.isEmpty()) {
				projectClassSteps.enter_revenue_accrual(sRevenueAccrual);
			}
			if (!sDownpaymentUnearned.isEmpty()) {
				projectClassSteps.enter_downpayment_unearned(sDownpaymentUnearned);
			}
			if (!sAttributableProfit.isEmpty()) {
				projectClassSteps.enter_attributable_profit(sAttributableProfit);
			}
			if (!sClaimDebtor.isEmpty()) {
				projectClassSteps.enter_claim_debtor(sClaimDebtor);
			}
			if (!sCertificationDebtor.isEmpty()) {
				projectClassSteps.enter_certification_debtor(sCertificationDebtor);
			}
			if (!sOtherPayable.isEmpty()) {
				projectClassSteps.enter_other_payable(sOtherPayable);
			}
			if (!sRetentionClearing.isEmpty()) {
				projectClassSteps.enter_retention_clearing(sRetentionClearing);
			}
			if (!sSubconClaimPayable.isEmpty()) {
				projectClassSteps.enter_subcon_claim_payable(sSubconClaimPayable);
			}
			if (!sSubconCertificationPayable.isEmpty()) {
				projectClassSteps.enter_subcon_certification_payable(sSubconCertificationPayable);
			}
			if (!sMaterialOnSite.isEmpty()) {
				projectClassSteps.enter_material_on_site(sMaterialOnSite);
			}
			if (!sRetentionMaterialOnSite.isEmpty()) {
				projectClassSteps.enter_retention_material_on_site(sRetentionMaterialOnSite);
			}
			if (!sLiquidatedDamage.isEmpty()) {
				projectClassSteps.enter_liquidated_damage(sLiquidatedDamage);
			}
			if (!sSubconAdvancePayment.isEmpty()) {
				projectClassSteps.enter_subcon_advance_payment(sSubconAdvancePayment);
			}
		}
		projectClassSteps.update();
	}

	@When("^user search for the project class with \"([^\"]*)\"$")
	public void user_search_for_the_project_class_with(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("searchTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("searchTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sProjectClassCode = SessionData.getDataTbVal("searchTable", row, "Project Class Code");
			if (!sProjectClassCode.isEmpty()) {
				projectClassSteps.search_project_class(sProjectClassCode);
			}
		}
	}

	@Then("^user should see the project class with \"([^\"]*)\" having correct information$")
	public void user_should_see_the_project_class_with_having_correct_information(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("projectClassTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sProjectClassCode = SessionData.getDataTbVal("projectClassTable", row, "Project Class Code");
			String sProjectClassDescription = SessionData.getDataTbVal("projectClassTable", row,
					"Project Class Description");
			String sUnearnedRevenue = SessionData.getDataTbVal("projectClassTable", row, "Unearned Revenue");
			String sWorkInProgress = SessionData.getDataTbVal("projectClassTable", row, "Work In Progress");
			String sRetention = SessionData.getDataTbVal("projectClassTable", row, "Retention");
			String sProjectRevenue = SessionData.getDataTbVal("projectClassTable", row, "Project Revenue");
			String sProjectCost = SessionData.getDataTbVal("projectClassTable", row, "Project Cost");
			String sRecognitionExchGainLoss = SessionData.getDataTbVal("projectClassTable", row,
					"Recognition Exch Gain/Loss (TH2)");
			String sCostAccrual = SessionData.getDataTbVal("projectClassTable", row, "Cost Accrual");
			String sRevenueAccrual = SessionData.getDataTbVal("projectClassTable", row, "Revenue Accrual");
			String sDownpaymentUnearned = SessionData.getDataTbVal("projectClassTable", row, "Downpayment Unearned");
			String sAttributableProfit = SessionData.getDataTbVal("projectClassTable", row, "Attributable Profit");
			String sClaimDebtor = SessionData.getDataTbVal("projectClassTable", row, "Claim Debtor");
			String sCertificationDebtor = SessionData.getDataTbVal("projectClassTable", row, "Certification Debtor");
			String sOtherPayable = SessionData.getDataTbVal("projectClassTable", row, "Other Payable");
			String sRetentionClearing = SessionData.getDataTbVal("projectClassTable", row, "Retention Clearing");
			String sSubconClaimPayable = SessionData.getDataTbVal("projectClassTable", row, "Subcon Claim Payable");
			String sSubconCertificationPayable = SessionData.getDataTbVal("projectClassTable", row,
					"Subcon Certification Payable");
			String sMaterialOnSite = SessionData.getDataTbVal("projectClassTable", row, "Material on Site");
			String sRetentionMaterialOnSite = SessionData.getDataTbVal("projectClassTable", row,
					"Retention Material on Site");
			String sLiquidatedDamage = SessionData.getDataTbVal("projectClassTable", row, "Liquidated Damage");
			String sSubconAdvancePayment = SessionData.getDataTbVal("projectClassTable", row, "Subcon Advance Payment");
			if (!sProjectClassCode.isEmpty()) {
				projectClassSteps.verify_project_class_code(sProjectClassCode);
			}
			if (!sProjectClassDescription.isEmpty()) {
				projectClassSteps.verify_project_class_description(sProjectClassDescription);
			}
			if (!sUnearnedRevenue.isEmpty()) {
				projectClassSteps.verify_unearned_revenue(sUnearnedRevenue);
			}
			if (!sWorkInProgress.isEmpty()) {
				projectClassSteps.verify_work_in_progress(sWorkInProgress);
			}
			if (!sRetention.isEmpty()) {
				projectClassSteps.verify_retention(sRetention);
			}
			if (!sProjectRevenue.isEmpty()) {
				projectClassSteps.verify_project_revenue(sProjectRevenue);
			}
			if (!sProjectCost.isEmpty()) {
				projectClassSteps.verify_project_cost(sProjectCost);
			}
			if (!sRecognitionExchGainLoss.isEmpty()) {
				projectClassSteps.verify_recognition_exch_gain_loss_th2(sRecognitionExchGainLoss);
			}
			if (!sCostAccrual.isEmpty()) {
				projectClassSteps.verify_cost_accrual(sCostAccrual);
			}
			if (!sRevenueAccrual.isEmpty()) {
				projectClassSteps.verify_revenue_accrual(sRevenueAccrual);
			}
			if (!sDownpaymentUnearned.isEmpty()) {
				projectClassSteps.verify_downpayment_unearned(sDownpaymentUnearned);
			}
			if (!sAttributableProfit.isEmpty()) {
				projectClassSteps.verify_attributable_profit(sAttributableProfit);
			}
			if (!sClaimDebtor.isEmpty()) {
				projectClassSteps.verify_claim_debtor(sClaimDebtor);
			}
			if (!sCertificationDebtor.isEmpty()) {
				projectClassSteps.verify_certification_debtor(sCertificationDebtor);
			}
			if (!sOtherPayable.isEmpty()) {
				projectClassSteps.verify_other_payable(sOtherPayable);
			}
			if (!sRetentionClearing.isEmpty()) {
				projectClassSteps.verify_retention_clearing(sRetentionClearing);
			}
			if (!sSubconClaimPayable.isEmpty()) {
				projectClassSteps.verify_subcon_claim_payable(sSubconClaimPayable);
			}
			if (!sSubconCertificationPayable.isEmpty()) {
				projectClassSteps.verify_subcon_certification_payable(sSubconCertificationPayable);
			}
			if (!sMaterialOnSite.isEmpty()) {
				projectClassSteps.verify_material_on_site(sMaterialOnSite);
			}
			if (!sRetentionMaterialOnSite.isEmpty()) {
				projectClassSteps.verify_retention_material_on_site(sRetentionMaterialOnSite);
			}
			if (!sLiquidatedDamage.isEmpty()) {
				projectClassSteps.verify_liquidated_damage(sLiquidatedDamage);
			}
			if (!sSubconAdvancePayment.isEmpty()) {
				projectClassSteps.verify_subcon_advance_payment(sSubconAdvancePayment);
			}
		}
	}

	@When("^user deletes the project class with \"([^\"]*)\"$")
	public void user_deletes_the_project_class_with(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("pjClassDeleteTable", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("pjClassDeleteTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("pjClassDeleteTable", row, "KEY");
			String sProjectClassCode = SessionData.getDataTbVal("pjClassDeleteTable", row, "Project Class Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProjectClassCode.isEmpty()) {
				projectClassSteps.delete();
			}
		}
	}

	@Then("^user should not see the project class with \"([^\"]*)\"$")
	public void user_should_not_see_the_project_class_with(String dataKey) {
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("pjClassDeleteTable", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("pjClassDeleteTable", row, "KEY");
			String sProjectClassCode = SessionData.getDataTbVal("pjClassDeleteTable", row, "Project Class Code");
			if (!sKey.isEmpty()) {
			}
			if (!sProjectClassCode.isEmpty()) {
				projectClassSteps.verify_search_project_class_not_found(sProjectClassCode);
			}
		}
	}
}