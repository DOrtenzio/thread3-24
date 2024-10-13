package cinema;

import cinema.util.Escape;

import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

public class TestSala {
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);

       //Creazione della fila e inizio arrivo delle persone (popolamento)
       Fila f1=new Fila();
       Fila.popolateFila();

        //Apro le sale
        Cassa.popolaSale();

       //Apriamo le casse ed ogni operatore inserisce il suo codice
       Cassa a1=new Cassa(f1,Escape.BOLD+Escape.UNDERLINE+Escape.CYAN);
            System.out.println(Escape.BOLD+"Inserire codice identificativo addetto"+Escape.RESET);
            a1.setCodice(in.next());
        Cassa a2=new Cassa(f1,Escape.BOLD+Escape.UNDERLINE+Escape.GREEN);
            System.out.println(Escape.BOLD+"Inserire codice identificativo addetto"+Escape.RESET);
            a2.setCodice(in.next());
        Cassa a3=new Cassa(f1,Escape.BOLD+Escape.UNDERLINE+Escape.YELLOW);
            System.out.println(Escape.BOLD+"Inserire codice identificativo addetto"+Escape.RESET);
            a3.setCodice(in.next());

        //Ripulisco Lo schermo (NB: Sequenze di escape valide solo per alcuni terminali)
        System.out.println(Cassa.pulisci()); //Cancella elementi a schermo

        //I cassieri iniziano a lavorare
        a1.start();
        //Simulazione di arrivo scaglionato dei cassieri (Elemento che non serve per la regolazione del codice ma solo per cercare di simulare la realtà)
        /*try {
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e) {
            System.out.println(e);
        }*/
        a2.start();
        a3.start();
    }
}
