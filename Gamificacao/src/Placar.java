
public class Placar {
	ArmazenamentoGenerico arm;
	
	public Placar(ArmazenamentoGenerico arm) {
		this.arm = arm;
	}
	
	public void registraPontos(String usuario, int numeroDePontos, String tipoDePonto) {
		arm.armazenaPontos(usuario, numeroDePontos, tipoDePonto);
	}

}	
