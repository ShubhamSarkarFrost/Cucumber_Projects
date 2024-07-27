package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Feature"},
        glue = {"Steps"},
        plugin = {"pretty","html:target/cucumber-reports/report", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        publish = true,
        tags = "not @ignore"

)

public class TestRunner {
}
