package zoo.zoo_patterns;

import zoo.base_objects.Animal;
import zoo.enums.Gender;
import zoo.zoo_animals.*;
import zoo_exceptions.InvalidDataException;

public class AnimalFactory {

    public static Animal createAnimal(String animalType, String name, int age, Gender gender, Object... specificParams) {
        switch (animalType.toLowerCase()) {
            case "lion":
                int prideSize = (int) specificParams[0];
                return new Lion(name, age, gender, prideSize);
            case "hummingbird":
                int flightSpeed = (int) specificParams[0];
                return new Hummingbird(name, age, gender, flightSpeed);
            case "crocodile":
                double length = (double) specificParams[0];
                return new Crocodile(name, age, gender, length);

            // НОВІ ХРЕБЕТНІ
            case "frog":
                return new Frog(name, age, gender);
            case "pike":
                return new Pike(name, age, gender);

            // НОВІ БЕЗХРЕБЕТНІ
            case "spider":
                return new Spider(name, age, gender);
            case "butterfly": // ДОДАНО Butterfly
                return new Butterfly(name, age, gender);

            default:
                throw new InvalidDataException("Невідомий тип тварини у Фабриці: " + animalType);
        }
    }
}