package com.synergix.definition.test;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;

import com.synergix.definition.test.VincentTestPage;

/**
 * @author Vincent
 * @version 20160121
 */
public class VincentTestSteps extends ScenarioSteps {
	VincentTestPage testPage;

	@Step
	public void test_step_1() {
		testPage.test_step_1();
	}

	@Step
	public String test_step_2() {
		return testPage.test_step_2();
	}

	@Step
	@Ignore
	public void assertion_result(String input) {
		// assertThat("2").as("TEST").isEqualTo("1");
	}

	@Step
	@Ignore
	public void test_step_4(String input) {
	}
}
