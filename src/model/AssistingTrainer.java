package model;
import java.util.*;

public class AssistingTrainer extends Trainer {

    private boolean proffessional;
    private ArrayList<String> expertises = new ArrayList<>(0);

    /**
     * @param
     */
    public AssistingTrainer(String name, String id, int salary, boolean status, int xpYears, String team, boolean proffessional, int index) {
        super(name,id,salary,status,xpYears,team);
        this.proffessional = proffessional;
        expertises.add(Expertise.get(index).getName());
    }

    @Override
    public String showInfo() {
      String proffessionalToString = (proffessional) ? "Si" : "No";
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
