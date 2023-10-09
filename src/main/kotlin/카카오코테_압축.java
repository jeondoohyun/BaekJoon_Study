import java.util.*;

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

        // arraylist to array
        int [] answer = new int[answer_arr.size()];
        for (int i=0; i< answer_arr.size(); i++) {
            answer[i] = answer_arr.get(i);
        }

        // 배열 출력
        System.out.println(Arrays.toString(answer));
    }
}

class 압축_다른풀이 {
    static HashMap<String, Integer> dict = new HashMap<>();
    public static void main(String[] args) {
        String msg = "ABABC";

        int[] answer;
        ArrayList<Integer> ans = new ArrayList<>();

        int dictIdx = 1;
        for(int i='A'; i<='Z'; i++){
            dict.put( String.valueOf((char)i), dictIdx++) ;
        }

        int idx = 0;
        while(idx < msg.length()){
            String w = "";
            while(idx < msg.length()){
                if(!dict.containsKey(w+msg.charAt(idx))){   // dict에 없을때
                    break;
                }else{  // dict에 존재할때
                    w += msg.charAt(idx);
                }
                idx++;
            }

            ans.add(dict.get(w));
            if(idx < msg.length()){
                dict.put(w+msg.charAt(idx), dictIdx++);
            }
        }

        answer = new int[ans.size()];
        for(int i =0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }

    }
}

class 압축_나의다른풀이 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        HashMap<String, Integer> dic = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int dicIdx = 1;
        for (int i='A'; i<='Z'; i++) {
            dic.put(String.valueOf((char)i), dicIdx++); // HashMap을 사용할 경우 원소가 같은것이 있는지 확인하기 편하다(containsKey). HashMap을 구성할때 잘해야함.
        }

        int cnt = 0;
        while (cnt < msg.length()) {
            String w = "";

            while (cnt < msg.length()) {
                if (dic.containsKey(w+msg.charAt(cnt))) {   // msg의 원소와 같은원소가 있을경우
                    w += msg.charAt(cnt++);
                } else {    // 같은 원소가 없을경우
                    break;
                }
            }
            // w에 해당하는 dic value값을 ans에 추가
            ans.add(dic.get(w));
            if (cnt < msg.length()) dic.put(w+msg.charAt(cnt), dicIdx++);
        }

        int[] ans2 = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            ans2[i] = ans.get(i);
        }

        System.out.println(Arrays.toString(ans2));


    }
}

