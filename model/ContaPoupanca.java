package conta.model;

public class ContaPoupanca extends ModelConta{
	//atributo 'aniversario' cujo modificador de acesso demonstra que só é possível acessar nessa classe.
	private int aniversario;

	//constructor
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	//get and set do aniversario
	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	//método específico sobreescrito
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\nAniversário da conta: " + this.aniversario);
	}
    
}
