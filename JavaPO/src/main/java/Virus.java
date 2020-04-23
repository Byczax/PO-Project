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
        // public void iterate(){
        //         if (reproduction>1)
        //         {
        //                 detection+=0.02*reproduction;
        //         }
        // }
        // public void infection_range(int x,int y){
        //         for(int i=x-1;i<=x+1;i++)
        //         for(int j=y-1;j<=y+1;j++)
        //         if(i!=x&&j!=y)
        // }
}
