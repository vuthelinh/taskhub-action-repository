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

public class P_19_HourlyRateGroup extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Hourly Rate Group is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String groupCode = getColumn(1);
            String groupDesc = getColumn(2);
            String requiredEnterPrjAtTS = getColumn(3);
            String detailNo = getColumn(4);

            if (empty(groupCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Hourly Rate Group Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + groupCode);

            pageSteps.goToMenu(MenuID.GL_PY_HOURLY_RATE_GROUP);
            pageSteps.clickButton("New");
            pageSteps.setText("Hourly Rate Group Code", groupCode);
            pageSteps.verifyResult("Hourly Rate Group Code", pageSteps.getTextValue("Hourly Rate Group Code"), groupCode);

            pageSteps.setText("Description", groupDesc);
            pageSteps.verifyResult("Description", pageSteps.getTextValue("Description"), groupDesc);

            pageSteps.setRadioOption("Required to enter project info at \"TimeSheet\" screen", requiredEnterPrjAtTS);
            pageSteps.verifyResult("Required to enter project info at \"TimeSheet\" screen",
                                   pageSteps.isRadioOptionChecked("Required to enter project info at \"TimeSheet\" screen", groupDesc));

            // Effective Periods & Group Members
            setupEffectivePeriods(detailNo);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Hourly Rate Group Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + groupCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Hourly Rate Group Report");
    }

    String groupDetNo = "";

    @Step("Set up effective periods & group members")
    private void setupEffectivePeriods(String detailNo)
    {
        setDetailData("Detail - Periods");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(detailNo))
            {
                String dateFrom = getColumn_Detail(2);
                String dateTo = getColumn_Detail(3);
                String schemeCode = getColumn_Detail(4);
                String groupDetailNo = getColumn_Detail(5);

                if (notEmpty(dateFrom) && notEmpty(dateTo))
                {
                    pageSteps.clickButton("Add", 1);
                    pageSteps.waitForAjax(1);
                    pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
                    pageSteps.verifyResult("Date From", pageSteps.getTextAtTableCell("Date From", 1), dateFrom);

                    pageSteps.setTextAtTableCell("Date To", 1, dateTo);
                    pageSteps.verifyResult("Date To", pageSteps.getTextAtTableCell("Date To", 1), dateTo);

                    pageSteps.setTextAtTableCell("Hourly Rate Scheme Code", 1, schemeCode);
                    pageSteps.verifyResult("Hourly Rate Scheme Code", pageSteps.getTextAtTableCell("Hourly Rate Scheme Code", 1), schemeCode);

                    int rowNo = pageSteps.getRowsCount("Date From");
                    pageSteps.selectRow("No.", rowNo);

                    setDetailData_Child("Detail - Members");
                    for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
                    {
                        String detNo2 = getColumn_Child(1);
                        if (notEmpty(detNo2))
                            groupDetNo = detNo2;
                        if (groupDetNo.equalsIgnoreCase(groupDetailNo))
                        {
                            String empCode = getColumn_Child(2);
                            if (notEmpty(empCode))
                            {
                                pageSteps.clickButton("Add", 2);
                                pageSteps.waitForAjax(1);
                                pageSteps.setTextAtTableCell("Employee Code", 1, empCode);
                                pageSteps.verifyResult("Employee Code", pageSteps.getTextAtTableCell("Employee Code", 1), empCode);
                            }
                        }
                    }
                }
            }
        }
    }
}
