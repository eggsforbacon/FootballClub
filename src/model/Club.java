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

}
