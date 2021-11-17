package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Recetas {
    private int id;
    private String[] recetario = {"Merluza en salsa roja de pimientos asados", "Salteado de Mariscos", "Budin de verduras", "Ensalada asiática de quinoa y gambas",
            "Pechuga de pollo con soja, miel y limón", "Curry de garbanzos y verduras", "Ensalada tailandesa de ternera"};

    private int[] precios = {24000, 25000, 10000, 15000, 18000, 20000};
    private int stock;

    public Recetas()
    {

    }

    public Recetas(int id, String[] recetario, int[] precios, int stock) {
        this.id = id;
        this.recetario = recetario;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getRecetario() {
        return recetario;
    }

    public void setRecetario(String[] recetario) {
        this.recetario = recetario;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recetas recetas = (Recetas) o;
        return id == recetas.id && stock == recetas.stock && Arrays.equals(recetario, recetas.recetario) && Arrays.equals(precios, recetas.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(recetario);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "Recetas{" +
                "id=" + id +
                ", recetario=" + Arrays.toString(recetario) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }

    public int anadirAdicional(int valor, int adicional){

        return valor + adicional;

    }

}


