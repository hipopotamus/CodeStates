import org.junit.jupiter.api.Test;

public class SolutionTest {

    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};

    private void dfs(Character[][] matrix, boolean[][] check, StringBuilder stringBuilder,
                     int row, int col, int direction) {
        if (check[row][col]) {
            return;
        }
        stringBuilder.append(matrix[row][col]);
        check[row][col] = true;

        int nextRow = row + dRow[direction];
        int nextCol = col + dCol[direction];

        if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length
                || check[nextRow][nextCol]) {
            direction = (direction + 1) % 4;
            nextRow = row + dRow[direction];
            nextCol = col + dCol[direction];
        }

        dfs(matrix, check, stringBuilder, nextRow, nextCol, direction);
    }

    public String spiralTraversal(Character[][] matrix) {
        // TODO:
        boolean[][] check = new boolean[matrix.length][matrix[0].length];
        StringBuilder stringBuilder = new StringBuilder();

        dfs(matrix, check, stringBuilder, 0, 0, 0);
        return stringBuilder.toString();
    }


    @Test
    public void solutionTest() {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output);

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output);
    }
}
