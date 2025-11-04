package zoo.patterns_strategy;

import zoo.base_objects.Animal;

// Інтерфейс Стратегії: визначає спільний метод
public interface FeedingStrategy {
    void feed(Animal animal);
}