package cenarios;

import CadastroUsuario.HomeCadastro;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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
    public void cadastro(){
        homeCadastro.regitrar();
        homeCadastro.preencherEmail();
        homeCadastro.preencherNome();
        homeCadastro.preencherSenha();
        homeCadastro.preencherConfirmarSenha();
        homeCadastro.clicarCriarContaComSaldo();
        homeCadastro.clicarCadastrar();
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));
    }

    @After
    public void finalizar() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
