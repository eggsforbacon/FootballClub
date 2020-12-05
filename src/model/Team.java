package model;

import java.util.*;

/**
 * A class that describes how a team should behave on the app.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class Team {

  private String teamName;
  private MainTrainer coach;
  private ArrayList<AssistingTrainer> assistants = new ArrayList<>(0);
  private ArrayList<Player> roster = new ArrayList<>(0);
  private ArrayList<Alignment> alignments = new ArrayList<>(0);

  /**
   * @param teamName The name of the team. <b>Must be unique, and not empty or null</b>.<br>
   */
  public Team(String teamName) {
    this.teamName = teamName;
    coach = null;
  }

  /**
   * Adds an alignment.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The alignment is added.<br>
   * @param newDate The date of the alignment to be added. <b>Must not be empty or null</b>.<br>
   * @param newIndex The index of the technique the alignment to be added will use. <b>Must be positive between 0 and 3</b>.<br>
   * @param newSetting The setting for the alignment to be addedd. <b>Must be unique, and not empty or null</b>.<br>
   */
   public boolean addAlignment(String newDate, int newIndex, String newSetting) {
     Alignment alig = new Alignment(newDate, newIndex, newSetting);
     if (contains(alig)) return false;
     else {
       alignments.add(alig);
       return true;
     }
   }

  /**
   * Adds assisting trainers to the team's roster.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The trainer is added to the team's roster.<br>
   * @param asst The trainer that is going to be added. <b>Must not be null</b>.<br>
   */
  public boolean addAssistingTrainers(AssistingTrainer asst) {
    if (contains(asst)) return false;
    else {
      assistants.add(asst);
      return true;
    }
  }

  /**
   * Adds players to the team's roster.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is added to the team's roster.<br>
   * @param player The player that is going to be added. <b>Must not be null</b>.<br>
   */
  public boolean addPlayer(Player player) {
    if (contains(player)) return false;
    else {
      roster.add(player);
      return true;
    }
  }

  /**
   * Checks wether the trainer that will be added is already inside the team.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The fact whether the alignment exists inside the team is true or not is stated.<br>
   * @param alig The alignment to be looked up. <b>Must not be null</b>.<br>
   */
   public boolean contains(Alignment alig) {
     boolean flag = false;
     for (Alignment a : alignments) {
         flag = (a.getSetting().equals(alig.getSetting()));
         if (flag) break;
     }
     return flag;
   }

  /**
   * Checks wether the trainer that will be added is already inside the team.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The fact whether the assistant exists inside the team is true or not is stated.<br>
   * @param asst The asssistant that will be looked up. <b>Must not be null</b>.<br>
   */
  public boolean contains(AssistingTrainer asst) {
    boolean flag = false;
    for (AssistingTrainer a : assistants) {
        flag = (a.getKey().equals(asst.getKey()));
        if (flag) break;
    }
    return flag;
  }

  /**
   * Checks wether the player that will be added is already inside the team.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The fact wheter the player exists inside the team is true or not is stated.<br>
   * @param player The player that will be looked up. <b>Must not be null</b>.<br>
   */
  public boolean contains(Player player) {
    boolean flag = false;
    for (Player p : roster) {
        flag = (p.getKey().equals(player.getKey()));
        if (flag) break;
    }
    return flag;
  }

  /**
   * Returns the information of the team.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information is returned.<br>
   */
  public ArrayList<String> showInfo() {
    ArrayList<String> info = new ArrayList<>();
    info.add("********************************************************************************");
    info.add("*Nombre del equipo: " + teamName);
    String mainCoach = (coach == null) ? "Ninguno" : coach.getName();
    info.add("*Entrenador principal: " + mainCoach);
    if (assistants.size() != 0) {
      info.add("*Entrenadores asistentes:                                                      *");
      for (AssistingTrainer a : assistants) {
        info.add("--" + a.getName());
      }
      info.add("********************************************************************************");
    } else {
      info.add("*No hay entrenadores asistentes por el momento.                                *");
      info.add("********************************************************************************");
    }
    if (roster.size() != 0) {
      info.add("*Jugadores:                                                                    *");
      for (Player p : roster) {
        info.add("--" + p.getName() + ", " + p.getPosition() + ", " + p.getNumber() + "  (" + p.getGoals() + " goles)");
      }
      info.add("********************************************************************************");
    } else {
      info.add("*No hay jugadores en el equipo por el momento.                                 *");
      info.add("********************************************************************************");
    }
    if (alignments.size() != 0) {
      info.add("*Alineaciones:");
      for (Alignment a : alignments) {
        info.add("--Fecha: " + a.getDate());
        info.add("--Formacion:                                                                    *");
        info.add("-----------------------");
        for (int i = 0; i < a.getSetting().length; i++) {
          StringBuilder fieldrows = new StringBuilder();
          fieldrows.append("|");
          for (int j = 0; j < a.getSetting()[0].length; j++) {
            String player = (a.getSetting()[i][j]) ? " 1 " : "   ";
            fieldrows.append(player);
          }
          fieldrows.append("|");
          info.add(fieldrows.toString());
        }
        info.add("-----------------------");
        info.add("(" + a.revert() + ")");
        info.add("*-------------------------------------------------------------------------------*");
      }
      info.add("********************************************************************************");
    } else {
      info.add("*No hay alineaciones en el equipo por el momento");
    }
    info.add("********************************************************************************");
    info.add("*Volver                                                                 [ENTER]*");
    info.add("********************************************************************************");
    return info;
  }

  //Getters

  /**
   * @return the teamName
   */
  public String getTeamName() {
  	return teamName;
  }

  /**
   * @return the coach
   */
  public MainTrainer getCoach() {
  	return coach;
  }

  /**
   * @return the assistants
   */
  public ArrayList<AssistingTrainer> getAssistants() {
  	return assistants;
  }

  /**
   * @return the roster
   */
  public ArrayList<Player> getRoster() {
  	return roster;
  }

  /**
   * @return the alignments
   */
  public ArrayList<Alignment> getAlignments() {
  	return alignments;
  }

  //Setters

  /**
   * @param teamName the teamName to set
   */
  public void setTeamName(String teamName) {
  	this.teamName = teamName;
  }

  /**
   * @param coach the coach to set
   */
  public void setCoach(MainTrainer coach) {
  	this.coach = coach;
  }
}
