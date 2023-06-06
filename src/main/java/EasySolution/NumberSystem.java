package EasySolution;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.IntStream;

public class NumberSystem {

    public static void main(String[] args) {
        String decimal = "100";
        for(int radix : new int[]{2,4,5,8,16,32}){
            System.out.println(Integer.valueOf(decimal,radix));
        }

    }
}
