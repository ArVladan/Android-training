package promo.kit.mycinema;

import java.io.Serializable;

/**
 * Created by Влад on 03.01.17.
 */

public class Movie implements Serializable {
    private int posterId;
    private String time;
    private String ganre;
    private String year;
    private String detail;

    public Movie(int posterId, String year, String ganre, String time, String detail) {
        this.posterId = posterId;
        this.ganre = ganre;
        this.year = year;
        this.time = time;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }
}
