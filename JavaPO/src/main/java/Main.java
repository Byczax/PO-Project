import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Virus grypa = new Virus(1,1,1,2);
        grypa.duration = 3.141528;
        System.out.print("\n"+grypa.duration+"\n");
        grypa.iterate();
        System.out.println(grypa.detection+"\n");
        Random rand = new Random();
        int n = rand.nextInt(50);
        System.out.println("\n"+n+" - Losowa liczba");
    }
}
