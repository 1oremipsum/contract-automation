package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;

public class Main {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		registerContract();
		sc.close();
	}
	
	public static Contract registerContract() {
		System.out.println("Enter the data of contract");
	
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), dtf);
	
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		System.out.print("Enter the number of installments: ");
		Integer numbInstallments = sc.nextInt();
		
		return new Contract(number, date, totalValue);
	}
}
