import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by trevor.campbell on 9/15/16.
 *
 * car info: http://www.supercars.net/blog/top-50-supercars-listed-price/
 */
public class Program3 {
    static Scanner keyboard = new Scanner(System.in);

    public static class CarData {
        String carMake;
        String carModel;
        int price;
        int horsepower;
    }


    public static void main(String[] args) {
        final int QuitChoice = 5;
        int selectedOption;
        CarData[] carData = new CarData[100];
        int dataLength = LoadCarData(carData);

        System.out.print("Program to display information from a file.");

        //Main run loop
        do {
            DisplayMenu();

            System.out.print("Enter selection: ");
            selectedOption = keyboard.nextInt();

            if (selectedOption == 1) {
                DisplayAllCarData(carData);
            } else if (selectedOption == 2) {
                DisplaySpecificModel(carData);
            } else if (selectedOption == 3) {
                ComputeTheAveragePrice(carData);
            } else if (selectedOption == 4) {
                DisplayCountOfCarsByPrice(carData, dataLength);
            } else if (selectedOption != QuitChoice) {
                System.out.println("Please enter a number from 1 to " +
                        QuitChoice + ".");
            }

            if (selectedOption != QuitChoice) {
                HoldScreen();
            }
        } while (selectedOption != 5);
        GoodBye();
    }

    //Method to display the menu
    public static void DisplayMenu() {
        System.out.println("Please choose a number below: ");
        System.out.println("1. Display all car data.");
        System.out.println("2. Display a specific model.");
        System.out.println("3. Compute the average price of cars " +
                "in a given horsepower range.");
        System.out.println("4. Display how many cars are in each price range.");
        System.out.println("5. End Program.");
    }

    //Method to load all of the car data into an array of CarData records
    private static int LoadCarData(CarData[] carData) {
        int nCarData = 0;
        try {
            File file = new File("Top20MostExpensiveCars.txt");
            Scanner inFile = new Scanner(file);

            do {
                carData[nCarData] = new CarData();
                carData[nCarData].carModel = inFile.next();
                carData[nCarData].carMake = inFile.next();
                carData[nCarData].price = inFile.nextInt();
                carData[nCarData].horsepower = inFile.nextInt();
                nCarData++;

            } while (!carData[nCarData - 1].carModel.equals("EOF"));
            --nCarData;

        } catch (IOException ioe) {
            System.out.print("File access error");
            nCarData = 0;
        }
        return nCarData;
    }

    //Method to end the program
    public static void GoodBye() {
        System.out.println("\nHave a nice day!\n");
    }

    //Method to hold the screen
    public static void HoldScreen() {
        String hold;
        System.out.print("\nType any character and press enter to " +
                "continue: ");
        hold = keyboard.next();
    }

    //method to display all of the file data
    public static void DisplayAllCarData(CarData[] carData) {
        int index = 0;

        System.out.println("Model  Make  Price  Horsepower");
        while (!EndOfFileMarker(carData, index)) {
            System.out.printf("%1s %-5s %-5d %-5d \n", carData[index].carModel,
                    carData[index].carMake, carData[index].price,
                    carData[index].horsepower);

            index++;
        }
    }

    //Method to display a specific model
    public static void DisplaySpecificModel(CarData[] carData) {
        String modelToDisplay;
        int index = 0;

        System.out.print("Enter model name: ");
        modelToDisplay = keyboard.next();

        while (!carData[index].carModel.equals(modelToDisplay)) {
            index++;
        }

        if (carData[index].carModel.equals(modelToDisplay)) {
            System.out.printf("%1s %-5s %-5d %-5d", carData[index].carModel,
                    carData[index].carMake, carData[index].price,
                    carData[index].horsepower);
        } else {
            System.out.println("That model doesn't exist.");
        }
    }

    //Method to compute the average price within a given horsepower range
    public static void ComputeTheAveragePrice(CarData[] carData) {
        int index = 0;
        int count = 0;
        int minHorsepower, maxHorsepower;
        int totalPrice = 0;
        int averagePrice = 0;

        System.out.print("Enter the minimum horsepower: ");
        minHorsepower = keyboard.nextInt();
        System.out.print("\nEnter the maximum horsepower: ");
        maxHorsepower = keyboard.nextInt();

        while (!EndOfFileMarker(carData, index)) {
            if (carData[index].horsepower >= minHorsepower &&
                    carData[index].horsepower <= maxHorsepower) {
                totalPrice += carData[index].price;
                count++;
            }
            index++;
        }

        if (count > 0) {
            averagePrice = totalPrice / count;

            System.out.print("The average price within " + minHorsepower +
                    "HP and " + maxHorsepower + "HP is " + averagePrice + ".");
        } else {
            System.out.print("There were no cars within that range.");
        }
    }

    //Method to display the count of cars by price range
    public static void DisplayCountOfCarsByPrice(CarData[] carData, int len) {
        CarData[] minPrice = MinPrice(carData, len);
        int priceRange = (minPrice[len - 1].price - minPrice[0].price) / 10;
        int startOfRange = minPrice[0].price;
        int count = 0;
        String numAsterisks = "";

        System.out.printf("Range : count");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < len; j++) {
                if (minPrice[j].price >= startOfRange &&
                        minPrice[j].price < startOfRange + priceRange) {
                    count++;
                    numAsterisks = numAsterisks + "*";
                }
            }
            System.out.printf("\n%5d   %d   %s", startOfRange, count,
                    numAsterisks);

            startOfRange += priceRange;
            numAsterisks = "";
            count = 0;
        }

    }

    //Helper method to sort CarData record array by price. Lowest to highest.
    public static CarData[] MinPrice(CarData[] carData, int len) {
        for (int i = 0; i < len - 1; i++) {
            int index = i;

            for (int j = i + 1; j < len; j++) {
                if (carData[j].price < carData[index].price) {
                    index = j;
                }
            }
            CarData minPrice = carData[index];
            carData[index] = carData[i];
            carData[i] = minPrice;
        }
        return carData;
    }

    //Method to check for the end of file marker record
    public static boolean EndOfFileMarker(CarData[] carData, int index) {
        return carData[index].carModel.equals("EOF");
    }
}
