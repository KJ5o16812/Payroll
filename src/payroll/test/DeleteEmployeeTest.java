package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.trans.AddHourlyEmployeeTransaction;

public class DeleteEmployeeTest {

	@Test
	public void testDeleteEmployeeExisted(){
		int empId=2001;
		new AddHourlyEmployeeTransaction(empId,"Bill","Home",12.5).execute();
		
	}
	public void test() {
		fail("Not yet implemented");
	}

}
