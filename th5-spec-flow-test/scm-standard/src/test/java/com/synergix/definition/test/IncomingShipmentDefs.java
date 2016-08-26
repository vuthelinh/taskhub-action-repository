package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.logistics.activeshipment.steps.LogisticIncomingActiveShipmentSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class IncomingShipmentDefs {
	private final static String PO_NO = "Purchase Order No";
	private final static String SV_NO = "Shipment Voucher No";
	@Steps
	LogisticIncomingActiveShipmentSteps LIASSteps;

	@Then("^user verifies display data in Detail tab of Logistic Active History Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_verifies_display_data_in_Detail_tab_of_Logistic_Active_History_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("VERIFY_LAHS_DETAIL", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();

		testData = SessionData.getDataTbRowsByValEqualInCol("VERIFY_LAHS_DETAIL", "KEY", dataKey);
		if (!testData.isEmpty()) {
			LIASSteps.switch_to_tab_detail();
		}
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("VERIFY_LAHS_DETAIL", row, "KEY");
			String sLiNo = SessionData.getDataTbVal("VERIFY_LAHS_DETAIL", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("VERIFY_LAHS_DETAIL", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("VERIFY_LAHS_DETAIL", row, "Item Code");
			String sQty = SessionData.getDataTbVal("VERIFY_LAHS_DETAIL", row, "Qty");
			String sQtyReq = SessionData.getDataTbVal("VERIFY_LAHS_DETAIL", row, "Qty Req");
			int rowIndex = 0;
			if (!sKey.isEmpty()) {
			}
			if (!sLiNo.isEmpty()) {
				rowIndex = LIASSteps.get_lahsis_det_row_index_by_li_no(sLiNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				assertThat(LIASSteps.get_lahsis_det_type(rowIndex).equals(sItemType)).isTrue();
			}
			if (!sItemCode.isEmpty()) {
				assertThat(LIASSteps.get_lahsis_det_item_code(rowIndex).equals(sItemCode)).isTrue();
			}
			if (!sQty.isEmpty()) {
				assertThat(LIASSteps.get_lahsis_det_qty(rowIndex).equals(sQty)).isTrue();
			}
			if (!sQtyReq.isEmpty()) {
				assertThat(LIASSteps.get_lahsis_det_qty_req(rowIndex).equals(sQtyReq)).isTrue();
			}
		}
	}

	@Then("^user previews Reports in Incoming Shipment as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Incoming_Shipment_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("PREVIEW_PDF_REPORT", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("PREVIEW_PDF_REPORT", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("PREVIEW_PDF_REPORT", row, "KEY");
			String sReportTitle = SessionData.getDataTbVal("PREVIEW_PDF_REPORT", row, "Report Title");
			String sChecksum = SessionData.getDataTbVal("PREVIEW_PDF_REPORT", row, "Checksum");
			String sContents = SessionData.getDataTbVal("PREVIEW_PDF_REPORT", row, "Contents");
			if (!sKey.isEmpty()) {
			}
			String sCurrentWindow = LIASSteps.getCurrentWindowHandle();
			LIASSteps.click_btn_preview();
			boolean isDisplaySelectReport = LIASSteps.is_display_reports_selection();
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				LIASSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (LIASSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", LIASSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					int iRet = LIASSteps.count_text_sections_in_report();
					assertTrue("Checksum is not correct. Expected : " + iChecksum + " Actual: " + iRet,
							iRet == iChecksum);
				}
				LIASSteps.getDriver().close();
				LIASSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				LIASSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user opens created Shipment Voucher No\\. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Incoming_Active_Shipment_Summary_by_created_Purchase_Order_No()
			throws Throwable {
		LIASSteps.switch_to_tab_outstanding();
		LIASSteps.filter_by_source_voucher_no(SessionData.getListStringLastValue(PO_NO));
		LIASSteps.open_first_shipment_voucher_no();
		SessionData.addToListString(SV_NO, LIASSteps.get_laosis_shipment_no());
		LIASSteps.shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
	}

	@Then("^user opens created Shipment Voucher No\\. in Outstanding state of Logistic Incoming Active Shipment Summary by (\\d+) before last created Purchase Order No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Incoming_Active_Shipment_Summary_by_before_last_created_Purchase_Order_No(
			int arg1) throws Throwable {
		LIASSteps.switch_to_tab_outstanding();
		LIASSteps.filter_by_source_voucher_no(SessionData.getListStringByIndex(PO_NO, -arg1));
		LIASSteps.open_first_shipment_voucher_no();
		SessionData.addToListString(SV_NO, LIASSteps.get_laosis_shipment_no());
		LIASSteps.shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
	}

	@Then("^user opens created Shipment Voucher No\\. in Costing state of Logistic Incoming Active Shipment Summary by created Purchase Order No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Costing_state_of_Logistic_Incoming_Active_Shipment_Summary_by_created_Purchase_Order_No()
			throws Throwable {
		LIASSteps.switch_to_tab_costing();
		LIASSteps.filter_by_source_voucher_no(SessionData.getListStringLastValue(PO_NO));
		LIASSteps.open_first_shipment_voucher_no();
		SessionData.addToListString(SV_NO, LIASSteps.get_lcsis_shipment_no());
		LIASSteps.shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
	}

	@Then("^user opens created Shipment Voucher No\\. in Outstanding state of Logistic Incoming Active Shipment Summary by created Shipment Voucher No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Incoming_Active_Shipment_Summary_by_created_Shipment_Voucher_No()
			throws Throwable {
		LIASSteps.switch_to_tab_outstanding();
		LIASSteps.filter_by_shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
		LIASSteps.open_first_shipment_voucher_no();
	}

	@Then("^user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_inputs_data_in_Header_tab_of_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		LIASSteps.switch_to_tab_header();
		SessionData.addDataTable("LAOS_ISD_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LAOS_ISD_HEADER_TAB", "KEY", dataKey).keySet()) {
			// String sKey = SessionData.getDataTbVal("LAOS_ISD_HEADER_TAB",
			// row, "KEY");
			String sActualShipmentDate = SessionData.getDataTbVal("LAOS_ISD_HEADER_TAB", row, "Actual Shipment Date");
			String sActualArrivalDate = SessionData.getDataTbVal("LAOS_ISD_HEADER_TAB", row, "Actual Arrival Date");
			String sGoodsReceiptDate = SessionData.getDataTbVal("LAOS_ISD_HEADER_TAB", row, "Goods Receipt Date");
			if (!sActualShipmentDate.isEmpty()) {
				LIASSteps.enter_laosis_actual_shipment_date(sActualShipmentDate);
			}
			if (!sActualArrivalDate.isEmpty()) {
				LIASSteps.enter_laosis_actual_arrival_date(sActualArrivalDate);
			}
			if (!sGoodsReceiptDate.isEmpty()) {
				LIASSteps.enter_laosis_goods_receipt_date(sGoodsReceiptDate);
			}
		}

	}

	@Then("^user click on Receive All Ost Qty button in Detail tab of Active Outstanding Shipment - Incoming Shipment Details$")
	public void user_Click_on_Receive_All_Ost_Qty_button_in_Detail_tab_of_Active_Outstanding_Shipment_Incoming_Shipment_Details()
			throws Throwable {
		LIASSteps.switch_to_tab_detail();
		LIASSteps.click_laosis_det_receive_all_ost_qty();
	}

	@Then("^user submits created Shipment Voucher No\\. in Logistic Active Outstanding Shipment - Incoming Shipment Details$")
	public void user_submits_created_Shipment_Voucher_No_in_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details()
			throws Throwable {
		LIASSteps.click_btn_submit_incoming_shipment_detail();
	}

	@Then("^user submits created Shipment Voucher No\\. in Logistic Active Outstanding Shipment - Incoming Shipment Details then get Shipment Voucher No$")
	public void user_submits_created_Shipment_Voucher_No_in_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details_then_get_Shipment_Voucher_No()
			throws Throwable {
		LIASSteps.click_btn_submit_incoming_shipment_detail();
		SessionData.addToListString(SV_NO, LIASSteps.get_infor_messeage_shipment_voucher_no());
		LIASSteps.click_btn_ok_infor_messeage();
		LIASSteps.shipment_voucher_no(SessionData.getListStringLastValue(SV_NO).toString());
	}

	@Then("^user submits created Shipment Voucher No\\. in Logistic Costing Shipment - Incoming Shipment Details$")
	public void user_submits_created_Shipment_Voucher_No_in_Logistic_Costing_Shipment_Incoming_Shipment_Details()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LIASSteps.click_btn_submit_lcsis_incoming_shipment_detail();
	}

	@Then("^user switchs through all tab in Logistic Active History Shipment - Incoming Shipment Details$")
	public void user_switchs_through_all_tab_in_Logistic_Active_History_Shipment_Incoming_Shipment_Details()
			throws Throwable {
		LIASSteps.switch_to_tab_header();
		LIASSteps.switch_to_tab_detail();
		LIASSteps.switch_to_tab_shipping_info();
		LIASSteps.switch_to_tab_attachments();
	}

	@Then("^user switchs through all tab in Logistic Active Outstanding Shipment - Incoming Shipment Details$")
	public void user_switchs_through_all_tab_in_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details()
			throws Throwable {
		LIASSteps.switch_to_tab_header();
		LIASSteps.switch_to_tab_detail();
		LIASSteps.switch_to_tab_shipping_info();
		LIASSteps.switch_to_tab_attachments();
	}

	@Then("^user opens Shipment Voucher No\\. in History state of Logistic Incoming Active Shipment Summary$")
	public void user_opens_Shipment_Voucher_No_in_History_state_of_Logistic_Incoming_Active_Shipment_Summary()
			throws Throwable {
		LIASSteps.switch_to_tab_history();
		LIASSteps.filter_by_shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
		LIASSteps.open_first_shipment_voucher_no();
	}

	@Then("^user opens Shipment Voucher No\\. in History state of Logistic Incoming Active Shipment Summary by (\\d+) before last created Shipment Voucher No\\.$")
	public void user_opens_Shipment_Voucher_No_in_History_state_of_Logistic_Incoming_Active_Shipment_Summary_by_before_last_created_Shipment_Voucher_No(
			int arg1) throws Throwable {
		LIASSteps.switch_to_tab_history();
		LIASSteps.filter_by_shipment_voucher_no(SessionData.getListStringByIndex(SV_NO, -arg1));
		LIASSteps.open_first_shipment_voucher_no();
	}

	@Then("^user add new Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_add_new_Lots_Information_for_item_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("LAOS_ISD_DETAIL_TAB_LOT_INFO", dataTable, false);
		String tempNo = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LAOS_ISD_DETAIL_TAB_LOT_INFO", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row, "No.");
			String sNextNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row + 1, "No.");
			String sRefNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row, "Ref No.");
			String sExpireDate = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row, "Expire Date");
			String sCountryOfOrigin = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row,
					"Country of Origin");
			String sQuantity = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row, "Quantity");
			String sGrossWeight = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row, "Gross Weight");
			String sTareWeight = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_LOT_INFO", row, "Tare Weight");
			if (sNo.isEmpty()) {
				continue;
			}
			int itemRowIndex = 0;
			if (!sNo.equals(tempNo)) {
				itemRowIndex = LIASSteps.get_laosis_det_row_index_by_no(sNo);
				LIASSteps.open_laosis_det_lots_information(itemRowIndex);
			}
			tempNo = sNo;
			LIASSteps.click_btn_li_add();
			if (!sRefNo.isEmpty()) {
				LIASSteps.enter_li_new_ref_no(sRefNo);
			}
			if (!sExpireDate.isEmpty()) {
				LIASSteps.enter_li_new_expiry_date(sExpireDate);
			}
			if (!sCountryOfOrigin.isEmpty()) {
				LIASSteps.enter_li_new_country_of_origin(sCountryOfOrigin);
			}
			if (!sQuantity.isEmpty()) {
				LIASSteps.enter_li_new_quantity(sQuantity);
			}
			if (!sGrossWeight.isEmpty()) {
				LIASSteps.enter_li_new_gross_weight(sGrossWeight);
			}
			if (!sTareWeight.isEmpty()) {
				LIASSteps.enter_li_new_tare_weight(sTareWeight);
			}
			if (!sNo.equals(sNextNo)) {
				LIASSteps.click_btn_li_done();
			}
		}
	}

	@Then("^user adds new items in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_adds_new_item_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		LIASSteps.switch_to_tab_detail();
		SessionData.addDataTable("LAOS_ISD_DETAIL_TAB_ADD_ITEM", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LAOS_ISD_DETAIL_TAB_ADD_ITEM", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_ADD_ITEM", row, "No.");
			String sItemCode = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_ADD_ITEM", row, "Item Code");
			String sSourcePoLineItemNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_ADD_ITEM", row,
					"Source PO Line Item No.");
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				LIASSteps.click_laosis_det_add();
				rowIndex = LIASSteps.get_laosis_det_row_index_by_no(sNo);
			} else {
				continue;
			}
			if (!sItemCode.isEmpty()) {
				LIASSteps.enter_laosis_det_item_code(rowIndex, sItemCode);
			}
			if (!sSourcePoLineItemNo.isEmpty()) {
				LIASSteps.enter_laosis_det_source_po_line_item_no(rowIndex, sSourcePoLineItemNo);
			}
		}
	}

	@Then("^user updates data of items in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_updates_data_of_items_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		LIASSteps.switch_to_tab_detail();
		SessionData.addDataTable("LAOS_ISD_DETAIL_TAB_UPDATE_ITEM", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LAOS_ISD_DETAIL_TAB_UPDATE_ITEM", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "No.");
			String sQty = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "Qty");
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				rowIndex = LIASSteps.get_laosis_det_row_index_by_no(sNo);
			} else {
				continue;
			}
			if (!sQty.isEmpty()) {
				LIASSteps.enter_laosis_det_qty(rowIndex, sQty);
			}
		}
	}

	@Then("^user generates Serial No Generating in Receving Serial Number in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_generates_Serial_No_Generating_in_Receving_Serial_Number_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", dataTable, false);
		for (int row : SessionData
				.getDataTbRowsByValEqualInCol("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", "KEY", dataKey).keySet()) {
			String sNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", row, "No.");
			String sPrefix = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", row, "Prefix");
			String sSuffix = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", row, "Suffix");
			String sFirstNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", row, "First No");
			String sLastNo = SessionData.getDataTbVal("LAOS_ISD_DETAIL_TAB_SERIAL_NO_GENERATING", row, "Last No");
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				rowIndex = LIASSteps.get_laosis_det_row_index_by_no(sNo);
				LIASSteps.open_laosis_det_receving_serial_number(rowIndex);
			} else {
				continue;
			}
			LIASSteps.switch_to_tab_rsn_serial_no_generating();
			if (!sPrefix.isEmpty()) {
				LIASSteps.enter_rsn_prefix(sPrefix);
			}
			if (!sSuffix.isEmpty()) {
				LIASSteps.enter_rsn_suffix(sSuffix);
			}
			if (!sFirstNo.isEmpty()) {
				LIASSteps.enter_rsn_first_no(sFirstNo);
			}
			if (!sLastNo.isEmpty()) {
				LIASSteps.enter_rsn_last_no(sLastNo);
			}
			LIASSteps.click_btn_rsn_generate();
			LIASSteps.click_btn_rsn_done();
		}
	}

	// BEGIN Logistic Costing Shipment - Incoming Shipment Details
	@Then("^user adds new item in Detail tab of Logistic Costing Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_add_new_item_in_Detail_tab_of_Logistic_Costing_Shipment_Incoming_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("LCS_ISD_DETAIL_TAB_ADD_ITEM", dataTable);
		LIASSteps.switch_to_tab_detail();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LCS_ISD_DETAIL_TAB_ADD_ITEM", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_ADD_ITEM", row, "No.");
			String sItemCode = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_ADD_ITEM", row, "Item Code");
			String sQty = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_ADD_ITEM", row, "Qty");
			String sUnitCost = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_ADD_ITEM", row, "Unit Cost");
			String sCostVariance = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_ADD_ITEM", row, "Cost Variance");
			String sSourcePoLineItemNo = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_ADD_ITEM", row,
					"Source PO Line Item No.");
			int rowIndex = 0;
			if (!sNo.isEmpty() || !sItemCode.isEmpty()) {
				LIASSteps.click_lcsis_det_add();
				rowIndex = LIASSteps.get_lcsis_det_row_index_by_no(sNo);
			} else {
				continue;
			}
			if (!sItemCode.isEmpty()) {
				LIASSteps.enter_lcsis_det_item_code(rowIndex, sItemCode);
			}
			if (!sQty.isEmpty()) {
				LIASSteps.enter_lcsis_det_qty(rowIndex, sQty);
			}
			if (!sUnitCost.isEmpty()) {
				LIASSteps.enter_lcsis_det_unit_cost(rowIndex, sUnitCost);
			}
			if (!sCostVariance.isEmpty()) {
				LIASSteps.select_lcsis_det_cost_variance(rowIndex, sCostVariance);
			}
			if (!sSourcePoLineItemNo.isEmpty()) {
				LIASSteps.enter_lcsis_det_source_po_line_item_no(rowIndex, sSourcePoLineItemNo);
			}
		}
	}

	@Then("^user updates data in Detail tab of Logistic Costing Shipment - Incoming Shipment Details as \"([^\"]*)\"$")
	public void user_update_data_in_Detail_tab_of_Logistic_Costing_Shipment_Incoming_Shipment_Details_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", dataTable);
		LIASSteps.switch_to_tab_detail();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "No.");
			String sItemCode = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "Item Code");
			String sQty = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "Qty");
			String sUnitCost = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "Unit Cost");
			String sCostVariance = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", row, "Cost Variance");
			String sSourcePoLineItemNo = SessionData.getDataTbVal("LCS_ISD_DETAIL_TAB_UPDATE_ITEM", row,
					"Source PO Line Item No.");
			int rowIndex = 0;
			if (!sNo.isEmpty() || !sItemCode.isEmpty()) {
				rowIndex = LIASSteps.get_lcsis_det_row_index_by_no(sNo);
			} else {
				continue;
			}
			if (!sQty.isEmpty()) {
				LIASSteps.enter_lcsis_det_qty(rowIndex, sQty);
			}
			if (!sCostVariance.isEmpty()) {
				LIASSteps.select_lcsis_det_cost_variance(rowIndex, sCostVariance);
			}
			if (!sUnitCost.isEmpty()) {
				LIASSteps.enter_lcsis_det_unit_cost(rowIndex, sUnitCost);
			}
			if (!sSourcePoLineItemNo.isEmpty()) {
				LIASSteps.enter_lcsis_det_source_po_line_item_no(rowIndex, sSourcePoLineItemNo);
			}
		}
	}

	@Then("^user submits error created Shipment Voucher No\\. in Logistic Active Outstanding Shipment - Incoming Shipment Details$")
	public void user_submits_error_created_Shipment_Voucher_No_in_Logistic_Active_Outstanding_Shipment_Incoming_Shipment_Details()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LIASSteps.click_btn_lcsis_submit_incoming_shipment_detail_no_assert();
	}

	@Then("^user verifies Error Message display as \"([^\"]*)\"$")
	public void user_verify_Error_Message_display_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("VERIFY_ERROR_SUBMIT_MESSAGE", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("VERIFY_ERROR_SUBMIT_MESSAGE", "KEY", dataKey)
				.keySet()) {
			String sContents = SessionData.getDataTbVal("VERIFY_ERROR_SUBMIT_MESSAGE", row, "Contents");
			if (!sContents.isEmpty()) {
				String contents = LIASSteps.get_submit_error_messages();
				if (!contents.contains(sContents)) {
					fail("Error message does not contain expected message: " + sContents);
				}
			}
		}
	}
	// END Logistic Costing Shipment - Incoming Shipment Details
}
