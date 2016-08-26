package com.synergix.common.pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.synergix.common.LogWork;
import com.synergix.utilities.ConnectDatabase;

import net.serenitybdd.core.pages.PageObject;

public class DatabaseTaskhub extends PageObject {

	public List<String> check_database_connection_pass_parameter_command() {
		String sql_query = "SELECT * FROM SYS_EMPLOYEE_SYS_ROLE_GLBL WHERE EMPLOYEE_ROLE_CODE = 'CEO'";
		ResultSet rs = null;

		ConnectDatabase.connect();
		rs = ConnectDatabase.executeQuery(sql_query);

		List<String> employeeRole = new ArrayList<String>();
		try {
			while (rs.next()) {
				employeeRole.add(rs.getString("EMPLOYEE_ROLE_CODE"));
				employeeRole.add(rs.getString("EMPLOYEE_ROLE_DESC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabase.close();

		LogWork.log_debug("EMPLOYEE_ROLE_CODE: " + employeeRole.get(0));
		LogWork.log_debug("EMPLOYEE_ROLE_DESC: " + employeeRole.get(1));

		return employeeRole;

	}

	
	public void execute_sql(String dbName, String sql_query) {
		ConnectDatabase.connect(dbName);
		ConnectDatabase.executeUpdate(sql_query);
		ConnectDatabase.close();
	}
}
