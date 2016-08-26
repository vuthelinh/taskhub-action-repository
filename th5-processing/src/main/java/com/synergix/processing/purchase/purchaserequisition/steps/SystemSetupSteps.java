package com.synergix.processing.purchase.purchaserequisition.steps;

import com.synergix.processing.purchase.purchaserequisition.pages.SystemSetupPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160303
 */
public class SystemSetupSteps extends ScenarioSteps {
	SystemSetupPage systemSetupPage;

	/**
	 * @Description Set setting for purchase requisition system config.
	 *              Supported config type: Radio,Input,Select,Search,Remarks
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
