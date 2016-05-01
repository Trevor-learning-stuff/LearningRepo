/**
 * Programmer: Trevor Campbell             CSC110AB Module 6
 * Date: April 28, 2016
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

    public Name(String name, int[] popularityRanks){
        this.name = name;
        this.popularityRanks = popularityRanks;
    }

    //get the name value
    // by tokenizing the string and extracting the first value into the name instance variable
    public String getName(){
        return name;
    }

    //get the popularity value
    public int getPop(int decade){
        return popularityRanks[decade];
    }

    //returns a single line for a histogram
    public String getHistoLine(int decade){
        String histoLine = "";
        for (int i = 0; i < popularityRanks[decade]; i++) {
            // TODO: 4/29/16 handle the limiting of printing better 87 - (0.087 * rank) = numberOfStars
            histoLine += "*";
        }
        return histoLine;
    }
    //Return a decade's line (String) in the histogram
    //Return null if the decade value is not valid

    //Labels with the user's name selection and returns
    //the histogram of the popularity ranks
    public String getHistogram(){
        String fullHistogram = "";

        System.out.println("Histogram for name, " + name + ":");

        for (int i = 0; i < popularityRanks.length - 1; i++) {
            fullHistogram += "\t" + popularityRanks[i] + ": " + getHistoLine(popularityRanks[i]) + "\n";
        }
        return fullHistogram;
    }
}