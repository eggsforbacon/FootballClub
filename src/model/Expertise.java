package model;

/**
 * Enum containing every expertise possible in the app.<br>
 * @author Samuel Hernandez <br>
 * @since 0.3.<br>
 */
public enum Expertise {
  OFFENSIVE("Ofensivo",0), DEFFENSIVE("Defensivo",1), POSSESIVE("Posesion",2), LAB("Jugadas de Laboratorio",3);

  private final String name;
  private final int position;

  /**
   * @param name The name of the tag.<br>
   * @param position The index of the tag.<br>
   */
  private Expertise(String name, int position) {
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
  public static Expertise get(int index) throws IllegalStateException {
    switch (index) {
      case 0:
        return OFFENSIVE;
      case 1:
        return DEFFENSIVE;
      case 2:
        return POSSESIVE;
      case 3:
        return LAB;
      default:
        throw new IllegalStateException("Valor invalido: " + index);
    }
  }
}
