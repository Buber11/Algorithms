package EasySolution;

public class Round  {

    public static <R extends Number, T extends Number> int round( T a, R round ){

       double b = a.doubleValue();
       double c = round.doubleValue();
       return (int) Math.floor(b + 1.0 - c);

    }
}
