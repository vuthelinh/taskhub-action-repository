package com.synergix.processing.project.quotationorder.pages;

import com.synergix.common.TH5PageObject;
import com.synergix.utilities.SessionData;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectEstimationPage extends TH5PageObject {
	public ProjectEstimationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@value='New']")
	private WebElementFacade addNewBtn;

	private String button(String buttonName, int order) {
		return "//input[contains(@value,'" + buttonName + "')][" + order + "]";
	}

	private String remarkButon(String buttonName, int order) {
		return "//table[contains(@id,'remarksModalPanelContentTable')]/tbody//input[contains(@value,'"
				+ buttonName + "')][" + order + "]";
	}

	private String getTableTeamMemberCell(String headerName, String type,
			int order) {
		return "(//*[text()='"
				+ headerName
				+ "']/ancestor-or-self::table[contains(@id,'PjEstNewTeamMember_Team:teamMemberTable')]/tbody//input[contains(@type,'"
				+ type + "')])[" + order + "]";
	}

	public void clickOnAddNewBtn() {
		switch_to_tab("Draft");
		clickOn(addNewBtn);
		get_project_no();
	}

	public String get_project_no() {
		String projectNo = getTextWithLabel("Project No.", 2); // get from xpath
		Serenity.setSessionVariable("Project No").to(projectNo);
		return projectNo;
	}

	public void setTextCustomerCode(String _customerCode) {
		enterInputFieldWithLabel("Customer", _customerCode);
		String projectNo = Serenity.sessionVariableCalled("Project No");
		System.out.println("Project no: " + projectNo);

	}

	public void setTextCustomerJobNo(String _customerJobNo) {
		enterInputFieldWithLabel("Customer Job No.", _customerJobNo);
	}

	public void setTextCustomerRevisionNo(String _customerRevisionNo) {
		enterInputFieldWithLabel("Customer Revision No", _customerRevisionNo);
	}

	public void setRadioBillType(String _billType) {
		selectRadioButton(xPathRadioBtnWithLabel(_billType));
		/* selectRadioButton("Bill Type",_billType); */
	}

	public void setHeaderInfor(List<List<String>> _headerTab) {
		switch_to_tab("Header");
		int totals = _headerTab.size();

		for (int i = 0; i < totals; i++) {
			if (!_headerTab.get(i).get(0).equals("")) {
				enterInputFieldWithLabel("Currency", _headerTab.get(i).get(0));
			}
			if (!_headerTab.get(i).get(1).equals("")) {
				enterInputFieldWithLabel("Sales Tax", _headerTab.get(i).get(1));
			}
			if (!_headerTab.get(i).get(2).equals("")) {
				enterInputFieldWithLabel("Customer PO No.", _headerTab.get(i)
						.get(2));
			}
			if (!_headerTab.get(i).get(3).equals("")) {
				enterInputFieldWithLabel("Reference No.", _headerTab.get(i)
						.get(3));
			}
			if (!_headerTab.get(i).get(4).equals("")) {
				enterInputFieldWithLabel("Estimate Date", _headerTab.get(i)
						.get(4));
			}
			if (!_headerTab.get(i).get(5).equals("")) {
				enterInputFieldWithLabel("Customer Contact", _headerTab.get(i)
						.get(5));
			}
			if (!_headerTab.get(i).get(6).equals("")) {
				enterInputFieldWithLabel("Start Date", _headerTab.get(i).get(6));
			}
			if (!_headerTab.get(i).get(7).equals("")) {
				enterInputFieldWithLabel("End Date", _headerTab.get(i).get(7));
			}
			if (!_headerTab.get(i).get(8).equals("")) {
				enterInputFieldWithLabel("Sales Person",
						_headerTab.get(i).get(8));
			}
			if (!_headerTab.get(i).get(9).equals("")) {
				enterInputFieldWithLabel("Sales Manager", _headerTab.get(i)
						.get(9));
			}
			if (!_headerTab.get(i).get(10).equals("")) {
				enterInputFieldWithLabel("SBU", _headerTab.get(i).get(10));
			}
			if (!_headerTab.get(i).get(11).equals("")) {
				enterInputFieldWithLabel("Project Class", _headerTab.get(i)
						.get(11));
			}
			if (!_headerTab.get(i).get(12).equals("")) {
				enterInputFieldWithLabel("Project Category", _headerTab.get(i)
						.get(12));
			}
			if (!_headerTab.get(i).get(13).equals("")) {
				enterInputFieldWithLabel("Commission Group", _headerTab.get(i)
						.get(13));
			}
			if (!_headerTab.get(i).get(14).equals("")) {
				selectRadioButton("Progress Retention Required", _headerTab
						.get(i).get(14));
			}
			if (!_headerTab.get(i).get(15).equals("")) {
				enterInputFieldWithLabel("Default Progress Retention",
						_headerTab.get(i).get(15));
			}
			if (!_headerTab.get(i).get(16).equals("")) {
				enterInputFieldWithLabel("Max Project Retention", _headerTab
						.get(i).get(16));
			}
			if (!_headerTab.get(i).get(17).equals("")) {
				enterInputFieldWithLabel("Max Project Retention Amount",
						_headerTab.get(i).get(17));
			}
			if (!_headerTab.get(i).get(18).equals("")) {
				enterInputFieldWithLabel("Retention Days", _headerTab.get(i)
						.get(18));
			}
			if (!_headerTab.get(i).get(19).equals("")) {
				enterInputFieldWithLabel("Retention Due Date", _headerTab
						.get(i).get(19));
			}
			if (!_headerTab.get(i).get(20).equals("")) {
				selectRadioButton("Downpayment Required", _headerTab.get(i)
						.get(20));
			}
			if (!_headerTab.get(i).get(21).equals("")) {
				enterInputFieldWithLabel("Downpayment Required", _headerTab
						.get(i).get(21));
			}
			if (!_headerTab.get(i).get(22).equals("")) {
				enterInputFieldWithLabel("Downpayment Required", "0");
				enterInputFieldWithLabel("Downpayment Amount", _headerTab
						.get(i).get(22));
			}
			if (!_headerTab.get(i).get(23).equals("")) {
				enterInputFieldWithLabel("Tolerable Variance %", _headerTab
						.get(i).get(23));
			}
			if (!_headerTab.get(i).get(24).equals("")) {
				selectRadioButton("Payment Certificate Provided", _headerTab
						.get(i).get(24));
			}
			if (!_headerTab.get(i).get(25).equals("")) {
				enterInputFieldWithLabel("Ship To Address", _headerTab.get(i)
						.get(25));
			}
			if (!_headerTab.get(i).get(26).equals("")) {
				enterInputFieldWithLabel("Ship To Contact", _headerTab.get(i)
						.get(26));
			}
			if (!_headerTab.get(i).get(27).equals("")) {
				enterInputFieldWithLabel("Shipment Mode", _headerTab.get(i)
						.get(27));
			}
			if (!_headerTab.get(i).get(28).equals("")) {
				enterInputFieldWithLabel("Shipment Term", _headerTab.get(i)
						.get(28));
			}
			if (!_headerTab.get(i).get(29).equals("")) {
				enterInputFieldWithLabel("Subject", _headerTab.get(i).get(29));
			}
			if (!_headerTab.get(i).get(30).equals("")) {
				enterTextAreaWithLabel("Subject Detail",
						_headerTab.get(i).get(30));
			}
		}
	}

	public void setDetailInfor(List<List<String>> _detailTab) {
		switch_to_tab("Detail");
		int totals = _detailTab.size();
		for (int i = 1; i < totals; i++) {
			String phaseRow = _detailTab.get(i).get(2);
			String itemRow = _detailTab.get(i).get(12);
			if (phaseRow.length() == 1
					|| (phaseRow.length() == 1 && !itemRow.equals(""))) {
				waitElementToBePresent(button("Add Phase", 1)).click();

				String xpathCurrent = "//*[.='" + phaseRow
						+ "']/preceding-sibling::td//input";
				waitElementToBePresent(xpathCurrent).click(); // click at
																// current Row
																// to input

				String xpathTableDetails = "(//table[contains(@id,'detailPhaseForm:pjEstFormTable')])";
				int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
						xpathTableDetails, phaseRow, 1, "Phase No.", 1)); // select
																			// current
																			// Phase
																			// row
				System.out.println("line: " + currentPhaseRow);
				if (!_detailTab.get(i).get(3).equals("")) {
					setDataCellTable(xpathTableDetails, 4,
							"Phase Desc/Remarks", currentPhaseRow, "textarea",
							1, _detailTab.get(i).get(3));
				}
				if (!_detailTab.get(i).get(4).equals("")) {
					setDataCellTable(xpathTableDetails, 4,
							"Phase Desc/Remarks", currentPhaseRow, "img", 1,
							_detailTab.get(i).get(4));
				}
				if (!_detailTab.get(i).get(5).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Qty",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(5));
				}
				if (!_detailTab.get(i).get(6).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "UOM",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(6));
				}
				if (!_detailTab.get(i).get(7).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Unit Price",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(7));
				}
				if (!_detailTab.get(i).get(8).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(8));
				}
				if (!_detailTab.get(i).get(9).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
							currentPhaseRow, "text", 1, "0");
					setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
							currentPhaseRow, "text", 2, _detailTab.get(i)
									.get(9));
				}
				if (!_detailTab.get(i).get(10).equals("")) {
					setDataCellTable(xpathTableDetails, 4,
							"Budgeted Total Cost", currentPhaseRow, "text", 1,
							_detailTab.get(i).get(10));
				}
				if (!_detailTab.get(i).get(11).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Del",
							currentPhaseRow, "checkbox", 1, _detailTab.get(i)
									.get(11));
					waitElementToBePresent(button("Delete", 1)).click();
				}
				if (!itemRow.equals("")) {
					waitElementToBePresent(button("Add Cost Item", 1)).click();
					String xpathTableCostItem = "(//table[contains(@id,'pjEstFormCostItem:pjEstFormItemCost')])";
					int currentItemRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
							xpathTableCostItem, itemRow, 1, "No.", 1));// select
																		// current
																		// Item
																		// row

					/*
					 * setDataCellTable(xpathTableCostItem, "Type",
					 * currentItemRow, "select", 1, _detailTab.get(i).get(13));
					 * if(!_detailTab.get(i).get(14).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Item Description/Remarks", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(14));}
					 * if(!_detailTab.get(i).get(15).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Item Description/Remarks", currentItemRow, "img", 2,
					 * _detailTab.get(i).get(15));}
					 * if(!_detailTab.get(i).get(16).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Qty/UOM",
					 * currentItemRow, "text", 1, _detailTab.get(i).get(16));}
					 * if(!_detailTab.get(i).get(17).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Pack Size No. of pack", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(17));}
					 * if(!_detailTab.get(i).get(18).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Price Type Unit Price", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(18));}
					 * if(!_detailTab.get(i).get(19).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Disc%/Amount",
					 * currentItemRow, "text", 1, _detailTab.get(i).get(19));}
					 * if(!_detailTab.get(i).get(20).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Disc%/Amount",
					 * currentItemRow, "text", 1, "0");
					 * setDataCellTable(xpathTableCostItem, "Disc%/Amount",
					 * currentItemRow, "text", 2, _detailTab.get(i).get(20));}
					 * if(!_detailTab.get(i).get(21).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Budgeted Unit Cost", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(21));}
					 * if(!_detailTab.get(i).get(22).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Del",
					 * currentItemRow, "checkbox", 1,
					 * _detailTab.get(i).get(21));
					 * waitElementToBePresent(button("Delete", 2)).click(); }
					 */

					setDataCellTable(xpathTableCostItem, 1, "Type",
							currentItemRow, "select", 1,
							_detailTab.get(i).get(13));
					if (!_detailTab.get(i).get(14).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Item Description/Remarks", currentItemRow,
								"text", 1, _detailTab.get(i).get(14));
					}
					if (!_detailTab.get(i).get(15).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Item Description/Remarks", currentItemRow,
								"img", 2, _detailTab.get(i).get(15));
					}
					if (!_detailTab.get(i).get(16).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Qty/UOM",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(16));
					}
					if (!_detailTab.get(i).get(17).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Unit Price",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(17));
					}
					if (!_detailTab.get(i).get(18).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(18));
					}
					if (!_detailTab.get(i).get(19).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 1, "0");
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 2, _detailTab.get(i)
										.get(19));
					}
					if (!_detailTab.get(i).get(20).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Budgeted Unit Cost", currentItemRow, "text",
								1, _detailTab.get(i).get(20));
					}
					if (!_detailTab.get(i).get(21).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Del",
								currentItemRow, "checkbox", 1, _detailTab
										.get(i).get(21));
						waitElementToBePresent(button("Delete", 2)).click();
					}

				}
			}
			if (phaseRow.length() > 2) {
				String parentPhase = phaseRow.substring(0,
						phaseRow.length() - 2);
				String xpathParent = "//*[.='" + parentPhase
						+ "']/preceding-sibling::td//input";
				waitElementToBePresent(xpathParent).click();
				waitElementToBePresent(button("Add Sub Phase", 1)).click();

				String xpathCurrent = "//*[.='" + phaseRow
						+ "']/preceding-sibling::td//input";
				waitElementToBePresent(xpathCurrent).click(); // click at
																// current Row
																// to input

				String xpathTableDetails = "(//table[contains(@id,'detailPhaseForm:pjEstFormTable')])";
				int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
						xpathTableDetails, phaseRow, 1, "Phase No.", 1)); // select
																			// current
																			// Phase
																			// row

				if (!_detailTab.get(i).get(3).equals("")) {
					setDataCellTable(xpathTableDetails, 4,
							"Phase Desc/Remarks", currentPhaseRow, "textarea",
							1, _detailTab.get(i).get(3));
				}
				if (!_detailTab.get(i).get(4).equals("")) {
					setDataCellTable(xpathTableDetails, 4,
							"Phase Desc/Remarks", currentPhaseRow, "img", 1,
							_detailTab.get(i).get(4));
				}
				if (!_detailTab.get(i).get(5).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Qty",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(5));
				}
				if (!_detailTab.get(i).get(6).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "UOM",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(6));
				}
				if (!_detailTab.get(i).get(7).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Unit Price",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(7));
				}
				if (!_detailTab.get(i).get(8).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
							currentPhaseRow, "text", 1, _detailTab.get(i)
									.get(8));
				}
				if (!_detailTab.get(i).get(9).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
							currentPhaseRow, "text", 1, "0");
					setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
							currentPhaseRow, "text", 2, _detailTab.get(i)
									.get(9));
				}
				if (!_detailTab.get(i).get(10).equals("")) {
					setDataCellTable(xpathTableDetails, 4,
							"Budgeted Total Cost", currentPhaseRow, "text", 1,
							_detailTab.get(i).get(10));
				}
				if (!_detailTab.get(i).get(11).equals("")) {
					setDataCellTable(xpathTableDetails, 4, "Del",
							currentPhaseRow, "checkbox", 1, _detailTab.get(i)
									.get(11));
					waitElementToBePresent(button("Delete", 1)).click();
				}
				if (!itemRow.equals("")) {
					waitElementToBePresent(button("Add Cost Item", 1)).click();
					String xpathTableCostItem = "(//table[contains(@id,'pjEstFormCostItem:pjEstFormItemCost')])";
					int currentItemRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
							xpathTableCostItem, itemRow, 1, "No.", 1));// select
																		// current
																		// Item
																		// row

					/*
					 * setDataCellTable(xpathTableCostItem, "Type",
					 * currentItemRow, "select", 1, _detailTab.get(i).get(13));
					 * if(!_detailTab.get(i).get(14).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Item Description/Remarks", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(14));}
					 * if(!_detailTab.get(i).get(15).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Item Description/Remarks", currentItemRow, "img", 2,
					 * _detailTab.get(i).get(15));}
					 * if(!_detailTab.get(i).get(16).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Qty/UOM",
					 * currentItemRow, "text", 1, _detailTab.get(i).get(16));}
					 * if(!_detailTab.get(i).get(17).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Pack Size No. of pack", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(17));}
					 * if(!_detailTab.get(i).get(18).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Price Type Unit Price", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(18));}
					 * if(!_detailTab.get(i).get(19).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Disc%/Amount",
					 * currentItemRow, "text", 1, _detailTab.get(i).get(19));}
					 * if(!_detailTab.get(i).get(20).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Disc%/Amount",
					 * currentItemRow, "text", 1, "0");
					 * setDataCellTable(xpathTableCostItem, "Disc%/Amount",
					 * currentItemRow, "text", 2, _detailTab.get(i).get(20));}
					 * if(!_detailTab.get(i).get(21).equals("")){
					 * setDataCellTable(xpathTableCostItem,
					 * "Budgeted Unit Cost", currentItemRow, "text", 1,
					 * _detailTab.get(i).get(21));}
					 * if(!_detailTab.get(i).get(22).equals("")){
					 * setDataCellTable(xpathTableCostItem, "Del",
					 * currentItemRow, "checkbox", 1,
					 * _detailTab.get(i).get(21));
					 * waitElementToBePresent(button("Delete", 2)).click(); }
					 */

					setDataCellTable(xpathTableCostItem, 1, "Type",
							currentItemRow, "select", 1,
							_detailTab.get(i).get(13));
					if (!_detailTab.get(i).get(14).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Item Description/Remarks", currentItemRow,
								"text", 1, _detailTab.get(i).get(14));
					}
					if (!_detailTab.get(i).get(15).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Item Description/Remarks", currentItemRow,
								"img", 2, _detailTab.get(i).get(15));
					}
					if (!_detailTab.get(i).get(16).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Qty/UOM",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(16));
					}
					if (!_detailTab.get(i).get(17).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Unit Price",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(17));
					}
					if (!_detailTab.get(i).get(18).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(18));
					}
					if (!_detailTab.get(i).get(19).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 1, "0");
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 2, _detailTab.get(i)
										.get(19));
					}
					if (!_detailTab.get(i).get(20).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Budgeted Unit Cost", currentItemRow, "text",
								1, _detailTab.get(i).get(20));
					}
					if (!_detailTab.get(i).get(21).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Del",
								currentItemRow, "checkbox", 1, _detailTab
										.get(i).get(21));
						waitElementToBePresent(button("Delete", 2)).click();
					}

				}
			}
			if (phaseRow.length() < 1 && !_detailTab.get(i).get(12).equals("")) { // /
																					// phase
																					// length
																					// <1
																					// and
																					// item
																					// type
																					// !=
																					// blank
				if (!itemRow.equals("")) {
					waitElementToBePresent(button("Add Cost Item", 1)).click();

					String xpathCurrent = "//*[.='" + phaseRow
							+ "']/preceding-sibling::td//input";
					waitElementToBePresent(xpathCurrent).click(); // click at
																	// current
																	// Row to
																	// input

					String xpathTableCostItem = "(//table[contains(@id,'pjEstFormCostItem:pjEstFormItemCost')])";
					int currentItemRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
							xpathTableCostItem, itemRow, 1, "No.", 1));// select
																		// current
																		// Item
																		// row

					setDataCellTable(xpathTableCostItem, 1, "Type",
							currentItemRow, "select", 1,
							_detailTab.get(i).get(13));
					if (!_detailTab.get(i).get(14).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Item Description/Remarks", currentItemRow,
								"text", 1, _detailTab.get(i).get(14));
					}
					if (!_detailTab.get(i).get(15).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Item Description/Remarks", currentItemRow,
								"img", 2, _detailTab.get(i).get(15));
					}
					if (!_detailTab.get(i).get(16).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Qty/UOM",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(16));
					}
					if (!_detailTab.get(i).get(17).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Unit Price",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(17));
					}
					if (!_detailTab.get(i).get(18).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 1, _detailTab.get(i)
										.get(18));
					}
					if (!_detailTab.get(i).get(19).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 1, "0");
						setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
								currentItemRow, "text", 2, _detailTab.get(i)
										.get(19));
					}
					if (!_detailTab.get(i).get(20).equals("")) {
						setDataCellTable(xpathTableCostItem, 1,
								"Budgeted Unit Cost", currentItemRow, "text",
								1, _detailTab.get(i).get(20));
					}
					if (!_detailTab.get(i).get(21).equals("")) {
						setDataCellTable(xpathTableCostItem, 1, "Del",
								currentItemRow, "checkbox", 1, _detailTab
										.get(i).get(21));
						waitElementToBePresent(button("Delete", 2)).click();
					}

				}

			}
		}
	}

	public void setDataCellTable(String xpathTable, int threadpossition,
			String headerName, int currentRow, String type, int order,
			String value) {
		int headerIndex = getTbColHeaderIndex(xpathTable, headerName, 1); // select
																			// header
		switch (type) {
		case "textarea":
			waitTypeAndTab(
					(xPathTbDataCellByPositionAndBodyIndex(xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//textarea[" + order + "]"), value);
			break;
		case "checkbox":
			setChkbox(
					(xPathTbDataCellByPositionAndBodyIndex(xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//input[contains(@type,'"
							+ type
							+ "')]["
							+ order + "]"), value);
			break;
		case "radio":
			selectRadioButton(
					(xPathTbDataCellByPositionAndBodyIndex(xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//input[contains(@type,'"
							+ type
							+ "')]["
							+ order + "]"), value);
			break;
		case "select":
			selectDdlByText(
					(xPathTbDataCellByPositionAndBodyIndex(xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//select[" + order + "]"), value);
			break;
		case "img":
			waitElementToBePresent(
					xPathTbDataCellByPositionAndBodyIndex("(" + xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//img)[" + order + "]").click();
			waitTypeAndTab(
					"//table/tbody/tr/td[contains(@class,'rich-tabpanel-content')]/textarea",
					value);
			waitElementToBePresent(remarkButon("Ok", 1)).click();
			break;
		default:
			waitTypeAndTab(
					(xPathTbDataCellByPositionAndBodyIndex(xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//input[contains(@type,'"
							+ type
							+ "')]["
							+ order + "]"), value);
			break;
		}
	}

	public void setPaymentInfor(List<List<String>> _paymentRows) {
		switch_to_tab("Payment Info");
		int totals = _paymentRows.size();
		for (int i = 0; i < totals; i++) {
			if (!_paymentRows.get(i).get(0).equals("")) {
				selectDdlByText(
						"//*[text()='Payment Option']/ancestor-or-self::td/following-sibling::td//select[@class='combo']",
						_paymentRows.get(i).get(0));
			}
			if (!_paymentRows.get(i).get(1).equals("")) {
				selectDdlByText(
						"//*[text()='Payment Term']/ancestor-or-self::td/following-sibling::td//select[@class='combo']",
						_paymentRows.get(i).get(1));
			}
			if (!_paymentRows.get(i).get(2).equals("")) {
				enterInputFieldWithLabel("Payment Term Tenor", _paymentRows
						.get(i).get(2), 1);
			}
			if (!_paymentRows.get(i).get(3).equals("")) {
				enterInputFieldWithLabel("Payment Term Tenor", _paymentRows
						.get(i).get(3), 2);
			}
			if (!_paymentRows.get(i).get(4).equals("")) {
				selectDdlByText(
						"//*[text()='Payment Method']/ancestor-or-self::td/following-sibling::td//select[@class='combo']",
						_paymentRows.get(i).get(4));
			}
			if (!_paymentRows.get(i).get(5).equals("")) {
				enterInputFieldWithLabel("Billing Party", _paymentRows.get(i)
						.get(5));
			}
			if (!_paymentRows.get(i).get(6).equals("")) {
				enterInputFieldWithLabel("Billing Address", _paymentRows.get(i)
						.get(6));
			}
			if (!_paymentRows.get(i).get(7).equals("")) {
				enterInputFieldWithLabel("Billing Contact", _paymentRows.get(i)
						.get(7));
			}
		}
	}

	public void setRemarkInfor(List<List<String>> _remarkRows) {
		switch_to_tab("Remarks");
		int totals = _remarkRows.size();

		for (int i = 0; i < totals; i++) {
			if (!_remarkRows.get(i).get(0).equals("")) {
				enterInputFieldWithLabel("Internal Remarks Code", _remarkRows
						.get(i).get(0));
			}
			if (!_remarkRows.get(i).get(1).equals("")) {
				enterInputFieldWithLabel("External Remarks Code", _remarkRows
						.get(i).get(1));
			}
			if (!_remarkRows.get(i).get(2).equals("")) {
				enterTextAreaWithLabel("Internal Remarks", _remarkRows.get(i)
						.get(2));
			}
			if (!_remarkRows.get(i).get(3).equals("")) {
				enterTextAreaWithLabel("External Remarks", _remarkRows.get(i)
						.get(3));
			}
			/*
			 * if(!_remarkRows.get(i).get(4).equals("")){
			 * enterInputFieldWithLabel
			 * ("Project Status",_remarkRows.get(i).get(4)); }
			 */
		}
	}

	public void setTeamMemberInfor(List<List<String>> _teammemRows) {
		switch_to_tab("Team Members");
		int totals = _teammemRows.size();
		for (int i = 0; i < totals; i++) {
			if (!_teammemRows.get(i).get(0).equals(_teammemRows.get(i).get(11))) {
				if (!_teammemRows.get(i).get(0).equals("")) {
					enterInputFieldWithLabel("Quantity Surveyor", _teammemRows
							.get(i).get(0));
				}
				if (!_teammemRows.get(i).get(1).equals("")) {
					enterInputFieldWithLabel("Project Manager", _teammemRows
							.get(i).get(1));
				}
				if (!_teammemRows.get(i).get(2).equals("")) {
					enterInputFieldWithLabel("(Maincon) Claim Officer",
							_teammemRows.get(i).get(2));
				}
				if (!_teammemRows.get(i).get(3).equals("")) {
					enterInputFieldWithLabel("(Subcon) Claim Officer",
							_teammemRows.get(i).get(3));
				}
				if (!_teammemRows.get(i).get(4).equals("")) {
					enterInputFieldWithLabel("Project Coordinator",
							_teammemRows.get(i).get(4));
				}
				if (!_teammemRows.get(i).get(5).equals("")) {
					enterInputFieldWithLabel("Operation Manager", _teammemRows
							.get(i).get(5));
				}
				if (!_teammemRows.get(i).get(6).equals("")) {
					enterInputFieldWithLabel("Service Engineer", _teammemRows
							.get(i).get(6));
				}
				if (!_teammemRows.get(i).get(7).equals("")) {
					enterInputFieldWithLabel("Project Director", _teammemRows
							.get(i).get(7));
				}
				if (!_teammemRows.get(i).get(8).equals("")) {
					enterInputFieldWithLabel("Executive Director", _teammemRows
							.get(i).get(8));
				}
				if (!_teammemRows.get(i).get(9).equals("")) {
					enterInputFieldWithLabel("Resident Technical Officer",
							_teammemRows.get(i).get(9));
				}
				if (!_teammemRows.get(i).get(10).equals("")) {
					enterInputFieldWithLabel("Head Of Department", _teammemRows
							.get(i).get(10));
				}
			} else {
				waitElementToBePresent(button("Add", 1)).click();
				if (!_teammemRows.get(i).get(12).equals("")) {
					waitElementToBePresent(
							getTableTeamMemberCell("Employee Code", "text", i))
							.sendKeys(_teammemRows.get(i).get(12));
				}
				if (!_teammemRows.get(i).get(13).equals("")) {
					waitElementToBePresent(
							getTableTeamMemberCell("Del", "checkbox", i + 1))
							.click();
				}
			}
		}
	}

	private static final String xPathPanelProjectEsstimation = "(//*[contains(@id,'mainPanel')]//ancestor-or-self::form)[1]";

	/*
	 * public void clickSubmitBtn() { waitElementToBePresent(button("Submit",
	 * 1)).click(); }
	 */

	public void clickSubmitBtn() {
		clickBtn(xPathPanelProjectEsstimation, "Submit");
		clickBtnYesOnConfirmSubmit();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	private String xPathPanelConfirmSubmit = "//div["
			+ sSpecialTextPredicates("You're about to submit this project estimation.")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit)
				.shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void clickBtnNoOnConfirmSubmit() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit)
				.shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit);
	}

	public void search_project_no_on_completed_tab(String projectNo) {
		filterDataByHeader(
				xPathTbHeaderCell("//*[contains(@id,'pjHstHdrSummary')]",
						"Project No."), projectNo);
		waitForAllJSCompletes();
	}

	public void click_reactive() {
		waitElementToBePresentThenScrollIntoView(
				xPathBillButtonOrLinkOnCompletedTab).shouldBeVisible();
		$("//tr[1]/td[1]/a | //tr[1]/td[1]/input").waitUntilClickable().click();
		clickBtnYesOnConfirmSubmit2();
		if (getInfoPanelMessagesThenClickOK() == null) {
			assertThat(getErrorMessagesThenClickOK() == null).isTrue();
		}
	}

	String xPathBillButtonOrLinkOnCompletedTab = "//tr[1]/td[1]/a | //tr[1]/td[1]/input";
	private String xPathPanelConfirmSubmit2 = "//div["
			+ sSpecialTextPredicates("Reactive Confirmation")
			+ " and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmSubmit2() {
		waitElementToBePresentThenScrollIntoView(xPathPanelConfirmSubmit2)
				.shouldBeVisible();
		clickBtn(xPathPanelConfirmSubmit2, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmSubmit2);
	}

	// Ian
	public void addNewMainPhase() {
		waitElementToBePresent(button("Add Phase", 1)).click();
	}

	private String xpathDetailsTable = "(//table[contains(@id,'phaseTable_pjQuoFormDetail:phaseTable_pjQuoFormTable')])";

	public void enterInputDescByPhaseNo(String phaseNo, String phaseDesc) {
		waitForAllJSCompletes();
		int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xpathDetailsTable, phaseNo, 1, "Phase No.", 1)); // select
																	// current
																	// Phase row

		setDataCellTable(xpathDetailsTable, 3, "Phase Desc/Remarks",
				currentPhaseRow, "textarea", 1, phaseDesc);
	}

	public void selectPhaseNo(String parentPhase) {
		String xpathParent = "//*[.='" + parentPhase
				+ "']/preceding-sibling::td//input";
		waitElementToBePresent(xpathParent).click();
	}

	public void addSubPhase() {
		waitElementToBePresent(button("Add Sub Phase", 1)).click();
	}

	public void setQtyByPhaseNo(String phaseNo, String qty) {
		waitForAllJSCompletes();
		int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xpathDetailsTable, phaseNo, 1, "Phase No.", 1)); // select
																	// current
																	// Phase row

		setDataCellTable(xpathDetailsTable, 3, "Qty", currentPhaseRow, "text",
				1, qty);
	}

	public void setPriceByPhaseNo(String phaseNo, String price) {
		waitForAllJSCompletes();
		int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xpathDetailsTable, phaseNo, 1, "Phase No.", 1)); // select
																	// current
																	// Phase row

		setDataCellTable(xpathDetailsTable, 3, "U/Price", currentPhaseRow,
				"text", 1, price);
	}

	public void setDiscPercentByPhaseNo(String phaseNo, String discPercent) {
		waitForAllJSCompletes();
		int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xpathDetailsTable, phaseNo, 1, "Phase No.", 1)); // select
																	// current
																	// Phase row

		setDataCellTable(xpathDetailsTable, 3, "Disc%/Amount", currentPhaseRow,
				"text", 1, discPercent);
	}

	public void setDiscAmountByPhaseNo(String phaseNo, String discAmount) {
		waitForAllJSCompletes();
		int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xpathDetailsTable, phaseNo, 1, "Phase No.", 1)); // select
																	// current
																	// Phase row

		setDataCellTable(xpathDetailsTable, 3, "Disc%/Amount", currentPhaseRow,
				"text", 2, discAmount);
	}

	public List<Double> getPhaseDetailByPhaseNo(String phaseNo) {

		int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
				xpathDetailsTable, phaseNo, 1, "Phase No.", 1)); // select
																	// current
																	// Phase row

		List<Double> result = new ArrayList<>();

		;

		result.add(Double.parseDouble(getDataCellTable(xpathDetailsTable, 3,
				"Total Amt", currentPhaseRow, "span", 1)));
		result.add(Double.parseDouble(getDataCellTable(xpathDetailsTable, 3,
				"Est. Total Cost", currentPhaseRow, "span", 1)));
		result.add(Double.parseDouble(getDataCellTable(xpathDetailsTable, 3,
				"Est. Profit", currentPhaseRow, "span", 1)));

		return result;
	}

	public String getDataCellTable(String xpathTable, int threadpossition,
			String headerName, int currentRow, String tagType, int order) {
		String result = new String();

		int headerIndex = getTbColHeaderIndex(xpathTable, headerName, 1); // select
																			// header

		switch (tagType) {
		case "input":
			// TODO get text from input
			// setChkbox((xPathTbDataCellByPositionAndBodyIndex(xpathTable,
			// threadpossition, currentRow, headerIndex) +
			// "//input[contains(@type,'" + type + "')][" + order + "]"),
			// value);
			break;
		case "span":
			result = getDriver().findElement(
					By.xpath(xPathTbDataCellByPositionAndBodyIndex(xpathTable,
							threadpossition, currentRow, headerIndex)
							+ "//span[" + order + "]")).getText();
			break;
		case "textarea":
			// TODO get text from textarea
			break;
		}

		return result;
	}

	public String getProjectNo() {
		return getTextValueWithLabel("Project No.", 2);
	}

	public void setPhaseInfor(String keyPrj, List<List<String>> _phaseList) {
		// switch_to_tab("Detail");

		String phaseList = "WTS_ProjectEstimation_Phase";
		SessionData.addDataTable(phaseList, _phaseList, false);

		String colPriceMethod = "Pricing Method";
		String colPhaseNo = "Phase No.";
		String colPhaseDesc = "Phase Desc";
		String colPhaseRemarks = "Phase Remarks";
		String colQty = "Qty";
		String colUOM = "UOM";
		String colUnitPrice = "Unit Price";
		String colFee = "Fee %";
		String colDisc = "Disc%";
		String colAmount = "Amount";
		String colBudgetedTotalCost = "Budgeted Total Cost";
		String colDel = "Del";

		for (int rowWTS_ProjectEstimation_Phase : SessionData
				.getDataTbRowsByValEqualInCol(phaseList, "PE KEY", keyPrj)
				.keySet()) {
			String priceMethod = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colPriceMethod);
			String phaseRow = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colPhaseNo);
			String phaseDesc = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colPhaseDesc);
			String phaseRemarks = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colPhaseRemarks);
			String qty = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colQty);
			String uOM = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colUOM);
			String unitPrice = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colUnitPrice);
			String disc = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colDisc);
			String fee = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colFee);
			String amount = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colAmount);
			String budgetedTotalCost = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colBudgetedTotalCost);
			String del = SessionData.getDataTbVal(phaseList,
					rowWTS_ProjectEstimation_Phase, colDel);

			if (!priceMethod.isEmpty()) {
				selectRadioButton("Pricing Method", priceMethod);
			}
			String[] listPhase = phaseRow.split("\\.");

			if (listPhase.length == 1) {
				clickBtn("Add Phase");
				waitForAllJSCompletes();
				String xPHRow = "//*[.='" + phaseRow
						+ "']/preceding-sibling::td//input";
				waitElementToBePresent(xPHRow).click();
			} else if (listPhase.length > 1) {
				String parentPhase = phaseRow.substring(0,
						phaseRow.length() - 2);
				String xpathParent = "//*[.='" + parentPhase
						+ "']/preceding-sibling::td//input";
				waitElementToBePresent(xpathParent).click();
				waitForAllJSCompletes();
				waitElementToBePresent(button("Add Sub Phase", 1)).click();
				waitForAllJSCompletes();
			}

			String xpathTableDetails = "(//table[contains(@id,'detailPhaseForm:pjEstFormTable')])";

			int currentPhaseRow = getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(
					xpathTableDetails, phaseRow, 1, "Phase No.", 1));

			if (!phaseDesc.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Phase Desc/Remarks",
						currentPhaseRow, "textarea", 1, phaseDesc);
			}
			if (!phaseRemarks.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Phase Desc/Remarks",
						currentPhaseRow, "img", 1, phaseRemarks);
			}
			if (!qty.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Qty", currentPhaseRow,
						"text", 1, qty);
			}
			if (!uOM.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "UOM", currentPhaseRow,
						"text", 1, uOM);
			}
			if (!unitPrice.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Unit Price",
						currentPhaseRow, "text", 1, unitPrice);
			}
			if (!fee.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Fee %",
						currentPhaseRow, "text", 1, fee);
			}
			if (!disc.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
						currentPhaseRow, "text", 1, disc);
			}
			if (!amount.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
						currentPhaseRow, "text", 1, "0");
				setDataCellTable(xpathTableDetails, 4, "Disc%/Amount",
						currentPhaseRow, "text", 2, amount);
			}
			if (!budgetedTotalCost.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Budgeted Total Cost",
						currentPhaseRow, "text", 1, budgetedTotalCost);
			}
			if (!del.isEmpty()) {
				setDataCellTable(xpathTableDetails, 4, "Del", currentPhaseRow,
						"checkbox", 1, del);
				waitElementToBePresent(button("Delete", 1)).click();
			}
		}
		waitForAllJSCompletes();
	}

	public void setItemInfor(String keyPrj, List<List<String>> _itemList) {

		String itemList = "WTS_ProjectEstimation_Item";
		SessionData.addDataTable(itemList, _itemList, false);

		String colPhaseNo = "Phase No.";
		String colItemNo = "No.";
		String colType = "Type";
		String colItemDescription = "Item Description";
		String colItemRemarks = "Item Remarks";
		String colQtyUOM = "Qty/UOM";
		String colItemUnitPrice = "Item Unit Price";
		String colItemDisc = "Item Disc%";
		String colItemAmount = "Item Amount";
		String colBudgetedUnitCost = "Budgeted Unit Cost";
		String colItemDel = "Item Del";

		for (int rowWTS_ProjectEstimation_Item : SessionData
				.getDataTbRowsByValEqualInCol(itemList, "PE KEY", keyPrj)
				.keySet()) {
			String phaseNo = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colPhaseNo);
			String type = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colType);
			String itemDescription = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colItemDescription);
			String itemRemarks = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colItemRemarks);
			String qtyUOM = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colQtyUOM);
			String itemUnitPrice = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colItemUnitPrice);
			String itemDisc = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colItemDisc);
			String itemAmount = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colItemAmount);
			String budgetedUnitCost = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colBudgetedUnitCost);
			String itemDel = SessionData.getDataTbVal(itemList,
					rowWTS_ProjectEstimation_Item, colItemDel);

			if (!phaseNo.isEmpty()) {
				String xPhaseRow = "//*[.='" + phaseNo
						+ "']/preceding-sibling::td//input";
				$(xPhaseRow).waitUntilClickable().click();
				waitForAllJSCompletes();
				waitElementToBePresent(button("Add Cost Item", 1)).click();
				waitForAllJSCompletes();

				String xpathTableCostItem = "//table[contains(@id,'pjEstFormCostItem:pjEstFormItemCost')]";
				int currentItemRow = findAll(
						xpathTableCostItem + "/tbody/tr[@class]").size();

				selectDdlByText("(" + xpathTableCostItem + "//select)["
						+ currentItemRow + "]", type);

				if (!itemDescription.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1,
							"Item Description/Remarks", currentItemRow, "text",
							1, itemDescription);
				}
				if (!itemRemarks.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1,
							"Item Description/Remarks", currentItemRow, "img",
							2, itemRemarks);
				}
				if (!qtyUOM.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1, "Qty/UOM",
							currentItemRow, "text", 1, qtyUOM);
				}
				if (!itemUnitPrice.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1, "Unit Price",
							currentItemRow, "text", 1, itemUnitPrice);
				}
				if (!itemDisc.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
							currentItemRow, "text", 1, itemDisc);
				}
				if (!itemAmount.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
							currentItemRow, "text", 1, "0");
					setDataCellTable(xpathTableCostItem, 1, "Disc%/Amount",
							currentItemRow, "text", 2, itemAmount);
				}
				if (!budgetedUnitCost.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1,
							"Budgeted Unit Cost", currentItemRow, "text", 1,
							budgetedUnitCost);
				}
				if (!itemDel.isEmpty()) {
					setDataCellTable(xpathTableCostItem, 1, "Del",
							currentItemRow, "checkbox", 1, itemDel);
					waitElementToBePresent(button("Delete", 2)).click();
				}
			}
			waitForAllJSCompletes();
		}
	}

}
