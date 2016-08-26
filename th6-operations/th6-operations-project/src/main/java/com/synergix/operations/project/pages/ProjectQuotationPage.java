package com.synergix.operations.project.pages;

import com.synergix.common.TH6PageObject;
import com.synergix.utilities.SessionData;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ian on 7/27/2016.
 */
public class ProjectQuotationPage extends TH6PageObject {
	
	public static final String XPATH_COST_ITEM_TABLE = "//div[contains(@id,'costItemTable')]";
	public static final String XPATH_BRAND_COMPARISON = "//div[div/div[text()='Brand Comparison']]";
	private static final String XPATH_PHASE_TABLE = "//div[contains(@id,'treeTableId') and contains(@class,'ui-treetable')]";
	private static final String XPATH_DETAILS_TAB = "//div[@role='tabpanel' and preceding-sibling::h3[1][.='Details']]";
	private static final String XPATH_COSTING_SHEET_TREE_TABLE = XPATH_DETAILS_TAB + "//form[div[contains(@id,'costingSheetTreeTableId')]]";
	private static final String XPATH_COSTING_SHEET = "//form[contains(@id,'costItemForms')]";
	private static final String XPATH_QUOTATION_SUMMARY = "//table[contains(@id,'quotationSummaryTable')]";
	public static final String XPATH_WORKHEAD = "//div[contains(@id,'workheadTable')]";
	public static final String XPATH_WORKHEAD_TABLE = XPATH_WORKHEAD;
	
	public ProjectQuotationPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @scope Project Quotation Summary
	 */
	@FindBy(xpath = "//button[contains(@id,'syn:summaryTabs:summaryDraftForm:draftPjTable:') and span[contains(@class,' fa-file')]]")
	private WebElementFacade newButton;
	
	public void clickAddNewButtonOnFunctionalPanel() {
		newButton.waitUntilPresent().click();
	}
	
	public void search_project_number(String parentXpath, String projectNumber) {
		waitForAllJSCompletes();
		String xpathToSearchInput = "//table//th[span[.='Quotation No.']]/input";
		$(parentXpath + xpathToSearchInput).waitUntilClickable().typeAndEnter(projectNumber);
	}
	
	public void search_project_number_in_draft(String projectNumber) {
		search_project_number("//div[@id='syn:summaryTabs']//form[@id='syn:summaryTabs:summaryDraftForm']", projectNumber);
	}
	
	public void openQuotation(String quotationNumber) {
		waitForAllJSCompletes();
		$("//table/tbody/tr/td[1][.='" + quotationNumber + "']").waitUntilClickable().click();
	}
	
	public void selectProjectQuotationNumberKey(String number_key) {
		String dialogXpath = "//div[contains(@id,'dnsSelectionPanel') and contains(@role,'dialog')]";
		waitForPresenceOf(dialogXpath);
		
		$(dialogXpath + "//td[@role='gridcell']/a[.='" + number_key + "']").click();
		
	}
	
	/**
	 * @scope Main field for Quotation
	 */
	public void enterCustomerCode(String customerCode) {
		String xPath = xPathInputFieldWithLabel("Customer", 1);
		searchAndSelectFirstResult(xPath, customerCode);
	}
	
	public void enterProject(String project) {
		enterTextAreaWithLabel("Project name", project);
	}
	
	public void enterQuotationDate(String quotationDate) {
		clickOnElement(xPathInputFieldWithLabel("Quotation Date & Validity", 1));
		waitForAllJSCompletes();
		setCalendarDate(quotationDate);
		waitForAllJSCompletes();
	}
	
	public String getDetailTabState() {
		waitForAllJSCompletes();
		String xpath_check_phase_details = "//button[.='Costing Sheet']";
		String xpath_check_costing_sheet = XPATH_COSTING_SHEET_TREE_TABLE;
		String xpath_check_brand_comparison = "//div[.='Cost Item Groups']";
		
		if (!findAll(xpath_check_phase_details).isEmpty()) {
			return "PhaseDetail";
		} else if (!findAll(xpath_check_costing_sheet).isEmpty()) {
			return "CostingSheet";
		} else if (!findAll(xpath_check_brand_comparison).isEmpty()) {
			return "BrandsComparison";
		} else {
			waitForAllJSCompletes();
			return getDetailTabState();
		}
	}
	
