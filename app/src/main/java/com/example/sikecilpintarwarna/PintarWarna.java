package com.example.sikecilpintarwarna;

import android.content.Intent;
import android.graphics.Color;
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
        ImageView ballOut = findViewById(R.id.ballOut);
        TextView colorOut = findViewById(R.id.colorOut);

        final int[] index = {0};
        int[] imageResource = {0, 1, 2, 3, 4, 5, 6}, color = {0, 1, 2, 3, 4, 5, 6};
        String[] textResource = {"PUTIH", "JINGGA", "KUNING", "HIJAU", "BIRU", "NILA", "UNGU"};

        imageResource[0] = R.drawable.base_bola;
        imageResource[1] = R.drawable.orange_ball;
        imageResource[2] = R.drawable.yellow_ball;
        imageResource[3] = R.drawable.green_ball;
        imageResource[4] = R.drawable.blue_ball;
        imageResource[5] = R.drawable.indigo_ball;
        imageResource[6] = R.drawable.purple_ball;

        color[0] = R.color.black;
        color[1] = Color.parseColor("#ff6600");
        color[2] = Color.parseColor("#ffff00");
        color[3] = Color.parseColor("#66ff33");
        color[4] = Color.parseColor("#0066ff");
        color[5] = Color.parseColor("#9900cc");
        color[6] = Color.parseColor("#ff66ff");

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
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}