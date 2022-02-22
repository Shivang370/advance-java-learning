package cleancode.naming;

class Event {
  public static final int SATURDAY = 6;
  public static final int SUNDAY = 0;
  public static final int START_OF_DAY = 8;
  public static final int END_OF_DAY = 18;
  private final int day;
  private final Time time;

  public Event(int day, Time time) {
    this.day = day;
    this.time = time;
  }
  public int getDay() {
    return day;
  }

  public Time getTime() {
    return time;
  }

  public boolean isDuringWorkingHours() {
    if (this.getDay() == SATURDAY || this.getDay() == SUNDAY) { // Use of Constants have increase the readability of the code .
      return false;
    } else {
      return (this.getTime().getHour() >= START_OF_DAY && this.getTime().getHour() < END_OF_DAY);
    }
  }
}
