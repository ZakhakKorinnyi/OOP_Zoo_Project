package zoo_exceptions;

public class PermissionDeniedException extends ZooException {
    public PermissionDeniedException(String message) {
        super(message);
    }
}