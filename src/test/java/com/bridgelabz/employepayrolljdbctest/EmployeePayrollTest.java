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
		employeePayrollJdbc = EmployeePayrollJdbc.getInstance();
		Assert.assertTrue(employeePayrollJdbc.dbConnect()!=null);
	}
	
	@Test
	public void ifData_FromDataBase_ShouldReturnSize() throws SQLException{
		employeePayrollService = new EmployeePayrollService();
		String query = "select * from employee;";
		Integer res = employeePayrollService.getQuery(query);
		Assert.assertEquals((Integer)4,res);
	}
	
	@Test
	public void ifData_UpdatePerform_ShouldReturnTrue() throws SQLException{
		employeePayrollService = new EmployeePayrollService();
		int res = employeePayrollService.updateData("Terissa",3000000.00);
		Assert.assertEquals(2,res);
	}
	
	@Test
	public void ifData_UpdatePerformUsingPrepared_ShouldReturnTrue() throws SQLException{
		employeePayrollService = new EmployeePayrollService();
		int res = employeePayrollService.updatePreparedData("Terissa",3000000.00);
		Assert.assertEquals(2,res);
	}
	
	@Test
	public void ifData_FromDataBaseDate_ShouldReturnSize() throws SQLException{
		employeePayrollService = new EmployeePayrollService();
		Integer res = employeePayrollService.retrieveDate();
		Assert.assertEquals((Integer)4,res);
	}
}
