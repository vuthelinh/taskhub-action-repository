package com.synergix.globalsetup.administration.company.pages;

import com.synergix.common.TH5PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ian and Steve on 8/3/2016.
 */
public class StrategicBusinessUnitPage extends TH5PageObject {
	private static final int DEL_CHECK_BOX_HEADER_INDEX = 3;
	private static final int DESCRIPTION_HEADER_INDEX = 2;
	private static final int INVENTORY_CLASS_HEADER_INDEX = 1;
	private static final String ACCESSIBLE_INVENTORY = "Accessible Inventory";
	private static final String PURCHASER_IN_CHARGE = "Purchaser in Charge";
	private static final String GLOBAL_STATUS = "Global Status";
	private static final String CTI_CODE = "CTI Code";
	private static final String DETAILED_DESCRIPTION = "Detailed Description";
	private static final String DESCRIPTION = "Description";
	private static final String SBU_CODE = "SBU Code";
	private static final String UPDATE_BUTTON_LABEL = "Update";
	private static final String SEARCH_BUTTON_LABEL = "Search";
	private static final String DELETE_BUTTON_LABEL = "Delete";
	private static final String NEW_BUTTON_LABEL = "New";
	private static final String CLOSE_BUTTON_LABEL = "Close";

	public StrategicBusinessUnitPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean search_sbu(String sbuCode){
		click_search_button_on_functional_panel();
		waitForAllJSCompletes();
		return search(SBU_CODE, sbuCode);
	}
	
	public void delete_value_by_search_sbu_code(String sbuCode){
		deleteValueBySearchBtn(SEARCH_BUTTON_LABEL, SBU_CODE, sbuCode);
	}
		
	public void enter_sbu_code(String sbuCode){
		enterInputFieldCodeWithLabel(SBU_CODE, sbuCode);
	}
	public String get_text_sbu_code(){
		String inputXpath = xPathInputFieldWithLabel(SBU_CODE);
		return waitElementToBePresent(inputXpath).getValue();
	}
	public void enter_description(String description){
		enterInputFieldWithLabel(DESCRIPTION, description);
	}
	public String get_text_description(){
		String inputXpath = xPathInputFieldWithLabel(DESCRIPTION);
		return waitElementToBePresent(inputXpath).getValue();
	}
	
	public void enter_detailed_description(String detailedDescription){
		enterTextAreaWithLabel(DETAILED_DESCRIPTION, detailedDescription);
	}
	public String get_text_detailed_description(){
		String inputXpath = xPathInputTextAreaWithLabel(DETAILED_DESCRIPTION);
		return waitElementToBePresent(inputXpath).getValue();
	}
	
	public void enter_cti_code(String ctiCode){
		enterInputFieldCodeWithLabel(CTI_CODE, ctiCode);
	}
	public String get_text_cti_code(){
		String inputXpath = xPathInputFieldWithLabel(CTI_CODE);
		return waitElementToBePresent(inputXpath).getValue();
	}
	
	public void select_global_status(String globalStatus){
		//checkRadio(GLOBAL_STATUS, globalStatus);

		String xpathElement = "(//*[text()='" + GLOBAL_STATUS + "']/ancestor-or-self" + "::td/following-sibling" + "::td//label[text()='"
		+ globalStatus + "']/preceding-sibling" + "::input)[1]";
		$(xpathElement).click();
		waitForAllJSCompletes();
	}
	
	public boolean is_checked_global_status(String globalStatus){
		return getChecked(GLOBAL_STATUS, globalStatus);
	}
	
	public void switch_tab_purchaser_in_charge(){
		switch_to_tab(PURCHASER_IN_CHARGE);
	}
	
	public void switch_tab_accessible_inventory(){
		switch_to_tab(ACCESSIBLE_INVENTORY);
	}
	
	public void switch_tab_company(){
		switch_to_tab_company();
		waitForAllJSCompletes();
	}
		
	public void enter_purchaser_in_charge(String employeeCode){
		enterInputFieldWithLabel(PURCHASER_IN_CHARGE, employeeCode);
		waitForAllJSCompletes();
	}
	public String get_text_purchaser_in_charge(){
		String inputXpath = xPathInputFieldWithLabel(PURCHASER_IN_CHARGE);
		return waitElementToBePresent(inputXpath).getValue();
	}
	
	public String get_text_purchaser_name(){
		String inputXpath = xPathInputFieldWithLabel(PURCHASER_IN_CHARGE);
		String descriptionXpath = inputXpath + "//ancestor::td//following-sibling::td";
		return waitElementToBePresent(descriptionXpath).getText();
	}

	public String xAddBtn = "//input[@value='Add'][@type='button'][parent::form]";
	public String xDeleteBtn = "//input[@value='Delete'][@type='button'][parent::form]";
	public void click_btn_add_in_tab(){
		clickOnElement(xAddBtn);
		waitForAllJSCompletes();
	}
	
	public void click_btn_delete_in_tab(){
		clickOnElement(xDeleteBtn);
		waitForAllJSCompletes();
	}
	
	public String xPathTbDataFieldByPosition(String parentXpath, int rowIndex, int headerIndex){
		String cellXpath = xPathTbDataCellByPosition(inventoryTableXpath, rowIndex, headerIndex);
		return cellXpath + "//input";
	}
		
	private String inventoryTableXpath = "//table[@id='frmInvClass:tblSbuInvClass']";
	
	public int get_inventory_class_table_count_data_row(){
		return getTbCountDataRow(inventoryTableXpath);
	}
	public void enter_inventory_class(String inventoryClass, int rowIndex){
		String inputXpath = xPathTbDataFieldByPosition(inventoryTableXpath, rowIndex, INVENTORY_CLASS_HEADER_INDEX);
		waitTypeAndEnter(inputXpath, inventoryClass);
		waitForAllJSCompletes();
	}
	
	public String get_text_inventory_class(int rowIndex){
		String inputXpath = xPathTbDataFieldByPosition(inventoryTableXpath, rowIndex, INVENTORY_CLASS_HEADER_INDEX);
		return waitElementToBePresent(inputXpath).getValue();
	}
	public String get_text_inventory_description(int rowIndex){
		String cellXpath = xPathTbDataCellByPosition(inventoryTableXpath, rowIndex, DESCRIPTION_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}
	public void check_del(int rowIndex){
		String inputXpath = xPathTbDataFieldByPosition(inventoryTableXpath, rowIndex, DEL_CHECK_BOX_HEADER_INDEX);
		if (!waitElementToBePresent(inputXpath).isSelected()){
			clickOnElement(inputXpath);
			waitForAllJSCompletes();
		}
	}
	public void uncheck_del(int rowIndex){
		String inputXpath = xPathTbDataFieldByPosition(inventoryTableXpath, rowIndex, DEL_CHECK_BOX_HEADER_INDEX);
		if (waitElementToBePresent(inputXpath).isSelected()){
			clickOnElement(inputXpath);
			waitForAllJSCompletes();
		}
	}
}
