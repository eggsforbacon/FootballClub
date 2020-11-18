package model;

public enum Technique {
  POSSESION("Posesion",0), COUNTER("Contraataque",1), HIGH("Presion alta",2), DEFAULT("Por defecto",3);

  private final String name;
  private final int position;

  private Technique(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

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
