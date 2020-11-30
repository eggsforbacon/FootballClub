package model;

public class Room {

  private Player[][] spaces;
  private String name;
  private String team;

  public Room(String name, int col, int row, String team) {
    this.name = name;
    spaces = new Player[col][row];
    this.team = team;
  }

  public Player[][] getSpaces() {
    return spaces;
  }

  public String getName() {
    return name;
  }

  public String getTeam() {
    return team;
  }

  public boolean playerIn(Player player) {
    boolean added = (player.getTeam().equals(team) && !contains(player)) ? add(player) : false;
    return added;
  }

  public boolean playerOut(Player player) {
    boolean removed = (contains(player)) ? remove(player) : false;
    return removed;
  }

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
}
