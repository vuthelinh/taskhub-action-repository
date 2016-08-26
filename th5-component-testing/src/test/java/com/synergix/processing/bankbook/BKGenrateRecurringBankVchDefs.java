package com.synergix.processing.bankbook;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.processing.bankbook.steps.BKGenerateRecurringBankVchSteps;
import com.synergix.processing.bankbook.steps.BKTransactionVchSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class BKGenrateRecurringBankVchDefs {
	@Steps
	BKGenerateRecurringBankVchSteps onBKGenerateRecurringBankVchSteps;

	@Steps
	MenuNavigationSteps onMenuNavigationSteps;

	@Steps
	BKTransactionVchSteps onBKTransactionVchSteps;

	boolean isContinue = false;
	boolean isUpdate = false;

	String ssBKGenerate = "BKGenerateVch";

	// DONE
	@When("^user generate recurring bank voucher as \"([^\"]*)\"$")
	public void user_generate_recurring_bank_voucher_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "BKGenerate";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colGenerationDateFrom = "Generation Date From";
		String colGenerationDateTo = "Generation Date To";
		String colRecurringTemplateNoFrom = "Recurring Template No From";
		String colRecurringTemplateNoTo = "Recurring Template No To";

		for (int rowBKGenerate : SessionData.getDataTbRowsByValEqualInCol(
				dataTableKey, colKEY, dataKey).keySet()) {
			String generationDateFrom = SessionData.getDataTbVal(dataTableKey,
					rowBKGenerate, colGenerationDateFrom);
			String generationDateTo = SessionData.getDataTbVal(dataTableKey,
					rowBKGenerate, colGenerationDateTo);
			String recurringTemplateNoFrom = SessionData.getDataTbVal(
					dataTableKey, rowBKGenerate, colRecurringTemplateNoFrom);
			String recurringTemplateNoTo = SessionData.getDataTbVal(
					dataTableKey, rowBKGenerate, colRecurringTemplateNoTo);

			if (!generationDateFrom.isEmpty()) {
				onBKGenerateRecurringBankVchSteps
						.typeGenerationDateFrom(generationDateFrom);
			}
			if (!generationDateTo.isEmpty()) {
				onBKGenerateRecurringBankVchSteps
						.typeGenerationDateTo(generationDateTo);
			}
			if (!recurringTemplateNoFrom.isEmpty()) {
				onBKGenerateRecurringBankVchSteps
						.typeRecurringTemplateNoFrom(recurringTemplateNoFrom);
			}
			if (!recurringTemplateNoTo.isEmpty()) {
				onBKGenerateRecurringBankVchSteps
						.typeRecurringTemplateNoTo(recurringTemplateNoTo);
			}
			onBKGenerateRecurringBankVchSteps.clickOnSubmitBtn();

			int amtVch = onBKGenerateRecurringBankVchSteps.getAmtVch();
			if (amtVch > 0) {
				String firstVch = onBKGenerateRecurringBankVchSteps
						.getFirstVch();
				
				onMenuNavigationSteps
						.user_navigates_to_screen("Operations>Bank Book>Transaction Voucher");

				onBKTransactionVchSteps.clickOnLastUpdateDatAtDratTab();
				onBKTransactionVchSteps.chooseVchNoAtDraftTab(firstVch, amtVch);
				onBKTransactionVchSteps.clickOnSubmitBtn();
			}
		}
	}
}
