import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestaCaixaEletronico {
	ServicoRemotoMock s;
	HardwareMock hardware;
	CaixaEletronico caixa;
	
	@Before
	public void inicializaClasses() {
		s = new ServicoRemotoMock();
		hardware = new HardwareMock();
		caixa = new CaixaEletronico(s, hardware);
		s.cadastraConta("1", 10.00);

	}
	
	@Test
	public void testaLoginComSucesso() {
		hardware.setNumeroDaConta("1");
		assertEquals("Usuario Autenticado", caixa.login());
	}
	
	@Test
	public void testaLoginSemSucesso() {
		hardware.setNumeroDaConta("2");
		assertEquals("Nao foi possivel autenticar o usuario", caixa.login());
	}
	
	@Test
	public void testaLoginComDuasContasCadastradas() {
		hardware.setNumeroDaConta("2");
		s.cadastraConta("2", 15.00);
		assertEquals("Usuario Autenticado", caixa.login());
	}
	
	@Test
	public void testaSaldoComSucesso() {
		hardware.setNumeroDaConta("1");
		caixa.login();
		assertEquals("O saldo eh R$10,00", caixa.saldo());
	}
	
	@Test
	public void testaSaldoDuasContasCadastradas() {
		hardware.setNumeroDaConta("2");
		s.cadastraConta("2", 15.00);
		caixa.login();
		assertEquals("O saldo eh R$15,00", caixa.saldo());
	}
	
	@Test
	public void testaSaqueComSucesso() {
		hardware.setNumeroDaConta("2");
		s.cadastraConta("2", 15.00);
		caixa.login();
		assertEquals("Retire seu dinheiro", caixa.sacar(5.0));
	}
	
	@Test
	public void testaSaldoAposSaque() {
		hardware.setNumeroDaConta("1");
		caixa.login();
		caixa.sacar(5.0);
		assertEquals("O saldo eh R$5,00", caixa.saldo());
	}
	
	@Test
	public void testaSaqueSemSucesso() {
		hardware.setNumeroDaConta("2");
		s.cadastraConta("2", 15.00);
		caixa.login();
		assertEquals("Saldo insuficiente", caixa.sacar(25.0));
	}
	
	
	@Test
	public void testaDepositoComSucesso() {
		hardware.setNumeroDaConta("1");
		hardware.setValorLidoEnvelope(20.00);
		caixa.login();
		caixa.depositar();
		assertEquals("O saldo eh R$30,00", caixa.saldo());
	}
	
	@Test
	public void testaExcecaoDeHardwareLogin() {
		hardware.lancarExcecaoAoExecutarMetodos();
		assertEquals("Houve um problema ao pegar o numero da conta", caixa.login());
	}
	
	@Test
	public void testaExcecaoDeHardwareSacar() {
		hardware.setNumeroDaConta("1");
		caixa.login();
		hardware.lancarExcecaoAoExecutarMetodos();
		assertEquals("Houve um problema ao entregar o dinheiro, tente novamente", caixa.sacar(10.00));
		assertEquals("O saldo eh R$10,00", caixa.saldo());
	}
	
	@Test
	public void testaExcecaoDeHardwareDepositar() {
		hardware.setNumeroDaConta("1");
		hardware.setValorLidoEnvelope(10.00);
		caixa.login();
		hardware.lancarExcecaoAoExecutarMetodos();
		assertEquals("Houve um problema ao ler o envelope, tente novamente", caixa.depositar());
		assertEquals("O saldo eh R$10,00", caixa.saldo());

	}
}
