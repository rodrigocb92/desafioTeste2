package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutos extends BasePage {
    public ListaDeProdutos(WebDriver navegador) {
        super(navegador);
    }

    public Produto clicarProduto(String produto) {
        navegador.findElement(By.linkText(produto)).click();
        return new Produto(navegador);
    }
}
