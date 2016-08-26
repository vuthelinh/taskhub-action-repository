package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.purchase.purchaseorder.steps.PurchaseOrderSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PurchaseOrderDefs {
	private final static String PR_NO = "Purchase Requisition No";
	private final static String PO_NO = "Purchase Order No";
	private final static String SO_NO = "Sales Order No";
	@Steps
	PurchaseOrderSteps pOSteps;

	@Then("^user clear list of created Purchase Order$")
	public void user_clear_list_of_created_Purchase_Order() throws Throwable {
		SessionData.clearListString(PO_NO);
	}

	@Then("^user opens Purchase Order Variation of created Purchase Order in Outstanding state of Purchase Order Summary$")
	public void user_opens_Purchase_Order_Variation_of_created_Purchase_Order_in_Outstanding_state_of_Purchase_Order_Summary()
			throws Throwable {
		pOSteps.switch_to_tab_outstanding();
		pOSteps.filter_summary_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		pOSteps.open_first_purchase_order_variation_no();
	}

	@Then("^user opens created Purchase Order in Outstanding state of Purchase Order Summary by Alloc Voucher No$")
	public void user_opens_created_Purchase_Order_in_Outstanding_state_of_Purchase_Order_Summary_by_Alloc_Voucher_No()
			throws Throwable {
		pOSteps.switch_to_tab_outstanding();
		pOSteps.filter_summary_by_alloc_voucher_no(SessionData.getListStringLastValue(SO_NO));
		pOSteps.open_first_purchase_order_no();
		SessionData.addToListString(PO_NO, pOSteps.get_ost_purchase_order_no());
		pOSteps.purchase_order_no(SessionData.getListStringLastValue(PO_NO).toString());
	}

	@Then("^user opens created Purchase Order in Purchase Order Detail Draft$")
	public void user_opens_created_Purchase_Order_in_Purchase_Order_Detail_Draft() throws Throwable {
		pOSteps.switch_to_tab_draft();
		pOSteps.filter_summary_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		pOSteps.open_first_purchase_order_no();
	}

	@Then("^user opens created Purchase Order in Draft state of Purchase Order Summary$")
	public void user_opens_created_Purchase_Order_in_Draft_state_of_Purchase_Order_Summary() throws Throwable {
		pOSteps.switch_to_tab_draft();
		pOSteps.filter_summary_by_po_no(SessionData.getListStringLastValue(PO_NO));
		pOSteps.open_first_purchase_order_no();
	}

	@Given("^user creates new Purchase Order in Draft stage of Purchase Order Summary as \"([^\"]*)\"$")
	public void user_creates_new_Purchase_Order_in_Draft_stage_of_Purchase_Order_Summary_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_HEADER", dataTable, false);
		pOSteps.switch_to_tab_draft();
		pOSteps.click_btn_new_of_po_summany();
		SessionData.addToListString(PO_NO, pOSteps.get_new_purchase_order_no());
		pOSteps.purchase_order_no(SessionData.getListStringLastValue(PO_NO).toString());
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_HEADER", "KEY", dataKey).keySet()) {
			String sSupplierCode = SessionData.getDataTbVal("PO_DRAFT_HEADER", row, "Supplier Code");
			String sSupplierName = SessionData.getDataTbVal("PO_DRAFT_HEADER", row, "Supplier Name");
			String sCopyFromOption = SessionData.getDataTbVal("PO_DRAFT_HEADER", row, "Copy From Option");
			String sCopyFrom = SessionData.getDataTbVal("PO_DRAFT_HEADER", row, "Copy From");
			if (!sSupplierCode.isEmpty()) {
				pOSteps.enter_supplier(sSupplierCode);
			}
			if (!sSupplierName.isEmpty()) {
				assertThat(pOSteps.get_supplier_name().equals(sSupplierName)).isTrue();
			}
			if (!sCopyFromOption.isEmpty()) {
				pOSteps.select_option_copy_from(sCopyFromOption);
			}
			if (!sCopyFrom.isEmpty()) {
				if (sCopyFrom.toLowerCase().equals("@last purchase order no@")) {
					sCopyFrom = SessionData.getListStringByIndex(PO_NO, -1);
				}
				pOSteps.enter_copy_from_po(sCopyFrom);
				pOSteps.click_btn_copy();
			}
		}
	}

	@Given("^user inputs data in Draft stage in Header tab of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Header_tab_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			pOSteps.switch_to_tab_header();
			String sSupplierContact = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Supplier Contact");
			String sPurchaseOrderDate = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Purchase Order Date");
			String sOrderCurrency = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Order Currency");
			String sSalesTax = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Sales Tax");
			String sPurchaser = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Purchaser");
			String sPurchaseCategory = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Purchase Category");
			String sReferenceNo = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Reference No.");
			String sSubject = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Subject");
			String sSegment1 = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Segment 1");
			String sSegment2 = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Segment 2");
			String sSegment3 = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Segment 3");
			String sSegment4 = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Segment 4");
			if (!sSupplierContact.isEmpty()) {
				pOSteps.enter_supplier_contact(sSupplierContact);
			}
			if (!sPurchaseOrderDate.isEmpty()) {
				pOSteps.enter_purchase_order_date(sPurchaseOrderDate);
			}
			if (!sOrderCurrency.isEmpty()) {
				pOSteps.enter_order_currency(sOrderCurrency);
			}
			if (!sSalesTax.isEmpty()) {
				pOSteps.enter_sales_tax(sSalesTax);
			}
			if (!sPurchaser.isEmpty()) {
				pOSteps.enter_purchaser(sPurchaser);
			}
			if (!sPurchaseCategory.isEmpty()) {
				pOSteps.enter_purchase_category(sPurchaseCategory);
			}
			if (!sReferenceNo.isEmpty()) {
				pOSteps.enter_reference_no(sReferenceNo);
			}
			if (!sSubject.isEmpty()) {
				pOSteps.enter_subject(sSubject);
			}
			if (!sSegment1.isEmpty()) {
				pOSteps.enter_segment_1(sSegment1);
			}
			if (!sSegment2.isEmpty()) {
				pOSteps.enter_segment_2(sSegment2);
			}
			if (!sSegment3.isEmpty()) {
				pOSteps.enter_segment_3(sSegment3);
			}
			if (!sSegment4.isEmpty()) {
				pOSteps.enter_segment_4(sSegment4);
			}
		}
	}

	@Given("^user inputs data for Allocation of Allocation Detail in Detail tab of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_inputs_data_for_Allocation_of_Allocation_Detail_in_Detail_tab_of_Purchase_Order_Detail_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", dataTable, false);
		String tempCurrentLineNo = "";
		String tempNextLineNo = "";
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", "KEY", dataKey);

		boolean isAllocPopup = false;
		if (!testData.isEmpty()) {
			isAllocPopup = !pOSteps.is_enable_viewing_source_voucher_detail_for_allocation();
		}
		for (int row : testData.keySet()) {
			String sNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "No.");
			tempNextLineNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row + 1, "No.");
			String sAllocationNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row,
					"Allocation No.");
			String sType = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Type");
			String sVoucherNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Voucher No.");
			String sPhaseSequenceNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row,
					"Phase Sequence No.");
			// String sScheduleNo =
			// SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL",
			// row, "Schedule No.");
			String sLineNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Line No.");
			String sAllocQty = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_ALLOCATION_DETAIL", row, "Alloc Qty");

			int rowIndex = 0;
			int allocRowIndex = 0;
			if (!tempCurrentLineNo.equals(sNo)) {
				if (!sNo.isEmpty() && !sAllocationNo.isEmpty()) {
					rowIndex = pOSteps.get_det_row_by_line_item_no(sNo);
				} else {
					continue;
				}
				pOSteps.open_panel_allocation_details(isAllocPopup, rowIndex);
				pOSteps.switch_to_tab_ad_allocation_details();
				allocRowIndex = 0;
			}
			tempCurrentLineNo = sNo;
			if (sAllocationNo.equals("1.0")) {
				if (pOSteps.check_alloc_row_existed_by_allocation_no(sAllocationNo)) {
				} else {
					pOSteps.click_btn_add_alloc();
				}
				allocRowIndex = 1;
			} else {
				pOSteps.click_btn_add_alloc();
				allocRowIndex = pOSteps.get_alloc_row_by_allocation_no(sAllocationNo);
			}
			if (!sType.isEmpty()) {
				pOSteps.select_alloc_alloc_type(allocRowIndex, sType);
			}
			if (!sVoucherNo.isEmpty()) {
				pOSteps.enter_alloc_voucher_no(allocRowIndex, sVoucherNo);
			}
			if (!sPhaseSequenceNo.isEmpty()) {
				pOSteps.enter_alloc_phase_sequence_no(allocRowIndex, sPhaseSequenceNo);
			}
			// if (!sScheduleNo.isEmpty()) {
			// }
			if (!sLineNo.isEmpty()) {
				pOSteps.enter_alloc_line_no(allocRowIndex, sLineNo);
			}
			if (!sAllocQty.isEmpty()) {
				pOSteps.enter_alloc_alloc_qty(allocRowIndex, sAllocQty);
			}
			if (!tempCurrentLineNo.equals(tempNextLineNo)) {
				if (isAllocPopup) {
					pOSteps.click_btn_done_alloc();
				}
			}
		}
	}

	@Then("^users updates Contents of item in Draft stage in Detail tab of Purchase Order Detail as \"([^\"]*)\"$")
	public void users_update_Contents_of_item_in_Draft_stage_in_Detail_tab_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", dataTable, false);
		String tempCurrentLineNo = "";
		String tempNextLineNo = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "No.");
			tempNextLineNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row + 1, "No.");
			String sContentCode = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "Content Code");
			String sDescription = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "Description");
			String sPercentage = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "Percentage (%)");
			String sRecoveryRate = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row,
					"Recovery Rate (%)");
			String sContentUnitCost = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row,
					"Content Unit Cost");
			int itemIndex = 0;
			int contentIndex = 0;
			if (!tempCurrentLineNo.equals(sNo)) {
				if (!sNo.isEmpty() && !sContentCode.isEmpty()) {
					itemIndex = pOSteps.get_det_row_by_line_item_no(sNo);
				} else {
					continue;
				}
				pOSteps.open_panel_contents(itemIndex);
			}
			contentIndex = pOSteps.get_content_row_by_content_code(sContentCode);
			tempCurrentLineNo = sNo;
			if (!sDescription.isEmpty()) {
				assertThat(pOSteps.get_content_description(contentIndex).equals(sDescription)).isTrue();
			}
			if (!sPercentage.isEmpty()) {
				pOSteps.enter_content_percentage(contentIndex, sPercentage);
			}
			if (!sRecoveryRate.isEmpty()) {
				pOSteps.enter_content_recovery_rate(contentIndex, sRecoveryRate);
			}
			if (!sContentUnitCost.isEmpty()) {
				pOSteps.enter_content_content_unit_cost(contentIndex, sContentUnitCost);
			}
			if (!tempCurrentLineNo.equals(tempNextLineNo)) {
				pOSteps.click_btn_content_confirm();
			}
		}
	}

	@Then("^user adds new Contents of item in Draft stage in Detail tab of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_add_new_Contents_of_item_in_Draft_stage_in_Detail_tab_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("pOSteps", dataTable, false);
		SessionData.addDataTable("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", dataTable, false);
		String tempCurrentLineNo = "";
		String tempNextLineNo = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", "KEY", dataKey)
				.keySet()) {
			String sNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "No.");
			tempNextLineNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row + 1, "No.");
			String sContentCode = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "Content Code");
			String sDescription = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "Description");
			String sPercentage = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row, "Percentage (%)");
			String sRecoveryRate = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row,
					"Recovery Rate (%)");
			String sContentUnitCost = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_CONTENTS_UPDATE", row,
					"Content Unit Cost");
			int itemIndex = 0;
			int contentIndex = 0;
			if (!tempCurrentLineNo.equals(sNo)) {
				if (!sNo.isEmpty() && !sContentCode.isEmpty()) {
					itemIndex = pOSteps.get_det_row_by_line_item_no(sNo);
				} else {
					continue;
				}
				pOSteps.open_panel_contents(itemIndex);
			}
			pOSteps.click_btn_content_add();
			pOSteps.enter_content_new_content_code(sContentCode);
			contentIndex = pOSteps.get_content_row_by_content_code(sContentCode);
			tempCurrentLineNo = sNo;
			if (!sDescription.isEmpty()) {
				assertThat(pOSteps.get_content_description(contentIndex).equals(sDescription)).isTrue();
			}
			if (!sPercentage.isEmpty()) {
				pOSteps.enter_content_percentage(contentIndex, sPercentage);
			}
			if (!sRecoveryRate.isEmpty()) {
				pOSteps.enter_content_recovery_rate(contentIndex, sRecoveryRate);
			}
			if (!sContentUnitCost.isEmpty()) {
				pOSteps.enter_content_content_unit_cost(contentIndex, sContentUnitCost);
			}
			if (!tempCurrentLineNo.equals(tempNextLineNo)) {
				pOSteps.click_btn_content_confirm();
			}
		}
	}

	@Then("^all default fields in Draft stage in Header tab of Purchase Order Detail will be pulled out as \"([^\"]*)\"$")
	public void all_default_fields_in_Draft_stage_in_Header_tab_of_Purchase_Order_Detail_will_be_pulled_out_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			String sSupplierContact = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Supplier Contact");
			String sSalesTax = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Sales Tax");
			String sOrderCurrency = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Order Currency");
			String sPurchaser = SessionData.getDataTbVal("PO_DRAFT_HEADER_TAB", row, "Purchaser");
			if (!sSupplierContact.isEmpty()) {
				assertThat(pOSteps.get_supplier_contact().equals(sSupplierContact)).isTrue();
			}
			if (!sSalesTax.isEmpty()) {
				assertThat(pOSteps.get_sales_tax().equals(sSalesTax)).isTrue();
			}
			if (!sOrderCurrency.isEmpty()) {
				assertThat(pOSteps.get_order_currency().equals(sOrderCurrency)).isTrue();
			}
			if (!sPurchaser.isEmpty()) {
				assertThat(pOSteps.get_purchaser().equals(sPurchaser)).isTrue();
			}
		}
	}

	@Then("^user inputs data in Draft stage in Shipment tab of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Shipment_tab_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_SHIPMENT_TAB", dataTable, false);
		pOSteps.switch_to_tab_shipment();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_SHIPMENT_TAB", "KEY", dataKey).keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("PO_DRAFT_SHIPMENT_TAB", row, "Shipment Mode");
			String sShipmentTerm = SessionData.getDataTbVal("PO_DRAFT_SHIPMENT_TAB", row, "Shipment Term");
			String sShipToLocation = SessionData.getDataTbVal("PO_DRAFT_SHIPMENT_TAB", row, "Ship to Location");
			String sNoOfShipment = SessionData.getDataTbVal("PO_DRAFT_SHIPMENT_TAB", row, "No. of Shipment");
			if (!sShipmentMode.isEmpty()) {
				pOSteps.enter_shipment_mode(sShipmentMode);
			}
			if (!sShipmentTerm.isEmpty()) {
				pOSteps.enter_shipment_term(sShipmentTerm);
			}
			if (!sShipToLocation.isEmpty()) {
				pOSteps.enter_ship_to_location(sShipToLocation);
			}
			if (!sNoOfShipment.isEmpty()) {
				pOSteps.enter_no_of_shipment(sNoOfShipment);
			}
		}
	}

	@Then("^user inputs data in Draft stage in Detail tab of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Detail_tab_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		pOSteps.switch_to_tab_detail();
		SessionData.addDataTable("PO_DRAFT_DETAIL_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_DETAIL_TAB", "KEY", dataKey).keySet()) {
			String sNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "No.");
			String sItemType = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Item Code");
			String sQty = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Qty");
			String sPackSize = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Pack Size");
			String sNoOfPack = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "No. of Pack");
			String sCostType = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Cost Type");

			String sUnitCost = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Unit Cost");
			String sDiscountPercent = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Discount Percent");
			String sDiscountAmount = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB", row, "Discount Amount");
			pOSteps.click_btn_add_detail();
			int rowIndex = 0;
			if (!sNo.isEmpty()) {
				rowIndex = pOSteps.get_det_row_by_line_item_no(sNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				pOSteps.select_det_type(rowIndex, sItemType);
			}
			if (!sItemCode.isEmpty()) {
				pOSteps.enter_det_item_code(rowIndex, sItemCode);
			}
			if (!sPackSize.isEmpty()) {
				pOSteps.select_det_pack_size(rowIndex, sPackSize);
			}
			if (!sNoOfPack.isEmpty()) {
				pOSteps.enter_det_no_of_pack(rowIndex, sNoOfPack);
			}
			if (!sQty.isEmpty()) {
				pOSteps.enter_det_qty(rowIndex, sQty);
			}
			if (!sUnitCost.isEmpty()) {
				pOSteps.enter_det_unit_cost(rowIndex, sUnitCost);
			}
			if (!sDiscountPercent.isEmpty()) {
				pOSteps.enter_det_discount_percent(rowIndex, sDiscountPercent);
			}
			if (!sDiscountAmount.isEmpty()) {
				pOSteps.enter_det_discount_amount(rowIndex, sDiscountAmount);
			}
			if (!sCostType.isEmpty()) {
				pOSteps.select_det_cost_type(rowIndex, sCostType);
			}
		}
	}

	@Then("^user verifies display data in Detail tab of Draft state of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_verifies_display_data_in_Detail_tab_of_Draft_state_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PO_DRAFT_DETAIL_TAB_VERIFY", dataTable, false);
		pOSteps.switch_to_tab_detail();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_DETAIL_TAB_VERIFY", "KEY", dataKey)
				.keySet()) {
			String sLiNo = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_VERIFY", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_VERIFY", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_VERIFY", row, "Item Code");
			String sQty = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_VERIFY", row, "Qty");
			String sUnitCost = SessionData.getDataTbVal("PO_DRAFT_DETAIL_TAB_VERIFY", row, "Unit Cost");
			int rowIndex = 0;
			if (!sLiNo.isEmpty()) {
				rowIndex = pOSteps.get_det_row_by_line_item_no(sLiNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				assertThat(pOSteps.get_det_type(rowIndex).equals(sItemType)).isTrue();
			}
			if (!sItemCode.isEmpty()) {
				assertThat(pOSteps.get_det_item_code(rowIndex).equals(sItemCode)).isTrue();
			}
			if (!sQty.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(pOSteps.get_det_qty(rowIndex), sQty)).isTrue();
			}
			if (!sUnitCost.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(pOSteps.get_det_unit_cost(rowIndex), sUnitCost)).isTrue();
			}
		}
	}

	@Then("^all default fields in Draft stage in Payment Info tab of Purchase Order Detail will be pulled out as \"([^\"]*)\"$")
	public void all_default_fields_in_Draft_stage_in_Payment_Info_tab_of_Purchase_Order_Detail_will_be_pulled_out_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		pOSteps.switch_to_tab_payment_info();
		SessionData.addDataTable("PO_DRAFT_PAYMENT_INFO_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PO_DRAFT_PAYMENT_INFO_TAB", "KEY", dataKey).keySet()) {
			String sPaymentOption = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Option");
			String sPaymentTerm = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Term");
			String sPaymentTermTenorCode = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row,
					"Payment Term Tenor Code");
			String sPaymentTermTenorDays = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row,
					"Payment Term Tenor Days");
			String sPaymentMethod = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Method");
			String sPaymentAmount = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Amount");
			String sPaymentParty = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Party");
			String sPaymentAddress = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Address");
			String sPaymentContact = SessionData.getDataTbVal("PO_DRAFT_PAYMENT_INFO_TAB", row, "Payment Contact");
			if (!sPaymentOption.isEmpty()) {
				assertThat(pOSteps.get_selected_payment_option().equals(sPaymentOption)).isTrue();
			}
			if (!sPaymentTerm.isEmpty()) {
				assertThat(pOSteps.get_selected_payment_term().equals(sPaymentTerm)).isTrue();
			}
			if (!sPaymentTermTenorCode.isEmpty()) {
				assertThat(pOSteps.get_payment_term_tenor_code().equals(sPaymentTermTenorCode)).isTrue();
			}
			if (!sPaymentTermTenorDays.isEmpty()) {
				assertThat(pOSteps.get_payment_term_tenor_days().equals(sPaymentTermTenorDays)).isTrue();
			}
			if (!sPaymentMethod.isEmpty()) {
				assertThat(pOSteps.get_selected_payment_method().equals(sPaymentMethod)).isTrue();
			}
			if (!sPaymentAmount.isEmpty()) {
				assertThat(pOSteps.get_payment_amount().equals(sPaymentAmount)).isTrue();
			}
			if (!sPaymentParty.isEmpty()) {
				assertThat(pOSteps.get_payment_party().equals(sPaymentParty)).isTrue();
			}
			if (!sPaymentAddress.isEmpty()) {
				assertThat(pOSteps.get_payment_address().equals(sPaymentAddress)).isTrue();
			}
			if (!sPaymentContact.isEmpty()) {
				assertThat(pOSteps.get_payment_contact().equals(sPaymentContact)).isTrue();
			}
		}
	}

	@Then("^user previews Reports in Draft stage of Purchase Order Detail as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Draft_stage_of_Purchase_Order_Detail_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
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
			String sCurrentWindow = pOSteps.getCurrentWindowHandle();
			pOSteps.click_btn_preview_purchase_order_detail();
			boolean isDisplaySelectReport = pOSteps.is_display_reports_selection();
			;
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				pOSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (pOSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", pOSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					int iRet = pOSteps.count_text_sections_in_report();
					assertTrue("Checksum is not correct. Expected : " + iChecksum + " Actual: " + iRet,
							iRet == iChecksum);
				}
				pOSteps.getDriver().close();
				pOSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				pOSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user generates PO report in in Draft stage of Purchase Order Detail$")
	public void user_generates_PO_report_in_in_Draft_stage_of_Purchase_Order_Detail(List<List<String>> dataTable)
			throws Throwable {
		String sCurrentWindow = pOSteps.getCurrentWindowHandle();
		pOSteps.click_btn_preview_purchase_order_detail();
		if (pOSteps.switch_to_preview_report_window()) {
			assertTrue("Preview content is not correct.", pOSteps.verify_preview_report_content("Purchase Order"));
			pOSteps.getDriver().close();
			pOSteps.switchToWindowHandle(sCurrentWindow);
		} else {
			pOSteps.switchToWindowHandle(sCurrentWindow);
			fail("***** ERROR ***** Report window not display.");
		}
	}

	@Then("^user submits created Purchase Order in Draft stage of Purchase Order$")
	public void user_submits_created_Purchase_Order_in_Draft_stage_of_Purchase_Order() throws Throwable {
		pOSteps.click_btn_submit_purchase_order_detail();
	}

	@Then("^user opens created Purchase Order in Outstanding state of Purchase Order Summary$")
	public void user_opens_created_Purchase_Order_in_Outstanding_state_of_Purchase_Order_Summary() throws Throwable {
		pOSteps.switch_to_tab_outstanding();
		pOSteps.filter_summary_by_po_no(SessionData.getListStringLastValue(PO_NO));
		pOSteps.open_first_purchase_order_no();
	}

	@Then("^user opens created Purchase Order in Completed state of Purchase Order Summary$")
	public void user_opens_created_Purchase_Order_in_Completed_state_of_Purchase_Order_Summary() throws Throwable {
		pOSteps.switch_to_tab_completed();
		pOSteps.filter_summary_by_po_no(SessionData.getListStringLastValue(PO_NO));
		pOSteps.open_first_purchase_order_no();
	}

	@Then("^user creates new Purchase Order$")
	public void user_creates_new_Purchase_Order() {
		String fixedData = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\dataset\\scm\\test_flow\\CreatePurchaseOrder.xls";
		System.out.println(fixedData);
		creates_new_Purchase_Order(fixedData);
	}

	@Then("^user creates new Purchase Order as data in \"([^\"]*)\" file\\.$")
	public void user_create_new_Purchase_Order_as_data_in_file(String _dataFilePath) {
		creates_new_Purchase_Order(_dataFilePath);
	}

	public void creates_new_Purchase_Order(String _dataFilePath) {
		SessionData.addExcelData("Purchase Order", _dataFilePath);
		// Header column
		HashMap<String, Integer> hHeaderColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Header");
		// int colHeaderTestKey = hHeaderColNames.get("TestKey");
		int colHeaderSupplier = hHeaderColNames.get("Supplier");
		// int colHeaderPurchaseOrderNo = hHeaderColNames.get("Purchase Order
		// No.");
		int colHeaderSupplierContact = hHeaderColNames.get("Supplier Contact");
		int colHeaderPurchaseOrderDate = hHeaderColNames.get("Purchase Order Date");
		int colHeaderOrderCurrency = hHeaderColNames.get("Order Currency");
		int colHeaderExchangeRate = hHeaderColNames.get("Exchange Rate");
		int colHeaderSalesTax = hHeaderColNames.get("Sales Tax");
		int colHeaderPurchaser = hHeaderColNames.get("Purchaser");
		int colHeaderSbu = hHeaderColNames.get("SBU");
		int colHeaderProductionPurchase = hHeaderColNames.get("Production Purchase");
		int colHeaderPurchaseCategory = hHeaderColNames.get("Purchase Category");
		int colHeaderReferenceNo = hHeaderColNames.get("Reference No.");
		int colHeaderSubject = hHeaderColNames.get("Subject");
		int colHeaderSegment1 = hHeaderColNames.get("Segment 1");
		int colHeaderSegment2 = hHeaderColNames.get("Segment 2");
		int colHeaderSegment3 = hHeaderColNames.get("Segment 3");
		int colHeaderSegment4 = hHeaderColNames.get("Segment 4");
		int colShipmentTestKey = hHeaderColNames.get("Shipment TestKey");
		int colDetailTestKey = hHeaderColNames.get("Detail TestKey");
		int colPayInfoTesKey = hHeaderColNames.get("Payment Info TestKey");
		int colRemarksTestKey = hHeaderColNames.get("Remarks TestKey");
		int colAttachmentTestKey = hHeaderColNames.get("Attachments TestKey");
		// Store data variable
		// Header sheet
		String sHeaderSupplier = "";
		// String sHeaderPurchaseOrderNo = "";
		String sHeaderSupplierContact = "";
		String sHeaderPurchaseOrderDate = "";
		String sHeaderOrderCurrency = "";
		String sHeaderExchangeRate = "";
		String sHeaderSalesTax = "";
		String sHeaderPurchaser = "";
		String sHeaderSbu = "";
		String sHeaderProductionPurchase = "";
		String sHeaderPurchaseCategory = "";
		String sHeaderReferenceNo = "";
		String sHeaderSubject = "";
		String sHeaderSegment1 = "";
		String sHeaderSegment2 = "";
		String sHeaderSegment3 = "";
		String sHeaderSegment4 = "";
		String sShipmentTestKey = "";
		String sDetailTestKey = "";
		String sPayInfoTesKey = "";
		String sRemarksTestKey = "";
		String sAttachmentsTestKey = "";

		// Get Data row mark with test key
		// LinkedHashMap<Integer, List<String>> HeaderData =
		// SessionData.getDataRowsContainValByColName("Purchase Order",
		// "Header", "TestKey", "KEY");
		LinkedHashMap<Integer, List<String>> HeaderData = SessionData.getExcelDataRowsContainVal("Purchase Order",
				"Header", "TestKey", "E");
		pOSteps.switch_to_tab_draft();
		// Execute all test data
		for (Integer testKey : HeaderData.keySet()) {
			// Parse data
			sHeaderSupplier = HeaderData.get(testKey).get(colHeaderSupplier);
			// sHeaderPurchaseOrderNo =
			// HeaderData.get(testKey).get(colHeaderPurchaseOrderNo);
			sHeaderSupplierContact = HeaderData.get(testKey).get(colHeaderSupplierContact);
			sHeaderPurchaseOrderDate = HeaderData.get(testKey).get(colHeaderPurchaseOrderDate);
			sHeaderOrderCurrency = HeaderData.get(testKey).get(colHeaderOrderCurrency);
			sHeaderExchangeRate = HeaderData.get(testKey).get(colHeaderExchangeRate);
			sHeaderSalesTax = HeaderData.get(testKey).get(colHeaderSalesTax);
			sHeaderPurchaser = HeaderData.get(testKey).get(colHeaderPurchaser);
			sHeaderSbu = HeaderData.get(testKey).get(colHeaderSbu);
			sHeaderProductionPurchase = HeaderData.get(testKey).get(colHeaderProductionPurchase);
			sHeaderPurchaseCategory = HeaderData.get(testKey).get(colHeaderPurchaseCategory);
			sHeaderReferenceNo = HeaderData.get(testKey).get(colHeaderReferenceNo);
			sHeaderSubject = HeaderData.get(testKey).get(colHeaderSubject);
			sHeaderSegment1 = HeaderData.get(testKey).get(colHeaderSegment1);
			sHeaderSegment2 = HeaderData.get(testKey).get(colHeaderSegment2);
			sHeaderSegment3 = HeaderData.get(testKey).get(colHeaderSegment3);
			sHeaderSegment4 = HeaderData.get(testKey).get(colHeaderSegment4);
			sShipmentTestKey = HeaderData.get(testKey).get(colShipmentTestKey);
			sDetailTestKey = HeaderData.get(testKey).get(colDetailTestKey);
			sPayInfoTesKey = HeaderData.get(testKey).get(colPayInfoTesKey);
			sRemarksTestKey = HeaderData.get(testKey).get(colRemarksTestKey);
			sAttachmentsTestKey = HeaderData.get(testKey).get(colAttachmentTestKey);
			// Do test
			if (!sHeaderSupplier.isEmpty()) {
				pOSteps.click_btn_new_of_po_summany();
				pOSteps.enter_supplier(sHeaderSupplier);
			} else {
				continue;
			}

			System.out.println("PO: " + pOSteps.get_new_purchase_order_no());
			// Do something here ?

			if (!sHeaderSupplierContact.isEmpty()) {
				pOSteps.enter_supplier_contact(sHeaderSupplierContact);
			}
			if (!sHeaderPurchaseOrderDate.isEmpty()) {
				pOSteps.enter_purchase_order_date(sHeaderPurchaseOrderDate);
			}
			if (!sHeaderOrderCurrency.isEmpty()) {
				pOSteps.enter_order_currency(sHeaderOrderCurrency);
			}
			if (!sHeaderSalesTax.isEmpty()) {
				pOSteps.enter_sales_tax(sHeaderSalesTax);
			}
			if (!sHeaderPurchaser.isEmpty()) {
				pOSteps.enter_purchaser(sHeaderPurchaser);
			}
			if (!sHeaderSbu.isEmpty()) {
				pOSteps.enter_sbu(sHeaderSbu);
			}
			if (!sHeaderProductionPurchase.isEmpty()) {
				pOSteps.select_option_production_purchase(sHeaderProductionPurchase);
			}
			if (!sHeaderPurchaseCategory.isEmpty()) {
				pOSteps.enter_purchase_category(sHeaderPurchaseCategory);
			}
			if (!sHeaderReferenceNo.isEmpty()) {
				pOSteps.enter_reference_no(sHeaderReferenceNo);
			}
			if (!sHeaderSubject.isEmpty()) {
				pOSteps.enter_subject(sHeaderSubject);
			}
			if (!sHeaderSegment1.isEmpty()) {
				pOSteps.enter_segment_1(sHeaderSegment1);
			}
			if (!sHeaderSegment2.isEmpty()) {
				pOSteps.enter_segment_2(sHeaderSegment2);
			}
			if (!sHeaderSegment3.isEmpty()) {
				pOSteps.enter_segment_3(sHeaderSegment3);
			}
			if (!sHeaderSegment4.isEmpty()) {
				pOSteps.enter_segment_4(sHeaderSegment4);
			}
			if (!sShipmentTestKey.isEmpty()) {
				enter_new_shipment(sShipmentTestKey);
			}
			if (!sDetailTestKey.isEmpty()) {
				pOSteps.switch_to_tab_detail();
				if (!sHeaderExchangeRate.isEmpty()) {
					pOSteps.enter_det_exchange_rate(sHeaderExchangeRate);
				}
				enter_new_details(sDetailTestKey);
			}
			if (!sPayInfoTesKey.isEmpty()) {
				enter_payment_info(sPayInfoTesKey);
			}
			if (!sRemarksTestKey.isEmpty()) {
				enter_remarks(sRemarksTestKey);
			}
			if (!sAttachmentsTestKey.isEmpty()) {
				add_attachments(sAttachmentsTestKey);
			}
			pOSteps.click_btn_submit_purchase_order_detail();
		}

	}

	// Input shipment tab
	public void enter_new_shipment(String sShipmentTestKey) {
		// Shipment Column
		HashMap<String, Integer> hShiColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Shipment");
		int colShiPurchaseOrderNo = hShiColNames.get("Purchase Order No.");
		int colShiShipmentMode = hShiColNames.get("Shipment Mode");
		int colShiShipmentTerm = hShiColNames.get("Shipment Term");
		int colShiDefaultShipToLocation = hShiColNames.get("Default ship to Location");
		int colShiPortOfLoading = hShiColNames.get("Port of Loading");
		int colShiPortOfDischarge = hShiColNames.get("Port of Discharge");
		int colShiPortOfFinalDestination = hShiColNames.get("Port of Final Destination");
		int colShiShipThrough = hShiColNames.get("Ship Through");
		int colShiShipToParty = hShiColNames.get("Ship to Party");
		int colShiShipToPartyAddress = hShiColNames.get("Ship to Party Address");
		int colShiShipToPartyContact = hShiColNames.get("Ship to Party Contact");
		int colShiCountryOfLoading = hShiColNames.get("Country of Loading");
		int colShiCountryOfDischarge = hShiColNames.get("Country of Discharge");
		int colShiCountryOfFinalDestination = hShiColNames.get("Country of Final Destination");
		int colShiProjectShipToAddress = hShiColNames.get("Project Ship To Address");
		int colShiNoOfShipment = hShiColNames.get("No. of Shipment");

		// Shipment
		String sShiPurchaseOrderNo = "";
		String sShiShipmentMode = "";
		String sShiShipmentTerm = "";
		String sShiDefaultShipToLocation = "";
		String sShiPortOfLoading = "";
		String sShiPortOfDischarge = "";
		String sShiPortOfFinalDestination = "";
		String sShiShipThrough = "";
		String sShiShipToParty = "";
		String sShiShipToPartyAddress = "";
		String sShiShipToPartyContact = "";
		String sShiNoOfShipment = "";
		String sShiCountryOfLoading = "";
		String sShiCountryOfDischarge = "";
		String sShiCountryOfFinalDestination = "";
		String sShiProjectShipToAddress = "";

		LinkedHashMap<Integer, List<String>> ShiData = SessionData.getExcelDataRowsEqualVal("Purchase Order",
				"Shipment", "TestKey", sShipmentTestKey);
		if (ShiData.size() == 0) {
			// fail.datanotfound
		}
		pOSteps.switch_to_tab_shipment();
		for (Integer shiKey : ShiData.keySet()) {
			// Parse data
			sShiPurchaseOrderNo = ShiData.get(shiKey).get(colShiPurchaseOrderNo);
			sShiShipmentMode = ShiData.get(shiKey).get(colShiShipmentMode);
			sShiShipmentTerm = ShiData.get(shiKey).get(colShiShipmentTerm);
			sShiDefaultShipToLocation = ShiData.get(shiKey).get(colShiDefaultShipToLocation);
			sShiPortOfLoading = ShiData.get(shiKey).get(colShiPortOfLoading);
			sShiPortOfDischarge = ShiData.get(shiKey).get(colShiPortOfDischarge);
			sShiPortOfFinalDestination = ShiData.get(shiKey).get(colShiPortOfFinalDestination);
			sShiShipThrough = ShiData.get(shiKey).get(colShiShipThrough);
			sShiShipToParty = ShiData.get(shiKey).get(colShiShipToParty);
			sShiShipToPartyAddress = ShiData.get(shiKey).get(colShiShipToPartyAddress);
			sShiShipToPartyContact = ShiData.get(shiKey).get(colShiShipToPartyContact);
			sShiProjectShipToAddress = ShiData.get(shiKey).get(colShiProjectShipToAddress);
			sShiNoOfShipment = ShiData.get(shiKey).get(colShiNoOfShipment);
			sShiCountryOfLoading = ShiData.get(shiKey).get(colShiCountryOfLoading);
			sShiCountryOfDischarge = ShiData.get(shiKey).get(colShiCountryOfDischarge);
			sShiCountryOfFinalDestination = ShiData.get(shiKey).get(colShiCountryOfFinalDestination);
			// Do test
			if (!sShiPurchaseOrderNo.isEmpty()) {
				// Do something
			}
			if (!sShiShipmentMode.isEmpty()) {
				pOSteps.enter_shipment_mode(sShiShipmentMode);
			}
			if (!sShiShipmentTerm.isEmpty()) {
				pOSteps.enter_shipment_term(sShiShipmentTerm);
			}
			if (!sShiDefaultShipToLocation.isEmpty()) {
				pOSteps.enter_ship_to_location(sShiDefaultShipToLocation);
			}
			if (!sShiPortOfLoading.isEmpty()) {
				pOSteps.enter_port_of_loading(sShiPortOfLoading);
			}
			if (!sShiPortOfDischarge.isEmpty()) {
				pOSteps.enter_port_of_discharge(sShiPortOfDischarge);
			}
			if (!sShiPortOfFinalDestination.isEmpty()) {
				pOSteps.enter_port_of_final_destination(sShiPortOfFinalDestination);
			}
			if (!sShiShipThrough.isEmpty()) {
				pOSteps.enter_ship_through(sShiShipThrough);
			}
			if (!sShiShipToParty.isEmpty()) {
				pOSteps.enter_ship_to_party(sShiShipToParty);
			}
			if (!sShiShipToPartyAddress.isEmpty()) {
				pOSteps.enter_ship_to_party_address(sShiShipToPartyAddress);
			}
			if (!sShiShipToPartyContact.isEmpty()) {
				pOSteps.enter_ship_to_party_contact(sShiShipToPartyContact);
			}
			if (!sShiCountryOfLoading.isEmpty()) {
				pOSteps.enter_country_of_loading(sShiCountryOfLoading);
			}
			if (!sShiCountryOfDischarge.isEmpty()) {
				pOSteps.enter_country_of_discharge(sShiCountryOfDischarge);
			}
			if (!sShiCountryOfFinalDestination.isEmpty()) {
				pOSteps.enter_country_of_final_destination(sShiCountryOfFinalDestination);
			}
			if (!sShiProjectShipToAddress.isEmpty()) {
				pOSteps.enter_project_ship_to_address(sShiProjectShipToAddress);
			}
			if (!sShiNoOfShipment.isEmpty()) {
				pOSteps.enter_no_of_shipment(sShiNoOfShipment);
			}
		}
	}

	public void enter_payment_info(String sPayInfoTesKey) {
		// Payment Info Column
		HashMap<String, Integer> hPayColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Payment Info");
		int colPayPaymentOption = hPayColNames.get("Payment Option");
		int colPayPaymentTerm = hPayColNames.get("Payment Term");
		int colPayPaymentTermTenor = hPayColNames.get("Payment Term Tenor");
		int colPayPaymentTermTenorCode = hPayColNames.get("Payment Term Tenor Code");
		int colPayPaymentMethod = hPayColNames.get("Payment Method");
		int colPayPaymentParty = hPayColNames.get("Payment Party");
		int colPayPaymentAddress = hPayColNames.get("Payment Address");
		int colPayPaymentContact = hPayColNames.get("Payment Contact");
		int colPayPaymentAmount = hPayColNames.get("Payment Amount");

		// Shipment
		String sPayPaymentOption = "";
		String sPayPaymentTerm = "";
		String sPayPaymentTermTenor = "";
		String sPayPaymentTermTenorCode = "";
		String sPayPaymentMethod = "";
		String sPayPaymentParty = "";
		String sPayPaymentAddress = "";
		String sPayPaymentContact = "";
		String sPayPaymentAmount = "";

		LinkedHashMap<Integer, List<String>> PayData = SessionData.getExcelDataRowsEqualVal("Purchase Order",
				"Payment Info", "TestKey", sPayInfoTesKey);
		if (PayData.size() == 0) {
			// fail.datanotfound
		}

		pOSteps.switch_to_tab_payment_info();
		for (Integer payKey : PayData.keySet()) {
			// Parse data
			sPayPaymentOption = PayData.get(payKey).get(colPayPaymentOption);
			sPayPaymentTerm = PayData.get(payKey).get(colPayPaymentTerm);
			sPayPaymentTermTenor = PayData.get(payKey).get(colPayPaymentTermTenor);
			sPayPaymentTermTenorCode = PayData.get(payKey).get(colPayPaymentTermTenorCode);
			sPayPaymentMethod = PayData.get(payKey).get(colPayPaymentMethod);
			sPayPaymentParty = PayData.get(payKey).get(colPayPaymentParty);
			sPayPaymentAddress = PayData.get(payKey).get(colPayPaymentAddress);
			sPayPaymentContact = PayData.get(payKey).get(colPayPaymentContact);
			sPayPaymentAmount = PayData.get(payKey).get(colPayPaymentAmount);

			// Do test
			if (!sPayPaymentOption.isEmpty()) {
				pOSteps.select_payment_option(sPayPaymentOption);
			}
			if (!sPayPaymentTerm.isEmpty()) {
				pOSteps.select_payment_term(sPayPaymentTerm);
			}
			if (!sPayPaymentTermTenor.isEmpty()) {
				pOSteps.enter_payment_term_tenor(sPayPaymentTermTenor);
			}
			if (!sPayPaymentTermTenorCode.isEmpty()) {
				pOSteps.enter_payment_term_tenor_code(sPayPaymentTermTenorCode);
			}
			if (!sPayPaymentMethod.isEmpty()) {
				pOSteps.select_payment_method(sPayPaymentMethod);
			}
			if (!sPayPaymentParty.isEmpty()) {
				pOSteps.enter_payment_party(sPayPaymentParty);
			}
			if (!sPayPaymentAddress.isEmpty()) {
				pOSteps.enter_payment_address(sPayPaymentAddress);
			}
			if (!sPayPaymentContact.isEmpty()) {
				pOSteps.enter_payment_contact(sPayPaymentContact);
			}
			if (!sPayPaymentAmount.isEmpty()) {
				pOSteps.enter_payment_amount(sPayPaymentAmount);
			}

		}
	}

	public void enter_remarks(String sRemarksTestKey) {
		// Remarks Column
		HashMap<String, Integer> hRmaColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Remarks");
		int colInternalRemarksCode = hRmaColNames.get("Internal Remarks Code");
		int colExternalRemarksCode = hRmaColNames.get("External Remarks Code");
		int colInternalRemarks = hRmaColNames.get("Internal Remarks");
		int colExternalRemarks = hRmaColNames.get("External Remarks");
		// Remarks
		String sInternalRemarksCode = "";
		String sExternalRemarksCode = "";
		String sInternalRemarks = "";
		String sExternalRemarks = "";

		LinkedHashMap<Integer, List<String>> RemarksData = SessionData.getExcelDataRowsEqualVal("Purchase Order",
				"Remarks", "TestKey", sRemarksTestKey);
		if (RemarksData.size() == 0) {
			// fail.datanotfound
		}
		pOSteps.switch_to_tab_remarks();
		for (Integer rmaKey : RemarksData.keySet()) {
			// Parse data
			sInternalRemarksCode = RemarksData.get(rmaKey).get(colInternalRemarksCode);
			sExternalRemarksCode = RemarksData.get(rmaKey).get(colExternalRemarksCode);
			sInternalRemarks = RemarksData.get(rmaKey).get(colInternalRemarks);
			sExternalRemarks = RemarksData.get(rmaKey).get(colExternalRemarks);
			// Do test
			if (!sInternalRemarksCode.isEmpty()) {
				pOSteps.enter_internal_remarks_code(sInternalRemarksCode);
			}
			if (!sExternalRemarksCode.isEmpty()) {
				pOSteps.enter_external_remarks_code(sExternalRemarksCode);
			}
			if (!sInternalRemarks.isEmpty()) {
				pOSteps.enter_internal_remarks(sInternalRemarks);
			}
			if (!sExternalRemarks.isEmpty()) {
				pOSteps.enter_external_remarks(sExternalRemarks);
			}
		}
	}

	public void add_attachments(String colAttachmentTestKey) {
		// Remarks Column
		HashMap<String, Integer> hAttColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Attachments");
		int colAttNo = hAttColNames.get("No.");
		int colAttFileName = hAttColNames.get("File Name");
		int colAttFileDescription = hAttColNames.get("File Description");
		int colAttMimeType = hAttColNames.get("MIME Type");
		int colAttFileSize = hAttColNames.get("File Size");

		// Remarks
		String sAttNo = "";
		String sAttFileName = "";
		String sAttFileDescription = "";
		String sAttMimeType = "";
		String sAttFileSize = "";

		LinkedHashMap<Integer, List<String>> AttData = SessionData.getExcelDataRowsEqualVal("Purchase Order",
				"Attachments", "TestKey", colAttachmentTestKey);
		if (AttData.size() == 0) {
			// fail.datanotfound
		}
		pOSteps.switch_to_tab_attachments();
		for (Integer attKey : AttData.keySet()) {
			// Parse data
			sAttNo = AttData.get(attKey).get(colAttNo);
			sAttFileName = AttData.get(attKey).get(colAttFileName);
			sAttFileDescription = AttData.get(attKey).get(colAttFileDescription);
			sAttMimeType = AttData.get(attKey).get(colAttMimeType);
			sAttFileSize = AttData.get(attKey).get(colAttFileSize);
			int currentRow = 0;
			// Do test
			if (!sAttNo.isEmpty()) {
			} else {
				continue;
			}
			if (!sAttFileName.isEmpty()) {
				pOSteps.click_btn_add_attachment();
				pOSteps.choose_attachment_file(sAttFileName);
				pOSteps.click_btn_upload_attachment();
			}
			currentRow = pOSteps.get_att_row_by_no(sAttNo);
			if (!sAttFileDescription.isEmpty()) {
				pOSteps.enter_file_description(currentRow, sAttFileDescription);
			}
			if (!sAttMimeType.isEmpty()) {
				// Assert here?
				System.out.println(pOSteps.get_new_file_mime_type(currentRow));
			}
			if (!sAttFileSize.isEmpty()) {
				System.out.println(pOSteps.get_new_file_file_size(currentRow));
				// Assert here?
			}
		}
	}

	public void enter_new_details(String sDetailTestKey) {
		// Detail Column Index
		HashMap<String, Integer> hDetColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Detail");
		int colDetTestkey = hDetColNames.get("TestKey");
		int colDetPurchaseOrderNo = hDetColNames.get("Purchase Order No.");
		int colDetEstimatedShipmentDate = hDetColNames.get("Estimated Shipment Date");
		int colDetEstimatedArrivalDate = hDetColNames.get("Estimated Arrival Date");
		int colDetLineItemNo = hDetColNames.get("Line Item No.");
		int colDetType = hDetColNames.get("Type");
		int colDetItemCode = hDetColNames.get("Item Code");
		int colDetItemRemarks = hDetColNames.get("Item Remarks");
		int colDetQty = hDetColNames.get("Qty");
		int colDetNoOfPack = hDetColNames.get("No of pack");
		int colDetPackSize = hDetColNames.get("Pack Size");
		int colDetSalesTax = hDetColNames.get("Sales Tax");
		int colDetCostType = hDetColNames.get("Cost Type");
		int colDetUnitCost = hDetColNames.get("Unit Cost");
		int colDetDiscountPercent = hDetColNames.get("Discount Percent");
		int colDetDiscountAmount = hDetColNames.get("Discount Amount");
		int colDetAllocationTestkey = hDetColNames.get("Allocation TestKey");
		int colDetSgmts = hDetColNames.get("Sgmts");
		int colDetTotal = hDetColNames.get("Total");
		int colDetDirectIssueToProject = hDetColNames.get("Direct Issue to Project");
		// Detail
		String sDetTestkey = "";
		String sDetPurchaseOrderNo = "";
		String sDetEstimatedShipmentDate = "";
		String sDetEstimatedArrivalDate = "";
		String sDetLineItemNo = "";
		String sDetType = "";
		String sDetItemCode = "";
		String sDetItemRemarks = "";
		String sDetQty = "";
		String sDetNoOfPack = "";
		String sDetPackSize = "";
		String sDetSalesTax = "";
		String sDetCostType = "";
		String sDetUnitCost = "";
		String sDetDiscountPercent = "";
		String sDetDiscountAmount = "";
		String sDetAllocationTestkey = "";
		String sDetSgmts = "";
		String sDetTotal = "";
		String sDetDirectIssueToProject = "";

		LinkedHashMap<Integer, List<String>> DetData = SessionData.getExcelDataRowsEqualVal("Purchase Order",
				"Detail", "TestKey", sDetailTestKey);
		if (DetData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer detKey : DetData.keySet()) {
			// Parse data
			sDetTestkey = DetData.get(detKey).get(colDetTestkey);
			sDetPurchaseOrderNo = DetData.get(detKey).get(colDetPurchaseOrderNo);
			sDetEstimatedShipmentDate = DetData.get(detKey).get(colDetEstimatedShipmentDate);
			sDetEstimatedArrivalDate = DetData.get(detKey).get(colDetEstimatedArrivalDate);
			sDetLineItemNo = DetData.get(detKey).get(colDetLineItemNo);
			sDetType = DetData.get(detKey).get(colDetType);
			sDetItemCode = DetData.get(detKey).get(colDetItemCode);
			sDetItemRemarks = DetData.get(detKey).get(colDetItemRemarks);
			sDetQty = DetData.get(detKey).get(colDetQty);
			sDetNoOfPack = DetData.get(detKey).get(colDetNoOfPack);
			sDetPackSize = DetData.get(detKey).get(colDetPackSize);
			sDetSalesTax = DetData.get(detKey).get(colDetSalesTax);
			sDetCostType = DetData.get(detKey).get(colDetCostType);
			sDetUnitCost = DetData.get(detKey).get(colDetUnitCost);
			sDetDiscountPercent = DetData.get(detKey).get(colDetDiscountPercent);
			sDetDiscountAmount = DetData.get(detKey).get(colDetDiscountAmount);
			sDetAllocationTestkey = DetData.get(detKey).get(colDetAllocationTestkey);
			sDetSgmts = DetData.get(detKey).get(colDetSgmts);
			sDetTotal = DetData.get(detKey).get(colDetTotal);
			sDetDirectIssueToProject = DetData.get(detKey).get(colDetDirectIssueToProject);
			int currentRow = 0; //
			pOSteps.click_btn_add_detail();
			currentRow++;
			// Do test
			if (!sDetTestkey.isEmpty()) {
			}
			if (!sDetPurchaseOrderNo.isEmpty()) {
			}
			if (!sDetEstimatedShipmentDate.isEmpty()) {
				pOSteps.enter_det_estimated_shipment_date(sDetEstimatedShipmentDate);
			}
			if (!sDetEstimatedArrivalDate.isEmpty()) {
				pOSteps.enter_det_estimated_arrival_date(sDetEstimatedArrivalDate);
			}
			if (!sDetLineItemNo.isEmpty()) {
				currentRow = pOSteps.get_det_row_by_line_item_no(sDetLineItemNo);
			}
			if (!sDetType.isEmpty()) {
				pOSteps.select_det_type(currentRow, sDetType);
			}
			if (!sDetItemCode.isEmpty()) {
				pOSteps.enter_det_item_code(currentRow, sDetItemCode);
			}
			if (!sDetItemRemarks.isEmpty()) {
				pOSteps.enter_det_item_remarks(currentRow, sDetItemRemarks);
			}
			if (!sDetQty.isEmpty()) {
				pOSteps.enter_det_qty(currentRow, sDetQty);
			}
			if (!sDetNoOfPack.isEmpty()) {
				pOSteps.enter_det_no_of_pack(currentRow, sDetNoOfPack);
			}
			if (!sDetPackSize.isEmpty()) {
				pOSteps.select_det_pack_size(currentRow, sDetPackSize);
			}
			if (!sDetSalesTax.isEmpty()) {
				pOSteps.enter_det_sales_tax(currentRow, sDetSalesTax);
			}
			if (!sDetCostType.isEmpty()) {
				pOSteps.select_det_cost_type(currentRow, sDetCostType);
			}
			if (!sDetUnitCost.isEmpty()) {
				pOSteps.enter_det_unit_cost(currentRow, sDetUnitCost);
			}
			if (!sDetDiscountPercent.isEmpty()) {
				pOSteps.enter_det_discount_percent(currentRow, sDetDiscountPercent);
			}
			if (!sDetDiscountAmount.isEmpty()) {
				pOSteps.enter_det_discount_amount(currentRow, sDetDiscountAmount);
			}
			if (!sDetDirectIssueToProject.isEmpty()) {
				pOSteps.set_det_direct_issue_to_project(currentRow, sDetDirectIssueToProject);
			}
			if (!sDetAllocationTestkey.isEmpty()) {
				boolean isAllocPopup = !pOSteps.is_enable_viewing_source_voucher_detail_for_allocation();
				pOSteps.open_panel_allocation_details(isAllocPopup, currentRow);
				enter_allocation(sDetLineItemNo, sDetAllocationTestkey);
				if (isAllocPopup) {
					pOSteps.click_btn_done_alloc();
				}
			}
			if (!sDetSgmts.isEmpty()) {
			}
			if (!sDetTotal.isEmpty()) {
				System.out.println(pOSteps.get_det_total(currentRow, sDetTotal));
			}
		}
	}

	public void enter_allocation(String sDetLineItemNo, String sDetAllocationTestkey) {
		// Allocation Column Index
		HashMap<String, Integer> hAllColNames = SessionData.getExcelColNameBySheetName("Purchase Order", "Allocation");
		// int colAllocTestkey = hAllColNames.get("TestKey");
		// int colAllocPurchaseOrderNo = hAllColNames.get("Purchase Order No.");
		int colAllocLineItemNo = hAllColNames.get("Line Item No.");
		int colAllocAllocationNo = hAllColNames.get("Allocation No.");
		int colAllocAllocType = hAllColNames.get("Alloc Type");
		int colAllocVoucherNo = hAllColNames.get("Voucher No.");
		int colAllocPhaseSequenceNo = hAllColNames.get("Phase Sequence No.");
		int colAllocLineNo = hAllColNames.get("Line No.");
		int colAllocAllocQty = hAllColNames.get("Alloc Qty");

		// Allocation
		// String sAllocTestkey = "";
		// String sAllocPurchaseOrderNo = "";
		String sAllocLineItemNo = "";
		String sAllocAllocationNo = "";
		String sAllocAllocType = "";
		String sAllocVoucerNo = "";
		String sAllocPhaseSequenceNo = "";
		String sAllocLineNo = "";
		String sAllocAllocQty = "";

		LinkedHashMap<Integer, List<String>> AllData = SessionData.getExcelDataRowsEqualVal("Purchase Order",
				"Allocation", "TestKey", sDetAllocationTestkey);
		if (AllData.size() == 0) {
			// fail.datanotfound
		}
		for (Integer allKey : AllData.keySet()) {
			// Parse data
			// sAllocTestkey = AllData.get(allKey).get(colAllocTestkey);
			// sAllocPurchaseOrderNo =
			// AllData.get(allKey).get(colAllocPurchaseOrderNo);
			sAllocLineItemNo = AllData.get(allKey).get(colAllocLineItemNo);
			sAllocAllocationNo = AllData.get(allKey).get(colAllocAllocationNo);
			sAllocAllocType = AllData.get(allKey).get(colAllocAllocType);
			sAllocVoucerNo = AllData.get(allKey).get(colAllocVoucherNo);
			sAllocPhaseSequenceNo = AllData.get(allKey).get(colAllocPhaseSequenceNo);
			sAllocLineNo = AllData.get(allKey).get(colAllocLineNo);
			sAllocAllocQty = AllData.get(allKey).get(colAllocAllocQty);
			// Do test
			pOSteps.update_data_alloc_purchase_order_no("TODO");
			int currentAllocRow = 0;
			if (!sAllocLineItemNo.isEmpty()) {
				if (!sAllocLineItemNo.equals(sDetLineItemNo)) {
					continue;
				}
			} else {
				continue;
			}
			// If Voucher No not set, not allocate(it auto create)
			if (sAllocVoucerNo.isEmpty()) {
				continue;
			}
			if (!sAllocAllocationNo.isEmpty()) {
				if (!sAllocAllocationNo.equals("1.0")) {
					pOSteps.click_btn_add_alloc();
				}
				currentAllocRow = pOSteps.get_alloc_row_by_allocation_no(sAllocAllocationNo);
			}
			if (!sAllocAllocType.isEmpty()) {
				pOSteps.select_alloc_alloc_type(currentAllocRow, sAllocAllocType);
			}
			if (!sAllocVoucerNo.isEmpty()) {
				pOSteps.enter_alloc_voucher_no(currentAllocRow, sAllocVoucerNo);
			}
			if (!sAllocPhaseSequenceNo.isEmpty()) {
				pOSteps.enter_alloc_phase_sequence_no(currentAllocRow, sAllocPhaseSequenceNo);
			}
			if (!sAllocLineNo.isEmpty()) {
				pOSteps.enter_alloc_line_no(currentAllocRow, sAllocLineNo);
			}
			if (!sAllocAllocQty.isEmpty()) {
				pOSteps.enter_alloc_alloc_qty(currentAllocRow, sAllocAllocQty);
			}
		}
	}
}
