package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends BasePage {
    public Home(WebDriver navegador) {
        super(navegador);
    }

    public Home digitarPesquisa(String pesquisa) {
        navegador.findElement(By.id("search_input")).sendKeys(pesquisa);
        return this;
    }

    public ListaDeProdutos clicarBusca() {
        navegador.findElement(By.name("search_form")).findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutos(navegador);
    }
}
