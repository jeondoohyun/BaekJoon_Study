import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택으로수열만들기_1874 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 만들어야할 수열의 길이
            int n = Integer.parseInt(br.readLine());

            // 스택으로 만들어야할 수열
            int[] goalArray = new int[n];

            // 수열길이 n 만큼 반복하여 수열 데이터 받기
            for (int i = 0; i < n; i++) {
                goalArray[i] = Integer.parseInt(br.readLine());
            }

            // 스택 객체 생성
            Stack<Integer> stack = new Stack<>();

            // 오름차순으로 스택에 넣을 자연수
            int num = 1;

            // +, - 를 넣을 stringBuffer
            StringBuffer sb = new StringBuffer();

            boolean success = true;
            for (int i = 0; i < goalArray.length; i++) {
                int su = goalArray[i];

                if (num <= su) {
                    while (num <= su) {   // 값이 같을때까지 넣어줘야함. 같은값을 넣고 빼서 수열을 만들어야 하기 때문
                        // 해당 수열값이 될때까지 스택에 자연수를 오름차순으로 push
                        stack.push(num++);  // 스택에 값을 넣은후에 +1
                        sb.append("+\n");   // push 할때는 + 출력
                    }
                    stack.pop();
                    sb.append("-\n");   // pop 할때는 - 출력
                } else {    // 자연수보다 num보다 수열이 작다. 현재자연수 보다 작은 자연수는 이미 스택에 들어가 있기 때문에 작은수는 스택에서 뺀다음에 수열과 같은지 확인
                    int pop = stack.pop();
                    sb.append("-\n");
                    if (pop != su) {
                        success = false;
                        bw.write("NO");
                        break;
                    }
                }
            }

            if (success) bw.write(sb.toString());   // success true면 수열을 만들었다는 뜻이니까 결과값 출력하면됨
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
