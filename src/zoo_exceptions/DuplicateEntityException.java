package zoo_exceptions;

public class DuplicateEntityException extends ZooRuntimeException {
    public DuplicateEntityException(String message) {
        super(message);
    }
}