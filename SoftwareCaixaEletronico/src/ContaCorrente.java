
public class ContaCorrente {
	private String numero;
	private double saldo;
	
	
	
	public ContaCorrente(double saldoInicial, String numero) {
		this.saldo = saldoInicial;
		this.numero = numero;
	}


	public boolean debitoEmConta(double valor) {
		if(valor > saldo) {
			return false;
		}
		
		saldo -= valor;
		return true;
	}
	
	public void creditoEmConta(double valor) {
		this.saldo += valor;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getNumero() {
		return numero;
	}

}
