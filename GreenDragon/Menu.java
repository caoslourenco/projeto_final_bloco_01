package GreenDragon;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import GreenDragon.Model.Cadastro;
import GreenDragon.Model.Domestico;
import GreenDragon.Model.Silvestre;
import GreenDragon.Controller.CadastroController;
import GreenDragon.Utils.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		CadastroController cadastro = new CadastroController();

		int numero = 0, opcao = 0;
		String nomePet, nomeTutor, telefone, tutor;

		
		

		while (true) {

			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND_BRIGHT
					+ "****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                            GreenDragon Pet                                 ");
			System.out.println("                                                                            ");
			System.out.println("****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                        1 - Criar cadatro de Pet                            ");
			System.out.println("                        2 - Listar todos os cadastros                       ");
			System.out.println("                        3 - Buscar Cadastro por Pet                         ");
			System.out.println("                        4 - Atualizar dados do cadastro do Pet              ");
			System.out.println("                        5 - Apagar conta                                    ");
			System.out.println("                        6 - Consulta por Titular                            ");
			System.out.println("                        0 - Sair                                            ");
			System.out.println("                                                                            ");
			System.out.println("****************************************************************************");
			System.out.println("Entre com a opção desejada:                                                  ");
			System.out.println(
					"                                                                            " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;

			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "GreenDragon Pet!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println("Digite o nome do Tutor: ");
				leia.nextLine();
				nomeTutor = leia.nextLine();

				System.out.println("Digite o número de telefone do tutor: ");
				telefone = leia.next();

				System.out.println("Digite o nome do Pet: ");
				nomePet = leia.next();

				System.out.println("Digite o tipo de Pet (1 - Doméstico ou 2 - Silvestre): ");
				int tipo = leia.nextInt();

				leia.nextLine();

				switch (tipo) {
				case 1:
					cadastro.cadastrar(new Domestico(cadastro.gerarNumero(), nomeTutor, telefone, nomePet, tipo));
					break;
				case 2:
					cadastro.cadastrar(new Silvestre(cadastro.gerarNumero(), nomeTutor, telefone, nomePet, tipo));
					break;
				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Cadastros\n\n");
				cadastro.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados do Cadastro - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				cadastro.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados do cadastro do Pet\n\n");

				System.out.println("Digite o número do cadastro: ");
				numero = leia.nextInt();

				Optional<Cadastro> numeroCadastro = cadastro.buscarNaCollection(numero);

				if (numeroCadastro.isPresent()) {

					System.out.println("Digite o nome do Tutor: ");
					leia.nextLine(); 
					nomeTutor = leia.nextLine(); 

					System.out.println("Digite o número de telefone do tutor: ");
					telefone = leia.next();

					System.out.println("Digite o nome do Pet: ");
					nomePet = leia.next();

					System.out.println("Digite o tipo de Pet (1 - Doméstico ou 2 - Silvestre): ");
					tipo = leia.nextInt();

					switch (tipo) {
					case 1 -> {

						cadastro.atualizar(new Domestico(numero, nomeTutor, telefone, nomePet, tipo));
					}
					case 2 -> {
						cadastro.atualizar(new Silvestre(numero, nomeTutor, telefone, nomePet, tipo));
					}
					}
				}

				else {
					System.out.println("O cadastro número: " + numero + " não foi encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar cadastro \n\n");

				System.out.println("Digite o número do Cadastro: ");
				numero = leia.nextInt();

				cadastro.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Consulta por Titular \n\n");

				System.out.println("Digite o nome do Tutor do pet: ");
				leia.skip("\\R");
				tutor = leia.nextLine();

				cadastro.procurarPorTutor(tutor);

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;

			}
		}

	}

	// public static void sobre() {
	// 	System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND_BRIGHT
	// 			+ "****************************************************************************");
	// 	System.out.println("Projeto desenvolvido por: 🦦                                       ");
	// 	System.out.println("Projeto Generation Brasil - generation@generation.org              ");
	// 	System.out.println("https://github.com/caoslourenco/projeto_final_bloco_01             ");
	// 	System.out.println(
	// 			"****************************************************************************" + Cores.TEXT_RESET);
	// }

	public static void keyPress() {
		try {

			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND_BRIGHT
					+ "\n\nPressione a tecla Enter para continuar..." + Cores.TEXT_RESET);
			System.in.read();

		} catch (IOException e) {

			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND_BRIGHT
					+ "Você pressionou uma tecla inválida!" + Cores.TEXT_RESET);

		}
	}

}
