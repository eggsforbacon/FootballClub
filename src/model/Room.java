package model;

/**
 * Previously DressingRoom (0.1, Deprectated in 0.3.1). Defines how a dressing room should behave.<br>
 * @author Samuel Hernandez
 * @since 0.5.<br>
 */
public class Room {

  private Player[][] spaces;
  private String name;
  private String team;

  /**
   * @param name The name of the dressing room. <b>Must be unique, and not empty or null</b>.<br>
   * @param col The amount of columns with which the dressing room will be created. <b>Must be a positive integer</b>.<br>
   * @param row The amount of rows with which the dressing room will be created. <b>Must be a positive integer</b>.<br>
   * @param team The name of the team that can access the room. <b>Must be the name of an existing team</b>.<br>
   */
  public Room(String name, int col, int row, String team) {
    this.name = name;
    spaces = new Player[col][row];
    this.team = team;
  }

  /**
   * Allows a player to be allocated inside of the dressing room.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is allocated inside of the dressing room.<br>
   * @param player The player to be allowed in. <b>Must not be null</b>.<br>
   */
  public boolean playerIn(Player player) {
    boolean added = (player.getTeam().equals(team) && !contains(player)) ? add(player) : false;
    return added;
  }

  /**
   * Allows a player to exit the dressing room.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player exits the dressing room.<br>
   * @param player The player to be let out. <b>Must not be null</b>.<br>
   */
  public boolean playerOut(Player player) {
    boolean removed = (contains(player)) ? remove(player) : false;
    return removed;
  }

  /**
   * Adds a player to the matrix containing all the player present in the dressing room.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is added to the matrix.<br>
   * @param player The player to be added. <b>Must not be null</b>.<br>
   */
  private boolean add(Player player) {
    boolean flag = false;

    for (int i = 0; i < spaces.length && !flag; i++) {
      int j = (i % 2 == 0) ? 0 : 1;
      for ( ; j < spaces[0].length; j += 2) {
        if (spaces[i][j] == null) {
          spaces[i][j] = player;
          flag = true;
          break;
        }
      }
    }

    return flag;
  }

  /**
   * Removes a player from the matrix containing all the player present in the dressing room.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is removed from the matrix.<br>
   * @param player The player to be removed. <b>Must not be null</b>.<br>
   */
  private boolean remove(Player player) {
    boolean flag = false;

    for (int i = 0; i < spaces.length && !flag; i++) {
      for (int j = 0; j < spaces[0].length; j++) {
        if (spaces[i][j].getName().equals(player.getName())) {
          spaces[i][j] = null;
          flag = true;
          break;
        }
      }
    }

    return flag;
  }

  /**
   * Checks wether the player is inside of the matrix.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The fact whether the player is inside the matrix or not is stated.<br>
   * @param player The player to be looked up. <b>Must not be null</b>.<br>
   */
  private boolean contains(Player player) {
    boolean flag = false;

    for (int i = 0; i < spaces.length; i++) {
      for (int j = 0; j < spaces[0].length; j++) {
        if (spaces[i][j].getName().equals(player.getName())) {
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
  public Player[][] getSpaces() {
  	return spaces;
  }

  /**
   * @return the name
   */
  public String getName() {
  	return name;
  }

  /**
   * @return the team
   */
  public String getTeam() {
  	return team;
  }
}
