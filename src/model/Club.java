package model;

import java.util.ArrayList;

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

  public Club(String clubName, String NIT, String foundationDate) {
    // Club initialization
    this.clubName = clubName;
    this.NIT = NIT;
    this.foundationDate = foundationDate;

    // Rooms initialization

    roomA = new Room("Camerino A", 7, 6, "Equipo A");
    roomB = new Room("Camerino B", 7, 7, "Equipo B");
    office = new Office("Oficinas", 6, 6);

    // Teams initialization

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

  public ArrayList<String> showInfo() {
    ArrayList<String> info = new ArrayList<>();
    info.add("**Nombre: " + clubName);
    info.add("**NIT: " + NIT);
    info.add("**Fecha de fundacion: " + foundationDate);
    info.add("**Cantidad de empleados: " + employees.size());
    info.add("*Empleados:                                                                    *");

    for (Employee e : employees) {
      info.add("--------------------------------------------------------------------------------");
      info.add("*Nombre del empleado: " + e.getName());
      info.add("*Tipo de empleado: " + e.getClass());
      info.add("*Estado: " + e.getStatus());
      info.add("--------------------------------------------------------------------------------");
    }
    info.add("********************************************************************************");
    info.add("*Volver                                                                 [ENTER]*");
    info.add("********************************************************************************");

    return info;
  }

}
