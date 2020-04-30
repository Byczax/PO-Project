
public class Draw {
    public static int Day(int day,int population) {
            for(int i=0;i<=(population/2);i++)
            System.out.print("  ");
            System.out.println("\033[37;1mDay:"+day+"\033[0m");
            return ++day;
    }

    public static void DrawMap(int size, int[][] tablica,int infected)
    {
        for(int i=0;i<size;i++){
            System.out.print("\t");
            for(int j=0;j<size;j++){
                if(tablica[i][j]==0)
                    System.out.print("\033[32;1mO\033[0m ");
                else if(tablica[i][j]==1)
                    System.out.print("\033[31;1m#\033[0m ");
                else if(tablica[i][j]==2)
                    System.out.print("\033[34;1mX\033[0m ");
            }
            System.out.print("\n");
        }
        System.out.println("Healthy: "+(size*size-infected)+"\t"+"Infected: "+infected);
        System.out.println("Press Enter To Continue To The Next Day...");
        new java.util.Scanner(System.in).nextLine();
        
    }   


}