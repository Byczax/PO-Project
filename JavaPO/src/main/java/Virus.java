import java.util.Random;

public class Virus {

        public int infection_chance;
        public int duration;
        public int detection;
        public int reproduction;

        public Virus(int infection_chance,int duration,int detection,int reproduction)
        {
                this.infection_chance = infection_chance;
                this.duration = duration;
                this.detection = detection;
                this.reproduction = reproduction;
        }

        public static int Infect(int population,int[][] tablica,int infected,int chance) 
        {
                
                Random rand = new Random();
                for(int i=0;i<population;i++)
                        for(int j=0;j<population;j++)
                                if(tablica[i][j]==1) //finding infected
                                        for(int k=1;k<9;k+=2)
                                                if((i+k/3)>0 && (i+k/3 -1)<population && (j + k%3 )>0 && (j + k%3 -1)<population)
                                                        if(tablica[i + k/3 -1][j + k%3 -1]==0 && rand.nextInt(chance)==1)
                                                        {
                                                                tablica[i + k/3 -1][j + k%3 -1]=1;
                                                                infected++;
                                                        }
                return infected;
        }
}
