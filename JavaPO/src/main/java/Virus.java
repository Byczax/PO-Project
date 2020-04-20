public class Virus {

        public double Infection_chance;
        public double duration;
        public double detection;
        public double reproduction;

        public Virus(double infection_chance,double duration,double detection,double reproduction)
        {
                this.Infection_chance = infection_chance;
                this.duration = duration;
                this.detection = detection;
                this.reproduction = reproduction;
        }
        public void iterate(){
                if (reproduction>1)
                {
                        detection+=0.02*reproduction;
                }
        }

}
