package cleancode.naming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTest {

  @Test
  public void
  Should_return_true_when_the_event_occoured_is_during_working_hours() {
    Time time = new Time(10);
    Event event = new Event(4, time);

    assertTrue(event.isDuringWorkingHours());
  }

  @Test public void
  Should_return_false_when_the_event_occoured_after_working_hours() {
    Time time = new Time(20);
    Event event = new Event(4, time);

    assertFalse(event.isDuringWorkingHours());
  }

  @Test public void
  Should_return_false_when_the_event_occoured_during_working_hours_in_non_working_day() {
    Time time = new Time(20);
    Event event = new Event(6, time);

    assertFalse(event.isDuringWorkingHours());
  }
}