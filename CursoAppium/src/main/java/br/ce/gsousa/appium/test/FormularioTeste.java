package br.ce.gsousa.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.core.DriverFactory;
import br.ce.gsousa.appium.page.FormularioPage;
import br.ce.gsousa.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		// driver = DriverFactory.getDriver();
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Gerry");

		assertEquals("Gerry", page.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Gerry");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("PS4");
		page.salvar();

		assertEquals("Nome: Gerry", page.obterNomeCadastrato());
		assertEquals("Console: ps4", page.obterConsoleCadastrado());
		assertTrue(page.obterCheckCadastrado().endsWith("Off"));
		assertTrue(page.obterSwithCadastrado().endsWith("Marcado"));
	}

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Gerry");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		page.salvarDemorado();
		// esperar(3000);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Gerry']")));

		assertEquals("Nome: Gerry", page.obterNomeCadastrato());
	}

	@Test
	public void deveMudarData() {
		page.clicarTexto("01/01/2000");
		page.clicarTexto("20");
		page.clicarTexto("OK");

		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}

	@Test
	public void deveMudarHora() {
		page.clicarTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarTexto("OK");

		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
}
