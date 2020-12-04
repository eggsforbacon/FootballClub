package model;

/**
 * Enum containing every position possible in the app.<br>
 * @author Samuel Hernandez <br>
 * @since 0.3.<br>
 */
public enum FieldPosition {
  GOALKEEPER("Portero",0), DEFENDER("Defensor",1), MIDFIELD("Volante",2), FORWARD("Delantero",3);

  private final String name;
  private final int position;

  /**
   * @param name The name of the tag.<br>
   * @param position The index of the tag.<br>
   */
  private FieldPosition(String name, int position) {
    this.name = name;
    this.position = position;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the position
   */
  public int getPosition() {
    return position;
  }

  /**
   * Returns the tag according to the index.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The tag is returned.<br>
   * @param index The index of the tag to be returned. <b>Must be between 0 and 3</b>.<br>
   */
  public static FieldPosition get(int index) throws IllegalStateException {
    switch (index) {
      case 0:
        return GOALKEEPER;
      case 1:
        return DEFENDER;
      case 2:
        return MIDFIELD;
      case 3:
        return FORWARD;
      default:
        throw new IllegalStateException("Valor invalido: " + index);
    }
  }
}
