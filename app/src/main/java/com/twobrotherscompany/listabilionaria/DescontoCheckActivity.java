package com.twobrotherscompany.listabilionaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DescontoCheckActivity extends AppCompatActivity {

    private EditText inputCupom;
    private TextView textCheck, textCupom1;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    private static final String Cupom1 = "AAACupom1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_check);

        inputCupom = findViewById(R.id.inputCupom);
        textCupom1 = findViewById(R.id.textCupom1);
        textCheck = findViewById(R.id.textCheck);

        CarregarCupom1();
    }

    public void Avancar (View view) {
        String Digitado = inputCupom.getText().toString();

        if (Digitado.equals( textCupom1.getText() ) ) {
            Intent intent = new Intent(getApplicationContext(), DescontoCinquentaActivity.class);
            startActivity(intent);
        } else {
            textCheck.setText("Cupom Inválido ou promoção finalizada");
        }

    }

    public void SemCupom (View view) {
            Intent intent = new Intent(getApplicationContext(), DescontoZeroActivity.class);
            startActivity(intent);
    }

    public void CarregarCupom1  () {
        final DatabaseReference Lista = referencia.child(Cupom1);
        Lista.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                textCupom1.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}