import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int N, M;
        int op1;
        int sum;
        int prevLeft;
        boolean isComplete = false;
        int left, right, mid;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        prevLeft = 1;
        for (int i = 0; i < N; ++i) {
            op1 = list.get(i);

            if (prevLeft >= N) {
                break;
            }

            left = prevLeft;
            right = N - 1;
            while (left <= right) {
                mid = (left + right) / 2;
                sum = list.get(mid) - op1;
                if (sum < M) {
                    left = mid + 1;
                    prevLeft = left;
                } else if (sum == M) {
                    min = sum;
                    isComplete = true;
                    break;
                } else {
                    right = mid - 1;
                    min = Math.min(sum, min);
                }
            }
            if (isComplete)
                break;
        }

        System.out.println(min);
    }
}
