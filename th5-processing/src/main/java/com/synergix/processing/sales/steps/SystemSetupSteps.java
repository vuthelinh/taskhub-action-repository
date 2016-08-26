package com.synergix.processing.sales.steps;

import com.synergix.processing.sales.pages.SystemSetupPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160303
 */
public class SystemSetupSteps extends ScenarioSteps {
	SystemSetupPage systemSetupPage;

	@Step
	public void switch_to_system_config_section(String systemConfigTabPath) {
		systemSetupPage.switch_to_system_config_section(systemConfigTabPath);
	}

	/**
	 * @Description Set setting for system config. Supported configtype:
	 *              Radio,Input,Select,Search,Remarks
	 * @author Vincent
	 * @param _systemConfigName
	 * @param _systemConfigIndex
	 * @param _configType
	 * @param _configValue
	 */
	@Step
	public void set_system_config(String _systemConfigName, int _systemConfigIndex, String _configType,
			String _configValue) {
		systemSetupPage.set_system_config(_systemConfigName, _systemConfigIndex, _configType, _configValue);
	}
}
