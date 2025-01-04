package com.twobrotherscompany.listabilionaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void Manha (View view) {
        Intent intent = new Intent(getApplicationContext(), ListaFreeActivity.class);
        startActivity(intent);
    }

    public void Blog (View view) {
        Intent intent = new Intent(getApplicationContext(), BlogActivity.class);
        startActivity(intent);
    }

    public void VIP (View view) {
        Intent intent = new Intent(getApplicationContext(), ChecarVipActivity.class);
        startActivity(intent);
    }

    public void Sobre (View view) {
        Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
        startActivity(intent);
    }
}