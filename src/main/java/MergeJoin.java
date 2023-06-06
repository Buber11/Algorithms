import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MergeJoin {

    public static List MergeJoin(int[] tab1, int[] tab2) {
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        int i = 0, j = 0;
        Map.Entry<Integer, Integer> pair;
        while (i < tab1.length && j < tab2.length) {

            if (tab1[i] == tab2[j]) {
                pair = new AbstractMap.SimpleEntry<>(tab1[i], tab2[j]);
                list.add(pair);
                j++;
                i++;
            } else if (tab1[i] < tab2[j]) {
                i++;
            } else if (tab1[i] > tab2[j]) {
                j++;
            }

        }


        return list;
    }

}

