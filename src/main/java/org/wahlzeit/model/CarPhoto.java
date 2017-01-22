package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.Exceptions.InvalidBuildYearException;
import org.wahlzeit.annotation.PatternInstance;

import static org.wahlzeit.utils.Asserts.*;

@Subclass
@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"AbstractProduct", "ConcreteProduct"}
)
public class CarPhoto extends Photo {

    private Car car;

    private static CarManager carManager = CarManager.getInstance();

    /**
     * default constructor
     */
    public CarPhoto(){
        super();
    }

    /**
     * constructor with id
     */
    public CarPhoto(PhotoId id){
        super(id);
    }

    /**
     * custom constructor
     */
    public CarPhoto(CarBrand carBrand, CarEngine carEngine, String typeName) throws InvalidBuildYearException {
        super();

        if(carBrand == null || carEngine == null) throw new IllegalArgumentException("Arguments must not be null");

        assertCarBrand(carBrand.asInt());
        assertCarEngine(carEngine.asInt());

        this.car = carManager.createCar(typeName, carEngine, carBrand);
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
