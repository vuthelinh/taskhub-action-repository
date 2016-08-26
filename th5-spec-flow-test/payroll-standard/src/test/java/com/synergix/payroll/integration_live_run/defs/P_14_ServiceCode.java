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

public class P_14_ServiceCode extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Service Code is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String serviceCode = getColumn(1);
            String desc = getColumn(2);
            String serviceCate = getColumn(3);
            String reportGroup = getColumn(4);
            String uom = getColumn(5);
            String defaultSalesTax = getColumn(6);
            String trackQtyInPrj = getColumn(7);
            String intercompanySalesTax = getColumn(8);
            String budgetCatCode = getColumn(9);
            String revenue = getColumn(10);
            String expense = getColumn(11);
            String revenueStt = getColumn(12);
            String expenseStt = getColumn(13);
            String revenueGLAN = getColumn(14);
            String expenseGLAN = getColumn(15);
            String unearnedRevenueGLAN = getColumn(16);
            String accruedCostGLAN = getColumn(17);
            String salesAccrualGLAN = getColumn(18);
            String overheadGLAN = getColumn(19);
            String wageServiceType = getColumn(20);
            String subjectToSDL = getColumn(21);
            String subjectToCPF = getColumn(22);
            String cpfWageType = getColumn(23);
            String adhocPayment = getColumn(24);
            String claimType = getColumn(25);
            String defaultSalesTaxPayroll = getColumn(26);
            String defaultInclusiveTax = getColumn(27);
            String defaultCurrency = getColumn(28);
            String defaultUnitPrice = getColumn(29);
            String employIncomeType = getColumn(30);
            String doctorFee = getColumn(31);
            String labCodeRequired = getColumn(32);
            String bookingType = getColumn(33);
            String overheadCostType = getColumn(34);
            String defaultOverheadUnitHomeCost = getColumn(35);

            if (empty(serviceCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Service Code Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + serviceCode);

            pageSteps.goToMenu(MenuID.GL_SERVICE);
            pageSteps.clickButton("New");
            pageSteps.setText("Service Code", serviceCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Service Code", pageSteps.getTextValue("Service Code"), serviceCode);

            pageSteps.setText("Service Description", desc);
            pageSteps.verifyResult("Service Description", pageSteps.getTextValue("Service Description"), desc);

            pageSteps.setText("Service Category", serviceCate);
            pageSteps.verifyResult("Service Category", pageSteps.getTextValue("Service Description"), serviceCate);

            pageSteps.setText("Report Grouping", reportGroup);
            pageSteps.verifyResult("Report Grouping", pageSteps.getTextValue("Report Grouping"), reportGroup);

            pageSteps.setText("UOM", uom);
            pageSteps.verifyResult("UOM", pageSteps.getTextValue("UOM"), uom);

            pageSteps.setDropDownOption("Default Sales Tax", defaultSalesTax);
            pageSteps.verifyResult("Default Sales Tax", pageSteps.getDropDownOptionValue("Default Sales Tax"), defaultSalesTax);

            pageSteps.setRadioOption("Track Qty in Project", trackQtyInPrj);
            pageSteps.verifyResult("Track Qty in Project", pageSteps.isRadioOptionChecked("Track Qty in Project", trackQtyInPrj));

            pageSteps.setText("Intercompany Sales Tax", intercompanySalesTax);
            pageSteps.verifyResult("Intercompany Sales Tax", pageSteps.getTextValue("Intercompany Sales Tax"), intercompanySalesTax);

            pageSteps.setText("Budget Category Code", budgetCatCode);
            pageSteps.verifyResult("Budget Category Code", pageSteps.getTextValue("Budget Category Code"), budgetCatCode);

            pageSteps.setCheckboxByValue("Revenue (Deduction)", revenue);
            pageSteps.verifyResult("Revenue (Deduction)", pageSteps.isCheckboxChecked("Revenue (Deduction)", revenue));

            pageSteps.setCheckboxByValue("Expense (Additional Payment)", expense);
            pageSteps.verifyResult("Expense (Additional Payment)", pageSteps.isCheckboxChecked("Expense (Additional Payment)", expense));

            pageSteps.setRadioOption("Revenue Status", revenueStt);
            pageSteps.verifyResult("Revenue Status", pageSteps.isRadioOptionChecked("Revenue Status", revenueStt));

            pageSteps.setRadioOption("Expense Status", expenseStt);
            pageSteps.verifyResult("Expense Status", pageSteps.isRadioOptionChecked("Expense Status", expenseStt));

            pageSteps.setText("Revenue GLAN", revenueGLAN);
            pageSteps.verifyResult("Revenue GLAN", pageSteps.getTextValue("Revenue GLAN"), revenueGLAN);

            pageSteps.setText("Expense GLAN", expenseGLAN);
            pageSteps.verifyResult("Expense GLAN", pageSteps.getTextValue("Expense GLAN"), expenseGLAN);

            pageSteps.setText("Unearned Revenue GLAN", unearnedRevenueGLAN);
            pageSteps.verifyResult("Unearned Revenue GLAN", pageSteps.getTextValue("Unearned Revenue GLAN"), unearnedRevenueGLAN);

            pageSteps.setText("Accrued Cost GLAN", accruedCostGLAN);
            pageSteps.verifyResult("Accrued Cost GLAN", pageSteps.getTextValue("Accrued Cost GLAN"), accruedCostGLAN);

            pageSteps.setText("Sales Accrual GLAN", salesAccrualGLAN);
            pageSteps.verifyResult("Sales Accrual GLAN", pageSteps.getTextValue("Sales Accrual GLAN"), salesAccrualGLAN);

            pageSteps.setText("Overhead GLAN", overheadGLAN);
            pageSteps.verifyResult("Overhead GLAN", pageSteps.getTextValue("Overhead GLAN"), overheadGLAN);

            // TAB - Service Relation
            pageSteps.goToTab("Service Relation");
            setupServiceRelation(serviceCode);

            // TAB - Supplier
            pageSteps.goToTab("Supplier");
            setupSupplier(serviceCode);

            // TAB - Payroll
            pageSteps.goToTab("Payroll");
            pageSteps.setRadioOption("Wage Service Type", wageServiceType);
            pageSteps.verifyResult("Wage Service Type", pageSteps.isRadioOptionChecked("Wage Service Type", wageServiceType));

            pageSteps.setRadioOption("Subject To SDL", subjectToSDL);
            pageSteps.verifyResult("Subject To SDL", pageSteps.isRadioOptionChecked("Subject To SDL", subjectToSDL));

            pageSteps.setRadioOption("Subject to CPF and Donation", subjectToCPF);
            pageSteps.verifyResult("Subject to CPF and Donation", pageSteps.isRadioOptionChecked("Subject to CPF and Donation", subjectToCPF));

            pageSteps.setRadioOption("CPF Wage Type", cpfWageType);
            pageSteps.verifyResult("CPF Wage Type", pageSteps.isRadioOptionChecked("CPF Wage Type", cpfWageType));

            pageSteps.setCheckbox("Adhoc Payment", adhocPayment);
            pageSteps.verifyResult("Adhoc Payment", pageSteps.isCheckboxChecked("Adhoc Payment", adhocPayment));

            pageSteps.setDropDownOption("Claim Type", claimType);
            pageSteps.verifyResult("Claim Type", pageSteps.getDropDownOptionValue("Claim Type"), claimType);

            if (!employIncomeType.isEmpty())
            {// fix bug choose Employment Income Type make refresh other input
                pageSteps.setRadioOption(employIncomeType);
                pageSteps.verifyResult("Employment Income Type", pageSteps.isRadioOptionChecked(employIncomeType));
            }

            pageSteps.setDropDownOption("Default Sales Tax", defaultSalesTaxPayroll);
            pageSteps.verifyResult("Default Sales Tax", pageSteps.getDropDownOptionValue("Default Sales Tax"), defaultSalesTaxPayroll);

            pageSteps.setCheckboxByValue("Default Inclusive Tax", defaultInclusiveTax);
            pageSteps.verifyResult("Default Inclusive Tax", pageSteps.isCheckboxChecked("Default Inclusive Tax", defaultInclusiveTax));

            pageSteps.setDropDownOption("Default Currency", defaultCurrency);
            pageSteps.verifyResult("Default Currency", pageSteps.getDropDownOptionValue("Default Currency"), defaultCurrency);

            pageSteps.setText("Default Unit Price", defaultUnitPrice);
            pageSteps.verifyResult("Default Unit Price", pageSteps.getTextValue("Default Unit Price"), defaultUnitPrice);

            // TAB - Medical Specific
            pageSteps.goToTab("Medical Specific");
            pageSteps.setRadioOption("Doctor Fee", doctorFee);
            pageSteps.verifyResult("Doctor Fee", pageSteps.isRadioOptionChecked("Doctor Fee", doctorFee));

            pageSteps.setRadioOption("Laboratory Code Required", labCodeRequired);
            pageSteps.verifyResult("Laboratory Code Required", pageSteps.isRadioOptionChecked("Laboratory Code Required", labCodeRequired));

            pageSteps.setDropDownOption("Booking Type", bookingType);
            pageSteps.verifyResult("Booking Type", pageSteps.getDropDownOptionValue("Booking Type"), bookingType);

            // TAB - Manufacturing
            pageSteps.goToTab("Manufacturing");
            pageSteps.setRadioOption("Overhead Cost Type", overheadCostType);
            pageSteps.verifyResult("Overhead Cost Type", pageSteps.isRadioOptionChecked("Overhead Cost Type", overheadCostType));

            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");

            // TAB - Local Info
            pageSteps.goToTab("Local Info");
            pageSteps.setText("Default Overhead Unit Home Cost", defaultOverheadUnitHomeCost);
            pageSteps.verifyResult("Default Overhead Unit Home Cost", pageSteps.getTextValue("Default Overhead Unit Home Cost"),
                                   defaultOverheadUnitHomeCost);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Service Code Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + serviceCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Service Code Report");
    }

    @Step("Set up supplier")
    private void setupSupplier(String supplierDetailNo)
    {
        setDetailData("Supplier");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(supplierDetailNo))
            {
                String supplier = getColumn_Detail(2);
                String partyServiceCode = getColumn_Detail(3);
                String defaultDesc = getColumn_Detail(4);
                String billingDesc = getColumn_Detail(5);
                String remarks = getColumn_Detail(6);
                String isDefault = getColumn_Detail(7);

                if (notEmpty(supplier))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    int rowNo = pageSteps.getRowsCount("Supplier");
                    pageSteps.setTextAtTableCell("Supplier", rowNo, supplier);
                    pageSteps.verifyResult("Supplier", pageSteps.getTextAtTableCell("Supplier", rowNo), supplier);

                    pageSteps.setTextAtTableCell("Party Service Code", rowNo, partyServiceCode);
                    pageSteps.verifyResult("Party Service Code", pageSteps.getTextAtTableCell("Party Service Code", rowNo), partyServiceCode);

                    pageSteps.setTextAtTableCell("Default Description", rowNo, defaultDesc);
                    pageSteps.verifyResult("Default Description", pageSteps.getTextAtTableCell("Default Description", rowNo), defaultDesc);

                    pageSteps.setTextAtTableCell("Billing Description", rowNo, billingDesc);
                    pageSteps.verifyResult("Billing Description", pageSteps.getTextAtTableCell("Billing Description", rowNo), billingDesc);

                    pageSteps.setRemarkAtTableCell("Remarks", rowNo, remarks);
                    pageSteps.verifyResult("Remarks", pageSteps.getTextAtTableCell("Remarks", rowNo), remarks);

                    pageSteps.setRadioOptionAtTableCell("Default", rowNo, isDefault);
                    pageSteps.verifyResult("Default", pageSteps.getTextAtTableCell("Default", rowNo), isDefault);
                }
            }
        }
    }

    @Step("Set up service relation")
    private void setupServiceRelation(String serviceRelationDetailNo)
    {
        setDetailData("Service Relation");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(serviceRelationDetailNo))
            {
                String partyTypeGroup = getColumn_Detail(2);
                String partyType = getColumn_Detail(3);
                String revenue = getColumn_Detail(4);
                String expense = getColumn_Detail(5);

                if (notEmpty(partyTypeGroup))
                {
                    pageSteps.setTableFilter("Party Type Group", partyTypeGroup);
                    pageSteps.setTableFilter("Party Type", partyType);
                    pageSteps.setCheckBoxAtTableCell("Revenue", 1, revenue);
                    pageSteps.setCheckBoxAtTableCell("Expense", 1, expense);

                    pageSteps.verifyResult("Revenue", pageSteps.isCheckBoxAtTableCellChecked("Revenue", 1, revenue));
                    pageSteps.verifyResult("Expense", pageSteps.isCheckBoxAtTableCellChecked("Expense", 1, expense));
                }
            }
        }
    }
}
