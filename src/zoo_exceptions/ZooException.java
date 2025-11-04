package zoo_exceptions;

// Успадковується від стандартного Exception (Checked Exception)
public class ZooException extends Exception {

    // Обов'язковий конструктор, що приймає повідомлення про помилку
    public ZooException(String message) {
        super(message); // Передаємо повідомлення базовому класу Exception
    }
}