	public void clickBackPhaseDetailsBtn() {
		waitForAllJSCompletes();
		clickBtn("Back to Phase Details");
		waitForAllJSCompletes();
	}
	
	public void clickAbortQuotation() {
		waitForAllJSCompletes();
		clickBtn("Abort");
		waitForAllJSCompletes();
	}
	
	public void clickSubmitQuotation() {
		waitForAllJSCompletes();
		clickBtn("Submit");
		waitForAllJSCompletes();
	}
	
	public void saveQuotationCode() {
		List<String> quotationCode = new ArrayList<>();
		
		String dataKey = "Project Quotation";
		
		SessionData.addToListString(dataKey, getQuotationCode());
	}
	
	public String getQuotationCode() {
		waitForAllJSCompletes();
		String title = $("(//form[@id='navigationForm']//span[@class='ui-menuitem-text'])[2]").getText();
		title = title.trim();
		title = title.replace("Project Quotation======= [", "");
		title = title.replace("]", "");
		return title.trim();
	}
	
	/**
	 * @scope Phase Sheet
	 */
	public void clickPlusAddButton(String parentXpath) {
		$(parentXpath + "//button[span[contains(@class,' fa-plus')]]").waitUntilClickable().click();
	}
	
	public void clickTrashButton(String parentXpath) {
		$(parentXpath + "//button[span[contains(@class,' fa-trash-o')]]").waitUntilClickable().click();
	}
	
	public void clickAddMainPhaseButton() {
		clickPlusAddButton(XPATH_PHASE_TABLE);
	}
	
	public void clickCostingSheetBtn() {
		waitForAllJSCompletes();
		clickBtn("Costing Sheet");
		waitForAllJSCompletes();
	}
	
	/**
	 * @scope Phase Sheet Total Summary
	 */
	public void enterCurrency(String currency) {
		searchAndSelectFirstResult(xPathTbDataCellByPosition("//table[contains(@id,'quotationSummaryTable')]", 1, 3) + "//input", currency);
		waitForAllJSCompletes();
	}
	
	public void enterExchangeRate(String exchangeRate) {
		waitTypeAndEnter(xPathTbDataCellByPosition("//table[contains(@id,'quotationSummaryTable')]", 1, 4) + "//input", exchangeRate);
		waitForAllJSCompletes();
	}
	
	public void enterSalesTax(String salesTax) {
		searchAndSelectFirstResult(xPathTbDataCellByPosition("//table[contains(@id,'quotationSummaryTable')]", 5, 2) + "//input", salesTax);
		waitForAllJSCompletes();
	}
	
	public String getExchangeRate() {
		waitForAllJSCompletes();
		int colIndex = getTbColHeaderIndex(XPATH_QUOTATION_SUMMARY + "//th[.='Home']");
		int rowIndex = getTbRowIndexOfDataCell(XPATH_QUOTATION_SUMMARY + "//td[.='Currency & Exch Rate']") - 1;
		return $(xPathTbDataCellByPosition(XPATH_QUOTATION_SUMMARY, rowIndex, colIndex) + "//input[1]").getValue();
	}
	
	public String getProjectSumNature() {
		waitForAllJSCompletes();
		return getTotalSummary("Nature", "Project Sum");
	}
	
	public String getProjectSumHome() {
		waitForAllJSCompletes();
		return getTotalSummary("Home", "Project Sum");
	}
	
	public String getProjectBudgetCostNature() {
		waitForAllJSCompletes();
		return getTotalSummary("Nature", "Project Budget Cost");
	}
	
	public String getProjectBudgetCostHome() {
		return getTotalSummary("Home", "Project Budget Cost");
	}
	
	public String getBudgetProfitPercent() {
		waitForAllJSCompletes();
		int colIndex = 2;
		int rowIndex = getTbRowIndexOfDataCell(XPATH_QUOTATION_SUMMARY + "//td[.='Project Budget Profit']") - 1;
		return $(xPathTbDataCellByPosition(XPATH_QUOTATION_SUMMARY, rowIndex, colIndex)).getText().replaceAll("%", "");
	}
	
