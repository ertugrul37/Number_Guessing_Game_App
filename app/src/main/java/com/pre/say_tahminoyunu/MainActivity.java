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
    private int KalanHak = 3, RandomSayi;
    private Random RndSayi;
    private boolean TahminDogrumu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tanımlamalar
        Metinler metinler = new Metinler();
        txtKalanHak = findViewById(R.id.txtKalanHak);
        txtSonuc =  findViewById(R.id.txtSonucc);
        editTxtSayi =  findViewById(R.id.editTxtSayı);

        RndSayi = new Random();
        RandomSayi = RndSayi.nextInt(5);
        System.out.println(metinler.a+ RandomSayi);

    }
    public void btnTahminEt(View view) {
        Metinler metinler = new Metinler();
        GelenDeger = editTxtSayi.getText().toString();

        if (!TextUtils.isEmpty(GelenDeger)) {
            if (KalanHak > 0 && TahminDogrumu == false) {
                if (GelenDeger.equals(String.valueOf(RandomSayi))) {

                    SonucuGoster(metinler.b);
                    TahminDogrumu = true;
                } else {
                    txtSonuc.setText(metinler.c);
                    editTxtSayi.setText("");
                }
                KalanHak--;
                txtKalanHak.setText(metinler.d + KalanHak);
                if (KalanHak == 0 && TahminDogrumu == false) {
                    SonucuGoster(metinler.e);
                    editTxtSayi.setText(" ");
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