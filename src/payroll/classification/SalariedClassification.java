package payroll.classification;

import payroll.PaymentClassification;

public class SalariedClassification extends PaymentClassification {
	private double salary;

	public SalariedClassification(double salary) {
		// TODO Auto-generated constructor stub
		this.salary=salary;
	}

	public double getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}

}
