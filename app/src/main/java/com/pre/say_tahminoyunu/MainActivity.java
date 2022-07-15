package com.pre.say_tahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtKalanHak, txtSonuc;
    private EditText editTxtSayi;
    private String GelenDeger;
    private int RandomSayi;
    private boolean TahminDogrumu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tanımlamalar
        Metinler metinler = new Metinler();
        txtKalanHak = findViewById(R.id.txtKalanHak);
        txtSonuc = findViewById(R.id.txtSonucc);
        editTxtSayi = findViewById(R.id.editTxtSayı);

        //Random Sayı üretme
       RandomSayi =new Random().nextInt(metinler.a_Deger);
       System.out.println(metinler.a + RandomSayi);
    }

    public void btnTahminEt(View view) {
        Metinler metinler = new Metinler();
        GelenDeger = editTxtSayi.getText().toString();
        if (!TextUtils.isEmpty(GelenDeger)) {
            if (metinler.k_Deger > metinler.ab_Deger && TahminDogrumu == false) {
                if (GelenDeger.equals(String.valueOf(RandomSayi))) {
                    SonucuGoster(metinler.b);
                    TahminDogrumu = true;
                } else {
                    txtSonuc.setText(metinler.c);
                    editTxtSayi.setText(metinler.ab);
                }
                metinler.k_Deger--;
                txtKalanHak.setText(metinler.d + metinler.k_Deger);
                if (metinler.k_Deger == metinler.ab_Deger && TahminDogrumu == false) {
                    SonucuGoster(metinler.e);
                    editTxtSayi.setText(metinler.ac);
                }
            } else
                txtSonuc.setText(metinler.f);
        } else
            txtSonuc.setText(metinler.g);
    }

    private void SonucuGoster(String s) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(s);
    }
}