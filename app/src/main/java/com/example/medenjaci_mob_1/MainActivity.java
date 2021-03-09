package com.example.medenjaci_mob_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username, password;

    String[] users = {"admin", "kupac", "a"};
    String[] pass = {"admin", "lozinka", "a"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // action bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        // login
        login = (Button) findViewById(R.id.Prijava);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prijava();
            }
        });
    }

    private void prijava(){
        String u = username.getText().toString().trim();
        String p = password.getText().toString().trim();

        Intent intent = new Intent(this, KupacGlavnaActivity.class);
        for(int i = 0; i < users.length; i++){
            if(users[i].equals(u)){
                if(pass[i].equals(p)){
                    startActivity(intent);
                    return;
                }else{
                    Toast.makeText(this, "Neispravna lozinka", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
        Toast.makeText(this, "Username ili lozinka nisu ispravni!", Toast.LENGTH_LONG).show();
    }
}