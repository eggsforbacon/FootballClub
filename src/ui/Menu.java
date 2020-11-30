package ui;
import model.*;
import java.util.*;

/**
 *Class
 *
 */
public class Menu {

  private int answer = 0;
  private boolean first = false;
  private Club iDontKnowSoccer;

  private final int CLUB_DATA = 1;
  private final int MODIFY_CLUB = 2;
  private final int SEE_TEAMS = 3;
  private final int HIRE = 4;
  private final int FIRE = 5;
  private boolean exit = false;

  public void startprogram() {
    Scanner in = new Scanner(System.in);

    if (!first) {
      clear();
      first = true;
      createClub(in);
    }

    do {
      showMainMenu(in);
    } while (!exit);
    clear();
  }

  private void createClub(Scanner in) {
    System.out.println("********************************************************************************");
    System.out.println("*Ingrese el nombre del club:                                                   *");
    String newClubName = in.nextLine();
    System.out.println("*Ingrese el NIT del club:                                                      *");
    String newClubNIT = in.nextLine();
    System.out.println("*Ingrese la fecha de fundacion (DD/MM/AAAA):                                   *");
    String newFoundationDate = in.nextLine();
    iDontKnowSoccer = new Club(newClubName,newClubNIT,newFoundationDate);
    System.out.println("********************************************************************************");
    System.out.println("***********************************Club creado**********************************");
    wait(1000);
  }

  private void showMainMenu(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("********************************************************************************");
    System.out.println("*Ver datos del club:                                                        [1]*");
    System.out.println("*Modificar datos del club                                                   [2]*");
    System.out.println("*Ver equipos                                                                [3]*");
    System.out.println("*Contratar empleado                                                         [4]*");
    System.out.println("*Despedir empleado                                                          [5]*");
    System.out.println("********************************************************************************");
    System.out.println("*Salir                                                                      [0]*");
    System.out.println("********************************************************************************");
    answer = in.nextInt();
    in.nextLine();
    switchMainMenu(in);
  }

  private void switchMainMenu(Scanner in) throws IllegalStateException {
    switch (answer) {
      case CLUB_DATA:
        readClubData(in);
        break;
      case MODIFY_CLUB:
        readModifyClub(in);
        break;
      case SEE_TEAMS:
        break;
      case HIRE:
        break;
      case FIRE:
        break;
      case 0:
        exit = true;
        break;
      default:
        throw new IllegalStateException("Valor no reconocido: " + answer);
    }
  }

  private void readClubData(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    for (int i = 0; i < iDontKnowSoccer.showInfo().size(); i++) {
      System.out.println(iDontKnowSoccer.showInfo().get(i));
    }
    System.out.println();
    in.nextLine();
  }

  private void readModifyClub(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar el nombre del club? [y/n]                                     *");
    String string = (in.nextLine().equalsIgnoreCase("y")) ? in.nextLine() : iDontKnowSoccer.getClubName();
    iDontKnowSoccer.setClubName(string);
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar el NIT del club? [y/n]                                        *");
    string = (in.nextLine().equalsIgnoreCase("y")) ? in.nextLine() : iDontKnowSoccer.getNIT();
    iDontKnowSoccer.setNIT(string);
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar la fecha de fundacion del club? [y/n]                         *");
    string = (in.nextLine().equalsIgnoreCase("y")) ? in.nextLine() : iDontKnowSoccer.getFoundationDate();
    iDontKnowSoccer.setFoundationDate(string);

    System.out.println("********************************************************************************");
    System.out.println("************************Datos modificados correctamente*************************");
    wait(1000);
  }

  private void clear() {
    try {
      final String OS = System.getProperty("os.name");

      if (OS.contains("Windows")) {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      }

      else {
        Runtime.getRuntime().exec("clear");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static void wait(int millis) {
    try {
      Thread.sleep(millis);
    }catch (Exception e) {
      System.out.println(e);
    }
  }
}
