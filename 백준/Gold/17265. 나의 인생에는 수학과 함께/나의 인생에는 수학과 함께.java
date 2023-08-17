import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Graph {
        int x;
        int y;
        int sum;
        char prevOp;

        Graph(int a, int b, int c, char d) {
            x = a;
            y = b;
            sum = c;
            prevOp = d;
        }
    }

    static int n;
    static char[][] map;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        bfs(0, 0);
        System.out.println(max + " " + min);
    }


    static void bfs(int x, int y) {
        int[] op_X = {0, 1};
        int[] op_Y = {1, 0};
        Graph g;
        Queue<Graph> queue = new LinkedList<>();
        int temp_sum = 0, temp_op;
        int temp_x;
        int temp_y;
        int next_x;
        int next_y;

        queue.add(new Graph(x, y, map[x][y] - '0', ' '));

        while (!queue.isEmpty()) {
            g = queue.poll();
            temp_x = g.x;
            temp_y = g.y;

            if (temp_x == n - 1 && temp_y == n - 1) {
                max = Math.max(g.sum, max);
                min = Math.min(g.sum, min);
                continue;
            }
            for (int i = 0; i < 2; i++) {
                next_x = op_X[i] + temp_x;
                next_y = op_Y[i] + temp_y;

                if (next_x < n && next_y < n) {
                    if (map[next_x][next_y] == '+' || map[next_x][next_y] == '-' || map[next_x][next_y] == '*') {
                        queue.add(new Graph(next_x, next_y, g.sum, map[next_x][next_y]));
                    } else {
                        temp_op = map[next_x][next_y] - '0';
                        switch (g.prevOp) {
                            case '+':
                                temp_sum = g.sum + (temp_op);
                                break;
                            case '-':
                                temp_sum = g.sum - (temp_op);
                                break;
                            case '*':
                                temp_sum = g.sum * (temp_op);
                                break;
                        }
                        queue.add(new Graph(next_x, next_y, temp_sum, ' '));
                    }
                }
            }
        }
    }
}
