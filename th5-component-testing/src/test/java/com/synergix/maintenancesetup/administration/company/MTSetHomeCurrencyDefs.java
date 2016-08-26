package com.synergix.maintenancesetup.administration.company;

import java.util.List;

import com.synergix.mtsetup.administration.company.steps.SetHomeCurrencySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTSetHomeCurrencyDefs {

	@Steps
	SetHomeCurrencySteps onSetHomeCurrencySteps;

	@When("^user update for company \"([^\"]*)\"$")
	public void user_update_for_company(String company) {
		if (!company.isEmpty()) {
			if (company.contains(",")) {
				String[] listCompany = company.split(",");
				for (String comp : listCompany) {
					onSetHomeCurrencySteps.chooseCompanyCode(comp);
					onSetHomeCurrencySteps.clickOnUpdateBtn();
				}
			} else {
				onSetHomeCurrencySteps.chooseCompanyCode(company);
				onSetHomeCurrencySteps.clickOnUpdateBtn();
			}
		} else {
			onSetHomeCurrencySteps.chooseAndUpdateAllCompany();
		}
	}

	@Given("^user set home and operation for currency$")
	public void user_set_home_and_operation_for_currency(List<List<String>> dataTable) {

		String dataTableKey = "HomeCurrency";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colHomeCurrency = "Home Currency";
		String colOperationCurrency = "Operation Currency";

		for (int rowHomeCurrency : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String homeCurrency = SessionData.getDataTbVal(dataTableKey, rowHomeCurrency, colHomeCurrency);
			String operationCurrency = SessionData.getDataTbVal(dataTableKey, rowHomeCurrency, colOperationCurrency);

			if (!homeCurrency.isEmpty()) {
				onSetHomeCurrencySteps.typeHomeCurrency(homeCurrency);
			}
			if (!operationCurrency.isEmpty()) {
				onSetHomeCurrencySteps.typeOperationCurrency(operationCurrency);
			}
		}
	}
}
