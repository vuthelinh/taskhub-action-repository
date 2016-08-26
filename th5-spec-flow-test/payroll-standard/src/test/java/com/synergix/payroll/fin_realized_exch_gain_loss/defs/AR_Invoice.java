package com.synergix.payroll.fin_realized_exch_gain_loss.defs;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.apache.poi.hssf.util.HSSFColor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AR_Invoice extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Given("^user create new AR Invoice$")
    public void createAR_Invoice(List<List<String>> dataTable)
    {
        SessionData.addDataTable("ARInvoice", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ARInvoice").keySet())
        {
            String invNo = SessionData.getDataTbVal("ARInvoice", row, "Invoice No");
            String customer = SessionData.getDataTbVal("ARInvoice", row, "Customer");
            String invDate = SessionData.getDataTbVal("ARInvoice", row, "Invoice Date");
            String currency = SessionData.getDataTbVal("ARInvoice", row, "Currency");
            String defSalesTax = SessionData.getDataTbVal("ARInvoice", row, "Default Sales Tax");
            String exchRate = SessionData.getDataTbVal("ARInvoice", row, "Exchange Rate");
            String type = SessionData.getDataTbVal("ARInvoice", row, "Type");
            String itemCode = SessionData.getDataTbVal("ARInvoice", row, "Item Code");
            String qtyUOM = SessionData.getDataTbVal("ARInvoice", row, "Qty UOM");
            String unitPrice = SessionData.getDataTbVal("ARInvoice", row, "Unit Price");
            String salesTax = SessionData.getDataTbVal("ARInvoice", row, "Sales Tax");
            String doSubmit = SessionData.getDataTbVal("ARInvoice", row, "Submit");

            if (empty(invNo) && empty(type))
                continue;

            if (notEmpty(invNo))
            {
                pageSteps.goToMenu(MenuID.PROC_AR_INVOICE);
                pageSteps.clickButton("New");
                //setSessionVariable(invNo, pageSteps.getTextDesc("Invoice No."));
                voucherList.put(invNo, pageSteps.getTextDesc("Invoice No."));
                pageSteps.setText("Customer", customer);
                pageSteps.setText("Invoice Date", invDate);
                pageSteps.setText("Currency", currency);
                pageSteps.setText("Default Sales Tax", defSalesTax);
            }
            if (notEmpty(type))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Type");
                pageSteps.setDropDownOptionAtTableCell("Type", rowNo, type);
                pageSteps.setTextAtTableCell("Item Code/Remarks Description", rowNo, itemCode);
                pageSteps.setTextAtTableCell("Qty UOM", rowNo, qtyUOM);
                pageSteps.setTextAtTableCell("Unit Price", rowNo, unitPrice);
                pageSteps.setTextAtTableCell("Sales Tax", rowNo, salesTax);
            }
            pageSteps.setText("Exchange Rate", exchRate);
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user create new AP Invoice$")
    public void createAP_Invoice(List<List<String>> dataTable)
    {
        SessionData.addDataTable("APInvoice", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("APInvoice").keySet())
        {
            String invNo = SessionData.getDataTbVal("APInvoice", row, "Invoice No");
            String supplier = SessionData.getDataTbVal("APInvoice", row, "Supplier");
            String postDate = SessionData.getDataTbVal("APInvoice", row, "Posting Date");
            String currency = SessionData.getDataTbVal("APInvoice", row, "Currency");
            String defSalesTax = SessionData.getDataTbVal("APInvoice", row, "Default Sales Tax");
            String exchRate = SessionData.getDataTbVal("APInvoice", row, "Exchange Rate");
            String type = SessionData.getDataTbVal("APInvoice", row, "Type");
            String itemCode = SessionData.getDataTbVal("APInvoice", row, "Item Code");
            String qtyUOM = SessionData.getDataTbVal("APInvoice", row, "Qty UOM");
            String unitPrice = SessionData.getDataTbVal("APInvoice", row, "Unit Price");
            String salesTax = SessionData.getDataTbVal("APInvoice", row, "Sales Tax");
            String doSubmit = SessionData.getDataTbVal("APInvoice", row, "Submit");

            if (empty(invNo) && empty(type))
                continue;

            if (notEmpty(invNo))
            {
                pageSteps.goToMenu(MenuID.PROC_AP_INVOICE);
                pageSteps.clickButton("New");
                //setSessionVariable(invNo, pageSteps.getTextDesc("Invoice No."));
                voucherList.put(invNo, pageSteps.getTextDesc("Voucher No."));
                pageSteps.setText("Supplier", supplier);
                pageSteps.setText("Posting Date", postDate);
                pageSteps.setText("Supplier Invoice No.", pageSteps.getTextDesc("Voucher No.")); // prevent bug filter blank in AP Payment
                pageSteps.setText("Currency", currency);
                pageSteps.setText("Sales Tax", defSalesTax);
            }
            if (notEmpty(type))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Type");
                pageSteps.setDropDownOptionAtTableCell("Type", rowNo, type);
                pageSteps.setTextAtTableCell("Item Code/Remarks Description", rowNo, itemCode);
                pageSteps.setTextAtTableCell("Qty UOM", rowNo, qtyUOM);
                pageSteps.setTextAtTableCell("Cost Type", rowNo, unitPrice);
                pageSteps.setTextAtTableCell("Sales Tax", rowNo, salesTax);
            }
            //pageSteps.setText("Exchange Rate", exchRate);
            pageSteps.setTextAtXpathCSS("//input[@id='lineItemsForm:lineItemsTable:exchRate']", exchRate);
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user create new AP Payment")
    public void createAP_Payment(List<List<String>> dataTable)
    {
        SessionData.addDataTable("APPayment", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("APPayment").keySet())
        {
            String vchNo = SessionData.getDataTbVal("APPayment", row, "Voucher No");
            String supplier = SessionData.getDataTbVal("APPayment", row, "Supplier");
            String payDate = SessionData.getDataTbVal("APPayment", row, "Payment Voucher Date");
            String bank = SessionData.getDataTbVal("APPayment", row, "Bank");
            String currency = SessionData.getDataTbVal("APPayment", row, "Currency");
            String chequeAmt = SessionData.getDataTbVal("APPayment", row, "Cheque Amt");
            String exchRate = SessionData.getDataTbVal("APPayment", row, "Exchange Rate");
            String doSubmit = SessionData.getDataTbVal("APPayment", row, "Submit");

            if (empty(vchNo))
                continue;

            pageSteps.goToMenu(MenuID.PROC_AP_PAYMENT);
            pageSteps.goToTab("Draft");
            pageSteps.clickButton("New");
            //setSessionVariable(invNo, pageSteps.getTextDesc("Invoice No."));
            voucherList.put(vchNo, pageSteps.getTextDesc("Payment Voucher Number"));
            pageSteps.setText("Supplier", supplier);
            pageSteps.setText("Payment Voucher Date", payDate);
            pageSteps.clickSearchButton("Bank Account No");
            pageSteps.setText("Currency Code", currency);
            pageSteps.selectRow("Bank Party Code", bank);
            pageSteps.setText("Exchange Rate", exchRate);
            pageSteps.setText("Cheque Amount", chequeAmt);
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user create new AR Receipt$")
    public void createAR_Receipt(List<List<String>> dataTable)
    {
        SessionData.addDataTable("ARReceipt", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ARReceipt").keySet())
        {
            String recNo = SessionData.getDataTbVal("ARReceipt", row, "Receipt No");
            String customer = SessionData.getDataTbVal("ARReceipt", row, "Customer");
            String recDate = SessionData.getDataTbVal("ARReceipt", row, "Receipt Date");
            String currency = SessionData.getDataTbVal("ARReceipt", row, "Currency");
            String exchRate = SessionData.getDataTbVal("ARReceipt", row, "Exchange Rate");
            String bankName = SessionData.getDataTbVal("ARReceipt", row, "Bank Name");
            String pymtMethod = SessionData.getDataTbVal("ARReceipt", row, "Pymt Method");
            String pymtAmt = SessionData.getDataTbVal("ARReceipt", row, "Pymt Amt");
            String doSubmit = SessionData.getDataTbVal("ARReceipt", row, "Submit");

            if (empty(recNo))
                continue;

            pageSteps.goToMenu(MenuID.PROC_AR_RECEIPT);
            pageSteps.goToTab("Draft");
            pageSteps.clickButton("New");
            //setSessionVariable(recNo, pageSteps.getTextDesc("Receipt No"));
            voucherList.put(recNo, pageSteps.getTextDesc("Receipt No"));
            pageSteps.setText("Customer", customer);
            pageSteps.setText("Receipt Date", recDate);
            pageSteps.setText("Receipt Currency", currency);
            pageSteps.setText("Exchange Rate", exchRate);

            pageSteps.clickSearchAtTableCell("Payment Detail", "Bank Name", 1);
            pageSteps.setText("Currency Code", currency);
            pageSteps.selectRow("Bank Party Code", bankName);
            pageSteps.setDropDownOptionAtTableCell("Pymt Method", 1, pymtMethod);
            pageSteps.setTextAtTableCell("Pymt Amt", 1, pymtAmt);
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user create new AR Credit Note$")
    public void createAR_CreditNote(List<List<String>> dataTable)
    {
        SessionData.addDataTable("ARCredit", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ARCredit").keySet())
        {
            String crnNo = SessionData.getDataTbVal("ARCredit", row, "Credit No");
            String customer = SessionData.getDataTbVal("ARCredit", row, "Customer");
            String crnDate = SessionData.getDataTbVal("ARCredit", row, "Credit Note Date");
            String currency = SessionData.getDataTbVal("ARCredit", row, "Currency");
            String exchRate = SessionData.getDataTbVal("ARCredit", row, "Exchange Rate");
            String defSalesTax = SessionData.getDataTbVal("ARCredit", row, "Default Sales Tax");
            String payOption = SessionData.getDataTbVal("ARCredit", row, "Payment Option");
            String type = SessionData.getDataTbVal("ARCredit", row, "Type");
            String itemCode = SessionData.getDataTbVal("ARCredit", row, "Item Code");
            String qtyUOM = SessionData.getDataTbVal("ARCredit", row, "Qty UOM");
            String unitPrice = SessionData.getDataTbVal("ARCredit", row, "Unit Price");
            String salesTax = SessionData.getDataTbVal("ARCredit", row, "Sales Tax");
            String doSubmit = SessionData.getDataTbVal("ARCredit", row, "Submit");

            if (empty(crnNo) && empty(type))
                continue;

            if (notEmpty(crnNo))
            {
                pageSteps.goToMenu(MenuID.PROC_AR_CREDITNOTE);
                pageSteps.clickButton("New");
                //setSessionVariable(invNo, pageSteps.getTextDesc("Invoice No."));
                voucherList.put(crnNo, pageSteps.getTextDesc("Crn No."));
                pageSteps.setText("Customer", customer);
                pageSteps.setText("Credit Note Date", crnDate);
                pageSteps.setText("Currency", currency);
                pageSteps.setText("Default Sales Tax", defSalesTax);
                pageSteps.setDropDownOption("Payment Option", payOption);
            }
            if (notEmpty(type))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Type");
                pageSteps.setDropDownOptionAtTableCell("Type", rowNo, type);
                pageSteps.setTextAtTableCell("Item Code/Remarks Description", rowNo, itemCode);
                pageSteps.setTextAtTableCell("Qty UOM", rowNo, qtyUOM);
                pageSteps.setTextAtTableCell("Price Type", rowNo, unitPrice);
                pageSteps.setTextAtTableCell("Sales Tax", rowNo, salesTax);
            }
            pageSteps.setText("Exchange Rate", exchRate);
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user create new AP Credit Note$")
    public void createAP_CreditNote(List<List<String>> dataTable)
    {
        SessionData.addDataTable("APCredit", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("APCredit").keySet())
        {
            String pcnNo = SessionData.getDataTbVal("APCredit", row, "Credit No");
            String supplier = SessionData.getDataTbVal("APCredit", row, "Supplier");
            String currency = SessionData.getDataTbVal("APCredit", row, "Currency");
            String postDate = SessionData.getDataTbVal("APCredit", row, "Posting Date");
            String exchRate = SessionData.getDataTbVal("APCredit", row, "Exchange Rate");
            String defSalesTax = SessionData.getDataTbVal("APCredit", row, "Default Sales Tax");
            String type = SessionData.getDataTbVal("APCredit", row, "Type");
            String itemCode = SessionData.getDataTbVal("APCredit", row, "Item Code");
            String qtyUOM = SessionData.getDataTbVal("APCredit", row, "Qty UOM");
            String unitPrice = SessionData.getDataTbVal("APCredit", row, "Unit Price");
            String salesTax = SessionData.getDataTbVal("APCredit", row, "Sales Tax");
            String doSubmit = SessionData.getDataTbVal("APCredit", row, "Submit");

            if (empty(pcnNo) && empty(type))
                continue;

            if (notEmpty(pcnNo))
            {
                pageSteps.goToMenu(MenuID.PROC_AP_CREDITNOTE);
                pageSteps.goToTab("Draft");
                pageSteps.clickButton("New");
                //setSessionVariable(invNo, pageSteps.getTextDesc("Invoice No."));
                String crnNo = pageSteps.getTextDesc("Crn No.");
                voucherList.put(pcnNo, crnNo);
                pageSteps.setText("Supplier", supplier);
                pageSteps.setText("Currency", currency);
                pageSteps.setText("Posting Date", postDate);
                pageSteps.setText("Supplier Credit Note No", crnNo); // to search in AP Payment
                pageSteps.setText("Sales Tax", defSalesTax);
            }
            if (notEmpty(type))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Type");
                pageSteps.setDropDownOptionAtTableCell("Type", rowNo, type);
                pageSteps.setTextAtTableCell("Item Code/Remarks Description", rowNo, itemCode);
                pageSteps.setTextAtTableCell("Qty UOM", rowNo, qtyUOM);
                pageSteps.setTextAtTableCell("Unit Cost", rowNo, unitPrice);
                pageSteps.setTextAtTableCell("Sales Tax", rowNo, salesTax);
            }
            pageSteps.setText("Exchange Rate", exchRate);
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    String applyFrom = "";

    @Given("^user do application$")
    public void applyReceiptToInvoice(List<List<String>> dataTable)
    {
        SessionData.addDataTable("ReceiptApply", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ReceiptApply").keySet())
        {
            String appDate = SessionData.getDataTbVal("ReceiptApply", row, "Application Date");
            String applyFrom_Temp = SessionData.getDataTbVal("ReceiptApply", row, "Application From");
            String applyTo = SessionData.getDataTbVal("ReceiptApply", row, "Application To");
            String recAmt = SessionData.getDataTbVal("ReceiptApply", row, "Rec Amt");
            String recHomeAmt = SessionData.getDataTbVal("ReceiptApply", row, "Rec Home Amt");
            String invAmt = SessionData.getDataTbVal("ReceiptApply", row, "Inv Amt");
            String invHomeAmt = SessionData.getDataTbVal("ReceiptApply", row, "Inv Home Amt");
            String crossRate = SessionData.getDataTbVal("ReceiptApply", row, "Cross Rate");
            String realizedExch = SessionData.getDataTbVal("ReceiptApply", row, "Realized Exch");
            String amtToPayCcy = SessionData.getDataTbVal("ReceiptApply", row, "Amt to Pay in Inv Ccy");
            String doSubmit = SessionData.getDataTbVal("ReceiptApply", row, "Submit");

            if (empty(applyFrom_Temp) && empty(recAmt))
                continue;

            if (notEmpty(applyFrom_Temp))
                applyFrom = applyFrom_Temp;

            // case apply from invoce to receipt
            if (applyFrom.toLowerCase().contains("inv"))
            {
                String invNo = getVoucher(applyFrom);
                String recNo = getVoucher(applyTo);
                pageSteps.goToTab("Outstanding");
                pageSteps.setTableFilter("Inv No.", invNo);
                if (pageSteps.getRowsCount("Inv No.") < 1)
                {
                    pageSteps.goToTab("Draft");
                    pageSteps.setTableFilter("Inv No.", invNo);
                }
                pageSteps.selectFirstRow("Inv No.");
                pageSteps.goToTab("Receipt");
                int rowNo = pageSteps.getRowNumber("Receipt Voucher No.", recNo);
                pageSteps.setTextAtTableCell("Cross Rate", rowNo, crossRate); // to handle amount more than needed
                pageSteps.setTextAtTableCell("Apl'd Rec Amt", rowNo, recAmt);
                pageSteps.setTextAtTableCell("Apl'd Inv Amt", rowNo, invAmt);
                //pageSteps.setTextAtTableCell("Realized Exch", rowNo, realizedExch);
            }
            // case apply from receipt to invoice
            else if (applyFrom.toLowerCase().contains("rec"))
            {
                // get corresponding receipt no and invoice no from map
                String recNo = getVoucher(applyFrom);
                String invNo = getVoucher(applyTo);
                if (notEmpty(applyFrom_Temp))
                {
                    pageSteps.goToTab("Outstanding");
                    pageSteps.setTableFilter("Receipt No", recNo);
                    if (pageSteps.getRowsCount("Receipt No") < 1)
                    {
                        pageSteps.goToTab("Draft");
                        pageSteps.setTableFilter("Receipt No", recNo);
                    }
                    pageSteps.selectFirstRow("Receipt No");
                    if (empty(appDate))
                        appDate = pageSteps.getTextDesc("Receipt Date");
                    pageSteps.setText("Application Date", appDate);
                    pageSteps.goToTab("Application");
                }
                if (notEmpty(recAmt))
                {
                    pageSteps.setTableFilter("Inv No.", invNo);
                    pageSteps.setTextAtTableCell("Cross Rate", 1, crossRate); // to handle amount more than needed
                    pageSteps.setTextAtTableCell("Apl'd Rec Amt", 1, recAmt);
                    pageSteps.setTextAtTableCell("Apl'd Inv Amt", 1, invAmt);
                }
            }
            // case apply from ar credit note to invoice
            else if (applyFrom.toLowerCase().contains("crn"))
            {
                // get corresponding receipt no and invoice no from map
                String crnNo = getVoucher(applyFrom);
                String invNo = getVoucher(applyTo);
                if (notEmpty(applyFrom_Temp))
                {
                    pageSteps.goToTab("Outstanding");
                    pageSteps.setTableFilter("Crn No.", crnNo);
                    if (pageSteps.getRowsCount("Crn No.") < 1)
                    {
                        pageSteps.goToTab("Draft");
                        pageSteps.setTableFilter("Crn No.", crnNo);
                    }
                    pageSteps.selectFirstRow("Crn No.");
                    if (empty(appDate))
                        appDate = pageSteps.getTextDesc("Credit Note Date");
                    pageSteps.setText("Application Date", appDate);
                    pageSteps.goToTab("Application");
                }
                if (notEmpty(recAmt))
                {
                    pageSteps.setTableFilter("Inv No.", invNo);
                    pageSteps.setTextAtTableCell("Cross Rate", 1, crossRate); // to handle amount more than needed
                    pageSteps.setTextAtTableCell("Apl'd Crn Amt", 1, recAmt);
                    pageSteps.setTextAtTableCell("Apl'd Inv Amt", 1, invAmt);
                }
            }
            // case apply from ap credit note to invoice
            else if (applyFrom.toLowerCase().contains("pcn"))
            {
                String pcnNo = getVoucher(applyFrom);
                String recNo = getVoucher(applyTo);
                if (notEmpty(applyFrom_Temp))
                {
                    pageSteps.goToTab("Outstanding");
                    pageSteps.setTableFilter("Crn No.", pcnNo);
                    if (pageSteps.getRowsCount("Crn No.") < 1)
                    {
                        pageSteps.goToTab("Draft");
                        pageSteps.setTableFilter("Crn No.", pcnNo);
                    }
                    pageSteps.selectFirstRow("Crn No.");
                    if (empty(appDate))
                        appDate = pageSteps.getTextDesc("Credit Note Date");
                    pageSteps.setText("Application Date", appDate);
                    pageSteps.goToTab("Application");
                }
                if (notEmpty(recAmt))
                {
                    pageSteps.setTableFilter("Inv No.", recNo);
                    pageSteps.setTextAtTableCell("Cross Rate", 1, crossRate); // to handle amount more than needed
                    pageSteps.setTextAtTableCell("Apl'd Crn Amt", 1, recAmt);
                    pageSteps.setTextAtTableCell("Apl'd Inv Amt", 1, invAmt);
                }
            }
            else if (applyFrom.toLowerCase().contains("pay")) // ap payment
            {
                String payNo = getVoucher(applyFrom);
                String pinNo = getVoucher(applyTo);
                if (notEmpty(applyFrom_Temp))
                {
                    pageSteps.goToTab("Outstanding");
                    pageSteps.setTableFilter("Pymt Vch No", payNo);
                    if (pageSteps.getRowsCount("Pymt Vch No") < 1)
                    {
                        pageSteps.goToTab("Draft");
                        pageSteps.setTableFilter("Pymt Vch No", payNo);
                    }
                    pageSteps.selectFirstRow("Pymt Vch No");
                    if (empty(appDate))
                        appDate = pageSteps.getTextDesc("Payment Voucher Date");
                    pageSteps.setText("Application Date", appDate);
                    pageSteps.goToTab("Application");
                }

                if (notEmpty(recAmt) || notEmpty(amtToPayCcy))
                {
                    if (applyTo.toLowerCase().contains("pin"))
                    {
                        pageSteps.goToTab("Invoice");
                        pageSteps.setTableFilter("Inv No.", pinNo); // todo: bug filter blank, must search by Supplier Invoice No. in AP Invoice
                        pageSteps.setTextAtTableCell("Cross Rate", 1, crossRate); // to handle amount more than needed
                        pageSteps.setTextAtTableCell("Amt to Pay in Inv Ccy", 1, amtToPayCcy);
                        pageSteps.setTextAtTableCell("Apl'd Chq Amt", 1, recAmt);
                        pageSteps.setTextAtTableCell("Apl'd Inv Amt", 1, invAmt);
//                    rowNo = pageSteps.getRowNumber("Apl'd Chq Amt", pinNo); // todo: wrong row number
//                    pageSteps.setTextAtTableCell("Apl'd Chq Amt", rowNo, recAmt);
//                    pageSteps.setTextAtTableCell("Apl'd Inv Amt", rowNo, invAmt);
                    }
                    else if (applyTo.toLowerCase().contains("pcn"))
                    {
                        pageSteps.goToTab("Credit Note");
                        pageSteps.setTableFilter("Crn No.", pinNo);
                        pageSteps.setTextAtTableCell("Apl'd Crn Amt", 1, recAmt);
                    }
                }
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user create new Payment to Customer$")
    public void createPaymentToCustomer(List<List<String>> dataTable)
    {
        SessionData.addDataTable("Refund", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("Refund").keySet())
        {
            String voucherNo = SessionData.getDataTbVal("Refund", row, "Voucher No");
            String applyFrom = SessionData.getDataTbVal("Refund", row, "Application From");
            String applyTo = SessionData.getDataTbVal("Refund", row, "Application To");
            String vchDate = SessionData.getDataTbVal("Refund", row, "Payment Voucher Date");
            String customer = SessionData.getDataTbVal("Refund", row, "Customer");
            String bank = SessionData.getDataTbVal("Refund", row, "Bank");
            String currency = SessionData.getDataTbVal("Refund", row, "Currency");
            String chequeAmt = SessionData.getDataTbVal("Refund", row, "Cheque Amt");
            String payAmt = SessionData.getDataTbVal("Refund", row, "Payment Amt");
            String payHomeAmt = SessionData.getDataTbVal("Refund", row, "Payment Home Amt");
            String exchRate = SessionData.getDataTbVal("Refund", row, "Exchange Rate");
            String recAmt = SessionData.getDataTbVal("Refund", row, "Rec Amt");
            String recHomeAmt = SessionData.getDataTbVal("Refund", row, "Rec Home Amt");
            String crnAmt = SessionData.getDataTbVal("Refund", row, "Crn Amt");
            String crnHomeAmt = SessionData.getDataTbVal("Refund", row, "Crn Home Amt");
            String realizedExch = SessionData.getDataTbVal("Refund", row, "Realized Exch");
            String doSubmit = SessionData.getDataTbVal("Refund", row, "Submit");

            if (empty(applyFrom) && empty(payAmt))
                continue;

            // get corresponding receipt no and invoice no from map
            String recNo = "";
            String crnNo = "";
            if (applyTo.toLowerCase().contains("rec"))
                recNo = getVoucher(applyTo);
            if (applyTo.toLowerCase().contains("crn"))
                crnNo = getVoucher(applyTo);

            if (notEmpty(applyFrom) || notEmpty(voucherNo))
            {
                pageSteps.goToMenu(MenuID.PROC_AP_PAYMENT_TO_CUSTOMER);
                pageSteps.clickButton("New");
                if (notEmpty(voucherNo))
                    applyFrom = voucherNo;
                voucherList.put(applyFrom, pageSteps.getTextDesc("Payment Voucher Number"));
                pageSteps.setText("Customer", customer);
                pageSteps.setText("Payment Voucher Date", vchDate);
                pageSteps.clickSearchButton("Bank Account No");
                pageSteps.setText("Currency Code", currency);
                pageSteps.selectRow("Bank Party Code", bank);
                pageSteps.setText("Exchange Rate", exchRate);
                if (empty(chequeAmt))
                    chequeAmt = payAmt;
                pageSteps.setText("Cheque Amount", chequeAmt);
                pageSteps.goToTab("Application");
            }
            if (applyTo.toLowerCase().contains("rec"))
                if (notEmpty(recAmt))
                {
                    pageSteps.setTableFilter("Rcpt No", recNo);
                    pageSteps.setTextAtTableCell("Apl'd Pymt Amt", 1, payAmt);
                    pageSteps.setTextAtTableCell("Apl'd Rec Amt", 1, recAmt);
                }
            if (applyTo.toLowerCase().contains("crn"))
                if (notEmpty(recAmt) || notEmpty(crnAmt))
                {
                    if (empty(crnAmt))
                        crnAmt = recAmt;
                    pageSteps.goToTab("Application to Credit Notes");
                    pageSteps.setTableFilter("Crn No", crnNo);
                    pageSteps.setTextAtTableCell("Applied Chq Amt", 1, payAmt);
                    pageSteps.setTextAtTableCell("Applied Crn Amt", 1, crnAmt);
                }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user do contra$")
    public void createContra(List<List<String>> dataTable)
    {
        SessionData.addDataTable("Contra", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("Contra").keySet())
        {
            String voucherNo = SessionData.getDataTbVal("Contra", row, "Voucher No");
            String party = SessionData.getDataTbVal("Contra", row, "Party");
            String voucherDate = SessionData.getDataTbVal("Contra", row, "Voucher Date");
            String currency = SessionData.getDataTbVal("Contra", row, "Currency");
            String buyRate = SessionData.getDataTbVal("Contra", row, "Buy Rate");
            String sellRate = SessionData.getDataTbVal("Contra", row, "Sell Rate");
            String invNo = SessionData.getDataTbVal("Contra", row, "Invoice No");
            String invAmt = SessionData.getDataTbVal("Contra", row, "Inv Amt");
            String doSubmit = SessionData.getDataTbVal("Contra", row, "Submit");

            if (empty(voucherNo) && empty(invNo))
                continue;

            if (notEmpty(voucherNo) && notEmpty(invNo))
            {
                pageSteps.goToMenu(MenuID.PROC_AP_CONTRA);
                pageSteps.clickButton("New");
                voucherList.put(voucherNo, pageSteps.getTextDesc("Contra Voucher No."));
                pageSteps.setText("Party", party);
                pageSteps.setText("Contra Voucher Date", voucherDate);
                pageSteps.setText("Currency", currency);
                pageSteps.setText("Exch Rate - Buy Rate", buyRate);
                pageSteps.setText("Exch Rate - Sell Rate", sellRate);
            }
            if (notEmpty(invNo))
            {
                // apply ar invoice
                if (invNo.toLowerCase().contains("inv"))
                {
                    String invoice = getVoucher(invNo);
                    pageSteps.goToTab("AR Invoices");
                    pageSteps.setTableFilter("Invoice No.", invoice);
//                    pageSteps.setTextAtTableCell("Apl'd Inv Amt", 1, invAmt); //todo: upgrade xpath
                    pageSteps.setTextAtXpathCSS("//tbody[@id='arInvForm:AR_INVOICE_TABLE:tb']/tr[1]/td[7]//input", invAmt);
                }
                // apply ap invoice
                if (invNo.toLowerCase().contains("pin"))
                {
                    String invoice = getVoucher(invNo);
                    pageSteps.goToTab("AP Invoices");
                    pageSteps.setTableFilter("Inv No.", invoice);
//                    pageSteps.setTextAtTableCell("Apl'd Inv Amt", 1, invAmt); //todo: upgrade xpath
                    pageSteps.setTextAtXpathCSS("//tbody[@id='apInvForm:AP_INVOICE_TABLE:tb']/tr[1]/td[7]/input", invAmt);
                }
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user cancel AR Receipt$")
    public void cancelAR_Receipt(List<List<String>> dataTable)
    {
        SessionData.addDataTable("CancelAR", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("CancelAR").keySet())
        {
            String rccNo = SessionData.getDataTbVal("CancelAR", row, "Receipt Cancellation No");
            String recToCancel = SessionData.getDataTbVal("CancelAR", row, "Receipt No");
            String cancelDate = SessionData.getDataTbVal("CancelAR", row, "Receipt Cancellation Date");
            String customer = SessionData.getDataTbVal("CancelAR", row, "Customer");
            String cancelType = SessionData.getDataTbVal("CancelAR", row, "Cancellation Type");
            String invToCancel = SessionData.getDataTbVal("CancelAR", row, "Application Invoice No");
            String newCustomer = SessionData.getDataTbVal("CancelAR", row, "New Customer");
            String doSubbmit = SessionData.getDataTbVal("CancelAR", row, "Submit");

            if (empty(recToCancel) && empty(invToCancel))
                continue;

            // get corresponding receipt no and invoice no from map
            String recNo = getVoucher(recToCancel);

            if (notEmpty(recToCancel))
            {
                pageSteps.goToMenu(MenuID.PROC_AR_RECEIPT_CANCELLATION);
                pageSteps.clickButton("New");
                voucherList.put(rccNo, pageSteps.getTextDesc("Receipt Cancellation No"));
                pageSteps.setText("Receipt Cancellation Date", cancelDate);
                pageSteps.setText("Customer", customer);
                pageSteps.setText("Receipt No", recNo);
                pageSteps.setRadioOption("Cancellation Type", cancelType);
                if (cancelType.equalsIgnoreCase("Wrong Customer"))
                    pageSteps.setText("New Customer", newCustomer);
            }
            if (notEmpty(invToCancel))
            {
                String invNo = getVoucher(invToCancel);
                int rowNo = pageSteps.getRowNumber("Inv No.", invNo);
                pageSteps.setCheckBoxAtTableCell("Select", rowNo, "Y");
            }
            if (doSubbmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user do AP revaluation$")
    public void doAPRevaluation(List<List<String>> dataTable)
    {
        executeUpdate("UPDATE AP_SYSTEM_SETUP SET CURRENT_PERIOD = '6' WHERE CURRENT_YEAR = '2016'");

        SessionData.addDataTable("doReval", dataTable, false);
        // do a reset revaluation to prevent beforehand
        pageSteps.goToMenu(MenuID.PROC_AP_REVALUATION);
        for (int row : SessionData.getDataTbRowsNoHeader("doReval").keySet())
        {
            String vchDate = SessionData.getDataTbVal("doReval", row, "Revaluation Voucher Date");
            String currency = SessionData.getDataTbVal("doReval", row, "Currency");
            String exchRate = "1";

            if (empty(currency))
                continue;

            if (notEmpty(vchDate))
            {
                pageSteps.clickButton("New");
                pageSteps.confirm("OK");
                pageSteps.setText("Revaluation Voucher Date", vchDate);
                pageSteps.setCheckBoxTableFilter("Del", "Y");
                pageSteps.clickButton("Delete");
                pageSteps.confirm("Yes");
            }
            if (notEmpty(currency))
            {
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Add");
                int rowNo = pageSteps.getRowsCount("Currency");
                pageSteps.setTextAtTableCell("Currency", rowNo, currency);
                pageSteps.setTextAtTableCell("Exch Rate", rowNo, exchRate);
            }
        }
        pageSteps.clickButton("Submit");
        pageSteps.confirm("Yes");

        pageSteps.goToMenu(MenuID.PROC_AP_REVALUATION);
        for (int row : SessionData.getDataTbRowsNoHeader("doReval").keySet())
        {
            String vchDate = SessionData.getDataTbVal("doReval", row, "Revaluation Voucher Date");
            String currency = SessionData.getDataTbVal("doReval", row, "Currency");
            String exchRate = SessionData.getDataTbVal("doReval", row, "Exchange Rate");

            if (empty(currency))
                continue;

            if (notEmpty(vchDate))
            {
                pageSteps.clickButton("New");
                pageSteps.confirm("OK");
                pageSteps.setText("Revaluation Voucher Date", vchDate);
                pageSteps.setCheckBoxTableFilter("Del", "Y");
                pageSteps.clickButton("Delete");
                pageSteps.confirm("Yes");
            }
            if (notEmpty(currency))
            {
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Add");
                int rowNo = pageSteps.getRowsCount("Currency");
                pageSteps.setTextAtTableCell("Currency", rowNo, currency);
                pageSteps.setTextAtTableCell("Exch Rate", rowNo, exchRate);
            }
        }
        pageSteps.clickButton("Submit");
        pageSteps.confirm("Yes");
    }

    @Given("^user do AR revaluation$")
    public void doARRevaluation(List<List<String>> dataTable)
    {
        executeUpdate("UPDATE AR_SYSTEM_SETUP SET CURRENT_PERIOD = '6' WHERE CURRENT_YEAR = '2016'");

        SessionData.addDataTable("doReval", dataTable, false);
        // do a reset revaluation to prevent beforehand
        pageSteps.goToMenu(MenuID.PROC_AR_REVALUATION);
        for (int row : SessionData.getDataTbRowsNoHeader("doReval").keySet())
        {
            String vchDate = SessionData.getDataTbVal("doReval", row, "Revaluation Voucher Date");
            String currency = SessionData.getDataTbVal("doReval", row, "Currency");
            String exchRate = "1";

            if (empty(currency))
                continue;

            if (notEmpty(vchDate))
            {
                pageSteps.clickButton("New");
                pageSteps.confirm("OK");
                pageSteps.setText("Revaluation Voucher Date", vchDate);
                pageSteps.setCheckBoxTableFilter("Del", "Y");
                pageSteps.clickButton("Delete");
                pageSteps.confirm("Yes");
            }
            if (notEmpty(currency))
            {
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Add");
                int rowNo = pageSteps.getRowsCount("Currency");
                pageSteps.setTextAtTableCell("Currency", rowNo, currency);
                pageSteps.setTextAtTableCell("Exch Rate", rowNo, exchRate);
            }
        }
        pageSteps.clickButton("Submit");
        pageSteps.confirm("Yes");

        pageSteps.goToMenu(MenuID.PROC_AR_REVALUATION);
        for (int row : SessionData.getDataTbRowsNoHeader("doReval").keySet())
        {
            String vchDate = SessionData.getDataTbVal("doReval", row, "Revaluation Voucher Date");
            String currency = SessionData.getDataTbVal("doReval", row, "Currency");
            String exchRate = SessionData.getDataTbVal("doReval", row, "Exchange Rate");

            if (empty(currency))
                continue;

            if (notEmpty(vchDate))
            {
                pageSteps.clickButton("New");
                pageSteps.confirm("OK");
                pageSteps.setText("Revaluation Voucher Date", vchDate);
                pageSteps.setCheckBoxTableFilter("Del", "Y");
                pageSteps.clickButton("Delete");
                pageSteps.confirm("Yes");
            }
            if (notEmpty(currency))
            {
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Add");
                int rowNo = pageSteps.getRowsCount("Currency");
                pageSteps.setTextAtTableCell("Currency", rowNo, currency);
                pageSteps.setTextAtTableCell("Exch Rate", rowNo, exchRate);
            }
        }
        pageSteps.clickButton("Submit");
        pageSteps.confirm("Yes");
    }

    @Given("^user do reconciliation$")
    public void createReconVoucher(List<List<String>> dataTable)
    {
        SessionData.addDataTable("Reconciliation", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("Reconciliation").keySet())
        {
            String recNo = SessionData.getDataTbVal("Reconciliation", row, "Reconciliation No");
            String recDate = SessionData.getDataTbVal("Reconciliation", row, "Reconciliation Voucher Date");
            String bankSttDate = SessionData.getDataTbVal("Reconciliation", row, "Bank Statement Date");
            String bank = SessionData.getDataTbVal("Reconciliation", row, "Bank");
            String currency = SessionData.getDataTbVal("Reconciliation", row, "Currency");
            String bankSttNo = SessionData.getDataTbVal("Reconciliation", row, "Bank Statement No");
            String bankSttAmt = SessionData.getDataTbVal("Reconciliation", row, "Bank Statement Amount");
            String voucherNo = SessionData.getDataTbVal("Reconciliation", row, "Voucher No");
            String doSubmit = SessionData.getDataTbVal("Reconciliation", row, "Submit");

            if (notEmpty(recNo))
            {
                pageSteps.clickButton("New");
                voucherList.put(recNo, pageSteps.getTextDesc("Reconciliation No"));
                pageSteps.setText("Reconciliation Voucher Date", recDate);
                pageSteps.setText("Bank Statement Date", bankSttDate);
                pageSteps.clickSearchButton("Bank Account No");
                pageSteps.setText("Currency Code", currency);
                pageSteps.selectRow("Bank Party Code", bank);
                pageSteps.setText("Bank Statement No", bankSttNo);
            }
            if (notEmpty(voucherNo))
            {
                pageSteps.setTableFilter("Source Voucher No.", getVoucher(voucherNo));
                int rowNo = pageSteps.getRowsCount("Source Voucher No.");
                if (rowNo > 0)
                    for (int i = 1; i <= rowNo; i++)
                        pageSteps.setCheckboxAtXpathCSS("//tbody[contains(@id, 'draftLineItemsTable:tb')]/tr[" + i + "]//input[@type='checkbox']",
                                                        true);

                // bank statement amount must be equals to reconcile amount
                String recAmt = pageSteps.getTextDesc("Reconcile Balance Amount");
                pageSteps.setText("Bank Statement Amount", recAmt);
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^user abort reconciliation$")
    public void abortReconVoucher(List<List<String>> dataTable)
    {
        SessionData.addDataTable("AbortReconciliation", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("AbortReconciliation").keySet())
        {
            String recNo = SessionData.getDataTbVal("AbortReconciliation", row, "Reconciliation No");

            pageSteps.setTableFilter("Reconciliation No", getVoucher(recNo));
            if (pageSteps.getRowsCount("Reconciliation No") > 0)
            {
                pageSteps.selectFirstRow("Reconciliation No");
                pageSteps.clickButton("Abort");
                pageSteps.confirm("Yes");
            }
        }
    }

    String sqlResult   = getPayrollOutputPath("FIN_Realized_Gain_Loss_Output_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");
    String sqlResult_1 = getPayrollOutputPath("FIN_Realized_Gain_Loss_Output.xls");

    @Given("^system will have to pullout data as\\s+\"([^\"]*)\"$")
    public void systemPulloutData(String sheetName, List<List<String>> dataTable)
    {
        if (!ReadBean.isFile(sqlResult))
            ReadBean.copyFile(sqlResult_1, sqlResult);

        String statement = "";
        ResultSet rs;
        String statementS = "";

        int lastRow = 1;
        SessionData.addDataTable("pullData", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("pullData").keySet())
        {
            String vchNo = SessionData.getDataTbVal("pullData", row, "Voucher No");
            if (vchNo.toLowerCase().contains("rcc"))
            {
                statement = "select A.MODULE_CODE, A.TRANSACTION_TYPE_CODE, A.SOURCE_VOUCHER_NO, B.RECEIPT_CANCELLATION_TYPE, A.GL_ENTRY_TYPE, A.CURRENCY_CODE, A.GL_ACC_CODE, A.EXCH_RATE, A.NATURE_DEBIT, A.NATURE_CREDIT, A.HOME_DEBIT, A.HOME_CREDIT from gl_ledger_summary AS A JOIN AR_RCC_HST_HDR AS B ON A.SOURCE_VOUCHER_NO = B.RECEIPT_CANCELLATION_NO JOIN AR_RCC_HST_DET AS C ON C.RECEIPT_CANCELLATION_NO =  A.SOURCE_VOUCHER_NO where A.SOURCE_VOUCHER_NO = '?'";
            }
            else
            {
                statement = "select MODULE_CODE, TRANSACTION_TYPE_CODE, SOURCE_VOUCHER_NO, GL_ENTRY_TYPE, CURRENCY_CODE, GL_ACC_CODE, EXCH_RATE, NATURE_DEBIT, NATURE_CREDIT, HOME_DEBIT, HOME_CREDIT from gl_ledger_summary where SOURCE_VOUCHER_NO = '?'";
            }
            String voucherNo = getVoucher(vchNo);

            if (empty(vchNo))
                continue;

            statementS = statement.replace("?", voucherNo);
            rs = getResultStatement(statementS);
            int records = ConnectDatabase.getNumberofRecords(statementS);

            lastRow += 1;
            ExcelUtils.writeToExel(sqlResult, sheetName, "Voucher: " + vchNo, lastRow, 0);
            lastRow += 1;
            ExcelUtils.createExistingColumns(sqlResult, sheetName, rs, lastRow);
            lastRow += 0;
            ExcelUtils.createExistingCells(sqlResult, sheetName, rs, lastRow);
            lastRow += records + 1;

            //ExcelUtils.createExcelFile(sqlResult, sheetName);
            //int lastRow = ExcelUtils.getLastRowNum(sqlResult, sheetName) + 1;
            //ExcelUtils.writeToExel(sqlResult, sheetName, "Voucher: " + vchNo, lastRow, 0);
            //ExcelUtils.createExistingColumns(sqlResult, sheetName, rs, true);
            //ExcelUtils.createExistingCells(sqlResult, sheetName, rs);
        }
    }

    String sqlResult_Data = getPayrollOutputPath("FIN_Realized_Gain_Loss_Output_Data_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");
    String voucherKey     = "";
    int    failedCases    = 0;

    @Given("^system will have to check data as\\s+\"([^\"]*)\" with desc\\s+\"([^\"]*)\"$")
    public void systemCheckData(String sheetName, String scenarioDesc, List<List<String>> dataTable)
    {
        ExcelUtils.createExcelFile(sqlResult_Data, sheetName);
        String statement = "";
        ResultSet rs = null;
        String statementS = "";

        int lastRow = 1;
        SessionData.addDataTable("checkData", dataTable, false);

        // get header list
        List<String> headerList = SessionData.getDataTbRowByRowIndex("checkData", 0);

        for (int row : SessionData.getDataTbRowsNoHeader("checkData").keySet())
        {
            String vchNo = SessionData.getDataTbVal("checkData", row, "Voucher No");

            if (notEmpty(vchNo))
                voucherKey = vchNo;
            String voucherNo = getVoucher(voucherKey);
            //String voucherNo = "AR00193REC"; // for debug
            if (voucherKey.toLowerCase().contains("rcc"))
            {
                statement = "select A.MODULE_CODE, A.TRANSACTION_TYPE_CODE, A.SOURCE_VOUCHER_NO, B.RECEIPT_CANCELLATION_TYPE, A.GL_ENTRY_TYPE, A.CURRENCY_CODE, A.GL_ACC_CODE, A.EXCH_RATE, A.NATURE_DEBIT, A.NATURE_CREDIT, A.HOME_DEBIT, A.HOME_CREDIT from gl_ledger_summary AS A JOIN AR_RCC_HST_HDR AS B ON A.SOURCE_VOUCHER_NO = B.RECEIPT_CANCELLATION_NO JOIN AR_RCC_HST_DET AS C ON C.RECEIPT_CANCELLATION_NO =  A.SOURCE_VOUCHER_NO where A.SOURCE_VOUCHER_NO = '?'";
            }
            else
            {
                statement = "select MODULE_CODE, TRANSACTION_TYPE_CODE, SOURCE_VOUCHER_NO, GL_ENTRY_TYPE, CURRENCY_CODE, GL_ACC_CODE, EXCH_RATE, NATURE_DEBIT, NATURE_CREDIT, HOME_DEBIT, HOME_CREDIT from gl_ledger_summary where SOURCE_VOUCHER_NO = '?'";
            }

            statementS = statement.replace("?", voucherNo);
            if (notEmpty(vchNo))
                rs = getResultStatement(statementS);

            if (notEmpty(vchNo))
            {
                lastRow += 1;
                ExcelUtils.writeToExel(sqlResult_Data, sheetName, "Voucher: " + vchNo, lastRow, 0);
            }

            try
            {
                int colIndex = 0;

                if (notEmpty(vchNo))
                {
                    lastRow = ExcelUtils.getLastRowNum(sqlResult_Data, sheetName) + 1;
                    for (String columnName : headerList) // write column header
                    {
                        ExcelUtils.writeToExel(sqlResult_Data, sheetName, columnName, lastRow, colIndex);
                        colIndex += 1;
                    }
                }

                rs.next();

                colIndex = 0;
                lastRow = ExcelUtils.getLastRowNum(sqlResult_Data, sheetName);
                for (String columnName : headerList)
                { // on each row, loop throught header columns in feature data table to get row value
                    if (columnName.contains("Voucher"))
                    {
                        String value = rs.getString("SOURCE_VOUCHER_NO");
                        ExcelUtils.writeToExel(sqlResult_Data, sheetName, value, lastRow, colIndex);
                    }
                    if (columnName.contains("_"))
                    {
                        String actualValue = rs.getString(columnName);
                        String expectedValue = SessionData.getDataTbVal("checkData", row, columnName);
                        boolean result = false;
                        if (empty(expectedValue))
                            result = true;
                        else
                        {
                            if (ReadBean.isNumber(expectedValue) && (ReadBean.isNumber(actualValue)))
                            {
                                if (toDouble(expectedValue) == toDouble(actualValue))
                                    result = true;
                                else
                                    result = false;
                            }
                            else
                            {
                                if (expectedValue.equalsIgnoreCase(actualValue))
                                    result = true;
                                else
                                    result = false;
                            }
                        }
                        sleep((long) 0.1);
                        ExcelUtils.writeToExel(sqlResult_Data, sheetName, actualValue, lastRow, colIndex);
                        sleep((long) 0.1);
                        if (result)
                            ExcelUtils.setCellColor(sqlResult_Data, sheetName, lastRow, colIndex, HSSFColor.LIGHT_GREEN.index);
                        else
                        {
                            ExcelUtils.setCellColor(sqlResult_Data, sheetName, lastRow, colIndex, HSSFColor.RED.index);
                            ExcelUtils.setCellComment(sqlResult_Data, sheetName, lastRow, colIndex, "Levin", "Expected: " + expectedValue);
                            failedCases += 1;
                            addRowToTbDataReport(sheetName, scenarioDesc, "GL_LEDGER_SUMMARY", "Fail",
                                                 columnName + " - Expected: " + expectedValue + " but return " + actualValue);
                        }
                    }
                    colIndex += 1;
                }
            } catch (SQLException e)
            {

            }
        }
        if (failedCases == 0)
            addRowToTbDataReport(sheetName, scenarioDesc, "", "Pass", "");
    }

    @Then("^user summarize report for Realized Exchange Gain/Loss$")
    public void summaryFIN()
    {
        // get the result table
        String report = getTableReport(reportKey, true);

        // display the result table in cucumber report
        pageSteps.verifyFinalResult(report);

        // display the result table with total failed cases
        pageSteps.verifyFinalResult(getTableReport_Summary(failedCases), failedCases);
    }

    @Given("user send mail report for FIN Realized Exchange")
    public void sendMailReportGainLoss()
    {
        List<String> fileNames = new ArrayList<>();
        fileNames.add(sqlResult_Data);
        sendEmailToFIN("FIN Realized Exchange Gain Loss Report",
                       "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + "Number of failed cases: " + failedCases + "\nSee the attached file for details",
                       fileNames);
    }
}
