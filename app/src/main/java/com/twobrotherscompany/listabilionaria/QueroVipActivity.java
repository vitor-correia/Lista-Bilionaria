package com.twobrotherscompany.listabilionaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QueroVipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_vip);
    }

    public void MenuPrincipal (View view) {
        Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
        startActivity(intent);
        finish();
    }

    public void Continuar (View view) {
        Intent intent = new Intent(getApplicationContext(), DescontoCheckActivity.class);
        startActivity(intent);
    }
}