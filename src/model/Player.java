package model;
import java.lang.reflect.Field;

/**
 * Specifies on the players' traits and behaviors.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class Player extends Employee implements Calculations{

    private int number;
    private int goals;
    private double averageRating;
    private String position;
    private int posIndex;
    private String team;

    /**
     * @see Employee#Employee(String, String, int, boolean) Employee Constructor
     * @param number The shirt number of the player. <b>Must be positive between 0 and 99</b>.<br>
     * @param goals The number of goals in the club pf the player. <b>Must be positive</b>.<br>
     * @param averageRating The average rating of the player. <b>Must be between 0 and 5</b>.<br>
     * @param posIndex The index to fetch the position of the player. <b>Must be between 0 and 3</b>.<br>
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
            "*Posicion y numero: " + position + "(" + number + ")" + "\n" +
            "*Precio de mercado: $" + marketPrice() + "\n" +
            "*Nivel de estrella: " + starLevel();
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
