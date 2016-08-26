package com.synergix.definition.test;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class VincentTestPage extends TH5PageObject {
	public VincentTestPage(WebDriver driver) {
		super(driver);
	}

	public void test_step_1() {
		// do something
	}

	public String test_step_2() {
		return "test step 2";
	}

	public void test_step_3(String input) {
		// do something
	}
}
