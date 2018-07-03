package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Carrinho extends BasePage{

    public Carrinho(WebDriver navegador) {
        super(navegador);
    }

    public String valorTotalCarrinho() {
        return navegador.findElement(By.id("sec_cart_total")).getText().replace(",", "");
    }
}
