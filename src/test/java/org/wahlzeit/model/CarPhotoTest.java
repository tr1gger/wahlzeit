package org.wahlzeit.model;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import static org.junit.Assert.assertNotNull;


public class CarPhotoTest {


    private CarPhoto carPhoto;

    @ClassRule
    public static RuleChain ruleChain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());


    @Before
    public void setUp() throws Exception {
        carPhoto = new CarPhoto();
    }


    @Test
    public void testConstructor(){
        assertNotNull(carPhoto);
    }

    @Test
    public void testPhotoId(){

    }


    @After
    public void tearDown(){

    }
}



