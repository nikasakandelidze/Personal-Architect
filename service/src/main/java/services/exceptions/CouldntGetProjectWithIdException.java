package services.exceptions;

public class CouldntGetProjectWithIdException extends RuntimeException{
    public CouldntGetProjectWithIdException(String message) {
        super(message);
    }
}
