package zoo.base_objects;

import zoo.enums.Gender;
import zoo_exceptions.InvalidDataException;
import zoo_exceptions.PermissionDeniedException; // Імпорт для Checked Exception

public class Visitor {

    private String name;
    private int age;
    private Gender gender;
    private boolean hasTicket;

    public Visitor(String name, int age, Gender gender) {
        // Інтеграція Unchecked Exception: InvalidDataException
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Ім'я відвідувача не може бути порожнім.");
        }
        if (age < 0) {
            throw new InvalidDataException("Вік відвідувача не може бути від'ємним.");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hasTicket = false; // Відвідувач за замовчуванням не має квитка
    }

    // Метод для покупки квитка
    public void buyTicket() {
        this.hasTicket = true;
        System.out.println(name + " купив(ла) квиток.");
    }

    /**
     * Метод для перегляду тварини з перевіркою квитка.
     * @param animal Тварина, яку відвідувач хоче подивитися.
     * @throws PermissionDeniedException Якщо відвідувач не має квитка (Checked Exception).
     */
    // Оголошуємо Checked Exception у сигнатурі методу
    public void watchAnimal(Animal animal) throws PermissionDeniedException {
        if (!hasTicket) {
            // Кидаємо Checked Exception, який вимагатиме обробки в Main.java
            throw new PermissionDeniedException(name + " не має квитка і не може спостерігати за тваринами.");
        }
        System.out.println(name + " спостерігає за " + animal.getName() + ".");
    }

    // Геттери для інкапсуляції
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasTicket() {
        return hasTicket;
    }
}