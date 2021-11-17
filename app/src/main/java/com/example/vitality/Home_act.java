package com.example.vitality;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import Objetos.Recetas;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Recetas Re = new Recetas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.video);  // llamo al video

        //Obtener ruta del video

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(ruta); // parseo de ruta

        video.setVideoURI(uri);  // le paso mi ruta al videView

        video.start(); // iniciar video al iniciar sesión

    }
    public void Task(View view){
        try {
            for (int i = 0; i <= 10; i++) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void Recetas(View View){

        Intent i = new Intent(this, Recetas_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("Recetas", Re.getRecetario());
        i.putExtras(bun);
        startActivity(i);
    }


    public void Info(View View){

        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Sqlite(View View){

        Intent i = new Intent(this, Sqlite_act.class);
        startActivity(i);
    }
}