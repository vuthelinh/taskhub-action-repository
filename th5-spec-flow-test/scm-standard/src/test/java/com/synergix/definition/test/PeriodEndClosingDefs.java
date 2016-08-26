package com.synergix.definition.test;

import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.synergix.mtsetup.financial.accounting.steps.PeriodEndClosingSteps;
import com.synergix.utilities.ConnectDatabase;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PeriodEndClosingDefs {
	@Steps
	PeriodEndClosingSteps periodEndClosingSteps;

	@Then("^user submits current IC in Period End Closing$")
	public void user_submit_current_IC_in_Period_End_Closing() throws Throwable {
		ConnectDatabase.connect();
		boolean stop = true;
		String sSqlStatement = "select X.INVENTORY_VOUCHER_NO,X.TRANSACTION_DATE from " + "IC_VCH_NEW_HDR AS X "
				+ "INNER JOIN " + "( select B.PERIOD_START_DATE,B.PERIOD_CLOSING_DATE " + "from IC_SYSTEM_SETUP AS A "
				+ "INNER JOIN MT_FINANCIAL_PERIOD AS B " + "ON A.POINTER_KEY = 0 "
				+ "AND A.CURRENT_YEAR = B.FINANCIAL_YEAR " + "AND A.CURRENT_PERIOD = B.FINANCIAL_PERIOD ) AS Y " + "ON "
				+ "X.TRANSACTION_DATE BETWEEN Y.PERIOD_START_DATE AND Y.PERIOD_CLOSING_DATE "
				+ "ORDER BY X.TRANSACTION_DATE";

		ResultSet rs = null;
		try {
			rs = ConnectDatabase.executeQuery(sSqlStatement);
			System.out.println("***** INFO ***** SQL Statement : " + sSqlStatement);
			if (!rs.next()) {
				stop = false;
			} else {
				fail("***** FAIL *****  SQL Statement :Existed unsubmit voucher. Check agains.");
			}
			ConnectDatabase.close();
		} catch (SQLException e) {
			stop = false;
			e.printStackTrace();
			fail("***** FAIL *****  SQL Statement : " + sSqlStatement + "\n\r" + "Error: " + e.toString());
			ConnectDatabase.close();
		}
		if (!stop) {
			int rowIndex = periodEndClosingSteps.get_row_by_module_code("IC");
			periodEndClosingSteps.select_module_code(rowIndex, "Yes");
			periodEndClosingSteps.submit_period_end_closing();
		}
	}

}
