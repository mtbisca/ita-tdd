import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TesteConversorCamelCase {
	
	private List<String> listaEsperada;
	private ConversorCamelCase c;
	private List<String> listaRecebida;
	
	@Before
	public void inicializador() {
		c = new ConversorCamelCase();
		listaEsperada = new ArrayList<String>();
	}

	@Test
	public void testaStringVazia() {
		listaRecebida = c.converterCamelCase("");
		listaEsperada.add("");
		assertEquals(listaRecebida, listaEsperada);
	}

	@Test
	public void testaStringMinuscula() {
		listaRecebida = c.converterCamelCase("nome");
		listaEsperada.add("nome");
		assertEquals(listaRecebida, listaEsperada);
	}
	
	@Test
	public void testaUnicaPalavra() {
		listaRecebida = c.converterCamelCase("Nome");
		listaEsperada.add("nome");
		assertEquals(listaRecebida, listaEsperada);
	}
}
