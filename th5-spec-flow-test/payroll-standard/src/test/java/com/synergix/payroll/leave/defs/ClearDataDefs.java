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
public class ClearDataDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Given("^Employee Grade is reset as in\\s+\"([^\"]*)\"$")
    public void resetEmpGrade(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;

        setDataset("Dataset");
        // clear grade
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String empCode = getColumn(1);
            if (notEmpty(empCode))
                executeUpdate("DELETE FROM MT_EMP_HR_EMP_GRADE WHERE EMPLOYEE_CODE = '" + empCode + "'");
        }
        // update grade
        setDetailData("Grade");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String empCode = getColumn_Detail(1);
            String grade = getColumn_Detail(3);
            String effDate = getColumn_Detail(4);

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

    @Given("^Data is clear as in\\s+\"([^\"]*)\"$")
    public void clearLeaveEntData(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;

        setDataset("Dataset");
        // clear grade
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String query = getColumn(1);
            if (notEmpty(query))
                executeUpdate(query);
        }
    }

    @Given("^Employee employment info is reset as in\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void resetEmpInfo(String dataset, String sheet)
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
            int rowsNo = pageSteps.getRowsCount("Join Date");
            if (rowsNo > 0)
            {
                // delete all records then add
                for (int j = 1; j <= rowsNo; j++)
                    pageSteps.setCheckBoxAtTableCell("Del", j, "Y");
                pageSteps.clickButton("Delete", 2);
                pageSteps.confirm("Yes");

                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                pageSteps.setTextAtTableCell("Join Date", 1, joinDate);
                pageSteps.setTextAtTableCell("Confirmation Date", 1, confirmDate);
                pageSteps.setTextAtTableCell("Company Code", 1, companyCode);
                pageSteps.clickButton("Update");
                pageSteps.confirm("Yes");
            }
        }
    }

    @When("^user runs query$")
    public void runQuery(List<List<String>> dataTable)
    {
        SessionData.addDataTable("SQL", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("SQL").keySet())
        {
            String query = SessionData.getDataTbVal("SQL", row, "SQL");
            if (query.toLowerCase().startsWith("update") || query.toLowerCase().startsWith("delete"))
                executeUpdate(query);
            else
                executeQuery(query);
        }
    }
}




