package zoo_exceptions;

public class EntityNotFoundException extends ZooException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}