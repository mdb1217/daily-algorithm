import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String s;
        int sum = 0;
        boolean isMinusExist = false;
        StringBuilder temp = new StringBuilder();
        char c;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        for (int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            if (c == '+') {
                if (isMinusExist) {
                    sum -= Integer.parseInt(temp.toString());
                } else {
                    sum += Integer.parseInt(temp.toString());
                }
                temp.setLength(0);
            } else if (c == '-') {
                if (isMinusExist) {
                    sum -= Integer.parseInt(temp.toString());
                } else {
                    sum += Integer.parseInt(temp.toString());
                }
                isMinusExist = true;
                temp.setLength(0);
            } else {
                temp.append(c);
            }
        }
        if (isMinusExist) {
            sum -= Integer.parseInt(temp.toString());
        } else {
            sum += Integer.parseInt(temp.toString());
        }

        System.out.println(sum);
    }
}
