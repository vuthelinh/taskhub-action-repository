package com.synergix.common.constants;

public class ElementID_TH6
{
    public static final String BUTTON                 = "button";
    public static final String BUTTON_WITHOUT_NAME    = "button//span[@class='ui-button-text ui-c']";
    public static final String BUTTON_ADD             = "span[contains(@class, 'fa-plus')]/ancestor::button[@type='submit']";
    public static final String BUTTON_DEL             = "span[contains(@class, 'fa-trash-o')]/ancestor::button[@type='submit']";
    public static final String TEXTBOX                = "input[@role='textbox']";
    public static final String DROPDOWNOPTION         = "select[@class='combo']";
    public static final String DROPDOWN_BUTTON        = "*[contains(@class, 'ui-autocomplete-dropdown') or contains(@class, 'ui-icon ui-icon-triangle-1-s ui-c') or contains(@class,'ui-selectonemenu ui-widget ui-state-default')]";
    public static final String SPAN                   = "span";
    public static final String OPTION                 = "option";
    public static final String SELECT                 = "select";
    public static final String LI                     = "li";
    public static final String SEARCHICON             = "button[contains(@class,'synfaces-search-button')]";
    public static final String INFO_ICON              = "*[@class='text-icon'][text()='i']";
    public static final String TEXTAREA               = "textarea";
    public static final String CHECKBOX_OLD           = "input[@type='checkbox']";
    public static final String CHECKBOX               = "div[contains(@class,'ui-chkbox-box')]";
    public static final String RADIO                  = "input[@type='radio']";
    public static final String LINK                   = "a[@href]";
    public static final String VARIATION              = "span";
    public static final String CALENDAR_BUTTON        = "img[@class='rich-calendar-button']";
    public static final String CALENDAR_MONTH_BUTTON  = "td[class='rich-calendar-month'] div";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         // css
    public static final String CALENDAR_TOOL_BUTTON   = "td[class='rich-calendar-tool'] div";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         // css
    public static final String CALENDAR_EDITOR_BUTTON = "//div[@class='rich-calendar-editor-btn']";
    public static final String CALENDAR_OK_BUTTON     = "//span[text()='OK']";
    public static final String CLOSE_BUTTON           = "input[type='button'][value='Close']";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         // css
    public static final String CLOSE_ICON             = "//span[@class='ui-icon ui-icon-closethick']";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         // css
    public static final String ERROR_MESSAGE          = "//span[@class='error-message']";
    public static final String REMARK_ICON            = "img[contains(@src, 'remarks')]";
    public static final String NUMBER_ICON            = "span[@class='display-number']";
    public static final String TEXT_VALUE             = "span[@class='description']";
    public static final String TABLE_ROW              = "tr[@class='ui-widget-content ui-datatable-even']";
    public static final String LABEL                  = "label";
    public static final String HOME_BUTTON            = "//a[@class='ui-menuitem-link ui-corner-all ui-icon ui-icon-home']";

    public static final String DATE_PICKER = "//div[contains(@class,'ui-datepicker-header ui')]";

    public static final String SEARCH_CLOSE_BUTTON = "//img[contains(@src, 'close-icon')]";
    public static final String GREEN_ARROW_BUTTON  = "img[contains(@src, 'greenarrow')]";
    public static final String BOOKMARK_BUTTON     = "//img[contains(@src, 'Bookmark')]";

    public static final String NAVIGATE_FIRST_BUTTON    = "//*[contains(@class, 'rich-datascr-button')][text()='««']";
    public static final String NAVIGATE_PREVIOUS_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='«']";
    public static final String NAVIGATE_LAST_BUTTON     = "//*[contains(@class, 'rich-datascr-button')][text()='»»']";
    public static final String NAVIGATE_NEXT_BUTTON     = "//*[contains(@class, 'ui-icon ui-icon-seek-next')]";

    public static final String MAIN_PANEL = "//span[@id=\"mainPanel\"]";

    public static final String DROPDOWN_ICON       = "span[@class='ui-icon ui-icon-triangle-1-s ui-c']";
    public static final String DROPDOWN_GREEN_ICON = "//*[@class='ui-row-toggler ui-icon ui-icon-circle-triangle-e']";

    public static final String CONFIRM_DIALOG = "//div[contains(@id,'globalConfirmationForm')]";
    public static final String ERROR_DIALOG   = "*[class='ui-growl-message']";
    public static final String YES_CONFIRM    = "//button[contains(@id, 'globalConfirmationForm')]//span[text()='Yes']";
    public static final String NO_CONFIRM     = "//button[contains(@id, 'globalConfirmationForm')]//span[text()='No']";
    public static final String OK_CONFIRM     = "//input[@id='statusPopupPanel_OkButton'] | //input[@id='ErrorForm:OKButton'] | //input[@value='OK']";
    public static final String ERROR_ICON     = "//span[@class='ui-growl-image ui-growl-image-error']";

    public static final String TABLE_HEADER_TAG    = "*[contains(@role, 'header')]";
    public static final String PROGRESS_CIRCLE     = "//img[contains(@src, 'ajax-throbber')]";
    public static final String AJAX_LOADER         = "//img[contains(@src, 'ajax-loader')]";
    public static final String PROGRESS_BAR_UNLOAD = "//div[@id='transparentBlockUI_blocker'][contains(@style,'display: none;')]";
    public static final String PROGRESS_BAR_BLOCK  = "//div[@id='transparentBlockUI_blocker'][contains(@style,'display: block;')]";
    public static final String AJAX_MODE           = "TH6";
}
