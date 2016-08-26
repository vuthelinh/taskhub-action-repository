package com.synergix.mastersetup.finance.accounting.accounting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.globalsetup.financial.accounting.steps.SalesTaxSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GLSalesTaxDefs {
	@Steps
	SalesTaxSteps onGlobalSalesTaxSteps;

	String dataFilePath = System.getProperty("user.dir") + CONST.FIN_FINANCIAL + "GLSalesTax.xls";

	@When("^user create sales tax as \"([^\"]*)\"$")
	public void user_create_sales_tax_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "SalesTax";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSALESTAX = "KEY SALES TAX";
		String colPrefix = "Prefix";
		String colSalesTaxCode = "Sales Tax Code";
		String colDescription = "Description";
		String colSalesTax = "Sales Tax";
		String colInputTaxGLAN = "Input Tax GLAN";
		String colOutputTaxGLAN = "Output Tax GLAN";
		String colIRASTaxTypeofPurchase = "IRAS Tax Type of Purchase";
		String colIRASTaxTypeofSupply = "IRAS Tax Type of Supply";
		String colCompany = "Company";

		onGlobalSalesTaxSteps.switchToIFrame();

		for (int rowSalesTax : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSALESTAX, dataKey)
				.keySet()) {
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colSalesTaxCode);
			String prefix = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colPrefix);
			String description = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colDescription);
			String salesTax = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colSalesTax);
			String inputTaxGLAN = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colInputTaxGLAN);
			String outputTaxGLAN = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colOutputTaxGLAN);
			String iRASTaxTypeofPurchase = SessionData.getDataTbVal(dataTableKey, rowSalesTax,
					colIRASTaxTypeofPurchase);
			String iRASTaxTypeofSupply = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colIRASTaxTypeofSupply);
			String company = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colCompany);

			if (!prefix.isEmpty()) {
				salesTaxCode = onGlobalSalesTaxSteps.autoGenCode("");
			}

			if (!salesTaxCode.isEmpty()) {
				onGlobalSalesTaxSteps.addNewSalesTax();
				onGlobalSalesTaxSteps.typeSalesTaxCode(salesTaxCode);

				if (!description.isEmpty()) {
					onGlobalSalesTaxSteps.typeDescription(description);
				}
				if (!salesTax.isEmpty()) {
					onGlobalSalesTaxSteps.typeSalesTax(salesTax);
				}
				if (!inputTaxGLAN.isEmpty()) {
					onGlobalSalesTaxSteps.typeInputTaxGLAN(inputTaxGLAN);
				}
				if (!outputTaxGLAN.isEmpty()) {
					onGlobalSalesTaxSteps.typeOutputTaxGLAN(outputTaxGLAN);
				}
				if (!iRASTaxTypeofPurchase.isEmpty()) {
					onGlobalSalesTaxSteps.selectIRASTaxTypeofPurchase(iRASTaxTypeofPurchase);
				}
				if (!iRASTaxTypeofSupply.isEmpty()) {
					onGlobalSalesTaxSteps.selectIRASTaxTypeofSupply(iRASTaxTypeofSupply);
				}

				onGlobalSalesTaxSteps.moveToCompanyTab();

				if (company.trim().toLowerCase().equals("all")) {
					onGlobalSalesTaxSteps.checkAllCompany();
				} else
					onGlobalSalesTaxSteps.checkCompany(company);

				onGlobalSalesTaxSteps.clickOnUpdateButton();
			}
		}
		onGlobalSalesTaxSteps.switchOutDefaultIFrame();
	}

	@When("^user delete sales tax$")
	public void user_delete_sales_tax(List<List<String>> dataTable) {
		String dataTableKey = "DelSalesTax";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colSalesTaxCode = "Sales Tax Code";

		onGlobalSalesTaxSteps.switchToIFrame();

		for (int rowSalesTax : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String salesTaxCode = SessionData.getDataTbVal(dataTableKey, rowSalesTax, colSalesTaxCode);
			if (!salesTaxCode.isEmpty()) {
				onGlobalSalesTaxSteps.chooseDelSalesTax(salesTaxCode);
			}
		}
		onGlobalSalesTaxSteps.switchOutDefaultIFrame();
	}

	@When("^user create new sales tax$")
	public void user_create_new_sales_tax() {

		SessionData.addExcelData("GLSalesTax", dataFilePath);

		HashMap<String, Integer> hSalesTaxColName = SessionData.getExcelColNameBySheetName("GLSalesTax", "Global Sales Tax");

		int colSalesTaxCode = hSalesTaxColName.get("Sales Tax Code");
		int colDescription = hSalesTaxColName.get("Description");
		int colSalesTax = hSalesTaxColName.get("Sales Tax");
		int colInputTaxGLAN = hSalesTaxColName.get("Input Tax GLAN");
		int colOutputTaxGLAN = hSalesTaxColName.get("Output Tax GLAN");
		int colIRASTaxTypeofPurchase = hSalesTaxColName.get("IRAS Tax Type of Purchase");
		int colIRASTaxTypeofSupply = hSalesTaxColName.get("IRAS Tax Type of Supply");

		HashMap<String, Integer> hCompanyColName = SessionData.getExcelColNameBySheetName("GLSalesTax", "Company");
		int colKeySalesTax = hCompanyColName.get("Sales Tax");
		int colCompany = hCompanyColName.get("Company");

		String salesTaxCode = "";
		String description = "";
		String salesTax = "";
		String inputTaxGLAN = "";
		String outputTaxGLAN = "";
		String iRASTaxTypeofPurchase = "";
		String iRASTaxTypeofSupply = "";

		String keySalesTax = "";
		String company = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader("GLSalesTax",
				"Global Sales Tax");

		onGlobalSalesTaxSteps.switchToIFrame();

		for (Integer row : getDataset.keySet()) {
			salesTaxCode = getDataset.get(row).get(colSalesTaxCode);
			description = getDataset.get(row).get(colDescription);
			salesTax = getDataset.get(row).get(colSalesTax);
			inputTaxGLAN = getDataset.get(row).get(colInputTaxGLAN);
			outputTaxGLAN = getDataset.get(row).get(colOutputTaxGLAN);
			iRASTaxTypeofPurchase = getDataset.get(row).get(colIRASTaxTypeofPurchase);
			iRASTaxTypeofSupply = getDataset.get(row).get(colIRASTaxTypeofSupply);

			onGlobalSalesTaxSteps.addNewSalesTax();

			if (!salesTaxCode.isEmpty()) {
				onGlobalSalesTaxSteps.typeSalesTaxCode(salesTaxCode);
			}
			if (!description.isEmpty()) {
				onGlobalSalesTaxSteps.typeDescription(description);
			}
			if (!salesTax.isEmpty()) {
				onGlobalSalesTaxSteps.typeSalesTax(salesTax);
			}
			if (!inputTaxGLAN.isEmpty()) {
				onGlobalSalesTaxSteps.typeInputTaxGLAN(inputTaxGLAN);
			}
			if (!outputTaxGLAN.isEmpty()) {
				onGlobalSalesTaxSteps.typeOutputTaxGLAN(outputTaxGLAN);
			}
			if (!iRASTaxTypeofPurchase.isEmpty()) {
				onGlobalSalesTaxSteps.selectIRASTaxTypeofPurchase(iRASTaxTypeofPurchase);
			}
			if (!iRASTaxTypeofSupply.isEmpty()) {
				onGlobalSalesTaxSteps.selectIRASTaxTypeofSupply(iRASTaxTypeofSupply);
			}

			onGlobalSalesTaxSteps.moveToCompanyTab();
			LinkedHashMap<Integer, List<String>> getCompany = SessionData.getExcelSheetData("GLSalesTax", "Company");
			for (Integer rowComp : getCompany.keySet()) {
				keySalesTax = getCompany.get(rowComp).get(colKeySalesTax);
				if (keySalesTax.equals(salesTaxCode)) {
					company = getCompany.get(rowComp).get(colCompany);
					if (company.trim().toLowerCase().equals("all")) {
						onGlobalSalesTaxSteps.checkAllCompany();
						break;
					} else
						onGlobalSalesTaxSteps.checkCompany(company);
				}
			}
			onGlobalSalesTaxSteps.clickOnUpdateButton();
		}
		onGlobalSalesTaxSteps.switchOutDefaultIFrame();
	}
}
