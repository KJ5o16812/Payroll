package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

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
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
