package LojaRPG;

import java.util.Scanner;

import LojaRPG.Lojas.LojaArcoFlecha;
import LojaRPG.Lojas.LojaPocao;
import LojaRPG.Pessoas.Cliente;
import LojaRPG.Pessoas.Funcionario;

public class Programa {

	Scanner scan = new Scanner(System.in);
	public Cliente cliente = new Cliente();
	public Funcionario func = new Funcionario("Deckard Cain", "Human", "Mago", "Analista");

	public void menu() throws Exception {
		fraseIntrodutoria();
		String condicao = " ";

		do {

			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n | Seja bem-vindo! Digite: |");
			sb.append("\n |                         |");
			sb.append("\n |    1 - Jogar            |");
			sb.append("\n |     2 - Info criadores |");
			sb.append("\n |     0 - Encerrar        |");
			sb.append("\n=========================");
			sb.append("\nOpc�o --> ");
			System.out.println(sb);
			condicao = scan.next();
			System.out.println(condicao);

			switch (condicao) {

			case "0":
				System.out.println("Saindo.....");
				condicao = "0";

				break;
			case "1":
				System.out.println("jogar");
				iniciarJogo();
				condicao = "0";
				break;
			case "2":
				System.out.println("Info criadores");
				infoCriadores();
				condicao = "0";
				break;
			default:
				System.out.println("Op��o inv�lida! Tente novamente.");
				break;

			}

		} while (!condicao.equals("0"));
	}
	
	public void iniciarJogo() throws Exception {
		System.out.println("Iniciando jogo!");
		String condicao = " ";
		do {

			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n |                         |");
			sb.append("\n |    1 - Criar personagem |");
			sb.append("\n |     0 - Encerrar        |");
			sb.append("\n=========================");
			sb.append("\nOpc�o --> ");
			System.out.println(sb);
			condicao = scan.next();
			System.out.println(condicao);

			switch (condicao) {

			case "0":
				System.out.println("Saindo.....");
				break;
			case "1":
				System.out.println("Criar Personagem***");
				criarPersonagem();
				escolhaLoja(cliente);
				condicao = "0";
				break;

			default:
				System.out.println("Op��o inv�lida! Tente novamente.");
				break;

			}

		} while (!condicao.equals("0"));

	}
	
	private static void infoCriadores() {
		StringBuilder sb = new StringBuilder();
		sb.append("Augusto");
		sb.append("\nCamilla");
		sb.append("\nEdgard");
		sb.append("\nHenrique");
		sb.append("\nJonathan");
		sb.append("\nVit�ria");
		sb.append("\nRenan");
		System.out.println(sb);
	}
	
	private void criarPersonagem() {
		cliente.setRaca(menuRacaPersonagem());
		cliente.setClasse(menuClassePersonagem());
		cliente.setSaldo(100.0);
		cliente.geradorCRF();
	}

	public String menuRacaPersonagem() {

		String racaPersonagem = " ";
		String condicao = " ";
		do {
			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n |                         |");
			sb.append("\n |     1 - An�o         |");
			sb.append("\n |     2 - Elfo           |");
			sb.append("\n |     3 - Minotauro        |");
			sb.append("\n |     4 - Gnomo        |");
			sb.append("\n |     5 - Goblin|");
			sb.append("\n Opc�o --> ");
			System.out.println(sb);
			condicao = scan.next();

			switch (condicao) {
			case "1":
				System.out.println("An�o***");
				racaPersonagem = "An�o";
				condicao = "0";
				Artes.anao();
				System.out.println(Artes.fraseAnao);
				break;
			case "2":
				System.out.println("Elfo***");
				racaPersonagem = "Elfo";
				condicao = "0";
				Artes.elfo();
				System.out.println(Artes.fraseElfo);
				break;
			case "3":
				System.out.println("Minotauro***");
				racaPersonagem = "Minotauro";
				condicao = "0";
				Artes.minotauroArt();
				System.out.println(Artes.fraseMinotauro);
				break;
			case "4":
				System.out.println("Gnomo***");
				racaPersonagem = "Gnomo";
				condicao = "0";
				Artes.gnomo();
				System.out.println(Artes.fraseGnomo);
				break;
			case "5":
				System.out.println("Goblin***");
				racaPersonagem = "Goblin";
				condicao = "0";
				Artes.goblin();
				System.out.println(Artes.fraseGoblin);
				break;

			default:
				System.out.println("Op��o inv�lida! Tente novamente.");
			}

		} while (!condicao.equals("0"));

		return racaPersonagem;
	}
	
