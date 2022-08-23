import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionTest {

    public int[] heapSort(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int element : arr) {
            queue.offer(element);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
        return arr;
    }



    @Test
    public void solutionTest() {
        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output));

        output = heapSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        System.out.println(Arrays.toString(output));
    }
}
