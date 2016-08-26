package com.synergix.processing.fixedasset;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import com.synergix.processing.fixedasset.steps.FAChangeLocationSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;

public class FAChangeLocationDefs {
	@Steps
	FAChangeLocationSteps onFAChangeLocationSteps;

	@When("^user create FA change location as \"([^\"]*)\"$")
	public void user_create_FA_change_location_as(String dataKey,
			List<List<String>> dataTable) {
		String colKEY = "KEY";
		String colFixedAssetCode = "Fixed Asset Code";
		String colTransactionDate = "Transaction Date";
		String colSubject = "Subject";

		String dataTableKey = "FAChangeLocation";
		SessionData.addDataTable(dataTableKey, dataTable);

		for (int rowFAChangeLocation : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String fixedAssetCode = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocation, colFixedAssetCode);
			String transactionDate = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocation, colTransactionDate);
			String subject = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocation, colSubject);

			onFAChangeLocationSteps.clickOnNewBtn();

			if (!fixedAssetCode.isEmpty()) {
				onFAChangeLocationSteps.typeFixedAssetCode(fixedAssetCode);
			}
			if (transactionDate.isEmpty())
				transactionDate = onFAChangeLocationSteps.getToday();
			onFAChangeLocationSteps.typeTransactionDate(transactionDate);

			if (!subject.isEmpty()) {
				onFAChangeLocationSteps.typeSubject(subject);
			}
		}
	}

	@When("^FA change location is add details as \"([^\"]*)\"$")
	public void FA_change_location_is_add_details_as(String dataKey,
			List<List<String>> dataTable) {
		String dataTableKey = "FAChangeLocationDet";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEY = "KEY";
		String colSerialNo = "Serial No";
		String colRemarksDescription = "Remarks Description";
		String colNewLocation = "New Location";
		String colDel = "Del";

		int rowIndex = 0;

		for (int rowFAChangeLocationDet : SessionData
				.getDataTbRowsByValEqualInCol(dataTableKey, colKEY, dataKey)
				.keySet()) {
			String serialNo = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocationDet, colSerialNo);
			String remarksDescription = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocationDet, colRemarksDescription);
			String newLocation = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocationDet, colNewLocation);
			String del = SessionData.getDataTbVal(dataTableKey,
					rowFAChangeLocationDet, colDel);

			onFAChangeLocationSteps.clickOnAddBtn();
			rowIndex += 1;

			if (!serialNo.isEmpty()) {
				onFAChangeLocationSteps.typeSerialNo(serialNo, rowIndex);
			}
			if (!remarksDescription.isEmpty()) {
				onFAChangeLocationSteps.typeRemarksDescription(
						remarksDescription, rowIndex);
			}
			if (!newLocation.isEmpty()) {
				onFAChangeLocationSteps.typeNewLocation(newLocation, rowIndex);
			}
			if (!del.isEmpty()) {
				onFAChangeLocationSteps.chooseDel(rowIndex);
				rowIndex -= 1;
			}
		}
	}

	@When("^FA change location is submitted$")
	public void FA_disposal_voucher_is_submitted() {
		onFAChangeLocationSteps.clickOnSubmitBtn();
	}
}
