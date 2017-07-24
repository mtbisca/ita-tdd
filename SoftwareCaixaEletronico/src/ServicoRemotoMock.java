import java.util.ArrayList;

public class ServicoRemotoMock implements ServicoRemoto {
	private ArrayList<ContaCorrente> listaDeContas;
	
	
	public ServicoRemotoMock() {
		listaDeContas = new ArrayList<ContaCorrente>();
	}
	
	public void cadastraConta(String numero, double saldoInicial) {
		listaDeContas.add(new ContaCorrente(saldoInicial,numero));
	}

	@Override
	public ContaCorrente recuperaConta(String numeroDaConta) {
		for(ContaCorrente c: listaDeContas) {
			if (c.getNumero() == numeroDaConta) {
				return c;
			}
		}
		
		return null;
	}

	@Override
	public void persisteConta(ContaCorrente C) {
		// TODO Auto-generated method stub
		
	}

}
