package streamexamples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sun.tools.doclint.Entity.and;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamTest {
  List<Product> products;
  List<Order> orders;

  @BeforeEach
  public void setup() {
    DataGenerator data = new DataGenerator();
    products = data.products();
    orders = data.orders();
  }

  @Test
  @DisplayName("Get a list of products belonging to category 'Books' with price > 50")
  public void exercise1() {
    List<Product> expectedProducts = null;
    expectedProducts=products.stream()
            .filter(p->p.getCategory().equals(Category.BOOKS.toString()))
            .filter(p->p.getPrice()>50)
            .peek(System.out::println)
            .collect(Collectors.toList());

    assertEquals(4, expectedProducts.size());
  }

  @Test
  @DisplayName("Get a list of products belonging to category 'Books' and price > 50 (using Predicate chaining for filter)")
  public void exercise2() {
    List<Product> expectedProducts = null;
    Predicate<Product> isBookCategory=(B)->B.getCategory().equals(Category.BOOKS.toString());
    Predicate<Product> ispriceabove50=(P)->P.getPrice()>50;
        expectedProducts=products.stream()
                .filter(isBookCategory.and(ispriceabove50))
                .peek(System.out::println)
                .collect(Collectors.toList());
    assertEquals(4, expectedProducts.size());
  }

  @Test
  @DisplayName("Get a list of products belonging to category 'Books' and price > 50 (using BiPredicate for filter)")
  public void exercise3() {
    List<Product> expectedProducts = null;
    BiPredicate<String,Double> hasbookandpricemorethan50=
            (category,bookprice)->category.equals(Category.BOOKS.toString())&& bookprice>50;
              expectedProducts=products.stream()
                                       .filter(p->hasbookandpricemorethan50.test(p.getCategory(),p.getPrice()))
                                        .collect(Collectors.toList());
              //******@ second way of doing this
//    List<Product> expectedProducts = null;
//    expectedProducts=products.stream()
//            .filter(p->p.getCategory().equals(Category.BOOKS.toString())&&p.getPrice()>50)
//            .peek(System.out::println)
//            .collect(Collectors.toList());
    assertEquals(4, expectedProducts.size());
  }

  @Test
  @DisplayName("Get a list of orders with products belonging to category 'Grocessory'")
  public void exercise4() {
    List<Product> expectedOrders = null;
    
    assertEquals(4, expectedOrders.size());
  }

  @Test
  @DisplayName("Get a list of products with category as GAMES and apply 15% discount")
  public void exercise5() {
    List<Product> expectedProducts = null;
    expectedProducts=products.stream()
            .filter(p->p.getCategory().equals(Category.GAMES.toString()))
            .map(p->p.withPrice(p.getPrice()*0.85))
            .peek(System.out::println)
            .collect(Collectors.toList());
    assertEquals(1, expectedProducts.size());
  }

  @Test
  @DisplayName("Get a list of products ordered by customer of tier 2 between 01-Apr-2010 and 31-Aug-2010")
  public void exercise6() {
    List<Order> expectedOrders = null;

    assertEquals(1, expectedOrders.size());
  }

  @Test
  @DisplayName("Get the cheapest products from Toys category")
  public void exercise7() {
    List<Product> expectedProducts = null;
//    expectedProducts=products.stream()
//            .filter(p->p.getCategory().equals(Category.TOYS.toString()))
//            .min(Comparator.comparing(Product::getPrice))
//            //.sorted(Comparator.comparing(Product::getPrice))
//             .findFirst();
    //assertEquals(95.46, expectedProducts.getPrice());
  }

  @Test
  @DisplayName("Get the 3 most recent placed order")
  public void exercise8() {
    List<Order> result = null;
    result=orders.stream()
                  .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                   .limit(3)
                    .collect(Collectors.toList());

    assertEquals(3, result.size());
  }

}