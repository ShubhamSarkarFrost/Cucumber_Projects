package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Feature"},
        glue = {"Steps"},
        plugin = {"pretty","html:target/cucumber-reports/report"},
        dryRun = true,
        monochrome = true,
        publish = true

)

public class TestRunner {
}
