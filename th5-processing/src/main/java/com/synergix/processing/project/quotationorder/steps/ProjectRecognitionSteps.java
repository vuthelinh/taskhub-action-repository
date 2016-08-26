package com.synergix.processing.project.quotationorder.steps;

import com.synergix.processing.project.quotationorder.pages.ProjectRecognitionPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProjectRecognitionSteps extends ScenarioSteps{

	ProjectRecognitionPage onProjectRecognitionPage;

	@Step
	public void go_to_tab(String tabName) {
		onProjectRecognitionPage.switch_to_tab(tabName);
	}

	@Step
	public void search_project_on_recognition_summary_tab(String projectNo) {
		onProjectRecognitionPage.search_project_on_recognition_summary_tab(projectNo);
	}

	@Step
	public void set_recognition_date(String recognitionDate) {
		onProjectRecognitionPage.enterInputFieldWithLabel("Recognition Date", recognitionDate);
	}

	@Step
	public void set_recognition_rate(String recognitionRate) {
		onProjectRecognitionPage.enterInputFieldWithLabel("Current Cumulative",recognitionRate);
	}
	
	@Step
	public void set_final_recognition(String finalRecognition) {
		onProjectRecognitionPage.selectRadioButton("Final Recog.", finalRecognition);
	}

	@Step
	public void click_submit() {
		onProjectRecognitionPage.submit_voucher();
	}

	
}
