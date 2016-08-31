package fr.pizzeria.exception;

public class DebitException extends Exception {
	
	private static final String MessageDebitException = "Attention le solde du Client est insuffisant !";
	
	public DebitException() {
		super(MessageDebitException);
		// TODO Auto-generated constructor stub
	}
	
}
