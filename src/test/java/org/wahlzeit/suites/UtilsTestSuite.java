package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.VersionTest;

/**
 * test suite for all utils tests
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        StringUtilTest.class,
        VersionTest.class
})
public class UtilsTestSuite {
}
