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
		assertEquals(listaEsperada, listaRecebida);
	}

	@Test
	public void testaStringMinuscula() {
		listaRecebida = c.converterCamelCase("nome");
		listaEsperada.add("nome");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test
	public void testaUnicaPalavra() {
		listaRecebida = c.converterCamelCase("Nome");
		listaEsperada.add("nome");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test
	public void testaPalavraComposta() {
		listaRecebida = c.converterCamelCase("nomeComposto");
		listaEsperada.add("nome");
		listaEsperada.add("composto");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test
	public void testaPalavraCompostaMaiuscula() {
		listaRecebida = c.converterCamelCase("NomeComposto");
		listaEsperada.add("nome");
		listaEsperada.add("composto");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test
	public void testaPalavraInteiraMaiuscula() {
		listaRecebida = c.converterCamelCase("CPF");
		listaEsperada.add("CPF");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test
	public void testaPalavraInteiraMaisuculaComposta() {
		listaRecebida = c.converterCamelCase("numeroCPF");
		listaEsperada.add("numero");
		listaEsperada.add("CPF");
		assertEquals(listaEsperada, listaRecebida);
	}

	@Test
	public void testaPalavraInteiraMaiusculaEntrePalavras() {
		listaRecebida = c.converterCamelCase("numeroCPFContribuinte");
		listaEsperada.add("numero");
		listaEsperada.add("CPF");
		listaEsperada.add("contribuinte");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test
	public void testaNumeroEntrePalavras() {
		listaRecebida = c.converterCamelCase("recupera10Primeiros");
		listaEsperada.add("recupera");
		listaEsperada.add("10");
		listaEsperada.add("primeiros");
		assertEquals(listaEsperada, listaRecebida);
	}
	
	@Test(expected=CamelCaseInvalidoException.class)
	public void testaPalavraComecandoPorNumero() {
		listaRecebida = c.converterCamelCase("10Primeiros");
	}
	
	@Test(expected=CamelCaseInvalidoException.class)
	public void testaPalavraComCaracterEspecial() {
		listaRecebida = c.converterCamelCase("nome#Composto");
	}
}
