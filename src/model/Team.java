package model;

import java.util.*;

public class Team {

  private String teamName;
  private MainTrainer coach;
  private AssistingTrainer[] assistants;
  private ArrayList<Player> roster = new ArrayList<>();
  private ArrayList<Alignment> alignments = new ArrayList<>();

  public Team(String teamName, MainTrainer coach) {
    this.teamName = teamName;
    this.coach = coach;

    assistants = new AssistingTrainer[3];
  }

  public ArrayList<Player> getRoster() {
    return roster;
  }

  public void addAssistingTrainers(AssistingTrainer asst) {

  }

  private boolean contains(AssistingTrainer asst) {
    boolean flag = false;
    for (int i = 0; i < assistants.length; i++) {
        flag = (assistants[i].getName().equals(asst.getName()));
        if (flag) break;
    }

    return flag;
  }
}
