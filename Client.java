import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class Client {

    private static MyLinkedList teamA = new MyLinkedList();
    private static MyLinkedList teamB = new MyLinkedList();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan1 = new Scanner(new File("A.txt"));
        Scanner scan2 = new Scanner(new File("B.txt"));
        teamA = readDataFromFile(scan1);
        teamB = readDataFromFile(scan2);
        menu();
    }

    public static void menu() throws FileNotFoundException {
        while(true) {
            System.out.println("*****************************************");
            System.out.println("|                 MENU                  |");
            System.out.println("*****************************************");
            System.out.println("| Options:                              |");
            System.out.println("|        1. Add New Player              |");
            System.out.println("|        2. View Teams                  |");
            System.out.println("|        3. Search                      |");
            System.out.println("|        4. Delete                      |");
            System.out.println("|        5. Exit                        |");
            System.out.println("*****************************************");
            System.out.print("Select option: ");
            Scanner console = new Scanner(System.in);
            String option = console.next();
            //loadData();
            switch (option) {
                case "1":
                    addPlayer();
                    break;
                case "2":
                    view();
                    break;
                case "3":
                    search();
                    break;
                case "4":
                    delete();
                    pressEnter();
                    break;
                case "5":
                    PrintStream  output = new PrintStream(new File("A.txt"));
                    PrintStream  output2 = new PrintStream(new File("B.txt"));
                    writeToFile(output, teamA);
                    writeToFile(output2, teamB);
                    System.exit(0);
                default:
                    System.out.println("Selection Incorrect");
                    break;
            }
        }
    }

    public static void addPlayer() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter first name (q to quit): ");
        String firstName = console.next();
        if (firstName.equalsIgnoreCase("q")) {
            return;
        }
        System.out.print("Enter last Name (q to quit): ");
        String lastName = console.next();
        if (lastName.equalsIgnoreCase("q")) {
            return;
        }
        System.out.print("Enter age: ");
        int age = console.nextInt();
        Player player = new Player(firstName, lastName, age);
        System.out.println("1. Team A");
        System.out.println("2. Team B");
        System.out.print("Select team: ");
        int selection = console.nextInt();
        if (selection == 1) {
            teamA.add(player);
        } else {
            teamB.add(player);
        }
    }

    public static void view() throws FileNotFoundException {
        while (true) {
            System.out.println("*****************************************");
            System.out.println("|              VIEW TEAMS               |");
            System.out.println("*****************************************");
            System.out.println("| Options:                              |");
            System.out.println("|        1. Team A                      |");
            System.out.println("|        2. Team B                      |");
            System.out.println("|        3. Back                        |");
            System.out.println("*****************************************");
            System.out.print("Select option: ");
            Scanner console = new Scanner(System.in);
            String option = console.next();
            switch (option) {
                case "1":
                    System.out.println();
                    System.out.println("         TEAM A - TOP PLAYERS IN THE WORLD           ");
                    teamA.sort();
                    display(teamA);
                    pressEnter();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("            TEAM B - OLYMPIACOS C.F.P.              ");
                    teamB.sort();
                    display(teamB);
                    pressEnter();
                    break;
                case "3":
                    menu();
                    break;
                default:
                    System.out.println("Selection Incorrect");
                    break;
            }
        }
    }

    private static void search() {
        while (true) {
            System.out.println("*****************************************");
            System.out.println("|                SEARCH                 |");
            System.out.println("*****************************************");
            System.out.println("| Options:                              |");
            System.out.println("|        1. Search by First Name        |");
            System.out.println("|        2. Search by Last Name         |");
            System.out.println("|        3. Search by Age               |");
            System.out.println("|        4. Search by Age Range         |");
            System.out.println("|        5. Back                        |");
            System.out.println("*****************************************");
            System.out.print("Select option: ");
            Scanner console = new Scanner(System.in);
            String option = console.next();
            switch (option) {
                case "1":
                    System.out.println();
                    System.out.print("Enter first name: ");
                    String firstName = console.next();
                    if (teamA.search(firstName).size() == 0  && teamB.search(firstName).size() == 0) {
                        System.out.println();
                        System.out.println("No results. Try again. ");
                        pressEnter();
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Result(s): ");
                        System.out.println();
                        if (teamA.search(firstName).size() != 0) {
                            System.out.println("From Team A: ");
                            display(teamA.search(firstName));
                        }
                        if (teamB.search(firstName).size() != 0) {
                            System.out.println();
                            System.out.println("From Team B: ");
                            display(teamB.search(firstName));
                        }
                        pressEnter();
                    }
                    break;
                case "2":
                    System.out.println();
                    System.out.print("Enter last name: ");
                    String lastName = console.next();
                    if (teamA.search(lastName).size() == 0  && teamB.search(lastName).size() == 0) {
                        System.out.println();
                        System.out.println("No results. Try again. ");
                        pressEnter();
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Result(s): ");
                        System.out.println();
                        if (teamA.search(lastName).size() != 0) {
                            System.out.println("From Team A: ");
                            display(teamA.search(lastName));
                        }
                        if (teamB.search(lastName).size() != 0) {
                            System.out.println();
                            System.out.println("From Team B: ");
                            display(teamB.search(lastName));
                        }
                        pressEnter();
                    }
                    break;
                case "3":
                    System.out.println();
                    System.out.print("Enter age: ");
                    String age = console.next();
                    if (teamA.search(age).size() == 0  && teamB.search(age).size() == 0) {
                        System.out.println();
                        System.out.println("No results. Try again. ");
                        pressEnter();
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Result(s): ");
                        System.out.println();
                        if (teamA.search(age).size() != 0) {
                            System.out.println("From Team A: ");
                            display(teamA.search(age));
                        }
                        if (teamB.search(age).size() != 0) {
                            System.out.println();
                            System.out.println("From Team B: ");
                            display(teamB.search(age));
                        }
                        pressEnter();
                    }
                    break;
                case "4":
                    System.out.println();
                    System.out.print("Enter age range: ");
                    int age1 = console.nextInt();
                    int age2 = console.nextInt();
                    if (teamA.search(age1, age2).size() == 0  && teamB.search(age1, age2).size() == 0) {
                        System.out.println();
                        System.out.println("No results. Try again. ");
                        pressEnter();
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Result(s): ");
                        System.out.println();
                        if (teamA.search(age1, age2).size() != 0) {
                            System.out.println("From Team A: ");
                            display(teamA.search(age1, age2));
                        }
                        if (teamB.search(age1, age2).size() != 0) {
                            System.out.println();
                            System.out.println("From Team B: ");
                            display(teamB.search(age1, age2));
                        }
                        pressEnter();
                    }
                    break;
                case "5":
                    try {
                        menu();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Selection Incorrect");
                    break;
            }
        }
    }

    private static void delete() {
        System.out.println();
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the player's last name: ");
        String input = console.next();
        if (teamA.search(input).size() == 0  && teamB.search(input).size() == 0) {
            System.out.println();
            System.out.println("No results. Try again. ");
            return;
        } else {
            System.out.println();
            if (teamA.search(input).size() != 0) {
                System.out.println("From Team - Top Players: ");
                display(teamA.search(input));
            }
            if (teamB.search(input).size() != 0) {
                System.out.println();
                System.out.println("From Team - OLYMPIACOS C.F.P.: ");
                display(teamB.search(input));
            }
            System.out.println();
            System.out.print("Enter the id of the player you want to delete: ");
            int id = console.nextInt();
            if (teamA.searchId(id) != null) {
                Player p = teamA.searchId(id);
                int index = teamA.indexOf(p);
                teamA.remove(index);
                System.out.println();
                System.out.println("The player with the name " + "(" + p.getFirstName() + ", " + p.getLastName() + ") " + " has been deleted.");
            } else {
                Player p = teamB.searchId(id);
                int index = teamB.indexOf(p);
                teamB.remove(index);
                System.out.println();
                System.out.println("The player with the name " + "(" + p.getFirstName() + ", " + p.getLastName() + ") " + " has been deleted.");
            }
        }
    }

    public static MyLinkedList readDataFromFile(Scanner scan) throws FileNotFoundException {
        MyLinkedList list = new MyLinkedList();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner data = new Scanner(line);
            int id = Integer.parseInt(data.next());
            String firstName = data.next();
            String lastName = data.next();
            int age = data.nextInt();
            Player player = new Player(firstName, lastName, age);
            list.add(player);
        }
        return list;
    }

    public static void pressEnter() {
        System.out.println();
        System.out.println("Press \"Enter\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void writeToFile(PrintStream output, MyLinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            output.println(list.get(i));
        }
        output.close();
        output.flush();
    }

    public static void display(MyLinkedList team) {
        System.out.println();
        System.out.println(String.format("%-10s%-15s%-22s%-2s", "ID","FIRST NAME","LAST NAME","AGE"));
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i));
        }
    }
}
