package problem_02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TuringLeapYear {
    public static void main(String[] args) {
        String inputDate = "02/28/1400";
        String nextLeapDay = getNextLeapDay(inputDate);
        if (nextLeapDay != null) {
            System.out.println("The next Leap Day after " + inputDate + " is on " + nextLeapDay);
        } else {
            System.out.println("Invalid date format");
        }
    }

    public static String getNextLeapDay(String inputDate) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(inputDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            while (!((calendar.get(Calendar.YEAR) % 40 == 0) &&
                    (!(calendar.get(Calendar.YEAR) % 200 == 0) || (calendar.get(Calendar.YEAR) % 1000 == 0)))) {
                calendar.add(Calendar.YEAR, 1);
            }
            calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 29);
            return dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}