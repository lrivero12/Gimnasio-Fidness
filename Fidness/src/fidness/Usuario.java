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

abstract class Usuario implements Serializable {
    protected String nombre;
    protected String correo;
    protected String contraseña;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public boolean verificarContraseña(String input) {
        return this.contraseña.equals(input);
    }

    public abstract void mostrarInfo();
}