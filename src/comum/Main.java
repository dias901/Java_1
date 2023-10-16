package comum;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HourContract;
import entidades.Worker;
import entidades.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		System.out.print("Insira o nome do departamento: ");
		String departamento = sc.nextLine();
		System.out.println("\nInsira dados do trabalhador");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("\nLevel: ");
		String level = sc.nextLine();
		System.out.print("\nSalário base0: ");
		Double salary = sc.nextDouble();
		Worker foda = new Worker(nome,WorkerLevel.valueOf(level),salary,new Departamento(departamento));
		
		System.out.println("\nQuanto Contratos tem este trabalhador?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate contractDate = LocalDate.parse(sc.next(),sdf);
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			foda.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + foda.getName());
		System.out.println("Department: " + foda.getDepartamento().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", foda.income(year, month)));
		
		sc.close();
		
	}
}