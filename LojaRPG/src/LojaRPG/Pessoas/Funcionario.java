package LojaRPG.Pessoas;

public class Funcionario extends Pessoa {

	private String nome;
	private double salario;// GANHA P„O
	private String cargo;

	public Funcionario() {

	}

	public Funcionario(String nome, String raca, String classe, String cargo) {
		super(classe, raca);
		this.cargo = cargo;
		this.nome = nome;
		definirSalarioComCargo(this.cargo);
	}

	public String definirSalarioComCargo(String cargo) {
		if (this.cargo.equalsIgnoreCase("Gerente"))
			this.salario = 8000;
		else if (this.cargo.equalsIgnoreCase("Analista"))
			this.salario = 5000;
		else
			this.salario = 2500;
		return cargo;
	}

//	public int getCod() {
//		return cod;
//	}
	
	

	public double getSalario() {
		return salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String status() {
		return /*Cod: " + getCod() +*/ ", Nome: " + getNome()+ ", Cargo: " + getCargo() + ", Sal·rio: " + getSalario();
	}

}