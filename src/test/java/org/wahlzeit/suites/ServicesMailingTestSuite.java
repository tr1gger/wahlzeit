package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTest;

/**
 * test suite for all services tests
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        EmailServiceTest.class
})
public class ServicesMailingTestSuite {
}
