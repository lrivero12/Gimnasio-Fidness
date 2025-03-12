/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidness;

/**
 *
 * @author luisg
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaGimnasio {
    private List<Usuario> usuarios;
    private List<Ejercicio> ejercicios;

    public SistemaGimnasio() {
        usuarios = new ArrayList<>();
        ejercicios = new ArrayList<>();
        cargarDatos();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario autenticar(String correo, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.correo.equals(correo) && u.verificarContraseña(contraseña)) {
                return u;
            }
        }
        return null;
    }
    
    public boolean existeCorreo(String correo) {
        for (Usuario u : usuarios) {
            if (u.correo.equals(correo)) {
                return true;
            }
        }
        return false;
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    public List<Ejercicio> obtenerEjercicios() {
        return ejercicios;
    }

    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("gimnasio.dat"))) {
            oos.writeObject(usuarios);
            oos.writeObject(ejercicios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("gimnasio.dat"))) {
            usuarios = (List<Usuario>) ois.readObject();
            ejercicios = (List<Ejercicio>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontraron datos previos, se creará un nuevo archivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos, se inicializan vacíos.");
            usuarios = new ArrayList<>();
            ejercicios = new ArrayList<>();
        }
    }
}
