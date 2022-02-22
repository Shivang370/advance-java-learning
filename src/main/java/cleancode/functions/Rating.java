package cleancode.functions;

import org.apache.commons.lang3.StringUtils;

public class Rating {

  private final String rating;

  public Rating(String rating) {
    this.rating = rating;
  }

  public boolean isValidRating() {
    //Guard clause :as it is guarding the function, check all things require for function to run , so control remains over one function
    if (this.getRating() == null)
       return false;
    return (isValid_B_Rating() ||isValid_A_Rating());


  }
  public boolean isValid_A_Rating()
  {
    if (this.getRating().substring(0, 1).equalsIgnoreCase("A")
            && this.getRating().length() == 3
            && StringUtils.isNumeric(this.getRating().substring(1, 3))) {
      return true;
    }
    return false;
  }
  public boolean isValid_B_Rating()
  {
    if (this.getRating().substring(0, 1).equalsIgnoreCase("B") &&
            this.getRating().length() == 2 && StringUtils.isNumeric(this.getRating().substring(1, 2))
              && Integer.parseInt(this.getRating().substring(1, 2)) > 0
              && Integer.parseInt(this.getRating().substring(1, 2)) < 5) {
        return true;
      }
    return false;
  }

  private String getRating() {
    return rating;
  }

}
