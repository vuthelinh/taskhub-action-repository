package com.synergix.mtsetup.moduleconfig.pages;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.synergix.common.LogWork;
import com.synergix.common.TH5PageObject;

public class ModuleConfigPage extends TH5PageObject {
	public ModuleConfigPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Description Switching to module config tab by format path. If there are
	 *              more than one tab have the same definition, first tab will
	 *              be switched to. Format: Tab1>Tab2>[Tab2Index]
	 * @author Vincent
	 * @param moduleConfigTabPath
	 */
	public void switch_to_module_config_section(String moduleConfigTabPath) {
		String[] asTabPath = moduleConfigTabPath.split(">");
		// Check path contain index
		int numPath = asTabPath.length;
		int tabIndex = 1;
		boolean bIndexOrNot = false;
		if (asTabPath[numPath - 1].contains("[")
				&& asTabPath[numPath - 1].contains("]")) {
			bIndexOrNot = true;
			try {
				tabIndex = Integer.parseInt(asTabPath[numPath - 1].replace("[",
						"").replace("]", ""));
			} catch (Exception e) {
				fail("Incorrect tab path format: " + moduleConfigTabPath);
			}
		}
		switch (numPath) {
		case 1:
			switch_to_tab(asTabPath[0]);
			break;
		case 2:
			if (!bIndexOrNot) {
				switch_to_tab(asTabPath[0]);
				if (asTabPath[0].contains(asTabPath[1])) {
					switch_to_tab(asTabPath[1], 2);
				} else {
					switch_to_tab(asTabPath[1], tabIndex);
				}
			} else {
				switch_to_tab(asTabPath[1], tabIndex);
			}
			break;
		case 3:
			switch_to_tab(asTabPath[0]);
			if (!bIndexOrNot) {
				if (asTabPath[0].contains(asTabPath[1])) {
					switch_to_tab(asTabPath[1], 2);
					if (asTabPath[1].contains(asTabPath[2])) {
						switch_to_tab(asTabPath[2], 3);
					} else {
						if (asTabPath[0].contains(asTabPath[2])) {
							switch_to_tab(asTabPath[2], 2);
						} else {
							switch_to_tab(asTabPath[2]);
						}
					}
				} else {
					switch_to_tab(asTabPath[1]);
					if (asTabPath[1].contains(asTabPath[2])) {
						switch_to_tab(asTabPath[2], 2);
					} else {
						if (asTabPath[0].contains(asTabPath[2])) {
							switch_to_tab(asTabPath[2], 2);
						} else {
							switch_to_tab(asTabPath[2]);
						}
					}
				}
			} else {
				switch_to_tab(asTabPath[1], tabIndex);
			}
			break;
		default:
			fail("Incorrect tab path format or not support this tab level yet.");
			break;
		}
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
	public void set_module_config(String _moduleConfigName,
			int _moduleConfigIndex, String _configType, String _configValue) {
		switch (_configType) {
		case "Radio":
			selectRadioButton(xPathRadioBtnWithGroupLabel("",
					_moduleConfigName, _moduleConfigIndex, _configValue));
			break;
		case "Input":
			enterInputFieldWithLabel(_moduleConfigName, _configValue,
					_moduleConfigIndex);
			break;
		case "Select":
			selectDdlWithLabelByText(_moduleConfigName, _moduleConfigIndex,
					_configValue);
			break;
		case "Search":
			try {
				String[] asConfigValue = _configValue.split(">");
				clickSearchIconWithLabel("", _moduleConfigName,
						_moduleConfigIndex);
				if (!search(asConfigValue[0], asConfigValue[1])) {
					fail(asConfigValue[0] + " not found: " + asConfigValue[1]);
				}
			} catch (Exception e) {
				fail("Incorrect format of config value: " + _configValue);
			}
			break;
		case "Remarks":
			enterRemarkByClickIcon(
					xPathRemarksWithLabel("", _moduleConfigName,
							_moduleConfigIndex, 1), _configValue);
			break;
		default:
			fail("Incorrect config type or not support this config type yet: "
					+ _configType);
			break;
		}
	}

	public void switch_to_module_config_section2(String moduleConfigTabPath) {
		String[] asTabPath = moduleConfigTabPath.split(">");

		int size = asTabPath.length;
		// String alwaysActive = "Accounts Payable";
		for (int i = 0; i < size; i++) {
			int findVoucher = findAll(
					"//td[contains(text(),'"
							+ asTabPath[i]
							+ "') and contains(@class,'rich-tab-header rich-tab-inactive')]")
					.size();
			LogWork.log_debug("findVoucher: " + findVoucher);
			if (findVoucher != 0) {
				$(
						"//td[contains(text(),'"
								+ asTabPath[i]
								+ "') and contains(@class,'rich-tab-header rich-tab-inactive')]")
						.waitUntilClickable().click();
				waitForAllJSCompletes();
			}
		}
	}

	String PAY_TS_ServiceCodeForTimesheet = "Service Code for Weekly Timesheet";
	String PAY_TS_EnableWTSWithoutPayrollDesignation = "Enable Weekly Timesheet to Capture Project Cost Without Payroll Designation Hourly Rate";
	String PRJCOSTING_QE_EnableInsertProjectToCtrlDB = "Enable Insert Project To Ctrl DB";
	String PAY_PAY_EnableSearchProjectInCtrlDatabase = "Enable Search Project In Ctrl Database";

	public void chooseModuleConfiguration(String tab,
			String moduleConfiguration, String value) {

		if (moduleConfiguration.equals(PAY_TS_ServiceCodeForTimesheet)) {
			clickSearchIconWithLabel(moduleConfiguration);
			searchAndSelectByInputCode("Service Code", value);
		} else if (moduleConfiguration
				.equals(PAY_TS_EnableWTSWithoutPayrollDesignation)) {
			selectRadioButton(moduleConfiguration, value);
		} else if (moduleConfiguration
				.equals(PRJCOSTING_QE_EnableInsertProjectToCtrlDB)) {
			selectRadioButton(moduleConfiguration, value);
		} else if (moduleConfiguration
				.equals(PAY_PAY_EnableSearchProjectInCtrlDatabase)) {
			selectRadioButton(moduleConfiguration, value);
		}

	}
}