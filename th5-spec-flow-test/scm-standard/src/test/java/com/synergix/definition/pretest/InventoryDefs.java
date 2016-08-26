package com.synergix.definition.pretest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.globalsetup.inventory.steps.InventorySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class InventoryDefs {

	@Steps
	InventorySteps invSteps;

	@Then("^user maintains Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Global_Inventory_as(String dataKey, List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_GENERAL", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_GENERAL", "KEY", dataKey).keySet()) {
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "KEY");
			String sInventoryCode = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Inventory Code");
			String sDescription = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Description");
			String sCopyFromInventory = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Copy From Inventory");
			String sShortDescription = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Short Description");
			String sDetailedDescription = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Detailed Description");
			String sBaseUom = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Base UOM");
			String sAutoBreakPackToBaseUom = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row,
					"Auto Break Pack To Base UOM");
			String sInventoryClass = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Inventory Class");
			String sInventoryCategory = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Inventory Category");
			String sBudgetCategoryCode = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Budget Category Code");
			String sInventoryType = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Inventory Type");
			String sInventoryBrand = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Inventory Brand");
			String sSeries1 = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Series 1");
			String sSeries2 = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Series 2");
			String sSeries3 = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Series 3");
			String sSeries4 = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Series 4");
			String sReportGroupingCode = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Report Grouping Code");
			String sLotNoTracking = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Lot No. Tracking");
			String sSerialNoTracking = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Serial No. Tracking");
			String sWarrantyTracking = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Warranty Tracking");
			String sCountryOfOrigin = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Country of Origin");
			String sReceiptMinimumShelfLife = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row,
					"Receipt Minimum Shelf Life");
			String sIssueMinimumExpiry = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row, "Issue Minimum Expiry");
			String sExchangeOfExpiredLot = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row,
					"Exchange of Expired Lot");
			String sExchangeAllowableWithin = SessionData.getDataTbVal("GL_INVENTORY_GENERAL", row,
					"Exchange Allowable Within");
			if (sKey.isEmpty() || sInventoryCode.isEmpty()) {
				continue;
			}
			if (!sInventoryCode.isEmpty()) {
				invSteps.click_btn_New_of_summary();
				invSteps.switch_to_tab_general();
				invSteps.click_btn_New_of_global_inv();
				if (!invSteps.enter_inventory_code(sInventoryCode).isEmpty()) {
					assertThat(invSteps.search_inventory_code(sInventoryCode)).isTrue();
				}
			}
			if (!sDescription.isEmpty())
				invSteps.enter_description(sDescription);
			if (!sCopyFromInventory.isEmpty())
				invSteps.enter_copy_from_inv(sCopyFromInventory);
			if (!sShortDescription.isEmpty())
				invSteps.enter_short_description(sShortDescription);
			if (!sDetailedDescription.isEmpty())
				invSteps.enter_detailed_description(sDetailedDescription);
			if (!sBaseUom.isEmpty())
				invSteps.enter_base_uom(sBaseUom);
			if (!sAutoBreakPackToBaseUom.isEmpty())
				invSteps.select_option_auto_break_pack_to_base_uom(sAutoBreakPackToBaseUom);
			if (!sInventoryClass.isEmpty())
				invSteps.enter_inventory_class(sInventoryClass);
			if (!sInventoryCategory.isEmpty())
				invSteps.enter_inventory_category(sInventoryCategory);
			if (!sBudgetCategoryCode.isEmpty())
				invSteps.enter_budget_category_code(sBudgetCategoryCode);
			if (!sInventoryType.isEmpty())
				invSteps.select_option_inventory_type(sInventoryType);
			if (!sInventoryBrand.isEmpty())
				invSteps.enter_inventory_brand(sInventoryBrand);
			if (!sSeries1.isEmpty())
				invSteps.enter_series_1(sSeries1);
			if (!sSeries2.isEmpty())
				invSteps.enter_series_2(sSeries2);
			if (!sSeries3.isEmpty())
				invSteps.enter_series_3(sSeries3);
			if (!sSeries4.isEmpty())
				invSteps.enter_series_4(sSeries4);
			if (!sReportGroupingCode.isEmpty())
				invSteps.enter_report_grouping_code(sReportGroupingCode);
			if (!sLotNoTracking.isEmpty())
				invSteps.select_option_lot_no_tracking(sLotNoTracking);
			if (!sSerialNoTracking.isEmpty())
				invSteps.select_option_serial_no_tracking(sSerialNoTracking);
			if (!sWarrantyTracking.isEmpty())
				invSteps.select_option_warranty_tracking(sWarrantyTracking);
			if (!sCountryOfOrigin.isEmpty())
				invSteps.enter_country_of_origin(sCountryOfOrigin);
			if (!sReceiptMinimumShelfLife.isEmpty())
				invSteps.enter_receipt_minimum_shelf_life(sReceiptMinimumShelfLife);
			if (!sIssueMinimumExpiry.isEmpty())
				invSteps.enter_issue_minimum_expiry(sIssueMinimumExpiry);
			if (!sExchangeOfExpiredLot.isEmpty()) {
				invSteps.select_option_exchange_of_expired_lot(sExchangeOfExpiredLot);
			}
			if (!sExchangeAllowableWithin.isEmpty()) {
				invSteps.enter_exchange_allowable_within(sExchangeAllowableWithin);
			}
			invSteps.update();
			
		}
	}

	@Then("^user maintains Specification of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Specification_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_SPECIFICATION", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_SPECIFICATION", "KEY", dataKey)
				.keySet()) {
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "KEY");
			String sLengthInch = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Length inch");
			String sBreadthInch = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Breadth inch");
			String sHeightInch = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Height inch");
			String sLengthMm = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Length mm");
			String sBreadthMm = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Breadth mm");
			String sHeightMm = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Height mm");
			String sVolume = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Volume");
			String sOuterDiameterInch = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row,
					"Outer Diameter inch");
			String sInnerDiameterInch = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row,
					"Inner Diameter inch");
			String sOuterLengthInch = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Outer Length inch");
			String sOuterDiameterMm = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Outer Diameter mm");
			String sInnerDiameterMm = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Inner Diameter mm");
			String sOuterLengthMm = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Outer Length mm");
			String sGrossWeight = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Gross Weight");
			String sNettWeight = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Nett Weight");
			String sWeightUom = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Weight UOM");
			String sDensity = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Density");
			String sMeasureType = SessionData.getDataTbVal("GL_INVENTORY_SPECIFICATION", row, "Measure Type");
			invSteps.switch_to_tab_specification();
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			if (!sLengthInch.isEmpty())
				invSteps.enter_length_inch(sLengthInch);
			if (!sBreadthInch.isEmpty())
				invSteps.enter_breadth_inch(sBreadthInch);
			if (!sHeightInch.isEmpty())
				invSteps.enter_height_inch(sHeightInch);
			if (!sLengthMm.isEmpty())
				invSteps.enter_length_mm(sLengthMm);
			if (!sBreadthMm.isEmpty())
				invSteps.enter_breadth_mm(sBreadthMm);
			if (!sHeightMm.isEmpty())
				invSteps.enter_height_mm(sHeightMm);
			if (!sVolume.isEmpty())
				invSteps.enter_volume(sVolume);
			if (!sOuterDiameterInch.isEmpty())
				invSteps.enter_outer_diameter_inch(sOuterDiameterInch);
			if (!sInnerDiameterInch.isEmpty())
				invSteps.enter_inner_diameter_inch(sInnerDiameterInch);
			if (!sOuterLengthInch.isEmpty())
				invSteps.enter_outer_length_inch(sOuterLengthInch);
			if (!sOuterDiameterMm.isEmpty())
				invSteps.enter_outer_diameter_mm(sOuterDiameterMm);
			if (!sInnerDiameterMm.isEmpty())
				invSteps.enter_inner_diameter_mm(sInnerDiameterMm);
			if (!sOuterLengthMm.isEmpty())
				invSteps.enter_outer_length_mm(sOuterLengthMm);
			if (!sGrossWeight.isEmpty())
				invSteps.enter_gross_weight(sGrossWeight);
			if (!sNettWeight.isEmpty())
				invSteps.enter_nett_weight(sNettWeight);
			if (!sWeightUom.isEmpty())
				invSteps.enter_weight_uom(sWeightUom);
			if (!sDensity.isEmpty())
				invSteps.enter_density(sDensity);
			if (!sMeasureType.isEmpty())
				invSteps.enter_measure_type(sMeasureType);
			invSteps.update();
		}
	}

	@Then("^user maintains Healthcare of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Healthcare_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_HEALTHCARE", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_HEALTHCARE", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_healthcare();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "KEY");
			String sDrugName = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Drug Name");
			String sTradeName = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Trade Name");
			String sStrength = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Strength");
			String sRoute = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Route");
			String sControlledDrugMohReportingReq = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row,
					"Controlled Drug, MOH reporting req");
			String sGenerateProductLabel = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row,
					"Generate Product Label");
			String sPrescriptionDesc = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Prescription Desc");
			String sQty = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Qty");
			String sUom = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "UOM");
			String sFrequency = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Frequency");
			String sFrequencyDesc = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Frequency Desc");
			String sDuration = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Duration");
			String sDrugUseCode = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row, "Drug Use Code");
			String sAdditionalInfoCode = SessionData.getDataTbVal("GL_INVENTORY_HEALTHCARE", row,
					"Additional Info Code");
			if (!sKey.isEmpty()) {
			}
			invSteps.click_btn_add_drug_detail();
			if (!sDrugName.isEmpty())
				invSteps.enter_drug_name(sDrugName);
			if (!sTradeName.isEmpty())
				invSteps.enter_trade_name(sTradeName);
			if (!sStrength.isEmpty())
				invSteps.enter_strength(sStrength);
			if (!sRoute.isEmpty())
				invSteps.enter_route(sRoute);
			if (!sControlledDrugMohReportingReq.isEmpty())
				invSteps.select_option_controlled_drug_moh_reporting_req(sControlledDrugMohReportingReq);
			if (!sGenerateProductLabel.isEmpty())
				invSteps.select_option_generate_product_label(sGenerateProductLabel);
			if (!sPrescriptionDesc.isEmpty())
				invSteps.enter_prescription_desc(sPrescriptionDesc);
			if (!sQty.isEmpty())
				invSteps.enter_qty(sQty);
			if (!sUom.isEmpty())
				invSteps.enter_uom(sUom);
			if (!sFrequency.isEmpty())
				invSteps.enter_frequency(sFrequency);
			if (!sFrequencyDesc.isEmpty())
				invSteps.enter_frequency_desc(sFrequencyDesc);
			if (!sDuration.isEmpty())
				invSteps.enter_duration(sDuration);
			if (!sDrugUseCode.isEmpty()) {
				invSteps.click_btn_add_drug_use();
				invSteps.enter_new_drug_use_code(sDrugUseCode);
			}
			if (!sAdditionalInfoCode.isEmpty()) {
				invSteps.click_btn_add_drug_add_info();
				invSteps.enter_new_drug_add_info(sAdditionalInfoCode);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains Pack Size of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Pack_Size_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_PACK_SIZE", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_PACK_SIZE", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_pack_size();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row, "KEY");
			String sPackSizeCode = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row, "Pack Size Code");
			String sDescription = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row, "Description");
			String sConvertFromPackSize = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row,
					"Convert from Pack Size");
			String sQtyInOtherPackSize = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row,
					"Qty in Other Pack Size");
			String sQtyInBaseUom = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row, "Qty in Base UOM");
			String sEnableInMobilePreSales = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row,
					"Enable in Mobile Pre Sales");
			String sEnableBaseUomInMobilePreSales = SessionData.getDataTbVal("GL_INVENTORY_PACK_SIZE", row,
					"Enable Base UOM in Mobile Pre Sales");
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			invSteps.click_btn_add_pack_size_cd();
			if (!sEnableBaseUomInMobilePreSales.isEmpty()) {
				invSteps.set_chkbox_enable_base_uom_in_Mobile_Pre_Sales(sEnableBaseUomInMobilePreSales);
			}
			if (!sPackSizeCode.isEmpty()) {
				invSteps.enter_new_pack_size_code(sPackSizeCode);
			}
			if (!sDescription.isEmpty()) {
				invSteps.enter_new_pack_size_cd_description(sDescription);
			}
			if (!sConvertFromPackSize.isEmpty()) {
				invSteps.select_new_convert_from_pack_size(sConvertFromPackSize);
			}
			if (!sQtyInOtherPackSize.isEmpty()) {
				invSteps.enter_new_qty_in_other_pack_size(sQtyInOtherPackSize);
			}
			if (!sQtyInBaseUom.isEmpty()) {
				invSteps.enter_new_qty_in_base_uom(sQtyInBaseUom);
			}
			if (!sEnableInMobilePreSales.isEmpty()) {
				invSteps.set_enable_in_mobile_pre_sales(sEnableInMobilePreSales);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains Supplier of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Supplier_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_SUPPLIER", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_SUPPLIER", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_supplier();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "KEY");
			String sSupplier = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Supplier");
			String sPartyInventoryCode = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Party Inventory Code");
			String sDefaultDescription = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Default Description");
			String sBillingDescription = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Billing Description");
			String sRemarks = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Remarks");
			String sMinOrderQty = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Min Order Qty");
			String sLeadTimeInDays = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Lead Time in Days");
			String sStdPackSize = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Std Pack Size");
			String sHomeUnitCost = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Home Unit Cost");
			String sDefault = SessionData.getDataTbVal("GL_INVENTORY_SUPPLIER", row, "Default");
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			if (!sSupplier.isEmpty()) {
				invSteps.click_btn_add_supplier();
				invSteps.enter_new_supplier(sSupplier);
			} else {
				continue;
			}
			if (!sPartyInventoryCode.isEmpty()) {
				invSteps.enter_new_party_inventory_code(sPartyInventoryCode);
			}
			if (!sDefaultDescription.isEmpty()) {
				invSteps.enter_new_default_description(sDefaultDescription);
			}
			if (!sBillingDescription.isEmpty()) {
				invSteps.enter_new_billing_description(sBillingDescription);
			}
			if (!sRemarks.isEmpty()) {
				invSteps.enter_new_remarks(sRemarks);
			}
			if (!sMinOrderQty.isEmpty()) {
				invSteps.enter_new_min_order_qty(sMinOrderQty);
			}
			if (!sLeadTimeInDays.isEmpty()) {
				invSteps.enter_new_lead_time_in_days(sLeadTimeInDays);
			}
			if (!sStdPackSize.isEmpty()) {
				invSteps.enter_new_std_pack_size(sStdPackSize);
			}
			if (!sHomeUnitCost.isEmpty()) {
				invSteps.enter_new_home_unit_cost(sHomeUnitCost);
			}
			if (!sDefault.isEmpty()) {
				invSteps.set_default_supplier(sDefault);
			}
			invSteps.update();
		}

	}

	@Then("^user maintains Content of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Content_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_CONTENT", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_CONTENT", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_content();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_CONTENT", row, "KEY");
			String sContentCode = SessionData.getDataTbVal("GL_INVENTORY_CONTENT", row, "Content Code");
			String sDescription = SessionData.getDataTbVal("GL_INVENTORY_CONTENT", row, "Description");
			String sDefaultPercentage = SessionData.getDataTbVal("GL_INVENTORY_CONTENT", row, "Default Percentage");
			String sDefaultRecoveryRate = SessionData.getDataTbVal("GL_INVENTORY_CONTENT", row,
					"Default Recovery Rate");
			if (!sKey.isEmpty()) {
			}
			if (!sContentCode.isEmpty()) {
				invSteps.click_btn_add_new_content();
				invSteps.enter_new_content_code(sContentCode);
			} else {
				continue;
			}
			if (!sDescription.isEmpty()) {
				invSteps.verify_new_content_description(sDescription);
			}
			if (!sDefaultPercentage.isEmpty()) {
				invSteps.enter_content_new_default_percentage(sDefaultPercentage);
			}
			if (!sDefaultRecoveryRate.isEmpty()) {
				invSteps.enter_content_new_default_recovery_rate(sDefaultRecoveryRate);
			}
			invSteps.update();
		}

	}

	@Then("^user maintains Attachments of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Attachments_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_ATTACHMENT", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_ATTACHMENT", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_attachments();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_ATTACHMENT", row, "KEY");
			String sFileName = SessionData.getDataTbVal("GL_INVENTORY_ATTACHMENT", row, "File Name");
			String sFileDescription = SessionData.getDataTbVal("GL_INVENTORY_ATTACHMENT", row, "File Description");
			if (!sKey.isEmpty()) {
			} else {
				continue;
			}
			if (!sFileName.isEmpty()) {
				invSteps.click_btn_add_new_attachment();
				invSteps.choose_attachment_file(sFileName);
				invSteps.click_btn_upload_attachment();
			} else {
				continue;
			}
			if (!sFileDescription.isEmpty()) {
				invSteps.enter_new_file_description(sFileDescription);
			}
			invSteps.update();
		}

	}

	@Then("^user maintains Company of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Company_of_Global_Inventory_as(String dataKey, List<List<String>> dataTable)
			throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_COMPANY", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_COMPANY", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_company();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_COMPANY", row, "KEY");
			String sCompanyName = SessionData.getDataTbVal("GL_INVENTORY_COMPANY", row, "Company Name");
			if (!sKey.isEmpty()) {
			}
			if (!sCompanyName.isEmpty()) {
				invSteps.tag_company_name(sCompanyName);
			}
			invSteps.update();
		}

	}

	@Then("^user maintains General in Local Info of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_General_in_Local_Info_of_Global_Inventory_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_LI_GENERAL", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_LI_GENERAL", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_local_info();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_LI_GENERAL", row, "KEY");
			String sHomeBaseCost = SessionData.getDataTbVal("GL_INVENTORY_LI_GENERAL", row, "Home Base Cost");
			String sProcurementLeadTime = SessionData.getDataTbVal("GL_INVENTORY_LI_GENERAL", row,
					"Procurement Lead Time");
			String sAllowIssueMoreThanAllocQty = SessionData.getDataTbVal("GL_INVENTORY_LI_GENERAL", row,
					"Allow Issue More Than Alloc Qty");
			String sInventoryCategory = SessionData.getDataTbVal("GL_INVENTORY_LI_GENERAL", row, "Inventory Category");
			String sInventoryModel = SessionData.getDataTbVal("GL_INVENTORY_LI_GENERAL", row, "Inventory Model");
			if (!sKey.isEmpty()) {
			}
			invSteps.switch_to_tab_locinfo_general();
			if (!sHomeBaseCost.isEmpty()) {
				invSteps.enter_home_base_cost(sHomeBaseCost);
			}
			if (!sProcurementLeadTime.isEmpty()) {
				invSteps.enter_procurement_lead_time(sProcurementLeadTime);
			}
			if (!sAllowIssueMoreThanAllocQty.isEmpty()) {
				invSteps.select_option_allow_issue_more_than_alloc_qty(sAllowIssueMoreThanAllocQty);
			}
			if (!sInventoryCategory.isEmpty()) {
				invSteps.verify_inventory_category_loc_info(sInventoryCategory);
			}
			if (!sInventoryModel.isEmpty()) {
				invSteps.switch_to_tab_locinfo_specification();
				invSteps.enter_inventory_model(sInventoryModel);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains Location information in Local Info of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Location_information_in_Local_Info_of_Global_Inventory_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_LI_LOCATION_INFO", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_LI_LOCATION_INFO", "KEY", dataKey)
				.keySet()) {
			invSteps.switch_to_tab_local_info();
			invSteps.switch_to_tab_locinfo_location();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_LI_LOCATION_INFO", row, "KEY");
			String sLocationCode = SessionData.getDataTbVal("GL_INVENTORY_LI_LOCATION_INFO", row, "Location Code");
			String sLocationName = SessionData.getDataTbVal("GL_INVENTORY_LI_LOCATION_INFO", row, "Location Name");
			String sMinHoldingQty = SessionData.getDataTbVal("GL_INVENTORY_LI_LOCATION_INFO", row, "Min Holding Qty");
			String sMaxHoldingQty = SessionData.getDataTbVal("GL_INVENTORY_LI_LOCATION_INFO", row, "Max Holding Qty");
			String sRemarks = SessionData.getDataTbVal("GL_INVENTORY_LI_LOCATION_INFO", row, "Remarks");
			if (!sKey.isEmpty()) {
			}
			if (!sLocationCode.isEmpty()) {
				if (!invSteps.is_added_location_code(sLocationCode)){
					invSteps.click_btn_add_location_information();
					invSteps.enter_new_location_code(sLocationCode);
				}				
			} else {
				continue;
			}
			if (!sLocationName.isEmpty()) {
				invSteps.verify_location_name(sLocationName);
			}
			if (!sMinHoldingQty.isEmpty()) {
				invSteps.enter_new_min_holding_qty(sMinHoldingQty);
			}
			if (!sMaxHoldingQty.isEmpty()) {
				invSteps.enter_new_max_holding_qty(sMaxHoldingQty);
			}
			if (!sRemarks.isEmpty()) {
				invSteps.enter_new_local_information_remarks(sRemarks);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains Bin Information in Local Info of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Bin_Information_in_Local_Info_of_Global_Inventory_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_LI_BIN_INFO", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_LI_BIN_INFO", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_local_info();
			invSteps.switch_to_tab_locinfo_location();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_LI_BIN_INFO", row, "KEY");
			String sRow = SessionData.getDataTbVal("GL_INVENTORY_LI_BIN_INFO", row, "Row");
			String sColumn = SessionData.getDataTbVal("GL_INVENTORY_LI_BIN_INFO", row, "Column");
			String sLevel = SessionData.getDataTbVal("GL_INVENTORY_LI_BIN_INFO", row, "Level");
			String sDescription = SessionData.getDataTbVal("GL_INVENTORY_LI_BIN_INFO", row, "Description");
			if (!sKey.isEmpty()) {
			}
			if (!sRow.isEmpty()) {
				invSteps.click_btn_add_bin_information();
				invSteps.enter_new_bin_row(sRow);
			} else {
				continue;
			}
			if (!sColumn.isEmpty()) {
				invSteps.enter_new_bin_column(sColumn);
			}
			if (!sLevel.isEmpty()) {
				invSteps.enter_new_bin_level(sLevel);
			}
			if (!sDescription.isEmpty()) {
				invSteps.enter_new_bin_description(sDescription);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains Customer Information in Local Info of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Customer_Information_in_Local_Info_of_Global_Inventory_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_LI_CUSTOMER_INFO", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_LI_CUSTOMER_INFO", "KEY", dataKey)
				.keySet()) {
			invSteps.switch_to_tab_local_info();
			invSteps.switch_to_tab_locinfo_customer();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "KEY");
			String sMoqInLoose = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "MOQ In Loose");
			String sCustomer = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "Customer");
			String sCustomerName = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "Customer Name");
			String sPartyInventoryCode = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row,
					"Party Inventory Code");
			String sDefaultDescription = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row,
					"Default Description");
			String sBillingDescription = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row,
					"Billing Description");
			String sDSalesPercent = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "D-Sales %");
			String sOSalesPercent = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "O-Sales %");
			String sRemarks = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_INFO", row, "Remarks");
			if (!sKey.isEmpty()) {
			}
			if (!sMoqInLoose.isEmpty()) {
				invSteps.enter_moq_in_loose(sMoqInLoose);
			}
			if (!sCustomer.isEmpty()) {
				invSteps.click_btn_add_cus_information();
				invSteps.enter_new_cus_customer(sCustomer);
			} else {
				continue;
			}
			if (!sCustomerName.isEmpty()) {
				invSteps.verify_new_cus_customer_name(sCustomerName);
			}
			if (!sPartyInventoryCode.isEmpty()) {
				invSteps.enter_new_cus_party_inventory_code(sPartyInventoryCode);
			}
			if (!sDefaultDescription.isEmpty()) {
				invSteps.enter_new_cus_default_description(sDefaultDescription);
			}
			if (!sBillingDescription.isEmpty()) {
				invSteps.enter_new_cus_billing_description(sBillingDescription);
			}
			if (!sDSalesPercent.isEmpty()) {
				invSteps.enter_new_cus_d_sales_(sDSalesPercent);
			}
			if (!sOSalesPercent.isEmpty()) {
				invSteps.enter_new_cus_o_sales(sOSalesPercent);
			}
			if (!sRemarks.isEmpty()) {
				invSteps.enter_new_cus_remarks(sRemarks);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains Customer Doc in Local Info of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_Customer_Doc_in_Local_Info_of_Global_Inventory_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_LI_CUSTOMER_DOC", dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol("GL_INVENTORY_LI_CUSTOMER_DOC", "KEY", dataKey)
				.keySet()) {
			invSteps.switch_to_tab_local_info();
			invSteps.switch_to_tab_locinfo_customer_doc();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_DOC", row, "KEY");
			String sDocumentCode = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_DOC", row, "Document Code");
			String sDescription = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_DOC", row, "Description");
			String sDocumentType = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_DOC", row, "Document Type");
			String sCurrentRevision = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_DOC", row, "Current Revision");
			String sAttachment = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_DOC", row, "Attachment");
			if (!sKey.isEmpty()) {
			}
			if (!sDocumentCode.isEmpty()) {
				invSteps.click_btn_add_document();
				invSteps.enter_doc_new_document_code(sDocumentCode);
			} else {
				continue;
			}
			if (!sDescription.isEmpty()) {
				invSteps.verify_doc_new_description(sDescription);
			}
			if (!sDocumentType.isEmpty()) {
				invSteps.verify_doc_new_document_type(sDocumentType);
			}
			if (!sCurrentRevision.isEmpty()) {
				invSteps.verify_doc_new_current_revision(sCurrentRevision);
			}
			if (!sAttachment.isEmpty()) {
				invSteps.verify_doc_new_attachment(sAttachment);
			}
			invSteps.update();
		}
	}

	@Then("^user maintains List Price By Type in Local Info of Global Inventory as \"([^\"]*)\"$")
	public void user_maintains_List_Price_By_Type_in_Local_Info_of_Global_Inventory_as(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", dataTable);
		for (int row : SessionData
				.getDataTbRowsByValEqualInCol("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", "KEY", dataKey).keySet()) {
			invSteps.switch_to_tab_local_info();
			invSteps.switch_to_tab_locinfo_list_price_by_type();
			String sKey = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", row, "KEY");
			String sCurrencyCode = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", row,
					"Currency Code");
			String sListPriceTypeCode = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", row,
					"List Price Type Code");
			String sListPriceTypeDesc = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", row,
					"List Price Type Desc");
			String sListPrice = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", row,
					"List Price");
			String sIsDefault = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE", row,
					"Is Default");
			String sForSetPriceDistribution = SessionData.getDataTbVal("GL_INVENTORY_LI_CUSTOMER_LIST_PRICE_BY_TYPE",
					row, "For Set Price Distribution");
			if (!sKey.isEmpty()) {
			}
			if (!sCurrencyCode.isEmpty()) {
				invSteps.click_btn_add_list_price_by_type();
				invSteps.enter_lpbt_new_currency_code(sCurrencyCode);
			}
			if (!sListPriceTypeCode.isEmpty()) {
				// invSteps.click_btn_add_list_price_by_type();
				invSteps.enter_lpbt_new_list_price_type_code(sListPriceTypeCode);
			}
			if (!sListPriceTypeDesc.isEmpty()) {
				invSteps.verify_lpbt_new_list_price_type_desc(sListPriceTypeDesc);
			}
			if (!sListPrice.isEmpty()) {
				invSteps.enter_lpbt_new_list_price(sListPrice);
			}
			if (!sIsDefault.isEmpty()) {
				invSteps.set_lpbt_new_is_default(sIsDefault);
			}
			if (!sForSetPriceDistribution.isEmpty()) {
				invSteps.set_lpbt_new_for_set_price_distribution(sForSetPriceDistribution);
			}
			invSteps.update();
		}
	}
	
	public void add_new_specification(String sSpecificationTestKey) throws Throwable {
		// Specification sheet
		HashMap<String, Integer> hSpeColNames = SessionData.getExcelColNameBySheetName("Inventory", "Specification");
		// int colSpeTestKey = hSpeColNames.get("TestKey");
		int colSpeLengthInch = hSpeColNames.get("Length inch");
		int colSpeBreadthInch = hSpeColNames.get("Breadth inch");
		int colSpeHeightInch = hSpeColNames.get("Height inch");
		int colSpeLengthMm = hSpeColNames.get("Length mm");
		int colSpeBreadthMm = hSpeColNames.get("Breadth mm");
		int colSpeHeightMm = hSpeColNames.get("Height mm");
		int colSpeVolume = hSpeColNames.get("Volume");
		int colSpeOuterDiameterInch = hSpeColNames.get("Outer Diameter inch");
		int colSpeInnerDiameterInch = hSpeColNames.get("Inner Diameter inch");
		int colSpeOuterLengthInch = hSpeColNames.get("Outer Length inch");
		int colSpeOuterDiameterMm = hSpeColNames.get("Outer Diameter mm");
		int colSpeInnerDiameterMm = hSpeColNames.get("Inner Diameter mm");
		int colSpeOuterLengthMm = hSpeColNames.get("Outer Length mm");
		int colSpeGrossWeight = hSpeColNames.get("Gross Weight");
		int colSpeNettWeight = hSpeColNames.get("Nett Weight");
		int colSpeWeightUOM = hSpeColNames.get("Weight UOM");
		int colSpeDensity = hSpeColNames.get("Density");
		int colSpeMeasureType = hSpeColNames.get("Measure Type");
		// Specification
		// String sSpecTestKey = "";
		String sLengthInch = "";
		String sBreadthInch = "";
		String sHeightInch = "";
		String sLengthMm = "";
		String sBreadthMm = "";
		String sHeightMm = "";
		String sVolume = "";
		String sOuterDiameterInch = "";
		String sInnerDiameterInch = "";
		String sOuterLengthInch = "";
		String sOuterDiameterMm = "";
		String sInnerDiameterMm = "";
		String sOuterLengthMm = "";
		String sGrossWeight = "";
		String sNettWeight = "";
		String sWeightUom = "";
		String sDensity = "";
		String sMeasureType = "";

		LinkedHashMap<Integer, List<String>> SpecificationData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Specification", "TestKey", sSpecificationTestKey);
		if (SpecificationData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_specification();
		for (Integer specKey : SpecificationData.keySet()) {
			// Parse data
			sLengthInch = SpecificationData.get(specKey).get(colSpeLengthInch);
			sBreadthInch = SpecificationData.get(specKey).get(colSpeBreadthInch);
			sHeightInch = SpecificationData.get(specKey).get(colSpeHeightInch);
			sLengthMm = SpecificationData.get(specKey).get(colSpeLengthMm);
			sBreadthMm = SpecificationData.get(specKey).get(colSpeBreadthMm);
			sHeightMm = SpecificationData.get(specKey).get(colSpeHeightMm);
			sVolume = SpecificationData.get(specKey).get(colSpeVolume);
			sOuterDiameterInch = SpecificationData.get(specKey).get(colSpeOuterDiameterInch);
			sInnerDiameterInch = SpecificationData.get(specKey).get(colSpeInnerDiameterInch);
			sOuterLengthInch = SpecificationData.get(specKey).get(colSpeOuterLengthInch);
			sOuterDiameterMm = SpecificationData.get(specKey).get(colSpeOuterDiameterMm);
			sInnerDiameterMm = SpecificationData.get(specKey).get(colSpeInnerDiameterMm);
			sOuterLengthMm = SpecificationData.get(specKey).get(colSpeOuterLengthMm);
			sGrossWeight = SpecificationData.get(specKey).get(colSpeGrossWeight);
			sNettWeight = SpecificationData.get(specKey).get(colSpeNettWeight);
			sWeightUom = SpecificationData.get(specKey).get(colSpeWeightUOM);
			sDensity = SpecificationData.get(specKey).get(colSpeDensity);
			sMeasureType = SpecificationData.get(specKey).get(colSpeMeasureType);
			// Do test
			if (!sLengthInch.isEmpty())
				invSteps.enter_length_inch(sLengthInch);
			if (!sBreadthInch.isEmpty())
				invSteps.enter_breadth_inch(sBreadthInch);
			if (!sHeightInch.isEmpty())
				invSteps.enter_height_inch(sHeightInch);
			if (!sLengthMm.isEmpty())
				invSteps.enter_length_mm(sLengthMm);
			if (!sBreadthMm.isEmpty())
				invSteps.enter_breadth_mm(sBreadthMm);
			if (!sHeightMm.isEmpty())
				invSteps.enter_height_mm(sHeightMm);
			if (!sVolume.isEmpty())
				invSteps.enter_volume(sVolume);
			if (!sOuterDiameterInch.isEmpty())
				invSteps.enter_outer_diameter_inch(sOuterDiameterInch);
			if (!sInnerDiameterInch.isEmpty())
				invSteps.enter_inner_diameter_inch(sInnerDiameterInch);
			if (!sOuterLengthInch.isEmpty())
				invSteps.enter_outer_length_inch(sOuterLengthInch);
			if (!sOuterDiameterMm.isEmpty())
				invSteps.enter_outer_diameter_mm(sOuterDiameterMm);
			if (!sInnerDiameterMm.isEmpty())
				invSteps.enter_inner_diameter_mm(sInnerDiameterMm);
			if (!sOuterLengthMm.isEmpty())
				invSteps.enter_outer_length_mm(sOuterLengthMm);
			if (!sGrossWeight.isEmpty())
				invSteps.enter_gross_weight(sGrossWeight);
			if (!sNettWeight.isEmpty())
				invSteps.enter_gross_weight(sNettWeight);
			if (!sWeightUom.isEmpty())
				invSteps.enter_weight_uom(sWeightUom);
			if (!sDensity.isEmpty())
				invSteps.enter_density(sDensity);
			if (!sMeasureType.isEmpty())
				invSteps.enter_measure_type(sMeasureType);
		}
	}

	public void add_new_healthcare(String sHealthcareTestKey) throws Throwable {
		// Healthcare
		HashMap<String, Integer> hHeathColNames = SessionData.getExcelColNameBySheetName("Inventory", "Healthcare");
		int colHlthDrugName = hHeathColNames.get("Drug Name");
		int colHlthTradeName = hHeathColNames.get("Trade Name");
		int colHlthStrength = hHeathColNames.get("Strength");
		int colHlthRoute = hHeathColNames.get("Route");
		int colHlthControlledDrugMohReportingReq = hHeathColNames.get("Controlled Drug, MOH reporting req");
		int colHlthGenerateProductLabel = hHeathColNames.get("Generate Product Label");
		int colHlthPrescriptionDesc = hHeathColNames.get("Prescription Desc");
		int colHlthQty = hHeathColNames.get("Qty");
		int colHlthUom = hHeathColNames.get("UOM");
		int colHlthFrequency = hHeathColNames.get("Frequency");
		int colHlthFrequencyDesc = hHeathColNames.get("Frequency Desc");
		int colHlthDuration = hHeathColNames.get("Duration");
		int colHlthDrugUseCode = hHeathColNames.get("Drug Use Code");
		int colHlthAdditionalInfoCode = hHeathColNames.get("Additional Info Code");
		// Healthcare
		String sDrugName = "";
		String sTradeName = "";
		String sStrength = "";
		String sRoute = "";
		String sControlledDrugMohReportingReq = "";
		String sGenerateProductLabel = "";
		String sPrescriptionDesc = "";
		String sQty = "";
		String sUom = "";
		String sFrequency = "";
		String sFrequencyDesc = "";
		String sDuration = "";
		String sDrugUseCode = "";
		String sAdditionalInfoCode = "";
		LinkedHashMap<Integer, List<String>> HealthcareData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Healthcare", "TestKey", sHealthcareTestKey);
		if (HealthcareData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_healthcare();
		for (Integer key : HealthcareData.keySet()) { // do test
			// Parse data
			sDrugName = HealthcareData.get(key).get(colHlthDrugName);
			sTradeName = HealthcareData.get(key).get(colHlthTradeName);
			sStrength = HealthcareData.get(key).get(colHlthStrength);
			sRoute = HealthcareData.get(key).get(colHlthRoute);
			sControlledDrugMohReportingReq = HealthcareData.get(key).get(colHlthControlledDrugMohReportingReq);
			sGenerateProductLabel = HealthcareData.get(key).get(colHlthGenerateProductLabel);
			sPrescriptionDesc = HealthcareData.get(key).get(colHlthPrescriptionDesc);
			sQty = HealthcareData.get(key).get(colHlthQty);
			sUom = HealthcareData.get(key).get(colHlthUom);
			sFrequency = HealthcareData.get(key).get(colHlthFrequency);
			sFrequencyDesc = HealthcareData.get(key).get(colHlthFrequencyDesc);
			sDuration = HealthcareData.get(key).get(colHlthDuration);
			sDrugUseCode = HealthcareData.get(key).get(colHlthDrugUseCode);
			sAdditionalInfoCode = HealthcareData.get(key).get(colHlthAdditionalInfoCode);

			// Input
			invSteps.click_btn_add_drug_detail();
			if (!sDrugName.isEmpty())
				invSteps.enter_drug_name(sDrugName);
			if (!sTradeName.isEmpty())
				invSteps.enter_trade_name(sTradeName);
			if (!sStrength.isEmpty())
				invSteps.enter_strength(sStrength);
			if (!sRoute.isEmpty())
				invSteps.enter_route(sRoute);
			if (!sControlledDrugMohReportingReq.isEmpty())
				invSteps.select_option_controlled_drug_moh_reporting_req(sControlledDrugMohReportingReq);
			if (!sGenerateProductLabel.isEmpty())
				invSteps.select_option_generate_product_label(sGenerateProductLabel);
			if (!sPrescriptionDesc.isEmpty())
				invSteps.enter_prescription_desc(sPrescriptionDesc);
			if (!sQty.isEmpty())
				invSteps.enter_qty(sQty);
			if (!sUom.isEmpty())
				invSteps.enter_uom(sUom);
			if (!sFrequency.isEmpty())
				invSteps.enter_frequency(sFrequency);
			if (!sFrequencyDesc.isEmpty())
				invSteps.enter_frequency_desc(sFrequencyDesc);
			if (!sDuration.isEmpty())
				invSteps.enter_duration(sDuration);
			if (!sDrugUseCode.isEmpty()) {
				invSteps.click_btn_add_drug_use();
				invSteps.enter_new_drug_use_code(sDrugUseCode);
			}
			if (!sAdditionalInfoCode.isEmpty()) {
				invSteps.click_btn_add_drug_add_info();
				invSteps.enter_new_drug_add_info(sAdditionalInfoCode);
			}
		}
	}

	public void add_new_package_size(String sPackSizeTestKey) throws Throwable {
		// Pack size
		HashMap<String, Integer> hPackSizeColNames = SessionData.getExcelColNameBySheetName("Inventory", "Pack Size");
		int colSpePackSizeCode = hPackSizeColNames.get("Pack Size Code");
		int colSpeDescription = hPackSizeColNames.get("Description");
		int colSpeConvertFromPackSize = hPackSizeColNames.get("Convert from Pack Size");
		int colSpeQtyInOtherPackSize = hPackSizeColNames.get("Qty in Other Pack Size");
		int colSpeQtyInBaseUom = hPackSizeColNames.get("Qty in Base UOM");
		int colSpeEnableInMobilePreSales = hPackSizeColNames.get("Enable in Mobile Pre Sales");
		int colSpeEnableBaseUomInMobilePreSales = hPackSizeColNames.get("Enable Base UOM in Mobile Pre Sales");
		// Pack Size
		String sPackSizeCode = "";
		String sPackSizeDescription = "";
		String sConvertFromPackSize = "";
		String sQtyInOtherPackSize = "";
		String sQtyInBaseUom = "";
		String sEnableInMobilePreSales = "";
		String sEnableBaseUomInMobilePreSales = "";

		LinkedHashMap<Integer, List<String>> PackSizeData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Pack Size", "TestKey", sPackSizeTestKey);
		if (PackSizeData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_pack_size();
		for (Integer key : PackSizeData.keySet()) { // do test
			// Parse data
			sPackSizeCode = PackSizeData.get(key).get(colSpePackSizeCode);
			sPackSizeDescription = PackSizeData.get(key).get(colSpeDescription);
			sConvertFromPackSize = PackSizeData.get(key).get(colSpeConvertFromPackSize);
			sQtyInOtherPackSize = PackSizeData.get(key).get(colSpeQtyInOtherPackSize);
			sQtyInBaseUom = PackSizeData.get(key).get(colSpeQtyInBaseUom);
			sEnableInMobilePreSales = PackSizeData.get(key).get(colSpeEnableInMobilePreSales);
			sEnableBaseUomInMobilePreSales = PackSizeData.get(key).get(colSpeEnableBaseUomInMobilePreSales);
			// Do test
			invSteps.click_btn_add_pack_size_cd();
			if (!sEnableBaseUomInMobilePreSales.isEmpty()) {
				invSteps.set_chkbox_enable_base_uom_in_Mobile_Pre_Sales(sEnableBaseUomInMobilePreSales);
			}
			if (!sPackSizeCode.isEmpty()) {
				invSteps.enter_new_pack_size_code(sPackSizeCode);
			}
			if (!sPackSizeDescription.isEmpty()) {
				invSteps.enter_new_pack_size_cd_description(sPackSizeDescription);
			}
			if (!sConvertFromPackSize.isEmpty()) {
				invSteps.select_new_convert_from_pack_size(sConvertFromPackSize);
			}
			if (!sQtyInOtherPackSize.isEmpty()) {
				invSteps.enter_new_qty_in_other_pack_size(sQtyInOtherPackSize);
			}
			if (!sQtyInBaseUom.isEmpty()) {
				invSteps.enter_new_qty_in_base_uom(sQtyInBaseUom);
			}
			if (!sEnableInMobilePreSales.isEmpty()) {
				invSteps.set_enable_in_mobile_pre_sales(sEnableInMobilePreSales);
			}
		}
	}

	public void add_new_supplier(String sSupplierTestKey) throws Throwable {
		// Supplier column
		HashMap<String, Integer> hSupplierColNames = SessionData.getExcelColNameBySheetName("Inventory", "Supplier");
		int colSupSupplier = hSupplierColNames.get("Supplier");
		int colSupPartyInventoryCode = hSupplierColNames.get("Party Inventory Code");
		int colSupDefaultDescription = hSupplierColNames.get("Default Description");
		int colSupBillingDescription = hSupplierColNames.get("Billing Description");
		int colSupRemarks = hSupplierColNames.get("Remarks");
		int colSupMinOrderQty = hSupplierColNames.get("Min Order Qty");
		int colSupLeadTimeInDays = hSupplierColNames.get("Lead Time in Days");
		int colSupStdPackSize = hSupplierColNames.get("Std Pack Size");
		int colSupHomeUnitCost = hSupplierColNames.get("Home Unit Cost");
		int colSupDefault = hSupplierColNames.get("Default");
		// Supplier
		String sSupplier = "";
		String sPartyInventoryCode = "";
		String sDefaultDescription = "";
		String sBillingDescription = "";
		String sRemarks = "";
		String sMinOrderQty = "";
		String sLeadTimeInDays = "";
		String sStdPackSize = "";
		String sHomeUnitCost = "";
		String sDefault = "";
		LinkedHashMap<Integer, List<String>> SupplierData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Supplier", "TestKey", sSupplierTestKey);
		if (SupplierData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_supplier();
		for (Integer key : SupplierData.keySet()) {
			// Parse data
			sSupplier = SupplierData.get(key).get(colSupSupplier);
			sPartyInventoryCode = SupplierData.get(key).get(colSupPartyInventoryCode);
			sDefaultDescription = SupplierData.get(key).get(colSupDefaultDescription);
			sBillingDescription = SupplierData.get(key).get(colSupBillingDescription);
			sRemarks = SupplierData.get(key).get(colSupRemarks);
			sMinOrderQty = SupplierData.get(key).get(colSupMinOrderQty);
			sLeadTimeInDays = SupplierData.get(key).get(colSupLeadTimeInDays);
			sStdPackSize = SupplierData.get(key).get(colSupStdPackSize);
			sHomeUnitCost = SupplierData.get(key).get(colSupHomeUnitCost);
			sDefault = SupplierData.get(key).get(colSupDefault);
			// Do test
			if (!sSupplier.isEmpty()) {
				invSteps.click_btn_add_supplier();
				invSteps.enter_new_supplier(sSupplier);
			} else {
				continue;
			}
			if (!sPartyInventoryCode.isEmpty()) {
				invSteps.enter_new_party_inventory_code(sPartyInventoryCode);
			}
			if (!sDefaultDescription.isEmpty()) {
				invSteps.enter_new_default_description(sDefaultDescription);
			}
			if (!sBillingDescription.isEmpty()) {
				invSteps.enter_new_billing_description(sBillingDescription);
			}
			if (!sRemarks.isEmpty()) {
				invSteps.enter_new_remarks(sRemarks);
			}
			if (!sMinOrderQty.isEmpty()) {
				invSteps.enter_new_min_order_qty(sMinOrderQty);
			}
			if (!sLeadTimeInDays.isEmpty()) {
				invSteps.enter_new_lead_time_in_days(sLeadTimeInDays);
			}
			if (!sStdPackSize.isEmpty()) {
				invSteps.enter_new_std_pack_size(sStdPackSize);
			}
			if (!sHomeUnitCost.isEmpty()) {
				invSteps.enter_new_home_unit_cost(sHomeUnitCost);
			}
			if (!sDefault.isEmpty()) {
				invSteps.set_default_supplier(sDefault);
			}

		}
	}

	public void add_new_content(String sContentTestKey) throws Throwable {
		// Content column
		String sContentContentCode = "";
		String sContentDescription = "";
		String sContentDefaultPercentage = "";
		String sContentDefaultRecoveryRate = "";
		// Content
		HashMap<String, Integer> hContentColNames = SessionData.getExcelColNameBySheetName("Inventory", "Content");
		int colContentContentCode = hContentColNames.get("Content Code");
		int colContentDescription = hContentColNames.get("Description");
		int colContentDefaultPercentage = hContentColNames.get("Default Percentage");
		int colContentDefaultRecoveryRate = hContentColNames.get("Default Recovery Rate");

		LinkedHashMap<Integer, List<String>> ContentData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Content", "TestKey", sContentTestKey);
		if (ContentData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_content();
		for (Integer keyContent : ContentData.keySet()) { // do test
			// Parse data
			sContentContentCode = ContentData.get(keyContent).get(colContentContentCode);
			sContentDescription = ContentData.get(keyContent).get(colContentDescription);
			sContentDefaultPercentage = ContentData.get(keyContent).get(colContentDefaultPercentage);
			sContentDefaultRecoveryRate = ContentData.get(keyContent).get(colContentDefaultRecoveryRate);
			// Do test
			if (!sContentContentCode.isEmpty()) {
				invSteps.click_btn_add_new_content();
				invSteps.enter_new_content_code(sContentContentCode);
			} else {
				continue;
			}
			if (!sContentDescription.isEmpty()) {
				invSteps.verify_new_content_description(sContentDescription);
			}
			if (!sContentDefaultPercentage.isEmpty()) {
				invSteps.enter_content_new_default_percentage(sContentDefaultPercentage);
			}
			if (!sContentDefaultRecoveryRate.isEmpty()) {
				invSteps.enter_content_new_default_recovery_rate(sContentDefaultRecoveryRate);
			}
		}
	}

	public void add_new_attachment(String sAttachmentsTestKey) throws Throwable {
		// Attachment column index
		HashMap<String, Integer> hAttColNames = SessionData.getExcelColNameBySheetName("Inventory", "Attachments");
		int colAttFileName = hAttColNames.get("File Name");
		int colAttFileDescription = hAttColNames.get("File Description");
		// Attachments
		String sFileName = "";
		String sFileDescription = "";

		LinkedHashMap<Integer, List<String>> AttachmentsData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Attachments", "TestKey", sAttachmentsTestKey);
		if (AttachmentsData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_attachments();
		for (Integer key : AttachmentsData.keySet()) { // do test
			// Parse data
			sFileName = AttachmentsData.get(key).get(colAttFileName);
			sFileDescription = AttachmentsData.get(key).get(colAttFileDescription);
			// Do test
			if (!sFileName.isEmpty()) {
				invSteps.click_btn_add_new_attachment();
				invSteps.choose_attachment_file(sFileName);
				invSteps.click_btn_upload_attachment();
			}
			if (!sFileDescription.isEmpty()) {
				invSteps.enter_new_file_description(sFileDescription);
			}
		}
	}

	public void add_new_location_information(String sLocationInformationTestkey) throws Throwable {
		// Location information
		HashMap<String, Integer> hLocInfColNames = SessionData.getExcelColNameBySheetName("Inventory",
				"Location information");
		int colLocLocationCode = hLocInfColNames.get("Location Code");
		int colLocLocationName = hLocInfColNames.get("Location Name");
		int colLocMinHoldingQty = hLocInfColNames.get("Min Holding Qty");
		int colLocMaxHoldingQty = hLocInfColNames.get("Max Holding Qty");
		int colLocRemarks = hLocInfColNames.get("Remarks");
		// Location Information
		String sLocationCode = "";
		String sLocationName = "";
		String sMinHoldingQty = "";
		String sMaxHoldingQty = "";
		String sLocInfoRemarks = "";

		LinkedHashMap<Integer, List<String>> LocationInfoData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Location information", "TestKey", sLocationInformationTestkey);
		if (LocationInfoData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_locinfo_location();
		for (Integer keyDetail : LocationInfoData.keySet()) {
			// Parse data
			sLocationCode = LocationInfoData.get(keyDetail).get(colLocLocationCode);
			sLocationName = LocationInfoData.get(keyDetail).get(colLocLocationName);
			sMinHoldingQty = LocationInfoData.get(keyDetail).get(colLocMinHoldingQty);
			sMaxHoldingQty = LocationInfoData.get(keyDetail).get(colLocMaxHoldingQty);
			sLocInfoRemarks = LocationInfoData.get(keyDetail).get(colLocRemarks);
			// Do test
			if (!sLocationCode.isEmpty()) {
				invSteps.click_btn_add_location_information();
				invSteps.enter_new_location_code(sLocationCode);
			} else {
				continue;
			}
			if (!sLocationName.isEmpty()) {
				invSteps.verify_location_name(sLocationName);
			}
			if (!sMinHoldingQty.isEmpty()) {
				invSteps.enter_new_min_holding_qty(sMinHoldingQty);
			}
			if (!sMaxHoldingQty.isEmpty()) {
				invSteps.enter_new_max_holding_qty(sMaxHoldingQty);
			}
			if (!sLocInfoRemarks.isEmpty()) {
				invSteps.enter_new_local_information_remarks(sLocInfoRemarks);
			}
		}
	}

	public void add_new_bin_information(String sBinInformationTestkey) throws Throwable {
		// Bin information data column
		HashMap<String, Integer> hBinInfColNames = SessionData.getExcelColNameBySheetName("Inventory", "Bin Information");
		int colBinRow = hBinInfColNames.get("Row");
		int colBinColumn = hBinInfColNames.get("Column");
		int colBinLevel = hBinInfColNames.get("Level");
		int colBinDescription = hBinInfColNames.get("Description");

		// Bin Information
		String sBinRow = "";
		String sBinColumn = "";
		String sBinLevel = "";
		String sBinRowDescription = "";

		LinkedHashMap<Integer, List<String>> BinInfoData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Bin Information", "TestKey", sBinInformationTestkey);
		if (BinInfoData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_locinfo_location();
		for (Integer keyDetail : BinInfoData.keySet()) {
			// Parse data
			sBinRow = BinInfoData.get(keyDetail).get(colBinRow);
			sBinColumn = BinInfoData.get(keyDetail).get(colBinColumn);
			sBinLevel = BinInfoData.get(keyDetail).get(colBinLevel);
			sBinRowDescription = BinInfoData.get(keyDetail).get(colBinDescription);

			// Do test
			if (!sBinRow.isEmpty()) {
				invSteps.click_btn_add_bin_information();
				invSteps.enter_new_bin_row(sBinRow);
			} else {
				continue;
			}
			if (!sBinColumn.isEmpty()) {
				invSteps.enter_new_bin_column(sBinColumn);
			}
			if (!sBinLevel.isEmpty()) {
				invSteps.enter_new_bin_level(sBinLevel);
			}
			if (!sBinRowDescription.isEmpty()) {
				invSteps.enter_new_bin_description(sBinRowDescription);
			}
		}
	}

	public void add_new_customer_information(String sCustomerInformationTestkey) throws Throwable {
		// Customer information
		HashMap<String, Integer> hCusInfColNames = SessionData.getExcelColNameBySheetName("Inventory",
				"Customer Information");
		int colCusMoqInLoose = hCusInfColNames.get("MOQ In Loose");
		int colCusCustomer = hCusInfColNames.get("Customer");
		int colCusCustomerName = hCusInfColNames.get("Customer Name");
		int colCusPartyInventoryCode = hCusInfColNames.get("Party Inventory Code");
		int colCusDefaultDescription = hCusInfColNames.get("Default Description");
		int colCusBillingDescription = hCusInfColNames.get("Billing Description");
		int colCusDSales = hCusInfColNames.get("D-Sales %");
		int colCusOSales = hCusInfColNames.get("O-Sales %");
		int colCusRemarks = hCusInfColNames.get("Remarks");
		// Customer Information
		String sCusMoqInLoose = "";
		String sCusCustomer = "";
		String sCusCustomerName = "";
		String sCusPartyInventoryCode = "";
		String sCusDefaultDescription = "";
		String sCusBillingDescription = "";
		String sCusDSales = "";
		String sCusOSales = "";
		String sCusRemarks = "";

		LinkedHashMap<Integer, List<String>> CusInfoData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Customer Information", "TestKey", sCustomerInformationTestkey);
		if (CusInfoData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_locinfo_customer();
		for (Integer keyDetail : CusInfoData.keySet()) {
			// Parse data
			sCusMoqInLoose = CusInfoData.get(keyDetail).get(colCusMoqInLoose);
			sCusCustomer = CusInfoData.get(keyDetail).get(colCusCustomer);
			sCusCustomerName = CusInfoData.get(keyDetail).get(colCusCustomerName);
			sCusPartyInventoryCode = CusInfoData.get(keyDetail).get(colCusPartyInventoryCode);
			sCusDefaultDescription = CusInfoData.get(keyDetail).get(colCusDefaultDescription);
			sCusBillingDescription = CusInfoData.get(keyDetail).get(colCusBillingDescription);
			sCusDSales = CusInfoData.get(keyDetail).get(colCusDSales);
			sCusOSales = CusInfoData.get(keyDetail).get(colCusOSales);
			sCusRemarks = CusInfoData.get(keyDetail).get(colCusRemarks);
			// Do test
			if (!sCusMoqInLoose.isEmpty()) {
				invSteps.enter_moq_in_loose(sCusMoqInLoose);
			}
			if (!sCusCustomer.isEmpty()) {
				invSteps.click_btn_add_cus_information();
				invSteps.enter_new_cus_customer(sCusCustomer);
			} else {
				continue;
			}
			if (!sCusCustomerName.isEmpty()) {
				invSteps.verify_new_cus_customer_name(sCusCustomerName);
			}
			if (!sCusPartyInventoryCode.isEmpty()) {
				invSteps.enter_new_cus_party_inventory_code(sCusPartyInventoryCode);
			}
			if (!sCusDefaultDescription.isEmpty()) {
				invSteps.enter_new_cus_default_description(sCusDefaultDescription);
			}
			if (!sCusBillingDescription.isEmpty()) {
				invSteps.enter_new_cus_billing_description(sCusBillingDescription);
			}
			if (!sCusDSales.isEmpty()) {
				invSteps.enter_new_cus_d_sales_(sCusDSales);
			}
			if (!sCusOSales.isEmpty()) {
				invSteps.enter_new_cus_o_sales(sCusOSales);
			}
			if (!sCusRemarks.isEmpty()) {
				invSteps.enter_new_cus_remarks(sCusRemarks);
			}
		}
	}

	public void add_new_customer_doc(String sCustomerDocTestkey) throws Throwable {
		// Customer Doc
		HashMap<String, Integer> hDocColNames = SessionData.getExcelColNameBySheetName("Inventory", "Customer Doc");
		int colDocDocumentCode = hDocColNames.get("Document Code");
		int colDocDescription = hDocColNames.get("Description");
		int colDocDocumentType = hDocColNames.get("Document Type");
		int colDocCurrentRevision = hDocColNames.get("Current Revision");
		int colDocAttachment = hDocColNames.get("Attachment");
		// Documment
		String sDocDocumentCode = "";
		String sDocDescription = "";
		String sDocDocumentType = "";
		String sDocCurrentRevision = "";
		String sDocAttachment = "";

		LinkedHashMap<Integer, List<String>> DocData = SessionData.getExcelDataRowsEqualVal("Inventory",
				"Customer Doc", "TestKey", sCustomerDocTestkey);
		if (DocData.size() == 0) {
			// fail.datanotfound
		}
		invSteps.switch_to_tab_locinfo_customer_doc();
		for (Integer keyDetail : DocData.keySet()) {
			// Parse data
			sDocDocumentCode = DocData.get(keyDetail).get(colDocDocumentCode);
			sDocDescription = DocData.get(keyDetail).get(colDocDescription);
			sDocDocumentType = DocData.get(keyDetail).get(colDocDocumentType);
			sDocCurrentRevision = DocData.get(keyDetail).get(colDocCurrentRevision);
			sDocAttachment = DocData.get(keyDetail).get(colDocAttachment);

			// Do test
			if (!sDocDocumentCode.isEmpty()) {
				invSteps.click_btn_add_document();
				invSteps.enter_doc_new_document_code(sDocDocumentCode);
			} else {
				continue;
			}
			if (!sDocDescription.isEmpty()) {
				invSteps.verify_doc_new_description(sDocDescription);
			}
			if (!sDocDocumentType.isEmpty()) {
				invSteps.verify_doc_new_document_type(sDocDocumentType);
			}
			if (!sDocCurrentRevision.isEmpty()) {
				invSteps.verify_doc_new_current_revision(sDocCurrentRevision);
			}
			if (!sDocAttachment.isEmpty()) {
				invSteps.verify_doc_new_attachment(sDocAttachment);
			}
		}
	}

	// Tag company
	public void tag_company(String sTagCompanyTestKey) throws Throwable {
		// Company sheet
		HashMap<String, Integer> hCompanyColNames = SessionData.getExcelColNameBySheetName("Inventory", "Company Name");
		int colCompanyName = hCompanyColNames.get("Company Name");

		if (!sTagCompanyTestKey.isEmpty()) { // Tag company
			LinkedHashMap<Integer, List<String>> CompanyData = SessionData.getExcelDataRowsEqualVal("Inventory",
					"Company Name", "TestKey", sTagCompanyTestKey);
			if (CompanyData.size() == 0) {
				// fail.datanotfound
			}
			invSteps.switch_to_tab_company();
			for (Integer comKey : CompanyData.keySet()) { // Tag company
				invSteps.tag_company_name(CompanyData.get(comKey).get(colCompanyName));
			}
			invSteps.update();
		}
	}

	// List Price By Type
	public void add_new_list_price_by_type(String sLPByTypeTestkey) {
		// List Price By Type column header index
		HashMap<String, Integer> hLPColNames = SessionData.getExcelColNameBySheetName("Inventory", "List Price By Type");
		int colLPCurrencyCode = hLPColNames.get("Currency Code");
		int colLPLPTypeCode = hLPColNames.get("List Price Type Code");
		int colLPLPTypeDesc = hLPColNames.get("List Price Type Desc");
		int colLPLPListPrice = hLPColNames.get("List Price");
		int colLPIsDefault = hLPColNames.get("Is Default");
		int colLPForSetPriceDistribution = hLPColNames.get("For Set Price Distribution");
		// List Price By Type
		String sLPCurrencyCode = "";
		String sLPLPTypeCode = "";
		String sLPLPTypeDesc = "";
		String sLPLPListPrice = "";
		String sLPIsDefault = "";
		String sLPForSetPriceDistribution = "";

		if (!sLPByTypeTestkey.isEmpty()) {
			LinkedHashMap<Integer, List<String>> LPData = SessionData.getExcelDataRowsEqualVal("Inventory",
					"List Price By Type", "TestKey", sLPByTypeTestkey);
			if (LPData.size() == 0) {
				// fail.datanotfound
			}
			invSteps.switch_to_tab_locinfo_list_price_by_type();
			for (Integer keyDetail : LPData.keySet()) {
				// Parse data
				sLPCurrencyCode = LPData.get(keyDetail).get(colLPCurrencyCode);
				sLPLPTypeCode = LPData.get(keyDetail).get(colLPLPTypeCode);
				sLPLPTypeDesc = LPData.get(keyDetail).get(colLPLPTypeDesc);
				sLPLPListPrice = LPData.get(keyDetail).get(colLPLPListPrice);
				sLPIsDefault = LPData.get(keyDetail).get(colLPIsDefault);
				sLPForSetPriceDistribution = LPData.get(keyDetail).get(colLPForSetPriceDistribution);
				// Do test
				if (!sLPCurrencyCode.isEmpty()) {
					invSteps.click_btn_add_list_price_by_type();
					invSteps.enter_lpbt_new_currency_code(sLPCurrencyCode);
				}
				if (!sLPLPTypeCode.isEmpty()) {
					// invSteps.click_btn_add_list_price_by_type();
					invSteps.enter_lpbt_new_list_price_type_code(sLPLPTypeCode);
				}
				if (!sLPLPTypeDesc.isEmpty()) {
					invSteps.verify_lpbt_new_list_price_type_desc(sLPLPTypeDesc);
				}
				if (!sLPLPListPrice.isEmpty()) {
					invSteps.enter_lpbt_new_list_price(sLPLPListPrice);
				}
				if (!sLPIsDefault.isEmpty()) {
					invSteps.set_lpbt_new_is_default(sLPIsDefault);
				}
				if (!sLPForSetPriceDistribution.isEmpty()) {
					invSteps.set_lpbt_new_for_set_price_distribution(sLPForSetPriceDistribution);
				}
			}
		}
	}

}
