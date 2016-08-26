package com.synergix.operations.scm.salesreturn.processing;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.operations.salesreturn.processing.steps.SalesReturnSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SalesReturnDefs {
	@Steps
	SalesReturnSteps saleReturnStep;

	@When("^user creates new sales return:$")
	public void user_creates_new_sales_return(List<List<String>> salesReturnList) throws Throwable {

		SessionData.addDataTable("salesReturnTbl", salesReturnList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("salesReturnTbl");
		for (int row : testData.keySet()) {

			String sReturnRequestDate = SessionData.getDataTbVal("salesReturnTbl", row, "Return Request Date");
			String sCustomerSupport = SessionData.getDataTbVal("salesReturnTbl", row, "Customer Support");
			String sSourceShipmentNo = SessionData.getDataTbVal("salesReturnTbl", row, "Source Shipment No.");

			saleReturnStep.click_btn_new();
			if (!sReturnRequestDate.isEmpty()) {
				saleReturnStep.enter_return_request_date(sReturnRequestDate);
			}
			if (!sCustomerSupport.isEmpty()) {
				saleReturnStep.enter_customer_support(sCustomerSupport);
			}
			if (!sSourceShipmentNo.isEmpty()) {
				saleReturnStep.enter_source_shipment_no(sSourceShipmentNo);
			}

		}

	}

	@When("^user pick Collection Date$")
	public void user_pick_Collection_Date(List<List<String>> shmInfoList) throws Throwable {
		SessionData.addDataTable("shimInfoTbl", shmInfoList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("shimInfoTbl");
		for (int row : testData.keySet()) {
			String sCollectionDate = SessionData.getDataTbVal("shimInfoTbl", row, "Collection Date");
			saleReturnStep.enter_collection_date(sCollectionDate);
		}
	}

	@When("^user chooses Return All in Return Item panel$")
	public void user_chooses_Return_All_in_Return_Item_panel() throws Throwable {
		saleReturnStep.click_btn_returnAll();

	}

	@Then("^user should see information for Header as the following:$")
	public void user_should_see_information_for_Header_as_the_following(List<List<String>> header) throws Throwable {

		SessionData.addDataTable("headerTbl", header);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("headerTbl");
		for (int row : testData.keySet()) {

			String sReturnRequestDate = SessionData.getDataTbVal("headerTbl", row, "Return Request Date");
			String sCustomerSupport = SessionData.getDataTbVal("headerTbl", row, "Customer Support");
			String sSourceShipmentNo = SessionData.getDataTbVal("headerTbl", row, "Source Shipment No");
			String sCustomer = SessionData.getDataTbVal("headerTbl", row, "Customer");

			if (!sReturnRequestDate.isEmpty()) {
				saleReturnStep.verify_returnRequestDate(sReturnRequestDate);
			}
			if (!sCustomerSupport.isEmpty()) {
				saleReturnStep.verify_customer_support(sCustomerSupport);
			}
			if (!sSourceShipmentNo.isEmpty()) {
				saleReturnStep.verify_source_shipment(sSourceShipmentNo);
			}
			if (!sCustomer.isEmpty()) {
				saleReturnStep.verify_customer(sCustomer);
			}
		}
	}

	@Then("^user should see information for Shm Info as the following:$")
	public void user_should_see_information_for_Shm_Info_as_the_following(List<List<String>> shmInfo) throws Throwable {

		SessionData.addDataTable("shmInfoTbl", shmInfo);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("shmInfoTbl");
		for (int row : testData.keySet()) {
			String sSourceDoNo = SessionData.getDataTbVal("shmInfoTbl", row, "Source DO No.");
			String sSourceSoNo = SessionData.getDataTbVal("shmInfoTbl", row, "Source SO No.");
			String sCustomerPoNo = SessionData.getDataTbVal("shmInfoTbl", row, "Customer PO No.");
			String sSalesperson = SessionData.getDataTbVal("shmInfoTbl", row, "Salesperson");
			String sShipToAddress = SessionData.getDataTbVal("shmInfoTbl", row, "Ship To Address");
			String sShipToContact = SessionData.getDataTbVal("shmInfoTbl", row, "Ship To Contact");
			String sActualShipmentDate = SessionData.getDataTbVal("shmInfoTbl", row, "Actual Shipment Date");
			String sLoadingLocation = SessionData.getDataTbVal("shmInfoTbl", row, "Loading Location");
			String sCollectionAddress = SessionData.getDataTbVal("shmInfoTbl", row, "Collection Address");
			String sCollectionContact = SessionData.getDataTbVal("shmInfoTbl", row, "Collection Contact");
			String sCollectionDate = SessionData.getDataTbVal("shmInfoTbl", row, "Collection Date");
			if (!sSourceDoNo.isEmpty()) {
				saleReturnStep.verify_sourceDO(sSourceDoNo);
			}
			if (!sSourceSoNo.isEmpty()) {
				saleReturnStep.verify_sourceSO(sSourceSoNo);
			}
			if (!sCustomerPoNo.isEmpty()) {
				saleReturnStep.verify_customerPO(sCustomerPoNo);
			}
			if (!sSalesperson.isEmpty()) {
				saleReturnStep.verify_salesperson(sSalesperson);
			}
			if (!sShipToAddress.isEmpty()) {
				saleReturnStep.verify_shipToAddress(sShipToAddress);
			}
			if (!sShipToContact.isEmpty()) {
				saleReturnStep.verify_shipToContact(sShipToContact);
			}
			if (!sActualShipmentDate.isEmpty()) {
				saleReturnStep.verify_actualDate(sActualShipmentDate);
			}
			if (!sLoadingLocation.isEmpty()) {
				saleReturnStep.verify_loadingLocation(sLoadingLocation);
			}
			if (!sCollectionAddress.isEmpty()) {
				saleReturnStep.verify_collectionAdd(sCollectionAddress);
			}
			if (!sCollectionContact.isEmpty()) {
				saleReturnStep.verify_collectionCon(sCollectionContact);
			}
			if (!sCollectionDate.isEmpty()) {
				saleReturnStep.verify_collectionDate(sCollectionDate);
			}
		}
	}

	@Then("^user should see Return Qty information as the following:$")
	public void user_should_see_Return_Qty_information_as_the_following(List<List<String>> qtyList) throws Throwable {

		SessionData.addDataTable("qtyTbl", qtyList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("qtyTbl");
		for (int row : testData.keySet()) {
			String sReturnQty = SessionData.getDataTbVal("qtyTbl", row, "Return Qty");
			if (!sReturnQty.isEmpty()) {
				saleReturnStep.verify_returnQty(sReturnQty);
			}
		}
	}

	@Then("^user should see information at Remarks panel as the following:$")
	public void user_should_see_information_at_Remarks_panel_as_the_following(List<List<String>> remarksList)
			throws Throwable {
		SessionData.addDataTable("remarkTbl", remarksList);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("remarkTbl");
		for (int row : testData.keySet()) {
			String sInternalReMarks = SessionData.getDataTbVal("remarkTbl", row, "Internal Remarks");
			String sExternalReMarks = SessionData.getDataTbVal("remarkTbl", row, "External Remarks");
			if (!sInternalReMarks.isEmpty()) {
				saleReturnStep.verify_internalRM(sInternalReMarks);

			}
			if (!sExternalReMarks.isEmpty()) {
				saleReturnStep.verify_externalRM(sExternalReMarks);
			}
		}
	}

	@Then("^user delete this Sales Return\\.$")
	public void user_delete_this_Sales_Return(List<List<String>> salesReturnLst) throws Throwable {
		SessionData.addDataTable("salesRTbl", salesReturnLst);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsNoHeader("salesRTbl");
		for (int row : testData.keySet()) {

			String sCode = SessionData.getDataTbVal("salesRTbl", row, "Sales Return No.");
			String getCode = saleReturnStep.get_text_code(sCode);
			saleReturnStep.click_btn_back_to_summary();
			saleReturnStep.filter_data(getCode);
			saleReturnStep.click_btn_abort();
			saleReturnStep.verify_drawing_object_not_found(getCode);
		}
	}

}
