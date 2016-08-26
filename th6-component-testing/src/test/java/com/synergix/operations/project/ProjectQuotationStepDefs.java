package com.synergix.operations.project;

import com.synergix.common.steps.LoginSteps;
import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.operations.project.steps.ProjectQuotationSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by Ian on 7/27/2016.
 */
public class ProjectQuotationStepDefs {


    /**
     * Description:
     */
    @Steps
    LoginSteps loginStep;

    @Steps
    MenuNavigationSteps menuNavigation;

    @Steps
    ProjectQuotationSteps projectQuotation;

    @Given("^I want to create a new quotation for a project at \"([^\"]*)\"$")
    public void i_want_to_create_a_new_quotation_for(String customerCode) {
        menuNavigation.user_navigates_to_screen("Operations>Project>Project Quotation>[2]");

        projectQuotation.click_add_new_button_on_functional_panel();
        projectQuotation.select_project_quotation_number_key("DV");
        projectQuotation.enter_customer_code(customerCode);

    }

    @When("^I divide the project \"([^\"]*)\" into phases$")
    public void i_divide_the_project_into_phases(String dataKey, List<List<String>> dataTable) {
        String dataTableKey = "DelugePhases";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colPhase = "Phase";
        String colWorkheadGroup = "Workhead Group";

        for (int rowDelugePhases : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colPhaseNo);
            String phase = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colPhase);
            String workheadGroup = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colWorkheadGroup);

            int phaseTree = phaseNo.split("\\.").length;

            if (phaseTree == 1) {
                projectQuotation.add_main_phase_with_desc(phaseNo, phase);
            } else if (phaseTree > 1) {
                projectQuotation.add_sub_phase_by_phase_no_with_desc(phaseNo, phase);
            }
            if (!phase.isEmpty()) {
                projectQuotation.enter_phase_desc(phaseNo, phase);
            }
            if (!workheadGroup.isEmpty()) {
                projectQuotation.select_workhead_group(phaseNo, workheadGroup);
            }
        }
    }

    @When("^I divide the project into phases$")
    public void i_divide_the_project_into_phases(List<List<String>> dataTable) {
        String dataTableKey = "DelugePhases";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colPhaseNo = "Phase No";
        String colPhase = "Phase";
        String colWorkheadGroup = "Workhead Group";

        for (int rowDelugePhases : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colPhaseNo);
            String phase = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colPhase);
            String workheadGroup = SessionData.getDataTbVal(dataTableKey, rowDelugePhases, colWorkheadGroup);

            int phaseTree = phaseNo.split("\\.").length;

            if (phaseTree == 1) {
                projectQuotation.add_main_phase_with_desc(phaseNo, phase);
            } else if (phaseTree > 1) {
                projectQuotation.add_sub_phase_by_phase_no_with_desc(phaseNo, phase);
            }
            if (!phase.isEmpty()) {
                projectQuotation.enter_phase_desc(phaseNo, phase);
            }
            if (!workheadGroup.isEmpty()) {
                projectQuotation.select_workhead_group(phaseNo, workheadGroup);
            }
        }
    }

    @When("^I estimate quantity, price and discount for each phase in \"([^\"]*)\"$")
    public void estimate_phase(String dataKey, List<List<String>> dataTable) {
        String dataTableKey = "DelugePhaseQuotationTable";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colQty = "Qty";
        String colUnitPrice = "Unit Price";
        String colDiscPercent = "Disc Percent";
        String colDiscAmount = "Disc Amount";
        String colBudgetCost = "Budget Cost";
        String colProfitMargin = "Profit Margin";

        for (int rowDelugeEstimatetable : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colPhaseNo);
            String qty = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colQty);
            String unitPrice = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colUnitPrice);
            String discPercent = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colDiscPercent);
            String discAmount = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colDiscAmount);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colBudgetCost);
            String profitMargin = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colProfitMargin);

            if (!qty.isEmpty()) {
                projectQuotation.enter_phase_qty(phaseNo, qty);
            }
            if (!unitPrice.isEmpty()) {
                projectQuotation.enter_phase_unit_price(phaseNo, unitPrice);
            }
            if (!discPercent.isEmpty()) {
                projectQuotation.enter_phase_disc_percent(phaseNo, discPercent);
            }
            if (!discAmount.isEmpty()) {
                projectQuotation.enter_phase_disc_amount(phaseNo, discAmount);
            }
            if (!budgetCost.isEmpty()) {
                projectQuotation.enter_phase_budget_cost(phaseNo, budgetCost);
            }
            if (!profitMargin.isEmpty()) {
                projectQuotation.enter_phase_profit_margin(phaseNo, profitMargin);
            }
        }
    }

    @When("^I estimate quantity, price and discount for each phase$")
    public void estimate_phase(List<List<String>> dataTable) {
        projectQuotation.switch_to_phase_detail();
        String dataTableKey = "DelugePhaseQuotationTable";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colPhaseNo = "Phase No";
        String colQty = "Qty";
        String colUnitPrice = "Unit Price";
        String colDiscPercent = "Disc Percent";
        String colDiscAmount = "Disc Amount";
        String colBudgetCost = "Budget Cost";
        String colProfitMargin = "Profit Margin";

        for (int rowDelugeEstimatetable : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colPhaseNo);
            String qty = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colQty);
            String unitPrice = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colUnitPrice);
            String discPercent = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colDiscPercent);
            String discAmount = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colDiscAmount);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colBudgetCost);
            String profitMargin = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colProfitMargin);

            if (!qty.isEmpty()) {
                projectQuotation.enter_phase_qty(phaseNo, qty);
            }
            if (!unitPrice.isEmpty()) {
                projectQuotation.enter_phase_unit_price(phaseNo, unitPrice);
            }
            if (!discPercent.isEmpty()) {
                projectQuotation.enter_phase_disc_percent(phaseNo, discPercent);
            }
            if (!discAmount.isEmpty()) {
                projectQuotation.enter_phase_disc_amount(phaseNo, discAmount);
            }
            if (!budgetCost.isEmpty()) {
                projectQuotation.enter_phase_budget_cost(phaseNo, budgetCost);
            }
            if (!profitMargin.isEmpty()) {
                projectQuotation.enter_phase_profit_margin(phaseNo, profitMargin);
            }
        }
    }

    @When("^I change Phase Details in \"([^\"]*)\"$")
    public void change_phase_details(String dataKey, List<List<String>> dataTable) {
        String dataTableKey = "DelugeChangePhaseQuotationTable";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colAction = "Action";
        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colPhase = "Phase";
        String colQty = "Qty";
        String colUnitPrice = "Unit Price";
        String colDiscPercent = "Disc Percent";
        String colDiscAmount = "Disc Amount";
        String colBudgetCost = "Budget Cost";
        String colProfitMargin = "Profit Margin";

        for (int rowDelugeEstimatetable : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String action = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colAction);
            String project = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colPhaseNo);
            String phase = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colPhase);
            String qty = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colQty);
            String unitPrice = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colUnitPrice);
            String discPercent = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colDiscPercent);
            String discAmount = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colDiscAmount);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colBudgetCost);
            String profitMargin = SessionData.getDataTbVal(dataTableKey, rowDelugeEstimatetable, colProfitMargin);

            switch (action) {
                case "Edit":
                    if (!qty.isEmpty()) {
                        projectQuotation.enter_phase_qty(phaseNo, qty);
                    }
                    if (!unitPrice.isEmpty()) {
                        projectQuotation.enter_phase_unit_price(phaseNo, unitPrice);
                    }
                    if (!discPercent.isEmpty()) {
                        projectQuotation.enter_phase_disc_percent(phaseNo, discPercent);
                    }
                    if (!discAmount.isEmpty()) {
                        projectQuotation.enter_phase_disc_amount(phaseNo, discAmount);
                    }
                    if (!budgetCost.isEmpty()) {
                        projectQuotation.enter_phase_budget_cost(phaseNo, budgetCost);
                    }
                    if (!profitMargin.isEmpty()) {
                        projectQuotation.enter_phase_profit_margin(phaseNo, profitMargin);
                    }
                    break;
                case "Delete":
                    projectQuotation.delete_phase(phaseNo);
                    break;
                case "Add":
                    int phaseTree = phaseNo.split("\\.").length;

                    if (phaseTree == 1) {
                        projectQuotation.add_main_phase_with_desc(phaseNo, phase);
                    } else if (phaseTree > 1) {
                        projectQuotation.add_sub_phase_by_phase_no_with_desc(phaseNo, phase);
                    }
                    if (!qty.isEmpty()) {
                        projectQuotation.enter_phase_qty(phaseNo, qty);
                    }
                    if (!unitPrice.isEmpty()) {
                        projectQuotation.enter_phase_unit_price(phaseNo, unitPrice);
                    }
                    if (!discPercent.isEmpty()) {
                        projectQuotation.enter_phase_disc_percent(phaseNo, discPercent);
                    }
                    if (!discAmount.isEmpty()) {
                        projectQuotation.enter_phase_disc_amount(phaseNo, discAmount);
                    }
                    if (!budgetCost.isEmpty()) {
                        projectQuotation.enter_phase_budget_cost(phaseNo, budgetCost);
                    }
                    if (!profitMargin.isEmpty()) {
                        projectQuotation.enter_phase_profit_margin(phaseNo, profitMargin);
                    }
                    break;
            }

        }
    }

    @Then("^\"([^\"]*)\" phase detail should be as following$")
    public void phase_detail_should_be_as_following(String dataKey, List<List<String>> dataTable) {
        projectQuotation.switch_to_phase_detail();

        String dataTableKey = "DelugePhaseDetails";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colQty = "Qty";
        String colUnitPrice = "Unit Price";
        String colDiscPercent = "Disc Percent";
        String colDiscAmount = "Disc Amount";
        String colPhaseValue = "Phase Value";
        String colBudgetCost = "Budget Cost";
        String colBudgetProfit = "Budget Profit";
        String colProfitMargin = "Profit Margin";

        for (int rowDelugePhaseDetails : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colPhaseNo);
            String qty = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colQty);
            String unitPrice = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colUnitPrice);
            String discPercent = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colDiscPercent);
            String discAmount = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colDiscAmount);
            String phaseValue = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colPhaseValue);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colBudgetCost);
            String budgetProfit = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colBudgetProfit);
            String profitMargin = SessionData.getDataTbVal(dataTableKey, rowDelugePhaseDetails, colProfitMargin);

            if (!qty.isEmpty()) {
                projectQuotation.verify_phase_qty(phaseNo, qty);
            }
            if (!unitPrice.isEmpty()) {
                projectQuotation.verify_phase_unitPrice(phaseNo, unitPrice);
            }
            if (!discPercent.isEmpty()) {
                projectQuotation.verify_phase_disc_percent(phaseNo, discPercent);
            }
            if (!discAmount.isEmpty()) {
                projectQuotation.verify_phase_disc_amount(phaseNo, discAmount);
            }
            if (!phaseValue.isEmpty()) {
                projectQuotation.verify_phase_value(phaseNo, phaseValue);
            }
            if (!budgetCost.isEmpty()) {
                projectQuotation.verify_phase_budget_cost(phaseNo, budgetCost);
            }
            if (!budgetProfit.isEmpty()) {
                projectQuotation.verify_phase_budget_profit(phaseNo, budgetProfit);
            }
            if (!profitMargin.isEmpty()) {
                projectQuotation.verify_phase_profit_margin(phaseNo, profitMargin);
            }
        }
    }

    @Given("^I want to create a new quotation for \"([^\"]*)\"$")
    public void i_want_to_create_a_new_quotation_for(String dataKey, List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Operations>Project>Project Quotation>[2]");

        projectQuotation.click_add_new_button_on_functional_panel();

        String dataTableKey = "Project";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colCustomer = "Customer";
        String colQuotationDate = "Quotation Date";
        String colCurrency = "Currency";
        String colExchangeRate = "Exchange Rate";
        String colSalesTax = "Sales Tax";

        for (int rowProject : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowProject, colProject);
            String customer = SessionData.getDataTbVal(dataTableKey, rowProject, colCustomer);
            String quotationDate = SessionData.getDataTbVal(dataTableKey, rowProject, colQuotationDate);
            String currency = SessionData.getDataTbVal(dataTableKey, rowProject, colCurrency);
            String exchangeRate = SessionData.getDataTbVal(dataTableKey, rowProject, colExchangeRate);
            String salesTax = SessionData.getDataTbVal(dataTableKey, rowProject, colSalesTax);


            if (!project.isEmpty()) {
                projectQuotation.enter_project(project);
            }

            if (!customer.isEmpty()) {
                projectQuotation.enter_customer_code(customer);
            }

            if (!quotationDate.isEmpty()) {
                projectQuotation.enter_quotation_date(quotationDate);
            }

            if (!currency.isEmpty()) {
                projectQuotation.enter_currency(currency);
            }

            if (!exchangeRate.isEmpty()) {
                projectQuotation.enter_exchange_rate(exchangeRate);
            }

            if (!salesTax.isEmpty()) {
                projectQuotation.enter_sales_tax(salesTax);
            }
        }
    }

    @When("^I add Cost Item in phases in \"([^\"]*)\"$")
    public void i_add_Cost_Item_to_phases_in(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_costing_sheet();

        String dataTableKey = "CostItem";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colDrawingObjectNo = "Drawing Object No";
        String colType = "Type";
        String colDrawingObject = "Drawing Object";
        String colItemCodeDescription = "Item Code Description";
        String colDrawingQty = "Drawing Qty";
        String colEstWastage = "Est. Wastage %";
        String colItemBudgetQty = "Item Budget>Qty";
        String colItemBudgetUnitCost = "Item Budget>Unit Cost";
        String colItemBudgetMarkup = "Item Budget>Markup %";
        String colLabourBudgetQty = "Labour Budget>Qty";
        String colLabourBudgetUnitCost = "Labour Budget>Unit Cost";
        String colLabourBudgetMarkup = "Labour Budget>Markup %";

        for (int rowCostItem : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowCostItem, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colPhaseNo);
            String drawingObjectNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObjectNo);
            String type = SessionData.getDataTbVal(dataTableKey, rowCostItem, colType);
            String drawingObject = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObject);
            String itemCodeDescription = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemCodeDescription);
            String drawingQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingQty);
            String estWastage = SessionData.getDataTbVal(dataTableKey, rowCostItem, colEstWastage);
            String itemBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetQty);
            String itemBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetUnitCost);
            String itemBudgetMarkup = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetMarkup);
            String labourBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetQty);
            String labourBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetUnitCost);
            String labourBudgetMarkup = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetMarkup);

            if (!phaseNo.isEmpty() && !projectQuotation.active_phase_in_costing_sheet().contentEquals(phaseNo)) {
                projectQuotation.select_phase_on_costing_sheet(phaseNo);
            }

            projectQuotation.click_add_cost_item_btn();

            if (!type.isEmpty()) {
                projectQuotation.select_type_for_last_cost_item(type);
            }
            if (!drawingObject.isEmpty()) {
                projectQuotation.select_drawing_object_for_last_cost_item(drawingObject);
            }
            if (!itemCodeDescription.isEmpty()) {
                projectQuotation.select_code_description_for_last_cost_item(itemCodeDescription);
            }
            if (!drawingQty.isEmpty()) {
                projectQuotation.enter_drawing_qty_for_last_cost_item(drawingQty);
            }
            if (!estWastage.isEmpty()) {
                projectQuotation.enter_wastage_for_last_cost_item(estWastage);
            }
            if (!itemBudgetQty.isEmpty()) {
                projectQuotation.enter_item_budget_qty_for_last_cost_item(itemBudgetQty);
            }
            if (!itemBudgetUnitCost.isEmpty()) {
                projectQuotation.enter_item_budget_unit_cost_for_last_cost_item(itemBudgetUnitCost);
            }
            if (!itemBudgetMarkup.isEmpty()) {
                projectQuotation.enter_item_budget_markup_for_last_cost_item(itemBudgetMarkup);
            }
            if (!labourBudgetQty.isEmpty()) {
                projectQuotation.enter_labour_qty_for_last_cost_item(labourBudgetQty);
            }
            if (!labourBudgetUnitCost.isEmpty()) {
                projectQuotation.enter_labour_unit_cost_for_last_cost_item(labourBudgetUnitCost);
            }
            if (!labourBudgetMarkup.isEmpty()) {
                projectQuotation.enter_labour_markup_for_last_cost_item(labourBudgetMarkup);
            }
        }
    }

    @When("^I add Cost Item in phases$")
    public void i_add_Cost_Item_to_phases_in(List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_costing_sheet();

        String dataTableKey = "CostItem";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colPhaseNo = "Phase No";
        String colDrawingObjectNo = "Drawing Object No";
        String colType = "Type";
        String colDrawingObject = "Drawing Object";
        String colItemCodeDescription = "Item Code Description";
        String colDrawingQty = "Drawing Qty";
        String colEstWastage = "Est. Wastage %";
        String colItemBudgetQty = "Item Budget>Qty";
        String colItemBudgetUnitCost = "Item Budget>Unit Cost";
        String colItemBudgetMarkup = "Item Budget>Markup %";
        String colLabourBudgetQty = "Labour Budget>Qty";
        String colLabourBudgetUnitCost = "Labour Budget>Unit Cost";
        String colLabourBudgetMarkup = "Labour Budget>Markup %";

        for (int rowCostItem : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colPhaseNo);
            String drawingObjectNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObjectNo);
            String type = SessionData.getDataTbVal(dataTableKey, rowCostItem, colType);
            String drawingObject = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObject);
            String itemCodeDescription = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemCodeDescription);
            String drawingQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingQty);
            String estWastage = SessionData.getDataTbVal(dataTableKey, rowCostItem, colEstWastage);
            String itemBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetQty);
            String itemBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetUnitCost);
            String itemBudgetMarkup = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetMarkup);
            String labourBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetQty);
            String labourBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetUnitCost);
            String labourBudgetMarkup = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetMarkup);

            if (!phaseNo.isEmpty() && !projectQuotation.active_phase_in_costing_sheet().contentEquals(phaseNo)) {
                projectQuotation.select_phase_on_costing_sheet(phaseNo);
            }

            projectQuotation.click_add_cost_item_btn();

            if (!type.isEmpty()) {
                projectQuotation.select_type_for_last_cost_item(type);
            }
            if (!drawingObject.isEmpty()) {
                projectQuotation.select_drawing_object_for_last_cost_item(drawingObject);
            }
            if (!itemCodeDescription.isEmpty()) {
                projectQuotation.select_code_description_for_last_cost_item(itemCodeDescription);
            }
            if (!drawingQty.isEmpty()) {
                projectQuotation.enter_drawing_qty_for_last_cost_item(drawingQty);
            }
            if (!estWastage.isEmpty()) {
                projectQuotation.enter_wastage_for_last_cost_item(estWastage);
            }
            if (!itemBudgetQty.isEmpty()) {
                projectQuotation.enter_item_budget_qty_for_last_cost_item(itemBudgetQty);
            }
            if (!itemBudgetUnitCost.isEmpty()) {
                projectQuotation.enter_item_budget_unit_cost_for_last_cost_item(itemBudgetUnitCost);
            }
            if (!itemBudgetMarkup.isEmpty()) {
                projectQuotation.enter_item_budget_markup_for_last_cost_item(itemBudgetMarkup);
            }
            if (!labourBudgetQty.isEmpty()) {
                projectQuotation.enter_labour_qty_for_last_cost_item(labourBudgetQty);
            }
            if (!labourBudgetUnitCost.isEmpty()) {
                projectQuotation.enter_labour_unit_cost_for_last_cost_item(labourBudgetUnitCost);
            }
            if (!labourBudgetMarkup.isEmpty()) {
                projectQuotation.enter_labour_markup_for_last_cost_item(labourBudgetMarkup);
            }
        }
    }

    @When("^I change Cost Item in phases in \"([^\"]*)\"$")
    public void i_change_Cost_Item_to_phases_in(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_costing_sheet();

        String dataTableKey = "EditCostItem";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colAction = "Action";
        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colDrawingObjectNo = "Drawing Object No";
        String colType = "Type";
        String colDrawingObject = "Drawing Object";
        String colItemCodeDescription = "Item Code Description";
        String colDrawingQty = "Drawing Qty";
        String colEstWastage = "Est. Wastage %";
        String colItemBudgetQty = "Item Budget>Qty";
        String colItemBudgetUnitCost = "Item Budget>Unit Cost";
        String colItemBudgetMarkup = "Item Budget>Markup %";
        String colLabourBudgetQty = "Labour Budget>Qty";
        String colLabourBudgetUnitCost = "Labour Budget>Unit Cost";
        String colLabourBudgetMarkup = "Labour Budget>Markup %";

        for (int rowCostItem : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String action = SessionData.getDataTbVal(dataTableKey, rowCostItem, colAction);
            String project = SessionData.getDataTbVal(dataTableKey, rowCostItem, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colPhaseNo);
            String drawingObjectNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObjectNo);
            String type = SessionData.getDataTbVal(dataTableKey, rowCostItem, colType);
            String drawingObject = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObject);
            String itemCodeDescription = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemCodeDescription);
            String drawingQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingQty);
            String estWastage = SessionData.getDataTbVal(dataTableKey, rowCostItem, colEstWastage);
            String itemBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetQty);
            String itemBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetUnitCost);
            String itemBudgetMarkup = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetMarkup);
            String labourBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetQty);
            String labourBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetUnitCost);
            String labourBudgetMarkup = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetMarkup);

            if (!phaseNo.isEmpty() && !projectQuotation.active_phase_in_costing_sheet().contentEquals(phaseNo)) {
                projectQuotation.select_phase_on_costing_sheet(phaseNo);
            }

            if (action.isEmpty() || action.contentEquals("Add")) {
                projectQuotation.click_add_cost_item_btn();

                if (!type.isEmpty()) {
                    projectQuotation.select_type_for_last_cost_item(type);
                }

                if (!drawingObject.isEmpty()) {
                    projectQuotation.select_drawing_object_for_last_cost_item(drawingObject);
                }

                if (!itemCodeDescription.isEmpty()) {
                    projectQuotation.select_code_description_for_last_cost_item(itemCodeDescription);
                }

                if (!drawingQty.isEmpty()) {
                    projectQuotation.enter_drawing_qty_for_last_cost_item(drawingQty);
                }

                if (!estWastage.isEmpty()) {
                    projectQuotation.enter_wastage_for_last_cost_item(estWastage);
                }

                if (!itemBudgetQty.isEmpty()) {
                    projectQuotation.enter_item_budget_qty_for_last_cost_item(itemBudgetQty);
                }
                if (!itemBudgetUnitCost.isEmpty()) {
                    projectQuotation.enter_item_budget_unit_cost_for_last_cost_item(itemBudgetUnitCost);
                }

                if (!itemBudgetMarkup.isEmpty()) {
                    projectQuotation.enter_item_budget_markup_for_last_cost_item(itemBudgetMarkup);
                }

                if (!labourBudgetQty.isEmpty()) {
                    projectQuotation.enter_labour_qty_for_last_cost_item(labourBudgetQty);
                }

                if (!labourBudgetUnitCost.isEmpty()) {
                    projectQuotation.enter_labour_unit_cost_for_last_cost_item(labourBudgetUnitCost);
                }

                if (!labourBudgetMarkup.isEmpty()) {
                    projectQuotation.enter_labour_markup_for_last_cost_item(labourBudgetMarkup);
                }
            } else if (action.contentEquals("Delete")) {
                projectQuotation.delete_costing_item(drawingObjectNo);
            } else if (action.contentEquals("Edit")) {
                if (!type.isEmpty()) {
                    projectQuotation.select_type_by_cost_item(drawingObjectNo, type);
                }

                if (!drawingObject.isEmpty()) {
                    projectQuotation.select_drawing_object_by_cost_item(drawingObjectNo, drawingObject);
                }

                if (!itemCodeDescription.isEmpty()) {
                    projectQuotation.select_code_description_by_cost_item(drawingObjectNo, itemCodeDescription);
                }

                if (!drawingQty.isEmpty()) {
                    projectQuotation.enter_drawing_qty_by_cost_item(drawingObjectNo, drawingQty);
                }

                if (!estWastage.isEmpty()) {
                    projectQuotation.enter_wastage_by_cost_item(drawingObjectNo, estWastage);
                }

                if (!itemBudgetQty.isEmpty()) {
                    projectQuotation.enter_item_budget_qty_by_cost_item(drawingObjectNo, itemBudgetQty);
                }
                if (!itemBudgetUnitCost.isEmpty()) {
                    projectQuotation.enter_item_budget_unit_cost_by_cost_item(drawingObjectNo, itemBudgetUnitCost);
                }

                if (!itemBudgetMarkup.isEmpty()) {
                    projectQuotation.enter_item_budget_markup_by_cost_item(drawingObjectNo, itemBudgetMarkup);
                }

                if (!labourBudgetQty.isEmpty()) {
                    projectQuotation.enter_labour_qty_by_cost_item(drawingObjectNo, labourBudgetQty);
                }

                if (!labourBudgetUnitCost.isEmpty()) {
                    projectQuotation.enter_labour_unit_cost_by_cost_item(drawingObjectNo, labourBudgetUnitCost);
                }

                if (!labourBudgetMarkup.isEmpty()) {
                    projectQuotation.enter_labour_markup_by_cost_item(drawingObjectNo, labourBudgetMarkup);
                }
            }
        }
    }


    @Then("^The Costing Sheet in \"([^\"]*)\" should be calculated as following$")
    public void the_costing_sheet_in_should_be_calculated_as_following(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_costing_sheet();

        String dataTableKey = "CostItemVerify";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colDrawingObjectNo = "Drawing Object No";
        String colItemBudgetQty = "Item Budget>Qty";
        String colItemBudgetUnitCost = "Item Budget>Unit Cost";
        String colLabourBudgetQty = "Labour Budget>Qty";
        String colBudgetCost = "Budget Cost";

        for (int rowCostItem : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowCostItem, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colPhaseNo);
            String drawingObjectNo = SessionData.getDataTbVal(dataTableKey, rowCostItem, colDrawingObjectNo);
            String itemBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetQty);
            String itemBudgetUnitCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colItemBudgetUnitCost);
            String labourBudgetQty = SessionData.getDataTbVal(dataTableKey, rowCostItem, colLabourBudgetQty);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowCostItem, colBudgetCost);

            if (!phaseNo.isEmpty()) {
                projectQuotation.select_phase_on_costing_sheet(phaseNo);
            }
            if (!itemBudgetQty.isEmpty()) {
                projectQuotation.assert_item_budget_qty(drawingObjectNo, itemBudgetQty);
            }
            if (!itemBudgetUnitCost.isEmpty()) {
                projectQuotation.assert_item_budget_unit_cost(drawingObjectNo, itemBudgetUnitCost);
            }
            if (!labourBudgetQty.isEmpty()) {
                projectQuotation.assert_labour_budget_qty(drawingObjectNo, labourBudgetQty);
            }
            if (!budgetCost.isEmpty()) {
                projectQuotation.assert_budget_cost(drawingObjectNo, budgetCost);
            }
        }
    }

    @Then("^\"([^\"]*)\" phase budget profit in Costing Sheet Tree should be as following$")
    public void phase_budget_profit_in_Costing_Sheet_Tree_should_be_as_following(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_costing_sheet();

        String dataTableKey = "CostingSheetTree";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colPhaseNo = "Phase No";
        String colBudgetCostInCostingSheetTree = "Budget Cost in Costing Sheet Tree";

        for (int rowCostingSheetTree : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowCostingSheetTree, colProject);
            String phaseNo = SessionData.getDataTbVal(dataTableKey, rowCostingSheetTree, colPhaseNo);
            String budgetCostInCostingSheetTree = SessionData.getDataTbVal(dataTableKey, rowCostingSheetTree, colBudgetCostInCostingSheetTree);

            projectQuotation.verify_budget_cost_in_costing_tree(phaseNo, budgetCostInCostingSheetTree);
        }


    }

    @Then("^Quotation Summary in \"([^\"]*)\" is as following$")
    public void quotation_Summary_in_is_as_following(String dataKey, List<List<String>> dataTable) throws Throwable {
        if (!projectQuotation.detail_state().contentEquals("PhaseDetail")) {
            projectQuotation.switch_to_phase_detail();
        }

        String dataTableKey = "QuotationSummary";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colTitle = "Title";
        String colNature = "Nature";
        String colHome = "Home";

        for (int rowQuotationSummary : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowQuotationSummary, colProject);
            String title = SessionData.getDataTbVal(dataTableKey, rowQuotationSummary, colTitle);
            String nature = SessionData.getDataTbVal(dataTableKey, rowQuotationSummary, colNature);
            String home = SessionData.getDataTbVal(dataTableKey, rowQuotationSummary, colHome);

            switch (title) {
                case "Exchange Rate":
                    if (!home.isEmpty()) {
                        projectQuotation.verify_exchange_rate(home);
                    }
                    break;

                case "Project Sum":
                    if (!nature.isEmpty()) {
                        projectQuotation.verify_project_sum_nature(nature);
                    }
                    if (!home.isEmpty()) {
                        projectQuotation.verify_project_sum_home(home);
                    }
                    break;

                case "Project Budget Cost":
                    if (!nature.isEmpty()) {
                        projectQuotation.verify_project_budget_cost_nature(nature);
                    }
                    if (!home.isEmpty()) {
                        projectQuotation.verify_project_budget_cost_home(home);
                    }
                    break;
                case "Project Budget Profit Percent":
                    if (!nature.isEmpty()) {
                        projectQuotation.project_budget_profit_percent(nature);
                    }
                    break;

                case " Project Budget Profit":
                    if (!nature.isEmpty()) {
                        projectQuotation.verify_project_budget_profit_nature(nature);
                    }
                    if (!home.isEmpty()) {
                        projectQuotation.verify_project_budget_profit_home(home);
                    }
                    break;

                case "Sales Tax":
                    if (!nature.isEmpty()) {
                        projectQuotation.verify_sales_tax_nature(nature);
                    }
                    if (!home.isEmpty()) {
                        projectQuotation.verify_sales_tax_home(home);
                    }
                    break;

                case "Project Value incl. Tax":
                    if (!nature.isEmpty()) {
                        projectQuotation.verify_project_value_nature(nature);
                    }
                    if (!home.isEmpty()) {
                        projectQuotation.verify_project_value_home(home);
                    }
                    break;

            }
        }
    }

    @Then("^Workhead Groups in \"([^\"]*)\" are grouped as$")
    public void workhead_Groups_in_are_grouped_as(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_brand_comparison();

        String dataTableKey = "WorkheadGroups";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colWorkheadGroups = "Workhead Groups";
        String colBudgetCost = "Budget Cost";

        for (int rowWorkheadGroups : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowWorkheadGroups, colProject);
            String workheadGroups = SessionData.getDataTbVal(dataTableKey, rowWorkheadGroups, colWorkheadGroups);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowWorkheadGroups, colBudgetCost);

            if (!workheadGroups.contentEquals("Total")) {
                projectQuotation.verify_workdead_groups(workheadGroups, budgetCost);
            } else {
                projectQuotation.verify_total_budget_cost_workhead_groups(budgetCost);
            }
        }
    }

    @Then("^Cost Item Groups in \"([^\"]*)\" are grouped as$")
    public void cost_Item_Groups_in_are_grouped_as(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_brand_comparison();

        String dataTableKey = "CostItemGroups";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colWorkheadGroups = "Workhead Groups";
        String colCostItemGroup = "Cost Item Group";
        String colSelectedBrands = "Selected Brands";
        String colBudgetCost = "Budget Cost";

        for (int rowCostItemGroups : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowCostItemGroups, colProject);
            String workheadGroups = SessionData.getDataTbVal(dataTableKey, rowCostItemGroups, colWorkheadGroups);
            String costItemGroup = SessionData.getDataTbVal(dataTableKey, rowCostItemGroups, colCostItemGroup);
            String selectedBrands = SessionData.getDataTbVal(dataTableKey, rowCostItemGroups, colSelectedBrands);
            String budgetCost = SessionData.getDataTbVal(dataTableKey, rowCostItemGroups, colBudgetCost);

            if (!workheadGroups.isEmpty()) {
                projectQuotation.click_workhead_group(workheadGroups);
            }

            if(costItemGroup.contentEquals("Total")){
                if (!budgetCost.isEmpty()) {
                    projectQuotation.verify_total_in_cost_item_groups(budgetCost);
                }
            } else{
                if (!selectedBrands.isEmpty()) {
                    projectQuotation.verify_selected_brands_in_cost_item_group(costItemGroup, selectedBrands);
                }
                if (!budgetCost.isEmpty()) {
                    projectQuotation.verify_budget_cost_in_cost_item_group(costItemGroup, budgetCost);
                }
            }
        }

    }

    @Then("^Brand Comparison in \"([^\"]*)\" as$")
    public void brand_Comparison_in_are_grouped_as(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_brand_comparison();

        String dataTableKey = "BrandComparison";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colWorkheadGroups = "Workhead Groups";
        String colCostItemGroup = "Cost Item Group";
        String colDrawingObject = "Drawing Object";
        String colQty = "Qty";
        String colBrand = "Brand";
        String colSupplier = "Supplier";
        String colCostPrice = "Cost Price";

        for (int rowBrandComparison : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colProject);
            String workheadGroups = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colWorkheadGroups);
            String costItemGroup = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colCostItemGroup);
            String drawingObject = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colDrawingObject);
            String qty = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colQty);
            String brand = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colBrand);
            String supplier = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colSupplier);
            String costPrice = SessionData.getDataTbVal(dataTableKey, rowBrandComparison, colCostPrice);

            if (!workheadGroups.isEmpty()) {
                projectQuotation.click_workhead_group(workheadGroups);
            }
            if (!costItemGroup.isEmpty()) {
                projectQuotation.click_cost_item_group(costItemGroup);
            }
            if (!qty.isEmpty()) {
                projectQuotation.verify_quantity_in_brand_comparison(drawingObject, qty);
            }
            if (drawingObject.contentEquals("Total")) {
                projectQuotation.verify_total_in_brand_comparison(brand, supplier, costPrice);
            } else {
                projectQuotation.verify_unit_cost_in_brand_comparison(drawingObject, brand, supplier, costPrice);
            }
        }
    }


    @When("^I select supplier for Drawing Object in \"([^\"]*)\" as$")
    public void i_select_supplier_for_drawing_object_in_as(String dataKey, List<List<String>> dataTable) throws Throwable {
        projectQuotation.switch_to_brand_comparison();

        String dataTableKey = "SelectSupplier";
        SessionData.addDataTable(dataTableKey, dataTable, false);

        String colProject = "PROJECT";
        String colWorkheadGroups = "Workhead Groups";
        String colCostItemGroup = "Cost Item Group";
        String colDrawingObject = "Drawing Object";
        String colBrand = "Brand";
        String colSupplier = "Supplier";

        for (int rowSelectSupplier : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colProject, dataKey).keySet()) {
            String project = SessionData.getDataTbVal(dataTableKey, rowSelectSupplier, colProject);
            String workheadGroups = SessionData.getDataTbVal(dataTableKey, rowSelectSupplier, colWorkheadGroups);
            String costItemGroup = SessionData.getDataTbVal(dataTableKey, rowSelectSupplier, colCostItemGroup);
            String drawingObject = SessionData.getDataTbVal(dataTableKey, rowSelectSupplier, colDrawingObject);
            String brand = SessionData.getDataTbVal(dataTableKey, rowSelectSupplier, colBrand);
            String supplier = SessionData.getDataTbVal(dataTableKey, rowSelectSupplier, colSupplier);

            if (!workheadGroups.isEmpty()) {
                projectQuotation.click_workhead_group(workheadGroups);
            }
            if (!costItemGroup.isEmpty()) {
                projectQuotation.click_cost_item_group(costItemGroup);
            }

            projectQuotation.select_supplier_for_cost_item(drawingObject, brand, supplier);
            projectQuotation.save_selected_supplers();
        }


    }


    @Given("^user is logged in to TaskHub System AUTO1 as Ian$")
    public void user_is_logged_in_task_tub_system_auto1() throws Throwable {
        loginStep.page_is_visited("http://172.18.0.21:9080/TH6/index.xhtml");
        loginStep.loginAs("ian.do").selectCompany("AUTO1").withPassword("taskhub").login();
    }

    @When("^I abort the quotation$")
    public void i_abort_the_quotation() throws Throwable {
        projectQuotation.abort_quotation();
    }

    @And("^I submit the quotation$")
    public void iSubmitTheQuotation() throws Throwable {
        projectQuotation.save_quotation_code();
        projectQuotation.submit_quotation();
    }
}
