/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidness;

/**
 *
 * @author luisg
 */
class Administrador extends Usuario {
    public Administrador(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Administrador: " + nombre + " - " + correo);
    }
}