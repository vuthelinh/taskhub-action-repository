package com.synergix.common.constants;

import java.lang.reflect.Field;

public class MenuID
{
    // MENUIDs
    // Maintainance Setup
    public static final String MS_PROCESSING_NUMBERING = "menuForm:menu_01123:anchor";

    // Opening Balance
    public static final String OB_AP                       = "menuForm:menu_137:anchor";
    public static final String OB_AR                       = "menuForm:menu_135:anchor";
    public static final String OB_FINANCIAL_PERIOD_OPENING = "menuForm:menu_136:anchor";
    public static final String OB_IR8A_OPENING_BALANCE     = "menuForm:menu_139:anchor";
    public static final String OB_FIXED_ASSET              = "menuForm:menu_8266:anchor";

    // Maintenance
    public static final String MT_APPROVING_OFFICER                   = "menuForm:menu_01130:anchor";
    public static final String MT_FI_ACC_PERROD_AND_CLOSING_TH2       = "menuForm:menu_01316:anchor";
    public static final String MT_FI_ACC_PERROD_AND_CLOSING_TH5       = "menuForm:menu_0131600:anchor";
    public static final String MT_PJ_TEMPLATE                         = "menuForm:menu_01863:anchor";
    public static final String MT_MODULE_CONFIG                       = "menuForm:menu_0270401:anchor";
    public static final String MT_INVENTORY_BOM                       = "menuForm:menu_014402:anchor";
    public static final String MT_ROLE_MASTER                         = "menuForm:menu_01145:anchor";
    public static final String MT_USER_ROLE_ACCESS                    = "menuForm:menu_01148:anchor";
    public static final String MT_PARTY_BANK_TH2                      = "menuForm:menu_01611:anchor";
    public static final String MT_FI_ACC_BANK_BOOK_RECURRING_TEMPLATE = "menuForm:menu_0131500:anchor";
    public static final String MT_FI_ACC_GL_RECURRING_VOUCHER         = "menuForm:menu_013151:anchor";
    public static final String MT_FI_ACC_GL_REVALUATION               = "menuForm:menu_013156:anchor";
    public static final String MT_PY_HOURLY_RATE_GROUP                = "menuForm:menu_02655:anchor";
    public static final String MT_FI_ACC_FINANCIAL_YEAR_PERIOD        = "menuForm:menu_0131677:anchor";
    public static final String MT_FI_CUR_EXCHANGE_RATE                = "menuForm:menu_013221:anchor";

    // Processing
    public static final String PROC_APPROVAL_SUMMARY = "menuForm:menu_0303:anchor";

    public static final String PROC_APOINTMENT_BOOKING = "menuForm:menu_0107:anchor";

    public static final String PROC_AP_INVOICE             = "menuForm:menu_03132:anchor";
    public static final String PROC_AP_INVOICE_TH2         = "menuForm:menu_0313:anchor";
    public static final String PROC_AP_PAYMENT             = "menuForm:menu_03142:anchor";
    public static final String PROC_AP_PAYMENT_SUGGESTION  = "menuForm:menu_8269:anchor";
    public static final String PROC_AP_PAYMENT_TO_CUSTOMER = "menuForm:menu_031401:anchor";
    public static final String PROC_AP_CREDITNOTE          = "menuForm:menu_03123:anchor";
    public static final String PROC_AP_CREDITNOTE_TH2      = "menuForm:menu_0312:anchor";
    public static final String PROC_AP_SYSTEM_SETUP        = "menuForm:menu_031701:anchor";
    public static final String PROC_AP_REVALUATION         = "menuForm:menu_8241:anchor";
    public static final String PROC_AP_CONTRA              = "menuForm:menu_03107:anchor";
    public static final String PROC_AP_MATCHING_CUSTOM     = "menuForm:menu_8270:anchor";

    public static final String PROC_AR_INVOICE              = "menuForm:menu_032301:anchor";
    public static final String PROC_AR_RECEIPT              = "menuForm:menu_03241:anchor";
    public static final String PROC_AR_RECEIPT_TH2          = "menuForm:menu_0324:anchor";
    public static final String PROC_AR_CREDITNOTE           = "menuForm:menu_032201:anchor";
    public static final String PROC_AR_SYSTEM_SETUP         = "menuForm:menu_032701:anchor";
    public static final String PROC_AR_REVALUATION          = "menuForm:menu_8240:anchor";
    public static final String PROC_AR_RECEIPT_CANCELLATION = "menuForm:menu_03253:anchor";

