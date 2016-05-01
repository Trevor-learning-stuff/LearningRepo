import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by trevor.campbell on 4/29/16.
 */
public class NameApp {

    public static void main(String[] args) {
        String[] fileData = new String[4429];
        Name[] nameList = new Name[4429];
        //load the file
        Scanner inputStream = null;
        String fileName = "names.txt";

        try {
            inputStream = new Scanner (new File(fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening file named: " + fileName);
        }

        for (int i = 0; i < fileData.length; i++) {
            fileData[i] = inputStream.nextLine();
        }

        nameList = readNamesFile(fileData);

        System.out.println(nameList[0].getName() + " " + nameList[0].getPop(2));

        /*String choice;
        boolean stillWorking = true;

        do{
            displayMenu();
            choice = getUsersChoice();
            switch (choice) {
                case "A":
                    displayHistogram();
                    break;
                case "B":
                    //compareTwoName();
                    break;
                case "C":
                    //displayTopTenNames();
                    break;
                case "D":
                    //writeAnomaliesToFile();
                    stillWorking = false;
            }
        }while (stillWorking);*/
    }

    //takes the array of strings in main and returns an array of Name objects
    private static Name[] readNamesFile(String[] fileData) {
        Name nameList[] = new Name[4429];
        int[] popularityRanks = new int[11];

        for (int i = 0; i < fileData.length; i++) {

            // Create a Scanner to parse or tokenize the string
            Scanner tokens = new Scanner(fileData[i]);
            // Now read tokens out of the string via the Scanner
            String name = tokens.next();

            for (int j = 0; j < popularityRanks.length; j++) {
                popularityRanks[j] = tokens.nextInt();
            }
            nameList[i] = new Name(name, popularityRanks);
            System.out.println(nameList[0].getName() + nameList[0].getPop(0));
            System.out.println(nameList[i].getName() + nameList[i].getPop(0));
        }
        return nameList;
    }

    //displays the menu options that the user can select
    private static void displayMenu() {
        System.out.println("Enter the character corresponding to your selection:");
        System.out.println("\tA - Print histogram for a name");
        System.out.println("\tB - Compare two names in a decade");
        System.out.println("\tC - Print top ten names for a decade");
        System.out.println("\tD - Quit (display file anomalies");
    }

    //prompts for and returns the menu item the user wishes to use
    private static String getUsersChoice() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Your selection: ");
        return keyboard.next();
    }

    private static void displayHistogram() {
        String name = getUsersNameChoice();

    }

    //method to get the user's decade selection
    //returns -1 if the decade choice is less than 1 or greater than 11
    private static int getUsersDecadeChoice() {
        Scanner keyboard = new Scanner(System.in);
        int decadeChoice;

        System.out.println("Enter number corresponding to your decade:");

        System.out.println("\t1 - 1900- 909");
        System.out.println("\t2 - 1910-1919");
        System.out.println("\t3 - 1920-1929");
        System.out.println("\t4 - 1930-1939");
        System.out.println("\t5 - 1940-1949");
        System.out.println("\t6 - 1950-1959");
        System.out.println("\t7 - 1960-1969");
        System.out.println("\t8 - 1970-1979");
        System.out.println("\t9 - 1980-1989");
        System.out.println("\t10 - 1990-1999");
        System.out.println("\t11 - 2000-2005");

        System.out.print("Enter a decade: ");
        decadeChoice = keyboard.nextInt();

        if (decadeChoice < 1 || decadeChoice > 11) {
            return -1;
        }else{
            return decadeChoice;
        }
    }

    //Prompts for and gets the name from the user
    private static String getUsersNameChoice() {
        Scanner keyboard = new Scanner(System.in);
        String name = "";

        System.out.print("Enter a name: ");
        return keyboard.next();
    }
}
