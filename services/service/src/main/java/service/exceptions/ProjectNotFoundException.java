package service.exceptions;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
