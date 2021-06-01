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

	//���Сʱ���ʹ�Ա
	public void testAddHourlyEmployeeTransaction(){
		int empId = 1001;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;	
	//�½�����ӵ㹤��������ִ��
		Transaction t =new AddHourlyEmployeeTransaction(empId, name ,address, hourlyRate);
		t.execute();
		//��ִ֤�н��
		Employee e=PayrollDatabase.getEmployee(empId);//���ݹ�Ա��Ŷ�ȡ��Ա��¼
		assertNotNull(e);//��Ա��¼����
		assertEquals(name,e.getName());//������ȷ
		assertEquals(address,e.getAddress());
		PaymentClassification pc =e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);//�ӵ㹤
		HourlyClassification hc =(HourlyClassification) pc;
		assertEquals(hourlyRate,hc.getHourlyRate(),0.01);//Сʱ������ȷ
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//֧����ʽĬ��Ϊ����֧Ʊ
		
	}
	//�����н��Ա
	public void testAddSalariedEmployee(){
		int empId = 1002;
		String name = "Bill";
		String address = "Home";
		double salary = 2410.0;	
	//�½�����ӵ㹤��������ִ��
		Transaction t =new AddSalariedEmployeeTransaction(empId, name ,address, salary);
		t.execute();
		//��ִ֤�н��
		Employee e=PayrollDatabase.getEmployee(empId);//���ݹ�Ա��Ŷ�ȡ��Ա��¼
		assertNotNull(e);//��Ա��¼����
		assertEquals(name,e.getName());//������ȷ
		assertEquals(address,e.getAddress());
		PaymentClassification pc =e.getPaymentClassification();
		assertTrue(pc instanceof SalariedClassification);//�ӵ㹤
		SalariedClassification hc =(SalariedClassification) pc;
		assertEquals(salary,hc.getSalary(),0.01);//Сʱ������ȷ
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//֧����ʽĬ��Ϊ����֧Ʊ
		
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
