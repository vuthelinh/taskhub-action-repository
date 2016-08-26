package com.synergix.definition.common;

import static org.junit.Assert.fail;

import java.util.List;

import com.synergix.common.steps.ModuleConfigSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/*import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;*/

/**
 * @author Vincent
 * @version 20160215
 */
public class ModuleConfigDefs {

	@Steps
	ModuleConfigSteps moduleConfigSteps;

	@Then("^user changes Module Config$")
	public void user_changes_Module_Config(List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("MODULE_CONFIG", dataTable, false);
		String previousModuleSection = "";
		for (int row : SessionData.getDataTbRowsNoHeader("MODULE_CONFIG").keySet()) {
			String sModuleSection = SessionData.getDataTbVal("MODULE_CONFIG", row, "Module Section");
			String sModuleName = SessionData.getDataTbVal("MODULE_CONFIG", row, "Module Name");
			String sConfigType = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Type");
			String sConfigValue = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Value");
			String sConfigType1 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Type 1");
			String sConfigValue1 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Value 1");
			String sConfigType2 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Type 2");
			String sConfigValue2 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Value 2");
			if (!sModuleSection.isEmpty()) {
				if (previousModuleSection != sModuleSection) {
					moduleConfigSteps.switch_to_module_config_section(sModuleSection);
				}
				previousModuleSection = sModuleSection;
			} else {
				continue;
			}
			int moduleIndex = 1;
			if (!sModuleName.isEmpty()) {
				String[] asModuleName = sModuleName.split(">");
				// Check path contain index
				int numPath = asModuleName.length;
				if (numPath == 2) {
					if (asModuleName[numPath - 1].contains("[") && asModuleName[numPath - 1].contains("]")) {
						try {
							moduleIndex = Integer.parseInt(asModuleName[numPath - 1].replace("[", "").replace("]", ""));
						} catch (Exception e) {
							fail("Module Config Format Name is not correct : " + sModuleName);
						}
						sModuleName = asModuleName[0];
					} else {
						fail("Module Config Format Name is not correct : " + sModuleName);
					}
				}
			}
			if (!sConfigType.isEmpty() && !sConfigValue.isEmpty()) {
				moduleConfigSteps.set_module_config(sModuleName, moduleIndex, sConfigType, sConfigValue);
			}
			if (!sConfigType1.isEmpty() && !sConfigValue1.isEmpty()) {
				moduleConfigSteps.set_module_config(sModuleName, moduleIndex, sConfigType1, sConfigValue1);
			}

			if (!sConfigType2.isEmpty() && !sConfigValue2.isEmpty()) {
				moduleConfigSteps.set_module_config(sModuleName, moduleIndex, sConfigType2, sConfigValue2);
			}
		}
	}

	@Then("^user changes Module Config as \"([^\"]*)\"$")
	public void user_changes_Module_Config_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("MODULE_CONFIG", dataTable, false);
		String previousModuleSection = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("MODULE_CONFIG", "KEY", dataKey).keySet()) {
			String sModuleSection = SessionData.getDataTbVal("MODULE_CONFIG", row, "Module Section");
			String sModuleName = SessionData.getDataTbVal("MODULE_CONFIG", row, "Module Name");
			String sConfigType = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Type");
			String sConfigValue = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Value");
			String sConfigType1 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Type 1");
			String sConfigValue1 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Value 1");
			String sConfigType2 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Type 2");
			String sConfigValue2 = SessionData.getDataTbVal("MODULE_CONFIG", row, "Config Value 2");
			if (!sModuleSection.isEmpty()) {
				if (!previousModuleSection.equals(sModuleSection)) {
					System.out.println("***** INFO ***** : Switch to " + sModuleSection);
					moduleConfigSteps.switch_to_module_config_section(sModuleSection);
				}
				previousModuleSection = sModuleSection;
			} else {
				continue;
			}
			int moduleIndex = 1;
			if (!sModuleName.isEmpty()) {
				String[] asModuleName = sModuleName.split(">");
				// Check path contain index
				int numPath = asModuleName.length;
				if (numPath == 2) {
					if (asModuleName[numPath - 1].contains("[") && asModuleName[numPath - 1].contains("]")) {
						try {
							moduleIndex = Integer.parseInt(asModuleName[numPath - 1].replace("[", "").replace("]", ""));
						} catch (Exception e) {
							fail("Module Config Format Name is not correct : " + sModuleName);
						}
						sModuleName = asModuleName[0];
					} else {
						fail("Module Config Format Name is not correct : " + sModuleName);
					}
				}
			}
			if (!sConfigType.isEmpty() && !sConfigValue.isEmpty()) {
				moduleConfigSteps.set_module_config(sModuleName, moduleIndex, sConfigType, sConfigValue);
			}
			if (!sConfigType1.isEmpty() && !sConfigValue1.isEmpty()) {
				moduleConfigSteps.set_module_config(sModuleName, moduleIndex, sConfigType1, sConfigValue1);
			}

			if (!sConfigType2.isEmpty() && !sConfigValue2.isEmpty()) {
				moduleConfigSteps.set_module_config(sModuleName, moduleIndex, sConfigType2, sConfigValue2);
			}
		}
	}
}
