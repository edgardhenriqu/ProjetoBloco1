package LojaRPG.Lojas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import LojaRPG.Item;
import LojaRPG.Pessoas.Cliente;

public class LojaArcoFlecha implements ILoja{

	public static Scanner scan = new Scanner(System.in);
	public List<Item> lojaArcoFlecha = Arrays.asList(new Item("",0), new Item("Arco de Fogo", 4), new Item("Arco do Trovao", 2), new Item("Arco de Gelo", 3));
	
	public void menuLoja(Cliente cliente) {

		System.out.println("Menu da loja de Poções");
		String condicao = "";
		do {

			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n |                         |");
			sb.append("\n |    1 - Comprar Item |"); // A LOJA VENDE PARA O CLIENTE
			sb.append("\n |     2 - vender Item |"); // A LOJA COMPRA DO CLIENTE
//			sb.append("\n |     0 - Sair... |");
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
				System.out.println("Comprando itens de Arco e Flecha do Mercador");
				condicao = "0";
				break;
			case "2":
				try {
				System.out.println("Vendendo seus Arcos e Flechas");
				cliente.getArcoFlecha(cliente.arcoFlechaCliente);
				cliente.vendaDeArcoFlecha();
				
				
				
				cliente.setSaldo(cliente.getSaldo() + lojaArcoFlecha.get(1).getPreco());
				System.out.println(cliente.getSaldo());
				
				
				}
				catch(IndexOutOfBoundsException erroIndex) {
					System.out.println("Voce nao tem mais arcos e flechas para vender!!!" + erroIndex);
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
				cliente.setSaldo(cliente.getSaldo() - lojaArcoFlecha.get(1).getPreco());
				cliente.arcoFlechaCliente.add(lojaArcoFlecha.get(1));
				System.out.println(cliente.getSaldo());
				condicao = "0";
				break;
			case "2":
				cliente.setSaldo(cliente.getSaldo() - lojaArcoFlecha.get(2).getPreco());
				cliente.arcoFlechaCliente.add(lojaArcoFlecha.get(2));
				System.out.println(cliente.getSaldo());
				condicao = "0";
				break;
			case "3":
				cliente.setSaldo(cliente.getSaldo() - lojaArcoFlecha.get(3).getPreco());
				cliente.arcoFlechaCliente.add(lojaArcoFlecha.get(3));
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
