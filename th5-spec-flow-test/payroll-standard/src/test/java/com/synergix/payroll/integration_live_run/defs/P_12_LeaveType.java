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

public class P_12_LeaveType extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Leave Type is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");

        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String leaveTypeCode = getColumn(1);
            String desc = getColumn(2);
            String excludeNonWkDays = getColumn(3);
            String paidLeave = getColumn(4);
            String deductSalary = getColumn(5);
            String encashUponResign = getColumn(6);
            String leaveEncashmentOnEarnBasis = getColumn(7);
            String entitleOnEarnBasis = getColumn(8);
            String prorateExpectedLeave = getColumn(9);
            String cutoffDateFirstMonth = getColumn(10);
            String minDaysInAdvanceforLeave = getColumn(11);
            String carriedForward = getColumn(12);
            String maxDaysCarriedForward = getColumn(13);
            String validOfCarriedForward = getColumn(14);
            String deductOnHalfWKDay = getColumn(15);
            String payHourlyEmp = getColumn(16);
            String leaveOption = getColumn(17);
            String minNoOfMonthsFromJoinDate = getColumn(18);
            String requireSupportDocs = getColumn(19);
            String mandatoryInternalRemarks = getColumn(20);
            String mandatoryCancelReason = getColumn(21);
            String enableEmailForCF = getColumn(22);
            String triggerEmail = getColumn(23);
            String emailTo = getColumn(24);
            String deductDaysFromAnotherLeaveType = getColumn(25);
            String deductFrom = getColumn(26);

            if (empty(leaveTypeCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Leave Type Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + leaveTypeCode);

            // for Min. No. of Days in Advance for Leave Application to appear
            executeUpdate("UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 'Y' WHERE PROPERTY_NAME = 'enableValidationBaseOnApplicationDate'");

            pageSteps.goToMenu(MenuID.GL_LEAVE_TYPE);
            pageSteps.clickButton("New");
            pageSteps.setText("Leave Type Code", leaveTypeCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Leave Type Code: ", pageSteps.getTextValue("Leave Type Code"), leaveTypeCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.setRadioOption("Exclude Non-working Days", excludeNonWkDays);
            pageSteps.verifyResult("Exclude Non-working Days: ", pageSteps.isRadioOptionChecked("Exclude Non-working Days", excludeNonWkDays));

            pageSteps.setRadioOption("Paid Leave", paidLeave);
            pageSteps.verifyResult("Paid Leave: ", pageSteps.isRadioOptionChecked("Paid Leave", paidLeave));

            if (paidLeave.equalsIgnoreCase("N") || paidLeave.equalsIgnoreCase("NO"))
            {
                pageSteps.setRadioOption("Deduct Salary", deductSalary);
                pageSteps.verifyResult("Deduct Salary: ", pageSteps.isRadioOptionChecked("Deduct Salary", deductSalary));
            }
            if (paidLeave.equalsIgnoreCase("Y") || paidLeave.equalsIgnoreCase("YES"))
            {
                pageSteps.setRadioOption("Encashment Upon Resignation", encashUponResign);
                pageSteps.verifyResult("Encashment Upon Resignation: ",
                                       pageSteps.isRadioOptionChecked("Encashment Upon Resignation", encashUponResign));
            }
            if (encashUponResign.equalsIgnoreCase("Y") || encashUponResign.equalsIgnoreCase("YES"))
            {
                pageSteps.setRadioOption("Leave Encashment On Earn Basis", leaveEncashmentOnEarnBasis);
                pageSteps.verifyResult("Leave Encashment On Earn Basis: ",
                                       pageSteps.isRadioOptionChecked("Leave Encashment On Earn Basis", leaveEncashmentOnEarnBasis));
            }
            if (paidLeave.equalsIgnoreCase("Y") || paidLeave.equalsIgnoreCase("YES"))
            {
                pageSteps.setRadioOption("Entitlement on Earn Basis", entitleOnEarnBasis);
                pageSteps.verifyResult("Entitlement on Earn Basis: ",
                                       pageSteps.isRadioOptionChecked("Entitlement on Earn Basis", entitleOnEarnBasis));

                pageSteps.setRadioOption("Prorate Expected Leave Entitlement", prorateExpectedLeave);
                pageSteps.verifyResult("Prorate Expected Leave Entitlement: ",
                                       pageSteps.isRadioOptionChecked("Prorate Expected Leave Entitlement", prorateExpectedLeave));
            }
            if (entitleOnEarnBasis.equalsIgnoreCase("Y") || entitleOnEarnBasis.equalsIgnoreCase("YES"))
            {
                pageSteps.setText("Cut-off Date for 1st Mth Entitlement", cutoffDateFirstMonth);
                pageSteps.verifyResult("Cut-off Date for 1st Mth Entitlement: ", pageSteps.getTextValue("Cut-off Date for 1st Mth Entitlement"),
                                       cutoffDateFirstMonth);
            }
            if (pageSteps.checkTextExist("Min. No. of Days in Advance for Leave Application", true))
            {
                pageSteps.setText("Min. No. of Days in Advance for Leave Application", minDaysInAdvanceforLeave);
                pageSteps.verifyResult("Min. No. of Days in Advance for Leave Application: ",
                                       pageSteps.getTextValue("Min. No. of Days in Advance for Leave Application"), minDaysInAdvanceforLeave);
            }

            pageSteps.setRadioOption("Carried Forward To Next Year", carriedForward);
            pageSteps.verifyResult("Carried Forward To Next Year: ", pageSteps.isRadioOptionChecked("Carried Forward To Next Year", carriedForward));

            if (carriedForward.equalsIgnoreCase("Y") || carriedForward.equalsIgnoreCase("YES"))
            {
                pageSteps.setText("Max. No. of Days Carried Forward", maxDaysCarriedForward);
                pageSteps.verifyResult("Max. No. of Days Carried Forward: ", pageSteps.getTextValue("Max. No. of Days Carried Forward"),
                                       maxDaysCarriedForward);

                pageSteps.setText("Validity of Carried Forward Leave", validOfCarriedForward);
                pageSteps.verifyResult("Validity of Carried Forward Leave: ", pageSteps.getTextValue("Validity of Carried Forward Leave"),
                                       validOfCarriedForward);
            }
            pageSteps.setRadioOption("Deduct one day if leave taken on half working day", deductOnHalfWKDay);
            pageSteps.verifyResult("Deduct one day if leave taken on half working day: ",
                                   pageSteps.isRadioOptionChecked("Deduct one day if leave taken on half working day", deductOnHalfWKDay));

            if (paidLeave.equalsIgnoreCase("Y") || paidLeave.equalsIgnoreCase("YES"))
            {
                pageSteps.setRadioOption("Pay Hourly Rate Employee if leave is applied", payHourlyEmp);
                pageSteps.verifyResult("Pay Hourly Rate Employee if leave is applied: ",
                                       pageSteps.isRadioOptionChecked("Pay Hourly Rate Employee if leave is applied", payHourlyEmp));
            }

            pageSteps.setDropDownOption("Leave Option", leaveOption);
            pageSteps.verifyResult("Leave Option: ", pageSteps.getDropDownOptionValue("Leave Option"), leaveOption);

            pageSteps.setText("Min. No. of Months from Join Date for Leave Application", minNoOfMonthsFromJoinDate);
            pageSteps.verifyResult("Min. No. of Months from Join Date for Leave Application: ",
                                   pageSteps.getTextValue("Min. No. of Months from Join Date for Leave Application"), minNoOfMonthsFromJoinDate);

            pageSteps.setRadioOption("Require Supporting Documents", requireSupportDocs);
            pageSteps.verifyResult("Require Supporting Documents: ",
                                   pageSteps.isRadioOptionChecked("Require Supporting Documents", requireSupportDocs));

            pageSteps.setRadioOption("Mandatory Internal Remarks", mandatoryInternalRemarks);
            pageSteps.verifyResult("Mandatory Internal Remarks: ",
                                   pageSteps.isRadioOptionChecked("Mandatory Internal Remarks", mandatoryInternalRemarks));

            pageSteps.setRadioOption("Mandatory Cancellation Reason", mandatoryCancelReason);
            pageSteps.verifyResult("Mandatory Cancellation Reason: ",
                                   pageSteps.isRadioOptionChecked("Mandatory Cancellation Reason", mandatoryCancelReason));

            if (carriedForward.equalsIgnoreCase("Y") || carriedForward.equalsIgnoreCase("YES"))
            {
                pageSteps.setRadioOption("Enable Email for Carried Forward + Earned Leave Days", enableEmailForCF);
                pageSteps.verifyResult("Enable Email for Carried Forward + Earned Leave Days: ",
                                       pageSteps.isRadioOptionChecked("Enable Email for Carried Forward + Earned Leave Days", enableEmailForCF));
            }

            pageSteps.setRadioOption("Trigger Email", triggerEmail);
            pageSteps.verifyResult("Trigger Email: ", pageSteps.isRadioOptionChecked("Trigger Email", triggerEmail));

            pageSteps.setText("Email To", emailTo);
            pageSteps.verifyResult("Email To: ", pageSteps.getTextValue("Email To"), emailTo);

            pageSteps.setRadioOption("Deduct Days from another leave type when exceeded", deductDaysFromAnotherLeaveType);
            pageSteps.verifyResult("Deduct Days from another leave type when exceeded: ",
                                   pageSteps.isRadioOptionChecked("Deduct Days from another leave type when exceeded",
                                                                  deductDaysFromAnotherLeaveType));

            if (deductDaysFromAnotherLeaveType.equalsIgnoreCase("Y") || deductDaysFromAnotherLeaveType.equalsIgnoreCase("YES"))
            {
                pageSteps.clickSearchButton("Deduct From");
                pageSteps.setText("Leave Type Code", deductFrom, 2);
                pageSteps.selectFirstRow("Leave Type Code");
            }

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Leave Type Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Leave Type Code: " + leaveTypeCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
    }
}
