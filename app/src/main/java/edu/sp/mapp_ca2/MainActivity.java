package edu.sp.mapp_ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //reset style back to app original theme to remove launch screen
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.LogInBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });
    }

    public void openLogIn() {
        EditText username =  (EditText) findViewById(R.id.text_username);
        EditText password = (EditText) findViewById(R.id.text_password);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        Log.d(TAG, "The username is " + user);
        Log.d(TAG, "The passsord is " + pass);

        if(user.equals("root") && pass.equals("123")){
            Intent intent = new Intent(this, FCActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_LONG).show();
        }

    }
}
