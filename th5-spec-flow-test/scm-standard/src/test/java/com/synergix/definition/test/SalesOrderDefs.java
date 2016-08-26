package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.sales.steps.SalesOrderSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SalesOrderDefs {
	// private final static String SQ_NO = "Sales Quotation No";
	private final static String SO_NO = "Sales Order No";
	private final static String PO_NO = "Purchase Order No";
	private final static String PR_NO = "Purchase Requisition No";
	private final static String SV_NO = "Shipment Voucher No";
	@Steps
	SalesOrderSteps SOSteps;

	@Then("^user inputs data in Draft stage in Header tab of Sales Order as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Header_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SO_DRAFT_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			String sCustomerAddress = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Customer Address");
			String sCustomerContact = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Customer Contact");
			String sOrderCurrency = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Order Currency");
			String sSalesTax = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Sales Tax");
			String sSalesPerson = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Sales Person");
			String sApprovingSbu = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Approving SBU");
			String sReferenceNo = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Reference No.");
			String sAllocatePOToSO = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Allocate PO to SO");
			String sAllocatePRToSO = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Allocate PR to SO");
			String sSubject = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Subject");
			String sSegment1 = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Segment 1");
			String sSegment2 = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Segment 2");
			String sSegment3 = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Segment 3");
			String sSegment4 = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Segment 4");

			if (!sCustomerAddress.isEmpty()) {
				SOSteps.enter_customer_address(sCustomerAddress);
			}
			if (!sCustomerContact.isEmpty()) {
				SOSteps.enter_customer_contact(sCustomerContact);
			}
			if (!sOrderCurrency.isEmpty()) {
				SOSteps.enter_order_currency(sOrderCurrency);
			}
			if (!sSalesTax.isEmpty()) {
				SOSteps.enter_sales_tax(sSalesTax);
			}
			if (!sSalesPerson.isEmpty()) {
				SOSteps.enter_sales_person(sSalesPerson);
			}
			if (!sApprovingSbu.isEmpty()) {
				SOSteps.enter_approving_sbu(sApprovingSbu);
			}
			if (!sReferenceNo.isEmpty()) {
				SOSteps.enter_reference_no(sReferenceNo);
			}
			if (!sSubject.isEmpty()) {
				SOSteps.enter_subject(sSubject);
			}
			if (!sAllocatePRToSO.isEmpty()) {
				SOSteps.select_allocate_pr_to_so(sAllocatePRToSO);
			}
			if (!sAllocatePOToSO.isEmpty()) {
				SOSteps.select_allocate_po_to_so(sAllocatePOToSO);
			}
			if (!sSegment1.isEmpty()) {
				SOSteps.enter_segment_1(sSegment1);
			}
			if (!sSegment2.isEmpty()) {
				SOSteps.enter_segment_2(sSegment2);
			}
			if (!sSegment3.isEmpty()) {
				SOSteps.enter_segment_3(sSegment3);
			}
			if (!sSegment4.isEmpty()) {
				SOSteps.enter_segment_4(sSegment4);
			}
		}
	}

	@Then("^user verifies data in Draft stage in Detail tab of Sales Order as \"([^\"]*)\"$")
	public void user_verifies_data_in_Draft_stage_in_Detail_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SOSteps.switch_to_tab_detail();
		SessionData.addDataTable("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", "KEY", dataKey)
				.keySet()) {
			String sTotalVolume = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", row, "Total Volume");
			String sTotalWeight = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", row, "Total Weight");
			String sTotalDiscountAmt = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", row,
					"Total Discount Amt");
			String sTotalSalesTaxAmt = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", row,
					"Total Sales Tax Amt");
			String sSubTotalAfterDiscount = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", row,
					"Sub Total After Discount");
			String sTotalAfterTaxAmt = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB_TOTAL_VERIFY", row,
					"Total After Tax Amt");

			if (!sTotalVolume.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_total_volume(), sTotalVolume)).isTrue();
			}
			if (!sTotalWeight.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_total_weight(), sTotalWeight)).isTrue();
			}
			if (!sTotalDiscountAmt.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_total_discount_amt(), sTotalDiscountAmt))
						.isTrue();
			}
			if (!sTotalSalesTaxAmt.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_total_sales_tax_amt(), sTotalSalesTaxAmt))
						.isTrue();
			}
			if (!sSubTotalAfterDiscount.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_sub_total_after_discount(),
						sSubTotalAfterDiscount)).isTrue();
			}
			if (!sTotalAfterTaxAmt.isEmpty()) {
				assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_total_after_tax_amt(), sTotalAfterTaxAmt))
						.isTrue();
			}
		}
	}

	@Then("^user opens Sales Order Variation of created Sales Order in Outstanding state of Sales Order Summary$")
	public void user_opens_Sales_Order_Variation_created_Sales_Order_in_Outstanding_state_of_Sales_Order_Summary()
			throws Throwable {
		SOSteps.switch_to_tab_outstanding();
		SOSteps.filter_summary_by_sales_order_no(SessionData.getListStringLastValue(SO_NO));
		SOSteps.open_first_sales_order_variation();
	}

	@Then("^user opens created Sales Order in Draft state of Sales Order Summary$")
	public void user_opens_created_Sales_Order_in_Draft_state_of_Sales_Order_Summary() throws Throwable {
		SOSteps.switch_to_tab_draft();
		SOSteps.filter_summary_by_sales_order_no(SessionData.getListStringLastValue(SO_NO));
		SOSteps.open_first_sales_order_no();
	}

	@Given("^user creates new Sales Order in Draft stage of Sales Order Summary as \"([^\"]*)\"$")
	public void user_creates_new_Sales_Order_in_Draft_stage_of_Sales_Order_Summary_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SOSteps.switch_to_tab_draft();
		SOSteps.click_btn_new_of_so_summany();
		SessionData.addToListString(SO_NO, SOSteps.get_new_sales_order_no());
		SOSteps.sales_order_no(SessionData.getListStringLastValue(SO_NO).toString());
		SessionData.addDataTable("SO_DRAFT_HEADER", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_HEADER", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("SO_DRAFT_HEADER", row, "KEY");
			String sCustomerCode = SessionData.getDataTbVal("SO_DRAFT_HEADER", row, "Customer Code");
			String sCustomerName = SessionData.getDataTbVal("SO_DRAFT_HEADER", row, "Customer Name");
			String sCopyFromOption = SessionData.getDataTbVal("SO_DRAFT_HEADER", row, "Copy From Option");
			String sCopyFrom = SessionData.getDataTbVal("SO_DRAFT_HEADER", row, "Copy From");
			if (!sKey.isEmpty()) {
			}
			if (!sCustomerCode.isEmpty()) {
				SOSteps.enter_customer(sCustomerCode);
			}
			if (!sCustomerName.isEmpty()) {
				assertThat(SOSteps.get_customer_name().equals(sCustomerName)).isTrue();
			}
			if (!sCopyFromOption.isEmpty()) {
				SOSteps.select_option_copy_from_option(sCopyFromOption);
			}
			if (!sCopyFrom.isEmpty()) {
				if (sCopyFrom.toLowerCase().equals("@last sales order no@")) {
					sCopyFrom = SessionData.getListStringByIndex(SO_NO, -1);
				}
				SOSteps.enter_copy_from(sCopyFrom);
				SOSteps.click_btn_copy();
			}
		}
	}

	@Then("^all default fields in Draft stage in Header tab of Sales Order will be pulled out as \"([^\"]*)\"$")
	public void all_default_fields_in_Draft_stage_in_Header_tab_of_Sales_Order_will_be_pulled_out_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SO_DRAFT_HEADER_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			String sCustomerAddress = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Customer Address");
			String sCustomerContact = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Customer Contact");
			String sOrderCurrency = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Order Currency");
			String sSalesTax = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Sales Tax");
			String sSalesPerson = SessionData.getDataTbVal("SO_DRAFT_HEADER_TAB", row, "Sales Person");
			if (!sCustomerAddress.isEmpty()) {
				assertThat(SOSteps.get_customer_address_code().equals(sCustomerAddress)).isTrue();
			}
			if (!sCustomerContact.isEmpty()) {
				assertThat(SOSteps.get_customer_contact_code().equals(sCustomerContact)).isTrue();
			}
			if (!sOrderCurrency.isEmpty()) {
				assertThat(SOSteps.get_order_currency().equals(sOrderCurrency)).isTrue();
			}
			if (!sSalesTax.isEmpty()) {
				assertThat(SOSteps.get_sales_tax().equals(sSalesTax)).isTrue();
			}
			if (!sSalesPerson.isEmpty()) {
				assertThat(SOSteps.get_sales_person().equals(sSalesPerson)).isTrue();
			}
		}

	}

	@Then("^user inputs data in Draft stage in Shipment tab of Sales Order as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Shipment_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SO_DRAFT_SHIPMENT_TAB", dataTable, false);
		SOSteps.switch_to_tab_shipment();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_SHIPMENT_TAB", "KEY", dataKey).keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("SO_DRAFT_SHIPMENT_TAB", row, "Shipment Mode");
			String sShipmentTerm = SessionData.getDataTbVal("SO_DRAFT_SHIPMENT_TAB", row, "Shipment Term");
			String sLoadingLocation = SessionData.getDataTbVal("SO_DRAFT_SHIPMENT_TAB", row, "Loading Location");
			String sNoOfShipment = SessionData.getDataTbVal("SO_DRAFT_SHIPMENT_TAB", row, "No. of Shipment");
			if (!sShipmentMode.isEmpty()) {
				SOSteps.enter_shipment_mode(sShipmentMode);
			}
			if (!sShipmentTerm.isEmpty()) {
				SOSteps.enter_shipment_term(sShipmentTerm);
			}
			if (!sLoadingLocation.isEmpty()) {
				SOSteps.enter_loading_location(sLoadingLocation);
			}
			if (!sNoOfShipment.isEmpty()) {
				SOSteps.enter_no_of_shipment(sNoOfShipment);
			}
		}
	}

	@Then("^user previews Reports in Sales Order as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Sales_Order_as(String dataKey, List<List<String>> dataTable) throws Throwable {
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
			String sCurrentWindow = SOSteps.getCurrentWindowHandle();
			SOSteps.click_btn_preview_sales_order_detail();
			boolean isDisplaySelectReport = SOSteps.is_display_reports_selection();
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				SOSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (SOSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", SOSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					int iRet = SOSteps.count_text_sections_in_report();
					assertTrue("Checksum is not correct. Expected : " + iChecksum + " Actual: " + iRet,
							iRet == iChecksum);
				}
				SOSteps.getDriver().close();
				SOSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				SOSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user inputs data in Draft stage in Detail tab of Sales Order as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Detail_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SOSteps.switch_to_tab_detail();
		SessionData.addDataTable("SO_DRAFT_DETAILS_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_DETAILS_TAB", "KEY", dataKey).keySet()) {
			String sLiNo = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Item Code");
			String sLoadingLocation = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Loading Location");
			String sQty = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Qty");
			String sPackSize = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Pack Size");
			String sNoOfPack = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "No. Of Pack");
			String sUnit = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Unit");
			String sPR = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "PR");
			String sPO = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "PO");
			String sSupplier = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Supplier");
			String sCcy = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Ccy");
			String sDraftOstPONo = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Draft/Ost PO No");
			String sDraftOstLineItemNo = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row,
					"Draft/Ost Line Item No");
			String sPOQtyAllocation = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "PO Qty Allocation");
			String sQOHAllocation = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "QOH Allocation");
			String sUnitCost = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Unit Cost");
			String sDiscountPercent = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Discount Percent");
			String sDiscountAmount = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Discount Amount");
			SOSteps.click_btn_add_detail();
			int iRowIndex = 0;
			if (!sLiNo.isEmpty()) {
				iRowIndex = SOSteps.get_det_row_by_line_item_no(sLiNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				SOSteps.select_det_item_type(iRowIndex, sItemType);
			}
			if (!sLoadingLocation.isEmpty()) {
				SOSteps.enter_det_loading_location(iRowIndex, sLoadingLocation);
			}
			if (!sItemCode.isEmpty()) {
				SOSteps.enter_det_item_code(iRowIndex, sItemCode);
			}
			if (!sPackSize.isEmpty()) {
				SOSteps.select_det_pack_size(iRowIndex, sPackSize);
			}
			if (!sNoOfPack.isEmpty()) {
				SOSteps.enter_det_no_of_pack(iRowIndex, sNoOfPack);
			}
			if (!sQty.isEmpty()) {
				if (!sNoOfPack.isEmpty()) {
					assertThat(SessionData.isSameDecimalValue(SOSteps.get_det_qty(iRowIndex), sQty)).isTrue();
				} else {
					SOSteps.enter_det_qty(iRowIndex, sQty);
				}
			}

			if (!sUnit.isEmpty()) {
				SOSteps.enter_det_unit(iRowIndex, sUnit);
			}
			if (!sPR.isEmpty()) {
				SOSteps.select_det_pr(iRowIndex, sPR);
			}
			if (!sPO.isEmpty()) {
				SOSteps.select_det_po(iRowIndex, sPO);
			}
			if (!sDraftOstPONo.isEmpty()) {
				if (sDraftOstPONo.equals("@Purchase Order No@")) {
					sDraftOstPONo = SessionData.getListStringLastValue(PO_NO).toString();
				}
				SOSteps.enter_det_draft_ost_po_no(iRowIndex, sDraftOstPONo);
			}
			if (!sDraftOstLineItemNo.isEmpty()) {
				assertThat(SOSteps.get_det_draft_ost_line_item_no(iRowIndex).equals(sDraftOstLineItemNo)).isTrue();
			}
			if (!sSupplier.isEmpty()) {
				SOSteps.enter_det_supplier(iRowIndex, sSupplier);
			}
			if (!sCcy.isEmpty()) {
				SOSteps.enter_det_ccy(iRowIndex, sCcy);
			}

			if (!sPOQtyAllocation.isEmpty()) {
				SOSteps.enter_det_po_qty_allocation(iRowIndex, sPOQtyAllocation);
			}
			if (!sQOHAllocation.isEmpty()) {
				SOSteps.enter_det_qoh_allocation(iRowIndex, sQOHAllocation);
			}
			if (!sUnitCost.isEmpty()) {
				SOSteps.enter_det_unit_cost(iRowIndex, sUnitCost);
			}
			if (!sDiscountPercent.isEmpty()) {
				SOSteps.enter_det_discount_percent(iRowIndex, sDiscountPercent);
			}
			if (!sDiscountAmount.isEmpty()) {
				SOSteps.enter_det_discount_amount(iRowIndex, sDiscountAmount);
			}
		}
	}

	@Then("^user updates data in Draft stage in Detail tab of Sales Order as \"([^\"]*)\"$")
	public void user_updates_data_in_Draft_stage_in_Detail_tab_of_Sales_Order_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SOSteps.switch_to_tab_detail();
		SessionData.addDataTable("SO_DRAFT_DETAILS_TAB", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SO_DRAFT_DETAILS_TAB", "KEY", dataKey).keySet()) {
			String sLiNo = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Item Code");
			String sQty = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Qty");
			String sUnit = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Unit");
			String sPO = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "PO");
			String sSupplier = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Supplier");
			String sCcy = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Ccy");
			String sPOQtyAllocation = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "PO Qty Allocation");
			String sUnitCost = SessionData.getDataTbVal("SO_DRAFT_DETAILS_TAB", row, "Unit Cost");
			int iRowIndex = 0;
			if (!sLiNo.isEmpty()) {
				iRowIndex = SOSteps.get_det_row_by_line_item_no(sLiNo);
			} else {
				continue;
			}
			if (!sItemType.isEmpty()) {
				SOSteps.select_det_item_type(iRowIndex, sItemType);
			}
			if (!sItemCode.isEmpty()) {
				SOSteps.enter_det_item_code(iRowIndex, sItemCode);
			}
			if (!sQty.isEmpty()) {
				SOSteps.enter_det_qty(iRowIndex, sQty);
			}
			if (!sUnit.isEmpty()) {
				SOSteps.enter_det_unit(iRowIndex, sUnit);
			}
			if (!sPO.isEmpty()) {
				SOSteps.select_det_po(iRowIndex, sPO);
			}
			if (!sSupplier.isEmpty()) {
				SOSteps.enter_det_supplier(iRowIndex, sSupplier);
			}
			if (!sCcy.isEmpty()) {
				SOSteps.enter_det_ccy(iRowIndex, sCcy);
			}
			if (!sPOQtyAllocation.isEmpty()) {
				SOSteps.enter_det_po_qty_allocation(iRowIndex, sPOQtyAllocation);
			}
			if (!sUnitCost.isEmpty()) {
				SOSteps.enter_det_unit_cost(iRowIndex, sUnitCost);
			}
		}
	}

	@Then("^user submits created Sales Order in Draft stage of Sales Order$")
	public void user_submits_created_Sales_Order_in_Draft_stage_of_Sales_Order() throws Throwable {
		SOSteps.submit_sales_order_detail();
		// Get Shipment Voucher No
		SessionData.addToListString(SV_NO, "");
	}

	@Then("^user submits created Sales Order then gets Purchase Order No in Draft stage of Sales Order$")
	public void user_submits_created_Sales_Order_then_gets_Purchase_Order_No_in_Draft_stage_of_Sales_Order()
			throws Throwable {
		SOSteps.submit_sales_order_detail();
		SessionData.addToListString(PO_NO, SOSteps.get_purchase_order_no_then_click_ok());
		SOSteps.purchase_order_no(SessionData.getListStringLastValue(PO_NO).toString());
	}

	@Then("^user submits created Sales Order then gets Purchase Requisitions No in Draft stage of Sales Order$")
	public void user_submits_created_Sales_Order_then_gets_Purchase_Requisitions_No_in_Draft_stage_of_Sales_Order()
			throws Throwable {
		SOSteps.submit_sales_order_detail();
		SessionData.addToListString(PR_NO, SOSteps.get_purchase_requisitions_no_then_click_ok());
		SOSteps.purchase_requisitions_no(SessionData.getListStringLastValue(PR_NO).toString());
	}

	@Then("^user opens created Sales Order in Outstanding state of Sales Order Summary$")
	public void user_opens_created_Sales_Order_in_Outstanding_state_of_Sales_Order_Summary() throws Throwable {
		SOSteps.switch_to_tab_outstanding();
		SOSteps.filter_summary_by_sales_order_no(SessionData.getListStringLastValue(SO_NO));
		SOSteps.open_first_sales_order_no();
	}

	@Then("^user opens created Sales Order in Completed state of Sales Order Summary$")
	public void user_opens_created_Sales_Order_in_Completed_state_of_Sales_Order_Summary() throws Throwable {
		SOSteps.switch_to_tab_completed();
		SOSteps.filter_summary_by_sales_order_no(SessionData.getListStringLastValue(SO_NO));
		SOSteps.open_first_sales_order_no();
	}
}
