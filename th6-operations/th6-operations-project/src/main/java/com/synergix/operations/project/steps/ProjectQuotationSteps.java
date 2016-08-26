package com.synergix.operations.project.steps;

import com.synergix.operations.project.pages.ProjectQuotationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Ian on 7/27/2016.
 */
public class ProjectQuotationSteps extends ScenarioSteps {

    public ProjectQuotationPage onProjectQuotation;

    @Step
    public void click_add_new_button_on_functional_panel() {
        onProjectQuotation.clickAddNewButtonOnFunctionalPanel();
    }

    @Step
    public void select_project_quotation_number_key(String number_key) {
        onProjectQuotation.selectProjectQuotationNumberKey(number_key);
    }

    @Step
    public void enter_customer_code(String customerCode) {
        onProjectQuotation.enterCustomerCode(customerCode);
    }

    @Step
    public void add_main_phase_with_desc(String phaseNo, String phase) {
        onProjectQuotation.clickAddMainPhaseButton();

    }

    @Step
    public void enter_phase_desc(String phaseNo, String phase) {
        int phaseTree = phaseNo.split("\\.").length;
        if (phaseTree == 1) {
            onProjectQuotation.enterPhaseDesc(phaseNo, phase);
        } else {
            String parentPhase = onProjectQuotation.parentPhaseFromPhase(phaseNo);
            if (onProjectQuotation.ifPhaseIsExpand(parentPhase)) {
                onProjectQuotation.enterPhaseDesc(phaseNo, phase);
            } else {
                onProjectQuotation.expandPhaseRow(parentPhase);
                onProjectQuotation.enterPhaseDesc(phaseNo, phase);
            }
        }
    }

    @Step
    public void select_workhead_group(String phaseNo, String workheadGroup) {
        int phaseTree = phaseNo.split("\\.").length;
        if (phaseTree == 1) {
            onProjectQuotation.enterPhaseWorkheadGroup(phaseNo, workheadGroup);
        } else {
            String parentPhase = onProjectQuotation.parentPhaseFromPhase(phaseNo);
            if (onProjectQuotation.ifPhaseIsExpand(parentPhase)) {
                onProjectQuotation.enterPhaseWorkheadGroup(phaseNo, workheadGroup);
            } else {
                onProjectQuotation.enterPhaseWorkheadGroup(phaseNo, workheadGroup);
            }
        }
    }

    @Step
    public void delete_phase(String phaseNo) {
        onProjectQuotation.deletePhaseRow(phaseNo);
        onProjectQuotation.chooseYesOnUpdateConfirmation();
    }

    @Step
    public void add_sub_phase_by_phase_no_with_desc(String phaseNo, String phase) {
        String parentPhase = onProjectQuotation.parentPhaseFromPhase(phaseNo);
        onProjectQuotation.addSubPhaseInPhaseRow(parentPhase);
    }

    @Step
    public void enter_phase_qty(String phaseNo, String qty) {
        onProjectQuotation.enterPhaseQuantity(phaseNo, qty);
    }

    @Step
    public void enter_phase_unit_price(String phaseNo, String unitPrice) {
        onProjectQuotation.enterPhaseUnitPrice(phaseNo, unitPrice);
    }

    @Step
    public void enter_phase_disc_percent(String phaseNo, String discPercent) {
        onProjectQuotation.enterPhaseDiscPercent(phaseNo, discPercent);
    }

    @Step
    public void enter_phase_disc_amount(String phaseNo, String discAmount) {
        onProjectQuotation.enterPhaseDiscAmount(phaseNo, discAmount);
    }

    @Step
    public void enter_phase_budget_cost(String phaseNo, String budgetCost) {
        onProjectQuotation.enterPhaseBudgetCost(phaseNo, budgetCost);
    }

    @Step
    public void enter_phase_profit_margin(String phaseNo, String profitMargin) {
        onProjectQuotation.enterPhaseProfitMargin(phaseNo, profitMargin);
    }

