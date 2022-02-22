package lambda;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> predicate=(s)->s.length()<20;
        System.out.println(predicate.test("Ashish"));
    }
}
