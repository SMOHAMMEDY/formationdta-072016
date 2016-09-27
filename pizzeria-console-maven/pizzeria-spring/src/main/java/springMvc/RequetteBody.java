package springMvc;

public class RequetteBody {
	
	private String operation;
	private double montant;
	
	
	
	
	public RequetteBody() {
		super();
	}
	
	
	
	public String getOperation() {
		return operation;
	}
		public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}

}
