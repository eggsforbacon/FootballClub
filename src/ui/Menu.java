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
  private String proceedAnswer = "";
  private boolean proceed = proceedAnswer.equalsIgnoreCase("y");
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
  private final int ROOMS = 8;
  private final int OFFICES = 9;
  private boolean exit = false;

  /************************************************
              TEAM MENU SELECTIONS
  ************************************************/
  private final int TEAM_A = 1;
  private final int TEAM_B = 2;

  /************************************************
              HIRE MENU SELECTIONS
  ************************************************/
  private final int PLAYER = 1;
  private final int MAIN_TRAINER = 2;
  private final int ASSISTING_TRAINER = 3;

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
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Ingresar o remover un jugador de un camerino                               [8]*");
    System.out.println("*Ingresar o remover un entrenador de las oficinas                           [9]*");
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
    proceedAnswer = in.nextLine();
    strAnswer = (proceed) ? in.nextLine() : iDontKnowSoccer.getClubName();
    iDontKnowSoccer.setClubName(strAnswer);
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar el NIT del club? [y/ANYKEY]                                   *");
    proceedAnswer = in.nextLine();
    strAnswer = (proceed) ? in.nextLine() : iDontKnowSoccer.getNIT();
    iDontKnowSoccer.setNIT(strAnswer);
    System.out.println("********************************************************************************");
    System.out.println("*Desea modificar la fecha de fundacion del club? [y/ANYKEY]                    *");
    proceedAnswer = in.nextLine();
    strAnswer = (proceed) ? in.nextLine() : iDontKnowSoccer.getFoundationDate();
    iDontKnowSoccer.setFoundationDate(strAnswer);

    System.out.println("********************************************************************************");
    System.out.println("************************Datos modificados correctamente*************************");
    wait(1000);
  }

  /**
   * Runs the algorithm to create an employee inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The employee is created, a.k.a hired.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readHire(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Que tipo de empleado desea contratar?                                         *");
    System.out.println("*Jugador                                                                    [1]*");
    System.out.println("*Entrenador principal                                                       [2]*");
    System.out.println("*Entrenador asistente                                                       [3]*");
    System.out.println("********************************************************************************");
    System.out.println("*Volver                                                                [ANYKEY]*");
    System.out.println("********************************************************************************");
    answer = in.nextInt();
    switchHire(in);
    wait(1000);
  }

  /**
   * Runs the algorithm to create a player inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is created, a.k.a hired.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param employeeInfo A string array containing general information of the employee. <b>Must not be null</b>.<br>
   */
  private void readPlayer(Scanner in, String[] employeeInfo) {
    System.out.println("*Escriba el numero del jugador:                                                *");
    int newNumber = in.nextInt();
    boolean flag = false;
    do {
      for (Employee e : iDontKnowSoccer.getEmployees()) {
        if (e instanceof Player && (newNumber == ((Player)e).getNumber())) {
          System.out.println("*El numero ingresado ya se encuentra registrado. Intente nuevamente:           *");
          newNumber = in.nextInt();
          flag = newNumber == (((Player)e).getNumber());
          break;
        }
      }
    } while (flag);
    System.out.println("*Escriba el numero de goles anotados por el jugador:                           *");
    int newGoals = in.nextInt();
    System.out.println("*Escriba el promedio del jugador [0 - 5]:                                      *");
    double newAverage = in.nextDouble();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Seleccione la posicion del jugador:                                           *");
    for (int i = 0; i < FieldPosition.values().length; i++) {
      System.out.println("*[" + (i+1) + "] " + FieldPosition.get(i).getName());
    }
    int newIndex = in.nextInt() - 1;
    iDontKnowSoccer.hire(employeeInfo, newNumber, newGoals, newAverage, newIndex);
  }

  /**
   * Runs the algorithm to create a main trainer inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The main trainer is created, a.k.a hired.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param employeeInfo A string array containing general information of the employee. <b>Must not be null</b>.<br>
   */
  private void readMainTrainer(Scanner in, String[] employeeInfo) {
    int[] newTrainerInfo = new int[3];
     System.out.println("*Escriba los anios de experiencia del entrenador:                              *");
     newTrainerInfo[0] = in.nextInt();
     System.out.println("*Escriba el numero de equipos que el entrenador ha liderado:                   *");
     newTrainerInfo[1] = in.nextInt();
     System.out.println("*Escriba el numero de partidos que el entrenador ha ganado:                    *");
     newTrainerInfo[2] = in.nextInt();
     iDontKnowSoccer.hire(employeeInfo, newTrainerInfo);
  }

  /**
    * Runs the algorithm to create an assisting trainer inside the club.<br>
    * <b>Pre: </b><br>
    * <b>Post: </b>The assisting trainer is created, a.k.a hired.<br>
    * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
    * @param employeeInfo A string array containing general information of the employee. <b>Must not be null</b>.<br>
    */
  private void readAssistingTrainer(Scanner in, String[] employeeInfo) {
     System.out.println("*Escriba los anios de experiencia del entrenador:                              *");
     int newXpyears = in.nextInt();
     in.nextLine();
     System.out.println("*El entrenador ha sido jugador profesional? [y/ANYKEY]:                        *");
     proceedAnswer = in.nextLine();
     update();
     boolean newProffessional = (proceed) ? true : false;
     System.out.println("*------------------------------------------------------------------------------*");
     System.out.println("*Escriba las experticias del entrenador separadas por un espacio( ). Si solo   *");
     System.out.println("*posee una experticia, escriba el numero que corresponde y despues espacio:    *");
     int i = 1;
     for (Expertise e : Expertise.values()) {
       System.out.println("**[" + i + "] " + e.getName());
       i++;
     }
     String[] newExpertisesUnparsed = in.nextLine().split(" ");
     ArrayList<Integer> newExpertises = new ArrayList<>();
     for (int j = 0; j < newExpertisesUnparsed.length; j++) {
       int element = (Integer.parseInt(newExpertisesUnparsed[j]));
       newExpertises.add(element - 1);
     }
     iDontKnowSoccer.hire(employeeInfo, newXpyears, newProffessional, newExpertises);
  }

  /**
   * Runs the algorithm to remove an employee from inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The employee is removed from the club completley.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readFire(Scanner in) {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Que empleado desea remover?                                                   *");
    int i = 1;
    for (Employee e : iDontKnowSoccer.getEmployees()) {
      System.out.println("**[" + i + "] " + e.getName() + "(" + e.getType() + ", " + e.getStatus() + ")");
      i++;
    }
    int removeIndex = in.nextInt() - 1;
    in.nextLine();

    System.out.println("*Esta segurx que desea despedir a " + iDontKnowSoccer.getEmployees().get(removeIndex).getName() + "? [y/ANYKEY]");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      iDontKnowSoccer.fire(removeIndex);

      System.out.println("********************************************************************************");
      System.out.println("************************Empleado despedido correctamente************************");
    } else {
      System.out.println("********************************************************************************");
      System.out.println("***********************************Cancelado************************************");
      wait(1000);
    }
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
   * Runs the algorithm to edit the club's teams' information.<br>
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
    proceedAnswer = in.nextLine();
    update();
    String newTeamName = (proceed) ? in.nextLine() : iDontKnowSoccer.getTeamA().getTeamName();
    iDontKnowSoccer.getTeamA().setTeamName(newTeamName);
    System.out.println("********************************************************************************");
    System.out.println("*Presione [a] para aniadir datos, [r] para remover, [x] para no modificar este *\n*dato y [c] para cambiar el dato                                                *");
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea cambiar o remover el entrenador principal? [c/r/x]");
    strAnswer = in.nextLine();
    update();
    if (isInChangeMode || isInRemoveMode) editCoach(in,iDontKnowSoccer.getTeamA());
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
    proceedAnswer = in.nextLine();
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
      try {
        System.out.println("*Seleccione el nuevo entrenador principal escribiendo su nombre:               *");
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof MainTrainer) System.out.println("**" + e.getName());
        }
        String theChanged = in.nextLine();

        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof MainTrainer && e.getName().equalsIgnoreCase(theChanged)) {
            e.setStatus(true);
            e.setTeam(team.getTeamName());
            team.setCoach((MainTrainer)e);
            break;
          }
        }
      } catch(NullPointerException npe) {
        System.out.println("*No hay entrenadores principales contratados por el momento                  *");
        wait(1000);
      }

    } else {
      try {
        System.out.println("*El entrenador principal sera removido                                         *");
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof MainTrainer && e.getName().equalsIgnoreCase(team.getCoach().getName())) {
            e.setStatus(false);
            e.setTeam("Ninguno");
            team.setCoach(null);
            break;
          }
        }
      } catch(Exception e) {
        System.out.println("*El equipo no tiene un entrenador asignado por el momento                      *");
      } finally {
        wait(1000);
      }
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
    proceed = true;
    try {
      while (assistantsTreshold >= 0 && proceed) {
        if (assistantsTreshold == 0 && isInAddMode) {
          System.out.println("*El numero maximo de asistentes por equipo se ha alcanzado                     *");
          wait(1000);
          break;
        }
        if (isInAddMode) {
          String theAdded = in.nextLine();
          for (Employee e : iDontKnowSoccer.getEmployees()) {
            if (e instanceof AssistingTrainer && e.getName().equalsIgnoreCase(theAdded)) {
              if (team.addAssistingTrainers((AssistingTrainer)e)) {
                e.setStatus(true);
                e.setTeam(team.getTeamName());
              }
              else {
                System.out.println("*El entrenador ya se encuentra en el equipo                                    *");
                e.setStatus(true);
                e.setTeam(team.getTeamName());
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
                e.setTeam("Ninguno");
                team.getAssistants().remove(e);
              }
              else {
                System.out.println("*El entrenador no se encuentra en el equipo                                    *");
                wait(1000);
              }
              break;
            }
          }
        }
        System.out.println("*------------------------------------------------------------------------------*");
        System.out.println("*Desea seguir editando? [y/ANYKEY]                                             *");
        proceedAnswer = in.nextLine();
        update();
        assistantsTreshold = LIMIT_OF_ASSISTANTS - team.getAssistants().size();
      }
    } catch(Exception e) {
      System.out.println("*No hay entrenadores asistentes contratados para aniadir al equipo (la lista de  *");
      System.out.println("*empleados no contiene entrenadores asistentes) o no hay entrenadores asistentes *");
      System.out.println("*que remover (la lista de entrenadores asistentes del equipo esta vacia)         *");
      wait(3000);
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
    proceed = true;
    try {
      while (playerTreshold >= 0 && proceed) {
        if (playerTreshold == 0 && isInAddMode) {
          System.out.println("*El numero maximo de jugadores por equipo se ha alcanzado                      *");
          wait(1000);
          break;
        }
        if (isInAddMode) {
          String theAdded = in.nextLine();
          for (Employee e : iDontKnowSoccer.getEmployees()) {
            if (e instanceof Player && e.getName().equalsIgnoreCase(theAdded)) {
              if (team.addPlayer((Player)e)) {
                e.setStatus(true);
                e.setTeam(team.getTeamName());
              }
              else {
                System.out.println("*El jugador ya se encuentra en el equipo                                       *");
                e.setStatus(true);
                e.setTeam(team.getTeamName());
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
                e.setTeam("Ninguno");
                team.getRoster().remove(e);
              }
              else {
                System.out.println("*El jugador no se encuentra en el equipo                                       *");
                wait(1000);
              }
              break;
            }
          }
        }
        System.out.println("*------------------------------------------------------------------------------*");
        System.out.println("*Desea seguir editando? [y/ANYKEY]                                             *");
        proceedAnswer = in.nextLine();
        update();
        playerTreshold = LIMIT_OF_PLAYERS - team.getRoster().size();
      }
    } catch(Exception e) {
      System.out.println("*No hay jugadores contratados para aniadir al equipo (la lista de empleados no   *");
      System.out.println("*contiene jugadores) o no hay jugadores dentro del equipo que remover (la lista  *");
      System.out.println("*de juagdores del equipo esta vacia)                                             *");
      wait(1000);
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
      in.nextLine();
      if ((newIndex < 0 || newIndex > 3)) throw new IllegalStateException("Respuesta invalida: " + newIndex);
      System.out.println("*------------------------------------------------------------------------------*");
      System.out.println("*Digite la formacion (De tal manera que sume 10, por ejemplo 4-4-2, con \"-\"):  *");
      String newSetting = in.nextLine();
      team.addAlignment(newDate, newIndex, newSetting);
    } else {
      System.out.println("*--------------------------------------------------------------------------------*");
      try {
        System.out.println("*Digite el numero de alineacion que desea eliminar:                              *");
        for (int j = 0; j < team.getAlignments().size(); j++) {
          System.out.println("*[" + (j + 1) + "]" + team.getAlignments().get(j).revert());
        }
        int oldIndex = in.nextInt() - 1;
        if ((oldIndex < 0 || oldIndex > 3)) throw new IllegalStateException("Respuesta invalida: " + oldIndex);
        team.getAlignments().remove(oldIndex);
      } catch(Exception e) {
        System.out.println("*No hay alineaciones que remover (la lista de alineaciones del equipo esta vacia)*");
        wait(1500);
      }
    }
  }

  /**
   * Runs the algorithm to edit the information of an employee in the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The information of the employee is edited.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readEditEmployee(Scanner in) throws IllegalStateException {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Escoja el empleado que desea editar:                                          *");
    int i = 1;
    for (Employee e : iDontKnowSoccer.getEmployees()) {
      System.out.println("**[" + i + "] " + e.getName() + "(" + e.getType() + ", " + e.getStatus() + ")");
    }
    int editedEmployeeIndex = in.nextInt() - 1;
    if (editedEmployeeIndex >= i) throw new IllegalStateException("Valor no admitido. El valor maximo es " + i + ".\nEl valor ingresado fue: " + (editedEmployeeIndex + 1));
    in.nextLine();
    clear();
    System.out.println("********************************************************************************");
    String[] newEmployeeInfo = new String[3];
    System.out.println("*Desea editar el nombre del empleado? [y/ANYKEY]                               *");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      System.out.println("*Escriba el nuevo nombre del empleado:                                         *");
      newEmployeeInfo[0]  = in.nextLine();
    } else newEmployeeInfo[0] = iDontKnowSoccer.getEmployees().get(editedEmployeeIndex).getName();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar la identificacion del empleado? [y/ANYKEY]                       *");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      System.out.println("*Escriba la nueva identificacion (10 digitos) del empleado:                    *");
      newEmployeeInfo[1] = in.nextLine();
    } else newEmployeeInfo[1] = iDontKnowSoccer.getEmployees().get(editedEmployeeIndex).getId();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar el salario del empleado? [y/ANYKEY]                              *");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      System.out.println("*Escriba el nuevo salario del empleado:                                        *");
      newEmployeeInfo[2] = in.nextLine();
    } else newEmployeeInfo[2] = Integer.toString(iDontKnowSoccer.getEmployees().get(editedEmployeeIndex).getSalary());

    System.out.println("*--------------------------------------------------------------------------------*");
    if (iDontKnowSoccer.getEmployees().get(editedEmployeeIndex) instanceof Player) {
      editPlayer(in,newEmployeeInfo,editedEmployeeIndex);
    } else if (iDontKnowSoccer.getEmployees().get(editedEmployeeIndex) instanceof MainTrainer) {
      editMainTrainer(in, newEmployeeInfo, editedEmployeeIndex);
    } else if (iDontKnowSoccer.getEmployees().get(editedEmployeeIndex) instanceof AssistingTrainer) {
      editAssistingTrainer(in, newEmployeeInfo, editedEmployeeIndex);
    }

    System.out.println("********************************************************************************");
    System.out.println("**********************Se termino de editar el empleado**************************");
    wait(1000);
  }

  /**
   * Runs the algorithm to edit a player inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The player is edited.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param newEmployeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param editedEmployeeIndex The index of the employee to be edited.<br>
   */
  private void editPlayer(Scanner in, String[] newEmployeeInfo, int editedEmployeeIndex) {
    System.out.println("*Desea editar el numero del jugador? [y/ANYKEY]                                *");
    proceedAnswer= in.nextLine();
    update();
    int newNumber;
    if (proceed) {
      System.out.println("*Escriba el nuevo numero del jugador:                                          *");
      newNumber = in.nextInt();
      in.nextLine();
      boolean flag = false;
      do {
        for (Employee e : iDontKnowSoccer.getEmployees()) {
          if (e instanceof Player && (newNumber == ((Player)e).getNumber())) {
          System.out.println("*El numero ingresado ya se encuentra registrado. Intente nuevamente:           *");
          newNumber = in.nextInt();
          flag = newNumber == (((Player)e).getNumber());
          break;
          }
        }
      } while (flag);
    } else newNumber = ((Player)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getNumber();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar el numero de goles anotados por el jugador? [y/ANYKEY]           *");
    proceedAnswer = in.nextLine();
    update();
    int newGoals;
    if (proceed) {
      System.out.println("*Escriba el nuevo numero de goles anotados por el jugador:                     *");
      newGoals = in.nextInt();
      in.nextLine();
    } else newGoals = ((Player)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getGoals();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar el promedio del jugador? [y/ANYKEY]                              *");
    proceedAnswer = in.nextLine();
    update();
    double newAverage;
    if (proceed) {
      System.out.println("*Escriba el nuevo promedio del jugador [0 - 5]:                                *");
      newAverage = in.nextDouble();
      in.nextLine();
    } else newAverage = ((Player)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getAverageRating();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar la posicion del jugador? [y/ANYKEY]                              *");
    proceedAnswer = in.nextLine();
    update();
    int newIndex;
    if (proceed) {
      System.out.println("*Seleccione la nueva posicion del jugador:                                     *");
      for (int i = 0; i < FieldPosition.values().length; i++) {
        System.out.println("*[" + (i+1) + "] " + FieldPosition.get(i).getName());
      }
      newIndex = in.nextInt() - 1;
    } else newIndex = ((Player)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getPosIndex();
    iDontKnowSoccer.edit(editedEmployeeIndex, newEmployeeInfo, newNumber, newGoals, newAverage, newIndex);
  }

  /**
   * Runs the algorithm to edit a main trainer inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The main trainer is edited.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param newEmployeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param editedEmployeeIndex The index of the employee to be edited.<br>
   */
  private void editMainTrainer(Scanner in, String[] newEmployeeInfo, int editedEmployeeIndex) {
    int[] newTrainerInfo = new int[3];
    System.out.println("*Desea editar los anios de experiencia del entrenador? [y/ANYKEY]              *");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      System.out.println("*Escriba los anios de experiencia del entrenador:                              *");
      newTrainerInfo[0] = in.nextInt();
    } else newTrainerInfo[0] = ((MainTrainer)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getXPYears();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar el numero de equipos que el entrenador ha liderado? [y/ANYKEY]   *");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      System.out.println("*Escriba el numero de equipos que el entrenador ha liderado:                   *");
      newTrainerInfo[1] = in.nextInt();
    } else newTrainerInfo[1] = ((MainTrainer)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getNumberOfTeams();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea editar el numero de partidos que el entrenador ha ganado? [y/ANYKEY]    *");
    proceedAnswer = in.nextLine();
    update();
    if (proceed) {
      System.out.println("*Escriba el numero de partidos que el entrenador ha ganado:                    *");
      newTrainerInfo[2] = in.nextInt();
    } else newTrainerInfo[2] = ((MainTrainer)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getWonMatches();
    iDontKnowSoccer.edit(editedEmployeeIndex, newEmployeeInfo, newTrainerInfo);
  }

  /**
   * Runs the algorithm to edit an assisting trainer inside the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The assisting trainer is edited.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   * @param newEmployeeInfo The general information shared by all employees. <b>Must not be null or empty</b>.<br>
   * @param editedEmployeeIndex The index of the employee to be edited.<br>
   */
  private void editAssistingTrainer(Scanner in, String[] newEmployeeInfo, int editedEmployeeIndex) {
    System.out.println("*Desea editar los anios de experiencia del entrenador? [y/ANYKEY]              *");
    proceedAnswer = in.nextLine();
    update();
    int newXpyears;
    if (proceed) {
      System.out.println("*Escriba los anios de experiencia del entrenador:                              *");
      newXpyears = in.nextInt();
      in.nextLine();
    } else newXpyears = ((AssistingTrainer)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getXPYears();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea cambiar la profesionalidad del entrenador [y/ANYKEY]                    *");
    proceedAnswer = in.nextLine();
    update();
    boolean newProffessional;
    if (proceed) {
      System.out.println("*El entrenador ha sido jugador profesional? [y/ANYKEY]:                        *");
      proceedAnswer = in.nextLine();
      update();
      newProffessional = (proceed) ? true : false;
    } else newProffessional = ((AssistingTrainer)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getIsProffesional();
    System.out.println("*------------------------------------------------------------------------------*");
    System.out.println("*Desea cambiar las experticias del entrenador? [y/ANYKEY]                      *");
    proceedAnswer = in.nextLine();
    update();
    ArrayList<Integer> newExpertises = new ArrayList<>();
    if (proceed) {
      System.out.println("*Escriba las experticias del entrenador separadas por un espacio( ). Si solo   *");
      System.out.println("*posee una experticia, escriba el numero que corresponde y despues espacio:    *");
      int i = 1;
      for (Expertise e : Expertise.values()) {
        System.out.println("**[" + i + "] " + e.getName());
        i++;
      }
      String[] newExpertisesUnparsed = in.nextLine().split(" ");

      for (int j = 0; j < newExpertisesUnparsed.length; j++) {
        int element = (Integer.parseInt(newExpertisesUnparsed[j]));
        newExpertises.add(element - 1);
      }
    } else newExpertises = ((AssistingTrainer)iDontKnowSoccer.getEmployees().get(editedEmployeeIndex)).getExpertises();
    iDontKnowSoccer.edit(editedEmployeeIndex, newEmployeeInfo, newXpyears, newProffessional, newExpertises);
  }

  /**
   * Runs the algorithim to edit the dressing rooms of the club.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The rooms are edited correctly.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void readDressingRooms(Scanner in) throws IllegalArgumentException {
    clear();
    System.out.println("********************************************************************************");
    System.out.println("*Desea aniaidr or remover un jugador? [a/r/x]                                    *");
    strAnswer = in.nextLine();
    update();
    System.out.println("********************************************************************************");
    if (isInAddMode) {
      System.out.println("*Que jugador desea aniadir al camerino?                                        *");
      for (Employee e : iDontKnowSoccer.getEmployees()) {
        if (e instanceof Player) System.out.println("** " + e.getName());
      }
      System.out.println(iDontKnowSoccer.addToRoom(in.nextLine()));
      wait(1000);
    } else if (isInRemoveMode) {
      System.out.println("*Que jugador desea remover del camerino?                                       *");
      for (Employee e : iDontKnowSoccer.getEmployees()) {
        if (e instanceof Player) System.out.println("** " + e.getName());
      }
      System.out.println(iDontKnowSoccer.removeFromRoom(in.nextLine()));
      wait(1000);
    } else if (!skipEdition) throw new IllegalArgumentException("La opcion no fue reconocida: " + strAnswer + "(" + skipEdition + ")");

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
        readHire(in);
        break;
      case FIRE:
        readFire(in);
        break;
      case SEE_TEAMS:
        readSeeTeams(in);
        break;
      case EDIT_TEAMS:
        readEditTeams(in);
        break;
      case EDIT_EMPLOYEE:
        readEditEmployee(in);
        break;
      case ROOMS:
        readDressingRooms(in);
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
    wait(1000);
  }

  /**
   * A logic algorithm that decides what to do according to user input on {@link #readHire(Scanner) readHire}.<br>
   * <b>Pre: </b><br>
   * <b>Post: </b>The program proceeds with the correct algorithm.<br>
   * @param in A scanner object to read input. <b>Must be initialized</b>.<br>
   */
  private void switchHire(Scanner in) {
    clear();
    in.nextLine();
    String[] employeeInfo = new String[3];
    System.out.println("********************************************************************************");
    System.out.println("*Escriba el nombre del empleado:                                               *");
    employeeInfo[0]  = in.nextLine();
    System.out.println("*Escriba la identificacion (10 digitos) del empleado:                          *");
    employeeInfo[1] = in.nextLine();
    System.out.println("*Escriba el salario del empleado:                                              *");
    employeeInfo[2] = in.nextLine();
    System.out.println("********************************************************************************");
    switch (answer) {
      case PLAYER:
        readPlayer(in,employeeInfo);
        break;
      case MAIN_TRAINER:
        readMainTrainer(in,employeeInfo);
        break;
      case ASSISTING_TRAINER:
        readAssistingTrainer(in,employeeInfo);
        break;
      default:
        break;
    }
    System.out.println("********************************************************************************");
    System.out.println("***********************Empleado contratado exitosamente*************************");
    wait(1000);
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
  private void wait(int millis) {
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
    proceed = proceedAnswer.equalsIgnoreCase("y");
    isInChangeMode = strAnswer.equalsIgnoreCase("c");
    isInRemoveMode = strAnswer.equalsIgnoreCase("r");
    isInAddMode = strAnswer.equalsIgnoreCase("a");
    skipEdition = strAnswer.equalsIgnoreCase("x");
  }
}
