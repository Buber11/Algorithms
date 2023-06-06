import Sort.Sort;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;


public class testSort {
    int[] array;

    @Before
    public void initialize() {
        array = new int[]{5, 3, 8, 2, 1, 4};
    }

    @Test
    public void BubbleSort() {

        Assertions.assertThat(Sort.BubbleSort(array)).isSorted();

    }

    @Test
    public void SelectionSort() {

        Assertions.assertThat(Sort.SelectionSort(array)).isSorted();

    }

    @Test
    public void MergeSort() {



    }


}
