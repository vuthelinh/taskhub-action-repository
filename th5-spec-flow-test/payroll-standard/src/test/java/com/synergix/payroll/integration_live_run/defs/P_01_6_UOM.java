package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_01_6_UOM extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^UOM is created as in\\s+\"([^\"]*)\"$")
    public void createUOM(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String uomCode = getColumn(1);
            String desc = getColumn(2);
            String isInventory = getColumn(3);
            String isService = getColumn(4);

            if (empty(uomCode))
                continue;

            // set fail subject and message
            setFailSubject("Create UOM Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + uomCode);

            pageSteps.goToMenu(MenuID.GL_INVENTORY_UOM);
            pageSteps.clickButton("New");
            pageSteps.setText("UOM Code", uomCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Verify UOM Code: ", pageSteps.getTextValue("UOM Code"), uomCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Check Description: ", pageSteps.getTextValue("Description").equalsIgnoreCase(desc));

            pageSteps.setCheckbox("Type", isInventory, 1);
            pageSteps.verifyResult("Verify Inventory Type: ", pageSteps.isCheckboxChecked("Type", 1, isInventory));

            pageSteps.setCheckbox("Type", isService, 2);
            pageSteps.verifyResult("Verify Service Type: ", pageSteps.isCheckboxChecked("Type", 2, isService));

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            pageSteps.clickButton("Search");
            pageSteps.setTextPopupPanel("Search UOM", "UOM Code", uomCode);
            pageSteps.verifyResult("UOM code records found: ", pageSteps.getRowsCount("UOM Code") >= 1);

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create UOM Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / UOM Code: " + uomCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create UOM Report");
    }

//    @Given("^Verify if UOM is created as in\\s+\"([^\"]*)\"$")
//    public void verifyUOM_Created(String dataset)
//    {
//        pageSteps.goToMenu(MenuID.GL_INVENTORY_UOM);
//        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
//        setDataset("Dataset");
//        for (i = 1; i <= datasetObjArray.length; i++)
//        {
//            String uomCode = getColumn(1);
//            String desc = getColumn(2);
//            String isInventory = getColumn(3);
//            String isService = getColumn(4);
//
//            if (empty(uomCode))
//                continue;
//
//            pageSteps.clickButton("Search");
//            pageSteps.setTextPopupPanel("Search UOM", "UOM Code", uomCode);
//            pageSteps.verifyResult("UOM code records found: ", pageSteps.getRowsCount("UOM Code") >= 1);
//            pageSteps.selectFirstRow("UOM Code");
//
//            String desc_E = pageSteps.getTextValue("Description");
//            boolean isInventory_E = pageSteps.isCheckboxChecked("Type", 1);
//            boolean isService_E = pageSteps.isCheckboxChecked("Type", 2);
//
//            pageSteps.verifyResult("Check Description: " + desc + " = " + desc_E, desc.equalsIgnoreCase(desc_E));
//            pageSteps.verifyResult("Check Inventory Type: " + isInventory + " = " + isInventory_E,
//                                   (isInventory.startsWith("Y") && isInventory_E) || (isInventory.startsWith("N") && !isInventory_E));
//            pageSteps.verifyResult("Check Service Type: " + isService + " = " + isService_E,
//                                   (isService.startsWith("Y") && isService_E) || (isService.startsWith("N") && !isService_E));
//        }
//        pageSteps.verifyFinalResult("UOM has been created");
//    }
}
