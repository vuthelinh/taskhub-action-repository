package com.synergix.operations.project;

import com.synergix.common.steps.MenuNavigationSteps;
import com.synergix.globalsetup.inventory.classification.steps.BrandSteps;
import com.synergix.globalsetup.inventory.steps.InventorySteps;
import com.synergix.globalsetup.party.steps.PartySteps;
import com.synergix.globalsetup.party.supplier.steps.SupplierSteps;
import com.synergix.globalsetup.project.steps.ProjectCategorySteps;
import com.synergix.globalsetup.service.steps.ServiceSteps;
import com.synergix.mastersetup.project.steps.CostItemGroupSteps;
import com.synergix.mastersetup.project.steps.DrawingObjectSteps;
import com.synergix.mastersetup.project.steps.PolicyTypeSteps;
import com.synergix.mtsetup.administration.company.steps.StrategicBusinessUnitSteps;
import com.synergix.mtsetup.administration.documentnumbering.steps.ProcessingNumberingSteps;
import com.synergix.mtsetup.administration.employee.steps.ApprovingOfficerSteps;
import com.synergix.mtsetup.pricing.inventory.steps.SupplierInventoryPriceListSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by Ian on 8/11/2016.
 * Description Input test data for Project Quotation
 */
public class DataForQuotationTestingDefs {

    @Steps
    MenuNavigationSteps menuNavigation;

    @Steps
    ProjectCategorySteps projectCategory;

