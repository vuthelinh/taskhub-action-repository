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

public class P_20_ApprovingOfficer extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Approving Officer is set up as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String moduleCodeDesc = getColumn(1);
            String transTypeDesc = getColumn(2);
            String apprMethod = getColumn(3);
            String rejectRemarks = getColumn(4);
            String sbuDetailNo = getColumn(5);

            if (empty(moduleCodeDesc))
                continue;

            // set fail subject and message
            setFailSubject("Setup Approving Officer Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + moduleCodeDesc);

            pageSteps.goToMenu(MenuID.MT_APPROVING_OFFICER);
            pageSteps.setTableFilter("Module Code Desc", moduleCodeDesc);
            pageSteps.setTableFilter("Transaction Type Desc", transTypeDesc);
            pageSteps.setDropDownOptionAtTableCell("Approving Method", 1, apprMethod);
            pageSteps.verifyResult("Approving Method", pageSteps.getDropDownOptionAtTableCell("Approving Method", 1), apprMethod);

            pageSteps.setRadioOptionAtTableCell("Reject Remarks Mandatory", 1, rejectRemarks);
            pageSteps.verifyResult("Reject Remarks Mandatory",
                                   pageSteps.isRadioOptionAtTableCellChecked("Reject Remarks Mandatory", 1, rejectRemarks));

            pageSteps.clickGreenArrow("Module Code Desc", 1);
            setupSBU(apprMethod, sbuDetailNo);
        }
        String report = pageSteps.getTableReport();
        writeReport(report);
        sendEmailToPY("Setup Approving Officer Report - Success",
                      "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + report, ElementID.REPORT_FILE);
        pageSteps.verifyFinalResult(report);
    }

    String flagCode    = "";
    String sbuFlagCode = "";

    @Step("Set up SBU with approving method = {0}")
    private void setupSBU(String apprMethod, String sbuDetailNo)
    {
        if (apprMethod.equalsIgnoreCase("By Approving Officer (1 Level by Value)"))
        {
            setDetailData("Officer");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (notEmpty(detNo))
                    flagCode = detNo;
                if (flagCode.equalsIgnoreCase(sbuDetailNo))
                {
                    String empCode = getColumn_Detail(2);
                    if (notEmpty(empCode))
                    {
                        pageSteps.clickButton("Add");
                        pageSteps.waitForAjax(1);
                        pageSteps.setText("Employee Code", empCode);
                        pageSteps.clickButton("Search");
                        pageSteps.selectFirstRow("Employee Code");
                        pageSteps.confirm("Yes");
                    }
                }
            }
        }

        else if (apprMethod.equalsIgnoreCase("Is SBU (1 Level by SBU by Value)"))
        {
            setDetailData("SBU");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (notEmpty(detNo))
                    flagCode = detNo;
                if (flagCode.equalsIgnoreCase(sbuDetailNo))
                {
                    String sbuCode = getColumn_Detail(2);
                    if (notEmpty(sbuCode))
                        sbuFlagCode = sbuCode;
                    if (notEmpty(sbuFlagCode))
                    {
                        pageSteps.setTableFilter("SBU Code", sbuFlagCode);
                        pageSteps.selectFirstRow("SBU Code");

                        String empCode = getColumn(4);
                        if (notEmpty(empCode))
                        {
                            pageSteps.clickButton("Add");
                            pageSteps.waitForAjax(1);
                            pageSteps.setText("Employee Code", empCode);
                            pageSteps.clickButton("Search");
                            pageSteps.selectFirstRow("Employee Code");
                            pageSteps.confirm("Yes");
                        }
                    }
                }
            }
        }

        else if (apprMethod.equalsIgnoreCase("Is SBU & Multiple Level (All levels By SBU)"))
        {
            setDetailData("SBU");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (notEmpty(detNo))
                    flagCode = detNo;
                if (flagCode.equalsIgnoreCase(sbuDetailNo))
                {
                    String sbuCode = getColumn_Detail(2);
                    if (notEmpty(sbuCode))
                        sbuFlagCode = sbuCode;
                    if (notEmpty(sbuFlagCode))
                    {
                        pageSteps.clickButton("Add", 999);// a bug that exists 2 Add buttons
                        pageSteps.waitForAjax(1);
                        int rowNo = pageSteps.getRowsCount("SBU Code");
                        pageSteps.setTextAtTableCell("SBU Code", rowNo, sbuFlagCode);
                        pageSteps.clickGreenArrow("SBU Code", rowNo);

                        String level = getColumn_Detail(3);
                        String empCode = getColumn_Detail(4);

                        if (notEmpty(empCode))
                        {
                            pageSteps.clickButton("Add", 999);
                            pageSteps.waitForAjax(1);
                            rowNo = pageSteps.getRowsCount("Level");
                            pageSteps.setTextAtTableCell("Level", rowNo, level);
                            pageSteps.setTextAtTableCell("Approving Officer", rowNo, empCode);
                        }
                    }
                }
            }
        }
    }
}
