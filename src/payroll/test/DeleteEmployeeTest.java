package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.trans.AddHourlyEmployeeTransaction;

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
	public void test() {
		fail("Not yet implemented");
	}

}
