package com.synergix.common.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.synergix.common.pages.DatabaseTaskhub;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DBSteps extends ScenarioSteps {
	DatabaseTaskhub database;

	@Step
	public void check_database_connection_pass_parameter_command() {
		List<String> empRole = database.check_database_connection_pass_parameter_command();

		assertThat(empRole.get(0), equalTo("CEO"));
		assertThat(empRole.get(1), equalTo("Chief Executive Officer"));
	}

	@Step
	public void execute_sql(String dbname, String sql) {
		database.execute_sql(dbname, sql);
	}

}
