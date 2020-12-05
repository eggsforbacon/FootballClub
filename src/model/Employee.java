package model;
import java.util.*;

/**
 * Class that generalizes over employees' traits and behavior.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
abstract public class Employee {
  private String name;
  private String id;
  private int salary;
  private boolean status;
  private String key;
  private String team;

  /**
   * @param name The name of the employee. <b>Must be unique, and not empty or null</b>.<br>
   * @param id The id of the employee. <b>Must be unique, and not empty or null</b>.<br>
   * @param salary The salary of the employee. <b>Must be positive</b>.<br>
   */
  public Employee(String name, String id, int salary) {
      this.name = name;
      this.id = id;
      this.salary = salary;
      team = "Ninguno";
      status = false;
      key = "k-";
      genKey();
  }

  /**
   * Returns the information of the employee, according to the type of employee.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information of the employee is returned.<br>
   */
  public abstract String showInfo();

  /**
   * Generates a unique key for every employee.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The key is generated.<br>
   */
  private void genKey() {
    Random ran = new Random();
    String[] dictionary = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
    for (int i = 0; i < 5; i++) {
      key += dictionary[ran.nextInt(26)];
    }
  }

  /**
   * Makes the status legible.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The status is made legible.<br>
   */
   public String legibleStatus() {
    return (getStatus()) ? "Activo" : "Inactivo";
   }

  //Getters

  /**
   * @return the name
   */
  public String getName() {
  	return name;
  }

  /**
   * @return the id
   */
  public String getId() {
  	return id;
  }

  /**
   * @return the salary
   */
  public int getSalary() {
  	return salary;
  }

  /**
   * @return the status
   */
  public boolean getStatus() {
    return status;
  }

  /**
   * @return the key
   */
  public String getKey() {
  	return key;
  }

  /**
   * @return the team
   */
  public String getTeam() {
    return team;
  }

  //Setters

  /**
   * @param name the name to set
   */
  public void setName(String name) {
  	this.name = name;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
  	this.id = id;
  }

  /**
   * @param salary the salary to set
   */
  public void setSalary(int salary) {
  	this.salary = salary;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(boolean status) {
  	this.status = status;
  }

  /**
   * @param team the team to set
   */
  public void setTeam(String team) {
  	this.team = team;
  }
}
