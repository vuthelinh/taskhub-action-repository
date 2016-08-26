package com.synergix.definition.common;

import com.synergix.common.steps.DBSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
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
    
    /**
	 * @author Levin
	 * */
    @Given("^user access DB\\s+\"([^\"]*)\" with id\\s+\"([^\"]*)\" and password\\s+\"([^\"]*)\"$")
    public void setSessionDB(String dbURL, String dbUsername, String dbPassword)
    {
        Serenity.setSessionVariable("DB_URL").to(dbURL);
        Serenity.setSessionVariable("DB_USERNAME").to(dbUsername);
        Serenity.setSessionVariable("DB_PASSWORD").to(dbPassword);
    }
}

