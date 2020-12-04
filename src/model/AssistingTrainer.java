package model;
import java.util.*;

/**
 * Specifies on Assisting trainers' behaviors and traits.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class AssistingTrainer extends Trainer {

    private boolean isProffessional;
    private ArrayList<String> expertises = new ArrayList<>(0);

    /**
     * @see Trainer#Trainer(String, String, int, boolean, int, String) Trainer Constructor
     * @param isProffessional Whether the trainer was or not a proffessional player. <b>Data type restrictions</b>.<br>
     * @param indexes The indexes of the expertises of the trainer. <b>Maximum size is 4, and must contain unique numbers between 0 and 3</b>.<br>
     */
    public AssistingTrainer(String name, String id, int salary, boolean status, int xpYears, String team, boolean isProffessional, ArrayList<Integer> indexes) {
        super(name,id,salary,status,xpYears,team);
        this.isProffessional = isProffessional;
        for (int i = 0; i < indexes.size(); i++) {
          expertises.add(Expertise.get(i).getName());
        }
    }

    @Override
    public String showInfo() {
      String proffessionalToString = (isProffessional) ? "Si" : "No";
      StringBuilder expertisesToString = new StringBuilder();
      int i = 0;
      for (String s : expertises) {
        if (i != expertises.size() - 1) {
          expertisesToString.append(s).append(", ");
          i++;
        } else expertisesToString.append(s);
      }
      return "" +
            "*------------------------------------------------------------------------------*\n" +
            "*Nombre del empleado: " + getName() + "\n" +
            "*ID: " + getId() + "\n" +
            "*Salario: " + getSalary() + "\n" +
            "*Tipo de empleado: Entrenador asistente\n" +
            "*Estado: " + getStatus() +
            "*Parte del equipo: " + getTeam() + "\n" +
            "*Fue jugador profesional: " + proffessionalToString + "\n" +
            "*Experticias: " + expertisesToString.toString() + "\n" +
            "*Anios de experiencia: " + getXPYears();
    }
}
