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

public class P_04_CommissionGroup extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Commission Group is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String groupCode = getColumn(1);
            String groupDesc = getColumn(2);
            String memberDetNo = getColumn(3);

            if (empty(groupCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Commision Group Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + groupCode);

            pageSteps.goToMenu(MenuID.GL_PY_COMMISSION_GROUP);
            pageSteps.clickButton("New");
            pageSteps.setText("Commission Group Code", groupCode);
            pageSteps.verifyResult("Verify Comission Group Code: ", pageSteps.getTextValue("Comission Group Code"), groupCode);

            pageSteps.setText("Description", groupDesc);
            pageSteps.verifyResult("Verify Description: ", pageSteps.getTextValue("Description"), groupDesc);

            addMember(memberDetNo);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Commission Group Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Commission Group Code: " + groupCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Commission Group Report");
    }

    @Step("Add group members")
    public void addMember(String memberDetNo)
    {
        setDetailData("Member");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(memberDetNo))
            {
                String empCode = getColumn_Detail(2);
                String salaryReport = getColumn_Detail(3);

                pageSteps.clickButton("Add", 1);
                pageSteps.setTextAtTableCell("Employee Code", 1, empCode);
                pageSteps.verifyResult("Verify Employee Code: ", pageSteps.getTextAtTableCell("Employee Code", 1), empCode);

                pageSteps.setCheckBoxAtTableCell("Salary & CPF in Report", 1, salaryReport);
                pageSteps.verifyResult("Verify Salary & CPF in Report: ",
                                       pageSteps.isCheckBoxAtTableCellChecked("", "Salary & CPF in Report", 1, salaryReport));

                pageSteps.clickNumberIconAtTableCell("No.", 1);
                addPeriod(memberDetNo);
            }
        }
    }

    @Step("Add effective periods")
    public void addPeriod(String memberDetNo)
    {
        setDetailData_Child("Period");
        for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
        {
            String detNo_Don = getColumn_Child(1);
            if (detNo_Don.equalsIgnoreCase(memberDetNo))
            {
                String dateFrom = getColumn_Child(2);
                String dateTo = getColumn_Child(3);

                pageSteps.clickButton("Add", 2);
                pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
                pageSteps.verifyResult("Verify Date From: ", pageSteps.getTextAtTableCell("Date From", 1), dateFrom);

                pageSteps.setTextAtTableCell("Date To", 1, dateTo);
                pageSteps.verifyResult("Verify Date To: ", pageSteps.getTextAtTableCell("Date To", 1), dateTo);
            }
        }
    }
}
