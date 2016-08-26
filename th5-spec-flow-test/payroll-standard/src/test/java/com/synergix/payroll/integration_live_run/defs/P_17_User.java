package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.ReadBean;
import cucumber.api.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_17_User extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    String runCode;
    String companyCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^User is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        companyCode = getProp("company.code");

        // setup global config
        pageSteps.goToMenu(MenuID.GL_GLOBAL_CONFIG);
        pageSteps.setRadioOption("Enable Send Email", "N");
        pageSteps.setRadioOption("Enable new authentication (only works with TH5)", "Y");

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String empCode  = getColumn(1);
            String empName  = getColumn(2);
            String idNo     = getColumn(3);
            String userName = getColumn(4);
            String userPass = getColumn(5);
            String tagToAll = getColumn(7);
            if (empty(companyCode))
                companyCode = getCurrentCompany();

            if (empty(empCode))
                continue;

            pageSteps.goToMenu(MenuID.GL_EMPLOYEE);
            pageSteps.clickButton("New");
            pageSteps.setText("Employee Code", empCode + "1"); //to prevent user name duplicates with user code
            pageSteps.setText("Employee Name", empName);
            pageSteps.setText("Date of Birth", "01/01/1990");
            pageSteps.setDropDownOption("Nationality", "Vietnamese");
            pageSteps.setDropDownOption("Gender", "Male");
            pageSteps.setDropDownOption("Race", "Malay");

            if (pageSteps.getRowsCount("Identification No.") == 0)
                pageSteps.clickButton("Add");
            pageSteps.setTextAtTableCell("Identification No.", 1, idNo);
            pageSteps.setTextAtTableCell("Application Date", 1, "01/01/2000");
            pageSteps.setTextAtTableCell("Issue Date", 1, "01/01/2000");
            pageSteps.setTextAtTableCell("Expiry Date", 1, "01/01/2020");

            // tag to all company
            if (tagToAll.equalsIgnoreCase("Y"))
            {
                pageSteps.goToTab("Company");
                pageSteps.setCheckBoxTableFilter("Tag", "Check");
            }
            pageSteps.clickButton("Generate");
            pageSteps.confirmNoOk("Yes");

            String info = pageSteps.getInfoPanelText();
            pageSteps.confirm("OK");
            String genPass = ReadBean.cutFirstChar(info, 'd');
            genPass = ReadBean.cutFirstChar(genPass, ' ');
            genPass = ReadBean.cutLastChar(genPass, ' ');

            pageSteps.logOut();
            pageSteps.login(empCode + "1", genPass, companyCode, 1);
            pageSteps.enterNewUserInfo(userName + "_1", userPass);

            String userID  = Serenity.sessionVariableCalled("USER_ID");
            String userPwd = Serenity.sessionVariableCalled("USER_PASSWORD");
            pageSteps.login(userID, userPass, companyCode, 1);
        }
    }

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^User Role Access is set up as in\\s+\"([^\"]*)\"$")
    public void testFlow2(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String userName   = getColumn(3);
            String roleAccess = getColumn(5);

            pageSteps.goToMenu(MenuID.MT_USER_ROLE_ACCESS);
            pageSteps.setTableFilter("User Name", userName);
            pageSteps.selectFirstRow("User ID");
            pageSteps.clickButton("Add");
            pageSteps.setTextAtTableCell("Role Code", 1, roleAccess);
            pageSteps.clickButton("Close");
        }
    }
}
