package de.knoxter.internal.objectmapmapper.exception;

public class AutoMapperException extends Exception {
    public AutoMapperException(String message, Exception innerException) {
        super(message, innerException);
    }
    public AutoMapperException(String message) {
        super(message);
    }
}
