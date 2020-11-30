package model;

public class Office {

  private Trainer[][] spaces;
  private String name;

  public Office(String name, int col, int row) {
    this.name = name;
    spaces = new Trainer[col][row];
  }

  public Trainer[][] getSpaces() {
    return spaces;
  }

  public String getName() {
    return name;
  }

  public boolean trainerIn(Trainer trainer) {
    boolean added = (!contains(trainer)) ? add(trainer) : false;
    return added;
  }

  public boolean trainerOut(Trainer trainer) {
    boolean removed = (contains(trainer)) ? remove(trainer) : false;
    return removed;
  }

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

  private boolean remove(Trainer trainer) {
    boolean flag = false;

    for (int i = 0; i < spaces.length && !flag; i++) {
      for (int j = 0; j < spaces[0].length; j++) {
        if (spaces[i][j].getName().equals(trainer.getName())) {
          spaces[i][j] = null;
          flag = true;
          break;
        }
      }
    }

    return flag;
  }

  private boolean contains(Trainer trainer) {
    boolean flag = false;

    for (int i = 0; i < spaces.length; i++) {
      for (int j = 0; j < spaces[0].length; j++) {
        if (spaces[i][j].getName().equals(trainer.getName())) {
          flag = true;
          break;
        }
      }
    }

    return flag;
  }
}
