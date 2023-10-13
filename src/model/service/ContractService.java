package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService ops;

	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer months) {	
		Double basicQuota = getBasicQuota(contract, months);
		
		for(int i=1; i<=months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			Double interest = ops.interest(basicQuota, i);
			Double fee = ops.paymentFee(basicQuota + interest);
			Double quota = basicQuota + interest + fee;
			
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
	}
	
	private Double getBasicQuota(Contract contract, Integer months) {
		return contract.getTotalValue() / months;
	}
}
