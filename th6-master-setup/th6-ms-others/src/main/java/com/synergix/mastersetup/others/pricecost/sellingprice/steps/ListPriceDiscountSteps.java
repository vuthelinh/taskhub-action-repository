package com.synergix.mastersetup.others.pricecost.sellingprice.steps;

import java.text.ParseException;
import static org.assertj.core.api.Assertions.assertThat;

import com.synergix.mastersetup.others.pricecost.sellingprice.page.ListPriceDiscountPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/* Create by: Lily Hoang */
public class ListPriceDiscountSteps extends ScenarioSteps {

	ListPriceDiscountPage listPriceDiscountpage;

	// Frame Discount by Customer Category
	@Step
	public void click_btn_add_new_table_with_frame_id(String idFrame) {
		listPriceDiscountpage.click_btn_add_new_table_with_frame_id(idFrame);
	}

	@Step
	public void click_btn_delete_table_with_frame_id(String idFrame) {
		listPriceDiscountpage.click_btn_delete_table_with_frame_id(idFrame);
	}

	@Step
	public void check_checkbox_table_with_frame_id(String idFrame) {
		listPriceDiscountpage.check_checkbox_table_with_frame_id(idFrame);
	}

	@Step
	public void uncheck_checkbox_table_with_frame_id(String idFrame) {
		listPriceDiscountpage.uncheck_checkbox_table_with_frame_id(idFrame);
	}

	@Step
	public void enter_textbox_search_with_frame_id(String idFrame, String value) {
		listPriceDiscountpage.enter_textbox_search_with_frame_id(idFrame, value);
	}

	@Step
	public void click_btn_expand_with_frame_id(String idFrame) {
		listPriceDiscountpage.click_btn_expand_with_frame_id(idFrame);
	}

	@Step
	public void click_btn_add_new_detail_with_frame_id(String idFrame) {
		listPriceDiscountpage.click_btn_add_new_detail_with_frame_id(idFrame);
	}

	@Step
	public void click_btn_delete_detail_with_frame_id(String idFrame) {
		listPriceDiscountpage.click_btn_delete_detail_with_frame_id(idFrame);
	}

	@Step
	public void enter_customer_category_textbox(String customerCategory) {
		listPriceDiscountpage.enter_customer_category_textbox(customerCategory);
	}

	@Step
	public String get_text_in_cell_code(String idFrame) {
		return listPriceDiscountpage.get_text_in_cell_code(idFrame);
	}

	@Step
	public boolean is_readonly_customer_category_textbox() {
		return listPriceDiscountpage.is_readonly_customer_category_textbox();

	}

	public void select_in_customer_category_combo_with_frame_id(String idFrame, String value) {
		listPriceDiscountpage.select_in_customer_category_combo_with_frame_id(idFrame, value);
	}

	// Private
	@Step
	public void enter_inventory_brand(String inventoryBrand) {
		listPriceDiscountpage.enter_inventory_brand(inventoryBrand);
	}

	@Step
	public void enter_inventory_code(String inventoryCode) {
		listPriceDiscountpage.enter_inventory_code(inventoryCode);
	}

	@Step
	public void enter_inventory_code_industry(String inventoryCode) {
		listPriceDiscountpage.enter_inventory_code_industry(inventoryCode);
	}

	@Step
	public void enter_effective_date_from(String idFrame, String effectiveDateFrom) {
		listPriceDiscountpage.enter_effective_date_from(idFrame, effectiveDateFrom);
	}

	@Step
	public void enter_discount(String idFrame, String discount) {
		listPriceDiscountpage.enter_discount_in_last_row(idFrame, discount);
	}

	@Step
	public int get_ri_effective_date_from_with_frame_id(String idFrame, String effectiveDateFrom) {
		return listPriceDiscountpage.get_ri_effective_date_from_with_frame_id(idFrame, effectiveDateFrom);
	}

	@Step
	public int count_row_effective_date_from(String idFrame) {

		return listPriceDiscountpage.count_row_effective_date_from(idFrame);
	}

	@Step
	public void check_del(String idFrame, String effectiveDateFrom) {

		listPriceDiscountpage.check_del_detail(idFrame, effectiveDateFrom);
	}

	@Step
	public void uncheck_del(String idFrame, String effectiveDateFrom) {

		listPriceDiscountpage.uncheck_del_detail(idFrame, effectiveDateFrom);
	}

	@Step
	public String get_text_last_effective_date_from(String idFrame) {
		return listPriceDiscountpage.get_text_lastest_effective_date_from(idFrame);
	}

	@Step
	public String get_text_latest_effective_with_frame_id(String idFrame) {
		return listPriceDiscountpage.get_text_latest_effective_with_frame_id(idFrame);
	}

	@Step
	public String get_text_customer_category_or_industry_combo(String idFrame) {
		return listPriceDiscountpage.get_text_customer_category_or_industry_combo(idFrame);
	}

	@Step
	public String get_text_effective_date_to_in_row(String idFrame, int ri) {
		return listPriceDiscountpage.get_text_effective_date_to_in_row(idFrame, ri);

	}

	@Step
	public void enter_effective_date_table(String idFrame, String effectiveDateFrom, String discount)
			throws ParseException {
		listPriceDiscountpage.click_btn_expand_with_frame_id(idFrame);
		listPriceDiscountpage.click_btn_add_new_detail_with_frame_id(idFrame);
		listPriceDiscountpage.enter_effective_date_from(idFrame, effectiveDateFrom);
		waitABit(2000);
		listPriceDiscountpage.enter_discount_in_last_row(idFrame, discount);
		String disActual = listPriceDiscountpage.get_text_discount_detail_in_row(idFrame, 0);
		int ind = disActual.indexOf(".") + 1;
		String sub = disActual.substring(ind);
		if (sub.equals("0")) {
			disActual = disActual + "0";
		}
		assertThat(disActual).isEqualTo(discount);

	}

	@Step
	public String find_max_effective_date_from(String idFrame) {
		return listPriceDiscountpage.find_max_effective_date_from(idFrame);
	}

	@Step
	public boolean is_value_exist_in_table(String idFrame, String code, String desc) {
		return listPriceDiscountpage.is_value_exist_in_frame_id(idFrame, code, desc);

	}

	@Step
	public boolean assert_date_to_previous_detail(String idFrame, String effectiveDateFrom) {
		return listPriceDiscountpage.assert_date_to_previous_detail(idFrame, effectiveDateFrom);
	}

	@Step
	public void click_btn_collapse_with_frame_id(String idFrame) {
		listPriceDiscountpage.click_btn_collapse_with_frame_id(idFrame);
	}

	@Step
	public String get_text_lastest_discount(String idFrame) {
		return listPriceDiscountpage.get_text_lastest_discount(idFrame);
	}

	@Step
	public String get_discount_with_frame_id(String idFrame) {
		return listPriceDiscountpage.get_discount_with_frame_id(idFrame);
	}

	@Step
	public void confirm_yes() {
		listPriceDiscountpage.confirm_yes();
	}

}
