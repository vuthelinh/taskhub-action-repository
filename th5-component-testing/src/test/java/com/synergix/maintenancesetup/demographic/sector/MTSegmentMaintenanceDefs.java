package com.synergix.maintenancesetup.demographic.sector;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.common.CONST;
import com.synergix.mtsetup.demographic.sector.steps.SegmentMaintenanceSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MTSegmentMaintenanceDefs {

	@Steps
	SegmentMaintenanceSteps onSegmentMaintenanceSteps;

	String filePath = System.getProperty("user.dir") + CONST.FIN_MT_DEMOGRAPHIC_SECTOR + "SegmentMaintenance.xls";
	String keyFileName = "SegmentMaintenance";
	String datasetSheet = "Dataset";
	String addSegmentSheet = "AddSegment";

	boolean isContinue = false;

	@When("^user create segment as \"([^\"]*)\"$")
	public void user_create_segment_as(String dataKey, List<List<String>> dataTable) {
		String dataTableKey = "SegmentMaintenance";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colKEYSGMT = "KEY SGMT";
		String colSegmentNo = "Segment No";
		String colSegmentName = "Segment Name";

		for (int rowSegmentMaintenance : SessionData.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSGMT, dataKey)
				.keySet()) {
			String segmentNo = SessionData.getDataTbVal(dataTableKey, rowSegmentMaintenance, colSegmentNo);
			String segmentName = SessionData.getDataTbVal(dataTableKey, rowSegmentMaintenance, colSegmentName);

			if (!segmentNo.isEmpty()) {
				onSegmentMaintenanceSteps.clickOnIcon(segmentNo);

				isContinue = true;

				if (!segmentName.isEmpty()) {
					onSegmentMaintenanceSteps.typeSegmentName(segmentName, segmentNo);
				}
			}
		}
	}

	@When("^segment is added detail as \"([^\"]*)\"$")
	public void segment_is_added_detail_as(String dataKey, List<List<String>> dataTable) {
		if (isContinue) {
			String dataTableKey = "SegmentMaintenanceDetail";
			SessionData.addDataTable(dataTableKey, dataTable);

			String colKEYSGMT = "KEY SGMT";
			String colSegmentCode = "Segment Code";
			String colDescription = "Description";
			String colDel = "Del";

			for (int rowSegmentMaintenanceDetail : SessionData
					.getDataTbRowsByValEqualInCol(dataTableKey, colKEYSGMT, dataKey).keySet()) {
				String segmentCode = SessionData.getDataTbVal(dataTableKey, rowSegmentMaintenanceDetail,
						colSegmentCode);
				String description = SessionData.getDataTbVal(dataTableKey, rowSegmentMaintenanceDetail,
						colDescription);
				String del = SessionData.getDataTbVal(dataTableKey, rowSegmentMaintenanceDetail, colDel);

				onSegmentMaintenanceSteps.clickAddBtn();
				int row = onSegmentMaintenanceSteps.getRowDetais();
				if (!segmentCode.isEmpty()) {
					onSegmentMaintenanceSteps.typeSegmentCode(segmentCode, row);
				}
				if (!description.isEmpty()) {
					onSegmentMaintenanceSteps.typeDescription(description, row);
				}
				if (del.toLowerCase().equals("y")) {
					onSegmentMaintenanceSteps.chooseDelDetail(row);
				}
			}
		}
	}

	@When("user delete segment")
	public void user_delete_segment(List<List<String>> dataTable) {
		String dataTableKey = "DelSegment";
		SessionData.addDataTable(dataTableKey, dataTable);

		String colSegmentNo = "Segment No";
		String colSegmentCode = "Segment Code";

		for (int rowDelSegment : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
			String segmentNo = SessionData.getDataTbVal(dataTableKey, rowDelSegment, colSegmentNo);
			String segmentCode = SessionData.getDataTbVal(dataTableKey, rowDelSegment, colSegmentCode);

			if (!segmentNo.isEmpty()) {
				onSegmentMaintenanceSteps.clickOnIcon(segmentNo);
				onSegmentMaintenanceSteps.chooseDelDetail(segmentCode);
			}
		}
	}

	@Given("^user create segment$")
	public void user_create_segment() {
		SessionData.addExcelData(keyFileName, filePath);
		HashMap<String, Integer> hDatasetColName = SessionData.getExcelColNameBySheetName(keyFileName, datasetSheet);
		int colKey = hDatasetColName.get("Key");
		int colSegmentName = hDatasetColName.get("Segment Name");
		String key = "";
		String segmentName = "";

		HashMap<String, Integer> hAddSegmentColName = SessionData.getExcelColNameBySheetName(keyFileName, addSegmentSheet);
		int colKeySgmt = hAddSegmentColName.get("Key");
		int colSegmentCode = hAddSegmentColName.get("Segment Code");
		int colDescription = hAddSegmentColName.get("Description");
		String keySgmt = "";
		String segmentCode = "";
		String description = "";

		LinkedHashMap<Integer, List<String>> getDataset = SessionData.getExcelSheetDataNoHeader(keyFileName,
				datasetSheet);
		for (Integer rowDataset : getDataset.keySet()) {
			key = getDataset.get(rowDataset).get(colKey);
			segmentName = getDataset.get(rowDataset).get(colSegmentName);

			if (!key.isEmpty()) {
				onSegmentMaintenanceSteps.clickOnIcon(key);
			}
			if (!segmentName.isEmpty()) {
				onSegmentMaintenanceSteps.typeSegmentName(segmentName, key);
			}

			LinkedHashMap<Integer, List<String>> getAddSegment = SessionData.getExcelSheetDataNoHeader(keyFileName,
					addSegmentSheet);
			for (Integer rowAddSegment : getAddSegment.keySet()) {
				keySgmt = getAddSegment.get(rowAddSegment).get(colKeySgmt);
				if (key.equals(keySgmt)) {
					segmentCode = getAddSegment.get(rowAddSegment).get(colSegmentCode);
					description = getAddSegment.get(rowAddSegment).get(colDescription);
					onSegmentMaintenanceSteps.clickAddBtn();
					int row = onSegmentMaintenanceSteps.getRowDetais();
					if (!segmentCode.isEmpty()) {
						onSegmentMaintenanceSteps.typeSegmentCode(segmentCode, row);
					}
					if (!description.isEmpty()) {
						onSegmentMaintenanceSteps.typeDescription(description, row);
					}
				}
			}
		}

	}

}
