package cinema;

import java.util.Scanner;

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
        a1.start();
        a2.start();
        a3.start();
    }
}
