package model;
import java.util.*;

public class Alignment {

  private String date;
  private String technique;
  private boolean[][] setting;

  public Alignment() {
    setting = new boolean[][] {
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false}
    };
  }

  public Alignment(String date, int index) {
    this.date = date;
    technique = Technique.get(index).getName();
    setting = new boolean[][] {
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false},
      {false,false,false,false,false,false,false}
    };
  }

  public String revert() {
    StringBuilder alignment = new StringBuilder();
    int index = 7;
    for (int i = setting.length - 1; i >= 0; i -= 3) {
      int count = 0;
      for (int j = 0; j < setting[i].length; j++) {
        if (setting[i][j]) count++;
      }
      if (count != 0) {
        alignment.append(count).append("-");
      } else index = 5;
    }
    alignment.delete(index,alignment.capacity());
    return alignment.toString();
  }

  private boolean[] set(int players) {
    boolean[] row = {false,false,false,false,false,false,false};
    int amount = players / 2; //Amount per half
    boolean center = players % 2 == 1;
    row[3] = center;
    for (int i = 1; i <= amount; i++) {
      row[3-i] = true;
      row[3+i] = true;
    }
    if (row[0] == false && row[2] == true && row[1] == false) {
      row[1] = true;
      row[5] = true;
      row[2] = false;
      row[4] = false;
    }
    return row;
  }

  //Getters

  public boolean[][] getSetting() {
    return setting;
  }

  public String getTechnique() {
    return technique;
  }

  public String getDate() {
    return date;
  }

  //Setters

  public void setSetting(int[] positions) {
    if (positions.length == 3) {
      setting[3] = set(positions[2]);
      setting[6] = set(positions[1]);
      setting[9] = set(positions[0]);
    } else if (positions.length == 4) {
      setting[0] = set(positions[3]);
      setting[3] = set(positions[2]);
      setting[6] = set(positions[1]);
      setting[9] = set(positions[0]);
    }
  }
}
