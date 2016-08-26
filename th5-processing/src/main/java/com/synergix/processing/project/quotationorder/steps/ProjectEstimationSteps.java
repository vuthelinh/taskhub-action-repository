package com.synergix.processing.project.quotationorder.steps;

import com.synergix.processing.project.quotationorder.pages.ProjectEstimationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ProjectEstimationSteps extends ScenarioSteps {

    ProjectEstimationPage onProjectEstiomationPage;

    @Step
    public void click_add_new_button_on_functional_panel() {
        onProjectEstiomationPage.click_add_new_button_on_functional_panel();
    }


    @Step
    public void customer_code(String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel("Customer", value);
    }

    @Step
    public void customer_job_no(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void customer_revision_no(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void bill_type(String lableText, String value) {
        onProjectEstiomationPage.selectRadioButton(lableText, value);
    }

    @Step
    public void go_to_tab(String string) {
        onProjectEstiomationPage.switch_to_tab(string);
    }

    @Step
    public void currency(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void sales_tax(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void customer_po_no(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void reference_no(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void estimate_date(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void customer_contact(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void start_date(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void end_date(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void sales_manager(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void project_class(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void project_category(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void progress_retention_required(String lableText, String value) {
        onProjectEstiomationPage.selectRadioButton(lableText, value);
    }

    @Step
    public void default_progress_retention(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void max_project_retention(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void max_project_retention_amount(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void retention_days(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void retention_due_date(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void downpayment_required(String lableText, String value) {
        onProjectEstiomationPage.selectRadioButton(lableText, value);
    }

    @Step
    public void downpayment_required_percent(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void downpayment_amount(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void tolerable_variance(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void payment_certificate_provided(String lableText, String value) {
        onProjectEstiomationPage.selectRadioButton(lableText, value);
    }

    @Step
    public void ship_to_address(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void ship_to_contact(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void shipment_mode(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void shipment_term(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void subject(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void subject_detail(String lableText, String value) {
        onProjectEstiomationPage.enterTextAreaWithLabel(lableText, value);
    }

    @Step
    public void payment_option(String lableText, String value) {
        onProjectEstiomationPage.selectDdlWithLabelByText(lableText, value);
    }

    @Step
    public void payment_term(String lableText, String value) {
        onProjectEstiomationPage.selectDdlWithLabelByText(lableText, value);
    }

    @Step
    public void payment_term_tenor_date(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void payment_term_tenor_term(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value, 2);
    }

    public void payment_method(String lableText, String value) {
        onProjectEstiomationPage.selectDdlWithLabelByText(lableText, value);
    }

    @Step
    public void billing_address(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void billing_contact(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void internal_remarks_code(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void external_remarks_code(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void internal_remarks(String lableText, String value) {
        onProjectEstiomationPage.enterTextAreaWithLabel(lableText, value);
    }

    @Step
    public void external_remarks(String lableText, String value) {
        onProjectEstiomationPage.enterTextAreaWithLabel(lableText, value);
    }

    @Step
    public void project_status(String lableText, String value) {
        onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
    }

    @Step
    public void click_summit() {
        onProjectEstiomationPage.clickSubmitBtn();
    }

    @Step
    public void set_details_infor(List<List<String>> dataset) {
        onProjectEstiomationPage.setDetailInfor(dataset);
    }

    @Step
    public void search_project_no_on_completed_tab(String projectNo) {
        onProjectEstiomationPage.search_project_no_on_completed_tab(projectNo);
    }

    @Step
    public void click_reactive() {
        onProjectEstiomationPage.click_reactive();
    }

    @Step
    public void add_main_phase_with_desc(String phaseNo, String phaseDesc) {
        onProjectEstiomationPage.addNewMainPhase();
        onProjectEstiomationPage.enterInputDescByPhaseNo(phaseNo, phaseDesc);
    }

    public void add_sub_phase_by_phase_no_with_desc(String phaseNo, String phaseDesc) {
        onProjectEstiomationPage.selectPhaseNo(phaseNo.substring(0, phaseNo.lastIndexOf(".")));
        onProjectEstiomationPage.addSubPhase();
        onProjectEstiomationPage.enterInputDescByPhaseNo(phaseNo, phaseDesc);

    }

    public void estimate_by_phase_no(String phaseNo, String qty, String price, String discPercent, String discAmount) {
        if (!qty.isEmpty()) {
            onProjectEstiomationPage.setQtyByPhaseNo(phaseNo, qty);
        }

        if (!price.isEmpty()) {
            onProjectEstiomationPage.setPriceByPhaseNo(phaseNo, price);
        }

        if (!discPercent.isEmpty()) {
            onProjectEstiomationPage.setDiscPercentByPhaseNo(phaseNo, discPercent);
        }

        if (!discAmount.isEmpty()) {
            onProjectEstiomationPage.setDiscAmountByPhaseNo(phaseNo, discAmount);
        }
    }

    public void phase_by_phase_no_should_be(String phaseNo, String totalAmount, String estimateCost, String estimateProfit) {
        List<Double> expected = new ArrayList<>();

        expected.add(Double.parseDouble(totalAmount));
        expected.add(Double.parseDouble(estimateCost));
        expected.add(Double.parseDouble(estimateProfit));

        List<Double> actual = onProjectEstiomationPage.getPhaseDetailByPhaseNo(phaseNo);

        assertThat(actual).isEqualTo(expected);
    }
    
    // NANCY add 20160822
    @Step
	public void switchToIFrame() {
		onProjectEstiomationPage.switchToIFrame();
	}

	@Step
	public void switchOutDefaultIFrame() {
		onProjectEstiomationPage.switchOutDefaultIFrame();
	}
	
	@Step
	public void customer_code(String lableText, String value) {
		onProjectEstiomationPage.enterInputFieldWithLabel(lableText, value);
	}

	@Step
	public void createNewVoucherPE() {
		onProjectEstiomationPage.clickOnAddNewBtn();
	}
	
	@Step
	public void searchProjectNo(String projectNo) {
		String xFilterCell = "//input[preceding-sibling::a[child::span[text()='Project No.']]]";
		onProjectEstiomationPage.waitTypeAndEnter(xFilterCell, projectNo);
		onProjectEstiomationPage.waitForAllJSCompletes();
		String xFirstRow = "//table[contains(@id, 'DraftHdrSummary')]/tbody/tr[1]//a[@href]";
		onProjectEstiomationPage.clickOnElement(xFirstRow);
	}
	
	@Step
	public void setSegment(List<String> listSegment) {
		onProjectEstiomationPage.setSegment(listSegment);		
	}


	@Step
	public void setPhaseInfor(String key, List<List<String>> dataset) {
		onProjectEstiomationPage.setPhaseInfor(key, dataset);
	}

	@Step
	public void setItemInfor(String key, List<List<String>> dataset) {
		onProjectEstiomationPage.setItemInfor(key, dataset);
	}
	public String getProjectNo() {		
		return onProjectEstiomationPage.getProjectNo();
	}

}
