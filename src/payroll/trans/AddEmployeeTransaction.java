package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.SalariedClassification;
import payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction   {

	private int empId;

	public AddEmployeeTransaction(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	protected abstract PaymentClassification getPaymentClassification();

	private String name;
	private String address;

	public AddEmployeeTransaction() {
		super();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Employee employee =new Employee(empId,name,address);
		employee.setPaymentClassification(getPaymentClassification());
		employee.setPaymentMethod(new HoldMethod());
		PayrollDatabase.save(employee);
	
	}

}