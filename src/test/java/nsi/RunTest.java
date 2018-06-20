package nsi;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "./src/test/resources/cucumber.json",
        jsonUsageReport = "./src/test/resources/usage.json", usageReport = true, detailedAggregatedReport = true,
        overviewChartsReport = true, outputFolder = "target/analysis", reportPrefix = "Marketing Website ",
        featureOverviewChart = true, toPDF = true, pdfPageSize = "A3 landscape")

@CucumberOptions(features = "classpath:features", plugin =
{"json:src/test/resources/cucumber.json" , "usage:src/test/resources/usage.json" }, monochrome = true, tags =
{"@Regression" })

// @NSINotWorking

public class RunTest
{

}
