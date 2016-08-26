package com.synergix.mtsetup.demographic.sector.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class SegmentMaintenancePage extends TH5PageObject {

	public SegmentMaintenancePage(WebDriver driver) {
		super(driver);
	}

	private String xParentSgmt = "//*[text()='Segments']/parent::div/descendant::table";
	private String xParentDetails = "//*[text()='Segments Details']/parent::div/descendant::table";

	public void clickOnIcon(String key) {
		String xPathIcon = xParentSgmt + "/tbody/tr[" + key + "]/td[1]/a[@href]";
		$(xPathIcon).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void typeSegmentName(String segmentName, String key) {
		String xPathLable = xParentSgmt + "/tbody/tr[" + key + "]/td[3]/input";
		waitTypeAndEnter(xPathLable, segmentName);
	}

	public void typeSegmentCode(String segmentCode, int key) {
		String xPathLable = xParentDetails + "/tbody/tr[" + key + "]/td[1]/input";
		waitTypeAndEnter(xPathLable, segmentCode);
	}

	public void typeDescription(String description, int key) {
		String xPathLable = xParentDetails + "/tbody/tr[" + key + "]/td[2]/input";
		waitTypeAndEnter(xPathLable, description);
	}

	public int getRowDetails() {
		String xPathRow = xParentDetails + "/tbody/tr[@class]";
		return findAll(By.xpath(xPathRow)).size();
	}

	public void chooseDelDetail(int row) {
		String xDel = xParentDetails + "/tbody/tr[" + row + "]/td[3]/input";
		clickOnElement(xDel);
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void chooseDelDetail(String segmentCode) {
		String xDel = xParentDetails + "/tbody/tr[child::td[1 and descendant-or-self::*[text()='" + segmentCode
				+ "']]]/td[3]/input";
		if (isElementExist(xDel)) {
			clickOnElement(xDel);
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			waitForAllJSCompletes();
		}
	}
}
