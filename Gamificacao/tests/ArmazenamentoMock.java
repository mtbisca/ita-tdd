import java.util.ArrayList;

public class ArmazenamentoMock implements ArmazenamentoGenerico {
	String usuario;
	String tipoDePonto;
	int numeroDePontos;
	ArrayList<String> allPointTypes;
	ArrayList<String> allUsers;
	
	@Override
	public void armazenaPontos(String usuario, int numeroDePontos, String tipoDePontos) {
		this.usuario = usuario;
		this.numeroDePontos = numeroDePontos;
		this.tipoDePonto = tipoDePontos;

	}

	@Override
	public int getsPointsByType(String usuario, String tipoDePontos) {
		if(tipoDePontos == "Estrela") {
			if(usuario.equals("Guerra"))
				return 10;
			else if(usuario.equals("Bisca"))
				return 20;
			else if(usuario.equals("Alberto"))
				return 8;
		} else if (tipoDePontos == "Xp") {
			if(usuario.equals("Guerra") || usuario.equals("Ze"))
				return 15;
		}
		return 0;

	}

	@Override
	public ArrayList<String> returnsAllUsers() {
		// TODO Auto-generated method stub
		return allUsers;
	}

	@Override
	public ArrayList<String> returnsAllPointTypes() {
		// TODO Auto-generated method stub
		return allPointTypes;
	}

	public void setAllPointTypes(ArrayList<String> allPointTypes) {
		this.allPointTypes = allPointTypes;
	}

	public void setAllUsers(ArrayList<String> allUsers) {
		this.allUsers = allUsers;
	}

}
