package cinema;

import java.util.concurrent.TimeUnit;

public class Cassa extends Thread {
    //Attributi della cassa
    private String codiceIdentificativo; //Codice identificativo cassiere
    private Fila fila; // Riferimento alla fila, da passare come parametro

    //Attributi legati indirettamente alla cassa infatti riguardanti le sale
    private static final boolean [] posti =new boolean[90];
    private static int postiDisponibili=posti.length;
    private static final int prezzoStandard=10;

    // Costruttore che accetta anche la fila
    public Cassa(Fila fila) {
        this.fila = fila;
    }

    //Metodi get e set
    public void setCodice(String codice) { this.codiceIdentificativo = codice; }

    //Metodi legati alla prenotazione di un posto
    //Riservo il posto
    public void riservaPosto (int postoCercato) {
        posti[postoCercato]=false;
        postiDisponibili--;
    }
    //Controllo che il posto scelto dal cliente sia disponibile
    public boolean controlloPosto (int postoCercato) {
        return posti[postoCercato];
    }

    //Metodi per la simulazione della prenotazione di un posto con relativa stamap di ricevuta
    //Simulo un'assegnazione di posto
    public void clienteSimulato () {
        int indicePosto, numeroCliente;
        synchronized (posti){
            numeroCliente=Fila.ultimoNum();
            System.out.println("Numero cliente : "+numeroCliente+" clienti in coda: "+Fila.getPersoneInFila());
            for (int l=0;l<fila.getBiglietti(numeroCliente);l++){
                do{
                    //Estraggo l'indice casuale del posto
                    indicePosto= (int) (Math.random() * posti.length);
                }while (controlloPosto(indicePosto));
                riservaPosto(indicePosto);
                System.out.println("BIGLIETTO PER ..."+fila.getNome(numeroCliente)+"\nPosto "+indicePosto+" Fila "+Integer.parseInt(String.valueOf(indicePosto/10))+" Assegnato da: "+ codiceIdentificativo); //TODO: Inserire film e sale
            }
            int prezzo=prezzoStandard*fila.getBiglietti(numeroCliente);
            if (fila.isSconto(numeroCliente))
                prezzo-=2*fila.getBiglietti(numeroCliente);
            System.out.println("TOTALE: "+prezzo);
        }
    }

    public void run(){
        while (Fila.getPersoneInFila()>0){
            clienteSimulato();
            try {
                TimeUnit.SECONDS.sleep(4);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}