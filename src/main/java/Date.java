/**
 * This class provides various static methods that calculate various quantities
 * related to dates, including the day of week a date fall on.
 * @author
 * @version
 */
public class Date {
    /**
     * Returns true if the year is a leap year; otherwise false
     *
     * @param year the year
     * @return true if the year is a leap year; otherwise false.
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the name of the day given by dayValue
     *
     * @param dayValue Numerical value of the day in the range 0 to 6, inclusively
     * @return the name of the day given by dayValue
     */
    public static String getNameOfDay(int dayValue) {
        switch (dayValue) {
            case 0:
                return ("Sunday");
            case 1:
                return ("Monday");
            case 2:
                return ("Tuesday");
            case 3:
                return ("Wednesday");
            case 4:
                return ("Thursday");
            case 5:
                return ("Friday");
            case 6:
                return ("Saturday");
        }
        return null;
    }

    /**
     * \
     * Returns the numeric value of the month.
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param name name of the month
     * @return the numeric value of the month.
     */
    public static int getMonthNumber(String name) {
        if ("january".equalsIgnoreCase(name)) {
            return 1;
        }
        if ("february".equalsIgnoreCase(name)) {
            return 2;
        }
        if ("march".equalsIgnoreCase(name)) {
            return 3;
        }
        if ("april".equalsIgnoreCase(name)) {
            return 4;
        }
        if ("may".equalsIgnoreCase(name)) {
            return 5;
        }
        if ("june".equalsIgnoreCase(name)) {
            return 6;
        }
        if ("july".equalsIgnoreCase(name)) {
            return 7;
        }
        if ("august".equalsIgnoreCase(name)) {
            return 8;
        }
        if ("september".equalsIgnoreCase(name)) {
            return 9;
        }
        if ("october".equalsIgnoreCase(name)) {
            return 10;
        }
        if ("november".equalsIgnoreCase(name)) {
            return 11;
        }
        if ("december".equalsIgnoreCase(name)) {
            return 12;
        }
        return -1;
    }

    /**
     * Returns the name of the month given the numeric value provided by month
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param month Numeric value of the month.  Should be 1 to 12, inclusively
     * @return the name of the month given the numeric value provided by month
     */
    public static String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> null;
        };
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the numeric value of the month
     * @param year  year
     * @return the number of days in the month given by the parameter month
     */
    public static int getDaysInMonth(int month, int year) {
        if (month >= 1 && month <= 12) {
            switch (month) {
                case 1, 3, 5, 7, 8, 10, 12:
                    return 31;
                case 2:
                    if (Date.isLeapYear(year)) {
                        return 29;
                    }
                    return 28;
                case 4, 6, 9, 11:
                    return 30;
            }
        }
        return -1;
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the name of the month
     * @param year  year
     * @return the number of days in the month
     */
    public static int getDaysInMonth(String month, int year) {
        switch (month) {
            case "January", "March", "May", "July", "August", "October", "December":
                return 31;
            case "February":
                if (Date.isLeapYear(year)) {
                    return 29;
                }
                return 28;
            case "April", "June", "September", "November":
                return 30;
        }
        return -1;
    }

    /**
     * Returns the offset in days for the month relative to January
     *
     * @param month numeric value of the month
     * @param year  year
     * @return the offset in days for the month relative to January
     */
    public static int getMonthOffset(int month, int year) {
        switch (month) {
            case 1:
                return 0;
            case 2, 3:
                return 3;
        }
        switch (month) {
            case 1, 10:
                return 0;
            case 2, 3, 11:
                return 3;
            case 4, 7:
                return 6;
            case 5:
                return 1;
            case 6:
                return 4;
            case 8:
                return 2;
            case 9, 12:
                return 5;
            default:
                return -1;

        }
    }

    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      numeric value of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(int month, int dayOfMonth, int year) {
        int yearOffset = (int) (year + Math.floor((year - 1.0) / 4) - Math.floor((year - 1.0) / 100) + Math.floor((year - 1.0) / 400)) % 7;
        int monthOffset = Date.getMonthOffset(month, year);

        if (dayOfMonth > Date.getDaysInMonth(month, year) || month < 1 || month > 12) {
            return -1;
        }

        if (Date.isLeapYear(year)) {
            switch (month) {
                case 3, 5, 6, 8, 9, 10, 11, 12:
                    monthOffset++;
                    break;
                case 4, 7:
                    monthOffset = 0;
                    break;
            }
        }

        monthOffset = (monthOffset + yearOffset) % 7;
        monthOffset = (monthOffset + dayOfMonth - 1) % 7;

        return monthOffset;
    }
    /**
     * Returns the day of the week that the date falls on
     * @param month name of the month
     * @param dayOfMonth day of the month
     * @param year year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(String month,int dayOfMonth, int year){
        return dayOfWeek(getMonthNumber(month), dayOfMonth, year);
    }
}

