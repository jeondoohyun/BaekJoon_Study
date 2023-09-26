import java.util.ArrayList;
import java.util.Collections;

public class 카카오코테_뉴스클러스터링 {
    public static void main(String[] args) {

        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        ArrayList<String> str1_arr = new ArrayList<>();
        ArrayList<String> str2_arr = new ArrayList<>();

        ArrayList<String> retain = new ArrayList<>();   // 교집합
        ArrayList<String> addAll = new ArrayList<>();   // 합집합

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i=0 ; i<str1.length()-1 ; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            if (('a' <= a && a <= 'z') &&
                    ('a' <= b && b <= 'z')) {    // 문자열인지 확인
                String c = String.valueOf(a) + String.valueOf(b);
                str1_arr.add(c);
            }
        }
        retain.addAll(str1_arr);

        for (int i=0 ; i<str2.length()-1 ; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            if (('a' <= a && a <= 'z') &&
                    ('a' <= b && b <= 'z')) {
                String c = String.valueOf(a) + String.valueOf(b);
                str2_arr.add(c);
            }
        }
        retain.retainAll(str2_arr);   // 교집합 계산

        if (str1_arr.size() >= str2_arr.size()) addAll.addAll(str1_arr);
        else {
            addAll.addAll(str2_arr);
            str2_arr.removeAll(str2_arr);
            str2_arr.addAll(str1_arr);
        }
        for (int j=0 ; j < str2_arr.size() ; j++) {
            if (!addAll.contains(str2_arr.get(j))) {
                addAll.add(str2_arr.get(j));    // 합집합 추가
            }
        }

        if (retain.size() == 0) System.out.println(65536);
        else System.out.println((int)((double)retain.size() / (double)addAll.size() * 65536));
    }
}

class 카카오코테_뉴스클러스터링_다른사람풀이 {
    public int solution(String str1, String str2) {
        ArrayList<String> multiSet1 = new ArrayList<>();
        ArrayList<String> multiSet2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();    // 합집합
        ArrayList<String> intersection = new ArrayList<>(); // 교집합

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                multiSet1.add(first + "" + second);
            }
        }

        for(int i = 0 ; i < str2.length() - 1 ; ++i){
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                multiSet2.add(first + "" + second);
            }
        }

        Collections.sort(multiSet1);
        Collections.sort(multiSet2);

        for(String s : multiSet1){
            if(multiSet2.remove(s)){    // 지워진다는건 multiset2에 s를 가지고 있다는것. 지우는게 true면 교집합에 추가
                intersection.add(s);
            }
            union.add(s);   // 합집합은 2집합의 모든 원소를 가지고 있어야 함, s를 추가, multiset1 원소s만큼 추가 하고 아래에서 겹치지 않고 남은 multiset2의 원소를 다시 추가
        }

        for(String s : multiSet2){
            union.add(s);
        }

        double jakard = 0;

        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }
}