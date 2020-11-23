package model;

public class Player extends Employee {

    private int number;
    private int goals;
    private double averageRating;
    private String position;

    public Player(String name, String id, int salary, boolean status, int number, int goals, double averageRating, int posIndex) {
        super(name,id,salary,status);
        this.number = number;
        this.goals = goals;
        this.averageRating = averageRating;
        position = FieldPosition.get(posIndex).getName();
    }
}
