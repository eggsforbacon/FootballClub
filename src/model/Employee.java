package model;

abstract public class Employee {
  String name;
  String id;
  int salary;
  boolean status;

  public Employee(String name, String id, int salary, boolean status) {
      this.name = name;
      this.id = id;
      this.salary = salary;
      this.status = status;
  }

  //Getters

  public String getName() {
    return name;
  }

  public String getID() {
    return id;
  }

  public int getSalary() {
    return salary;
  }

  public boolean getStatus() {
    return status;
  }
}
