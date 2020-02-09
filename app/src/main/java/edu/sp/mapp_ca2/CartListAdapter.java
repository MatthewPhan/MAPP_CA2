package edu.sp.mapp_ca2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {
    double totalprice = 0;
    String stringdouble;
//    private JSONArray names;
//    private JSONObject cartitems;




    LayoutInflater inflater;


    public CartListAdapter(Context ctx, JSONObject obj){
        // Store a reference to the loaded JSONArray from the internet
//        MyData mydata = new MyData();
        MyData mydata = new MyData();
        mydata.setItems(obj);
//        setItems(obj);
        // get inflater for later use
        inflater = LayoutInflater.from(ctx);
    }
//    public JSONObject getItems(){
//        return cartitems;
//    }
//    public void setItems(JSONObject cartitems){
//
//        this.cartitems = cartitems;
//        // store the key names for easy use later to lessen processing load
//        names = cartitems.names();
//
//    }



    @NonNull
    @Override
    public CartListAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        // inflate xml layout for single row item
        View itemView = inflater.inflate(R.layout.recycler_item, parent, false);


        // Create view holder and return it
        return new CartViewHolder(itemView, this);
        // return null;

    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.CartViewHolder holder, int position){

        // retrieving data from array
        try {

            // get the json object at this new position
            final JSONObject obj = MyData.cartitems.getJSONObject(MyData.names.getString(position));
//            final JSONObject obj = cartitems.getJSONObject(names.getString(position));
            Log.d("Testing", "Price is: " + obj.getString("price"));




            Log.d("CartList", "Response is: " + obj);

            // Display the name in textview
            holder.tv.setText(obj.getString("name"));
            holder.tv2.setText(obj.getString("quantity"));
            holder.tv3.setText(obj.getString("price"));


        }
        catch (Exception e){
            Log.e("CartListAdapter", e.getMessage());
        }
    }

    @Override
    public int getItemCount(){

        return MyData.cartitems.length();
//        return cartitems.length();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView tv2;
        TextView tv3;


        CartListAdapter mAdapter;
        public CartViewHolder(View itemView, CartListAdapter adapter){
            super(itemView);

            // get the textview for the later use
            tv = itemView.findViewById(R.id.word);
            tv2 = itemView.findViewById(R.id.word2);
            tv3 = itemView.findViewById(R.id.word3);
            mAdapter = adapter;


        }
    }







}
