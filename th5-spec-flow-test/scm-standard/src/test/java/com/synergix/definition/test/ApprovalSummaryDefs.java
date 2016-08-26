package com.synergix.definition.test;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.approval.steps.ApprovalSummarySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ApprovalSummaryDefs {
	private final static String APV_NO = "Add Payment Voucher No";
	private final static String PR_NO = "Purchase Requisition No";
	private final static String SO_NO = "Sales Order No";
	@Steps
	ApprovalSummarySteps approvalSummarySteps;

	@Then("^user selects Transaction in Approval Summary as \"([^\"]*)\"$")
	public void user_selects_Transaction_in_Approval_Summary_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("APPROVAL_SUMMARY", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("APPROVAL_SUMMARY", "KEY", dataKey).keySet()) {
			String sModuleCodeDesc = SessionData.getDataTbVal("APPROVAL_SUMMARY", row, "Module Code Desc");
			String sTransactionTypeDesc = SessionData.getDataTbVal("APPROVAL_SUMMARY", row, "Transaction Type Desc");
			approvalSummarySteps.click_on_in_queue_number_by_anytext(sModuleCodeDesc + " " + sTransactionTypeDesc);
		}
	}

	@Then("^user submits Approval Action for Purchase Requisition as \"([^\"]*)\"$")
	public void user_submits_Approval_Action_for_Purchase_Requisition_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("APPROVAL_SUMMARY_DETAIL_PR", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("APPROVAL_SUMMARY_DETAIL_PR", "KEY", dataKey)
				.keySet()) {
			String sPrNo = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_PR", row, "PR No.");
			String sApprovedSupplier = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_PR", row, "Approved Supplier");
			String sAction = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_PR", row, "Action");
			if (!sPrNo.isEmpty()) {
				if (sPrNo.equals("@CREATEDPRNO@")) {
					sPrNo = SessionData.getListStringLastValue(PR_NO);
				}
				approvalSummarySteps.filter_in_queue_by_pr_no(sPrNo);
			} else {
				continue;
			}
			if (!sApprovedSupplier.isEmpty()) {
				approvalSummarySteps.enter_in_queue_approved_supplier_first_row(sApprovedSupplier);
			}
			if (!sAction.isEmpty()) {
				approvalSummarySteps.select_in_queue_action_first_row(sAction);
				approvalSummarySteps.click_btn_submit();
			}
		}
	}

	@Then("^user updates created PR No. for Supplier of Line Item Information in Detail tab of PR Pending Approval Details in Approval Summary as \"([^\"]*)\"$")
	public void user_updates_for_created_PR_No_Supplier_of_Line_Item_Information_in_Detail_tab_of_PR_Pending_Approval_Details_in_Approval_Summary_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("APPROVAL_SUMMARY_PRPAD_DETAIL", dataTable);
		String sPrNo = SessionData.getListStringLastValue(PR_NO);
		approvalSummarySteps.filter_in_queue_by_pr_no(sPrNo);
		approvalSummarySteps.open_first_pr_no();
		approvalSummarySteps.switch_to_tab_prpad_detail();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("APPROVAL_SUMMARY_PRPAD_DETAIL", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("APPROVAL_SUMMARY_PRPAD_DETAIL", row, "KEY");
			String sNo = SessionData.getDataTbVal("APPROVAL_SUMMARY_PRPAD_DETAIL", row, "No.");
			String sSupplier = SessionData.getDataTbVal("APPROVAL_SUMMARY_PRPAD_DETAIL", row, "Supplier");
			String sApprovedSupplier = SessionData.getDataTbVal("APPROVAL_SUMMARY_PRPAD_DETAIL", row,
					"Approved Supplier");
			if (sKey.isEmpty() || sNo.isEmpty() || sSupplier.isEmpty() || sSupplier.isEmpty()) {
				continue;
			}
			int itemRowIndex = 0;
			itemRowIndex = approvalSummarySteps.get_prpad_row_index_by_no(sNo);
			approvalSummarySteps.open_prpad_panel_line_item_information(itemRowIndex);
			int supplierRowIndex = 0;
			supplierRowIndex = approvalSummarySteps.get_prpad_supplier_row_index_by_supplier(sSupplier);
			if (!sApprovedSupplier.isEmpty()) {
				approvalSummarySteps.set_prpad_supplier_approved_supplier(supplierRowIndex, sApprovedSupplier);
			}
		}
		approvalSummarySteps.click_btn_prpad_done();
	}

	@Then("^user submits Approval Action for Sales Order as \"([^\"]*)\"$")
	public void user_submits_Approval_Action_for_Sales_Order_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("APPROVAL_SUMMARY_DETAIL_SO", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("APPROVAL_SUMMARY_DETAIL_SO", "KEY", dataKey)
				.keySet()) {
			String sSONo = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_SO", row, "SO No.");
			String sApprovedSupplier = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_SO", row, "Approved Supplier");
			String sAction = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_SO", row, "Action");
			if (!sSONo.isEmpty()) {
				if (sSONo.equals("@CREATEDSONO@")) {
					sSONo = SessionData.getListStringLastValue(SO_NO);
				}
				approvalSummarySteps.filter_in_queue_by_so_no(sSONo);
			} else {
				continue;
			}
			if (!sApprovedSupplier.isEmpty()) {
				approvalSummarySteps.enter_in_queue_approved_supplier_first_row(sApprovedSupplier);
			}
			if (!sAction.isEmpty()) {
				approvalSummarySteps.select_in_queue_action_first_row(sAction);
				approvalSummarySteps.click_btn_submit();
			}
		}
	}

	// BEGIN PAYROLL
	@Then("^user submits Approval Action for Additional Payment Voucher No\\. as \"([^\"]*)\"$")
	public void user_submits_Approval_Action_for_Additional_Payment_Voucher_No_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row, "KEY");
			String sAdditionalPaymentVoucherNo = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row,
					"Additional Payment Voucher No.");
			String sPayrollDate = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row, "Payroll Date");
			String sRecipientCode = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row,
					"Recipient Code");
			String sRecipientName = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row,
					"Recipient Name");
			String sRemarks = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row, "Remarks");
			String sAction = SessionData.getDataTbVal("APPROVAL_SUMMARY_DETAIL_ADD_PAYMENT", row, "Action");

			if (!sAdditionalPaymentVoucherNo.isEmpty()) {
				if (sAdditionalPaymentVoucherNo.equals("@CREATEDADDPAYMENTVOUCHER@")) {
					sAdditionalPaymentVoucherNo = SessionData.getListStringLastValue(APV_NO);
				}
				approvalSummarySteps.filter_in_queue_by_add_payment_voucher_no(sAdditionalPaymentVoucherNo);
			}
			if (!sRecipientCode.isEmpty()) {
				approvalSummarySteps.filter_in_queue_by_recipient_code(sRecipientCode);
			}
			if (!sRecipientName.isEmpty()) {
				approvalSummarySteps.filter_in_queue_by_recipient_name(sRecipientName);

			}
			if (!sPayrollDate.isEmpty()) {
				approvalSummarySteps.enter_in_queue_payroll_date_first_row(sPayrollDate);
			}

			if (!sRemarks.isEmpty()) {
				approvalSummarySteps.enter_in_queue_remarks_first_row(sRemarks);
			}
			if (!sAction.isEmpty()) {
				approvalSummarySteps.click_btn_submit();
			}
		}
	}
	// END PAYROLL
}
