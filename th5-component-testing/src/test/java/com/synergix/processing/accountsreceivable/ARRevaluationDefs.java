package com.synergix.processing.accountsreceivable;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.accountsreceivable.steps.ARRevaluationSTeps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class ARRevaluationDefs {
	@Steps
	ARRevaluationSTeps onARRevaluationStep;

	@When("^user create ar revaluation as \"([^\"]*)\"$")
	public void user_create_ar_revaluation_as(String datakey,
			List<List<String>> dataTable) throws Throwable {

		String dataTableKey = "Revaluation";
		SessionData.addDataTable(dataTableKey, dataTable);
		String colKey = "KEY";
		String colRevaluationVoucherDate = "Revaluation Voucher Date";
		String colDescription = "Description";

		for (int row : SessionData.getDataTbRowsByValEqualInCol(dataTableKey,
				colKey, datakey).keySet()) {

			String revaluationVoucherDate = SessionData.getDataTbVal(
					dataTableKey, row, colRevaluationVoucherDate);
			String description = SessionData.getDataTbVal(dataTableKey, row,
					colDescription);

			onARRevaluationStep.addNewRevaluation();

			if (revaluationVoucherDate.isEmpty())
				revaluationVoucherDate = onARRevaluationStep.getdateToday();
			onARRevaluationStep
					.type_revaluationVoucherDate(revaluationVoucherDate);

			if (!description.isEmpty()) {
				onARRevaluationStep.type_description(description);
			}
		}
	}

	@When("^ar revaluation added currency as \"([^\"]*)\"$")
	public void revaluation_added_currency_as(String datakey,
			List<List<String>> dataTable) throws Throwable {
		String dataTableKey = "Revaluation1";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKey = "KEY";
		String colCurrency = "Currency";
		String colExchRate = "Exch Rate";
		String colDel = "Del";

		for (int row : SessionData.getDataTbRowsByValEqualInCol(dataTableKey,
				colKey, datakey).keySet()) {

			String currency = SessionData.getDataTbVal(dataTableKey, row,
					colCurrency);
			String exchRate = SessionData.getDataTbVal(dataTableKey, row,
					colExchRate);
			String delete = SessionData.getDataTbVal(dataTableKey, row, colDel);

			onARRevaluationStep.deleteAllCurrency();
			onARRevaluationStep.clickOnAddBtn();

			int rowIndex = onARRevaluationStep.countRowTb();

			if (!currency.isEmpty()) {
				onARRevaluationStep.type_curency(currency, rowIndex);
			}

			if (!exchRate.isEmpty()) {
				onARRevaluationStep.type_exchRate(exchRate, rowIndex);
			}

			if (delete.toLowerCase().equals("y")) {
				onARRevaluationStep.deleteCurrency(rowIndex);
			}
		}
	}

	@When("^ar revaluation submited$")
	public void revaluation_submited() {
		onARRevaluationStep.submitRevaluation();
	}
}
