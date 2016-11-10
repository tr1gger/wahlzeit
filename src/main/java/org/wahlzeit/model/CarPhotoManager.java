package org.wahlzeit.model;


import java.util.HashMap;
import java.util.Map;

public class CarPhotoManager extends PhotoManager {

    /**
     *
     */
    protected static final PhotoManager instance = new CarPhotoManager();

    /**
     *
     */
    protected Map<PhotoId, Photo> photos = new HashMap<PhotoId, Photo>();

    public CarPhotoManager(){
        super();
    }

    public PhotoManager getCarPhotoManager(){
        return instance;
    }

}
