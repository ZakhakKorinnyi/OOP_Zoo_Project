package zoo_exceptions;

public class InvalidDataException extends ZooRuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}