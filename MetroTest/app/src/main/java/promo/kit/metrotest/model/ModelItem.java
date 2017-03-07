package promo.kit.metrotest.model;

import java.util.ArrayList;
import java.util.List;

public class ModelItem {
    private String BILET = "Билет №";
    public static final String TABLE_ANSWER = "answer_tab";
    public static final String KEY_ID = "id";
    public static final String ANSWER = "answer";
    private int number;

    public ModelItem(String BILET, int number) {
        this.BILET = BILET;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBilet() {
        return BILET;
    }



}
