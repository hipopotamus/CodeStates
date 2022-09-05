import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {

    private class Node {
        int row;
        int col;
        boolean check = false;
        boolean dump = false;
        int number;
        int direct;

        public Node(int row, int col, boolean dump) {
            this.row = row;
            this.col = col;
            this.dump = dump;
        }
    }

    public int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        // TODO:
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        Node[][] nodeArr = new Node[room.length][room[0].length];
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                boolean dump = false;
                if (room[i][j] == 1) {
                    dump = true;
                }
                nodeArr[i][j] = new Node(i, j, dump);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Node firstNode = nodeArr[src[0]][src[1]];
        firstNode.direct = sDir;
        firstNode.check = true;
        queue.offer(firstNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCol[i];

                if ((nextRow < 0 || nextRow >= room.length || nextCol < 0 || nextCol >= room[0].length
                        || nodeArr[nextRow][nextCol].dump)) {
                    continue;
                }

                int direction = Math.abs(i + 1 - node.direct) % 3;
                int time = 0;
                if (direction != 0) {
                    time = 1;
                }
                if (nodeArr[nextRow][nextCol].check && node.number + direction + time > nodeArr[nextRow][nextCol].number) {
                    continue;
                }
                Node nextNode = nodeArr[nextRow][nextCol];
                nextNode.check = true;
                nextNode.direct = i + 1;
                nextNode.number = node.number + direction + time;

                queue.offer(nodeArr[nextRow - dRow[i]][nextCol - dCol[i]]);
            }
        }

        Node distNode = nodeArr[dst[0]][dst[1]];
        int direction = Math.abs(dDir - distNode.direct) % 3;
        return distNode.number + direction;
    }

    @Test
    public void solutionTest() {
        int[][] room = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
        };
        int[] src = new int[]{3, 0};
        int sDir = 3;
        int[] dst = new int[]{2, 2};
        int dDir = 2;
        int output = robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output);

        room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
        };
        src = new int[]{4, 2};
        sDir = 1;
        dst = new int[]{2, 2};
        dDir = 3;
        output = robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output);
    }
}
