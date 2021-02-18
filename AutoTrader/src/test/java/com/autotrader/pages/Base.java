package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Base {

public static void clearCookies() {
    MyDriver.get().manage().deleteAllCookies();
}

public void scrollDown (WebElement link) {
try {
    Thread.sleep(2000);
}catch (Exception e){

}


    JavascriptExecutor jse =(JavascriptExecutor) MyDriver.get();
     jse.executeScript("argument[0].scrollIntoView(true)",link);

    }

}


