package org.wahlzeit.Exceptions;

/**
 * Created by robert on 11.12.16.
 */
public class InvalidBuildYearException extends Exception {

    public InvalidBuildYearException(){
        super();
    }

    public InvalidBuildYearException(String message){
        super(message);
    }

    public InvalidBuildYearException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidBuildYearException(Throwable cause){
        super(cause);
    }
}


