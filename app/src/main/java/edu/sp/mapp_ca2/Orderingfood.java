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

public class Orderingfood extends AppCompatActivity {
    EditText foodcater;
    Button button;
    String food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderingfood);

        foodcater = (EditText)findViewById(R.id.foodname);
        button = (Button) findViewById(R.id.buttontoorder);
        Log.d("Orderingfood", "Food? " + foodcater);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                food = foodcater.getText().toString();
                Log.d("Orderingfood", "What is food: " + food);
                if (food.equals("Chicken Chop")){
                    Openactivity1();
                }else if (food.equals("Spaghetti")){
                    Openactivity2();
                }else if (food.equals("Fish")){
                    Openactivity3();
                }else{
                    Log.d("Ordering food", "Food is: " + food);
                    Openactivity4();
                }
            }
        });
//        if (food == "Chicken Chop"){
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Openactivity1();
//
//
//                }
//            });
//
//        }else if (food == "Beef Steak"){
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Openactivity2();
//                }
//            });
//        }else if (food == "Fish Fillet"){
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Openactivity3();
//                }
//            });
//        }else {
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Openactivity4();
//                }
//            });
//
//        }


    }

    void Openactivity1(){
        Intent intent = new Intent(this, Westernfood.class);
        startActivity(intent);
    }

    void Openactivity2(){
        Intent intent = new Intent(this, Beefsteak.class);
        startActivity(intent);
    }


    void Openactivity3(){
        Intent intent = new Intent(this, Fish.class);
        startActivity(intent);
    }

    void Openactivity4(){
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
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
