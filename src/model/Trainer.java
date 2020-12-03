package model;

public abstract  class Trainer extends Employee {

    private int xpYears;
    private String team;

    /**
     * @param name
     */
    public Trainer(String name, String id, int salary, boolean status, int xpYears, String team) {
        super(name,id,salary,status);
        this.xpYears = xpYears;
        this.team = team;
    }

    @Override
    public abstract String showInfo();

    //Getters

    /**
     * @return the xpYears
     */
    public int getXPYears() {
    	return xpYears;
    }

    /**
     * @return the team
     */
    public String getTeam() {
    	return team;
    }

    //Setters

    /**
     * @param xpYears the xpYears to set
     */
    public void setXpYears(int xpYears) {
    	this.xpYears = xpYears;
    }
}
