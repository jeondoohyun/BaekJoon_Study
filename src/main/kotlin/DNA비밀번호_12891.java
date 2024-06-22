import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

class DNA비밀번호_12891 {

    static int checkDna = 0;   // 필요 Dna 충족 갯수. 4되면 비밀번호 경우의수 result의 숫자를 하나 올리면 된다.
    static char[] dnaArray = null;
    static int[] nowDna = new int[4];  // 현재상태 배열
    static int[] needDnaArray = new int[4];   // 비밀번호 조건
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s_p = br.readLine().split(" ");
            int s = Integer.parseInt(s_p[0]);   // 임의로 만든 dna 문자열 길이
            int p = Integer.parseInt(s_p[1]);   // 비밀번호로 사용할 부분 문자열의 길이

            dnaArray = br.readLine().toCharArray();

            String[] needData = br.readLine().split(" ");   // ACGT순으로 받음


            int result = 0;     // 비밀번호 경우의수 카운트


            // todo : 첫 부분문자열을 비밀번호 조건 체크 해야됨
            for (int i = 0; i < dnaArray.length; i++) {
                if (dnaArray[i] == 'A') {
                    nowDna[0]++;
                } else if (dnaArray[i] == 'C') {
                    nowDna[1]++;
                } else if (dnaArray[i] == 'G') {
                    nowDna[2]++;
                } else if (dnaArray[i] == 'T') {
                    nowDna[3]++;
                }
            }


            for (int i = 0; i < needData.length; i++) {
                needDnaArray[i] = Integer.parseInt(needData[i]);   // 비밀번호 조건 배열 만들기
                if (needDnaArray[i] == 0) {
                    checkDna++;     // 필요 dna 숫자가 0이라면 해당 문자는 무조건 통과이기 때문에 +1 해준다.
                }
            }

            int moveCnt = s - p;
            for (int i = 0; i < moveCnt; i++) {
                int start = i;
                int end = start + p - 1;
                removeDna(dnaArray[start]);
                addDna(dnaArray[end]);
                if (checkDna == 4) result++;    // checkDna가 4라는거는 각자리 조건이 모두 만족했다는랙
            }

            bw.write(result+"");
            bw.flush();
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 한칸 이동되면서 왼쪽 dna가 빠지게 되므로 왼쪽 dna 제거
    static void removeDna(char s) {

        // 빼준다는건 부분문자열에 포함되어 있었다는뜻. 수량이 있었다는뜻.
        //-1 해주기전에 비밀번호 조건 갯수와 똑같았다면 이제 -1해주면 조건에 충족이 안된다는뜻이기 때문에 checkDna를 -- 해준다.
        if (s == 'A') {
            if (nowDna[0] == needDnaArray[0]) checkDna--;
            nowDna[0]--;
        } else if (s == 'C') {
            if (nowDna[1] == needDnaArray[1]) checkDna--;
            nowDna[1]--;
        } else if (s == 'G') {
            if (nowDna[2] == needDnaArray[2]) checkDna--;
            nowDna[2]--;
        } else if (s == 'T') {
            if (nowDna[3] == needDnaArray[3]) checkDna--;
            nowDna[3]--;
        }

    }

    // 한칸 이동되면서 오른쪽 dna가 추가되므로 오른쪽 dna 추가
    static void addDna(char s) {
        if (s == 'A') {
            nowDna[0]++;
            if (nowDna[0] == needDnaArray[0]) checkDna++;   // 현재 상태 배열값이 비밀번호 조건과 같아졌으면 ++ 해준다. 부등호 > 가 아닌 ==인 이유는 부등호는 비밀번호 조건보다 클때마다 ++ 되는 것을 막기위함. 각 자리수에서 조건이 충족하면 +1만 필요
        } else if (s == 'C') {
            nowDna[1]++;
            if (nowDna[1] == needDnaArray[1]) checkDna++;
        } else if (s == 'G') {
            nowDna[2]++;
            if (nowDna[2] == needDnaArray[2]) checkDna++;
        } else if (s == 'T') {
            nowDna[3]++;
            if (nowDna[3] == needDnaArray[3]) checkDna++;
        }
    }
}
