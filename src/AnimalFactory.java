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
            default:
                throw new IllegalArgumentException("Невідомий тип тварини: " + animalType);
        }
    }
}