package com.cieep.a07_ejerciciosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        sp = getSharedPreferences(Constantes.LOGIN, MODE_PRIVATE);

        if (sp.getBoolean(Constantes.LOGGED, false)) {
            startActivity(new Intent(MainActivity.this, UserActivity.class));
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();

                if (email.equalsIgnoreCase("eduard@cieep.com") && pass.equalsIgnoreCase("12345")){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean(Constantes.LOGGED, true);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, UserActivity.class));
                    finish();
                }
            }
        });
    }
}