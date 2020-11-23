package model;

public class Trainer extends Employee {

    private int xpYears;
    
    public Trainer(String name, String id, int salary, boolean status, int xpYears) {
        super(name,id,salary,status);
        this.xpYears = xpYears;
    }
}
