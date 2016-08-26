package com.synergix.mastersetup.others.pricecost.sellingprice;

import com.synergix.common.CONST;
import com.synergix.globalsetup.inventory.classification.steps.*;
import com.synergix.globalsetup.inventory.steps.*;
import com.synergix.globalsetup.party.customer.steps.GlobalCustomerCategorySteps;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.mastersetup.others.pricecost.sellingprice.steps.ListPriceDiscountSteps;
import com.synergix.mastersetup.party.customer.customer.steps.IndustrySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ListPriceDiscountDefs {
	/* Create by: Lily Hoang */

	@Steps
	ListPriceDiscountSteps listPriceDiscountStep;
	@Steps
	BrandSteps brandStep;
	@Steps
	InventorySteps inventory;
	@Steps
	IndustrySteps industry;
	@Steps
	GlobalCustomerCategorySteps cusCategory;
	public String idFrame = "idF";

	public String idFrameCusCategory = "customerCategoryDiscount";
	public String idFrameInvBrand = "customerCategoryBrandDiscount";
	public String idFrameInventory = "customerInventoryDiscount";
	public String idFrameCusIndustry = "customerIndustryInventoryDiscount";

	@When("^Customer Category is created as in \"([^\"]*)\"$")
	public void customer_custegory_is_created_as_in_something(String file) throws Throwable {

		String fileName = System.getProperty("user.dir") + CONST.FIN_INVENTORY + file;
		SessionData.addDataTable("TEST_EXCEL", fileName, "Customer Category", false);
		for (int row : SessionData.getDataTbRowsNoHeader("TEST_EXCEL").keySet()) {
			String s1 = SessionData.getDataTbVal("TEST_EXCEL", row, "Customer Category Code");
			String s2 = SessionData.getDataTbVal("TEST_EXCEL", row, "Description");
			String s3 = SessionData.getDataTbVal("TEST_EXCEL", row, "Customer Type");
			System.out.println(row + ": " + s1 + "-" + s2 + "-");

			cusCategory.create_new_customer_category(s1, s2, s3);

		}

	}

	@When("^Inventory Brand is created as in \"([^\"]*)\"$")
	public void inventory_brand_is_created_as_in_something(String file) throws Throwable {

		String fileName = System.getProperty("user.dir") + CONST.FIN_INVENTORY + file;
		SessionData.addDataTable("TEST_EXCEL", fileName, "Inventory Brand", false);
		for (int row : SessionData.getDataTbRowsNoHeader("TEST_EXCEL").keySet()) {
			String s1 = SessionData.getDataTbVal("TEST_EXCEL", row, "Inventory Brand Code");
			String s2 = SessionData.getDataTbVal("TEST_EXCEL", row, "Description");
			System.out.println(row + ": " + s1 + "-" + s2 + "-");
			brandStep.create_new_brand(s1, s2);

		}

	}

	@When("^Inventory Code is created as in \"([^\"]*)\"$")
	public void inventory_code_is_created_as_in_something(String file) throws Throwable {

		String fileName = System.getProperty("user.dir") + CONST.FIN_INVENTORY + file;
		SessionData.addDataTable("TEST_EXCEL", fileName, "Inventory Code", false);
		for (int row : SessionData.getDataTbRowsNoHeader("TEST_EXCEL").keySet()) {
			String s1 = SessionData.getDataTbVal("TEST_EXCEL", row, "Inventory Code");
			String s2 = SessionData.getDataTbVal("TEST_EXCEL", row, "Description");
			String s3 = SessionData.getDataTbVal("TEST_EXCEL", row, "Inventory Class");
			String s4 = SessionData.getDataTbVal("TEST_EXCEL", row, "Base UOM");
			String s5 = SessionData.getDataTbVal("TEST_EXCEL", row, "Inventory Brand");
			System.out.println(row + ": " + s1 + "-" + s2 + "-" + s3 + "-" + s4 + "-" + s5);
			inventory.create_new_inventory_item(s1, s2, s3, s4, s5);

		}

	}

	@When("^Customer Industry is created as in \"([^\"]*)\"$")
	public void customer_industry_is_created_as_in_something(String file) throws Throwable {

		String fileName = System.getProperty("user.dir") + CONST.FIN_INVENTORY + file;
		SessionData.addDataTable("TEST_EXCEL", fileName, "Customer Industry", false);

		for (int row : SessionData.getDataTbRowsNoHeader("TEST_EXCEL").keySet()) {
			String s1 = SessionData.getDataTbVal("TEST_EXCEL", row, "Industry Code");
			String s2 = SessionData.getDataTbVal("TEST_EXCEL", row, "Description");

			System.out.println(row + ": " + s1 + "-" + s2 + "-");
			industry.create_new_industry(s1, s2);

		}

	}

	@When("^I want to create a new List Price Discount by Customer Category as the following with Key as \"([^\"]*)\"$")
	public void i_want_to_create_a_new_list_price_discount_by_customer_category_as_the_following_with_key_as_something(
			String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("CUSCATEGORYTBL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("CUSCATEGORYTBL", "Key", dataKey);
		String idFrame = idFrameCusCategory;
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("CUSCATEGORYTBL", row, "Key");
			String sCustomerCategory = SessionData.getDataTbVal("CUSCATEGORYTBL", row, "Customer Category");
			String sDescription = SessionData.getDataTbVal("CUSCATEGORYTBL", row, "Description");
			if (!sKey.isEmpty()) {
			}
			if (!sCustomerCategory.isEmpty() && listPriceDiscountStep.is_value_exist_in_table(idFrame,
					sCustomerCategory, sDescription) == false) {
				listPriceDiscountStep.click_btn_add_new_table_with_frame_id(idFrame);
				listPriceDiscountStep.enter_customer_category_textbox(sCustomerCategory);
				assertThat(listPriceDiscountStep.get_text_in_cell_code(idFrame)).isEqualTo(sDescription);
			}

		}

	}

	@Then("^The Price Lice Discount should be displayed on Review Grade List as the followng with Key as \"([^\"]*)\"$")
	public void the_review_grade_should_be_displayed_on_review_grade_list_as_the_followng_with_key_as_something(
			String dataKey) {
	}

	@And("^The Discount List is listed as the following as the as \"([^\"]*)\"$")
	public void the_discount_list_is_listed_as_the_following_as_the_as_something(String dataKey,
			List<List<String>> dataTable) throws ParseException {
		SessionData.addDataTable("DISCOUNTTBL", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("DISCOUNTTBL", "Key", dataKey);
		String idFrame = "";
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("DISCOUNTTBL", row, "Key");
			String sType = SessionData.getDataTbVal("DISCOUNTTBL", row, "Frame Name");
			String sEffectiveDateFrom = SessionData.getDataTbVal("DISCOUNTTBL", row, "Effective Date From");
			String sEffectiveDateTo = SessionData.getDataTbVal("DISCOUNTTBL", row, "Effective Date To");
			String sDiscount = SessionData.getDataTbVal("DISCOUNTTBL", row, "Discount");

			if (!sKey.isEmpty()) {
			}
			if (!sType.isEmpty() && !sDiscount.isEmpty()) {

				switch (sType) {
				case "Customer Category":
					idFrame = "customerCategoryDiscount";
					break;
				case "Inventory Brand and Customer Category":
					idFrame = "customerCategoryBrandDiscount";
					break;
				case "Inventory and Customer Category":
					idFrame = "customerInventoryDiscount";
					break;
				case "Inventory and Customer Industry":
					idFrame = idFrameCusIndustry;
					break;
				}
				sEffectiveDateFrom = listPriceDiscountStep.find_max_effective_date_from(idFrame);
				listPriceDiscountStep.enter_effective_date_table(idFrame, sEffectiveDateFrom, sDiscount);
			}

			assertThat(listPriceDiscountStep.assert_date_to_previous_detail(idFrame, sEffectiveDateFrom))
					.isEqualTo(true);

		}

		assertThat(listPriceDiscountStep.get_text_latest_effective_with_frame_id(idFrame))
				.isEqualTo(listPriceDiscountStep.get_text_last_effective_date_from(idFrame));
		assertThat(listPriceDiscountStep.get_text_lastest_discount(idFrame))
				.isEqualTo(listPriceDiscountStep.get_discount_with_frame_id(idFrame));
		listPriceDiscountStep.click_btn_collapse_with_frame_id(idFrame);
	}

	@And("^I want to create a new List Price Discount by Inventory Brand and Customer Category as the following with Key as \"([^\"]*)\"$")
	public void i_want_to_create_a_new_list_price_discount_by_inventory_brand_and_customer_category_as_the_following_with_key_as_something(
			String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("INVBRANDTBL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("INVBRANDTBL", "Key", dataKey);
		String idFrame = idFrameInvBrand;
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("INVBRANDTBL", row, "Key");
			String sInventoryBrand = SessionData.getDataTbVal("INVBRANDTBL", row, "Inventory Brand");
			String sCustomerCategory = SessionData.getDataTbVal("INVBRANDTBL", row, "Customer Category");
			String sDescription = SessionData.getDataTbVal("INVBRANDTBL", row, "Description");
			if (!sKey.isEmpty()) {
			}
			if (!sInventoryBrand.isEmpty()
					&& listPriceDiscountStep.is_value_exist_in_table(idFrame, sInventoryBrand, sDescription) == false) {
				listPriceDiscountStep.is_value_exist_in_table(idFrame, "", "");
				listPriceDiscountStep.click_btn_add_new_table_with_frame_id(idFrame);
				listPriceDiscountStep.enter_inventory_brand(sInventoryBrand);

				listPriceDiscountStep.select_in_customer_category_combo_with_frame_id(idFrame, sCustomerCategory);
			}
			assertThat(listPriceDiscountStep.get_text_in_cell_code(idFrame)).isEqualTo(sDescription);
			assertThat(listPriceDiscountStep.get_text_customer_category_or_industry_combo(idFrame))
					.isEqualTo(sCustomerCategory);
		}
	}

	@And("^I want to create a new List Price Discount by Inventory and Customer Category as the following with Key as \"([^\"]*)\"$")
	public void i_want_to_create_a_new_list_price_discount_by_inventory_and_customer_category_as_the_following_with_key_as_something(
			String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("INVENTORY", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("INVENTORY", "Key", dataKey);
		String idFrame = idFrameInventory;
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("INVENTORY", row, "Key");
			String sInventoryCode = SessionData.getDataTbVal("INVENTORY", row, "Inventory Code");
			String sCustomerCategory = SessionData.getDataTbVal("INVENTORY", row, "Customer Category");
			String sDescription = SessionData.getDataTbVal("INVENTORY", row, "Description");
			if (!sKey.isEmpty()) {
			}
			if (!sInventoryCode.isEmpty()
					&& listPriceDiscountStep.is_value_exist_in_table(idFrame, sInventoryCode, sDescription) == false) {
				listPriceDiscountStep.is_value_exist_in_table(idFrame, "", "");
				listPriceDiscountStep.click_btn_add_new_table_with_frame_id(idFrame);
				listPriceDiscountStep.enter_inventory_code(sInventoryCode);
				listPriceDiscountStep.select_in_customer_category_combo_with_frame_id(idFrame, sCustomerCategory);
			}
			assertThat(listPriceDiscountStep.get_text_in_cell_code(idFrame)).isEqualTo(sDescription);
			assertThat(listPriceDiscountStep.get_text_customer_category_or_industry_combo(idFrame))
					.isEqualTo(sCustomerCategory);
		}
	}

	@And("^I want to create a new List Price Discount by Inventory and Customer Industry  as the following with Key as \"([^\"]*)\"$")
	public void i_want_to_create_a_new_list_price_discount_by_inventory_and_customer_industry_as_the_following_with_key_as_something(
			String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("CUSINDUSTRY", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		String idFrame = idFrameCusIndustry;
		testData = SessionData.getDataTbRowsByValEqualInCol("CUSINDUSTRY", "Key", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("CUSINDUSTRY", row, "Key");
			String sInventoryCode = SessionData.getDataTbVal("CUSINDUSTRY", row, "Inventory Code");
			String sCustomerCategory = SessionData.getDataTbVal("CUSINDUSTRY", row, "Customer Industry");
			String sDescription = SessionData.getDataTbVal("CUSINDUSTRY", row, "Description");
			if (!sKey.isEmpty()) {
			}
			if (!sInventoryCode.isEmpty()
					&& listPriceDiscountStep.is_value_exist_in_table(idFrame, sInventoryCode, sDescription) == false) {
				listPriceDiscountStep.is_value_exist_in_table(idFrame, "", "");
				listPriceDiscountStep.click_btn_add_new_table_with_frame_id(idFrame);
				listPriceDiscountStep.enter_inventory_code_industry(sInventoryCode);

				listPriceDiscountStep.select_in_customer_category_combo_with_frame_id(idFrame, sCustomerCategory);
			}
			assertThat(listPriceDiscountStep.get_text_in_cell_code(idFrame)).isEqualTo(sDescription);
			assertThat(listPriceDiscountStep.get_text_customer_category_or_industry_combo(idFrame))
					.isEqualTo(sCustomerCategory);

		}
	}

	@When("^I want to delete value in Discount table with the key as \"([^\"]*)\"$")
	public void i_want_to_delete_value_in_discount_table_with_the_key_as_something(String dataKey,
			List<List<String>> dataTable) {

		SessionData.addDataTable("DELTABLE", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("DELTABLE", "Key", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("DELTABLE", row, "Key");
			String sFrameName = SessionData.getDataTbVal("DELTABLE", row, "Frame Name");
			String sDescription = SessionData.getDataTbVal("DELTABLE", row, "Description");
			String sDeletedValue = SessionData.getDataTbVal("DELTABLE", row, "Deleted Value");
			System.out.println("sau khi load");
			switch (sFrameName) {
			case "Customer Category":
				idFrame = "customerCategoryDiscount";
				break;
			case "Inventory Brand and Customer Category":
				idFrame = "customerCategoryBrandDiscount";
				break;
			case "Inventory and Customer Category":
				idFrame = "customerInventoryDiscount";
				break;
			case "Inventory and Customer Industry":
				idFrame = idFrameCusIndustry;
				break;
			}

			if (listPriceDiscountStep.is_value_exist_in_table(idFrame, sDeletedValue, sDescription) == true) {
				listPriceDiscountStep.check_checkbox_table_with_frame_id(idFrame);
				listPriceDiscountStep.click_btn_delete_table_with_frame_id(idFrame);
				listPriceDiscountStep.confirm_yes();
			}
		}

	}

}
