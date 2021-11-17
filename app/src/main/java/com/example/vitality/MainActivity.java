package com.example.vitality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Recetas;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar pb;
    private Button btn;
    private Administrador adm = new Administrador();
    private Recetas Re = new Recetas();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Vitality);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        pb = findViewById(R.id.pb);
        btn = findViewById(R.id.btn_InSesion);


        pb.setVisibility(View.INVISIBLE);
        msj.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Task().execute();//Empieza a correr la tarea
            }

        });
    }

    public void Facebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("htpps://www.facebook.com/"));
        startActivity(i);
    }
    public void Instagram(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("htpps://www.instagram.com/"));
        startActivity(i);
    }

    public void Twitter(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("htpps://www.twitter.com/"));
        startActivity(i);
    }

    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("htpps://www.youtube.com/"));
        startActivity(i);
    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }


    class Task extends AsyncTask<String, Void, String> {

        @Override // configuracion inicial de la tarea
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        @Override // encagado de procesar en segundo plano la tarea pesada
        protected String doInBackground(String... strings) {


            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override // finaliza la tarea asincrona
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario) {
                case "Cesar":
                    if (usuario.equals(userObj) && contrasena.equals(passObj)) {
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);

                    }
                    break;
                case "":
                    if (usuario.equals("") && contrasena.equals("")) {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacios, inrenta de nuevo");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(passObj)) {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Usuario incorrecto, intenta de nuevo");
                    }
                    break;
            }
        }
    }
}