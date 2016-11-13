package org.wahlzeit.model;


import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class CarPhoto extends Photo {

    private static final Logger log = Logger.getLogger(CarPhoto.class.getName());

    private CarPhotoManager carPhotoManager;

    public CarPhoto(){
        super();
    }

    public CarPhoto(PhotoId id){
       super(id);
        log.warning("Car PHOTO CREATETD with id:" + id);
        log.config(LogBuilder.createSystemMessage().addParameter("CAR PHOTO CREATED with ID: ", this.getId()).toString());
    }
}
