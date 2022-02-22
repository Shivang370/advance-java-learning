package basket;

import java.util.Iterator;
import java.util.List;

public class Basket {
  private List<Item> items;

  Basket(List<Item> items) {
    this.items = items;
  }

  public float getBasketTotal() {
    Iterator<Item> iterator = items.iterator();
    float basketTotal = 0.0f;
    while(iterator.hasNext()) { //Right now it is checking a boolean condition ,for(Item item:this.items) can also be used
      Item item = iterator.next();
      basketTotal = basketTotal + item.getTotalPrice();
    }
    return basketTotal;
  }
  //feature envy is a type of code smell : it shows that basket is using the items function & it is not required , so it isnt a good coding practice.
  // if we have the get total price function over here.


}

