package com.autotrader.runnerClasses;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/autotrader/stepDefinitions",
        dryRun =false,
       tags = "@smoke_test,@unit_test",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)

public class RunnerClass {


}