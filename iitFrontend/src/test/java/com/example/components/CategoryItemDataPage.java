package com.example.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoryItemDataPage extends ElementsContainer {
    public SelenideElement getIcon() {
        return getSelf().find(".category-icon");
    }

    public SelenideElement getTextElement() {
        return getSelf().$(".category-caption");
    }

    public String getCategoryMenuBackgroundColor(String str){
        return getSelf().find(byText(str)).hover().getCssValue("background");
    }
    public SelenideElement getCountElement() {
        return getSelf().find(".count");
    }
    public SelenideElement getExportButton(String sub) {
        return getSelf().$(byText(sub)).parent().parent().find(byId("dropDepartmentsLink"));
    }
    public SelenideElement getCategory(String category) {
        return getSelf().$(byText(category));
    }




}
