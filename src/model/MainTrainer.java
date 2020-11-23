package model;

public class MainTrainer extends Trainer {

    private int numberOfTeams;
    private int wonMatches;

    public MainTrainer(String name, String id, int salary, boolean status, int xpYears, int numberOfTeams, int wonMatches) {
        super(name,id,salary,status,xpYears);
        this.numberOfTeams = numberOfTeams;
        this.wonMatches = wonMatches;
    }
}
