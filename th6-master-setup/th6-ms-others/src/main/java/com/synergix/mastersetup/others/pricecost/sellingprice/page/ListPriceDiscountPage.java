package com.synergix.mastersetup.others.pricecost.sellingprice.page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConstants;

import org.jruby.RubyProcess.Sys;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sun.jna.platform.win32.OaIdl.DATE;
import com.synergix.common.TH6PageObject;
import com.synergix.utilities.DateTimeUtil;

import net.serenitybdd.core.pages.WebElementFacade;
/* Create by: Lily Hoang */
public class ListPriceDiscountPage extends TH6PageObject {

	public ListPriceDiscountPage(WebDriver driver) {
		super(driver);
	}

	public String idFrameCusCategory = "customerCategoryDiscount";
	public String idFrameInvBrand = "customerCategoryBrandDiscount";
	public String idFrameInventory = "customerInventoryDiscount";
	public String idFrameCusIndustry = "customerIndustryInventoryDiscount";

	public String xPathTxtCusCategory = "(//*[@id='syn:invSalesMarginCostFr:customerCategoryDiscount']//input[contains(@id,'autoComplete_input')])[last()]";
	public String xPathTxtInvBrand = "(//*[@id='syn:invSalesMarginCostFr:customerCategoryBrandDiscount']//input[contains(@id,'autoComplete_input')])[last()]";
	public String xPathTxtInventory = "(//*[@id='syn:invSalesMarginCostFr:customerInventoryDiscount']//input[contains(@id,'autoComplete_input')])[last()]";
	public String xPathTxtInventoryInd = "(//*[@id='syn:invSalesMarginCostFr:customerIndustryInventoryDiscount']//input[contains(@id,'autoComplete_input')])[last()]";

