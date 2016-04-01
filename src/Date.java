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
        if (isValidYear(year)) {
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
        if (isValidYear(y)) {
            year = y;
        }
    }

    public String toString() {
        return String.format("%s-%d-%d", convertMonthToStringName(month), day, year);
    }

    public boolean equals(Date other) {
        return other.getDay() == this.getDay() && other.getMonth() == this.getMonth() && other.getYear() == this.getYear();
    }

    // TODO: 4/1/16 do these
    public int getDayNumber() {
        return (int)30.6001*(month+1);
    }

    public void addDays(int amt) {

    }

    public int compareTo(Date other) {
        if (this.day < other.getDay() || this.month < other.getMonth() || this.year < other.getMonth()) {
            return -1;
        }else if (this.day == other.getDay() || this.month == other.getMonth() || this.year == other.getMonth()) {
            return 0;
        }else{
            return 1;
        }
    }
// TODO: 4/1/16 do this one too
    /*public int getDaysApart(Date other) {

    }*/

    private boolean isValidDay(int aDay) {
        switch (month) {
            case FEB:
                if (isLeapYear()) {
                    if (aDay >= 1 && aDay <= 29) {
                        return true;
                    }else{
                        throw new IllegalArgumentException("Day value " + aDay + " is invalid for month value " + month);
                    }
                }else if (aDay >= 1 && aDay <=28){
                    return true;
                }else{
                    throw new IllegalArgumentException("Day value " + aDay + " is invalid for month value " + month);
                }
            case APR:
            case JUN:
            case SEP:
            case NOV:
                if (aDay >= 1 && aDay <= 30) {
                    return true;
                }else{
                    throw new IllegalArgumentException("Day value " + aDay + " is invalid for month value " + month);
                }
            default:
                if (aDay >= 1 && aDay <= 31) {
                    return true;
                }else{
                    throw new IllegalArgumentException("Day value " + aDay + " is invalid for month value " + month);
                }

        }
    }

    private boolean isValidMonth(int aMonth) {
        if (aMonth >= 1 && aMonth <= 12) {
            return true;
        } else {
            throw new IllegalArgumentException("Month must be between 1 and 12, inclusive");
        }
    }

    public boolean isValidYear(int aYear) {
        if (aYear > 0) {
            return true;
        }else{
            throw new IllegalArgumentException("Year must be positive (>0)");
        }
    }

    private boolean isLeapYear() {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    private String convertMonthToStringName(int aMonth) {
        switch (aMonth) {
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUG";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";
        }
        return null;
    }
}
