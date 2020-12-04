package ui;
import model.*;
import java.util.*;

/**
 * Class containing the program's flow algorithims.<br>
 * @author Samuel Hernandez <br>
 * @since 0.1.<br>
 */
public class Menu {

  /*************************************************************************************************
                                        FIELD DECLARATIONS
  *************************************************************************************************/

  private int answer = 0;
  private String strAnswer = "";
  private boolean proceed = strAnswer.equalsIgnoreCase("y");
  private boolean isInChangeMode = strAnswer.equalsIgnoreCase("c");
  private boolean isInRemoveMode = strAnswer.equalsIgnoreCase("r");
  private boolean isInAddMode = strAnswer.equalsIgnoreCase("a");
  private boolean skipEdition = strAnswer.equalsIgnoreCase("x");
  private boolean first = false;
  private Club iDontKnowSoccer;

  /************************************************
              MAIN MENU SELECTIONS
  ************************************************/
  private final int CLUB_DATA = 1;
  private final int MODIFY_CLUB = 2;
  private final int HIRE = 3;
  private final int FIRE = 4;
  private final int SEE_TEAMS = 5;
  private final int EDIT_TEAMS = 6;
  private final int EDIT_EMPLOYEE = 7;
  private boolean exit = false;

  /************************************************
              TEAM MENU SELECTIONS
  ************************************************/
  private final int TEAM_A = 1;
  private final int TEAM_B = 2;

  /*************************************************************************************************
                                            MAIN MEMBERS
  *************************************************************************************************/

  /**
   * Runs the program with the specified algorithm.<br>
   * <b>Pre: </b>There is a main function defined.<br>
   * <b>Post: </b>The program is ran.<br>
   */
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

  /**
   * Calls the constructor for the class {@link model.Club Club} after receiving its corresponding arguments.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The club is created.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
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

  /**
   * Diplays the main menu on screen.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The menu is displayed.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void showMainMenu(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("********************************************************************************");
    System.out.println("*Ver datos del club:                                                        [1]*");
    System.out.println("*Modificar datos del club                                                   [2]*");
    System.out.println("*Contratar empleado                                                         [3]*");
    System.out.println("*Despedir empleado                                                          [4]*");
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Ver equipos                                                                [5]*");
    System.out.println("*Editar equipos                                                             [6]*");
    System.out.println("*Editar empleado                                                            [7]*");
    System.out.println("********************************************************************************");
    System.out.println("*Salir                                                                      [0]*");
    System.out.println("********************************************************************************");
    answer = in.nextInt();
    in.nextLine();
    switchMainMenu(in);
  }

  /*************************************************************************************************
                                        SELECTION MEMBERS
  *************************************************************************************************/

