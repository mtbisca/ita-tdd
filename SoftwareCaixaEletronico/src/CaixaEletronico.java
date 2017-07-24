public class CaixaEletronico {
	
	private ServicoRemoto s;
	private Hardware hardware;
	private ContaCorrente conta;
	
	public CaixaEletronico(ServicoRemoto s, Hardware h) {
		this.s = s;
		this.hardware = h;
	}


	public String login() {
		
		try {
			String numeroDaConta = hardware.pegarNumeroDaContaCartao();
			conta = s.recuperaConta(numeroDaConta);
			if(conta == null) {
				return "Nao foi possivel autenticar o usuario";
			}
			return "Usuario Autenticado";
		} catch (ProblemaDeHardwareException e) {
			return e.getMessage();
		}
	}


	public String saldo() {
		double saldo = conta.getSaldo();
		int saldoCentavos = (int) saldo % 1;
		int saldoReais = (int)((saldo - saldoCentavos));
		saldoCentavos *= 100;
		return String.format("O saldo eh R$%d,%02d", saldoReais, saldoCentavos);
	}


	public String sacar(double valor) {
		try {
			if(conta.debitoEmConta(valor)) {
				hardware.entregarDinheiro(valor);
				return "Retire seu dinheiro";
			}
			return "Saldo insuficiente";
		} catch (ProblemaDeHardwareException e) {
			conta.creditoEmConta(valor);
			return e.getMessage();
		}
	}
	
	public String depositar() {
		try {
			double valor = hardware.lerEnvelope();
			conta.creditoEmConta(valor);
			return "Deposito recebido com sucesso";
		} catch (ProblemaDeHardwareException e) {
			return e.getMessage();
		}
		
	}

}
