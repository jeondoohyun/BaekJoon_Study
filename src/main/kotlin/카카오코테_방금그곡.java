import java.util.*;

public class 카카오코테_방금그곡 {
    public static void main(String[] args) {

        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//        int size = musicinfos.length/4;
        ArrayList<Infos> infos = new ArrayList<>();

        // 반복문을 다 돌려서 파싱후 다시 반복문을 돌려서 비효율적
        for (int i=0; i< musicinfos.length; i++) {
            int[] time = new int[2];
            String title = "";
            String melody = "";
            int cnt = 0;
            String[] music = musicinfos[i].split(",");
            for (int j=0; j<4; j++) {
                if (cnt==0 || cnt==1) {
                    String[] a = music[cnt].split(":");
                    time[cnt] = Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
                } else if (cnt==2) {
                    title = music[j];
                } else {
                    melody = music[j];
                }
                cnt++;
            }
            int a = time[1] - time[0];
            infos.add(new Infos(a, title, melody));
        }

//        for (Infos e: infos) {
//            System.out.println(e.time+", "+e.title+", "+e.melody);
//        }


        String _m = m;
        for (Infos e : infos) {
//            for ()
        }


    }


}

class Infos {
    int time = 0;
    String title = "";
    String melody = "";

    Infos(int time, String title, String melody) {
        this.time = time;
        this.title = title;
        this.melody = melody;
    }
}

class 다른풀이 {
    static HashMap<String, String> dict = new HashMap<>();  // 치환할 문자열 저장
    public static void main(String[] args) {
        String answer = "(None)";

        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        dict.put("C#", "c"); dict.put("D#", "d"); dict.put("F#", "f");
        dict.put("G#", "g"); dict.put("A#", "a");
//        m = change(m);

        int maxTime = 0;
        for(int i=0; i<musicinfos.length; i++){
            String[] temp = musicinfos[i].split(",");
            int time = getTime(temp[0], temp[1]);
//            String music = change(temp[3]);
            String music = temp[3];

            /* 재생시간만큼 music 반복 */
            while(music.length()<time){
                music += music;
            }
            music = music.substring(0,time);

            /* 조건 일치 여부 확인 */
            if(music.contains(m)){
                if(maxTime < time){ // 재생 시간이 가장 긴 것을 정답으로
                    maxTime = time;
                    answer = temp[2];
                }
            }

        }


//        return answer;
    }

    /* #이 붙은 문자열 치환 */
    static String change(String str){
        for(String key : dict.keySet()){
            str = str.replace(key, dict.get(key));
        }
        return str;
    }

    /* 재생시간 구하기 */
    static int getTime(String str1, String str2){
        String[] time1 = str1.split(":");
        String[] time2 = str2.split(":");

        int h1 = Integer.parseInt(time1[0])*60;
        int h2 = Integer.parseInt(time2[0])*60;

        int m1 = Integer.parseInt(time1[1]);
        int m2 = Integer.parseInt(time2[1]);

        return (h2+m2)-(h1+m1);

    }
}

class 나의다른풀이 {

    public static void main(String[] args) {

        String result = "";
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        int maxTime = 0;
        for (int i=0 ; i< musicinfos.length ; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            int playingTime = getTime(musicinfo[0], musicinfo[1]);
            String music = musicinfo[3];

            while (music.length() < playingTime) {  // 음 하나당 1분 재생되기 때문에 플레이시간보다 음이 적다면 추가해주고 시간만큼만 있도록 자른다.
                music += music;
            }
            music.substring(0, playingTime);



            // 방송국 음악정보를 시간에 맞게 완성해주고 내가 알고 있는 음이 포함되어 있는지 확인
            // 1. 음이 같은 노래가 중복된다면 플레이시간이 가장긴 시간을 반환한다.
            // 2. 음시간도 같다면 먼저 입력된 값을 출력 한다.
            if (music.contains(m)) {
                if (maxTime < playingTime) {
                    maxTime = playingTime;
                    result = musicinfo[2];
                }
            }
        }
    }


    static public int getTime(String str1, String str2) {
        String[] t1 = str1.split(":");
        String[] t2 = str2.split(":");

        int h1 = Integer.parseInt(t1[0])*60;
        int h2 = Integer.parseInt(t2[0])*60;

        int m1 = Integer.parseInt(t1[1]);
        int m2 = Integer.parseInt(t2[1]);

        int result = (h2+m2) - (h1+m1);

        return result;
    }
}


