package com.apiautomation.payloads;

import java.util.Arrays;
import java.util.HashMap;

import com.apiautomation.pojos.Employees;
import com.apiautomation.util.ConfigurationReader;

import io.restassured.RestAssured;

/**
 * Class contain employee pay load functions
 * 
 * @author santosh.pardeshi
 *
 */
public class EmployeePayload {

	ConfigurationReader configurationReader = ConfigurationReader.getInstance();

	/**
	 * Get all Employee list as response
	 * 
	 * @return as Employees
	 */
	private Employees getEmployees() {
		return RestAssured.given()
				.get(configurationReader.getProperty("base_url") + configurationReader.getProperty("all_employees"))
				.as(Employees.class);

	}

	/**
	 * Create new user and give status code
	 * 
	 * @param name   : employee name
	 * @param salary : employee salary
	 * @param age    : employee age
	 * @return status code
	 */
	public int createEmployeeData(String name, String salary, String age) {
		HashMap<String, String> body = new HashMap<>();
		body.put("name", name);
		body.put("salary", salary);
		body.put("age", age);
		return RestAssured.given().when().body(Arrays.asList(body))
				.post(configurationReader.getProperty("base_url") + configurationReader.getProperty("create_employee"))
				.getStatusCode();
	}

	/**
	 * update existing employee data
	 * 
	 * @param id     : employee id to update
	 * @param name   employee name to update
	 * @param salary employee salary to update
	 * @param age    employee age to update
	 * @return status code
	 */
	public int updateEmployeeData(int id, String name, String salary, String age) {

		HashMap<String, String> body = null;
		if (getEmployees().getData().stream().anyMatch(emp -> emp.getId().equals(String.valueOf(id)))) {
			body = new HashMap<>();
			body.put("name", name);
			body.put("salary", salary);
			body.put("age", age);

		}
		return RestAssured.given().when().body(Arrays.asList(body)).put(
				configurationReader.getProperty("base_url") + configurationReader.getProperty("update_employee") + id)
				.getStatusCode();

	}

	/**
	 * Delete employee record
	 * 
	 * @param id employee id
	 * @return status code
	 */
	public int deleteEmployeeData(int id) {
		return RestAssured.delete(
				configurationReader.getProperty("base_url") + configurationReader.getProperty("delete_book") + id)
				.getStatusCode();
	}

	/**
	 * Get status of employee list
	 * 
	 * @return as String
	 */
	public String getEmployeeStatus() {
		return getEmployees().getStatus();
	}
}
