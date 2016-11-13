package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;


@Subclass
public class CarPhoto extends Photo {
    public CarPhoto(){
        super();
    }

    public CarPhoto(PhotoId id){
        super(id);
    }
}
