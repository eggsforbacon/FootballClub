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

}
