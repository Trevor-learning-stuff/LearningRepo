/**
 * Created by trevor.campbell on 3/28/16.
 */
public class Date {

    private int month;
    private int day;
    private int year;

    public static final int JAN = 1;
    public static final int FEB = 2;
    public static final int MAR = 3;
    public static final int APR = 4;
    public static final int MAY = 5;
    public static final int JUN = 6;
    public static final int JUL = 7;
    public static final int AUG = 8;
    public static final int SEP = 9;
    public static final int OCT = 10;
    public static final int NOV = 11;
    public static final int DEC = 12;

    public Date(){
        month = 1;
        day = 1;
        year = 2000;
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(Date date) {

    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setDay(int d) {
        day = d;
    }

    public void setYear(int y) {
        year = y;
    }

    public String toString(Date d) {
        String dateString = "";

        return dateString;
    }

    public boolean equals(Date other) {
        boolean isEqual = false;

        return isEqual;
    }

    public int getDayNumber() {
        int dayNumber = 0;

        return dayNumber;
    }

    public void addDays(int amt) {

    }

    public int compareTo(Date other) {

    }

    public int getDaysApart(Date other) {

    }


}
