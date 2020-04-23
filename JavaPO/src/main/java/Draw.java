
public class Draw {

    public static void DrawMap(int size, int[][] tablica)
    {
        for(int i=1;i<size+1;i++){
            System.out.print("\t");
            for(int j=1;j<size+1;j++){
                if(tablica[i][j]==1)
                {
                    System.out.print("\033[31;1m#\033[0m ");
                }
                else
                    System.out.print("\033[32;1mO\033[0m ");
            }
            System.out.print("\n");
        }
    }   


}