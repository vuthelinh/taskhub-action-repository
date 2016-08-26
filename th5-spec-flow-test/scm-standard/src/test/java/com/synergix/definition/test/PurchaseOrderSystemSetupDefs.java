package com.synergix.definition.test;

import static org.junit.Assert.fail;

import java.util.List;

import com.synergix.processing.purchase.purchaseorder.steps.SystemSetupSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * @author Vincent
 * @version 20160303
 */
public class PurchaseOrderSystemSetupDefs {

	@Steps
	SystemSetupSteps systemConfigSteps;

	@Then("^user changes Purchase Order System Setup$")
	public void user_changes_Purchase_Order_System_Config(List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PURCHASE_ORDER_SYSTEM_SETUP", dataTable, false);
		for (int row : SessionData.getDataTbRows("PURCHASE_ORDER_SYSTEM_SETUP").keySet()) {
			if (row == 0) {
				continue;
			}
			String sSystemName = SessionData.getDataTbVal("PURCHASE_ORDER_SYSTEM_SETUP", row, "System Name");
			String sConfigType1 = SessionData.getDataTbVal("PURCHASE_ORDER_SYSTEM_SETUP", row, "Config Type 1");
			String sConfigValue1 = SessionData.getDataTbVal("PURCHASE_ORDER_SYSTEM_SETUP", row, "Config Value 1");
			String sConfigType2 = SessionData.getDataTbVal("PURCHASE_ORDER_SYSTEM_SETUP", row, "Config Type 2");
			String sConfigValue2 = SessionData.getDataTbVal("PURCHASE_ORDER_SYSTEM_SETUP", row, "Config Value 2");

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
							fail("Purchase Order System Config Format Name is not correct : " + sSystemName);
						}
						sSystemName = asSystemName[0];
					} else {
						fail("Purchase Order System Config Format Name is not correct : " + sSystemName);
					}
				}
			} else {
				continue;
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
