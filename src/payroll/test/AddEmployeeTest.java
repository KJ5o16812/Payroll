package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PaymentMethod;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.classification.SalariedClassification;
import payroll.method.HoldMethod;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.AddSalariedEmployeeTransaction;

public class AddEmployeeTest {

	//添加小时工资雇员
	public void testAddHourlyEmployeeTransaction(){
		int empId = 1001;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;	
	//新建添加钟点工操作，并执行
		Transaction t =new AddHourlyEmployeeTransaction(empId, name ,address, hourlyRate);
		t.execute();
		//验证执行结果
		Employee e=PayrollDatabase.getEmployee(empId);//根据雇员编号读取雇员记录
		assertNotNull(e);//雇员记录存在
		assertEquals(name,e.getName());//名字正确
		assertEquals(address,e.getAddress());
		PaymentClassification pc =e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);//钟点工
		HourlyClassification hc =(HourlyClassification) pc;
		assertEquals(hourlyRate,hc.getHourlyRate(),0.01);//小时工资正确
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//支付方式默认为保存支票
		
	}
	//添加月薪雇员
	public void testAddSalariedEmployee(){
		int empId = 1002;
		String name = "Bill";
		String address = "Home";
		double salary = 2410.0;	
	//新建添加钟点工操作，并执行
		Transaction t =new AddSalariedEmployeeTransaction(empId, name ,address, salary);
		t.execute();
		//验证执行结果
		Employee e=PayrollDatabase.getEmployee(empId);//根据雇员编号读取雇员记录
		assertNotNull(e);//雇员记录存在
		assertEquals(name,e.getName());//名字正确
		assertEquals(address,e.getAddress());
		PaymentClassification pc =e.getPaymentClassification();
		assertTrue(pc instanceof SalariedClassification);//钟点工
		SalariedClassification hc =(SalariedClassification) pc;
		assertEquals(salary,hc.getSalary(),0.01);//小时工资正确
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//支付方式默认为保存支票
		
	}
	private PaymentClassification SalariedClassification() {
		// TODO Auto-generated method stub
		return null;
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
