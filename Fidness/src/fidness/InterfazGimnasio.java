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

public class InterfazGimnasio extends JFrame {
    private SistemaGimnasio sistema;
    private Usuario usuarioAutenticado;
    private JTextArea areaTexto;
    private JComboBox<Ejercicio> comboEjercicios;
    private List<Ejercicio> rutina;
    private int intentosFallidos = 0;

    public InterfazGimnasio(SistemaGimnasio sistema) {
        this.sistema = sistema;
        rutina = new ArrayList<>();
        preguntarSiTieneUsuario();
    }

    private void preguntarSiTieneUsuario() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Ya tiene una cuenta registrada?", "Inicio", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            mostrarLogin();
        } else {
            registrarNuevoUsuario();
            mostrarLogin();
        }
    }

    private void mostrarLogin() {
        while (usuarioAutenticado == null) {
            String correo = JOptionPane.showInputDialog("Ingrese su correo:");
            if (correo == null || correo.trim().isEmpty()) {
                return;
            }

            if (!sistema.existeCorreo(correo)) {
                int opcion = JOptionPane.showConfirmDialog(this, "Usuario no existe. ¿Desea registrarse?", "Registro", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    registrarNuevoUsuario();
                } else {
                    preguntarSiTieneUsuario();
                    return;
                }
            }

            for (int i = 0; i < 3; i++) {
                String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
                if (contraseña == null || contraseña.trim().isEmpty()) {
                    return;
                }

                usuarioAutenticado = sistema.autenticar(correo, contraseña);
                if (usuarioAutenticado != null) {
                    mostrarInterfazPrincipal();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Intento " + (i + 1) + " de 3");
                }
            }
            JOptionPane.showMessageDialog(this, "Demasiados intentos fallidos. Espere 30 segundos para volver a intentarlo.");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void registrarNuevoUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        if (nombre == null || nombre.trim().isEmpty()) return;
        
        String correo = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
        if (correo == null || correo.trim().isEmpty()) return;
        
        if (sistema.existeCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "El correo ya está registrado. Inicie sesión en su cuenta.");
            return;
        }
        
        String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
        if (contraseña == null || contraseña.trim().isEmpty()) return;
        
        String[] opciones = {"Cliente", "Administrador"};
        int tipoUsuario = JOptionPane.showOptionDialog(this, "Seleccione el tipo de usuario:", "Registro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        Usuario nuevoUsuario;
        if (tipoUsuario == 1) {
            nuevoUsuario = new Administrador(nombre, correo, contraseña);
        } else {
            nuevoUsuario = new Cliente(nombre, correo, contraseña);
        }
        
        sistema.registrarUsuario(nuevoUsuario);
        sistema.guardarDatos();
        JOptionPane.showMessageDialog(this, "Usuario registrado con éxito. Ahora puede iniciar sesión.");
    }

    private void mostrarInterfazPrincipal() {
        setTitle("Gimnasio Fidness - Ejercicios");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        comboEjercicios = new JComboBox<>(sistema.obtenerEjercicios().toArray(new Ejercicio[0]));
        JButton btnAgregarRutina = new JButton("Agregar a Rutina");
        JButton btnExportar = new JButton("Exportar Rutina");
        areaTexto = new JTextArea();
        
        btnAgregarRutina.addActionListener(e -> agregarEjercicioRutina());
        btnExportar.addActionListener(e -> exportarRutina());
        
        add(comboEjercicios, "North");
        add(new JScrollPane(areaTexto), "Center");
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregarRutina);
        panelBotones.add(btnExportar);
        add(panelBotones, "South");
        
        setVisible(true);
    }
    
    private void agregarEjercicioRutina() {
        Ejercicio seleccionado = (Ejercicio) comboEjercicios.getSelectedItem();
        if (seleccionado != null) {
            rutina.add(seleccionado);
            actualizarRutinaTexto();
        }
    }

    private void actualizarRutinaTexto() {
        areaTexto.setText("Rutina:\n");
        for (Ejercicio e : rutina) {
            areaTexto.append(e.getNombre() + " - " + e.getCategoria() + "\n");
        }
    }

    private void exportarRutina() {
        try (PrintWriter writer = new PrintWriter("rutina.txt")) {
            writer.println("Rutina de " + usuarioAutenticado.nombre);
            for (Ejercicio e : rutina) {
                writer.println(e.getNombre() + " - " + e.getCategoria());
            }
            JOptionPane.showMessageDialog(this, "Rutina exportada correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al exportar rutina.");
        }
    }
}