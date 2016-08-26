package com.synergix.processing.fixedasset;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.fixedasset.steps.FADepreciationVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class FADepreciationVchDefs {
	@Steps
	FADepreciationVchSteps onFADepreciationVchSteps;

	@When("^user submit depreciation voucher as \"([^\"]*)\"$")
	public void user_submit_depreciation_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FADepreciation";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colVoucherNo = "Voucher No.";

		for (int rowFADepreciation : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String voucherNo = SessionData.getDataTbVal(dataTableKey,
					rowFADepreciation, colVoucherNo);
			if (!voucherNo.isEmpty()) {
				onFADepreciationVchSteps.searchDraftVchAndSubmit(voucherNo);
			}
		}
	}

	@When("^user submit all depreciation voucher$")
	public void user_submit_all_depreciation_voucher() {
		onFADepreciationVchSteps.chooseAllVch();
		onFADepreciationVchSteps.clickOnSubmitBtn();
	}
}
