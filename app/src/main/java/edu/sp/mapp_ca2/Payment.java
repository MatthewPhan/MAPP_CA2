package edu.sp.mapp_ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        button = (Button) findViewById(R.id.paying);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thanks();
            }
        });

    }

    void thanks(){
        Intent intent = new Intent(this, Thankyou.class);
        startActivity(intent);
    }
}
