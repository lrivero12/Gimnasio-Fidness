/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fidness;

/**
 *
 * @author luisg
 */
import javax.swing.SwingUtilities;

public class Fidness {
    public static void main(String[] args) {
        SistemaGimnasio sistema = new SistemaGimnasio();

        // Agregar ejercicios si la lista está vacía
        if (sistema.obtenerEjercicios().isEmpty()) {
            sistema.agregarEjercicio(new Ejercicio("Sentadillas", "Pierna", "Ejercicio de fuerza para piernas."));
            sistema.agregarEjercicio(new Ejercicio("Prensa de piernas", "Pierna", "Ejercicio en máquina para fortalecer piernas."));
            sistema.agregarEjercicio(new Ejercicio("Extensión de piernas", "Pierna", "Ejercicio en máquina para cuadriceps."));
            sistema.agregarEjercicio(new Ejercicio("Curl de piernas", "Pierna", "Ejercicio en máquina para isquiotibiales."));
            sistema.agregarEjercicio(new Ejercicio("Peso muerto", "Pierna", "Ejercicio compuesto para glúteos y piernas."));
            
            sistema.agregarEjercicio(new Ejercicio("Press de banca", "Pecho", "Ejercicio de empuje para el pecho."));
            sistema.agregarEjercicio(new Ejercicio("Aperturas con mancuernas", "Pecho", "Ejercicio para pectorales."));
            sistema.agregarEjercicio(new Ejercicio("Fondos en paralelas", "Pecho", "Ejercicio para pectorales y tríceps."));
            sistema.agregarEjercicio(new Ejercicio("Flexiones", "Pecho", "Ejercicio de peso corporal para pectorales."));
            sistema.agregarEjercicio(new Ejercicio("Press inclinado", "Pecho", "Ejercicio para la parte superior del pecho."));
            
            sistema.agregarEjercicio(new Ejercicio("Dominadas", "Espalda", "Ejercicio de tracción para fortalecer la espalda."));
            sistema.agregarEjercicio(new Ejercicio("Remo con barra", "Espalda", "Ejercicio compuesto para la espalda."));
            sistema.agregarEjercicio(new Ejercicio("Pull-over con mancuerna", "Espalda", "Ejercicio de expansión torácica."));
            sistema.agregarEjercicio(new Ejercicio("Jalón al pecho", "Espalda", "Ejercicio en polea para dorsales."));
            sistema.agregarEjercicio(new Ejercicio("Hiperextensiones", "Espalda", "Ejercicio para la zona lumbar."));
            
            sistema.agregarEjercicio(new Ejercicio("Press militar", "Hombros", "Ejercicio compuesto para hombros."));
            sistema.agregarEjercicio(new Ejercicio("Elevaciones laterales", "Hombros", "Ejercicio para deltoides laterales."));
            sistema.agregarEjercicio(new Ejercicio("Pájaros", "Hombros", "Ejercicio para deltoides posteriores."));
            sistema.agregarEjercicio(new Ejercicio("Encogimientos con mancuernas", "Hombros", "Ejercicio para trapecios."));
            sistema.agregarEjercicio(new Ejercicio("Arnold Press", "Hombros", "Ejercicio de empuje con rotación."));
            
            sistema.agregarEjercicio(new Ejercicio("Curl de bíceps con barra", "Brazos", "Ejercicio de aislamiento para bíceps."));
            sistema.agregarEjercicio(new Ejercicio("Martillo con mancuernas", "Brazos", "Ejercicio para braquial y bíceps."));
            sistema.agregarEjercicio(new Ejercicio("Extensiones de tríceps en polea", "Brazos", "Ejercicio para tríceps."));
            sistema.agregarEjercicio(new Ejercicio("Patada de tríceps", "Brazos", "Ejercicio de aislamiento para tríceps."));
            sistema.agregarEjercicio(new Ejercicio("Curl en banco Scott", "Brazos", "Ejercicio concentrado para bíceps."));
            
            sistema.agregarEjercicio(new Ejercicio("Plancha", "Core", "Ejercicio isométrico para abdomen."));
            sistema.agregarEjercicio(new Ejercicio("Crunch abdominal", "Core", "Ejercicio para recto abdominal."));
            sistema.agregarEjercicio(new Ejercicio("Elevación de piernas", "Core", "Ejercicio para abdomen inferior."));
            sistema.agregarEjercicio(new Ejercicio("Giros rusos", "Core", "Ejercicio para oblicuos."));
            sistema.agregarEjercicio(new Ejercicio("Rodillo abdominal", "Core", "Ejercicio avanzado para abdomen."));
            
            sistema.guardarDatos();
        }
        
        SwingUtilities.invokeLater(() -> new InterfazGimnasio(sistema));
    }
}
