package com.synergix.definition.test;

import java.util.List;

import com.synergix.processing.purchase.purchaseorder.steps.PurchaseOrderVariationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PurchaseOrderVariationDefs {
	private final static String PR_NO = "Purchase Requisition No";
	private final static String PO_NO = "Purchase Order No";
	@Steps
	PurchaseOrderVariationSteps pOVSteps;

	@Then("^user inputs data for Allocation of Allocation Details in Detail tab of Purchase Order Variation Detail as \"([^\"]*)\"$")
	public void user_inputs_data_for_Allocation_of_Allocation_Details_in_Detail_tab_of_Purchase_Order_Variation_Detail_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		pOVSteps.switch_to_tab_detail();
		SessionData.addDataTable("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", dataTable, false);
		String tempCurrentLineNo = "";
		String tempNextLineNo = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "No.");
			tempNextLineNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row + 1, "No.");
			String sAllocationNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row,
					"Allocation No.");
			String sType = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Type");
			String sVoucherNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Voucher No.");
			String sPhaseSequenceNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row,
					"Phase No.");
			// String sScheduleNo =
			// SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL",
			// row, "Schedule No.");
			String sLineNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Line No.");
			String sAllocQty = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Alloc Qty");

			int rowIndex = 0;
			int allocRowIndex = 0;
			boolean isAllocPopup = true;
			if (!tempCurrentLineNo.equals(sNo)) {
				if (!sNo.isEmpty() && !sAllocationNo.isEmpty()) {
					rowIndex = pOVSteps.get_det_row_by_line_item_no(sNo);
				} else {
					continue;
				}
				isAllocPopup = !pOVSteps.is_enable_viewing_source_voucher_detail_for_allocation();
				pOVSteps.open_panel_allocation_details(isAllocPopup, rowIndex);
				pOVSteps.switch_to_tab_ad_allocation_details();
				allocRowIndex = 0;
			}
			tempCurrentLineNo = sNo;
			if (sAllocationNo.equals("1.0")) {
				if (pOVSteps.check_alloc_row_existed_by_allocation_no(sAllocationNo)) {
				} else {
					pOVSteps.click_btn_add_alloc();
				}
				allocRowIndex = 1;
			} else {
				pOVSteps.click_btn_add_alloc();
				allocRowIndex = pOVSteps.get_alloc_row_by_allocation_no(sAllocationNo);
			}
			if (!sType.isEmpty()) {
				pOVSteps.select_alloc_alloc_type(allocRowIndex, sType);
			}
			if (!sVoucherNo.isEmpty()) {
				pOVSteps.enter_alloc_voucher_no(allocRowIndex, sVoucherNo);
			}
			if (!sPhaseSequenceNo.isEmpty()) {
				pOVSteps.enter_alloc_phase_sequence_no(allocRowIndex, sPhaseSequenceNo);
			}
			// if (!sScheduleNo.isEmpty()) {
			// }
			if (!sLineNo.isEmpty()) {
				pOVSteps.enter_alloc_line_no(allocRowIndex, sLineNo);
			}
			if (!sAllocQty.isEmpty()) {
				pOVSteps.enter_alloc_alloc_qty(allocRowIndex, sAllocQty);
			}
			if (!tempCurrentLineNo.equals(tempNextLineNo)) {
				if (isAllocPopup) {
					pOVSteps.click_btn_done_alloc();
				}
			}
		}

	}

	@Then("^user submits created Purchase Order Variation$")
	public void user_submits_created_Purchase_Order_Variation_then_gets_Purchase_Order_No() throws Throwable {
		pOVSteps.click_btn_submit_purchase_order_detail();
	}

}
