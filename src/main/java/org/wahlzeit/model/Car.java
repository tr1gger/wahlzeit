package org.wahlzeit.model;

import org.wahlzeit.annotation.PatternInstance;

import java.util.concurrent.atomic.AtomicInteger;


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
    private CarType carType;

    /**
     *
     */
    private static CarManager carManager = CarManager.getInstance();


    public Car(CarType carType){
        this.carType = carType;
    }

    public static Car createCar(String typeName){
        return carManager.createCar(typeName);
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
}
