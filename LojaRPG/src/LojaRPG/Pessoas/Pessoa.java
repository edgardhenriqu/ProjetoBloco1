package LojaRPG.Pessoas;


public class Pessoa
{
	
	protected String classe;
	protected String raca;
	protected String statusSocial;

	public Pessoa() {
		
	}
	
	public Pessoa(String raca){
		this.raca = raca;
	}
	
	public Pessoa(String raca, String classe) {
		this.raca = raca;
		this.classe = classe;
	}
	
	public String getClasse() {
		return classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getStatusSocial() {
		return statusSocial;
	}

	public void setStatusSocial(String statusSocial) {
		this.statusSocial = statusSocial;
	}
	
	
	
}
