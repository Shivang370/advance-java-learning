package streamexamples;

import java.util.List;
import java.util.Set;

import static java.time.LocalDate.of;
import static java.util.Arrays.asList;
import static streamexamples.Category.*; //statically imported so directly name can be used
import static streamexamples.Category.TOYS;
import static streamexamples.Status.*;
import static streamexamples.Status.NEW;

public class DataGenerator {
  private Product grocessory1;
  private Product books1;
  private Product baby1;
  private Product books2;
  private Product baby2;
  private Product toys1;
  private Product grocessory2;
  private Product toys2;
  private Product grocessory3;
  private Product baby3;
  private Product books3;
  private Product books4;
  private Product baby4;
  private Product games1;
  private Product baby5;
  private Product toys3;

  public List<Product> products() {
    grocessory1 = new Product(1, "Pulses", GROCESSORY, 100.0);
    books1 = new Product(2, "Learning Java Streams", BOOKS, 55.0);
    baby1 = new Product(3, "Night light", BABY, 41.46);
    books2 = new Product(4, "The Great Gatsby", BOOKS, 697.57);
    baby2 = new Product(5, "Brib", BABY, 366.90);
    toys1 = new Product(6, "doll", TOYS, 95.50);
    grocessory2 = new Product(7, "Olive oil", GROCESSORY, 302.19);
    toys2 = new Product(8, "Ball", TOYS, 295.37);
    grocessory3 = new Product(9, "Frozen Food", GROCESSORY, 534.64);
    baby3 = new Product(10, "Bedding", BABY, 623.58);
    books3 = new Product(11, "To Kill a Mockingbird", BOOKS, 551.39);
    books4 = new Product(12, "War and Peace", BOOKS, 240.58);
    baby4 = new Product(13, "Humidifier", BABY, 881.38);
    games1 = new Product(14, "Airplane adventure", GAMES, 988.49);
    baby5 = new Product(15, "Clothes storage", BABY, 177.61);
    toys3 = new Product(16, "Kite", TOYS, 95.46);

    return asList(grocessory1, books1, baby1, books2, baby2, toys1, grocessory2, toys2, grocessory3, baby3, books3, books4, baby4, games1, baby5, toys3);
  }

  public List<Order> orders() {
    Customer stefan = new Customer(1, "Stefan", 1);
    Customer rob = new Customer(2, "Rob", 2);
    Customer james = new Customer(3, "James", 2);
    Customer robert = new Customer(4, "Robert", 0);
    Customer john = new Customer(5, "John", 1);
    Customer lily = new Customer(6, "Lily", 0);
    Customer olive = new Customer(7, "Olive", 2);
    Customer edward = new Customer(8, "Edward", 1);
    Customer dino = new Customer(9, "Dino", 2);
    Customer ava = new Customer(10, "Ava", 1);

    return asList(
      new Order(1, of(2011, 10, 20), of(2011, 10, 22), NEW, stefan, Set.of(grocessory1, books1)),
      new Order(2, of(2012, 1, 12), of(2012, 1, 15), NEW, rob, Set.of(toys1, baby5)),
      new Order(3, of(2012, 4, 15), of(2012, 4, 25), DELIVERED, lily, Set.of(books2, books3, toys3)),
      new Order(4, of(2010, 7, 22), of(2010, 7, 23), PENDING, edward, Set.of(grocessory2)),
      new Order(5, of(2013, 2, 19), of(2013, 2, 21), PENDING, olive, Set.of(toys3)),
      new Order(6, of(2010, 4, 2), of(2010, 4, 7), NEW, rob, Set.of(baby2)),
      new Order(7, of(2011, 6, 21), of(2011, 6, 26), NEW, lily, Set.of(baby2, grocessory3, books3, toys2, games1)),
      new Order(8, of(2012, 8, 24), of(2012, 8, 27), DELIVERED, rob, Set.of(books4)),
      new Order(9, of(2010, 11, 11), of(2010, 11, 13), NEW, dino, Set.of(games1)),
      new Order(10, of(2012, 5, 25), of(2012, 5, 26), DELIVERED, james, Set.of(grocessory3, games1)),
      new Order(11, of(2012, 9, 27), of(2012, 9, 28), PENDING, ava, Set.of(toys1, games1)),
      new Order(12, of(2013, 10, 4), of(2013, 10, 10), NEW, stefan, Set.of(baby1)),
      new Order(13, of(2011, 10, 10), of(2011, 10, 13), DELIVERED, john, Set.of(toys1)),
      new Order(14, of(2019, 12, 11), of(2019, 12, 19), PENDING, robert, Set.of(books1, books2, books3, books4)),
      new Order(15, of(2017, 6, 12), of(2017, 6, 16), NEW, james, Set.of(toys1, toys2, toys3))
    );
  }
}
