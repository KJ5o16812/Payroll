package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.exception.NoSuchEmployeeException;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.DeleteEmployeeTransaction;

public class DeleteEmployeeTest {

	@Test
	public void testDeleteEmployeeExisted(){
		int empId=2001;
		new AddHourlyEmployeeTransaction(empId,"Bill","Home",12.5).execute();
		
		Transaction t =new DeleteEmployeeTransaction(empId);
		t.execute();
		
		Employee e=PayrollDatabase.getEmployee(empId);
		assertNull(e);
	}
	public void testDeleteEmployeeNotExisted(){
		int empId = 2002;
		Employee employee=PayrollDatabase.getEmployee(empId);
		assertNull(employee);
		Transaction t =new DeleteEmployeeTransaction(empId);
		try{
		t.execute();
		fail("No such employee");
		}catch(Exception e){
			assertTrue(e instanceof NoSuchEmployeeException);
		}
		
		
	}
	public void test() {
		fail("Not yet implemented");
	}

}
