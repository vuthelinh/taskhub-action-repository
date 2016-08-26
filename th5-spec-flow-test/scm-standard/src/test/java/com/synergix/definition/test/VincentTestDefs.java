package com.synergix.definition.test;

import java.util.List;

import com.synergix.common.steps.SessionDataSteps;
import static com.synergix.utilities.SessionData.*;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class VincentTestDefs {
	@Steps
	VincentTestSteps testSteps;
	@Steps
	SessionDataSteps test;

	
	@When("^Table A$")
	public void table_A(List<List<String>> dataTable) throws Throwable {
		addDataTable("DATA TABLE B", dataTable);
	}

	@When("^Table B$")
	public void table_B(List<List<String>> dataTable) throws Throwable {
		addDataTable("DATA TABLE A", dataTable);
	}
	
	@When("^Vincent Test$")
	public void vincent_Test() throws Throwable {
		compareDataTb("TEST1", "DATA TABLE B", "DATA TABLE A");
		compareDataTb("TEST2", "DATA TABLE B", "DATA TABLE A", true);
		compareDataTb("TEST3", "DATA TABLE B", "DATA TABLE A", false);
		compareDataTb("TEST4", "DATA TABLE B", "DATA TABLE A", "Col1", "Col2", "Col4");
		
//		addSoftAssertion("ABC", "2",
//				"check check check checkcheck checkcheck checkcheck checkcheck checkcheck checkcheck checkcheck checkcheck check",
//				"4", "5");
//		addSoftAssertion("ABC", "2", "3", "5", "5");
//		addSoftAssertion("ABC", "2", "3", true, true);
	}

}
