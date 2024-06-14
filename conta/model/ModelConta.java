package conta.model;

import java.util.Scanner;

public class ModelConta {

    // Declaração de atributos da classe
    private int conta;
    private String tipoConta;
    private int contaAp;
    private int numeroConta;
    private int agencia;
    private int agenciaAp;
    private float depositar;
    private float sacar;
    private float transferir;
    private float saldo;
    private float saldoDestino;
    private String titular;
    private String titularAp;

    // Criação do construtor
    public ModelConta(int conta, int agencia, String titular) {
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
        
    }

    // Criação de getters e setters
    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
    public String gettipoConta() {
        return tipoConta;
    }

    public void tipoConta(int conta) {
        this.tipoConta = tipoConta;
    }
    public int getContaAp() {
        return contaAp;
    }

    public void setContaAp(int contaAp) {
        this.contaAp = contaAp;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getAgenciaAp() {
        return agenciaAp;
    }

    public void setAgenciaAp(int agenciaAp) {
        this.agenciaAp = agenciaAp;
    }

    public float getDepositar() {
        return depositar;
    }

    public void setDepositar(float depositar) {
        this.depositar = depositar;
    }

    public float getSacar() {
        return sacar;
    }

    public void setSacar(float sacar) {
        this.sacar = sacar;
    }

    public float getTransferir() {
        return transferir;
    }

    public void setTransferir(float transferir) {
        this.transferir = transferir;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldoDestino() {
        return saldoDestino;
    }

    public void setSaldoDestino(float saldoDestino) {
        this.saldoDestino = saldoDestino;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitularAp() {
        return titularAp;
    }

    public void setTitularAp(String titularAp) {
        this.titularAp = titularAp;
    }

    // Scanner para leitura de dados
    Scanner read = new Scanner(System.in);

    // Criação de demais métodos
    public void criarConta() {
    	System.out.println("\nQual tipo de conta deseja criar (Corrente ou Poupança)? ");
    	tipoConta = read.nextLine();
    	if (tipoConta.equalsIgnoreCase("corrente")) {
    		System.out.println("Para criar sua conta corrente, coloque os dados a seguir.");
    		System.out.println("\nQual é o seu nome? ");
    	        titular = read.nextLine();
    	        System.out.println("\nDigite a agência: ");
    	        agencia = read.nextInt();
    	        System.out.println("\nDigite o número da conta: ");
    	        conta = read.nextInt();
    	        saldo = 0;
    	        System.out.println("\nConta criada com sucesso. Saldo inicial: " + saldo);
    	} else if (tipoConta.equalsIgnoreCase("poupança")) {
    		System.out.println("Para criar sua conta corrente, coloque os dados a seguir.");
    		System.out.println("\nQual é o seu nome? ");
            titular = read.nextLine();
            System.out.println("\nDigite a agência: ");
            agencia = read.nextInt();
            System.out.println("\nDigite o número da conta: ");
            conta = read.nextInt();
            saldo = 0;
            System.out.println("\nConta criada com sucesso. Saldo inicial: " + saldo);
    	} else {
    		System.out.println("\nOpção inválida. Por favor, tente novamente. ");
    	}  
    }

    public void listarConta() {
        System.out.println("\nTitular: " + titular);
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + conta);
        System.out.println("Saldo: " + saldo);
    }

    public void buscarConta() {
        System.out.println("\nDigite o número da sua conta: ");
        int numeroConta = read.nextInt();
        
        // Para buscar conta
        if (this.conta == numeroConta) {
            System.out.println("\nConta encontrada: " + conta);
        } else {
            System.out.println("\nConta não encontrada.");
        }
    }

    public void atualizarConta() {
        System.out.println("\nAtualize seus dados");
        System.out.println("\nNome: ");
        titular = read.nextLine();
        System.out.println("\nAgência: ");
        agencia = read.nextInt();
        System.out.println("\nConta: ");
        conta = read.nextInt();
    }

    public void apagarConta() {
        System.out.println("\nDigite o nome do titular: ");
        titularAp = read.nextLine();
        System.out.println("\nDigite a agência: ");
        agenciaAp = read.nextInt();
        System.out.println("\nDigite o número da conta: ");
        contaAp = read.nextInt();

        // Exclusão de conta
        if (titularAp.equals(titular) && agenciaAp == agencia && contaAp == conta) {
            System.out.println("\nConta apagada.");
            titular = null;
            agencia = 0;
            conta = 0;
            saldo = 0;
        } else {
            System.out.println("\nConta não encontrada.");
        }
    }

    public void sacar() {
        System.out.println("\nDigite quanto deseja sacar: ");
        sacar = read.nextFloat();

        //Saque
        if (sacar <= saldo) {
            saldo -= sacar;
            System.out.println("\nSaque de R$ " + sacar + " realizado com sucesso.\nSaldo atual: R$ " + saldo);
        } else {
            System.out.println("\nSaldo insuficiente. Por favor, tente novamente.\nSaldo atual: R$ " + saldo);
        }
    }

    public void depositar() {
        System.out.println("\nDigite quanto deseja depositar: ");
        depositar = read.nextFloat();
        saldo += depositar;
        System.out.println("Depósito de R$ " + depositar + " realizado com sucesso. Saldo atual: R$ " + saldo);
    }

    public void transferir(ModelConta contaDestino) {
        System.out.println("\nDigite quanto deseja transferir: ");
        transferir = read.nextFloat();
        
        //Transferir
        if (transferir <= saldo) {
            saldo -= transferir;
            contaDestino.setSaldo(contaDestino.getSaldo() + transferir);
            System.out.println("\nTransferência de R$ " + transferir + " realizada com sucesso.\nSaldo atual: R$ " + saldo);
        } else {
            System.out.println("\nSaldo insuficiente. Por favor, tente novamente.\nSaldo atual: R$ " + saldo);
        }
    }
}