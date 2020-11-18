package ui;
import model.*;
import java.util.*;

public class Menu {


  public void startprogram() {
    Scanner in = new Scanner(System.in);
    Alignment a = new Alignment();
    System.out.println("ingresar formacion: ");
    String s = in.nextLine();
    String[] sArr = s.split("-");
    int[] i = new int[sArr.length];
    for (int j = 0; j < i.length; j++) {
      i[j] = Integer.parseInt(sArr[j]);
    }
    a.setSetting(i);
    System.out.println("La formacion es: " + a.revert());
  }
}
