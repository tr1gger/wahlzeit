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

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(PhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
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
