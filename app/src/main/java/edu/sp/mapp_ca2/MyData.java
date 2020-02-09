package edu.sp.mapp_ca2;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyData {
    public static JSONArray names;
    public static JSONObject cartitems;

    public JSONObject getItems(){
        return cartitems;
    }
    public void setItems(JSONObject cartitems){

        this.cartitems = cartitems;
        // store the key names for easy use later to lessen processing load
        names = cartitems.names();

    }







}
