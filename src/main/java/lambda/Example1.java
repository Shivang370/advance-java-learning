package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Example1 {

  public static void main(String[] args) {
    // defining comparator
    /*Comparator<String> comparator= new Comparator<String>() {
      public int compare(String s1, String s2) {

        return Integer.compare(s1.length(), s2.length());
      }
    };*/
    Comparator<String> citycomparatorbylength=(s1,s2)->
      Integer.compare(s1.length(),s2.length());
    Comparator<String> cityComparisonbyAlpha=(s1,s2)-> s1.compareTo(s2);
    String[] cityNames = new String[] {"New Delhi", "Berlin", "Amsterdam"};

    Arrays.sort(cityNames, citycomparatorbylength.thenComparing(cityComparisonbyAlpha));

    for(String city : cityNames) {
      System.out.println(city);
    }
  }
}
