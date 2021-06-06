package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;
import payroll.Paycheck;
import payroll.PayrollDatabase;
import payroll.trans.AddSalariedEmployeeTransaction;
import payroll.trans.PaydayTransaction;

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
	
	public void testPaydaySalariedMailMethod(){
		int empId=60011;
		String name="Bill";
		double salary=3456.7;
		new AddSalariedEmployeeTransaction(empId,name,"Home",salary).execute();
		new ChangeMailTransaction(empId,"BZU").execute();
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
