package com.synergix.mtsetup.pricing.inventory.steps;

import com.synergix.mtsetup.pricing.inventory.pages.SupplierInventoryPriceListPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian on 8/4/2016.
 */
public class SupplierInventoryPriceListSteps extends ScenarioSteps {
    private SupplierInventoryPriceListPage onSupplierInventoryPriceList;

    @Step
    public void switch_iframe() {
        onSupplierInventoryPriceList.switchToIFrame();
    }

    @Step
    public void switch_out_iframe() {
        onSupplierInventoryPriceList.switchOutDefaultIFrame();
    }

    @Step
    public void select_supplier_currency(String supplier, String currency) {
        onSupplierInventoryPriceList.clickNewPriceList();
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.enterSupplierCodeAndEnter(supplier);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.enterCurrencyCodeAndEnter(currency);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

    }

    @Step
    public void add_new_effective_date(String effectiveDateFrom, String effectiveDateTo) {
        onSupplierInventoryPriceList.clickAddEffectiveButton();
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.selectEffectiveDateFrom(effectiveDateFrom);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.selectEffectiveDateTo(effectiveDateTo);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

    }

    public void add_inventory_item(String inventoryCode) {
        onSupplierInventoryPriceList.clickAddInventoryIdem();
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.enterInventoryCode(inventoryCode);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.clickBtn("Done");
        onSupplierInventoryPriceList.waitForAllJSCompletes();

    }

    public void set_unit_price_for_current_inventory_item(String unitPrice) {
        onSupplierInventoryPriceList.enterUnitPrice(unitPrice);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

    }


    public void set_qty_range_for_current_inventory_item(String qtyFrom, String qtyTo, String unitPrice) {
        onSupplierInventoryPriceList.enterQtyTo(qtyFrom, qtyTo);
        onSupplierInventoryPriceList.waitForAllJSCompletes();

        onSupplierInventoryPriceList.enterUnitPriceInRange(qtyFrom, unitPrice);
        onSupplierInventoryPriceList.waitForAllJSCompletes();


    }

    public void add_new_qty_range_for_current_inventory_item() {
        onSupplierInventoryPriceList.clickNewPriceRange();
        onSupplierInventoryPriceList.waitForAllJSCompletes();

    }

    public void expand_last_inventory() {
        onSupplierInventoryPriceList.clickExpandLastInventory();
        onSupplierInventoryPriceList.waitForAllJSCompletes();

    }

    public void add_range() {
        onSupplierInventoryPriceList.clickAddButtonOnRangeTable();
    }

    public void select_checkbox_price_quantity_range() {
        onSupplierInventoryPriceList.checkCheckboxPriceByQuantityRange();
    }
}
