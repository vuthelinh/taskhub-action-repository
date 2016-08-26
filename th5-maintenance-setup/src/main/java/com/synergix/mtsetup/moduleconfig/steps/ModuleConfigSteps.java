package com.synergix.mtsetup.moduleconfig.steps;

import com.synergix.mtsetup.moduleconfig.pages.ModuleConfigPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ModuleConfigSteps extends ScenarioSteps{

	ModuleConfigPage onModuleConfigPage;
 
	public void switchToIFrame() {
		onModuleConfigPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onModuleConfigPage.switchOutDefaultIFrame();
	}
		
	// #Region#Vincent
	/**
	 * @Description Switching to module config tab by format path. If there are
	 *              more than one tab have the same definition, first tab will
	 *              be switched to. Format: Tab1>Tab2>[Tab2Index]
	 * @author Vincent
	 * @param moduleConfigTabPath
	 */
	@Step
	public void switch_to_module_config_section(String moduleConfigTabPath) {
		onModuleConfigPage.switch_to_module_config_section(moduleConfigTabPath);
	}
	
	@Step
	public void switch_to_module_config_section2(String moduleConfigTabPath) {
		onModuleConfigPage.switch_to_module_config_section2(moduleConfigTabPath);
	}

	/**
	 * @Description Set setting for module config. Supported configtype:
	 *              Radio,Input,Select,Search,Remarks
	 * @author Vincent
	 * @param _moduleConfigName
	 * @param _moduleConfigIndex
	 * @param _configType
	 * @param _configValue
	 */
	@Step
	public void set_module_config(String _moduleConfigName, int _moduleConfigIndex, String _configType,
			String _configValue) {
		onModuleConfigPage.set_module_config(_moduleConfigName, _moduleConfigIndex, _configType, _configValue);
	}

	// #EndRegion#Vincent
	@Step
	public void go_to_accounts_payable_menu_tab() {
		onModuleConfigPage.switch_to_tab("Accounts Payable", 1);
	}

	@Step
	public void go_to_accounts_payable_tab() {
		onModuleConfigPage.switch_to_tab("Accounts Payable", 2);
	}

	@Step
	public void go_to_accounts_receivable_menu_tab() {
		onModuleConfigPage.switch_to_tab("Accounts Receivable", 1);
	}

	@Step
	public void go_to_accounts_receivable_tab() {
		onModuleConfigPage.switch_to_tab("Accounts Receivable", 2);

	}

	@Step
	public void go_to_bank_book_menu_tab() {
		onModuleConfigPage.switch_to_tab("Bank Book", 1);
	}

	@Step
	public void go_to_bank_book_tab() {
		onModuleConfigPage.switch_to_tab("Bank Book", 2);
	}

	@Step
	public void go_to_general_ledger_menu_tab() {
		onModuleConfigPage.switch_to_tab("General Ledger", 1);
	}

	@Step
	public void go_to_general_ledger_tab() {
		onModuleConfigPage.switch_to_tab("General Ledger", 2);
	}

	@Step
	public void go_to_opening_balance_menu_tab() {
		onModuleConfigPage.switch_to_tab("Opening Balance", 1);
	}

	@Step
	public void go_to_opening_balance_tab() {
		onModuleConfigPage.switch_to_tab("Opening Balance", 2);
	}

	@Step
	public void invalid_prior_period(String lableText, String value) {
		onModuleConfigPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void invalid_future_period(String lableText, String value) {
		onModuleConfigPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void custom_tax_code(String lableText, String value) {
		onModuleConfigPage.clickSearchIconWithLabel(lableText);
		onModuleConfigPage.search("Sales Tax Code", value);
	}

	@Step
	public void retained_earning_glan(String lableText, String value) {
		onModuleConfigPage.clickSearchIconWithLabel(lableText);
		onModuleConfigPage.search("GL Account Code", value);

	}

	@Step
	public void ap_clearing_glan(String lableText, String value) {
		onModuleConfigPage.clickSearchIconWithLabel(lableText);
		onModuleConfigPage.search("GL Account Code", value);

	}

	@Step
	public void ar_clearing_glan(String lableText, String value) {
		onModuleConfigPage.clickSearchIconWithLabel(lableText);
		onModuleConfigPage.search("GL Account Code", value);
	}

	@Step
	public String get_text_label(int row) {
		onModuleConfigPage.waitForAllJSCompletes();
		String actual = onModuleConfigPage.$(
				"//table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/form/table/tbody/tr[" + row + "]/td/span")
				.getText();
		
		return actual;
	}

	public void moveToTab(String tab) {
		onModuleConfigPage.switch_to_tab(tab);
	}
	
	@Step
	public void chooseModuleConfiguration(String tab, String moduleConfiguration, String value) {
		onModuleConfigPage.chooseModuleConfiguration(tab, moduleConfiguration, value);
	}
}
