package com.synergix.processing.purchase.purchaseorder.pages;

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
	 * @Description Set setting for purchase order system config. Supported config type:
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
