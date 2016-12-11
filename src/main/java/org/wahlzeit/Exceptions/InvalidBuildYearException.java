package org.wahlzeit.Exceptions;

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


