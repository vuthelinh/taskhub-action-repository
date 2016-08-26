package com.synergix.mastersetup.humanresource.performancemanagement;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.runner.RunWith;

import com.synergix.mastersetup.humanresource.performancemanagement.steps.ReviewGradeSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.thucydides.core.annotations.Steps;

@RunWith(Cucumber.class)
public class ReviewGradeDefs {
	public String sFromYearKey = "FY";
	public String sToYearKey = "TY";
	public int rowIndex = 2;

	@Steps
	ReviewGradeSteps reviewGradeStep;

	@When("^I want to create a new Review Grade$")
	public void i_want_to_create_a_new_review_grade() {
		String sFromYear = reviewGradeStep.find_max_to_year();
		String	sToYear = String.valueOf(Integer.parseInt(reviewGradeStep.find_max_to_year()) + 1);
		SessionData.addToListString(sFromYearKey, sFromYear);
		SessionData.addToListString(sToYearKey, sToYear);
		
		sFromYearKey=SessionData.getListStringLastValue(sFromYearKey);
		sToYearKey=SessionData.getListStringLastValue(sToYearKey);

	}
	@When("^I want to update Review Grade$")
	public void i_want_to_update_review_grade() {
		reviewGradeStep.is_exist_review_grade_at_rowindex(sFromYearKey, sToYearKey);
	}

	@Then("^The Review Grade should be displayed on Review Grade List as the followng with Key as \"([^\"]*)\"$")
	public void the_review_grade_should_be_displayed_on_review_grade_list_as_the_followng_with_key_as_something(
			String key, List<List<String>> strArg1) {

	}

	@And("^The Review Grade has new Time period  as the following with Key as \"([^\"]*)\"$")
	public void the_review_grade_has_new_time_period_as_the_following_with_key_as_something(String key,
			List<List<String>> timeTable) throws Throwable {
		SessionData.addDataTable("TIMETABLE", timeTable,false);
		LinkedHashMap<Integer, List<String>> testData = SessionData.getDataTbRowsByValEqualInCol("TIMETABLE", "Key",
				key);
		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("TIMETABLE", row, "Key");
			

			if (!sKey.isEmpty()) {
			}
			if (reviewGradeStep.is_exist_review_grade_at_rowindex(sFromYearKey, sToYearKey) == 0) {
				reviewGradeStep.click_btn_add_new();
				if (!sFromYearKey.isEmpty()) {
					reviewGradeStep.enter_from_year(sFromYearKey);
				}
				if (!sToYearKey.isEmpty()) {
					reviewGradeStep.enter_to_year(sToYearKey);
				}
			}

		}
		

	}

	@And("^The Review Grade has new Score information as the following with Key as \"([^\"]*)\"$")
	public void the_review_grade_has_new_score_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> scoreTable) throws Throwable {
		SessionData.addDataTable("SCORETABLE", scoreTable,false);

		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("SCORETABLE", "Key", dataKey);

		reviewGradeStep.click_btn_expand_detail(SessionData.getListStringLastValue(sFromYearKey),
				SessionData.getListStringLastValue(sToYearKey), 1);

		if (reviewGradeStep.is_disabled_score_range_all(SessionData.getListStringLastValue(sFromYearKey),
				SessionData.getListStringLastValue(sToYearKey), rowIndex) == false) {

			reviewGradeStep.check_score_range_all(SessionData.getListStringLastValue(sFromYearKey),
					SessionData.getListStringLastValue(sToYearKey), rowIndex);
			reviewGradeStep.click_btn_delete_score_range(SessionData.getListStringLastValue(sFromYearKey),
					SessionData.getListStringLastValue(sToYearKey), rowIndex);
			reviewGradeStep.confirm_yes();
		}

		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("SCORETABLE", row, "Key");
			String sScoreFrom = SessionData.getDataTbVal("SCORETABLE", row, "Score From");
			String sScoreTo = SessionData.getDataTbVal("SCORETABLE", row, "Score To");
			String sGrade = SessionData.getDataTbVal("SCORETABLE", row, "Grade");

			if (!sScoreFrom.isEmpty()) {
				reviewGradeStep.click_btn_new_score_range(sFromYearKey,
						sToYearKey, rowIndex);
				reviewGradeStep.enter_score_from(rowIndex, sScoreFrom);
			}
			if (!sScoreTo.isEmpty()) {
				reviewGradeStep.enter_score_to( rowIndex, sScoreTo);
			}
			if (!sGrade.isEmpty()) {
				reviewGradeStep.enter_grade(rowIndex, sGrade);
			}
		}
	}

	@And("^The Review Grade has new Review Type information as the following with Key as \"([^\"]*)\"$")
	public void the_review_grade_has_new_review_type_information_as_the_following_with_key_as_something(String dataKey,
			List<List<String>> reviewTable) {
		SessionData.addDataTable("REVIEWTABLE", reviewTable,false);
		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
		testData = SessionData.getDataTbRowsByValEqualInCol("REVIEWTABLE", "Key", dataKey);

		if (reviewGradeStep.is_disabled_review_type_all(sFromYearKey,
				sToYearKey, rowIndex) == false) {
			reviewGradeStep.check_review_type_all(sFromYearKey,
					sToYearKey, rowIndex);
			reviewGradeStep.click_btn_delete_review_type(sFromYearKey,
					sToYearKey, rowIndex);
			reviewGradeStep.confirm_yes();
		}

		for (int row : testData.keySet()) {
			String sKey = SessionData.getDataTbVal("REVIEWTABLE", row, "Key");
			String sReviewType = SessionData.getDataTbVal("REVIEWTABLE", row, "Review Type");

			if (!sReviewType.isEmpty()) {
				reviewGradeStep.click_btn_new_review_type( rowIndex);
				reviewGradeStep.enter_review_type(sReviewType, rowIndex);

			}
			
		}
	}

}