/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fidness;

/**
 *
 * @author luisg
 */
class AutoGuardado extends Thread {
    private SistemaGimnasio sistema;

    public AutoGuardado(SistemaGimnasio sistema) {
        this.sistema = sistema;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000); // Guarda cada 10 segundos
                sistema.guardarDatos();
                System.out.println("Datos guardados automáticamente.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
