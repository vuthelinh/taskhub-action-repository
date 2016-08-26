package com.synergix.mastersetup.project.pages;

import com.synergix.common.TH6PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ian on 8/4/2016.
 */
public class CostItemGroupPage extends TH6PageObject {
    public CostItemGroupPage(WebDriver driver) {
        super(driver);
    }


    public static final String INPUT_DESCRIPTION = "/td[3]/input";
    public static final String BUTTON_UPDATE = "//button[.='Update']";

    @FindBy(xpath = "//button[contains(@id,'syn:summary') and span[contains(@class,' fa-plus')]]")
    private WebElementFacade newButton;

    //    TODO create click add new button on common
    public void clickAddNewButtonOnFunctionalPanel() {
        newButton
                .waitUntilPresent()
                .click();
    }

    @FindBy(xpath = "//table[@role='grid']/tbody/tr/td[2]/input[@aria-readonly='false' and @aria-readonly='false']")
    private WebElementFacade newCostItemGroupCodeInput;

    public void enterCostItemGroupCodeAndEnter(String costItemGroupCode) {
        newCostItemGroupCodeInput.typeAndEnter(costItemGroupCode);
    }

    private String xpathRowCostItemGroup(String costItemGroupCode) {
        return "//table[@role='grid']/tbody/tr[td[input[@value='"
                + costItemGroupCode
                + "']]]";
    }

    public void enterCostItemGroupDescriptionForCostItemGroup(String costItemGroupCode, String description) {
        waitTypeAndEnter(
                xpathRowCostItemGroup(costItemGroupCode) + INPUT_DESCRIPTION,
                description);
    }

    public void clickUpdateForCostItemGroup(String costItemGroupCode) {
        clickOnElement(xpathRowCostItemGroup(costItemGroupCode) + BUTTON_UPDATE);
    }

    private String xPathBtnYesConfirmUpdate = "//div[contains(@id,'globalConfirmation')]//button[.='Yes']";

    public void clickBtnYesOnConfirmUpdate() {
        waitFor(xPathBtnYesConfirmUpdate);
        clickOnElement(xPathBtnYesConfirmUpdate);
        waitForAllJSCompletes();
    }
}
