package service.exceptions;

public class CouldntAddProjectException extends RuntimeException{
    public CouldntAddProjectException(String message) {
        super(message);
    }
}
