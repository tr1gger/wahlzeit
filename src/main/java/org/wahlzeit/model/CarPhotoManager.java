package org.wahlzeit.model;


import com.google.appengine.api.images.Image;

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

    /**
     *
     */
    public Photo createPhoto(String filename, Image uploadedImage) throws Exception {
        PhotoId id = PhotoId.getNextId();
        Photo result = PhotoUtil.createCarPhoto(filename, id, uploadedImage);
        addPhoto(result);
        return result;
    }

}
