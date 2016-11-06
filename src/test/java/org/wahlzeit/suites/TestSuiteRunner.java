package org.wahlzeit.suites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.logging.Logger;

/**
 * Helper class to run the test suite
 */
public class TestSuiteRunner {

    private static Logger log = Logger.getLogger(TestSuiteRunner.class.getName());

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(AllTestSuite.class);

        for (Failure failure : result.getFailures()) {
            log.warning(failure.toString());
        }

       log.info("" + result.wasSuccessful());
    }
}
