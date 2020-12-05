package model;

/**
 * Generalizes over trainers' traits and behavior.<br>
 * @author Samuel Hernandez <br>
 * @since 0.3.<br>
 */
public abstract  class Trainer extends Employee {
  private int xpYears;

  /**
   * @see Employee#Employee(String, String, int) Employee Constructor.<br>
   * @param xpYears The years of experience of the trainer. <b>Must be positive</b>.<br>
   */
  public Trainer(String name, String id, int salary, int xpYears) {
    super(name,id,salary);
    this.xpYears = xpYears;
  }

  //Getters

  /**
   * @return the xpYears
   */
  public int getXPYears() {
  	return xpYears;
  }

  //Setters

  /**
   * @param xpYears the xpYears to set
   */
  public void setXpYears(int xpYears) {
  	this.xpYears = xpYears;
  }
}
