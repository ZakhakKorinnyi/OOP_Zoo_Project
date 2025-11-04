package zoo_exceptions;

// Успадковується від стандартного RuntimeException (Unchecked Exception)
public class ZooRuntimeException extends RuntimeException {

    // Обов'язковий конструктор, що приймає повідомлення про помилку
    public ZooRuntimeException(String message) {
        super(message); // Передаємо повідомлення базовому класу RuntimeException
    }
}