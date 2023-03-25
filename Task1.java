import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Task1 {

    private static void menu(Scanner scanner, HashMap<String, ArrayList<Long>> telbook) {
        System.out.println("-= TELEPHONE BOOK =-");
        System.out.println("    Main menu");
        System.out.println("====================");
        System.out.println();
        System.out.println("1. Add Person");
        System.out.println("2. Show all users");
        System.out.println("3. Show user");
        System.out.println("4. Add phone number");
        System.out.println("5. Close book");
        System.out.print("Enter a number from menu: ");
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            addUser(scanner, telbook);
        }
        if (userInput == 2) {
            showAllusers(scanner, telbook);
        }
        if (userInput == 3) {
            showUser(scanner, telbook);
        } 
        if (userInput == 4){
            addPhone(scanner, telbook);
        }
        if (userInput == 5) {
            System.exit(0);
        }
        else {
            menu(scanner, telbook);
        }
    }

    private static void addPhone(Scanner scanner, HashMap<String, ArrayList<Long>> telbook) {
        System.out.println();
        System.out.print("Enter a name to add a phone: ");
        String userName = scanner.next();
        System.out.println();
        System.out.print("Enter a number: ");
        Long number = scanner.nextLong();
        for (Entry<String, ArrayList<Long>> name: telbook.entrySet()){
            if (name.getKey().equals(userName)){
                name.getValue().add(number);
            }
        }
        menu(scanner, telbook);
    }

    private static void showUser(Scanner scanner, HashMap<String, ArrayList<Long>> telbook) {
        System.out.print("Enter a name to find a user: ");
        String userName = scanner.next();
        for (Entry<String, ArrayList<Long>> name: telbook.entrySet()){
            if (name.getKey().equals(userName))
            System.out.println(name);
        }
        String userAwait = scanner.next();
        if (userAwait == "q")
            menu(scanner, telbook);
        else
            menu(scanner, telbook);
    }

    private static void showAllusers(Scanner scanner, HashMap<String, ArrayList<Long>> telbook) {
        int count = 1;
        for (Entry<String, ArrayList<Long>> user: telbook.entrySet()){
            System.out.println(count++ + "." + " Имя: " + user.getKey() + " | Телефоны: " + user.getValue());
        }
        System.out.println();
        System.out.println();
        System.out.print("Enter q for return to main menu: ");
        String userAwait = scanner.next();
        if (userAwait == "q")
            menu(scanner, telbook);
        else
            menu(scanner, telbook);
    }

    private static void addUser(Scanner scanner, HashMap<String, ArrayList<Long>> telbook) {
        System.out.print("Enter Your Name: ");
        String userName = scanner.next();
        System.out.print("Enter mobile phone: ");
        Long userNumber = scanner.nextLong();
        ArrayList<Long> number = new ArrayList<>();
        number.add(userNumber);
        telbook.put(userName, number);
        menu(scanner, telbook);
    }

    public static void main(String[] args) {

        System.out.println("\033[H\033[2J");
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Long>> telbook = new HashMap<>();
        menu(scanner, telbook);

        scanner.close();
    }
}