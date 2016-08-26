package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_01_0_RoleMaster extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Role Master is set up as in\\s+\"([^\"]*)\"$")
    public void setupRoleMaster(String dataset)
    {
        // set fail subject and message
        setFailSubject("Set up Role Master Report - Fail");
        setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL());

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String roleCode = getColumn(1);
            if (empty(roleCode))
                continue;

            pageSteps.goToMenu(MenuID.MT_ROLE_MASTER);
            pageSteps.setTableFilter("Role Code", roleCode);
            pageSteps.waitForAjax(1);

            int record = pageSteps.getRowsCount("Role Code");
            pageSteps.verifyResult("Verify Role Code record exists: ", record >= 1);
            if (record >= 1)
            {
                pageSteps.selectFirstRow("Role Code");
                addForm(roleCode);
                pageSteps.clickButton("Close");
            }
        }
        String report = pageSteps.getTableReport();
        writeReport(report);
        sendEmailToPY("Setup Role Master Report - Success",
                      "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + report, ElementID.REPORT_FILE);
        pageSteps.verifyFinalResult(report);
    }

    @Step("Add form code access")
    public void addForm(String roleCode)
    {
        setDetailData("Form Code");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String fCode = getColumn_Detail(1);
            if (fCode.equalsIgnoreCase(roleCode))
            {
                String formCode = getColumn_Detail(2);
                String formName = getColumn_Detail(3);

                pageSteps.setTableFilter("Form Code", formCode);
                pageSteps.setTableFilter("Form Name", formName);
                pageSteps.waitForAjax(1);

                int record = pageSteps.getRowsCount("Form Code");
                pageSteps.verifyResult("Verify Form Code record exists: ", record == 1);
                if (record == 1)
                {
                    pageSteps.setCheckboxAtXpathCSS("//tbody[contains(@id,'mtRoleAccessTable:tb')]/tr[1]/td[1]/input", true);
                    pageSteps.verifyResult("Verify form code selected: ", pageSteps.isCheckBoxAtTableCellChecked("Sel", 1, "Y"));
                }
            }
        }
    }
}
