package utility;

import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.IReporter;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;


/**
 * Created by amy on 8/31/2016.
 * here is an example http://stackoverflow.com/questions/10219640/create-custom-testng-report-webdriver
 * https://www.seleniumeasy.com/testng-tutorials/testng-customize-emailable-html-report-example
 */
public class CustomReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
        //Iterating over each suite include in the test
        for (ISuite suite : suites) {
            //following code gets suite name
            String suiteName = suite.getName();
            //Getting the results for the suite
            Map<String,ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()){
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}