    public static final String PROC_CON_CONSOLIDAITON_VCH = "menuForm:menu_04401:anchor";

    public static final String PROC_CMS_BILLING             = "menuForm:menu_032840:anchor";
    public static final String PROC_PAYROLLTIMESHEET        = "menuForm:menu_04894:anchor";
    public static final String PROC_CMS_BILLING_CREDIT_NOTE = "menuForm:menu_032835:anchor";
    public static final String PROC_CMS_BILLING_CLAIM       = "menuForm:menu_032850:anchor";

    public static final String PROC_CRM_LEAD = "menuForm:menu_0462010:anchor";

    public static final String PROC_BK_TRANSACTION        = "menuForm:menu_032716:anchor";
    public static final String PROC_BK_RECONCILIATION     = "menuForm:menu_032720:anchor";
    public static final String PROC_BK_REVALUATION        = "menuForm:menu_032724:anchor";
    public static final String PROC_BK_GENERATE_RECURRING = "menuForm:menu_032770:anchor";
    public static final String PROC_BK_SYSTEM_SETUP       = "menuForm:menu_032780:anchor";

    public static final String PROC_CYL_CS_PROPOSAL = "menuForm:menu_03308001:anchor";
    public static final String PROC_CYL_CS_CONTRACT = "";

    public static final String PROC_FA_HOLDING                   = "menuForm:menu_033710:anchor";
    public static final String PROC_FA_GENERATE_DEPRECIATION_VCH = "menuForm:menu_033711:anchor";
    public static final String PROC_FA_DEPRECIATION_VCH          = "menuForm:menu_033712:anchor";
    public static final String PROC_FA_SYSTEM_SETUP              = "menuForm:menu_0337601:anchor";
    public static final String PROC_FA_DISPOSAL_VCH              = "menuForm:menu_8264:anchor";
    public static final String PROC_FA_CHANGE_LOCATION           = "menuForm:menu_8265:anchor";

    public static final String PROC_PJ_QUOTATION                          = "menuForm:menu_01862:anchor";
    public static final String PROC_PJ_ESTIMATION                         = "menuForm:menu_64011:anchor";
    public static final String PROC_PJ_COSTALLOCATION                     = "menuForm:menu_03717:anchor";
    public static final String PROC_PJ_BILLING                            = "menuForm:menu_03718:anchor";
    public static final String PROC_PJ_CLAIM                              = "menuForm:menu_03719:anchor";
    public static final String PROC_PJ_SCHEDULER                          = "menuForm:menu_12016:anchor";
    public static final String PROC_PJ_CREDITNOTE                         = "menuForm:menu_12012:anchor";
    public static final String PROC_PJ_RECOGNITION                        = "menuForm:menu_12015:anchor";
    public static final String PROC_PJ_GLOBALDAILYSITEPLANNING            = "menuForm:menu_03740:anchor";
    public static final String PROC_PJ_DRAFTBILL1                         = "menuForm:menu_12121:anchor";
    public static final String PROC_PJ_DRAFTBILL                          = "menuForm:menu_03730:anchor";
    public static final String PROC_PJ_PACKING_LIST_FOR_MATERIAL_OFF_SITE = "menuForm:menu_91182:anchor";
    public static final String PROC_SUB_CONTRACT                          = "menuForm:menu_11111:anchor";
    public static final String PROC_SUB_CLAIM                             = "menuForm:menu_12121:anchor";

    public static final String PROC_PR_PURCHASE_ORDER                = "menuForm:menu_038235:anchor";
    public static final String PROC_PR_PURCHASE_REQUISITION          = "menuForm:menu_038226:anchor";
    public static final String PROC_PR_REQUISITION_COMBINE           = "menuForm:menu_038227:anchor";
    public static final String PROC_PR_PR_SYSTEM_SETUP               = "menuForm:menu_038228:anchor";
    public static final String PROC_PR_PO_SYSTEM_SETUP               = "menuForm:menu_038232:anchor";
    public static final String PROC_PR_TIMESHEET_DETAIL_FOR_EMPLOYEE = "menuForm:menu_2233:anchor";

