package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.*;

/**
 * test suite for all model tests
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        ModelPersistenceTestSuite.class,
        AccessRightsTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class
})

public class ModelTestSuite {
}
