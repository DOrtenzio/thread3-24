package tombola;

import java.util.concurrent.TimeUnit;

public class Estrattore extends Thread{
    private static boolean [] bussolotto=new boolean[91];
    private String nome;

    //Get e set
    public String getNome() { return nome; }
    public static boolean[] getBussolotto() { return bussolotto; }
    public static void setBussolotto(boolean[] bussolotto) { Estrattore.bussolotto = bussolotto; }
    public void setNome(String nome) { this.nome = nome; }

    //Costruttore
    public Estrattore(String nome){ this.nome=nome; }

    //Metodo estrai
    public int estrai(){
        int numEstratto;
        synchronized (bussolotto){
            do {
                numEstratto=(int) ((Math.random()*90)+1);
            }while (bussolotto[numEstratto]);
            bussolotto[numEstratto]=true;
        }
        return numEstratto;
    }

    //Run
    public void run() {
        while (true){
            System.out.println(getNome()+" ha estratto "+estrai());
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
