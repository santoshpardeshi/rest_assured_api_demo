package com.apiautomation.demo;

import org.testng.annotations.DataProvider;

/**
 * Employee data provider
 * 
 * @author santosh.pardeshi
 *
 */
public class EmployeeDataProvider {

	/** Default constructor */
	private EmployeeDataProvider() {
	}

	/**
	 * Create employee data
	 * 
	 * @return as 2D object array
	 */
	@DataProvider(name = "CreateEmployee")
	public static Object[][] createEmployee() {
		return new Object[][] { { "Santosh", "1233", "30" } };
	}

	/**
	 * update employee data
	 * 
	 * @return as 2D object array
	 */
	@DataProvider(name = "UpdateEmployee")
	public static Object[][] updateEmployee() {
		return new Object[][] { { "Santosh Pardeshi", "122", "31" } };
	}
}
