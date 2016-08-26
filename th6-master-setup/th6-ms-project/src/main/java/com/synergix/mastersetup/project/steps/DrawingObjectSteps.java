package com.synergix.mastersetup.project.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.mastersetup.project.pages.DrawingObjectPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian on 8/4/2016.
 */
public class DrawingObjectSteps extends ScenarioSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DrawingObjectPage onDrawingObject;

	@Step
	public void create_new_drawing_object(String drawingObjectCode, String description, String costItemGroup) {
		onDrawingObject.clickNewBtn();
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterInputFieldCodeWithLabel("Drawing Object Code", drawingObjectCode);

		
		onDrawingObject.enterInputFieldWithLabel("Description", description);
		
		onDrawingObject.enter_cost_item_group(costItemGroup);

		update();
	}

	@Step
	public void add_brand_inventory(String brand, String inventory) {
		onDrawingObject.clickNewBrandInventory();
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterInputAddBrandCode(brand);
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterInputInventoryForBrand(brand, inventory);
		onDrawingObject.waitForAllJSCompletes();

		update();
	}

	@Step
	public void add_labour_budget(String dateFrom, String dateTo, String qty, String uom) {
		onDrawingObject.clickNewLabourBudget();
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterLastDateFrom(dateFrom);
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterDateTo(dateFrom, dateTo);
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterQty(dateFrom, qty);
		onDrawingObject.waitForAllJSCompletes();

		onDrawingObject.enterUOM(dateFrom, uom);
		onDrawingObject.waitForAllJSCompletes();
		update();
	}

	@Step
	public void update() {
		onDrawingObject.clickUpdateBtn();
		onDrawingObject.waitForAllJSCompletes();
		onDrawingObject.clickBtnYesOnConfirmUpdate();
	}

	/**
	 * Created by Zoe on 8/10/2016.
	 */
	@Step
	public void back_to_summary() {
		onDrawingObject.back_to_summary();
	}

	@Step
	public void filter_data(String sCode) {
		onDrawingObject.enter_code_subPanel(sCode);
	}

	@Step
	public void verify_drawing_object_code(String sCode) {
		assertThat(onDrawingObject.get_text_drawing_object_code(), equalTo(sCode));

	}

	@Step
	public void verify_description(String description) {
		assertThat(onDrawingObject.get_text_description(description), equalTo(description));

	}

	@Step
	public void verify_costItem(String costItem) {
		assertThat(onDrawingObject.get_text_cost_Item(), equalTo(costItem));
	}

	@Step
	public void verify_dateFrom(String dateFrom) {
		assertThat(onDrawingObject.get_text_dateFrom(), equalTo(dateFrom));
	}

	@Step
	public void verify_dateTo(String dateTo) {
		assertThat(onDrawingObject.get_text_dateTo(), equalTo(dateTo));
	}

	@Step
	public void verify_qty(String qty) {
		assertThat(onDrawingObject.get_text_qty(), equalTo(qty));
	}

	@Step
	public void verify_uOM(String uom) {
		assertThat(onDrawingObject.get_text_uOM(), equalTo(uom));
	}

	@Step
	public void verify_brand(String sBrand) {
		assertThat(onDrawingObject.get_text_brand(), equalTo(sBrand));
	}

	@Step
	public void verify_inventory(String sInventory) {
		assertThat(onDrawingObject.get_text_inventory(), equalTo(sInventory));
	}

	@Step
	public void check_company(String company) {
		onDrawingObject.chooseCompany(company);
	}

	@Step
	public void click_btn_delete_drawingObject() {
		onDrawingObject.click_btn_delete_drawingObject();
	}

	@Step
	public void click_delete_laborBudget() {
		onDrawingObject.choose_laborBudget();
		onDrawingObject.click_delete_laborBudget();
	}

	@Step
	public void click_delete_brand_inventory() {
		onDrawingObject.choose_brand_inventory();
		onDrawingObject.click_delete_brand_inventory();
	}

	@Step
	public void verify_drawing_object_not_found(String sCode) {
		onDrawingObject.enter_code_mainPanel(sCode);
		assertThat(onDrawingObject.get_result_code(), equalTo("No records found."));
	}
}
