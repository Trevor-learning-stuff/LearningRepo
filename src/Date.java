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
        if (year >= 0) {
            this.year = year;
        }

        if (isValidMonth(month)) {
            this.month = month;
        }

        if (isValidDay(day)) {
            this.day = day;
        }
    }

    public Date(Date date) {
        this.month = date.getMonth();
        this.day = date.getDay();
        this.year = date.getYear();
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
        if (isValidMonth(m)) {
            month = m;
        }
    }

    public void setDay(int d) {
        if (isValidDay(d)) {
            day = d;
        }
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

    /*public int compareTo(Date other) {

    }*/

    /*public int getDaysApart(Date other) {

    }*/

    private boolean isValidDay(int day) {
        switch (month) {
            case FEB:
                if (isLeapYear()) {
                    if (day >= 1 && day <= 29) {
                        return true;
                    }else{
                        throw new IllegalArgumentException("Day value " + day + " is invalid for month value " + month);
                    }
                }else if(day >= 1 && day <=28){
                    return true;
                }else{
                    throw new IllegalArgumentException("Day value " + day + " is invalid for month value " + month);
                }
            case APR:
            case JUN:
            case SEP:
            case NOV:
                if (day >= 1 && day <= 30) {
                    return true;
                }else{
                    throw new IllegalArgumentException("Day value " + day + " is invalid for month value " + month);
                }
            default:
                if (day >= 1 && day <= 31) {
                    return true;
                }else{
                    throw new IllegalArgumentException("Day value " + day + " is invalid for month value " + month);
                }

        }
    }

    private boolean isValidMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        } else {
            throw new IllegalArgumentException("Month value, " + month + ", is not between 1 and 12");
        }
    }

    private boolean isLeapYear() {
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            return true;
        }else{
            return false;
        }
    }


}