	public void escolhaLoja(Cliente cliente) {
		String condicao = " ";
		System.out.println("Ol� "+cliente.getRaca()+" meu nome � " + func.getNome() + ", o que posso fazer por voc�?");
		do {

			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n |                         |");
			sb.append("\n |     1 - Loja de Po��es  |");
			sb.append("\n |     2 - Loja de Arco e Flecha  |");
			sb.append("\n |     0 - Sair  |");
			sb.append("\n  =========================");
			sb.append("\nOpc�o --> ");
			System.out.println(sb);
			
			condicao = scan.next();

			LojaPocao lojaPocao = new LojaPocao();
			LojaArcoFlecha lojaArcoFlecha = new LojaArcoFlecha();
			switch (condicao) {
			case "1":
		
				lojaPocao.menuLoja(cliente);
				
				System.out.println("Loja de po��es***");
					for(int i=1; i<lojaPocao.lojaItensPocao.size(); i++) {
						System.out.println(i+": "+lojaPocao.lojaItensPocao.get(i).getNome() + " R$" + lojaPocao.lojaItensPocao.get(i).getPreco());
					}

				lojaPocao.escolherIten(cliente);
				escolhaLoja(cliente);
				
				condicao = "0";
				break;
				
			case "2":
				lojaArcoFlecha.menuLoja(cliente);
				System.out.println("Loja de Arco e Flecha***");
					for(int i=1; i<lojaArcoFlecha.lojaArcoFlecha.size(); i++) {
						System.out.println(i+": "+lojaArcoFlecha.lojaArcoFlecha.get(i).getNome() + " R$" + lojaArcoFlecha.lojaArcoFlecha.get(i).getPreco());
					}

				lojaArcoFlecha.escolherIten(cliente);
				escolhaLoja(cliente);
				condicao = "0";
				break;
			case "0":
				System.out.println("Saindo...");
				condicao = "0";
				break;
			default:
				System.out.println("Op��o inv�lida! Tente novamente.");
				break;
			}
		} while (!condicao.equals("0"));

	}
	
	private String menuClassePersonagem() {

		String classePersonagem = " ";
		String condicao = " ";
		do {
			StringBuilder sb = new StringBuilder();
			sb.append("\n  =========================");
			sb.append("\n |                         |");
			sb.append("\n |     1 - Guerreiro         |");
			sb.append("\n |     2 - Arqueiro           |");
			sb.append("\n |     3 - Mago        |");
			sb.append("\n |     4 - Ladr�o        |");
			sb.append("\n |     5 - Curandeiro|");
			sb.append("\n  =========================");
			sb.append("\n Opc�o --> ");
			System.out.println(sb);
			condicao = scan.next();

			switch (condicao) {
			case "1":
				System.out.println("Guerreiro***");
				classePersonagem = "Guerreiro";
				condicao = "0";
				break;
			case "2":
				System.out.println("Arqueiro***");
				classePersonagem = "Arqueiro";
				condicao = "0";
				break;
			case "3":
				System.out.println("Mago***");
				classePersonagem = "Mago";
				condicao = "0";
				break;
			case "4":
				System.out.println("Ladr�o***");
				classePersonagem = "Ladr�o";
				condicao = "0";
				break;
			case "5":
				System.out.println("Curandeiro***");
				classePersonagem = "Curandeiro";
				condicao = "0";
				break;

			default:
				System.out.println("Op��o inv�lida! Tente novamente.");
			}

		} while (!condicao.equals("0"));

		return classePersonagem;
	}
	
	
	
	public static void fraseIntrodutoria() throws Exception {
		String fraseInicial = " Raftel, � uma ilha no final do Novo Mundo,\n"
				+ " no qual supostamente � onde est� o tesouro One Piece.\n"
				+ " Foi nomeada pelo Gol D. Roger ap�s o seu grupo chegar na ilha e descobrir o tesouro\n"
				+ " deixado pelo grande Joyboy.\n"
				+ " Fazendo com que v�rios mundos se juntasse a busca deste tesouro em Raftal,\n"
				+ " desvendando seus enigmas at� que algu�m, consiga conquistar seu tesourou.";
		for (int i = 0; i < fraseInicial.length(); i++) {
			System.out.print(fraseInicial.charAt(i));
//			Thread.sleep(7);
		}
	}
	
}


	
	
	