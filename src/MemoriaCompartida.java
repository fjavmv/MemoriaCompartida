/*
    Esta clase representa el espacio de memoria que actúa como buffer, donde
    almacenamos información  la cual es accedida de de manera concurrente
    utilizando hilos (proceso A) y (proceso B).

    El buffer es un espacio temporal de memoria física el cual se usa para
    almacenar información mientras se envía de un lado a otro.
 */
public class MemoriaCompartida {
    // Variable encargada de controlar la generación de información
    private boolean puedoEscribir = true;

    // Dato a almacenar en la MC para ser consumido
    private int dato;

    /*
      Almacenamos la información siempre y cuando puedoEscribir lo permita
      si no se cumple dicha considición invocamos al metodo wait() para estar a al espera.
      para esta operación es importante controlar de manera sincronizada el acceso al recurso critico
     */
    public synchronized void cargar(int dato) {
        while (!puedoEscribir) {
            try {
                wait();
            } catch (InterruptedException ie) {
                System.out.println(ie.getLocalizedMessage());
            }
        }
        this.dato = dato;
        puedoEscribir = !puedoEscribir;

        // Invocamos al metodo sleep para dormir al hilo un tiempo determinado medio segundo
        //Este metodo puede ser sobrecargado (polimorfismo por parametro)
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            System.out.println(ie.getLocalizedMessage());
        }
        notify(); // para despertar un hilo
    }
    /*
     Leemos la información siempre y cuando puedoEscribir lo permita
     si no se cumple dicha considición invocamos al metodo wait() para estar a al espera.
     para esta operación es importante controlar de manera sincronizada el acceso al recurso critico
    */
    public synchronized int obtener() {
        while (puedoEscribir) {
            try {
                wait();
            } catch (InterruptedException ie) {
                System.out.println(ie.getLocalizedMessage());
            }
        }
        puedoEscribir = !puedoEscribir;
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            System.out.println(ie.getLocalizedMessage());
        }
        notify(); // para despertar un hilo
        return dato; //Retornamos dato almacenado
    }

}
