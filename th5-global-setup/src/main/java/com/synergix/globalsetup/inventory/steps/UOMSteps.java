package com.synergix.globalsetup.inventory.steps;

import com.synergix.globalsetup.inventory.page.UOMPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UOMSteps extends ScenarioSteps {

	private static final String UOM_CODE = "UOM Code";
	UOMPage onUOMPage;

	public void switchToIFrame() {
		onUOMPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onUOMPage.switchOutDefaultIFrame();
	}

	@Step
	public void addUOM() {
		onUOMPage.clickOnAddNewBtn();
	}

	@Step
	public void typeUOMCode(String uOMCode) {
		onUOMPage.typeUOMCode(uOMCode);
	}

	@Step
	public void typeDescription(String description) {
		onUOMPage.typeDescription(description);
	}

	@Step
	public void checkType(String type) {
		onUOMPage.checkType(type);
	}

	@Step
	public void update() {
		onUOMPage.clickOnUpdateButton();
	}

	@Step
	public void moveToCompanyTab() {
		onUOMPage.switch_to_tab("Company");
	}

	@Step
	public void checkAllCompany() {
		onUOMPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onUOMPage.chooseCompany(company);
	}

	@Step
	/**
	 * Created by Steve
	 * @param uOMCode
	 * @return
	 */
	public boolean search_UOM(String uOMCode){
		onUOMPage.click_search_button_on_functional_panel();
		onUOMPage.waitForAllJSCompletes();
		return onUOMPage.search(UOM_CODE, uOMCode);
		
	}
	
	public void chooseDelUOM(String uOMCode) {
		onUOMPage.deleteValueBySearchBtn("Search", UOM_CODE, uOMCode);
	}
	@Step
	public String isAlreadyExistsInDatabase(String uOMCode) {
		return onUOMPage.check_database_exist(uOMCode);
	}
}
