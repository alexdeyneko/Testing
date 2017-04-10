package com.example.pages;


import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DataPageShootingRange extends DataPage{
    public DataPageShootingRange() {
        super();
        this.url = super.getUrl()+"/7708040885-strelbishcha";
    }
    public String doNotHoverMenuElement(String item) {
        String color=$(byClassName("dataset-buttons")).find(byText(item)).getCssValue("color");
        return color;
    }
    public String doHoverMenuElement(String item) {

        String color=$(byClassName("dataset-buttons")).find(byText(item)).hover().getCssValue("color");
        return color;
    }

}
