import java.util.Random;
public class Main {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int populacja = 10;// do 50 wtedy mieści się w konsoli
        int[][] tablica = new int [populacja][populacja];
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = 0;
            }
        }
        int X = rand.nextInt(populacja-2)+1;
        int Y = rand.nextInt(populacja-2)+1;
        tablica[X][Y]=1;
        int ilosc = 1;
        int day = 1;
        while (ilosc<(populacja-2)*(populacja-2)) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\033[37;1mDay:"+day+"\033[0m");
            day++;
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
                        System.out.print("\033[31;1m#\033[0m ");
                    }
                    else
                        System.out.print("\033[32;1mO\033[0m ");
                }
                System.out.print("\n");
            }
            Thread.sleep(1000);
        }
        
    }
}
