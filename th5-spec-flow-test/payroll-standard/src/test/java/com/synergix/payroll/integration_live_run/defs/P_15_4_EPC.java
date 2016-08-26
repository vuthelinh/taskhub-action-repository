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

public class P_15_4_EPC extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Employee Payroll Category is created as in\\s+\"([^\"]*)\"$")
    public void createEPC(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String epcCode = getColumn(1);
            String desc = getColumn(2);
            String fixedAdvBfMonthEndPayrun = getColumn(3);
            String maxTaxOnHold = getColumn(4);
            String paymentCycle = getColumn(5);
            String deductionPerPayrun = getColumn(6);
            String employerBank = getColumn(7);
            String employerBankAccNo = getColumn(8);
            String mon = getColumn(9);
            String tue = getColumn(10);
            String wed = getColumn(11);
            String thu = getColumn(12);
            String fri = getColumn(13);
            String sat = getColumn(14);
            String sun = getColumn(15);
            String phd = getColumn(16);
            String totalWkHoursPerDay = getColumn(17);
            String totalWkHoursPerWeek = getColumn(18);
            String mandatoryAllocToProj = getColumn(19);
            String allocBasicSalary = getColumn(20);
            String deductionLateForWork = getColumn(21);
            String deductionLeaveEarly = getColumn(22);
            String absenceLeaveType = getColumn(23);
            String absenceOnMonLeaveType = getColumn(24);
            String encashmentOfLeaveUponResign = getColumn(25);
            String amTimeFrom = getColumn(26);
            String amTimeTo = getColumn(27);
            String pmTimeFrom = getColumn(28);
            String pmTimeTo = getColumn(29);
            String claimConsultFee = getColumn(30);
            String deductExcessAmt = getColumn(31);
            String empClass = getColumn(32);
            String inventoryPriceList = getColumn(33);

            if (empty(epcCode))
                continue;

            // set fail subject and message
            setFailSubject("Create EPC Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + epcCode);

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE_PAYROLL_CATEGORY);
            pageSteps.clickButton("New");
            pageSteps.setText("Employee Payroll Category Code", epcCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("EPC", pageSteps.getTextValue("Employee Payroll Category Code"), epcCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description", pageSteps.getTextValue("Description"), desc);

            pageSteps.setText("Fixed Advancement before Month End Payrun", fixedAdvBfMonthEndPayrun);
            pageSteps.verifyResult("Fixed Advancement before Month End Payrun", pageSteps.getTextValue("Fixed Advancement before Month End Payrun"),
                                   fixedAdvBfMonthEndPayrun);

            pageSteps.setText("Max Tax On Hold", maxTaxOnHold);
            pageSteps.verifyResult("Max Tax On Hold", pageSteps.getTextValue("Max Tax On Hold"), maxTaxOnHold);

            pageSteps.setText("Payment Cycle", paymentCycle);
            pageSteps.verifyResult("Payment Cycle", pageSteps.getTextValue("Payment Cycle"), paymentCycle);

            pageSteps.setText("Deduction Per Payrun", deductionPerPayrun);
            pageSteps.verifyResult("Deduction Per Payrun", pageSteps.getTextValue("Deduction Per Payrun"), deductionPerPayrun);

            pageSteps.setText("Employer Bank", employerBank);
            pageSteps.verifyResult("Employer Bank", pageSteps.getTextValue("Employer Bank"), employerBank);

            pageSteps.setText("Employer Bank Account No.", employerBankAccNo);
            pageSteps.verifyResult("Employer Bank Account No.", pageSteps.getTextValue("Employer Bank Account No."), employerBankAccNo);

            // Designated Working Days
            pageSteps.setDropDownOption("Mon", mon);
            pageSteps.setDropDownOption("Tue", tue);
            pageSteps.setDropDownOption("Wed", wed);
            pageSteps.setDropDownOption("Thu", thu);
            pageSteps.setDropDownOption("Fri", fri);
            pageSteps.setDropDownOption("Sat", sat);
            pageSteps.setDropDownOption("Sun", sun);
            pageSteps.setDropDownOption("PH", phd);

            pageSteps.setText("Total Working Hours Per Day", totalWkHoursPerDay);
            pageSteps.setText("Total Working Hours Per Week", totalWkHoursPerWeek);

            pageSteps.setRadioOption("Mandatory Allocation To Project", mandatoryAllocToProj);
            pageSteps.setRadioOption("Allocate Basic Salary and Unpaid Leave Deduction to Project", allocBasicSalary);
            pageSteps.setRadioOption("Deduction For Being Late For Work", deductionLateForWork);
            pageSteps.setRadioOption("Deduction For Leaving Work Early", deductionLeaveEarly);

            // TAB - Default - Leave
            pageSteps.goToTab("Leave");
            pageSteps.setText("Absence Leave Type", absenceLeaveType);
            pageSteps.setText("Absence On Monday Leave Type", absenceOnMonLeaveType);
            pageSteps.setRadioOption("Encashment of Leave Upon Resignation", encashmentOfLeaveUponResign);

            // Leave Duration
            pageSteps.setTextAtTableCell("Leave Duration", "Time From", 1, amTimeFrom);
            pageSteps.setTextAtTableCell("Leave Duration", "Time To", 1, amTimeTo);
            pageSteps.setTextAtTableCell("Leave Duration", "Time From", 2, pmTimeFrom);
            pageSteps.setTextAtTableCell("Leave Duration", "Time To", 2, pmTimeTo);

            // Leave Pernalty
            setupLeavePenalty(epcCode);

            // Eating Break For Basic Salary Employee
            pageSteps.goToTab("Eating Break For Basic Salary Employee");
            setupEatingBreak(epcCode);

            // TAB - Medical Expense
            pageSteps.goToTab("Medical Expense");
            pageSteps.setRadioOption("Claim consultation fee when reach \"Max Amt Per Year\"", claimConsultFee);
            pageSteps.setRadioOption("Deduct excess amount from employee", deductExcessAmt);
            setupMedicalExpense(epcCode);

            // TAB - Security
            pageSteps.goToTab("Security");
            setupSecurity(epcCode);

            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");

            // TAB - Local Info
            pageSteps.goToTab("Local Info");
            pageSteps.setText("Employee Class", empClass);
            pageSteps.setText("Inventory Price List", inventoryPriceList);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create EPC Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + epcCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create EPC Report");
    }

    @Step("Set up security")
    private void setupSecurity(String securityDetailNo)
    {
        String detN = "";
        setDetailData("Security");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                detN = detNo;
            if (detN.equalsIgnoreCase(securityDetailNo))
            {
                String empCode = getColumn_Detail(2);
                String showPayrollInfo = getColumn_Detail(3);
                String showHRInfo = getColumn_Detail(4);
                String showTimesheetInfo = getColumn_Detail(5);
                String showLeaveInfo = getColumn_Detail(6);

                if (notEmpty(empCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    pageSteps.setTextAtTableCell("Employee Code", 1, empCode);
                    pageSteps.setCheckBoxAtTableCell("Show Payroll Info.", 1, showPayrollInfo);
                    pageSteps.setCheckBoxAtTableCell("Show HR Info.", 1, showHRInfo);
                    pageSteps.setCheckBoxAtTableCell("Show TimeSheet Info.", 1, showTimesheetInfo);
                    pageSteps.setCheckBoxAtTableCell("Show Leave Info.", 1, showLeaveInfo);
                }
            }
        }
    }

    @Step("Set up medical expense")
    private void setupMedicalExpense(String medicalExpenseDetailNo)
    {
        setDetailData("Medical");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(medicalExpenseDetailNo))
            {
                String serviceCode = getColumn_Detail(2);
                String salesTax = getColumn_Detail(3);
                String inclTax = getColumn_Detail(4);
                String currency = getColumn_Detail(5);
                String year = getColumn_Detail(6);
                String maxAmtPeryear = getColumn_Detail(7);
                String entitledOffset = getColumn_Detail(8);

                if (notEmpty(serviceCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    pageSteps.setTextAtTableCell("Service Code", 1, serviceCode);
                    pageSteps.setTextAtTableCell("Sales Tax", 1, salesTax);
                    pageSteps.setCheckBoxAtTableCell("Incl. Tax", 1, inclTax);
                    pageSteps.setTextAtTableCell("Currency", 1, currency);
                    pageSteps.setTextAtTableCell("Year", 1, year);
                    pageSteps.setTextAtTableCell("Max Amt Per Year", 1, maxAmtPeryear);
                    pageSteps.setTextAtTableCell("Entitled Offset Per Visit", 1, entitledOffset);
                }
            }
        }
    }

    String breakDetNo = "";

    @Step("Set up eating break for basic salary employee")
    private void setupEatingBreak(String eatingBreakDetailNo)
    {
        setDetailData("Eating Break");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                breakDetNo = detNo;
            if (breakDetNo.equalsIgnoreCase(eatingBreakDetailNo))
            {
                String periodType = getColumn_Detail(2);
                String lunchTimeFrom = getColumn_Detail(3);
                String lunchTimeTo = getColumn_Detail(4);
                String dinnerTimeFrom = getColumn_Detail(5);
                String dinnerTimeTo = getColumn_Detail(6);
                String supperTimeFrom = getColumn_Detail(7);
                String supperTimeTo = getColumn_Detail(8);

                if (periodType.equalsIgnoreCase("Weekday") || periodType.equalsIgnoreCase("Saturday") || periodType.equalsIgnoreCase(
                        "Sunday") || periodType.equalsIgnoreCase("Public Holiday"))
                {
                    //pageSteps.setTextAtTableCellLunchBreak("", periodType, lunchTimeFrom, lunchTimeTo, "", "");
                    //pageSteps.setTextAtTableCellDinnerBreak("", periodType, dinnerTimeFrom, dinnerTimeTo, "", "");
                    //pageSteps.setTextAtTableCellSupperBreak("", periodType, supperTimeFrom, supperTimeTo, "", "");
                    int row = 1;
                    switch (periodType)
                    {
                        case "Weekday":
                            row = 1;
                            break;
                        case "Saturday":
                            row = 2;
                            break;
                        case "Sunday":
                            row = 3;
                            break;
                        case "Public Holiday":
                            row = 4;
                            break;
                    }
                    pageSteps.setTextAtXpathCSS("//table[contains(@id,'frmEatingBreak:tblEatingBreak')]/tbody/tr[" + row + "]/td[2]/input",
                                                lunchTimeFrom);
                    pageSteps.setTextAtXpathCSS("//table[contains(@id,'frmEatingBreak:tblEatingBreak')]/tbody/tr[" + row + "]/td[3]/input",
                                                lunchTimeTo);
                    pageSteps.setTextAtXpathCSS("//table[contains(@id,'frmEatingBreak:tblEatingBreak')]/tbody/tr[" + row + "]/td[4]/input",
                                                dinnerTimeFrom);
                    pageSteps.setTextAtXpathCSS("//table[contains(@id,'frmEatingBreak:tblEatingBreak')]/tbody/tr[" + row + "]/td[5]/input",
                                                dinnerTimeTo);
                    pageSteps.setTextAtXpathCSS("//table[contains(@id,'frmEatingBreak:tblEatingBreak')]/tbody/tr[" + row + "]/td[6]/input",
                                                supperTimeFrom);
                    pageSteps.setTextAtXpathCSS("//table[contains(@id,'frmEatingBreak:tblEatingBreak')]/tbody/tr[" + row + "]/td[7]/input",
                                                supperTimeTo);
                }
            }
        }
    }

    @Step("Set up leave penalty")
    private void setupLeavePenalty(String leavePenaltyDetailNo)
    {
        setDetailData("Leave Penalty");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(leavePenaltyDetailNo))
            {
                String leaveType = getColumn_Detail(2);
                String leaveDaysWOPenalty = getColumn_Detail(3);
                String entitledPeriod = getColumn_Detail(4);
                String dailyPenaltyAmt = getColumn_Detail(5);

                if (notEmpty(leaveType))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    pageSteps.setTextAtTableCell("Leave Type", 1, leaveType);
                    pageSteps.setTextAtTableCell("Leave Days without Penalty", 1, leaveDaysWOPenalty);
                    pageSteps.setDropDownOptionAtTableCell("Entitled Period", 1, entitledPeriod);
                    pageSteps.setTextAtTableCell("Daily Penalty Amt", 1, dailyPenaltyAmt);
                }
            }
        }
    }
}
