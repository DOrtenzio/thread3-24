package tombola;

public class Main extends Thread{
    public static void main(String[] args) {
        Estrattore e1=new Estrattore("Pippo");
        Estrattore e2=new Estrattore("      Marco");
        e1.start();
        e2.start();
    }
}