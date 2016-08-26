package com.synergix.globalsetup.project.steps;

import com.synergix.globalsetup.project.pages.ProjectCategoryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Ian and Steve on 8/3/2016.
 */
public class ProjectCategorySteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	private ProjectCategoryPage onProjectCategory;
	
	@Step
	public void switch_to_iframe(){
		onProjectCategory.switchToIFrame();
	}
	
	@Step
	public void switch_out_default_iframe(){
		onProjectCategory.switchOutDefaultIFrame();
	}

	@Step
	public void click_add_new_button_on_functional_panel() {
		onProjectCategory.click_add_new_button_on_functional_panel();
	}

	@Step
	public void enter_project_category_code(String projectCategoryCode) {
		onProjectCategory.enter_project_category_code(projectCategoryCode);
	}
	
	@Step
	public void click_update(){
		onProjectCategory.click_update_button_on_functional_panel();
	}
	
	@Step
	public void click_delete(){
		onProjectCategory.click_delete_button_on_functional_panel();
	}

	@Step
	public String get_text_project_category_code() {
		return onProjectCategory.get_text_project_category_code();
	}

	@Step
	public void enter_description(String description) {
		onProjectCategory.enter_description(description);
	}

	@Step
	public String get_text_description() {
		return onProjectCategory.get_text_description();
	}

	@Step
	public void switch_to_tab_local_info() {
		onProjectCategory.switch_to_tab_local_info();
	}

	@Step
	public void select_status(String status) {
		onProjectCategory.select_status(status);
	}

	@Step
	public void verify_project_category_code(String projectCategoryCode) {
		onProjectCategory.waitForAllJSCompletes();
		assertThat(onProjectCategory.get_text_project_category_code(), equalTo(projectCategoryCode));
	}

	@Step
	public void verify_description(String description) {
		assertThat(onProjectCategory.get_text_description(), equalTo(description));
	}

	@Step
	public void verify_status(String status) {
		assertThat(onProjectCategory.is_selected_status(status), equalTo(true));
	}
	
	@Step
	public void verify_project_category_not_found(String projectCategory){
		assertThat(onProjectCategory.search_project_category(projectCategory), equalTo(false));
	}

	@Step
	public void choose_company(String companyList) {
		onProjectCategory.waitForAllJSCompletes();
		onProjectCategory.chooseCompany(companyList);
	}

	@Step
	public boolean search_project_category(String projectCategory) {
		return onProjectCategory.search_project_category(projectCategory);
	}

	@Step
	public void create_new_project_category(String projectCategoryCode, String description) {
		onProjectCategory.switchToIFrame("th5frame");

		onProjectCategory.click_add_new_button_on_functional_panel();

		onProjectCategory.waitForAllJSCompletes();
		onProjectCategory.enter_project_category_code(projectCategoryCode);
		if (!description.isEmpty()) {
			onProjectCategory.waitForAllJSCompletes();
			onProjectCategory.enter_description(description);
		}

		onProjectCategory.switchOutDefaultIFrame();
	}
}
