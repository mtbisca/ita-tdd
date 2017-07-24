
public interface ServicoRemoto {
	
	public ContaCorrente recuperaConta(String numeroDaConta);
	
	public void persisteConta(ContaCorrente C);
}
