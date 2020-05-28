package com.apiautomation.pojos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Employee pojo class
 * 
 * @author santosh.pardeshi
 *
 */
@Getter
@Setter
public class Employees {
	private String status;
	private List<EmployeeData> data;
}
