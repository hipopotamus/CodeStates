import org.junit.jupiter.api.Test;

public class SolutionTest {

    public int[] fibonacci(int num) {
        // TODO:
        int[] result = new int[num + 1];

        if (num >= 0) {
            result[0] = 0;
        }
        if (num >= 1) {
            result[1] = 1;
        }

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;

    }

    @Test
    public void solutionTest() {

    }
}
