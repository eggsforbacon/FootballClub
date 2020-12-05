package model;

import java.util.ArrayList;
/**
 * Cointainer class that links every other class together, along with determining what a club should behave like.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class Club {
  private String clubName;
  private String NIT;
  private String foundationDate;
  private Team teamA;
  private Team teamB;
  private ArrayList<Employee> employees = new ArrayList<>();
  private Room roomA;
  private Room roomB;
  private Office office;

  /**
   * @param clubName The name of the club.<br>
   * @param NIT The identification number of the club.<br>
   * @param foundationDate The date the club was founded.<br>
   */
  public Club(String clubName, String NIT, String foundationDate) {
    // Club initialization
    this.clubName = clubName;
    this.NIT = NIT;
    this.foundationDate = foundationDate;

    //Teams initialization

    teamA = new Team("Equipo A");
    teamB = new Team("Equipo B");

    // Rooms initialization

    roomA = new Room("Camerino A", 7, 6, "Equipo A");
    roomB = new Room("Camerino B", 7, 7, "Equipo B");
    office = new Office("Oficinas", 6, 6);

  }

  /**
   * Adds a player to the employees, a.k.a hires them.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is hired.<br>
   * @param employeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param newNumber The number of the new player. <b>Must be a positive integer</b>.<br>
   * @param newGoals The number of goals of the new player. <b>Must be a positive integer</b>.<br>
   * @param newAverageRating The average rating of the new player. <b>Must be between 0 and 5</b>.<br>
   * @param newIndex The index of the position of the new player. <b>Must be between 0 and 3</b>.<br>
   */
   public void hire(String[] employeeInfo, int newNumber, int newGoals, double newAverageRating, int newIndex) {
     Player newPlayer = new Player(employeeInfo[0], employeeInfo[1], Integer.parseInt(employeeInfo[2]), newNumber, newGoals, newAverageRating, newIndex);
     employees.add(newPlayer);
   }

   /**
    * Adds a main trainer to the employees, a.k.a hires them.<br>
    * <b>Pre: </b><br>
    * <b>Post: </b>The main trainer is hired.<br>
    * @param employeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
    * @param newTrainerInfo The specific information of the main trainer. <b>Must not be null</b>.<br>
    */
  public void hire(String[] employeeInfo, int[] newTrainerInfo) {
    MainTrainer newMainTrainer = new MainTrainer(employeeInfo[0], employeeInfo[1], Integer.parseInt(employeeInfo[2]), newTrainerInfo[0], newTrainerInfo[1], newTrainerInfo[2]);
    employees.add(newMainTrainer);
  }

  /**
   * Adds a assisting trainer to the employees, a.k.a hires them.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The assisting trainer is hired.<br>
   * @param employeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param newXpyears The years of experience of the trainer. <b>Must be positive</b>.<br>
   * @param newProffessional Whether the assisting trainer has or not beeen a proffessional player. <b>Data type restrictions</b>.<br>
   * @param newExpertises The expertises the trainer has. <b>Must not be null</b>.<br>
   */
  public void hire(String[] employeeInfo, int newXpyears, boolean newProffessional, ArrayList<Integer> newExpertises) {
   AssistingTrainer newAssistingTrainer = new AssistingTrainer(employeeInfo[0], employeeInfo[1], Integer.parseInt(employeeInfo[2]), newXpyears, newProffessional, newExpertises);
   employees.add(newAssistingTrainer);
  }


  /**
   * Looks for every instance of the employee, then removes it.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>Every instance of the employee is removed.<br>
   * @param removeIndex The index of the employee to be removed.<br>
   */
  public void fire(int removeIndex) throws IllegalArgumentException {
    Employee remove = employees.get(removeIndex);
    if (remove instanceof Player) {
      if (getTeamA().contains((Player)remove)) getTeamA().getRoster().remove((Player)remove);
      else if (getTeamB().contains((Player)remove)) getTeamB().getRoster().remove((Player)remove);

      if (roomA.contains((Player)remove)) roomA.playerOut((Player)remove);
      else if (roomB.contains((Player)remove)) roomB.playerOut((Player)remove);
    } else if (remove instanceof MainTrainer) {
      if (getTeamA().getCoach().getKey().equals(((MainTrainer)remove).getKey())) getTeamA().setCoach(null);
      else if (getTeamB().getCoach().getKey().equals(((MainTrainer)remove).getKey())) getTeamB().setCoach(null);

      if (office.contains((Trainer)remove)) office.trainerOut((Trainer)remove);
    } else if (remove instanceof AssistingTrainer) {
      if (getTeamA().contains((AssistingTrainer)remove)) getTeamA().getAssistants().remove((AssistingTrainer)remove);
      else if (getTeamB().contains((AssistingTrainer)remove)) getTeamB().getAssistants().remove((AssistingTrainer)remove);

      if (office.contains((Trainer)remove)) office.trainerOut((Trainer)remove);
    } else throw new IllegalArgumentException("El tipo ingresado no es valido: " + remove.getClass());
    employees.remove(remove);
  }

  /**
   * Allows the edition of the players information.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The players information is edited.<br>
   * @param editedEmployeeIndex The index of the employee that is being edited.<br>
   * @param newEmployeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param newNumber The number of the new player. <b>Must be a positive integer</b>.<br>
   * @param newGoals The number of goals of the new player. <b>Must be a positive integer</b>.<br>
   * @param newAverageRating The average rating of the new player. <b>Must be between 0 and 5</b>.<br>
   * @param newIndex The index of the position of the new player. <b>Must be between 0 and 3</b>.<br>
   */
  public void edit(int editedEmployeeIndex, String[] newEmployeeInfo, int newNumber, int newGoals, double newAverageRating, int newIndex) {
    int index = 0;
    for (Employee e : employees) {
      if (index == editedEmployeeIndex) {
        boolean wasInTeamA = false;
        boolean wasInTeamB = false;
        boolean wasInRoomA = false;
        boolean wasInRoomB = false;

        if (getTeamA().contains((Player)e)) {
          getTeamA().getRoster().remove((Player)e);
          wasInTeamA = true;
        }
        else if (getTeamB().contains((Player)e)) {
          getTeamB().getRoster().remove((Player)e);
          wasInTeamB = true;
        }

        if (roomA.contains((Player)e)) {
          roomA.playerOut((Player)e);
          wasInRoomA = true;
        }
        else if (roomB.contains((Player)e)) {
          roomB.playerOut((Player)e);
          wasInRoomB = true;
        }

        e.setName(newEmployeeInfo[0]);
        e.setId(newEmployeeInfo[1]);
        e.setSalary(Integer.parseInt(newEmployeeInfo[2]));
        ((Player)e).setNumber(newNumber);
        ((Player)e).setGoals(newGoals);
        ((Player)e).setAverageRating(newAverageRating);
        ((Player)e).setPosition(newIndex);

        if (wasInTeamA) teamA.addPlayer((Player)e);
        else if (wasInTeamB) teamB.addPlayer((Player)e);
        if (wasInRoomA) roomA.playerIn((Player)e);
        else if (wasInRoomB) roomB.playerIn((Player)e);
        break;
      }
      index++;
    }
  }

  /**
   * Allows the edition of the main trainers information.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The main trainers information is edited.<br>
   * @param editedEmployeeIndex The index of the employee that is being edited.<br>
   * @param newEmployeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param newTrainerInfo The specific information of the main trainer. <b>Must not be null</b>.<br>
   */
  public void edit(int editedEmployeeIndex, String[] newEmployeeInfo, int[] newTrainerInfo) {
    int index = 0;
    for (Employee e : employees) {
      if (index == editedEmployeeIndex) {
        boolean wasInTeamA = false;
        boolean wasInTeamB = false;
        boolean wasInOffice = false;

        if (getTeamA().getCoach().getKey().equals(e.getKey())) {
          getTeamA().setCoach(null);
          wasInTeamA = true;
        }
        else if (getTeamB().getCoach().getKey().equals(e.getKey())) {
          getTeamB().setCoach(null);
          wasInTeamB = true;
        }

        if (office.contains((Trainer)e)) {
          office.trainerOut((Trainer)e);
          wasInOffice = true;
        }

        e.setName(newEmployeeInfo[0]);
        e.setId(newEmployeeInfo[1]);
        e.setSalary(Integer.parseInt(newEmployeeInfo[2]));
        ((MainTrainer)e).setXpYears(newTrainerInfo[0]);
        ((MainTrainer)e).setNumberOfTeams(newTrainerInfo[1]);
        ((MainTrainer)e).setWonMatches(newTrainerInfo[2]);

        if (wasInTeamA) teamA.setCoach((MainTrainer)e);
        else if (wasInTeamB) teamB.setCoach((MainTrainer)e);
        if (wasInOffice) office.trainerIn((Trainer)e);
        break;
      }
      index++;
    }
  }

  /**
   * Allows the edition of the assisting trainers information.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The assisting trainers information is edited.<br>
   * @param editedEmployeeIndex The index of the employee that is being edited.<br>
   * @param newEmployeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param newXpyears The years of experience of the trainer. <b>Must be positive</b>.<br>
   * @param newProffessional Whether the assisting trainer has or not beeen a proffessional player. <b>Data type restrictions</b>.<br>
   * @param newExpertises The expertises the trainer has. <b>Must not be null</b>.<br>
   */
  public void edit(int editedEmployeeIndex, String[] newEmployeeInfo, int newXpyears, boolean newProffessional, ArrayList<Integer> newExpertises) {
    int index = 0;
    for (Employee e : employees) {
      if (index == editedEmployeeIndex) {
        boolean wasInTeamA = false;
        boolean wasInTeamB = false;
        boolean wasInOffice = false;

        if (getTeamA().getCoach().getKey().equals(e.getKey())) {
          getTeamA().setCoach(null);
          wasInTeamA = true;
        }
        else if (getTeamB().getCoach().getKey().equals(e.getKey())) {
          getTeamB().setCoach(null);
          wasInTeamB = true;
        }

        if (office.contains((Trainer)e)) {
          office.trainerOut((Trainer)e);
          wasInOffice = true;
        }

        e.setName(newEmployeeInfo[0]);
        e.setId(newEmployeeInfo[1]);
        e.setSalary(Integer.parseInt(newEmployeeInfo[2]));
        ((AssistingTrainer)e).setXpYears(newXpyears);
        ((AssistingTrainer)e).setProffessional(newProffessional);
        ((AssistingTrainer)e).setExpertises(newExpertises);

        if (wasInTeamA) teamA.setCoach((MainTrainer)e);
        else if (wasInTeamB) teamB.setCoach((MainTrainer)e);
        if (wasInOffice) office.trainerIn((Trainer)e);
        break;
      }
      index++;
    }
  }

  /**
   * Adds a player to a room.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is added to a room.<br>
   * @param playerName The name of the player to be added.<br>
   */
  public String addToRoom(String playerName) {
    String opMsg = "";
    boolean breaks = false;
    for (Employee e: employees) {
      if (e.getName().equalsIgnoreCase(playerName)) {
        if (e.getTeam().equalsIgnoreCase(teamA.getTeamName())) {
          opMsg = (roomA.playerIn((Player)e)) ? "**El jugador ha sido agregado: " + roomA.contains((Player)e) : "**El jugador no pudo ser agregado: " + roomA.contains((Player)e);
        }
        else if (e.getTeam().equalsIgnoreCase(teamB.getTeamName())) {
          opMsg = (roomB.playerIn((Player)e)) ? "**El jugador ha sido agregado: " + roomB.contains((Player)e) : "**El jugador no pudo ser agregado: " + roomB.contains((Player)e);
        }
        breaks = true;
      }
      if (breaks) continue;
    }
    if (!breaks) opMsg = "*El jugador ingresado no fue reconocido";
    return opMsg;
  }

  /**
   * Removes a player from a room.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is removed from a room.<br>
   * @param playerName The name of the player to be added.<br>
   */
  public String removeFromRoom(String playerName) {
    String opMsg = "";
    boolean breaks = false;
    for (Employee e: employees) {
      if (e.getName().equalsIgnoreCase(playerName)) {
        if (e.getTeam().equalsIgnoreCase(teamA.getTeamName())) {
          opMsg = (roomA.playerOut((Player)e)) ? "**El jugador ha sido removido: " + roomA.contains((Player)e): "**El jugador no pudo ser removido: " + roomA.contains((Player)e);
        }
        else if (e.getTeam().equalsIgnoreCase(teamB.getTeamName())) {
          opMsg = (roomB.playerOut((Player)e)) ? "**El jugador ha sido removido: " + roomB.contains((Player)e): "**El jugador no pudo ser removido: " + roomB.contains((Player)e);
        }
        breaks = true;
      }
      if (breaks) continue;
    }
    if (!breaks) opMsg = "*El jugador que se intento remover no fue reconocido";
    return opMsg;
  }

  /**
   * Returns the information of the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information of the club is shown.<br>
   */
  public ArrayList<String> showInfo() {
    ArrayList<String> info = new ArrayList<>();
    info.add("**Nombre: " + clubName);
    info.add("**NIT: " + NIT);
    info.add("**Fecha de fundacion: " + foundationDate);
    info.add("**Cantidad de empleados: " + employees.size());
    info.add("*Empleados:                                                                    *");

    for (Employee e : employees) {
      info.add(e.showInfo());
    }
    info.add("*------------------------------------------------------------------------------*");
    info.add("********************************************************************************");
    info.add("*Volver                                                                 [ENTER]*");
    info.add("********************************************************************************");

    return info;
  }

  //Getters

  /**
   * @return the clubName
   */
  public String getClubName() {
  	return clubName;
  }

  /**
   * @return the nIT
   */
  public String getNIT() {
  	return NIT;
  }

  /**
   * @return the foundationDate
   */
  public String getFoundationDate() {
  	return foundationDate;
  }

  /**
   * @return the teamA
   */
  public Team getTeamA() {
  	return teamA;
  }

  /**
   * @return the teamB
   */
  public Team getTeamB() {
  	return teamB;
  }

  /**
   * @return the employees
   */
  public ArrayList<Employee> getEmployees() {
  	return employees;
  }

  /**
   * @return the roomA
   */
  public Room getRoomA() {
  	return roomA;
  }

  /**
   * @return the roomB
   */
  public Room getRoomB() {
  	return roomB;
  }

  //Setters

  /**
   * @param clubName the clubName to set
   */
  public void setClubName(String clubName) {
  	this.clubName = clubName;
  }

  /**
   * @param nIT the nIT to set
   */
  public void setNIT(String nIT) {
  	NIT = nIT;
  }

  /**
   * @param foundationDate the foundationDate to set
   */
  public void setFoundationDate(String foundationDate) {
  	this.foundationDate = foundationDate;
  }
}
