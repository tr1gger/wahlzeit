package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.TellFriendTest;

/**
 * test suite for all handler tests
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        TellFriendTest.class
})
public class HandlerTestSuite {
}
