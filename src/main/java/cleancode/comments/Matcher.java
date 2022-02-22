package cleancode.comments;

public class Matcher {
  public Matcher() {}

  public boolean match(int[] expected, int[] actual,
                       int clipLimit, int delta) {
    //We have removed the comments & on behalf of it one should make methods do it by making their names as comment by extracting methods from codes.
    clipToolargevalues(actual, clipLimit);
    if (isLengthDifference(expected, actual))
      return false;
    return isWithinExpectedDelta(expected, actual, delta);
  }

  private boolean isLengthDifference(int[] expected, int[] actual) {
    return actual.length != expected.length;
  }

  private boolean isWithinExpectedDelta(int[] expected, int[] actual, int delta) {
    for (int i = 0; i < actual.length; i++)
      if (Math.abs(expected[i] - actual[i]) > delta)
        return false;
    return true;
  }

  private void clipToolargevalues(int[] actual, int clipLimit) {
    for (int i1 = 0; i1 < actual.length; i1++)
      if (actual[i1] > clipLimit)
        actual[i1] = clipLimit;
  }

}
