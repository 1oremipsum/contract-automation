package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Main {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);
	private static ContractService service;
	
	public static void main(String[] args) {
		printInstallments(defineInstallments(registerContract()));
		sc.close();
		/* Example of data input and output:
		 * 
		 * Number: 2020
		 * Date (dd/MM/yyyy): 13/10/2023
		 * Contract value: 600,0
		 * Enter the number of installments of contract: 3
		 * 13/11/2023 - $206,04
		 * 13/12/2023 - $208,08
	     * 13/01/2024 - $210,12
		 */
	}
	
	private static Contract registerContract() {
		System.out.println("Enter the data of contract");
	
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), dtf);
	
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		return new Contract(number, date, totalValue);
	}
	
	private static Contract defineInstallments(Contract contract) {
		System.out.print("Enter the number of installments of contract: ");
		Integer n = sc.nextInt();
		
		service = new ContractService(new PaypalService());
		service.processContract(contract, n);
		
		return contract;
	}
	
	private static void printInstallments(Contract contract) {
		for(Installment i: contract.getInstallments()) {
			System.out.println(i);
		}
	}
}
