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

    //a b c d e f g
    String a = "Random Sayi  : ";
    String b = "Doğru Tahmin";
    String c = "Yanlış Tahminde Bulundunuz.";
    String d = "Kalan Hak : ";
    String e = "Tahmin hakkın bitti.";
    String f = "Oyun bitti..";
    String g = "Girlen Değer Boş Olamaz";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tanımlamalar
        txtKalanHak = findViewById(R.id.txtKalanHak);
        txtSonuc =  findViewById(R.id.txtSonucc);
        editTxtSayi =  findViewById(R.id.editTxtSayı);

        RndSayi = new Random();
        RandomSayi = RndSayi.nextInt(5);
        System.out.println(a+ RandomSayi);

    }

    @SuppressLint("SetTextI18n")
    public void btnTahminEt(View view) {
        GelenDeger = editTxtSayi.getText().toString();

        if (!TextUtils.isEmpty(GelenDeger)) {
            if (KalanHak > 0 && TahminDogrumu == false) {
                if (GelenDeger.equals(String.valueOf(RandomSayi))) {

                    SonucuGoster(b);
                    TahminDogrumu = true;
                } else {
                    txtSonuc.setText(c);
                    editTxtSayi.setText("");
                }
                KalanHak--;
                txtKalanHak.setText(d + KalanHak);
                if (KalanHak == 0 && TahminDogrumu == false) {
                    SonucuGoster((String) e);
                    editTxtSayi.setText(" ");
                }
            } else
                txtSonuc.setText(f);
        } else
            txtSonuc.setText(g);
    }

    private void SonucuGoster(String s) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(s);
    }
}