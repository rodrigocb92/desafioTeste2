package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.Carrinho;
import pages.Home;
import suporte.Web;
import static org.junit.Assert.*;

public class CarrinhoDeCompras {
    private WebDriver navegador;
    double valTotal = 0;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionaProdutos2(){
        WebDriverWait aguardar = new WebDriverWait(navegador, 20);
        String total = new Home(navegador)
                .digitarPesquisa("Batman")
                .clicarBusca()
                .clicarProduto("Batman: Arkham City (X360)")
                .aumentarQuantidade(1)
                .addCarrinho()
                .buscaPreco();
        valTotal = valTotal + (Double.parseDouble(total)*1);
        aguardar.until(ExpectedConditions.stalenessOf(navegador.findElement(By.className("cm-auto-hide"))));
        String total2 = new Home(navegador)
                .digitarPesquisa("iPhone")
                .clicarBusca()
                .clicarProduto("Apple iPhone 4S Black")
                .aumentarQuantidade(2)
                .addCarrinho()
                .buscaPreco();
        valTotal = valTotal + (Double.parseDouble(total2)*2);
        aguardar.until(ExpectedConditions.stalenessOf(navegador.findElement(By.className("cm-auto-hide"))));
        new BasePage(navegador).abrirCarrinho();
        String valCarrinho = new Carrinho(navegador).valorTotalCarrinho();
        assertEquals(String.valueOf(valTotal), valCarrinho);
    }

    @After
    public void tearDown() {
        navegador.quit();
    }
}