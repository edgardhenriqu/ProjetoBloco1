package LojaRPG.Pessoas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import LojaRPG.Item;


public class Cliente extends Pessoa
{

	Random rand = new Random();
	
	public int crf;
	public double saldo;
	public List<Item> pocoesCliente = new ArrayList<>();
	public List<Item> arcoFlechaCliente = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public Cliente() {
	}
	
	public Cliente(String raca) {
		super(raca);
	}
	
	public void getPocoesCliente(List<Item> pocoesCliente) {
		for(int i =0;i<pocoesCliente.size();i++) {
			System.out.println(i+1 + " - "  + pocoesCliente.get(i).getNome() + ", " + pocoesCliente.get(i).getPreco() + "]");

		}
	}
	
	public void getArcoFlecha(List<Item> arcoFlecha) {
		for(int i =0;i<arcoFlecha.size();i++) {
			System.out.println(i+1 + " - "  + arcoFlecha.get(i).getNome() + ", " + arcoFlecha.get(i).getPreco() + "]");

		}
	}
	
	@Override
	public String getStatusSocial() {
		return statusSocial;
	}
	@Override
	public void setStatusSocial(String statusSocial) {
		this.statusSocial = statusSocial;
	}
	
	public Cliente(String raca, String classe) {
		super(raca, classe);
		this.crf = geradorCRF();
	}
	
	public int geradorCRF()
	{
		return this.crf = rand.nextInt(100000,999999);
		
	}

	public int getCrf() {
		return crf;
	}

	public void setCrf(int crf) {
		this.crf = crf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	public void vendaDePocoes() {
		
		String condicao = "";
		do {

			condicao = scan.next();
			System.out.println(condicao);

			switch (condicao) {

			case "0":
				System.out.println("Volte sempre!");
				condicao = "0";
				break;
			case "1":
				pocoesCliente.remove(0);
				condicao = "0";
				break;
			case "2":
				condicao = "0";
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;

			}

		} while (!condicao.equals("0"));
		
	}
	
	public void vendaDeArcoFlecha() {
		String condicao = "";
		do {

			condicao = scan.next();
			System.out.println(condicao);

			switch (condicao) {

			case "0":
				System.out.println("Volte sempre!");
				condicao = "0";
				break;
			case "1":
				arcoFlechaCliente.remove(0);
				condicao = "0";
				break;
			case "2":
				condicao = "0";
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;

			}

		} while (!condicao.equals("0"));
	}
	

	public String status() {
		return getClasse() + "\n" + getRaca() + "\n" + getCrf() + "\n" + getSaldo();
	}
	


	
}