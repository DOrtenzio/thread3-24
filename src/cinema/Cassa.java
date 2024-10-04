package cinema;

import java.util.concurrent.TimeUnit;

public class Cassa extends Thread {
    //Attributi della cassa
    private String codiceIdentificativo; //Codice identificativo cassiere
    private Fila fila; // Riferimento alla coda d'attesa per le casse, da passare come parametro

    //Cinema e sale
    private static final Sala [] sale=new Sala[8];

    // Costruttore che accetta anche la fila
    public Cassa(Fila fila) {
        this.fila = fila;
    }

    //Metodo per popolare sale
    public void popolaSale(){
        for(int i=0;i<sale.length;i++){
            sale[i]=new Sala((int) (Math.random() * 30)+80,(Math.random()*4)+4, i);
        }
    }

    //Metodi get e set
    public void setCodice(String codice) { this.codiceIdentificativo = codice; }

    //Estrai film a caso
    private int getSalaACaso(){
        return (int) (Math.random()*8);
    }

    //Metodi per la simulazione della prenotazione di un posto con relativa stamap di ricevuta
    //Simulo un'assegnazione di posto
    public void clienteSimulato () {
        int indicePosto, numeroCliente,salaFilmScelto=getSalaACaso();
        synchronized (sale[salaFilmScelto]){
            numeroCliente=Fila.ultimoNum();
            System.out.println("Numero cliente : "+numeroCliente+" clienti in coda: "+Fila.getPersoneInFila());
            for (int l=0;l<fila.getBiglietti(numeroCliente);l++){
                do{
                    //Estraggo l'indice casuale del posto
                    indicePosto= (int) (Math.random() * sale[salaFilmScelto].getPostiDisponibili());
                }while (sale[salaFilmScelto].controlloPosto(indicePosto));
                sale[salaFilmScelto].riservaPosto(indicePosto);
                System.out.println("BIGLIETTO per "+sale[salaFilmScelto].getFilm()+"\nDi"+fila.getNome(numeroCliente)+"\nPosto "+indicePosto+" Fila "+Integer.parseInt(String.valueOf(indicePosto/10))+" Sala: "+salaFilmScelto+" Assegnato da: "+ codiceIdentificativo);
            }
            int prezzo= (int) (sale[salaFilmScelto].getPrezzo()*fila.getBiglietti(numeroCliente));
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