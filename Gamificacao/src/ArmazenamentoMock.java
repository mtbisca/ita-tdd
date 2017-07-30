import java.util.ArrayList;

public class ArmazenamentoMock implements ArmazenamentoGenerico {
	String usuario;
	String tipoDePonto;
	int numeroDePontos;
	@Override
	public void armazenaPontos(String usuario, int numeroDePontos, String tipoDePontos) {
		this.usuario = usuario;
		this.numeroDePontos = numeroDePontos;
		this.tipoDePonto = tipoDePontos;

	}

	@Override
	public int getsPointsByType(String usuario, String tipoDePontos) {
		return numeroDePontos;

	}

	@Override
	public ArrayList<String> returnsAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> returnsAllPointTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
