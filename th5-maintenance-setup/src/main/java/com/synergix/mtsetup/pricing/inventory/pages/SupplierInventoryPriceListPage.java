package com.synergix.mtsetup.pricing.inventory.pages;

import com.synergix.common.TH5PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ian on 8/4/2016.
 */
public class SupplierInventoryPriceListPage extends TH5PageObject {

    public static final String EFFECTIVE_TABLE = "//form[@id='form2']";
    public static final String PRICE_RANGE_TABLE = "//form[@id='form5']";

    public SupplierInventoryPriceListPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewPriceList() {
        clickBtn("New");
    }

    public void enterSupplierCodeAndEnter(String supplier) {
        enterInputFieldCodeWithLabel("Supplier", supplier);
    }

    public void enterCurrencyCodeAndEnter(String currency) {
        enterInputFieldCodeWithLabel("Currency", currency);
    }

    public void clickAddEffectiveButton() {
        clickBtn("Add", 1);
    }

    public void clickAddInventoryIdem() {
        clickBtn("Add", 2);
    }

    public void selectEffectiveDateFrom(String effectiveDateFrom) {
        waitTypeAndEnter(EFFECTIVE_TABLE + "/table/tbody//td[2]//input", effectiveDateFrom);
    }

    public void selectEffectiveDateTo(String effectiveDateTo) {
        waitTypeAndEnter(EFFECTIVE_TABLE + "/table/tbody//td[3]//input", effectiveDateTo);
    }

    public void enterInventoryCode(String inventoryCode) {
        enterInputFieldCodeWithLabel("Inventory Code", inventoryCode);
    }

    public void enterUnitPrice(String unitPrice) {
        waitTypeAndEnter("(" + PRICE_RANGE_TABLE + ")[1]//tbody/tr/td[3]//input", unitPrice);
    }

    public void checkCheckboxPriceByQuantityRange() {
        clickOnElement("(" + PRICE_RANGE_TABLE + ")[1]//tbody/tr/td[2]//input");
    }

    public void enterQtyTo(String qtyFrom, String qtyTo) {
        waitTypeAndEnter("(" + PRICE_RANGE_TABLE + ")[1]//tbody/tr[last()]/td[6]//input", qtyTo);
    }

    public void enterUnitPriceInRange(String qtyFrom, String unitPrice) {
        waitTypeAndEnter("(" + PRICE_RANGE_TABLE + ")[1]//tbody/tr[last()]/td[7]//input", unitPrice);
    }

    public void clickExpandLastInventory() {
        clickOnElement("//form[@id='form4']//table/tbody/tr[last()]/td[1]//a");
    }

    public void clickAddButtonOnRangeTable() {
        clickBtn("Add", 3);
    }

    public void clickNewPriceRange() {
        clickOnElement("(" + PRICE_RANGE_TABLE + ")[1]//tbody/tr/td[4]//a");
    }
}
