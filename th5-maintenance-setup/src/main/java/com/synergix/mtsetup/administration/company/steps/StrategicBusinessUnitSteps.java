package com.synergix.mtsetup.administration.company.steps;

import com.synergix.mtsetup.administration.company.pages.StrategicBusinessUnitPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian on 8/3/2016.
 */
public class StrategicBusinessUnitSteps extends ScenarioSteps {
    StrategicBusinessUnitPage onStrategicBusinessUnit;


    @Step
    public void create_new_strategic_business_unit(String sbuCode, String description) {
        onStrategicBusinessUnit.switchToIFrame("th5frame");

        onStrategicBusinessUnit.click_add_new_button_on_functional_panel();
        onStrategicBusinessUnit.waitForAllJSCompletes();

        onStrategicBusinessUnit.enterInputFieldCodeWithLabel("SBU Code", sbuCode);
        onStrategicBusinessUnit.waitForAllJSCompletes();

        onStrategicBusinessUnit.enterInputFieldCodeWithLabel("Description", description);
        onStrategicBusinessUnit.waitForAllJSCompletes();

        onStrategicBusinessUnit.click_update_button_on_functional_panel();
        onStrategicBusinessUnit.waitForAllJSCompletes();

        onStrategicBusinessUnit.switchOutDefaultIFrame();
    }
}
