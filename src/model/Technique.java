package model;

/**
 * Enum containing every technique possible in the app.<br>
 * @author Samuel Hernandez <br>
 * @since 0.2.<br>
 */
public enum Technique {
  POSSESION("Posesion",0), COUNTER("Contraataque",1), HIGH("Presion alta",2), DEFAULT("Por defecto",3);

  private final String name;
  private final int position;

  /**
   * @param name The name of the tag.<br>
   * @param position The index of the tag.<br>
   */
  private Technique(String name, int position) {
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
  public static Technique get(int index) throws IllegalStateException {
    switch (index) {
      case 0:
        return POSSESION;
      case 1:
        return COUNTER;
      case 2:
        return HIGH;
      case 3:
        return DEFAULT;
      default:
        throw new IllegalStateException("Valor invalido: " + index);
    }
  }
}
