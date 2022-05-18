package LojaRPG.Lojas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import LojaRPG.Item;
import LojaRPG.Programa;
import LojaRPG.Pessoas.Cliente;

public class LojaPocao implements ILoja{

	public static Scanner scan = new Scanner(System.in);
	public List<Item> lojaItensPocao = Arrays.asList(new Item("",0), new Item("Pocao do Trovao", 2), new Item("Pocao do Ar", 4), new Item("Pocao da Terra", 3));
	Programa programa = new Programa();
	
	public LojaPocao() {
		
	}

	public void menuLoja(Cliente cliente) {

		System.out.println("Menu da loja de Poções");
		String condicao = "";
		do {

			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n |                         |");
			sb.append("\n |    1 - Comprar Item |"); // A LOJA VENDE PARA O CLIENTE
			sb.append("\n |     2 - vender Item |"); // A LOJA COMPRA DO CLIENTE
//			sb.append("\n |     0 - Sair  |");
			sb.append("\n |                       |");
			sb.append("\n=========================");
			sb.append("\nOpcão --> ");
			System.out.println(sb);
			condicao = scan.next();
			System.out.println(condicao);

			switch (condicao) {

//			case "0":
//				System.out.println("Volte sempre!");
//				condicao = "0";
//				break;
			case "1":
				System.out.println("Comprando itens de Pocoes do Mercador");
				
				condicao = "0";
				break;
			case "2":
				try {
				System.out.println("Vendendo SEUS itens");
				cliente.getPocoesCliente(cliente.pocoesCliente);
				cliente.vendaDePocoes();
				
				
				
				cliente.setSaldo(cliente.getSaldo() + lojaItensPocao.get(1).getPreco());
				System.out.println(cliente.getSaldo());
				
				
				}
				catch(IndexOutOfBoundsException erroIndex) {
					System.out.println("Voce nao tem mais pocoes para vender!!!" + erroIndex);
				}
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;

			}

		} while (!condicao.equals("0"));

	}
	
	public void escolherIten(Cliente cliente) {
		String condicao = " ";
		do {

			condicao = scan.next();

			switch (condicao) {
			case "1":
				cliente.setSaldo(cliente.getSaldo() - lojaItensPocao.get(1).getPreco());
				cliente.pocoesCliente.add(lojaItensPocao.get(1));
				System.out.println(cliente.getSaldo());
				condicao = "0";
				break;
			case "2":
				cliente.setSaldo(cliente.getSaldo() - lojaItensPocao.get(2).getPreco());
				cliente.pocoesCliente.add(lojaItensPocao.get(2));
				System.out.println(cliente.getSaldo());
				condicao = "0";
				break;
			case "3":
				cliente.setSaldo(cliente.getSaldo() - lojaItensPocao.get(3).getPreco());
				cliente.pocoesCliente.add(lojaItensPocao.get(3));
				System.out.println(cliente.getSaldo());
				condicao = "0";
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
				break;
			}
		} while (!condicao.equals("0"));
	}

	
	

	
	
}
