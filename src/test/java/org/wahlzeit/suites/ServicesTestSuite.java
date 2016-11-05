package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;

/**
 * Test Suite for all Services Tests
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        ServicesMailingTestSuite.class,
        EmailAddressTest.class,
        LogBuilderTest.class
})
public class ServicesTestSuite {
}
