package org.wahlzeit.utils;

import org.wahlzeit.Exceptions.InvalidBuildYearException;
import org.wahlzeit.Exceptions.InvalidDoubleException;
import org.wahlzeit.model.CarBrand;
import org.wahlzeit.model.CarEngine;


public class Asserts {

    /**
     * @methodtype assertion
     */
    public static void assertNotNull(Object arg) {
        if(arg == null){
            throw new IllegalArgumentException("Value must not be null");
        }
    }

    /**
     * @methodtype assertion
     */
    public static void assertValidDouble(double val) throws InvalidDoubleException {
        if (Double.isInfinite(val) || Double.isNaN(val)){
            throw new InvalidDoubleException(val + " is not a valid double!");
        }

    }

    /**
     * @methodtype assertion
     */
    public static void assertCarBrand(int i){
        try{
            CarBrand[] values = CarBrand.values();
            CarBrand brand = values[i];
        } catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Not a valid Car Brand!");
        }

    }

    /**
     * @methodtype assertion
     */
    public static void assertCarEngine(int i){
        try{
            CarEngine[] values = CarEngine.values();
            CarEngine model = values[i];
        } catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Not a valid Car Model!");
        }

    }

}
