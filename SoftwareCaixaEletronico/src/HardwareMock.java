
public class HardwareMock implements Hardware {
	private String numeroDaConta;
	private double valor;
	private boolean lancarExcecao;
	
	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}
	
	@Override
	public String pegarNumeroDaContaCartao() {
		if(lancarExcecao) {
			throw new ProblemaDeHardwareException("Houve um problema ao pegar o numero da conta");
		}
		return numeroDaConta;
	}

	@Override
	public void entregarDinheiro(double valor) {
		if(lancarExcecao) {
			throw new ProblemaDeHardwareException("Houve um problema ao entregar o dinheiro, tente novamente");
		}
		System.out.println("Retire " + valor + " reais");

	}

	
	public void setValorLidoEnvelope(double valor) {
		this.valor = valor;
	}
	
	@Override
	public double lerEnvelope() {
		if(lancarExcecao) {
			throw new ProblemaDeHardwareException("Houve um problema ao ler o envelope, tente novamente");
		}
		return this.valor;

	}

	public void lancarExcecaoAoExecutarMetodos() {
		this.lancarExcecao = true;
		
	}

}
