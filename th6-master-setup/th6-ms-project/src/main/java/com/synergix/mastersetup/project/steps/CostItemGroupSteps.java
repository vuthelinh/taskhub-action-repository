package com.synergix.mastersetup.project.steps;

import com.synergix.mastersetup.project.pages.CostItemGroupPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian on 8/4/2016.
 */
public class CostItemGroupSteps extends ScenarioSteps {
    private CostItemGroupPage onCostItemGroup;

    @Step
    public void create_new_cost_item_group(String policyTypeCode, String description) {
        onCostItemGroup.clickAddNewButtonOnFunctionalPanel();
        onCostItemGroup.enterCostItemGroupCodeAndEnter(policyTypeCode);
        onCostItemGroup.waitForAllJSCompletes();
        onCostItemGroup.enterCostItemGroupDescriptionForCostItemGroup(policyTypeCode, description);
        onCostItemGroup.clickUpdateForCostItemGroup(policyTypeCode);
        onCostItemGroup.waitForAllJSCompletes();
        onCostItemGroup.clickBtnYesOnConfirmUpdate();
    }
}
