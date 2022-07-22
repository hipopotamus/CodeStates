import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class SolutionTest {

    public int arrLength(int[] arr){
        // TODO:
            if (arr.length <= 1) return arr.length;

            int[] newArr = Arrays.copyOfRange(arr, 0, arr.length - 1);
            return 1 + arrLength(newArr);
    }

    public static class testClass{
        int hi = 3;
        String morning = "hello";

        public int getHi() {
            return hi;
        }

        public void setHi(int hi) {
            this.hi = hi;
        }

        public String getMorning() {
            return morning;
        }

        public void setMorning(String morning) {
            this.morning = morning;
        }
    }

    @Test
    public void solutionTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        testClass testClass = new testClass();
        Object[] test = new Object[]{testClass, 2, new Object[]{"a", "b"}, 3};
        String s = objectMapper.writeValueAsString(test);
        System.out.println(s);
        System.out.println(s instanceof String);
    }
}
