import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int N, a;
        int result = 0;
        int[] list;
        int comp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        comp = N;

        list = new int[N];

        for (int i = 0; i < N; ++i) {
            a = Integer.parseInt(br.readLine());
            list[i] = a;
        }

        for (int i = N - 1; i >= 0; --i) {
            if (list[i] == comp) {
                --comp;
            } else {
                ++result;
            }
        }

        System.out.println(result);
    }
}
