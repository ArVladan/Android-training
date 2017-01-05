package promo.kit.mycinema;

/**
 * Created by Влад on 03.01.17.
 */

public class Movie {
    private String name;
    private int posterId;

    public Movie(String name, int posterId){
        this.name = name;
        this.posterId = posterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }
}
