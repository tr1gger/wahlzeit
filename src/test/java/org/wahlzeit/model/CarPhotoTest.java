package org.wahlzeit.model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class CarPhotoTest {


    private CarPhoto carPhoto;


    /**
     *  Could not fix error:
     *  java.lang.NoClassDefFoundError: Could not initialize class org.wahlzeit.model.PhotoManager / Photo / PhotoFactory
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        carPhoto = new CarPhoto();
    }


    @Test
    public void testConstructor(){
        assertNotNull(carPhoto);
    }

    @Test
    public void testPhotoId(){

    }


    @After
    public void tearDown(){

    }
}



