package com.synergix.processing.fixedasset;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.processing.fixedasset.steps.FADepreciationVchSteps;
import com.synergix.processing.fixedasset.steps.FAGenerateDepreciationVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class FAGenerateDepreciationDefs {
	@Steps
	FAGenerateDepreciationVchSteps onFAGenerateDepreciationVchSteps;
	@Steps
	MenuNavigationSteps onMenuNavigationSteps;
	@Steps
	FADepreciationVchSteps onFADepreciationVchSteps;

	@When("^user generate depreciation voucher as \"([^\"]*)\"$")
	public void user_generate_depreciation_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FAGen";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colFixedAssetClassFrom = "Fixed Asset Class From";
		String colFixedAssetClassTo = "Fixed Asset Class To";

		for (int rowFAGen : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String fixedAssetClassFrom = SessionData.getDataTbVal(dataTableKey,
					rowFAGen, colFixedAssetClassFrom);
			String fixedAssetClassTo = SessionData.getDataTbVal(dataTableKey,
					rowFAGen, colFixedAssetClassTo);

			if (!fixedAssetClassFrom.isEmpty()) {
				onFAGenerateDepreciationVchSteps
						.typeFixedAssetClassFrom(fixedAssetClassFrom);
			}
			if (!fixedAssetClassTo.isEmpty()) {
				onFAGenerateDepreciationVchSteps
						.typeFixedAssetClassTo(fixedAssetClassTo);
			}
			onFAGenerateDepreciationVchSteps.clickOnGenerateBtn();
			onMenuNavigationSteps
					.user_navigates_to_screen("Processing>Fixed Asset>Depreciation Voucher>[1]");

			onFADepreciationVchSteps.chooseAllVch();
			onFADepreciationVchSteps.clickOnSubmitBtn();
		}
	}
}
