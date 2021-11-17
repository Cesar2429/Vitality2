package com.example.vitality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Recetas;

public class Recetas_act extends AppCompatActivity {
    private Spinner receta;
    private TextView result;
    private RatingBar calificar;
    private Recetas Re = new Recetas(); // Instancia de la clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        receta = findViewById(R.id.spnreceta);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        //recibo los extras

        Bundle bun = getIntent().getExtras();//Recibo el intent con los valores del bundle.
        String[] listado = bun.getStringArray("Recetas");

        ArrayAdapter adaptRecetas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        receta.setAdapter(adaptRecetas);

    }
    public void Calcular (View View){

        String opcion = receta.getSelectedItem().toString(); // obtengo la selección del spinner en una variable.
        int resultado = 0;
        int precio = 0;

        for(int i = 0; i< opcion.length(); i++){

            if(opcion.equals(Re.getRecetario()[i])){ // pregunto por la seleccion del spinner (index)

                precio = Re.getPrecios()[i]; // obtengo resultado del precio según índice

                resultado = Re.anadirAdicional(Re.getPrecios()[i], 450); // obtengo regla adicional
                calificar.setRating(i+1); // pinta las estrellas del rating bar
                break;
            }
        }

        result.setText("Has seleccionado " + opcion +"\ntiene un costo de $" + precio + "\npor lo que su precio total es $" + resultado);


    }

}