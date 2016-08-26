package com.synergix.processing.fixedasset;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.fixedasset.steps.FAHoldingSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class FAHoldingDefs {
	@Steps
	FAHoldingSteps onFAHoldingSteps;

	@When("^user submit FA holding as \"([^\"]*)\"$")
	public void user_submit_FA_holding_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FAHolding";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colAssetVoucherNo = "Asset Voucher No";
		String colCreateAPCN = "Create AP CN";

		for (int rowFAHolding : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String assetVoucherNo = SessionData.getDataTbVal(dataTableKey,
					rowFAHolding, colAssetVoucherNo);
			String createAPCN = SessionData.getDataTbVal(dataTableKey,
					rowFAHolding, colCreateAPCN);

			if (!assetVoucherNo.isEmpty()) {
				onFAHoldingSteps.searchDraftAssetVoucherNo(assetVoucherNo);
			}
			if (createAPCN.toLowerCase().equals("y")) {
				onFAHoldingSteps.chooseCreateAPCN();
			}
		}
	}

	@When("^FA holding is added asset details as \"([^\"]*)\"$")
	public void FA_holding_is_added_asset_details_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FAHoldingDet";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colAssetSerialNo = "Asset Serial No";
		String colLocation = "Location";

		int rowIndex = 1;

		for (int rowFAHoldingDet : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String assetSerialNo = SessionData.getDataTbVal(dataTableKey,
					rowFAHoldingDet, colAssetSerialNo);
			String location = SessionData.getDataTbVal(dataTableKey,
					rowFAHoldingDet, colLocation);

			if (!assetSerialNo.isEmpty()) {
				onFAHoldingSteps.typeAssetSerialNo(assetSerialNo, rowIndex);
			}
			if (!location.isEmpty()) {
				onFAHoldingSteps.typeLocation(location, rowIndex);
			}
			rowIndex = rowIndex + 1;
		}
	}

	@When("^FA Holding is submitted$")
	public void FA_Holding_is_submitted() {
		onFAHoldingSteps.clickOnSubmitBtn();
	}
}
