package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.logistics.activeshipment.steps.LogisticOutgoingActiveShipmentSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OutgoingShipmentDefs {
	private final static String SO_NO = "Sales Order No";
	private final static String SV_NO = "Shipment Voucher No";
	@Steps
	LogisticOutgoingActiveShipmentSteps LOASSteps;

	@Then("^user previews Reports in Outgoing Shipment as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Outgoing_Shipment_as(String dataKey, List<List<String>> dataTable)
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
			String sCurrentWindow = LOASSteps.getCurrentWindowHandle();
			LOASSteps.click_btn_preview();
			boolean isDisplaySelectReport = LOASSteps.is_display_reports_selection();
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				LOASSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (LOASSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", LOASSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					int iRet = LOASSteps.count_text_sections_in_report();
					assertTrue("Checksum is not correct. Expected : " + iChecksum + " Actual: " + iRet,
							iRet == iChecksum);
				}
				LOASSteps.getDriver().close();
				LOASSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				LOASSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user verifies display data in Detail tab of Logistic Active History Shipment - Outgoing Shipment Details as \"([^\"]*)\"$")
	public void user_verifies_display_data_in_Detail_tab_of_Logistic_Active_History_Shipment_Outgoing_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("VERIFY_LAHSOS_DETAIL", dataTable, false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("VERIFY_LAHSOS_DETAIL", "KEY", dataKey);
		if (!testData.isEmpty()) {
			LOASSteps.switch_to_tab_detail();
		}
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("VERIFY_LAHSOS_DETAIL", row, "KEY");
			String sNo = SessionData.getDataTbVal("VERIFY_LAHSOS_DETAIL", row, "No.");
			String sType = SessionData.getDataTbVal("VERIFY_LAHSOS_DETAIL", row, "Type");
			String sItemCode = SessionData.getDataTbVal("VERIFY_LAHSOS_DETAIL", row, "Item Code");
			String sQty = SessionData.getDataTbVal("VERIFY_LAHSOS_DETAIL", row, "Qty");
			String sQtyReq = SessionData.getDataTbVal("VERIFY_LAHSOS_DETAIL", row, "Qty Req");
			if (!sKey.isEmpty()) {
			}
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				rowIndex = LOASSteps.get_lahsos_det_row_index_by_no(sNo);
			} else {
				continue;
			}
			if (!sType.isEmpty()) {
				assertThat(LOASSteps.get_lahsos_det_type(rowIndex).equals(sType)).isTrue();
			}
			if (!sItemCode.isEmpty()) {
				assertThat(LOASSteps.get_lahsos_det_item_code(rowIndex).equals(sItemCode)).isTrue();
			}
			if (!sQty.isEmpty()) {
				assertThat(LOASSteps.get_lahsos_det_qty(rowIndex).equals(sQty)).isTrue();
			}
			if (!sQtyReq.isEmpty()) {
				assertThat(LOASSteps.get_lahsos_det_qty_req(rowIndex).equals(sQtyReq)).isTrue();
			}
		}
	}

	@Then("^user opens created Shipment Voucher No\\. in Outstanding state of Logistic Outgoing Active Shipment Summary by (\\d+) before last created Sales Order No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Outgoing_Active_Shipment_Summary_by_before_last_created_Sales_Order_No(
			int arg1) throws Throwable {
		LOASSteps.switch_to_tab_outstanding();
		LOASSteps.filter_by_source_voucher_no(SessionData.getListStringByIndex(SO_NO, -arg1));
		LOASSteps.open_first_shipment_voucher_no();
		SessionData.addToListString(SV_NO, LOASSteps.get_laos_shipment_no());
		LOASSteps.shipment_no(SessionData.getListStringLastValue(SV_NO).toString());
	}

	@Then("^user opens created Shipment Voucher No\\. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Outgoing_Active_Shipment_Summary_by_created_Sales_Order_No()
			throws Throwable {
		LOASSteps.switch_to_tab_outstanding();
		LOASSteps.filter_by_source_voucher_no(SessionData.getListStringLastValue(SO_NO));
		LOASSteps.open_first_shipment_voucher_no();
		SessionData.addToListString(SV_NO, LOASSteps.get_laos_shipment_no());
		LOASSteps.shipment_no(SessionData.getListStringLastValue(SV_NO).toString());
	}

	@Then("^user opens created Shipment Voucher No\\. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Shipment Voucher No\\.$")
	public void user_opens_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Outgoing_Active_Shipment_Summary_by_created_Shipment_Voucher_No()
			throws Throwable {
		LOASSteps.switch_to_tab_outstanding();
		LOASSteps.filter_by_shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
		LOASSteps.open_first_shipment_voucher_no();
	}

	@Then("^user generates DO No\\. for created Shipment Voucher No\\. in Outstanding state of Logistic Outgoing Active Shipment Summary$")
	public void user_generates_DO_No_for_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Outgoing_Active_Shipment_Summary()
			throws Throwable {
		LOASSteps.click_btn_laos_do_no();
		LOASSteps.do_no(LOASSteps.get_laos_do_no());
	}

	@Then("^user submits created Shipment Voucher No\\. in Outstanding state of Logistic Outgoing Active Shipment Summary$")
	public void user_submits_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Outgoing_Active_Shipment_Summary()
			throws Throwable {
		LOASSteps.click_btn_submit_shipment_no_detail();
	}

	@Then("^user opens Shipment Voucher No\\. in History state of Logistic Outgoing Active Shipment Summary$")
	public void user_opens_Shipment_Voucher_No_in_History_state_of_Logistic_Outgoing_Active_Shipment_Summary()
			throws Throwable {
		LOASSteps.switch_to_tab_history();
		LOASSteps.filter_by_shipment_voucher_no(SessionData.getListStringLastValue(SV_NO));
		LOASSteps.open_first_shipment_voucher_no();
	}

	@Then("^user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details$")
	public void user_resets_Shm_Qty_to_zero_for_All_for_items_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Outgoing_Shipment_Details()
			throws Throwable {
		LOASSteps.switch_to_tab_detail();
		LOASSteps.click_btn_laosos_reset_shm_qty_to_0_for_all();
	}

	@Then("^user selects Deliver All Ost Qty for created Shipment Voucher No\\. in Outstanding state of Logistic Outgoing Active Shipment Summary$")
	public void user_selects_Deliver_All_Ost_Qty_for_created_Shipment_Voucher_No_in_Outstanding_state_of_Logistic_Outgoing_Active_Shipment_Summary()
			throws Throwable {
		LOASSteps.switch_to_tab_detail();
		LOASSteps.click_btn_deliver_all_ost_qty();
	}

	@Then("^user updates data in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as \"([^\"]*)\"$")
	public void user_updates_data_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Outgoing_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		LOASSteps.switch_to_tab_detail();
		SessionData.addDataTable("LAOSOSD_DETAIL_TAB_UPDATE_ITEM", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LAOSOSD_DETAIL_TAB_UPDATE_ITEM", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("LAOSOSD_DETAIL_TAB_UPDATE_ITEM", row, "No.");
			String sQty = SessionData.getDataTbVal("LAOSOSD_DETAIL_TAB_UPDATE_ITEM", row, "Qty");
			String sNoOfPacks = SessionData.getDataTbVal("LAOSOSD_DETAIL_TAB_UPDATE_ITEM", row, "No. Of Packs");
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				rowIndex = LOASSteps.get_laosos_det_row_index_by_no(sNo);
			} else {
				continue;
			}
			if (!sQty.isEmpty()) {
				LOASSteps.enter_laosos_det_qty(rowIndex, sQty);
			}
			if (!sNoOfPacks.isEmpty()) {
				LOASSteps.enter_laosos_det_no_of_packs(rowIndex, sNoOfPacks);
			}
		}
	}

	@Then("^user picks earliest lot first via Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as \"([^\"]*)\"$")
	public void user_picks_earliest_lot_firest_via_Lots_Information_for_item_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Outgoing_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		LOASSteps.switch_to_tab_detail();
		SessionData.addDataTable("LAOSOSD_LOT_INFO_PICKS_EARLIEST_LOT_FIRST", dataTable, false);
		for (int row : SessionData
				.getDataTbRowsByValEqualInCol("LAOSOSD_LOT_INFO_PICKS_EARLIEST_LOT_FIRST", "KEY", dataKey).keySet()) {
			String sNo = SessionData.getDataTbVal("LAOSOSD_LOT_INFO_PICKS_EARLIEST_LOT_FIRST", row, "No.");
			String sQuantity = SessionData.getDataTbVal("LAOSOSD_LOT_INFO_PICKS_EARLIEST_LOT_FIRST", row, "Quantity");
			if (!sNo.isEmpty()) {
				int rowIndex = LOASSteps.get_laosos_det_row_index_by_no(sNo);
				LOASSteps.open_laosos_det_lots_information(rowIndex);
			} else {
				continue;
			}
			if (!sQuantity.isEmpty()) {
				LOASSteps.enter_li_quantity(sQuantity);
			}
			LOASSteps.click_btn_li_pick_earliest_lot_first();
			LOASSteps.click_btn_li_done();
		}
	}

	@Then("^user switchs through all tab in Logistic Active History Shipment - Outgoing Shipment Details$")
	public void user_switchs_through_all_tab_in_Logistic_Active_History_Shipment_Outgoing_Shipment_Details()
			throws Throwable {
		LOASSteps.switch_to_tab_header();
		LOASSteps.switch_to_tab_detail();
		LOASSteps.switch_to_tab_shipping_info();
		LOASSteps.switch_to_tab_attachments();
	}

	@Then("^user switchs through all tab in Logistic Active Outstanding Shipment - Outgoing Shipment Details$")
	public void user_switchs_through_all_tab_in_Logistic_Active_Outstanding_Shipment_Outgoing_Shipment_Details()
			throws Throwable {
		LOASSteps.switch_to_tab_header();
		LOASSteps.switch_to_tab_detail();
		LOASSteps.switch_to_tab_shipping_info();
		LOASSteps.switch_to_tab_attachments();
	}

	@Then("^user adds Serial No via Issuing Serial Number for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as \"([^\"]*)\"$")
	public void user_add_Serial_No_via_Issuing_Serial_Number_for_item_in_Detail_tab_of_Logistic_Active_Outstanding_Shipment_Outgoing_Shipment_Details_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", dataTable, false);
		LOASSteps.switch_to_tab_detail();
		String tempCurrentLineNo = "";
		String tempNextLineNo = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", "KEY", dataKey)
				.keySet()) {
			String sLineNo = SessionData.getDataTbVal("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", row, "Line No.");
			tempNextLineNo = SessionData.getDataTbVal("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", row + 1, "Line No.");
			String sNo = SessionData.getDataTbVal("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", row, "No.");
			String sSerialNo = SessionData.getDataTbVal("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", row, "Serial No");
			String sSelectPossibleSerial = SessionData.getDataTbVal("LAOSOSD_ISSUING_SERIAL_NUMBER_ADD", row,
					"Select Possible Serial");
			int rowIndex = 0;
			int serialRowIndex = 0;

			if (!tempCurrentLineNo.equals(sLineNo)) {
				if (!sLineNo.isEmpty() && (!sSerialNo.isEmpty() || !sSelectPossibleSerial.isEmpty())) {
					rowIndex = LOASSteps.get_laosos_det_row_index_by_no(sLineNo);
				} else {
					continue;
				}
				LOASSteps.open_laosos_det_issuing_serial_number(rowIndex);
			}
			tempCurrentLineNo = sLineNo;

			serialRowIndex = LOASSteps.get_isn_row_by_no(sNo);
			if (!sSerialNo.isEmpty()) {
				LOASSteps.enter_isn_serial_no(serialRowIndex, sSerialNo);
			} else {
				LOASSteps.select_isn_possible_serial_no(serialRowIndex);
			}
			if (!tempCurrentLineNo.equals(tempNextLineNo)) {
				LOASSteps.click_btn_isn_done();
			}
		}
	}
}
