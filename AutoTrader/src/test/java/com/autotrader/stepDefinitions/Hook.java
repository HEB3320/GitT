package com.autotrader.stepDefinitions;

import com.autotrader.utilities.ConfigurationReader;
import com.autotrader.utilities.MyDriver;
import com.github.bogdanlivadariu.gifwebdriver.GifScreenshotWorker;
import com.github.bogdanlivadariu.gifwebdriver.GifWebDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hook {
    private static Logger logger = Logger.getLogger(Hook.class);

        @Before
        public void setup() {
            System.out.println("#### setup! start d######\n");
            MyDriver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            MyDriver.get().manage().window().maximize();
            MyDriver.get().get(ConfigurationReader.getProperty("url"));
        }


        @After
        public void teardown(Scenario scenario) throws IOException {
            //if test failed - do this
            //if test failed - do this
            if (scenario.isFailed()) {
                logger.error("Test failed!");
                byte[] screenshot = ((TakesScreenshot) MyDriver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/gif");
            }
/*
            if (scenario.isFailed()) {
                WebDriver driver = new GifWebDriver(new ChromeDriver());
                GifWebDriver gifDriver = (GifWebDriver) driver;
                gifDriver.getGifScreenshotWorker().takeScreenshot();
                GifScreenshotWorker gifWorker = gifDriver.getGifScreenshotWorker();
                gifWorker.setTimeBetweenFramesInMilliseconds(2000);
                gifWorker.setRootDir("some place where files screenshots and gifs will be placed");
                gifWorker.setLoopContinuously(true);
            }

 */




           else {
                logger.info("Cleanup!");
                logger.info("Test completed!");
            }
            System.out.println("###########-THE END-###################");
            //after every test, we gonna close browser
            MyDriver.get().close();


           /*
            File scrFile = ((TakesScreenshot) MyDriver.get()).getScreenshotAs(OutputType.FILE);
            // store the screenshot to your local machine
            FileUtils.copyFile(scrFile, new File("D:pageScreenshot.gif"), true);

            */






        }
    }


