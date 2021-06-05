package payroll.classification;

import payroll.PaymentClassification;

public class CommissionedClassification extends PaymentClassification {

	private double salary;
	private double commissionRate;

	public CommissionedClassification(double salary, double commissionRate) {
		this.salary = salary;
		// TODO Auto-generated constructor stub
		this.commissionRate = commissionRate;
	}

	public double getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}

	public double getCommissionRate() {
		// TODO Auto-generated method stub
		return 0;
	}


}
