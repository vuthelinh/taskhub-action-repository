package com.synergix.globalsetup.cylinders.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CylinderCapacityPage extends TH5PageObject {
	private static final String INTERCHANGEABLE_GROUP_CODE = "Interchangeable Group Code";
	private static final String CYLINDER_CAPACITY = "Cylinder Capacity";
	private static final String DESCRIPTION = "Description";
	private static final String CYLINDER_CAPACITY_CODE = "Cylinder Capacity Code";
	private static final String CAPACITY_CODE = "Capacity Code";

	public CylinderCapacityPage(WebDriver driver) {
		super(driver);
	}

	public void enter_cylinder_capacity_code(String cylinderCapacityCode) {
		enterInputFieldCodeWithLabel(CYLINDER_CAPACITY_CODE,
				cylinderCapacityCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public void enter_cylinder_capacity(String cylinderCapacity) {
		enterInputFieldWithLabel(CYLINDER_CAPACITY, cylinderCapacity);
	}

	public void enter_interchangeable_group_code(String interchangeableGroupCode) {
		enterInputFieldCodeWithLabel(INTERCHANGEABLE_GROUP_CODE,
				interchangeableGroupCode);
	}


	public void searchCylinderCapacity(String cylinderCapacityCode) {
		search(CAPACITY_CODE, cylinderCapacityCode);
	}

	@FindBy(id="panGlblCylinderCapacity:inCapCode")
	public WebElementFacade CylinderCapacityCode;
	public String get_code() {
		return CylinderCapacityCode.waitUntilPresent().getTextValue();
	}

	@FindBy(id="panGlblCylinderCapacity:inCapDesc")
	public WebElementFacade CylinderCapacityDesc;
	public String get_description() {
		return CylinderCapacityDesc.waitUntilPresent().getTextValue();
	}

	@FindBy(id="panGlblCylinderCapacity:inCap")
	public WebElementFacade CylinderCapacity;
	public String get_cylinder_capacity() {
		return CylinderCapacity.waitUntilPresent().getTextValue();
	}

	@FindBy(id="panGlblCylinderCapacity:interchangeableGroupCode")
	public WebElementFacade interchangeableGroupCode;
	public String get_interchangeable_group_code() {
		return interchangeableGroupCode.waitUntilPresent().getTextValue();
	}

	public boolean search(String sCylinderCapacityCode) {
		return search("Capacity Code", sCylinderCapacityCode);
	}
	
}
