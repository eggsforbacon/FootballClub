package model;

/**
 * Specifies on Main trainers' behaviors and traits.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class MainTrainer extends Trainer implements Calculations{

    private int numberOfTeams;
    private int wonMatches;

    /**
     * @see Trainer#Trainer(String, String, int, boolean, int, String) Trainer Constructor
     * @param numberOfTeams The number of teams the trainer has lead. <b>Must be positive</b>.<br>
     * @param wonMatches The number of matches the trainer has won. <b>Must be positive</b>.<br>
     */
    public MainTrainer(String name, String id, int salary, boolean status, int xpYears, String team, int numberOfTeams, int wonMatches) {
        super(name,id,salary,status,xpYears,team);
        this.numberOfTeams = numberOfTeams;
        this.wonMatches = wonMatches;
    }

    @Override
    public String showInfo() {
      return "" +
            "*------------------------------------------------------------------------------*\n" +
            "*Nombre del empleado: " + getName() + "\n" +
            "*ID: " + getId() + "\n" +
            "*Salario: " + getSalary() + "\n" +
            "*Tipo de empleado: Entrenador principal\n" +
            "*Estado: " + getStatus() +
            "*Lider del equipo: " + getTeam() + "\n" +
            "*Partidos ganados: " + wonMatches + "\n" +
            "*Equipos liderados: " + numberOfTeams + "\n" +
            "*Anios de experiencia: " + getXPYears() + "\n" +
            "*Precio de mercado: $" + marketPrice() + "\n" +
            "*Nivel de estrella: " + starLevel();
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