  /**
   * Runs the algorithim to show the club's information on screen.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information of the club is shown.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readClubData(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    for (int i = 0; i < iDontKnowSoccer.showInfo().size(); i++) {
      System.out.println(iDontKnowSoccer.showInfo().get(i));
    }
    System.out.println();
    in.nextLine();
  }

  /**
   * Runs the algorithm to edit the club's information.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information is edited succesfully.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readModifyClub(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar el nombre del club? [y/ANYKEY]                                *");
    strAnswer = in.nextLine();
    strAnswer = (proceed) ? in.nextLine() : iDontKnowSoccer.getClubName();
    iDontKnowSoccer.setClubName(strAnswer);
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar el NIT del club? [y/ANYKEY]                                   *");
    strAnswer = in.nextLine();
    strAnswer = (proceed) ? in.nextLine() : iDontKnowSoccer.getNIT();
    iDontKnowSoccer.setNIT(strAnswer);
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar la fecha de fundacion del club? [y/ANYKEY]                    *");
    strAnswer = in.nextLine();
    strAnswer = (proceed) ? in.nextLine() : iDontKnowSoccer.getFoundationDate();
    iDontKnowSoccer.setFoundationDate(strAnswer);

    System.out.println("********************************************************************************");
    System.out.println("************************Datos modificados correctamente*************************");
    wait(1000);
  }

  /**
   * Runs the algorithm to see the club's teams' information.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The menu to select which team's information to see is displayed.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readSeeTeams(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Ver equipo A                                                               [1]*");
    System.out.println("*Ver equipo B                                                               [2]*");
    System.out.println("********************************************************************************");
    System.out.println("*Salir                                                                      [0]*");
    answer = in.nextInt();
    in.nextLine();
    switchSeeTeams(in);
  }

  /**
   * Runs the algorithm to editthe club's teams' information.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The menu to select which team to edit is displayed.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readEditTeams(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Editar equipo A                                                            [1]*");
    System.out.println("*Editar equipo B                                                            [2]*");
    System.out.println("********************************************************************************");
    System.out.println("*Salir                                                                      [0]*");
    answer = in.nextInt();
    in.nextLine();
    switchEditTeams(in);
  }

  /**
   * Runs the algorithim to edit the information of team A.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information of the team is succesfully edited.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readTeamA(Scanner in) throws IllegalStateException {
    System.out.println("*Desea modificar el nombre del equipo? [y/ANYKEY]                              *");
    strAnswer = in.nextLine();
    update();
    String newTeamName = (proceed) ? in.nextLine() : iDontKnowSoccer.getTeamA().getTeamName();
    iDontKnowSoccer.getTeamA().setTeamName(newTeamName);
    System.out.println("********************************************************************************");
    System.out.println("*Presione [a] para aniadir datos, [r] para remover, [x] para no modificar este *\n*dato y [c] para cambiar el dato                                                *");
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea cambiar o remover el entrenador principal? [c/r/x]");
    strAnswer = in.nextLine();
    update();
    if (isInChangeMode || isInRemoveMode) editCoach(in,iDontKnowSoccer.getTeamB());
    else if (!skipEdition) throw new IllegalStateException("Opcion invalida: " + strAnswer + "(" + skipEdition + ")");
    System.out.println("*Desea aniadir o remover entrenadores asistentes? [a/r/x]                      *");
    strAnswer = in.nextLine();
    update();
    if (isInAddMode || isInRemoveMode) editAssistants(in,iDontKnowSoccer.getTeamA());
    System.out.println("*Desea aniadir o remover jugadores? [a/r/x]                                    *");
    strAnswer = in.nextLine();
    update();
    if (isInAddMode || isInRemoveMode) editRoster(in,iDontKnowSoccer.getTeamA());
    System.out.println("*Desea aniadir o remover alineaciones? [a/r/x]                                 *");
    strAnswer = in.nextLine();
    update();
    if (isInAddMode || isInRemoveMode) editAlignments(in, iDontKnowSoccer.getTeamA());
    System.out.println("**********************Se ha terminado de editar el equipo***********************");

  }

  /**
   * Runs the algorithim to edit the information of team B.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information of the team is succesfully edited.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readTeamB(Scanner in) throws IllegalStateException {
    System.out.println("*Desea modificar el nombre del equipo? [y/ANYKEY]                              *");
    strAnswer = in.nextLine();
    update();
    String newTeamName = (proceed) ? in.nextLine() : iDontKnowSoccer.getTeamB().getTeamName();
    iDontKnowSoccer.getTeamB().setTeamName(newTeamName);
    System.out.println("********************************************************************************");
    System.out.println("*Presione [a] para aniadir datos, [r] para remover, [x] para no modificar este *\n*dato y [c] para cambiar el dato                                                *");
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea cambiar o remover el entrenador principal? [c/r/x]");
    strAnswer = in.nextLine();
    update();
    if (isInChangeMode || isInRemoveMode) editCoach(in,iDontKnowSoccer.getTeamB());
    else if (!skipEdition) throw new IllegalStateException("Opcion invalida: " + strAnswer + "(" + skipEdition + ")");
    System.out.println("*Desea aniadir o remover entrenadores asistentes? [a/r/x]                      *");
    strAnswer = in.nextLine();
    update();
    if (isInAddMode || isInRemoveMode) editAssistants(in,iDontKnowSoccer.getTeamB());
    System.out.println("*Desea aniadir o remover jugadores? [a/r/x]                                    *");
    strAnswer = in.nextLine();
    update();
    if (isInAddMode || isInRemoveMode) editRoster(in,iDontKnowSoccer.getTeamB());
    System.out.println("*Desea aniadir o remover alineaciones? [a/r/x]                                 *");
    strAnswer = in.nextLine();
    update();
    if (isInAddMode || isInRemoveMode) editAlignments(in, iDontKnowSoccer.getTeamB());
    System.out.println("**********************Se ha terminado de editar el equipo***********************");

  }

  /**
   * Runs the algorithm to edit the coach of a team specifically.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The coach of the specified team is changed.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param team The specified team. <b>Must not be null</b>.<br>
   */
  private void editCoach(Scanner in, Team team) {
    team.getCoach().setStatus(false);
    if (isInChangeMode) {
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Seleccione el nuevo entrenador principal escribiendo su nombre:               *");
      for (Employee e : iDontKnowSoccer.getEmployees()) {
        if (e instanceof MainTrainer) System.out.println("**" + e.getName());
      }
      String theChanged = in.nextLine();
      for (Employee e : iDontKnowSoccer.getEmployees()) {
        if (e instanceof MainTrainer && e.getName().equalsIgnoreCase(theChanged)) {
          team.setCoach((MainTrainer)e);
          e.setStatus(true);
          break;
        }
      }
    } else {
      System.out.println("*El entrenador principal sera removido                                         *");
      team.setCoach(null);
      wait(1000);
    }

  }

