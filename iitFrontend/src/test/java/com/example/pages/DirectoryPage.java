package com.example.pages;


import com.codeborne.selenide.SelenideElement;
import com.example.components.CategoryItemDataPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DirectoryPage extends AbstractPage{
    public DirectoryPage() {
        super();
        this.url = "https://data.mos.ru/classifier";
    }

    public AbstractPage navigate() {
        return super.navigate(this.getClass());
    }

    @Override
    public AbstractPage waitPageLoaded() {
        $(".loader-block").waitWhile(visible, 30000);
        return this;
    }

    public SelenideElement getExportButton(String sub) {
        return $(byText(sub)).parent().parent().find(byId("dropDepartmentsLink"));
    }
    public SelenideElement getCategory(String category) {
        return $(byText(category));
    }
    public  SelenideElement getDocxDownloader()
    {
        return $(byText("docx"));
    }
}
