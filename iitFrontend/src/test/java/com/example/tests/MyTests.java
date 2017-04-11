package com.example.tests;
import com.codeborne.selenide.SelenideElement;
import com.example.BaseTest;
import com.example.components.CategoryItemDataPage;
import com.example.pages.*;
import com.example.services.ColorService;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.FileAssert.fail;

public class MyTests extends BaseTest {
    private static final String CATEGORY_NAME = "Физическая культура и спорт";
    @Test
    public void changeMenuElementsColor()
    {
    DataPageShootingRange page = page(DataPageShootingRange.class);
    page.navigate();
        List<String> menu = new ArrayList<String>();
    menu.add("Паспорт");
    menu.add("Описание");
    menu.add("Справочники");

    for (String item:menu)
    {
        String tempStr = page.doNotHoverMenuElement(item);

        String[] before = ColorService.parseRGBAStringToInt(tempStr);
        String tempStr2=page.doHoverMenuElement(item);
        String[] after = ColorService.parseRGBAStringToInt(tempStr2);

        Assert.assertTrue(ColorService.isDarker(after, before));
    }

  }

    @Test
    public void changeCategoryMenuElementsBackground()
    {
        DataPage page = page(DataPage.class);
        page.navigate();
        page.shouldBeOpened();
        List<String> list = new ArrayList<String>();
        list.add(CATEGORY_NAME);
        list.add("Связь");
        list.add("Культура");
        for(String item :list) {
            String rgba = page.getCategoryMenuBackgroundColor(item);
            String[] after = ColorService.parseRGBAStringToInt(rgba);
            String[] testArray;
            testArray = new String[]{"153", "205", "222"};
            Assert.assertTrue(ColorService.isEqualColor(after, testArray));
        }
    }
    @Test
    public void exportDirectory() throws Exception {
        String subCategory="Виды спорта и услуг";
        DirectoryPage page = page(DirectoryPage.class);
        page.navigate();
        page.shouldBeOpened();
        page.getCategory(CATEGORY_NAME).click();
        page.getExportButton(subCategory).click();
        try {
            page.getDocxDownloader().download();
        } catch (FileNotFoundException e) {

            Assert.fail(e.getMessage());
        }

    }
    @Test void openMapInDataPageAutodromes()
    {

        String subCategory="Автодромы спортивные крытые";
        DataPage page=page(DataPage.class);
        page.navigate();
        page.shouldBeOpened();
        page.getCategory(CATEGORY_NAME).click();
        page.getCategory(subCategory).click();

        DataPageAutodromes newPage=new DataPageAutodromes();
        newPage.registerNewTab();
        newPage.waitPageLoaded();
        newPage.getMenuElementButton__Map().click();
        Assert.assertEquals("block",newPage.getMapDisplayStyle());
    }
    @Test void searchingInTableDirectory()
    {
        int expectedRowCount=1;
        String subCategory="Виды освещения спортивных объектов";
        String searchString="без дополнительного освещения";
        DirectoryPage page=new DirectoryPage();
        page.navigate();
        page.getCategory(CATEGORY_NAME).click();
        page.getCategory(subCategory).click();
        DirectoryPageKindsOfLight newPage=new DirectoryPageKindsOfLight();
        newPage.registerNewTab();
        newPage.getSearchForm().sendKeys(searchString);
        sleep(1000);
        Assert.assertEquals(newPage.getTableRowCount(),expectedRowCount);
    }
//
}
