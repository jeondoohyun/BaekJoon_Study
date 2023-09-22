import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 카카오코테_다트게임 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayNum = new ArrayList<>();
        try {
            int answer = 0;

            String dartResult = "1D2S#10S";

            int i = 0;
            int cnt = 0;
            while (i < dartResult.length()) {
                if (Character.isDigit(dartResult.charAt(i))) {
                    cnt++;
                    if (Character.isDigit(dartResult.charAt(i+1))) {
                        arrayNum.add(Integer.parseInt("10"));
                        i+=2;
                        continue;
                    }
                    arrayNum.add(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
                    i++;
                    continue;
                }

                if (dartResult.charAt(i) == 'S') {
                    i++;
                    continue;
                }
                if (dartResult.charAt(i) == 'D') {
                    int a = (int) Math.pow(arrayNum.get(cnt-1), 2);
                    arrayNum.set(cnt-1, a);
                    i++;
                    continue;
                }
                if (dartResult.charAt(i) == 'T') {
                    int a = (int) Math.pow(arrayNum.get(cnt-1), 3);
                    arrayNum.set(cnt-1, a);
                    i++;
                    continue;
                }
                if (dartResult.charAt(i) == '*') {
                    i++;
                    if (cnt > 1) {
                        int a = arrayNum.get(cnt-2) * 2;
                        arrayNum.set(cnt-2, a);
                    }
                    int a = arrayNum.get(cnt-1) * 2;
                    arrayNum.set(cnt-1, a);
                    continue;
                }
                if (dartResult.charAt(i) == '#') {
                    i++;
                    int a = arrayNum.get(cnt-1) * -1;
                    arrayNum.set(cnt-1, a);
                }
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(arrayNum.get(0) + arrayNum.get(1) + arrayNum.get(2) +"");
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            return arrayNum.get(0) + arrayNum.get(1) + arrayNum.get(2);
        }

    }
}