  /**
   * Runs the algorithm to edit the assisting trainers of a team specifically.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The assisting trainers are edited for the specified team.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param team The specified team. <b>Must not be null</b>.<br>
   */
  private void editAssistants(Scanner in, Team team) {
    final int LIMIT_OF_ASSISTANTS = 3;
    int assistantsTreshold = LIMIT_OF_ASSISTANTS - team.getAssistants().size();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Seleccione el entrenador que desea remover o aniadir escribiendo su nombre:   *");
    for (Employee e : iDontKnowSoccer.getEmployees()) {
      if (e instanceof AssistingTrainer) System.out.println("**" + e.getName());;
    }
    while (assistantsTreshold >= 0) {
      if (assistantsTreshold == 0 && isInAddMode) {
        System.out.println("*El numero maximo de asistentes por equipo se ha alcanzado                     *");
        wait(1000);
        break;
      }
      if (isInAddMode) {
        String theAdded = in.nextLine();
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof AssistingTrainer && e.getName().equalsIgnoreCase(theAdded)) {
            if (team.addAssistingTrainers((AssistingTrainer)e)) e.setStatus(true);
            else {
              System.out.println("*El entrenador ya se encuentra en el equipo                                    *");
              e.setStatus(false);
              wait(1000);
            }
            break;
          }
        }
      } else {
        String theDeleted = in.nextLine();
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof AssistingTrainer && e.getName().equalsIgnoreCase(theDeleted)) {
            if (team.contains((AssistingTrainer)e)) {
              e.setStatus(false);
              team.getAssistants().remove(e);
            }
            else {
              System.out.println("*El entrenador no se encuentra en el equipo                                    *");
              e.setStatus(true);
              wait(1000);
            }
            break;
          }
        }
      }
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Desea seguir editando? [y/ANYKEY]                                             *");
      strAnswer = in.nextLine();
      update();
      assistantsTreshold = LIMIT_OF_ASSISTANTS - team.getAssistants().size();
    }
  }

  /**
   * Runs the algorithm to edit the roster (players) of a team specifically.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The roster is edited for the specified team.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param team The specified team. <b>Must not be null</b>.<br>
   */
  private void editRoster(Scanner in, Team team) {
    final int LIMIT_OF_PLAYERS = 25;
    int playerTreshold = LIMIT_OF_PLAYERS - team.getRoster().size();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Seleccione el jugador que desea remover o aniadir escribiendo su nombre:      *");
    for (Employee e : iDontKnowSoccer.getEmployees()) {
      if (e instanceof Player) System.out.println("**" + e.getName());;
    }
    while (playerTreshold >= 0) {
      if (playerTreshold == 0 && isInAddMode) {
        System.out.println("*El numero maximo de jugadores por equipo se ha alcanzado                      *");
        wait(1000);
        break;
      }
      if (isInAddMode) {
        String theAdded = in.nextLine();
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof Player && e.getName().equalsIgnoreCase(theAdded)) {
            if (team.addPlayer((Player)e)) e.setStatus(true);
            else {
              System.out.println("*El jugador ya se encuentra en el equipo                                       *");
              e.setStatus(false);
              wait(1000);
            }
            break;
          }
        }
      } else {
        String theDeleted = in.nextLine();
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof Player && e.getName().equalsIgnoreCase(theDeleted)) {
            if (team.contains((Player)e)) {
              e.setStatus(false);
              team.getRoster().remove(e);
            }
            else {
              System.out.println("*El jugador no se encuentra en el equipo                                       *");
              e.setStatus(true);
              wait(1000);
            }
            break;
          }
        }
      }
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Desea seguir editando? [y/ANYKEY]                                             *");
      strAnswer = in.nextLine();
      update();
      playerTreshold = LIMIT_OF_PLAYERS - team.getRoster().size();
    }
  }

  /**
   * Runs the algorithm to edit the alignments of a team specifically.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The alignments are edited for the specified team.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param team The specified team. <b>Must not be null</b>.<br>
   */
  private void editAlignments(Scanner in, Team team) throws IllegalStateException {
    if (isInAddMode) {
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Digite la fecha de la alineacion [DD/MM/AAAA]:                                *");
      String newDate = in.nextLine();
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Escoja una tecnica para la formacion:                                         *");
      int i = 1;
      for (Technique t : Technique.values()) {
        System.out.println("**[" + i + "]" + t.getName());
      i++;
      }
      int newIndex = in.nextInt() - 1;
      if ((newIndex < 0 || newIndex > 3)) throw new IllegalStateException("Respuesta invalida: " + newIndex);
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Digite la formacion (De tal manera que sume 10, por ejemplo 4-4-2, con \"-\"):  *");
      String newSetting = in.nextLine();
      team.addAlignment(newDate, newIndex, newSetting);
    } else {
      System.out.println("*--------------------------------------------------------------------------------*");
      System.out.println("*Digite el numero de alineacion que desea eliminar:                              *");
      for (int j = 0; j < team.getAlignments().size(); j++) {
        System.out.println("*[" + (j + 1) + "]" + team.getAlignments().get(j).revert());
      }
      int oldIndex = in.nextInt() - 1;
      if ((oldIndex < 0 || oldIndex > 3)) throw new IllegalStateException("Respuesta invalida: " + oldIndex);
      team.getAlignments().remove(oldIndex);
    }
  }

  /*************************************************************************************************
                                            LOGIC MEMBERS
  *************************************************************************************************/

  /**
   * A logic algorithm that decides what to run according to user input on {@link #showMainMenu(Scanner) showMainMenu}.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The program proceeds with the correct algorithm.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void switchMainMenu(Scanner in) throws IllegalStateException {
    switch (answer) {
      case CLUB_DATA:
        readClubData(in);
        break;
      case MODIFY_CLUB:
        readModifyClub(in);
        break;
      case HIRE:
        break;
      case FIRE:
        break;
      case SEE_TEAMS:
        readSeeTeams(in);
        break;
      case EDIT_TEAMS:
        readEditTeams(in);
        break;
      case EDIT_EMPLOYEE:
        break;
      case 0:
        exit = true;
        break;
      default:
        throw new IllegalStateException("Valor no reconocido: " + answer);
    }
  }

  /**
   * A logic algorithm that decides what to do according to user input on {@link #readSeeTeams(Scanner) readSeeTeams}.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The program proceeds with the correct algorithm.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void switchSeeTeams(Scanner in) throws IllegalStateException {
    clear();
    System.out.println("********************************************************************************");
    switch (answer) {
      case TEAM_A:
        for (String s : iDontKnowSoccer.getTeamA().showInfo()) {
          System.out.println(s);
        }
        break;
      case TEAM_B:
        for (String s : iDontKnowSoccer.getTeamB().showInfo()) {
          System.out.println(s);
        }
        break;
      case 0:
        break;
      default:
        throw new IllegalStateException("Valor desconocido (??????): " + answer);
    }
    in.nextLine();
  }

  /**
   * A logic algorithm that decides what to do according to user input on {@link #readEditTeams(Scanner) readEditTeams}.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The program proceeds with the correct algorithm.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void switchEditTeams(Scanner in) throws IllegalStateException {
    clear();
    System.out.println("********************************************************************************");
    switch (answer) {
      case TEAM_A:
        readTeamA(in);
        break;
      case TEAM_B:
        readTeamB(in);
        break;
      case 0:
        break;
      default:
        throw new IllegalStateException("Valor desconocido (????): " + answer);
    }
  }

  /*************************************************************************************************
                                            FORMAT MEMBERS
  *************************************************************************************************/
  /**
   * Clears the terminal.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The terminal is cleared.<br>
   */
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

  /**
   * Halts runtime for a specified ammount of milliseconds.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>Runtime is halted, and then released.<br>
   * @param millis Represents the milliseconds that runtime will be halted for. <b>Must be a positive integer</b>.<br>
   */
  private static void wait(int millis) {
    try {
      Thread.sleep(millis);
    }catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Updates the logic fields everytime there is input.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The fields are updated.<br>
   */
  private void update() {
    proceed = strAnswer.equalsIgnoreCase("y");
    isInChangeMode = strAnswer.equalsIgnoreCase("c");
    isInRemoveMode = strAnswer.equalsIgnoreCase("r");
    isInAddMode = strAnswer.equalsIgnoreCase("a");
    skipEdition = strAnswer.equalsIgnoreCase("x");
  }
}
