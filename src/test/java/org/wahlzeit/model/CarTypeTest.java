package org.wahlzeit.model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.Exceptions.InvalidBuildYearException;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import static org.junit.Assert.*;

public class CarTypeTest {

    @ClassRule
    public static RuleChain ruleChain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());

    private static String TYPE_NAME_SPORTS_CAR = "sports car";
    private static String TYPE_NAME_CONVERTIBLE_CAR = "convertible";
    private static String TYPE_NAME_SUV_CAR =  "suv";

    private Car sportsCar;
    private Car suvCar;

    private CarManager carManager = CarManager.getInstance();

    @Before
    public void startUp(){
        sportsCar = Car.createCar(TYPE_NAME_SPORTS_CAR);
        suvCar = Car.createCar(TYPE_NAME_SUV_CAR);
    }

    @Test
    public void carTypeNameTest() throws InvalidBuildYearException {
        assertEquals(sportsCar.getCarType().getTypeName(), TYPE_NAME_SPORTS_CAR);
    }

    @Test
    public void carIdTest(){
        assertNotEquals(sportsCar.getId(), suvCar.getId());
    }

    @Test
    public void getCarByIdTest(){
        Car car = carManager.getCar(sportsCar.getId());
        assertEquals(car, sportsCar);
    }

    @Test
    public void createSubTypes(){

        /**
         * create new carType 'convertible'
         */
        CarType convertibleType = carManager.getCarType(TYPE_NAME_CONVERTIBLE_CAR);

        /**
         * add carType 'convertible' to super type 'sports car'
         */
        carManager.getCarType(TYPE_NAME_SPORTS_CAR).addSubType(convertibleType);

        assertEquals(convertibleType.getSuperType(), carManager.getCarType(TYPE_NAME_SPORTS_CAR));
        assertTrue(convertibleType.isSubType());
    }

}
