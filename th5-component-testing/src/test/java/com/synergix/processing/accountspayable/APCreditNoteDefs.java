package com.synergix.processing.accountspayable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountspayable.steps.APCreditNoteSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class APCreditNoteDefs {
	@Steps
	APCreditNoteSteps onAPCreditNoteSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	private String ssCrnNo = "CrnNo";

	@When("^user create AP credit note as \"([^\"]*)\"$")
	public void user_create_AP_credit_note_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APCreditNote";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYAPCRN = "KEY AP CRN";
		String colCrnNo = "Crn No.";
		String colSupplier = "Supplier";
		String colCurrency = "Currency";
		String colPostingDate = "Posting Date";
		String colSupplierCreditNoteNo = "Supplier Credit Note No";
		String colCreditNoteCategory = "Credit Note Category";
		String colSalesTax = "Sales Tax";
		String colLocation = "Location";
		String colSupplierCreditNoteDate = "Supplier Credit Note Date";
		String colDefaultDisc = "Default Disc %";
		String colReferenceNo = "Reference No.";
		String colCreditNoteJustification = "Credit Note Justification";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowAPCreditNote : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEYAPCRN, dataKey).keySet()) {
			String kEYAPCRN = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colKEYAPCRN);
			String crnNo = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colCrnNo);
			String supplier = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSupplier);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colCurrency);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colPostingDate);
			String supplierCreditNoteNo = SessionData.getDataTbVal(
					dataTableKey, rowAPCreditNote, colSupplierCreditNoteNo);
			String creditNoteCategory = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colCreditNoteCategory);
			String salesTax = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSalesTax);
			String location = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colLocation);
			String supplierCreditNoteDate = SessionData.getDataTbVal(
					dataTableKey, rowAPCreditNote, colSupplierCreditNoteDate);
			String defaultDisc = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colDefaultDisc);
			String referenceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colReferenceNo);
			String creditNoteJustification = SessionData.getDataTbVal(
					dataTableKey, rowAPCreditNote, colCreditNoteJustification);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment4);

			if (!supplier.isEmpty()) {
				onAPCreditNoteSteps.clickOnNewBtn();
				onAPCreditNoteSteps.typeSupplier(supplier);

				onAPCreditNoteSteps.moveToHeaderTab();

				if (!currency.isEmpty()) {
					onAPCreditNoteSteps.typeCurrency(currency);
				}
				if (!postingDate.isEmpty()) {
					onAPCreditNoteSteps.typePostingDate(postingDate);
				}
				if (!supplierCreditNoteNo.isEmpty()) {
					onAPCreditNoteSteps
							.typeSupplierCreditNoteNo(supplierCreditNoteNo);
				}
				if (!creditNoteCategory.isEmpty()) {
					onAPCreditNoteSteps
							.typeCreditNoteCategory(creditNoteCategory);
				}
				if (!salesTax.isEmpty()) {
					onAPCreditNoteSteps.typeSalesTax(salesTax);
				}
				if (!location.isEmpty()) {
					onAPCreditNoteSteps.typeLocation(location);
				}
				if (!supplierCreditNoteDate.isEmpty()) {
					onAPCreditNoteSteps
							.typeSupplierCreditNoteDate(supplierCreditNoteDate);
				}
				if (!defaultDisc.isEmpty()) {
					onAPCreditNoteSteps.typeDefaultDisc(defaultDisc);
				}
				if (!referenceNo.isEmpty()) {
					onAPCreditNoteSteps.typeReferenceNo(referenceNo);
				}
				if (!creditNoteJustification.isEmpty()) {
					onAPCreditNoteSteps
							.typeCreditNoteJustification(creditNoteJustification);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPCreditNoteSteps.setSegment(listSegment);

				isContinue = true;
				isUpdate = false;

				onAPCreditNoteSteps.getCrnNo(ssCrnNo);
			}
		}

	}

	@When("^user update AP credit note as \"([^\"]*)\"$")
	public void user_update_AP_credit_note_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "APCreditNote";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYAPCRN = "KEY AP CRN";
		String colCrnNo = "Crn No.";
		String colSupplier = "Supplier";
		String colCurrency = "Currency";
		String colPostingDate = "Posting Date";
		String colSupplierCreditNoteNo = "Supplier Credit Note No";
		String colCreditNoteCategory = "Credit Note Category";
		String colSalesTax = "Sales Tax";
		String colLocation = "Location";
		String colSupplierCreditNoteDate = "Supplier Credit Note Date";
		String colDefaultDisc = "Default Disc %";
		String colReferenceNo = "Reference No.";
		String colCreditNoteJustification = "Credit Note Justification";
		String colSegment1 = "Segment 1";
		String colSegment2 = "Segment 2";
		String colSegment3 = "Segment 3";
		String colSegment4 = "Segment 4";

		for (int rowAPCreditNote : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEYAPCRN, dataKey).keySet()) {
			String kEYAPCRN = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colKEYAPCRN);
			String crnNo = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colCrnNo);
			String supplier = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSupplier);
			String currency = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colCurrency);
			String postingDate = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colPostingDate);
			String supplierCreditNoteNo = SessionData.getDataTbVal(
					dataTableKey, rowAPCreditNote, colSupplierCreditNoteNo);
			String creditNoteCategory = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colCreditNoteCategory);
			String salesTax = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSalesTax);
			String location = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colLocation);
			String supplierCreditNoteDate = SessionData.getDataTbVal(
					dataTableKey, rowAPCreditNote, colSupplierCreditNoteDate);
			String defaultDisc = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colDefaultDisc);
			String referenceNo = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colReferenceNo);
			String creditNoteJustification = SessionData.getDataTbVal(
					dataTableKey, rowAPCreditNote, colCreditNoteJustification);
			String segment1 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment1);
			String segment2 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment2);
			String segment3 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment3);
			String segment4 = SessionData.getDataTbVal(dataTableKey,
					rowAPCreditNote, colSegment4);

			if (onAPCreditNoteSteps.searchDrafCrnNo(crnNo)) {
				if (!supplier.isEmpty()) {
					onAPCreditNoteSteps.typeSupplier(supplier);
				}
				onAPCreditNoteSteps.moveToHeaderTab();

				if (!currency.isEmpty()) {
					onAPCreditNoteSteps.typeCurrency(currency);
				}
				if (!postingDate.isEmpty()) {
					onAPCreditNoteSteps.typePostingDate(postingDate);
				}
				if (!supplierCreditNoteNo.isEmpty()) {
					onAPCreditNoteSteps
							.typeSupplierCreditNoteNo(supplierCreditNoteNo);
				}
				if (!creditNoteCategory.isEmpty()) {
					onAPCreditNoteSteps
							.typeCreditNoteCategory(creditNoteCategory);
				}
				if (!salesTax.isEmpty()) {
					onAPCreditNoteSteps.typeSalesTax(salesTax);
				}
				if (!location.isEmpty()) {
					onAPCreditNoteSteps.typeLocation(location);
				}
				if (!supplierCreditNoteDate.isEmpty()) {
					onAPCreditNoteSteps
							.typeSupplierCreditNoteDate(supplierCreditNoteDate);
				}
				if (!defaultDisc.isEmpty()) {
					onAPCreditNoteSteps.typeDefaultDisc(defaultDisc);
				}
				if (!referenceNo.isEmpty()) {
					onAPCreditNoteSteps.typeReferenceNo(referenceNo);
				}
				if (!creditNoteJustification.isEmpty()) {
					onAPCreditNoteSteps
							.typeCreditNoteJustification(creditNoteJustification);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPCreditNoteSteps.setSegment(listSegment);

				onAPCreditNoteSteps.getCrnNo(ssCrnNo);

				isContinue = true;
				isUpdate = true;
			}
		}

	}

	@When("^AP credit note is added detail as \"([^\"]*)\"$")
	public void AP_credit_note_is_added_detail_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APCreditNoteDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYAPCRN = "KEY AP CRN";
			String colLINo = "LI No.";
			String colType = "Type";
			String colItemCode = "Item Code";
			String colRemarks = "Remarks Description";
			String colQtyUOM = "Qty UOM";
			String colPackSize = "Pack Size No. Of Packs";
			String colCostType = "Cost Type";
			String colUnitCost = "Unit Cost";
			String colDiscount = "Discount %";
			String colAmount = "Amount";
			String colSalestax = "Sales tax";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colSerialNo = "Serial No";
			String colDelete = "Delete";
			String colDel = "Del";

			int rowIndex = onAPCreditNoteSteps.countRowDetailTb();

			for (int rowAPCreditNoteDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYAPCRN,
							dataKey).keySet()) {
				String lINo = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colLINo);
				String type = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colType);
				String itemCode = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colItemCode);
				String remarks = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colRemarks);
				String qtyUOM = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colQtyUOM);
				String packSize = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colPackSize);
				String costType = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colCostType);
				String unitCost = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colUnitCost);
				String discountAmount = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colDiscount);
				String amount = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colAmount);
				String salestax = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colSalestax);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colSegment4);
				String serialNo = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colSerialNo);
				String delete = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colDelete);
				String del = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteDetail, colDel);

				onAPCreditNoteSteps.clickOnAddBtn();
				rowIndex += 1;

				if (!type.isEmpty()) {
					onAPCreditNoteSteps.chooseType(type, rowIndex);
				}
				if (!itemCode.isEmpty()) {
					onAPCreditNoteSteps.typeItemCode(itemCode, rowIndex);
				}
				if (!remarks.isEmpty()) {
					onAPCreditNoteSteps.typeRemarks(remarks, rowIndex);
				}
				if (!qtyUOM.isEmpty()) {
					onAPCreditNoteSteps.typeQtyUOM(qtyUOM, rowIndex);
				}
				if (!packSize.isEmpty()) {
					onAPCreditNoteSteps.typePackSize(packSize, rowIndex);
				}
				if (!costType.isEmpty()) {
					onAPCreditNoteSteps.chooseCostType(costType, rowIndex);
				}
				if (!unitCost.isEmpty()) {
					onAPCreditNoteSteps.typeUnitCost(unitCost, rowIndex);
				}
				if (!discountAmount.isEmpty()) {
					onAPCreditNoteSteps.typeDiscount(discountAmount, rowIndex);
				}
				if (!amount.isEmpty()) {
					onAPCreditNoteSteps.typeAmount(amount, rowIndex);
				}
				if (!salestax.isEmpty()) {
					onAPCreditNoteSteps.typeSalestax(salestax, rowIndex);
				}

				List<String> listSegment = new ArrayList<String>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPCreditNoteSteps.setSegment(listSegment, rowIndex);

				if (!serialNo.isEmpty()) {
					onAPCreditNoteSteps.chooseSerialNo(serialNo, rowIndex);
				}
				if (delete.toLowerCase().equals("y")
						|| delete.toLowerCase().equals("yes")) {
					onAPCreditNoteSteps.chooseDelete(rowIndex);
					rowIndex = rowIndex - 1;
				}
				if (del.toLowerCase().equals("y")
						|| del.toLowerCase().equals("yes")) {
					onAPCreditNoteSteps.chooseDel(rowIndex);
					rowIndex = rowIndex - 1;
				}
			}
		}
	}

	@When("^AP credit note is add detail with allocation as \"([^\"]*)\"$")
	public void AP_credit_note_is_add_detail_with_allocation_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APCreditNoteAlloc";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYAPCRN = "KEY AP CRN";
			String colLIno = "LI no.";
			String colSegment1 = "Segment 1";
			String colSegment2 = "Segment 2";
			String colSegment3 = "Segment 3";
			String colSegment4 = "Segment 4";
			String colType = "Type";
			String colVoucherNo = "Voucher No.";
			String colQty = "Qty";
			String colDelete = "Delete";
			String colSel = "Sel";

			int rowIndex = onAPCreditNoteSteps.countRowAllocTb();

			for (int rowAPCreditNoteAlloc : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYAPCRN,
							dataKey).keySet()) {
				String lIno = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colLIno);
				String segment1 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colSegment1);
				String segment2 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colSegment2);
				String segment3 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colSegment3);
				String segment4 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colSegment4);
				String type = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colType);
				String voucherNo = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colVoucherNo);
				String qty = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colQty);
				String delete = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colDelete);
				String sel = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteAlloc, colSel);

				if (!lIno.isEmpty()) {
					onAPCreditNoteSteps.chooseLIno(lIno);
				}

				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3,
						segment4));
				onAPCreditNoteSteps.setSegmentAlloc(listSegment);

				onAPCreditNoteSteps.clickOnAddAllocBtn();

				rowIndex++;

				if (!type.isEmpty()) {
					onAPCreditNoteSteps.chooseTypeAlloc(type, rowIndex);
				}
				if (!voucherNo.isEmpty()) {
					onAPCreditNoteSteps.typeVoucherNo(voucherNo, rowIndex);
				}
				if (!qty.isEmpty()) {
					onAPCreditNoteSteps.typeQty(qty, rowIndex);
				}
				if (delete.toLowerCase().equals("y")
						|| delete.toLowerCase().equals("yes")) {
					onAPCreditNoteSteps.chooseDelete(rowIndex);
					rowIndex = rowIndex - 1;
				}
				if (sel.toLowerCase().equals("y")
						|| sel.toLowerCase().equals("yes")) {
					onAPCreditNoteSteps.chooseSelAlloc(rowIndex);
					rowIndex = rowIndex - 1;
				}
				onAPCreditNoteSteps.clickOnDoneAllocBtn();
			}
		}
	}

	@When("^AP credit note is applied as \"([^\"]*)\"$")
	public void AP_credit_note_is_applied_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APCreditNoteApply";
			SessionData.addDataTable(dataTableKey, dataTable, false);

			String colKEYAPCRN = "KEY AP CRN";
			String colInvNo = "Inv No.";
			String colSupInvNo = "Sup Inv No";
			String colInvDate = "Inv Date";
			String colDueDate = "Due Date";
			String colInvCcyRefNo = "Inv Ccy Ref No.";
			String colApldCrnAmtHomeAmt = "Apld Crn Amt Home Amt";
			String colApldInvAmtHomeAmt = "Apld Inv Amt Home Amt";
			String colCrossRateRealizedExch = "Cross Rate Realized Exch";
			String colApplyFull = "Apply Full";

			for (int rowAPCreditNoteApply : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYAPCRN,
							dataKey).keySet()) {
				String invNo = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colInvNo);
				String supInvNo = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colSupInvNo);
				String invDate = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colInvDate);
				String dueDate = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colDueDate);
				String invCcyRefNo = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colInvCcyRefNo);
				String apldCrnAmtHomeAmt = SessionData.getDataTbVal(
						dataTableKey, rowAPCreditNoteApply,
						colApldCrnAmtHomeAmt);
				String apldInvAmtHomeAmt = SessionData.getDataTbVal(
						dataTableKey, rowAPCreditNoteApply,
						colApldInvAmtHomeAmt);
				String crossRateRealizedExch = SessionData.getDataTbVal(
						dataTableKey, rowAPCreditNoteApply,
						colCrossRateRealizedExch);
				String applyFull = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colApplyFull);

				onAPCreditNoteSteps.moveToApplicationTab();
				if (!invNo.isEmpty()) {
					onAPCreditNoteSteps.typeInvNo(invNo);
				}
				if (!apldCrnAmtHomeAmt.isEmpty()) {
					onAPCreditNoteSteps
							.typeApldCrnAmtHomeAmt(apldCrnAmtHomeAmt);
				}
				if (!apldInvAmtHomeAmt.isEmpty()) {
					onAPCreditNoteSteps
							.typeApldInvAmtHomeAmt(apldInvAmtHomeAmt);
				}
				if (!crossRateRealizedExch.isEmpty()) {
					onAPCreditNoteSteps
							.typeCrossRateRealizedExch(crossRateRealizedExch);
				}
				if (applyFull.toLowerCase().equals("y")
						|| applyFull.toLowerCase().equals("yes")) {
					onAPCreditNoteSteps.chooseApplyFull(applyFull);
				}
			}
		}
	}

	@When("^preview AP credit note$")
	public void preview_AP_credit_note() {
		if (isContinue) {
			onAPCreditNoteSteps.clickOnPreviewBtn();
		}
	}

	@When("^preview AP credit note at history tab$")
	public void preview_AP_credit_note_at_history_tab() {
		if (isContinue) {

			List<String> listCrnNo = new ArrayList<>();
			listCrnNo = Serenity.sessionVariableCalled(ssCrnNo);

			String crnNo = listCrnNo.get(0);

			onAPCreditNoteSteps.clickOnPreviewHSTBtn(crnNo);
		}
	}

	@When("^AP credit note is applied in outstanding tab as \"([^\"]*)\"$")
	public void AP_credit_note_is_applied_in_outstanding_tab_as(String dataKey,
			List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "APCreditNoteApplyOST";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYAPCRN = "KEY AP CRN";
			String colCrnNo = "Crn No.";
			String colApplicationDate = "Application Date";

			List<String> listCrnNo = new ArrayList<>();
			listCrnNo = Serenity.sessionVariableCalled(ssCrnNo);

			String crnNo = listCrnNo.get(0);
			// String crnNo="AP000005CN";

			if (!crnNo.isEmpty()) {
				onAPCreditNoteSteps.gotoOutstandingTab();
				onAPCreditNoteSteps.searchOSTCrnNo(crnNo);
			}

			for (int rowAPCreditNoteApply : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYAPCRN,
							dataKey).keySet()) {
				String crnNo2 = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colCrnNo);
				String applicationDate = SessionData.getDataTbVal(dataTableKey,
						rowAPCreditNoteApply, colApplicationDate);

				if (applicationDate.isEmpty()) {
					applicationDate = onAPCreditNoteSteps.getToday();
				}
				onAPCreditNoteSteps.moveToHeaderTab();
				onAPCreditNoteSteps.typeApplicationDate(applicationDate);
			}
		}
	}

	@When("^submit AP credit note$")
	public void submit_AP_credit_note() {
		if (isContinue) {
			onAPCreditNoteSteps.clickOnSubmitBtn();
		}
	}
}
