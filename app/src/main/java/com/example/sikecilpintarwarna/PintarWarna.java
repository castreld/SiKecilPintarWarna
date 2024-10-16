package com.example.sikecilpintarwarna;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PintarWarna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pintar_warna);

        Button backButton = findViewById(R.id.backButton), menuButton = findViewById(R.id.menuButton), nextButton = findViewById(R.id.nextButton);
        ImageView ballOut = findViewById(R.id.ballOut), playButton = findViewById(R.id.playButton);
        TextView colorOut = findViewById(R.id.colorOut);
        final MediaPlayer[] player = {null};

        final int[] index = {0};
        int[] imageResource = {0, 1, 2, 3, 4, 5, 6, 7}, audioResource = {0, 1, 2, 3, 4, 5, 6, 7}, color = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        String[] textResource = {"P U T I H", "M E R A H", "J I N G G A", "K U N I N G", "H I J A U", "B I R U", "N I L A", "U N G U"};

        audioResource[0] = R.raw.bola_putih;
        audioResource[1] = R.raw.bola_merah;
        audioResource[2] = R.raw.bola_jingga;
        audioResource[3] = R.raw.bola_kuning;
        audioResource[4] = R.raw.bola_hijau;
        audioResource[5] = R.raw.bola_biru;
        audioResource[6] = R.raw.bola_nila;
        audioResource[7] = R.raw.bola_ungu;

        imageResource[0] = R.drawable.base_bola;
        imageResource[1] = R.drawable.red_ball;
        imageResource[2] = R.drawable.orange_ball;
        imageResource[3] = R.drawable.yellow_ball;
        imageResource[4] = R.drawable.green_ball;
        imageResource[5] = R.drawable.blue_ball;
        imageResource[6] = R.drawable.indigo_ball;
        imageResource[7] = R.drawable.purple_ball;

        color[0] = Color.parseColor("#FFFFFF"); //Putih
        color[1] = Color.parseColor("#FF0000"); //Merah
        color[2] = Color.parseColor("#ff6600"); //Jingga
        color[3] = Color.parseColor("#ffff00"); //Kuning
        color[4] = Color.parseColor("#66ff33"); //Hijau
        color[5] = Color.parseColor("#0066ff"); //Biru
        color[6] = Color.parseColor("#9900cc"); //Nila
        color[7] = Color.parseColor("#ff66ff"); //Ungu
        color[8] = Color.parseColor("#000000");

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PintarWarna.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index[0]++;

                if (index[0] >= imageResource.length) {
                    index[0] = 0;
                }

                ballOut.setImageResource(imageResource[index[0]]);
                colorOut.setText(textResource[index[0]]);
                colorOut.setTextColor(color[index[0]]);

                if(textResource[index[0]].equals("P U T I H") || textResource[index[0]].equals("K U N I N G") || textResource[index[0]].equals("H I J A U")) {
                    colorOut.setShadowLayer(7,0,0, color[8]);
                }else {
                    colorOut.setShadowLayer(0,0,0, color[0]);
                }

                if (player[0] != null) {
                    player[0].release();
                    player[0] = null;
                }

                player[0] = MediaPlayer.create(PintarWarna.this, audioResource[index[0]]);
                player[0].start();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index[0]--;

                if (index[0] < 0) {
                    index[0] = imageResource.length - 1;
                }

                ballOut.setImageResource(imageResource[index[0]]);
                colorOut.setText(textResource[index[0]]);
                colorOut.setTextColor(color[index[0]]);

                if(textResource[index[0]].equals("P U T I H") || textResource[index[0]].equals("K U N I N G") || textResource[index[0]].equals("H I J A U")) {
                    colorOut.setShadowLayer(7,0,0, color[8]);
                }else {
                    colorOut.setShadowLayer(0,0,0, color[0]);
                }

                if (player[0] != null) {
                    player[0].release();
                    player[0] = null;
                }

                player[0] = MediaPlayer.create(PintarWarna.this, audioResource[index[0]]);
                player[0].start();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player[0] != null) {
                    player[0].release();
                    player[0] = null;
                }

                player[0] = MediaPlayer.create(PintarWarna.this, audioResource[index[0]]);
                player[0].start();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}