    @Given("^user create Project Category$")
    public void user_create_project_category(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Project>Project Category>[2]");

        String dataTableKey = "DelugeProjectCategory";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colProjectCategoryCode = "Project Category Code";
        String colDescription = "Description";

        for (int rowProjectCategory : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String projectCategoryCode = SessionData.getDataTbVal(dataTableKey, rowProjectCategory, colProjectCategoryCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowProjectCategory, colDescription);

            if (!projectCategoryCode.isEmpty()) {
                projectCategory.create_new_project_category(projectCategoryCode, description);
            }
        }

        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    StrategicBusinessUnitSteps strategicBusinessUnit;

    @And("^user create Strategic Business Unit$")
    public void user_create_strategic_business_unit(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Company>Strategic Business Unit");

        String dataTableKey = "DelugeStrategicBusinessUnit";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colSbuCode = "SBU Code";
        String colDescription = "Description";

        for (int rowSbuCode : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String sbuCode = SessionData.getDataTbVal(dataTableKey, rowSbuCode, colSbuCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowSbuCode, colDescription);

            if (!sbuCode.isEmpty()) {
                strategicBusinessUnit.create_new_strategic_business_unit(sbuCode, description);
            }
        }
    }

    @Steps
    private PartySteps party;

    @And("^user create Party$")
    public void user_create_party(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Party>Party");

        String dataTableKey = "DelugeDelugeParty";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colPartyCode = "Party Code";
        String colPartyName = "Party Name";

        for (int rowPartyCode : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String partyCode = SessionData.getDataTbVal(dataTableKey, rowPartyCode, colPartyCode);
            String partyName = SessionData.getDataTbVal(dataTableKey, rowPartyCode, colPartyName);

            if (!partyCode.isEmpty()) {
                party.create_new_party(partyCode, partyName);
            }
        }

        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private SupplierSteps supplier;

    @And("^user create Supplier$")
    public void userCreateSupplier(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Supplier>Supplier");
        supplier.switchToIFrame();
        String dataTableKey = "DelugeSupplier";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colSupplier = "Supplier";
        String colSupplierName = "Supplier Name";
        String colSupplierClassCode = "Supplier Class Code";
        String colCurrency = "Currency";


        for (int rowSupplier : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String supplierCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplier);
            String supplierName = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierName);
            String supplierClassCode = SessionData.getDataTbVal(dataTableKey, rowSupplier, colSupplierClassCode);
            String currency = SessionData.getDataTbVal(dataTableKey, rowSupplier, colCurrency);

            if (!supplierCode.isEmpty()) {
                supplier.create_new_supplier(supplierCode, supplierName, supplierClassCode, currency);
            } else if (!currency.isEmpty()) {
                supplier.add_curency(currency);
            }
        }
        supplier.switchOutDefaultIFrame();
        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private BrandSteps brand;

    @And("^user create Brand$")
    public void user_create_brand(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Inventory>Brand");

        String dataTableKey = "Brand";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colInventoryBrandCode = "Inventory Brand Code";
        String colDescription = "Description";

        for (int rowBrand : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {

            String inventoryBrandCode = SessionData.getDataTbVal(dataTableKey, rowBrand, colInventoryBrandCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowBrand, colDescription);
            if (!inventoryBrandCode.isEmpty()) {
                brand.create_new_brand(inventoryBrandCode, description);
            }
        }

        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private InventorySteps inventory;

    @And("^user create new Inventory Item$")
    public void user_create_new_inventory_item(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Inventory>Inventory");

        inventory.switchToIFrame();
        inventory.click_btn_New_of_summary();
        inventory.switchOutDefaultIFrame();

        String dataTableKey = "InventoryItem";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colInventoryCode = "Inventory Code";
        String colDescription = "Description";
        String colBaseUOM = "Base UOM";
        String colInventoryClass = "Inventory Class";
        String colInventoryBrand = "Inventory Brand";

        for (int rowInventoryItem : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String inventoryCode = SessionData.getDataTbVal(dataTableKey, rowInventoryItem, colInventoryCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowInventoryItem, colDescription);
            String baseUOM = SessionData.getDataTbVal(dataTableKey, rowInventoryItem, colBaseUOM);
            String inventoryClass = SessionData.getDataTbVal(dataTableKey, rowInventoryItem, colInventoryClass);
            String inventoryBrand = SessionData.getDataTbVal(dataTableKey, rowInventoryItem, colInventoryBrand);

            if (!inventoryCode.isEmpty()) {
                inventory.create_new_inventory_item(inventoryCode, description, baseUOM, inventoryClass, inventoryBrand);
            }
        }
        menuNavigation.clickOnHomeIcon();

    }

    @Steps
    private ServiceSteps service;

    @And("^user create Service$")
    public void user_create_service(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Service>Service");

        String dataTableKey = "ServiceItem";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colServiceCode = "Service Code";
        String colDescription = "Description";
        String colExpenseGLAN = "Expense GLAN";


        for (int rowServiceItem : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String serviceCode = SessionData.getDataTbVal(dataTableKey, rowServiceItem, colServiceCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowServiceItem, colDescription);
            String expenseGLAN = SessionData.getDataTbVal(dataTableKey, rowServiceItem, colExpenseGLAN);

            service.create_new_service(serviceCode, description, expenseGLAN);

        }
        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private PolicyTypeSteps policyType;

    @And("^user create Policy Type$")
    public void user_create_policy_type(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Project>Policy Type");

        String dataTableKey = "PolicyType";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colPolicyTypeCode = "Policy Type Code";
        String colDescription = "Description";

        for (int rowPolicyType : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String policyTypeCode = SessionData.getDataTbVal(dataTableKey, rowPolicyType, colPolicyTypeCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowPolicyType, colDescription);

            policyType.create_new_policy_type(policyTypeCode, description);
        }
        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private CostItemGroupSteps costItemGroup;

    @And("^user create Cost Item Group$")
    public void user_create_cost_item_group(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Project>Cost Item Group>[2]");
        String dataTableKey = "CostItemGroup";
        SessionData.addDataTable(dataTableKey, dataTable);
        String colCostItemGroupCode = "Cost Item Group Code";
        String colDescription = "Description";

        for (int rowCostItemGroup : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String costItemGroupCode = SessionData.getDataTbVal(dataTableKey, rowCostItemGroup, colCostItemGroupCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowCostItemGroup, colDescription);
            costItemGroup.create_new_cost_item_group(costItemGroupCode, description);
        }
        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private DrawingObjectSteps drawingObject;

    @And("^user create Drawing Object$")
    public void user_create_drawing_object(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Project>Drawing Object Maintenance");

        String dataTableKey = "DrawingObject";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colDrawingObjectCode = "Drawing Object Code";
        String colDescription = "Description";
        String colCostItemGroup = "Cost Item Group";
        String colBrand = "Brand";
        String colInventory = "Inventory";
        String colDateFrom = "Date From";
        String colDateTo = "Date To";
        String colQty = "Qty";
        String colUOM = "UOM";

        for (int rowDrawingObject : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String drawingObjectCode = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colDrawingObjectCode);
            String description = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colDescription);
            String costItemGroup = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colCostItemGroup);
            String brand = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colBrand);
            String inventory = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colInventory);
            String dateFrom = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colDateFrom);
            String dateTo = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colDateTo);
            String qty = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colQty);
            String uom = SessionData.getDataTbVal(dataTableKey, rowDrawingObject, colUOM);

