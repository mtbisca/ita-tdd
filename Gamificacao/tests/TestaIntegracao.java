import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestaIntegracao {
	static Placar p;
	static Armazenamento a;
	
	@BeforeClass
	public static void apagaArquivoDeDados() {
		File dataFile = new File("dados");
		dataFile.delete();
	}
	
	@BeforeClass
	public static void inicializaPlacar() {
		a = new Armazenamento();
		p = new Placar(a);
		
		p.registraPontos("Guerra", 15, "Estrela");
		p.registraPontos("Bisca", 10, "Estrela");
		p.registraPontos("Bisca", 5, "Xp");
		p.registraPontos("Ze", 20, "Xp");
	}
	
	@Test
	public void testaRecuperaPontos() {
		assertEquals(p.getAllUserPoints("Guerra"), "User:Guerra Estrela:15");
		assertEquals(p.getAllUserPoints("Bisca"), "User:Bisca Estrela:10 Xp:5");
		assertEquals(p.getAllUserPoints("Ze"), "User:Ze Xp:20");

	}
	
	@Test
	public void testaGetRanking() {
		String rankingEstrela = "15 Guerra" + '\n' + "10 Bisca" + "\n";
		String rankingXp = "20 Ze" + '\n' + "5 Bisca" + "\n";
		assertEquals(p.getPointRanking("Estrela"), rankingEstrela);
		assertEquals(p.getPointRanking("Xp"), rankingXp);
	}
	
}
