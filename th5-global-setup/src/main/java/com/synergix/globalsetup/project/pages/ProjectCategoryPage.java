package com.synergix.globalsetup.project.pages;

import com.synergix.common.TH5PageObject;

import net.thucydides.core.annotations.Step;

import org.openqa.selenium.WebDriver;

/**
 * Created by Ian and Steve on 8/3/2016.
 */
public class ProjectCategoryPage extends TH5PageObject {
    private static final String PROJECT_CATEGORY_CODE_FOR_SEARCH = "Project Category Code";
	private static final String LOCAL_INFO = "Local Info";
	private static final String STATUS = "Status";
	private static final String DESCRIPTION = "Description:";
	private static final String PROJECT_CATEGORY_CODE = "Project Category Code:";
	public ProjectCategoryPage(WebDriver driver) {
        super(driver);
    }
    
	private String tableXpath = "//table";
    public void enter_project_category_code(String projectCategoryCode){
    	enterInputFieldCodeWithLabel(PROJECT_CATEGORY_CODE, projectCategoryCode);
    }
    public String get_text_project_category_code(){
    	return getTextValueWithLabel(tableXpath, PROJECT_CATEGORY_CODE);
    }
    public void enter_description(String description){
    	enterInputFieldWithLabel(DESCRIPTION, description);
    }
    public String get_text_description(){
    	return getTextValueWithLabel(tableXpath, DESCRIPTION);
    }
    
    public void switch_to_tab_local_info(){
    	switch_to_tab(LOCAL_INFO);
    	waitForAllJSCompletes();
    }
    public void select_status(String status){
    	checkRadio(STATUS, status);
    	waitForAllJSCompletes();
    }
    public boolean is_selected_status(String status){
    	return getChecked(STATUS, status);
    }
    
	public boolean search_project_category(String projectCategory){
		click_search_button_on_functional_panel();
		waitForAllJSCompletes();
		return search(PROJECT_CATEGORY_CODE_FOR_SEARCH, projectCategory);
	}
}
