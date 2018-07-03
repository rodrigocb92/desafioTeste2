package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public Carrinho abrirCarrinho() {
        JavascriptExecutor jse = (JavascriptExecutor)navegador;
        jse.executeScript("scroll(0, -250);");
        navegador.findElement(By.className("top-cart-content")).click();
        navegador.findElement(By.linkText("VER CARRINHO")).click();
        return new Carrinho(navegador);
    }
}
