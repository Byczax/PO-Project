public class Main {


    class Wirus {
        public float Infection_chance;
        public float duration;
        public float detection;
        public float reproduction;

    }
    
    class Human {
        public int Central_location;
        public float Social_distancing;
        public float Travel_rate;
    }

    class Community {
        // static int Total;
        public int Suspective;
        public int Infected;
        public int Removed;
        public int isolated;
    }

    public static void main(String[] args) {
        System.out.println("Hello World !!!");
        System.out.println(
            "Integer: " + 10 +
            " Double: " + 3.14 +
            " Boolean: " + true);
    }
}
