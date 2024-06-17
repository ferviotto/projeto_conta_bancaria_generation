package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.cores;

public class Menu {
	public static Scanner read = new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int op = 0;
		
		//removi teste da conta model

		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Giuliano", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
			
		// Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Eloisa", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();	
				
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
				keyPress();
				break;
				
			case 2:
				System.out.println("\nListar todas as contas");
				keyPress();
				break;
				
			case 3:
				System.out.println("\nConsultar dados da conta por número");
				keyPress();
				break;
				
			case 4:
				System.out.println("\nAtualizar dados da conta");
				keyPress();
				break;
				
			case 5:
				System.out.println("\nApagar a conta");
				keyPress();
				break;
				
			case 6:
				System.out.println("\nSaque");
				keyPress();
				break;
				
			case 7:
				System.out.println("\nDepósito");
				keyPress();
				break;
				
			case 8:
				System.out.println("\nTransferência entre contas");
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
			
	