package com.synergix.mastersetup.project;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.steps.MenuNavigationSteps;

import com.synergix.globalsetup.inventory.classification.steps.BrandSteps;
import com.synergix.globalsetup.inventory.steps.InventorySteps;
import com.synergix.globalsetup.inventory.steps.UOMSteps;
import com.synergix.mastersetup.project.steps.CostItemGroupSteps;
import com.synergix.mastersetup.project.steps.DrawingObjectSteps;

import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * 
 * @author Zoe
 *
 */

public class DrawingObjectMaintenanceDefs {

	

	@Steps
	DrawingObjectSteps drawingObject;

	@When("^user creates new drawing object$")
	public void user_creates_new_drawing_object(List<List<String>> drawingOlist) throws Throwable {

		SessionData.addDataTable("drawingObjectTbl", drawingOlist);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("drawingObjectTbl");
		for (int row : testData.keySet()) {
			String sDrawingObjectCode = SessionData.getDataTbVal("drawingObjectTbl", row, "Drawing Object Code");
			String sDescription = SessionData.getDataTbVal("drawingObjectTbl", row, "Description");
			String sCostItemGroup = SessionData.getDataTbVal("drawingObjectTbl", row, "Cost Item Group");
			String sBrand = SessionData.getDataTbVal("drawingObjectTbl", row, "Brand");
			String sInventory = SessionData.getDataTbVal("drawingObjectTbl", row, "Inventory");
			String sDateFrom = SessionData.getDataTbVal("drawingObjectTbl", row, "Date From");
			String sDateTo = SessionData.getDataTbVal("drawingObjectTbl", row, "Date To");
			String sQty = SessionData.getDataTbVal("drawingObjectTbl", row, "Qty");
			String sUom = SessionData.getDataTbVal("drawingObjectTbl", row, "UOM");
			String sCompany = SessionData.getDataTbVal("drawingObjectTbl", row, "Company Name");
			if (!sDrawingObjectCode.isEmpty()) {
				drawingObject.create_new_drawing_object(sDrawingObjectCode, sDescription, sCostItemGroup);
			}

			if (!sBrand.isEmpty()) {
				drawingObject.add_brand_inventory(sBrand, sInventory);
			}

			if (!sDateFrom.isEmpty()) {
				drawingObject.add_labour_budget(sDateFrom, sDateTo, sQty, sUom);
			}
			if (!sCompany.isEmpty()) {
				drawingObject.check_company(sCompany);
			}

		}
		drawingObject.update();
	}

	@Then("^user found down information in the list$")
	public void user_found_down_information_in_the_list(List<List<String>> drawingOlist) throws Throwable {
		drawingObject.back_to_summary();
		SessionData.addDataTable("drawingObjectTbl", drawingOlist);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("drawingObjectTbl");
		for (int row : testData.keySet()) {
			String sDrawingObjectCode = SessionData.getDataTbVal("drawingObjectTbl", row, "Drawing Object Code");
			String sDescription = SessionData.getDataTbVal("drawingObjectTbl", row, "Description");
			String sCostItemGroup = SessionData.getDataTbVal("drawingObjectTbl", row, "Cost Item Group");
			String sBrand = SessionData.getDataTbVal("drawingObjectTbl", row, "Brand");
			String sInventory = SessionData.getDataTbVal("drawingObjectTbl", row, "Inventory");
			String sDateFrom = SessionData.getDataTbVal("drawingObjectTbl", row, "Date From");
			String sDateTo = SessionData.getDataTbVal("drawingObjectTbl", row, "Date To");
			String sQty = SessionData.getDataTbVal("drawingObjectTbl", row, "Qty");
			String sUom = SessionData.getDataTbVal("drawingObjectTbl", row, "UOM");

			drawingObject.filter_data(sDrawingObjectCode);
			drawingObject.verify_description(sDescription);
			drawingObject.verify_costItem(sCostItemGroup);
			drawingObject.verify_dateFrom(sDateFrom);
			drawingObject.verify_dateTo(sDateTo);
			drawingObject.verify_qty(sQty);
			drawingObject.verify_uOM(sUom);
			drawingObject.verify_brand(sBrand);
			drawingObject.verify_inventory(sInventory);

		}

	}

	@Then("^user delete drawing object then that drawing object is not found in the list$")
	public void user_delete_drawing_object_then_that_drawing_object_is_not_found_in_the_list(
			List<List<String>> drawingOlist) throws Throwable {
		SessionData.addDataTable("drawingObjectTbl", drawingOlist);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("drawingObjectTbl");
		for (int row : testData.keySet()) {
			String sDrawingObjectCode = SessionData.getDataTbVal("drawingObjectTbl", row, "Drawing Object Code");
			drawingObject.click_delete_laborBudget();
			drawingObject.click_delete_brand_inventory();
			drawingObject.click_btn_delete_drawingObject();
			drawingObject.verify_drawing_object_not_found(sDrawingObjectCode);
		}

	}
}
