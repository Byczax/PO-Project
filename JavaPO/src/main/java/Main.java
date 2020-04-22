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
        int n = rand.nextInt(100);
        System.out.println("\n"+n+" - Losowa liczba");
        int populacja = 10;
        int[][] tablica = new int [populacja][populacja];
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = 0;
            }
        }
        int X = rand.nextInt(populacja-2)+1;
        int Y = rand.nextInt(populacja-2)+1;
        System.out.println("\n"+X+" - Losowa liczba");
        System.out.println("\n"+Y+" - Losowa liczba");
        tablica[X][Y]=1;
        int ilosc = 1;

        while (ilosc<(populacja-2)*(populacja-2)) {
            for(int i=1;i<populacja-1;i++){
                for(int j=1;j<populacja-1;j++){
                    if(tablica[i][j]==1){
                            if (tablica[i-1][j]==0) {
                                if (rand.nextInt(2)==1) {
                                    tablica[i-1][j]=1;
                                    if(i-1!=0)
                                    {
                                        ilosc++;
                                    }
                                }
                            }

                            if (tablica[i+1][j]==0) {
                                if (rand.nextInt(2)==1) {
                                    tablica[i+1][j]=1;
                                    if(i+1!=populacja-1)
                                    {
                                        ilosc++;
                                    }
                                    }
                                }

                            if (tablica[i][j-1]==0) {
                                if (rand.nextInt(2)==1) {
                                    tablica[i][j-1]=1;
                                    if(j-1!=0)
                                    {
                                        ilosc++;
                                    }
                                }
                            }

                            if (tablica[i][j+1]==0) {
                                if (rand.nextInt(2)==1) {
                                    tablica[i][j+1]=1;
                                    if(j+1!=populacja-1)
                                    {
                                        ilosc++;
                                    }
                                }
                            }
                    }
                }        
            }
            for(int i=1;i<populacja-1;i++){
                for(int j=1;j<populacja-1;j++){
                    if(tablica[i][j]==1)
                    {
                        System.out.print("# ");
                    }
                    else
                        System.out.print("O ");
                }
                System.out.print("\n");
            }
            System.out.print("\n\n\n");
        }
    }
}
