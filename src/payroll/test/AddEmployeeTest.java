package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

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
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
