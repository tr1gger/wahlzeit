package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.model.persistence.GcsAdapterTest;

/**
 * Test Suite for all Model Persistence Tests
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        DatastoreAdapterTest.class,
        GcsAdapterTest.class
})
public class ModelPersistenceTestSuite {
}