	public String getProjectBudgetProfitNature() {
		return getTotalSummary("Nature", "Project Budget Profit");
	}
	
	public String getProjectBudgetProfitHome() {
		return getTotalSummary("Home", "Project Budget Profit");
	}
	
	public String getSalesTaxNature() {
		return getTotalSummary("Nature", "Sales Tax");
	}
	
	public String getSalesTaxHome() {
		return getTotalSummary("Home", "Sales Tax");
	}
	
	public String getProjectValueNature() {
		return getTotalSummary("Nature", "Project Value incl. Tax");
	}
	
	public String getProjectValueHome() {
		return getTotalSummary("Home", "Project Value incl. Tax");
	}
	
	public String getTotalSummary(String colName, String rowName) {
		int colIndex = getTbColHeaderIndex(XPATH_QUOTATION_SUMMARY + "//th[.='" + colName + "']");
		int rowIndex = getTbRowIndexOfDataCell(XPATH_QUOTATION_SUMMARY + "//td[.='" + rowName + "']") - 1;
		
		return $(xPathTbDataCellByPosition(XPATH_QUOTATION_SUMMARY, rowIndex, colIndex)).getText();
	}
	
	/**
	 * @scope Action in phase row
	 */
	
	public void expandPhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[1]/span[contains(@class,'ui-icon-triangle-1-e')]").waitUntilClickable().click();
		
		
	}
	
	public void collapsePhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[1]/span[contains(@class,'ui-icon-triangle-1-s')]").waitUntilClickable().click();
		
		
	}
	
	public void addSubPhaseInPhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[last()]/button[span[contains(@class,'fa-plus')]]").waitUntilClickable().click();
		
		
	}
	
	public void deletePhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[last()]/button[span[contains(@class,'fa-trash-o')]]").waitUntilClickable().click();
		
		
	}
	
	public void moveUpPhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[last()]/button[span[contains(@class,'fa-arrow-up')]]").waitUntilClickable().click();
		
		
	}
	
	public void moveDownPhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[last()]/button[span[contains(@class,'fa-arrow-down')]]").waitUntilClickable().click();
		
		
	}
	
	public void moveToPositonPhaseRow(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[last()]/button[span[contains(@class,'fa-arrows-v')]]").waitUntilClickable().click();
		
		
	}
	
	/**
	 * @scope Enter phase details
	 */
	
	public void enterPhaseDesc(String phaseNo, String phaseDesc) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[2]/textarea").waitUntilEnabled().typeAndEnter(phaseDesc);
	}
	
	public void enterPhaseWorkheadGroup(String phaseNo, String workheadGroup) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		searchAndSelectFirstResult(xpathRow + "/td[3]//input[1]", workheadGroup);
	}
	
	public void enterPhaseQuantity(String phaseNo, String quantity) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[4]//input[1]").waitUntilEnabled().typeAndEnter(quantity);
		
		
	}
	
	public void enterPhaseUOM(String phaseNo, String uom) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[4]//input[2]").waitUntilEnabled().typeAndEnter(uom);
		
		
	}
	
	public void enterPhaseUnitPrice(String phaseNo, String unitPrice) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[5]//input[1]").waitUntilEnabled().typeAndEnter(unitPrice);
		
		
	}
	
	public void enterPhaseDiscPercent(String phaseNo, String disc) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[6]//input[1]").waitUntilEnabled().typeAndEnter(disc);
		
		
	}
	
	public void enterPhaseDiscAmount(String phaseNo, String disc) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[6]//input[2]").waitUntilEnabled().typeAndEnter(disc);
		
		
	}
	
	public void enterPhaseBudgetCost(String phaseNo, String budgetCost) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[8]//input[1]").waitUntilEnabled().typeAndEnter(budgetCost);
		
		
	}
	
	public void enterPhaseProfitMargin(String phaseNo, String margin) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		$(xpathRow + "/td[9]//input[1]").waitUntilEnabled().typeAndEnter(margin);
		
		
	}
	
	/**
	 * @scope Get phase detail
	 */
	
	public String getPhaseQty(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		return $(xpathRow + "/td[4]//input[1]").waitUntilVisible().getValue();
	}
	
	public String getPhaseUOM(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		return $(xpathRow + "/td[4]//input[2]").waitUntilVisible().getValue();
	}
	
	public String getPhaseUnitPrice(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		if (isElementExist(xpathRow + "/td[5]//input[1]")) {
			return $(xpathRow + "/td[5]//input[1]").getValue();
		} else {
			return $(xpathRow + "/td[5]").getText();
		}
	}
	
	public String getPhaseDiscPercent(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		return $(xpathRow + "/td[6]//input[1]").waitUntilVisible().getValue();
	}
	
	public String getPhaseDiscAmount(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		return $(xpathRow + "/td[6]//input[2]").waitUntilVisible().getValue();
	}
	
	public String getPhaseValue(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		return $(xpathRow + "/td[7]").waitUntilVisible().getText();
	}
	
	public String getPhaseBudgetCost(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		if (isElementExist(xpathRow + "/td[8]//input[1]")) {
			return $(xpathRow + "/td[8]//input[1]").getValue();
		} else {
			return $(xpathRow + "/td[8]").getText();
		}
	}
	
	public String getPhaseBudgetProfit(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		return $(xpathRow + "/td[9]").getText().split("\n")[0];
	}
	
	public String getPhaseProfitMargin(String phaseNo) {
		waitForAllJSCompletes();
		
		String xpathRow = xpathPhaseRowByPhaseNo(phaseNo);
		
		if (isElementExist(xpathRow + "/td[9]//input[1]")) {
			return $(xpathRow + "/td[9]//input[1]").getValue();
		} else {
			return $(xpathRow + "/td[9]").getText().split("\n")[1];
		}
	}
	
	/**
	 * @Desciption Phase Utils
	 */
	
	public String xpathPhaseRowByPhaseNo(String phaseNo) {
		return XPATH_DETAILS_TAB + XPATH_PHASE_TABLE + "//tbody/tr[td[1][.='" + phaseNo + "']]";
	}
	
	public String parentPhaseFromPhase(String phaseNo) {
		return phaseNo.substring(0, phaseNo.lastIndexOf("."));
	}
	
	public boolean ifPhaseIsExpand(String phaseNo) {
		waitForAllJSCompletes();
		return isElementExist(xpathPhaseRowByPhaseNo(phaseNo) + "/td[1]/span[contains(@class,'ui-icon-triangle-1-s')]");
	}
	
	//    TODO expand all phases
	public void expandAllPhases() {
		
	}
	
	/**
	 * @scope Costing Sheet
	 */
	
	public void clickPhaseOnCostingSheetTree(String phaseNo) {
		waitForAllJSCompletes();
		findTbDataCellByTextEqualInCol(XPATH_COSTING_SHEET_TREE_TABLE, phaseNo, 1, "Phase No.", 1).click();
		waitForAllJSCompletes();
	}
	
	public String getActivePhaseInCostingSheet() {
		waitForAllJSCompletes();
		List<WebElementFacade> activePhaseRow = findAll(XPATH_COSTING_SHEET_TREE_TABLE + "//tr[contains(@class,'ui-state-highlight')]");
		
		if (activePhaseRow.isEmpty()) {
			return "";
		} else {
			return activePhaseRow.get(0).findBy("td[" + getTbColHeaderIndex(XPATH_COSTING_SHEET_TREE_TABLE, "Phase No.") + "]").getText();
		}
	}
	
	public void clickAddCostItem() {
		clickPlusAddButton(XPATH_COSTING_SHEET);
	}
	
	public String getBudgetCostInCostingTree(String phaseNo) {
		int colIndex = getTbColHeaderIndex(XPATH_COSTING_SHEET_TREE_TABLE, "Budget Cost");
		int rowIndex = getTbRowIndexOfDataCell(XPATH_COSTING_SHEET_TREE_TABLE + "//table/tbody/tr/td[1][.='" + phaseNo + "']");
		String xpath = xPathTbDataCellByPosition(XPATH_COSTING_SHEET_TREE_TABLE, rowIndex, colIndex);
		return $(xpath).getText();
	}
	
	public void selectCostingItemRow(String drawingObjectNo) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[last()]" + "//div[contains(@class, 'ui-chkbox-box ')]";
		clickOnElement(xpath);
		waitForAllJSCompletes();
	}
	
	public void clickDeleteOnCostingSheet() {
		clickTrashButton(XPATH_COSTING_SHEET);
		waitForAllJSCompletes();
	}
	
	/**
	 * @scope Enter Cost Item detail
	 */
	
	public void selectTypeForLastCostItem(String type) {
		clickTypeInputForCostItemByOrder("last()");
		waitForAllJSCompletes();
		selectDdlByTextTH6(type);
	}
	
	public void clickTypeInputForCostItemByOrder(String resOrder) {
		int headerIndex = getTbColHeaderIndex(XPATH_COSTING_SHEET, "Type");
		waitForAllJSCompletes();
		clickOnElement(XPATH_COSTING_SHEET + "//tbody/tr[" + resOrder + "]/td[" + headerIndex + "]");
		waitForAllJSCompletes();
	}
	
	public void clickTypeInputForCostItemByOrder(Integer resOrder) {
		clickTypeInputForCostItemByOrder(resOrder.toString());
	}
	
	public void selectDrawingObjectForLastCostItem(String drawingObject) {
		//        int headerIndex = getTbColHeaderIndex(XPATH_COSTING_SHEET, "Drawing Object");
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Drawing Object");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + headerIndex + "]" + "//input[1]";
		searchAndSelectFirstResult(xpath, drawingObject);
	}
	
	public void selectCodeDescriptionForLastCostItem(String itemCodeDescription) {
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Code");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + headerIndex + "]" + "//input[1]";
		searchAndSelectFirstResult(xpath, itemCodeDescription);
	}
	
	public void enterDrawingQtyForLastCostItem(String drawingQty) {
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Drawing Qty");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + headerIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, drawingQty);
	}
	
	public void enterWastageForLastCostItem(String estWastage) {
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Drawing Qty");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + headerIndex + "]" + "//input[2]";
		waitTypeAndEnter(xpath, estWastage);
	}
	
	public void enterItemBudgetQtyForLastCostItem(String itemBudgetQty) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Qty");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, itemBudgetQty);
	}
	
	public void enterItemBudgetUnitCostForLastCostItem(String itemBudgetUnitCost) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Unit Cost");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, itemBudgetUnitCost);
	}
	
	public void enterItemBudgetMarkupForLastCostItem(String itemBudgetMarkup) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Markup %");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, itemBudgetMarkup);
	}
	
	public void enterLabourQtyForLastCostItem(String labourBudgetQty) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Qty UOM");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, labourBudgetQty);
	}
	
	public void enterLabourUnitCostForLastCostItem(String labourBudgetUnitCost) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Unit Cost");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, labourBudgetUnitCost);
	}
	
	public void enterLabourMarkupForLastCostItem(String labourBudgetMarkup) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Markup %");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[last()]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, labourBudgetMarkup);
	}
	
	
	public void selectTypeByCostItem(String drawingObjectNo, String type) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		clickTypeInputForCostItemByOrder(rowIndex);
		waitForAllJSCompletes();
		selectDdlByTextTH6(type);
	}
	
	public void selectDrawingObjectByCostItem(String drawingObjectNo, String drawingObject) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Drawing Object");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + headerIndex + "]" + "//input[1]";
		searchAndSelectFirstResult(xpath, drawingObject);
	}
	
	public void selectCodeDescriptionByCostItem(String drawingObjectNo, String itemCodeDescription) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Code");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + headerIndex + "]" + "//input[1]";
		searchAndSelectFirstResult(xpath, itemCodeDescription);
	}
	
	public void enterDrawingQtyByCostItem(String drawingObjectNo, String drawingQty) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Drawing Qty");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + headerIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, drawingQty);
	}
	
	public void enterWastageByCostItem(String drawingObjectNo, String estWastage) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Drawing Qty");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + headerIndex + "]" + "//input[2]";
		waitTypeAndEnter(xpath, estWastage);
	}
	
	public void enterItemBudgetQtyByCostItem(String drawingObjectNo, String itemBudgetQty) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Qty");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, itemBudgetQty);
	}
	
	public void enterItemBudgetUnitCostByCostItem(String drawingObjectNo, String itemBudgetUnitCost) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Unit Cost");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, itemBudgetUnitCost);
	}
	
	public void enterItemBudgetMarkupByCostItem(String drawingObjectNo, String itemBudgetMarkup) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Markup %");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, itemBudgetMarkup);
	}
	
	public void enterLabourQtyByCostItem(String drawingObjectNo, String labourBudgetQty) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Qty UOM");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, labourBudgetQty);
	}
	
	public void enterLabourUnitCostByCostItem(String drawingObjectNo, String labourBudgetUnitCost) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Unit Cost");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, labourBudgetUnitCost);
	}
	
	public void enterLabourMarkupByCostItem(String drawingObjectNo, String labourBudgetMarkup) {
		int rowIndex = getRowIndexByCellValue(XPATH_COSTING_SHEET, "1", drawingObjectNo);
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Markup %");
		String xpath = XPATH_COSTING_SHEET + "//table/tbody//tr[" + rowIndex + "]" + "/td[" + colIndex + "]" + "//input[1]";
		waitTypeAndEnter(xpath, labourBudgetMarkup);
	}
	
	/**
	 * @scope Get Cost Item detail
	 */
	public String getItemBudgetQty(String phaseNo) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Qty UOM");
		int rowIndex = Integer.parseInt(phaseNo);
		String xpath = xPathTbDataCellByPosition(XPATH_COSTING_SHEET, rowIndex, colIndex) + "//input[1]";
		return $(xpath).getValue();
	}
	
	public String getItemBudgetUnitCost(String phaseNo) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Item Budget", "Unit Cost");
		int rowIndex = Integer.parseInt(phaseNo);
		String xpath = xPathTbDataCellByPosition(XPATH_COSTING_SHEET, rowIndex, colIndex) + "//input";
		return $(xpath).getValue();
	}
	
	public String getLabourBudgetQty(String phaseNo) {
		int colIndex = locateColumnIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Labour Budget", "Qty UOM");
		int rowIndex = Integer.parseInt(phaseNo);
		String xpath = xPathTbDataCellByPosition(XPATH_COSTING_SHEET, rowIndex, colIndex) + "//input";
		return $(xpath).getValue();
	}
	
	public String getBudgetCost(String phaseNo) {
		int colIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_COSTING_SHEET, "Budget Cost");
		int rowIndex = Integer.parseInt(phaseNo);
		String xpath = xPathTbDataCellByPosition(XPATH_COSTING_SHEET, rowIndex, colIndex) + "//span[1]";
		return $(xpath).getText();
	}
	
	/**
	 * @return
	 * @scope Brand Comparison
	 */
	
	public void clickBrandComparisonBtn() {
		waitForAllJSCompletes();
		clickBtn("Brand Comparison");
	}
	
	public void clickEyeOnTable(String xpathTable, String rowTitle) {
		$(xpathTable + "//tbody/tr[td[.='" + rowTitle + "']]//button").waitUntilClickable().click();
	}
	
	public void clickWorkheadGroup(String workHeadGroup) {
		waitForAllJSCompletes();
		clickEyeOnTable(XPATH_WORKHEAD_TABLE, workHeadGroup);
	}
	
	public void clickCostItemGroup(String costItemGroup) {
		waitForAllJSCompletes();
		clickEyeOnTable(XPATH_COST_ITEM_TABLE, costItemGroup);
	}
	
	public void selectSupplierForCostItem(String itemCost, String brand, String supplier) {
		int colOrder = locateColumnIn2LevelHeaderTable(XPATH_BRAND_COMPARISON, "//tr[th][1]", "//tr[th][2]", brand, supplier);
		
		$(XPATH_BRAND_COMPARISON + "//table/tbody/tr[td[.='" + itemCost + "']]/td[" + colOrder + "]/button").waitUntilClickable().click();
	}
	
	public String getBudgetCostByWorkheadGroup(String workheadGroup) {
		waitForAllJSCompletes();
		String xpath = xPathTbDataCellByPosition(XPATH_WORKHEAD_TABLE, getRowIndexByCellValue(XPATH_WORKHEAD_TABLE, workheadGroup), 3);
		return $(xpath).getText();
	}
	
	public String getTotalBudgetCostInWorkheadGroup() {
		waitForAllJSCompletes();
		return $(XPATH_WORKHEAD_TABLE + "//tfoot/tr[1]/td[2]").getText();
	}
	
	public String getSelectedBrandsByCostItemGroup(String costItemGroup) {
		waitForAllJSCompletes();
		int colIndex = getTbColHeaderIndex(XPATH_COST_ITEM_TABLE, "Selected Brands");
		int rowIndex = getRowIndexByCellValue(XPATH_COST_ITEM_TABLE, costItemGroup);
		return $(xPathTbDataCellByPosition(XPATH_COST_ITEM_TABLE, rowIndex, colIndex)).getText();
	}
	
	public String getBudgetCostByCostItemGroup(String costItemGroup) {
		waitForAllJSCompletes();
		int colIndex = getTbColHeaderIndex(XPATH_COST_ITEM_TABLE, "Budget Cost");
		int rowIndex = getRowIndexByCellValue(XPATH_COST_ITEM_TABLE, costItemGroup);
		return $(xPathTbDataCellByPosition(XPATH_COST_ITEM_TABLE, rowIndex, colIndex)).getText();
	}
	
	public String getTotalBudgetCostByCostItemGroup() {
		waitForAllJSCompletes();
		return $(XPATH_COST_ITEM_TABLE + "//tfoot/tr[1]/td[2]").getText();
	}
	
	public String getDrawingObjectQtyInBrandComparison(String drawingObject) {
		waitForAllJSCompletes();
		int headerIndex = locateLevel1HeaderIn2LevelHeaderTable(XPATH_BRAND_COMPARISON, "Qty");
		int rowIndex = getRowIndexByCellValue(XPATH_BRAND_COMPARISON, drawingObject);
		
		return $(xPathTbDataCellByPosition(XPATH_BRAND_COMPARISON, rowIndex, headerIndex)).getText();
	}
	
	public String getTotalBrandComparison(String brand, String supplier) {
		waitForAllJSCompletes();
		int headerIndex = locateColumnIn2LevelHeaderTable(XPATH_BRAND_COMPARISON, brand, supplier) - 1;
		String xpathCell = "//tfoot/tr/td[" + headerIndex + "]";
		
		return $(XPATH_BRAND_COMPARISON + xpathCell).getText();
	}
	
	public String getUnitCostInBrandComparison(String drawingObject, String brand, String supplier) {
		waitForAllJSCompletes();
		int headerIndex = locateColumnIn2LevelHeaderTable(XPATH_BRAND_COMPARISON, brand, supplier);
		int rowIndex = getRowIndexByCellValue(XPATH_BRAND_COMPARISON, drawingObject);
		return $(xPathTbDataCellByPosition(XPATH_BRAND_COMPARISON, rowIndex, headerIndex) + "/span[1]").getText();
	}
	
	public void saveSelectedSuplierListInComparison() {
		waitForAllJSCompletes();
		$(XPATH_BRAND_COMPARISON + "//div[contains(@class,'ui-datatable-header')]//button[span[contains(@class,'fa-save')]]").click();
		waitForAllJSCompletes();
	}
	
	public void deleteSelectedSuplierListInComparison() {
		$(XPATH_BRAND_COMPARISON + "//div[contains(@class,'ui-datatable-header')]//button[span[contains(@class,'fa-trash-o')]]").click();
		waitForAllJSCompletes();
	}
	
	/**
	 * Can be public
	 */
	public void searchAndSelectFirstResult(String xpath, String value) {
		waitElementToBePresentThenScrollIntoView(
				xpath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled()
				.waitUntilVisible();
		$(xpath).clear();
		$(xpath).sendKeys(value);
		waitForAllJSCompletes();
		$(xpath).sendKeys(Keys.ENTER);
		waitForAllJSCompletes();
	}
	
	/**
	 * @param xpathParent     String xpath to table
	 * @param xpathHeaderRow1 String xpath to header level 1
	 * @param xpathHeaderRow2 String xpath to header level 2
	 * @param headerLevel1    String name of header level 1
	 * @param headerLevel2    String name of header level 2
	 * @return int order of column in table
	 * @scope Locate column in table has 2 header rows
	 * @author Ian
	 * @Example Locate Brand 3 > Sup 2
	 * |Sth1   | Sth2  |Brand1         |Brand2                 |Brand 3        |
	 * |       |       |Sup1   |Sup2   |Sup1   |Sup2   |Sup3   |Sup1   |Sup2   |
	 * brandOrder = 7
	 * colspanCount = 5
	 * supploerOrder = 6
	 * location = 7 - 5 + 6 + 1 = 9
	 */
	private int locateColumnIn2LevelHeaderTable(String xpathParent, String xpathHeaderRow1, String xpathHeaderRow2, String headerLevel1,
	                                            String headerLevel2) {
		waitForAllJSCompletes();
		List<WebElementFacade> previousElement = new ArrayList<>();
		previousElement = findAll(By.xpath(xPathTbHeaderCell(xpathParent, headerLevel1) + "/preceding-sibling::th"));
		//Number of column level 2 before the header level 1 col | xpathParent + xpathHeaderRow1 + "/th[.='" + headerLevel1 + "']" +
		Integer colspanSum = previousElement.stream().map(element -> {
			String colspan = element.getAttribute("colspan");
			String rowspan = element.getAttribute("rowspan");
			return ((colspan == null && rowspan != null) ? 0 : (colspan == null && rowspan == null) ? 1 : Integer.parseInt(colspan));
		}).mapToInt(Integer::intValue).sum();
		
		//Number of column before the header level 1 col
		Integer headerLevel1Order = previousElement.stream().map(element -> {
			String colspan = element.getAttribute("colspan");
			return (colspan == null ? 1 : Integer.parseInt(colspan));
		}).mapToInt(Integer::intValue).sum();
		
		if (headerLevel2.isEmpty()) {
			return headerLevel1Order + 1;
		} else {
			String currentColspan = find(By.xpath(xpathParent + xpathHeaderRow1 + "/th[.='" + headerLevel1 + "']")).getAttribute("colspan");
			int currentColspanInt = currentColspan == null ? 1 : Integer.parseInt(currentColspan);
			
			//Number of column level 2 before the header level 2 col
			List<WebElementFacade> headerLevel2Elements = findAll(By.xpath(xPathTbHeaderCell(xpathParent, headerLevel2, 10).replace("[10]", "")));
			int result;
			
			for (WebElementFacade element : headerLevel2Elements) {
				int headerLevel2Index = element.findElements(By.xpath("preceding-sibling::th")).size();
				result = headerLevel1Order - colspanSum + headerLevel2Index + 1;
				if (result <= (headerLevel1Order + currentColspanInt) && result > (headerLevel1Order)) {
					return result;
				}
			}
		}
		return 0;
	}
	
	private int locateColumnIn2LevelHeaderTable(String xpathParent, String headerLevel1, String headerLevel2) {
		return locateColumnIn2LevelHeaderTable(xpathParent, "//thead/tr[1]", "//thead/tr[2]", headerLevel1, headerLevel2);
	}
	
	public int locateLevel1HeaderIn2LevelHeaderTable(String xpathParent, String headerLevel1) {
		return locateColumnIn2LevelHeaderTable(xpathParent, headerLevel1, "");
	}
	
	public void selectDdlByTextTH6(String _value) {
		String xpath = "//div[contains(@class,'ui-selectonemenu-panel') and contains(@style,'block')]";
		waitElementToBePresentThenScrollIntoView(xpath).waitUntilEnabled().waitUntilVisible();
		
		clickOnElement(xpath + "//ul/li[.='" + _value + "']");
	}
	
	public int getRowIndexByCellValue(String parentXpath, String value) {
		return getTbRowIndexOfDataCell(parentXpath + "//table/tbody/tr/td[descendant-or-self::*[normalize-space(text())='" + value + "']]");
	}
	
	public int getRowIndexByCellValue(String parentXpath, String colIndex, String value) {
		return getTbRowIndexOfDataCell(parentXpath + "//table/tbody/tr/td[" + colIndex + "][descendant-or-self::*[normalize-space(text())='" + value + "']]");
	}
	
}
