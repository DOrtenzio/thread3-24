package cinema;

import java.util.concurrent.TimeUnit;

public class Fila extends Thread {
    private static Cliente [] fila=new Cliente[10];
    private static int personeInFila=fila.length;
    private static int ultimoNumero=0;

    //Fila
    public void popolateFila(){
        for (int i=0; i<fila.length;i++){
            boolean s;
            if ((int) (Math.random()*10)+1 < 5)
                s=false;
            else
                s=true;
           fila[i]=new Cliente("nome a caso",(int) (Math.random()*10)+1,s); //TODO: Mettere nomi a caso
        }
    }

    public static int getPersoneInFila() { return personeInFila; }
    //gestioni numeri

    //Chiamo ultimo numero
    public synchronized static int ultimoNum () {
        ultimoNumero++;
        return ultimoNumero;
    }

    public void run() {
        while (true){
            popolateFila();
            try {
                TimeUnit.SECONDS.sleep(4);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}