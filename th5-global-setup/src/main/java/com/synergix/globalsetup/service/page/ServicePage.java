package com.synergix.globalsetup.service.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ServicePage extends TH5PageObject {

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    public void typeServiceCode(String serviceCode) {
        enterInputFieldCodeWithLabel("Service Code", serviceCode);
    }

    public void typeServiceDescription(String serviceDescription) {
        enterInputFieldWithLabel("Service Description", serviceDescription);
    }

    public void typeServiceCategory(String serviceCategory) {
        enterInputFieldCodeWithLabel("Service Category", serviceCategory);
    }

    public void typeUOM(String uOM) {
        enterInputFieldCodeWithLabel("UOM", uOM);
    }

    public void chooseTrackQtyinProject(String trackQtyinProject) {
        selectRadioButton("Track Qty in Project", trackQtyinProject);
    }

    public void typeBudgetCategoryCode(String budgetCategoryCode) {
        enterInputFieldCodeWithLabel("Budget Category Code", budgetCategoryCode);
    }

    public void chooseServiceType(String serviceType) {
        String[] type = serviceType.split(",");
        for (int i = 0; i < type.length; i++) {
            setChkbox(xPathChkboxWithGroupLabel("Service Type", type[i]), "true");
        }
    }

    public void chooseRevenueStatus(String revenueStatus) {
        String xPath = "(//*[text()='Revenue Status']/parent::td//following-sibling::td//label[text()='" + revenueStatus
                + "'])[1]";
        $(xPath).click();
        waitForAllJSCompletes();
    }

    public void typeRevenueGLAN(String revenueGLAN) {
        enterInputFieldCodeWithLabel("Revenue GLAN", revenueGLAN);
    }

    public void typeUnearnedRevenueGLAN(String unearnedRevenueGLAN) {
        enterInputFieldCodeWithLabel("Unearned Revenue GLAN", unearnedRevenueGLAN);
    }

    public void typeSalesAccrualGLAN(String salesAccrualGLAN) {
        enterInputFieldCodeWithLabel("Sales Accrual GLAN", salesAccrualGLAN);
    }

    public void typeReportGrouping(String reportGrouping) {
        enterInputFieldCodeWithLabel("Report Grouping", reportGrouping);
    }

    public void chooseDefaultSalesTax(String defaultSalesTax) {
        selectDdlWithLabelByText("Default Sales Tax", defaultSalesTax.trim().toUpperCase());
    }

    public void typeIntercompanySalesTax(String intercompanySalesTax) {
        enterInputFieldCodeWithLabel("Intercompany Sales Tax", intercompanySalesTax);
    }

    public void chooseExpenseStatus(String expenseStatus) {
        String xPath = "(//*[text()='Expense Status']/parent::td//following-sibling::td//label[text()='" + expenseStatus
                + "'])[1]";
        $(xPath).click();
        waitForAllJSCompletes();
    }

    public void typeExpenseGLAN(String expenseGLAN) {
        enterInputFieldCodeWithLabel("Expense GLAN", expenseGLAN);
    }

    public void typeAccruedCostGLAN(String accruedCostGLAN) {
        enterInputFieldCodeWithLabel("Accrued Cost GLAN", accruedCostGLAN);
    }

    public void typeOverheadGLAN(String overheadGLAN) {
        enterInputFieldCodeWithLabel("Overhead GLAN", overheadGLAN);
    }

    @FindBy(xpath = "//*[text()='Party Type']/parent::a/following-sibling::input")
    public WebElementFacade headerFiterPartyType;

    @FindBy(xpath = "//*[text()='Party Type Group']/parent::a/following-sibling::input")
    public WebElementFacade headerFilterPartyTypeGroup;

    public void typeRelation(String partyTypeGroup, String partyType) {
        headerFiterPartyType.typeAndEnter(partyType);
        waitForAllJSCompletes();
        waitABit(500);
        headerFilterPartyTypeGroup.typeAndEnter(partyTypeGroup);
        waitForAllJSCompletes();
        waitABit(1000);
    }

    public void selectExpense(String _listServiceRelationExpense) {
        headerFiterPartyType.typeAndEnter(_listServiceRelationExpense);
        String xPathFirstExpense = "//thead/following-sibling::tbody/tr[1]/td[4]/input";
        waitForAllJSCompletes();
        if ($(xPathFirstExpense).getAttribute("checked") == null)
            $(xPathFirstExpense).click();
        waitForAllJSCompletes();
    }

    public void clickOnNewButton() {
        findBtn("New").waitUntilClickable().click();
        waitForAllJSCompletes();
    }

    public void clickOnUpdateButton() {
        findBtn("Update").waitUntilClickable().click();
        chooseYesOnUpdateConfirmation();
        chooseOkOnInforPanel();
        waitForAllJSCompletes();
    }

    public void chooseRevenue() {
        String xPathFirstRevenus = "(//thead/following-sibling::tbody/tr[1]/td[3]/input)[1]";

        if (!$(xPathFirstRevenus).isSelected()) {
            $(xPathFirstRevenus).click();
            waitForAllJSCompletes();
            waitABit(120);
        }
    }

    public void chooseExpense() {
        String xPathFirstExpense = "(//thead/following-sibling::tbody/tr[1]/td[4]/input)[1]";

        if (!$(xPathFirstExpense).isSelected()) {
            $(xPathFirstExpense).click();
            waitForAllJSCompletes();
        }
    }

}
