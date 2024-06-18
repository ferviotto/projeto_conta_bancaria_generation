package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.cores;

public class Menu {
	public static Scanner read = new Scanner (System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		Scanner read = new Scanner (System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar contas\n");
		
		ContaCorrente cc1 = new ContaCorrente (contas.gerarNumero(), 123, 1, "Fernanda Viotto", 1000f, 100f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente (contas.gerarNumero(), 124, 1, "Giuliano Caron", 2000f, 100f);
		contas.cadastrar(cc2);
		ContaCorrente cp1 = new ContaCorrente (contas.gerarNumero(), 125, 2, "Larissa de Souza", 4000f, 28);
		contas.cadastrar(cp1);
		ContaCorrente cp2 = new ContaCorrente (contas.gerarNumero(), 126, 2, "Leonardo De Gobbi", 8000f, 20);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		
		
		
		//removi teste da conta model
		//removi teste da Classe Conta Corrente	
		//removi teste da Classe Conta Poupança
		
		int op = 0;
		
		while(true) {
			System.out.println(cores.TEXT_BLUE_BRIGHT);
			System.out.println("\n \tBanco da Fer");
			System.out.println("\n1 - Criar Conta");
			System.out.println("\n2 - Listar todas as contas");
			System.out.println("\n3 - Buscar conta por número");
			System.out.println("\n4 - Atualizar dados da conta");
			System.out.println("\n5 - Apagar conta");
			System.out.println("\n6 - Sacar");
			System.out.println("\n7 - Depositar");
			System.out.println("\n8 - Transferir valores entre contas");
			System.out.println("\n9 - Sair");
			
			
			try {
				System.out.println(" " + cores.TEXT_RESET);
				System.out.println("\nEntre com a opção desejada: ");
				op = read.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros.");
				read.nextLine();
				op=0;
			}

			if (op == 9) {
				System.out.println("\nObrigado. Volte sempre.");
                read.close();
				System.exit(0);
			}

			switch (op) {
			case 1:
				System.out.println("\nCriar conta");
				System.out.println("\nDigite o número da agência: ");
				agencia = read.nextInt();
				System.out.println("\nDigite o nome do titular: ");
				read.skip("\\R?");
				titular = read.nextLine();
				
				do {
					System.out.println("\nDigite o tipo da conta (1-CC ou 2-CP): ");
					tipo = read.nextInt();
				} while (tipo < 1 && tipo > 2);
				
				System.out.println("\nDigite o saldo da conta (R$): ");
				saldo = read.nextFloat();
				
				switch (tipo) {
				case 1 -> {
					System.out.println("\nDigite o limite de crédito (R$): ");
					limite = read.nextFloat();
					contas.cadastrar (new ContaCorrente (contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					
					System.out.println("\nDigite o dia do aniversário da conta: ");
					aniversario = read.
							nextInt();
					contas.cadastrar (new ContaPoupanca (contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				
				System.out.println("\nA conta "+tipo+" foi criada com sucesso.");
				keyPress();
				break;
				
			case 2:
				System.out.println("\nListar todas as contas");
				contas.listarTodas();
				keyPress();
				break;
				
			case 3:
				System.out.println("\nConsultar dados da conta por número");
				System.out.println("\nDigite o número da conta: ");
				numero = read.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
				
			case 4:
				System.out.println("\nAtualizar dados da conta");
				System.out.println("\nDigite o número da conta: ");
				numero = read.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					System.out.println("\nDigite o Numero da Agência: ");
					agencia = read.nextInt();
					System.out.println("\nDigite o Nome do Titular: ");
					read.skip("\\R?");
					titular = read.nextLine();

					System.out.println("\nDigite o Saldo da Conta (R$): ");
					saldo = read.nextFloat();

					tipo = buscaConta.getTipo();

					switch (tipo) {
						case 1 -> {
							System.out.println("\nDigite o Limite de Crédito (R$): ");
							limite = read.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("\nDigite o dia do Aniversario da Conta: ");
							aniversario = read.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("\nTipo de conta inválido.");
						}
					}

				} else
					System.out.println("\nConta não encontrada.");
				keyPress();
				break;
				
			case 5:
				System.out.println("\nApagar a conta");
				System.out.println("\nDigite o número da conta: ");
				numero = read.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
				
			case 6:
				System.out.println("\nSaque");
				
				System.out.println("\nDigite o Numero da conta: ");
				numero = read.nextInt();

				do {
					System.out.println("\nDigite o Valor do Saque (R$): ");
					valor = read.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);
				keyPress();
				break;
				
			case 7:
				System.out.println("\nDepósito");
				
				System.out.println("Digite o Numero da conta: ");
				numero = read.nextInt();

				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = read.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);
				keyPress();
				break;
				
			case 8:
				System.out.println("\nTransferência entre contas");
				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = read.nextInt();
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = read.nextInt();

				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = read.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
				
			default:
				System.out.println(cores.TEXT_RED_BOLD + "\nOpção Inválida. Por favor, digite uma opção válida." + cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}
	
	public static void keyPress() {

		try {
			System.out.println(cores.TEXT_RESET + "\nPressione enter para continuar");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter. Por favor, tente novamente.");
		}
	}
}
			
	