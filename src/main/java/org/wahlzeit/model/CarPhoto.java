package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.Exceptions.InvalidBuildYearException;

import static org.wahlzeit.utils.Asserts.*;

@Subclass
public class CarPhoto extends Photo {

    private CarBrand brand;
    private CarModel model;

    private int buildYear;


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
    public CarPhoto(int buildYear, CarBrand carBrand, CarModel carModel) throws InvalidBuildYearException {
        super();

        assertBuildYear(buildYear);
        assertCarBrand(brand.asInt());
        assertCarModel(model.asInt());

        this.buildYear = buildYear;
        this.brand = carBrand;
        this.model = carModel;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        assertCarBrand(brand.asInt());
        this.brand = brand;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        assertCarModel(model.asInt());
        this.model = model;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) throws InvalidBuildYearException {
        assertBuildYear(buildYear);
        this.buildYear = buildYear;
    }
}
