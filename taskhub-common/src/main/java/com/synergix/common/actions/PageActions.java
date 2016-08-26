package com.synergix.common.actions;

import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.common.pages.LoginPage;
import com.synergix.utilities.ReadBean;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageActions extends PageActions_Base
{
    private WebElement       element;
    private List<WebElement> elements;

    private WebDriver driver;
    protected boolean proceedAfterError  = false;
    protected double  progressBarTimeOut = 1;

    public PageActions(WebDriver driver)
    {
        super(driver);
        tableHeaderMode = ElementID.TABLE_HEADER_TAG; // TH5 tables
        ajaxMode = ElementID.AJAX_MODE;
    }

    public void setActionDriver(WebDriver driver)
    {
        this.driver = driver;
        setActionDriver_Base(driver);
        setReportInfo();
    }

//    @Override
//    public void setReportInfo()
//    {
//        ATUReports.setWebDriver(driver);
//        ATUReports.setAuthorInfo("Levin's Automation Tests", DateBean.getTimeNow(), "1.0");
//    }

    // constructor used for multilogin
    public PageActions(WebDriver dr, String baseURL)
    {
        super(dr);
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dr.get(baseURL);
    }

    @Override
    public WebDriver getActionDriver()
    {
        return this.driver;
    }

    public List<WebElement> getElementCell(String columnName, int rowNumber, int colCount, boolean isGetEntireColumn, boolean isSameRowWithHeader,
                                           boolean isGetAllRows, boolean isGetTdCount, long timeOut) throws Exception
    {
        String div = "";
        String xPath = "";
        String[] s = null;
        s = ReadBean.split(columnName, " ");
        if (s.length <= 1)
        {
            // div = "(//*[text()=\"" + columnName + "\"] | //*[starts-with(text(), \"" + columnName + "\")])[1]";
            div = "//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | //" + tableHeaderMode + "//*[starts-with(text(), \"" + columnName + "\")]";
        }
        if (s.length > 1 && s.length <= 2)
        {// 1 line column name, in rare cases there are 2 lines
            div = "//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | //" + tableHeaderMode + "//*[starts-with(text(), \"" + columnName + "\")] | //" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text()=\"" + s[1] + "\"] | //" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text" + "()=\"" + " " + s[1] + "\"]";
        }
        else if (s.length > 2)
        {// 2 lines column (s.length >=3)
            String case0_column1 = "";
            String case1_column1 = "";
            String case1_column2 = "";
            String case2_column1 = "";
            String case2_column2 = "";
            String case3_column1 = "";
            String case3_column2 = "";
            String case4_column1 = "";
            String case4_column2 = "";
            String case5_column1 = "";
            String case5_column2 = "";
            String case6_column1 = "";
            String case6_column2 = "";
            String case6_column3 = "";
            // case 0 - all words first line
            case0_column1 = columnName;
            // case 1 - 2 words first line
            case1_column1 = s[0] + " " + s[1];
            case1_column2 = "";
            for (int i = 2; i < s.length; i++)
            {
                case1_column2 += " " + s[i];
            }
            case1_column2 = case1_column2.trim();
            // case 2 - 3 words first line
            case2_column1 = s[0] + " " + s[1] + " " + s[2];
            case2_column2 = "";
            if (s.length > 3)
            {
                for (int i = 3; i < s.length; i++)
                {
                    case2_column2 += " " + s[i];
                }
                case2_column2 = case2_column2.trim();
            }
            // case 3 - 4 words first line
            if (s.length >= 4)
            {
                case3_column1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3];
                case3_column2 = "";
                if (s.length > 4)
                {
                    for (int i = 4; i < s.length; i++)
                    {
                        case3_column2 += " " + s[i];
                    }
                    case3_column2 = case3_column2.trim();
                }
            }
            // case 4 - 5 words first line
            if (s.length >= 5)
            {
                case4_column1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4];
                case4_column2 = "";
                if (s.length > 5)
                {
                    for (int i = 5; i < s.length; i++)
                    {
                        case4_column2 += " " + s[i];
                    }
                    case4_column2 = case4_column2.trim();
                }
            }
            // case 5 & 6 - 1 word first line
            if (s.length >= 2)
            {
                if (s.length == 2)
                {
                    case5_column1 = s[0].trim();
                    case5_column2 = s[1].trim();
                }
                if (s.length == 3)
                {
                    case5_column1 = s[0].trim();
                    case5_column2 = s[1].trim() + " " + s[2].trim();
                    case6_column1 = s[0].trim();
                    case6_column2 = s[1].trim();
                    case6_column3 = s[2].trim();
                }
            }
            String case0 = "";
            String case1 = "";
            String case2 = "";
            String case3 = "";
            String case4 = "";
            String case5 = "";
            String case6 = "";
            case0 = "//" + tableHeaderMode + "//*[text()=\"" + case0_column1 + "\"]";
            case1 = "//" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"][text()=\"" + case1_column2 + "\"]" + " | //" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"][text()=\"" + " " + case1_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case1_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + " " + case1_column2 + "\"]";
            case2 = "//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"][text()=\"" + case2_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"][text()=\"" + " " + case2_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + case2_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case2_column2 + "\"]";
            case3 = "//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"][text()=\"" + case3_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"][text()=\"" + " " + case3_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + case3_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case3_column2 + "\"]";
            case4 = "//*[text()=\"" + case4_column1 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"][text()=\"" + case4_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"][text()=\"" + " " + case4_column2 + "\"] | //" + tableHeaderMode + "//*[text" + "()=\"" + case4_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case4_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case4_column2 + "\"]";
            case5 = "//" + tableHeaderMode + "//*[text()=\"" + case5_column1 + "\"][text()=\"" + case5_column2 + "\"]";
            case6 = "//" + tableHeaderMode + "//*[text()=\"" + case6_column1 + "\"][text()=\"" + case6_column2 + "\"][text()=\"" + case6_column3 + "\"]";
            div = case0 + " | " + case1 + " | " + case2 + " | " + case3 + " | " + case4 + " | " + case5 + " | " + case6;
        }
        // getting the postion of the visible column
        elements = getElements(div, 1);
        if (elements.size() > 1)
        {
            int pos = getVisibleElementPos(elements);
            // div = div + "[" + pos + "]"; // use this if anything wrong
            // happens - levin
            div = "(" + div + "[" + pos + "])";
        }
        div = "(" + div + ")";
        if (colCount == 0 && isGetTdCount == true)
        {
            // count(" + div + "/ancestor-or-self::th/preceding-sibling::th")+1
            tdCount = getColumnCount("" + div + "/ancestor-or-self::th/preceding-sibling::th") + "";
        }
        else if (colCount == 0 && isGetTdCount == false)
        {
            tdCount = "count(" + div + "/ancestor-or-self::th/preceding-sibling::th)+1";
        }
        else
        {
            tdCount = colCount + "";
        }
        if (isGetEntireColumn)
        {
            isSameRowWithHeader = false;
            isGetAllRows = false;
            xPath = div + "/ancestor::thead/following-sibling::tbody/tr/td[" + tdCount + "]";
        }
        else if (isSameRowWithHeader)
        {
            isGetAllRows = false;
            isGetEntireColumn = false;
            xPath = div + "/ancestor::tr//th[" + tdCount + "]//div/parent::th"; // handle cases in System Role tab in Global Employee where column name duplicates with table header above
        }
        else if (isGetAllRows)
        {
            isGetEntireColumn = false;
            isSameRowWithHeader = false;
            xPath = div + "/ancestor::thead/following-sibling::tbody/tr";
        }
        else
        {
            xPath = div + "/ancestor::thead/following-sibling::tbody/tr[" + rowNumber + "]/td[" + tdCount + "]";
        }
        sleep(0.1);
        elements = getElements(xPath, timeOut);
        if (elements == null)
        {
            return null;
        }
        if (notNull(elements))
        {
            return elements;
        }
        else
        {
            return null;
        }
    }

    // Levin: ***important*** to determine the table header in TH5 or TH6
    protected String tableHeaderMode = ""; // ElementID.TABLE_HEADER_TAG

    // for table in Project Quotation, where there are 2 tables with same column
    // name

    /**
     * @param columnName
     * @param order
     * @param rowNumber
     * @param colCount            Default is 0, specify if user need the cell of a customized
     *                            column
     * @param isGetEntireColumn   Get all cells in all rows of the column
     * @param isSameRowWithHeader Get the cell in table header instead of row in table body
     * @param isGetAllRows        Get all row (tr)
     * @param isGetTdCount        false
     * @param timeOut
     * @return
     * @throws Exception
     * @author levin
     */
    public List<WebElement> getElementCell(String columnName, int order, int rowNumber, int colCount, boolean isGetEntireColumn,
                                           boolean isSameRowWithHeader, boolean isGetAllRows, boolean isGetTdCount, long timeOut) throws Exception
    {
        String div = "";
        String xPath = "";
        String[] s = null;
        s = ReadBean.split(columnName, " ");
        if (s.length <= 1)
        {
            // div = "(//*[text()=\"" + columnName + "\"] |
            // //*[starts-with(text(), \"" + columnName + "\")])[1]";
            div = "(//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | //" + tableHeaderMode + "//*[starts-with(text(), \"" + columnName + "\")])";
        }
        else if (s.length > 1 && s.length <= 2)
        {// 1 line column name, in
            // rare cases there are 2
            // lines
            div = "(//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | //" + tableHeaderMode + "//*[starts-with(text(), \"" + columnName + "\")] | //" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text()=\"" + s[1] + "\"] | //" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text" + "()=\"" + " " + s[1] + "\"])";
        }
        else if (s.length > 2)
        {// 2 lines column (s.length >=3)
            String case0_column1 = "";
            String case1_column1 = "";
            String case1_column2 = "";
            String case2_column1 = "";
            String case2_column2 = "";
            String case3_column1 = "";
            String case3_column2 = "";
            String case4_column1 = "";
            String case4_column2 = "";
            String case5_column1 = "";
            String case5_column2 = "";
            String case6_column1 = "";
            String case6_column2 = "";
            String case6_column3 = "";
            // case 0 - all words first line
            case0_column1 = columnName;
            // case 1 - 2 words first line
            case1_column1 = s[0] + " " + s[1];
            case1_column2 = "";
            for (int i = 2; i < s.length; i++)
            {
                case1_column2 += " " + s[i];
            }
            case1_column2 = case1_column2.trim();
            // case 2 - 3 words first line
            case2_column1 = s[0] + " " + s[1] + " " + s[2];
            case2_column2 = "";
            if (s.length > 3)
            {
                for (int i = 3; i < s.length; i++)
                {
                    case2_column2 += " " + s[i];
                }
                case2_column2 = case2_column2.trim();
            }
            // case 3 - 4 words first line
            if (s.length >= 4)
            {
                case3_column1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3];
                case3_column2 = "";
                if (s.length > 4)
                {
                    for (int i = 4; i < s.length; i++)
                    {
                        case3_column2 += " " + s[i];
                    }
                    case3_column2 = case3_column2.trim();
                }
            }
            // case 4 - 5 words first line
            if (s.length >= 5)
            {
                case4_column1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4];
                case4_column2 = "";
                if (s.length > 5)
                {
                    for (int i = 5; i < s.length; i++)
                    {
                        case4_column2 += " " + s[i];
                    }
                    case4_column2 = case4_column2.trim();
                }
            }
            // case 5 & 6 - 1 word first line
            if (s.length >= 2)
            {
                if (s.length == 2)
                {
                    case5_column1 = s[0].trim();
                    case5_column2 = s[1].trim();
                }
                if (s.length == 3)
                {
                    case5_column1 = s[0].trim();
                    case5_column2 = s[1].trim() + " " + s[2].trim();
                    case6_column1 = s[0].trim();
                    case6_column2 = s[1].trim();
                    case6_column3 = s[2].trim();
                }
            }
            String case0 = "";
            String case1 = "";
            String case2 = "";
            String case3 = "";
            String case4 = "";
            String case5 = "";
            String case6 = "";
            case0 = "//" + tableHeaderMode + "//*[text()=\"" + case0_column1 + "\"]";
            case1 = "//" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"][text()=\"" + case1_column2 + "\"]" + " | //" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"][text()=\"" + " " + case1_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case1_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + " " + case1_column2 + "\"]";
            case2 = "//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"][text()=\"" + case2_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"][text()=\"" + " " + case2_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + case2_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case2_column2 + "\"]";
            case3 = "//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"][text()=\"" + case3_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"][text()=\"" + " " + case3_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + case3_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case3_column2 + "\"]";
            case4 = "//" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"][text()=\"" + case4_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"][text()=\"" + " " + case4_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"]/parent::tr/following-sibling::tr//*[text" + "()=\"" + case4_column2 + "\"] | //" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case4_column2 + "\"]";
            case5 = "//" + tableHeaderMode + "//*[text()=\"" + case5_column1 + "\"][text()=\"" + case5_column2 + "\"]";
            case6 = "//" + tableHeaderMode + "//*[text()=\"" + case6_column1 + "\"][text()=\"" + case6_column2 + "\"][text()=\"" + case6_column3 + "\"]";
            div = "(" + case0 + " | " + case1 + " | " + case2 + " | " + case3 + " | " + case4 + " | " + case5 + " | " + case6 + ")";
        }
        sleep(1);
        // getting the position of the visible columns, continuously in case
        // there are more than 1 columns in a table, and the columns repeat in
        // other tables
        elements = getElements(div, 1);
        if (elements.size() > 1)
        {
            int pos = getVisibleElementPos(elements) + order - 1;
            div = div + "[" + pos + "]";
        }
        div = "(" + div + ")";
        div = div + "[" + order + "]";
        if (colCount == 0 && isGetTdCount == true)
        {// @Warning: Unused
            // count(" + div +
            // "/ancestor-or-self::th/preceding-sibling::th")+1
            tdCount = getColumnCount("(" + div + "/ancestor-or-self::th)[1]/preceding-sibling::th") + "";
        }
        else if (colCount == 0 && isGetTdCount == false)
        {
            tdCount = "count(" + div + "/ancestor-or-self::th[1]/preceding-sibling::th)+1";// ->
        }
        else
        {// @Warning: Unused
            tdCount = colCount + "";
        }
        if (isGetEntireColumn)
        {// @Warning: Unused
            isSameRowWithHeader = false;
            isGetAllRows = false;
            xPath = "(" + div + "/ancestor::thead)[1]/following-sibling::tbody/tr/td[" + tdCount + "]";
        }
        else if (isSameRowWithHeader)
        {// @Warning: Unused
            isGetAllRows = false;
            isGetEntireColumn = false;
            xPath = div + "/ancestor-or-self::th[1]";
        }
        else if (isGetAllRows)
        {// @Warning: Unused
            isGetEntireColumn = false;
            isSameRowWithHeader = false;
            xPath = "(" + div + "/ancestor::thead)[1]/following-sibling::tbody/tr";
        }
        else
        {
            xPath = "(" + div + "/ancestor::thead)[1]/following-sibling::tbody/tr[" + rowNumber + "]/td[" + tdCount + "]";
        }
        elements = getElements(xPath, timeOut);
        if (elements == null)
        {
            return null;
        }
        else if (notNull(elements))
        {
            return elements;
        }
        else
        {
            return null;
        }
    }

    /**
     * Get an element under a column name with a div name
     *
     * @throws Exception
     * @author Levin
     */
    public List<WebElement> getElementCell(String tableName, String columnName, int rowNumber, int colCount, boolean isGetEntireColumn,
                                           boolean isSameRowWithHeader, boolean isGetAllRows, long timeOut) throws Exception
    {
        String div = "";
        String xPath = "";
        String[] s = null;
        s = ReadBean.split(columnName, " ");
        if (s.length <= 2)
        {// 1 line column name, in rare cases there are 2
            // lines
            if (s.length == 1)
            {
                div = "((//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()" + "=\"" + columnName + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[starts-with(text(), \"" + columnName + "\")])[1] | //div[text()=\"" + tableName + "\"]//ancestor::tr//following-sibling::tr//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | " + "(//*[text()=\"" + tableName
                        // div
                        + "\"]/ancestor::td)[last()]//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"])";
            }
            else
            {
                div = "(//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | " + "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[starts-with(text(), \"" + columnName + "\")] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text" + "()=\"" + s[1] + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text()=\"" + " " + s[1] + "\"] | //div[text()" + "=\"" + tableName + "\"]//ancestor::tr//following-sibling::tr//" + tableHeaderMode + "//*[text()=\"" + columnName + "\"] | //div[text()=\"" + tableName + "\"]//ancestor::tr//following-sibling::tr//" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text()=\"" + s[1] + "\"] | (//*[text()=\"" + tableName + "\"]/ancestor::td)[last()]//" + tableHeaderMode + "//*[text()=\"" + s[0] + "\"][text()=\"" + s[1] + "\"])";
            }
        }
        else
        {// 2 line column (s.length >=3)
            String case0_column1 = "";
            String case1_column1 = "";
            String case1_column2 = "";
            String case2_column1 = "";
            String case2_column2 = "";
            String case3_column1 = "";
            String case3_column2 = "";
            String case4_column1 = "";
            String case4_column2 = "";
            String case5_column1 = "";
            String case5_column2 = "";
            String case6_column1 = "";
            String case6_column2 = "";
            String case6_column3 = "";
            // case 0 - all words first line
            case0_column1 = columnName;
            // case 1 - 2 words first line
            case1_column1 = s[0] + " " + s[1];
            case1_column2 = "";
            for (int i = 2; i < s.length; i++)
            {
                case1_column2 += " " + s[i];
            }
            case1_column2 = case1_column2.trim();
            // case 2 - 3 words first line
            case2_column1 = s[0] + " " + s[1] + " " + s[2];
            case2_column2 = "";
            if (s.length > 3)
            {
                for (int i = 3; i < s.length; i++)
                {
                    case2_column2 += " " + s[i];
                }
                case2_column2 = case2_column2.trim();
            }
            // case 3 - 4 words first line
            if (s.length >= 4)
            {
                case3_column1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3];
                case3_column2 = "";
                if (s.length > 4)
                {
                    for (int i = 4; i < s.length; i++)
                    {
                        case3_column2 += " " + s[i];
                    }
                    case3_column2 = case3_column2.trim();
                }
            }
            // case 4 - 5 words first line
            if (s.length >= 5)
            {
                case4_column1 = s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4];
                case4_column2 = "";
                if (s.length > 5)
                {
                    for (int i = 5; i < s.length; i++)
                    {
                        case4_column2 += " " + s[i];
                    }
                    case4_column2 = case4_column2.trim();
                }
            }
            // case 5 & 6 - 1 word first line
            if (s.length >= 2)
            {
                if (s.length == 2)
                {
                    case5_column1 = s[0].trim();
                    case5_column2 = s[1].trim();
                }
                if (s.length == 3)
                {
                    case5_column1 = s[0].trim();
                    case5_column2 = s[1].trim() + " " + s[2].trim();
                    case6_column1 = s[0].trim();
                    case6_column2 = s[1].trim();
                    case6_column3 = s[2].trim();
                }
            }
            String case0 = "";
            String case1 = "";
            String case2 = "";
            String case3 = "";
            String case4 = "";
            String case5 = "";
            String case6 = "";
            case0 = "//div[text()=\"" + tableName + "\"]/parent::div//table//*[text()=\"" + case0_column1 + "\"] | " + "//div[text()=\"" + tableName + "\"]//ancestor::tr//following-sibling::tr//" + tableHeaderMode + "//*[text()=\"" + case0_column1 + "\"]";
            case1 = "//div[text()=\"" + tableName + "\"]/parent::div//table//*[text()=\"" + case1_column1 + "\"][text" + "()=\"" + case1_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"][text()=\"" + " " + case1_column2 + "\"] " + "| //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case1_column2 + "\"] | " + "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case1_column2 + "\"] " + "| //div[text()=\"" + tableName + "\"]//ancestor::tr//following-sibling::tr//" + tableHeaderMode + "//*[text()=\"" + case1_column1 + "\"][text()=\"" + case1_column2 + "\"]";
            case2 = "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"][text()=\"" + case2_column2 + "\"] | " + "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"][text()=\"" + " " + case2_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case2_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case2_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case2_column2 + "\"]";
            case3 = "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"][text()=\"" + case3_column2 + "\"] | " + "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"][text()=\"" + " " + case3_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case3_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case3_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case3_column2 + "\"]";
            case4 = "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"][text()=\"" + case4_column2 + "\"] | " + "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"][text()=\"" + " " + case4_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + case4_column2 + "\"] | //div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case4_column1 + "\"]/parent::tr/following-sibling::tr//*[text()=\"" + " " + case4_column2 + "\"]";
            case5 = "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case5_column1 + "\"][text()=\"" + case5_column2 + "\"]";
            case6 = "//div[text()=\"" + tableName + "\"]/parent::div//table//" + tableHeaderMode + "//*[text()=\"" + case6_column1 + "\"][text()=\"" + case6_column2 + "\"][text()=\"" + case6_column3 + "\"]";
            div = "(" + case0 + " | " + case1 + " | " + case2 + " | " + case3 + " | " + case4 + " | " + case5 + " | " + case6 + ")";
        }
        // getting the postion of the visible column
        elements = getElements(div, 1);
        if (elements.size() > 1)
        {
            int pos = getVisibleElementPos(elements);
            div = div + "[" + pos + "]";
        }
        div = "(" + div + ")";
        String tdCount = "";
        if (colCount == 0)
        {
            // count(" + div + "/ancestor-or-self::th/preceding-sibling::th")+1
            tdCount = getColumnCount("" + div + "/ancestor-or-self::th/preceding-sibling::th") + "";
        }
        else
        {
            tdCount = colCount + "";
        }
        if (isGetEntireColumn)
        {
            isSameRowWithHeader = false;
            xPath = div + "/ancestor::thead/following-sibling::tbody/tr/td[" + tdCount + "]";
        }
        if (isSameRowWithHeader)
        {
            xPath = div + "/ancestor::tr//th[" + tdCount + "]";
        }
        if (isGetAllRows)
        {
            xPath = div + "/ancestor::thead/following-sibling::tbody/tr";
        }
        else
        {
            xPath = div + "/ancestor::thead/following-sibling::tbody/tr[" + rowNumber + "]/td[" + tdCount + "]";
        }
        elements = getElements(xPath, timeOut);
        if (elements == null)
        {
            return null;
        }
        if (notNull(elements))
        {
            return elements;
        }
        else
        {
            return null;
        }
    }

    public List<WebElement> getElementsUnderColumnName(String columnName, int rowNumber, int colCount, String type, long timeOut) throws Exception
    {
        elements = getElementCell(columnName, rowNumber, colCount, false, false, false, true, timeOut);
        element = getVisibleElement(elements);
        return getElementChildren(element, "//" + type);
    }

    // for 2 tables with same column name, PJ uses commonly
    public List<WebElement> getElementsUnderColumnName(String columnName, int repeatedColOrder, int rowNumber, int elementxSequence, int colCount,
                                                       String type, long timeOut) throws Exception
    {
        elements = getElementCell(columnName, repeatedColOrder, rowNumber, colCount, false, false, false, true, timeOut);
        element = getVisibleElement(elements);
        return getElementChildren(element, "//" + type + "[" + elementxSequence + "]");
    }

    public List<WebElement> getElementsUnderColumnNameNoException(String columnName, int rowNumber, int colCount, String type,
                                                                  long timeOut) throws Exception
    {
        elements = getElementCell(columnName, rowNumber, colCount, false, false, false, true, timeOut);
        return getElementChildrenNoException(elements, "//" + type);
    }

    // for 2 tables with same column name, PJ uses commonly
    public List<WebElement> getElementsUnderColumnNameNoException(String columnName, int order, int rowNumber, int colCount, String type,
                                                                  long timeOut) throws Exception
    {
        elements = getElementCell(columnName, order, rowNumber, colCount, false, false, false, true, timeOut);
        return getElementChildrenNoException(elements, "//" + type);
    }

    public List<WebElement> getElementsUnderColumnName(String tableName, String columnName, int rowNumber, int colCount, String type,
                                                       long timeOut) throws Exception
    {
        if (empty(tableName))
            elements = getElementCell(columnName, rowNumber, colCount, false, false, false, true, timeOut);
        else
            elements = getElementCell(tableName, columnName, rowNumber, colCount, false, false, false, timeOut);
        element = getVisibleElement(elements);
        return getElementChildren(element, "//" + type);
    }

    public List<WebElement> getElementsUnderColumnNameNoException(String tableName, String columnName, int rowNumber, int colCount, String type,
                                                                  long timeOut) throws Exception
    {
        if (empty(tableName))
            elements = getElementCell(columnName, rowNumber, colCount, false, false, false, true, timeOut);
        else
            elements = getElementCell(tableName, columnName, rowNumber, colCount, false, false, false, timeOut);
        return getElementChildrenNoException(elements, "//" + type);
    }

    public List<WebElement> getAllRowsInTable(String columnName) throws Exception
    {
        return getElementCell(columnName, 0, 0, false, false, true, true, 1);// get tdcount = true
    }

    // find the input in the same row with the header column
    public List<WebElement> getElementsInColumnHeader(String columnName, int colCount, String type) throws Exception
    {
        elements = getElementCell(columnName, 0, colCount, false, true, false, true, 1);
        element = getVisibleElement(elements);
        return getElementChildren(element, "//" + type);
    }

    public WebElement getElementsInColumnHeader(String columnName, int colCount, String type, int order) throws Exception
    {
        elements = getElementCell(columnName, 0, colCount, false, true, false, true, 1);
        element = getVisibleElement(elements);
        return getElementChildren(element, "//" + type).get(order - 1);
    }

    public List<WebElement> getEntireColumnUnderColumnName(String columnName, int colCount, String type) throws Exception
    {
        elements = getElementCell(columnName, 0, colCount, true, false, false, true, 1);
        if (type.equals(""))
            return elements;
        else
        {
            element = getVisibleElement(elements);
            return getElementChildren(element, "//" + type);
        }
    }

    public List<WebElement> getEntireColumnUnderColumnNameNoException(String columnName, int colCount, String type) throws Exception
    {
        elements = getElementCell(columnName, 0, colCount, true, false, false, true, 1);
        if (type.equals(""))
            return elements;
        else
        {
            element = getVisibleElement(elements);
            return getElementChildrenNoException(elements, "//" + type);
        }
    }

    public List<WebElement> getElementCellSameColumn(String columnName, int colCount, String type) throws Exception
    {
        String tdCount = "";
        if (colCount == 0)
            tdCount = "count(//*[text()=\"" + columnName + "\"]/ancestor::th/preceding-sibling::th)+1";
        else
            tdCount = colCount + "";
        String xPath = "//*[text()=\"" + columnName + "\"]/ancestor::tr//th[" + tdCount + "]//" + type + "[1]";
        elements = getElements(xPath, 10);
        if (elements == null)
            return null;
        if (notNull(elements))
            return elements;
        else
            return null;
    }

    /**
     * columnNo is counted from flagColumn to presentColumn author nancy
     *
     * @throws Exception
     */
    // takes column no as td[count]
    public WebElement getElementInFronOfElementByColumnPosition(String flagColumnName, String type, int columnNo) throws Exception
    {
        String xPath = "//*[text()=\"" + flagColumnName + "\"]/ancestor-or-self::th/preceding-sibling::th[" + columnNo + "]//" + type;
        return getElement(xPath, 10);
    }

    public WebElement getElementNextToElementByColumnPosition1(String flagColumnName, String type, int columnNo) throws Exception
    {
        String xPath = "//*[text()=\"" + flagColumnName + "\"]/ancestor-or-self::td/following-sibling::td[" + columnNo + "]//" + type;
        return getElement(xPath, 10);
    }

    // get last cell of the last column of a row
    // for selecting the whole row by checkbox
    public WebElement getLastElementUnderColumnName(String columnName, int rowNumber, String type) throws Exception
    {
        String xPath = "//*[text()=\"" + columnName + "\"]/ancestor-or-self::th/parent::tr/ancestor::thead/following-sibling::tbody/tr[" + rowNumber + "]/td[last()]";
        element = getElement(xPath, 10);
        if (element != null)
            return getElementChildren(element, "//" + type).get(0);
        return null;
    }

    /**
     * @param labelText The label before the element to get the input type
     * @return <b>radio</b> Radio button<br>
     * <b>text</b> Text field or text area<br>
     * <b>combo</b> Drop down box<br>
     * <b>icon</b> Search icon
     * @Deprecated This method is renamed to getInputType(String) and should no
     * longer be used.
     */
    @Deprecated
    public String checkElementsNextToElement(String labelText)
    {
        try
        {
            return getInputType(labelText);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Get the type of an input element: Radio, TextBox, DropDownOption,
     * SearchIcon Old name: checkElementsNextToElement(String)
     *
     * @param labelText The label before the element to get the input type
     * @return <b>radio</b> Radio button<br>
     * <b>text</b> Text field or text area<br>
     * <b>combo</b> Drop down box<br>
     * <b>icon</b> Search icon
     * @throws Exception
     */
    public String getInputType(String labelText) throws Exception
    {
        String xPath = "";
        labelText = labelText.trim();
        if (labelText.contains("\""))
            xPath = "(//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.RADIO + ")[1] | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.TEXTBOX + ")[1] | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.DROPDOWNOPTION + ")[1] | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.SEARCHICON + ")[1]";
        else
            xPath = "(//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.RADIO + ")[1] | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.TEXTBOX + ")[1] | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.DROPDOWNOPTION + ")[1] | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.SEARCHICON + ")[1]";
        element = getElement(xPath, 10);
        if (element != null)
        {
            String type = "";
            try
            {
                type = element.getAttribute("type");
                // boolean y = type.equals("text");
                if (type.equals("text") || type.equals("radio"))
                    return type;// text - radio
                else
                {
                    type = element.getAttribute("class");// icon - combo
                    if (type.equals("icon") || type.equals("combo"))
                        return type;
                }
            } catch (NullPointerException e)
            {
                type = "";
            }
        }
        else
            return "";
        return "";
    }

    /**
     * Get the Element type of an input element.
     *
     * @param labelText The label before the element to get the input type
     * @return ElementID.RADIO Radio button<br>
     * ElementID.TEXTBOX Text field or text area<br>
     * ElementID.DROPDOWNOPTION Drop down option box<br>
     * ElementID.SEARCHICON Search icon
     * @throws Exception
     */
    public String getInputElementType(String labelText) throws Exception
    {
        String type = getInputType(labelText);
        switch (type)
        {
            case "text":
                return ElementID.TEXTBOX;
            case "radio":
                return ElementID.RADIO;
            case "icon":
                return ElementID.SEARCHICON;
            case "combo":
                return ElementID.DROPDOWNOPTION;
            default:
                return "";
        }
    }

    /**
     * Get the status enabled or disabled/read only of an input element: Radio,
     * TextBox, DropDownOption, SearchIcon
     *
     * @param labelText The label before the element to get the input type
     * @return True if the input can be inputed (default) <br>
     * False if the input is disabled or read only
     * @throws Exception
     * @author Jack
     */
    public Boolean isInputEnabled(String labelText) throws Exception
    {
        String xPath = "";
        labelText = labelText.trim();
        if (labelText.contains("\""))
            xPath = "(//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.RADIO + ")[1]" + " | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.TEXTBOX + ")[1]" + " | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.DROPDOWNOPTION + ")[1]" + " | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + ElementID.SEARCHICON + ")[1]";
        else
            xPath = "(//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.RADIO + ")[1]" + " | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.TEXTBOX + ")[1]" + " | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.DROPDOWNOPTION + ")[1]" + " | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + ElementID.SEARCHICON + ")[1]";
        element = getElement(xPath, 10);
        try
        {
            if (!isEnable(element))
                return false;
        } catch (Exception e)
        {
            return true;
        }
        return true;
    }

    public boolean isCheckboxChecked(String labelText)
    {
        try
        {
            elements = getElementsInFrontOfElement(labelText, ElementID.CHECKBOX);
            if (notNull(elements))
            {
                if (isChecked(elements.get(0)))
                    return true;
                else
                    return false;
            }
        } catch (Exception e)
        {
            return false;
        }
        return false;
    }

    public boolean isCheckboxChecked(String labelText, int order)
    {
        try
        {
            elements = getElementsNextToElement(labelText, ElementID.CHECKBOX, order);
            if (notNull(elements))
            {
                if (isChecked(elements.get(0)))
                    return true;
                else
                    return false;
            }
        } catch (Exception e)
        {
            return false;
        }
        return false;
    }

    // get an element, eg: a textbox or a button next to a label text
    public List<WebElement> getElementsNextToElement(String labelText, String type) throws Exception
    {
        return getElementsNextToElement(labelText, type, 1);
    }

    // TH6 Exclusive
    // get an element, eg: a textbox or a button next to a label text
    public List<WebElement> getElementsNextToElement(String labelText, String type, boolean waitToShow) throws Exception
    {
        return getElementsNextToElement(labelText, type, 1, waitToShow);
    }

    public List<WebElement> getElementsInTheSameCell(String labelText, String type) throws Exception
    {
        return getElementsInTheSameCell(labelText, type, 1);
    }

    public List<WebElement> getElementsNextToElement(String labelText, String type, int order) throws Exception
    {
        return getElementsNextToElement(labelText, type, order, true);
    }

    public List<WebElement> getElementsNextToElement(String labelText, String type, int order, boolean waitToShow) throws Exception
    {
        String xPath = "";
        // also search for element in mainPanel for screens in Project module
        String orderS = "";
        if (order >= 999)
            orderS = "last()";
        else
            orderS = order + "";
        if (labelText.contains("\""))
            xPath = "((//text()[normalize-space() = '" + labelText + "'] | //*[text()='" + labelText + "'])/ancestor-or-self::td/following-sibling::td//" + type + ")[" + orderS + "] | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + type + ")[" + orderS + "]";
        else
            xPath = "((//text()[normalize-space() = \"" + labelText + "\"] | //*[text()=\"" + labelText + "\"])/ancestor-or-self::td/following-sibling::td//" + type + ")[" + orderS + "] | (//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + type + ")[" + orderS + "]";
        return getElements(xPath, 10, waitToShow);
    }

    // for setting Employee Payroll Category in Global Employee and popup panel
    public List<WebElement> getElementsNextToElementInDiv(String divName, String labelText, String type, int order,
                                                          boolean waitToShow) throws Exception
    {
        String xPath = "";
        // also search for element in mainPanel for screens in Project module
        String orderS = "";
        if (order >= 999)
            orderS = "last()";
        else
            orderS = order + "";
        if (labelText.contains("\""))
            xPath = "(//div[contains(text(), '" + divName + "')]//ancestor::tr//following-sibling::tr//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//" + type + ")[" + orderS + "]";
        else
            xPath = "(//div[contains(text(), \"" + divName + "\")]//ancestor::tr//following-sibling::tr//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + type + ")[" + orderS + "]";
        return getElements(xPath, 10, waitToShow);
    }

    // click remark in the same cell at label text
    public List<WebElement> getElementsInTheSameCell(String labelText, String type, int order) throws Exception
    {
        String xPath = "";
        if (labelText.contains("\""))
            xPath = "(//*[@id=\"mainPanel\"]//*[text()='" + labelText + "']/ancestor-or-self::td//" + type + ")[" + order + "]";
        else
            xPath = "(//*[@id=\"mainPanel\"]//*[text()=\"" + labelText + "\"]/ancestor-or-self::td//" + type + ")[" + order + "]";
        return getElements(xPath, 10);
    }

    // get an element, eg: a checkbox before to a label text
    public List<WebElement> getElementsInFrontOfElement(String labelText, String type) throws Exception
    {
        String xPath = "(//*[@id=\"mainPanel\"]//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/preceding-sibling::td//" + type + ")[last()]" + " | (//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//" + type + ")[1]";
        return getElements(xPath, 10);
    }

    // ------------------------Element Actions------------------------//
    long sleepTimeCellText = 1;

    /**
     * @param columnName
     * @param rowNumber
     * @param value
     */
    @Step("Row {1}: Input value {2} into {0}")
    public void setTextAtTableCell(String columnName, int rowNumber, String value)
    {
        try
        {
            if (notEmpty(value) && rowNumber > 0)
            {
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.TEXTBOX, 10).get(0);
                waitForElementToBeInputtable(element, 1);// handle textbox when
                // disable or readonly
                // element = getElementsUnderColumnName(columnName,0,ElementID.TEXTBOX,10).get(0);//slowdown
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            }
        } catch (Exception e)
        {
            report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
        }
    }

    /**
     * Use when xpath cannot get the correct column count
     *
     * @param columnName name of the column
     * @param colCount   order of column in the table
     * @param rowNumber  order of the row in the table
     * @param value      text value to input
     * @author Levin
     */
    @Step("Row {2}: Input value {3} into {0}")
    public void setTextAtTableCell(String columnName, int colCount, int rowNumber, String value)
    {
        try
        {
            if (notEmpty(value) && rowNumber > 0)
            {
                element = getElementsUnderColumnName(columnName, rowNumber, colCount, ElementID.TEXTBOX, 10).get(0);
                waitForElementToBeInputtable(element, 1);// handle textbox when
                // disable or readonly
                // element = getElementsUnderColumnName(columnName,0,ElementID.TEXTBOX,10).get(0);//slowdown
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            }
        } catch (Exception e)
        {
            report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
        }
    }

    public String getTextAtTableCell(String columnName, int colCount, int rowNumber)
    {
        try
        {
            if (notEmpty(columnName) && rowNumber > 0)
            {
                element = getElementsUnderColumnName(columnName, rowNumber, colCount, ElementID.TEXTBOX, 10).get(0);
                waitForElementToBeInputtable(element, 1);// handle textbox when
                // disable or readonly
                // element = getElementsUnderColumnName(columnName,0,ElementID.TEXTBOX,10).get(0);//slowdown
                if (element != null)
                {
                    return getText(element);
                }
            }
        } catch (Exception e)
        {
            return "";
        }
        return "";
    }

    public String getTextAtTableCell(String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.TEXTBOX, 10).get(0);
            waitForElementToBeInputtable(element, 1);// handle textbox when
            // disable or readonly
            // element = getElementsUnderColumnName(columnName,rowNumber,0,ElementID.TEXTBOX,10).get(0);//slowdown
            if (element != null)
                return getText(element);
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
        return "";
    }

    /**
     * @param columnName
     * @param rowNumber
     * @param value
     */
    @Step("Row {1}: Input value {2} into {0}")
    public void setTextAtTableCell(String columnName, int rowNumber, String value, Boolean waitForDesc)
    {
        try
        {
            if (notEmpty(value))
            {
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.TEXTBOX, 10).get(0);
                waitForElementToBeInputtable(element, 1);// handle textbox when
                // disable or readonly
                // element = getElementsUnderColumnName(columnName,rowNumber,0,ElementID.TEXTBOX,10).get(0);//slowdown
                if (element != null)
                    setTextAtElement(element, value, sleepTimeCellText);
                else
                    // disable or readonly
                    // element = getElementsUnderColumnName(columnName,rowNumber,0,ElementID.TEXTBOX,10).get(0);//slowdown
                    if (element != null)
                        setTextAtElement(element, value, sleepTimeCellText);
                    else
                        throw new Exception();
                if (waitForDesc)
                {
                    WebElement ele = getElementsUnderColumnName(columnName, rowNumber, 0,
                                                                "span[contains(translate(@id, 'DESC', 'desc'),'desc')" + "  or contains(translate(@id, 'NAME', 'name')" + ",'name')  or contains(translate(@class, " + "'DESC', 'desc'),'desc')  or contains" + "(translate(@class, 'NAME', 'name'),'name')" + "][not(*)]",
                                                                5).get(0);
                    waitForElementToShow(ele, 10);
                }
                report("Input data into column:" + columnName + " at row:" + rowNumber, value, PASSED, element);
            }
        } catch (Exception e)
        {
            report("Input data into column:" + columnName + " at row:" + rowNumber, value, FAILED, element, e);
        }
    }

    // in case the column name duplicate with other text
    @Step("Row {2}: Input value {3} into {1}")
    public void setTextAtTableCell(int columnOrder, String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElementsUnderColumnName(columnName, columnOrder, rowNumber, 1, 0, ElementID.TEXTBOX, 10).get(0);
                waitForElementToBeInputtable(element, 1);// handle textbox when
                // disable or readonly
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    // use specially in Project Quotation, when there are 2 columns with the
    // same name
    @Step("Row {2}: Input value {4} into {0}")
    public void setTextAtTableCell(String columnName, int repeatedColOrder, int rowNumber, int textBoxSequence, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElementsUnderColumnName(columnName, repeatedColOrder, rowNumber, textBoxSequence, 0, ElementID.TEXTBOX, 10).get(0);
                waitForElementToBeInputtable(element, 1);// handle textbox when
                // disable or readonly
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    @Step("Table {0} row {2}: Input value {3} into {1}")
    public void setTextAtTableCell(String tableName, String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.TEXTBOX, 10).get(0);
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into table: " + tableName + " at column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into table: " + tableName + " at column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    public String getTextAtTableCell(String tableName, String columnName, int rowNumber)
    {
        if (notEmpty(columnName))
        {
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.TEXTBOX, 10).get(0);
                if (element != null)
                {
                    return getText(element);
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    // set text at textbox by column name with table name, in case there are
    // more than 1 textboxes

    @Step("Row {1}: Input value {2} into {0}")
    public void setTextAtTableCell(String columnName, int rowNumber, String value, int order)
    {
        if (notEmpty(value))
        {
            try
            {
                elements = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.TEXTBOX, order);
                if (notNull(elements))
                {
                    element = elements.get(order - 1);
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    // set text at textbox by column name with table name, in case there are
    // more than 1 textboxes
    @Step("Table {0} row {2}: Input value {3} into {1}")
    public void setTextAtTableCell(String tableName, String columnName, int rowNumber, String value, int order)
    {
        if (notEmpty(value))
        {
            try
            {
                elements = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.TEXTBOX, order);
                if (notNull(elements))
                {
                    element = elements.get(order - 1);
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input data into table: " + tableName + " at column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into table: " + tableName + " at column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    public String getTextAtTableCell(String tableName, String columnName, int rowNumber, int order)
    {
        if (notEmpty(columnName))
        {
            try
            {
                elements = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.TEXTBOX, order);
                if (notNull(elements))
                {
                    return getText(elements.get(order - 1));
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    @Step("Row {1}: Input value {2} into {0}")
    public void setTextAreaAtTableCell(String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.TEXTAREA, 10).get(0);
                if (waitForElementToBeInputtable(element, 1))
                    // handle textbox when disable or readonly
                    element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.TEXTBOX, 10).get(0);
                if (element != null)
                {
                    setTextAreaAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    @Step("Table {0} row {2}: Input value {3} into {1}")
    public void setTextAreaAtTableCell(String tableName, String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.TEXTAREA, 10).get(0);
                if (element != null)
                {
                    setTextAreaAtElement(element, value, sleepTimeCellText);
                    report("Input data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }

    }

    @Step("Choose {0} = {2} at row {1}")
    public void setDropDownOptionAtTableCell(String columnName, int rowNumber, String optionValue)
    {
        if (notEmpty(optionValue))
        {
            try
            {
                optionValue = optionValue.trim();
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.OPTION + "[contains(text(), \"" + optionValue + "\")]",
                                                     10).get(0);
                if (element != null)
                {
                    clickAtElement(element, sleepTimeCellText);
                    report("Set dropdown option: " + columnName + "[" + rowNumber + "]" + ":", optionValue, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Set dropdown option: " + columnName + "[" + rowNumber + "]" + ":", optionValue, FAILED, element, e);
            }
        }
    }

    public String getDropDownOptionAtTableCell(String columnName, int rowNumber)
    {
        if (notEmpty(columnName))
        {
            try
            {
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.OPTION + "[@selected]", 10).get(0);
                if (element != null)
                {
                    return getText(element);
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    @Step("Choose {1} = {3} at row {2} in table {0}")
    public void setDropDownOptionAtTableCell(String tableName, String columnName, int rowNumber, String optionValue)
    {
        if (notEmpty(optionValue))
        {
            try
            {
                optionValue = optionValue.trim();
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0,
                                                     ElementID.OPTION + "[contains(text(), \"" + optionValue + "\")]", 10).get(0);
                if (element != null)
                {
                    clickAtElement(element, sleepTimeCellText);
                    report("Set dropdown option in table: " + tableName + " Column: " + columnName + "[" + rowNumber + "]" + ":", optionValue, PASSED,
                           element);
                }
            } catch (Exception e)
            {
                report("Set dropdown option in table: " + tableName + " Column: " + columnName + "[" + rowNumber + "]" + ":", optionValue, FAILED,
                       element, e);
            }
        }
    }

    public String getDropDownOptionAtTableCell(String tableName, String columnName, int rowNumber)
    {
        if (notEmpty(columnName))
        {
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.OPTION + "[@selected]", 10).get(0);
                if (element != null)
                {
                    return getText(element);
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    @Step("Choose {0} = {2} at row {1}")
    public void setRadioOptionAtTableCell(String columnName, int rowNumber, String checkValue)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                checkValue = checkValue.trim();
                if (checkValue.equalsIgnoreCase("Y"))
                    checkValue = "Yes";
                if (checkValue.equalsIgnoreCase("N"))
                    checkValue = "No";
                element = getElementsUnderColumnName(columnName, rowNumber, 0,
                                                     "label[text()='" + checkValue + "']/preceding-sibling::" + ElementID.RADIO, 10).get(0);
                if (element != null)
                {
                    clickAtElement(element, sleepTimeCellText);
                    report("Set radio option: " + columnName + "[" + rowNumber + "]" + ":", checkValue, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Set radio option: " + columnName + "[" + rowNumber + "]" + ":", checkValue, FAILED, element, e);
            }
        }
    }

    public boolean isRadioOptionAtTableCellChecked(String columnName, int rowNumber, String checkValue)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                checkValue = checkValue.trim();
                if (checkValue.equalsIgnoreCase("Y"))
                    checkValue = "Yes";
                if (checkValue.equalsIgnoreCase("N"))
                    checkValue = "No";
                element = getElementsUnderColumnName(columnName, rowNumber, 0,
                                                     "label[text()='" + checkValue + "']/preceding-sibling::" + ElementID.RADIO, 10).get(0);
                if (element != null)
                {
                    return isChecked(element);
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return true;
    }

    // set all check box in the column
    @Step("Choose all value in {0}: {1}")
    public void setCheckboxOptionAtTableCell_All(String columnName, String checkValue)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                checkValue = checkValue.trim();
                if (checkValue.equalsIgnoreCase("Y"))
                    checkValue = "Yes";
                if (checkValue.equalsIgnoreCase("N"))
                    checkValue = "No";
                elements = getEntireColumnUnderColumnName(columnName, 0, ElementID.CHECKBOX);
                if (notNull(elements))
                {
                    for (WebElement ele : elements)
                        clickAtElement(ele, 0.5);
                    report("Set  option: " + columnName + ":", checkValue, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Set radio option: " + columnName + ":", checkValue, FAILED, element, e);
            }
        }
    }

    public boolean isCheckboxOptionAtTableCell_AllChecked(String columnName)
    {
        if (notEmpty(columnName))
        {
            List<Boolean> allChecked = new ArrayList<>();
            allChecked.clear();
            try
            {
                elements = getEntireColumnUnderColumnName(columnName, 0, ElementID.CHECKBOX);
                if (notNull(elements))
                {
                    for (WebElement ele : elements)
                        allChecked.add(isChecked(ele));

                    for (boolean a : allChecked)
                        if (!a)
                            return false;

                    return true;
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return false;
    }

    @Step("Set checkbox option = {1} in header column {0}")
    public void setCheckboxHeader(String flagColumnName, String checkValue, int countColumnNumber)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                element = getElementInFronOfElementByColumnPosition(flagColumnName, ElementID.CHECKBOX, countColumnNumber);
                if (element != null)
                {
                    setCheckbox(element, checkValue, 0.5);
                    report("Option check at column: " + flagColumnName, checkValue, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Option check at column: " + flagColumnName, checkValue, FAILED, element, e);
            }
        }
    }

    /**
     * listRowNumber: is list row of value need set checkbox.
     *
     * @author nancy
     */
    @Step("Set checkbox option = {2} in row {1} of column {0}")
    public void setCheckboxTableCell(String columnName, String listRowNumber, String checkboxValue)
    {
        if (listRowNumber.trim().toUpperCase().equals("ALL"))
            setCheckBoxTableFilter("Tag", checkboxValue);
        else if (notEmpty(listRowNumber))
        {
            String[] strs = listRowNumber.split(", ");
            try
            {
                for (int i = 0; i < strs.length; i++)
                {
                    int rowNumber = Integer.parseInt(strs[i]);
                    setCheckBoxAtTableCell(columnName, rowNumber, checkboxValue);
                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    @Step("Set checkbox option = {2} in row {1} of column {0}")
    public void setCheckBoxAtTableCell(String columnName, int rowNumber, String checkboxValue)
    {
        if (notEmpty(checkboxValue))
        {
            try
            {
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.CHECKBOX, 10).get(0);
                if (element != null)
                {
                    setCheckbox(element, checkboxValue, sleepTimeCellText);
                    report("Option check at column: " + columnName + " at row: " + rowNumber, checkboxValue, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Option check at column: " + columnName + " at row: " + rowNumber, checkboxValue, FAILED, element, e);
            }
        }
    }

    public boolean isCheckBoxAtTableCellChecked(String columnName, int rowNumber)
    {
        if (notEmpty(columnName))
        {
            try
            {
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.CHECKBOX, 10).get(0);
                if (element != null)
                {
                    return isChecked(element);
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return false;
    }

    @Step("Set checkbox option = {3} in row {2} of column {1} in table {0}")
    public void setCheckBoxAtTableCell(String tableName, String columnName, int rowNumber, String checkboxValue)
    {
        if (notEmpty(checkboxValue))
        {
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.CHECKBOX, 10).get(0);
                if (element != null)
                {
                    setCheckbox(element, checkboxValue, sleepTimeCellText);
                    report("Option check at table: " + tableName + " at column: " + columnName + " at row: " + rowNumber, checkboxValue, PASSED,
                           element);
                }
            } catch (Exception e)
            {
                report("Option check at table: " + tableName + " at column: " + columnName + " at row: " + rowNumber, checkboxValue, FAILED, element,
                       e);
            }
        }
    }

    public boolean isCheckBoxAtTableCellChecked(String tableName, String columnName, int rowNumber)
    {
        if (notEmpty(columnName))
        {
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.CHECKBOX, 10).get(0);
                if (element != null)
                {
                    return isChecked(element);
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return true;
    }

    @Step("Click info button under {0}, line {1}")
    public void clickInfoAtTableCell(String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.INFO_ICON, 10).get(0);
            if (element != null)
            {
                clickAtElement(element, sleepTimeCellText);
                report("Click info in column: " + columnName + " at row: " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click info in column: " + columnName + " at row: " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Click info button in {0} under {1}, line {2}")
    public void clickInfoAtTableCell(String tableName, String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.INFO_ICON, 10).get(0);
            if (element != null)
            {
                clickAtElement(element, sleepTimeCellText);
                report("Click info in column: " + columnName + " at row: " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click info in column: " + columnName + " at row: " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Click search under {0}, line {1}")
    public void clickSearchAtTableCell(String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.SEARCHICON, 10).get(0);
            if (element != null)
            {
                clickAtElement(element, sleepTimeCellText);
                report("Click search in column: " + columnName + " at row: " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click search in column: " + columnName + " at row: " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Click search button in {0} under {1}, line {2}")
    public void clickSearchAtTableCell(String tableName, String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.SEARCHICON, 10).get(0);
            if (element != null)
            {
                clickAtElement(element, sleepTimeCellText);
                report("Click info in column: " + columnName + " at row: " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click info in column: " + columnName + " at row: " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Click number icon under {0}, line {1}")
    public void clickNumberIconAtTableCell(String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.NUMBER_ICON, 10).get(0);
            if (element != null)
            {
                clickAtElement(element, sleepTimeCellText);
                report("Click number icon in column: " + columnName + " at row: " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click number icon in column: " + columnName + " at row: " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Click number icon in {0} under {1}, line {2}")
    public void clickNumberIconAtTableCell(String tableName, String columnName, int rowNumber)
    {
        try
        {
            element = getElementsUnderColumnName(tableName, columnName, rowNumber, 0, ElementID.NUMBER_ICON, 10).get(0);
            if (element != null)
            {
                clickAtElement(element, sleepTimeCellText);
                report("Click info in column: " + columnName + " at row: " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click info in column: " + columnName + " at row: " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Set remark {0} = {2} at row {1}")
    public void setRemarkAtTableCell(String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                value = value.trim();
                element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.REMARK_ICON, 10).get(0);
                if (element != null)
                {
                    waitForElementToBeClickable(element, 3);
                    element = getElementsUnderColumnName(columnName, rowNumber, 0, ElementID.REMARK_ICON, 10).get(0);
                    clickAtElement(element, sleepTimeCellText);
                    waitForElementToShow("//*[@id = 'remarksModalPanelHeader']", 3);
                    // waitForAjax(1);
                    // set text at Remarks textarea
                    setTextAtXpathCSSNoEnter("(//*/ancestor::table[last()])[last()]/tbody//textarea", value);
                    print("Set text: " + columnName + " - " + value);
                    if (checkElementVisible("(//*[@value='Close'])[last()]"))
                        clickButton("Close");
                    else
                        clickButton("Ok");
                    waitForAjax(2);
                    report("Input remarks into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input remarks into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    @Step("Set remark {0} = {3} at row {1}")
    public void setRemarkAtTableCell(String columnName, int rowNumber, int columnNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                value = value.trim();
                element = getElementsUnderColumnName(columnName, rowNumber, columnNumber, ElementID.REMARK_ICON, 10).get(0);
                if (element != null)
                {
                    clickAtElement(element, sleepTimeCellText);
                    waitForElementToShow("//*[@id = 'remarksModalPanelHeader']", 10);
                    // set text at Remarks textarea
                    setTextAtXpathCSSNoEnter("(//*/ancestor::table[last()])[last()]/tbody//textarea", value);
                    print("Set text " + columnName + " - " + value);
                    clickButton("Ok");
                    waitForAjax(5);
                    report("Input remarks into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input remarks into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    // table in Allocation details
    @Step("Row {1}: Input allocation value {2} into {0}")
    public void setTextAtAllocationTableCell(String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                String s[] = ReadBean.split(columnName, " ");
                String columnHeader = "//*[text()=\"" + columnName + "\"] | //*[starts-with(text(), \"" + columnName + "\")] | //*[text()=\"" + s[0] + " " + s[1] + "\"]";
                String xPath = "(" + columnHeader + ")/ancestor::table/following-sibling::table//tr[" + rowNumber + "]/td[count((" + columnHeader + ")/ancestor-or-self::td/preceding-sibling::td)+1]//" + ElementID.TEXTBOX + " | (" + columnHeader + ")/ancestor::table[1]/tbody/tr[" + rowNumber + "]/td[count((" + columnHeader + ")/ancestor-or-self::th/preceding-sibling::th)+1]//" + ElementID.TEXTBOX;
                element = getElement(xPath, 10);

                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Input allocation data into column: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input allocation data into column: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    // input searchValue at search textbox then select first row
    public void getSearchResult(String searchName, String searchValue, String columnName)
    {
        setText(searchName, searchValue);
        clickButton("Search");
        selectFirstRow(columnName);
    }

    @Step("Select first result of {0}")
    public void selectFirstRow(String columnName)
    {
        selectRow(columnName, 1);
    }

    @Step("Select {0}: {1}")
    public void selectRow(String columnName, String rowValue)
    {
        int rowNumber = getRowNumber(columnName, rowValue);
        selectRow(columnName, rowNumber);
    }

    @Step("Select result number {1} of {0}")
    public void selectRow(String columnName, int rowNumber)
    {
        try
        {
            elements = getElementsUnderColumnNameNoException(columnName, rowNumber, 0, ElementID.LINK, 3);
            if (notNull(elements))
            {
                for (WebElement ele : elements)
                {// may mistaken with same name column in another tab
                    if (checkElementVisible(ele))
                    {
                        String text = getText(ele);
                        clickAtElement(ele, 0.5);
                        report("Select record at column: " + columnName + " at row: " + rowNumber, text, PASSED, ele);
                        break;
                    }
                }
            }
            else
            {
                elements = getElementsUnderColumnNameNoException(columnName, rowNumber, 0, ElementID.VARIATION, 3);
                if (notNull(elements))
                {
                    for (WebElement ele : elements)
                    {// may mistaken with same name column in another tab
                        if (checkElementVisible(ele))
                        {
                            String text = getText(ele);
                            clickAtElement(ele, 0.5);
                            report("Select record at column: " + columnName + " at row: " + rowNumber, text, PASSED, ele);
                            break;
                        }
                    }
                }
                else
                {
                    elements = getElementsUnderColumnNameNoException(columnName, rowNumber, 0, ElementID.BUTTON, 3);
                    if (notNull(elements))
                    {
                        for (WebElement ele : elements)
                        {// may mistaken with same name column in another tab
                            if (checkElementVisible(ele))
                            {
                                String text = getText(ele);
                                clickAtElement(ele, 0.5);
                                report("Select record at column: " + columnName + " at row: " + rowNumber, text, PASSED, ele);
                            }
                        }
                    }
                    else
                    {
                        element = getElementNoException(ElementID.SEARCH_CLOSE_BUTTON, 1);
                        if (element != null)
                        {
                            String text = getText(element);
                            clickAtElement(element, 0.5);
                            report("Select record at column: " + columnName + " at row: " + rowNumber, text, PASSED, element);
                        }
                        else
                        {// Vincent: other , click on cell
                            elements = getElementsUnderColumnNameNoException(columnName, rowNumber, 0, ".", 3);
                            if (element != null)
                            {
                                String text = getText(element);
                                clickAtElement(element, 0.5);
                                report("Select record at column: " + columnName + " at row: " + rowNumber, text, PASSED, element);
                            }
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            report("Select record at column: " + columnName + " at row: " + rowNumber, "", FAILED, null, e);
        }
    }

    @Step("Filter column {0} = {1}")
    public void setTableFilter(String columnName, String value)
    {
        try
        {
            elements = getElementsInColumnHeader(columnName, 0, ElementID.TEXTBOX);
            if (notNull(elements))
            {
                for (WebElement ele : elements)
                {
                    if (checkElementVisible(ele))
                    {
                        setTextAtElement(ele, value, 1);
                        report("Filter record at column: " + columnName, value, PASSED, ele);
                        break;
                    }
                }
            }
        } catch (Exception e)
        {
            report("Filter record at column: " + columnName, value, FAILED, null, e);
        }
    }

    @Step("Filter column {0} = {1}")
    public void setTableFilter(String columnName, String value, int order)
    {
        try
        {
            element = getElementsInColumnHeader(columnName, 0, ElementID.TEXTBOX).get(order - 1);
            if (element != null)
            {
                setTextAtElement(element, value, 1);
                report("Filter record at column: " + columnName, value, PASSED, element);
            }
        } catch (Exception e)
        {
            report("Filter record at column: " + columnName, value, FAILED, element, e);
        }
    }

    /**
     * Set table filter where there exist a column which name is also a partial
     * of another column name
     *
     * @param colCount order of the columnn in table
     * @Author Levin
     */
    @Step("Filter column {0} = {1}")
    public void setTableFilter(String columnName, String value, int colCount, int order)
    {
        try
        {
            element = getElementsInColumnHeader(columnName, colCount, ElementID.TEXTBOX).get(order - 1);
            if (element != null)
            {
                setTextAtElement(element, value, 1);
                report("Filter record at column: " + columnName, value, PASSED, element);
            }
        } catch (Exception e)
        {
            report("Filter record at column: " + columnName, value, FAILED, element, e);
        }
    }

    @Step("Set checkbox option = {1} of column {0}")
    public void setCheckBoxTableFilter(String columnName, String value)
    {
        try
        {
            elements = getElementsInColumnHeader(columnName, 0, ElementID.CHECKBOX);
            if (notNull(elements))
            {
                for (WebElement ele : elements)
                {
                    if (checkElementVisible(ele))
                    {
                        setCheckbox(ele, value, 3);
                        report("Option check at filter: " + columnName, value, PASSED, ele);
                        break;
                    }
                }
            }
        } catch (Exception e)
        {
            report("Option check at filter: " + columnName, value, FAILED, null, e);
        }
    }

    // set text into textbox or textarea next to a label
    @Step("Open calendar")
    public void openCalendar(String labelText)
    {
        try
        {
            elements = getElementsNextToElement(labelText, ElementID.CALENDAR_BUTTON);
            if (notNull(elements))
            {
                clickAtElement(elements.get(0), 0.5);
                report("Open calendar: " + labelText, "", PASSED, elements.get(0));
            }
        } catch (Exception e)
        {
            report("Open calendar: " + labelText, "", FAILED, elements.get(0), e);
        }
    }

    @Step("Set calendar date: {0}")
    public void setCalendarDate(String ddMMyyyy)
    {// dd//MM/yyyy
        if (notEmpty(ddMMyyyy))
        {
            String day = ReadBean.split(ddMMyyyy, "/")[0];
            String month = ReadBean.split(ddMMyyyy, "/")[1];
            String year = ReadBean.split(ddMMyyyy, "/")[2];
            if (Integer.parseInt(month) == 1)
                month = "Jan";
            else if (Integer.parseInt(month) == 2)
                month = "Feb";
            else if (Integer.parseInt(month) == 3)
                month = "Mar";
            else if (Integer.parseInt(month) == 4)
                month = "Apr";
            else if (Integer.parseInt(month) == 5)
                month = "May";
            else if (Integer.parseInt(month) == 6)
                month = "Jun";
            else if (Integer.parseInt(month) == 7)
                month = "Jul";
            else if (Integer.parseInt(month) == 8)
                month = "Aug";
            else if (Integer.parseInt(month) == 9)
                month = "Sep";
            else if (Integer.parseInt(month) == 10)
                month = "Oct";
            else if (Integer.parseInt(month) == 11)
                month = "Nov";
            else if (Integer.parseInt(month) == 12)
                month = "Dec";
            try
            {
                clickAtXpathCSS(ElementID.CALENDAR_MONTH_BUTTON);
                element = getElementNoException(ElementID.CALENDAR_EDITOR_BUTTON + "[text()='" + month + "']", 1);
                // click at Year
                if (element != null)
                    clickAtElement(element, 0.5);
                // if not found that means the button has already been selected,
                // proceed
                element = getElementNoException(ElementID.CALENDAR_EDITOR_BUTTON + "[text()='" + year + "']", 1);
                // click at Year
                if (element != null)
                    clickAtElement(element, 0.5);

                    // if not found that means the button has already been selected,
                    // proceed
                else
                {
                    if (Integer.parseInt(year) > Calendar.getInstance().get(Calendar.YEAR))
                    {// if the desired year is larger than the year in the list, proceed to next year tab
                        WebElement elementTemp = getElement(ElementID.CALENDAR_EDITOR_BUTTON + "[text()='>']", 1);
                        while (true)
                        {
                            clickAtElement(elementTemp, 0.5);
                            element = getElementNoException(ElementID.CALENDAR_EDITOR_BUTTON + "[text()='" + year + "']", 1);
                            if (element != null)
                            {
                                clickAtElement(element, 0.5);
                                break;
                            }
                        }
                    }
                    else if (Integer.parseInt(year) < Calendar.getInstance().get(Calendar.YEAR))
                    {
                        WebElement elementTemp = getElement(ElementID.CALENDAR_EDITOR_BUTTON + "[text()='<']", 1);
                        while (true)
                        {
                            clickAtElement(elementTemp, 0.5);
                            element = getElementNoException(ElementID.CALENDAR_EDITOR_BUTTON + "[text()='" + year + "']", 1);
                            if (element != null)
                            {
                                clickAtElement(element, 0.5);
                                break;
                            }
                        }
                    }
                }
                clickAtXpathCSS(ElementID.CALENDAR_OK_BUTTON);// choose day next
                int dayI = Integer.parseInt(day);
                // check if day has already been selected
                element = getElementNoException(
                        "//td[text()='" + dayI + "'][@class='rich-calendar-cell-size rich-calendar-cell " + "rich-calendar-select' " + "or @class='rich-calendar-cell-size rich-calendar-cell " + "rich-calendar-today rich-calendar-select']",
                        // Vincent: update for more case
                        1);
                if (element != null)
                    clickAtXpathCSS("//div[@class='rich-calendar-tool-btn'][text()='x']");
                else
                {
                    elements = getElements("//td[text()='" + dayI + "'][contains(@class, 'rich-calendar-cell-size')]", 1);
                    if (elements.size() == 1)
                        clickAtElement(elements.get(0), 0.5);
                    else
                    {
                        if (Integer.parseInt(day) < 20)
                            clickAtElement(elements.get(0), 0.5);
                        if (Integer.parseInt(day) > 20)
                            clickAtElement(elements.get(1), 0.5);
                    }
                }
                report("Input calendar date: ", day + "/" + month + "/" + year, PASSED);
            } catch (Exception e)
            {
                report("Input calendar date: ", day + "/" + month + "/" + year, FAILED, e);
            }
        }
    }

    // set text into textbox or textarea next to a label
    @Step("Input value {1} into {0}")
    public void setText(String labelText, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.TEXTBOX);
                if (notNull(elements))
                {
                    waitForElementToBeInputtable(elements.get(0), 1);
                    elements = getElementsNextToElement(labelText, ElementID.TEXTBOX);

                    for (WebElement ele : elements)
                    {// may mistaken with same name column in another tab
                        if (checkElementVisible(ele))
                        {
                            setTextAtElement(ele, value, 0.5);
                            report("Input data to field: " + labelText, value, PASSED, ele);
                            waitForMandatoryField(labelText, 3);// wait for page
                            break;
                        }
                        else
                        {
                            print("Element's unreachable: " + ele.getTagName());
                        }
                    }
                }
            } catch (Exception e)
            {
                report("Input data to field: " + labelText, value, FAILED, elements.get(0), e);
            }
        }
    }

    @Step("Input value {1} into {0}")
    public void setText(String labelText, String value, int order)
    {
        if (notEmpty(value))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.TEXTBOX, order);
                if (notNull(elements))
                {
                    waitForElementToBeInputtable(elements.get(0), 1);
                    elements = getElementsNextToElement(labelText, ElementID.TEXTBOX, order);

                    for (WebElement ele : elements)
                    {// may mistaken with same name column in another tab
                        if (checkElementVisible(ele))
                        {
                            setTextAtElement(ele, value, 0.5);
                            report("Input data to field: " + labelText, value, PASSED, ele);
                            waitForMandatoryField(labelText, 3);// wait for page
                            break;
                        }
                        else
                        {
                            print("Element's unreachable: " + ele.getTagName());
                        }
                    }
                }
            } catch (Exception e)
            {
                report("Input data to field: " + labelText, value, FAILED, elements.get(0), e);
            }
        }
    }

    public String getTextValue(String labelText, int order)
    {
        if (notEmpty(labelText))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.TEXTBOX, order);
                if (notNull(elements))
                {
                    waitForElementToBeInputtable(elements.get(0), 1);
                    elements = getElementsNextToElement(labelText, ElementID.TEXTBOX, order);

                    for (WebElement ele : elements)
                    {// may mistaken with same name column in another tab
                        if (checkElementVisible(ele))
                        {
                            return getText(ele);
                        }
                    }
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    public String getTextValueByXpathCss(String xPathCss)
    {
        if (notEmpty(xPathCss))
        {
            try
            {
                element = getElementNoException(xPathCss, 1);
                if (element != null)
                    return getText(element);
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    // for setting Employee Payroll Category in Global Employee and popup panel
    @Step("Input value {2} into {1} at {0}")
    public void setTextPopupPanel(String divName, String labelText, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                elements = getElementsNextToElementInDiv(divName, labelText, ElementID.TEXTBOX, 1, true);
                if (notNull(elements))
                {
                    if (waitForElementToBeInputtable(elements.get(0), 1))
                        elements = getElementsNextToElementInDiv(divName, labelText, ElementID.TEXTBOX, 1, true);
                    for (WebElement ele : elements)
                    {// may mistaken with same name column in another tab
                        if (checkElementVisible(ele))
                        {
                            setTextAtElement(ele, value, 0.5);
                            waitForMandatoryField(labelText, 3);
                            report("Input data to field: " + labelText, value, PASSED, ele);
                            break;
                        }
                    }
                }
            } catch (Exception e)
            {
                report("Input data to field: " + labelText, value, FAILED, elements.get(0), e);
            }
        }
    }

    public String getTextPopupPanel(String divName, String labelText)
    {
        if (notEmpty(labelText))
        {
            try
            {
                elements = getElementsNextToElementInDiv(divName, labelText, ElementID.TEXTBOX, 1, true);
                if (notNull(elements))
                {
                    if (waitForElementToBeInputtable(elements.get(0), 1))
                        elements = getElementsNextToElementInDiv(divName, labelText, ElementID.TEXTBOX, 1, true);
                    for (WebElement ele : elements)
                    {// may mistaken with same name column in another tab
                        if (checkElementVisible(ele))
                        {
                            return getText(ele);
                        }
                    }
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    @Step("Input value {1} into {0}")
    public void setText(String labelText, String value, boolean waitForDesc)
    {
        if (notEmpty(value))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.TEXTBOX);
                if (notNull(elements))
                {
                    if (waitForElementToBeInputtable(elements.get(0), 1))
                        elements = getElementsNextToElement(labelText, ElementID.TEXTBOX);
                    for (WebElement ele : elements)
                    {// may mistaken with same name
                        // column in another tab
                        if (checkElementVisible(ele))
                        {
                            setTextAtElement(ele, value, 0.5);
                            waitForMandatoryField(labelText, 3);
                            if (waitForDesc)
                                waitForTextDescToShow(labelText, 3);
                            report("Input data to field: " + labelText, value, PASSED, ele);
                            break;
                        }
                    }
                }
            } catch (Exception e)
            {
                report("Input data to field: " + labelText, value, FAILED, elements.get(0), e);
            }
        }
    }

    // set text into textbox or textarea inside a label

    /**
     * @param preLabelText The text before the textbox need to be inputed
     * @param value        The value to be set
     * @param order        The sequence of the textbox (if there is more than 1 text box
     * @author Jack
     */
    @Step("Input value {1} into {0}")
    public void setTextInside(String preLabelText, String value, int order)
    {
        String xPath;
        if (preLabelText.contains("\""))
            xPath = "(//*[@id='mainPanel']//*[text()='" + preLabelText + "']/ancestor-or-self::td//" + ElementID.TEXTBOX + ")[" + order + "]";
        else
            xPath = "(//*[@id=\"mainPanel\"]//*[text()=\"" + preLabelText + "\"]/ancestor-or-self::td//" + ElementID.TEXTBOX + ")[" + order + "]";
        try
        {
            element = getElement(xPath, 3);
            if (element != null)
            {
                if (waitForElementToBeInputtable(element, 1))
                    element = getElement(xPath, 3);
                if (checkElementVisible(element))
                {
                    setTextAtElement(element, value, 0.5);
                    waitForMandatoryField(preLabelText, 3);
                    waitForAjax(3);
                    report("Input data to field: " + preLabelText, value, PASSED, element);
                }
            }
        } catch (Exception e)
        {
            report("Input data to field: " + preLabelText, value, FAILED, element, e);
        }
    }

    @Step("Input value {1} into {0}")
    public void setTextArea(String labelText, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                value = value.trim();
                elements = getElementsNextToElement(labelText, ElementID.TEXTAREA);
                if (notNull(elements))
                {
                    waitForElementToBeClickable(elements.get(0), 10);// no enter key at textarea
                    // elements.get(0).click();
                    elements = getElementsNextToElement(labelText, ElementID.TEXTAREA);
                    elements.get(0).clear();
                    elements.get(0).sendKeys(value);
                    elements.get(0).sendKeys(Keys.TAB);

                    report("Input data to field: " + labelText, value, PASSED, elements.get(0));
                }
            } catch (Exception e)
            {
                report("Input data to field: " + labelText, value, FAILED, elements.get(0), e);
            }
        }
    }

    public String getTextArea(String labelText)
    {
        if (notEmpty(labelText))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.TEXTAREA);
                if (notNull(elements))
                {
                    return getText(elements.get(0));
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    /**
     * Set the text after a specific label. If the text label is not found, the
     * text will not be inputed. The text is limited inside main panel of the
     * page only
     *
     * @param labelText the label text
     * @param value     the text to be set
     * @author Levin, Jack
     */
    @Step("Input value {1} into {0}")
    public void setTextIfAvailable(String labelText, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                String xPath = "(//*[@id=\"mainPanel\"]//*[text()=\"" + labelText + "\"]/following::" + ElementID.TEXTBOX + ")[1]";
                element = getElementNoException(xPath, 3);
                if (element != null)
                {
                    waitForElementToBeInputtable(element, 1);
                    element = getElementNoException(xPath, 3);
                    setTextAtElement(element, value, 0.5);
                    waitForMandatoryField(labelText, 3);
                    report("Input data to text field: ", value, PASSED, element);
                }
            } catch (Exception e)
            {
                // no exception
            }
        }
    }

    /**
     * Set the text after a specific label. If the text label is not found, the
     * text will not be inputed. The text is limited inside main panel of the
     * page only
     *
     * @param labelText the label text
     * @param value     the text to be set
     * @author Levin, Jack
     */
    @Step("Input value {1} into {0}")
    public void setTextIfAvailable(String labelText, String value, Boolean waitForDecs)
    {
        if (notEmpty(value))
        {
            try
            {
                String xPath = "(//*[@id=\"mainPanel\"]//*[text()=\"" + labelText + "\"]/following::" + ElementID.TEXTBOX + ")[1]";
                element = getElementNoException(xPath, 3);
                if (element != null)
                {
                    if (waitForElementToBeInputtable(element, 1))
                        element = getElementNoException(xPath, 3);
                    setTextAtElement(element, value, 0.5);
                    waitForMandatoryField(labelText, 3);
                    if (waitForDecs)
                        waitForTextDescToShow(labelText, 3);
                    report("Input data to text field: ", value, PASSED, element);
                }
            } catch (Exception e)
            {
                // no exception
            }
        }
    }

    @Step("Input remark {0} = {1}")
    public void setRemark(String labelText, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                value = value.trim();
                elements = getElementsInTheSameCell(labelText, ElementID.REMARK_ICON);
                if (notNull(elements))
                {
                    clickAtElement(elements.get(0), 1);
                    setTextAtXpathCSSNoEnter("(//*/ancestor::table[last()])[last()]/tbody//textarea", value);
                    clickButton("Ok");
                    report("Input remark: " + labelText, value, PASSED, elements.get(0));
                }
            } catch (Exception e)
            {
                report("Input remark: " + labelText, value, PASSED, elements.get(0), e);
            }
        }
    }

    public void setRadioOption(WebElement element) throws Exception
    {
        if (!isChecked(element))
            clickAtElement(element, 1);
    }

    // for radio that have name eg: Active/Suspend
    @Step("Choose option: {0}")
    public void setRadioOption(String radioName)
    {
        if (notEmpty(radioName))
        {
            try
            {
                // String xPath = "(//label[text()=\"" + radioName + "\"]/parent::td//"
                // + ElementConstants.RADIO + ")[1]"; // old
                String xPath = "(//label[text()=\"" + radioName + "\"]/preceding-sibling::" + ElementID.RADIO + ")[1]";
                element = getElement(xPath, 10);
                setRadioOption(element);
                report("Select option: ", radioName, PASSED, element);
            } catch (Exception e)
            {
                report("Select option: ", radioName, FAILED, element, e);
            }
        }
    }

    public boolean isRadioOptionChecked(String radioName)
    {
        if (notEmpty(radioName))
        {
            try
            {
                // String xPath = "(//label[text()=\"" + radioName + "\"]/parent::td//"
                // + ElementConstants.RADIO + ")[1]"; // old
                String xPath = "(//label[text()=\"" + radioName + "\"]/preceding-sibling::" + ElementID.RADIO + ")[1]";
                element = getElement(xPath, 10);
                return isChecked(element);
            } catch (Exception e)
            {
                return false;
            }
        }
        return false;
    }

    // for radio that have name eg: Active/Suspend
    @Step("Choose option: {0}")
    public void setRadioOption(String radioName, int order)
    {
        try
        {
            String xPath = "//label[text()=\"" + radioName + "\"]/preceding-sibling::" + ElementID.RADIO + "";
            elements = getElements(xPath, 10);
            if (notNull(elements))
            {
                setRadioOption(elements.get(0));
                report("Select option: ", radioName, PASSED, elements.get(0));
            }
        } catch (Exception e)
        {
            report("Select option: ", radioName, FAILED, elements.get(0), e);
        }
    }

    // for Yes/No radio that have a label text
    @Step("Choose option {0} = {1}")
    public void setRadioOption(String labelText, String radioValue)
    {
        if (notEmpty(radioValue))
        {
            try
            {
                labelText = labelText.trim();
                radioValue = radioValue.trim();
                String xPath = "";
                // radioValue = expandAbbrText(radioValue);
                if (radioValue.toLowerCase().equals("no") || radioValue.toLowerCase().equals("n"))
                    radioValue = "No";
                else if (radioValue.toLowerCase().equals("yes") || radioValue.toLowerCase().equals("y"))
                    radioValue = "Yes";
                if (labelText.contains("\""))
                    xPath = "(//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//label[text" + "()='" + radioValue + "']/preceding-sibling::" + ElementID.RADIO + ")[1]";
                else
                    xPath = "(//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//label[text()=\"" + radioValue + "\"]/preceding-sibling::" + ElementID.RADIO + ")[1]";
                element = getElement(xPath, 10);
                if (element != null)
                {
                    setRadioOption(element);
                    report("Select option: " + labelText, radioValue, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Select option: " + labelText, radioValue, FAILED, element, e);
            }
        }
    }

    public boolean isRadioOptionChecked(String labelText, String radioValue)
    {
        if (notEmpty(radioValue))
        {
            try
            {
                labelText = labelText.trim();
                radioValue = radioValue.trim();
                String xPath = "";
                // radioValue = expandAbbrText(radioValue);
                if (radioValue.toLowerCase().equals("no") || radioValue.toLowerCase().equals("n"))
                    radioValue = "No";
                else if (radioValue.toLowerCase().equals("yes") || radioValue.toLowerCase().equals("y"))
                    radioValue = "Yes";
                if (labelText.contains("\""))
                    xPath = "(//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td//label[text" + "()='" + radioValue + "']/preceding-sibling::" + ElementID.RADIO + ")[1]";
                else
                    xPath = "(//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td//label[text()=\"" + radioValue + "\"]/preceding-sibling::" + ElementID.RADIO + ")[1]";
                element = getElement(xPath, 10);
                if (element != null)
                {
                    return isChecked(element);
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Set Radio button (Yes / No option) if it is available in screen
     *
     * @param labelText  The label of the radio button.
     * @param radioValue
     */
    @Step("Choose option {0} = {1}")
    public void setRadioOptionIfAvailable(String labelText, String radioValue)
    {
        waitForElementToBeClickable(ElementID.RADIO, 2);
        try
        {
            if (checkTextExist(labelText, true) && isInputEnabled(labelText) && !empty(radioValue))
                setRadioOption(labelText, radioValue);
        } catch (Exception e)
        {
            // no exception
        }
    }

    // for Yes/No radio that have a label text
    public void setRadioOption(String labelText, String radioValue, int order)
    {
        if (notEmpty(radioValue))
        {
            try
            {
                labelText = labelText.trim();
                radioValue = radioValue.trim();
                if (radioValue.toLowerCase().equals("no") || radioValue.toLowerCase().equals("n"))
                    radioValue = "false";
                if (radioValue.toLowerCase().equals("yes") || radioValue.toLowerCase().equals("y"))
                    radioValue = "true";
                elements = getElementsNextToElement(labelText, ElementID.RADIO + "[@value='" + radioValue + "']");
                if (notNull(elements))
                {
                    setRadioOption(elements.get(order - 1));
                    report("Select option: " + labelText, radioValue, PASSED, elements.get(order - 1));
                }
            } catch (Exception e)
            {
                report("Select option: " + labelText, radioValue, FAILED, elements.get(order - 1), e);
            }
        }
    }

    public boolean isRadioOptionChecked(String labelText, String radioValue, int order)
    {
        if (notEmpty(radioValue))
        {
            try
            {
                labelText = labelText.trim();
                radioValue = radioValue.trim();
                if (radioValue.toLowerCase().equals("no") || radioValue.toLowerCase().equals("n"))
                    radioValue = "false";
                if (radioValue.toLowerCase().equals("yes") || radioValue.toLowerCase().equals("y"))
                    radioValue = "true";
                elements = getElementsNextToElement(labelText, ElementID.RADIO + "[@value='" + radioValue + "']");
                if (notNull(elements))
                {
                    return isChecked(elements.get(order - 1));
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return true;
    }

    // select a dropdown list next to a label
    @Step("Choose {0} = {1}")
    public void setDropDownOption(String labelText, String optionValue, boolean exactMatch)
    {
        if (notEmpty(optionValue))
        {
            try
            {
                labelText = labelText.trim();
                optionValue = optionValue.trim();
                String element = "";
                if (!exactMatch)
                    element = ElementID.OPTION + "[contains(text(), \"" + optionValue + "\")]";
                else
                    element = ElementID.OPTION + "[text()=\"" + optionValue + "\"]";
                elements = getElementsNextToElement(labelText, element);// [not(contains(@selected,
                // 'selected'))]
                if (notNull(elements))
                {
                    clickAtElement(elements.get(0), 0.5);
                    report("Select option: " + labelText, optionValue, PASSED, elements.get(0));
                }
            } catch (Exception e)
            {
                report("Select option: " + labelText, optionValue, FAILED, elements.get(0), e);
            }
        }
    }

    public String getDropDownOptionValue(String labelText)
    {
        if (notEmpty(labelText))
        {
            try
            {
                labelText = labelText.trim();
                elements = getElementsNextToElement(labelText, ElementID.OPTION + "[@selected]");// [not(contains(@selected,
                // 'selected'))]
                if (notNull(elements))
                {
                    return getText(elements.get(0));
                }
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    // select a dropdown list follow number
    @Step("Choose {0} = {1}")
    public void setDropDownOption(String labelText, int optionNumber)
    {
        try
        {
            if (optionNumber > 0)
            {
                labelText = labelText.trim();
                elements = getElementsNextToElement(labelText, ElementID.OPTION + "[contains(text(), \"" + optionNumber + "\")]");
                if (notNull(elements))
                {
                    clickAtElement(elements.get(0), 0.5);
                    report("Set " + labelText + " to row", optionNumber + "", PASSED, element);
                }
            }
        } catch (Exception e)
        {
            report("Set " + labelText + " to row", optionNumber + "", FAILED, element, e);
        }
    }

    // select a stand alone dropdown list
    @Step("Choose {0}")
    public void setDropDownOption(String optionValue)
    {
        if (notEmpty(optionValue))
        {
            try
            {
                optionValue = optionValue.trim();
                elements = getElements("//" + ElementID.OPTION + "[contains(text(), \"" + optionValue + "\")]", 10);// [not(contains(@selected,
                // 'selected'))]
                if (notNull(elements))
                {
                    clickAtElement(elements.get(0), 0.5);
                    report("Select option: ", optionValue, PASSED, elements.get(0));
                }
                else
                {
                    // System.out.println("Cannot found " + element.toString());
                }
            } catch (Exception e)
            {
                report("Select option: ", optionValue, FAILED, elements.get(0), e);
            }
        }
    }

    /**
     * Click at button by its name
     *
     * @param buttonName name of the button
     * @throws Exception
     * @author Levin
     */

    @Step("Click {0} button")
    public void clickButton(String buttonName)
    {
        try
        {
            String xPath = "//input[@type='button'][@value=\"" + buttonName + "\"] | " + "//input[@type='submit'][@value=\"" + buttonName + "\"]";
            element = getElement(xPath, 3);
            if (element != null)
            {
                waitForElementToBeClickable(element, 3);
                clickAtElement(element, 0.5);
                report("Click at button: " + buttonName, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click at button: " + buttonName, "", FAILED, element, e);
        }
    }

    /**
     * Click at button based on position on screen
     *
     * @param buttonName name of the button
     * @param order      order of the button on screen (999 = last button)
     * @author Levin
     */
    @Step("Click {0} button")
    public void clickButton(String buttonName, int order)
    {
        try
        {
            String xPath = "";
            if (order >= 999)
                xPath = "(//input[@type='button'][@value=\"" + buttonName + "\"])[last()]";
            else
                xPath = "(//input[@type='button'][@value=\"" + buttonName + "\"])[" + order + "]";
            element = getElement(xPath, 10);
            if (element != null)
            {
                waitForElementToBeClickable(xPath, 3);
                clickAtElement(element, 0.5);
                report("Click at button: " + buttonName, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click at button: " + buttonName, "", FAILED, element, e);
        }
    }

    @Step("Click search")
    public void clickSearchButton()
    {
        try
        {
            clickAtXpathCSS("//" + ElementID.SEARCHICON);
            report("Click search button", "", PASSED, element);
        } catch (Exception e)
        {
            report("Click search button", "", FAILED, element, e);
        }
    }

    public void clickAtXpathCSS(String xPathCSS)
    {
        try
        {
            clickAtXpathCSS_Base(xPathCSS);
            report("Click xpath: " + xPathCSS, "", PASSED, element);
        } catch (Exception e)
        {
            report("Click xpath: " + xPathCSS, "", FAILED, element, e);
        }
    }

    public void clickAtXpathCSS(String xPathCSS, int order)
    {
        try
        {
            clickAtXpathCSS_Base("(" + xPathCSS + ")[" + order + "]");
            report("Click xpath: " + xPathCSS, "", PASSED, element);
        } catch (Exception e)
        {
            report("Click xpath: " + xPathCSS, "", FAILED, element, e);
        }
    }

    @Step("Click search at {0}")
    public void clickSearchButton(String labelText)
    {
        try
        {
            elements = getElementsNextToElement(labelText, ElementID.SEARCHICON);
            clickAtElement(elements.get(0), 0.5);
            report("Click search button: " + labelText, "", PASSED, element);
        } catch (Exception e)
        {
            report("Click search button: " + labelText, "", FAILED, element, e);
        }
    }

    @Step("Click search at {0}")
    public void clickSearchButton(String labelText, int order)
    {
        try
        {
            elements = getElementsNextToElement(labelText, ElementID.SEARCHICON);
            if (notNull(elements))
            {
                clickAtElement(elements.get(order - 1), 0.5);
                report("Click search button: " + labelText, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Click search button: " + labelText, "", FAILED, element, e);
        }
    }

    @Step("Click green arrow button under {0}, line {1}")
    public void clickGreenArrow(String columnName, int rowNumber)
    {
        try
        {
            String xPath = "//*[contains(text(), \"" + columnName + "\")" + "]/ancestor::thead/following-sibling::tbody/tr[" + rowNumber + "]//" + ElementID.GREEN_ARROW_BUTTON;
            element = getElement(xPath, 10);
            // if (notNull(elements)) {
            if (element != null)
            {
                clickAtElement(element, 0.5);
                report("Open sub records (click at green arrow) at " + columnName + " of row " + rowNumber, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Open sub records (click at green arrow) at " + columnName + " of row " + rowNumber, "", FAILED, element, e);
        }
    }

    @Step("Access {0} screen")
    public void goToMenu(String MenuID)
    {
        try
        {
            waitForElementToBeClickable("//a[./text()='Logout'] | //a[./text()='Log out']", 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('" + MenuID + "').click();");
            // sleep(3); // for parallel run
            waitForAjax(3);
            waitForElementToBeClickable(ElementID.BOOKMARK_BUTTON, 10);
            waitForProgressBar(1);
            report("Go to menu: " + com.synergix.common.constants.MenuID.getMenuName(MenuID), "", PASSED, element);
        } catch (Exception e)
        {
            // disable failing for using with TH6
            //report("Go to menu: " + com.synergix.common.constants.MenuID.getMenuName(MenuID), "", FAILED, element, e);
        }
    }

    /**
     * Get first value next to a label
     *
     * @param labelText
     * @return The first value next to a label
     */
    @Step("Get description of {0}")
    public String getText(String labelText)
    {
        if (notEmpty(labelText))
        {
            try
            {
                String xPath = "//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td[contains" + "(@class, 'value')]";
                String text = "";
                elements = getElements(xPath, 10);
                if (notNull(elements))
                {
                    for (WebElement element : elements)
                    {
                        text = element.getText();
                        if (text != null)
                            if (text.equals(""))
                            {
                                text = getText(element);
                                if (!text.equals(""))
                                {
                                    print(labelText + ": " + text);
                                    return text;
                                }
                            }
                            else
                            {
                                text = element.getText();
                                if (!text.equals(""))
                                {
                                    print(labelText + ": " + text);
                                    return text;
                                }
                            }
                    }
                }
                else
                    return "";
            } catch (Exception e)
            {
                report("Get text value from: " + labelText, "", FAILED, elements.get(0), e);
            }
        }
        return "";
    }

    @Step("Get value of textbox {0}")
    public String getTextValue(String labelText)
    {
        if (notEmpty(labelText))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.TEXTBOX);
                return getText(elements.get(0));
            } catch (Exception e)
            {
                return "";
            }
        }
        return "";
    }

    // get the alias name in front of Logout
    public String getLoginAlias()
    {
        try
        {
            String alias = "";
            element = driver.findElement(By.tagName("body"));
            alias = element.getText();
            Charset.forName("UTF-8").encode(alias);
            alias = ReadBean.getStringBetween(alias, "\n", "|").trim();
            print("Found Alias: " + alias);
            return alias;
        } catch (Exception e)
        {
            report("Get current login alias", "", FAILED, null, e);
            return "";
        }
    }

    public void setTextAtElement(WebElement element, String value, double progressBarTimeOut) throws Exception
    {
        if (notEmpty(value))
        {
            value = value.trim();
            waitForElementToBeClickable(element, 3);
            if (element.isDisplayed() && isEnable(element))
            {
                if (value.equals("blank")) // clear the text
                {
                    clearText(element, true);
                    element.sendKeys(Keys.ENTER);
                }
                else
                    // check if value in textbox is the same with inputting text
                    if (!isInputted(element, value))
                    {
                        clearText(element, true);
                        inputText(element, value, false, true);
                        waitForTextToBePresent(element, value, 1);
                        // in case the page reloads after accepted a value
                        waitForAjax((long) progressBarTimeOut);
                    }
            }
        }
    }

    public boolean verifyTextAtElement(WebElement element, String value)
    {
        try
        {
            if (notEmpty(value))
            {
                value = value.trim();
                waitForElementToBeClickable(element, 10);
                if (element.isDisplayed() && element.isEnabled())
                {
                    // check if value in textbox is the same with inputting text
                    if (isInputted(element, value))
                    {
                        String text = "Text is the same: " + value + " / " + element.getAttribute("value");
                        print(text);
                        return true;
                    }
                    else
                    {
                        String text = "Text is not the same: " + value + " / " + element.getAttribute("value");
                        print(text);
                        return false;
                    }
                }
                else
                {
                    print("Cannot vefiry text: " + value);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void setTextAreaAtElement(WebElement element, String value, double progressBarTimeOut) throws Exception
    {
        if (notEmpty(value))
        {
            value = value.trim();
            waitForElementToBeClickable(element, 10);
            if (element.isDisplayed() && element.isEnabled())
            {
                // check if value in textbox is the same with inputting text
                if (!isInputted(element, value))
                {
                    getFocus(element);
                    element.clear();
                    getFocus(element);
                    element.sendKeys(value);
                    print("Text is inputed: " + value);

                    waitForTextToBePresent(element, value, 10);
                    // in case the page reloads after accepted a value
                    waitForAjax((long) progressBarTimeOut);
                }
                else
                    print("Text is inputed already: " + value);
            }
            else
                print("Cannot input text: " + value);
        }
        // element =
        // getElementByCSSNoException("input[id='ErrorForm:OKButton']", 1);
        // if (element != null) {
        // clickAtElement(element);// click ok at error message
        // }
    }

    @Step("Set checkbox of xPath \"{0}\" with option = {1}")
    public void setCheckbox(String xPathCSS, boolean checkValue)
    {
        try
        {
            element = getElement(xPathCSS, 10);
            if (checkValue && element != null)
                setCheckbox(element, "check", 0.5);
            else if (!checkValue && element != null)
                setCheckbox(element, "uncheck", 0.5);
            report("Toogle option: " + xPathCSS, checkValue + "", PASSED, element);
        } catch (Exception e)
        {
            report("Toogle option: " + xPathCSS, checkValue + "", FAILED, element, e);
        }
    }

    @Step("Set checkbox of {0} with option = {1}")
    public void setCheckbox(String labelText, String checkValue, int order)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                elements = getElementsNextToElement(labelText, ElementID.CHECKBOX, order);
                if (notNull(elements))
                {
                    setCheckbox(elements.get(0), checkValue, 0.5);
                    report("Toogle option: " + labelText, checkValue + "", PASSED, elements.get(0));
                }
            } catch (Exception e)
            {
                report("Toogle option: " + labelText, checkValue + "", FAILED, elements.get(0), e);
            }
        }
    }

    @Step("Set checkbox of {0} with option = {1}")
    public void setCheckbox(String labelText, String checkValue)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                elements = getElementsInFrontOfElement(labelText, ElementID.CHECKBOX);
                if (notNull(elements))
                {
                    setCheckbox(elements.get(0), checkValue, 0.5);
                    report("Toogle option: " + labelText, checkValue + "", PASSED, elements.get(0));
                }
            } catch (Exception e)
            {
                report("Toogle option: " + labelText, checkValue + "", FAILED, elements.get(0), e);
            }
        }
    }

    @Step("Set checkbox of {0} with option = {1}")
    public void setCheckboxByValue(String labelValue, String checkValue)
    {
        if (notEmpty(checkValue))
        {
            try
            {
                String xPath = "((//*[text()='" + labelValue + "']/preceding-sibling::td | //*[text()='" + labelValue + "']/parent::td/preceding-sibling::td)//" + ElementID.CHECKBOX + ")[last()]";
                element = getElement(xPath, 1);
                if (element != null)
                {
                    setCheckbox(element, checkValue, 0.5);
                    report("Toogle option: " + labelValue, checkValue + "", PASSED, elements.get(0));
                }
            } catch (Exception e)
            {
                report("Toogle option: " + labelValue, checkValue + "", FAILED, elements.get(0), e);
            }
        }
    }

    public boolean isCheckboxByValueChecked(String labelValue)
    {
        if (notEmpty(labelValue))
        {
            try
            {
                String xPath = "((//*[text()='" + labelValue + "']/preceding-sibling::td | //*[text()='" + labelValue + "']/parent::td/preceding-sibling::td)//" + ElementID.CHECKBOX + ")[last()]";
                element = getElement(xPath, 1);
                if (element != null)
                {
                    return isChecked(element);
                }
            } catch (Exception e)
            {
                return false;
            }
        }
        return true;
    }

    public void setTextAtXpathCSS(String xPathCSS, String value)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElement(xPathCSS, 10);
                setTextAtElement(element, value, 0.5);
                report("Input data at: " + xPathCSS, value, PASSED, element);
            } catch (Exception e)
            {
                report("Input data at: " + xPathCSS, value, FAILED, element, e);
            }
        }
    }

    public void setTextAtXpathCSSNoEnter(String xPathCSS, String value) throws Exception
    {
        if (notEmpty(value))
        {
            element = getElement(xPathCSS, 10);
            setTextAreaAtElement(element, value, 0.5);
        }
    }

    @Step("Open tab {0}")
    public void goToTab(String tabName)
    {
        if (notEmpty(tabName))
        {
            String xPath = "(//*[contains(@class, 'rich-tab-header')][contains(text(), '" + tabName + "')])";
            try
            {
                waitForProgressBar(1);
                element = getElement(xPath, 0);
                if (element.getAttribute("class").contains("rich-tab-inactive")) // only click inactive tab
                {
                    clickAtElement(element, 1);
                    waitForProgressBar(1);
                }
                report("Open tab: " + tabName, "", PASSED, element);
            } catch (Exception e)
            {
                report("Open tab: " + tabName, "", FAILED, element, e);
            }
        }
    }

    @Step("Open tab {0}")
    public void goToTab(String tabName, int order)
    {
        if (notEmpty(tabName))
        {
            String xPath = "(//*[contains(@class, 'rich-tab-header')][contains(text(), '" + tabName + "')])[" + order + "]";
            try
            {
                waitForProgressBar(1);
                elements = getElements(xPath, 3);
                element = getVisibleElement(elements);
                if (element.getAttribute("class").contains("rich-tab-inactive")) // only click inactive tab
                {
                    clickAtElement(element, 1);
                    waitForProgressBar(1);
                }
                report("Open tab: " + tabName, "", PASSED, element);
            } catch (Exception e)
            {
                report("Open tab: " + tabName, "", FAILED, element, e);
            }
        }
    }

    @Step("Select numbering scheme {0}")
    public void selectNumberingScheme(int rowNo)
    {
        if (checkTextExist("Select a Document Numbering Scheme", true))
        {
            selectRow("Scheme Key", rowNo);
            confirm("OK");
        }
    }

    @Step("Confirmation: {0}")
    public void confirm(String yesNoOk)
    {
        try
        {
            if (yesNoOk.equalsIgnoreCase("yes") || yesNoOk.equalsIgnoreCase("no"))
            {
                if (checkElementVisible("form[id='confirmationPanel_Form'][name='confirmationPanel_Form']"))
                {
                    if (yesNoOk.equalsIgnoreCase("yes"))
                    {
                        element = getElementNoException(
                                "form[id='confirmationPanel_Form'][name='confirmationPanel_Form'] " + "input[id='confirmationPanel_Form:confirmationPanel_YesButton']",
                                (long) 0.5);
                        if (element != null)
                            clickAtElement(element, 1);
                        // check if confirm message or error message or warning
                        // when a required field has not been filled in
//                        element = getElementNoException(
//                                "//*[@id='statusPopupPanel_OkButton'] | //*[@id='ErrorForm:OKButton'] | //input[@value='OK'] | //input[@id='confirmationPanel_Form:confirmationPanel_YesButton']",
//                                1);
//                        if (element != null)
//                        {
//                            // no error
//                            if (element.getAttribute("id").equals("confirmationPanel_Form:confirmationPanel_YesButton"))
//                            {
//                                clickAtElement(element, 1);
//                            }
//
//                            if (element.getAttribute("id").equals("statusPopupPanel_OkButton"))
//                            {
//                                clickAtElement(element, 1);
//                            }
//
//                            // error
//                            if (element.getAttribute("id").equals("ErrorForm:OKButton"))
//                            {
//                                customAssert(ElementID.ERROR_MESSAGE);// fail the test
//                            }
//                        }
                        waitForAjax(3);
                        confirm("OK");
                    }
                    else if (yesNoOk.toLowerCase().equals("no"))
                    {
                        element = getElementNoException(
                                "form[id='confirmationPanel_Form'][name='confirmationPanel_Form'] " + "input[id='confirmationPanel_Form:confirmationPanel_NoButton']",
                                1);
                        if (element != null)
                            clickAtElement(element, 1);
                    }
                }
            }
            if (yesNoOk.equalsIgnoreCase("OK"))
            {
                element = getElementNoException("//*[@id='statusPopupPanel_OkButton'] | //*[@id='ErrorForm:OKButton'] | //input[@value='OK']", 1);
                if (element != null)
                    clickAtElement(element, 1);// click ok at confirm massage
            }
            report("Confirmation", yesNoOk, PASSED);
        } catch (Exception e)
        {
            // if no confirmation box shows, continue
            report("No Confirmation", yesNoOk, PASSED);
        }
    }

    // confirm without auto click OK
    @Step("Confirm: {0}")
    public void confirmNoOk(String yesNoOk)
    {
        try
        {
            if (yesNoOk.toLowerCase().equals("yes") || yesNoOk.toLowerCase().equals("no"))
            {
                if (checkElementVisible("form[id='confirmationPanel_Form'][name='confirmationPanel_Form']"))
                {
                    if (yesNoOk.toLowerCase().equals("yes"))
                    {
                        element = getElement(
                                "form[id='confirmationPanel_Form'][name='confirmationPanel_Form'] " + "input[id='confirmationPanel_Form:confirmationPanel_YesButton']",
                                10);
                        if (element != null)
                            clickAtElement(element, 1);
                    }
                    else if (yesNoOk.toLowerCase().equals("no"))
                    {
                        element = getElement(
                                "form[id='confirmationPanel_Form'][name='confirmationPanel_Form'] " + "input[id='confirmationPanel_Form:confirmationPanel_NoButton']",
                                10);
                        if (element != null)
                            clickAtElement(element, 1);
                    }
                }
            }
            if (yesNoOk.toLowerCase().equals("ok"))
            {
                element = getElementNoException("//input[@id='statusPopupPanel_OkButton'] | //input[@id='ErrorForm:OKButton']", 1);
                if (element != null)
                    clickAtElement(element, 1);// click ok at confirm massage
            }
            report("Confirmation", yesNoOk, PASSED);
        } catch (Exception e)
        {
            // if no confirmation box shows, continue
            report("No Confirmation", yesNoOk, PASSED);
        }
    }

    public void tagUserToProcessingNumbering(String baseUrl, String menuID)
    {
        if (checkUntaggedNumberingScheme())
        {
            String moduleCode = getNumberingSchemeModuleCode();
            String transactionCode = getNumberingSchemeTransactionCode();
            openURL(baseUrl);
            // get user name from main page //
            // //a[text()='Logout']/parent::form/text()"); // Levin Le |
            String user = getLoginAlias();// get alias name "Levin Le"
            goToMenu(MenuID.MS_PROCESSING_NUMBERING);
            setTableFilter("Module Code", moduleCode);
            sleep(3);
            setTableFilter("Transaction Type Code", transactionCode);
            // setTextByXpath(moduleCode, "//span[text() = 'Module
            // Code']/parent::a/following-sibling::input"); // module code
            // setTextByXpath(transactionCode, "//span[text() = 'Transaction
            // Type Code']/parent::a/following-sibling::input"); // transaction
            // type code
            selectFirstRow("Module Code");// select the first result
            selectFirstRow("Numbering Scheme Code");// choose the first scheme
            // clickAtCSS("tbody[id*=':transactionTypeTable:tb']
            // tr:nth-of-type(1)>td:nth-of-type(1)>a:nth-of-type(1)"); // select
            // the first result
            // clickAtCSS("tbody[id*=':schemeTable']
            // tr:nth-of-type(1)>td:nth-of-type(1)>a"); // choose the first
            // scheme
            // if ismanual numbering, no need to set length code, but tag users
            // right away
            if (!isChecked("tbody[id*=':schemeTable'] tr:nth-of-type(1) input[id*=':manualNumbering']"))
            {
                String maxLength = getTextByXpathCSS("input[id*=':maxLengthCode']");// get
                // max
                // length
                // code
                setText("Length of Code", maxLength);// set length code
                goToTab("Tag Users To Numbering Scheme");
            }
            clickButton("Add", 2);
            try
            {
                clickAtXpathCSS("table[id*=':taggedUerTable'] img");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            // click at	search icon
            setText("Alias", user);
            selectFirstRow("User ID");// click at first result
            // setTextByCSS(
            // user,
            // "table[id='searchModalPanelContentTable']>tbody>tr:nth-of-type(2)>td>table>tbody>tr:nth-of-type(2)
            // >td>form>table>tbody>tr>td:nth-of-type(4)>span>input");
            // // search alias name
            // clickAtCSS("tbody[id='searchResult_Form:searchResult_Table:tb']>tr:nth-of-type(1)>td:nth-of-type(1)>a");
            // // click at first result
            sleep(2);
            openURL(baseUrl);
            goToMenu(menuID);
            clickButton("New");
        }
    }

    @Step("Login with username: {0} and password: {1} of company: {2}")
    public void login(String username, String password, String company, long timeOut)
    {
        try
        {
            waitForTextToShow("Company", timeOut);
            sleep(0.5);
            clearCache();// reload page to handle WildFly's unable to click login button
            waitForTextToShow("Company", timeOut);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.FillUserName(username);
            loginPage.FillPassword(password);
            loginPage.selectCompany(company);
            loginPage.clickLoginBtn();
            loginPage.checkConfirmMessageBoxThenYes();
            //Login_Page.logIn(driver, username, password, company);// faster

            // levin del this later
            //			if (checkValueExist("Click Here to Return to TaskHub Main Page"))
            //				clickButton("Click Here to Return to TaskHub Main Page");
            waitForTextToShow("Logout", timeOut);
            report("Log in with: ", "Username: " + username + "; Password: " + password + "; Company: " + company, PASSED);
        } catch (Exception e)
        {
            report("Log in with: ", "Username: " + username + "; Password: " + password + "; Company: " + company, FAILED, e);
        }
    }

    @Step("Enter new credentials: {0} - {1}")
    public void enterNewUserInfo(String username, String password)
    {
        try
        {
            waitForTextToShow("Enter New User Name", 1);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterNewUser(username, password);
            loginPage.checkConfirmMessageBoxThenYes();
            //Login_Page.logIn(driver, username, password, company);// faster
            report("Enter new user info: ", "Username: " + username + "; Password: " + password, PASSED);
        } catch (Exception e)
        {
            report("Enter new user info: ", "Username: " + username + "; Password: " + password, FAILED, e);
        }
    }

    @Step("Logout")
    public void logOut()
    {
        try
        {
            element = getElementNoException("//a[./text()='Logout'] | //a[./text()='Log out']", 1);
            if (element != null)
            {
                clickAtElement(element, 0.5);
                report("Logout", getLoginAlias(), PASSED);
            }
        } catch (Exception e)
        {
            report("Logout", getLoginAlias(), FAILED, e);
        }
    }

    @Step("Select {0} transaction to approve")
    public void selectRowInQueueAtTableApprovalSummary(String transactionTypeDesc)
    {
        try
        {
            String xPath = "//tr[count(//td[2][text()=\"" + transactionTypeDesc + "\"]/parent::tr/preceding-sibling::tr)+1]/td[3]/a";
            element = getElement(xPath, 10);
            if (element != null)
            {
                clickAtElement(element, 0.5);
                report("Approval transaction type: " + transactionTypeDesc, "", PASSED, element);
            }
        } catch (Exception e)
        {
            report("Approval transaction type: " + transactionTypeDesc, "", FAILED, element, e);
        }
    }

    /**
     * Approve all records in visible table in Approval Summary
     *
     * @param action Approve / Reject / None
     * @author Levin
     */
    @Step("{0} all at Approval Summary")
    public void approveAllAtTableApprovalSummary(String action)
    {
        if (action.equalsIgnoreCase("Approve"))
            action = "A";
        if (action.equalsIgnoreCase("Reject"))
            action = "R";
        if (action.equalsIgnoreCase("None"))
            action = "N";
        try
        {
            while (true)
            {
                String xPath = "//input[@type='radio'][@value='" + action + "']";
                elements = getElements(xPath, 10);
                if (notNull(elements))
                {
                    for (WebElement ele : elements)
                    {
                        clickAtElement(ele, 0);
                    }
                }
                element = getElementNoException(ElementID.NAVIGATE_NEXT_BUTTON, (long) 0.5);
                if (element != null && isEnable(element))
                    clickAtElement(element, 1);
                else
                    break;
            }
            clickButton("Submit");
            confirm("Yes");

            report("Approval summary action: " + action, "", PASSED);
        } catch (Exception e)
        {
            report("Approval summary action: " + action, "", FAILED, e);
        }
    }

    // for table in Global Basic with OT Scheme
    private void setTextAtTableCellEatingBreak(String tableName, String breakType, String columnName, int rowNumber, String value)
    {
        if (notEmpty(value))
        {
            int colCount = 0;
            if (breakType.equals("Lunch"))
            {
                if (columnName.equals("Time From"))
                    colCount = 2;
                if (columnName.equals("Time To"))
                    colCount = 3;
                if (columnName.equals("Cutoff Time"))
                    colCount = 4;
                if (columnName.equals("Rate Factor"))
                    colCount = 5;
            }

            if (breakType.equals("Dinner"))
            {
                if (columnName.equals("Time From"))
                    colCount = 6;
                if (columnName.equals("Time To"))
                    colCount = 7;
                if (columnName.equals("Cutoff Time"))
                    colCount = 8;
                if (columnName.equals("Rate Factor"))
                    colCount = 9;
            }

            if (breakType.equals("Supper"))
            {
                if (columnName.equals("Time From"))
                    colCount = 10;
                if (columnName.equals("Time To"))
                    colCount = 11;
                if (columnName.equals("Cutoff Time"))
                    colCount = 12;
                if (columnName.equals("Rate Factor"))
                    colCount = 13;
            }
            try
            {
                element = getElementsUnderColumnName(tableName, columnName, rowNumber, colCount, ElementID.TEXTBOX, 10).get(0);
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellText);
                    report("Set eating break: " + breakType + " - " + columnName, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Set eating break: " + breakType + " - " + columnName, value, FAILED, element, e);
            }
        }
    }

    // for table in Global Basic with OT Scheme
    @Step("Input Lunch Time From = {2}, Time To = {3}, Cutoff Time = {4}, Rate Factor = {5} into Period Type {1} of " + "table {0}")
    public void setTextAtTableCellLunchBreak(String tableName, String periodType, String timeFrom, String timeTo, String cutOffTime,
                                             String rateFactor)
    {
        int rowNumber = 0;
        if (periodType.equals("Weekday"))
            rowNumber = 1;
        if (periodType.equals("Saturday"))
            rowNumber = 2;
        if (periodType.equals("Sunday"))
            rowNumber = 3;
        if (periodType.equals("Public Holiday"))
            rowNumber = 4;
        setTextAtTableCellEatingBreak(tableName, "Lunch", "Time From", rowNumber, timeFrom);
        setTextAtTableCellEatingBreak(tableName, "Lunch", "Time To", rowNumber, timeTo);
        setTextAtTableCellEatingBreak(tableName, "Lunch", "Cutoff Time", rowNumber, cutOffTime);
        setTextAtTableCellEatingBreak(tableName, "Lunch", "Rate Factor", rowNumber, rateFactor);
    }

    // for table in Global Basic with OT Scheme

    @Step("Input Dinner Time From = {2}, Time To = {3}, Cutoff Time = {4}, Rate Factor = {5} into Period Type {1} of " + "" + "table {0}")
    public void setTextAtTableCellDinnerBreak(String tableName, String periodType, String timeFrom, String timeTo, String cutOffTime,
                                              String rateFactor)
    {
        int rowNumber = 0;
        if (periodType.equals("Weekday"))
            rowNumber = 1;
        if (periodType.equals("Saturday"))
            rowNumber = 2;
        if (periodType.equals("Sunday"))
            rowNumber = 3;
        if (periodType.equals("Public Holiday"))
            rowNumber = 4;
        setTextAtTableCellEatingBreak(tableName, "Dinner", "Time From", rowNumber, timeFrom);
        setTextAtTableCellEatingBreak(tableName, "Dinner", "Time To", rowNumber, timeTo);
        setTextAtTableCellEatingBreak(tableName, "Dinner", "Cutoff Time", rowNumber, cutOffTime);
        setTextAtTableCellEatingBreak(tableName, "Dinner", "Rate Factor", rowNumber, rateFactor);
    }

    // for table in Global Basic with OT Scheme
    @Step("Input Supper Time From = {2}, Time To = {3}, Cutoff Time = {4}, Rate Factor = {5} into Period Type {1} of " + "" + "table {0}")
    public void setTextAtTableCellSupperBreak(String tableName, String periodType, String timeFrom, String timeTo, String cutOffTime,
                                              String rateFactor)
    {
        int rowNumber = 0;
        if (periodType.equals("Weekday"))
            rowNumber = 1;
        if (periodType.equals("Saturday"))
            rowNumber = 2;
        if (periodType.equals("Sunday"))
            rowNumber = 3;
        if (periodType.equals("Public Holiday"))
            rowNumber = 4;
        setTextAtTableCellEatingBreak(tableName, "Supper", "Time From", rowNumber, timeFrom);
        setTextAtTableCellEatingBreak(tableName, "Supper", "Time To", rowNumber, timeTo);
        setTextAtTableCellEatingBreak(tableName, "Supper", "Cutoff Time", rowNumber, cutOffTime);
        setTextAtTableCellEatingBreak(tableName, "Supper", "Rate Factor", rowNumber, rateFactor);
    }

    long sleepTimeCellTextPY = 1;

    @Step("Input {3} into row {2} of column {1} in tab {0}")
    public void setTextAtTableCellPRTimeSheet(String tabName, String columnName, int rowNumber, String value)
    {
        setElementPRTimesheet(tabName, columnName, rowNumber, value, ElementID.TEXTBOX);
    }

    public String getTextAtTableCellPRTimeSheet(String tabName, String columnName, int rowNumber)
    {
        return getText(getElementPRTimesheet(tabName, columnName, rowNumber, "", ElementID.TEXTBOX));
    }

    @Step("Set checkbox option = {3} in row {2} of column {1} in tab {0}")
    public void setCheckBoxAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber, String checkboxValue)
    {
        setElementPRTimesheet(tabName, columnName, rowNumber, checkboxValue, ElementID.CHECKBOX);
    }

    public boolean isCheckBoxAtTableCellPRTimesheetChecked(String tabName, String columnName, int rowNumber, String checkboxValue)
    {
        if (empty(checkboxValue))
            return true;
        boolean check = isChecked(getElementPRTimesheet(tabName, columnName, rowNumber, checkboxValue, ElementID.CHECKBOX));
        return ((check && checkboxValue.startsWith("Y")) || (!check && checkboxValue.startsWith("N")));
    }

    @Step("Click search in row {2} of column {1} in tab {0}")
    public void clickSearchAtTableCellPRTimeSheet(String tabName, String columnName, int rowNumber)
    {
        setElementPRTimesheet(tabName, columnName, rowNumber, "0", ElementID.SEARCHICON);
    }

    boolean tradeCodeStatus = false;

    public WebElement getElementPRTimesheet(String tabName, String columnName, int rowNumber, String value, String mode)
    {
        if (notEmpty(value))
        {
            String xPath = "";
            // int columnNo = 0;
            String table = "";
            String searchPattern = "";
            if (columnName.equalsIgnoreCase("Employee Code"))
                searchPattern = " Code";
            else if (columnName.equalsIgnoreCase("Employee Name"))
                searchPattern = " Name";
            else if (columnName.equalsIgnoreCase("Travel Hours"))
                searchPattern = "Hours";
            else if (columnName.equalsIgnoreCase("Actual Working Location"))
                searchPattern = "Actual";
            else if (columnName.equalsIgnoreCase("Employee Job Type"))
                searchPattern = " Job Type";
            else if (columnName.equalsIgnoreCase("Clock In Location"))
                searchPattern = "Clock In";
            else if (columnName.equalsIgnoreCase("Wage Service Description"))
                searchPattern = "Wage Service";
            else if (columnName.equalsIgnoreCase("Exchange Rate"))
                searchPattern = "Exchange";
            else if (columnName.equalsIgnoreCase("Incl. Tax"))
                searchPattern = "Incl.";
            else if (columnName.equalsIgnoreCase("Nature Amt Before Tax"))
                searchPattern = " Before Tax";
            else if (columnName.equalsIgnoreCase("Nature Amt After Tax"))
                searchPattern = " After Tax";
            else
                searchPattern = columnName;

            if (tabName.contains("Manual"))
                table = ElementID.xPathTableManual;
            else if (tabName.contains("Import"))
                table = ElementID.xPathTableImport;
            else if (tabName.contains("Leave"))
            {
                table = ElementID.xPathTableLeave;
                if (columnName.equalsIgnoreCase("Employee Code"))
                    searchPattern = "Employee Code";
                if (columnName.equalsIgnoreCase("Employee Name"))
                    searchPattern = "Employee Name";
                if (columnName.equalsIgnoreCase("Leave Type"))
                    searchPattern = "Leave Type";
                if (columnName.equalsIgnoreCase("Leave Type Desc"))
                    searchPattern = "Leave Type Desc";
            }
            else if (tabName.contains("No Record"))
                table = ElementID.xPathTableNoRecord;
            else if (tabName.contains("Detail"))
                table = ElementID.xPathTableDetail;
            else if (tabName.contains("Additional"))
                table = ElementID.xPathTableAddPayment;

            String xPathElement = mode;
            if (mode.equalsIgnoreCase(ElementID.DROPDOWNOPTION))
                xPathElement = ElementID.OPTION + "[contains(text(), \"" + value + "\")]";
            if (mode.equalsIgnoreCase(ElementID.TEXTBOX))
                xPathElement = ElementID.TEXTBOX;

            int addCol = 0;
            if (mode.equalsIgnoreCase(ElementID.CHECKBOX))
            {
                xPathElement = ElementID.CHECKBOX;

                if (tabName.contains("Detail"))
                    searchPattern = "Actual";// for timesheet details
                else if (tabName.contains("No Record"))
                    searchPattern = "Leave Type";// for no records tab
                else
                {
                    if (tradeCodeStatus) // if trade code exist, no need to check again
                        tradeCodeStatus = checkTextExist("Trade Code", true);
                    if (tradeCodeStatus)
                        searchPattern = "Trade Code";
                    else
                        searchPattern = " Job Type";
                }

                if (columnName.equalsIgnoreCase("No Lunch"))
                    addCol = 1;
                if (columnName.equalsIgnoreCase("No Dinner"))
                    addCol = 2;
                if (columnName.equalsIgnoreCase("No Supper"))
                    addCol = 3;
                if (columnName.equalsIgnoreCase("Pay Emp Based On Actual Clock In Time"))
                    addCol = 4;
                if (columnName.equalsIgnoreCase("Del"))
                    addCol = 5;
                if (columnName.equalsIgnoreCase("On Hold"))
                    addCol = 5;
                if (columnName.equalsIgnoreCase("Sel"))
                    addCol = 7;
            }

            xPath = table + "/tbody/tr[" + rowNumber + "]/td[count((//th//*[text()=\"" + searchPattern + "\"] | " + "//th[text()=\"" + searchPattern + "\"])//ancestor::th//preceding-sibling::th) + 1 + " + addCol + "]//" + xPathElement;

            if (mode.equalsIgnoreCase(ElementID.CHECKBOX) && columnName.equalsIgnoreCase("Travel"))
                xPath = table + "/tbody/tr[" + rowNumber + "]/td[12]//" + ElementID.CHECKBOX;
            else if (mode.equalsIgnoreCase(ElementID.CHECKBOX) && columnName.equalsIgnoreCase(
                    "Del") && rowNumber == 0) // select Del all at table filter
                xPath = table + "/thead/tr/th[last()]//" + ElementID.CHECKBOX;

            return getElementNoException(xPath, 1); // in case textbox of Timesheet Date column in TS Details is disabled
        }
        return null;
    }

    public void setElementPRTimesheet(String tabName, String columnName, int rowNumber, String value, String mode)
    {
        if (notEmpty(value))
        {
            try
            {
                element = getElementPRTimesheet(tabName, columnName, rowNumber, value, mode);
                if (element != null)
                {
                    if (mode.equalsIgnoreCase(ElementID.TEXTBOX))
                        setTextAtElement(element, value, progressBarTimeOut);
                    if (mode.equalsIgnoreCase(ElementID.DROPDOWNOPTION))
                        clickAtElement(element, rowNumber);
                    if (mode.equalsIgnoreCase(ElementID.CHECKBOX))
                        setCheckbox(element, value, progressBarTimeOut);
                    if (mode.equalsIgnoreCase(ElementID.SEARCHICON))
                        clickAtElement(element, progressBarTimeOut);
                    report("Input timesheet data at: " + tabName + " at field: " + columnName + " at row: " + rowNumber, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Input timesheet data at: " + tabName + " at field: " + columnName + " at row: " + rowNumber, value, FAILED, element, e);
            }
        }
    }

    @Step("Choose {1} = {3} at row {2} in tab {0}")
    public void setDropDownOptionAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber, String value)
    {
        setElementPRTimesheet(tabName, columnName, rowNumber, value, ElementID.DROPDOWNOPTION);
    }

    public String getDropDownOptionAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber)
    {
        return getText(getElementPRTimesheet(tabName, columnName, rowNumber, "", ElementID.DROPDOWNOPTION));
    }

    public String getTextAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber)
    {
        return getText(getElementPRTimesheet(tabName, columnName, rowNumber, "", "td"));
    }

    @Step("Select all {1} = {2} in tab {0}")
    public void setCheckBoxTableFilterAtTableCellPRTimesheet(String tabName, String columnName, String value)
    {
        setElementPRTimesheet(tabName, columnName, 0, value, ElementID.CHECKBOX);
    }

    @Step("Filter column {1} = {2} at tab {0}")
    public void setTableFilterAtPRTimesheet(String tabName, String columnName, String value)
    {
        if (notEmpty(value))
        {
            String xPath = "";
            int columnNo = 0;
            String table = "";
            if (tabName.contains("Manual"))
            {
                table = ElementID.xPathTableManual;
                if (columnName.equals("Employee Code"))
                    columnNo = 2;
                else if (columnName.equals("Time In"))
                    columnNo = 4;
                else if (columnName.equals("Date In"))
                    columnNo = 5;
                else if (columnName.equals("Time Out"))
                    columnNo = 6;
                else if (columnName.equals("Date Out"))
                    columnNo = 7;
                else if (columnName.equals("Project No."))
                    columnNo = 8;
                else if (columnName.equals("Phase Sequence No."))
                    columnNo = 9;
                else if (columnName.equals("LI No."))
                    columnNo = 10;
                else if (columnName.equals("Actual Working Location"))
                {
                    if (checkTextExist("LI No.", true))
                        columnNo = 14;
                    else
                        columnNo = 12;
                }
                else if (columnName.equals("Employee Job Type"))
                {
                    if (checkTextExist("LI No.", true))
                        columnNo = 15;
                    else
                        columnNo = 13;
                }
            }
            else if (tabName.contains("Import"))
            {
                table = ElementID.xPathTableImport;
                if (columnName.equals("Employee Code"))
                    columnNo = 2;
                else if (columnName.equals("Employee Name"))
                    columnNo = 3;
                else if (columnName.equals("Clock In Location"))
                    columnNo = 6;
                else if (columnName.equals("Clock Out Location"))
                    columnNo = 9;
                else if (columnName.equals("Project No."))
                    columnNo = 10;
                else if (columnName.equals("Phase Sequence No."))
                    columnNo = 11;
                else if (columnName.equals("Actual Working Location"))
                    columnNo = 14;
                else if (columnName.equals("Employee Job Type"))
                    columnNo = 15;
            }
            else if (tabName.contains("Leave"))
            {
                table = ElementID.xPathTableLeave;
                if (columnName.equals("Employee Code"))
                    columnNo = 2;
                else if (columnName.equals("Employee Name"))
                    columnNo = 3;
                else if (columnName.equals("Leave Type"))
                    columnNo = 4;
                else if (columnName.equals("Leave Type Desc"))
                    columnNo = 5;
            }
            else if (tabName.contains("No Record"))
            {
                table = ElementID.xPathTableNoRecord;
                if (columnName.equals("Employee Code"))
                    columnNo = 1;
                else if (columnName.equals("Time In"))
                    columnNo = 4;
                else if (columnName.equals("Date In"))
                    columnNo = 5;
                else if (columnName.equals("Time Out"))
                    columnNo = 6;
                else if (columnName.equals("Date Out"))
                    columnNo = 7;
                else if (columnName.equals("Project No."))
                    columnNo = 8;
                else if (columnName.equals("Phase Sequence No."))
                    columnNo = 9;
                else if (columnName.equals("LI No."))
                    columnNo = 10;
                else if (columnName.equals("Actual Working Location"))
                {
                    if (checkTextExist("LI No.", true))
                        columnNo = 14;
                    else
                        columnNo = 12;
                }
                else if (columnName.equals("Employee Job Type"))
                {
                    if (checkTextExist("LI No.", true))
                        columnNo = 15;
                    else
                        columnNo = 13;
                }
                else if (columnName.equals("Trade Code"))
                {
                    if (checkTextExist("LI No.", true))
                        columnNo = 16;
                    else
                        columnNo = 14;
                }
                else if (columnName.equals("Leave Type"))
                {
                    if (checkTextExist("LI No.", true))
                        columnNo = 17;
                    else
                        columnNo = 15;
                }
            }
            else if (tabName.contains("Details"))
            {
                table = ElementID.xPathTableDetail;
                if (columnName.equals("Time In"))
                    columnNo = 3;
                else if (columnName.equals("Date In"))
                    columnNo = 2;
                else if (columnName.equals("Time Out"))
                    columnNo = 6;
                else if (columnName.equals("Date Out"))
                    columnNo = 5;
                else if (columnName.equals("Project No."))
                    columnNo = 8;
                else if (columnName.equals("Phase Sequence No."))
                    columnNo = 9;
                else if (columnName.equals("LI No."))
                    columnNo = 10;
                else if (columnName.equals("Employee Job Type"))
                    columnNo = 11;
                else if (columnName.equals("Trade Code"))
                    columnNo = 12;
                else if (columnName.equals("Actual Working Location"))
                {
                    if (checkTextExist("Trade Code", true))
                        columnNo = 14;
                    else
                        columnNo = 13;
                }
            }
            else if (tabName.contains("Additional"))
            {
                table = ElementID.xPathTableAddPayment;
                if (columnName.equals("Wage Service Description"))
                    columnNo = 2;
                else if (columnName.equals("Exchange Rate"))
                    columnNo = 4;
                else if (columnName.equals("Qty"))
                    columnNo = 5;
                else if (columnName.equals("Unit Price"))
                    columnNo = 6;
                else if (columnName.equals("Sales Tax"))
                    columnNo = 8;
            }
            // table[@id='frmConsolTS:tblManNoRecDet']/thead//th[3]//input
            xPath = table + "/thead//th[" + columnNo + "]//" + ElementID.TEXTBOX;
            try
            {
                element = getElement(xPath, 10);
                if (element != null)
                {
                    setTextAtElement(element, value, sleepTimeCellTextPY);
                    report("Filter data at: " + tabName + " at field " + columnName, value, PASSED, element);
                }
            } catch (Exception e)
            {
                report("Filter data at: " + tabName + " at field " + columnName, value, FAILED, element, e);
            }
        }
    }

    // setColumnValueInMultiList(columnName, "", "", ElementID.RADIO, "", 1,
    // false, true, actionValue);

    @Step("Set value {4} into {2} in record {1} of column {0}")
    public void setColumnValueInMultiList(String columnName, String searchValue, String textBoxColumnName, String type, String setValue, int order,
                                          boolean reverseSearch, boolean submitAll, String submitValue)
    {
        try
        {
            String searchButton = "";
            String searchButton2 = "";
            int ok = 0;
            if (reverseSearch == true)
            {
                searchButton = ElementID.NAVIGATE_LAST_BUTTON;
                searchButton2 = ElementID.NAVIGATE_PREVIOUS_BUTTON;
            }
            if (reverseSearch == false)
            {
                searchButton = ElementID.NAVIGATE_FIRST_BUTTON;
                searchButton2 = ElementID.NAVIGATE_NEXT_BUTTON;
            }
            element = getElementNoException(searchButton, 1);// get to last list or
            // first list
            if (element != null)
            {
                clickAtElement(element, 0.5);
            }
            WebElement ele = null;
            if (element != null)
            {
                // waitForElementToBeClickable(searchButton2, 10); // wait for page
                // to load after clicked last/first button
                ele = getElementNoException(searchButton2, 1);
                waitForElementToBeClickable(ele, 1);
            }

            while (true)
            {
                // loop
                // int rowPosition = 0;
                elements = getAllRowsInTable(columnName);
                String colPosition = tdCount;
                for (WebElement element : elements)
                {
                    if (submitAll)
                    {
                        List<WebElement> elementsTemp = null;
                        if (type.contains("radio"))
                        {
                            // element = getAllRowsInTable(columnName).get(rowPosition - 1); get the entire row
                            elementsTemp = getElementChildren(element, ElementID.RADIO);// get
                            // the radio in the row
                        }
                        if (notNull(elementsTemp))
                        {
                            // 0 for None, 1 for Approve, 2 for Reject
                            if (submitValue.equals("None"))
                            {
                                setRadioOption(elementsTemp.get(0));
                                ok = 1;
                            }
                            else if (submitValue.equals("Approve"))
                            {
                                setRadioOption(elementsTemp.get(1));
                                ok = 1;
                            }
                            else if (submitValue.equals("Reject"))
                            {
                                setRadioOption(elementsTemp.get(2));
                                ok = 1;
                            }
                            else if (submitValue.equals("Revise"))
                            {
                                setRadioOption(elementsTemp.get(2));
                                ok = 1;
                            }
                            else if (submitValue.equals("Fail"))
                            {
                                setRadioOption(elementsTemp.get(3));
                                ok = 1;
                            }
                        }
                        else
                            ok = 0;
                    }
                    else
                    {
                        // rowPosition = elements.indexOf(element) + 1;
                        // check if text has information button
                        String text = "";
                        text = getElementChildren(element, "//td[" + colPosition + "]").get(0).getText();
                        if (text.endsWith(" i"))
                        {
                            text = text.replace(" i", "");
                            text = text.trim();
                        }

                        if (text.equals(searchValue))
                        {// get all text in each row
                            ///// WARNING - may cause wrong behavior - should use element.getText().equals(searchValue) rowPosition = elements.indexOf(element) + 1;
                            if (type.contains("text"))
                            {
                                setTextAtTableCell(textBoxColumnName, getPhaseLineItem(text), setValue, order);
                                if (text.equals(searchValue))
                                {// get all text in each row
                                    // ///// WARNING - may cause wrong behavior - recommend use element.getText().equals(searchValue) rowPosition = elements.indexOf(element) + 1;
                                    if (type.contains("text"))
                                    {
                                        setTextAtTableCell(textBoxColumnName, getPhaseLineItem(text), setValue);
                                    }
                                    // set Checkbox - type = checkbox, setValue =
                                    // Yes or No
                                    if (type.contains("checkbox"))
                                    {
                                        // element = getAllRowsInTable(columnName).get(rowPosition - 1); // get the entire row
                                        elements = getElementChildren(element, ElementID.CHECKBOX);// get
                                        // the checkbox in the row
                                    }
                                    // set Radio - type = radio, setValue =
                                    // radioName
                                    if (type.contains("radio"))
                                    {
                                        // element = getAllRowsInTable(columnName).get(rowPosition - 1); // get the entire row
                                        elements = getElementChildren(element, ElementID.RADIO);// get
                                        // the radio in the row
                                    }
                                    if (notNull(elements))
                                    {
                                        if (type.contains("checkbox"))
                                            setCheckbox(elements.get(order - 1), setValue, 0.5);
                                        if (type.contains("radio"))
                                            setRadioOption(elements.get(order - 1));
                                    }
                                    ok = 1;
                                    break;
                                }
                            }
                        }
                        if (ok == 1)
                        {
                            report("Found and set data at: " + textBoxColumnName + " with field " + columnName + ": " + searchValue, setValue,
                                   PASSED);
                            break;
                        }
                        else
                        {
                            waitForElementToBeClickable(ele, 3);
                            if (ele != null)
                            {// end of page list
                                if (!ele.isEnabled())
                                    break;
                            }
                            else
                            {
                                clickAtElement(ele, 0.5);
                                waitForElementToBeClickable(searchButton, 10);// wait
                                // for list to load after clicked next/previous button
                            }
                        }
                    }
                }
                // loop
            }
        } catch (Exception e)
        {
            report("Found and set data at: " + textBoxColumnName + " with field " + columnName + ": " + searchValue, setValue, FAILED, e);
        }
    }

    // for project menus
    public int getPhaseLineItem(String phaseNo)
    {
        String xPath = "//td[starts-with(@class, 'rich-table-cell')][text()='" + phaseNo + "']/parent::tr/preceding-sibling::tr | //td[text()='" + phaseNo + "']/parent::td/parent::tr/preceding-sibling::tr | (//td[starts-with(@class, 'rich-table-cell')" + "]/span[text()='" + phaseNo

                + "']/ancestor::tr[1]/preceding-sibling::tr)";
        int result = getElementsCount(xPath) + 1;
        print("Get phase " + phaseNo + " to row: " + result);
        return result;
    }

    public int getPhaseLineItem(String phaseNo, int order)
    {
        String xPath = "(//td[starts-with(@class, 'rich-table-cell')][text()='" + phaseNo + "']/parent::tr)[" + order + "]/preceding-sibling::tr" + " | (//td[text()='" + phaseNo + "']/parent::td/parent::tr)[" + order + "]/preceding-sibling::tr" + " | (//td[starts-with(@class, 'rich-table-cell')]/span[text()='" + phaseNo + "']/ancestor::tr/preceding-sibling::tr)[last()]";
        int result = getElementsCount(xPath) + 1;
        print("Found row: " + result + " for phase " + phaseNo + " on path: " + xPath);
        return result;
    }

    // for project menus
    @Step("Select record with phase no {0}")
    public void selectLineItem(String phaseNo)
    {
        try
        {
            int parentPhaseLine = getPhaseLineItem(phaseNo);
            // select parent line
            String xPath = "//*[text()='Phase No']/ancestor::table[1]/tbody/tr[" + parentPhaseLine + "]/td[1]//input";
            element = getElement(xPath, 1);
            print("Select phase no: " + phaseNo);

            waitForElementToBeClickable(element, 10);
            element = getElement(xPath, 1);
            if (element != null && !isChecked(element) && element.isEnabled() && element.isDisplayed())
            {
                element.click();
                waitForElementToBeSelected(element, 1);
                waitForAjax(3);
                report("Select record with phase no", phaseNo, PASSED);
            }
            else
            {
                print("Could not find " + xPath);
                report("Select record with phase no", phaseNo, FAILED);
            }
        } catch (Exception e)
        {
            report("Select record with phase no", phaseNo, FAILED, e);
        }
    }

    // for project menus
    public void addPhaseNo(String phaseNo)
    {
        if (!phaseNo.equals(""))
        {
            // count items in table, if empty, add phase 1
            String xPath = "//*[text()='Phase No']/ancestor::table[1]/tbody/tr";
            int rowsCount = getElementsCount(xPath);
            // add phase 1
            if (phaseNo.equals("1") && rowsCount == 0)
            {
                clickButton("Add Phase");
                waitForElementToShow("//*[text()='Phase No']/ancestor::table[1]//*[text()=\"" + phaseNo + "\"]", 10);
            }
            // add parent phase
            if (!phaseNo.equals("1") && phaseNo.length() == 1)
            {
                clickButton("Add Phase");
                waitForElementToShow("//*[text()='Phase No']/ancestor::table[1]//*[text()=\"" + phaseNo + "\"]", 10);
            }
            // add sub phase
            if (phaseNo.length() > 2 && phaseNo.contains("."))
            {
                // get the parent phase (the phase before the ".x")
                String parentPhase = "";
                try
                {
                    parentPhase = phaseNo.substring(0, phaseNo.length() - 2);
                } catch (Exception e)
                {
                    parentPhase = "";
                }
                if (parentPhase.length() > 0)
                {
                    selectLineItem(parentPhase);
                    // add sub phase
                    clickButton("Add Sub Phase");
                    waitForElementToShow("//*[text()='Phase No']/ancestor::table[1]//*[text()=\"" + phaseNo + "\"]", 10);
                }
            }
            waitForAjax(2);
        }
    }

    public void setTextAtSalesTaxInvoice(String columnName, String salesTaxCode, String value)
    {
        String xPath = "//td[text()='" + salesTaxCode + "']/parent::tr/preceding-sibling::tr";
        int row = getElementsCount(xPath) + 1;
        xPath = "//td[text()='" + columnName + "']//preceding-sibling::td";
        int column = getElementsCount(xPath) + 1;
        xPath = "//td[text()='Sales Tax Amount']/ancestor::table[1]";
        setTextAtXpathCSS("//td[text()='" + columnName + "']/ancestor::table[1]//tr[" + row + "]/td[" + column + "]//input", value);
    }

    // check = Yes or No
    @Step("Set checkbox option = {2} in record {1} of column {0}")
    public void setCheckBoxAtMultiList(String flagColumnName, String flagValue, String check, boolean reverseSearch)
    {
        setColumnValueInMultiList(flagColumnName, flagValue, "", ElementID.CHECKBOX, check, 1, reverseSearch, false, "");
    }

    @Step("Set checkbox option = {2} in record {1} of column {0}")
    public void setCheckBoxAtMultiList(String flagColumnName, String flagValue, String check, int order, boolean reverseSearch)
    {
        setColumnValueInMultiList(flagColumnName, flagValue, "", ElementID.CHECKBOX, check, order, reverseSearch, false, "");
    }

    @Step("Set checkbox option 1 = {2}, option 2 = {3} in record {1} of column {0}")
    public void setCheckBoxAtMultiList(String flagColumnName, String flagValue, String check1, String check2, boolean reverseSearch)
    {
        setColumnValueInMultiList(flagColumnName, flagValue, "", ElementID.CHECKBOX, check1, 1, reverseSearch, false, "");
        setColumnValueInMultiList(flagColumnName, flagValue, "", ElementID.CHECKBOX, check2, 2, reverseSearch, false, "");
    }

    @Step("Choose option {2} in record {1} of {0}")
    public void setRadioAtMultiList(String flagColumnName, String flagValue, String radioName, boolean reverseSearch)
    {
        setColumnValueInMultiList(flagColumnName, flagValue, "", ElementID.RADIO, radioName, 1, reverseSearch, false, "");
    }

    @Step("Choose approval option = {1} in {0}")
    public void setRadioApprovalAtMultiList(String columnName, String actionValue)
    {
        setColumnValueInMultiList(columnName, "", "", ElementID.RADIO, "", 1, false, true, actionValue);
    }

    @Step("Input {4} into {2} in record {1} of {0}")
    public void setTextAtMultiList(String flagColumnName, String flagValue, String textBoxColumnName, String type, String value,
                                   boolean reverseSearch)
    {
        setColumnValueInMultiList(flagColumnName, flagValue, textBoxColumnName, ElementID.TEXTBOX, value, 1, reverseSearch, false, "");
    }

    @Step("Input {4} into {2} in record {1} of {0}")
    public void setTextAtMultiList(String flagColumnName, String flagValue, String textBoxColumnname, String type, String value, int order,
                                   boolean reverseSearch)
    {
        setColumnValueInMultiList(flagColumnName, flagValue, textBoxColumnname, ElementID.TEXTBOX, value, 1, reverseSearch, false, "");
    }

    /**
     * Customer signing - used for CnR in SEMBAS
     */
    @Step("Customer sign")
    public void customerSign()
    {
        clickButton("Customer Sign");
        waitForTextToShow("Signature", 5);
        Point[] points = new Point[2];
        points[0] = new Point(0, 0);
        points[1] = new Point(100, 100);
        dragAndDropInsidePanel("//canvas[@id='myScribble']", points);
        clickButton("Save");
    }

    // use for checking value of result next to search icon in module config
    @Deprecated
    // Used for text only
    public boolean isSameSearchResult(String labelText, String value) throws Exception
    {
        if (notEmpty(value))
        {
            elements = getElementsNextToElement(labelText, "tr");
            if (notNull(elements))
            {
                String text = elements.get(0).getText();
                if (text.equals(value))
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        return true;
    }

    public boolean checkUntaggedNumberingScheme()
    {
        if (!getTextByXpathCSSNoException("//span[@class='error-message' and contains(text(), 'numbering scheme')]").equals(""))
            return true;
        else
            return false;
    }

    public boolean isButtonClickable(String buttonName)
    {
        try
        {
            element = getElementNoException("input[type='button'][value=\"" + buttonName + "\"]", 1);
            if (isEnable(element))
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static String getModuleCode(String text)
    {
        String code = ReadBean.getStringBetween(ReadBean.getStringBetween(text, ":", ","), "'", "'");
        return code;
    }

    public static String getTransactionCode(String text)
    {
        String[] as = text.split(",");
        String code = ReadBean.getStringBetween(as[1], "'", "'");
        return code;
    }

    public String getNumberingSchemeModuleCode()
    {
        String errorMes = getTextByXpathCSS("//span[@class='error-message' and contains(text(), 'numbering scheme')]");
        return getModuleCode(errorMes);
    }

    public String getNumberingSchemeTransactionCode()
    {
        String errorMes = getTextByXpathCSS("//span[@class='error-message' and contains(text(), 'numbering scheme')]");
        return getTransactionCode(errorMes);
    }

    /**
     * First designed for Project Claim by Work done, can cater for more cases
     * <br>
     * Get sequence of existing row in a table
     *
     * @param tableColumnName A unique name in Header of the table
     * @param value           The value inside the row
     * @return The number of the row in screen table
     * @author Jack
     */
    public int getRowNumber(String tableColumnName, String value)
    {
        // levin add search for row by value in a text box
        // String xPath = "(//thead//*[contains(text(),\"" + tableColumnName +
        // "\")]/ancestor::table[1]//*[text()='"
        // + value + "']/ancestor::tr[1]/preceding-sibling::tr) |
        // (//thead//*[contains(text(),\"" + tableColumnName
        // + "\")]/ancestor::table[1]//input[@value=\"" + value +
        // "\"]/ancestor::tr[2]/preceding-sibling::tr)";
        // return getRowCount(xPath) + 1;
        // improve performance in case preceding-sibling returns 0

        if (!checkElementVisible("//*[text()=\"" + value + "\" or @value='" + value + "'] | //td//*[text()=\"" + value + "\"]"))
            return 0;

        String xPath = "(//thead//*[contains(text(),\"" + tableColumnName + "\")]/ancestor::table[1]//*[text()='" + value + "' or @value='" + value + "']/ancestor::tr[1]/parent::*/child::tr) | (//thead//*[contains(text(),\"" + tableColumnName + "\")]/ancestor::table[1]//input[@value=\"" + value + "\"]/ancestor::tr[2]/parent::*/child::tr)";
        int totalRows = getElementsCount(xPath);
        if (totalRows == 1 && checkElementVisible("//*[text()=\"" + value + "\" or @value='" + value + "'] | //td//*[text()=\"" + value + "\"]"))
        {
            return 1;
        }
        else
        {
            xPath = "(//thead//*[contains(text(),\"" + tableColumnName + "\")]/ancestor::table[1]//*[text()='" + value + "' or @value='" + value + "']/ancestor::tr[1]/preceding-sibling::tr) | (//thead//*[contains(text(),\"" + tableColumnName + "\")]/ancestor::table[1]//input[@value=\"" + value + "\"]/ancestor::tr[2]/preceding-sibling::tr)";
            if (checkElementVisible("//*[text()=\"" + value + "\" or @value='" + value + "'] | //td//*[text()=\"" + value + "\"]"))
                return getElementsCount(xPath) + 1;
            else
                return 0;
        }
    }

    /**
     * First designed for Project Claim by Work done, can cater for more cases
     *
     * @param tableColumnName A unique name in Header of the table
     * @return The total number of the row in screen table
     * @author Jack
     */
    public int getRowsCount(String tableColumnName)
    {
        String xPath = "//thead//*[contains(text(),\"" + tableColumnName + "\")]/ancestor::thead[1]/following-sibling::tbody/tr[starts-with(@class,\"rich-table-row\")]";
        print("Get rows count Xpath: " + xPath + "");
        print("Table column: " + tableColumnName);
        waitForElementToShow(xPath, 1);
        int result = getElementsCount(xPath);
        print("Counted rows: " + result);
        return result;
    }

    public void waitForNewRow(String columnName, int currentNo)
    {
        int current = getRowsCount(columnName);
        print("Wait for new row: " + current + "/" + currentNo);
        if (current - currentNo != 1)
        {
            waitForAjax((long) 0.5);
            waitForNewRow(columnName, currentNo);
        }
        waitForAjax(1);
    }

    /**
     * Wait for new row in time out period
     *
     * @param columnName
     * @param currentNo
     * @param timeOut
     */
    public void waitForNewRow(String columnName, int currentNo, double timeOut)
    {
        int current = getRowsCount(columnName);
        print("Wait for new row: " + current + "/" + currentNo);
        if (current - currentNo != 1 && timeOut >= 0)
        {
            waitForAjax((long) 0.5);
            waitForNewRow(columnName, currentNo, timeOut - 0.5);
        }
        waitForAjax(1);
    }

    /**
     * Wait for text description show after inputting text field
     *
     * @param labelText The label of the text
     * @param timeOut   The time out of method
     * @author Jack
     */
    public void waitForTextDescToShow(String labelText, long timeOut)
    {
        String xPath = "";
        if (labelText.contains("\""))
            xPath = "//*[@id=\"mainPanel\"]//*[text()='" + labelText + "']/ancestor-or-self::td/following-sibling::td[position()<4]//span[" + "contains(translate(@id, 'DESC', 'desc'),'desc')" + " or contains(translate(@id, 'NAME', 'name'),'name')" + " or contains(translate(@class, 'DESC', 'desc'),'desc')" + " or contains(translate(@class, 'NAME', 'name'),'name')][1]";
        else
            xPath = "//*[@id=\"mainPanel\"]//*[text()=\"" + labelText + "\"]/ancestor-or-self::td/following-sibling::td[position()<4]//span[" + "contains(translate(@id, 'DESC', 'desc'),'desc')" + " or contains(translate(@id, 'NAME', 'name'),'name')" + " or contains(translate(@class, 'DESC', 'desc'),'desc')" + " or contains(translate(@class, 'NAME', 'name'),'name')][1]";
        waitForElementToShow(xPath, timeOut);
    }

    /**
     * Wait for the filter to show in any column of specified row. This method
     * is only applied to the tables with sorters.
     *
     * @param value   The text to wait
     * @param timeOut Time out to wait
     * @param row     The row where the value is expected to be in, 0 will look for
     *                all rows
     * @author Jack
     */
    public void waitForTableFilter(String value, int row, long timeOut)
    {
        if (row == 0)
            waitForElementToShow("//a[@class=\"sorter\"]/ancestor::thead[1]/following-sibling::tbody[1]//tr//*[text()=\"" + value + "\"]", timeOut);
        else
            waitForElementToShow(
                    "//a[@class=\"sorter\"]/ancestor::thead[1]/following-sibling::tbody[1]//tr[" + row + "]//*[text()=\"" + value + "\"]", timeOut);
    }// wait for page update after input a mandatory field

    // wait for page update after input a mandatory (red) field
    public void waitForMandatoryField(String labelText, long timeOut)
    {
        try
        {
            String xPath = "";
            String mandatory = "";
            if (labelText.contains("\""))
                xPath = "//*[text()='" + labelText + "']";
            else
                xPath = "//*[text()=\"" + labelText + "\"]";
            element = getElementNoException(xPath, 0);
            mandatory = element.getAttribute("class");
            try
            {
                mandatory.equals("mandatory");
            } catch (NullPointerException e)
            {
                mandatory = "false";
            }
            if (mandatory.equals("mandatory"))
            {
                print("Waiting for mandatory fields");
                waitForElementToBeInputtable(getElementsNextToElement(labelText, ElementID.TEXTBOX).get(0), 1);
            }
        } catch (Exception e)
        {
        }
    }
}