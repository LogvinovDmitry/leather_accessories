package app.repository;

public class BagParam {
    private Integer bag_id;
    private String bag_name;
    private Integer bag_category;
    private String bag_description;
    private String bag_date_added;
    private Double bag_price;

    public Double getBag_price() {
        return bag_price;
    }

    public void setBag_price(Double bag_price) {
        this.bag_price = bag_price;
    }


    public String getBag_date_added() {
        return bag_date_added;
    }

    public void setBag_date_added(String bag_date_added) {
        this.bag_date_added = bag_date_added;
    }

    public String getBag_category_inf() {
        return bag_category_inf;
    }

    public void setBag_category_inf(String bag_category_inf) {
        this.bag_category_inf = bag_category_inf;
    }

    private String bag_category_inf;


    public Integer getBag_id() {
        return bag_id;
    }

    public void setBag_id(Integer bag_id) {
        this.bag_id = bag_id;
    }

    public String getBag_name() {
        return bag_name;
    }

    public void setBag_name(String bag_name) {
        this.bag_name = bag_name;
    }

    public Integer getBag_category() {
        return bag_category;
    }

    public void setBag_category(Integer bag_category) {
        this.bag_category = bag_category;
    }

    public String getBag_description() {
        return bag_description;
    }

    public void setBag_description(String bag_description) {
        this.bag_description = bag_description;
    }

    //  @Override
//    public String toString() {
//        return getClass().getSimpleName() + " (movies_id: " + movies_id + "; movie_title: " + movie_title + "; genre: " + genre + "; rating: " + rating + "; producer_id: " + producer_id + ")";
//    }
}
