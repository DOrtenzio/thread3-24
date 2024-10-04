package cinema;

public class Sala {
    //Attributi di sala
    private boolean [] posti;
    private int postiDisponibili;
    private double prezzo;
    private String film;

    // Array di film casuali
    private static final String [] nomiFilm = {
            "It", "Don Matteo: La vendetta contro Raul Bova", "Altrimenti ci arrabiamo", "Et", "Topolino e l'evasione del fisco",
            "Tutti tranne l'inps", "How I meet your debt", "Elena", "Achille dal tallone magico", "Ok"
    };

    public Sala(int posti,double prezzo, int posizione){
        this.posti =new boolean[posti];
        this.prezzo=prezzo;
        this.postiDisponibili=posti;
        this.film=getFilmCasuale(posizione);
    }

    //get e set
    public double getPrezzo() { return prezzo; }
    public int getPostiDisponibili() { return postiDisponibili; }
    public String getFilm() { return film; }

    public void setPostiDisponibili(int postiDisponibili) { this.postiDisponibili = postiDisponibili; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    //Metodo per estrarre un film casuale
    public String getFilmCasuale(int posizione) { return nomiFilm[posizione]; }

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

}
