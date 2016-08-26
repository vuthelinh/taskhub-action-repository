package com.synergix.definition.test;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.purchase.purchaseorder.steps.PurchaseOrderPurgingSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class PurchaseOrderPurgingDefs {
	private final static String PO_NO = "Purchase Order No";
	private final static String PR_NO = "Purchase Requisition No";

	@Steps
	PurchaseOrderPurgingSteps pOPSteps;

	@Given("^user purger Purchase Order as \"([^\"]*)\"$")
	public void user_purger_Purchase_Order_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("PURCHASE_ORDER_PURGING", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("PURCHASE_ORDER_PURGING", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row, "KEY");
			String sPurchaseOrderNoFrom = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row,
					"Purchase Order No. From");
			String sPurchaseOrderNoTo = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row,
					"Purchase Order No. To");
			String sOrderDateFrom = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row, "Order Date From");
			String sOrderDateTo = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row, "Order Date To");
			String sSupplierCodeFrom = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row, "Supplier Code From");
			String sSupplierCodeTo = SessionData.getDataTbVal("PURCHASE_ORDER_PURGING", row, "Supplier Code To");
			if (!sKey.isEmpty()) {
			}
			if (!sPurchaseOrderNoFrom.isEmpty()) {
				if (sPurchaseOrderNoFrom.toLowerCase().equals("@last purchase order no@")) {
					sPurchaseOrderNoFrom = SessionData.getListStringLastValue(PO_NO);
				}
				pOPSteps.enter_purchase_order_no_from(sPurchaseOrderNoFrom);
			}
			if (!sPurchaseOrderNoTo.isEmpty()) {
				if (sPurchaseOrderNoTo.toLowerCase().equals("@last purchase order no@")) {
					sPurchaseOrderNoTo = SessionData.getListStringLastValue(PO_NO);
				}
				pOPSteps.enter_purchase_order_no_to(sPurchaseOrderNoTo);
			}
			if (!sOrderDateFrom.isEmpty()) {
				pOPSteps.enter_order_date_from(sOrderDateFrom);
			}
			if (!sOrderDateTo.isEmpty()) {
				pOPSteps.enter_order_date_to(sOrderDateTo);
			}
			if (!sSupplierCodeFrom.isEmpty()) {
				pOPSteps.enter_supplier_code_from(sSupplierCodeFrom);
			}
			if (!sSupplierCodeTo.isEmpty()) {
				pOPSteps.enter_supplier_code_to(sSupplierCodeTo);
			}
			pOPSteps.purging();
		}
	}

}
