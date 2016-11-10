package org.wahlzeit.model;


import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

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

    public Photo createCarPhoto(){
         return new CarPhoto();
    }

    public Photo createCarPhoto(PhotoId id){
        return new CarPhoto(id);
    }

}
