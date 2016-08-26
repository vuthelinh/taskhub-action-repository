package com.synergix.mtsetup.demographic.sector.steps;

import com.synergix.mtsetup.demographic.sector.pages.SegmentMaintenancePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SegmentMaintenanceSteps extends ScenarioSteps {

	SegmentMaintenancePage onSegmentMaintenancePage;

	public void switchToIFrame() {
		onSegmentMaintenancePage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onSegmentMaintenancePage.switchOutDefaultIFrame();
	}

	@Step
	public void typeSegmentName(String segmentName, String key) {
		onSegmentMaintenancePage.typeSegmentName(segmentName, key);
	}

	@Step
	public void clickAddBtn() {
		onSegmentMaintenancePage.clickBtn("Add");
		onSegmentMaintenancePage.waitForAllJSCompletes();
	}

	@Step
	public void typeSegmentCode(String segmentCode, int key) {
		onSegmentMaintenancePage.typeSegmentCode(segmentCode, key);
	}

	@Step
	public void typeDescription(String description, int key) {
		onSegmentMaintenancePage.typeDescription(description, key);
	}

	@Step
	public void clickOnIcon(String key) {
		onSegmentMaintenancePage.clickOnIcon(key);
	}

	@Step
	public int getRowDetais() {
		return onSegmentMaintenancePage.getRowDetails();
	}

	@Step
	public void chooseDelDetail(int row) {
		onSegmentMaintenancePage.chooseDelDetail(row);
	}

	@Step
	public void chooseDelDetail(String segmentCode) {
		onSegmentMaintenancePage.chooseDelDetail(segmentCode);
	}

}
