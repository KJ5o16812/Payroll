package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.trans.AddSalariedEmployeeTransaction;

public class PaydayTest {

	public void testPaydaySalaried(){
		int empId=6001;
		String name="Bill";
		double salary=3456.7;
		new AddSalariedEmployeeTransaction(empId,name,"Home",salary).execute();
		PaydayTransaction t = new PaydayTransaction();
		t.execute();
		Paycheck p =t.getPaycheck(empId);
		assertEquals(empId,p.getEmpId());
		assertEquals(name,p.getName());
		assertEquals(salary,p.getAmount(),0.01);
		assertNotNull(p.getDisposition());
		Employee employee=PayrollDatabase.getEmployee(empId);
		assertEquals(employee.getPaymentMethod().getDisposition(),p.getDisposition());
		
	}
	
	public void testPaydaySalariedMailMethod(){}
	
	public void testPaydaySalariedDirectMethod(){}
	
	public void testPaydayHourlyNoTimeCard(){}
	
	public void testPaydayHourlylessThan8Hours(){}
	
	public void testPaydayHourlyGreatThan8Hours(){}
	
	public void testPaydayHourlyMoreTimeCards(){}
	
	public void testPaydayCommissionedNoSalesReceipts(){}
	
	public void testPaydayCommissionedMoreSalesReceipts(){}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
