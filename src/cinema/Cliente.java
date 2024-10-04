package cinema;

public class Cliente {
    private String nome;
    private int numBiglietti;
    private boolean tesseraSconto;

    public boolean isTesseraSconto() { return tesseraSconto; }
    public int getNumBiglietti() { return numBiglietti; }
    public String getNome() { return nome; }

    public void setNumBiglietti(int numBiglietti) { this.numBiglietti = numBiglietti; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTesseraSconto(boolean tesseraSconto) { this.tesseraSconto = tesseraSconto; }

    public Cliente (String nome, int numeroBiglietti, boolean tesseraSconto){
        this.nome=nome;
        this.numBiglietti=numeroBiglietti;
        this.tesseraSconto=tesseraSconto;
    }
}
