package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Ignore;
import org.wahlzeit.annotation.PatternInstance;
import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Set;


@PatternInstance(
        patternName = "Object Type",
        participants = {"Object Type"}
)
public class CarType extends DataObject{

    /**
     *
     */
    @Ignore
    private  CarType superType = null;

    /**
     *
     */
    @Ignore
    private Set<CarType> subTypes = new HashSet<CarType>();

    /**
     *
     */
    private String typeName;


    /**
     *
     */
    private static CarManager carManager = CarManager.getInstance();


    private CarType(String typeName){
        this.typeName = typeName;
    }

    public static CarType getInstance(String typeName){
        return carManager.getCarType(new CarType(typeName));
    }

    /**
     * @methodtype creation
     */
    public Car createInstance(){
        return new Car(this);
    }

    /**
     * @methodtype get
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @methodtype set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @methodtype get
     */
    public CarType getSuperType() {
        return superType;
    }

    /**
     * @methodtype set
     */
    public void setSuperType(CarType superType) {
        this.superType = superType;
    }

    /**
     * @methodtype helper
     */
    public void addSubType(CarType carType){
        assert (carType != null) : "Tried to set null sub-type";
        carType.setSuperType(this);
        subTypes.add(carType);
    }

    /**
     * @methodtype Query
     */
    public boolean isSubType(){
        return getSuperType() != null;
    }

}
