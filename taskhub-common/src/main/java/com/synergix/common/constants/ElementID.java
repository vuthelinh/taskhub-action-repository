package com.synergix.common.constants;

public class ElementID
{
    public static final String REPORT_FILE = "C:/report.txt";

    public static final String BUTTON                 = "input[@type='button']";
    public static final String TEXTBOX                = "input[@type='text']";
    public static final String DROPDOWNOPTION         = "select[@class='combo']";
    public static final String SPAN                   = "span";
    public static final String OPTION                 = "option";
    public static final String SEARCHICON             = "*[contains(@src, 'lookup')]";
    public static final String INFO_ICON              = "*[@class='text-icon'][text()='i']";
    public static final String TEXTAREA               = "textarea";
    public static final String CHECKBOX               = "input[@type='checkbox']";
    public static final String RADIO                  = "input[@type='radio']";
    public static final String LINK                   = "a[@href]";
    public static final String VARIATION              = "span[text()='i']";
    public static final String CALENDAR_BUTTON        = "img[@class='rich-calendar-button']";
    public static final String CALENDAR_TODAY_BUTTON  = "//div[@class='rich-calendar-tool-btn'][text()='Today']";
    public static final String CALENDAR_MONTH_BUTTON  = "td[class='rich-calendar-month'] div";                                                                                                                                                    //css
    public static final String CALENDAR_TOOL_BUTTON   = "td[class='rich-calendar-tool'] div";                                                                                                                                                                            //css
    public static final String CALENDAR_EDITOR_BUTTON = "//div[@class='rich-calendar-editor-btn' or @class='rich-calendar-editor-btn rich-calendar-editor-btn-selected']";
    public static final String CALENDAR_OK_BUTTON     = "//span[text()='OK']";
    public static final String CLOSE_BUTTON           = "input[type='button'][value='Close']";                                                                                                                                                    //css
    public static final String ERROR_MESSAGE          = "//span[@class='error-message']";
    public static final String REMARK_ICON            = "img[contains(@src, 'remarks')]";
    public static final String NUMBER_ICON            = "span[@class='display-number' or @class='display-number amt']";
    public static final String TEXT_VALUE             = "span[@class='description']";

    public static final String SEARCH_CLOSE_BUTTON = "//img[contains(@src, 'close-icon')]";
    public static final String GREEN_ARROW_BUTTON  = "img[contains(@src, 'greenarrow')]";
    public static final String BOOKMARK_BUTTON     = "//img[contains(@src, 'Bookmark')]";

    public static final String NAVIGATE_FIRST_BUTTON    = "//*[contains(@class, 'rich-datascr-button')][text()='««']";
    public static final String NAVIGATE_PREVIOUS_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='«']";
    public static final String NAVIGATE_LAST_BUTTON     = "//*[contains(@class, 'rich-datascr-button')][text()='»»']";
    public static final String NAVIGATE_NEXT_BUTTON     = "//*[contains(@class, 'rich-datascr-button')][text()='»']";

    public static final String MAIN_PANEL     = "//span[@id=\"mainPanel\"]";
    public static final String PROGRESS_PANEL = "//*[contains(@id, 'modalProgressPanelDiv')]";

    public static final String TABLE_HEADER_TAG = "*[contains(@*, 'header')]";
    public static final String AJAX_MODE        = "TH5";

    public static final String xPathTableManual     = "//table[@id='frmDraftTS:tblManDet']";
    public static final String xPathTableLeave      = "//table[@id='frmdraftts:tbllvdet' or @id='DetailFrmId:EmployeesTblId' or @id='DetailFrmId:tblLeaveTypes']";
    public static final String xPathTableImport     = "//table[@id='frmDraftTS:tblImpDet']";
    public static final String xPathTableNoRecord   = "//table[@id='frmConsolTS:tblManNoRecDet']";
    public static final String xPathTableDetail     = "//table[@id='DetailForm:detailTable']";
    public static final String xPathTableAddPayment = "//table[contains(@id, 'empServDetailTable')]";
}
