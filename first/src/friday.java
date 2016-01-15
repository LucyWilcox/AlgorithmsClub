/*
ID: lucy.wi1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class friday {
    static Month month;
    static Day day;
    static int monthInt;
    static int dayInt;
    static int year = 1900;
    public static void main (String [] args) throws IOException {
        Scanner scanner = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int years =  scanner.nextInt();
        int stopYear = year + years;
        String printString = "";
        HashMap<String, Integer> fridays = new HashMap<String, Integer>();
        fridays.put("SATURDAY", 0);
        fridays.put("SUNDAY", 0);
        fridays.put("MONDAY", 0);
        fridays.put("TUESDAY", 0);
        fridays.put("WEDNESDAY", 0);
        fridays.put("THURSDAY", 0);
        fridays.put("FRIDAY", 0);
        month = Month.JANUARY;
        day = Day.MONDAY;
        String[] dayList = new String[7];

        while (year < stopYear) {
            int days = monthLength(year);
            for (int i = 1; i <= days; i++) {
                monthInt = month.getCode();
                dayInt = day.getCode();
                if(i == 13){
                    int curFridays = fridays.get(day.toString());
                    fridays.put(day.toString(), curFridays + 1);
                }
                if (dayInt != 7) {
                    day = Day.fromCode(dayInt + 1);
                } else {
                    day = Day.fromCode(1);
                }
                if (i == days) {
                    if (monthInt != 12) {
                        month = Month.fromCode(monthInt + 1);
                    } else {
                        month = Month.fromCode(1);
                        year ++;
                    }
                }
            }
        }

        for (int i = 0; i < dayList.length; i++){
            dayList[i] = Day.fromCode(i + 1).toString();
        }
        for(int i = 0; i < 7; i++){
            String dayString = dayList[i];
            int fridaysInt = Integer.parseInt(fridays.get(dayString).toString());
            printString = printString + fridaysInt + " ";
        }
        printString = printString.substring(0,printString.length()-1);
        out.println(printString);
        out.close();
    }
    public static int monthLength(int year) {
        int monthLength = 0;
        switch (month) {
            case SEPTEMBER: case APRIL: case JUNE: case NOVEMBER:
                monthLength = 30;
                break;
            case JANUARY: case MARCH: case MAY: case JULY:
            case AUGUST: case OCTOBER: case DECEMBER:
                monthLength = 31;
                break;
            case FEBRUARY:
                if(year % 100 == 0){
                    if(year % 400 == 0){
                        monthLength = 29;
                    }
                    else {
                        monthLength = 28;
                    }
                }
                else if(year % 4 == 0){
                    monthLength = 29;
                }
                else {
                    monthLength = 28;
                }
                break;
        }
        return monthLength;
    }

    public enum Day {
        SATURDAY(1), SUNDAY(2), MONDAY(3), TUESDAY(4), WEDNESDAY(5),
        THURSDAY(6), FRIDAY(7);
        private int code;
        Day(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }
        public static Day fromCode(int code) {
            for (Day d : Day.values()) {
                if (d.code == code) {
                    return d;
                }
            }
            throw new IllegalArgumentException("Invalid day code: " + code);
        }
    }
    public enum Month {
        JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
        JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
        private int code;
        Month(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }
        public static Month fromCode(int code) {
            for (Month m : Month.values()) {
                if (m.code == code) {
                    return m;
                }
            }
            throw new IllegalArgumentException("Invalid month code: " + code);
        }
    }
}
