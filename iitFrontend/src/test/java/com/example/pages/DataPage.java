package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.components.CategoryItemDataPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DataPage extends AbstractPage {
    public DataPage() {
        super();
        this.url = "https://data.mos.ru/opendata";
    }

    public AbstractPage navigate() {
        return super.navigate(this.getClass());
    }
    public SelenideElement getCategory(String category) {
        return $(byText(category));
    }

    @Override
    public AbstractPage waitPageLoaded() {
        $(".loader-block").waitWhile(visible, 30000);
        return this;
    }

    public CategoryItemDataPage getSelectedItem() {
        CategoryItemDataPage category = new CategoryItemDataPage();
        category.setSelf($(".items-list .selected"));
        return category;
    }
    public String getCategoryMenuBackgroundColor(String str){
        return $(byText(str)).parent().hover().getCssValue("background");
    }






}
