package com.synergix.common.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;

import com.synergix.utilities.SessionData;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SessionDataSteps extends ScenarioSteps {
	// BEGIN Soft Assertion
	@Step
	@Ignore
	public void assertion_result(String _assertion) {
		// Display report only
	}

	@Step
	public void assertion_result_then_assert(String _assertionKey, String _assertion) {
		assertThat(SessionData.getSoftAssertionOverallResult(_assertionKey))
				.as("Overall assertion of " + _assertionKey + " have to pass.").isTrue();
	}

	@Step
	public void clear_assertion(String _assertionKey) {
		SessionData.clearSoftAssertion(_assertionKey);
	}
	// END Soft Assertion
}
