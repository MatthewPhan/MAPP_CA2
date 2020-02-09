package edu.sp.mapp_ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Fish extends AppCompatActivity {
    private Button button;
    TextView named;
    TextView priced;
    EditText quantities;
    String name;
    double price;
    int quantity;
    double totalprice;

    public static RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
        queue = Volley.newRequestQueue(this);
        button = (Button) findViewById(R.id.addtocart);
        named = (TextView) findViewById(R.id.titlefish);
        priced = (TextView) findViewById(R.id.fishpricing);
        quantities = (EditText) findViewById(R.id.fishquantityedit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = named.getText().toString();
                price = Double.parseDouble(priced.getText().toString());
                quantity = Integer.parseInt(quantities.getText().toString());
                totalprice = price * quantity;
                sendData(name, totalprice, quantity);
                openActivity1();
            }
        });

    }
    void openActivity1(){
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }

    void sendData(String name, double price, int quantity){
        String url = "https://mapp-assignment2.firebaseio.com/Cart.json";
        final String n = name;
        final double p = price;
        final int q = quantity;


        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Westernfood", "Response is: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Westernfood", "That didn't work!");
            }
        }){
            // This is the inner class for StringRequest
            // format the body content of this request to be sent to the network
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {

                    // Set up a JSON Object
                    JSONObject obj = new JSONObject();
                    obj.put("name",n);
                    obj.put("price", p);
                    obj.put("quantity", q);


                    Log.d("WesternJSON", obj.toString());
                    // send the bytes
                    return obj.toString().getBytes();

                }
                catch (Exception e){
                    Log.e("WesternJson", e.getMessage());
                }
                return super.getBody();
            }
            // Set the content type to json
            @Override
            public String getBodyContentType(){
                return "application/json";

            }
        };


        // Add the request to the RequestQueue
        // reuse the queue by setting it as static variable in MainActivity
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
}
