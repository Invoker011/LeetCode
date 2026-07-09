package Number_of_Days_Between_two_Days;

public class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int days1 = countDays(date1);
        int days2 = countDays(date2);
        return Math.abs(days1-days2);
        
    }
    private int countDays(String date){
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int days = Integer.parseInt(parts[2]);
        int totalDays =  0;
        for(int y = 1971; y <year; y ++){
            if(isLeapYear(y)){
                totalDays +=366;
            }else{
                totalDays += 365;
            }
        }
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(isLeapYear(year)){
            daysInMonth[1] = 29;
        }

        for(int m = 1; m < month; m++){
            totalDays += daysInMonth[m - 1];
        }

        totalDays += days;

        return totalDays;

    }
    private boolean isLeapYear(int year){
        return year % 400 == 0 ||(year%4 ==0 && year %100!=0);
    }

    
}
