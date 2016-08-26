package com.synergix.definition.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.sales.steps.SalesQuotationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SalesQuotationDefs {
	private final static String SQ_NO = "Sales Quotation No";
	private final static String SO_NO = "Sales Order No";
	@Steps
	SalesQuotationSteps SQSteps;

	@Given("^user creates new Sales Quotation in Draft stage of Sales Quotation Summary as \"([^\"]*)\"$")
	public void user_creates_new_Sales_Quotation_in_Draft_stage_of_Sales_Quotation_Summary_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SQSteps.switch_to_tab_draft();
		SQSteps.click_btn_new_of_sq_summany();
		SessionData.addToListString(SQ_NO, SQSteps.get_new_sales_quotation_no());
		SQSteps.sales_quotation_no(SessionData.getListStringLastValue(SQ_NO).toString());
		SessionData.addDataTable("SQ_DRAFT_HEADER", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SQ_DRAFT_HEADER", "KEY", dataKey).keySet()) {
			String sCustomerCode = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Customer Code");
			String sCustomerName = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Customer Name");
			String sCopyFromOption = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Copy From Option");
			String sCopyFrom = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Copy From");
			String sSegment1 = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Segment 1");
			String sSegment2 = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Segment 2");
			String sSegment3 = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Segment 3");
			String sSegment4 = SessionData.getDataTbVal("SQ_DRAFT_HEADER", row, "Segment 4");

			if (!sCustomerCode.isEmpty()) {
				SQSteps.enter_customer(sCustomerCode);
			}
			if (!sCustomerName.isEmpty()) {
				assertThat(SQSteps.get_customer_name().equals(sCustomerName)).isTrue();
			}
			if (!sCopyFromOption.isEmpty()) {
				SQSteps.select_option_copy_from(sCopyFromOption);
			}
			if (!sCopyFrom.isEmpty()) {
				SQSteps.enter_copy_from(sCopyFrom);
			}
			if (!sSegment1.isEmpty()) {
				SQSteps.enter_segment_1(sSegment1);
			}
			if (!sSegment2.isEmpty()) {
				SQSteps.enter_segment_2(sSegment2);
			}
			if (!sSegment3.isEmpty()) {
				SQSteps.enter_segment_3(sSegment3);
			}
			if (!sSegment4.isEmpty()) {
				SQSteps.enter_segment_4(sSegment4);
			}
		}
	}

	@Then("^all default fields in Draft stage in Header tab of Sales Quotation were be pulled out as \"([^\"]*)\"$")
	public void all_default_fields_in_Draft_stage_in_Header_tab_of_Sales_Quotation_were_be_pulled_out_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SQ_DRAFT_HEADER_TAB", dataTable);
		SQSteps.switch_to_tab_header();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SQ_DRAFT_HEADER_TAB", "KEY", dataKey).keySet()) {
			String sCustomerAddress = SessionData.getDataTbVal("SQ_DRAFT_HEADER_TAB", row, "Customer Address");
			String sCustomerContact = SessionData.getDataTbVal("SQ_DRAFT_HEADER_TAB", row, "Customer Contact");
			String sCurrency = SessionData.getDataTbVal("SQ_DRAFT_HEADER_TAB", row, "Currency");
			String sSalesTax = SessionData.getDataTbVal("SQ_DRAFT_HEADER_TAB", row, "Sales Tax");
			String sSalesPerson = SessionData.getDataTbVal("SQ_DRAFT_HEADER_TAB", row, "Sales Person");
			if (!sCustomerAddress.isEmpty()) {
				assertThat(SQSteps.get_customer_address_code().equals(sCustomerAddress)).isTrue();
			}
			if (!sCustomerContact.isEmpty()) {
				assertThat(SQSteps.get_customer_contact_code().equals(sCustomerContact)).isTrue();
			}
			if (!sCurrency.isEmpty()) {
				assertThat(SQSteps.get_currency().equals(sCurrency)).isTrue();
			}
			if (!sSalesTax.isEmpty()) {
				assertThat(SQSteps.get_sales_tax().equals(sSalesTax)).isTrue();
			}
			if (!sSalesPerson.isEmpty()) {
				assertThat(SQSteps.get_sales_person().equals(sSalesPerson)).isTrue();
			}
		}
	}

	@Then("^user inputs data in Draft stage in Shipment tab of Sales Quotation as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Shipment_tab_of_Sales_Quotation_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SQ_DRAFT_SHIPMENT_TAB", dataTable);
		SQSteps.switch_to_tab_shipment();
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SQ_DRAFT_SHIPMENT_TAB", "KEY", dataKey).keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("SQ_DRAFT_SHIPMENT_TAB", row, "Shipment Mode");
			String sShipmentTerm = SessionData.getDataTbVal("SQ_DRAFT_SHIPMENT_TAB", row, "Shipment Term");
			String sLoadingLocation = SessionData.getDataTbVal("SQ_DRAFT_SHIPMENT_TAB", row, "Loading Location");
			String sNoOfShipment = SessionData.getDataTbVal("SQ_DRAFT_SHIPMENT_TAB", row, "No. of Shipment");
			if (!sShipmentMode.isEmpty()) {
				SQSteps.enter_shipment_mode(sShipmentMode);
			}
			if (!sShipmentTerm.isEmpty()) {
				SQSteps.enter_shipment_term(sShipmentTerm);
			}
			if (!sLoadingLocation.isEmpty()) {
				SQSteps.enter_loading_location(sLoadingLocation);
			}
			if (!sNoOfShipment.isEmpty()) {
				SQSteps.enter_no_of_shipment(sNoOfShipment);
			}
		}
	}

	@Then("^user inputs data in Draft stage in Detail tab of Sales Quotation as \"([^\"]*)\"$")
	public void user_inputs_data_in_Draft_stage_in_Detail_tab_of_Sales_Quotation_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SQSteps.switch_to_tab_detail();
		SessionData.addDataTable("SQ_DRAFT_DETAIL_TAB", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("SQ_DRAFT_DETAIL_TAB", "KEY", dataKey).keySet()) {
			String sLiNo = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "LI No.");
			String sItemType = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Item Type");
			String sItemCode = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Item Code");
			String sQty = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Qty");
			String sUnit = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Unit");
			String sSupplier = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Supplier");
			String sCcy = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Ccy");
			String sUnitCost = SessionData.getDataTbVal("SQ_DRAFT_DETAIL_TAB", row, "Unit Cost");
			SQSteps.click_btn_add_detail();
			int iRowIndex = 0;
			if (!sLiNo.isEmpty()) {
				iRowIndex = SQSteps.get_det_row_by_line_item_no(sLiNo);
			} else {
				break;
			}
			if (!sItemType.isEmpty()) {
				SQSteps.select_det_item_type(iRowIndex, sItemType);
			}
			if (!sItemCode.isEmpty()) {
				SQSteps.enter_det_item_code(iRowIndex, sItemCode);
			}
			if (!sQty.isEmpty()) {
				SQSteps.enter_det_qty(iRowIndex, sQty);
			}
			if (!sUnit.isEmpty()) {
				SQSteps.enter_det_unit(iRowIndex, sUnit);
			}
			if (!sSupplier.isEmpty()) {
				SQSteps.enter_det_supplier(iRowIndex, sSupplier);
			}
			if (!sCcy.isEmpty()) {
				SQSteps.select_det_ccy(iRowIndex, sCcy);
			}
			if (!sUnitCost.isEmpty()) {
				SQSteps.enter_det_unit_cost(iRowIndex, sUnitCost);
			}
		}
	}

	@Then("^user generates SQ report in Draft stage of Sales Quotation$")
	public void user_generates_SQ_report_in_Draft_stage_of_Sales_Quotation(List<List<String>> dataTable)
			throws Throwable {
		String sCurrentWindow = SQSteps.getCurrentWindowHandle();
		SQSteps.click_btn_preview_sales_quotation_detail();
		if (SQSteps.switch_to_preview_report_window()) {
			assertTrue("Preview content is not correct.", SQSteps.verify_preview_report_content("Sales Quotation"));
			SQSteps.getDriver().close();
			SQSteps.switchToWindowHandle(sCurrentWindow);
		} else {
			SQSteps.switchToWindowHandle(sCurrentWindow);
			fail("***** ERROR ***** Report window not display.");
		}
	}

	@Then("^user previews Reports in Sales Quotation as \"([^\"]*)\"$")
	public void user_previews_Reports_in_Sales_Quotation_as(String dataKey, List<List<String>> dataTable)
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
			String sCurrentWindow = SQSteps.getCurrentWindowHandle();
			SQSteps.click_btn_preview_sales_quotation_detail();
			boolean isDisplaySelectReport = SQSteps.is_display_reports_selection();
			if (!sReportTitle.isEmpty()) {
				assertTrue("Report Selection Panel does not display.", isDisplaySelectReport);
				SQSteps.open_report_by_report_title(sReportTitle);
			} else {
				assertTrue("Report Selection Panel displays.", !isDisplaySelectReport);
			}
			if (SQSteps.switch_to_preview_report_window()) {
				if (!sContents.isEmpty()) {
					assertTrue("Preview content is not correct.", SQSteps.verify_preview_report_content(sContents));
				}
				if (!sChecksum.isEmpty()) {
					int iChecksum = 0;
					try {
						iChecksum = Integer.parseInt(sChecksum);
					} catch (Exception e) {
						fail("***** ERROR ***** Recheck input data.Checksum must be an interger : " + sChecksum
								+ ". Error: " + e.getMessage());
					}
					int iRet = SQSteps.count_text_sections_in_report();
					assertTrue("Checksum is not correct. Expected : " + iChecksum + " Actual: " + iRet,
							iRet == iChecksum);
				}
				SQSteps.getDriver().close();
				SQSteps.switchToWindowHandle(sCurrentWindow);
			} else {
				SQSteps.switchToWindowHandle(sCurrentWindow);
				fail("***** ERROR ***** Report window not display.");
			}
		}
	}

	@Then("^user submits created Sales Quotation in Draft stage of Sales Quotation$")
	public void user_submits_created_Sales_Quotation_in_Draft_stage_of_Sales_Quotation() throws Throwable {
		SQSteps.submit_sales_quotation_detail();
	}

	@Then("^user opens created Sales Quotation in Outstanding state of Sales Quotation Summary$")
	public void user_opens_created_Sales_Quotation_in_Outstanding_state_of_Sales_Quotation_Summary() throws Throwable {
		SQSteps.switch_to_tab_outstanding();
		SQSteps.filter_by_sales_quotation_no(SessionData.getListStringLastValue(SQ_NO));
		SQSteps.open_first_sales_quotation_no();
	}

	@Then("^user confirm created Sales Quotation in Outstanding state of Sales Quotation Summary$")
	public void user_confirm_created_Sales_Quotation_in_Outstanding_state_of_Sales_Quotation_Summary()
			throws Throwable {
		SQSteps.click_btn_confirm();
		SQSteps.clickBtnYesOnConfirmConfirm();
		SessionData.addToListString(SO_NO, SQSteps.get_sales_order_no_info_panel());
		SQSteps.click_btn_ok_confirm_infor_panel();
		SQSteps.sales_order_no(SessionData.getListStringLastValue(SO_NO).toString());
	}

	@Then("^user opens created Sales Quotation in History state of Sales Quotation Summary$")
	public void user_opens_created_Sales_Quotation_in_History_state_of_Sales_Quotation_Summary() throws Throwable {
		SQSteps.switch_to_tab_history();
		SQSteps.filter_by_sales_quotation_no(SessionData.getListStringLastValue(SQ_NO));
		SQSteps.open_first_sales_quotation_no();
	}
}
