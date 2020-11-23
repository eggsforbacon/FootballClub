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
}
