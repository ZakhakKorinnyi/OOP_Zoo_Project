package zoo.patterns_strategy;

import zoo.base_objects.Animal;

// Стратегія для хижих тварин (Лев, Крокодил, Щука)
public class CarnivoreFeedingStrategy implements FeedingStrategy {
    @Override
    public void feed(Animal animal) {
        System.out.println(animal.getName() + " отримує високобілковий раціон (Хижак).");
        animal.performEat(); // Викликається захищений метод базового класу
    }
}