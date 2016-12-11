package org.wahlzeit.Exceptions;

public class InvalidDoubleException extends Exception{

    public InvalidDoubleException(){
        super();
    }

    public InvalidDoubleException(String message){
        super(message);
    }

    public InvalidDoubleException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidDoubleException(Throwable cause){
        super(cause);
    }

}