    public static final String PROC_LOG_ACTIVE_INCOMMINGSHIPMENT     = "menuForm:menu_03621:anchor";
    public static final String PROC_LOG_ACTIVE_OUTGOINGSHIPMENT      = "menuForm:menu_03624:anchor";
    public static final String PROC_LOG_PLANNING_BILLINGPURCHASE     = "menuForm:menu_03663:anchor";
    public static final String PROC_LOG_MERGESHIPMENT_OUTGOING       = "menuForm:menu_03633:anchor";
    public static final String PROC_LOG_MERGESHIPMENT_INCOMING       = "menuForm:menu_03634:anchor";
    public static final String PROC_LOG_COMBINE_OUTGOINGSHIPMENT     = "menuForm:menu_036854:anchor";
    public static final String PROC_LOG_PANNING_BILLINGSALES         = "menuForm:menu_03662:anchor";
    public static final String PROC_LOG_SYSTEM_SETUP                 = "menuForm:menu_03991:anchor";
    public static final String PROC_LOG_WEIGHING_BRIDGE_DO           = "menuForm:menu_03744:anchor";
    public static final String PROC_LOG_WEIGHING_BRIDGE_RO           = "menuForm:menu_03745:anchor";
    public static final String PROC_LOG_WEIGHING_BRIDGE_BILLING_SALE = "menuForm:menu_03746:anchor";
    public static final String PROC_LOG_TRANSFERORDER                = "menuForm:menu_03691:anchor";

    public static final String PROC_SALES_QUOTATION    = "menuForm:menu_03931:anchor";
    public static final String PROC_SALES_ORDER        = "menuForm:menu_03923:anchor";
    public static final String PROC_SALES_SYSTEM_SETUP = "menuForm:menu_0395:anchor";

    public static final String PROC_IC_STOCKISSUE       = "menuForm:menu_70000:anchor";
    public static final String PROC_IC_STOCKRETURN      = "menuForm:menu_70030:anchor";
    public static final String PROC_IC_STOCKTAKESUMMARY = "menuForm:menu_8244:anchor";
    public static final String PROC_IC_INVENTORYVOUCHER = "menuForm:menu_0352:anchor";

    public static final String PROC_MFG_PP                     = "menuForm:menu_04122:anchor";
    public static final String PROC_MFG_FS                     = "menuForm:menu_041228:anchor";
    public static final String PROC_MF_MRP                     = "menuForm:menu_041223:anchor";
    public static final String PROC_MFG_WO                     = "menuForm:menu_041241:anchor";
    public static final String PROC_MFG_SVV                    = "menuForm:menu_23512:anchor";    // SOURCE VOUCHER VARIATION
    public static final String PROC_MFG_SYSTEM_SETUP           = "menuForm:menu_04125:anchor";
    public static final String PROC_MFG_BOMVARIATION           = "menuForm:menu_24512:anchor";
    public static final String PROC_MFG_BOMREPLACEMENT         = "menuForm:menu_25512:anchor";
    public static final String PROC_MFG_MAV                    = "menuForm:menu_16413:anchor";
    public static final String PROC_MFG_MOV                    = "menuForm:menu_75120:anchor";
    public static final String PROC_MFG_SRP                    = "menuForm:menu_041232:anchor";
    public static final String PROC_MFG_MACHINECAPACITY        = "menuForm:menu_16412:anchor";
    public static final String PROC_MFG_MACHINECENTER          = "menuForm:menu_170103:anchor";
    public static final String PROC_MFG_SPLITPRODUCTION        = "menuForm:menu_83213:anchor";
    public static final String PROC_MFG_REWORK                 = "menuForm:menu_83215:anchor";
    public static final String PROC_MFG_EMPLOYEEDAILYTIMESHEET = "menuForm:menu_300103:anchor";

    public static final String PROC_QAQC_QIJA = "menuForm:menu_027051:anchor";
    public static final String PROC_QAQC_QI   = "menuForm:menu_027052:anchor";
    public static final String PROC_QAQC_NCR  = "menuForm:menu_027053:anchor";

    public static final String PROC_SV_ENQUIRY        = "menuForm:menu_0420:anchor";
    public static final String PROC_SV_SERVICEORDER   = "menuForm:menu_0419:anchor";
    public static final String PROC_SV_SERVICEBILLING = "menuForm:menu_04090:anchor";

