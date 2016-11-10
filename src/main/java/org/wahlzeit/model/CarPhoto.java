package org.wahlzeit.model;


public class CarPhoto extends Photo {

    private CarPhotoManager carPhotoManager;

    public CarPhoto(){
        super();
    }

    public CarPhoto(PhotoId id){
       super(id);
    }
}
