import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class 평균구하기_1546 {      // 백준 제출할때는 class Main으로 변경하여 제출 해야함

    public static void main(String[] args) {

        try {

            // Scanner 사용
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 과목수

//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            int N = Integer.parseInt(br.readLine());

            int A[] = new int[N];   // 과목수길이 배열 생성

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            long sum = 0;
            long max = 0;

            for (int i = 0; i < N; i++) {
                if (A[i]>max) max = A[i];
                sum += A[i];
            }

            System.out.println(sum*100.0/max/N);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
