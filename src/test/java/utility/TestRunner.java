package utility;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"stepDefinition"},
        plugin={"json:target/cucumberReports/Cucumber.json",
                "junit:target/cucumberReports/Cucumber.xml",
                "html:target/cucumberReports"},
        tags={"@nswsearch"},
        monochrome = true


)
public class TestRunner {
}
