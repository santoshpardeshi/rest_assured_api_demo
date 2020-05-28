package com.apiautomation.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Employee data pojo class
 * 
 * @author santosh.pardeshi
 *
 */

@Getter
@Setter
public class EmployeeData {

	private String id;
	@JsonProperty("employee_name")
	private String employeeName;
	@JsonProperty("employee_salary")
	private String employeeSalary;
	@JsonProperty("employee_age")
	private String employeeAge;
	@JsonProperty("profile_image")
	private String profileImage;

}
