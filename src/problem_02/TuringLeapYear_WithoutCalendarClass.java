package problem_02;


public class TuringLeapYear_WithoutCalendarClass {
    public static void main(String[] args) {
        String date = "02/28/1400";
        try {
            System.out.println(nextLeapDay(date));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use MM/DD/YYYY");
        }
    }

    public static String nextLeapDay(String date) throws Exception {
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 0) {
            throw new Exception("Invalid date");
        }
        year++;
        while (!((year % 40 == 0 && year % 200 != 0) || year % 1000 == 0)) {
            year++;
        }
        return "02/31/" + year;
    }

}