            if (!drawingObjectCode.isEmpty()) {
                drawingObject.create_new_drawing_object(drawingObjectCode, description, costItemGroup);
            }

            if (!brand.isEmpty()) {
                drawingObject.add_brand_inventory(brand, inventory);
            }

            if (!dateFrom.isEmpty()) {
                drawingObject.add_labour_budget(dateFrom, dateTo, qty, uom);
            }


        }

        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private SupplierInventoryPriceListSteps supplierInventoryPriceList;

    @And("^user maintain Supplier Inventory Price List$")
    public void user_maintain_supplier_inventory_price_list(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Price & Cost>Supplier Inventory Price List");
        supplierInventoryPriceList.switch_iframe();

        String dataTableKey = "SupplierInventoryPriceList";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colSupplier = "Supplier";
        String colCurrency = "Currency";
        String colEffectiveDateFrom = "Effective Date From";
        String colEffectiveDateTo = "Effective Date To";
        String colInventoryCode = "Inventory Code";
        String colUnitPrice = "Unit Price";
        String colPriceByQuantityRange = "Price By Quantity Range";
        String colQtyFrom = "Qty From";
        String colQtyTo = "Qty To (<)";

        for (int rowSupplierInventoryPriceList : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String supplier = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colSupplier);
            String currency = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colCurrency);
            String effectiveDateFrom = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colEffectiveDateFrom);
            String effectiveDateTo = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colEffectiveDateTo);
            String inventoryCode = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colInventoryCode);
            String unitPrice = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colUnitPrice);
            String priceByQuantityRange = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colPriceByQuantityRange);
            String qtyFrom = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colQtyFrom);
            String qtyTo = SessionData.getDataTbVal(dataTableKey, rowSupplierInventoryPriceList, colQtyTo);

            if (!supplier.isEmpty() && !currency.isEmpty()) {
                supplierInventoryPriceList.select_supplier_currency(supplier, currency);
            }

            if (!effectiveDateFrom.isEmpty()) {
                supplierInventoryPriceList.add_new_effective_date(effectiveDateFrom, effectiveDateTo);
            }

            if (!priceByQuantityRange.isEmpty()) {
                supplierInventoryPriceList.add_inventory_item(inventoryCode);
                supplierInventoryPriceList.expand_last_inventory();
                supplierInventoryPriceList.add_range();

                supplierInventoryPriceList.select_checkbox_price_quantity_range();
                supplierInventoryPriceList.set_qty_range_for_current_inventory_item(qtyFrom, qtyTo, unitPrice);
            } else if (!qtyFrom.isEmpty() && !qtyTo.isEmpty()) {
                supplierInventoryPriceList.add_new_qty_range_for_current_inventory_item();
                supplierInventoryPriceList.set_qty_range_for_current_inventory_item(qtyFrom, qtyTo, unitPrice);
            } else {
                supplierInventoryPriceList.add_inventory_item(inventoryCode);
                supplierInventoryPriceList.expand_last_inventory();
                supplierInventoryPriceList.add_range();

                supplierInventoryPriceList.set_unit_price_for_current_inventory_item(unitPrice);
            }
        }

        supplierInventoryPriceList.switch_out_iframe();
        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private ProcessingNumberingSteps processingNumbering;

    @And("^user is tagged in Processing Numbering$")
    public void user_is_tagged_in_processing_numbering(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Document Numbering>Processing Numbering");
        processingNumbering.switchToIFrame();

        String dataTableKey = "ProcessingNumber";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colModuleCode = "Module Code";
        String colTransactionTypeCode = "Transaction Type Code";
        String colNumberingSchemeCode = "Numbering Scheme Code";
        String colUserID = "User ID";
        String colLengthofCode = "Length of Code";
        String colPrefix = "Prefix";

        for (int rowProcessingNumbering : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String moduleCode = SessionData.getDataTbVal(dataTableKey, rowProcessingNumbering, colModuleCode);
            String transactionTypeCode = SessionData.getDataTbVal(dataTableKey, rowProcessingNumbering, colTransactionTypeCode);
            String numberingSchemeCode = SessionData.getDataTbVal(dataTableKey, rowProcessingNumbering, colNumberingSchemeCode);
            String userID = SessionData.getDataTbVal(dataTableKey, rowProcessingNumbering, colUserID);
            String lengthofCode = SessionData.getDataTbVal(dataTableKey, rowProcessingNumbering, colLengthofCode);
            String prefix = SessionData.getDataTbVal(dataTableKey, rowProcessingNumbering, colPrefix);

            processingNumbering.enter_module_code(moduleCode);
            processingNumbering.enter_transaction_type_code(transactionTypeCode);

            processingNumbering.select_first_result_module();

            processingNumbering.click_btn_ns_add();
            processingNumbering.enter_ns_new_numbering_scheme_code(numberingSchemeCode);

            processingNumbering.select_numbering_scheme_code(numberingSchemeCode);

            processingNumbering.enter_ns_length_of_code(lengthofCode);
            processingNumbering.enter_ns_prefix(prefix);

            processingNumbering.switch_to_tab_tag_users_to_numbering_scheme();
            processingNumbering.click_btn_tag_user_add();
            processingNumbering.enter_tag_user_user_id(userID);

            processingNumbering.click_btn_ns_close();
        }

        processingNumbering.switchOutDefaultIFrame();
        menuNavigation.clickOnHomeIcon();
    }

    @Steps
    private ApprovingOfficerSteps approvingOfficer;

    @And("^user add Approving Officer$")
    public void user_add_approving_officer(List<List<String>> dataTable) throws Throwable {
        menuNavigation.user_navigates_to_screen("Master Setup>Employee & Approving Officer>Approving Officer");
        approvingOfficer.switch_to_iframe();

        String dataTableKey = "ApprovingOfficer";
        SessionData.addDataTable(dataTableKey, dataTable);

        String colModuleCodeDesc = "Module Code Desc";
        String colTransactionTypeDesc = "Transaction Type Desc";
        String colApprovingMethod = "Approving Method";
        String colEmployeeCode = "Employee Code";
        String colApprovalHomeAmountLimit = "Approval Home Amount Limit (Per Voucher)";

        for (int rowApprovingOfficer : SessionData.getDataTbRowsNoHeader(dataTableKey).keySet()) {
            String moduleCodeDesc = SessionData.getDataTbVal(dataTableKey, rowApprovingOfficer, colModuleCodeDesc);
            String transactionTypeDesc = SessionData.getDataTbVal(dataTableKey, rowApprovingOfficer, colTransactionTypeDesc);
            String approvingMethod = SessionData.getDataTbVal(dataTableKey, rowApprovingOfficer, colApprovingMethod);
            String employeeCode = SessionData.getDataTbVal(dataTableKey, rowApprovingOfficer, colEmployeeCode);
            String approvalHomeAmountLimit = SessionData.getDataTbVal(dataTableKey, rowApprovingOfficer, colApprovalHomeAmountLimit);

            approvingOfficer.search_by_modulecode_transaction_desc(moduleCodeDesc, transactionTypeDesc);

            approvingOfficer.select_first_result();

            approvingOfficer.add_officer_with_amount_limit(employeeCode, approvalHomeAmountLimit);


        }
        approvingOfficer.switch_out_iframe();
        menuNavigation.clickOnHomeIcon();
    }
}
