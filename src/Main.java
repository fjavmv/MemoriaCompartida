public class Main {
    public static void main(String[] args) {
        MemoriaCompartida memoriaCompartida = new MemoriaCompartida();
        ProcesoA procesoA = new ProcesoA(memoriaCompartida);
        ProcesoB procesoB = new ProcesoB(memoriaCompartida);
        //Creamos instancia de clase Theread
        new Thread(procesoA).start();
        new Thread(procesoB).start();
    }
}
