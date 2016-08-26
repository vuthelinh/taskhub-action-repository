package com.synergix.processing.project.costing.costingallowcation.steps;

import com.synergix.processing.project.costing.costingallowcation.pages.CostAllowcationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CostAllowcationSteps extends ScenarioSteps {

	CostAllowcationPage onCostAllowcationPage;
	
	@Step
	public void click_new() {
		onCostAllowcationPage.clickBtn("New");
	}

	@Step
	public void cost_allocation_date(String lableText, String value) {
		onCostAllowcationPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void project_no(String projectNo) {
		onCostAllowcationPage.enterInputFieldWithLabel("Project No.", projectNo);
	}

	@Step
	public void default_type(String lableText, String value) {
		onCostAllowcationPage.selectDdlWithLabelByText(lableText, value);
	}

	@Step
	public void reference_no(String lableText, String value) {
		onCostAllowcationPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void currency(String lableText, String value) {
		onCostAllowcationPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void exchange_rate(String lableText, String value) {
		onCostAllowcationPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void click_add_button() {
		onCostAllowcationPage.clickBtn("Add");
	}

	@Step
	public void set_type(String detailNo, String type) {
		
		int currentRowDetail = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathTableDetails, detailNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathTableDetails,"Type",currentRowDetail,"select",1,type); //input data Type
	}

	@Step
	public void set_item_code_remarks_description(String detailNo, String item_code_remarks_description) {
		int currentRowDetail = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathTableDetails, detailNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathTableDetails,"Item Code/Remarks Description",currentRowDetail,"text",1,item_code_remarks_description);//input data Item Code/Remark Description
	}

	@Step
	public void set_cost_allowcation(String detailNo, String allocation) {
		int currentRowDetail = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathTableDetails, detailNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathTableDetails,"Allocation",currentRowDetail,"span",1,allocation); //click on link Allocation
	}
	
	@Step
	public void click_add_cost_allocation_detail_buton() {
		onCostAllowcationPage.clickBtn(onCostAllowcationPage.xpathCostAllocate,"Add");
	}
	
	@Step
	public void set_project_no(String costNo, String project_no) {
		int currentRowAllow = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathCostAllocate, costNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathCostAllocateTable,"Project No.",currentRowAllow,"text",1,project_no); //input data project no
	}

	@Step
	public void set_phase_sequence_no(String costNo, String phase_sequence_no) {
		int currentRowAllow = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathCostAllocate, costNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathCostAllocateTable,"Phase Sequence No.",currentRowAllow,"text",1,phase_sequence_no); //input data Phase Sequence No
	}

	@Step
	public void set_cost_item_sequence_no(String costNo, String cost_item_sequence_no) {
		int currentRowAllow = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathCostAllocate, costNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathCostAllocateTable,"Cost Item Sequence No",currentRowAllow,"text",1,cost_item_sequence_no); //input data Cost Item Sequence No
	}

	@Step
	public void set_alloc_amt(String costNo, String alloc_amt) {
		int currentRowAllow = onCostAllowcationPage.getTbRowIndexOfDataCell(onCostAllowcationPage.xPathTbDataCellByTextEqualInCol(onCostAllowcationPage.xpathCostAllocate, costNo, 1, "No.", 1)); // select current row
		onCostAllowcationPage.setDataCellTable(onCostAllowcationPage.xpathCostAllocateTable,"Alloc Amt",currentRowAllow,"text",1,alloc_amt); //input data Alloc Amt
	}

	@Step
	public void click_done_button() {
		onCostAllowcationPage.clickBtn(onCostAllowcationPage.xpathCostAllocate,"Done");
	}
	
	@Step
	public void go_to_tab_remark() {
		onCostAllowcationPage.switch_to_tab("Remark");
	}
	
	@Step
	public void internal_remarks_code(String lableText, String value) {
		onCostAllowcationPage.enterInputFieldWithLabel(lableText, value);
		
	}
	
	@Step
	public void external_remarks_code(String lableText, String value) {
		onCostAllowcationPage.enterInputFieldWithLabel(lableText, value);
		
	}
	
	@Step
	public void internal_remarks(String lableText, String value) {
		onCostAllowcationPage.enterTextAreaWithLabel(lableText, value);
	}
	
	@Step
	public void external_remarks(String lableText, String value) {
		onCostAllowcationPage.enterTextAreaWithLabel(lableText, value);
	}


	@Step
	public void submit_voucher() {
		onCostAllowcationPage.submit_voucher();
	}

	
	
	

}
