package model;

import java.lang.reflect.Field;

public class Player extends Employee implements Calculations{

    private int number;
    private int goals;
    private double averageRating;
    private String position;
    private int posIndex;
    private String team;

    /**
     * @param name The name of the player.<br>
     * @param id The id of the player.<br>
     * @param salary The salary of the player.<br>
     * @param status The status of the player.<br>
     * @param number The shirt number of the player.<br>
     * @param goals The number of goals in the club pf the player.<br>
     * @param averageRating The average rating of the player.<br>
     * @param posIndex The index to fetch the position of the player.<br>
     */
    public Player(String name, String id, int salary, boolean status, int number, int goals, double averageRating, int posIndex) {
        super(name,id,salary,status);
        this.number = number;
        this.goals = goals;
        this.averageRating = averageRating;
        this.posIndex = posIndex;
        position = FieldPosition.get(posIndex).getName();
    }

    @Override
    public String showInfo() {
      return "" +
            "*------------------------------------------------------------------------------*\n" +
            "*Nombre del empleado: " + getName() + "\n" +
            "*ID: " + getId() + "\n" +
            "*Salario: " + getSalary() + "\n" +
            "*Tipo de empleado: Jugador\n" +
            "*Estado: " + getStatus() +
            "*Equipo: " + team + "\n" +
            "*Posicion y numero: " + position + "(" + number + ")";
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

    //Getters

    /**
     * @return the number
     */
    public int getNumber() {
    	return number;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
    	return goals;
    }

    /**
     * @return the averageRating
     */
    public double getAverageRating() {
    	return averageRating;
    }

    /**
     * @return the position
     */
    public String getPosition() {
    	return position;
    }

    /**
     * @return the team
     */
    public String getTeam() {
    	return team;
    }
}
