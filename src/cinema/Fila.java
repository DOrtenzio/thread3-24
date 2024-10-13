package cinema;

import java.util.concurrent.TimeUnit;

public class Fila extends Thread {
    //Attributi della fila
    private static Cliente [] fila=new Cliente[20]; //Fila dei clienti
    private static int personeInFila=fila.length; //Persone in fila
    private static int ultimoNumero=0; //Numeri estratti

    //Creo le persone in fila
    public static void popolateFila(){
        for (int i=0; i<fila.length;i++){
            boolean s; //Variabile con casuale per creare l'avere o no della tessera
            if ((int) (Math.random()*10)+1 < 5)
                s=false;
            else
                s=true;
           fila[i]=new Cliente((int) (Math.random()*10)+1,s);
        }
    }

    //Metodi get della fila
    public static int getPersoneInFila() { return personeInFila; }

    //Metodi get riferiti alla persona in fila
    public String getNome(int num){ return fila[num].getNome(); }
    public int getBiglietti(int num){ return fila[num].getNumBiglietti(); }
    public boolean isSconto(int num){ return fila[num].isTesseraSconto(); }

    //Chiamo ultimo numero
    public static int ultimoNum () {
        synchronized (fila){ //Synchronized non necessario usato solo per un ordine visivo (Se non si mette i numeri non si sovrastano ugualmente)
            ultimoNumero++;
            personeInFila--;
            return ultimoNumero;
        }
    }

}