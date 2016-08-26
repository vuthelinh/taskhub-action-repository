package com.synergix.definition.test;

import static org.junit.Assert.fail;

import java.util.List;

import com.synergix.processing.sales.steps.SystemSetupSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * @author Vincent
 * @version 20160303
 */
public class SalesSystemSetupDefs {

	@Steps
	SystemSetupSteps systemConfigSteps;

	@Then("^user changes Sales System Setup$")
	public void user_changes_System_Config(List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SALES_SYSTEM_SETUP", dataTable, false);
		String previousSystemSection = "";
		for (int row : SessionData.getDataTbRows("SALES_SYSTEM_SETUP").keySet()) {
			if (row == 0) {
				continue;
			}
			String sSystemSection = SessionData.getDataTbVal("SALES_SYSTEM_SETUP", row, "System Section");
			String sSystemName = SessionData.getDataTbVal("SALES_SYSTEM_SETUP", row, "System Name");
			String sConfigType1 = SessionData.getDataTbVal("SALES_SYSTEM_SETUP", row, "Config Type 1");
			String sConfigValue1 = SessionData.getDataTbVal("SALES_SYSTEM_SETUP", row, "Config Value 1");
			String sConfigType2 = SessionData.getDataTbVal("SALES_SYSTEM_SETUP", row, "Config Type 2");
			String sConfigValue2 = SessionData.getDataTbVal("SALES_SYSTEM_SETUP", row, "Config Value 2");
			if (!sSystemSection.isEmpty()) {
				if (previousSystemSection != sSystemSection) {
					systemConfigSteps.switch_to_system_config_section(sSystemSection);
				}
				previousSystemSection = sSystemSection;
			} else {
				continue;
			}
			int systemIndex = 1;
			if (!sSystemName.isEmpty()) {
				String[] asSystemName = sSystemName.split(">");
				// Check path contain index
				int numPath = asSystemName.length;
				if (numPath == 2) {
					if (asSystemName[numPath - 1].contains("[") && asSystemName[numPath - 1].contains("]")) {
						try {
							systemIndex = Integer.parseInt(asSystemName[numPath - 1].replace("[", "").replace("]", ""));
						} catch (Exception e) {
							fail("System Config Format Name is not correct : " + sSystemName);
						}
						sSystemName = asSystemName[0];
					} else {
						fail("System Config Format Name is not correct : " + sSystemName);
					}
				}
			}
			if (!sConfigType1.isEmpty() && !sConfigValue1.isEmpty()) {
				systemConfigSteps.set_system_config(sSystemName, systemIndex, sConfigType1, sConfigValue1);
			}

			if (!sConfigType2.isEmpty() && !sConfigValue2.isEmpty()) {
				systemConfigSteps.set_system_config(sSystemName, systemIndex, sConfigType2, sConfigValue2);
			}
		}
	}

}
