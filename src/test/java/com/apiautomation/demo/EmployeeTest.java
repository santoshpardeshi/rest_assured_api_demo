package com.apiautomation.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apiautomation.constants.StatusCodeConstant;
import com.apiautomation.payloads.EmployeePayload;

/**
 * Class that contain all test related to employee
 * 
 * @author santosh.pardeshi
 *
 */
public class EmployeeTest {
	EmployeePayload employeePayload;

	@BeforeTest
	public void init() {
		employeePayload = new EmployeePayload();
	}

	@Test
	public void verifyEmployeeStatus() {
		String status_success = "success";
		assertEquals(employeePayload.getEmployeeStatus(), status_success, "Employee status is not correct");

	}

	@Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "CreateEmployee")
	public void verifyCreateEmployeeData(String name, String salary, String age) {
		assertTrue(employeePayload.createEmployeeData(name, salary, age) == StatusCodeConstant.STATUS_CODE_OK,
				"Status code is not " + StatusCodeConstant.STATUS_CODE_OK + ". employee data is not created.");

	}

	@Test(dataProviderClass = EmployeeDataProvider.class, dataProvider = "UpdateEmployee")
	public void verifyUpdateEmployeeData(String name, String salary, String age) {
		assertTrue(employeePayload.updateEmployeeData(1, name, salary, age) == StatusCodeConstant.STATUS_CODE_OK,
				"Status code is not " + StatusCodeConstant.STATUS_CODE_OK + ". employee data is not updated.");
	}

	@Test
	public void verifyDeleteEmployeeData() {
		assertTrue(employeePayload.deleteEmployeeData(1) == StatusCodeConstant.STATUS_CODE_OK,
				"Status code is not " + StatusCodeConstant.STATUS_CODE_OK + ". employee data is not deleted.");
	}
}
