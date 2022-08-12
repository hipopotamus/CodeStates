import org.junit.jupiter.api.Test;

public class SolutionTest {

    public int[][] rotateMatrix(int[][] matrix, int K) {
        // TODO:
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        K = K % 4;
        return locate(matrix, K, 0);
    }

    private int[][] locate(int[][] matrix, int K, int depth) {
        if (depth == K) {
            return matrix;
        }
        int[][] resultMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        return locate(resultMatrix, K, depth + 1);
    }

    @Test
    public void solutionTest() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 99},
                {5, 6, 7, 8, 99},
                {9, 10, 11, 12, 99},
                {13, 14, 15, 16, 99}
        };
        int K = 1;

        int[][] rotatedMatrix = rotateMatrix(matrix, K);
        System.out.println("h");
    }
}
