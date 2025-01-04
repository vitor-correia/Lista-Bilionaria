package com.twobrotherscompany.listabilionaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListaFreeActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private static final String Dia = "AAAAADia";
    private static final String Sinais = "AAAAASinais";
    private TextView textDia, textSinais;
    private FrameLayout frameReward;
    private ScrollView scrollLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_free);

        frameReward = findViewById(R.id.frameReward);
        frameReward.setVisibility(View.VISIBLE);

        scrollLista = findViewById(R.id.scrollLista);
        scrollLista.setVisibility(View.INVISIBLE);

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

    public void QueroVip (View view) {
        Intent intent = new Intent(getApplicationContext(), QueroVipActivity.class);
        startActivity(intent);
    }
}