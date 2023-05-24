import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;


public class testSort {

   @Test
   public void BubbleSort(){

      int[] array = {5, 3, 8, 2, 1, 4};

      Assertions.assertThat(Sort.BubbleSort(array)).isSorted();

   }

   @Test
   public void SelectionSort(){

      int[] array = {5, 3, 8, 2, 1, 4};

      Assertions.assertThat(Sort.SelectionSort(array)).isSorted();

   }



}
