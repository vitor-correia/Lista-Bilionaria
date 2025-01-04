package com.twobrotherscompany.listabilionaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListaVipActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private static final String Dia = "AAAAADia";
    private static final String Sinais = "AAAAASinais";

    private TextView textDia, textSinais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vip);

        textDia   = findViewById(R.id.textDia);
        textSinais = findViewById(R.id.textSinais);

        CarregarDia();
        CarregarSinais();
    }

    public void CarregarDia  () {
        final DatabaseReference Lista = referencia.child(Dia);
        Lista.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                textDia.setText( "Lembre-se, os sinais são para até 1 Martingale e o fuso horário é para UTC-3 São Paulo\n\n" + "Sinais para o dia " + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void CarregarSinais  () {
        final DatabaseReference Lista = referencia.child(Sinais);
        Lista.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                textSinais.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}