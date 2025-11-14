package zoo.patterns_strategy;

import zoo.base_objects.Animal;

// Визначення стратегії, що визначає спільний метод
public interface FeedingStrategy {
    void feed(Animal animal);
}