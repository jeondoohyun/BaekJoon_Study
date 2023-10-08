import java.util.ArrayList;
import java.util.Arrays;

public class 카카오코테_압축 {
    public static void main(String[] args) {

        // 압축 알고리즘 종류는?


        String msg = "TOBEORNOTTOBEORTOBEORNOT";
//        String msg = "KAKAO";

        ArrayList<Integer> answer_arr = new ArrayList<>();
        ArrayList<String> dictionary = new ArrayList<>();

        // 아스키코드 65:A, 90:Z, index:25(Z)
        for (int i=65; i<=90; i++) {
            char a = (char) i;
            dictionary.add(Character.toString(a));
        }

        // 1. 가장 앞의 char가 dictionary에 있으면 바로 뒤의 char까지 함께 문자가 dictionary에 있는지 확인. 없으면 가장 앞에 있는 char에 해당하는 index+1을 answer에 추가하고 dictionary에 2개를 합친 문자를 추가
        // 2. 2개를 붙인 문자가 있으면 그다음 char도 붙여 3개를 붙인 문자가 있는지를 확인.
        int leng = 1;
        int result = 0;
        int pl = 0;
        for (int i=0; i<msg.length(); i++) {
            pl = 0;
            leng = i+1;
            result = 0;
            String a = msg.substring(i,leng);
            for (int j=0; j<dictionary.size(); j++) {
                String b = dictionary.get(j);
                if (a.equals(b)) {
                    if (a.length()>=2) pl++;
                    leng++;
                    if (leng > msg.length()) leng = msg.length();
                    a = msg.substring(i,leng);
                    result = j+1;
                }
            }
            i += pl;    // 문자를 합처서 검사하였기 때문에 다음 i 인덱스는 넘어간다.
            answer_arr.add(result);
            dictionary.add(a);
        }

        int [] answer = new int[answer_arr.size()];
        for (int i=0; i< answer_arr.size(); i++) {
            answer[i] = answer_arr.get(i);
        }

        // 배열 출력
        System.out.println(Arrays.toString(answer));
    }
}
