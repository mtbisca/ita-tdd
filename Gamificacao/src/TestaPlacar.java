import static org.junit.Assert.*;

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
	public void testaRegistroMaisDeUmTipoDePontos() {
		ArmazenamentoGenerico arm = new ArmazenamentoMock();
		Placar p = new Placar(arm);
		p.registraPontos("Guerra", 10, "Estrela");
		p.registraPontos("Sonic", 15, "Estrela");
		assertEquals(arm.getsPointsByType("Guerra", "Estrela"), 10);
		assertEquals(arm.getsPointsByType("Sonic", "Estrela"), 15);

	}
}
