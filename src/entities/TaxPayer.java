package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public double salaryTax(){
		if(this.getSalaryIncomeByMonth() > 5000.00)
			return (this.getSalaryIncome() * 20) / 100;
		if(this.getSalaryIncomeByMonth() > 3000.00 &&
				this.getSalaryIncomeByMonth() < 5000.00)
			return (this.getSalaryIncome() * 10) / 100;
		return 0;		
	}
	
	public double servicesTax(){
		if(this.getServicesIncome() > 0.00)
			return (this.getServicesIncome() * 15) / 100;
		return 0;
	}
	
	public double capitalTax(){
		if(this.getCapitalIncome() > 0.00)
			return (this.getCapitalIncome() * 20) / 100;
		return 0;		
	}
	
	public double grossTax(){
		return this.salaryTax() +
				this.servicesTax() +
				this.capitalTax();
	}
	
	public double taxRebate(){
		if(((this.grossTax()*30)/100)<=(this.getEducationSpending() + this.getHealthSpending()))
			return this.grossTax() - ((this.grossTax()*30)/100);
		return this.getEducationSpending() + this.getHealthSpending();
	}

	public double netTax(){
		return  this.grossTax() - this.taxRebate();
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}
	
	public double getSalaryIncomeByMonth() {
		return salaryIncome/12;
	}
	
	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	
}
