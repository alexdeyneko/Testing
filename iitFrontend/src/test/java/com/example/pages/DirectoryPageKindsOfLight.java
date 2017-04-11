package com.example.pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Set;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DirectoryPageKindsOfLight extends DirectoryPage{
    public DirectoryPageKindsOfLight() {
        super();
        this.url = super.getUrl()+"/7708040885-vidy-osveshcheniya-sportivnyh-obektov";
    }
    public void registerNewTab()
    {
        Set<String> test=getWebDriver().getWindowHandles();
        switchTo().window((String) test.toArray()[test.size()-1]);
    }
    public SelenideElement getSearchForm(){

        return $(byCssSelector("#rows-caption > thead > tr.filter_tr > td > div:nth-child(2) > input[type=\"text\"]"));
    }
    public int getTableRowCount()
    {
        String temp=$(byCssSelector("#rows > div:nth-child(3) > div.pager.page-container > span > span")).getText();
        int count=Integer.parseInt(temp.split(" из")[0]);
        return count;
    }
}
