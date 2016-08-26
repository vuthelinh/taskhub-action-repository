package com.synergix.definition.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.synergix.processing.project.costing.steps.CostItemEnquiryRequestSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CostItemEnquiryRequestDefs {
	private final static String PR_NO = "Purchase Requisition No";
	private final static String RV_NO = "Request Voucher No";
	// private final static String PO_NO = "Purchase Order No";
	@Steps
	CostItemEnquiryRequestSteps CIERSteps;

	@Then("^user opens Project No\\. in Cost Item Enquiry & Request as \"([^\"]*)\"$")
	public void user_opens_Project_No_in_Cost_Item_Enquiry_Request_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("CIER_OPEN_PROJECT_NO", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("CIER_OPEN_PROJECT_NO", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "KEY");
			String sProjectNo = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Project No.");
			String sCustomerName = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Customer Name");
			String sCustomerJobNo = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Customer Job No.");
			String sSalesPerson = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Sales Person");
			String sSalesManager = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Sales Manager");
			String sStartDateFrom = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Start Date From");
			String sStartDateTo = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Start Date To");
			String sEndDateFrom = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "End Date From");
			String sEndDateTo = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "End Date To");
			String sSubject = SessionData.getDataTbVal("CIER_OPEN_PROJECT_NO", row, "Subject");
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			if (!sProjectNo.isEmpty()) {
				CIERSteps.filter_by_project_no(sProjectNo);
			}
			if (!sCustomerName.isEmpty()) {
				CIERSteps.filter_by_customer_name(sCustomerName);
			}
			if (!sCustomerJobNo.isEmpty()) {
				CIERSteps.filter_by_customer_job_no(sCustomerJobNo);
			}
			if (!sSalesPerson.isEmpty()) {
				CIERSteps.filter_by_sales_person(sSalesPerson);
			}
			if (!sSalesManager.isEmpty()) {
				CIERSteps.filter_by_sales_manager(sSalesManager);
			}
			if (!sStartDateFrom.isEmpty() && !sStartDateTo.isEmpty()) {
				CIERSteps.filter_by_start_date(sStartDateFrom, sStartDateTo);
			}

			if (!sEndDateFrom.isEmpty() && !sEndDateTo.isEmpty()) {
				CIERSteps.filter_by_end_date(sEndDateFrom, sEndDateFrom);
			}
			if (!sSubject.isEmpty()) {
				CIERSteps.filter_by_subject(sSubject);
			}
			CIERSteps.open_first_project_no();
		}
	}

	@Then("^user creates blank new request in Cost Item Request Summary of Cost Item Enquiry & Request$")
	public void user_creates_blank_new_request_in_Cost_Item_Request_Summary_of_Cost_Item_Enquiry_Request()
			throws Throwable {
		CIERSteps.switch_to_tab_request_draft();
		CIERSteps.click_btn_create_blank_new_request();
		SessionData.addToListString(RV_NO, CIERSteps.get_cird_request_voucher_no());
		CIERSteps.request_voucher_no(SessionData.getListStringLastValue(RV_NO).toString());
	}

	@Then("^user adds new item in Detail tab in Cost Item Request Draft of Cost Item Enquiry & Request as \"([^\"]*)\"$")
	public void user_adds_new_item_in_Detail_tab_in_Cost_Item_Request_Draft_of_Cost_Item_Enquiry_Request_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("CIER_CIRD_DETAIL_ADD_NEW_ITEM", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("CIER_CIRD_DETAIL_ADD_NEW_ITEM", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_ITEM", row, "No.");
			String sType = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_ITEM", row, "Type");
			String sItemCode = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_ITEM", row, "Item Code");
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				CIERSteps.click_btn_cird_add();
				rowIndex = CIERSteps.get_cird_det_row_index_by_no(sNo);
			}
			if (!sType.isEmpty()) {
				CIERSteps.select_cird_det_type(rowIndex, sType);
			}
			if (!sItemCode.isEmpty()) {
				CIERSteps.enter_cird_det_item_code(rowIndex, sItemCode);
			}
		}
	}

	@Then("^user updates data in Qty To Request Break Down By Phase of Cost Item Enquiry in Cost Item Enquiry of Cost Item Enquiry & Request as \"([^\"]*)\"$")
	public void user_updates_data_in_Qty_To_Request_Break_Down_By_Phase_of_Cost_Item_Enquiry_in_Cost_Item_Enquiry_of_Cost_Item_Enquiry_Request_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("CIER_CIE_UPDATE_QTRBDBP", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("CIER_CIE_UPDATE_QTRBDBP", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "KEY");
			String sNo = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "No.");
			String sType = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "Type");
			String sItemCode = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "Item Code");
			String sSel = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "Sel");
			String sPhaseNo = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "Phase No.");
			String sQtyToRequest = SessionData.getDataTbVal("CIER_CIE_UPDATE_QTRBDBP", row, "Qty to Request");
			if (sKey.isEmpty() || sNo.isEmpty() || sPhaseNo.isEmpty()) {
				continue;
			}
			int itemRowIndex = 0;
			int phaseRowIndex = 0;

			itemRowIndex = CIERSteps.get_cie_row_index_by_no(sNo);
			if (!sType.isEmpty()) {
				String type = CIERSteps.get_cie_type(itemRowIndex);
				assertTrue("Item type is not correct." + "Expected: " + sType + "Actual: " + type, type.equals(sType));
			}
			if (!sItemCode.isEmpty()) {
				String itemCode = CIERSteps.get_cie_item_code(itemRowIndex);
				assertTrue("Item Code is not correct." + "Expected: " + sItemCode + "Actual: " + itemCode,
						itemCode.contains(sItemCode));
			}
			if (!sSel.isEmpty()) {
				CIERSteps.set_checkbox_cie_sel(itemRowIndex, sSel);
			}
			CIERSteps.click_on_cie_qty_to_request(itemRowIndex);
			phaseRowIndex = CIERSteps.get_cie_qtrbdbp_row_index_by_phase_no(sPhaseNo);
			if (!sQtyToRequest.isEmpty()) {
				CIERSteps.enter_cie_qtrbdbp_qty_to_request(phaseRowIndex, sQtyToRequest);
			}
		}
	}

	@Then("^user inputs new data in Qty To Request Break Down By Phase in Cost Item Request Draft of Cost Item Enquiry & Request as \"([^\"]*)\"$")
	public void user_inputs_new_data_in_Qty_To_Request_Break_Down_By_Phase_in_Cost_Item_Request_Draft_of_Cost_Item_Enquiry_Request_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("CIER_CIRD_DETAIL_ADD_NEW_QTRBDBP", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("CIER_CIRD_DETAIL_ADD_NEW_QTRBDBP", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_QTRBDBP", row, "KEY");
			String sNo = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_QTRBDBP", row, "No.");
			String sPhaseNo = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_QTRBDBP", row, "Phase No.");
			String sQtyToRequest = SessionData.getDataTbVal("CIER_CIRD_DETAIL_ADD_NEW_QTRBDBP", row, "Qty to Request");
			if (sKey.isEmpty() || sNo.isEmpty() || sPhaseNo.isEmpty()) {
				continue;
			}
			int itemRowIndex = 0;
			int phaseRowIndex = 0;

			itemRowIndex = CIERSteps.get_cird_det_row_index_by_no(sNo);
			CIERSteps.click_on_cird_det_qty_to_request(itemRowIndex);
			CIERSteps.click_btn_cird_qtrbdbp_add();
			CIERSteps.enter_cird_qtrbdbp_new_phase_no(sPhaseNo);
			phaseRowIndex = CIERSteps.get_cird_qtrbdbp_row_index_by_phase_no(sPhaseNo);
			if (!sQtyToRequest.isEmpty()) {
				CIERSteps.enter_cird_qtrbdbp_qty_to_request(phaseRowIndex, sQtyToRequest);
			}
		}
	}

	@Then("^user adds selected items to request in Cost Item Enquiry of Cost Item Enquiry & Request$")
	public void user_adds_selected_items_to_request_in_Cost_Item_Enquiry_of_Cost_Item_Enquiry_Request()
			throws Throwable {
		CIERSteps.click_btn_add_items_to_request();
	}

	@Then("^user submits Cost Item Request Draft in Cost Item Enquiry & Request$")
	public void user_submits_Cost_Item_Request_Draft_in_Cost_Item_Enquiry_Request() throws Throwable {
		CIERSteps.click_btn_cird_submit();
		SessionData.addToListString(PR_NO, CIERSteps.get_cird_purchase_requisition_voucher_no());
		CIERSteps.click_cird_btn_ok_infor_panel_message();
		CIERSteps.purchase_requisition_voucher_no(SessionData.getListStringLastValue(PR_NO).toString());
	}
}
