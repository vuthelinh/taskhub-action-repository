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

public class P_15_3_EmployeeGrade extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Employee Grade is created as in\\s+\"([^\"]*)\"$")
    public void createEmpGrade(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String gradeCode = getColumn(1);
            String desc = getColumn(2);
            String caclMethod = getColumn(3);
            String localInfo = getColumn(4);

            if (empty(gradeCode) && empty(caclMethod))
                continue;

            // set fail subject and message
            setFailSubject("Create Employee Grade Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + gradeCode);

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE_GRADE);
            pageSteps.clickButton("New");
            pageSteps.setText("Grade Code", gradeCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Grade Code", pageSteps.getTextValue("Grade Code"), gradeCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description", pageSteps.getTextValue("Description"), desc);

            // TAB - Leave Entitlement
            pageSteps.goToTab("Leave Entitlement");
            if (pageSteps.checkTextExist("Annual Increment", false))
            {
                pageSteps.setRadioOption(caclMethod);
                pageSteps.verifyResult("Calculation Method: " + caclMethod, pageSteps.isRadioOptionChecked(caclMethod));
            }

            pageSteps.waitForAjax(1);
            if (caclMethod.equalsIgnoreCase("Annual Increment"))
                setupAnnualIncrement(gradeCode);
            if (pageSteps.checkTextExist("Year of Service", false))
                if (caclMethod.equalsIgnoreCase("Year of Service"))
                    setupYoS(gradeCode);

            // TAB - Carried Forward Leave
            pageSteps.goToTab("Carried Forward Leave");
            setupCarriedForwardLeave(gradeCode);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Employee Grade Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + gradeCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Employee Grade Report");
    }

    @Step("Set up year of service")
    private void setupYoS(String gradeCode)
    {
        setDetailData("Year of Service");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                glGradeCode = detNo;

            if (glGradeCode.equalsIgnoreCase(gradeCode))
            {
                String leaveType = getColumn_Detail(2);
                String yosFrom = getColumn_Detail(3);
                String yosTo = getColumn_Detail(4);
                String le = getColumn_Detail(5);

                if (notEmpty(leaveType))
                {
                    pageSteps.clickButton("Add", 1);
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Leave Type");
                    pageSteps.setTextAtTableCell("Leave Type", rowNo, leaveType);
                    pageSteps.verifyResult("Leave Type", pageSteps.getTextAtTableCell("Leave Type", rowNo), leaveType);

                    pageSteps.clickGreenArrow("Leave Type", rowNo);
                }
                if (notEmpty(yosFrom))
                {
                    pageSteps.clickButton("Add", 2);
                    pageSteps.waitForAjax(1);
                    int rowNo2 = pageSteps.getRowsCount("Year of Service From");
                    pageSteps.setTextAtTableCell("Year of Service From", rowNo2, yosFrom);
                    pageSteps.verifyResult("Year of Service From", pageSteps.getTextAtTableCell("Year of Service From", rowNo2), yosFrom);

                    pageSteps.setTextAtTableCell("Year of Service To", rowNo2, yosTo);
                    pageSteps.verifyResult("Year of Service To", pageSteps.getTextAtTableCell("Year of Service To", rowNo2), yosTo);

                    pageSteps.setTextAtTableCell("Leave Entitlement", rowNo2, le);
                    pageSteps.verifyResult("Leave Entitlement", pageSteps.getTextAtTableCell("Leave Entitlement", rowNo2), le);
                }
            }
        }
    }

    String glGradeCode;

    @Step("Set up carried forward leave")
    private void setupCarriedForwardLeave(String gradeCode)
    {
        setDetailData("Carried Forward Leave");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                glGradeCode = detNo;

            if (glGradeCode.equalsIgnoreCase(gradeCode))
            {
                String leaveType = getColumn_Detail(2);
                String maxNoOfDays = getColumn_Detail(3);

                if (notEmpty(leaveType))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Leave Type");
                    pageSteps.setTextAtTableCell("Leave Type", rowNo, leaveType);
                    pageSteps.verifyResult("Leave Type", pageSteps.getTextAtTableCell("Leave Type", rowNo), leaveType);

                    pageSteps.setTextAtTableCell("Max. No. of Days Carried Forward", rowNo, maxNoOfDays);
                    pageSteps.verifyResult("Max. No. of Days Carried Forward",
                                           pageSteps.getTextAtTableCell("Max. No. of Days Carried Forward", rowNo), maxNoOfDays);
                }
            }
        }
    }

    @Step("Set up annual entitlement")
    private void setupAnnualIncrement(String gradeCode)
    {
        setDetailData("Annual Increment");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                glGradeCode = detNo;

            if (glGradeCode.equalsIgnoreCase(gradeCode))
            {
                String leaveType = getColumn_Detail(2);
                String startingLeave = getColumn_Detail(3);
                String maxLeave = getColumn_Detail(4);
                String annualIncrement = getColumn_Detail(5);

                if (notEmpty(leaveType))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Leave Type");
                    pageSteps.setTextAtTableCell("Leave Type", rowNo, leaveType);
                    pageSteps.verifyResult("Leave Type", pageSteps.getTextAtTableCell("Leave Type", rowNo), leaveType);

                    pageSteps.setTextAtTableCell("Starting Leave Entitlement (Days)", rowNo, startingLeave);
                    pageSteps.verifyResult("Starting Leave Entitlement (Days)",
                                           pageSteps.getTextAtTableCell("Starting Leave Entitlement (Days)", rowNo), startingLeave);

                    pageSteps.setTextAtTableCell("Max Leave Entitlement (Days)", rowNo, maxLeave);
                    pageSteps.verifyResult("Max Leave Entitlement (Days)", pageSteps.getTextAtTableCell("Max Leave Entitlement (Days)", rowNo),
                                           maxLeave);

                    pageSteps.setTextAtTableCell("Annual Increment (Days)", rowNo, annualIncrement);
                    pageSteps.verifyResult("Annual Increment (Days)", pageSteps.getTextAtTableCell("Annual Increment (Days)", rowNo),
                                           annualIncrement);
                }
            }
        }
    }
}
