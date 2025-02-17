package com.qa.ExtentReportListener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporter implements IReporter {
    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
<<<<<<< HEAD
        extent = new ExtentReports(System.getProperty("user.dir")+"/TestOutput/Report.html", true);
=======
        extent = new ExtentReports(System.getProperty("user.dir") + "/TestOutput/Report.html", true);
>>>>>>> 2ba595c (updates)

        for (ISuite suite : suites) {
            // Create a suite node in the Extent Report
            String suiteName = suite.getName();
            extent.startTest("Suite: " + suiteName);
<<<<<<< HEAD

=======
>>>>>>> 2ba595c (updates)
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
<<<<<<< HEAD

                // Add passed, failed, and skipped tests to the report
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);              
=======
              
                // Add passed, failed, and skipped tests to the report
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
>>>>>>> 2ba595c (updates)
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
<<<<<<< HEAD
   //     extent.close();
        Desktop desktop = Desktop.getDesktop();

        File htmlFile = new File(System.getProperty("user.dir")+"/TestOutput/Report.html");
        try {
			desktop.open(htmlFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======

>>>>>>> 2ba595c (updates)
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                // Get the test name and description
                String testName = result.getMethod().getMethodName();
                String description = result.getMethod().getDescription();
                if (description == null || description.isEmpty()) {
                    description = "No description provided.";
                }

                // Create a test node in the Extent Report
                test = extent.startTest(testName, description);

                // Set start and end times
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                // Assign groups if any
                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }

<<<<<<< HEAD
=======
                // Log test data from DataProvider
                Object[] testParams = result.getParameters();
                if (testParams != null && testParams.length > 0) {
                    StringBuilder paramLog = new StringBuilder("Test Data: ");
                    for (Object param : testParams) {
                        paramLog.append(param).append(" ");
                    }
                    test.log(LogStatus.INFO, paramLog.toString().trim());
                }

>>>>>>> 2ba595c (updates)
                // Log the result
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                extent.endTest(test);
<<<<<<< HEAD
            }    }  }
=======
            }
        }
    }
>>>>>>> 2ba595c (updates)

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
<<<<<<< HEAD
=======

>>>>>>> 2ba595c (updates)
}
