package org.wahlzeit.utils;

import org.wahlzeit.Exceptions.InvalidBuildYearException;
import org.wahlzeit.Exceptions.InvalidDoubleException;
import org.wahlzeit.model.CarBrand;
import org.wahlzeit.model.CarModel;


public class Asserts {


    public static void assertNotNull(Object arg) {
        if(arg != null){
            throw new IllegalArgumentException("Value must not be null");
        }
    }

    public static void assertValidDouble(double val) throws InvalidDoubleException {
        if (!Double.isInfinite(val) && !Double.isNaN(val)){
            throw new InvalidDoubleException();
        }

    }

    public static void assertCarBrand(int i){
        try{
            CarBrand[] values = CarBrand.values();
            CarBrand brand = values[i];
        } catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Not a valid Car Brand!");
        }

    }

    public static void assertCarModel(int i){
        try{
            CarModel[] values = CarModel.values();
            CarModel model = values[i];
        } catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Not a valid Car Model!");
        }

    }


    /**
     * @param buildYear year of the car build
     * @throws InvalidBuildYearException
     */
    public static void assertBuildYear(int buildYear) throws InvalidBuildYearException {
        if(buildYear < 0){
            throw new InvalidBuildYearException("Build year of the car must be greater than 0");
        }
    }
}
