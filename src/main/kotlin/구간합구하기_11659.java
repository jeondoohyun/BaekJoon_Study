import com.ibm.jvm.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class 구간합구하기_11659 {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            String[] numbers = br.readLine().split(" ");
            int[] addNum = new int[N];

            for (int i=0 ; i<N ; i++) {
                if (i==0) addNum[0] = Integer.parseInt(numbers[0]);
                else addNum[i] = addNum[i-1] + Integer.parseInt(numbers[i]);
            }

            int cnt = 0;
            StringBuffer sb = new StringBuffer();
            while (cnt < M) {
                String[] s1 = br.readLine().split(" ");
                int i = Integer.parseInt(s1[0]) - 1;    // 인덱스는 0부터 시작하므로 인덱스에 맞추기 위해 -1
                int j = Integer.parseInt(s1[1]) - 1;
                if (i == 0) sb.append( addNum[j] + "\n");
                else sb.append((addNum[j] - addNum[i - 1])+"\n");
                cnt++;
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
