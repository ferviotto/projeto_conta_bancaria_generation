package conta.model;

public class ContaCorrente extends ModelConta{
	//atributo 'limite' cujo modificador de acesso demonstra que só é possível acessar nessa classe.
	private float limite;
	
	//constructor
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	//get and set do limite

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	//métodos específicos sobreescrito
	@Override
	public boolean sacar(float valor) { 
		
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
		
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\nLimite de Crédito: " + this.limite);
	}
    
}
