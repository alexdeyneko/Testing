package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.galenframework.page.selenium.ScreenElement;
import org.openqa.selenium.By;

import java.util.Set;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DataPageAutodromes extends DataPage{
    public DataPageAutodromes() {
        super();
        this.url = super.getUrl()+"/7708040885-avtodromy-sportivnye-krytye";
    }
    public SelenideElement getMenuElementButton__Map()
    {
        return $(byCssSelector("#app > div:nth-child(3) > ul > li.hide-lt-500-important > a"));
    }
    public String getMapDisplayStyle()
    {
        String display=$(By.id("map")).getCssValue("display");
        return  display;


    }
    public void registerNewTab()
    {
        Set<String> test=getWebDriver().getWindowHandles();
        switchTo().window((String) test.toArray()[test.size()-1]);
    }

}
