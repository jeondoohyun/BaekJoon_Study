import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 연속된자연수의합_투포인터_2018 {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            int count = 1;
            int start_index = 1;
            int end_index = 1;
            int sum = 1;

            while (end_index != N) {    // end_index가 N이 되는 순간 while 반복문이 끝나서 자기 자신인 숫자일때의 count++를 할수 없으니 count에 미리 1을 넣어줬음
                if (sum == N) {
                    count++;
                    end_index++;
                    sum = sum + end_index;
                } else if (sum > N) {
                    sum = sum - start_index;    // sum이 N 값을 넘어 버렸으니까 왼쪽 인덱스를 오른쪽으로 한칸 옮기면서 start_index값을 빼준다
                    start_index++;
                } else if (sum < N) {
                    end_index++;
                    sum = sum + end_index;
                }
            }

            bw.write(count+"");
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
