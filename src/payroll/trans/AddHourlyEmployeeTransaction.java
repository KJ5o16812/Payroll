package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.classification.SalariedClassification;
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction implements Transaction {


	private double hourlyRate;

	public AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
		super(empId,name,address);
		// TODO Auto-generated constructor stub
		
		this.hourlyRate = hourlyRate;
	}

	protected PaymentClassification getPaymentClassification(){
		return new HourlyClassification(hourlyRate);
	}

}
