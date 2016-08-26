package com.synergix.processing.project.quotationandorder;

import com.synergix.common.steps.LoginSteps;
import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.processing.project.quotationorder.steps.ProjectEstimationSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by Synergix47 on 7/21/2016.
 */
public class QuotationDefs {

    @Steps
    LoginSteps loginStep;

    @Steps
    MenuNavigationSteps menuNavigation;

    @Steps
    ProjectEstimationSteps projectEstimation;

    @Given("^I want to create a new quotation for a project at \"([^\"]*)\"$")
    public void i_want_to_create_a_new_quotation_for(String customerCode) {
        loginStep.goTo();
        loginStep.loginAs("ian.do").selectCompany("AUTO1").withPassword("taskhub").login();

        menuNavigation.user_navigates_to_screen("Processing>Project>Quotation & Order>Project Quotation");

        projectEstimation.click_add_new_button_on_functional_panel();
        projectEstimation.customer_code(customerCode);

    }

    @When("^I divide the project \"([^\"]*)\" into phases$")
    public void i_divide_the_project_into_phases(String projectNo, List<List<String>> dataTable) {

        projectEstimation.go_to_tab("Detail");

        String dataTableKey = "Phases Table";
        SessionData.addDataTable(dataTableKey, dataTable);


        String colPhaseNo = "Phase No";
        String colPhase = "Phase";

        for (int rowPhase : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowPhase, colPhaseNo);
            String phase = SessionData.getDataTbVal(dataTableKey, rowPhase, colPhase);

            int phaseTree = phaseNo.split("\\.").length;

            if (phaseTree == 1) {
                projectEstimation.add_main_phase_with_desc(phaseNo, phase);
            } else if (phaseTree > 1) {
                projectEstimation.add_sub_phase_by_phase_no_with_desc(phaseNo, phase);
            }

        }
    }

    @When("^I estimate quantity, price and discount for each phase in \"([^\"]*)\"$")
    public void estimate_phase(String projectNo, List<List<String>> dataTable) {
        String dataTableKey = "EstimateTable";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colPhaseNo = "Phase No.";
        String colQty = "Qty";
        String colPrice = "Price";
        String colDiscPercent = "Disc Percent";
        String colDiscAmount = "Disc Amount";

        for (int rowPhase : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowPhase, colPhaseNo);
            String qty = SessionData.getDataTbVal(dataTableKey, rowPhase, colQty);
            String price = SessionData.getDataTbVal(dataTableKey, rowPhase, colPrice);
            String discPercent = SessionData.getDataTbVal(dataTableKey, rowPhase, colDiscPercent);
            String discAmount = SessionData.getDataTbVal(dataTableKey, rowPhase, colDiscAmount);

            projectEstimation.estimate_by_phase_no(phaseNo, qty, price, discPercent, discAmount);
        }
    }

    @Then("^\"([^\"]*)\" phase detail should be as following$")
    public void phase_detail(String projectNo, List<List<String>> dataTable) {
        String dataTableKey = "PhaseDetail";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colPhaseNo = "Phase No.";
        String colTotalAmount = "Total Amount";
        String colEstimateCost = "Estimate Cost";
        String colEstimateProfit = "Estimate Profit";

        for (int rowPhase : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowPhase, colPhaseNo);
            String totalAmount = SessionData.getDataTbVal(dataTableKey, rowPhase, colTotalAmount);
            String estimateCost = SessionData.getDataTbVal(dataTableKey, rowPhase, colEstimateCost);
            String estimateProfit = SessionData.getDataTbVal(dataTableKey, rowPhase, colEstimateProfit);

            projectEstimation.phase_by_phase_no_should_be(phaseNo, totalAmount, estimateCost, estimateProfit);
        }
    }
}
