package model;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Specifies on Main trainers' behaviors and traits.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class MainTrainer extends Trainer implements Calculations {

    private int numberOfTeams;
    private int wonMatches;

    /**
     * @see Trainer#Trainer(String, String, int, int) Trainer Constructor
     * @param numberOfTeams The number of teams the trainer has lead. <b>Must be positive</b>.<br>
     * @param wonMatches The number of matches the trainer has won. <b>Must be positive</b>.<br>
     */
    public MainTrainer(String name, String id, int salary, int xpYears, int numberOfTeams, int wonMatches) {
        super(name,id,salary,xpYears);
        this.numberOfTeams = numberOfTeams;
        this.wonMatches = wonMatches;
        setType("Entrenador Principal");
    }

    @Override
    public String showInfo() {
      NumberFormat comma = NumberFormat.getInstance();
      comma.setGroupingUsed(true);
      return "" +
            "*------------------------------------------------------------------------------*\n" +
            "*Nombre del empleado: " + getName() + "\n" +
            "*ID: " + getId() + "\n" +
            "*Salario: $" + comma.format(getSalary()) + "\n" +
            "*Tipo de empleado: " + getType() + "\n" +
            "*Estado: " + legibleStatus() + "\n" +
            "*Lider del equipo: " + getTeam() + "\n" +
            "*Partidos ganados: " + wonMatches + "\n" +
            "*Equipos liderados: " + numberOfTeams + "\n" +
            "*Anios de experiencia: " + getXPYears() + "\n" +
            "*Precio de mercado: $" + marketPrice() + "\n" +
            "*Nivel de estrella: " + String.format("%.2f",starLevel());
    }

    @Override
    public String marketPrice() {
      double price = (getSalary() * 10) + (getXPYears() * 100) + (wonMatches * 50);
      DecimalFormat doppelComma = new DecimalFormat("#.##");
      doppelComma.setGroupingUsed(true);
      doppelComma.setGroupingSize(3);
      return doppelComma.format(price);
    }

    @Override
    public double starLevel() {
        return 5 + (wonMatches / 10);
    }

    //Getters

    /**
     * @return the wonMatches
     */
    public int getWonMatches() {
    	return wonMatches;
    }

    /**
     * @return the numberOfTeams
     */
    public int getNumberOfTeams() {
    	return numberOfTeams;
    }

    //Setters

    /**
     * @param wonMatches the wonMatches to set
     */
    public void setWonMatches(int wonMatches) {
    	this.wonMatches = wonMatches;
    }

    /**
     * @param numberOfTeams the numberOfTeams to set
     */
    public void setNumberOfTeams(int numberOfTeams) {
    	this.numberOfTeams = numberOfTeams;
    }
}
