import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestaArmazenamento {
	
	@BeforeClass
	public static void apagaArquivoDeDados() {
		File dataFile = new File("dados");
		dataFile.delete();
	}
	
	@Test 
	public void testaArmazenaPontos() {
		Armazenamento a = new Armazenamento();
		a.armazenaPontos("Guerra", 15, "Coracao");
		a.armazenaPontos("Bisca", 20, "Estrela");
		a.armazenaPontos("Guerra", 5, "Xp");
		assertEquals(a.getsPointsByType("Bisca", "Estrela"), 20);
	}
	
	@Test
	public void testaRecuperaPontosDeUmTipo() {
		Armazenamento a = new Armazenamento();
		assertEquals(a.getsPointsByType("Bisca", "Estrela"), 20);
		assertEquals(a.getsPointsByType("Joana", "Estrela"), 0);
		assertEquals(a.getsPointsByType("Guerra", "Coracao"), 15);
	}

	@Test
	public void testaRetornaTodosOsUsarios() {
		Armazenamento a = new Armazenamento();
		ArrayList<String> listaEsperada = new ArrayList<String>();
		listaEsperada.add("Guerra");
		listaEsperada.add("Bisca");
		assertEquals(listaEsperada, a.returnsAllUsers());
		
	}
	
	@Test
	public void testaRetornaTodosOsTiposDePonto() {
		Armazenamento a = new Armazenamento();
		ArrayList<String> listaEsperada = new ArrayList<String>();
		listaEsperada.add("Coracao");
		listaEsperada.add("Xp");
		listaEsperada.add("Estrela");
		assertEquals(listaEsperada, a.returnsAllPointTypes());
		
	}
	
}
