package com.synergix.definition.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.synergix.processing.purchase.purchaserequisition.steps.CombinePRSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CombinePRDefs {
	private final static String PR_NO = "Purchase Requisition No";
	private final static String PO_NO = "Purchase Order No";
	private final static String LIST_PO_NO = "LIST Purchase Order No";
	@Steps
	CombinePRSteps combinePRSteps;

	@Then("^user selects No of PR Pending To Generate PO in Combine PR as as \"([^\"]*)\"$")
	public void user_selects_No_of_PR_Pending_To_Generate_PO_in_Combine_PR_as_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("COMBINE_PR_NO_OF_PENDING", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("COMBINE_PR_NO_OF_PENDING", "KEY", dataKey).keySet()) {
			String sSupplierCode = SessionData.getDataTbVal("COMBINE_PR_NO_OF_PENDING", row, "Supplier Code");
			String sSupplierName = SessionData.getDataTbVal("COMBINE_PR_NO_OF_PENDING", row, "Supplier Name");
			String sCurency = SessionData.getDataTbVal("COMBINE_PR_NO_OF_PENDING", row, "Curency");
			if (!sSupplierCode.isEmpty()) {
				combinePRSteps.filter_by_supplier_code(sSupplierCode);
			}
			if (!sSupplierName.isEmpty()) {
				combinePRSteps.filter_by_supplier_name(sSupplierName);
			}
			if (!sCurency.isEmpty()) {
				combinePRSteps.filter_by_currency(sCurency);
			}
			if (!sSupplierCode.isEmpty() || !sSupplierName.isEmpty()) {
				combinePRSteps.click_on_no_of_pr_pending_to_generate_po(1);
			}
		}
	}

	@Then("^user selects Group PRs to generate PO in Combine PR as \"([^\"]*)\"$")
	public void user_selects_Group_PRs_to_generate_PO_in_Combine_PR_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("COMBINE_PR_GROUP_PR", dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("COMBINE_PR_GROUP_PR", "KEY", dataKey).keySet()) {
			String sShipmentMode = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row, "Shipment Mode");
			String sShipmentTerm = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row, "Shipment Term");
			String sLoading = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row, "Loading");
			String sDischarge = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row, "Discharge");
			String sFinalDest = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row, "Final Dest");
			String sDefaultShipToLocation = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row,
					"Default ship to Location");
			String sSbu = SessionData.getDataTbVal("COMBINE_PR_GROUP_PR", row, "SBU");
			String sTempSearchPatterm = "";
			if (!sShipmentMode.isEmpty()) {
				sTempSearchPatterm += sShipmentMode + " ";
			}
			if (!sShipmentTerm.isEmpty()) {
				sTempSearchPatterm += sShipmentTerm + " ";
			}
			if (!sLoading.isEmpty()) {
				sTempSearchPatterm += sLoading + " ";
			}
			if (!sDischarge.isEmpty()) {
				sTempSearchPatterm += sDischarge + " ";
			}
			if (!sFinalDest.isEmpty()) {
				sTempSearchPatterm += sFinalDest + " ";
			}
			if (!sDefaultShipToLocation.isEmpty()) {
				sTempSearchPatterm += sDefaultShipToLocation + " ";
			}
			if (!sSbu.isEmpty()) {
				sTempSearchPatterm += sSbu;
			}
			combinePRSteps.select_group_prs_row_index_by_any_text(sTempSearchPatterm);
		}
	}

	@Then("^user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR$")
	public void user_selects_and_submits_created_Purchase_Requisition_in_Purchase_Requisition_of_Combine_PR()
			throws Throwable {
		combinePRSteps.check_checkbox_pr_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		combinePRSteps.click_btn_submit();
		SessionData.addToListString(PO_NO, combinePRSteps.get_purchase_order_no());

		combinePRSteps.purchase_order_no(SessionData.getListStringLastValue(PO_NO).toString());
		combinePRSteps.click_btn_ok_infor_panel_confirm();
	}

	@Then("^user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR then verify kind of PO as \"([^\"]*)\"$")
	public void user_selects_and_submits_created_Purchase_Requisition_in_Purchase_Requisition_of_Combine_PR_then_verify_kind_of_PO_as(
			String dataKey, List<List<String>> dataTable) throws Throwable {
		combinePRSteps.check_checkbox_pr_by_pr_no(SessionData.getListStringLastValue(PR_NO));
		combinePRSteps.click_btn_submit();
		List<String> lPOs = new ArrayList<String>();
		List<String> outlPOs = new ArrayList<String>();
		lPOs = combinePRSteps.get_list_purchase_order_no();
		for (String temp : lPOs) {
			outlPOs.add(temp.replace("Purchase order '", "").replace("' has been generated successfully", "")
					.replace("Outstanding Purchase Order(s) have been generated: ", "")
					.replace("Draft Purchase Order(s) have been generated: ", ""));
		}
		Serenity.setSessionVariable(LIST_PO_NO).to(outlPOs);
		combinePRSteps.purchase_order_no(Serenity.sessionVariableCalled(LIST_PO_NO).toString());
		combinePRSteps.click_btn_ok_infor_panel_confirm();
		SessionData.addDataTable("COMBINE_PR_PO_CREATE", dataTable, false);

		for (int row : SessionData.getDataTbRowsByValEqualInCol("COMBINE_PR_PO_CREATE", "KEY", dataKey).keySet()) {
			String sContains = SessionData.getDataTbVal("COMBINE_PR_PO_CREATE", row, "Contains");
			String sNotContains = SessionData.getDataTbVal("COMBINE_PR_PO_CREATE", row, "Not Contains");
			boolean bVerify = false;
			if (!sContains.isEmpty()) {
				for (String temp : lPOs) {
					if (temp.contains(sContains)) {
						bVerify = true;
						System.out.println("Created Purchase Order list contains: " + sContains);
					}
				}
				assertTrue("Verify kind of created Purchase Order(s) contains: " + sContains, bVerify);
			}
			if (!sNotContains.isEmpty()) {
				bVerify = true;
				for (String temp : lPOs) {
					if (temp.contains(sNotContains)) {
						System.out.println("Created Purchase Order list contains: " + sContains);
						bVerify = false;
					}
				}
				assertTrue("Verify kind of created Purchase Order(s) not contains: " + sNotContains, bVerify);
			}
		}
	}
}
