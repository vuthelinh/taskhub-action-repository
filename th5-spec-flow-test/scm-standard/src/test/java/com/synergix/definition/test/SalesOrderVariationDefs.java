package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.synergix.processing.sales.steps.SalesOrderVariationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SalesOrderVariationDefs {
	// private final static String SQ_NO = "Sales Quotation No";
	private final static String SO_NO = "Sales Order No";
	private final static String PO_NO = "Purchase Order No";
	private final static String PR_NO = "Purchase Requisition No";
	private final static String SV_NO = "Shipment Voucher No";
	@Steps
	SalesOrderVariationSteps SOVariationSteps;

	@Then("^user inputs data in Draft stage in Header tab of Sales Order Variation as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Header_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SOV_DRAFT_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SOV_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			String sAllocatePoToSo = SessionData.getDataTbVal("SOV_DRAFT_HEADER_TAB", row, "Allocate PO to SO");
			if (!sAllocatePoToSo.isEmpty()) {
				SOVariationSteps.select_allocate_po_to_so(sAllocatePoToSo);
			}
		}
	}

	@Then("^all default fields in Draft stage in Header tab of Sales Order Variation will be pulled out as \"([^\"]*)\"$")
	public void all_default_fields_in_Draft_stage_in_Header_tab_of_Sales_Order_will_be_pulled_out_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SOV_DRAFT_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SOV_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			String sCustomerAddress = SessionData.getDataTbVal("SOV_DRAFT_HEADER_TAB", row, "Customer Address");
			String sCustomerContact = SessionData.getDataTbVal("SOV_DRAFT_HEADER_TAB", row, "Customer Contact");
			String sOrderCurrency = SessionData.getDataTbVal("SOV_DRAFT_HEADER_TAB", row, "Order Currency");
			String sSalesTax = SessionData.getDataTbVal("SOV_DRAFT_HEADER_TAB", row, "Sales Tax");
			if (!sCustomerAddress.isEmpty()) {
				assertThat(SOVariationSteps.get_customer_address_code().equals(sCustomerAddress)).isTrue();
			}
			if (!sCustomerContact.isEmpty()) {
				assertThat(SOVariationSteps.get_customer_contact_code().equals(sCustomerContact)).isTrue();
			}
			if (!sOrderCurrency.isEmpty()) {
				assertThat(SOVariationSteps.get_order_currency().equals(sOrderCurrency)).isTrue();
			}
			if (!sSalesTax.isEmpty()) {
				assertThat(SOVariationSteps.get_sales_tax().equals(sSalesTax)).isTrue();
			}
		}

	}

	@Then("^user inputs data in Shipment tab of Sales Order Variation as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Shipment_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SOV_DRAFT_SHIPMENT_TAB", dataTable, false);
		SOVariationSteps.switch_to_tab_shipment();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SOV_DRAFT_SHIPMENT_TAB", "KEY", dataKey).keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("SOV_DRAFT_SHIPMENT_TAB", row, "Shipment Mode");
			String sShipmentTerm = SessionData.getDataTbVal("SOV_DRAFT_SHIPMENT_TAB", row, "Shipment Term");
			String sLoadingLocation = SessionData.getDataTbVal("SOV_DRAFT_SHIPMENT_TAB", row, "Loading Location");
			String sNoOfShipment = SessionData.getDataTbVal("SOV_DRAFT_SHIPMENT_TAB", row, "No. of Shipment");
			if (!sShipmentMode.isEmpty()) {
				SOVariationSteps.enter_shipment_mode(sShipmentMode);
			}
			if (!sShipmentTerm.isEmpty()) {
				SOVariationSteps.enter_shipment_term(sShipmentTerm);
			}
			if (!sLoadingLocation.isEmpty()) {
				SOVariationSteps.enter_loading_location(sLoadingLocation);
			}
			if (!sNoOfShipment.isEmpty()) {
				SOVariationSteps.enter_no_of_shipment(sNoOfShipment);
			}
		}
	}

	@Then("^user inputs data in Details tab of Sales Order Variation as \"([^\"]*)\"$")
	public void user_inputs_data_in_Details_tab_of_Sales_Order_Variation_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SOVariationSteps.switch_to_tab_detail();
		SessionData.addDataTable("SOV_DRAFT_DETAILS_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SOV_DRAFT_DETAILS_TAB", "KEY", dataKey).keySet()) {
			String sLiNo = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Item Type");
			String sLoadingLocation = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Loading Location");
			String sItemCode = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Item Code");
			String sPackSize = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Pack Size");
			String sNoOfPack = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "No. Of Pack");
			String sQty = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Qty");
			String sUnit = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Unit");
			String sPR = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "PR");
			String sPO = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "PO");
			String sSupplier = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Supplier");
			String sCcy = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Ccy");
			String sDraftOstPONo = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Draft/Ost PO No");
			String sQOHAllocation = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "QOH Allocation");
			String sDraftOstLineItemNo = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row,
					"Draft/Ost Line Item No");
			String sPOQtyAllocation = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "PO Qty Allocation");
			String sUnitCost = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Unit Cost");

			SOVariationSteps.click_btn_add_detail();
			int iRowIndex = 0;
			if (!sLiNo.isEmpty()) {
				iRowIndex = SOVariationSteps.get_det_row_by_line_item_no(sLiNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				SOVariationSteps.select_det_item_type(iRowIndex, sItemType);
			}
			if (!sLoadingLocation.isEmpty()) {
				SOVariationSteps.enter_det_loading_location(iRowIndex, sLoadingLocation);
			}
			if (!sItemCode.isEmpty()) {
				SOVariationSteps.enter_det_item_code(iRowIndex, sItemCode);
			}

			if (!sPackSize.isEmpty()) {
				SOVariationSteps.select_det_pack_size(iRowIndex, sPackSize);
			}
			if (!sNoOfPack.isEmpty()) {
				SOVariationSteps.enter_det_no_of_pack(iRowIndex, sNoOfPack);
			}
			if (!sQty.isEmpty()) {
				if (!sNoOfPack.isEmpty()) {
					assertThat(SessionData.isSameDecimalValue(SOVariationSteps.get_det_qty(iRowIndex), sQty)).isTrue();
				} else {
					SOVariationSteps.enter_det_qty(iRowIndex, sQty);
				}
			}

			if (!sUnit.isEmpty()) {
				SOVariationSteps.enter_det_unit(iRowIndex, sUnit);
			}
			if (!sPR.isEmpty()) {
				SOVariationSteps.select_det_pr(iRowIndex, sPR);
			}
			if (!sPO.isEmpty()) {
				SOVariationSteps.select_det_po(iRowIndex, sPO);
			}
			if (!sDraftOstPONo.isEmpty()) {
				if (sDraftOstPONo.equals("@Purchase Order No@")) {
					sDraftOstPONo = SessionData.getListStringLastValue(PO_NO).toString();
				}
				SOVariationSteps.enter_det_draft_ost_po_no(iRowIndex, sDraftOstPONo);
			}
			if (!sDraftOstLineItemNo.isEmpty()) {
				assertThat(SOVariationSteps.get_det_draft_ost_line_item_no(iRowIndex).equals(sDraftOstLineItemNo))
						.isTrue();
			}
			if (!sSupplier.isEmpty()) {
				SOVariationSteps.enter_det_supplier(iRowIndex, sSupplier);
			}
			if (!sCcy.isEmpty()) {
				SOVariationSteps.enter_det_ccy(iRowIndex, sCcy);
			}

			if (!sPOQtyAllocation.isEmpty()) {
				SOVariationSteps.enter_det_po_qty_allocation(iRowIndex, sPOQtyAllocation);
			}
			if (!sQOHAllocation.isEmpty()) {
				SOVariationSteps.enter_det_qoh_allocation(iRowIndex, sQOHAllocation);
			}
			if (!sUnitCost.isEmpty()) {
				SOVariationSteps.enter_det_unit_cost(iRowIndex, sUnitCost);
			}
		}
	}

	@Then("^user updates data in Details tab of Sales Order Variation as \"([^\"]*)\"$")
	public void user_updates_data_in_Details_tab_of_Sales_Order_Variation_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SOVariationSteps.switch_to_tab_detail();
		SessionData.addDataTable("SOV_DRAFT_DETAILS_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SOV_DRAFT_DETAILS_TAB", "KEY", dataKey).keySet()) {
			String sLiNo = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Item Code");
			String sQty = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Qty");
			String sUnit = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Unit");
			String sPO = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "PO");
			String sSupplier = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Supplier");
			String sCcy = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Ccy");
			String sPOQtyAllocation = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "PO Qty Allocation");
			String sUnitCost = SessionData.getDataTbVal("SOV_DRAFT_DETAILS_TAB", row, "Unit Cost");
			int iRowIndex = 0;
			if (!sLiNo.isEmpty()) {
				iRowIndex = SOVariationSteps.get_det_row_by_line_item_no(sLiNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				SOVariationSteps.select_det_item_type(iRowIndex, sItemType);
			}
			if (!sItemCode.isEmpty()) {
				SOVariationSteps.enter_det_item_code(iRowIndex, sItemCode);
			}
			if (!sQty.isEmpty()) {
				SOVariationSteps.enter_det_qty(iRowIndex, sQty);
			}
			if (!sUnit.isEmpty()) {
				SOVariationSteps.enter_det_unit(iRowIndex, sUnit);
			}
			if (!sPO.isEmpty()) {
				SOVariationSteps.select_det_po(iRowIndex, sPO);
			}
			if (!sSupplier.isEmpty()) {
				SOVariationSteps.enter_det_supplier(iRowIndex, sSupplier);
			}
			if (!sCcy.isEmpty()) {
				SOVariationSteps.enter_det_ccy(iRowIndex, sCcy);
			}
			if (!sPOQtyAllocation.isEmpty()) {
				SOVariationSteps.enter_det_po_qty_allocation(iRowIndex, sPOQtyAllocation);
			}
			if (!sUnitCost.isEmpty()) {
				SOVariationSteps.enter_det_unit_cost(iRowIndex, sUnitCost);
			}
		}
	}

	@Then("^user submits created Sales Order Variation then gets Purchase Order No$")
	public void user_submits_created_Sales_Order_Variation_then_gets_Purchase_Order_No() throws Throwable {
		SOVariationSteps.submit_sales_order_detail();
		SessionData.addToListString(PO_NO, SOVariationSteps.get_purchase_order_no_then_click_ok());
		SOVariationSteps.purchase_order_no(SessionData.getListStringLastValue(PO_NO).toString());
	}

	@Then("^user submits created Sales Order Variation then gets Purchase Requisitions No$")
	public void user_submits_created_Sales_Order_Variation_then_gets_Purchase_Requisitions_No() throws Throwable {
		SOVariationSteps.submit_sales_order_detail();
		SessionData.addToListString(PR_NO, SOVariationSteps.get_purchase_requisitions_no_then_click_ok());
		SOVariationSteps.purchase_requisitions_no(SessionData.getListStringLastValue(PR_NO).toString());
	}
	@Then("^user submits created Sales Order Variation$")
	public void user_submits_created_Sales_Order_Variation() throws Throwable {
		SOVariationSteps.submit_sales_order_detail();
	}
}
