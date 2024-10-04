package cinema;

import java.util.concurrent.TimeUnit;

public class Addetto extends Thread {

    private String codiceIdentificativo;

    //Array in comune dove sono contenuti tutti i posti
    private static boolean [] posti =new boolean[90];
    private static int postiDisponibili=posti.length;
    private static int prezzoStandard=10;

    public void setCodice(String codice) { this.codiceIdentificativo = codice; }


    //Riservo il posto
    public void riservaPosto (int postoCercato) {
        posti[postoCercato]=false;
        postiDisponibili--;
    }

    //Controllo che il posto scelto dal cliente sia disponibile
    public boolean controlloPosto (int postoCercato) {
        return posti[postoCercato];
    }

    //Simulo un'assegnazione di posto
    public void clienteSimulato (Fila f1) {
        int i;
        synchronized (posti){
            System.out.println("Numero cliente : "+Fila.ultimoNum()+" clienti in coda: "+Fila.getPersoneInFila());
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception e) {
                System.out.println(e);
            }

            do{
                //Estraggo l'indice casuale del posto
                i= (int) (Math.random() * posti.length);
            }while (controlloPosto(i));
           riservaPosto(i);
           System.out.println(f1."Posto "+i+" Fila "+Integer.parseInt(String.valueOf(i/10))+" Assegnato da: "+ codiceIdentificativo);
           try {
                TimeUnit.SECONDS.sleep(4);
           }catch(Exception e) {
                System.out.println(e);
           }
        }
    }

    public void run(Fila f1) {
        while (Fila.getPersoneInFila()>0){
            clienteSimulato(f1);
        }
    }
}