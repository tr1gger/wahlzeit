package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * master test suite class for all child test suites
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        HandlerTestSuite.class,
        ModelTestSuite.class,
        ServicesTestSuite.class,
        UtilsTestSuite.class
})
public class AllTestSuite {
}
