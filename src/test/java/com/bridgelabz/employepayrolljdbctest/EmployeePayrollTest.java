package com.bridgelabz.employepayrolljdbctest;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeejdbc.EmployeePayrollJdbc;
import com.bridgelabz.employeejdbc.EmployeePayrollService;


public class EmployeePayrollTest {
	EmployeePayrollJdbc employeePayrollJdbc;
	EmployeePayrollService employeePayrollService;
	
	
	@Test
	public void ifConnection_IsSuccessful_ShouldReturnTrue() {
		employeePayrollJdbc = new EmployeePayrollJdbc();
		Assert.assertTrue(employeePayrollJdbc.dbConnect()!=null);
	}
	
	@Test
	public void ifData_FromDataBase_ShouldReturnSize() throws SQLException{
		employeePayrollService = new EmployeePayrollService();
		String query = "select * from employee;";
		Integer res = employeePayrollService.getQuery(query);
		Assert.assertEquals((Integer)4,res);
	}
}
