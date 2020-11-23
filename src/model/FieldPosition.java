package model;

public enum FieldPosition {
  GOALKEEPER("Portero",0), DEFENDER("Defensor",1), MIDFIELD("Volante",2), FORWARD("Delantero",3);

  private final String name;
  private final int position;

  private FieldPosition(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

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
