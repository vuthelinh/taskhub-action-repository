package com.synergix.mastersetup.humanresource.performancemanagement.steps;

import com.synergix.mastersetup.humanresource.performancemanagement.page.ReviewGradePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ReviewGradeSteps extends ScenarioSteps {

	ReviewGradePage reviewGradePage;

	@Step
	public void click_btn_add_new() {
		reviewGradePage.click_btn_add_new();
	}

	@Step
	public void enter_from_year(String fromYear) {
		reviewGradePage.enter_from_year(fromYear);

	}

	@Step
	public String get_text_from_year(int ri) {
		return reviewGradePage.get_text_from_year_at_row(ri);

	}

	@Step
	public String is_readonly_from_year(String fromYear) {
		return reviewGradePage.is_readonly_from_year(fromYear);

	}

	@Step
	public void enter_to_year(String toYear) {
		reviewGradePage.enter_to_year(toYear);
	}

	@Step
	public String get_text_to_year(int ri) {
		return reviewGradePage.get_text_to_year_at_row(ri);
	}

	@Step
	public int count_row_table_review_grade() {

		return reviewGradePage.count_row_table_review_grade();

	}

	@Step
	public void click_btn_new_score_range(String fromYear, String toYear,int rowindex) {
		reviewGradePage.click_btn_new_score_range(fromYear, toYear, rowindex);
	}

	@Step
	public void click_btn_delete_score_range(String fromYear, String toYear,int rowindex) {
		reviewGradePage.click_btn_delete_score_range(fromYear, toYear, rowindex);
	}

	@Step
	public void click_btn_expand_detail(String fromYear, String toYear,int rowindex) {
		reviewGradePage.click_btn_expand_detail(fromYear, toYear, rowindex);
	}
	@Step
	public void click_btn_collapse_detail(String fromYear, String toYear,int rowindex) {
		reviewGradePage.click_btn_collapse_detail(fromYear, toYear, rowindex);
	}


	@Step
	public void enter_grade(int rowindex, String value) {
		reviewGradePage.enter_grade( rowindex, value);
	}

	@Step
	public void enter_score_from(int rowindex, String value) {
		reviewGradePage.enter_score_from( rowindex, value);
	}

	@Step
	public void enter_score_to(int rowindex, String value) {
		reviewGradePage.enter_score_to( rowindex, value);
	}

	@Step
	public void click_btn_new_review_type(int rowindex) {
		reviewGradePage.click_btn_new_review_type( rowindex);
	}

	@Step
	public void click_btn_delete_review_type(String fromYear, String toYear,int rowindex) {
		reviewGradePage.click_btn_delete_review_type(fromYear, toYear, rowindex);
	}

	@Step
	public void enter_review_type( String value,int rowindex) {
		reviewGradePage.enter_review_type( value, rowindex);
	}

	@Step
	public int is_exist_review_grade_at_rowindex(String fromYear, String toYear) {
		return reviewGradePage.is_exist_review_grade_at_rowindex(fromYear, toYear);

	}

	@Step
	public void check_score_range_all(String fromYear, String toYear,int rowindex) {
		reviewGradePage.check_score_range_all(fromYear, toYear, rowindex);

	}

	@Step
	public void uncheck_score_range_all(String fromYear, String toYear,int rowindex) {
		reviewGradePage.uncheck_score_range_all(fromYear, toYear, rowindex);
	}

	@Step
	public void confirm_yes() {
		reviewGradePage.confirm_yes();
	}

	@Step
	public boolean is_disabled_score_range_all(String fromYear, String toYear,int rowindex) {
		return reviewGradePage.is_disabled_score_range_all(fromYear, toYear, rowindex);

	}
	@Step
	public boolean is_disabled_review_type_all(String fromYear, String toYear,int rowindex) {
		return reviewGradePage.is_disabled_review_type_all(fromYear, toYear, rowindex);
		
	}
	@Step
	public void check_review_type_all(String fromYear, String toYear,int rowindex) {
		reviewGradePage.check_review_type_all(fromYear, toYear, rowindex);
	}
	@Step
	public void uncheck_review_type_all(String fromYear, String toYear,int rowindex) {
		reviewGradePage.uncheck_review_type_all(fromYear, toYear, rowindex);
	}
	
	@Step
	public void create_new (String fromYear, String toYear,int rowindex) {
		reviewGradePage.uncheck_review_type_all(fromYear, toYear, rowindex);
	}
	@Step
	public String find_max_to_year() {
		return reviewGradePage.find_max_to_year();
	}
	public int find_max_to_year1() {
		return reviewGradePage.find_max_to_year1();
	}
}
