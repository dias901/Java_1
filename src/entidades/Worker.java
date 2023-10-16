package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departamento departamento;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary,Departamento departamento) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departamento = departamento;
	}
	
	public List<HourContract> getContracts(){
		return contracts;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public Double income(int year, int month) {
		Double soma = baseSalary;
		LocalDate cal = LocalDate.now();
		for (HourContract c : contracts) {
			cal = c.getDate();
			int c_year = cal.getYear();
			int c_month = cal.getMonthValue();
			if (year == c_year && month == c_month) {
				soma += c.totalValor();
			}
		}
		
		return soma;
}
	
}

