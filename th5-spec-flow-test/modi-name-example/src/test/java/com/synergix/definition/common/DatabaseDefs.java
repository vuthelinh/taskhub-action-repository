package com.synergix.definition.common;

import com.synergix.common.steps.DBSteps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DatabaseDefs
{
    @Steps
    DBSteps DBStep;

    @When("^check database connection with pass parameter in command line$")
    public void check_database_connection_pass_parameter_command()
    {
        DBStep.check_database_connection_pass_parameter_command();
    }
}

