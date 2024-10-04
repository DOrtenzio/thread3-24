package cinema;

import java.util.Scanner;

public class TestSala {
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       Fila f1=new Fila();
       f1.start();
       Addetto a1=new Addetto();
            System.out.println("Inserire codice identificativo addetto");
            a1.setCodice(in.next());
       Addetto a2=new Addetto();
            System.out.println("Inserire codice identificativo addetto");
            a2.setCodice(in.next());
       Addetto a3=new Addetto();
            System.out.println("Inserire codice identificativo addetto");
            a3.setCodice(in.next());
       a1.start(f1);
       a2.start(f1);
       a3.start(f1);
    }
}
