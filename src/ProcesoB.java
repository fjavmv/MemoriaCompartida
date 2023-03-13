public class ProcesoB implements Runnable {
    private MemoriaCompartida memoriaCompartida;

    /*
      Constructor que recibe por parámetro la información a consumir
     */
    public ProcesoB(MemoriaCompartida memoriaCompartida) {
        this.memoriaCompartida = memoriaCompartida;
    }
    @Override
    public void run() {
        int leerValor;
        for (int i = 0; i <= 10; i++) {
            leerValor = memoriaCompartida.obtener();
            System.out.println("Obteniendo: " + i + " dato leido: " + leerValor);
        }
    }
}
