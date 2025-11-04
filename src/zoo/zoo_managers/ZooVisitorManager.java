package zoo.zoo_managers;

import zoo.base_objects.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ZooVisitorManager {

    private List<Visitor> visitors;

    public ZooVisitorManager() {
        this.visitors = new ArrayList<>();
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
        System.out.println(visitor.getName() + " прибув(ла) до зоопарку.");
    }
}