package com.synergix.globalsetup.cylinders.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CylinderBrandPages extends TH5PageObject {
	
	private static final String CYLINDER_BRAND_CODE = "Cylinder Brand Code";
	private static final String DESCRIPTION = "Description";
	
	public CylinderBrandPages(WebDriver driver){
		super(driver);
	}
	
	public void enter_cylinder_brand_code(String cylinderBrandCode) {
		enterInputFieldCodeWithLabel(CYLINDER_BRAND_CODE, cylinderBrandCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public boolean search(String sCylinderBrandCode) {
		return search(CYLINDER_BRAND_CODE, sCylinderBrandCode);
	}

	@FindBy(id="panGlblCylinderBrand:inCapCode")
	private WebElementFacade CylinderBrandCode;
	public String get_code() {
		return CylinderBrandCode.waitUntilPresent().getTextValue();
	}

	@FindBy(id="panGlblCylinderBrand:inCapDesc")
	private WebElementFacade CylinderBrandDesc;
	public String get_description() {
		return CylinderBrandDesc.waitUntilPresent().getTextValue();
	}

	public String check_database_exist(String sCylinderCode) {
		return check_database_exist("MT_CYL_BRAND", "CYLINDER_BRAND_CODE", sCylinderCode);
	}

}
