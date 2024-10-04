package cinema;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestSala {
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       Fila f1=new Fila();
       f1.popolateFila();
       Cassa a1=new Cassa(f1);
            System.out.println("Inserire codice identificativo addetto");
            a1.setCodice(in.next());
        Cassa a2=new Cassa(f1);
            System.out.println("Inserire codice identificativo addetto");
            a2.setCodice(in.next());
        Cassa a3=new Cassa(f1);
            System.out.println("Inserire codice identificativo addetto");
            a3.setCodice(in.next());
        a1.popolaSale();

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
