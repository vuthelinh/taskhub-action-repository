package com.synergix.mastersetup.humanresource.performancemanagement.steps;

import com.synergix.mastersetup.humanresource.performancemanagement.page.ReviewBonusPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ReviewBonusSteps extends ScenarioSteps {

	/**
	 * Create by: Lily Hoang
	 */

	ReviewBonusPage reviewBonusPage;

	@Step
	public void click_btn_new() {
		reviewBonusPage.click_btn_new();
	}

	@Step
	public void click_btn_new_sumary() {
		reviewBonusPage.click_btn_new_sumary();
	}

	@Step
	public void click_btn_back_to_summary() {
		reviewBonusPage.click_btn_back_to_summary();
	}

	@Step
	public void click_btn_delete_salary() {
		reviewBonusPage.click_btn_delete_salary();
	}

	@Step
	public void uncheck_del_salary_with_salary_from(String salaryFrom) {
		reviewBonusPage.uncheck_del_salary_with_salary_from(salaryFrom);
	}

	public void enter_increment_with_grade(String grade, String value) {
		reviewBonusPage.enter_increment_with_grade(grade, value);
	}

	public int get_ri_review_bonus_exist(String yearFrom, String yearTo, String emType) {
		return reviewBonusPage.get_ri_review_bonus_exist(yearFrom, yearTo, emType);

	}

	@Step
	public void create_new_review_bonus(String yearFrom, String yearTo, String emType) {
		int ri = reviewBonusPage.get_ri_review_bonus_exist(yearFrom, yearTo, emType);
		if (ri == 0) {
			reviewBonusPage.click_btn_new();
			reviewBonusPage.is_exist_review_grade(yearFrom);
			reviewBonusPage.select_in_employment_type(emType);
		}
	}

	@Step
	public void create_new_salary_increment() {
		reviewBonusPage.switch_tab_salary_increment();
		double doubleSal = reviewBonusPage.find_max_salary() + 1;
		String salaryFrom = String.valueOf(doubleSal);
		String salaryTo = String.valueOf(doubleSal + 5);
		reviewBonusPage.click_btn_add_salary();
		reviewBonusPage.click_btn_last_page_salary();
		reviewBonusPage.enter_salary_from(salaryFrom);
		reviewBonusPage.enter_salary_to(salaryTo);

	}

	@Step
	public void delete_salary_increment() {
		reviewBonusPage.switch_tab_salary_increment();
		double doubleSal = reviewBonusPage.find_max_salary();
		String salaryFrom = String.valueOf(doubleSal);
		String salaryTo = String.valueOf(doubleSal + 5);
		reviewBonusPage.check_del_salary_with_salary_from(salaryFrom, salaryTo);

	}

	@Step
	public void create_new_bonus_gratuity(String grade, String value) {
		reviewBonusPage.switch_tab_bonus_gratuity();
		reviewBonusPage.enter_bonus_gratuity(grade, value);
	}

	@Step
	public double find_max_salary() {
		return reviewBonusPage.find_max_salary();
	}
	public int get_ri_salary_range_exist(String salaryFrom, String salaryTo) {
		return reviewBonusPage.get_ri_salary_range_exist(salaryFrom, salaryTo);
	}
}
