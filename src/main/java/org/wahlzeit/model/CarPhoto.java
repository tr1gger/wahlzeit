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

        if(carBrand == null || carModel == null) throw new IllegalArgumentException("Arguments must not be null");

        assertBuildYear(buildYear);
        assertCarBrand(brand.asInt());
        assertCarModel(model.asInt());

        this.buildYear = buildYear;
        this.brand = carBrand;
        this.model = carModel;
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
    public CarModel getModel() {
        return model;
    }

    /**
     * @methodtype set
     */
    public void setModel(CarModel model) {
        assertCarModel(model.asInt());
        this.model = model;
    }

    /**
     * @methodtype get
     */
    public int getBuildYear() {
        return buildYear;
    }

    /**
     * @methodtype set
     */
    public void setBuildYear(int buildYear) throws InvalidBuildYearException {
        assertBuildYear(buildYear);
        this.buildYear = buildYear;
    }
}
