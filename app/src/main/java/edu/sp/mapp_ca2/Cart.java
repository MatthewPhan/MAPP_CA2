package edu.sp.mapp_ca2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cart extends AppCompatActivity {
    final String TAG = "Cart";
    RecyclerView recyclerView;
    CartListAdapter mAdapter;
    JSONObject items = new JSONObject();
    TextView totalpricing;
    private Button button;
    private Button checkout;
    //    private JSONObject food;
    // store RequestQueue as a static to be shared in this app
    public static RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        queue = Volley.newRequestQueue(this);
        button = (Button) findViewById(R.id.cleared);
        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkingout();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleardata();
                openActivity();

            }
        });


        setupRecycler();
        connectToInternet();
//        totalprices();





    }
    void openActivity(){
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    void checkingout(){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    void connectToInternet(){

        // Instantiae the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://mapp-assignment2.firebaseio.com/Cart.json";

        // Request a string response from the provided Url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d(TAG, "Response is: " + response);

                        parseData(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "That didn't work!" + error.getMessage());
            }
        });

        // Add the request to the RequestQueue
        queue.add(stringRequest);
//        queue.add(stringRequest);
    }
    void parseData(String s){
        try {
            JSONObject jsonObject = new JSONObject(s);
            // once the data is loaded, update adpater for recyclerview
            MyData inst = new MyData();
            inst.setItems(jsonObject);
//           mAdapter.setItems(jsonObject);
            mAdapter.notifyDataSetChanged();
        }
        catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }
    void setupRecycler(){
        recyclerView = findViewById(R.id.recyclerViewed);
        mAdapter = new CartListAdapter(this, items);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    void cleardata(){
        String url = "https://mapp-assignment2.firebaseio.com/Cart.json";

        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Cart", "clear cart: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Cart", "that didn't work!");
            }
        }){
            @Override
            public byte[] getBody() throws AuthFailureError{
                try {
                    JSONObject obj1 = new JSONObject();
                    obj1.remove("name");
                    obj1.remove("price");
                    obj1.remove("quantity");

                    return obj1.toString().getBytes();
                }catch (Exception e){
                    Log.e("Cart",e.getMessage());
                }
                return super.getBody();
            }
            public String getBodyContentType(){
                return "application/json";
            }
        };

        queue.add(stringRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.spfoodmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_aboutus:
                openaboutus();
                return true;

            case R.id.action_settings:
                opensettings();
                return true;

            default:

        }
        return super.onOptionsItemSelected(item);
    }
    void openaboutus(){
        Intent intent = new Intent(this, aboutus.class);
        startActivity(intent);
    }
    void opensettings(){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);

    }
//    void totalprices(){
//        double totalprice= 0;
//        String stringdouble;
//        JSONArray jsonArray = MyData.names;
//            for (int position=0; position<jsonArray.length(); position++){
//                JSONObject objs = MyData.cartitems.getJSONObject(jsonArray.getString(position));
//                String doublestring = objs.getString("price");
//                totalprice += Double.parseDouble(doublestring);
//
//
//
//            }
//            stringdouble = Double.toString(totalprice);
//            totalpricing.setText(stringdouble);
//            totalpricing = (TextView) findViewById(R.id.totalprice);
//
//
//
//    }
//    void totalprices(double price){
//
//        JSONObject obj1 = food.getJSONObject(CartListAdapter.names.getString(i));
//    }
}
