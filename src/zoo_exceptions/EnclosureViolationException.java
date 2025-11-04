package zoo_exceptions;

public class EnclosureViolationException extends ZooRuntimeException {
    public EnclosureViolationException(String message) {
        super(message);
    }
}