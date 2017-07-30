import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestaPlacar {

	@Test
	public void testaRegistroPontos() {
		ArmazenamentoGenerico arm = new ArmazenamentoMock();
		Placar p = new Placar(arm);
		p.registraPontos("Guerra", 10, "Estrela");
		assertEquals(arm.getsPointsByType("Guerra", "Estrela"), 10);
	}
	
	@Test
	public void testGetAllUserPoints() {
		ArmazenamentoMock a = new ArmazenamentoMock();
		ArrayList<String> allPointTypes = new ArrayList<String>();
		allPointTypes.add("Estrela");
		allPointTypes.add("Xp");
		allPointTypes.add("Dinheiro");
		a.setAllPointTypes(allPointTypes);
		
		Placar p = new Placar(a);
		p.registraPontos("Guerra", 10, "Estrela");
		p.registraPontos("Guerra", 15, "Xp");
		p.registraPontos("Bisca", 25, "Dinheiro");
		String respostaEsperada = "User:Guerra Estrela:10 Xp:15";
		assertEquals(respostaEsperada, p.getAllUserPoints("Guerra"));
	}
	
	@Test
	public void testGetPointRanking() {
		ArmazenamentoMock a = new ArmazenamentoMock();
		ArrayList<String> allUsers = new ArrayList<String>();
		allUsers.add("Bisca");
		allUsers.add("Guerra");
		allUsers.add("Alberto");
		allUsers.add("Ze");
		a.setAllUsers(allUsers);
		
		Placar p = new Placar(a);
		p.registraPontos("Guerra", 10, "Estrela");
		p.registraPontos("Bisca", 20, "Estrela");
		p.registraPontos("Alberto", 8, "Estrela");
		p.registraPontos("Ze", 15, "Xp");
		
		String rankingEstrela = "20 Bisca" + "\n" + "10 Guerra" + "\n" + "8 Alberto" + "\n";
		
		assertEquals(rankingEstrela, p.getPointRanking("Estrela"));
		
	}
	
	
}
