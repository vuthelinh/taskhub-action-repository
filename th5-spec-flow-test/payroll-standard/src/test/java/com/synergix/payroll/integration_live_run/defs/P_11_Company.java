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

public class P_11_Company extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Company Info is set up as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String companyCode = getColumn(1);
            String sbu = getColumn(2);
            String companyName = getColumn(3);
            String address = getColumn(4);
            String postalCode = getColumn(5);
            String country = getColumn(6);
            String telNo_Comp = getColumn(7);
            String faxNo = getColumn(8);
            String taxAccNo = getColumn(9);
            String rocNo = getColumn(10);
            String mainHomePage = getColumn(11);
            String defaultTheme = getColumn(12);
            String entityID = getColumn(13);
            String compID = getColumn(14);
            String assSuppCode = getColumn(15);
            String assCustCode = getColumn(16);
            String globalManPow = getColumn(17);
            String orgIDType = getColumn(18);
            String orgIDNo = getColumn(19);
            String autPerson = getColumn(20);
            String designation = getColumn(21);
            String email = getColumn(22);
            String telNo_Emp = getColumn(23);
            String fileSrc = getColumn(24);
            String nameOfDiv = getColumn(25);
            String nationalCode = getColumn(26);
            String companyDetailNo = getColumn(27);

            if (empty(companyCode))
                continue;

            // set fail subject and message
            setFailSubject("Set up Company Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + companyCode);

            pageSteps.goToMenu(MenuID.GL_COMPANY);
            pageSteps.selectRow("Company Code", companyCode);

            pageSteps.waitForTextToShow(companyCode, 10);

            if (pageSteps.checkTextExist("SBU", true))
            {
                pageSteps.setText("SBU", sbu);
                pageSteps.verifyResult("SBU", pageSteps.getTextValue("SBU"), sbu);
            }
            pageSteps.setText("Company Name", companyName);
            pageSteps.verifyResult("Company Name", pageSteps.getTextValue("Company Name"), companyName);

            pageSteps.setTextArea("Address", address);
            pageSteps.verifyResult("Address", pageSteps.getTextArea("Address"), address);

            pageSteps.setText("Postal Code", postalCode);
            pageSteps.verifyResult("Postal Code", pageSteps.getTextValue("Postal Code"), postalCode);

            pageSteps.setDropDownOption("Country", country);
            pageSteps.verifyResult("Country", pageSteps.getDropDownOptionValue("Country"), postalCode);

            pageSteps.setText("Telephone Number", telNo_Comp);
            pageSteps.verifyResult("Telephone Number", pageSteps.getTextValue("Telephone Number"), telNo_Comp);

            pageSteps.setText("Fax Number", faxNo);
            pageSteps.verifyResult("Fax Number", pageSteps.getTextValue("Fax Number"), faxNo);

            pageSteps.setText("Tax Account Number", taxAccNo);
            pageSteps.verifyResult("Tax Account Number", pageSteps.getTextValue("Tax Account Number"), taxAccNo);

            pageSteps.setText("ROC No.", rocNo);
            pageSteps.verifyResult("ROC No.", pageSteps.getTextValue("ROC No."), rocNo);

            pageSteps.setText("Main Home Page", mainHomePage);
            pageSteps.verifyResult("Main Home Page", pageSteps.getTextValue("Main Home Page"), mainHomePage);

            pageSteps.setDropDownOption("Default Theme", defaultTheme);
            pageSteps.verifyResult("Default Theme", pageSteps.getDropDownOptionValue("Default Theme"), defaultTheme);

            pageSteps.setText("Entity ID", entityID);
            pageSteps.verifyResult("Entity ID", pageSteps.getTextValue("Entity ID"), entityID);

            pageSteps.setText("Company ID", compID);
            pageSteps.verifyResult("Company ID", pageSteps.getTextValue("Company ID"), compID);

            // TAB - Intercompany Billing
            pageSteps.goToTab("Intercompany Billing");
            pageSteps.setText("Associated Supplier Code", assSuppCode);
            pageSteps.verifyResult("Associated Supplier Code", pageSteps.getTextValue("Associated Supplier Code"), assSuppCode);

            pageSteps.setText("Associated Customer Code", assCustCode);
            pageSteps.verifyResult("Associated Customer Code", pageSteps.getTextValue("Associated Customer Code"), assCustCode);

            pageSteps.setRadioOption("Global Manpower Enabled", globalManPow);
            pageSteps.verifyResult("Global Manpower Enabled", pageSteps.isRadioOptionChecked("Global Manpower Enabled", globalManPow));

            // TAB - Employment Income
            if (pageSteps.checkTextExist("Employment Income", true))
            {
                pageSteps.goToTab("Employment Income");
                pageSteps.setDropDownOption("Organization ID Type", orgIDType);
                pageSteps.verifyResult("Organization ID Type", pageSteps.getDropDownOptionValue("Organization ID Type"), orgIDType);

                pageSteps.setText("Organization ID No", orgIDNo);
                pageSteps.verifyResult("Organization ID No", pageSteps.getTextValue("Organization ID No"), orgIDNo);

                pageSteps.setText("Authorized Person", autPerson);
                pageSteps.verifyResult("Authorized Person", pageSteps.getTextValue("Authorized Person"), autPerson);

                pageSteps.setText("Designation", designation);
                pageSteps.verifyResult("Designation", pageSteps.getTextValue("Designation"), designation);

                pageSteps.setText("Email Address", email);
                pageSteps.verifyResult("Email Address", pageSteps.getTextValue("Email Address"), email);

                pageSteps.setText("Telephone Number", telNo_Emp);
                pageSteps.verifyResult("Telephone Number", pageSteps.getTextValue("Telephone Number"), telNo_Emp);

                pageSteps.setDropDownOption("File Source", fileSrc);
                pageSteps.verifyResult("File Source", pageSteps.getDropDownOptionValue("File Source"), fileSrc);

                pageSteps.setText("Name of Division/Branch", nameOfDiv);
                pageSteps.verifyResult("Name of Division/Branch", pageSteps.getTextValue("Name of Division/Branch"), nameOfDiv);

                pageSteps.setText("Permanent Resident Nationality Code", nationalCode);
                pageSteps.verifyResult("Permanent Resident Nationality Code", pageSteps.getTextValue("Permanent Resident Nationality Code"),
                                       nationalCode);
            }

            // TAB - CPF
            pageSteps.goToTab("CPF");
            setupCPF(companyDetailNo);

            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");

            // TAB - Consolidation
            pageSteps.goToTab("Consolidation");
            setupConsol(companyDetailNo);

            pageSteps.goToTab("General Info");

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Setup Company Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Company Code: " + companyCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Setup Company Report");
    }

    @Step("Set up CPF")
    public void setupCPF(String companyDetailNo)
    {
        setDetailData("CPF");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(companyDetailNo))
            {
                String cpfSubmissionNo = getColumn_Detail(2);
                pageSteps.clickButton("Add");
                pageSteps.setTextAtTableCell("CPF Submission No.", 1, cpfSubmissionNo);
                pageSteps.verifyResult("CPF Submission No.", pageSteps.getTextAtTableCell("CPF Submission No.", 1), cpfSubmissionNo);
            }
        }
    }

    @Step("Set up consolidation")
    public void setupConsol(String companyDetailNo)
    {
        setDetailData("Consolidation");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(companyDetailNo))
            {
                String comp = getColumn_Detail(2);
                pageSteps.setTextAtTableCell("Subsidiary Company", 1, comp);
                pageSteps.verifyResult("Subsidiary Company", pageSteps.getTextAtTableCell("Subsidiary Company", 1), comp);
            }
        }
    }
}
