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

public class P_15_1_EmployeeClass extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Employee Class is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String empClassCode = getColumn(1);
            String desc = getColumn(2);
            String basicSalary = getColumn(3);
            String cpfPayable = getColumn(4);
            String employerCPF = getColumn(5);
            String employeeCPF = getColumn(6);
            String timesheet = getColumn(7);
            String salaryOnHold = getColumn(8);
            String leaveEncashment = getColumn(9);
            String otOnHold = getColumn(10);
            String pieceRateWS = getColumn(11);
            String taxOnHold = getColumn(12);
            String penalty = getColumn(13);
            String negativeSalary = getColumn(14);
            String unpaidLeave = getColumn(15);
            String latenessDeduction = getColumn(16);
            String advancement = getColumn(17);
            String leavingWorkEarly = getColumn(18);
            String pieceRateWSonHold = getColumn(19);

            if (empty(empClassCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Employee Class Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + empClassCode);

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE_CLASS);
            pageSteps.clickButton("New");
            pageSteps.setText("Employee Class Code", empClassCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Employee Class Code", pageSteps.getTextValue("Employee Class Code"), empClassCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description", pageSteps.getTextValue("Description"), desc);

            pageSteps.setText("Basic Salary", basicSalary);
            pageSteps.verifyResult("Basic Salary", pageSteps.getTextValue("Basic Salary"), basicSalary);

            pageSteps.setText("CPF Payable", cpfPayable);
            pageSteps.verifyResult("CPF Payable", pageSteps.getTextValue("CPF Payable"), cpfPayable);

            pageSteps.setText("Employer CPF", employerCPF);
            pageSteps.verifyResult("Employer CPF", pageSteps.getTextValue("Employer CPF"), employerCPF);

            pageSteps.setText("Employee CPF", employeeCPF);
            pageSteps.verifyResult("Employee CPF", pageSteps.getTextValue("Employee CPF"), employeeCPF);

            pageSteps.setText("Timesheet", timesheet);
            pageSteps.verifyResult("Timesheet", pageSteps.getTextValue("Timesheet"), timesheet);

            pageSteps.setText("Salary On Hold", salaryOnHold);
            pageSteps.verifyResult("Salary On Hold", pageSteps.getTextValue("Salary On Hold"), salaryOnHold);

            pageSteps.setText("Leave Encashment", leaveEncashment);
            pageSteps.verifyResult("Leave Encashment", pageSteps.getTextValue("Leave Encashment"), leaveEncashment);

            pageSteps.setText("OT On Hold", otOnHold);
            pageSteps.verifyResult("OT On Hold", pageSteps.getTextValue("OT On Hold"), otOnHold);

            if (pageSteps.checkTextExist("Piece Rate Worksheet", true))
            {
                pageSteps.setText("Piece Rate Worksheet", pieceRateWS);
                pageSteps.verifyResult("Piece Rate Worksheet", pageSteps.getTextValue("Piece Rate Worksheet"), pieceRateWS);
            }

            pageSteps.setText("Tax On Hold", taxOnHold);
            pageSteps.verifyResult("Tax On Hold", pageSteps.getTextValue("Tax On Hold"), taxOnHold);

            pageSteps.setText("Penalty", penalty);
            pageSteps.verifyResult("Penalty", pageSteps.getTextValue("Penalty"), penalty);

            pageSteps.setText("Negative Salary", negativeSalary);
            pageSteps.verifyResult("Negative Salary", pageSteps.getTextValue("Negative Salary"), negativeSalary);

            pageSteps.setText("Unpaid Leave", unpaidLeave);
            pageSteps.verifyResult("Unpaid Leave", pageSteps.getTextValue("Unpaid Leave"), unpaidLeave);

            pageSteps.setText("Lateness Deduction", latenessDeduction);
            pageSteps.verifyResult("Lateness Deduction", pageSteps.getTextValue("Lateness Deduction"), latenessDeduction);

            pageSteps.setText("Advancement", advancement);
            pageSteps.verifyResult("Advancement", pageSteps.getTextValue("Advancement"), advancement);

            pageSteps.setText("Leaving Work Early", leavingWorkEarly);
            pageSteps.verifyResult("Leaving Work Early", pageSteps.getTextValue("Leaving Work Early"), leavingWorkEarly);

            if (pageSteps.checkTextExist("Piece Rate Worksheet on Hold", true))
            {
                pageSteps.setText("Piece Rate Worksheet on Hold", pieceRateWSonHold);
                pageSteps.verifyResult("Piece Rate Worksheet on Hold", pageSteps.getTextValue("Piece Rate Worksheet on Hold"), pieceRateWSonHold);
            }

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Employee Class Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + empClassCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Employee Class Report");
    }
}