    public static final String PROC_PY_TIMESHEET_DETAIL      = "menuForm:menu_2233:anchor";
    public static final String PROC_PY_ADDITIONAL_PAYMENT    = "menuForm:menu_048100:anchor";
    public static final String PROC_PY_PAYROLL_DEDUCTION     = "menuForm:menu_048101:anchor";
    public static final String PROC_PY_BANK_TEXT_FILE_EXPORT = "menuForm:menu_04811:anchor";
    public static final String PROC_PY_CPF_FILE_EXTRACTION   = "menuForm:menu_04812:anchor";
    public static final String PROC_PY_PAYROLL_TIMESHEET     = "menuForm:menu_04894:anchor";
    public static final String PROC_PY_TIMESHEET_GENERATION  = "menuForm:menu_04892:anchor";
    public static final String PROC_PY_PIECE_RATE_WORKSHEET  = "menuForm:menu_24810:anchor";
    public static final String PROC_PY_PAYROLL_GENERATION    = "menuForm:menu_24811:anchor";
    public static final String PROC_PY_IR8A_FILE_EXTRACTION  = "menuForm:menu_24825:anchor";

    public static final String PROC_LV_ENTITLEMENT = "menuForm:menu_0434:anchor";
    public static final String PROC_LV_APPLICATION = "menuForm:menu_0435:anchor";

    public static final String PROC_MC_CONTRACT         = "menuForm:menu_045101:anchor";
    public static final String PROC_MC_CONTRACT_DO      = "menuForm:menu_045102:anchor";
    public static final String PROC_MC_CONTRACT_BILLING = "menuForm:menu_045106:anchor";
    public static final String PROC_MC_CONTRACT_CRN     = "menuForm:menu_045107:anchor";
    public static final String PROC_MC_SYSTEM_SETUP     = "menuForm:menu_04512:anchor";

    public static final String PROC_RENTAL_SYSTEM_SETUP   = "menuForm:menu_0480130:anchor";
    public static final String PROC_GL_JOURNAL_VOUCHER    = "menuForm:menu_0350:anchor";
    public static final String PROC_GL_SYSTEM_SETUP       = "menuForm:menu_01400:anchor";
    public static final String PROC_GL_GENERATE_RECURRING = "menuForm:menu_03503:anchor";

    // Global Setup
    public static final String GL_GLOBAL_CONFIG = "menuForm:menu_149100:anchor";
    public static final String GL_DEPARTMENT    = "menuForm:menu_8333:anchor";

    public static final String GL_EMPLOYEE_CLASS            = "menuForm:menu_14011001:anchor";
    public static final String GL_EMPLOYEE_JOBTYPE          = "menuForm:menu_14011013:anchor";
    public static final String GL_EMPLOYEE                  = "menuForm:menu_14011019:anchor";
    public static final String GL_APPROVING_OFFICER         = "menuForm:menu_14011021:anchor";
    public static final String GL_EMPLOYEE_GRADE            = "menuForm:menu_14011022:anchor";
    public static final String GL_EMPLOYEE_BIOMETRICS       = "menuForm:menu_14011023:anchor";
    public static final String GL_EMPLOYEE_PAYROLL_CATEGORY = "menuForm:menu_14011030:anchor";
    public static final String GL_SALUTATION                = "menuForm:menu_8334:anchor";
    public static final String GL_DESIGNATION_GROUP         = "menuForm:menu_8335:anchor";
    public static final String GL_SALES_PERSON              = "menuForm:menu_9500:anchor";
    public static final String GL_COMPANY_CONFIGURATION     = "menuForm:menu_0111201:anchor";

    public static final String GL_CHART_OF_ACC         = "menuForm:menu_14100501:anchor";
    public static final String GL_SALES_TAX            = "menuForm:menu_14100545:anchor";
    public static final String GL_CURRENCY             = "menuForm:menu_14100530:anchor";
    public static final String GL_FIXED_ASSET_CLASS    = "menuForm:menu_14030010:anchor";
    public static final String GL_FIXED_ASSET_CATEGORY = "menuForm:menu_14030015:anchor";
    public static final String GL_FIXED_ASSET          = "menuForm:menu_14030020:anchor";
    public static final String GL_FIXED_ASSET_LOCATION = "menuForm:menu_14030025:anchor";
    public static final String GL_PARTY                = "menuForm:menu_145001:anchor";
    public static final String GL_PARTY_GROUP          = "menuForm:menu_145002:anchor";
    public static final String GL_SUPPLIER_CLASS       = "menuForm:menu_14500701:anchor";
    public static final String GL_SUPPLIER_CATEGORY    = "menuForm:menu_14500703:anchor";
    public static final String GL_SUPPLIER             = "menuForm:menu_14500707:anchor";
    public static final String GL_RANK                 = "menuForm:menu_14500705:anchor";

