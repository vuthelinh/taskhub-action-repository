package com.synergix.mastersetup.humanresource.performancemanagement;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedHashMap;
import java.util.List;
import com.synergix.mastersetup.humanresource.performancemanagement.steps.*;
import com.synergix.common.CONST;
import com.synergix.mastersetup.humanresource.performancemanagement.steps.ReviewBonusSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ReviewBonusDefs {
	@Steps
	ReviewBonusSteps reviewBonusStep;
	@Steps
	ReviewGradeSteps reviewGradeStep;

	public String fromYearKey = "";
	public String toYearKey = "";
	public int rowIndex = 2;
	public int max=0;
	@And("^Review Grade is created as in file \"([^\"]*)\"$")
	public void review_grade_is_created_as_in_file_something(String file) throws Throwable {
		reviewGradeStep.click_btn_add_new();
		 max=reviewGradeStep.find_max_to_year1();
		fromYearKey = String.valueOf(max+1);
		toYearKey = String.valueOf(max + 2);
		String fileName = System.getProperty("user.dir") + CONST.FIN_INVENTORY + file;
		SessionData.addDataTable("TEST_EXCEL", fileName, "Review Grade", false);
		for (int row : SessionData.getDataTbRowsNoHeader("TEST_EXCEL").keySet()) {
			String s1 = SessionData.getDataTbVal("TEST_EXCEL", row, "From Year");
			String s2 = SessionData.getDataTbVal("TEST_EXCEL", row, "To Year");
			String s3 = SessionData.getDataTbVal("TEST_EXCEL", row, "Score From");
			String s4 = SessionData.getDataTbVal("TEST_EXCEL", row, "Score To");
			String s5 = SessionData.getDataTbVal("TEST_EXCEL", row, "Grade");
			String s6 = SessionData.getDataTbVal("TEST_EXCEL", row, "Review Type");
			// System.out.println(row + ": " + s1 + "-" + s2 + "-");
			
			if (!s1.isEmpty()) {
				reviewGradeStep.enter_from_year(fromYearKey);
			}
			if (!s2.isEmpty()) {
				reviewGradeStep.enter_to_year(toYearKey);
			}

			reviewGradeStep.click_btn_expand_detail(fromYearKey, toYearKey, 1);
			if (!s3.isEmpty()) {
				reviewGradeStep.click_btn_new_score_range(fromYearKey, toYearKey, rowIndex);
				reviewGradeStep.enter_score_from(rowIndex, s3);
			}
			if (!s4.isEmpty()) {
				reviewGradeStep.enter_score_to(rowIndex, s4);
			}
			if (!s5.isEmpty()) {
				reviewGradeStep.enter_grade(rowIndex, s5);
			}

			if (!s6.isEmpty()) {
				reviewGradeStep.click_btn_new_review_type(rowIndex);
				reviewGradeStep.enter_review_type(s6, rowIndex);
			}
			reviewGradeStep.click_btn_collapse_detail(fromYearKey, toYearKey, 1);

		}

	}

	@When("^User wants to create a new Review Bonus for a Review grade as the following with Key as \"([^\"]*)\"$")
	public void user_wants_to_create_a_new_review_bonus_for_a_review_grade_as_the_following_with_key_as_something(
			String dataKey, List<List<String>> reviewGrate) throws Throwable {
		SessionData.addDataTable("ReviewGradeTbl", reviewGrate);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("ReviewGradeTbl", "Key", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("ReviewGradeTbl", row, "Key");
			String sYearFrom = SessionData.getDataTbVal("ReviewGradeTbl", row, "Year From");
			String sYearTo = SessionData.getDataTbVal("ReviewGradeTbl", row, "Year To");
			String sEmploymentType = SessionData.getDataTbVal("ReviewGradeTbl", row, "Employment Type");
			if (!sKey.isEmpty()) {
			}
			if (!sYearFrom.isEmpty() && !sYearTo.isEmpty() && !sEmploymentType.isEmpty()) {
				reviewBonusStep.create_new_review_bonus(fromYearKey,toYearKey, sEmploymentType);
			}

		}
	}

	@Then("^Review Bonus should be display on the list as following \"([^\"]*)\"$")
	public void review_bonus_should_be_display_on_the_list_as_following(String dataKey, List<List<String>> reviewGrate)
			throws Throwable {
		SessionData.addDataTable("ReviewGradeTbl", reviewGrate);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("ReviewGradeTbl", "Key", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("ReviewGradeTbl", row, "Key");
			String sYearFrom = SessionData.getDataTbVal("ReviewGradeTbl", row, "Year From");
			String sYearTo = SessionData.getDataTbVal("ReviewGradeTbl", row, "Year To");
			String sEmploymentType = SessionData.getDataTbVal("ReviewGradeTbl", row, "Employment Type");
			if (!sYearFrom.isEmpty() && !sYearTo.isEmpty() && !sEmploymentType.isEmpty()) {
				reviewBonusStep.click_btn_back_to_summary();
				// assertThat(reviewBonusStep.get_ri_review_bonus_exist(sYearFrom,
				// sYearTo, sEmploymentType)).isNotEqualTo(0);
			}

		}
	}

	@And("^The Salary Increment has infomation as the following as \"([^\"]*)\"$")
	public void the_salary_increment_has_infomation_as_the_following_as_something(String dataKey,
			List<List<String>> salaryTbl) throws Throwable {

		SessionData.addDataTable("SALARYTBL", salaryTbl);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("SALARYTBL", "Key", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("SALARYTBL", row, "Key");
			String sBasicSalaryFrom = SessionData.getDataTbVal("SALARYTBL", row, "Basic Salary From");
			String sBasicSalaryTo = SessionData.getDataTbVal("SALARYTBL", row, "Basic Salary To");
			String sGrade = SessionData.getDataTbVal("SALARYTBL", row, "Grade");
			String sIncrement = SessionData.getDataTbVal("SALARYTBL", row, "Increment");
			if (!sKey.isEmpty()) {
			}
			if (!sBasicSalaryFrom.isEmpty() && !sBasicSalaryTo.isEmpty()) {
				reviewBonusStep.create_new_salary_increment();
			}

			if (!sGrade.isEmpty() && !sIncrement.isEmpty()) {
				reviewBonusStep.enter_increment_with_grade(sGrade, sIncrement);
			}
		}
	}

	@And("^The Bonus/Gratuity has infomation as the following as \"([^\"]*)\"$")
	public void the_bonusgratuity_has_infomation_as_the_following_as_something(String dataKey,
			List<List<String>> dataTable) throws Throwable {
		SessionData.addDataTable("GratuityTbl", dataTable);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("GratuityTbl", "Key", dataKey);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("GratuityTbl", row, "Key");
			String sGrade = SessionData.getDataTbVal("GratuityTbl", row, "Grade");
			String sBonusGratuity = SessionData.getDataTbVal("GratuityTbl", row, "Bonus Gratuity");
			if (!sKey.isEmpty()) {
			}
			if (!sGrade.isEmpty() && !sBonusGratuity.isEmpty()) {
				reviewBonusStep.create_new_bonus_gratuity(sGrade, sBonusGratuity);
			}
		}
	}

}
