package promo.kit.metrotest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 31.01.17.
 */
public class ModelItem {
    private String BILET = "Билет №";
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

//    public static List<ModelItem> getFakeItems() {
//        ArrayList<ModelItem> biletList = new ArrayList<>();
//        for(int i = 0; i < 15; i++) {
//            biletList.add(new ModelItem("Билет №", ++i));
//            i--;
//        }
//        return biletList;
//    }


}
