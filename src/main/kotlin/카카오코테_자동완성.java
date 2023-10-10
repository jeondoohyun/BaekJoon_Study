import java.util.*;

public class 카카오코테_자동완성 {
    // trie 트라이 알고리즘(재귀함수 사용)인데 무식하게 풀었다. trie알고리즘으로 다시 풀어보자
    // tree와 비슷함
    public static void main(String[] args) {
        String[] words = { "abc","def","ghi","jklm" };

        int answer = 0;
        for (int i=0; i<words.length; i++) {    // 검사하는 문자갯수 만큼
            String word = words[i];
            int cnt = 0;
            String a = "";
            Loop1 :
            while (cnt < word.length()) {   // 검사하는 문자의 char를 하나씩 늘려가면서 검사
                a += String.valueOf(word.charAt(cnt));    // char to String
                if (a.length() == word.length()) {
                    answer += a.length();
                    break;
                }
                // 내꺼 빼고 검사를 어케 하지?
                for (int j=0; j<words.length; j++) {
                    if (i!=j && words[j].contains(a)) {
                        break;
                    }
                    // 겹치는게 하나도 없는것을 어케 알지? 간단한 방법은 없나?
                    if (j == words.length-1) {
                        answer += a.length();
                        break Loop1;
                    }
                }
                cnt++;
            }
        }

        System.out.println(answer);

    }
}

class 자동완성_trie {

    public static void main(String[] args) {

        String[] words = { "go","gone","guild" };

        int answer = 0;
        answer = solve(words);

    }

    public static class Node {
        HashMap<Character, Node> child = new HashMap(); // HashMap()으로 Node를 계속 이어줘서 가지 모양을 이어준다.
        boolean isEnd = false;
        int branchSum = 0;
    }

    public static class Trie {

        Node root;

        public Trie(){
            root = new Node();
        }   // 객체생성 한 Trie의 root는 계속 똑같다. Trie a = new Trie() a의 root는 같은 Node()

        public void insert(String word){    // node 만들기

            Node current = root;

            for(Character c : word.toCharArray()){
                if(current.child.get(c) == null){
                    Node node = new Node(); // 새로운 child를 이어 주기 위해 Node()새로 생성하여 put으로 넣어준다.
                    current.child.put(c, node); // 어쨋든 첫 current는 root이기때문에 root안에 새로운 node를 심어주는것.
                    current = node; // 새로 생성한 Node()를 current로 넣어줘 current를 바꿔준다. 이 Node의 마지막에 isEnd를 true처리.
                }
                else
                    current = current.child.get(c);     // go에서 gone을 추가 할때는 go까지는 current.child.get(c) != null 이기 때문에 기존에 있는 Node를 사용.
            }
            current.isEnd = true;
        }
    }

    public static int makeBranchSum(Node now){

        if(now.isEnd && now.child.isEmpty())
            return now.branchSum = 1;

        for(Node node : now.child.values())
            now.branchSum += makeBranchSum(node);

        if(now.isEnd && !now.child.isEmpty())
            now.branchSum += 1;
        return now.branchSum;
    }

    public static int search(Node now, int cnt){

        int ret = 0;

        if(now.branchSum == 1)
            return cnt;

        for(Node node : now.child.values())
            ret += search(node, cnt + 1);
        if(now.isEnd)
            ret += cnt;

        return ret;
    }

    public static int solve(String[] words){

        Trie trie = new Trie();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            trie.insert(word);
        }
        makeBranchSum(trie.root);
        return search(trie.root, 0);
    }
}
