package CadastroUsuario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeCadastro {
    WebDriver driver;

    //  Variaveis com nomes maiusculos não sofrem alterações
    String REGISTRAR = "//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]";
    String EMAIL = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[2]/input";
    String NOME = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]";
    String SENHA = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[4]/div/input";
    String CONFIRMAR_SENHA = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[5]/div/input";
    String CRIAR_SALDO =  "//*[@id='__next']/div/div[2]/div/div[2]/form/div[6]/label/span";
    String CADASTRAR = "//*[@id='__next']/div/div[2]/div/div[2]/form/button";

    public HomeCadastro(WebDriver driverParametro){
        this.driver = driverParametro;
    }
    public void regitrar(){
        driver.findElement(By.xpath(REGISTRAR)).click();
    }
     public void preencherEmail(){
        driver.findElement(By.xpath(EMAIL)).sendKeys("roberto@gmail.com");
     }
     public void preencherNome(){
        driver.findElement(By.xpath(NOME)).sendKeys("Roberto Matias");
     }
     public void preencherSenha(){
        driver.findElement(By.xpath(SENHA)).sendKeys("123456");
     }
     public void preencherConfirmarSenha(){
         driver.findElement(By.xpath(CONFIRMAR_SENHA)).sendKeys("123456");
     }
     public void clicarCriarContaComSaldo(){
         driver.findElement(By.xpath(CRIAR_SALDO)).click();
     }
    public void clicarCadastrar(){
         driver.findElement(By.xpath(CADASTRAR)).click();
    }

}
