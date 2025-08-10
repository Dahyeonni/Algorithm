import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 4, t = 0;

        while (t++ < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 첫번째 직사각형
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            // 두번째 직사각형
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            // 공통 부분 없음 d
            if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                System.out.println("d");
            }
            // 점 c
            else if ((x1 == p2 && y1 == q2) ||
                     (x1 == p2 && q1 == y2) ||
                     (p1 == x2 && q1 == y2) ||
                     (p1 == x2 && y1 == q2)) {
                System.out.println("c");
            }
            // 선분 b
            else if (p1 == x2 || x1 == p2 || q1 == y2 || y1 == q2) {
                System.out.println("b");
            }
            // 직사각형 a
            else {
                System.out.println("a");
            }
        }
    }
}