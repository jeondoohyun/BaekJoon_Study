import java.util.*;

public class 카카오코테_프렌즈4블록 {
    static ArrayList<ArrayList<XYData>> coordinates = new ArrayList<>();
    static ArrayList<XYData> edit_coor = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) {

        int m = 6;  // 높이
        int n = 6;  // 폭
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};


        for (int j=0; j<m; j++) {
            coordinates.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                char a = board[j].toCharArray()[i];
                coordinates.get(j).add(new XYData(i, j, a, true));
            }
        }

        // 1. 2x2지워지는 알고리즘, 몇개의 블록이 지워지는지 구하는 알고리즘
        // 2. 지워진 블록 위치에 떨어지는 블록 구하기
        // 3. 다시 지워지는 알고리즘 갯수 더하기, 지워진 블록 갯수 총합 리턴

        while (deleteBlock()) {
            moveBlock();
        }

        System.out.println(result);


    }

    public static boolean deleteBlock() {
        // 2중 반복문 돌릴땐 j가 안쪽에서 반복되는데 이것이 x,y좌표로 칠때 y이다. 그래서 헷갈림. 안쪽 반복문에 x가 반영되도록 짜야됨.
        boolean isdel = false;
        for (int i=0; i<coordinates.size(); i++) {
            for (int j=0; j<coordinates.get(i).size(); j++) {
                if (i<coordinates.size()-1 && j<coordinates.get(i).size()-1) {  // indexOutofBound 방지
                    if (coordinates.get(i).get(j).data != '0' &&
                            coordinates.get(i).get(j).data == coordinates.get(i).get(j+1).data &&
                            coordinates.get(i).get(j).data == coordinates.get(i+1).get(j+1).data &&
                            coordinates.get(i).get(j).data == coordinates.get(i+1).get(j).data) {
                        if (coordinates.get(i).get(j).exist) {
                            result++;
                            coordinates.get(i).get(j).exist = false;
                            edit_coor.add(new XYData(j,i,'0',false));
                        }
                        if (coordinates.get(i).get(j+1).exist) {
                            result++;
                            coordinates.get(i).get(j+1).exist = false;
                            edit_coor.add(new XYData(j+1,i,'0',false));
                        }
                        if (coordinates.get(i+1).get(j+1).exist) {
                            result++;
                            coordinates.get(i+1).get(j+1).exist = false;
                            edit_coor.add(new XYData(j+1,i+1,'0',false));
                        }
                        if (coordinates.get(i+1).get(j).exist) {
                            result++;
                            coordinates.get(i+1).get(j).exist = false;
                            edit_coor.add(new XYData(j,i+1,'0',false));
                        }
                        isdel = true;
                    }
                }
            }
        }
        editBlock();
        return isdel;
    }

    public static void moveBlock() {
        for (int i=coordinates.size()-2; i>=0; i--) {  // 세로
            for (int j=0; j<coordinates.get(i).size(); j++) {  // 가로
                if (coordinates.get(i).get(j).exist &&
                    !coordinates.get(i+1).get(j).exist) {
                    // 반복문, 아래 블럭 exist가 true이면 탈출하도록
                    for (int k=i+1; k<coordinates.size(); k++) {
                        if (coordinates.get(k).get(j).exist) {
                            coordinates.get(k-1).get(j).exist = true;
                            coordinates.get(k-1).get(j).data = coordinates.get(i).get(j).data;
                            coordinates.get(i).get(j).exist = false;
                            coordinates.get(i).get(j).data = '0';
                            break;
                        } else if (k==coordinates.size()-1) {
                            coordinates.get(k).get(j).exist = true;
                            coordinates.get(k).get(j).data = coordinates.get(i).get(j).data;
                            coordinates.get(i).get(j).exist = false;
                            coordinates.get(i).get(j).data = '0';
                        }
                    }
                }
            }
        }
    }

    public static void editBlock() {
        for (XYData e: edit_coor) {
            coordinates.get(e.y).get(e.x).data = '0';
        }
        edit_coor.removeAll(edit_coor);
    }
}




class XYData {
    int x;
    int y;
    char data;
    boolean exist;

    XYData(int x, int y, char data, boolean exist) {
        this.x = x;
        this.y = y;
        this.data = data;
        this.exist = exist;
    }
}



// 다른 풀이

class Solution {
    static boolean v[][];   // 체크 배열

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // String 배열은 변경이 어려움. char 배열로 복사해서 사용
        char copy[][] = new char[m][n];
        for(int i=0; i<m ; i++){
            copy[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while(flag){
            v = new boolean[m][n];
            flag = false;
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(copy[i][j] == '#') continue; // #은 빈칸을 의미
                    if(check(i,j,copy)){    // 2*2 체크
                        v[i][j] = true;
                        v[i][j+1] = true;
                        v[i+1][j] = true;
                        v[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            answer += erase(m,n,copy);
            v = new boolean[m][n];
        }
        return answer;
    }

    /* 2*2가 같은지 체크 */
    public static boolean check(int x, int y, char[][] board){
        char ch = board[x][y];
        if(ch == board[x][y+1] && ch== board[x+1][y] && ch == board[x+1][y+1]){
            return true;
        }
        return false;
    }

    /* 같은 블록 제거 */
    public static int erase(int m, int n, char[][] board){
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(v[i][j])
                    board[i][j] = '.';
            }
        }

        /* 큐를 이용해 세로로 제거 작업 진행 */
        for(int i=0; i<n; i++){
            Queue<Character> q = new LinkedList<>();
            for(int j=m-1; j>=0; j--){  // y좌표 아래부터 위로 반복
                if(board[j][i] == '.'){
                    cnt++;  // 지우는 블록 카운트, true로 표시한거를 지움.
                }else{
                    q.add(board[j][i]);         // y좌표 아래부터 데이터 값이 .이 아니라면 순서대로 큐에 집어넣는다. 그렇게 한후 y좌표 아래부터 poll을 해서 하나씩 채우면 빈칸이 당겨져있음
                }
            }
            int idx=m-1;
            // 삭제한 블록 위의 블록들 내리기
            while(!q.isEmpty()){
                board[idx--][i] = q.poll();     // 붙여서 채우면 결과적으론 하나씩 채워놓는것.
            }
            // 빈칸 채우기
            for(int j=idx; j>=0; j--){
                board[j][i] = '#';
            }
        }

        return cnt;
    }
}

// 내가 다시 풀어본 문제
class 내가다시 {
    public static void main(String[] args) {
        
    }
}
