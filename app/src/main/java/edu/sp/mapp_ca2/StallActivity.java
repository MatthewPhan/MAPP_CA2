package edu.sp.mapp_ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StallActivity extends AppCompatActivity {


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stall);
        button = (Button) findViewById(R.id.WesternStall);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmenu();
            }
        });
    }

    public void openmenu(){
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
