package model;

/**
 * Generalizes over trainers' traits and behavior.<br>
 * @author Samuel Hernandez <br>
 * @since 0.3.<br>
 */
public abstract  class Trainer extends Employee {

    private int xpYears;
    private String team;

    /**
    * @see Employee#Employee(String, String, int, boolean) Employee Constructor.<br>
    * @param xpYears The years of experience of the trainer. <b>Must be positive</b>.<br>
    * @param team The name of the team of the trainer. <b>Must be the name of an existing team</b>.<br>
     */
    public Trainer(String name, String id, int salary, boolean status, int xpYears, String team) {
        super(name,id,salary,status);
        this.xpYears = xpYears;
        this.team = team;
    }

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

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
    	this.team = team;
    }
}
