/**
 * Programmer: Trevor Campbell             CSC110AB Module 5 Part 2
 * Date: April 11, 2016
 * Description: This creates a custom date object that a programmer can use
 *
 * Input: none
 * Output: error for invalid dates
 *
 * Pseudocode for this solution:
 * Begin
 * can be constructed in 3 ways
 *      default - defaults to jan. 1, 2000
 *      set day, month, year
 *      set from another Date object
 * Methods for getting each of the Instance variables - month, day, year
 * Methods for setting each of the Instance variables - month, day, year
 * toString Method - Any time the date is printed, it will be formatted as JAN 1, 2000
 * Equals Method - check if the Date object is equal to another
 * getDayNumber Method - returns the day of the year for the current set date
 * addDays Method - add or subtract days and return the proper date
 * compareTo Method - returns -1 if date is less than another, returns 0 if equal, returns 1 if greater
 * End
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
        month = JAN;
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

    public int getDayNumber() {
        int numberDays = 0;

        if (isLeapYear()) {
            switch (month) {
                case JAN:
                    numberDays = day;
                    break;
                case FEB:
                    numberDays = 31 + day;
                    break;
                case MAR:
                    numberDays = 60 + day;
                    break;
                case APR:
                    numberDays = 91 + day;
                    break;
                case MAY:
                    numberDays = 121 + day;
                    break;
                case JUN:
                    numberDays = 152 + day;
                    break;
                case JUL:
                    numberDays = 182 + day;
                    break;
                case AUG:
                    numberDays = 213 + day;
                    break;
                case SEP:
                    numberDays = 244 + day;
                    break;
                case OCT:
                    numberDays = 274 + day;
                    break;
                case NOV:
                    numberDays = 305 + day;
                    break;
                case DEC:
                    numberDays = 335 + day;
                    break;
            }
        }

        if (!isLeapYear()) {

            switch (month) {
                case JAN:
                    numberDays = day;
                    break;
                case FEB:
                    numberDays = 31 + day;
                    break;
                case MAR:
                    numberDays = 59 + day;
                    break;
                case APR:
                    numberDays = 90 + day;
                    break;
                case MAY:
                    numberDays = 120 + day;
                    break;
                case JUN:
                    numberDays = 151 + day;
                    break;
                case JUL:
                    numberDays = 181 + day;
                    break;
                case AUG:
                    numberDays = 212 + day;
                    break;
                case SEP:
                    numberDays = 243 + day;
                    break;
                case OCT:
                    numberDays = 273 + day;
                    break;
                case NOV:
                    numberDays = 304 + day;
                    break;
                case DEC:
                    numberDays = 334 + day;
                    break;
            }
        }

        return numberDays;
    }

    public void addDays(int amt) {

        if (isLeapYear()) {
            if (amt >= 366 || amt <= -366) {
                year += amt / 366;
                this.calculateMonthAndDay(this.getDayNumber() + amt - 366);
            }else{
                this.calculateMonthAndDay(getDayNumber() + amt);
            }
        }else {
            if (amt >= 365 || amt <= -365) {
                year += amt / 365;
                this.calculateMonthAndDay(this.getDayNumber() + amt - 365);
            }else{
                this.calculateMonthAndDay(getDayNumber() + amt);
            }
        }
    }

    public int compareTo(Date other) {
        if (this.day < other.getDay()|| this.month < other.getMonth() || this.year < other.getYear()) {
            return -1;
        }else if (this.day == other.getDay() && this.month == other.getMonth() && this.year == other.getYear()) {
            return 0;
        }else{
            return 1;
        }
    }

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

    private boolean isValidYear(int aYear) {
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
        String month = "";

        switch (aMonth) {
            case 1:
                month = "JAN";
                break;
            case 2:
                month = "FEB";
                break;
            case 3:
                month = "MAR";
                break;
            case 4:
                month = "APR";
                break;
            case 5:
                month = "MAY";
                break;
            case 6:
                month = "JUN";
                break;
            case 7:
                month = "JUL";
                break;
            case 8:
                month = "AUG";
                break;
            case 9:
                month = "SEP";
                break;
            case 10:
                month = "OCT";
                break;
            case 11:
                month = "NOV";
                break;
            case 12:
                month = "DEC";
                break;
        }
        return month;
    }

    private void calculateMonthAndDay(int dayOfYear) {

        if(!isLeapYear()) {
            if (dayOfYear >= 1 && dayOfYear <= 31) {
                this.month = JAN;
                this.day = dayOfYear;

            } else if (dayOfYear >= 32 && dayOfYear <= 59) {
                this.month = FEB;
                this.day = 28 - (59 - dayOfYear);

            } else if (dayOfYear >= 60 && dayOfYear <= 90) {
                this.month = MAR;
                this.day = 31 - (90 - dayOfYear);

            } else if (dayOfYear >= 91 && dayOfYear <= 120) {
                this.month = APR;
                this.day = 30 - (120 - dayOfYear);

            } else if (dayOfYear >= 121 && dayOfYear <= 151) {
                this.month = MAY;
                this.day = 31 - (151 - dayOfYear);

            } else if (dayOfYear >= 152 && dayOfYear <= 181) {
                this.month = JUN;
                this.day = 30 - (181 - dayOfYear);

            } else if (dayOfYear >= 182 && dayOfYear <= 212) {
                this.month = JUL;
                this.day = 31 - (212 - dayOfYear);

            } else if (dayOfYear >= 213 && dayOfYear <= 243) {
                this.month = AUG;
                this.day = 31 - (243 - dayOfYear);

            } else if (dayOfYear >= 244 && dayOfYear <= 273) {
                this.month = SEP;
                this.day = 30 - (273 - dayOfYear);

            } else if (dayOfYear >= 274 && dayOfYear <= 304) {
                this.month = OCT;
                this.day = 31 - (304 - dayOfYear);

            } else if (dayOfYear >= 205 && dayOfYear <= 334) {
                this.month = NOV;
                this.day = 30 - (334 - dayOfYear);

            } else if (dayOfYear >= 335 && dayOfYear <= 365) {
                this.month = DEC;
                this.day = 31 - (365 - dayOfYear);

            }
        }

        if (isLeapYear()) {
            if (dayOfYear >= 1 && dayOfYear <= 31) {
                this.month = JAN;
                this.day = dayOfYear;

            } else if (dayOfYear >= 32 && dayOfYear <= 60) {
                this.month = FEB;
                this.day = 29 - (60 - dayOfYear);

            } else if (dayOfYear >= 61 && dayOfYear <= 91) {
                this.month = MAR;
                this.day = 31 - (91 - dayOfYear);

            } else if (dayOfYear >= 92 && dayOfYear <= 121) {
                this.month = APR;
                this.day = 30 - (121 - dayOfYear);

            } else if (dayOfYear >= 122 && dayOfYear <= 152) {
                this.month = MAY;
                this.day = 31 - (152 - dayOfYear);

            } else if (dayOfYear >= 153 && dayOfYear <= 182) {
                this.month = JUN;
                this.day = 30 - (182 - dayOfYear);

            } else if (dayOfYear >= 183 && dayOfYear <= 213) {
                this.month = JUL;
                this.day = 31 - (213 - dayOfYear);

            } else if (dayOfYear >= 214 && dayOfYear <= 244) {
                this.month = AUG;
                this.day = 31 - (243 - dayOfYear);

            } else if (dayOfYear >= 245 && dayOfYear <= 274) {
                this.month = SEP;
                this.day = 30 - (274 - dayOfYear);

            } else if (dayOfYear >= 275 && dayOfYear <= 305) {
                this.month = OCT;
                this.day = 31 - (305 - dayOfYear);

            } else if (dayOfYear >= 206 && dayOfYear <= 335) {
                this.month = NOV;
                this.day = 30 - (334 - dayOfYear);

            } else if (dayOfYear >= 336 && dayOfYear <= 366) {
                this.month = DEC;
                this.day = 31 - (366 - dayOfYear);

            }
        }
    }
}
