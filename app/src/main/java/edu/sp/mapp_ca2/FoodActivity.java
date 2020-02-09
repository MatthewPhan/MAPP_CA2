package edu.sp.mapp_ca2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FoodActivity extends AppCompatActivity {

    private MenuOpenHelper mDB;

    private static final String TAG = MainActivity.class.getSimpleName();

    public static final int WORD_EDIT = 1;
    public static final int WORD_ADD = -1;

    private RecyclerView mRecyclerView;
    private MenuListAdapter mAdapter;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        button = (Button) findViewById(R.id.orderfood);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openorderfood();
            }
        });

        mDB = new MenuOpenHelper(this);

        // Create recycler view.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // Create an mAdapter and supply the data to be displayed.
        mAdapter = new MenuListAdapter(this, mDB);

        // Connect the mAdapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);

        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //For fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.cartfab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCartFAB();
            }
        });

    }

    public void openorderfood(){
        Intent intent = new Intent(this, Orderingfood.class);
        startActivity(intent);
    }

    public void openCartFAB(){
        Intent intent = new Intent(this, Cart.class);
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

 /*   public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);



    }*/
}