    public static final String GL_CUSTOMER_CLASS     = "menuForm:menu_14500501:anchor";
    public static final String GL_CUSTOMER_CATEGORY  = "menuForm:menu_14500503:anchor";
    public static final String GL_CUSTOMER           = "menuForm:menu_14500505:anchor";
    public static final String GL_SBU                = "menuForm:menu_14010510:anchor";
    public static final String GL_PROJECT_CLASS      = "menuForm:menu_14086:anchor";
    public static final String GL_PROJECT_TYPE       = "menuForm:menu_140801:anchor";
    public static final String GL_PROJECT_CATEGORY   = "menuForm:menu_14085:anchor";
    public static final String GL_PROJECT_SITE_LOC   = "menuForm:menu_14084:anchor";
    public static final String GL_INVENTORY_CLASS    = "menuForm:menu_14300103:anchor";
    public static final String GL_INVENTORY          = "menuForm:menu_14300405:anchor";
    public static final String GL_INVENTORY_LOCATION = "menuForm:menu_14300201:anchor";
    public static final String GL_INVENTORY_UOM      = "menuForm:menu_14300404:anchor";
    public static final String GL_INVENTORY_BRAND    = "menuForm:menu_14300101:anchor";
    public static final String GL_INVENTORY_CATEGORY = "menuForm:menu_14300102:anchor";
    public static final String GL_SERVICE_CATEGORY   = "menuForm:menu_149004:anchor";
    public static final String GL_SERVICE            = "menuForm:menu_149009:anchor";
    public static final String GL_MT_NUMBERING       = "menuForm:menu_14010710:anchor";
    public static final String GL_PROC_NUMBERING     = "menuForm:menu_14010720:anchor";
    public static final String GL_COMPANY            = "menuForm:menu_14010507:anchor";
    public static final String GL_COUNTRY            = "menuForm:menu_14030510:anchor";
    public static final String GL_PAYMENT_TENOR_TERM = "menuForm:menu_147001:anchor";
    public static final String GL_QUOTATION_TERM     = "menuForm:menu_140812:anchor";
    public static final String GL_QUOTATION_VALIDITY = "menuForm:menu_14700302:anchor";
    public static final String GL_LEAVE_TYPE         = "menuForm:menu_140710:anchor";

    // Global Setup - Payroll
    public static final String GL_PY_TIME_CLOCK_MACHINE_LOCATION  = "menuForm:menu_140401:anchor";
    public static final String GL_PY_WORKING_GROUP                = "menuForm:menu_140402:anchor";
    public static final String GL_PY_COMMISSION_GROUP             = "menuForm:menu_140403:anchor";
    public static final String GL_PY_HOURLY_RATE_SCHEME           = "menuForm:menu_140404:anchor";
    public static final String GL_PY_HOURLY_RATE_GROUP            = "menuForm:menu_140405:anchor";
    public static final String GL_PY_GLOBAL_BASIC_OT_SCHEME       = "menuForm:menu_140406:anchor";
    public static final String GL_PY_WORKING_LOCATION             = "menuForm:menu_140410:anchor";
    public static final String GL_PY_WORKING_AREA                 = "menuForm:menu_140420:anchor";
    public static final String GL_PY_PAYROLL_REPORTING_GROUP      = "menuForm:menu_140430:anchor";
    public static final String GL_PY_CPF_CONTRIBUTION_RATE_SCHEME = "menuForm:menu_140440:anchor";
    public static final String GL_PY_COMMUNITY_FUND_DONATION      = "menuForm:menu_140450:anchor";
    public static final String GL_PY_SDL_MAINTENANCE              = "menuForm:menu_140460:anchor";
    public static final String GL_PY_PAYMENT_CYCLE                = "menuForm:menu_8585:anchor";

    // TM

    public static final String TASK_MANAGEMENT       = "menuForm:menu_04160:anchor";
    // Report
    public static final String RP_PJ_RECOGNITION_WIP = "menuForm:menu_01880:anchor";

    public static final String RP_PURCHASE_OUTSPORDER = "menuForm:menu_096111:anchor";

    public static String getMenuName(String menuID)
    {
        MenuID menu = new MenuID();
        Field[] fields = MenuID.class.getFields();
        for (Field field : fields)
        {
            try
            {
                if (field.get(menu).toString().equals(menuID))
                {
                    return field.getName();
                }
            } catch (IllegalArgumentException | IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return "";
    }
}
