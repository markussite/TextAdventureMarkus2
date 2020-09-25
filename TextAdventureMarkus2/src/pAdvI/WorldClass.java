package pAdvI;

import java.util.HashMap;

public class WorldClass {
    HashMap<String, Item> items = new HashMap<>();
    Item test, faust, welik;

    public void createItems(){
        items.put("Fist", faust = new Item("Fist", 1));
        items.put("Bycicle", welik = new Item("Bycicle", 5));

    }
}
