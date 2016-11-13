package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Subclass;

import java.util.logging.Logger;

@Subclass
public class CarPhoto extends Photo {


    private static final Logger log = Logger.getLogger(CarPhoto.class.getName());

    public CarPhoto(){
        super();
    }

    public CarPhoto(PhotoId id){
        super(id);
    }
}
