package com.itsoeh.jmendoza.evaluacionae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CambiarPassword extends AppCompatActivity {

    private Button btn_login_back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_password);

        btn_login_back2 = findViewById(R.id.chapass_btn_back);
        btn_login_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}