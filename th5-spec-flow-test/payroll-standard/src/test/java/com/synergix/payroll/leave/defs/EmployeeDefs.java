package com.synergix.payroll.leave.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by synergix61 on 23/2/2016.
 */
public class EmployeeDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Given("^Employee resigns as in\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void empResign(String dataset, String sheet)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;

        setDetailData(sheet);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String empCode = getColumn_Detail(1);
            String cessDate = getColumn_Detail(5);
            String companyCode = getColumn_Detail(7);
            String empStt = getColumn_Detail(8);

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.setTableFilter("Employee Code", empCode);
            pageSteps.selectFirstRow("Employee Code");

            pageSteps.goToTab("Employment Duration");
            if (pageSteps.getRowsCount("Join Date") == 1)
                pageSteps.setTextAtTableCell("Cessation Date", 1, cessDate);
            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");
        }
    }

    @Given("^Employee rejoins as in\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void empRejoin(String dataset, String sheet)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;

        setDetailData(sheet);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String empCode = getColumn_Detail(1);
            String joinDate = getColumn_Detail(3);
            String confirmDate = getColumn_Detail(4);
            String companyCode = getColumn_Detail(7);
            String empStt = getColumn_Detail(8);

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.setTableFilter("Employee Code", empCode);
            pageSteps.selectFirstRow("Employee Code");

            pageSteps.goToTab("Employment Duration");
            if (pageSteps.getRowsCount("Join Date") == 1)
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(3);
                pageSteps.setTextAtTableCell("Join Date", 2, joinDate);
                pageSteps.setTextAtTableCell("Confirmation Date", 2, confirmDate);
                pageSteps.setTextAtTableCell("Company Code", 2, companyCode);
                pageSteps.clickButton("Update");
                pageSteps.confirm("Yes");
            }
        }
    }

    @Given("^Employee updates Grade as in\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void updateGrade(String dataset, String sheet)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;

        setDetailData(sheet);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String empCode = getColumn_Detail(1);
            String grade = getColumn_Detail(3);
            String effDate = getColumn_Detail(4);
            String epc = getColumn_Detail(5);

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.setTableFilter("Employee Code", empCode);
            pageSteps.selectFirstRow("Employee Code");

            pageSteps.goToTab("Local Info");
            pageSteps.clickButton("Edit", 1);
            pageSteps.openCalendar("Effective Date");
            pageSteps.setCalendarDate(effDate);
            pageSteps.setTextPopupPanel("Edit HR Info", "Grade", grade);
            pageSteps.clickButton("Submit");
            pageSteps.confirm("OK");
            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");
        }
    }

    @Given("^user updates Grade")
    public void updateGrade_F(List<List<String>> dataTable)
    {
        SessionData.addDataTable("UpdateGrade", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("UpdateGrade").keySet())
        {
            String empCode = SessionData.getDataTbVal("UpdateGrade", row, "Employee Code");
            String effDate = SessionData.getDataTbVal("UpdateGrade", row, "Effective Date From");
            String grade = SessionData.getDataTbVal("UpdateGrade", row, "Grade");

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.setTableFilter("Employee Code", empCode);
            pageSteps.selectFirstRow("Employee Code");

            pageSteps.goToTab("Local Info");
            pageSteps.clickButton("Edit", 1);
            pageSteps.openCalendar("Effective Date");
            pageSteps.setCalendarDate(effDate);
            pageSteps.setTextPopupPanel("Edit HR Info", "Grade", grade);
            pageSteps.clickButton("Submit");
            pageSteps.confirm("OK");
            pageSteps.clickButton("Update");
            pageSteps.confirm("Yes");
        }
    }

    @When("^user updates Cessation Date for employees$")
    public void updateCessationDate(List<List<String>> dataTable)
    {
        SessionData.addDataTable("UpdateCessation", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("UpdateCessation").keySet())
        {
            String empCode = SessionData.getDataTbVal("UpdateCessation", row, "Employee Code");
            String cessDate = SessionData.getDataTbVal("UpdateCessation", row, "Cessation Date");

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.setTableFilter("Employee Code", empCode);
            pageSteps.selectFirstRow("Employee Code");
            pageSteps.goToTab("Employment Duration");
            if (pageSteps.getRowsCount("Join Date") > 0)
            {
                pageSteps.setTextAtTableCell("Cessation Date", 1, cessDate);
                pageSteps.clickButton("Update");
                pageSteps.confirm("Yes");
            }
        }
    }
}




