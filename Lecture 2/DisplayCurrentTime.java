public class DisplayCurrentTime {
  public static void main(String[] args) {
    long totalMili = System.currentTimeMillis();

    long totalSec = totalMili / 1000;

    long currentSec = totalSec % 60;

    long totalMin = totalSec / 60;

    long currentMin = totalMin % 60;

    long totalHour = totalMin / 60;

    // Calculate GMT hour
    long currentHour_GMT = totalHour % 24;

    // Calculate GMT +8
    long currentHour_GMT8 = currentHour_GMT + 8;

    // Convert 24 hour to 12 hour format
    long currentHour_GMT8_12H = currentHour_GMT8 % 12;

    System.out.println("Current time is " + currentHour_GMT8_12H
    + ":" + currentMin + ":" + currentSec + " GMT +8 (Malaysia Time)");
  }
}
