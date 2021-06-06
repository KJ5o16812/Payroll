package payroll.trans;

import java.util.List;

import payroll.Employee;
import payroll.Paycheck;
import payroll.PayrollDatabase;
import payroll.Transaction;

public class PaydayTransaction implements Transaction {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<Employee> employeeList = PayrollDatabase.listEmployee();
		for(Employee employee :	employeeList){
			Paycheck paycheck = new Paycheck();
			employee.pay(paycheck);
			paychecks.put(paycheck.getEmpId(),paycheck);
		}

	}

	public Paycheck getPaycheck(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
