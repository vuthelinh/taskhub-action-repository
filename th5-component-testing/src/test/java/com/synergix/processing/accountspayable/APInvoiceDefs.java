package com.synergix.processing.accountspayable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.common.actions.DatasetBase;
import com.synergix.processing.accountspayable.steps.APInvoiceSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APInvoiceDefs extends DatasetBase {
	@Steps
	APInvoiceSteps onAPInvoiceSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssAPInvNo = "APInvNo";

	@When("^user create AP invoice as \"([^\"]*)\"$")
	public void user_create_AP_invoice_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APInvoice";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYAPINV = "KEY AP INV";
		String colSupplier = "Supplier";
		String colCurrency = "Currency";
		String colPostingDate = "Posting Date";
		String colSupplierInvoiceNo = "Supplier Invoice No.";
		String colDiscDate = "Disc Date";
		String colSupplierDONo = "Supplier DO No.";
		String colBillOfLadingNo = "Bill Of Lading No.";
		String colCustomTaxInvoice = "Custom Tax Invoice";
		String colSalesTax = "Sales Tax";
		String colDueDate = "Due Date";
		String colSupplierInvoiceDate = "Supplier Invoice Date";
		String colDefaultDiscount = "Default Discount %";
		String colSupplierDODate = "Supplier DO Date";
		String colImportPermitNo = "Import Permit No.";
		String colReferenceNo = "Reference No.";
		String colInventoryLocation = "Inventory Location";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowAPInvoice : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEYAPINV, dataKey).keySet()) {
			String supplier = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplier);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colCurrency);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colPostingDate);
			String supplierInvoiceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierInvoiceNo);
			String discDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colDiscDate);
			String supplierDONo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierDONo);
			String billOfLadingNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colBillOfLadingNo);
			String customTaxInvoice = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colCustomTaxInvoice);
			String salesTax = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSalesTax);
			String dueDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colDueDate);
			String supplierInvoiceDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierInvoiceDate);
			String defaultDiscount = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colDefaultDiscount);
			String supplierDODate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierDODate);
			String importPermitNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colImportPermitNo);
			String referenceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colReferenceNo);
			String inventoryLocation = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colInventoryLocation);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment4);

			if (!supplier.isEmpty()) {
				onAPInvoiceSteps.clickOnNewBtn();
				onAPInvoiceSteps.typeSupplier(supplier);

				isContinue = true;
				isUpdate = false;

				onAPInvoiceSteps.moveToheadertab();

				if (!currency.isEmpty()) {
					onAPInvoiceSteps.typeCurrency(currency);
				}

				if (!postingDate.isEmpty()) {
					onAPInvoiceSteps.typePostingDate(postingDate);
				}

				if (!salesTax.isEmpty()) {
					onAPInvoiceSteps.typeSalesTax(salesTax);
				}

				if (!supplierInvoiceNo.isEmpty()) {
					onAPInvoiceSteps.typeSupplierInvoiceNo(supplierInvoiceNo);
				}
				if (!discDate.isEmpty()) {
					onAPInvoiceSteps.typeDiscDate(discDate);
				}

				if (!supplierDONo.isEmpty()) {
					onAPInvoiceSteps.typeSupplierDONo(supplierDONo);
				}
				if (!billOfLadingNo.isEmpty()) {
					onAPInvoiceSteps.typeBillOfLadingNo(billOfLadingNo);
				}
				if (!customTaxInvoice.isEmpty()) {
					onAPInvoiceSteps.chooseCustomTaxInvoice(customTaxInvoice);
				}
				if (!dueDate.isEmpty()) {
					onAPInvoiceSteps.typeDueDate(dueDate);
				}
				if (!supplierInvoiceDate.isEmpty()) {
					onAPInvoiceSteps
							.typeSupplierInvoiceDate(supplierInvoiceDate);
				}
				if (!defaultDiscount.isEmpty()) {
					onAPInvoiceSteps.typeDefaultDiscount(defaultDiscount);
				}
				if (!supplierDODate.isEmpty()) {
					onAPInvoiceSteps.typeSupplierDODate(supplierDODate);
				}
				if (!importPermitNo.isEmpty()) {
					onAPInvoiceSteps.typeImportPermitNo(importPermitNo);
				}
				if (!referenceNo.isEmpty()) {
					onAPInvoiceSteps.typeReferenceNo(referenceNo);
				}
				if (!inventoryLocation.isEmpty()) {
					onAPInvoiceSteps.typeInventoryLocation(inventoryLocation);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));

				onAPInvoiceSteps.setSegment(listSegment);

				onAPInvoiceSteps.getAPInvoiceNo(ssAPInvNo);
			}
		}

	}

	@When("^user update AP invoice as \"([^\"]*)\"$")
	public void user_update_AP_invoice_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APInvoice";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYAPINV = "KEY AP INV";
		String colVoucherNo = "Voucher No.";
		String colSupplier = "Supplier";
		String colCurrency = "Currency";
		String colPostingDate = "Posting Date";
		String colSupplierInvoiceNo = "Supplier Invoice No.";
		String colDiscDate = "Disc Date";
		String colSupplierDONo = "Supplier DO No.";
		String colBillOfLadingNo = "Bill Of Lading No.";
		String colCustomTaxInvoice = "Custom Tax Invoice";
		String colSalesTax = "Sales Tax";
		String colDueDate = "Due Date";
		String colSupplierInvoiceDate = "Supplier Invoice Date";
		String colDefaultDiscount = "Default Discount %";
		String colSupplierDODate = "Supplier DO Date";
		String colImportPermitNo = "Import Permit No.";
		String colReferenceNo = "Reference No.";
		String colInventoryLocation = "Inventory Location";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowAPInvoice : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEYAPINV, dataKey).keySet()) {
			String voucherNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colVoucherNo);
			String supplier = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplier);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colCurrency);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colPostingDate);
			String supplierInvoiceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierInvoiceNo);
			String discDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colDiscDate);
			String supplierDONo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierDONo);
			String billOfLadingNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colBillOfLadingNo);
			String customTaxInvoice = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colCustomTaxInvoice);
			String salesTax = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSalesTax);
			String dueDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colDueDate);
			String supplierInvoiceDate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierInvoiceDate);
			String defaultDiscount = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colDefaultDiscount);
			String supplierDODate = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSupplierDODate);
			String importPermitNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colImportPermitNo);
			String referenceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colReferenceNo);
			String inventoryLocation = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colInventoryLocation);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowAPInvoice, colSegment4);

			if (!voucherNo.isEmpty()) {
				if (onAPInvoiceSteps.searchVchNo(voucherNo)) {
					isContinue = true;
					isUpdate = true;
					if (!supplier.isEmpty())
						onAPInvoiceSteps.typeSupplier(supplier);
					onAPInvoiceSteps.moveToheadertab();

					if (!currency.isEmpty()) {
						onAPInvoiceSteps.typeCurrency(currency);
					}
					if (!postingDate.isEmpty()) {
						onAPInvoiceSteps.typePostingDate(postingDate);
					}

					if (!salesTax.isEmpty()) {
						onAPInvoiceSteps.typeSalesTax(salesTax);
					}
					if (!supplierInvoiceNo.isEmpty()) {
						onAPInvoiceSteps
								.typeSupplierInvoiceNo(supplierInvoiceNo);
					}
					if (!discDate.isEmpty()) {
						onAPInvoiceSteps.typeDiscDate(discDate);
					}
					if (!supplierDONo.isEmpty()) {
						onAPInvoiceSteps.typeSupplierDONo(supplierDONo);
					}
					if (!billOfLadingNo.isEmpty()) {
						onAPInvoiceSteps.typeBillOfLadingNo(billOfLadingNo);
					}
					if (!customTaxInvoice.isEmpty()) {
						onAPInvoiceSteps
								.chooseCustomTaxInvoice(customTaxInvoice);
					}
					if (!dueDate.isEmpty()) {
						onAPInvoiceSteps.typeDueDate(dueDate);
					}
					if (!supplierInvoiceDate.isEmpty()) {
						onAPInvoiceSteps
								.typeSupplierInvoiceDate(supplierInvoiceDate);
					}
					if (!defaultDiscount.isEmpty()) {
						onAPInvoiceSteps.typeDefaultDiscount(defaultDiscount);
					}
					if (!supplierDODate.isEmpty()) {
						onAPInvoiceSteps.typeSupplierDODate(supplierDODate);
					}
					if (!importPermitNo.isEmpty()) {
						onAPInvoiceSteps.typeImportPermitNo(importPermitNo);
					}
					if (!referenceNo.isEmpty()) {
						onAPInvoiceSteps.typeReferenceNo(referenceNo);
					}
					if (!inventoryLocation.isEmpty()) {
						onAPInvoiceSteps
								.typeInventoryLocation(inventoryLocation);
					}

					List<String> listSegment = new ArrayList<>();
					listSegment.addAll(Arrays.asList(segment1, segment2,
							segment3, segment4));

					onAPInvoiceSteps.setSegment(listSegment);
					onAPInvoiceSteps.getAPInvoiceNo(ssAPInvNo);
				}
			}
		}

	}

	@When("^AP invoice is added detail header as \"([^\"]*)\"$")
	public void AP_invoice_is_added_detail_header_as(String dataKey,
			List<List<String>> dataTable) {

		onAPInvoiceSteps.moveToheadertab();

		if (isContinue) {
			if (isUpdate) {
				onAPInvoiceSteps.chooseDelAllDetailRow();
			}

			String dataTableKey = "APInvoiceDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYAPINV = "KEY AP INV";
			String colType = "Type";
			String colItemCodeRemarks = "Item Code/Remarks";
			String colQtyUOM = "Qty UOM";
			String colPackSize = "Pack Size";
			String colCostType = "Cost Type";
			String colDiscount = "Discount %";
			String colTotalAmt = "Total Amt";
			String colSalesTax = "Sales Tax";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colDelete = "Delete";
			int rowIndex = 0;

			for (int rowAPInvoiceDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYAPINV,
							dataKey).keySet()) {
				String type = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colType);
				String itemCodeRemarks = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colItemCodeRemarks);
				String qtyUOM = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colQtyUOM);
				String packSize = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colPackSize);
				String costType = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colCostType);
				String discount = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colDiscount);
				String totalAmt = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colTotalAmt);
				String salesTax = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colSalesTax);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colSegment4);
				String delete = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoiceDetail, colDelete);

				onAPInvoiceSteps.clickAddDetail();
				rowIndex += 1;

				System.out.println("***[NANCY]***: ROW INDEX:" + rowIndex);

				if (!type.isEmpty()) {
					onAPInvoiceSteps.typeType(type, rowIndex);
				}
				if (!itemCodeRemarks.isEmpty()) {
					onAPInvoiceSteps.typeItemCodeRemarks(itemCodeRemarks,
							rowIndex);
				}
				if (!qtyUOM.isEmpty()) {
					onAPInvoiceSteps.typeQtyUOM(qtyUOM, rowIndex);
				}
				if (!packSize.isEmpty()) {
					onAPInvoiceSteps.typePackSize(packSize, rowIndex);
				}
				if (!costType.isEmpty()) {
					onAPInvoiceSteps.typeCostType(costType, rowIndex);
				}
				if (!discount.isEmpty()) {
					onAPInvoiceSteps.typeDiscount(discount, rowIndex);
				}
				if (!totalAmt.isEmpty()) {
					onAPInvoiceSteps.typeTotalAmt(totalAmt, rowIndex);
				}
				if (!salesTax.isEmpty()) {
					onAPInvoiceSteps.chooseSalesTax(salesTax, rowIndex);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));

				onAPInvoiceSteps.setSegment(listSegment, rowIndex);

				if (delete.toLowerCase().equals("y")) {
					onAPInvoiceSteps.chooseDelDetailRow(rowIndex);
				}
			}
		}

	}

	@When("^AP invoice is added payment information as \"([^\"]*)\"$")
	public void AP_invoice_is_added_payment_information_as(String dataKey,
			List<List<String>> dataTable) {

		if (isContinue) {
			String dataTableKey = "APInvoicePaymentInfo";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYAPINV = "KEY AP INV";
			String colPaymentOption = "Payment Option";
			String colPaymentTerm = "Payment Term";
			String colPaymentTermTenor = "Payment Term Tenor";
			String colPaymentMethod = "Payment Method";
			String colPaymentAmount = "Payment Amount";
			String colPaymentParty = "Payment Party";
			String colPaymentAddress = "Payment Address";
			String colPaymentContact = "Payment Contact";

			for (int rowAPInvoicePaymentInfo : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYAPINV,
							dataKey).keySet()) {
				String paymentOption = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentOption);
				String paymentTerm = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentTerm);
				String paymentTermTenor = SessionData.getDataTbVal(
						dataTableKey, rowAPInvoicePaymentInfo,
						colPaymentTermTenor);
				String paymentMethod = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentMethod);
				String paymentAmount = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentAmount);
				String paymentParty = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentParty);
				String paymentAddress = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentAddress);
				String paymentContact = SessionData.getDataTbVal(dataTableKey,
						rowAPInvoicePaymentInfo, colPaymentContact);

				onAPInvoiceSteps.moveToPaymentInformation();
				if (!paymentOption.isEmpty()) {
					onAPInvoiceSteps.choosePaymentOption(paymentOption);
				}
				if (!paymentTerm.isEmpty()) {
					onAPInvoiceSteps.choosePaymentTerm(paymentTerm);
				}
				if (!paymentTermTenor.isEmpty()) {
					onAPInvoiceSteps.typePaymentTermTenor(paymentTermTenor);
				}
				if (!paymentMethod.isEmpty()) {
					onAPInvoiceSteps.choosePaymentMethod(paymentMethod);
				}
				if (!paymentAmount.isEmpty()) {
					onAPInvoiceSteps.typePaymentAmount(paymentAmount);
				}
				if (!paymentParty.isEmpty()) {
					onAPInvoiceSteps.typePaymentParty(paymentParty);
				}
				if (!paymentAddress.isEmpty()) {
					onAPInvoiceSteps.typePaymentAddress(paymentAddress);
				}
				if (!paymentContact.isEmpty()) {
					onAPInvoiceSteps.typePaymentContact(paymentContact);
				}
			}
		}

	}

	@When("^AP invoice is submitted$")
	public void AP_invoice_is_submitted() {
		if (isContinue) {
			onAPInvoiceSteps.clickOnSubmitBtn();
		}
	}

	@Then("^user verify AP invoice with SQL1 \"([^\"]*)\" with expected$")
	public void user_verify_AP_invoice_with_SQL1(String sQLStatement,
			List<List<String>> expectedTable) {

		// sQLStatement =
		// "select INVOICE_NO, SUPPLIER_CODE, CURRENCY_CODE, date(AGE_DATE) AGE_DATE, IS_CUSTOM_TAX, TOTAL_DISC_AMT, TOTAL_PRE_TAX_AMT, TOTAL_PRE_TAX_HOME_AMT, TOTAL_SALES_TAX_AMT, TOTAL_SALES_TAX_HOME_AMT, TOTAL_AFTER_TAX_AMT, TOTAL_AFTER_TAX_HOME_AMT from AP_INV_HST_HDR where INVOICE_NO in ('AP000021IN', 'AP000022IN', 'AP000023IN', 'AP000024IN', 'AP000025IN') order by INVOICE_NO";
		// List<String> listInvoiceNo = new ArrayList<String>();
		// listInvoiceNo.addAll(Arrays.asList("AP000021IN", "AP000022IN",
		// "AP000023IN", "AP000024IN", "AP000025IN"));

		// Change SQL Statement
		List<String> listInvoiceNo = onAPInvoiceSteps
				.getDatafromSession(ssAPInvNo);
		for (int i = 1; i <= listInvoiceNo.size(); i++) {
			String regex = "INV0" + i;
			sQLStatement = sQLStatement.replaceAll(regex,
					listInvoiceNo.get(i - 1).trim());
		}
		// Change Expected Result Table

		List<List<String>> outputExpectedTb = new ArrayList<List<String>>();
		outputExpectedTb.add(expectedTable.get(0));

		for (int i = 1; i < expectedTable.size(); i++) {
			List<String> dataRow = expectedTable.get(i);
			List<String> temp = new ArrayList<String>();

			temp.add(listInvoiceNo.get(i - 1));
			temp.addAll(dataRow.subList(1, dataRow.size() - 1));

			outputExpectedTb.add(temp);
		}

		ResultSet rs;
		rs = getResultStatement(sQLStatement);

		List<List<String>> actualTable = new ArrayList<List<String>>();

		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int countColumn = metaData.getColumnCount(); // number of column

			List<String> columnName = new ArrayList<String>();
			for (int i = 1; i <= countColumn; i++) {
				columnName.add(metaData.getColumnLabel(i));
			}

			actualTable.add(columnName);
			while (rs.next()) {
				List<String> resultRow = new ArrayList<String>();
				for (int i = 1; i <= countColumn; i++) {
					resultRow.add(rs.getString(i));
				}
				actualTable.add(resultRow);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		onAPInvoiceSteps.verify("Actual Table", SessionData
				.generateTbDataReport(actualTable).toString());

		if (!compareData(actualTable, outputExpectedTb))
			throw new AssertionError();
	}

	public boolean compareData(List<List<String>> actualTable,
			List<List<String>> expectedTable) {
		boolean result = false;
		int flag = 0;
		for (int i = 1; i < expectedTable.size(); i++) {
			List<String> rowActual = actualTable.get(i);
			List<String> rowExpected = expectedTable.get(i);

			for (int j = 0; j < rowExpected.size(); j++) {
				if (!rowActual.get(j).toUpperCase()
						.equals(rowExpected.get(j).toUpperCase())) {
					flag += 1;
				}
			}
		}
		if (flag > 0)
			result = false;
		else
			result = true;
		return result;
	}
}