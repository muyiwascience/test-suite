import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/olu/Documents/test-suite/src/test/resources/Features/car_check_reg_number.feature:17"},
        plugin = {"json:/Users/olu/Documents/test-suite/target/cucumber-parallel/json/4.json"},
        monochrome = true,
        glue = {"uk.co.cartaxcheck.steps"})
public class Parallel04IT {
}
