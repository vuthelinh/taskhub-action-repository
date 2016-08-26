package com.synergix.operations.others.approval.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.synergix.operations.others.approval.pages.AprrovalPages;

public class ApprovalSteps extends ScenarioSteps {

	AprrovalPages onAprrovalPages;

	@Step
	public void projectCostingApproval(String radioValue,
			String transactionTypeDesc) {
		String projectNo = Serenity.sessionVariableCalled("Project No");
		onAprrovalPages
				.clickInQueue(radioValue, transactionTypeDesc, projectNo);
	}

	public void switchToIframe() {
		String idIFrame = "th5frame";
		onAprrovalPages.switchToIFrame(idIFrame);
	}

	public void switchOutDefaultIFrame() {
		onAprrovalPages.switchOutDefaultIFrame();

	}

}
