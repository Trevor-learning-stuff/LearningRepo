import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by trevor.campbell on 4/29/16.
 */
public class NameApp {

    public static void main(String[] args) {
        String[] fileData = new String[4429];
        Name[] nameList;
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

        String choice;
        boolean stillWorking = true;

        do{
            displayMenu();
            choice = getUsersChoice();
            switch (choice) {
                case "A":
                    displayHistogram(nameList);
                    break;
                case "B":
                    compareTwoNames(nameList);
                    break;
                case "C":
                    displayTopTenNames(nameList);
                    break;
                case "D":
                    writeAnomaliesToFile(nameList);
                    stillWorking = false;
            }
        }while (stillWorking);
    }

    //takes the array of strings in main and returns an array of Name objects
    private static Name[] readNamesFile(String[] fileData) {
        Name nameList[] = new Name[4429];
        int[] popularityRanks;

        for (int i = 0; i < fileData.length; i++) {

            // Create a Scanner to parse or tokenize the string
            Scanner tokens = new Scanner(fileData[i]);
            // Now read tokens out of the string via the Scanner
            String name = tokens.next();

            popularityRanks = new int[11];
            for (int j = 0; j < popularityRanks.length; j++) {
                popularityRanks[j] = tokens.nextInt();
            }
            nameList[i] = new Name(name, popularityRanks);
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
        return keyboard.next().toUpperCase();
    }

    //prompts the user for a name and displays the histogram for it
    private static void displayHistogram(Name[] nameList) {
        String name = getUsersNameChoice();

        if (searchForName(name, nameList) == -1) {
            System.out.println("No data for the name " + name);
        } else {
            int nameIndex = searchForName(name, nameList);
            System.out.println(nameList[nameIndex].getHistogram());
        }


    }

    private static void compareTwoNames(Name[] nameList) {
        String name1 = getUsersNameChoice();
        String name2 = getUsersNameChoice();
        int decade = getUsersDecadeChoice();
        int name1Index = searchForName(name1, nameList);
        int name2Index = searchForName(name2, nameList);
        int name1PopRating = nameList[name1Index].getPop(decade);
        int name2PopRating = nameList[name2Index].getPop(decade);
        String name1HistoLine = nameList[name1Index].getHistoLine(decade);
        String name2HistoLine = nameList[name2Index].getHistoLine(decade);

        System.out.println("Data for " + name1);
        System.out.println("\t" + name1PopRating + ": " + name1HistoLine);
        System.out.println("Data for " + name2);
        System.out.println("\t" + name2PopRating + ": "+ name2HistoLine);
    }

    private static void displayTopTenNames(Name[] nameList) {
        int decade = getUsersDecadeChoice();
        int count = 0;
        int l = 0;
        String[] decadeName = new String[20];
        Name[] temp = new Name[nameList.length];

        for (int i = 0; i < nameList.length; i++){
            temp[i] = nameList[i];
        }

        for (int index = 0; index < temp.length; index++){
            int smallestIndex = getIndexOfSmallest(decade, index, temp);
            Name tempInt = temp[index];
            temp[index] = temp[smallestIndex];
            temp[smallestIndex] = tempInt;
        }

        do {

            if (temp[l].getPop(decade) == 0){
                l++;
            }
            else {
                decadeName[count] = temp[l].getName() + " " + "(" + temp[l].getPop(decade) + ")";

                count++;
                l++;
            }

        } while (count < 20);

        for (int i = 0; i < 20; i += 2){
            System.out.printf("%20s\t%20s\n", decadeName[i],decadeName[i + 1]);
        }
    }

    private static int getIndexOfSmallest(int decade, int startIndex, Name[] temp){
        int min = temp[startIndex].getPop(decade);
        int indexOfMin = startIndex;

        for (int index = startIndex + 1; index < temp.length; index++){
            if (temp[index].getPop(decade) < min){
                min = temp[index].getPop(decade);
                indexOfMin = index;
            }
        }

        return indexOfMin;
    }

    //searches for the name the user entered in the array of Name objects
    //and returns the index value for the name
    private static int searchForName(String name, Name[] nameList) {

        for (int i = 0; i < nameList.length; i++) {
            String nameInList = nameList[i].getName();
            if (name.equals(nameInList)) {
                return i;
            }
        }
        return -1;
    }

    //method to get the user's decade selection
    //returns -1 if the decade choice is less than 1 or greater than 11
    private static int getUsersDecadeChoice() {
        Scanner keyboard = new Scanner(System.in);
        int decadeChoice;

        System.out.println("Enter number corresponding to your decade:");

        System.out.println("\t1 - 1900-1909");
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

    private static String decadeChoice(int decade) {
        String decadeRange = "";
        switch (decade) {
            case 1:
                decadeRange = "1900-1909";
            case 2:
                decadeRange = "1910-1919";
            case 3:
                decadeRange = "1920-1929";
            case 4:
                decadeRange = "1930-1939";
            case 5:
                decadeRange = "1940-1949";
            case 6:
                decadeRange = "1950-1959";
            case 7:
                decadeRange = "1960-1969";
            case 8:
                decadeRange = "1970-1979";
            case 9:
                decadeRange = "1980-1989";
            case 10:
                decadeRange = "1990-1999";
            case 11:
                decadeRange = "2000-2005";
        }
        return decadeRange;
    }

    private static void writeAnomaliesToFile(Name[] nameList) throws FileNotFoundException{
        Name[] temp = new Name[nameList.length];
        String[] anomalies = new String[1065];
        int anomalyCount = 0;

        for (int i = 0; i < nameList.length; i++){
            temp[i] = nameList[i];
        }

        for (int decade = 0; decade < 11; decade++){
            for (int ranks = 1; ranks < 1000; ranks++){
                int found = 0;
                String tempName = "";

                String decadeYear = decadeChoice(decade);

                for (int i = 0; i < temp.length; i++){
                    if (temp[i].getPop(decade) == ranks){
                        found++;
                    }

                    if (found == 1 &&
                            temp[i].getPop(decade) == ranks){
                        tempName = temp[i].getName();
                    }
                }

                if (found == 0){
                    anomalies[anomalyCount] = "No names "
                            + "for " + decadeYear + ", rank "
                            + ranks + ".";
                    anomalyCount++;
                }
                else if (found == 1){
                    anomalies[anomalyCount] = "One "
                            + "Name (" + tempName + ") for "
                            + decadeYear + ", rank "
                            + ranks + ".";
                    anomalyCount++;
                }
            }
        }

        //write the anomalies to the anomalies.txt file
        String fileName = "anomalies.txt";
        PrintWriter outputStream = null;

        outputStream = new PrintWriter(fileName);

        for (int i = 0; i < anomalies.length; i++){
            outputStream.println(anomalies[i]);
        }

        outputStream.close();
    }
}
