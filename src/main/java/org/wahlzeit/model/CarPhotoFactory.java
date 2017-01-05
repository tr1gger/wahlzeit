package org.wahlzeit.model;


import org.wahlzeit.annotation.PatternInstance;
import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

@PatternInstance(
        patternName = "Abstract Factory",
        participants = {"AbstractFactory", "ConcreteFactory"}
)
public class CarPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(CarPhotoFactory.class.getName());

    private static PhotoFactory instance  = null;

    public static PhotoFactory getInstance(){
        if(instance == null){
            log.config(LogBuilder.createSystemMessage().addAction("setting CarPhotoFactory").toString());
            instance = new CarPhotoFactory();
        }
        return instance;
    }

    protected static synchronized void setInstance(PhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize CarPhotoFactory twice");
        }

        instance = photoFactory;
    }

    @Override
    public Photo createPhoto(){
         return new CarPhoto();
    }

    @Override
    public Photo createPhoto(PhotoId id){
        return new CarPhoto(id);
    }

}
