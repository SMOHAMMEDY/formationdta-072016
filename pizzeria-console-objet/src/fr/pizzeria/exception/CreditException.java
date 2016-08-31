package fr.pizzeria.exception;

public class CreditException extends Exception {
	
private static final String MessageCreditException = "Attention le solde du Client est supérieur à 5000 € !";
	
	public CreditException() {
		super(MessageCreditException);
		// TODO Auto-generated constructor stub
	}

	}

