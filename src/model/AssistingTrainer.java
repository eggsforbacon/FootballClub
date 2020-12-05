package model;
import java.util.*;
import java.text.NumberFormat;
import ui.Menu;

/**
 * Specifies on Assisting trainers' behaviors and traits.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class AssistingTrainer extends Trainer {

    private boolean isProffessional;
    private ArrayList<String> expertises = new ArrayList<>(0);

    /**
     * @see Trainer#Trainer(String, String, int, int) Trainer Constructor
     * @param isProffessional Whether the trainer was or not a proffessional player. <b>Data type restrictions</b>.<br>
     * @param indexes The indexes of the expertises of the trainer. <b>Maximum size is 4, and must contain unique numbers between 0 and 3</b>.<br>
     */
    public AssistingTrainer(String name, String id, int salary, int xpYears, boolean isProffessional, ArrayList<Integer> indexes) {
        super(name,id,salary,xpYears);
        this.isProffessional = isProffessional;
        for (int i = 0; i < indexes.size(); i++) {
          expertises.add(Expertise.get(indexes.get(i)).getName());
        }
        setType("Entrenador Asistente");
    }

    @Override
    public String showInfo() {
      NumberFormat comma = NumberFormat.getInstance();
      comma.setGroupingUsed(true);
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
            "*Salario: $" + comma.format(getSalary()) + "\n" +
            "*Tipo de empleado: " + getType() + "\n" +
            "*Estado: " + legibleStatus() + "\n" +
            "*Parte del equipo: " + getTeam() + "\n" +
            "*Fue jugador profesional: " + proffessionalToString + "\n" +
            "*Experticias: " + expertisesToString.toString() + "\n" +
            "*Anios de experiencia: " + getXPYears();
    }

    //Getters

    /**
     * @return the expertises
     */
    public ArrayList<Integer> getExpertises() {
      ArrayList<Integer> expertisesToInt = new ArrayList<>();
      for (String s : expertises) {
        expertisesToInt.add(Integer.parseInt(s));
      }
    	return expertisesToInt;
    }

    /**
     * @return the fact whether or not the trainer is proffessional
     */
    public boolean getIsProffesional() {
      return isProffessional;
    }

    //Setters

    /**
     * @param expertises the expertises to set
     */
    public void setExpertises(ArrayList<Integer> expertises) {
      this.expertises.clear();
      for (int i = 0; i < expertises.size(); i++) {
        this.expertises.add(Expertise.get(expertises.get(i)).getName());
      }
    }

    /**
     * @param isProffessional the isProffessional to set
     */
    public void setProffessional(boolean isProffessional) {
    	this.isProffessional = isProffessional;
    }
}
