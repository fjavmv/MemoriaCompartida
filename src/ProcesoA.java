public class ProcesoA implements Runnable{
    private MemoriaCompartida memoriaCompartida;
    /*
      Constructor que recibe por parámetro un objeto de MemoriaCompartida donde almacenaremos la
      información generada
     */
    public ProcesoA(MemoriaCompartida memoriaCompartida) {
        this.memoriaCompartida = memoriaCompartida;
    }
    @Override
    public void run() {
        int valorAGenerar;
        for (int i = 0; i <= 10; i++) {
            valorAGenerar = 100 * i;
            this.memoriaCompartida.cargar(valorAGenerar);
            System.out.println("Generando " + i + " Escribiendo valor: " + valorAGenerar);
        }
    }
}
