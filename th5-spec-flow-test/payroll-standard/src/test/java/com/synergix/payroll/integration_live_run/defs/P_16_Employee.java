package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.ReadBean;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_16_Employee extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;
    String companyCode = "";

    String reportPath = getPayrollOutputPath("daily_employee_th5.xls");

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Employee is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
//        companyCode = getProp("company.code");
        runCode = getProp("run.code");
        ReadBean.deleteFile(reportPath);
        String reportText = "";

        // turn off auto numbering
        pageSteps.goToMenu(MenuID.MS_PROCESSING_NUMBERING);
        pageSteps.setTableFilter("Module Code", "MT");
        pageSteps.setTableFilter("Transaction Type Code", "EMP");
        if (pageSteps.getRowsCount("Module Code") > 0)
            pageSteps.setCheckBoxAtTableCell("Auto Number", 1, "N");

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String empCode = getColumn(1);
            String empName = getColumn(2);
            String salutation = getColumn(3);
            String DOB = getColumn(4);
            String nationality = getColumn(5);
            String dateToBecomeCitizen = getColumn(6);
            String homeAddress = getColumn(7);
            String postalCode = getColumn(8);
            String gender = getColumn(9);
            String martialStt = getColumn(10);
            String race = getColumn(11);
            String religion = getColumn(12);
            String smartcardNo = getColumn(13);
            String countryCode = getColumn(14);
            String overseaAddr = getColumn(15);
            String zipCode = getColumn(16);
            String overseaCountryCode = getColumn(17);
            String subCompany = getColumn(18);
            String religionalOffice = getColumn(19);
            String empJobType = getColumn(20);
            String workingLocation = getColumn(21);
            String designation = getColumn(22);
            String designationEffDate = getColumn(23);
            String designGroup = getColumn(24);
            String designCountry = getColumn(25);
            String designCategory = getColumn(26);
            String teamLead = getColumn(27);
            String teamLeadEffDate = getColumn(28);
            String assDirector = getColumn(29);
            String assDirectorEffDate = getColumn(30);
            String director = getColumn(31);
            String directorEffDate = getColumn(32);
            String exclEndYear = getColumn(33);
            String exclConfirm = getColumn(34);
            String exclIntern = getColumn(35);
            String timesheet1stOfficer = getColumn(36);
            String timesheet1stOfficerEffDate = getColumn(37);
            String timesheet2ndOfficer = getColumn(38);
            String timesheet2ndOfficerEffDate = getColumn(39);
            String defaultPaymentCycle = getColumn(40);
            String dateToBecomePR = getColumn(41);
            String donationCode = getColumn(42);
            String epc = getColumn(43);
            String epcEffDate = getColumn(44);
            String relatedToTimesheet = getColumn(45);
            String salaryType = getColumn(46);
            String salaryTypeEffDate = getColumn(47);
            String grade = getColumn(48);
            String gradeEffDate = getColumn(49);
            String workingGroup = getColumn(50);
            String paymentCycle = getColumn(51);
            String mon = getColumn(52);
            String tue = getColumn(53);
            String wed = getColumn(54);
            String thu = getColumn(55);
            String fri = getColumn(56);
            String sat = getColumn(57);
            String sun = getColumn(58);
            String totalWHoursPerDay = getColumn(59);
            String totalWHoursPerWeek = getColumn(60);
            String encashmentOfLeave = getColumn(61);
            String morningTimeFrom = getColumn(62);
            String morningTimeTo = getColumn(63);
            String afternoonTimeFrom = getColumn(64);
            String afternoonTimeTo = getColumn(65);
            String basicSalaryInHomeCcy = getColumn(66);
            String basicSalaryEffDate = getColumn(67);
            String basicOTSchemeCode = getColumn(68);
            String capOvertime = getColumn(69);
            String hourlyRateAllowAmt = getColumn(70);
            String hourlyRateAllowAmtEffDate = getColumn(71);
            String fixedAdvandement = getColumn(72);
            String exemptCPF = getColumn(73);
            String commenceDate = getColumn(74);
            String periodOfEmploy = getColumn(75);
            String periodOfEmployAsAt = getColumn(76);
            String exclFromSubmission = getColumn(77);
            String sdlExemption = getColumn(78);
            String payrollReportingGroup = getColumn(79);
            String bankPaymentCycle = getColumn(80);
            String exemptIncomeType = getColumn(81);
            String exemptAmt = getColumn(82);
            String salaryBreakdown = getColumn(83);
            String deductWorkLate = getColumn(84);
            String deductLeaveEarly = getColumn(85);
            String maxTaxOnHoldAmt = getColumn(86);
            String deductionPerPayrunAmt = getColumn(87);

            if (empty(empCode))
                continue;

            // check for employee existence in DB to improve exec time
            //if (hasRecords("select * from MT_EMPLOYEE where EMPLOYEE_CODE = '" + empCode + "'"))
            //    continue;

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);

            String temp = empCode;
            if (notEmpty(runCode) && runCode.equalsIgnoreCase("date"))
                temp = empCode + DateTimeUtil.getTime("ddMMyy");

            // set fail subject and message
            setFailSubject("Daily Employee TH5 - Automated Mail Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Employee Code: " + temp);

            pageSteps.setTableFilter("Employee Code", temp);
            pageSteps.waitForProgressBar(1);
            if (pageSteps.getRowsCount("Employee Code") == 1) // already exists
                continue;

            pageSteps.clickButton("New");
            pageSteps.setText("Employee Code", temp);
            pageSteps.verifyResult("Employee Code: ", pageSteps.getTextValue("Employee Code"), temp);

            pageSteps.setText("Employee Name", empName);
            pageSteps.verifyResult("Employee Name: ", pageSteps.getTextValue("Employee Name"), empName);

            pageSteps.setDropDownOption("Salutation", salutation);
            pageSteps.waitForAjax(1);
            pageSteps.verifyResult("Salutation: ", pageSteps.getDropDownOptionValue("Salutation"), salutation);

            pageSteps.setText("Date of Birth", DOB);
            pageSteps.verifyResult("Date of Birth: ", pageSteps.getTextValue("Date of Birth"), DOB);

            pageSteps.setDropDownOption("Nationality", nationality);
            pageSteps.verifyResult("Nationality: ", pageSteps.getDropDownOptionValue("Nationality"), nationality);

            if (pageSteps.checkTextExist("Date to Become Citizen", true))
            {
                pageSteps.setText("Date to Become Citizen", dateToBecomeCitizen);
                pageSteps.verifyResult("Date to Become Citizen: ", pageSteps.getTextValue("Date to Become Citizen"), dateToBecomeCitizen);

                pageSteps.clickButton("Submit");
            }
            if (notEmpty(dateToBecomePR) && pageSteps.checkTextExist("Is Permanent Resident", true)) // none Singaporean acquires SPR status
            {
                if (!pageSteps.isCheckboxChecked("Is Permanent Resident"))
                {
                    pageSteps.setCheckbox("Is Permanent Resident", "Y");
                    pageSteps.verifyResult("Is Permanent Resident: ", pageSteps.isCheckboxChecked("Is Permanent Resident", "Y"));

                    pageSteps.setText("Date to Become PR", dateToBecomePR);
                    pageSteps.verifyResult("Date to Become PR: ", pageSteps.getTextValue("Date to Become PR"), dateToBecomePR);

                    pageSteps.clickButton("Submit");
                }
            }
            pageSteps.setTextArea("Home Address", homeAddress);
            pageSteps.verifyResult("Home Address: ", pageSteps.getTextArea("Home Address"), homeAddress);

            pageSteps.setText("Postal Code", postalCode);
            pageSteps.verifyResult("Postal Code: ", pageSteps.getTextValue("Postal Code"), postalCode);

            pageSteps.setDropDownOption("Gender", gender);
            pageSteps.verifyResult("Gender: ", pageSteps.getDropDownOptionValue("Gender"), gender);

            pageSteps.setDropDownOption("Marital Status", martialStt);
            pageSteps.verifyResult("Marital Status: ", pageSteps.getDropDownOptionValue("Marital Status"), martialStt);

            pageSteps.setDropDownOption("Race", race);
            pageSteps.verifyResult("Race: ", pageSteps.getDropDownOptionValue("Race"), race);

            pageSteps.setTextArea("Smart Card No.", smartcardNo);
            pageSteps.verifyResult("Smart Card No.: ", pageSteps.getTextArea("Smart Card No."), smartcardNo);

            pageSteps.setText("Country Code", countryCode);
            pageSteps.verifyResult("Country Code: ", pageSteps.getTextValue("Country Code"), countryCode);

            // Identification Documents
            setupIdentification(empCode);

            // TAB -System Role
            pageSteps.goToTab("System Role");
            setupSystemRole(empCode);

            // TAB - Employment Duration
            pageSteps.goToTab("Employment Duration");
            setupEmployment(empCode);

            // TAB - Singapore Specific
            pageSteps.goToTab("Singapore Specific");
            pageSteps.setText("Commencement Date of Employment In SG", commenceDate);
            pageSteps.verifyResult("Commencement Date of Employment In SG", pageSteps.getTextValue("Commencement Date of Employment In SG"),
                                   commenceDate);

            pageSteps.setText("Period Of Employment", periodOfEmploy);
            pageSteps.verifyResult("Period Of Employment", pageSteps.getTextValue("Period Of Employment"), periodOfEmploy);

            pageSteps.setText("Period Of Employment As At", periodOfEmployAsAt);
            pageSteps.verifyResult("Period Of Employment As At", pageSteps.getTextValue("Period Of Employment As At"), periodOfEmployAsAt);

            if (pageSteps.checkTextExist("Date to Become PR", true))
            {
                pageSteps.setText("Date to Become PR", dateToBecomePR);
                pageSteps.verifyResult("Date to Become PR", pageSteps.getTextValue("Date to Become PR"), dateToBecomePR);
            }
            if (pageSteps.checkTextExist("Date to Become Citizen", true))
            {
                pageSteps.setText("Date to Become Citizen", dateToBecomeCitizen);
                pageSteps.verifyResult("Date to Become Citizen", pageSteps.getTextValue("Date to Become Citizen"), dateToBecomeCitizen);
            }
            pageSteps.setRadioOption("Exempted from Employment Income File Submission (IR8A)", exclFromSubmission);
            pageSteps.verifyResult("Exempted from Employment Income File Submission (IR8A)",
                                   pageSteps.isRadioOptionChecked("Exclude From Employment Income File Submission", exclFromSubmission));

            pageSteps.setRadioOption("Exempted from SDL Contribution", sdlExemption);
            pageSteps.verifyResult("Exempted from SDL Contribution", pageSteps.isRadioOptionChecked("Exempted from SDL Contribution", sdlExemption));

            // Local Info tab only visible after updated
            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");

            // TAB - Local Info
            pageSteps.goToTab("Local Info");

            // TAB - Local Info - HR - General
            // must set Payment Cycle first
            pageSteps.setText("Payment Cycle", paymentCycle);
            pageSteps.verifyResult("Payment Cycle", pageSteps.getTextValue("Payment Cycle"), paymentCycle);

            // set up Grade, EPC, Emp Job Type
            pageSteps.goToTab("HR");
            setupGrade(empCode);

            // update to show Payroll tab
            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");

            if (notEmpty(salaryType))
            {
                pageSteps.clickButton("Edit", 2);
                pageSteps.setText("Effective Date", salaryTypeEffDate);
                pageSteps.verifyResult("Effective Date", pageSteps.getTextValue("Effective Date"), salaryTypeEffDate);

                pageSteps.setDropDownOption("Salary Type", salaryType);
                pageSteps.verifyResult("Salary Type", pageSteps.getDropDownOptionValue("Salary Type"), salaryType);

                pageSteps.clickButton("Submit");
                pageSteps.waitForAjax(1);
                pageSteps.confirm("OK");
            }

            pageSteps.setText("Payroll Reporting Group", payrollReportingGroup);
            pageSteps.verifyResult("Payroll Reporting Group", pageSteps.getTextValue("Payroll Reporting Group"), payrollReportingGroup);

            pageSteps.setText("Working Group", workingGroup);
            pageSteps.verifyResult("Working Group", pageSteps.getTextValue("Working Group"), workingGroup);

            pageSteps.setText("Working Location", workingLocation);
            pageSteps.verifyResult("Working Location", pageSteps.getTextValue("Working Location"), workingLocation);

            pageSteps.setText("Designated Country", designCountry);
            pageSteps.verifyResult("Designated Country", pageSteps.getTextValue("Designated Country"), designCountry);

            pageSteps.setDropDownOption("Designation Category", designCategory);
            pageSteps.verifyResult("Designation Category", pageSteps.getTextValue("Designation Category"), designCategory);

            if (notEmpty(designation))
            {
                pageSteps.clickButton("Edit", 3);
                pageSteps.setTextPopupPanel("Edit HR Info", "Effective Date", designationEffDate);
                pageSteps.verifyResult("Effective Date", pageSteps.getTextValue("Effective Date", 2), designationEffDate);

                pageSteps.setTextPopupPanel("Edit HR Info", "Designation", designation);
                pageSteps.verifyResult("Designation", pageSteps.getTextPopupPanel("Edit HR Info", "Designation"), designation);

                pageSteps.clickButton("Submit");
                pageSteps.waitForAjax(1);
                pageSteps.confirm("OK");
            }
            pageSteps.setText("Designation Group", designGroup);
            pageSteps.verifyResult("Designation Group", pageSteps.getTextValue("Designation Group"), designGroup);

            pageSteps.setRadioOption("Related To Timesheet", "Y"); // hardcode
            pageSteps.verifyResult("Related To Timesheet", pageSteps.isRadioOptionChecked("Related To Timesheet", "Y"));

            pageSteps.setRadioOption("Monitor employee in consolidated timesheet (\"No Record\" tab)", "Y"); // hardcode
            pageSteps.verifyResult("Monitor employee in consolidated timesheet (\"No Record\" tab)",
                                   pageSteps.isRadioOptionChecked("Monitor employee in consolidated timesheet (\"No Record\" tab)", "Y"));

            // TAB - Local Info - HR - Leave
            pageSteps.goToTab("Leave");
            pageSteps.setDropDownOption("Mon", mon);
            pageSteps.verifyResult("Mon", pageSteps.getDropDownOptionValue("Mon"), mon);

            pageSteps.setDropDownOption("Tue", tue);
            pageSteps.verifyResult("Tue", pageSteps.getDropDownOptionValue("Tue"), tue);

            pageSteps.setDropDownOption("Wed", wed);
            pageSteps.verifyResult("Wed", pageSteps.getDropDownOptionValue("Wed"), wed);

            pageSteps.setDropDownOption("Thu", thu);
            pageSteps.verifyResult("Thu", pageSteps.getDropDownOptionValue("Thu"), thu);

            pageSteps.setDropDownOption("Fri", fri);
            pageSteps.verifyResult("Fri", pageSteps.getDropDownOptionValue("Fri"), fri);

            pageSteps.setDropDownOption("Sat", sat);
            pageSteps.verifyResult("Sat", pageSteps.getDropDownOptionValue("Sat"), sat);

            pageSteps.setDropDownOption("Sun", sun);
            pageSteps.verifyResult("Sun", pageSteps.getDropDownOptionValue("Sun"), sun);

            pageSteps.setText("Total Working Hours Per Day", totalWHoursPerDay);
            pageSteps.verifyResult("Total Working Hours Per Day", pageSteps.getTextValue("Total Working Hours Per Day"), totalWHoursPerDay);

            pageSteps.setText("Total Working Hours Per Week", totalWHoursPerWeek);
            pageSteps.verifyResult("Total Working Hours Per Week", pageSteps.getTextValue("Total Working Hours Per Week"), totalWHoursPerWeek);

            pageSteps.setRadioOption("Encashment of Leave Upon Resignation", encashmentOfLeave);
            pageSteps.verifyResult("Encashment of Leave Upon Resignation",
                                   pageSteps.isRadioOptionChecked("Encashment of Leave Upon Resignation", encashmentOfLeave));

            pageSteps.setTextAtTableCell("Leave Duration", "Time From", 1, morningTimeFrom);
            pageSteps.verifyResult("Morning Time From", pageSteps.getTextAtTableCell("Leave Duration", "Time From", 1), morningTimeFrom);

            pageSteps.setTextAtTableCell("Leave Duration", "Time To", 1, morningTimeTo);
            pageSteps.verifyResult("Morning Time To", pageSteps.getTextAtTableCell("Leave Duration", "Time To", 1), morningTimeTo);

            pageSteps.setTextAtTableCell("Leave Duration", "Time From", 2, afternoonTimeFrom);
            pageSteps.verifyResult("Afternoon Time From", pageSteps.getTextAtTableCell("Leave Duration", "Time From", 2), afternoonTimeFrom);

            pageSteps.setTextAtTableCell("Leave Duration", "Time To", 2, afternoonTimeTo);
            pageSteps.verifyResult("Afternoon Time From", pageSteps.getTextAtTableCell("Leave Duration", "Time To", 2), afternoonTimeTo);

            // TAB - Local Info - Payroll
            pageSteps.goToTab("Payroll");

            if (ExcelUtils.isSheetExist(excelPath, "Salary"))
            {
                setupSalary(empCode);
            }
            else
            {
                if (notEmpty(basicSalaryInHomeCcy))
                {
                    pageSteps.clickButton("Edit");
                    pageSteps.openCalendar("Effective Date");
                    pageSteps.setCalendarDate(basicSalaryEffDate);
                    pageSteps.waitForAjax(1);
                    pageSteps.setTextPopupPanel("Edit Payroll Info", "Basic Salary (in Home CCY)", basicSalaryInHomeCcy);
                    pageSteps.verifyResult("Basic Salary (in Home CCY)",
                                           pageSteps.getTextPopupPanel("Edit Payroll Info", "Basic Salary (in Home CCY)"), basicSalaryInHomeCcy);

                    if (salaryType.equals("Basic OT"))
                    {
                        pageSteps.setTextPopupPanel("Edit Payroll Info", "Basic with OT Scheme Code", basicOTSchemeCode);
                        pageSteps.verifyResult("Basic with OT Scheme Code",
                                               pageSteps.getTextPopupPanel("Edit Payroll Info", "Basic with OT Scheme Code"), basicOTSchemeCode);
                    }
                    pageSteps.clickButton("Submit");
                    pageSteps.waitForAjax(1);
                    pageSteps.confirm("OK");
                }
            }
            if (salaryType.equals("Basic OT"))
            {
                pageSteps.setRadioOption("Cap Overtime Payment Rate", capOvertime);
                pageSteps.verifyResult("Cap Overtime Payment Rate", pageSteps.isRadioOptionChecked("Cap Overtime Payment Rate", capOvertime));
            }
            if (salaryType.equals("Hourly Rate"))
            {
                if (notEmpty(hourlyRateAllowAmt))
                {
                    pageSteps.clickButton("Edit", 2);
                    pageSteps.clickButton("Add", 2);
                    int rowNo = pageSteps.getRowsCount("Date From");
                    pageSteps.setTextAtTableCell("Date From", rowNo, "01/01/2010");
                    pageSteps.verifyResult("Date From", pageSteps.getTextAtTableCell("Date From", rowNo), "01/01/2010");

                    pageSteps.setTextAtTableCell("Date To", rowNo, "01/01/2020");
                    pageSteps.verifyResult("Date To", pageSteps.getTextAtTableCell("Date To", rowNo), "01/01/2020");

                    pageSteps.setTextAtTableCell("Allowance Amt", rowNo, hourlyRateAllowAmt);
                    pageSteps.verifyResult("Allowance Amt", pageSteps.getTextAtTableCell("Allowance Amt", rowNo), hourlyRateAllowAmt);

                    pageSteps.clickButton("Submit");
                }
            }
            pageSteps.setText("Fixed Advancement before Month End Payrun", fixedAdvandement);
            pageSteps.verifyResult("Fixed Advancement before Month End Payrun", pageSteps.getTextValue("Fixed Advancement before Month End Payrun"),
                                   fixedAdvandement);

            // TAB - Local Info - Payroll - General
            pageSteps.setText("Payroll Reporting Group", payrollReportingGroup);
            pageSteps.verifyResult("Payroll Reporting Group", pageSteps.getTextValue("Payroll Reporting Group"), payrollReportingGroup);

            pageSteps.setText("Payment Cycle", bankPaymentCycle);
            pageSteps.verifyResult("Payment Cycle", pageSteps.getTextValue("Payment Cycle"), bankPaymentCycle);

            // Bank Details
            setupBankDetail(empCode);

            // TAB - Local Info - Payroll - Community Fund Donation
            pageSteps.goToTab("Community Fund Donation");
            setupFundDonation(empCode);

            // TAB - Local Info - Payroll - Fixed Payment
            pageSteps.goToTab("Fixed Payment");
            setupFixedPayment(empCode);

            // TAB - Local Info - Payroll - Fixed Deduction
            pageSteps.goToTab("Fixed Deduction");
            setupFixedDeduction(empCode);

            if (salaryType.equals("Basic OT"))
            {
                pageSteps.setRadioOption("Deduction For Being Late For Work", deductWorkLate);
                pageSteps.verifyResult("Deduction For Being Late For Work",
                                       pageSteps.isRadioOptionChecked("Deduction For Being Late For Work", deductWorkLate));

                pageSteps.setRadioOption("Deduction For Leaving Work Early", deductLeaveEarly);
                pageSteps.verifyResult("Deduction For Leaving Work Early",
                                       pageSteps.isRadioOptionChecked("Deduction For Leaving Work Early", deductLeaveEarly));
            }

            // TAB - Local Info - Payroll - Tax On Hold
            pageSteps.goToTab("Tax On Hold");
            pageSteps.setText("Max Tax On Hold", maxTaxOnHoldAmt);
            pageSteps.verifyResult("Max Tax On Hold", pageSteps.getTextValue("Max Tax On Hold"), maxTaxOnHoldAmt);

            pageSteps.setText("Deduction Per Payrun", deductionPerPayrunAmt);
            pageSteps.verifyResult("Deduction Per Payrun", pageSteps.getTextValue("Deduction Per Payrun"), deductionPerPayrunAmt);

            setupTaxOnHold(empCode);

            // Update to main
            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            pageSteps.writeTableReportToExcel(CONST.reportKey, reportPath, temp); // write verify points to excel
            String report = pageSteps.getTableReport();
            reportText += report + "\n";
            pageSteps.verifyStepResult(report);
        }
        if (notEmpty(reportText) && ReadBean.isFile(reportPath))
            sendEmailToPY("Daily Employee TH5 - Automated Mail Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + "Please see the attached file for details" + "\n" + reportText,
                          reportPath);
        pageSteps.verifyFinalResult("Create Employee TH5");
    }

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Employee Local Info is set up as in\\s+\"([^\"]*)\"$")
    public void modifyEmployeeInfo(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String empCode = getColumn(1);
            String empName = getColumn(2);
            String salutation = getColumn(3);
            String DOB = getColumn(4);
            String nationality = getColumn(5);
            String dateToBecomeCitizen = getColumn(6);
            String homeAddress = getColumn(7);
            String postalCode = getColumn(8);
            String gender = getColumn(9);
            String martialStt = getColumn(10);
            String race = getColumn(11);
            String religion = getColumn(12);
            String smartcardNo = getColumn(13);
            String countryCode = getColumn(14);
            String overseaAddr = getColumn(15);
            String zipCode = getColumn(16);
            String overseaCountryCode = getColumn(17);
            String subCompany = getColumn(18);
            String religionalOffice = getColumn(19);
            String empJobType = getColumn(20);
            String workingLocation = getColumn(21);
            String designation = getColumn(22);
            String designationEffDate = getColumn(23);
            String designGroup = getColumn(24);
            String designCountry = getColumn(25);
            String designCategory = getColumn(26);
            String teamLead = getColumn(27);
            String teamLeadEffDate = getColumn(28);
            String assDirector = getColumn(29);
            String assDirectorEffDate = getColumn(30);
            String director = getColumn(31);
            String directorEffDate = getColumn(32);
            String exclEndYear = getColumn(33);
            String exclConfirm = getColumn(34);
            String exclIntern = getColumn(35);
            String timesheet1stOfficer = getColumn(36);
            String timesheet1stOfficerEffDate = getColumn(37);
            String timesheet2ndOfficer = getColumn(38);
            String timesheet2ndOfficerEffDate = getColumn(39);
            String defaultPaymentCycle = getColumn(40);
            String dateToBecomePR = getColumn(41);
            String donationCode = getColumn(42);
            String epc = getColumn(43);
            String epcEffDate = getColumn(44);
            String relatedToTimesheet = getColumn(45);
            String salaryType = getColumn(46);
            String salaryTypeEffDate = getColumn(47);
            String grade = getColumn(48);
            String gradeEffDate = getColumn(49);
            String workingGroup = getColumn(50);
            String paymentCycle = getColumn(51);
            String mon = getColumn(52);
            String tue = getColumn(53);
            String wed = getColumn(54);
            String thu = getColumn(55);
            String fri = getColumn(56);
            String sat = getColumn(57);
            String sun = getColumn(58);
            String totalWHoursPerDay = getColumn(59);
            String totalWHoursPerWeek = getColumn(60);
            String encashmentOfLeave = getColumn(61);
            String morningTimeFrom = getColumn(62);
            String morningTimeTo = getColumn(63);
            String afternoonTimeFrom = getColumn(64);
            String afternoonTimeTo = getColumn(65);
            String basicSalaryInHomeCcy = getColumn(66);
            String basicSalaryEffDate = getColumn(67);
            String basicOTSchemeCode = getColumn(68);
            String capOvertime = getColumn(69);
            String hourlyRateAllowAmt = getColumn(70);
            String hourlyRateAllowAmtEffDate = getColumn(71);
            String fixedAdvandement = getColumn(72);
            String exemptCPF = getColumn(73);
            String commenceDate = getColumn(74);
            String periodOfEmploy = getColumn(75);
            String periodOfEmployAsAt = getColumn(76);
            String exclFromSubmission = getColumn(77);
            String sdlExemption = getColumn(78);
            String payrollReportingGroup = getColumn(79);
            String bankPaymentCycle = getColumn(80);
            String exemptIncomeType = getColumn(81);
            String exemptAmt = getColumn(82);
            String salaryBreakdown = getColumn(83);
            String deductWorkLate = getColumn(84);
            String deductLeaveEarly = getColumn(85);
            String maxTaxOnHoldAmt = getColumn(86);
            String deductionPerPayrunAmt = getColumn(87);

            if (empty(empCode))
                continue;

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.setTableFilter("Employee Code", empCode);
            pageSteps.waitForAjax(1);

            if (pageSteps.getRowsCount("Employee Code") == 0)
                continue;

            pageSteps.selectFirstRow("Employee Code");
            if (pageSteps.checkTextExist("Local Info", true))
            {
                // TAB - Local Info
                pageSteps.goToTab("Local Info");

                // TAB - Local Info - HR - General
                // must set Payment Cycle first
                pageSteps.setText("Payment Cycle", paymentCycle);
                if (notEmpty(epc))
                {
                    pageSteps.clickButton("Edit", 1);
                    pageSteps.openCalendar("Effective Date");
                    pageSteps.setCalendarDate(epcEffDate);
                    pageSteps.setText("Employee Payroll Category", epc, 2);
                    pageSteps.setText("Employee Job Type", empJobType, 2);
                    pageSteps.setText("Grade", grade, 2);
                    pageSteps.clickButton("Submit");
                    pageSteps.waitForAjax(1);
                    pageSteps.confirm("OK");
                }
                if (notEmpty(salaryType))
                {
                    pageSteps.clickButton("Edit", 2);
                    pageSteps.setText("Effective Date", salaryTypeEffDate);
                    pageSteps.setDropDownOption("Salary Type", salaryType);
                    pageSteps.clickButton("Submit");
                    pageSteps.waitForAjax(1);
                    pageSteps.confirm("OK");
                }

                pageSteps.setText("Payroll Reporting Group", payrollReportingGroup);
                pageSteps.setText("Working Group", workingGroup);
                pageSteps.setText("Working Location", workingLocation);
                pageSteps.setText("Designated Country", designCountry);
                pageSteps.setDropDownOption("Designation Category", designCategory);
                if (notEmpty(designation))
                {
                    pageSteps.clickButton("Edit", 3);
                    pageSteps.setTextPopupPanel("Edit HR Info", "Effective Date", designationEffDate);
                    pageSteps.setText("Designation", designation, 2);
                    pageSteps.clickButton("Submit");
                    pageSteps.waitForAjax(1);
                    pageSteps.confirm("OK");
                }
                pageSteps.setText("Designation Group", designGroup);
                pageSteps.setRadioOption("Related To Timesheet", "Y"); // hardcode
                pageSteps.setRadioOption("Monitor employee in consolidated timesheet (\"No Record\" tab)", "Y"); // hardcode

                // TAB - Local Info - HR - Leave
                pageSteps.goToTab("Leave");
                pageSteps.setDropDownOption("Mon", mon);
                pageSteps.setDropDownOption("Tue", tue);
                pageSteps.setDropDownOption("Wed", wed);
                pageSteps.setDropDownOption("Thu", thu);
                pageSteps.setDropDownOption("Fri", fri);
                pageSteps.setDropDownOption("Sat", sat);
                pageSteps.setDropDownOption("Sun", sun);
                pageSteps.setText("Total Working Hours Per Day", totalWHoursPerDay);
                pageSteps.setText("Total Working Hours Per Week", totalWHoursPerWeek);
                pageSteps.setRadioOption("Encashment of Leave Upon Resignation", encashmentOfLeave);
                pageSteps.setTextAtTableCell("Leave Duration", "Time From", 1, morningTimeFrom);
                pageSteps.setTextAtTableCell("Leave Duration", "Time To", 1, morningTimeTo);
                pageSteps.setTextAtTableCell("Leave Duration", "Time From", 2, afternoonTimeFrom);
                pageSteps.setTextAtTableCell("Leave Duration", "Time To", 2, afternoonTimeTo);

                // TAB - Local Info - Payroll
                pageSteps.goToTab("Payroll");
                if (notEmpty(basicSalaryInHomeCcy))
                {
                    pageSteps.clickButton("Edit");
                    pageSteps.openCalendar("Effective Date");
                    pageSteps.setCalendarDate(basicSalaryEffDate);
                    pageSteps.setText("Basic Salary (in Home CCY)", basicSalaryInHomeCcy, 2);
                    if (salaryType.equals("Basic OT"))
                        pageSteps.setText("Basic with OT Scheme Code", basicOTSchemeCode, 2);
                    pageSteps.clickButton("Submit");
                    pageSteps.waitForAjax(1);
                    pageSteps.confirm("OK");
                }
                if (salaryType.equals("Basic OT"))
                    pageSteps.setRadioOption("Cap Overtime Payment Rate", capOvertime);
                if (salaryType.equals("Hourly Rate"))
                {
                    if (notEmpty(hourlyRateAllowAmt))
                    {
                        pageSteps.clickButton("Edit", 2);
                        pageSteps.clickButton("Add", 2);
                        int rowNo = pageSteps.getRowsCount("Date From");
                        pageSteps.setTextAtTableCell("Date From", rowNo, "01/01/2010");
                        pageSteps.setTextAtTableCell("Date To", rowNo, "01/01/2020");
                        pageSteps.setTextAtTableCell("Allowance Amt", rowNo, hourlyRateAllowAmt);
                        pageSteps.clickButton("Submit");
                    }
                }
                pageSteps.setText("Fixed Advancement before Month End Payrun", fixedAdvandement);

                // TAB - Local Info - Payroll - General
                pageSteps.setText("Payroll Reporting Group", payrollReportingGroup);
                pageSteps.setText("Payment Cycle", bankPaymentCycle);

                // Bank Details
                setupBankDetail(empCode);

                // TAB - Local Info - Payroll - Community Fund Donation
                pageSteps.goToTab("Community Fund Donation");
                setupFundDonation(empCode);

                // TAB - Local Info - Payroll - Fixed Payment
                pageSteps.goToTab("Fixed Payment");
                setupFixedPayment(empCode);

                // TAB - Local Info - Payroll - Fixed Deduction
                pageSteps.goToTab("Fixed Deduction");
                setupFixedDeduction(empCode);
                if (salaryType.equals("Basic OT"))
                {
                    pageSteps.setRadioOption("Deduction For Being Late For Work", deductWorkLate);
                    pageSteps.setRadioOption("Deduction For Leaving Work Early", deductLeaveEarly);
                }

                // TAB - Local Info - Payroll - Tax On Hold
                pageSteps.goToTab("Tax On Hold");
                pageSteps.setText("Max Tax On Hold", maxTaxOnHoldAmt);
                pageSteps.setText("Deduction Per Payrun", deductionPerPayrunAmt);
                setupTaxOnHold(empCode);

                pageSteps.goToTab("SBU");
                setupSBU(empCode);

                // Update to main
                pageSteps.clickButton("Update");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Step("Set up SBU")
    private void setupSBU(String empCode)
    {
        setDetailData("SBU");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(empCode))
            {
                String sbu = getColumn_Detail(2);
                if (notEmpty(sbu))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.setTextAtTableCell("Strategic Business Unit", 1, sbu);
                }
            }
        }
    }

    @Step("Set up identification documents")
    public void setupIdentification(String idDetailNo)
    {
        setDetailData("Identification");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(idDetailNo))
            {
                String idType = getColumn_Detail(2);
                String idNo = getColumn_Detail(3);
                String appDate = getColumn_Detail(4);
                String issDate = getColumn_Detail(5);
                String expDate = getColumn_Detail(6);
                String cardReturnDate = getColumn_Detail(7);

                if (notEmpty(idType))
                {
                    if (pageSteps.getRowsCount("Identification Type") == 0)
                        pageSteps.clickButton("Add");
                    pageSteps.setDropDownOptionAtTableCell("Identification Documents", "Identification Type", 1, idType);
                    pageSteps.waitForAjax(1);
                    pageSteps.verifyResult("Identification Type",
                                           pageSteps.getDropDownOptionAtTableCell("Identification Documents", "Identification Type", 1), idType);

                    pageSteps.setTextAtTableCell("Identification Documents", "Identification No.", 1, idNo);
                    pageSteps.waitForAjax(1);
                    pageSteps.verifyResult("Identification No.",
                                           pageSteps.getDropDownOptionAtTableCell("Identification Documents", "Identification No.", 1), idNo);

                    pageSteps.setTextAtTableCell("Identification Documents", "Application Date", 1, appDate);
                    pageSteps.verifyResult("Application Date", pageSteps.getTextAtTableCell("Identification Documents", "Application Date", 1),
                                           appDate);

                    pageSteps.setTextAtTableCell("Identification Documents", "Issue Date", 1, issDate);
                    pageSteps.verifyResult("Issue Date", pageSteps.getTextAtTableCell("Identification Documents", "Issue Date", 1), issDate);

                    pageSteps.setTextAtTableCell("Identification Documents", "Expiry Date", 1, expDate);
                    pageSteps.verifyResult("Expiry Date", pageSteps.getTextAtTableCell("Identification Documents", "Expiry Date", 1), expDate);
                    break; // only 1 identification is needed
                }
            }
        }
    }

    @Step("Set up system role")
    public void setupSystemRole(String systemRoleDetailNo)
    {
        String empCode = "";

        setDetailData("System Role");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                empCode = detNo;
            if (empCode.equalsIgnoreCase(systemRoleDetailNo))
            {
                String role = getColumn_Detail(2);
                if (notEmpty(role))
                {
                    pageSteps.setTableFilter("Employee System Role", role);
                    pageSteps.setRadioOptionAtTableCell("Allowed", 1, "Y");
                    pageSteps.verifyResult("System Role", pageSteps.isRadioOptionAtTableCellChecked("Allowed", 1, "Y"));
                }
            }
        }
    }

    @Step("Set up employment duration")
    private void setupEmployment(String empCode)
    {
        String detailNo = "";
        setDetailData("Employment");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                detailNo = detNo;
            if (detailNo.equalsIgnoreCase(empCode))
            {
                String joinDate = getColumn_Detail(3);
                String confirmDate = getColumn_Detail(4);
                String cessDate = getColumn_Detail(5);
                String yearOS = getColumn_Detail(6);
                if (empty(companyCode))
                    companyCode = getColumn_Detail(7);
                String employStt = getColumn_Detail(8);

                if (notEmpty(joinDate))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Join Date");
                    pageSteps.setTextAtTableCell("Join Date", rowNo, joinDate);
                    pageSteps.verifyResult("Join Date", pageSteps.getTextAtTableCell("Join Date", rowNo), joinDate);

                    pageSteps.setTextAtTableCell("Confirmation Date", rowNo, confirmDate);
                    pageSteps.verifyResult("Confirmation Date", pageSteps.getTextAtTableCell("Confirmation Date", rowNo), confirmDate);

                    pageSteps.setTextAtTableCell("Cessation Date", rowNo, cessDate);
                    pageSteps.verifyResult("Cessation Date", pageSteps.getTextAtTableCell("Cessation Date", rowNo), cessDate);

                    pageSteps.setTextAtTableCell("Company Code", rowNo, companyCode); // get the company code in properties file
                    pageSteps.verifyResult("Company Code", pageSteps.getTextAtTableCell("Company Code", rowNo), companyCode);

                    pageSteps.setDropDownOptionAtTableCell("Employment Status", rowNo, employStt);
                    pageSteps.verifyResult("Employment Status", pageSteps.getTextAtTableCell("Employment Status", rowNo), employStt);

                    if (notEmpty(yearOS))
                    {
                        pageSteps.clickButton("Update");
                        pageSteps.confirm("Yes");
                        executeUpdate(
                                "UPDATE MT_EMPLOYEE_CONTRACT SET INCLUDE_IN_YEAR_SERVICE = '" + yearOS + "' WHERE EMPLOYEE_CODE = '" + empCode + "' AND JOIN_DATE = '" + DateTimeUtil.reverseDate(
                                        joinDate) + "'");
                    }
                }
            }
        }
    }

    @Step("Set up Salary")
    private void setupSalary(String empCode)
    {
        String detailNo = "";
        setDetailData("Salary");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
                detailNo = detNo;
            if (detailNo.equalsIgnoreCase(empCode))
            {
                String basicSalaryInHomeCcy = getColumn_Detail(2);
                String basicSalaryEffDate = getColumn_Detail(3);

                pageSteps.clickButton("Edit");
                pageSteps.openCalendar("Effective Date");
                pageSteps.setCalendarDate(basicSalaryEffDate);
                pageSteps.waitForAjax(1);
                pageSteps.setTextPopupPanel("Edit Payroll Info", "Basic Salary (in Home CCY)", basicSalaryInHomeCcy);
                pageSteps.verifyResult("Basic Salary (in Home CCY)", pageSteps.getTextPopupPanel("Edit Payroll Info", "Basic Salary (in Home CCY)"),
                                       basicSalaryInHomeCcy);

//                if (salaryType.equals("Basic OT"))
//                {
//                    pageSteps.setTextPopupPanel("Edit Payroll Info", "Basic with OT Scheme Code", basicOTSchemeCode);
//                    pageSteps.verifyResult("Basic with OT Scheme Code", pageSteps.getTextPopupPanel("Edit Payroll Info", "Basic with OT Scheme Code"),
//                                           basicOTSchemeCode);
//                }
                pageSteps.clickButton("Submit");
                pageSteps.waitForAjax(1);
                pageSteps.confirm("OK");
            }
        }
    }

    @Step("Setup bank details")
    private void setupBankDetail(String bankDetailNo)
    {
        setDetailData("Bank");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String paymentMethod = getColumn_Detail(2);
                String employerBank = getColumn_Detail(3);
                String employerBankAccNo = getColumn_Detail(4);
                String employeeBank = getColumn_Detail(5);
                String employeeBankAccNo = getColumn_Detail(6);
                String employeeBankBranchCode = getColumn_Detail(7);

                if (notEmpty(paymentMethod))
                {
                    if (pageSteps.checkTextExist("Bank Details", true))
                    {
                        pageSteps.clickButton("Add");
                        pageSteps.waitForAjax(1);
                        pageSteps.setDropDownOptionAtTableCell("Payment Method", 1, paymentMethod);
                        pageSteps.verifyResult("Payment Method", pageSteps.getDropDownOptionAtTableCell("Payment Method", 1), paymentMethod);

                        pageSteps.setTextAtTableCell("Employer Bank", 1, employerBank);
                        pageSteps.verifyResult("Employer Bank", pageSteps.getTextAtTableCell("Employer Bank", 1), employerBank);

                        pageSteps.setTextAtTableCell("Employer Bank Account No.", 1, employerBankAccNo);
                        pageSteps.verifyResult("Employer Bank Account No.", pageSteps.getTextAtTableCell("Employer Bank Account No.", 1),
                                               employerBankAccNo);

                        pageSteps.setTextAtTableCell("Employee Bank", 1, employeeBank);
                        pageSteps.verifyResult("Employee Bank", pageSteps.getTextAtTableCell("Employee Bank", 1), employeeBank);

                        pageSteps.setTextAtTableCell("Employee Bank Account No.", 1, employeeBankAccNo);
                        pageSteps.verifyResult("Employee Bank Account No.", pageSteps.getTextAtTableCell("Employee Bank Account No.", 1),
                                               employeeBankAccNo);

                        pageSteps.setTextAtTableCell("Employee Bank Branch Code", 1, employeeBankBranchCode);
                        pageSteps.verifyResult("Employee Bank Branch Code", pageSteps.getTextAtTableCell("Employee Bank Branch Code", 1),
                                               employeeBankBranchCode);
                        break; // only set the first row cuz in TH5, Bank Details are not in table
                    }
                    else
                    {
                        pageSteps.setDropDownOption("Payment Method", paymentMethod);
                        pageSteps.verifyResult("Payment Method", pageSteps.getDropDownOptionValue("Payment Method"), paymentMethod);

                        pageSteps.setText("Employer Bank", employerBank);
                        pageSteps.verifyResult("Employer Bank", pageSteps.getTextValue("Employer Bank"), employerBank);

                        pageSteps.setText("Employer Bank Account No.", employerBankAccNo);
                        pageSteps.verifyResult("Employer Bank Account No.", pageSteps.getTextValue("Employer Bank Account No."), employerBankAccNo);

                        if (paymentMethod.equals("Bank"))
                        {
                            pageSteps.setText("Employee Bank", employeeBank);
                            pageSteps.verifyResult("Employee Bank", pageSteps.getTextValue("Employee Bank"), employeeBank);

                            pageSteps.setText("Employee Bank Account No.", employeeBankAccNo);
                            pageSteps.verifyResult("Employee Bank Account No.", pageSteps.getTextValue("Employee Bank Account No."),
                                                   employeeBankAccNo);

                            pageSteps.setText("Employee Bank Branch Code", employeeBankBranchCode);
                            pageSteps.verifyResult("Employee Bank Branch Code", pageSteps.getTextValue("Employee Bank Branch Code"),
                                                   employeeBankBranchCode);
                        }
                        break; // only set the first row cuz in TH5, Bank Details are not in table
                    }
                }
            }
        }
    }

    @Step("Setup community fund donation")
    private void setupFundDonation(String communityFundDonationDetailNo)
    {
        setDetailData("Fund");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(communityFundDonationDetailNo))
            {
                String donationCode = getColumn_Detail(2);
                String desc = getColumn_Detail(3);

                if (notEmpty(donationCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Donation Code");
                    pageSteps.setTextAtTableCell("Donation Code", rowNo, donationCode);
                    pageSteps.verifyResult("Donation Code", pageSteps.getTextAtTableCell("Donation Code", rowNo), donationCode);

                    pageSteps.setTextAtTableCell("Description", rowNo, desc);
                    pageSteps.verifyResult("Description", pageSteps.getTextAtTableCell("Description", rowNo), desc);
                }
            }
        }
    }

    @Step("Setup fixed payment")
    private void setupFixedPayment(String fixedPaymentDetailNo)
    {
        setDetailData("Fixed Payment");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(fixedPaymentDetailNo))
            {
                String wageService = getColumn_Detail(2);
                String remarks = getColumn_Detail(3);
                String effStartDate = getColumn_Detail(4);
                String effEndDate = getColumn_Detail(5);
                String freq = getColumn_Detail(6);
                String amt = getColumn_Detail(7);
                String inclTax = getColumn_Detail(8);
                String salesTax = getColumn_Detail(9);
                String prorated = getColumn_Detail(10);

                if (notEmpty(wageService))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Wage Service");
                    pageSteps.setTextAtTableCell("Wage Service", rowNo, wageService);
                    pageSteps.verifyResult("Wage Service", pageSteps.getTextAtTableCell("Wage Service", rowNo), wageService);

                    pageSteps.setTextAtTableCell("Effective Start Date", rowNo, effStartDate);
                    pageSteps.verifyResult("Effective Start Date", pageSteps.getTextAtTableCell("Effective Start Date", rowNo), effStartDate);

                    pageSteps.setTextAtTableCell("Effective End Date", rowNo, effEndDate);
                    pageSteps.verifyResult("Effective End Date", pageSteps.getTextAtTableCell("Effective End Date", rowNo), effEndDate);

                    pageSteps.setDropDownOptionAtTableCell("Frequency", rowNo, freq);
                    pageSteps.verifyResult("Frequency", pageSteps.getDropDownOptionAtTableCell("Frequency", rowNo), freq);

                    pageSteps.setTextAtTableCell("Amt", 5, rowNo, amt);
                    pageSteps.verifyResult("Amt", pageSteps.getTextAtTableCell("Amt", 5, rowNo), amt);

                    pageSteps.setCheckBoxAtTableCell("Incl. Tax", rowNo, inclTax);
                    pageSteps.verifyResult("Incl. Tax", pageSteps.isCheckBoxAtTableCellChecked("Incl. Tax", rowNo, inclTax));

                    if (inclTax.equalsIgnoreCase("Y"))
                    {
                        pageSteps.setDropDownOptionAtTableCell("Sales Tax", rowNo, salesTax);
                        pageSteps.verifyResult("Sales Tax", pageSteps.getDropDownOptionAtTableCell("Sales Tax", rowNo), salesTax);
                    }
                    pageSteps.setCheckBoxAtTableCell("Prorated", rowNo, prorated);
                    pageSteps.verifyResult("Prorated", pageSteps.isCheckBoxAtTableCellChecked("Prorated", rowNo, prorated));
                }
            }
        }
    }

    @Step("Setup fixed deduction")
    private void setupFixedDeduction(String fixedDeductionDetailNo)
    {
        setDetailData("Fixed Deduction");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(fixedDeductionDetailNo))
            {
                String wageService = getColumn_Detail(2);
                String remarks = getColumn_Detail(3);
                String effStartDate = getColumn_Detail(4);
                String effEndDate = getColumn_Detail(5);
                String freq = getColumn_Detail(6);
                String amt = getColumn_Detail(7);
                String inclTax = getColumn_Detail(8);
                String salesTax = getColumn_Detail(9);
                String prorated = getColumn_Detail(10);

                if (notEmpty(wageService))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Wage Service");
                    pageSteps.setTextAtTableCell("Wage Service", rowNo, wageService);
                    pageSteps.verifyResult("Wage Service", pageSteps.getTextAtTableCell("Wage Service", rowNo), wageService);

                    pageSteps.setTextAtTableCell("Effective Start Date", rowNo, effStartDate);
                    pageSteps.verifyResult("Effective Start Date", pageSteps.getTextAtTableCell("Effective Start Date", rowNo), effStartDate);

                    pageSteps.setTextAtTableCell("Effective End Date", rowNo, effEndDate);
                    pageSteps.verifyResult("Effective End Date", pageSteps.getTextAtTableCell("Effective End Date", rowNo), effEndDate);

                    pageSteps.setDropDownOptionAtTableCell("Frequency", rowNo, freq);
                    pageSteps.verifyResult("Frequency", pageSteps.getDropDownOptionAtTableCell("Frequency", rowNo), freq);

                    pageSteps.setTextAtTableCell("Amt", 5, rowNo, amt);
                    pageSteps.verifyResult("Amt", pageSteps.getTextAtTableCell("Amt", 5, rowNo), amt);

                    pageSteps.setCheckBoxAtTableCell("Incl. Tax", rowNo, inclTax);
                    pageSteps.verifyResult("Incl. Tax", pageSteps.isCheckBoxAtTableCellChecked("Incl. Tax", rowNo, inclTax));

                    if (inclTax.equalsIgnoreCase("Y"))
                    {
                        pageSteps.setDropDownOptionAtTableCell("Sales Tax", rowNo, salesTax);
                        pageSteps.verifyResult("Sales Tax", pageSteps.getDropDownOptionAtTableCell("Sales Tax", rowNo), salesTax);
                    }
                    pageSteps.setCheckBoxAtTableCell("Prorated", rowNo, prorated);
                    pageSteps.verifyResult("Prorated", pageSteps.isCheckBoxAtTableCellChecked("Prorated", rowNo, prorated));
                }
            }
        }
    }

    @Step("Setup tax on hold")
    private void setupTaxOnHold(String taxOnHoldDetailNo)
    {
        setDetailData("Tax");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(taxOnHoldDetailNo))
            {
                String dateFrom = getColumn_Detail(2);
                String dateTo = getColumn_Detail(3);
                String amt = getColumn_Detail(4);

                if (notEmpty(dateFrom))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Tax On Hold Amt");
                    pageSteps.setTextAtTableCell("Date From", rowNo, dateFrom);
                    pageSteps.verifyResult("Tax On Hold Date From", pageSteps.getTextAtTableCell("Date From", rowNo), dateFrom);

                    pageSteps.setTextAtTableCell("Date To", rowNo, dateTo);
                    pageSteps.verifyResult("Tax On Hold Date To", pageSteps.getTextAtTableCell("Date To", rowNo), dateTo);

                    pageSteps.setTextAtTableCell("Tax On Hold Amt", rowNo, amt);
                    pageSteps.verifyResult("Tax On Hold Amt", pageSteps.getTextAtTableCell("Tax On Hold Amt", rowNo), amt);
                }
            }
        }
    }

    @Step("Setup grade")
    private void setupGrade(String empCode)
    {
        setDetailData("Grade");
        if (detailObjArray.length < 1)
            return;
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(empCode))
            {
                String grade = getColumn_Detail(3);
                String effDate = getColumn_Detail(4);
                String epc = getColumn_Detail(5);
                String empJobType = getColumn_Detail(6);

                if (notEmpty(grade) || notEmpty(epc) || notEmpty(empJobType))
                {
                    pageSteps.clickButton("Edit", 1);
                    pageSteps.openCalendar("Effective Date");
                    pageSteps.setCalendarDate(effDate);
                    pageSteps.setTextPopupPanel("Edit HR Info", "Employee Payroll Category", epc);
                    pageSteps.verifyResult("Payment Cycle", pageSteps.getTextPopupPanel("Edit HR Info", "Employee Payroll Category"), epc);

                    pageSteps.setTextPopupPanel("Edit HR Info", "Employee Job Type", empJobType);
                    pageSteps.verifyResult("Employee Job Type", pageSteps.getTextPopupPanel("Edit HR Info", "Employee Job Type"), empJobType);

                    pageSteps.setTextPopupPanel("Edit HR Info", "Grade", grade);
                    pageSteps.verifyResult("Grade", pageSteps.getTextPopupPanel("Edit HR Info", "Grade"), grade);

                    pageSteps.clickButton("Submit");
                    pageSteps.waitForAjax(1);
                    pageSteps.confirm("OK");
                }
            }
        }
    }
}
