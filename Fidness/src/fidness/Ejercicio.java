/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidness;

/**
 *
 * @author luisg
 */
import java.io.Serializable;

class Ejercicio implements Serializable {
    private String nombre;
    private String categoria;
    private String descripcion;

    public Ejercicio(String nombre, String categoria, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return nombre + " - " + categoria;
    }
}
