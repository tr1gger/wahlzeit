package org.wahlzeit.model;

import org.wahlzeit.annotation.PatternInstance;

import static org.wahlzeit.utils.Asserts.*;

@PatternInstance(
        patternName = "Object Type",
        participants = {"Object"}
)
public class Car {

    /**
     *
     */
    private int id;

    /**
     *
     */
    private CarBrand brand;

    /**
     *
     */
    private CarEngine engine;

    /**
     *
     */
    private CarType carType;

    /**
     *
     */
    private static CarManager carManager = CarManager.getInstance();


    private Car(CarType carType, CarEngine carEngine, CarBrand carBrand){
        assertCarBrand(carBrand.asInt());
        assertCarEngine(carEngine.asInt());

        this.engine = carEngine;
        this.brand = carBrand;
        this.carType = carType;
    }

    public static Car createInstance(CarType carType, CarEngine carEngine, CarBrand carBrand){
        return carManager.getCar(new Car(carType, carEngine, carBrand));
    }

    /**
     * @methodtype get
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * @methodtype set
     */
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    /**
     * @methodtype get
     */
    public int getId() {
        return id;
    }

    /**
     * @methodtype set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @methodtype get
     */
    public CarBrand getBrand() {
        return brand;
    }

    /**
     * @methodtype set
     */
    public void setBrand(CarBrand brand) {
        assertCarBrand(brand.asInt());
        this.brand = brand;
    }

    /**
     * @methodtype get
     */
    public CarEngine getEngine() {
        return engine;
    }

    /**
     * @methodtype set
     */
    public void setEngine(CarEngine engine) {
        assertCarEngine(engine.asInt());
        this.engine = engine;
    }
}
