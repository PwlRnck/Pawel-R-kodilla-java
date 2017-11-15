package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_DAY = "//div[@id=\"reg_form_box\"]/div[contains(string(),\"Data urodzenia\")]//select[1]";
    public static final String XPATH_MONTH = "//div[@id=\"reg_form_box\"]/div[contains(string(),\"Data urodzenia\")]//select[2]";
    public static final String XPATH_YEAR = "//div[@id=\"reg_form_box\"]/div[contains(string(),\"Data urodzenia\")]//select[3]";

    public static final int DAY = 1;
    public static final int MONTH = 1;
    public static final int YEAR = 2000;

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com/");

        //while (!webDriver.findElement(By.xpath(XPATH_WAITFOR)).isDisplayed());

        WebElement selectComboDay = webDriver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(DAY);

        WebElement selectComboMonth = webDriver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(MONTH);

        WebElement selectComboYear = webDriver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByValue(Integer.toString(YEAR));
    }
}
