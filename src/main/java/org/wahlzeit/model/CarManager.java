package org.wahlzeit.model;

import org.wahlzeit.annotation.PatternInstance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@PatternInstance(
        patternName = "Object Type, Singelton",
        participants = {"Object", "Object Type"}
)
public class CarManager {

    /**
     *
     */
    public static AtomicInteger id = new AtomicInteger();

    /**
     *
     */
    public static CarManager carManager = new CarManager();

    /**
     *
     */
    private Map<Integer, Car> cars =  new HashMap<>();


    /**
     *
     */
    private Map<String, CarType> carTypes = new HashMap<>();

    private CarManager(){
    }

    /**
     * @methodtype get
     */
    public static CarManager getInstance(){
        return carManager;
    }

    /**
     * @methodtype creation
     */
    public Car createCar(String typeName){
        CarType carType = getCarType(typeName);
        Car car = carType.createInstance();
        car.setId(id.incrementAndGet());
        cars.put(car.getId(), car);
        return car;
    }

    /**
     * @methodtype get
     */
    public CarType getCarType(String typeName) {
        if(carTypes.get(typeName) == null){
            CarType carType = new CarType(typeName);
            carTypes.put(typeName, carType);
            return carType;
        }
        return carTypes.get(typeName);
    }

    /**
     * @methodtype get
     */
    public Car getCar(int id){
        return cars.get(id);
    }

}

