package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.purchase.purchaserequisition.steps.RequisitionSummarySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class RequisitionSummaryDefs {
	private final static String PR_NO = "Purchase Requisition No";
	private final static String SO_NO = "Sales Order No";
	// private final static String PO_NO = "Purchase Order No";
	@Steps
	RequisitionSummarySteps RSSteps;

	@Given("^user creates new Purchase Requisition in Purchase Requisition Draft as \"([^\"]*)\"$")
	public void user_creates_new_Purchase_Requisition_in_Purchase_Requisition_Draft_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		RSSteps.switch_to_tab_draft();
		RSSteps.click_btn_new_of_pr_summany();
		SessionData.addToListString(PR_NO, RSSteps.get_prd_new_purchase_requisition_no());
		RSSteps.purchase_requisition_no(SessionData.getListStringLastValue(PR_NO).toString());
		SessionData.addDataTable("PR_DRAFT_HEADER", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PR_DRAFT_HEADER", "KEY", dataKey).keySet()) {
			String sRequestor = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Requestor");
			String sRequestorName = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Requestor Name");
			String sCopyFrom = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Copy From");
			String sPurchaseRequisitionDate = SessionData.getDataTbVal("PR_DRAFT_HEADER", row,
					"Purchase Requisition Date");
			String sSegment1 = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Segment 1");
			String sSegment2 = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Segment 2");
			String sSegment3 = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Segment 3");
			String sSegment4 = SessionData.getDataTbVal("PR_DRAFT_HEADER", row, "Segment 4");
			if (!sRequestor.isEmpty()) {
				RSSteps.enter_prd_requestor(sRequestor);
			}
			if (!sRequestorName.isEmpty()) {
				if (sRequestorName.equals("@LOGINUSERNAME@")) {
					sRequestorName = RSSteps.get_user_login_name();
				}
				assertThat(RSSteps.get_prd_requestor_name().equals(sRequestorName)).isTrue();
			}
			if (!sCopyFrom.isEmpty()) {
				RSSteps.enter_prd_copy_from(sCopyFrom);
			}
			if (!sPurchaseRequisitionDate.isEmpty()) {
				RSSteps.enter_prd_header_purchase_requisition_date(sPurchaseRequisitionDate);
			}
			if (!sSegment1.isEmpty()) {
				RSSteps.enter_prd_header_segment_1(sSegment1);
			}
			if (!sSegment2.isEmpty()) {
				RSSteps.enter_prd_header_segment_2(sSegment2);
			}
			if (!sSegment3.isEmpty()) {
				RSSteps.enter_prd_header_segment_3(sSegment3);
			}
			if (!sSegment4.isEmpty()) {
				RSSteps.enter_prd_header_segment_4(sSegment4);
			}

		}
	}

	@Given("^user inputs data in Shipment tab of Purchase Requisition Draft  as \"([^\"]*)\"$")
	public void user_inputs_data_in_Shipment_tab_of_Purchase_Requisition_Draft_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		RSSteps.switch_to_tab_shipment();
		SessionData.addDataTable("PR_DRAFT_SHIPMENT_TAB", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PR_DRAFT_SHIPMENT_TAB", "KEY", dataKey).keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("PR_DRAFT_SHIPMENT_TAB", row, "Shipment Mode");
			String sShipmentTerm = SessionData.getDataTbVal("PR_DRAFT_SHIPMENT_TAB", row, "Shipment Term");
			String sShipToLocation = SessionData.getDataTbVal("PR_DRAFT_SHIPMENT_TAB", row, "Ship to Location");
			String sNoOfShipment = SessionData.getDataTbVal("PR_DRAFT_SHIPMENT_TAB", row, "No. of Shipment");
			if (!sShipmentMode.isEmpty()) {
				RSSteps.enter_prd_shi_shipment_mode(sShipmentMode);
			}
			if (!sShipmentTerm.isEmpty()) {
				RSSteps.enter_prd_shi_shipment_term(sShipmentTerm);
			}
			if (!sShipToLocation.isEmpty()) {
				RSSteps.enter_prd_shi_ship_to_location(sShipToLocation);
			}
			if (!sNoOfShipment.isEmpty()) {
				RSSteps.enter_prd_shi_no_of_shipment(sNoOfShipment);
			}
		}
	}

	@Given("^user inputs data in Detail tab of Purchase Requisition Draft as \"([^\"]*)\"$")
	public void user_inputs_data_in_Detail_tab_of_Purchase_Requisition_Draft_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PR_DRAFT_DETAIL_TAB", dataTable);
		RSSteps.switch_to_tab_detail();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PR_DRAFT_DETAIL_TAB", "KEY", dataKey).keySet()) {
			String sNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB", row, "No.");
			String sType = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB", row, "Type");
			String sItemCode = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB", row, "Item Code");
			String sQty = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB", row, "Qty");
			String sSupplier = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB", row, "Supplier");
			String sNewBaseUCost = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB", row, "Unit Cost New");
			int rowIndex = 0;
			RSSteps.click_btn_prd_detail_add();
			if (!sNo.isEmpty()) {
				rowIndex = RSSteps.get_prd_detail_row_by_no(sNo);
			} else {
				continue;
			}
			if (!sType.isEmpty()) {
				RSSteps.select_prd_detail_type(rowIndex, sType);
			}
			if (!sItemCode.isEmpty()) {
				RSSteps.enter_prd_detail_item_code(rowIndex, sItemCode);
			}
			if (!sQty.isEmpty()) {
				RSSteps.enter_prd_detail_qty(rowIndex, sQty);
			}
			RSSteps.open_prd_detail_panel_line_item_information(rowIndex);
			if (!sSupplier.isEmpty()) {
				// RSSteps.enter_prd_detail_supplier_all_line(sSupplier);
				RSSteps.switch_to_tab_prd_detail_supplier();
				RSSteps.click_btn_prd_detail_lii_supplier_add();
				RSSteps.enter_prd_detail_lii_supplier_new_supplier(sSupplier);
			} else {
				continue;
			}
			if (!sNewBaseUCost.isEmpty()) {
				RSSteps.enter_prd_detail_lii_supplier_new_unit_cost_new(sNewBaseUCost);
			}
		}
	}

	@Given("^user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Draft as \"([^\"]*)\"$")
	public void user_inputs_data_for_Supplier_of_Line_Item_Information_in_Detail_tab_of_Purchase_Requisition_Draft_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", dataTable);
		String tempBefore = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "KEY");
			String sNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "No.");
			String sSupplier = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Supplier");
			String sType = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Type");
			String sVoucherNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Voucher No.");
			String sVoucherDate = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Voucher Date");
			String sCcy = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Ccy");
			String sCostType = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Cost Type");
			String sUnitCostRef = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Unit Cost Ref");
			String sUnitCostNew = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Unit Cost New");
			String sDiscountPercent = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row,
					"Discount Percent");
			String sDiscountAmount = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row,
					"Discount Amount");
			String sTax = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Tax");
			String sTaxAmt = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_SUPPLIER", row, "Tax Amt");
			if (!sKey.isEmpty()) {
			}
			if (!sNo.isEmpty()) {
				if (!tempBefore.equals(sNo)) {
					RSSteps.open_prd_detail_panel_line_item_information(RSSteps.get_prd_detail_row_by_no(sNo));
					RSSteps.switch_to_tab_prd_detail_supplier();
				}
				RSSteps.click_btn_prd_detail_lii_supplier_add();
				tempBefore = sNo;
			}
			if (!sSupplier.isEmpty()) {
				RSSteps.enter_prd_detail_lii_supplier_new_supplier(sSupplier);
			}
			if (!sType.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_supplier_new_type().equals(sType)).isTrue();
			}
			if (!sVoucherNo.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_supplier_new_voucher_no().equals(sVoucherNo)).isTrue();
			}
			if (!sVoucherDate.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_supplier_new_voucher_date().equals(sVoucherDate)).isTrue();
			}
			if (!sCcy.isEmpty()) {
				RSSteps.select_prd_detail_lii_supplier_new_ccy(sCcy);
			}
			if (!sCostType.isEmpty()) {
				RSSteps.select_prd_detail_lii_supplier_new_cost_type(sCostType);
			}
			if (!sUnitCostRef.isEmpty()) {
				RSSteps.enter_prd_detail_lii_supplier_new_unit_cost_ref(sUnitCostRef);
			}
			if (!sUnitCostNew.isEmpty()) {
				RSSteps.enter_prd_detail_lii_supplier_new_unit_cost_new(sUnitCostNew);
			}
			if (!sDiscountPercent.isEmpty()) {
				RSSteps.enter_prd_detail_lii_supplier_new_disc_percent(sDiscountPercent);
			}
			if (!sDiscountAmount.isEmpty()) {
				RSSteps.enter_prd_detail_lii_supplier_new_disc_amt(sDiscountAmount);
			}
			if (!sTax.isEmpty()) {
				RSSteps.select_prd_detail_lii_supplier_new_tax(sTax);
			}
			if (!sTaxAmt.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_supplier_new_tax_amount().equals(sTaxAmt)).isTrue();
			}
		}
	}

	@Given("^user inputs data for Allocation of Line Item Information in Detail tab of Purchase Requisition Draft as \"([^\"]*)\"$")
	public void user_inputs_data_for_Allocation_of_Line_Item_Information_in_Detail_tab_of_Purchase_Requisition_Draft_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", dataTable);
		String tempBefore = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "KEY");
			String sNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "No.");
			String sAllocationNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row,
					"Allocation No.");
			String sType = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "Type");
			String sVoucherNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "Voucher No.");
			String sCustomerJobNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row,
					"Customer Job No.");
			String sPhaseNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "Phase No.");
			String sScheduleNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "Schedule No.");
			String sLineItemNo = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "Line Item No.");
			String sAllocQty = SessionData.getDataTbVal("PR_DRAFT_DETAIL_TAB_LII_ALLOCATION", row, "Alloc Qty");
			if (!sKey.isEmpty()) {
			}
			if (!sNo.isEmpty()) {
				if (!tempBefore.equals(sNo)) {
					RSSteps.open_prd_detail_panel_line_item_information(RSSteps.get_prd_detail_row_by_no(sNo));
					RSSteps.switch_to_tab_prd_detail_allocation();
				}
				RSSteps.click_btn_prd_detail_lii_allocation_add();
				tempBefore = sNo;
			}
			int rowIndex = 0;
			if (!sAllocationNo.isEmpty()) {
				rowIndex = RSSteps.get_prd_detail_lii_allocation_allocation_no(sAllocationNo);
			}
			if (!sType.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_allocation_type(rowIndex).equals(sType)).isTrue();
			}
			if (!sVoucherNo.isEmpty()) {
				RSSteps.enter_prd_detail_lii_allocation_voucher_no(rowIndex, sVoucherNo);
			}
			if (!sCustomerJobNo.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_allocation_customer_job_no(rowIndex).equals(sCustomerJobNo))
						.isTrue();
			}
			if (!sPhaseNo.isEmpty()) {
				RSSteps.enter_prd_detail_lii_allocation_phase_no(rowIndex, sPhaseNo);
			}
			if (!sScheduleNo.isEmpty()) {
				assertThat(RSSteps.get_prd_detail_lii_allocation_schedule_no(rowIndex).equals(sScheduleNo)).isTrue();
			}
			if (!sLineItemNo.isEmpty()) {
				RSSteps.enter_prd_detail_lii_allocation_line_item_no(rowIndex, sLineItemNo);
			}
			if (!sAllocQty.isEmpty()) {
				RSSteps.enter_prd_detail_lii_allocation_alloc_qty(rowIndex, sAllocQty);
			}
		}
	}

	@Then("^user previews Reports in Purchase Requisition Draft$")
	public void user_previews_Reports_in_Purchase_Requisition_Draft(List<List<String>> dataTable) throws Throwable {
		String sCurrentWindow = RSSteps.getCurrentWindowHandle();
		RSSteps.click_btn_prd_preview();
		if (RSSteps.switch_to_preview_report_window()) {
			assertTrue("Preview content is not correct.",
					RSSteps.verify_preview_report_content("Purchase Requisition"));
			RSSteps.getDriver().close();
			RSSteps.switchToWindowHandle(sCurrentWindow);
		} else {
			RSSteps.switchToWindowHandle(sCurrentWindow);
			fail("***** ERROR ***** Report window not display.");
		}
	}

	@Then("^user previews Reports in Purchase Requisition Draft as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Purchase_Requisition_Draft_as(String dataKey, List<List<String>> dataTable)
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
			String sCurrentWindow = RSSteps.getCurrentWindowHandle();
			RSSteps.click_btn_prd_preview();
			boolean isDisplaySelectReport = RSSteps.is_display_reports_selection();
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				RSSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (RSSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", RSSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					int iRet = RSSteps.count_text_sections_in_report();
					assertTrue("Checksum is not correct. Expected : " + iChecksum + " Actual: " + iRet,
							iRet == iChecksum);
				}
				RSSteps.getDriver().close();
				RSSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				RSSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Cost Confirmation as \"([^\"]*)\"$")
	public void user_inputs_data_for_Supplier_of_Line_Item_Information_in_Detail_tab_of_Purchase_Requisition_Cost_Confirmation_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		RSSteps.switch_to_tab_detail();
		SessionData.addDataTable("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", dataTable);
		String tempBefore = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "KEY");
			String sNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "No.");
			String sSupplier = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Supplier");
			String sType = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Type");
			String sVoucherNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Voucher No.");
			String sVoucherDate = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Voucher Date");
			String sCcy = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Ccy");
			String sCostType = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Cost Type");
			String sUnitCostRef = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Unit Cost Ref");
			String sUnitCostNew = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Unit Cost New");
			String sDiscountPercent = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row,
					"Discount Percent");
			String sDiscountAmount = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row,
					"Discount Amount");
			String sTax = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Tax");
			String sTaxAmt = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Tax Amt");
			String sPrefSup = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_SUPPLIER", row, "Pref Sup");
			if (!sKey.isEmpty()) {
			}
			if (!sNo.isEmpty()) {
				if (!tempBefore.equals(sNo)) {
					RSSteps.open_prcc_detail_panel_line_item_information(RSSteps.get_prcc_detail_row_by_no(sNo));
					RSSteps.switch_to_tab_prd_detail_supplier();
				}
				RSSteps.click_btn_prcc_detail_lii_supplier_add();
				tempBefore = sNo;
			}
			if (!sSupplier.isEmpty()) {
				RSSteps.enter_prcc_detail_lii_supplier_new_supplier(sSupplier);
			}
			if (!sType.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_supplier_new_type().equals(sType)).isTrue();
			}
			if (!sVoucherNo.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_supplier_new_voucher_no().equals(sVoucherNo)).isTrue();
			}
			if (!sVoucherDate.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_supplier_new_voucher_date().equals(sVoucherDate)).isTrue();
			}
			if (!sCcy.isEmpty()) {
				RSSteps.select_prcc_detail_lii_supplier_new_ccy(sCcy);
			}
			if (!sCostType.isEmpty()) {
				RSSteps.select_prcc_detail_lii_supplier_new_cost_type(sCostType);
			}
			if (!sUnitCostRef.isEmpty()) {
				RSSteps.enter_prcc_detail_lii_supplier_new_unit_cost_ref(sUnitCostRef);
			}
			if (!sUnitCostNew.isEmpty()) {
				RSSteps.enter_prcc_detail_lii_supplier_new_unit_cost_new(sUnitCostNew);
			}
			if (!sDiscountPercent.isEmpty()) {
				RSSteps.enter_prcc_detail_lii_supplier_new_disc_percent(sDiscountPercent);
			}
			if (!sDiscountAmount.isEmpty()) {
				RSSteps.enter_prcc_detail_lii_supplier_new_disc_amt(sDiscountAmount);
			}
			if (!sTax.isEmpty()) {
				RSSteps.select_prcc_detail_lii_supplier_new_tax(sTax);
			}
			if (!sTaxAmt.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_supplier_new_tax_amount().equals(sTaxAmt)).isTrue();
			}
			if (!sPrefSup.isEmpty()) {
				RSSteps.set_prcc_detail_lii_supplier_pref_sup(sPrefSup);
			}
		}
	}

	@Then("^data for Allocation of Line Item Information was entered in Detail tab of Purchase Requisition Cost Confirmation as \"([^\"]*)\"$")
	public void data_for_Allocation_of_Line_Item_Information_was_entered_in_Detail_tab_of_Purchase_Requisition_Cost_Confirmation_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		RSSteps.switch_to_tab_detail();
		SessionData.addDataTable("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", dataTable);
		String tempBefore = "";
		for (int row : SessionData
				.getDataTbRowsByValEqualInCol("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row, "KEY");
			String sNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row, "No.");
			String sAllocationNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row,
					"Allocation No.");
			String sType = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row, "Type");
			String sVoucherNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row,
					"Voucher No.");
			String sCustomerJobNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row,
					"Customer Job No.");
			String sPhaseNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row, "Phase No.");
			String sScheduleNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row,
					"Schedule No.");
			String sLineItemNo = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row,
					"Line Item No.");
			String sAllocQty = SessionData.getDataTbVal("PR_PRCC_DETAIL_TAB_LII_ALLOCATION_VERIFY", row, "Alloc Qty");
			if (!sKey.isEmpty()) {
			}
			if (!sNo.isEmpty()) {
				if (!tempBefore.equals(sNo)) {
					RSSteps.open_prcc_detail_panel_line_item_information(RSSteps.get_prcc_detail_row_by_no(sNo));
					RSSteps.switch_to_tab_prcc_detail_allocation();
				}
				tempBefore = sNo;
			}
			int rowIndex = 0;
			if (!sAllocationNo.isEmpty()) {
				rowIndex = RSSteps.get_prcc_detail_lii_allocation_allocation_no(sAllocationNo);
			}
			if (!sType.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_type(rowIndex).equals(sType)).isTrue();
			}
			if (!sVoucherNo.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_voucher_no(rowIndex).equals(sVoucherNo)).isTrue();
			}
			if (!sCustomerJobNo.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_customer_job_no(rowIndex).equals(sCustomerJobNo))
						.isTrue();
			}
			if (!sPhaseNo.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_phase_no(rowIndex).equals(sPhaseNo)).isTrue();
			}
			if (!sScheduleNo.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_schedule_no(rowIndex).equals(sScheduleNo)).isTrue();
			}
			if (!sLineItemNo.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_line_item_no(rowIndex).equals(sLineItemNo)).isTrue();
			}
			if (!sAllocQty.isEmpty()) {
				assertThat(RSSteps.get_prcc_detail_lii_allocation_alloc_qty(rowIndex).equals(sAllocQty)).isTrue();
			}
		}
	}

	@Then("^user submits created Purchase Requisition in Purchase Requisition Draft$")
	public void user_submits_created_Purchase_Requisition_in_Purchase_Requisition_Draft() throws Throwable {
		RSSteps.click_btn_prd_submit_purchase_requisition_detail();
	}

	@Then("^user opens created Purchase Requisition in Purchase Requisition Draft$")
	public void user_opens_created_Purchase_Requisition_in_Purchase_Requisition_Draft() throws Throwable {
		RSSteps.switch_to_tab_draft();
		RSSteps.filter_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		RSSteps.open_first_purchase_requisition_no();
	}

	@Then("^user opens created Purchase Requisition in Purchase Requisition Draft by Source Voucher No$")
	public void user_opens_created_Purchase_Requisition_in_Purchase_Requisition_Draft_by_Source_Voucher_No()
			throws Throwable {
		RSSteps.switch_to_tab_draft();
		RSSteps.filter_by_source_voucher_no(SessionData.getListStringLastValue(SO_NO));
		RSSteps.open_first_purchase_requisition_no();
		SessionData.addToListString(PR_NO, RSSteps.get_prd_new_purchase_requisition_no());
		RSSteps.purchase_requisition_no(SessionData.getListStringLastValue(PR_NO).toString());
	}

	@Then("^user opens created Purchase Requisition in Purchase Requisition Cost Confirmation$")
	public void user_opens_created_Purchase_Requisition_in_Purchase_Requisition_Cost_Confirmation() throws Throwable {
		RSSteps.switch_to_tab_cost_confirmation();
		RSSteps.filter_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		RSSteps.open_first_purchase_requisition_no();
	}

	@Then("^user previews Reports in Purchase Requisition Cost Confirmation$")
	public void user_previews_Reports_in_Purchase_Requisition_Cost_Confirmation(List<List<String>> dataTable)
			throws Throwable {
		String sCurrentWindow = RSSteps.getCurrentWindowHandle();
		RSSteps.click_btn_prcc_preview();
		if (RSSteps.switch_to_preview_report_window()) {
			assertTrue("Preview content is not correct.",
					RSSteps.verify_preview_report_content("Purchase Requisition"));
			RSSteps.getDriver().close();
			RSSteps.switchToWindowHandle(sCurrentWindow);
		} else {
			RSSteps.switchToWindowHandle(sCurrentWindow);
			fail("***** ERROR ***** Report window not display.");
		}
	}

	@Then("^user previews Reports in Purchase Requisition Cost Confirmation as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Purchase_Requisition_Cost_Confirmation_as(String dataKey,
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
			String sCurrentWindow = RSSteps.getCurrentWindowHandle();
			RSSteps.click_btn_prcc_preview();
			boolean isDisplaySelectReport = RSSteps.is_display_reports_selection();
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				RSSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (RSSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", RSSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					assertTrue("Checksum is not correct. Expected : " + iChecksum,
							RSSteps.count_text_sections_in_report() == iChecksum);
				}
				RSSteps.getDriver().close();
				RSSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				RSSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user submits created Purchase Requisition in Purchase Requisition Cost Confirmation$")
	public void user_submits_created_Purchase_Requisition_in_Purchase_Requisition_Cost_Confirmation() throws Throwable {
		RSSteps.click_btn_prcc_submit();
	}

	@Then("^user opens created Purchase Requisition in Purchase Requisition Pending$")
	public void user_opens_created_Purchase_Requisition_in_Purchase_Requisition_Pending() throws Throwable {
		RSSteps.switch_to_tab_pending_approval();
		RSSteps.filter_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		RSSteps.open_first_purchase_requisition_no();
	}

	@Then("^user opens created Purchase Requisition in Purchase Requisition History$")
	public void user_opens_created_Purchase_Requisition_in_Purchase_Requisition_History() throws Throwable {
		RSSteps.switch_to_tab_history();
		RSSteps.filter_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		RSSteps.open_first_purchase_requisition_no();
	}
}
