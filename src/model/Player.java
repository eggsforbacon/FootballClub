package model;

import java.lang.reflect.Field;

public class Player extends Employee implements Calculations{

    private int number;
    private int goals;
    private double averageRating;
    private int posIndex;

    public Player(String name, String id, int salary, boolean status, int number, int goals, double averageRating, int posIndex) {
        super(name,id,salary,status);
        this.number = number;
        this.goals = goals;
        this.averageRating = averageRating;
        this.posIndex = posIndex;
    }

    @Override
    public double marketPrice() {
        double price = 0;
        switch (FieldPosition.get(posIndex)) {
            case GOALKEEPER:
                price = (getSalary() * 12) + (averageRating * 150);
                break;
            case DEFENDER:
                price = (getSalary() * 13) + (averageRating * 125) + (goals * 100);
                break;
            case MIDFIELD:
                price = (getSalary() * 14) + (averageRating * 135) + (goals * 125);
                break;
            case FORWARD:
                price = (getSalary() * 15) + (averageRating * 145) + (goals * 150);
                break;
        }
        return price;
    }

    @Override
    public double starLevel() {
        double level = 0;
        switch (FieldPosition.get(posIndex)) {
            case GOALKEEPER:
                level = averageRating * 0.9;
                break;
            case DEFENDER:
                level = (averageRating * 0.9) + (goals / 100);
                break;
            case MIDFIELD:
                level = (averageRating * 0.9) + (goals / 90);
                break;
            case FORWARD:
                level = (averageRating * 0.9) + (goals / 80);
                break;
        }
        return level;
    }
}
