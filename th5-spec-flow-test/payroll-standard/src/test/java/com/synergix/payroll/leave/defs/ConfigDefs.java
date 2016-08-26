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
public class ConfigDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Given("^Global Config is set as in\\s+\"([^\"]*)\"$")
    public void setGlobalConfig(String dataset)
    {
        pageSteps.goToMenu(MenuID.GL_GLOBAL_CONFIG);

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDetailData("Dataset");

        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String configName = getColumn_Detail(1);
            String value = getColumn_Detail(2);
            String type = getColumn_Detail(3);

            if (notEmpty(configName) && notEmpty(value) && notEmpty(type))
            {
                if (type.equalsIgnoreCase("RADIO"))
                    pageSteps.setRadioOption(configName, value);
                if (type.equalsIgnoreCase("DROPDOWN"))
                    pageSteps.setDropDownOption(configName, value);
                if (type.equalsIgnoreCase("TEXT"))
                    pageSteps.setText(configName, value);
                if (type.equalsIgnoreCase("DB"))
                {
                    String query = getColumn_Detail(4);
                    if (notEmpty(query))
                        executeUpdate(query);
                }
            }
        }
    }

    @Given("^Module Config is set as in\\s+\"([^\"]*)\"$")
    public void setModuleConfig(String dataset)
    {
        pageSteps.goToMenu(MenuID.MT_MODULE_CONFIG);

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDetailData("Dataset");

        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String parentTab = getColumn_Detail(1);
            String childTab = getColumn_Detail(2);
            String configName = getColumn_Detail(3);
            String value = getColumn_Detail(4);
            String type = getColumn_Detail(5);

            if (notEmpty(configName) && notEmpty(value) && notEmpty(type))
            {
                pageSteps.goToTab(parentTab);
                pageSteps.goToTab(childTab);

                if (type.equalsIgnoreCase("RADIO"))
                    pageSteps.setRadioOption(configName, value);
                if (type.equalsIgnoreCase("DROPDOWN"))
                    pageSteps.setDropDownOption(configName, value);
                if (type.equalsIgnoreCase("TEXT"))
                    pageSteps.setText(configName, value);
                if (type.equalsIgnoreCase("DB"))
                {
                    String query = getColumn_Detail(6);
                    if (notEmpty(query))
                        executeUpdate(query);
                }
            }
        }
    }

    @When("^Module Config is set$")
    public void setModuleConfig_F(List<List<String>> dataTable)
    {
        pageSteps.goToMenu(MenuID.MT_MODULE_CONFIG);
        SessionData.addDataTable("ModuleConfig", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ModuleConfig").keySet())
        {
            String parentTab = SessionData.getDataTbVal("ModuleConfig", row, "Parent Tab");
            String childTab = SessionData.getDataTbVal("ModuleConfig", row, "Child Tab");
            String configName = SessionData.getDataTbVal("ModuleConfig", row, "Module Configuration");
            String value = SessionData.getDataTbVal("ModuleConfig", row, "Value");
            String type = SessionData.getDataTbVal("ModuleConfig", row, "Type");
            String query = SessionData.getDataTbVal("ModuleConfig", row, "SQL");

            pageSteps.goToTab(parentTab);
            pageSteps.goToTab(childTab);

            if (type.equalsIgnoreCase("RADIO"))
                pageSteps.setRadioOption(configName, value);
            if (type.equalsIgnoreCase("DROPDOWN"))
                pageSteps.setDropDownOption(configName, value);
            if (type.equalsIgnoreCase("TEXT"))
                pageSteps.setText(configName, value);
            if (type.equalsIgnoreCase("DB"))
                if (notEmpty(query))
                    executeUpdate(query);
        }
    }
}


