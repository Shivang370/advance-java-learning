package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Runner {

  public static void main(String[] args) {
    Person fred = new Person("Fred", "Smith", 56);
    Person maria = new Person("Maria", "Gracia", 43);
    Person rob  = new Person("Rob", "Hartman", 36);
    Person aryan  = new Person("Aryan", "Hartman", 36);


    // TODO: Write comparators (firstname and age) for Person using lambda expressions.
    //  Apply comparators for sorting person list
    //  When the age is same, it should compare the firstname
    List<Person> person=asList(fred,maria,rob,aryan);
    // Use of lambda Expression
    /*Comparator<Person> agecomparator=(p1,p2)->Integer.compare(p1.getAge(),p2.getAge()) ;
    Comparator<Person> firstnamecomparator=(p1,p2)->p1.getFirstName().compareTo(p2.getFirstName());*/
    //Use of method references
    Comparator<Person> agecomparator= Comparator.comparingInt(Person::getAge);
    Comparator<Person> firstnamecomparator= Comparator.comparing(Person::getFirstName);
    Collections.sort(person,agecomparator.thenComparing(firstnamecomparator));
    for(Person names : person) {
      System.out.println(names.getFirstName()+" : "+names.getAge());
    }
  }
}
