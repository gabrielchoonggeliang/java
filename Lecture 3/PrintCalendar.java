import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**
 * The PrintCalendar class provides methods to print a calendar for a given year and month.
 */
public class PrintCalendar {

  /**
   * The main method reads user input for the year and month, and prints the calendar for that month.
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    int year, month;
    Scanner input=new Scanner(System.in);
    System.out.print("Enter full year (e.g., 2012): ");
    year=input.nextInt();
    System.out.print("Enter month as a number between 1 and 12: ");
    month=input.nextInt();
    input.close();
    printMonth(year,month);
  }

  /**
   * The printMonth method prints the calendar for a given month.
   */
  public static void printMonth(int year, int month) {
    printMonthTitle(year, month);
    printMonthBody(year, month);
  }

  /**
   * The printMonthTitle method prints the title of the calendar for a given month.
   */
  public static void printMonthTitle(int year, int month) {
    System.out.println("         "+getMonthName(month)+" "+year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }

  /**
   * The getMonthName method returns the name of the month for a given month number.
   * @param month The month number.
   * @return The name of the month.
   */
  public static String getMonthName(int month) {
    String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
    return months[month-1];
  }

  /**
   * The printMonthBody method prints the body of the calendar for a given month.
   */
  public static void printMonthBody(int year, int month) {
    int startDay=getStartDay(year,month);
    int numberOfDaysInMonth=getNumberOfDaysInMonth(year,month);
    for(int i=0;i<startDay;i++){
      System.out.print("    ");
    }
    for(int i=1;i<=numberOfDaysInMonth;i++){
      System.out.printf("%4d",i);
      if((i+startDay)%7==0) System.out.println();
    }
    System.out.println();
  }

  /**
   * The getStartDay method returns the start day of the month for a given year and month.
   * @param year The year.
   * @param month The month.
   * @return The start day of the month.
   */
  public static int getStartDay(int year, int month) {
    final int START_DAY_FOR_JAN_1_1800=3;
    int totalNumberOfDays=getTotalNumberOfDays(year,month);
    return (totalNumberOfDays+START_DAY_FOR_JAN_1_1800)%7;
  }

  /**
   * The getNumberOfDaysInMonth method returns the number of days in a month for a given year and month.
   * @param year The year.
   * @param month The month.
   * @return The number of days in the month.
   */
  public static int getNumberOfDaysInMonth(int year, int month) {
    List<Integer> thirtyOne = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
    List<Integer> thirty = Arrays.asList(4, 6, 9, 11);
    if(month==2) return isLeapYear(year)?29:28;
    else if(thirtyOne.contains(month)) return 31;
    else if(thirty.contains(month)) return 30;
    else return 0;
  }

  /**
   * The getTotalNumberOfDays method returns the total number of days from January 1, 1800 to the given year and month.
   * @param year The year.
   * @param month The month.
   * @return The total number of days.
   */
  public static int getTotalNumberOfDays(int year, int month) {
    //use January 1, 1800 as the base date
    int total=0;
    for(int i=1800;i<year;i++){
      total+=isLeapYear(i)?366:365; //add 366 if leap year, 365 otherwise
    }
    //add days from January to the month prior to the calendar month
    for(int i=1;i<month;i++){
      total+=getNumberOfDaysInMonth(year,i); //add days using getNumberOfDaysInMonth
    }
    return total;
  }

  /**
   * The isLeapYear method returns true if the given year is a leap year, false otherwise.
   * @param year The year.
   * @return True if the year is a leap year, false otherwise.
   */
  public static boolean isLeapYear(int year) {
    // implementation
    return year%400==0||(year%4==0&&year%100!=0);
  }
}