    @Step
    public void verify_phase_qty(String phaseNo, String qty) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseQty(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(qty));
    }

    @Step
    public void verify_phase_unitPrice(String phaseNo, String unitPrice) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseUnitPrice(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(unitPrice));
    }

    @Step
    public void verify_phase_disc_percent(String phaseNo, String discPercent) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseDiscPercent(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(discPercent));
    }

    @Step
    public void verify_phase_disc_amount(String phaseNo, String discAmount) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseDiscAmount(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(discAmount));
    }

    @Step
    public void verify_phase_value(String phaseNo, String phaseValue) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseValue(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(phaseValue));
    }

    @Step
    public void verify_phase_budget_cost(String phaseNo, String budgetCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseBudgetCost(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(budgetCost));
    }

    @Step
    public void verify_phase_budget_profit(String phaseNo, String budgetProfit) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseBudgetProfit(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(budgetProfit));
    }

    @Step
    public void verify_phase_profit_margin(String phaseNo, String profitMargin) {
        assertThat(Float.parseFloat(onProjectQuotation.getPhaseProfitMargin(phaseNo).replaceAll("%", "").replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(profitMargin));
    }

    @Step
    public void switch_to_costing_sheet() {
        if (detail_state().contentEquals("CostingSheet")) {

        } else if (!detail_state().contentEquals("PhaseDetail")) {
            onProjectQuotation.clickBackPhaseDetailsBtn();
            onProjectQuotation.clickCostingSheetBtn();
        } else {
            onProjectQuotation.clickCostingSheetBtn();
        }

    }

    @Step
    public void add_main_phase() {
        onProjectQuotation.clickAddMainPhaseButton();
    }

    @Step
    public void select_phase_on_costing_sheet(String phaseNo) {
        onProjectQuotation.clickPhaseOnCostingSheetTree(phaseNo);
    }

    @Step
    public void search_quotation_number(String projectNumber) {
        onProjectQuotation.search_project_number_in_draft(projectNumber);
    }

    @Step
    public void click_quotation(String quotationNumber) {
        onProjectQuotation.openQuotation(quotationNumber);
    }

    @Step
    public void click_workhead_group(String workHeadGroup) {
        onProjectQuotation.clickWorkheadGroup(workHeadGroup);
    }

    @Step
    public void click_cost_item_group(String costItemGroup) {
        onProjectQuotation.clickCostItemGroup(costItemGroup);
    }

    @Step
    public void select_supplier_for_cost_item(String itemCost, String brand, String supplier) {
        onProjectQuotation.selectSupplierForCostItem(itemCost, brand, supplier);
    }

    @Step
    public void enter_project(String project) {
        onProjectQuotation.enterProject(project);
    }

    @Step
    public void enter_quotation_date(String quotationDate) {
        onProjectQuotation.enterQuotationDate(quotationDate);
    }

    @Step
    public void enter_currency(String currency) {
        onProjectQuotation.enterCurrency(currency);
    }

    @Step
    public void enter_exchange_rate(String exchangeRate) {
        onProjectQuotation.enterExchangeRate(exchangeRate);
    }

    @Step
    public void enter_sales_tax(String salesTax) {
        onProjectQuotation.enterSalesTax(salesTax);
    }

    @Step
    public String active_phase_in_costing_sheet() {
        return onProjectQuotation.getActivePhaseInCostingSheet();
    }

    @Step
    public void click_add_cost_item_btn() {
        onProjectQuotation.clickAddCostItem();
    }

    @Step
    public void select_type_for_last_cost_item(String type) {
        onProjectQuotation.selectTypeForLastCostItem(type);
    }

    @Step
    public void select_drawing_object_for_last_cost_item(String drawingObject) {
        onProjectQuotation.selectDrawingObjectForLastCostItem(drawingObject);
    }

    @Step
    public void select_code_description_for_last_cost_item(String itemCodeDescription) {
        onProjectQuotation.selectCodeDescriptionForLastCostItem(itemCodeDescription);
    }

    @Step
    public void enter_drawing_qty_for_last_cost_item(String drawingQty) {
        onProjectQuotation.enterDrawingQtyForLastCostItem(drawingQty);
    }

    @Step
    public void enter_wastage_for_last_cost_item(String estWastage) {
        onProjectQuotation.enterWastageForLastCostItem(estWastage);
    }

    @Step
    public void enter_item_budget_unit_cost_for_last_cost_item(String itemBudgetUnitCost) {
        onProjectQuotation.enterItemBudgetUnitCostForLastCostItem(itemBudgetUnitCost);
    }

    @Step
    public void enter_item_budget_markup_for_last_cost_item(String itemBudgetMarkup) {
        onProjectQuotation.enterItemBudgetMarkupForLastCostItem(itemBudgetMarkup);
    }

    @Step
    public void enter_labour_qty_for_last_cost_item(String labourBudgetQty) {
        onProjectQuotation.enterLabourQtyForLastCostItem(labourBudgetQty);
    }

    @Step
    public void enter_labour_unit_cost_for_last_cost_item(String labourBudgetUnitCost) {
        onProjectQuotation.enterLabourUnitCostForLastCostItem(labourBudgetUnitCost);
    }

    @Step
    public void enter_labour_markup_for_last_cost_item(String labourBudgetMarkup) {
        onProjectQuotation.enterLabourMarkupForLastCostItem(labourBudgetMarkup);
    }

    @Step
    public void assert_item_budget_qty(String phaseNo, String itemBudgetQty) {
        assertThat(Integer.parseInt(onProjectQuotation.getItemBudgetQty(phaseNo).replaceAll(",", ""))).isEqualTo(Integer.parseInt(itemBudgetQty));
    }

    @Step
    public void assert_item_budget_unit_cost(String phaseNo, String itemBudgetUnitCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getItemBudgetUnitCost(phaseNo).replaceAll(",", ""))).isEqualTo(Float.parseFloat(itemBudgetUnitCost));
    }

    @Step
    public void assert_labour_budget_qty(String phaseNo, String labourBudgetQty) {
        assertThat(Integer.parseInt(onProjectQuotation.getLabourBudgetQty(phaseNo).replaceAll(",", ""))).isEqualTo(Integer.parseInt(labourBudgetQty));
    }

    @Step
    public void assert_budget_cost(String phaseNo, String budgetCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getBudgetCost(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(budgetCost));
    }

    @Step
    public void verify_budget_cost_in_costing_tree(String phaseNo, String budgetCostInCostingSheetTree) {
        assertThat(Float.parseFloat(onProjectQuotation.getBudgetCostInCostingTree(phaseNo).replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(budgetCostInCostingSheetTree));
    }

    @Step
    public void verify_exchange_rate(String exchangeRate) {
        assertThat(Float.parseFloat(onProjectQuotation.getExchangeRate().replaceAll(",", ""))).isEqualTo(Float.parseFloat(exchangeRate));
    }

    @Step
    public void verify_project_sum_nature(String nature) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectSumNature().replaceAll(",", ""))).isEqualTo(Float.parseFloat(nature));
    }

    @Step
    public void verify_project_sum_home(String home) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectSumHome().replaceAll(",", ""))).isEqualTo(Float.parseFloat(home));
    }

    @Step
    public void verify_project_budget_cost_nature(String nature) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectBudgetCostNature().replaceAll(",", ""))).isEqualTo(Float.parseFloat(nature));
    }

    @Step
    public void verify_project_budget_cost_home(String home) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectBudgetCostHome().replaceAll(",", ""))).isEqualTo(Float.parseFloat(home));
    }

    @Step
    public void project_budget_profit_percent(String percent) {
        assertThat(Float.parseFloat(onProjectQuotation.getBudgetProfitPercent().replaceAll(",", ""))).isEqualTo(Float.parseFloat(percent));
    }

    @Step
    public void verify_project_budget_profit_nature(String nature) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectBudgetProfitNature().replaceAll(",", ""))).isEqualTo(Float.parseFloat(nature));
    }

    @Step
    public void verify_project_budget_profit_home(String home) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectBudgetProfitHome().replaceAll(",", ""))).isEqualTo(Float.parseFloat(home));
    }

    @Step
    public void verify_sales_tax_nature(String nature) {
        assertThat(Float.parseFloat(onProjectQuotation.getSalesTaxNature().replaceAll(",", ""))).isEqualTo(Float.parseFloat(nature));
    }

    @Step
    public void verify_sales_tax_home(String home) {
        assertThat(Float.parseFloat(onProjectQuotation.getSalesTaxHome().replaceAll(",", ""))).isEqualTo(Float.parseFloat(home));
    }

    @Step
    public void verify_project_value_nature(String nature) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectValueNature().replaceAll(",", ""))).isEqualTo(nature);
    }

    @Step
    public void verify_project_value_home(String home) {
        assertThat(Float.parseFloat(onProjectQuotation.getProjectValueHome().replaceAll(",", ""))).isEqualTo(Float.parseFloat(home));
    }

    @Step
    public String detail_state() {
        return onProjectQuotation.getDetailTabState();
    }

    @Step
    public void switch_to_phase_detail() {
        if (detail_state().contentEquals("PhaseDetail")) {

        } else {
            onProjectQuotation.clickBackPhaseDetailsBtn();
        }
    }

    @Step
    public void switch_to_brand_comparison() {
        if (detail_state().contentEquals("BrandsComparison")) {

        } else if (!detail_state().contentEquals("PhaseDetail")) {
            switch_to_phase_detail();
            onProjectQuotation.clickBrandComparisonBtn();
        } else {
            onProjectQuotation.clickBrandComparisonBtn();
        }
    }

    @Step
    public void verify_workdead_groups(String workheadGroups, String budgetCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getBudgetCostByWorkheadGroup(workheadGroups).replaceAll(",", ""))).isEqualTo(Float.parseFloat(budgetCost));
    }

    @Step
    public void verify_total_budget_cost_workhead_groups(String budgetCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getTotalBudgetCostInWorkheadGroup().replaceAll(",", ""))).isEqualTo(Float.parseFloat(budgetCost));
    }

    @Step
    public void open_quotation() {
        onProjectQuotation.search_project_number_in_draft("ANQ0000083");
        onProjectQuotation.openQuotation("ANQ0000083");
    }

    @Step
    public void verify_selected_brands_in_cost_item_group(String costItemGroup, String selectedBrands) {
        assertThat(onProjectQuotation.getSelectedBrandsByCostItemGroup(costItemGroup.replaceAll(",", ""))).isEqualTo(selectedBrands);
    }

    @Step
    public void verify_budget_cost_in_cost_item_group(String costItemGroup, String budgetCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getBudgetCostByCostItemGroup(costItemGroup).replaceAll(",", ""))).isEqualTo(Float.parseFloat(budgetCost));
    }

    @Step
    public void verify_total_in_cost_item_groups(String budgetCost) {
        assertThat(Float.parseFloat(onProjectQuotation.getTotalBudgetCostByCostItemGroup().replaceAll(",", ""))).isEqualTo(Float.parseFloat(budgetCost));
    }

    @Step
    public void verify_quantity_in_brand_comparison(String drawingObject, String qty) {
        assertThat(Float.parseFloat(onProjectQuotation.getDrawingObjectQtyInBrandComparison(drawingObject).replaceAll(",", ""))).isEqualTo(Float.parseFloat(qty));
    }

    @Step
    public void verify_total_in_brand_comparison(String brand, String supplier, String costPrice) {
        assertThat(Float.parseFloat(onProjectQuotation.getTotalBrandComparison(brand, supplier).replaceAll(",", ""))).isEqualTo(Float.parseFloat(costPrice));
    }

    @Step
    public void verify_unit_cost_in_brand_comparison(String drawingObject, String brand, String supplier, String costPrice) {

        assertThat(Float.parseFloat(onProjectQuotation.getUnitCostInBrandComparison(drawingObject, brand, supplier).replaceAll("\\$", "").replaceAll(",", "").replaceAll(",", "")))
                .isEqualTo(Float.parseFloat(costPrice));
    }

    @Step
    public void save_selected_supplers() {
        onProjectQuotation.saveSelectedSuplierListInComparison();
    }

    @Step
    public void abort_quotation() {
        onProjectQuotation.clickAbortQuotation();
        onProjectQuotation.chooseYesOnUpdateConfirmation();
    }

    @Step
    public void enter_item_budget_qty_for_last_cost_item(String itemBudgetQty) {
        onProjectQuotation.enterItemBudgetQtyForLastCostItem(itemBudgetQty);
    }

    @Step
    public void delete_costing_item(String drawingObjectNo) {
        onProjectQuotation.selectCostingItemRow(drawingObjectNo);
        onProjectQuotation.clickDeleteOnCostingSheet();
        onProjectQuotation.chooseYesOnUpdateConfirmation();
    }

    @Step
    public void select_type_by_cost_item(String drawingObjectNo, String type) {
        onProjectQuotation.selectTypeByCostItem(drawingObjectNo, type);
    }

    @Step
    public void select_drawing_object_by_cost_item(String drawingObjectNo, String drawingObject) {
        onProjectQuotation.selectDrawingObjectByCostItem(drawingObjectNo, drawingObject);
    }

    @Step
    public void select_code_description_by_cost_item(String drawingObjectNo, String itemCodeDescription) {
        onProjectQuotation.selectCodeDescriptionByCostItem(drawingObjectNo, itemCodeDescription);
    }

    @Step
    public void enter_drawing_qty_by_cost_item(String drawingObjectNo, String drawingQty) {
        onProjectQuotation.enterDrawingQtyByCostItem(drawingObjectNo, drawingQty);
    }

    @Step
    public void enter_wastage_by_cost_item(String drawingObjectNo, String estWastage) {
        onProjectQuotation.enterWastageByCostItem(drawingObjectNo, estWastage);
    }

    @Step
    public void enter_item_budget_qty_by_cost_item(String drawingObjectNo, String itemBudgetQty) {
        onProjectQuotation.enterItemBudgetQtyByCostItem(drawingObjectNo, itemBudgetQty);
    }

    @Step
    public void enter_item_budget_unit_cost_by_cost_item(String drawingObjectNo, String itemBudgetUnitCost) {
        onProjectQuotation.enterItemBudgetUnitCostByCostItem(drawingObjectNo, itemBudgetUnitCost);
    }

    @Step
    public void enter_item_budget_markup_by_cost_item(String drawingObjectNo, String itemBudgetMarkup) {
        onProjectQuotation.enterItemBudgetMarkupByCostItem(drawingObjectNo, itemBudgetMarkup);
    }

    @Step
    public void enter_labour_qty_by_cost_item(String drawingObjectNo, String labourBudgetQty) {
        onProjectQuotation.enterLabourQtyByCostItem(drawingObjectNo, labourBudgetQty);
    }

    @Step
    public void enter_labour_unit_cost_by_cost_item(String drawingObjectNo, String labourBudgetUnitCost) {
        onProjectQuotation.enterLabourUnitCostByCostItem(drawingObjectNo, labourBudgetUnitCost);
    }

    @Step
    public void enter_labour_markup_by_cost_item(String drawingObjectNo, String labourBudgetMarkup) {
        onProjectQuotation.enterLabourMarkupByCostItem(drawingObjectNo, labourBudgetMarkup);
    }

    @Step
    public void submit_quotation() {
        onProjectQuotation.clickSubmitQuotation();
        onProjectQuotation.chooseYesOnUpdateConfirmation();
    }

    @Step
    public void save_quotation_code() {
        onProjectQuotation.saveQuotationCode();
    }
}
