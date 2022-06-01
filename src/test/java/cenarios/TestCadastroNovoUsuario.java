package cenarios;

import CadastroUsuario.HomeCadastro;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
/*
 - Os campos Nome, Email, Senha e Confirmação de senha são de prenchimento obrigatório
 - Erro: Nome não pode ser vazio
* */

public class TestCadastroNovoUsuario {
    WebDriver driver;
    HomeCadastro homeCadastro;

    @Before
    public void before (){
    driver = new ChromeDriver();
    homeCadastro = new HomeCadastro(driver);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:3000/#");
    }

    @Test
    public void testeCadastro(){
        homeCadastro.regitrar();
        homeCadastro.preencherEmail("roberto@gmail.com");
        homeCadastro.preencherNome("Roberto Matias");
        homeCadastro.preencherSenha("123456");
        homeCadastro.preencherConfirmarSenha("123456");
        homeCadastro.clicarCriarContaComSaldo();
        homeCadastro.clicarCadastrar();
        validarMensagem("foi criada com sucesso");
    }
    @Test
    public void testeCadastroVazio(){
        homeCadastro.regitrar();
        homeCadastro.preencherEmail("roberto@gmail.com");
        homeCadastro.preencherSenha("123456");
        homeCadastro.preencherConfirmarSenha("123456");
        homeCadastro.clicarCriarContaComSaldo();
        homeCadastro.clicarCadastrar();
        validarMensagem("Nome não pode ser vazio");

    }

    @After
    public void finalizar() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    public void validarMensagem(String msg){
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }

}
