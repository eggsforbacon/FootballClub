package model;

/**
 * Class that defines how an office space should behave.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class Office {

  private Trainer[][] spaces;
  private String name;

  /**
   * @param name The name of the office space.<br>
   * @param col The amount of columns with which the office space will be created.<br>
   * @param row The amount of rows with which the office space will be created.<br>
   */
  public Office(String name, int col, int row) {
    this.name = name;
    spaces = new Trainer[col][row];
  }

  /**
   * Allows a trainer to be allocated inside of the office.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The trainer is allocated inside of the office.<br>
   * @param trainer The trainer to be allowed in. <b>Must not be null</b>.<br>
   */
  public boolean trainerIn(Trainer trainer) {
    boolean added = (!contains(trainer)) ? add(trainer) : false;
    return added;
  }

  /**
   * Allows a trainer to exit the office.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The trainer exits the office.<br>
   * @param trainer The trainer to be let out. <b>Must not be null</b>.<br>
   */
  public boolean trainerOut(Trainer trainer) {
    boolean removed = (contains(trainer)) ? remove(trainer) : false;
    return removed;
  }

  /**
   * Adds a trainer to the matrix containing all the trainers present in the offices.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The trainer is added to the matrix.<br>
   * @param trainer The trainer to be added. <b>Must not be null</b>.<br>
   */
  private boolean add(Trainer trainer) {
    boolean flag = false;
    for (int i = 0; i < spaces.length && !flag; i++) {
      int j = (i % 2 == 0) ? 0 : 1;
      for (; j < spaces[0].length; j += 2) {
        if (spaces[i][j] == null) {
          spaces[i][j] = trainer;
          flag = true;
          break;
        }
      }
    }
    return flag;
  }

  /**
   * Removes a trainer from the matrix containing all the trainers present in the offices.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The trainer is removed from the matrix.<br>
   * @param trainer The trainer to be removed. <b>Must not be null</b>.<br>
   */
  private boolean remove(Trainer trainer) {
    boolean flag = false;
    for (int i = 0; i < spaces.length && !flag; i++) {
      for (int j = 0; j < spaces[0].length; j++) {
        if (spaces[i][j].getKey().equals(trainer.getKey())) {
          spaces[i][j] = null;
          flag = true;
          break;
        }
      }
    }
    return flag;
  }

  /**
   * Checks wether the trainer is inside of the matrix.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The fact whether the trainer is inside the matrix or not is stated.<br>
   * @param trainer The trainer to be looked up. <b>Must not be null</b>.<br>
   */
  public boolean contains(Trainer trainer) {
    boolean flag = false;

    for (int i = 0; i < spaces.length; i++) {
      for (int j = 0; j < spaces[0].length; j++) {
        if (spaces[i][j].getKey().equals(trainer.getKey())) {
          flag = true;
          break;
        }
      }
    }

    return flag;
  }

  //Getters

  /**
   * @return the spaces
   */
  public Trainer[][] getSpaces() {
  	return spaces;
  }

  /**
   * @return the name
   */
  public String getName() {
  	return name;
  }
}
