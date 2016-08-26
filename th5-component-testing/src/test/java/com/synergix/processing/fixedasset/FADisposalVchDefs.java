package com.synergix.processing.fixedasset;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.fixedasset.steps.FADisposalVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class FADisposalVchDefs {
	@Steps
	FADisposalVchSteps onFADisposalVchSteps;

	@When("^user create FA disposal voucher as \"([^\"]*)\"$")
	public void user_create_FA_disposal_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FADisposalVch";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colFixedAssetCode = "Fixed Asset Code";
		String colDisposalDate = "Disposal Date";
		String colSubject = "Subject";
		String colDescription = "Description";

		for (int rowFADisposalVch : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String fixedAssetCode = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVch, colFixedAssetCode);
			String disposalDate = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVch, colDisposalDate);
			String subject = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVch, colSubject);
			String description = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVch, colDescription);

			onFADisposalVchSteps.clickOnNewBtn();

			if (!fixedAssetCode.isEmpty()) {
				onFADisposalVchSteps.chooseFixedAssetCode(fixedAssetCode);
			}
			if (disposalDate.isEmpty())
				disposalDate = onFADisposalVchSteps.getToday();
			onFADisposalVchSteps.typeDisposalDate(disposalDate);

			if (!subject.isEmpty()) {
				onFADisposalVchSteps.typeSubject(subject);
			}
			if (!description.isEmpty()) {
				onFADisposalVchSteps.typeDescription(description);
			}
		}
	}

	@When("^FA disposal voucher is add details as \"([^\"]*)\"$")
	public void FA_disposal_voucher_is_add_details_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FADisposalVchDet";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colSerialNo = "Serial No";
		String colRemarksDescription = "Remarks Description";
		String colDisposalAmt = "Disposal Amt";
		String colDel = "Del";

		int rowIndex = 0;

		for (int rowFADisposalVchDet : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String serialNo = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVchDet, colSerialNo);
			String remarksDescription = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVchDet, colRemarksDescription);
			String disposalAmt = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVchDet, colDisposalAmt);
			String del = SessionData.getDataTbVal(dataTableKey,
					rowFADisposalVchDet, colDel);

			onFADisposalVchSteps.clickOnAddBtn();
			rowIndex += 1;

			if (!serialNo.isEmpty()) {
				onFADisposalVchSteps.typeSerialNo(serialNo, rowIndex);
			}
			if (!remarksDescription.isEmpty()) {
				onFADisposalVchSteps.typeRemarksDescription(remarksDescription,
						rowIndex);
			}
			if (!disposalAmt.isEmpty()) {
				onFADisposalVchSteps.typeDisposalAmt(disposalAmt, rowIndex);
			}
			if (!del.isEmpty()) {
				onFADisposalVchSteps.chooseDel(rowIndex);
				rowIndex -= 1;
			}
		}
	}

	@When("^FA disposal voucher is submitted$")
	public void FA_disposal_voucher_is_submitted() {
		onFADisposalVchSteps.clickOnSubmitBtn();
	}
}
