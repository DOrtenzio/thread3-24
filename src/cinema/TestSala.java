package cinema;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestSala {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int cassaAp=0;
        Fila f1=new Fila();
        Fila.popolateFila();
        Cassa a1=new Cassa(f1);
        System.out.println("Inserire codice identificativo addetto");
        a1.setCodice(in.next());
        cassaAp++;
        Cassa a2=new Cassa(f1);
        System.out.println("Inserire codice identificativo addetto");
        a2.setCodice(in.next());
        cassaAp++;
        Cassa a3=new Cassa(f1);
        System.out.println("Inserire codice identificativo addetto");
        a3.setCodice(in.next());
        cassaAp++;
        Cassa.popolaSale();
        GestTerm.pulisci();

        //Inizio
        System.out.println("Persone in fila: "+f1+"\tCasse aperte: "+cassaAp+"\tSale: "+Cassa.getNumSale());
        System.out.println("Cassa 1: ");
        System.out.println("Cassa 2: ");
        System.out.println("Cassa 3: ");
        a1.start();
        a2.start();
        a3.start();
        String s="";
        for (int i=0;i<Cassa.getNumSale();i++){
            s=s+"Sala "+i+" :"+Cassa.getPostiDisponibiliSala(i)+" | ";
        }
        System.out.println(s);



        a1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e) {
            System.out.println(e);
        }
        a2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e) {
            System.out.println(e);
        }
        a3.start();
    }
}