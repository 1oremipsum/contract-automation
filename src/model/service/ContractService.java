package model.service;

import model.entities.Contract;

public class ContractService {
	private OnlinePaymentService ops;

	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer months) {
		
	}
}
