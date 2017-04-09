
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.xpath.operations.Equals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.title;

public class Tests {
    /*
    Названия методов- это номера тест-кейсов
     */
    public Tests()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Doesn't matter chrome or Chrome as this is case insensitive.
        System.setProperty("selenide.browser", "Chrome");
    }
    public static String category="Физическая культура и спорт";
    @Test
    public void DMru_44()
    {
        List<String> menu = new ArrayList<String>();
        menu.add("Паспорт");
        menu.add("Описание");
        menu.add("Справочники");

        open("https://data.mos.ru/opendata/7708040885-strelbishcha");
        boolean result=true;
        for(String item:menu)
       {
           String str=$(byText(item)).getCssValue("color");
           String[]before=Parser.parseRGBAStringToInt(str);

           String newStr=$(byText(item)).hover().getCssValue("color");
           String[]after=Parser.parseRGBAStringToInt(newStr);


           for (int j=0;j<before.length-1;j++)
           {
               if(Integer.parseInt(before[j])<=Integer.parseInt(after[j]))
               {
                   result=false;
               }
           }
       }
        ////////////////////
        Assert.assertTrue(result);
    }
    @Test
    public void DMru_41()
    {
        List<String> names = new ArrayList<String>();
        names.add(this.category);
        names.add("Связь");
        names.add("Культура");
        open("https://data.mos.ru/opendata");
        boolean result=true;
        for(String item:names)
        {
            String afterHover=$(byText(item)).parent().hover().getCssValue("background");
            String[]after=Parser.parseRGBAStringToInt(afterHover);
            String[] testArray;
            testArray=new String[]{"153","205","222"};
            for (int i=0;i<testArray.length;i++)
            {
                if(Integer.parseInt(testArray[i])!=Integer.parseInt(after[i]))
                    result=false;
            }

        }
        Assert.assertTrue(result);
    }
    @Test
    public void DMru_37()
    {
        open("https://data.mos.ru/classifier");
        $(byText(this.category)).click();
        SelenideElement parent=$(byText("Виды спорта и услуг")).parent().parent();

        parent.find(byId("dropDepartmentsLink")).click();
        $(byText("docx")).click();
    }

    //вне зачета
    public void eng_rus()
    {
        open("https://data.mos.ru/");
        //$(byXpath("//*[@id=\"generalMenu\"]/ul[1]/li[1]/a")).click();
        $(byCssSelector("#generalMenu .inactivevisible > a")).click();
        sleep(10000);
    }
    @Test
    public void DMru_40()
    {
        open("https://data.mos.ru/opendata?categoryId=15&IsActual=true");
        $(byText("Автодромы спортивные крытые")).click();
        Set<String> test=getWebDriver().getWindowHandles();

        switchTo().window((String) test.toArray()[test.size()-1]);
        $(byCssSelector("#app > div:nth-child(3) > ul > li.hide-lt-500-important > a")).click();
    }

    @Test
    public void DMru_45()
    {

        open("https://data.mos.ru/classifier?categoryId=15&IsOld=true");
        String driver=getWebDriver().getWindowHandle();
        switchTo().window(driver);

        $(byText("Виды освещения спортивных объектов")).click();
        Set<String> test=getWebDriver().getWindowHandles();
        switchTo().window((String) test.toArray()[test.size()-1]);

        $(byCssSelector("#rows-caption > thead > tr.filter_tr > td > div:nth-child(2) > input[type=\"text\"]")).sendKeys("без дополнительного освещения");

    }


}
