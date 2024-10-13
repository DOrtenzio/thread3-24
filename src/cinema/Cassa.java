package cinema;

import cinema.util.Escape;

import java.util.concurrent.TimeUnit;

public class Cassa extends Thread {
    //Attributi della cassa
    private String codiceIdentificativo; //Codice identificativo cassiere
    private Fila fila; // Riferimento alla coda d'attesa per le casse, da passare come parametro
    private String color;

    //Cinema e sale
    private static final Sala [] sale=new Sala[8];

    // Costruttore che accetta anche la fila ed il colore identificativo
    public Cassa(Fila fila, String color) {
        this.fila = fila;
        this.color=color;
    }

    //Metodo per popolare sale
    public static void popolaSale(){
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

    public static String pulisci() {
        return "\033[2J";
    }

    //Metodi per la simulazione della prenotazione di un posto con relativa stamap di ricevuta
    //Simulo un'assegnazione di posto
    public String clienteSimulato () {
        int indicePosto, numeroCliente,salaFilmScelto=getSalaACaso();
        String ricevuta="";
        synchronized (sale[salaFilmScelto]){
            numeroCliente=Fila.ultimoNum();
            ricevuta=ricevuta+this.color+"\n Numero cliente : "+numeroCliente+" clienti in coda: "+Fila.getPersoneInFila()+" CASSA: "+this.codiceIdentificativo+ Escape.RESET;
            for (int l=0;l<fila.getBiglietti(numeroCliente);l++){
                do{
                    //Estraggo l'indice casuale del posto
                    indicePosto= (int) (Math.random() * sale[salaFilmScelto].getPostiDisponibili());
                }while (sale[salaFilmScelto].controlloPosto(indicePosto));
                sale[salaFilmScelto].riservaPosto(indicePosto);
                ricevuta=ricevuta+("\n\tBIGLIETTO per "+sale[salaFilmScelto].getFilm()+"\n \tDi: "+fila.getNome(numeroCliente)+"\n \tPosto "+indicePosto+" Fila "+Integer.parseInt(String.valueOf(indicePosto/10))+" Sala: "+salaFilmScelto+" Assegnato da: "+ this.codiceIdentificativo);
            }
            int prezzo= (int) (sale[salaFilmScelto].getPrezzo()*fila.getBiglietti(numeroCliente));
            if (fila.isSconto(numeroCliente))
                prezzo-=2*fila.getBiglietti(numeroCliente);
            ricevuta=ricevuta+"\n\tTOTALE: "+prezzo+"\n";
        }
        return ricevuta;
    }

    public void run(){
        while (Fila.getPersoneInFila()>1){
            System.out.println(clienteSimulato());
            try {
                TimeUnit.SECONDS.sleep(4);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}