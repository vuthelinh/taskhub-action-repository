package com.synergix.processing.generalledger;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.generalledger.steps.GLGenerateVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class GLGenerateVchDefs {
	@Steps
	GLGenerateVchSteps onGLGenerateVchSteps;

	@When("^user generate GL recurring voucher as \"([^\"]*)\"$")
	public void user_generate_GL_recurring_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "GLGen";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colGenerationDateFrom = "Generation Date From";
		String colGenerationDateTo = "Generation Date To";
		String colRecurringVchCodeFrom = "Recurring Vch Code From";
		String colRecurringVchCodeTo = "Recurring Vch Code To";

		for (int rowGLGen : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String generationDateFrom = SessionData.getDataTbVal(dataTableKey,
					rowGLGen, colGenerationDateFrom);
			String generationDateTo = SessionData.getDataTbVal(dataTableKey,
					rowGLGen, colGenerationDateTo);
			String recurringVchCodeFrom = SessionData.getDataTbVal(
					dataTableKey, rowGLGen, colRecurringVchCodeFrom);
			String recurringVchCodeTo = SessionData.getDataTbVal(dataTableKey,
					rowGLGen, colRecurringVchCodeTo);

			if (!generationDateFrom.isEmpty()) {
				onGLGenerateVchSteps.typeGenerationDateFrom(generationDateFrom);
			}
			if (!generationDateTo.isEmpty()) {
				onGLGenerateVchSteps.typeGenerationDateTo(generationDateTo);
			}
			if (!recurringVchCodeFrom.isEmpty()) {
				onGLGenerateVchSteps
						.typeRecurringVchCodeFrom(recurringVchCodeFrom);
			}
			if (!recurringVchCodeTo.isEmpty()) {
				onGLGenerateVchSteps.typeRecurringVchCodeTo(recurringVchCodeTo);
			}

			onGLGenerateVchSteps.clickOnGenerateBtn();
			onGLGenerateVchSteps.clickAndSubmitVchNo();
		}
	}
}
