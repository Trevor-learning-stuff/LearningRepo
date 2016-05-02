/**
 * Programmer: Trevor Campbell             CSC110AB Module 6
 * Date: April 29, 2016
 * Description: This program reads a file and creates a name object with a person's name and their popularity rating
 * starting from 1900 to the 2000's
 *
 * Input: User enters a name or decade and a name
 * Output: The popularity of an entered name during a selected decade
 *
 * Pseudocode for this solution:
 * Begin
 * Read in the data from names.txt
 * Create an array of Name objects
 * Display a menu with the following options:
 ** A - Print histogram for a name
 ** B - Compare two names in a decade
 ** C - Print top ten names for a decade
 ** D - Quit (display file anomalies
 * Prompt the user for a menu selection
 * if menu option A is selected:
 ** Prompt the user for a name
 ** Display the name
 ** Display the histogram for all decades
 * Prompt the user for a menu selection
 * If menu option B is selected:
 ** Prompt the user for the first name
 ** Prompt the user for the second name
 ** Prompt the user for a decade
 ** Print the first entered name
 ** Print the histoline for the first name
 ** Print the second entered name
 ** Print the histoline for the second name
 * Prompt the user for a menu selection
 * If menu option C is selected:
 ** Prompt the user for a decade
 ** Print the top ten names (male and female) for the entered decade
 * Prompt the user for a menu selection
 * If menu option D is selected:
 ** Write all anomalies to the file anomalies.txt
 ** Terminate the program
 * end
 */


public class Name {

    private String name;
    private int[] popularityRanks = new int[11];
    private static int MAX_STARS = 85;
    private static int MIN_RANK = 0;

    public Name(String name, int[] popularityRanks){
        this.name = name;
        this.popularityRanks = popularityRanks;
    }

    //return the value of the instance variable name for this object
    public String getName(){
        return name;
    }

    //get the popularity value
    //return -1 if value is out of bounds
    public int getPop(int decade){
        if (decade >= 0 && decade <= 10){
            return popularityRanks[decade];
        }
        else{
            return -1;
        }
    }

    //returns a single line for a histogram
    public String getHistoLine(int decade){
        String histoLine = popularityRanks[decade] + ": ";
        double popularity = (1000 - popularityRanks[decade]) / 11.7;
        int histo = (int)popularity;

        if(popularityRanks[decade] != 0){

            for (int i = 0; i < histo; i++){
                histoLine += "*";
            }
        }

        return histoLine;
    }

    //Labels with the user's name selection and returns
    //the histogram of the popularity ranks
    public String getHistogram(){
        String fullHistogram = "";

        System.out.println("Histogram for name, " + name + ":");

        for (int i = 0; i < 11; i++){
            fullHistogram += this.getHistoLine(i) + "\n";
        }
        return fullHistogram;
    }
}