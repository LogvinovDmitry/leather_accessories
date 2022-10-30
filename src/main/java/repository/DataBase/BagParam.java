package repository.DataBase;

public class BagParam {
    private Integer bag_id;
    private String bag_name;
    private Integer bag_category;
    private String bag_description;



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
