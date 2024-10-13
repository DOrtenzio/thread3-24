package cinema;

public class Cliente extends Thread {
    // Attributi
    private String nome; //Nome cliente con cui registrare il nominativo sul biglietto
    private int numBiglietti; //Numero di biglietti che il cliente vuole comprare
    private boolean tesseraSconto; //Se ha la tessera sconto ci sono 2 euro in meno per biglietto

    // Array di nomi casuali
    private static final String [] nomi = {
            "Luca", "Giulia", "Marco", "Sara", "Francesco",
            "Valentina", "Matteo", "Elena", "Alessandro", "Martina"
    };

    //Costruttore
    public Cliente ( int numeroBiglietti, boolean tesseraSconto){
        this.nome=getNomeCasuale();
        this.numBiglietti=numeroBiglietti;
        this.tesseraSconto=tesseraSconto;
    }

    //Metodi Get e Set
    public boolean isTesseraSconto() { return tesseraSconto; }
    public int getNumBiglietti() { return numBiglietti; }
    public String getNome() { return nome; }
    public void setNumBiglietti(int numBiglietti) { this.numBiglietti = numBiglietti; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTesseraSconto(boolean tesseraSconto) { this.tesseraSconto = tesseraSconto; }

    //Metodo per ricavare un nome semi-casuale
    public String getNomeCasuale() { return nomi [(int) (Math.random()* nomi.length)]; }
}
