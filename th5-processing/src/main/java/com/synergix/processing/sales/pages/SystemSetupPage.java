package com.synergix.processing.sales.pages;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160303
 */
public class SystemSetupPage extends TH5PageObject {
	public SystemSetupPage(WebDriver driver) {
		super(driver);
	}

	//private static final String sPageHeader = "System Setup";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	/**
	 * @Description Switching to sales system config tab by format path. If
	 *              there are more than one tab have the same definition, first
	 *              tab will be switched to. Format: Tab1>Tab2>[Tab2Index]
	 * @author Vincent
	 * @param systemConfigTabPath
	 */
	public void switch_to_system_config_section(String systemConfigTabPath) {
		String[] asTabPath = systemConfigTabPath.split(">");
		// Check path contain index
		int numPath = asTabPath.length;
		int tabIndex = 1;
		boolean bIndexOrNot = false;
		if (asTabPath[numPath - 1].contains("[") && asTabPath[numPath - 1].contains("]")) {
			bIndexOrNot = true;
			try {
				tabIndex = Integer.parseInt(asTabPath[numPath - 1].replace("[", "").replace("]", ""));
			} catch (Exception e) {
				fail("Incorrect tab path format: " + systemConfigTabPath);
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
	 * @Description Set setting for system config. Supported config type:
	 *              Radio,Input,Select,Search,Remarks
	 * @author Vincent
	 * @param _systemConfigName
	 * @param _systemConfigIndex
	 * @param _configType
	 * @param _configValue
	 */
	public void set_system_config(String _systemConfigName, int _systemConfigIndex, String _configType,
			String _configValue) {
		switch (_configType) {
		case "Radio":
			selectRadioButton(xPathRadioBtnWithGroupLabel("", _systemConfigName, _systemConfigIndex, _configValue));
			break;
		case "Input":
			enterInputFieldWithLabel(_systemConfigName, _configValue, _systemConfigIndex);
			break;
		case "Select":
			selectDdlWithLabelByText(_systemConfigName, _systemConfigIndex, _configValue);
			break;
		case "Search":
			try {
				String[] asConfigValue = _configValue.split(">");
				clickSearchIconWithLabel("", _systemConfigName, _systemConfigIndex);
				if (!search(asConfigValue[0], asConfigValue[1])) {
					fail(asConfigValue[0] + " not found: " + asConfigValue[1]);
				}
			} catch (Exception e) {
				fail("Incorrect format of config value: " + _configValue);
			}
			break;
		case "Remarks":
			enterRemarkByClickIcon(xPathRemarksWithLabel("", _systemConfigName, _systemConfigIndex, 1), _configValue);
			break;
		default:
			fail("Incorrect config type or not support this config type yet: " + _configType);
			break;
		}
	}
}
