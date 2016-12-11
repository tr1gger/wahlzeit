package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.Exceptions.InvalidBuildYearException;


@Subclass
public class CarPhoto extends Photo {

    private String brand;

    private String model;

    private int buildYear;

    public CarPhoto(){
        super();
    }

    public CarPhoto(int buildYear) throws InvalidBuildYearException {
        super();
        assertBuildYear(buildYear);
    }


    /**
     * @param buildYear year of the car build
     * @throws InvalidBuildYearException
     */
    public void assertBuildYear(int buildYear) throws InvalidBuildYearException{
        if(buildYear < 0){
            throw new InvalidBuildYearException("Build year of the car must be greater than 0");
        }
    }

    public CarPhoto(PhotoId id){
        super(id);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }
}
