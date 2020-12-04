package model;
import java.util.*;

/**
 * A class containing the alignments and their behavior.<br>
 * @author Samuel Hernandez <br>
 * @since 0.2.<br>
 */
public class Alignment {

  private String date;
  private String technique;
  private boolean[][] setting;
  private final int COLS = 7;
  private final int ROWS = 10;

  /**
   * @param date The date the alignment was added. <b>Must not be empty or null</b>.<br>
   * @param index The index of the technique of the alignment. <b>Must be a positive between 0 and 3</b>.<br>
   * @param stringSetting The string containng the alignment. <b>Must be unique, and not empty or null</b>.<br>
   */
  public Alignment(String date, int index, String stringSetting) {
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
    setSetting(stringSetting);
  }

  /**
   * Reverts the setting matrix to a more legible string.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The matrix is reverted to a string.<br>
   */
  public String revert() {
    StringBuilder alignment = new StringBuilder();
    ArrayList<String> settingRows = new ArrayList<>();
    for (int i = (ROWS - 1); i >= 0; i--) {
      int count = 0;
      for (int j = 0; j < COLS; j++) {
        if (setting[i][j] == true) count++;
      }
      if (count != 0) settingRows.add("" + count);
    }

    for (int i = 0; i < settingRows.size() - 1; i++) {
      alignment.append(settingRows.get(i)).append("-");
    }
    int edgecase = settingRows.size() - 1;
    alignment.append(settingRows.get(edgecase));
    return alignment.toString();
  }

  /**
   * Sets a row of the alignment.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The row is set.<br>
   * @param players Integer that represent the amount of players int the row. <b>Must be a positive integer lesser than 7</b>.<br>
   */
  private boolean[] set(int players) throws IllegalArgumentException {
    if (players > 7) throw new IllegalArgumentException(players + " eccede la cantidad permitida por fila");
    boolean isOdd = players % 2 == 1;
    boolean[] row = {false,false,false,false,false,false,false};
    int amount = players / 2; //Amount per half
    boolean center = isOdd;
    row[3] = center;
    for (int i = 1; i <= amount; i++) {
      row[3-i] = true;
      row[3+i] = true;
    }
    if (row[0] == false && row[2] == true && row[1] == false && row[3] == true) {
      row[1] = true;
      row[5] = true;
      row[2] = false;
      row[4] = false;
    }
    return row;
  }

  //Getters

  /**
   * @return the setting
   */
  public boolean[][] getSetting() {
  	return setting;
  }

  /**
   * @return the technique
   */
  public String getTechnique() {
  	return technique;
  }

  /**
   * @return the date
   */
  public String getDate() {
  	return date;
  }

  //Setters

  /**
   * @param stringSetting the setting to set
   */
  public void setSetting(String stringSetting) throws IllegalArgumentException, IllegalStateException {
    String[] parsing = stringSetting.split("-");
    int[] positions = new int[parsing.length];
    for (int i = 0; i < positions.length; i++) {
      positions[i] = Integer.parseInt(parsing[i]);
    }
    final int MAXIMUM_ALLOWED_PLAYERS = 10;
    final int ALIG_ROWS = positions.length;
    int attemtedPlayers = 0;
    for (int i = 0; i < ALIG_ROWS; i++) {
      attemtedPlayers += positions[i];
    }
    if (attemtedPlayers != MAXIMUM_ALLOWED_PLAYERS) throw new IllegalArgumentException("La formacion debe sumar " + MAXIMUM_ALLOWED_PLAYERS + " jugadores. Cantidad de jugadores ingresada: " + attemtedPlayers);
    switch (ALIG_ROWS) {
      case 2:
        setting[2] = set(positions[1]);
        setting[6] = set(positions[0]);
        break;
      case 3:
        setting[2] = set(positions[2]);
        setting[5] = set(positions[1]);
        setting[8] = set(positions[0]);
        break;
      case 4:
        for (int i = 0; i < ROWS; i += 3) {
          for (int j = 3; j >= 0; j--) {
            setting[i] = set(positions[j]);
          }
        }
        break;
      case 5:
        for (int i = 0; i < ROWS; i += 2) {
          for (int j = 4; j >= 0; j--) {
            setting[i] = set(positions[j]);
          }
        }
        break;
      case 6:
        setting[0] = set(positions[5]);
        setting[1] = set(positions[4]);
        setting[3] = set(positions[3]);
        setting[5] = set(positions[2]);
        setting[7] = set(positions[1]);
        setting[9] = set(positions[0]);
        break;
      case 7:
        setting[0] = set(positions[6]);
        setting[1] = set(positions[5]);
        setting[3] = set(positions[4]);
        setting[4] = set(positions[3]);
        setting[5] = set(positions[2]);
        setting[7] = set(positions[1]);
        setting[8] = set(positions[0]);
        break;
      case 8:
        setting[0] = set(positions[7]);
        setting[1] = set(positions[6]);
        setting[2] = set(positions[5]);
        setting[3] = set(positions[4]);
        setting[5] = set(positions[3]);
        setting[6] = set(positions[2]);
        setting[7] = set(positions[1]);
        setting[8] = set(positions[0]);
        break;
      case 9:
        setting[0] = set(positions[8]);
        setting[1] = set(positions[7]);
        setting[2] = set(positions[6]);
        setting[3] = set(positions[5]);
        setting[5] = set(positions[4]);
        setting[6] = set(positions[3]);
        setting[7] = set(positions[2]);
        setting[8] = set(positions[1]);
        setting[9] = set(positions[0]);
        break;
      case 10:
        for (int i = 0; i < ROWS; i++) {
          for (int j = 9; j >= 0; j--) {
            setting[i] = set(positions[j]);
          }
        }
        break;
      default:
        throw new IllegalStateException("Formato o valor invalido: " + ALIG_ROWS);
    }
  }
}
