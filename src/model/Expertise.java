package model;

public enum Expertise {
    
OFFENSIVE("Ofensivo",0), DEFFENSIVE("Defensivo",1), POSSESIVE("Posesion",2), LAB("Jugadas de Laboratorio",3);

  private final String name;
  private final int position;

  private Expertise(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

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
