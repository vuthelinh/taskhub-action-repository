package com.synergix.globalsetup.cylinders.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class StallTypePages extends TH5PageObject {
	public StallTypePages(WebDriver driver) {
		super(driver);
	}

	private static final String DESCRIPTION = "Description";
	private static final String STALL_TYPE_CODE = "Stall Type Code";

	public void enter_stall_type_code(String stallTypeCode) {
		enterInputFieldCodeWithLabel(STALL_TYPE_CODE, stallTypeCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public void search_stall_type(String sStallTypeCode) {
       search(STALL_TYPE_CODE, sStallTypeCode);
	}

	public String get_code() {
		return getTextValueWithLabel(STALL_TYPE_CODE);
	}

	public String get_des() {
		return getTextValueWithLabel(DESCRIPTION);
	}

	public boolean search(String sStallTypeCode) {
		return search(STALL_TYPE_CODE, sStallTypeCode);
	}

}