	// TABLE
	public String xpath_btn_add_new_table_with_frame_id(String idFrame) {
		String xPathBtnAddNewTable = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@class,'header')]//span[@class='synfaces-float-left']/button";
		return xPathBtnAddNewTable;
	}

	public String xpath_btn_delete_table_with_frame_id(String idFrame) {
		String xPathBtnAddNewTable = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@class,'header')]//span[@class='synfaces-float-right']/button";
		return xPathBtnAddNewTable;
	}

	public String xpath_btn_add_new_detail_with_frame_id(String idFrame) {
		String xPathBtnAddNewTable = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@class,'tablewrapper')]//span[@class='synfaces-float-left']/button";
		return xPathBtnAddNewTable;
	}

	public void click_btn_add_new_detail_with_frame_id(String idFrame) {
		waitElementToBePresent(xpath_btn_add_new_detail_with_frame_id(idFrame)).waitUntilClickable().click();
	}

	public String xpath_btn_delete_detail_with_frame_id(String idFrame) {
		String xPathBtnAddNewTable = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@class,'tablewrapper')]//span[@class='synfaces-float-right']/button";
		return xPathBtnAddNewTable;
	}

	public String xpath_checkbox_table_with_frame_id(String idFrame) {
		String xPathBtnAddNewTable = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@class,'tablewrapper')]//span[contains(@id,'standardCost')]/parent::td/following-sibling::td//input[@type='checkbox']";
		return xPathBtnAddNewTable;
	}

	public String xpath_checkbox_table_with_frame_id_and_date_From(String idFrame, String dateFrom) {
		String xPathBtnAddNewTable = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@class,'tablewrapper')]//input[@value='" + dateFrom
				+ "']/ancestor-or-self::td[1]/following-sibling::td/input[@type='checkbox']";
		return xPathBtnAddNewTable;
	}

	public String xpath_textbox_search_with_frame_id(String idFrame) {
		String xPathTxtSearch = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//th[2]//input[contains(@id,'filter')]";
		return xPathTxtSearch;
	}

	public void enter_textbox_search_with_frame_id(String idFrame, String value) {
		waitTypeAndEnter(xpath_textbox_search_with_frame_id(idFrame), value);
		waitForAllJSCompletes();
	}

	public boolean is_value_exist_in_frame_id(String idFrame, String code, String desc) {
		enter_textbox_search_with_frame_id(idFrame, code);
		boolean is_exist = false;
		String xPath = "//*[@id='syn:invSalesMarginCostFr:" + idFrame + "']//input[contains(@id,'autoComplete_input')]";
		if (isElementExist(xPath)) {
			String actual = waitElementToBePresent(xPath).getAttribute("value");
			if (actual.equals(desc)) {
				is_exist = true;
			}
		} else {
			is_exist = false;
		}
		return is_exist;
	}

	public void click_btn_expand_with_frame_id(String idFrame) {
		String xPathBtnExpand = "//*[@id='syn:invSalesMarginCostFr:" + idFrame + "']//div[@aria-label='Toggle Row']";
		String is_expanded = waitElementToBePresent(xPathBtnExpand).getAttribute("aria-expanded");
		if (is_expanded.equals("false")) {
			waitElementToBeClickable(xPathBtnExpand).click();
		}
		waitForAllJSCompletes();

	}

	public void click_btn_collapse_with_frame_id(String idFrame) {
		String xPathBtnExpand = "//*[@id='syn:invSalesMarginCostFr:" + idFrame + "']//div[@aria-label='Toggle Row']";
		String is_expanded = waitElementToBePresent(xPathBtnExpand).getAttribute("aria-expanded");
		if (is_expanded.equals("true")) {
			waitElementToBeClickable(xPathBtnExpand).click();
		}
		waitForAllJSCompletes();

	}

	public String get_text_latest_effective_with_frame_id(String idFrame) {
		String xPathLabelLastestEffective = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//span[contains(@id,'latestEffectiveStartDate')]";
		return waitElementToBePresent(xPathLabelLastestEffective).getTextValue();
	}

	public String get_discount_with_frame_id(String idFrame) {
		String xPathLabelLastestEffective = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//span[contains(@id,'standardCost')]";
		return waitElementToBePresent(xPathLabelLastestEffective).getTextValue();
	}

	public String get_text_customer_category_or_industry_combo(String idFrame) {
		String xPath = "//*[@id='syn:invSalesMarginCostFr:" + idFrame + "']//div[contains(@id,'category')]//label";
		return waitElementToBePresent(xPath).getTextValue();
	}

	public String xpath_effective_date_from(String idFrame) {
		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[last()]//input[contains(@id,'effectiveDateFrom_input')]";
		return xPath;
	}

	// Input table

	public void click_btn_add_new_table_with_frame_id(String idFrame) {
		waitElementToBePresent(xpath_btn_add_new_table_with_frame_id(idFrame)).waitUntilClickable().click();
	}

	public void click_btn_delete_table_with_frame_id(String idFrame) {
		waitElementToBePresent(xpath_btn_delete_table_with_frame_id(idFrame)).waitUntilClickable().click();
	}

	public void check_checkbox_table_with_frame_id(String idFrame) {
		clickOnElement(xpath_checkbox_table_with_frame_id(idFrame));
	}

	public void uncheck_checkbox_table_with_frame_id(String idFrame) {
		uncheckChkbox(xpath_checkbox_table_with_frame_id(idFrame));
	}

	public void select_in_customer_category_combo_with_frame_id(String idFrame, String value) {
		waitABit(2000);
		String xPathCboCusCategory = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'category')]//span";
		waitElementToBePresent(xPathCboCusCategory).click();
		waitForAllJSCompletes();
		waitABit(2000);
		selectDdlByTextTH6(value);
		waitForAllJSCompletes();
	}

	// Input
	public void enter_customer_category_textbox(String customerCategory) {
		waitForAllJSCompletes();
		//waitElementToBePresent(xPathTxtCusCategory).type(customerCategory);
		/*waitABit(2000);
		waitForAllJSCompletes();*/
		$(xPathTxtCusCategory).waitUntilPresent().type(customerCategory);
       // waitFor(ExpectedConditions.attributeToBe(By.xpath(xPathTxtCusCategory), "value", customerCategory));
		waitABit(2000);
        $(xPathTxtCusCategory).waitUntilVisible().sendKeys(Keys.ENTER);
        waitForAllJSCompletes();
		
	}

	public String get_text_in_cell_code(String idFrame) {
		waitForAllJSCompletes();

		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//input[contains(@id,'autoComplete_input')])[last()]";
		return waitElementToBePresent(xPath).getAttribute("value");

	}

	public boolean is_readonly_customer_category_textbox() {
		
	//	return $(xPathTxtCusCategory).isEnabled();
		if (waitElementToBePresent(xPathTxtCusCategory).getAttribute("aria-readonly") == "true") {
			return true;
		} else {
			return false;
		}

	}

	public void enter_inventory_brand(String inventoryBrand) {
		waitForAllJSCompletes();
		waitElementToBePresent(xPathTxtInvBrand).type(inventoryBrand);
		waitABit(2000);
		waitForAllJSCompletes();
		$(xPathTxtInvBrand).sendKeys(Keys.ENTER);
		waitForAllJSCompletes();
	}

	public void enter_Inventory_search(String inventory) {
		waitTypeAndEnter(xpath_textbox_search_with_frame_id(idFrameInventory), inventory);
	}

	public void enter_inventory_code(String inventoryCode) {
		waitElementToBePresent(xPathTxtInventory).type(inventoryCode);
		waitForAllJSCompletes();
		waitABit(2000);
		
		$(xPathTxtInventory).sendKeys(Keys.ENTER);
		waitForAllJSCompletes();
	}

	public void enter_inventory_code_industry(String inventoryCode) {
		waitForAllJSCompletes();
		waitElementToBePresent(xPathTxtInventoryInd).type(inventoryCode);
			waitForAllJSCompletes();
		waitABit(2000);
		waitFor(ExpectedConditions.attributeToBe(By.xpath(xPathTxtInventoryInd), "value", inventoryCode));
		
		$(xPathTxtInventoryInd).sendKeys(Keys.ENTER);

	}

	/// Detail
	public void click_btn_delete_detail_with_frame_id(String idFrame) {
		waitElementToBePresent(xpath_btn_delete_detail_with_frame_id(idFrame)).waitUntilClickable().click();
	}

	public void enter_effective_date_from(String idFrame, String effectiveDateFrom) {
		waitForAllJSCompletes();
		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[last()]//input[contains(@id,'effectiveDateFrom_input')]";
		waitTypeAndTabEnterThenUpdateDate(xPath, effectiveDateFrom);
		waitForAllJSCompletes();

	}

	public String get_text_lastest_effective_date_from(String idFrame) {
		waitForAllJSCompletes();
		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[last()]//input[contains(@id,'effectiveDateFrom_input')]";
		return waitElementToBePresent(xPath).getAttribute("value");
	}

	public String get_text_lastest_discount(String idFrame) {
		waitForAllJSCompletes();
		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[last()]//input[contains(@id,'standardCost')]";
		String discount = waitElementToBePresent(xPath).getAttribute("value");
		int ind = discount.indexOf(".") + 1;
		String sub = discount.substring(ind);
		if (sub.equals("0")) {
			discount = discount + "0";
		}

		return discount;
	}

	public String get_text_effective_date_to_in_row(String idFrame, int ri) {
		waitForAllJSCompletes();

		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[" + ri + "]//td[2]";
		return waitElementToBePresent(xPath).getTextValue();

	}

	public String find_max_effective_date_from(String idFrame) {
		String maxDateFrom = "";

		String xPath = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//span[contains(@id,'latestEffectiveStartDate')]";
		String lastestEff = waitElementToBePresent(xPath).getTextValue();
		if (!lastestEff.equals("")) {
			maxDateFrom = DateTimeUtil.addDays(lastestEff, 2);

		} else {
			maxDateFrom = getToday();
		}
		return maxDateFrom;

	}

	public String get_text_discount_detail_in_row(String idFrame, int ri) {
		waitForAllJSCompletes();

		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[last()]//td[3]//input";
		if (isElementExist(xPath)) {
			return waitElementToBePresent(xPath).getAttribute("value");
		} else {
			return "";
		}

	}

	public String get_text_effective_date_from_in_row(String idFrame, int ri) {
		waitForAllJSCompletes();

		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[" + ri + "]//td[1]//input";
		if (isElementExist(xPath)) {
			return waitElementToBePresent(xPath).getAttribute("value");
		} else {
			return "";
		}

	}

	public void enter_discount_in_last_row(String idFrame, String discount) {
		waitForAllJSCompletes();
		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[last()]//input[contains(@id,'standardCost')]";
		waitTypeAndEnterThenUpdateValue(xPath, discount);
		click_btn_expand_with_frame_id(idFrame);
		waitForAllJSCompletes();
	}

	public void enter_discount_in_row_index(String idFrame, String discount, int ri) throws ParseException {
		waitForAllJSCompletes();
		String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[" + ri
				+ "]//input[contains(@id,'standardCost')]";
		waitTypeAndEnterThenUpdateValue(xPath, discount);
		waitForAllJSCompletes();
	}

	public int get_ri_effective_date_from_with_frame_id(String idFrame, String effectiveDateFrom) {
		int ri = 0;
		int rowQty = count_row_effective_date_from(idFrame);
		for (int i = 1; i <= rowQty; i++) {
			String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
					+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[" + i
					+ "]//input[contains(@id,'effectiveDateFrom_input')]";
			String actual = waitElementToBePresent(xPath).getAttribute("value");

			if (actual.equals(effectiveDateFrom)) {
				ri = i;
			}

		}
		return ri;
	}

	public int count_row_effective_date_from(String idFrame) {

		String xPath = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody";
		String xPath2 = "//*[@id='syn:invSalesMarginCostFr:" + idFrame
				+ "']//div[contains(@id,'periodTable')]//table/tbody//td[text()='No records found.']";
		if (isElementExist(xPath) && !isElementExist(xPath2)) {
			return getTbCountDataRow(xPath);

		} else {
			return 0;
		}

	}

	public void check_del_detail(String idFrame, String effectiveDateFrom) {

		int ri = get_ri_effective_date_from_with_frame_id(idFrame, effectiveDateFrom);
		if (ri != 0) {
			String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
					+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[" + ri + "]//input[@type='checkbox']";
			checkChkbox(xPath);
		} else {
			System.out.println("ERROR: Can't find Effective Date From to check");
		}

	}

	public void uncheck_del_detail(String idFrame, String effectiveDateFrom) {

		int ri = get_ri_effective_date_from_with_frame_id(idFrame, effectiveDateFrom);
		if (ri != 0) {
			String xPath = "(//*[@id='syn:invSalesMarginCostFr:" + idFrame
					+ "']//div[contains(@id,'periodTable')]//table/tbody//tr)[" + ri + "]//input[@type='checkbox']";
			uncheckChkbox(xPath);
		} else {
			System.out.println("ERROR: Can't find Effective Date From to uncheck");
		}
	}

	public void confirm_yes() {
		chooseYesOnUpdateConfirmation();
	}

	// Verify

	public boolean assert_date_to_previous_detail(String idFrame, String effectiveDateFrom) {

		String txtTo = "";
		boolean is_equal = true;
		int ri = get_ri_effective_date_from_with_frame_id(idFrame, effectiveDateFrom);
		if (ri > 1) {
			int ri2 = ri - 1;
			txtTo = get_text_effective_date_to_in_row(idFrame, ri2);

			if (effectiveDateFrom.equals(DateTimeUtil.addDays(txtTo, 1))) {
				is_equal = true;
			} else {
				is_equal = false;

			}

		}

		return is_equal;

	}

	public int get_ri_date_in_range(String idFrame, String effectiveDateFrom) throws ParseException {
		int ri = 0;
		if (count_row_effective_date_from(idFrame) > 0) {
			for (int i = 0; i < count_row_effective_date_from(idFrame); i++) {
				int j = i + 1;
				String dateTop = get_text_effective_date_from_in_row(idFrame, j);
				String dateLast = get_text_effective_date_to_in_row(idFrame, j);
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				Date sEffectiveDateFrom = formater.parse(effectiveDateFrom);
				Date sDateTop = formater.parse("01/01/1990");
				if (!dateTop.equals("")) {
					sDateTop = formater.parse(dateTop);
				}

				if (sEffectiveDateFrom.equals(sDateTop)) {
					ri = j;

				} else {
					if (dateLast.equals("") && ri == 0) {
						ri = 0;
					} else {
						if (dateLast.equals("")) {
							dateLast = "01/12/9999";
						}
						Date sDateLast = formater.parse(dateLast);
						if ((sEffectiveDateFrom.after(sDateTop) && sEffectiveDateFrom.before(sDateLast))
								|| sEffectiveDateFrom.equals(sDateLast)) {
							ri = j;

						}
					}

				}
			}

		}
		return ri;
	}

	// Common
	
	

	public String AddSubstractDaysToCurrentDate(int numdays) {

		// initiation
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, numdays);
		String date = now.get(Calendar.DATE) + "0" + (now.get(Calendar.MONTH) + 1) + "" + now.get(Calendar.YEAR);
		return date;

	}

	public Date convertStringToDate(String dateInString) {

		// initiation
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {

			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;

	}

	public void selectDdlByTextTH6(String _value) {
		String xpath = "//div[contains(@class,'ui-selectonemenu-panel') and contains(@style,'block')]";
		waitElementToBePresentThenScrollIntoView(xpath).waitUntilEnabled();
		clickOnElement(xpath + "//ul/li[.='" + _value + "']");
	}
	
}