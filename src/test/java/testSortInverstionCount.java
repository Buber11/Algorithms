import Sort.SortInversionCount;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class testSortInverstionCount {


    @Test
    public void x2(){

        Assertions.assertThat(SortInversionCount.SortInversionCountX2(new int[]{1, 20, 6, 4, 5})).isEqualTo(5);

    }

    @Test
    public void Merge(){

        Assertions.assertThat(SortInversionCount.mergeSortAndCount(new int[]{1, 20, 6, 4, 5},0,4)).isEqualTo(5);

    }


}
