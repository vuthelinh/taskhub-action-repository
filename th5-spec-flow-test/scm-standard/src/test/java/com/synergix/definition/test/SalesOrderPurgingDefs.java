package com.synergix.definition.test;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.processing.sales.steps.SalesOrderPurgingSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class SalesOrderPurgingDefs {
	private final static String SO_NO = "Sales Order No";
	private final static String PO_NO = "Purchase Order No";

	@Steps
	SalesOrderPurgingSteps sOPSteps;

	@Given("^user purger Sales Order as \"([^\"]*)\"$")
	public void user_purger_Sales_Order_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("SALES_ORDER_PURGING", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("SALES_ORDER_PURGING", "KEY", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "KEY");
			String sSalesOrderNoFrom = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "Sales Order No From");
			String sSalesOrderNoTo = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "Sales Order No To");
			String sOrderDateFrom = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "Order Date From");
			String sOrderDateTo = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "Order Date To");
			String sCustomerCodeFrom = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "Customer Code From");
			String sCustomerCodeTo = SessionData.getDataTbVal("SALES_ORDER_PURGING", row, "Customer Code To");
			if (!sKey.isEmpty()) {
			}
			if (!sSalesOrderNoFrom.isEmpty()) {
				if (sSalesOrderNoFrom.toLowerCase().equals("@last sales order no@")) {
					sSalesOrderNoFrom = SessionData.getListStringLastValue(SO_NO);
				}
				sOPSteps.enter_sales_order_no_from(sSalesOrderNoFrom);
			}
			if (!sSalesOrderNoTo.isEmpty()) {
				if (sSalesOrderNoTo.toLowerCase().equals("@last sales order no@")) {
					sSalesOrderNoTo = SessionData.getListStringLastValue(SO_NO);
				}
				sOPSteps.enter_sales_order_no_to(sSalesOrderNoTo);
			}
			if (!sOrderDateFrom.isEmpty()) {
				sOPSteps.enter_order_date_from(sOrderDateFrom);
			}
			if (!sOrderDateTo.isEmpty()) {
				sOPSteps.enter_order_date_to(sOrderDateTo);
			}
			if (!sCustomerCodeFrom.isEmpty()) {
				sOPSteps.enter_customer_code_from(sCustomerCodeFrom);
			}
			if (!sCustomerCodeTo.isEmpty()) {
				sOPSteps.enter_customer_code_to(sCustomerCodeTo);
			}
			sOPSteps.purging();
		}
	}

}
