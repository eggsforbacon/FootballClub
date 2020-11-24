package model;

public class MainTrainer extends Trainer implements Calculations{

    private int numberOfTeams;
    private int wonMatches;

    public MainTrainer(String name, String id, int salary, boolean status, int xpYears, int numberOfTeams, int wonMatches) {
        super(name,id,salary,status,xpYears);
        this.numberOfTeams = numberOfTeams;
        this.wonMatches = wonMatches;
    }

    @Override
    public double marketPrice() {
        return (getSalary() * 10) + (getXPYears() * 100) + (wonMatches * 50);
    }

    @Override
    public double starLevel() {
        return 5 + (wonMatches / 10);
    }
}
