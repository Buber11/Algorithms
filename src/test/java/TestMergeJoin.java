import org.assertj.core.api.Assertions;
import org.assertj.core.data.MapEntry;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestMergeJoin {


    @Test
    public void MergeJoin(){

        List<Integer> list1 = Arrays.asList(1, 3, 4, 6, 8);
        List<Integer> list2 = Arrays.asList(2, 4, 5, 8, 9);

        List<Map.Entry<Integer,Integer>> expected = Arrays.asList(
                new AbstractMap.SimpleEntry<>(4,4),
                new AbstractMap.SimpleEntry<>(8,8)
        );

        Assertions.assertThat(MergeJoin.MergeJoin(new int[]{1, 3, 4, 6, 8}, new int[]{2, 4, 5, 8, 9})).isEqualTo(expected);

    }

}
