public class Gravity {
    public double falling(double time, double velo){
        return (velo*time)+(0.5*9.8*time*time);
    }

    public static void main(String[] arg) {
        Gravity test1 = new Gravity();
        double test = test1.falling(3,0);
        System.out.print(test);
    }
}

/*
time = 3
velo = 5
returns 59.1

time = 3
velo = 0
returns 44.1

time = 3600
velo = 0
returns 63504000.0

*/
