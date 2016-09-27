package springMvc;

public class RepBody {

	private boolean succes;
	private double solde;
	private String msg;
	

	public RepBody() {
		super();
	}
	
	
	public boolean isSucces() {
		return succes;
	}
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
