package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
         tags = "@login_with_params",
      plugin = {"html:target/default-report",
      }
      // plugin = "html:target/cucumber-html-report"
        //mvn clean verify -q
        //mvn clean verify
)

public class CucumberRunner {

}
