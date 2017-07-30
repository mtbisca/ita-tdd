import java.util.ArrayList;

public interface ArmazenamentoGenerico {
	
	public void armazenaPontos(String usuario, int numeroDePontos, String tipoDePontos);
	
	public int getsPointsByType(String usuario, String tipoDePontos);
	
	public ArrayList<String> returnsAllUsers();
	
	public ArrayList<String> returnsAllPointTypes();
}
