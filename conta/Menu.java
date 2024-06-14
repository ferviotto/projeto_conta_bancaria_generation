package conta;

import java.util.Scanner;
import conta.model.ModelConta;
import conta.util.cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Teste da Classe Conta
		ModelConta c1 = new ModelConta(1, 123, 1, "Fernanda",10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();

		Scanner read = new Scanner(System.in);

		int op;
				
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
			
		op = read.nextInt();
			
			System.out.println("\nEntre com a opção desejada: ");
			op = read.nextInt();
			
			System.out.println(" " + cores.TEXT_RESET);
			
			if (op == 9) {
				System.out.println(cores.TEXT_PURPLE_BOLD + "\nObrigado. Volte sempre.");
				read.close();
				System.exit(0);
			}
			
			switch (op) {
			
			case 1:
				System.out.println(cores.TEXT_PURPLE + "\nCriar conta");
				break;
			
			case 2:
				System.out.println(cores.TEXT_GREEN + "\nListar todas as contas");
				break;
				
			case 3:
				System.out.println(cores.TEXT_YELLOW + "\nConsultar dados da conta por número");
               			break;
               	
			case 4:
				System.out.println(cores.TEXT_BLUE + "\nAtualizar dados da conta");
				break;
				
			case 5:
				System.out.println(cores.TEXT_PURPLE_BRIGHT + "\nApagar a conta");
				break;
				
			case 6:
				System.out.println(cores.TEXT_GREEN_BOLD + "\nSaque");
              			break;
              	
			case 7:
				System.out.println(cores.TEXT_YELLOW_BOLD + "\nDepósito");
                		break;
                
			case 8:
				System.out.println(cores.TEXT_BLUE_BRIGHT + "\nTransferência entre contas");
                		break;
				default:
				System.out.println(cores.TEXT_RED_BOLD + "\nOpção Inválida. Por favor, digite uma opção válida." + cores.TEXT_RESET);
               			break;
			}
		}	
	}
}
