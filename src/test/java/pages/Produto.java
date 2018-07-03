package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Produto extends BasePage {
    public Produto(WebDriver navegador) {
        super(navegador);
    }

    public Produto pesquisarProdutos() {
        navegador.findElement(By.cssSelector("input[type='submit']")).click();
        return this;
    }

    public Produto aumentarQuantidade(int qtd) {
        if(qtd > 1){
            navegador.findElement(By.className("cm-increase")).click();
        }
        return this;
    }

    public String buscaPreco(){
        return navegador.findElement(By.xpath("//div[contains(@class, 'ty-product-prices')]//span[contains(@class, 'ty-price-num')]/following-sibling::span")).getText();
    }

    public Produto addCarrinho() {
        navegador.findElement(By.xpath("//button[contains(text(),'Adicionar ao carrinho')]")).click();
        return this;
    }
}
