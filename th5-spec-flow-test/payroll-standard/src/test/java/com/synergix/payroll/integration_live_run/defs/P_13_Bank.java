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

public class P_13_Bank extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Bank is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String partyCode = getColumn(1);
            String partyName = getColumn(2);
            String partyShortName = getColumn(3);
            String partyGroupCode = getColumn(4);
            String countryOfCorp = getColumn(5);
            String mainHomePage = getColumn(6);
            String taxAgent = getColumn(7);
            String gstRegNo = getColumn(8);
            String uniqueEntNo = getColumn(9);
            String partyContraGLAN = getColumn(10);
            String contraExchGLAN = getColumn(11);

            if (empty(partyCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Bank Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + partyCode);

            pageSteps.goToMenu(MenuID.GL_PARTY);
            pageSteps.clickButton("New");
            pageSteps.setText("Party Code", partyCode);
            pageSteps.verifyResult("Party Code: ", pageSteps.getTextValue("Party Code"), partyCode);

            pageSteps.setText("Party Name", partyName);
            pageSteps.verifyResult("Party Name: ", pageSteps.getTextValue("Party Name"), partyName);

            pageSteps.setText("Party Short Name", partyShortName);
            pageSteps.verifyResult("Party Short Name: ", pageSteps.getTextValue("Party Short Name"), partyShortName);

            pageSteps.setText("Party Group Code", partyGroupCode);
            pageSteps.verifyResult("Party Group Code: ", pageSteps.getTextValue("Party Group Code"), partyGroupCode);

            pageSteps.setText("Country Of Incorporation", countryOfCorp);
            pageSteps.verifyResult("Country Of Incorporation: ", pageSteps.getTextValue("Country Of Incorporation"), countryOfCorp);

            pageSteps.setText("Main Home Page", mainHomePage);
            pageSteps.verifyResult("Main Home Page: ", pageSteps.getTextValue("Main Home Page"), mainHomePage);

            pageSteps.setRadioOption("Tax Agent", taxAgent);
            pageSteps.verifyResult("Tax Agent: ", pageSteps.isRadioOptionChecked("Tax Agent", taxAgent));

            pageSteps.setText("GST Registration No", gstRegNo);
            pageSteps.verifyResult("GST Registration No: ", pageSteps.getTextValue("GST Registration No"), gstRegNo);

            pageSteps.setText("Unique Entity No", uniqueEntNo);
            pageSteps.verifyResult("Unique Entity No: ", pageSteps.getTextValue("Unique Entity No"), uniqueEntNo);

            pageSteps.setText("Party Contra GLAN", partyContraGLAN);
            pageSteps.verifyResult("Party Contra GLAN: ", pageSteps.getTextValue("Party Contra GLAN"), partyContraGLAN);

            pageSteps.setText("Contra Realized Exch GLAN", contraExchGLAN);
            pageSteps.verifyResult("Contra Realized Exch GLAN: ", pageSteps.getTextValue("Contra Realized Exch GLAN"), contraExchGLAN);

            // TAB - Address
            setUpAdress(partyCode);

            // TAB - Contact
            pageSteps.goToTab("Contact");
            setUpContact(partyCode);

            // TAB - Relation/Service Group
            pageSteps.goToTab("Relation/Service Group");
            setUpRelationService(partyCode);

            // TAB - Bank Detail
            pageSteps.goToTab("Bank Detail");
            setUpBankDetail(partyCode);

            // TAB - Local Info
            pageSteps.goToTab("Local Info");
            setUpLocalInfo(partyCode);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Bank Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + partyCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyFinalResult(report);
        }
    }

    @Given("^Party Group is created as in\\s+\"([^\"]*)\"$")
    public void createPartyGroup(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String groupCode = getColumn(1);
            String desc = getColumn(2);

            if (empty(groupCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Party Group Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + groupCode);

            pageSteps.goToMenu(MenuID.GL_PARTY_GROUP);
            pageSteps.clickButton("New");
            pageSteps.setText("Party Group Code", groupCode);
            pageSteps.verifyResult("Party Group Code: ", pageSteps.getTextValue("Party Group Code"), groupCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Party Group Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + groupCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Party Group Report");
    }

    @Step("Set up address")
    public void setUpAdress(String bankDetailNo)
    {
        setDetailData("Address");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String lra = getColumn_Detail(2);
                String addressCode = getColumn_Detail(3);
                String desc = getColumn_Detail(4);
                String address = getColumn_Detail(5);
                String countryCode = getColumn_Detail(6);
                String postalCode = getColumn_Detail(7);
                String includeSales = getColumn_Detail(8);
                String includePurchase = getColumn_Detail(9);
                String includeShipTo = getColumn_Detail(10);
                String includeCustomerBilling = getColumn_Detail(11);
                String includePaymentToSupplier = getColumn_Detail(12);
                String includeServiceCentre = getColumn_Detail(13);
                String includeBank = getColumn_Detail(14);

                if (notEmpty(countryCode))
                {
                    pageSteps.clickButton("Add", 1);
                    if (pageSteps.checkTextExist("Scheme Key", true))
                        pageSteps.selectFirstRow("Scheme Key");
                    pageSteps.setText("Address Code", addressCode);
                    pageSteps.setText("Description", desc);
                    pageSteps.setTextArea("Address", address);
                    pageSteps.setText("Country Code", countryCode);
                    pageSteps.setText("Postal Code", postalCode);

                    if (includeSales.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Sales", includeSales.substring(0, 1));
                    if (includePurchase.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Purchase", includePurchase.substring(0, 1));
                    if (includeShipTo.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Ship to", includeShipTo.substring(0, 1));
                    if (includeCustomerBilling.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Customer Billing", includeCustomerBilling.substring(0, 1));
                    if (includePaymentToSupplier.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Payment to Supplier", includePaymentToSupplier.substring(0, 1));
                    if (includeServiceCentre.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Service Centre", includeServiceCentre.substring(0, 1));
                    if (includeBank.startsWith("Y"))
                        pageSteps.setCheckboxByValue("Bank", includeBank.substring(0, 1));

                    pageSteps.waitForAjax(1);
                    if (includeSales.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Sales']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includePurchase.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Purchase']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeShipTo.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Ship to']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeCustomerBilling.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Customer Billing']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includePaymentToSupplier.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Payment to Supplier']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeServiceCentre.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Service Centre']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeBank.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Bank']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                }

                // Add contact type
                String contactType = getColumn_Detail(15);
                String contactInfo = getColumn_Detail(16);
                String contactDefault = getColumn_Detail(17);

                if (notEmpty(contactType))
                {
                    pageSteps.clickButton("Add", 2);
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Contact Type");
                    pageSteps.setDropDownOptionAtTableCell("Contact Type", rowNo, contactType);
                    pageSteps.verifyResult("Contact Type: ", pageSteps.getDropDownOptionAtTableCell("Contra Realized Exch GLAN", rowNo), contactType);

                    pageSteps.setTextAtTableCell("Contact Information", rowNo, contactInfo);
                    pageSteps.verifyResult("Contact Information: ", pageSteps.getDropDownOptionAtTableCell("Contact Information", rowNo),
                                           contactInfo);

                    pageSteps.setRadioOptionAtTableCell("Default", rowNo, contactDefault);
                    pageSteps.verifyResult("Default: ", pageSteps.isRadioOptionAtTableCellChecked("Default", rowNo, contactDefault));
                }
            }
        }
    }

    @Step("Set up contact")
    public void setUpContact(String bankDetailNo)
    {
        setDetailData("Contact");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String partyContactCode = getColumn_Detail(2);
                String salutation = getColumn_Detail(3);
                String firstName = getColumn_Detail(4);
                String middleName = getColumn_Detail(5);
                String lastName = getColumn_Detail(6);
                String name = getColumn_Detail(7);
                String addressCode = getColumn_Detail(8);
                String designation = getColumn_Detail(9);
                String designationGroup = getColumn_Detail(10);
                String department = getColumn_Detail(11);
                String includeSales = getColumn_Detail(12);
                String includePurchase = getColumn_Detail(13);
                String includeShipTo = getColumn_Detail(14);
                String includeCustomerBilling = getColumn_Detail(15);
                String includePaymentToSupplier = getColumn_Detail(16);
                String includeServiceCentre = getColumn_Detail(17);
                String includeBank = getColumn_Detail(18);

                if (notEmpty(partyContactCode))
                {
                    pageSteps.clickButton("Add", 1);
                    pageSteps.setText("Party Contact Code", partyContactCode);
                    pageSteps.setDropDownOption("Salutation", salutation);
                    pageSteps.setText("First Name", firstName);
                    pageSteps.setText("Middle Name", middleName);
                    pageSteps.setText("Last Name", lastName);
                    pageSteps.setText("Name", name);
                    pageSteps.setDropDownOption("Address Code", addressCode);
                    pageSteps.setText("Designation", designation);
                    pageSteps.setText("Designation Group", designationGroup);
                    pageSteps.setText("Department", department);

                    if (includeSales.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Sales", includeSales.substring(0, 1));
                        pageSteps.verifyResult("Sales: ", pageSteps.isCheckboxByValueChecked("Sales", includeSales.substring(0, 1)));
                    }
                    if (includePurchase.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Purchase", includePurchase.substring(0, 1));
                        pageSteps.verifyResult("Purchase: ", pageSteps.isCheckboxByValueChecked("Purchase", includePurchase.substring(0, 1)));
                    }
                    if (includeShipTo.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Ship to", includeShipTo.substring(0, 1));
                        pageSteps.verifyResult("Ship to: ", pageSteps.isCheckboxByValueChecked("Ship to", includeShipTo.substring(0, 1)));
                    }
                    if (includeCustomerBilling.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Customer Billing", includeCustomerBilling.substring(0, 1));
                        pageSteps.verifyResult("Customer Billing: ",
                                               pageSteps.isCheckboxByValueChecked("Customer Billing", includeCustomerBilling.substring(0, 1)));
                    }
                    if (includePaymentToSupplier.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Payment to Supplier", includePaymentToSupplier.substring(0, 1));
                        pageSteps.verifyResult("Payment to Supplier: ",
                                               pageSteps.isCheckboxByValueChecked("Payment to Supplier", includePaymentToSupplier.substring(0, 1)));
                    }
                    if (includeServiceCentre.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Service Centre", includeServiceCentre.substring(0, 1));
                        pageSteps.verifyResult("Service Centre: ",
                                               pageSteps.isCheckboxByValueChecked("Service Centre", includeServiceCentre.substring(0, 1)));
                    }
                    if (includeBank.startsWith("Y"))
                    {
                        pageSteps.setCheckboxByValue("Bank", includeBank.substring(0, 1));
                        pageSteps.verifyResult("Bank: ", pageSteps.isCheckboxByValueChecked("Bank", includeBank.substring(0, 1)));
                    }

                    pageSteps.waitForAjax(1);
                    if (includeSales.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Sales']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includePurchase.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Purchase']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeShipTo.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Ship to']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeCustomerBilling.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Customer Billing']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includePaymentToSupplier.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Payment to Supplier']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeServiceCentre.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Service Centre']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                    if (includeBank.equalsIgnoreCase("YY"))
                        pageSteps.setCheckboxAtXpathCSS("//*[text()='Bank']/following-sibling::td/" + ElementID.CHECKBOX,
                                                        true); // set Default checkbox
                }

                // Add contact type
                String contactType = getColumn_Detail(19);
                String contactInfo = getColumn_Detail(20);
                String contactDefault = getColumn_Detail(21);

                if (notEmpty(contactType))
                {
                    pageSteps.clickButton("Add", 2);
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Contact Type");
                    pageSteps.setDropDownOptionAtTableCell("Contact Type", rowNo, contactType);
                    pageSteps.verifyResult("Contact Type: ", pageSteps.getDropDownOptionAtTableCell("Contact Type", rowNo), contactType);

                    pageSteps.setTextAtTableCell("Contact Information", rowNo, contactInfo);
                    pageSteps.verifyResult("Contact Information: ", pageSteps.getTextAtTableCell("Contact Information", rowNo), contactInfo);

                    pageSteps.setRadioOptionAtTableCell("Default", rowNo, contactDefault);
                    pageSteps.verifyResult("Default: ", pageSteps.isRadioOptionAtTableCellChecked("Default", rowNo, contactDefault));
                }
            }
        }
    }

    @Step("Set up bank detail")
    public void setUpBankDetail(String bankDetailNo)
    {
        setDetailData("Bank Detail");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String bank = getColumn_Detail(2);
                String accNo = getColumn_Detail(3);
                String currency = getColumn_Detail(4);
                String bankDefault = getColumn_Detail(5);

                pageSteps.clickButton("Add");
                int rowNo = pageSteps.getRowsCount("Bank");
                pageSteps.setTextAtTableCell("Bank", rowNo, bank);
                pageSteps.verifyResult("Bank: ", pageSteps.getTextAtTableCell("Bank", rowNo), bank);

                pageSteps.setTextAtTableCell("Account No.", rowNo, accNo);
                pageSteps.verifyResult("Account No.: ", pageSteps.getTextAtTableCell("Account No.", rowNo), accNo);

                pageSteps.setTextAtTableCell("Currency", rowNo, currency);
                pageSteps.verifyResult("Currency: ", pageSteps.getTextAtTableCell("Currency", rowNo), currency);

                pageSteps.setRadioOptionAtTableCell("Default", rowNo, bankDefault);
                pageSteps.verifyResult("Default: ", pageSteps.isRadioOptionAtTableCellChecked("Default", rowNo, bankDefault));
            }
        }
    }

    @Step("Set up relation service")
    public void setUpRelationService(String bankDetailNo)
    {
        setDetailData("Relation Service");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String partyRelation = getColumn_Detail(2);
                String serviceType = getColumn_Detail(3);
                String allowed = getColumn_Detail(4);

                pageSteps.setTableFilter("Party Relation", partyRelation);
                pageSteps.setTableFilter("Service Type", serviceType);
                pageSteps.setRadioOptionAtTableCell("Allowed", 1, allowed);
            }
        }
    }

    @Step("Set up local info")
    public void setUpLocalInfo(String bankDetailNo)
    {
        setDetailData("Local Info");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String usageType = getColumn_Detail(2);
                String swiftCode = getColumn_Detail(3);
                String bankNo = getColumn_Detail(4);
                String chipsUID = getColumn_Detail(5);

                if (notEmpty(bankNo))
                {
                    pageSteps.setText("SWIFT Code", swiftCode);
                    pageSteps.setText("Bank Number", bankNo);
                    pageSteps.setText("CHIPS UID", chipsUID);
                }

                // set Branches
                pageSteps.goToTab("Branches");
                String branchCode = getColumn_Detail(6);
                String branchDesc = getColumn_Detail(7);

                if (notEmpty(branchCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Branch Description");
//                    pageSteps.setTextAtTableCell("Branch Code", rowNo, branchCode);
                    pageSteps.setTextAtXpathCSS("//tbody[@id='partyForm:branchTable:tb']/tr[" + rowNo + "]/td[1]", branchCode);
                    pageSteps.setTextAtTableCell("Branch Description", rowNo, branchDesc);
                }
            }
        }

        // set Own Bank Detail
        pageSteps.goToTab("Own Bank Detail");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(bankDetailNo))
            {
                String accNo = getColumn_Detail(8);
                String branchCode2 = getColumn_Detail(9);
                String currency = getColumn_Detail(10);
                String bankGLAN = getColumn_Detail(11);
                String lastChequeNo = getColumn_Detail(12);
                String combineBCinPayment = getColumn_Detail(13);
                String combineBCinReceipt = getColumn_Detail(14);

                if (notEmpty(accNo))
                {
                    pageSteps.clickButton("Add", 2);
                    int rowNo = pageSteps.getRowsCount("Account No.");
                    pageSteps.setTextAtTableCell("Account No.", rowNo, accNo);
//                    pageSteps.setTextAtTableCell("Branch Code", rowNo, branchCode2);
                    pageSteps.setTextAtXpathCSS("//tbody[@id='partyForm:intAcctTable:tb']/tr[" + rowNo + "]/td[2]/input", branchCode2);
                    pageSteps.setTextAtTableCell("Currency Code", rowNo, currency);
                    pageSteps.verifyResult("Currency Code: ", pageSteps.getTextAtTableCell("Currency Code", rowNo), currency);

                    pageSteps.setTextAtTableCell("Bank GLAN", rowNo, bankGLAN);
                    pageSteps.verifyResult("Bank GLAN: ", pageSteps.getTextAtTableCell("Bank GLAN", rowNo), bankGLAN);

                    pageSteps.setTextAtTableCell("Last Cheque No", rowNo, lastChequeNo);
                    pageSteps.verifyResult("Last Cheque No: ", pageSteps.getTextAtTableCell("Last Cheque No", rowNo), lastChequeNo);

                    pageSteps.setCheckBoxAtTableCell("Combine BC in Payment", rowNo, combineBCinPayment);
                    pageSteps.verifyResult("Combine BC in Payment: ",
                                           pageSteps.isCheckBoxAtTableCellChecked("Combine BC in Payment", rowNo, combineBCinPayment));

                    pageSteps.setCheckBoxAtTableCell("Combine BC in Receipt", rowNo, combineBCinReceipt);
                    pageSteps.verifyResult("Combine BC in Receipt: ",
                                           pageSteps.isCheckBoxAtTableCellChecked("Combine BC in Receipt", rowNo, combineBCinReceipt));
                }
            }
        }
    }
}
